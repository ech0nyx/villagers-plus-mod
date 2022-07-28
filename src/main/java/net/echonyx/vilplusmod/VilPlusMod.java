package net.echonyx.vilplusmod;

import net.echonyx.vilplusmod.item.ModItems;
import net.echonyx.vilplusmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VilPlusMod implements ModInitializer {
	public static final String MOD_ID = "vilplusmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModVillagers.registerVillagers();
	}
}
