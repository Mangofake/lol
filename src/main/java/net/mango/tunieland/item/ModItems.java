package net.mango.tunieland.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;

public class ModItems {
    public static final Item SOME_ITEM =
            register("some_item", new Item(new FabricItemSettings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(Tunieland.MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        Tunieland.LOGGER.info("Registering mod items for " + Tunieland.MOD_ID);
    }
}
