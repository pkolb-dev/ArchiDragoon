package archipelagoon.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SlotData {
  public static final Set<String> EXPECTED_MOD_VERSIONS = new HashSet<>(List.of("0.1.2"));

  @SerializedName("addition_randomizer")
  public int additionRandomizer = 0;

  @SerializedName("random_starting_addition")
  public int randomStartingAddition = 0;

  @SerializedName("lod_completion_condition")
  public int completionCondition = 1;

  @SerializedName("world_version")
  public List<Integer> worldVersion = new ArrayList<>();

  //  @SerializedName("death_link")
  //  public int deathLink = 0;
  @SerializedName("enable_shop_sanity")
  public int enableShopsanity = 0;

  private SlotData() {
  }

  public String getVersion() {
    return String.format("%s.%s.%s", this.worldVersion.get(0), this.worldVersion.get(1), this.worldVersion.get(2));
  }
}