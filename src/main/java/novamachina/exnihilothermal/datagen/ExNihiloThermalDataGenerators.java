package novamachina.exnihilothermal.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihilothermal.datagen.client.ExNihiloThermalItemGenerator;
import novamachina.exnihilothermal.datagen.client.ExNihiloThermalLangGenerator;
import novamachina.exnihilothermal.datagen.common.ExNihiloThermalRecipeGenerator;
import novamachina.exnihilothermal.datagen.common.ExNihiloThermalTagGenerator;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExNihiloThermalDataGenerators {

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packoutput = generator.getPackOutput();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    if (event.includeServer()) {
      generator.addProvider(
          true, new ExNihiloThermalRecipeGenerator(packoutput, event.getExistingFileHelper()));
      generator.addProvider(
          true,
          new ExNihiloThermalTagGenerator(
              packoutput, lookupProvider, event.getExistingFileHelper()));
    }
    if (event.includeClient()) {
      // Items
      generator.addProvider(
          true, new ExNihiloThermalItemGenerator(packoutput, event.getExistingFileHelper()));
      // Lang
      generator.addProvider(true, new ExNihiloThermalLangGenerator(packoutput, "en_us"));
    }
  }
}
