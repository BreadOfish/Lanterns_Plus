package com.breadofish.lanternsplus.ModParticles;

import com.breadofish.lanternsplus.Lanternsplus;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModParticles {
    public static final SimpleParticleType PURPUR_FLAME = FabricParticleTypes.simple();

    public static void register(){
        Registry.register(
                BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(Lanternsplus.MOD_ID, "purpur_flame"),
                PURPUR_FLAME
        );
    }
}
