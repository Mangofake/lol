package net.mango.tunieland;

import net.fabricmc.api.ModInitializer;

public class Tunieland implements ModInitializer {
	@Override
	public void onInitialize() {
		ModItems.register();        // make these static register methods
		ModItemGroups.register();
		ModEntitySpawning.register();
	}
}
