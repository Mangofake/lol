package net.mango.tunieland.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.mango.tunieland.Tunieland;

public class ModItemGroups {

    public static final ItemGroup TUNIELAND_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Tunieland.MOD_ID, "tunieland"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("Tunieland"))
                    .icon(() -> new ItemStack(ModItems.PINKY_DRINK))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINKY_DRINK);
                        entries.add(ModItems.SANGRE_DE_MOSQUITO);
                        entries.add(ModItems.JOCOQUE);
                        entries.add(ModItems.MONSTER_DRINK_MANGO);
                        entries.add(ModItems.MONSTER_DRINK_PUNCH);
                        entries.add(ModItems.MONSTER_DRINK_ULTRA);
                        entries.add(ModItems.MONSTER_DRINK);
                        entries.add(ModItems.MANGO);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        Tunieland.LOGGER.info("Registering Item Groups for " + Tunieland.MOD_ID);
    }
}
