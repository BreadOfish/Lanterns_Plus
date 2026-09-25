package com.breadofish.lanternsplus.ModRecipies;

import com.breadofish.lanternsplus.Lanternsplus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.*;

public class ModRecipeTypes {
    public static final RecipeType<CopperCampfireRecipe> COPPER_CAMPFIRE = register("copper_campfire");

    protected static <T extends Recipe<?>> RecipeType<T> register(final String name) {
        return (RecipeType<T>) Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                ResourceKey.create(
                        Registries.RECIPE_TYPE,
                        Identifier.fromNamespaceAndPath(Lanternsplus.MOD_ID, name)
                ),
                new RecipeType<T>() {
                    public String toString() {
                        return name;
                    }
                }
        );
    }

    public static final void register(){
        Lanternsplus.LOGGER.info("Registering Custom recipe types...");
    }
}
