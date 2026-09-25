package com.breadofish.lanternsplus.ModRecipies;

import com.breadofish.lanternsplus.Lanternsplus;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class ModRecipePropertySet {
    public static final ResourceKey<RecipePropertySet> COPPER_CAMPFIRE_INPUT = ResourceKey.create(
            RecipePropertySet.TYPE_KEY,
            Identifier.fromNamespaceAndPath(
                    Lanternsplus.MOD_ID,
                    "copper_campfire_input"
            )
    );

    public static void register(){
        Lanternsplus.LOGGER.info("Registering Recipe Properties...");
    }
}
