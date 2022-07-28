package net.echonyx.vilplusmod.villager;

import com.google.common.collect.ImmutableSet;
import net.echonyx.vilplusmod.VilPlusMod;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType LODESTONE_POI = registerPOI("lodestone_poi", Blocks.LODESTONE);
    public static final VillagerProfession NETHER_TRAVELER = registerProfession("nethertraveler",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(VilPlusMod.MOD_ID, "lodestone_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(VilPlusMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(VilPlusMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ITEM_LODESTONE_COMPASS_LOCK).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(VilPlusMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        VilPlusMod.LOGGER.debug("Registering Villagers for" + VilPlusMod.MOD_ID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(NETHER_TRAVELER, 1,
            factories -> {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.PAPER, 24),
                        new ItemStack(Items.EMERALD, 1),
                        16, 2, 0.05f
                )));
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 7),
                        new ItemStack(Items.MAP, 1),
                        16, 2, 0.05f
                )));
        });
        TradeOfferHelper.registerVillagerOffers(NETHER_TRAVELER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GLASS_PANE, 11),
                            new ItemStack(Items.EMERALD, 1),
                            16, 10, 0.05f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 13),
                            new ItemStack(Items.COMPASS, 1),
                            new ItemStack(Items.FILLED_MAP, 1),
                            16, 2, 0.2f
                    )));
                });
    }
}
