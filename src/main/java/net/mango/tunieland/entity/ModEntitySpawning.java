package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;


import net.mango.tunieland.entity.MosquitoEntity;


public class ModEntitySpawning {
    public static void register() {
        // Register mosquito attributes
        FabricDefaultAttributeRegistry.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                MosquitoEntity.createMosquitoAttributes()
        );

        // Allow mosquitoes to spawn in the overworld
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                ModEntities.MOSQUITO_ENTITY_TYPE,
                80, // spawn weight
                2,  // min group size
                4   // max group size
        );

        // Set mosquito spawn restrictions
        SpawnRestriction.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.WORLD_SURFACE,
                MosquitoEntity::canSpawnAnywhere
        );
    }
}
