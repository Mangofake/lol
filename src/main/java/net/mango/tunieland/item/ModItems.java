package net.mango.tunieland.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;
import net.minecraft.item.FoodComponent;


public class ModItems {


    public static final Item JOCOQUE = registerItem("jocoque",
            new JocoqueItem(new FabricItemSettings().food(
                    new FoodComponent.Builder()
                            .hunger(2)             // optional hunger
                            .saturationModifier(0.3f) // optional saturation
                            .alwaysEdible()        // allows eating even at full hunger
                            .build()
            )));

    public static final Item SANGRE_DE_MOSQUITO = registerItem("sangre_de_mosquito",
            new Item(new FabricItemSettings()));

    public static final Item PINKY_DRINK = registerItem("pinky_drink",
            new PinkyDrinkItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tunieland.MOD_ID, name), item);
    }

    public static final Item MONSTER_DRINK_MANGO = registerItem("monster_mango",
            new MonsterDrinkItem(new FabricItemSettings().food(new FoodComponent.Builder()
                    .hunger(1)
                    .saturationModifier(0.5f)
                    .alwaysEdible()
                    .build())));
    public static final Item MONSTER_DRINK_PUNCH = registerItem("monster_punch",
            new MonsterDrinkItem(new FabricItemSettings()));
    public static final Item MONSTER_DRINK = registerItem("monster",
            new MonsterDrinkItem(new FabricItemSettings()));
    public static final Item MONSTER_DRINK_ULTRA = registerItem("monster_ultra",
            new MonsterDrinkItem(new FabricItemSettings()));


    public static void registerModItems() {
        Tunieland.LOGGER.info("Registering ModItems for " + Tunieland.MOD_ID);
    }
}
