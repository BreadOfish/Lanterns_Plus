package com.breadofish.lanternsplus.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RedstoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class RedstoneCampfire extends CampfireBlock {
    public RedstoneCampfire(boolean spawnParticles, int fireDamage, Properties properties) {
        super(spawnParticles, fireDamage, properties);
    }

    private  int getInputSignal(Level level, BlockPos pos, BlockState state){
        Direction inputDir = state.getValue(FACING).getOpposite();
        BlockPos inputPos = pos.relative(inputDir);
        int power = level.getSignal(inputPos, inputDir);
        if (power >= 15) return power;
        BlockState inputState = level.getBlockState(inputPos);
        return Math.max(power, inputState.is(Blocks.REDSTONE_WIRE) ? inputState.getValue(RedstoneWireBlock.POWER) : 0);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state == null){
            return null;
        }
        boolean powered = getInputSignal(context.getLevel(), context.getClickedPos(), state) > 0;
        return state.setValue(LIT, powered && !state.getValue(WATERLOGGED));
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);
        if (level.isClientSide()) return;

        boolean powered = getInputSignal(level, pos, state) > 0;
        if (powered == state.getValue(LIT)) return;
        if (powered && state.getValue(WATERLOGGED)) return;

        if (!powered && level instanceof ServerLevel serverLevel) {   // going out only
            level.levelEvent(null, 1009, pos, 0);                     // fizz sound
            douse(null, level, pos, state);                           // resets block entity, game event

            ParticleOptions smoke = state.getValue(SIGNAL_FIRE)
                    ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE
                    : ParticleTypes.CAMPFIRE_COSY_SMOKE;
            RandomSource random = serverLevel.getRandom();
            for (int i = 0; i < 20; i++) {
                serverLevel.sendParticles(smoke,
                        pos.getX() + 0.5 + random.nextDouble() / 3.0 * (random.nextBoolean() ? 1 : -1),
                        pos.getY() + random.nextDouble() + random.nextDouble() + 0.5,
                        pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (random.nextBoolean() ? 1 : -1),
                        0, 0.0, 1.0, 0.0, 0.07);   // count 0: the offset is the velocity (upward drift)
            }
        }

        level.setBlock(pos, state.setValue(LIT, powered), Block.UPDATE_ALL);
        level.updateNeighborsAt(pos.relative(state.getValue(FACING)), this);
    }

    @Override
    protected boolean shouldRedstoneWireConnectTo(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return state.getValue(LIT) ? 15 : 0;
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return state.getValue(LIT);
    }


    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(LIT) && direction == state.getValue(FACING).getOpposite() ? 15 : 0;
    }

    @Override
    protected int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state,level,pos,direction);
    }
}
