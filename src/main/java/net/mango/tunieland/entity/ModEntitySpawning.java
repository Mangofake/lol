package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.WorldAccess;
import net.mango.tunieland.Tunieland;

public class ModEntitySpawning {
    public static final EntityType<MosquitoEntity> MOSQUITO =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier(Tunieland.MOD_ID, "mosquito"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosquitoEntity::new)
                            .dimensions(EntityDimensions.fixed(0.7f, 0.5f))
                            .trackRangeBlocks(8)
                            .build()
            );

    public static void register() {
        FabricDefaultAttributeRegistry.register(MOSQUITO, MosquitoEntity.createMosquitoAttributes());

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE,
                MOSQUITO,
                50, 2, 4
        );

        SpawnRestriction.register(
                MOSQUITO,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MosquitoEntity::canSpawnOnGrass
        );
    }
}
