package archipelagoon.randomizer;

import archipelagoon.screens.MessageScreen;
import legend.game.inventory.screens.MenuStack;

import java.util.ArrayDeque;
import java.util.Queue;

import static legend.game.sound.Audio.playMenuSound;

public final class MessageManager {
  private static final MessageManager INSTANCE = new MessageManager();
  private final Queue<String> messageQueue = new ArrayDeque<>();
  private final MenuStack menuStack = new MenuStack();
  private final Object lock = new Object();
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
        this.menuStack.reset();
        return;
      }

      this.messageActive = true;
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
    this.menuStack.render();
  }
}
