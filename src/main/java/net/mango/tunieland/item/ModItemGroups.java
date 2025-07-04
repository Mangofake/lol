package net.mango.tunieland.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;
import net.minecraft.item.Items;

public class ModItemGroups {
    public static final ItemGroup TUNIELAND_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Tunieland.MOD_ID, "tunieland"),
            ItemGroup.create(
                            ItemGroup.Row.TOP,
                            0
                    )
                    .displayName(Text.translatable("itemgroup.tunieland"))
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SANGRE_DE_MOSQUITO);
                        entries.add(ModItems.PINKY_DRINK);
                    })
                    .build()
    );
}
