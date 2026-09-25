package com.breadofish.lanternsplus.ModBlocks;

import com.breadofish.lanternsplus.BlockEntity.CopperCampfireBE;
import com.breadofish.lanternsplus.BlockEntity.ModBlockEntities;
import com.breadofish.lanternsplus.ModRecipies.CopperCampfireRecipe;
import com.breadofish.lanternsplus.ModRecipies.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class CopperCampfire extends CampfireBlock {

    public CopperCampfire(boolean spawnParticles, int fireDamage, Properties properties) {
        super(spawnParticles, fireDamage, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperCampfireBE(pos, state);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CopperCampfireBE campfire) {
            if (level instanceof ServerLevel serverLevel) {
                if (campfire.placeFood(serverLevel, player, itemStack)) {
                    player.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return InteractionResult.SUCCESS_SERVER;
                }
            }

            return InteractionResult.CONSUME;
            }
        return InteractionResult.FAIL;
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(final Level level, final BlockState blockState, final BlockEntityType<T> type) {
        if (level instanceof ServerLevel serverLevel) {
            if ((Boolean)blockState.getValue(LIT)) {
                RecipeManager.CachedCheck<SingleRecipeInput, CopperCampfireRecipe> quickCheck = RecipeManager.createCheck(ModRecipeTypes.COPPER_CAMPFIRE);
                return createTickerHelper(type, ModBlockEntities.COPPER_CAMPFIRE, (innerLevel, pos, state, entity) -> CopperCampfireBE.cookTick(serverLevel, pos, state, entity, quickCheck));
            } else {
                return createTickerHelper(type, ModBlockEntities.COPPER_CAMPFIRE, CopperCampfireBE::cooldownTick);
            }
        } else {
            return (Boolean)blockState.getValue(LIT) ? createTickerHelper(type, ModBlockEntities.COPPER_CAMPFIRE, CopperCampfireBE::particleTick) : null;
        }
    }


}
