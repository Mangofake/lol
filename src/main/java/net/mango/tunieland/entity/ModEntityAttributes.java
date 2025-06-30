package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;

public class ModEntityAttributes {
    public static void register() {
        FabricDefaultAttributeRegistry.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                MosquitoEntity.createMosquitoAttributes()
        );
    }
}