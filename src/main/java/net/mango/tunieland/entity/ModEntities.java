package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY_TYPE =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier("tunieland", "mosquito"),
                    FabricEntityTypeBuilder.<MosquitoEntity>create(SpawnGroup.MONSTER, MosquitoEntity::new)
                            .dimensions(EntityDimensions.fixed(0.7f, 0.5f))
                            .build()
            );

    public static void register() {
        // Ensures the static field is loaded
    }
}