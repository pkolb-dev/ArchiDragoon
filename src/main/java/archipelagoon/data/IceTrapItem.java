package archipelagoon.data;

import com.google.gson.JsonObject;
import legend.game.combat.bent.BattleEntity27c;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import legend.game.inventory.UseItemResponse;
import legend.game.scripting.FlowControl;
import legend.game.scripting.ScriptState;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import java.util.Optional;
import java.util.function.Function;

import static legend.core.GameEngine.REGISTRIES;

public class IceTrapItem extends Item {
  public IceTrapItem() {
    super(ItemIcon.NONE, 0);
  }

  /** Creates an ice trap that impersonates the item being passed in */
  public ItemStack impersonate(final ItemStack stack) {
    final JsonObject data = new JsonObject();
    data.addProperty("id", stack.getRegistryId().toString());
    data.add("data", stack.getExtraData());

    final ItemStack impersonatedStack = new ItemStack(this, stack.getSize(), stack.getCurrentDurability());
    impersonatedStack.setExtraData(data);
    return impersonatedStack;
  }

  private ItemStack getImpersonatedStack(final ItemStack stack) {
    final JsonObject data = stack.getExtraData();

    if(data == null || !data.has("id")) {
      return null;
    }

    final RegistryDelegate<Item> delegate = REGISTRIES.items.getEntry(data.getAsJsonPrimitive("id").getAsString());

    if(!delegate.isValid()) {
      return null;
    }

    final JsonObject impersonatedData = data.has("data") ? data.getAsJsonObject("data") : null;

    final Item item = delegate.get();
    final ItemStack impersonatedStack = new ItemStack(item, stack.getSize(), stack.getCurrentDurability());
    impersonatedStack.setExtraData(impersonatedData);

    return impersonatedStack;
  }

  private <T> Optional<T> getImpersonatedStackValue(final ItemStack stack, final Function<ItemStack, T> accessor) {
    final ItemStack impersonatedStack = this.getImpersonatedStack(stack);

    if(impersonatedStack == null) {
      return Optional.empty();
    }

    return Optional.of(accessor.apply(impersonatedStack));
  }

  @Override
  public ItemIcon getIcon(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getIcon).orElseGet(() -> super.getIcon(stack));
  }

  @Override
  public String getNameTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getNameTranslationKey).orElseGet(() -> super.getNameTranslationKey(stack));
  }

  @Override
  public String getDescriptionTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getDescriptionTranslationKey).orElseGet(() -> super.getDescriptionTranslationKey(stack));
  }

  @Override
  public String getBattleDescriptionTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getBattleDescriptionTranslationKey).orElseGet(() -> super.getBattleDescriptionTranslationKey(stack));
  }

  @Override
  public int getBuyPrice(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getBuyPrice).orElseGet(() -> super.getBuyPrice(stack));
  }

  @Override
  public int getSellPrice(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getSellPrice).orElseGet(() -> super.getSellPrice(stack));
  }

  @Override
  public int getMaxStackSize(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getMaxSize).orElseGet(() -> super.getMaxStackSize(stack));
  }

  @Override
  public boolean hasDurability(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::hasDurability).orElseGet(() -> super.hasDurability(stack));
  }

  @Override
  public int getMaxDurability(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getMaxDurability).orElseGet(() -> super.getMaxDurability(stack));
  }

  @Override
  public boolean isSame(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, stack::isSameItem).orElseGet(() -> super.isSame(stack));
  }

  @Override
  public boolean canBeUsedNow(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsedNow(location)).orElseGet(() -> super.canBeUsedNow(stack, location));
  }

  @Override
  public void useInMenu(final ItemStack stack, final UseItemResponse response, final int charId) {
    throw new RuntimeException("TODO");
  }

  @Override
  public FlowControl useInBattle(final ItemStack stack, final ScriptState<BattleEntity27c> user, final int targetBentIndex) {
    throw new RuntimeException("TODO");
  }

  @Override
  public boolean canBeUsed(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsed(location)).orElse(false);
  }

  @Override
  public boolean canTarget(final ItemStack stack, final TargetType type) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canTarget(type)).orElse(false);
  }
}
