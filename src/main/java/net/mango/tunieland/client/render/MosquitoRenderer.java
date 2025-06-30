package net.mango.tunieland.client.render;

import net.mango.tunieland.entity.MosquitoEntity;
import net.mango.tunieland.client.model.MosquitoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;



public class MosquitoRenderer extends GeoEntityRenderer<MosquitoEntity> {
    public MosquitoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MosquitoModel());
    }
}