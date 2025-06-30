package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.entity.SpawnGroup;

import net.minecraft.registry.BuiltinRegistries;

public class ModEntitySpawn {
    public static void register() {
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BuiltinRegistries.BIOME.getKey(BiomeKeys.PLAINS)),
                SpawnGroup.CREATURE,
                ModEntities.MOSQUITO,
                10,  // weight
                2,   // min group
                4    // max group
        );
    }
}