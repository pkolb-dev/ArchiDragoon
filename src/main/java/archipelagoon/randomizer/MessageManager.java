package archipelagoon.randomizer;

import archipelagoon.screens.MessageScreen;
import legend.game.inventory.WhichMenu;
import legend.game.inventory.screens.MenuStack;

import java.util.ArrayDeque;
import java.util.Queue;

import static legend.game.Menus.whichMenu_800bdc38;
import static legend.game.Text.textZ_800bdf00;
import static legend.game.sound.Audio.playMenuSound;

public final class MessageManager {
  private static final MessageManager INSTANCE = new MessageManager();
  private final Queue<String> messageQueue = new ArrayDeque<>();
  private final Object lock = new Object();
  private MenuStack menuStack;
  private boolean messageActive;

  private MessageManager() {
  }

  public static MessageManager getInstance() {
    return INSTANCE;
  }

  public void displayMessage(final String message) {
    if(message.isEmpty()) {
      return;
    }

    synchronized(this.lock) {
      this.messageQueue.add(message);
      this.tryShowNextMessage();
    }
  }

  private void tryShowNextMessage() {
    synchronized(this.lock) {
      if(this.messageActive) {
        return;
      }

      if(this.messageQueue.isEmpty()) {
        if(whichMenu_800bdc38 == WhichMenu.NONE_0) {
          textZ_800bdf00 = 13;
        }

        this.menuStack = null;
        return;
      }

      this.messageActive = true;
      if(this.menuStack == null) {
        this.menuStack = new MenuStack();
      }
      playMenuSound(4);
      final MessageScreen screen = new MessageScreen(this.messageQueue.poll(), _ -> {
        synchronized(this.lock) {
          this.messageActive = false;
          this.tryShowNextMessage();
        }
      });

      this.menuStack.pushScreen(screen);
    }
  }

  public void render() {
    if(this.menuStack != null) {
      this.menuStack.render();
    }
  }
}
