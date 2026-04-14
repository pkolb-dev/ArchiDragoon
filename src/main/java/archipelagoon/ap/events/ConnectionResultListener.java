package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.data.SlotData;
import archipelagoon.screens.ArchipelagoConnectScreen;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;
import legend.core.GameEngine;
import legend.game.SItem;

import java.math.BigInteger;

import static legend.game.FullScreenEffects.startFadeEffect;

public class ConnectionResultListener {

  @ArchipelagoEventListener
  public void onConnectionResult(final ConnectionResultEvent event) {
    if(event.getResult() == null) {
      return;
    }

    // TODO - I18n these strings
    final String msg = switch(event.getResult()) {
      case SlotAlreadyTaken -> "Slot already in use.";
      case Success -> "Connection Successful.";
      case InvalidSlot -> "Invalid Slot Name.\nPlease make sure\nyou typed it correctly.";
      case InvalidPassword -> "Invalid Password";
      case IncompatibleVersion -> "Server Rejected\nour connection\ndue to an\nincompatible\ncommunication protocol.";
      case InvalidGame -> "Invalid Game.\nCheck your slot.";
      default -> "Unknown Error";
    };

    final APContext ctx = APContext.getContext();
    if(event.getResult() != ConnectionResult.Success) {
      SItem.menuStack.pushScreen(new ArchipelagoConnectScreen(GameEngine.CONFIG, () -> {
        startFadeEffect(2, 10);
        SItem.menuStack.popScreen();
      }));

      ctx.displayMessage(msg);
      return;
    }

    final SlotData slotData = event.getSlotData(SlotData.class);

    if(!SlotData.EXPECTED_MOD_VERSIONS.contains(slotData.getVersion())) {
      ctx.displayMessage("Unexpected APWorld Version.\nGenerated world version:\n" +
        slotData.getVersion());
      ctx.disconnect();
      return;
    }

    long seedName = new BigInteger(event.getSeedName()).longValue();
    seedName += event.getSlot();

    slotData.slotSeed = seedName;

    ctx.setSlotData(slotData);
    ctx.retrieveLocations();
  }
}
