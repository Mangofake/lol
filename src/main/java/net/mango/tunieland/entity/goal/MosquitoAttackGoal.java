package net.mango.tunieland.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.mango.tunieland.effect.ModEffects;

public class MosquitoAttackGoal extends MeleeAttackGoal {

    public MosquitoAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity target = this.mob.getTarget();
        if (target != null && this.mob.squaredDistanceTo(target) < 2.0) {
            this.mob.swingHand(Hand.MAIN_HAND);

            if (this.mob.tryAttack(target)) {
                target.addStatusEffect(new StatusEffectInstance(ModEffects.DENGUE, 100, 0));
                System.out.println("Mosquito hit " + target.getName().getString() + " and applied Dengue.");
            }
        }
    }
}