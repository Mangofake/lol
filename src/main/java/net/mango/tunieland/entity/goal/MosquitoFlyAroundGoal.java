package net.mango.tunieland.entity.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

import java.util.EnumSet;

public class MosquitoFlyAroundGoal extends Goal {
    private final PathAwareEntity mosquito;
    private int timer;

    public MosquitoFlyAroundGoal(PathAwareEntity mosquito) {
        this.mosquito = mosquito;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void tick() {
        if (--timer <= 0) {
            timer = 40 + mosquito.getRandom().nextInt(20);

            Random rand = mosquito.getRandom();
            Vec3d target = mosquito.getPos().add(
                    rand.nextFloat() * 6 - 3,
                    rand.nextFloat() * 4 - 2,
                    rand.nextFloat() * 6 - 3
            );

            mosquito.getNavigation().startMovingTo(target.x, target.y, target.z, 1.0);
        }

        // Smooth turning toward velocity
        Vec3d velocity = mosquito.getVelocity();
        if (velocity.lengthSquared() > 0.01) {
            mosquito.setYaw((float)(Math.toDegrees(Math.atan2(velocity.z, velocity.x)) - 90F));
            mosquito.setBodyYaw(mosquito.getYaw());
            mosquito.setHeadYaw(mosquito.getYaw());
        }
    }
}