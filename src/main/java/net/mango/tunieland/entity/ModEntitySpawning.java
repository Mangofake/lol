package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.SpawnRestriction;
import net.mango.tunieland.entity.MosquitoEntity;

public class ModEntitySpawning {

    public static void register() {
        // Make mosquitoes spawn in all overworld biomes
        BiomeModifications.addSpawn(
                BiomeSelectors.all(),
                SpawnGroup.AMBIENT,
                ModEntities.MOSQUITO_ENTITY_TYPE,
                100, // spawn weight
                2,  // min group size
                4   // max group size
        );

        // Set spawn rules for mosquitoes
        SpawnRestriction.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.WORLD_SURFACE,
                MosquitoEntity::canSpawnAnywhere
        );
    }
}
