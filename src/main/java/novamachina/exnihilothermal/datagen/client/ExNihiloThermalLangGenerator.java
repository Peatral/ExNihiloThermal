package novamachina.exnihilothermal.datagen.client;

import net.minecraft.data.PackOutput;
import novamachina.exnihilothermal.common.init.ExNihiloThermalItems;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants.ModIds;
import novamachina.novacore.data.AbstractLangGenerator;

public class ExNihiloThermalLangGenerator extends AbstractLangGenerator {

  public ExNihiloThermalLangGenerator(PackOutput gen, String locale) {
    super(gen, ModIds.EX_NIHILO_THERMAL, locale);
  }

  @Override
  protected void addTranslations() {
    // Items
    addItem();
  }

  private void addItem() {
    addItemAutoName(ExNihiloThermalItems.BASALZ_DOLL.getId().getPath());
    addItemAutoName(ExNihiloThermalItems.BLIZZ_DOLL.getId().getPath());
    addItemAutoName(ExNihiloThermalItems.BLITZ_DOLL.getId().getPath());
    addItemAutoName(ExNihiloThermalItems.DUST_OBSIDIAN.getId().getPath());
    add("tooltip.doll.basalz", "Add to a barrel of lava to spawn a Basalz");
    add("tooltip.doll.blitz", "Add to a barrel of lava to spawn a Blitz");
    add("tooltip.doll.blizz", "Add to a barrel of water to spawn a Blizz");
  }
}
