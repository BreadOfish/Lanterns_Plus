package com.breadofish.lanternsplus.BlockEntity;

import com.breadofish.lanternsplus.Lanternsplus;
import com.breadofish.lanternsplus.ModBlocks.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;

import java.util.List;
import java.util.Set;

public class ModBlockEntities {
    public static final ResourceKey<BlockEntityType<?>> COPPER_CAMPFIRE_TYPE;
    public static final BlockEntityType<CopperCampfireBE> COPPER_CAMPFIRE;

    private static <T extends BlockEntity> BlockEntityType<T> register(final ResourceKey<BlockEntityType<?>> key, final BlockEntityType.BlockEntitySupplier<? extends T> factory, final Block... validBlocks) {
        Identifier id = key.identifier();
        if (validBlocks.length == 0) {
            Lanternsplus.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", id);
        }

        if (id.getNamespace().equals("minecraft")) {
            Util.fetchChoiceType(References.BLOCK_ENTITY, id.getPath());
        }

        return (BlockEntityType)Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key, new BlockEntityType(factory, Set.of(validBlocks)));
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(final ResourceKey<BlockEntityType<?>> id, final BlockEntityType.BlockEntitySupplier<? extends T> factory, final List<Block> validBlocks) {
        return register(id, factory, (Block[])validBlocks.toArray(new Block[0]));
    }
    static {
        COPPER_CAMPFIRE_TYPE = ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(
                Lanternsplus.MOD_ID,
                "copper_campfire"
        ));

        COPPER_CAMPFIRE = register(COPPER_CAMPFIRE_TYPE, CopperCampfireBE::new, ModBlocks.COPPER_CAMPFIRE);
    }

    public static void register(){
        Lanternsplus.LOGGER.info("Registering Mod Entities...");
    }
}
