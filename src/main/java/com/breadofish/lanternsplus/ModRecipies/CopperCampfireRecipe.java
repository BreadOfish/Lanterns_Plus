package com.breadofish.lanternsplus.ModRecipies;

import com.breadofish.lanternsplus.ModBlocks.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class CopperCampfireRecipe extends AbstractCookingRecipe {
    public static final MapCodec<CopperCampfireRecipe> MAP_CODEC = cookingMapCodec(CopperCampfireRecipe::new, 100);
    public static final StreamCodec<RegistryFriendlyByteBuf, CopperCampfireRecipe> STREAM_CODEC = cookingStreamCodec(CopperCampfireRecipe::new);
    public static final RecipeSerializer<CopperCampfireRecipe> SERIALIZER;


    public CopperCampfireRecipe(CommonInfo commonInfo, CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return ModRecipeTypes.COPPER_CAMPFIRE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CAMPFIRE;
    }

    @Override
    protected Item furnaceIcon() {
        return ModBlocks.COPPER_CAMPFIRE.asItem();
    }

    static {
        SERIALIZER = new RecipeSerializer(MAP_CODEC, STREAM_CODEC);
    }
}
