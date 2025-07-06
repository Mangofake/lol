package net.mango.tunieland.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mango.tunieland.Tunieland;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static EntityType<MosquitoEntity> MOSQUITO_ENTITY_TYPE; // ❌ no longer static final initialized early

    public static void register() {
        MOSQUITO_ENTITY_TYPE = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(Tunieland.MOD_ID, "mosquito"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MosquitoEntity::new)
                        .dimensions(EntityDimensions.fixed(0.4f, 0.4f))
                        .trackRangeBlocks(80)
                        .build()
        );

        Tunieland.LOGGER.info("Registering ModEntities for " + Tunieland.MOD_ID);
    }
}
