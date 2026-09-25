package com.breadofish.lanternsplus.ModRecipies;

import com.breadofish.lanternsplus.Lanternsplus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
    public static final RecipeSerializer<CopperCampfireRecipe> COPPER_CAMPFIRE_RECIPE_RECIPE_SERIALIZER =
            Registry.register(
                    BuiltInRegistries.RECIPE_SERIALIZER,
                    ResourceKey.create(Registries.RECIPE_SERIALIZER,
                            Identifier.fromNamespaceAndPath(Lanternsplus.MOD_ID, "copper_campfire")),
                    CopperCampfireRecipe.SERIALIZER
            );

    public static final void register(){
        Lanternsplus.LOGGER.info("Registering Custom recipe serializers...");
    }

}
