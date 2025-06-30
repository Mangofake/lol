package net.mango.tunieland.client.model;

import net.mango.tunieland.entity.MosquitoEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;



public class MosquitoModel extends GeoModel<MosquitoEntity> {

    @Override
    public Identifier getModelResource(MosquitoEntity animatable) {
        return new Identifier("tunieland", "geo/mosquito.geo.json");
    }

    @Override
    public Identifier getTextureResource(MosquitoEntity animatable) {
        return new Identifier("tunieland", "textures/entity/mosquito.png");
    }

    @Override
    public Identifier getAnimationResource(MosquitoEntity animatable) {
        return new Identifier("tunieland", "animations/mosquito.entity.json");
    }
}