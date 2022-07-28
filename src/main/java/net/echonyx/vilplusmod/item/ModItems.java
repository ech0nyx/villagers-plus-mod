package net.echonyx.vilplusmod.item;

import net.echonyx.vilplusmod.VilPlusMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.VILPLUSMOD)));

    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.VILPLUSMOD)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VilPlusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VilPlusMod.LOGGER.debug("Registering Mod Items for" + VilPlusMod.MOD_ID);
    }
}
