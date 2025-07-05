package net.mango.tunieland.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import software.bernie.geckolib.GeckoLib;

import net.mango.tunieland.entity.ModEntities;
import net.mango.tunieland.client.render.MosquitoRenderer;

public class TunielandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GeckoLib.initialize();

        EntityRendererRegistry.register(ModEntities.MOSQUITO_ENTITY_TYPE, MosquitoRenderer::new);
    }
}
