package novamachina.exnihilothermal.datagen.common;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilothermal.api.ExNihiloThermalTags;
import novamachina.exnihilothermal.common.init.ExNihiloThermalItems;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;
import novamachina.novacore.data.tags.TagProvider;

public class ExNihiloThermalTagGenerator extends TagProvider {

  public ExNihiloThermalTagGenerator(
      PackOutput output,
      CompletableFuture<HolderLookup.Provider> lookupProvider,
      ExistingFileHelper existingFileHelper) {
    super(
        output,
        lookupProvider,
        ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
        existingFileHelper);
  }

  @Override
  protected void registerTags() {
    addToTag(ExNihiloThermalTags.DUST_OBSIDIAN, ExNihiloThermalItems.DUST_OBSIDIAN.get());
  }
}
