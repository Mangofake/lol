package net.mango.tunieland;

import net.fabricmc.api.ModInitializer;
import net.mango.tunieland.entity.ModEntities;
import net.mango.tunieland.entity.ModEntityAttributes;
import net.mango.tunieland.entity.ModEntitySpawning;
import net.mango.tunieland.item.ModItemGroups;
import net.mango.tunieland.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tunieland implements ModInitializer {
	public static final String MOD_ID = "tunieland";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModEntities.register();
		ModEntityAttributes.register();
		ModEntitySpawning.register(); // ← ✅ ADD THIS LINE
	}
}