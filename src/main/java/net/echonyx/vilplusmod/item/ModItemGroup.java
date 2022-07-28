package net.echonyx.vilplusmod.item;

import net.echonyx.vilplusmod.VilPlusMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup VILPLUSMOD = FabricItemGroupBuilder.build(
            new Identifier(VilPlusMod.MOD_ID, "vilplusmod"), () -> new ItemStack(ModItems.TANZANITE));
}
