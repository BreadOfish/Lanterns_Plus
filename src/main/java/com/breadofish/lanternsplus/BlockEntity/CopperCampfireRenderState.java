package com.breadofish.lanternsplus.BlockEntity;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

import java.util.Collections;
import java.util.List;

public class CopperCampfireRenderState extends BlockEntityRenderState {
    public List<ItemStackRenderState> items = Collections.emptyList();
    public Direction facing;

    public CopperCampfireRenderState() {
        this.facing = Direction.NORTH;
    }
}
