package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.EntityType;

import java.util.Random;

public class ModEntitySpawning {

    public static void register() {
        // Register mosquito attributes (optional here, but also done in ModEntityAttributes)
        FabricDefaultAttributeRegistry.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                MosquitoEntity.createMosquitoAttributes()
        );

        // Register mosquito spawn restriction
        SpawnRestriction.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MosquitoEntity::canSpawn
        );

        // Add mosquitoes to overworld spawns
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                ModEntities.MOSQUITO_ENTITY_TYPE,
                10, 1, 3
        );
    }
}
