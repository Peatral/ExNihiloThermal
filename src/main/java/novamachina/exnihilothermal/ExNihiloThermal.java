package novamachina.exnihilothermal;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import novamachina.exnihilothermal.common.init.ExNihiloThermalInitialization;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;
import org.slf4j.Logger;

@Mod(ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL)
public class ExNihiloThermal {

  private static final Logger logger = LogUtils.getLogger();

  public ExNihiloThermal() {
    logger.debug("Starting Ex Nihilo: Sequentia - Thermal Addon");
    ExNihiloThermalInitialization.init(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
