package com.breadofish.lanternsplus.DataGen;

import com.breadofish.lanternsplus.ModBlocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class TagGenerator extends FabricTagsProvider.BlockTagsProvider {
    public TagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        builder(BlockTags.LANTERNS)
                .add(Objects.requireNonNull(ModBlocks.PURPUR_LANTERN.properties().blockId()))
                .add(Objects.requireNonNull(ModBlocks.REDSTONE_LANTERN.properties().blockId()));
        builder(BlockTags.CAMPFIRES)
                .add(Objects.requireNonNull(ModBlocks.COPPER_CAMPFIRE.properties().blockId()))
                .add(Objects.requireNonNull(ModBlocks.REDSTONE_CAMPFIRE.properties().blockId()));
    }
}
