package net.mango.tunieland.blocks.Jungles_Leaves;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.util.Identifier;
import net.mango.tunieland.item.ModItems;

public class ModLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Check if this is the loot table for jungle leaves
            if (id.equals(new Identifier("minecraft", "blocks/jungle_leaves"))) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.MANGO)
                                .conditionally(RandomChanceLootCondition.builder(0.015f))); // 1.5% chance

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
