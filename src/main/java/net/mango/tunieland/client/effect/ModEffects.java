package net.mango.tunieland.effect;

import net.mango.tunieland.Tunieland;
import net.mango.tunieland.client.effect.DengueStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect DENGUE;

    public static void registerEffects() {
        DENGUE = Registry.register(Registries.STATUS_EFFECT, new Identifier("tunieland", "dengue"), new DengueStatusEffect());
    }
}
