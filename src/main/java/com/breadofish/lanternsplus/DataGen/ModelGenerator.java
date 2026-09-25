package com.breadofish.lanternsplus.DataGen;

import com.breadofish.lanternsplus.ModBlocks.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createNormalTorch(ModBlocks.PURPUR_TORCH, ModBlocks.PURPUR_WALL_TORCH);
        blockModelGenerators.createLantern(ModBlocks.REDSTONE_LANTERN);
        blockModelGenerators.createLantern(ModBlocks.PURPUR_LANTERN);
        blockModelGenerators.createLantern(ModBlocks.GILDED_LANTERN);
        blockModelGenerators.createLantern(ModBlocks.GILDED_REDSTONE_LANTERN);
        blockModelGenerators.createLantern(ModBlocks.GILDED_PURPUR_LANTERN);
        blockModelGenerators.createCampfires(ModBlocks.COPPER_CAMPFIRE);
        blockModelGenerators.createCampfires(ModBlocks.REDSTONE_CAMPFIRE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
