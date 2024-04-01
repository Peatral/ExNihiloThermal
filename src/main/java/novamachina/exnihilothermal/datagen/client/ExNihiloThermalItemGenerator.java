package novamachina.exnihilothermal.datagen.client;

import com.mojang.logging.LogUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihilothermal.common.init.ExNihiloThermalItems;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;
import org.slf4j.Logger;

public class ExNihiloThermalItemGenerator extends ItemModelProvider {

  private static final Logger logger = LogUtils.getLogger();

  private static final String ITEMS_TAG = "item/";
  private static final String ITEM_GENERATED = "item/generated";
  private static final String LAYER_0_TAG = "layer0";

  public ExNihiloThermalItemGenerator(PackOutput generator, ExistingFileHelper existingFileHelper) {
    super(generator, ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    singleTexture(
        ForgeRegistries.ITEMS.getKey(ExNihiloThermalItems.BASALZ_DOLL.get()).toString(),
        new ResourceLocation(ITEM_GENERATED),
        LAYER_0_TAG,
        new ResourceLocation(
            ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
            ITEMS_TAG + ExNihiloThermalItems.BASALZ_DOLL.get().getDollName()));

    singleTexture(
        ForgeRegistries.ITEMS.getKey(ExNihiloThermalItems.BLITZ_DOLL.get()).toString(),
        new ResourceLocation(ITEM_GENERATED),
        LAYER_0_TAG,
        new ResourceLocation(
            ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
            ITEMS_TAG + ExNihiloThermalItems.BLITZ_DOLL.get().getDollName()));

    singleTexture(
        ForgeRegistries.ITEMS.getKey(ExNihiloThermalItems.BLIZZ_DOLL.get()).toString(),
        new ResourceLocation(ITEM_GENERATED),
        LAYER_0_TAG,
        new ResourceLocation(
            ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
            ITEMS_TAG + ExNihiloThermalItems.BLIZZ_DOLL.get().getDollName()));

    singleTexture(
        ForgeRegistries.ITEMS.getKey(ExNihiloThermalItems.DUST_OBSIDIAN.get()).getPath(),
        new ResourceLocation(ITEM_GENERATED),
        "layer0",
        new ResourceLocation(
            ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
            "item/" + ExNihiloThermalItems.DUST_OBSIDIAN.get().getResourceName()));
  }
}
