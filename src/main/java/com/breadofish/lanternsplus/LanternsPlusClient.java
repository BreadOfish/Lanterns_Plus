package com.breadofish.lanternsplus;

import com.breadofish.lanternsplus.BlockEntity.CopperCampfireBE;
import com.breadofish.lanternsplus.BlockEntity.CopperCampfireBERenderer;
import com.breadofish.lanternsplus.BlockEntity.ModBlockEntities;
import com.breadofish.lanternsplus.ModParticles.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LanternsPlusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(ModParticles.PURPUR_FLAME, FlameParticle.Provider::new);
        BlockEntityRenderers.register(ModBlockEntities.COPPER_CAMPFIRE, CopperCampfireBERenderer::new);
    }
}
