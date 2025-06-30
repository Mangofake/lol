package net.mango.tunieland.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;   // <— no “.v1”
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;

public class ModItemGroups {
    public static final ItemGroup TUNIELAND_GROUP =
            FabricItemGroupBuilder
                    .create(new Identifier(Tunieland.MOD_ID, "tunieland"))
                    .icon(() -> new ItemStack(ModItems.SOME_ITEM))
                    .build();
}