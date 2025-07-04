package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModEntityAttributes {
    public static void register() {
        FabricDefaultAttributeRegistry.register(
                ModEntitySpawning.MOSQUITO,
                MosquitoEntity.createMobAttributes()
        );
    }
}
