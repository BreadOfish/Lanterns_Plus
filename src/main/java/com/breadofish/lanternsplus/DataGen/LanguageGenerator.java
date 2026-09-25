package com.breadofish.lanternsplus.DataGen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LanguageGenerator extends FabricLanguageProvider {
    public LanguageGenerator(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("block.lanternsplus.purpur_torch", "Purpur Torch");
        translationBuilder.add("block.lanternsplus.redstone_lantern", "Redstone Lantern");
        translationBuilder.add("block.lanternsplus.gilded_redstone_lantern", "Gilded Redstone Lantern");
        translationBuilder.add("block.lanternsplus.gilded_lantern", "Gilded Lantern");
        translationBuilder.add("block.lanternsplus.gilded_purpur_lantern", "Gilded Purpur Lantern");
        translationBuilder.add("block.lanternsplus.purpur_lantern", "Purpur Lantern");
        translationBuilder.add("block.lanternsplus.copper_campfire", "Copper Campfire");
        translationBuilder.add("block.lanternsplus.redstone_campfire", "Redstone Campfire");
        translationBuilder.add("block.lanternsplus.gilded_chain", "Gilded Chain");
    }
}
