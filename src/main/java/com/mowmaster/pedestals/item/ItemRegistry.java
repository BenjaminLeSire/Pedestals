package com.mowmaster.pedestals.item;


import com.mowmaster.pedestals.blocks.*;
import com.mowmaster.pedestals.item.pedestalUpgrades.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;

public class ItemRegistry
{
    public static void onItemRegistryReady(RegistryEvent.Register<Item> e)
    {
        BlockPedestalTE.onItemRegistryReady(e);

        ItemColorPallet.onItemRegistryReady(e);
        ItemLinkingTool.onItemRegistryReady(e);
        ItemUpgradeDropper.onItemRegistryReady(e);
        ItemUpgradeImport.onItemRegistryReady(e);
        ItemUpgradeBreaker.onItemRegistryReady(e);
        ItemUpgradeChopper.onItemRegistryReady(e);
        ItemUpgradeCobbleGen.onItemRegistryReady(e);
        ItemUpgradeCrafter.onItemRegistryReady(e);
        ItemCraftingPlaceholder.onItemRegistryReady(e);
        ItemUpgradeCrusher.onItemRegistryReady(e);
        ItemUpgradeEffectGrower.onItemRegistryReady(e);
        ItemUpgradeEffectHarvester.onItemRegistryReady(e);
        ItemUpgradeEffectPlanter.onItemRegistryReady(e);
        ItemUpgradeEffectMagnet.onItemRegistryReady(e);
        ItemUpgradeExpCollector.onItemRegistryReady(e);
        ItemUpgradeExpRelay.onItemRegistryReady(e);
        ItemUpgradeExpTank.onItemRegistryReady(e);
        ItemUpgradeExpBottler.onItemRegistryReady(e);
        ItemUpgradeExpDropper.onItemRegistryReady(e);
        ItemUpgradeExpEnchanter.onItemRegistryReady(e);
        ItemUpgradeExpAnvil.onItemRegistryReady(e);
        ItemUpgradeExport.onItemRegistryReady(e);
        ItemUpgradeRestock.onItemRegistryReady(e);
        ItemUpgradeFilterEnchanted.onItemRegistryReady(e);
        ItemUpgradeFilterEnchantedBlacklist.onItemRegistryReady(e);
        ItemUpgradeFilterItem.onItemRegistryReady(e);
        ItemUpgradeFilterItemBlacklist.onItemRegistryReady(e);
        ItemUpgradeFilterItemStack.onItemRegistryReady(e);
        ItemUpgradeFilterItemStackBlacklist.onItemRegistryReady(e);
        ItemUpgradeFilterMod.onItemRegistryReady(e);
        ItemUpgradeFilterModBlacklist.onItemRegistryReady(e);
        ItemUpgradeFurnace.onItemRegistryReady(e);
        ItemUpgradeMilker.onItemRegistryReady(e);
        ItemUpgradeShearer.onItemRegistryReady(e);
        ItemUpgradePlacer.onItemRegistryReady(e);
    }

    public static void onItemColorsReady(ColorHandlerEvent.Item event)
    {
        BlockPedestalTE.handleItemColors(event);
        ItemColorPallet.handleItemColors(event);
    }
}
