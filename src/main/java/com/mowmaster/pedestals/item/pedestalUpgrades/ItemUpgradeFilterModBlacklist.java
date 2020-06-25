package com.mowmaster.pedestals.item.pedestalUpgrades;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.stream.IntStream;

import static com.mowmaster.pedestals.pedestals.PEDESTALS_TAB;
import static com.mowmaster.pedestals.references.Reference.MODID;

public class ItemUpgradeFilterModBlacklist extends ItemUpgradeBaseFilter
{
    public ItemUpgradeFilterModBlacklist(Item.Properties builder) {super(builder.group(PEDESTALS_TAB));}

    public void updateAction(int tick, World world, ItemStack itemInPedestal, ItemStack coinInPedestal, BlockPos pedestalPos)
    {

    }

    @Override
    public boolean canAcceptItem(World world, BlockPos posPedestal, ItemStack itemStackIn)
    {
        boolean returner = true;
        BlockPos posInventory = getPosOfBlockBelow(world, posPedestal, 1);

        if(world.getTileEntity(posInventory) !=null)
        {
            if(world.getTileEntity(posInventory).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, getPedestalFacing(world, posPedestal)).isPresent())
            {
                IItemHandler handler = (IItemHandler) world.getTileEntity(posInventory).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, getPedestalFacing(world, posPedestal)).orElse(null);
                if(handler != null)
                {
                    int range = handler.getSlots();
                    for(int i=0;i<range;i++)
                    {
                        ItemStack stackInSlot = handler.getStackInSlot(i);
                        //find a slot with items
                        ItemStack itemFromInv = ItemStack.EMPTY;

                        itemFromInv = IntStream.range(0,range)//Int Range
                                .mapToObj((handler)::getStackInSlot)//Function being applied to each interval
                                .filter(itemStack -> itemStack.getItem().getRegistryName().getNamespace()==itemStackIn.getItem().getRegistryName().getNamespace())
                                .findFirst().orElse(ItemStack.EMPTY);
                        System.out.println(itemFromInv.getDisplayName());

                        if(!itemFromInv.isEmpty())
                        {
                            returner = false;
                        }
                    }
                }
            }
        }

        return returner;
    }

    public void upgradeAction(World world, BlockPos posOfPedestal, ItemStack coinInPedestal)
    {

    }

    public static final Item MOD = new ItemUpgradeFilterModBlacklist(new Item.Properties().maxStackSize(64).group(PEDESTALS_TAB)).setRegistryName(new ResourceLocation(MODID, "coin/filtermodb"));

    @SubscribeEvent
    public static void onItemRegistryReady(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(MOD);
    }



}
