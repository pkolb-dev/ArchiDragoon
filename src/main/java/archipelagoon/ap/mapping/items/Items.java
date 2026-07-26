package archipelagoon.ap.mapping.items;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// PK - use this to look up item ID from AP item id
public final class Items {
  private static final Map<Long, String> ITEM_MAP = new HashMap<>();

  static {
    ITEM_MAP.putAll(Consumables.getStaticMap());
    ITEM_MAP.putAll(Equipment.getStaticMap());
    ITEM_MAP.putAll(Goods.getStaticMap());
    ITEM_MAP.putAll(Additions.getStaticMap());
    ITEM_MAP.putAll(Magic.getIdStrings());
  }

  private Items() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ITEM_MAP);
  }

  public static String getRegistryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
