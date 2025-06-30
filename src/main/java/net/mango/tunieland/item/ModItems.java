package net.mango.tunieland.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;

public class ModItems {
    public static final Item SOME_ITEM = register("some_item",
            new Item(new FabricItemSettings().group(ModItemGroups.TUNIELAND_GROUP))
    );

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM,
                new Identifier(Tunieland.MOD_ID, name),
                item
        );
    }

    public static void register() {
        // nothing to do – class loading already registers
    }
}
