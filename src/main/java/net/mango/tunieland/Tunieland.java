package net.mango.tunieland;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tunieland implements ModInitializer {
	public static final String MOD_ID = "tunieland";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Tunieland mod initializing...");
		// Register entities, items, etc.
	}
}