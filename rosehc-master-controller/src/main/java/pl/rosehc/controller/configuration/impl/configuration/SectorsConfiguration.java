package pl.rosehc.controller.configuration.impl.configuration;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pl.rosehc.controller.configuration.ConfigurationData;
import pl.rosehc.controller.sector.SectorType;
import pl.rosehc.controller.wrapper.global.BarColorWrapper;
import pl.rosehc.controller.wrapper.global.BarStyleWrapper;

public final class SectorsConfiguration extends ConfigurationData {

  @SerializedName("sectors")
  public Map<String, SectorWrapper> sectorMap = new LinkedHashMap<String, SectorWrapper>() {{
    for (int index = 0; index < 3; index++) {
      this.put("spawn_" + (index + 1), createSectorWrapper(SectorType.SPAWN, -100, 100, -100, 100));
    }

    this.put("s1", createSectorWrapper(SectorType.GAME, -100, 1000, 100, 1000));
    this.put("w1", createSectorWrapper(SectorType.GAME, -1000, -100, -100, 1000));
    this.put("e1", createSectorWrapper(SectorType.GAME, 100, 1000, -1000, 100));
    this.put("n1", createSectorWrapper(SectorType.GAME, -1000, 100, -1000, -100));
  }};
  @SerializedName("border_size")
  public int borderSize = 1000;

  @SerializedName("proxies")
  public List<Integer> proxyList = Arrays.asList(1, 2);

  @SerializedName("messages")
  public MessagesWrapper messagesWrapper = new MessagesWrapper();
  @SerializedName("border_bar_style")
  public BarStyleWrapper borderBarStyleWrapper = BarStyleWrapper.SEGMENTED_10;
  @SerializedName("border_bar_color")
  public BarColorWrapper borderBarColorWrapper = BarColorWrapper.PINK;

  private static SectorWrapper createSectorWrapper(final SectorType type, final int minX,
      final int maxX, final int minZ, final int maxZ) {
    SectorWrapper wrapper = new SectorWrapper();
    wrapper.type = type;
    wrapper.minX = minX;
    wrapper.maxX = maxX;
    wrapper.minZ = minZ;
    wrapper.maxZ = maxZ;
    return wrapper;
  }

  public static final class MessagesWrapper {

    // SPIGOT
    public String sectorIsOffline = "&cSektor, na kt??ry chcesz si?? po????czy?? jest aktualnie offline!";
    public String sectorIsHeavilyLoaded = "&cSektor, na kt??ry chcesz si?? po????czy?? jest aktualnie przeci????ony";
    public String cannotSynchronizeYourData = "&cWystapi?? niespodziewany problem podczas pr??by synchronizacji twoich danych.";
    public String connectingInfo = "&aPomy??lnie zsynchronizowano twoje dane! ????cz?? z sektorem {SECTOR_NAME}";
    public String sectorNotFound = "&cNie odnaleziono sektora na tej lokalizacji.";
    public String cannotBreakBlocksOnSpawn = "&cNie mo??esz niszczy?? blok??w na spawnie!";
    public String cannotBreakBlocksInEnd = "&cNie mo??esz niszczy?? blok??w w endzie!";
    public String cannotBreakBlocksNearSector = "&cNie mo??esz niszczy?? blok??w przy granicy sektora!";
    public String cannotPlaceBlocksOnSpawn = "&cNie mo??esz stawia?? blok??w na spawnie!";
    public String cannotPlaceBlocksInEnd = "&cNie mo??esz stawia?? blok??w w endzie!";
    public String cannotPlaceBlocksNearSector = "&cNie mo??esz stawia?? blok??w przy granicy sektora!";
    public String cannotFillTheBucketOnSpawn = "&cNie mo??esz nape??nia?? wiaderka na spawnie!";
    public String cannotFillTheBucketNearSector = "&cNie mo??esz nape??nia?? wiaderka przy granicy sektora!";
    public String cannotEmptyTheBucketOnSpawn = "&cNie mo??esz opr????nia?? wiaderka na spawnie!";
    public String cannotEmptyTheBucketNearSector = "&cNie mo??esz opr????nia?? wiaderka przy granicy sektora!";
    public String playerIsAlreadyOnlineOnThisSector = "&cPodany gracz jest ju?? online na tym sektorze!";
    public String playerProfileNotFound = "&cNie posiadasz profilu.";
    public String nearSectorBossBarTitle = "&dZbli??asz si?? do granicy sektora &8| &7{DISTANCE}m";

    // PROXY
    public String playerIsAlreadyOnline = "&cGracz o tym nicku jest ju?? online!";
  }

  public static final class SectorWrapper {

    public SectorType type;
    public int minX, maxX;
    public int minZ, maxZ;
  }
}
