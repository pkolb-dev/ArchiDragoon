package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.DeathLinkEvent;

public class DeathLinkListener {
  @ArchipelagoEventListener
  public void onDeathResultEvent(final DeathLinkEvent event) {
    final APContext ctx = APContext.getContext();
    ctx.triggerDeathFromAP(event.source, event.cause);
  }
}
