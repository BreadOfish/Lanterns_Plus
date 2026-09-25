package com.breadofish.lanternsplus.ModBlocks;

import com.breadofish.lanternsplus.Lanternsplus;
import com.breadofish.lanternsplus.ModParticles.ModParticles;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block PURPUR_TORCH = registerBlock(
            "purpur_torch",
            properties -> new TorchBlock(ModParticles.PURPUR_FLAME, properties),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(value -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED),
            false
    );
    public static final Block PURPUR_WALL_TORCH = registerBlock(
            "purpur_wall_torch",
            properties -> new WallTorchBlock(ModParticles.PURPUR_FLAME, properties),
            BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel(value -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED),
            false
    );

    public static final Item PURPUR_TORCH_ITEM = registerItem(
            "purpur_torch",
            properties -> new StandingAndWallBlockItem(PURPUR_TORCH, PURPUR_WALL_TORCH, Direction.DOWN, properties),
            new Item.Properties().useBlockDescriptionPrefix()
    );

    public static final Block REDSTONE_LANTERN = registerBlock(
            "redstone_lantern",
            RedstoneLanternBlock::new,
            BlockBehaviour.Properties.of().lightLevel(value -> 14).sound(SoundType.LANTERN).pushReaction(PushReaction.PUSH_PULL),
            true
    );
    public static final Block GILDED_REDSTONE_LANTERN = registerBlock(
            "gilded_redstone_lantern",
            RedstoneLanternBlock::new,
            BlockBehaviour.Properties.of().lightLevel(value -> 14).sound(SoundType.LANTERN).pushReaction(PushReaction.PUSH_PULL),
            true
    );
    public static final Block GILDED_LANTERN = registerBlock(
            "gilded_lantern",
            LanternBlock::new,
            BlockBehaviour.Properties.of().lightLevel(value -> 14).sound(SoundType.LANTERN).pushReaction(PushReaction.PUSH_PULL),
            true
    );

    public static final Block GILDED_PURPUR_LANTERN = registerBlock(
            "gilded_purpur_lantern",
            LanternBlock::new,
            BlockBehaviour.Properties.of().lightLevel(value -> 14).sound(SoundType.LANTERN).pushReaction(PushReaction.PUSH_PULL),
            true
    );


    public static final Block PURPUR_LANTERN = registerBlock(
            "purpur_lantern",
            LanternBlock::new,
            BlockBehaviour.Properties.of().lightLevel(value -> 14).sound(SoundType.LANTERN).pushReaction(PushReaction.PUSH_PULL),
            true
    );


    public static final Block COPPER_CAMPFIRE= registerBlock(
            "copper_campfire",
            properties -> new CopperCampfire(true, 1, properties),
            BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).lightLevel(state -> state.getValue(BlockStateProperties.LIT)  ? 15 : 0).noOcclusion(),
            true
    );

    public static final Block REDSTONE_CAMPFIRE = registerBlock(
            "redstone_campfire",
            properties -> new RedstoneCampfire(true, 1, properties),
            BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).lightLevel(state -> state.getValue(BlockStateProperties.LIT)  ? 15 : 0).noOcclusion(),
            true
    );

    public static final Block GILDED_CHAIN = registerBlock(
            "gilded_chain",
            ChainBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN),
            true
    );

    public static ResourceKey<Block> blockKey(String name){
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Lanternsplus.MOD_ID, name));
    }

    public static ResourceKey<Item> itemKey(String name){
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Lanternsplus.MOD_ID, name));
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean registerBlockItem){
        ResourceKey<@NotNull Block> blockKey = blockKey(name);

        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                blockKey(name),
                blockFactory.apply(properties.setId(blockKey))
        );

        if(registerBlockItem){
            ResourceKey<Item> itemKey = itemKey(name);
            Registry.register(
                    BuiltInRegistries.ITEM,
                    itemKey,
                    new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix())
            );
        }
        return block;
    }

    private static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties properties) {
        ResourceKey<@NotNull Item> key = itemKey(name);
        return Registry.register(BuiltInRegistries.ITEM, key, itemFactory.apply(properties.setId(key)));
    }

    public static void registerModBlocks(){
        Lanternsplus.LOGGER.info("Registering Modded Blocks...");
    }
}
