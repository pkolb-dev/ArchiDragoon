package archipelagoon.data.items;

import com.google.gson.JsonObject;
import legend.game.combat.bent.BattleEntity27c;
import legend.game.i18n.I18n;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import legend.game.inventory.UseItemResponse;
import legend.game.scripting.ScriptState;
import legend.game.types.ActiveStatsa0;
import legend.game.types.CharacterData2c;
import legend.lodmod.items.BattleItem;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import java.util.Optional;
import java.util.function.Function;

import static legend.core.GameEngine.REGISTRIES;
import static legend.game.SItem.loadCharacterStats;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.game.Scus94491BpeSegment_800b.stats_800be5f8;

public class IceTrapItem extends BattleItem {
  public IceTrapItem() {
    super(ItemIcon.NONE, 0);
  }

  /**
   * Creates an ice trap that impersonates the item being passed in
   */
  public ItemStack impersonate(final Item item) {
    return this.impersonate(new ItemStack(item));
  }

  /**
   * Creates an ice trap that impersonates the item being passed in
   */
  public ItemStack impersonate(final ItemStack stack) {
    final JsonObject data = new JsonObject();
    data.addProperty("id", stack.getRegistryId().toString());
    data.addProperty("has_durability", stack.hasDurability());
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

    final JsonObject impersonatedData = data.has("data") && data.get("data") instanceof JsonObject ? data.getAsJsonObject("data") : null;

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
    // Reading the stack from our json data has to call this method. If we were to try to
    // read this from the impersonated stack it would cause a stack overflow.

    final JsonObject extraData = stack.getExtraData();

    if(extraData == null || !extraData.has("has_durability")) {
      return super.hasDurability(stack);
    }

    return extraData.getAsJsonPrimitive("has_durability").getAsBoolean();
  }

  @Override
  public int getMaxDurability(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getMaxDurability).orElseGet(() -> super.getMaxDurability(stack));
  }

  // Breaks taking item from inventory
  //  @Override
  //  public boolean isSame(final ItemStack stack) {
  //    return this.getImpersonatedStackValue(stack, stack::isSameItem).orElseGet(() -> super.isSame(stack));
  //  }

  @Override
  public boolean canBeUsed(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsed(location)).orElse(false);
  }

  @Override
  public boolean canBeUsedNow(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsedNow(location)).orElseGet(() -> super.canBeUsedNow(stack, location));
  }

  @Override
  public boolean canTarget(final ItemStack stack, final TargetType type) {
    if(type == TargetType.INSTANT) {
      return true;
    }

    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canTarget(type)).orElse(false);
  }

  @Override
  public void useInMenu(final ItemStack stack, final UseItemResponse response, final int charId) {
    final CharacterData2c character = gameState_800babc8.charData_32c[charId];
    final ActiveStatsa0 stats = stats_800be5f8[charId];
    final int hpToTake = stats.maxHp_66 / 10;

    character.hp_08 = Math.max(1, character.hp_08 - hpToTake);

    loadCharacterStats();
    response.success(I18n.translate(this.getTranslationKey("use")));
  }

  @Override
  protected int getUseItemScriptEntrypoint() {
    return 34;
  }

  @Override
  protected void useItemScriptLoaded(final ScriptState<BattleEntity27c> user, final int targetBentIndex) {
    user.setStor(8, 0xd7fff5); // Colour
    user.setStor(28, user.index);
    user.setStor(30, user.index);
  }
}
