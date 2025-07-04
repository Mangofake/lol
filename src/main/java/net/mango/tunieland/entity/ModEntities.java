package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.mango.tunieland.Tunieland;
import net.minecraft.registry.Registries;
import net.mango.tunieland.entity.MosquitoEntity;

public class ModEntities {
    public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("tunieland", "mosquito"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build()
    );

    public static void register() {
        Tunieland.LOGGER.info("Registering ModEntities for " + Tunieland.MOD_ID);
    }
}