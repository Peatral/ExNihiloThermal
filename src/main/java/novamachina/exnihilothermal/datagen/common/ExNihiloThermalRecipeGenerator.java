package novamachina.exnihilothermal.datagen.common;

import static novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities.createSaveLocation;

import cofh.thermal.core.ThermalCore;
import java.util.function.Consumer;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants;
import novamachina.exnihilosequentia.data.recipes.CrushingRecipeBuilder;
import novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities;
import novamachina.exnihilosequentia.data.recipes.SiftingRecipeBuilder;
import novamachina.exnihilosequentia.world.item.EXNItems;
import novamachina.exnihilosequentia.world.item.crafting.ItemStackWithChance;
import novamachina.exnihilosequentia.world.item.crafting.MeshWithChance;
import novamachina.exnihilothermal.api.ExNihiloThermalTags;
import novamachina.exnihilothermal.common.init.ExNihiloThermalItems;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;
import novamachina.novacore.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

public class ExNihiloThermalRecipeGenerator extends RecipeProvider {

  public ExNihiloThermalRecipeGenerator(PackOutput generator, ExistingFileHelper helper) {
    super(generator, helper, ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL);
  }

  @Override
  protected void addRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
    registerCrafting(consumer);
    registerCrushing(consumer);
    registerSieve(consumer);
  }

  protected void registerCrafting(Consumer<FinishedRecipe> consumer) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExNihiloThermalItems.BASALZ_DOLL.get())
        .pattern("xvx")
        .pattern("zyz")
        .pattern("xwx")
        .define('x', ExNihiloThermalTags.DUST_OBSIDIAN)
        .define('v', Tags.Items.DUSTS_REDSTONE)
        .define('z', Tags.Items.DUSTS_GLOWSTONE)
        .define('y', EXNItems.CRAFTING_DOLL.asItem())
        .define('w', Tags.Items.CROPS_NETHER_WART)
        .group(ExNihiloConstants.ModIds.EX_NIHILO_SEQUENTIA)
        .unlockedBy(
            "has_doll",
            InventoryChangeTrigger.TriggerInstance.hasItems(EXNItems.CRAFTING_DOLL.asItem()))
        .save(consumer, createSaveLocation(ExNihiloThermalItems.BASALZ_DOLL.getId()));

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExNihiloThermalItems.BLIZZ_DOLL.get())
        .pattern("xvx")
        .pattern("zyz")
        .pattern("xwx")
        .define('x', Items.SNOWBALL)
        .define('v', Tags.Items.DUSTS_REDSTONE)
        .define('z', Tags.Items.DUSTS_GLOWSTONE)
        .define('y', EXNItems.CRAFTING_DOLL.asItem())
        .define('w', Tags.Items.CROPS_NETHER_WART)
        .group(ExNihiloConstants.ModIds.EX_NIHILO_SEQUENTIA)
        .unlockedBy(
            "has_doll",
            InventoryChangeTrigger.TriggerInstance.hasItems(EXNItems.CRAFTING_DOLL.asItem()))
        .save(consumer, createSaveLocation(ExNihiloThermalItems.BLIZZ_DOLL.getId()));

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExNihiloThermalItems.BLITZ_DOLL.get())
        .pattern("xvx")
        .pattern("zyz")
        .pattern("xwx")
        .define('x', ThermalCore.ITEMS.get("niter_dust"))
        .define('v', Tags.Items.DUSTS_REDSTONE)
        .define('z', Tags.Items.DUSTS_GLOWSTONE)
        .define('y', EXNItems.CRAFTING_DOLL.asItem())
        .define('w', Tags.Items.CROPS_NETHER_WART)
        .group(ExNihiloConstants.ModIds.EX_NIHILO_SEQUENTIA)
        .unlockedBy(
            "has_doll",
            InventoryChangeTrigger.TriggerInstance.hasItems(EXNItems.CRAFTING_DOLL.asItem()))
        .save(consumer, createSaveLocation(ExNihiloThermalItems.BLITZ_DOLL.getId()));
  }

  protected void registerCrushing(Consumer<FinishedRecipe> consumer) {
    CrushingRecipeBuilder.crushing(
            Items.OBSIDIAN, // Ingredient.of(Tags.Items.OBSIDIAN),
            ItemStackWithChance.of(new ItemStack(ExNihiloThermalItems.DUST_OBSIDIAN.get(), 4)))
        .build(consumer, crushingLoc("dust_obsidian"));
  }

  private void registerSieve(Consumer<FinishedRecipe> consumer) {
    SiftingRecipeBuilder.sifting(Ingredient.of(Tags.Items.GRAVEL), ThermalCore.ITEMS.get("niter"))
        .addRoll(new MeshWithChance(EXNItems.MESH_FLINT.asItem().getType(), 0.05F))
        .addRoll(new MeshWithChance(EXNItems.MESH_IRON.asItem().getType(), 0.1F))
        .addRoll(new MeshWithChance(EXNItems.MESH_DIAMOND.asItem().getType(), 0.15F))
        .build(consumer, siftingLoc("niter"));

    SiftingRecipeBuilder.sifting(Ingredient.of(Tags.Items.GRAVEL), ThermalCore.ITEMS.get("sulfur"))
        .addRoll(new MeshWithChance(EXNItems.MESH_FLINT.asItem().getType(), 0.05F))
        .addRoll(new MeshWithChance(EXNItems.MESH_IRON.asItem().getType(), 0.1F))
        .addRoll(new MeshWithChance(EXNItems.MESH_DIAMOND.asItem().getType(), 0.15F))
        .build(consumer, siftingLoc("sulfur"));

    SiftingRecipeBuilder.sifting(Ingredient.of(Tags.Items.GRAVEL), ThermalCore.ITEMS.get("apatite"))
        .addRoll(new MeshWithChance(EXNItems.MESH_FLINT.asItem().getType(), 0.05F))
        .addRoll(new MeshWithChance(EXNItems.MESH_IRON.asItem().getType(), 0.1F))
        .addRoll(new MeshWithChance(EXNItems.MESH_DIAMOND.asItem().getType(), 0.15F))
        .build(consumer, siftingLoc("apatite"));

    SiftingRecipeBuilder.sifting(
            Ingredient.of(Tags.Items.GRAVEL), ThermalCore.ITEMS.get("cinnabar"))
        .addRoll(new MeshWithChance(EXNItems.MESH_FLINT.asItem().getType(), 0.05F))
        .addRoll(new MeshWithChance(EXNItems.MESH_IRON.asItem().getType(), 0.1F))
        .addRoll(new MeshWithChance(EXNItems.MESH_DIAMOND.asItem().getType(), 0.15F))
        .build(consumer, siftingLoc("cinnabar"));
  }

  private ResourceLocation siftingLoc(String id) {
    return new ResourceLocation(
        ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
        "sifting/" + RecipeProviderUtilities.prependRecipePrefix(id));
  }

  private ResourceLocation crushingLoc(String id) {
    return new ResourceLocation(
        ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
        "crushing/" + RecipeProviderUtilities.prependRecipePrefix(id));
  }
}
