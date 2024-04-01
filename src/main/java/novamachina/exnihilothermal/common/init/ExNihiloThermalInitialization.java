package novamachina.exnihilothermal.common.init;

import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihilosequentia.world.item.EXNItems;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(
    modid = ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExNihiloThermalInitialization {

  private static final Logger logger = LogUtils.getLogger();

  private ExNihiloThermalInitialization() {}

  @SubscribeEvent
  public static void onServerStart(ServerStartingEvent event) {
    logger.debug("Fired FMLServerStartingEvent");
    enableOres();
  }

  public static void init(@Nonnull final IEventBus modEventBus) {
    logger.debug("Initializing modded items");
    ExNihiloThermalItems.init(modEventBus);
  }

  private static void enableOres() {
    //    ExNihiloItems.COPPER.setEnabled(true);
    EXNItems.SILVER.setEnabled(true);
    EXNItems.TIN.setEnabled(true);
    EXNItems.LEAD.setEnabled(true);
    EXNItems.NICKEL.setEnabled(true);
  }
}
