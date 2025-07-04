package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.SpawnRestriction;

import net.mango.tunieland.entity.MosquitoEntity;

public class ModEntitySpawning {

    public static void register() {
        FabricDefaultAttributeRegistry.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                MosquitoEntity.createMosquitoAttributes()
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                ModEntities.MOSQUITO_ENTITY_TYPE,
                8, 1, 2
        );

        SpawnRestriction.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MosquitoEntity::canSpawnAnywhere
        );
    }
}
