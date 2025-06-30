package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.entity.registry.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.Tunieland;

public class ModEntitySpawning {
    public static final EntityType<MosquitoEntity> MOSQUITO =
            Registry.register(Registry.ENTITY_TYPE,
                    new Identifier(Tunieland.MOD_ID, "mosquito"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosquitoEntity::new)
                            .dimensions(EntityDimensions.fixed(0.7f, 0.5f))
                            .build()
            );

    public static void register() {
        FabricDefaultAttributeRegistry.register(
                MOSQUITO,
                MosquitoEntity.createAttributes()
        );
    }
}
