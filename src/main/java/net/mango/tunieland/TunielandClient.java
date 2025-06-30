package net.mango.tunieland.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mango.tunieland.client.render.MosquitoRenderer;
import net.mango.tunieland.entity.ModEntities;

public class TunielandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(
                ModEntities.MOSQUITO_ENTITY_TYPE,
                MosquitoRenderer::new
        );
    }
}