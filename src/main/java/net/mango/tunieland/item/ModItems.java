package net.mango.tunieland.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;


public class ModItems {


    public static final Item JOCOQUE = registerItem("jocoque",
            new JocoqueItem(new FabricItemSettings()));

    public static final Item SANGRE_DE_MOSQUITO = registerItem("sangre_de_mosquito",
            new Item(new FabricItemSettings()));

    public static final Item PINKY_DRINK = registerItem("pinky_drink",
            new PinkyDrinkItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tunieland.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Tunieland.LOGGER.info("Registering ModItems for " + Tunieland.MOD_ID);
    }
}
