package net.mango.tunieland.entity.goal;

import net.mango.tunieland.entity.MosquitoEntity;
import net.mango.tunieland.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.EnumSet;

public class MosquitoAttackGoal extends Goal {
    private final MosquitoEntity mosquito;
    private final double speed;
    private final boolean pauseWhenMobIdle;
    private LivingEntity target;

    public MosquitoAttackGoal(MosquitoEntity mosquito, double speed, boolean pauseWhenMobIdle) {
        this.mosquito = mosquito;
        this.speed = speed;
        this.pauseWhenMobIdle = pauseWhenMobIdle;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        LivingEntity target = this.mosquito.getTarget();
        return target != null && target.isAlive();
    }

    @Override
    public void start() {
        this.target = this.mosquito.getTarget();
        this.mosquito.getNavigation().startMovingTo(this.target, this.speed);
    }

    @Override
    public boolean shouldContinue() {
        return this.target != null && this.target.isAlive();
    }

    @Override
    public void stop() {
        this.target = null;
    }

    @Override
    public void tick() {
        if (this.target != null) {
            this.mosquito.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            this.mosquito.getNavigation().startMovingTo(this.target, this.speed);

            if (this.mosquito.squaredDistanceTo(this.target) < 1.5D) {
                // ✅ Safe delayed access
                this.target.addStatusEffect(createDengueEffect());
            }
        }
    }

    private static StatusEffectInstance createDengueEffect() {
        return new StatusEffectInstance(ModEffects.DENGUE, 100, 0);
    }
}
