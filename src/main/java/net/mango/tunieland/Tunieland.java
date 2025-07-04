package net.mango.tunieland;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.mango.tunieland.item.ModItems;
import net.mango.tunieland.item.ModItemGroups;
import net.mango.tunieland.entity.ModEntitySpawning;
import net.mango.tunieland.entity.ModEntityAttributes;

public class Tunieland implements ModInitializer {
	public static final String MOD_ID = "tunieland";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Tunieland mod");

		ModItems.register();
		ModItemGroups.TUNIELAND_GROUP.toString(); // Ensures it's initialized
		ModEntitySpawning.register();
		ModEntityAttributes.register();
	}
}
