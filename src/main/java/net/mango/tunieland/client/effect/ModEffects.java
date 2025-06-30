package net.mango.tunieland.effect;

import net.mango.tunieland.client.effect.DengueStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mango.tunieland.effect.ModEffects;

public class ModEffects {
    public static final StatusEffect DENGUE = new DengueStatusEffect();

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("tunieland", "dengue"), DENGUE);
    }
}