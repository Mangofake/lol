package net.mango.tunieland.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;

public class ModItems {
    public static final Item SANGRE_DE_MOSQUITO = register("sangre_de_mosquito",
            new Item(new FabricItemSettings())
    );

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(Tunieland.MOD_ID, name),
                item
        );
    }

    public static final Item PINKY_DRINK = register("pinky_drink",
            new PinkyDrinkItem(new FabricItemSettings()
                    .maxCount(16)
                    .food(new FoodComponent.Builder()
                            .hunger(2)                        // 🍖 restores 2 hunger points
                            .saturationModifier(0.3f)         // optional: how long the food lasts
                            .alwaysEdible()
                            .build()))
    );

    public static void register() {
        // No-op for now
    }
}
