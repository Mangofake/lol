package net.mango.tunieland.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import net.mango.tunieland.item.ModItems;
import net.mango.tunieland.entity.goal.MosquitoAttackGoal;
import net.mango.tunieland.entity.goal.MosquitoFlyAroundGoal;

import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;

import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class MosquitoEntity extends HostileEntity implements GeoAnimatable {
    private final AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);

    public MosquitoEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    public static DefaultAttributeContainer.Builder createMosquitoAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.8);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MosquitoAttackGoal(this, 1.0, true));
        this.goalSelector.add(2, new MosquitoFlyAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new BirdNavigation(this, world);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, net.minecraft.entity.damage.DamageSource source) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BEE_LOOP;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isSilent() && this.age % 60 == 0) {
            this.playSound(SoundEvents.ENTITY_BEE_LOOP, 0.5f, 1.0f);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.age % 100 < 50) {
            this.setVelocity(this.getVelocity().x, 0.03, this.getVelocity().z);
        } else {
            this.setVelocity(this.getVelocity().x, -0.03, this.getVelocity().z);
        }
        this.move(MovementType.SELF, this.getVelocity());
        Vec3d vel = this.getVelocity();
        if (!vel.equals(Vec3d.ZERO)) {
            float yaw = (float)(Math.atan2(vel.z, vel.x) * (180F / Math.PI)) - 90.0F;
            this.setYaw(yaw);
            this.bodyYaw = yaw;
            this.prevYaw = yaw;
            this.headYaw = yaw;
        }
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        return super.canTarget(target) && target instanceof PlayerEntity;
    }

    @Override
    public void onDeath(net.minecraft.entity.damage.DamageSource source) {
        super.onDeath(source);
        if (!this.getWorld().isClient && this.random.nextFloat() < 0.30f) {
            this.dropStack(new ItemStack(ModItems.SANGRE_DE_MOSQUITO));
        }
    }

    public static boolean canSpawnOnGrass(EntityType<MosquitoEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isOf(Blocks.GRASS_BLOCK) && world.getLightLevel(pos) > 8;
    }

    @Override
    public double getTick(Object custom) {
        return this.age;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 20, state -> PlayState.CONTINUE));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }
}
