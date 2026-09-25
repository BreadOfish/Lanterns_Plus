package com.breadofish.lanternsplus;

import com.breadofish.lanternsplus.BlockEntity.ModBlockEntities;
import com.breadofish.lanternsplus.ModBlocks.ModBlocks;
import com.breadofish.lanternsplus.ModParticles.ModParticles;
import com.breadofish.lanternsplus.ModRecipies.ModRecipeSerializers;
import com.breadofish.lanternsplus.ModRecipies.ModRecipeTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lanternsplus implements ModInitializer {
	public static final String MOD_ID = "lanternsplus";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void registerCreativeTabs(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register((fabricCreativeModeTabOutput -> fabricCreativeModeTabOutput.accept(ModBlocks.REDSTONE_CAMPFIRE)));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register((fabricCreativeModeTabOutput -> fabricCreativeModeTabOutput.accept(ModBlocks.REDSTONE_LANTERN)));        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register((fabricCreativeModeTabOutput -> fabricCreativeModeTabOutput.accept(ModBlocks.GILDED_REDSTONE_LANTERN)));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            Blocks.SOUL_LANTERN,
                            ModBlocks.PURPUR_LANTERN
                    );
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            Blocks.TORCH,
                            ModBlocks.PURPUR_TORCH
                    );
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            Blocks.IRON_CHAIN,
                            ModBlocks.GILDED_CHAIN
                    );
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            Blocks.CAMPFIRE,
                            ModBlocks.COPPER_CAMPFIRE
                    );
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            Blocks.LANTERN,
                            ModBlocks.GILDED_LANTERN
                    );
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.insertAfter(
                            ModBlocks.PURPUR_LANTERN,
                            ModBlocks.GILDED_PURPUR_LANTERN
                    );
                });
    }

	@Override
	public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModParticles.register();
        BlockEntityTypes.CAMPFIRE.addValidBlock(ModBlocks.REDSTONE_CAMPFIRE);
        ModRecipeTypes.register();
        ModRecipeSerializers.register();
        ModBlockEntities.register();
        ModRecipeSerializers.register();
        registerCreativeTabs();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
