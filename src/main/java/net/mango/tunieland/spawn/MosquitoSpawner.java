package net.mango.tunieland.spawn;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.mango.tunieland.entity.ModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;

public class MosquitoSpawner {
    private static final int CHANCE = 80;
    private static final int GROUP  = 1;
    private static final int RANGE  = 14;
    private static final int MAX_PER_PLAYER = 5;
    // new global cap
    private static final int MAX_GLOBAL = 200;

    public static void init() {
        ServerWorldEvents.LOAD.register((server, world) -> {
            if (world.getRegistryKey().getValue().getPath().equals("overworld")) {
                ServerTickEvents.END_WORLD_TICK.register(w -> trySpawn(w));
            }
        });
    }

    private static void trySpawn(ServerWorld world) {
        // GLOBAL CAP: stop trying once we’ve reached MAX_GLOBAL
        long totalMosquitoes = world.getEntitiesByType(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                e -> true
        ).stream().count();
        if (totalMosquitoes >= MAX_GLOBAL) return;

        var random = world.getRandom();
        for (var player : world.getPlayers()) {
            if (random.nextInt(CHANCE) != 0) continue;

            long nearby = world.getEntitiesByType(
                    ModEntities.MOSQUITO_ENTITY_TYPE,
                    e -> e.isInRange(player, RANGE)
            ).stream().count();
            if (nearby >= MAX_PER_PLAYER) continue;

            int dx = random.nextInt(RANGE * 2 + 1) - RANGE;
            int dz = random.nextInt(RANGE * 2 + 1) - RANGE;
            BlockPos ground = world.getTopPosition(
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    player.getBlockPos().add(dx, 0, dz)
            );
            var below = ground.down();
            if (!world.getBlockState(below).isOf(Blocks.DIRT)
                    && !world.getBlockState(below).isOf(Blocks.GRASS_BLOCK)) continue;
            if (!world.isSkyVisible(ground)) continue;

            for (int i = 0; i < GROUP; i++) {
                @SuppressWarnings("unchecked")
                var m = (PathAwareEntity)
                        ModEntities.MOSQUITO_ENTITY_TYPE.create(world);
                if (m == null) continue;
                m.refreshPositionAndAngles(
                        ground.getX() + random.nextDouble(),
                        ground.getY(),
                        ground.getZ() + random.nextDouble(),
                        0, 0
                );
                world.spawnEntity(m);
            }
        }
    }
}