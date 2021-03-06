package pl.rosehc.controller.configuration.impl.configuration;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pl.rosehc.controller.configuration.ConfigurationData;
import pl.rosehc.controller.configuration.impl.configuration.PlatformConfiguration.CustomItemsWrapper.CustomCraftingWrapper.CraftingItemWrapper;
import pl.rosehc.controller.configuration.impl.configuration.PlatformConfiguration.KitWrapper.KitItemWrapper;
import pl.rosehc.controller.wrapper.global.BarColorWrapper;
import pl.rosehc.controller.wrapper.global.BarStyleWrapper;
import pl.rosehc.controller.wrapper.global.LocationWrapper;
import pl.rosehc.controller.wrapper.global.PotionEffectWrapper;
import pl.rosehc.controller.wrapper.platform.PlatformChatStatusType;
import pl.rosehc.controller.wrapper.platform.PlatformEndPortalPointWrapper;
import pl.rosehc.controller.wrapper.platform.PlatformUserDepositItemTypeWrapper;
import pl.rosehc.controller.wrapper.platform.gui.deposit.PlatformDepositItemSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.deposit.PlatformDepositWithdrawAllSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.drop.PlatformDropPreviewItemGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.drop.PlatformDropStoneDropCobbleStoneItemGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.drop.PlatformDropStoneDropItemGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.kit.PlatformKitListPreviewGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.kit.PlatformKitPreviewGivenItemGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.kit.PlatformKitPreviewPickupGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.other.PlatformChannelSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.other.PlatformChatSettingSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.other.PlatformCrowbarTakeoverSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.other.PlatformDiscoEffectTypeSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.platform.gui.other.PlatformHomeSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.spigot.DefaultSpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.spigot.SpigotGuiElementWrapper;
import pl.rosehc.controller.wrapper.spigot.SpigotGuiEnchantmentWrapper;
import pl.rosehc.controller.wrapper.spigot.SpigotGuiWrapper;

public final class PlatformConfiguration extends ConfigurationData {

  @SerializedName("messages")
  public MessagesWrapper messagesWrapper = new MessagesWrapper();
  @SerializedName("ranks")
  public List<RankWrapper> rankList = Collections.singletonList(
      createRankWrapper("gracz", "&7", "&f", "&7", "&f", Collections.emptyList(), 1, true));
  @SerializedName("proxy_whitelist")
  public ProxyWhitelistWrapper proxyWhitelistWrapper = new ProxyWhitelistWrapper();
  @SerializedName("proxy_motd")
  public ProxyMotdWrapper proxyMotdWrapper = new ProxyMotdWrapper();
  @SerializedName("spawn_location")
  public LocationWrapper spawnLocationWrapper = new LocationWrapper("world", 0D, 0D, 0D, 0F, 0F);
  @SerializedName("case_drops")
  public List<MagicCaseItemWrapper> magicCaseItemWrapperList = Arrays.asList(
      createMagicCaseItemWrapper(
          "DIAMOND",
          "&cDiament",
          Arrays.asList(
              "&cTo jest",
              "&aPrzykladowy item"
          ),
          Arrays.asList(
              createEnchantmentWrapper("DAMAGE_ALL", 5),
              createEnchantmentWrapper("DURABILITY", 1337)
          ),
          100D,
          (short) 0,
          1,
          1,
          null
      ),
      createMagicCaseItemWrapper(
          "GOLD_INGOT",
          "&aO kurwa pierdolne chyba",
          Arrays.asList(
              "&cTo jest",
              "&aPrzykladowy item"
          ),
          Arrays.asList(
              createEnchantmentWrapper("DAMAGE_ALL", 5),
              createEnchantmentWrapper("DURABILITY", 2137)
          ),
          100D,
          (short) 0,
          1,
          2,
          null
      )
  );
  @SerializedName("cobbleX_drops")
  public List<CobbleXItemWrapper> cobbleXItemWrappers = Arrays.asList(
      createCobbleXItemWrapper(
          "DIAMOND",
          "&cDiament",
          Arrays.asList(
              "&cTo jest",
              "&aPrzykladowy item"
          ),
          Arrays.asList(
              createEnchantmentWrapper("DAMAGE_ALL", 5),
              createEnchantmentWrapper("DURABILITY", 1337)
          ),
          (short) 0,
          1,
          1
      ),
      createCobbleXItemWrapper(
          "GOLD_INGOT",
          "&aO kurwa pierdolne chyba",
          Arrays.asList(
              "&cTo jest",
              "&aPrzykladowy item"
          ),
          Arrays.asList(
              createEnchantmentWrapper("DAMAGE_ALL", 5),
              createEnchantmentWrapper("DURABILITY", 2137)
          ),
          (short) 0,
          1,
          2
      )
  );

  @SerializedName("inventories")
  public Map<String, SpigotGuiWrapper> inventoryMap = new HashMap<String, SpigotGuiWrapper>() {{
    this.put("channel", createChannelGuiWrapper());
    this.put("home", createHomeGuiWrapper());
    this.put("kit_list", createKitListGuiWrapper());
    this.put("kit_preview_SAMPLE1", createKitPreviewGuiWrapper());
    this.put("kit_preview_SAMPLE2", createKitPreviewGuiWrapper());
    this.put("deposit", createDepositGuiWrapper());
    this.put("crowbar_takeover", createCrowbarTakeoverGuiWrapper());
    this.put("chat_settings", createChatSettingsGuiWrapper());
    this.put("drop_main", createDropMainGuiWrapper());
    this.put("drop_stone", createDropStoneGuiWrapper());
    this.put("drop_cobbleX", createDropPremiumItemGuiWrapper("COBBLEX"));
    this.put("drop_magicCase", createDropPremiumItemGuiWrapper("MAGICZNA SKRZYNKA"));
    this.put("disco", createDiscoEffectSelectionGuiWrapper());
  }};

  @SerializedName("kits")
  public List<KitWrapper> kitWrapperList = Arrays.asList(
      createKitWrapper(
          "SAMPLE1",
          null,
          Collections.singletonList(
              createKitItemWrapper(
                  1,
                  "DIAMOND",
                  "&cDiament",
                  Collections.emptyList(),
                  Collections.emptyList(),
                  (short) 0,
                  1
              )
          ),
          "10m"
      ),
      createKitWrapper(
          "SAMPLE2",
          null,
          Collections.singletonList(
              createKitItemWrapper(
                  1,
                  "DIAMOND",
                  "&cDiament ale magiczny taki",
                  Collections.emptyList(),
                  Collections.singletonList(
                      createEnchantmentWrapper(
                          "DAMAGE_ALL",
                          5
                      )
                  ),
                  (short) 0,
                  1
              )
          ),
          "2h4m"
      )
  );
  @SerializedName("limits")
  public Map<PlatformUserDepositItemTypeWrapper, Integer> limitMap = new LinkedHashMap<PlatformUserDepositItemTypeWrapper, Integer>() {{
    this.put(PlatformUserDepositItemTypeWrapper.GOLDEN_HEADS, 1);
    this.put(PlatformUserDepositItemTypeWrapper.GOLDEN_APPLES, 12);
    this.put(PlatformUserDepositItemTypeWrapper.ENDER_PEARLS, 3);
    this.put(PlatformUserDepositItemTypeWrapper.SNOWBALLS, 8);
    this.put(PlatformUserDepositItemTypeWrapper.FISHING_RODS, 1);
  }};

  @SerializedName("slots")
  public SlotWrapper slotWrapper = new SlotWrapper();
  @SerializedName("spawn_scoreboard")
  public SpawnScoreboardProfileWrapper spawnScoreboardProfileWrapper = new SpawnScoreboardProfileWrapper();
  @SerializedName("end_scoreboard")
  public EndScoreboardProfileWrapper endScoreboardProfileWrapper = new EndScoreboardProfileWrapper();
  @SerializedName("blocked_commands")
  public BlockedCommandsWrapper blockedCommandsWrapper = new BlockedCommandsWrapper();
  @SerializedName("special_boss_bar")
  public SpecialBossBarWrapper specialBossBarWrapper;
  @SerializedName("custom_commands")
  public List<SimpleCustomCommandWrapper> simpleCustomCommandWrapperList = Arrays.asList(
      createSimpleCustomCommandWrapper(
          "sample1",
          "Przyk??adowa Komenda 1",
          Arrays.asList(
              "sample1_alias1",
              "sample1_alias2"
          ),
          Arrays.asList(
              "&cSample Message",
              "&aSample Message {PLAYER_NAME}"
          )
      ),
      createSimpleCustomCommandWrapper(
          "sample2",
          "Przyk??adowa Komenda 2",
          Arrays.asList(
              "sample2_alias1",
              "sample2_alias2"
          ),
          Arrays.asList(
              "&dSample Message!!!!!",
              "&5Sample Message {PLAYER_NAME}!!!!"
          )
      )
  );
  @SerializedName("custom_items")
  public CustomItemsWrapper customItemsWrapper = new CustomItemsWrapper();
  @SerializedName("enchantment_blockades")
  public EnchantmentBlockadesWrapper enchantmentBlockadesWrapper = new EnchantmentBlockadesWrapper();
  @SerializedName("chat_status_type")
  public PlatformChatStatusType chatStatusType = PlatformChatStatusType.ENABLED;
  @SerializedName("end_portal_points")
  public List<PlatformEndPortalPointWrapper> endPortalPointWrapperList = new ArrayList<>();
  @SerializedName("drop")
  public DropSettingsWrapper dropSettingsWrapper = new DropSettingsWrapper();
  @SerializedName("anti_grief")
  public AntiGriefSettingsWrapper antiGriefSettingsWrapper = new AntiGriefSettingsWrapper();
  @SerializedName("auto_messages")
  public AutoMessagesSettingsWrapper autoMessagesSettingsWrapper = new AutoMessagesSettingsWrapper();
  @SerializedName("end_min_random_coordinate")
  public int endMinRandCoordinate = -100;
  @SerializedName("end_max_random_coordinate")
  public int endMaxRandomCoordinate = 100;

  @SerializedName("combat_time")
  public String combatTime = "21s";
  @SerializedName("death_kicks")
  public boolean deathKicksState = true;
  @SerializedName("server_freeze")
  public boolean serverFreezeState;

  private static SpigotGuiWrapper createChatSettingsGuiWrapper() {
    final SpigotGuiWrapper chatSettingsGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformChatSettingSpigotGuiElementWrapper globalChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper(), itemShopChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper();
    final PlatformChatSettingSpigotGuiElementWrapper killsChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper(), deathsChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper();
    final PlatformChatSettingSpigotGuiElementWrapper casesChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper(), achievementsChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper();
    final PlatformChatSettingSpigotGuiElementWrapper rewardsChatSettingElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper(), privateMessagesChatSettingsElementWrapper = new PlatformChatSettingSpigotGuiElementWrapper();
    globalChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    globalChatSettingElementWrapper.name = "&5&lWIADOMO??CI GLOBALNE";
    globalChatSettingElementWrapper.slot = 10;
    itemShopChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    itemShopChatSettingElementWrapper.name = "&6&lWIADOMO??CI Z ITEMSHOPU";
    itemShopChatSettingElementWrapper.slot = 12;
    killsChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    killsChatSettingElementWrapper.name = "&e&lWIADOMO??CI O ZAB??JSTWACH";
    killsChatSettingElementWrapper.slot = 14;
    deathsChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    deathsChatSettingElementWrapper.name = "&e&lWIADOMO??CI O ??MIERCIACH";
    deathsChatSettingElementWrapper.slot = 16;
    casesChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    casesChatSettingElementWrapper.name = "&d&lWIADOMO??CI O DROPIE SKRZYNEK";
    casesChatSettingElementWrapper.slot = 29;
    achievementsChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    achievementsChatSettingElementWrapper.name = "&f&lWIADOMO??CI O ODEBRANIU OSI??GNI????";
    achievementsChatSettingElementWrapper.slot = 31;
    rewardsChatSettingElementWrapper.material = "STAINED_GLASS_PANE";
    rewardsChatSettingElementWrapper.name = "&9&lWIADOMO??CI O ODEBRANIU NAGR??D";
    rewardsChatSettingElementWrapper.slot = 32;
    privateMessagesChatSettingsElementWrapper.material = "STAINED_GLASS_PANE";
    privateMessagesChatSettingsElementWrapper.name = "&9&lWIADOMO??CI O ODEBRANIU NAGR??D";
    privateMessagesChatSettingsElementWrapper.slot = 33;
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    chatSettingsGuiWrapper.inventoryName = "&dUstawienia czatu";
    chatSettingsGuiWrapper.inventorySize = 45;
    chatSettingsGuiWrapper.fillElement = fillElementWrapper;
    chatSettingsGuiWrapper.elements = new LinkedHashMap<>();
    chatSettingsGuiWrapper.elements.put("global", globalChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("itemShop", itemShopChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("kills", killsChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("deaths", deathsChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("cases", casesChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("achievements", achievementsChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("rewards", rewardsChatSettingElementWrapper);
    chatSettingsGuiWrapper.elements.put("privateMessages",
        privateMessagesChatSettingsElementWrapper);
    return chatSettingsGuiWrapper;
  }

  private static SpigotGuiWrapper createDepositGuiWrapper() {
    final SpigotGuiWrapper depositGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformDepositItemSpigotGuiElementWrapper goldenHeadsElementWrapper = new PlatformDepositItemSpigotGuiElementWrapper();
    final PlatformDepositItemSpigotGuiElementWrapper goldenApplesElementWrapper = new PlatformDepositItemSpigotGuiElementWrapper();
    //noinspection SpellCheckingInspection
    final PlatformDepositItemSpigotGuiElementWrapper enderPearlsElementWrapper = new PlatformDepositItemSpigotGuiElementWrapper();
    final PlatformDepositItemSpigotGuiElementWrapper snowballsElementWrapper = new PlatformDepositItemSpigotGuiElementWrapper();
    final PlatformDepositItemSpigotGuiElementWrapper fishingRodsElementWrapper = new PlatformDepositItemSpigotGuiElementWrapper();
    final PlatformDepositWithdrawAllSpigotGuiElementWrapper withdrawAllElementWrapper = new PlatformDepositWithdrawAllSpigotGuiElementWrapper();
    goldenHeadsElementWrapper.name = "&6&lGHEADY";
    goldenHeadsElementWrapper.slot = 11;
    goldenApplesElementWrapper.name = "&e&lREFILE";
    goldenApplesElementWrapper.slot = 13;
    enderPearlsElementWrapper.name = "&5&lPER??Y";
    enderPearlsElementWrapper.slot = 15;
    snowballsElementWrapper.name = "&f&l??NIE??KI";
    snowballsElementWrapper.slot = 21;
    fishingRodsElementWrapper.name = "&a&lW??DKI";
    fishingRodsElementWrapper.slot = 23;
    withdrawAllElementWrapper.material = "HOPPER";
    withdrawAllElementWrapper.name = "&dWyp??a?? do limitu";
    withdrawAllElementWrapper.slot = 40;
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    depositGuiWrapper.inventoryName = "&dDepozyt";
    depositGuiWrapper.inventorySize = 45;
    depositGuiWrapper.fillElement = fillElementWrapper;
    depositGuiWrapper.elements = new LinkedHashMap<>();
    depositGuiWrapper.elements.put("itemGOLDEN_HEADS", goldenHeadsElementWrapper);
    depositGuiWrapper.elements.put("itemGOLDEN_APPLES", goldenApplesElementWrapper);
    depositGuiWrapper.elements.put("itemENDER_PEARLS", enderPearlsElementWrapper);
    depositGuiWrapper.elements.put("itemSNOWBALLS", snowballsElementWrapper);
    depositGuiWrapper.elements.put("itemFISHING_RODS", fishingRodsElementWrapper);
    depositGuiWrapper.elements.put("withdraw_all", withdrawAllElementWrapper);
    return depositGuiWrapper;
  }

  private static SpigotGuiWrapper createDropStoneGuiWrapper() {
    final SpigotGuiWrapper dropStoneInventoryWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformDropStoneDropItemGuiElementWrapper diamondDropItemElementWrapper = new PlatformDropStoneDropItemGuiElementWrapper();
    final PlatformDropStoneDropCobbleStoneItemGuiElementWrapper cobbleStoneElementWrapper = new PlatformDropStoneDropCobbleStoneItemGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper enableAllElementWrapper = new DefaultSpigotGuiElementWrapper(), disableAllElementWrapper = new DefaultSpigotGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper backElementWrapper = new DefaultSpigotGuiElementWrapper();
    enableAllElementWrapper.name = "&aKliknij, aby w????czy?? wszystkie dropy!";
    enableAllElementWrapper.material = "INK_SACK";
    enableAllElementWrapper.data = (byte) 10;
    enableAllElementWrapper.slot = 24;
    disableAllElementWrapper.name = "&cKliknij, aby wy????czy?? wszystkie dropy!";
    disableAllElementWrapper.material = "INK_SACK";
    disableAllElementWrapper.data = (byte) 1;
    disableAllElementWrapper.slot = 25;
    backElementWrapper.name = "&cKliknij, aby powr??ci?? do menu g????wnego!";
    backElementWrapper.material = "FENCE_GATE";
    backElementWrapper.slot = 26;
    diamondDropItemElementWrapper.name = "&9Diament";
    cobbleStoneElementWrapper.slot = 23;
    //noinspection DuplicatedCode
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    dropStoneInventoryWrapper.inventoryName = "&dDROP (STONE)";
    dropStoneInventoryWrapper.inventorySize = 27;
    dropStoneInventoryWrapper.fillElement = fillElementWrapper;
    dropStoneInventoryWrapper.elements = new LinkedHashMap<>();
    dropStoneInventoryWrapper.elements.put("itemDIAMENT", diamondDropItemElementWrapper);
    dropStoneInventoryWrapper.elements.put("cobbleStone", cobbleStoneElementWrapper);
    dropStoneInventoryWrapper.elements.put("enable_all", enableAllElementWrapper);
    dropStoneInventoryWrapper.elements.put("disable_all", disableAllElementWrapper);
    dropStoneInventoryWrapper.elements.put("back", backElementWrapper);
    return dropStoneInventoryWrapper;
  }

  private static SpigotGuiWrapper createDiscoEffectSelectionGuiWrapper() {
    final SpigotGuiWrapper discoEffectSelectionGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformDiscoEffectTypeSpigotGuiElementWrapper grayEffectTypeElementWrapper = new PlatformDiscoEffectTypeSpigotGuiElementWrapper(), ultraEffectTypeElementWrapper = new PlatformDiscoEffectTypeSpigotGuiElementWrapper();
    final PlatformDiscoEffectTypeSpigotGuiElementWrapper smoothEffectTypeElementWrapper = new PlatformDiscoEffectTypeSpigotGuiElementWrapper(), randomEffectTypeElementWrapper = new PlatformDiscoEffectTypeSpigotGuiElementWrapper();
    grayEffectTypeElementWrapper.material = "LEATHER_HELMET";
    grayEffectTypeElementWrapper.name = "&8&lGRAY";
    grayEffectTypeElementWrapper.leatherArmorColor = "#191919";
    grayEffectTypeElementWrapper.slot = 10;
    ultraEffectTypeElementWrapper.material = "LEATHER_HELMET";
    ultraEffectTypeElementWrapper.name = "&d&lULTRA";
    ultraEffectTypeElementWrapper.leatherArmorColor = "#C5596C";
    ultraEffectTypeElementWrapper.slot = 12;
    smoothEffectTypeElementWrapper.material = "LEATHER_HELMET";
    smoothEffectTypeElementWrapper.name = "&4&lSMOOTH";
    smoothEffectTypeElementWrapper.leatherArmorColor = "#993333";
    smoothEffectTypeElementWrapper.slot = 14;
    randomEffectTypeElementWrapper.material = "LEATHER_HELMET";
    randomEffectTypeElementWrapper.name = "&5&lRANDOM";
    randomEffectTypeElementWrapper.leatherArmorColor = "#334CB2";
    randomEffectTypeElementWrapper.slot = 16;
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    discoEffectSelectionGuiWrapper.inventoryName = "&dPrzejmowanie sejfu";
    discoEffectSelectionGuiWrapper.inventorySize = 27;
    discoEffectSelectionGuiWrapper.fillElement = fillElementWrapper;
    discoEffectSelectionGuiWrapper.elements = new LinkedHashMap<>();
    discoEffectSelectionGuiWrapper.elements.put("GRAY", grayEffectTypeElementWrapper);
    discoEffectSelectionGuiWrapper.elements.put("ULTRA", ultraEffectTypeElementWrapper);
    discoEffectSelectionGuiWrapper.elements.put("SMOOTH", smoothEffectTypeElementWrapper);
    discoEffectSelectionGuiWrapper.elements.put("RANDOM", randomEffectTypeElementWrapper);
    return discoEffectSelectionGuiWrapper;
  }

  private static SpigotGuiWrapper createHomeGuiWrapper() {
    final SpigotGuiWrapper homeGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformHomeSpigotGuiElementWrapper firstHomeElementWrapper = new PlatformHomeSpigotGuiElementWrapper();
    final PlatformHomeSpigotGuiElementWrapper secondHomeElementWrapper = new PlatformHomeSpigotGuiElementWrapper();
    final PlatformHomeSpigotGuiElementWrapper thirdHomeElementWrapper = new PlatformHomeSpigotGuiElementWrapper();
    final PlatformHomeSpigotGuiElementWrapper fourthHomeElementWrapper = new PlatformHomeSpigotGuiElementWrapper();
    firstHomeElementWrapper.material = "INK_SACK";
    firstHomeElementWrapper.name = "&7Domek: &5#1";
    firstHomeElementWrapper.slot = 10;
    secondHomeElementWrapper.material = "INK_SACK";
    secondHomeElementWrapper.name = "&7Domek: &5#2";
    secondHomeElementWrapper.slot = 12;
    thirdHomeElementWrapper.material = "INK_SACK";
    thirdHomeElementWrapper.name = "&7Domek: &5#3";
    thirdHomeElementWrapper.slot = 14;
    fourthHomeElementWrapper.material = "INK_SACK";
    fourthHomeElementWrapper.name = "&7Domek: &5#4";
    fourthHomeElementWrapper.slot = 16;
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    homeGuiWrapper.inventoryName = "&dMenu zarz??dzania domami";
    homeGuiWrapper.inventorySize = 27;
    homeGuiWrapper.fillElement = fillElementWrapper;
    homeGuiWrapper.elements = new LinkedHashMap<>();
    homeGuiWrapper.elements.put("home1", firstHomeElementWrapper);
    homeGuiWrapper.elements.put("home2", secondHomeElementWrapper);
    homeGuiWrapper.elements.put("home3", thirdHomeElementWrapper);
    homeGuiWrapper.elements.put("home4", fourthHomeElementWrapper);
    return homeGuiWrapper;
  }

  private static SpigotGuiWrapper createDropPremiumItemGuiWrapper(final String name) {
    final SpigotGuiWrapper dropPremiumItemGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper backElementWrapper = new DefaultSpigotGuiElementWrapper();
    backElementWrapper.name = "&cKliknij, aby powr??ci?? do menu g????wnego!";
    backElementWrapper.material = "FENCE_GATE";
    backElementWrapper.slot = 53;
    dropPremiumItemGuiWrapper.inventoryName = "&dDROP (" + name + ")";
    dropPremiumItemGuiWrapper.inventorySize = 54;
    dropPremiumItemGuiWrapper.elements = new LinkedHashMap<>();
    dropPremiumItemGuiWrapper.elements.put("back", backElementWrapper);
    int index = 0;
    for (final int slot : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 17, 18, 19, 25, 26, 27,
        28, 34, 35, 36, 37, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52}) {
      final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
      fillElementWrapper.slot = slot;
      fillElementWrapper.material = "STAINED_GLASS_PANE";
      fillElementWrapper.name = "&8#";
      fillElementWrapper.data = 15;
      dropPremiumItemGuiWrapper.elements.put("glass" + (index++), fillElementWrapper);
    }

    final PlatformDropPreviewItemGuiElementWrapper firstItemPreviewElementWrapper = new PlatformDropPreviewItemGuiElementWrapper(), secondItemPreviewElementWrapper = new PlatformDropPreviewItemGuiElementWrapper();
    firstItemPreviewElementWrapper.slot = 11;
    secondItemPreviewElementWrapper.slot = 12;
    dropPremiumItemGuiWrapper.elements.put("item0", firstItemPreviewElementWrapper);
    dropPremiumItemGuiWrapper.elements.put("item1", secondItemPreviewElementWrapper);
    return dropPremiumItemGuiWrapper;
  }

  private static SpigotGuiWrapper createDropMainGuiWrapper() {
    final SpigotGuiWrapper dropMainInventoryGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper stoneDropItemElementWrapper = new DefaultSpigotGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper magicCaseItemElementWrapper = new DefaultSpigotGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper cobbleXItemElementWrapper = new DefaultSpigotGuiElementWrapper();
    stoneDropItemElementWrapper.material = "STONE";
    stoneDropItemElementWrapper.name = "&7&lDrop ze stone";
    stoneDropItemElementWrapper.slot = 11;
    magicCaseItemElementWrapper.material = "CHEST";
    magicCaseItemElementWrapper.name = "&5&lDrop z magicznych skrzynek";
    magicCaseItemElementWrapper.slot = 13;
    cobbleXItemElementWrapper.material = "MOSSY_COBBLESTONE";
    cobbleXItemElementWrapper.name = "&e&lDrop z CobbleX";
    cobbleXItemElementWrapper.slot = 15;
    //noinspection DuplicatedCode
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    dropMainInventoryGuiWrapper.inventoryName = "&dDROP (MENU)";
    dropMainInventoryGuiWrapper.inventorySize = 27;
    dropMainInventoryGuiWrapper.fillElement = fillElementWrapper;
    dropMainInventoryGuiWrapper.elements = new LinkedHashMap<>();
    dropMainInventoryGuiWrapper.elements.put("stone", stoneDropItemElementWrapper);
    dropMainInventoryGuiWrapper.elements.put("magicCase", magicCaseItemElementWrapper);
    dropMainInventoryGuiWrapper.elements.put("cobbleX", cobbleXItemElementWrapper);
    return dropMainInventoryGuiWrapper;
  }

  private static SpigotGuiWrapper createChannelGuiWrapper() {
    final SpigotGuiWrapper channelGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformChannelSpigotGuiElementWrapper firstChannelElementWrapper = new PlatformChannelSpigotGuiElementWrapper();
    final PlatformChannelSpigotGuiElementWrapper secondChannelElementWrapper = new PlatformChannelSpigotGuiElementWrapper();
    final PlatformChannelSpigotGuiElementWrapper thirdChannelElementWrapper = new PlatformChannelSpigotGuiElementWrapper();
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    firstChannelElementWrapper.material = "WOOL";
    firstChannelElementWrapper.slot = 11;
    secondChannelElementWrapper.material = "WOOL";
    secondChannelElementWrapper.slot = 13;
    thirdChannelElementWrapper.material = "WOOL";
    thirdChannelElementWrapper.slot = 15;
    channelGuiWrapper.inventoryName = "&dWybierz kana?? spawn'u";
    channelGuiWrapper.inventorySize = 27;
    channelGuiWrapper.fillElement = fillElementWrapper;
    channelGuiWrapper.elements = new LinkedHashMap<>();
    channelGuiWrapper.elements.put("spawn_1", firstChannelElementWrapper);
    channelGuiWrapper.elements.put("spawn_2", secondChannelElementWrapper);
    channelGuiWrapper.elements.put("spawn_3", thirdChannelElementWrapper);
    return channelGuiWrapper;
  }

  private static SpigotGuiWrapper createKitListGuiWrapper() {
    final SpigotGuiWrapper kitListGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final PlatformKitListPreviewGuiElementWrapper firstKitPreviewElementWrapper = new PlatformKitListPreviewGuiElementWrapper();
    final PlatformKitListPreviewGuiElementWrapper secondKitPreviewElementWrapper = new PlatformKitListPreviewGuiElementWrapper();
    firstKitPreviewElementWrapper.material = "STONE";
    firstKitPreviewElementWrapper.name = "&cPierwszy kit ({KIT_NAME})";
    firstKitPreviewElementWrapper.slot = 12;
    secondKitPreviewElementWrapper.material = "COBBLESTONE";
    secondKitPreviewElementWrapper.name = "&aDrugi kit ({KIT_NAME})";
    secondKitPreviewElementWrapper.slot = 14;
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    kitListGuiWrapper.inventoryName = "&dLista dost??pnych zestaw??w";
    kitListGuiWrapper.inventorySize = 27;
    kitListGuiWrapper.fillElement = fillElementWrapper;
    kitListGuiWrapper.elements = new LinkedHashMap<>();
    kitListGuiWrapper.elements.put("kitSAMPLE1", firstKitPreviewElementWrapper);
    kitListGuiWrapper.elements.put("kitSAMPLE2", secondKitPreviewElementWrapper);
    return kitListGuiWrapper;
  }

  private static SpigotGuiWrapper createKitPreviewGuiWrapper() {
    final SpigotGuiWrapper kitPreviewGuiWrapper = new SpigotGuiWrapper();
    final PlatformKitPreviewGivenItemGuiElementWrapper itemPreviewElementWrapper = new PlatformKitPreviewGivenItemGuiElementWrapper();
    final PlatformKitPreviewPickupGuiElementWrapper pickupElementWrapper = new PlatformKitPreviewPickupGuiElementWrapper();
    final DefaultSpigotGuiElementWrapper backElementWrapper = new DefaultSpigotGuiElementWrapper();
    itemPreviewElementWrapper.slot = 0;
    pickupElementWrapper.material = "INK_SACK";
    pickupElementWrapper.slot = 7;
    backElementWrapper.material = "BARRIER";
    backElementWrapper.name = "&cPowr??t do menu g????wnego";
    backElementWrapper.slot = 8;
    kitPreviewGuiWrapper.inventoryName = "&dZestaw {KIT_NAME}";
    kitPreviewGuiWrapper.inventorySize = 9;
    kitPreviewGuiWrapper.elements = new LinkedHashMap<>();
    kitPreviewGuiWrapper.elements.put("item1", itemPreviewElementWrapper);
    kitPreviewGuiWrapper.elements.put("pickup", pickupElementWrapper);
    kitPreviewGuiWrapper.elements.put("back", backElementWrapper);
    return kitPreviewGuiWrapper;
  }

  private static SpigotGuiWrapper createCrowbarTakeoverGuiWrapper() {
    final SpigotGuiWrapper crowbarTakeoverGuiWrapper = new SpigotGuiWrapper();
    final DefaultSpigotGuiElementWrapper fillElementWrapper = new DefaultSpigotGuiElementWrapper();
    final SpigotGuiElementWrapper takeoverElementWrapper = new PlatformCrowbarTakeoverSpigotGuiElementWrapper();
    fillElementWrapper.material = "STAINED_GLASS_PANE";
    fillElementWrapper.name = "&8#";
    fillElementWrapper.data = 15;
    takeoverElementWrapper.slot = 13;
    crowbarTakeoverGuiWrapper.inventoryName = "&dPrzejmowanie sejfu";
    crowbarTakeoverGuiWrapper.inventorySize = 27;
    crowbarTakeoverGuiWrapper.fillElement = fillElementWrapper;
    crowbarTakeoverGuiWrapper.elements = new LinkedHashMap<>();
    crowbarTakeoverGuiWrapper.elements.put("takeover", takeoverElementWrapper);
    return crowbarTakeoverGuiWrapper;
  }

  private static MagicCaseItemWrapper createMagicCaseItemWrapper(final String material,
      final String name, final List<String> lore,
      final List<SpigotGuiEnchantmentWrapper> enchantments, final double chance, final short data,
      final int minAmount, final int maxAmount, final CustomItemType customItemType) {
    final MagicCaseItemWrapper wrapper = new MagicCaseItemWrapper();
    wrapper.material = material;
    wrapper.name = name;
    wrapper.lore = lore;
    wrapper.enchantments = enchantments;
    wrapper.chance = chance;
    wrapper.data = data;
    wrapper.minAmount = minAmount;
    wrapper.maxAmount = maxAmount;
    wrapper.customItemType = customItemType;
    return wrapper;
  }

  private static CobbleXItemWrapper createCobbleXItemWrapper(final String material,
      final String name, final List<String> lore,
      final List<SpigotGuiEnchantmentWrapper> enchantments, final short data, final int minAmount,
      final int maxAmount) {
    final CobbleXItemWrapper wrapper = new CobbleXItemWrapper();
    wrapper.material = material;
    wrapper.name = name;
    wrapper.lore = lore;
    wrapper.enchantments = enchantments;
    wrapper.data = data;
    wrapper.minAmount = minAmount;
    wrapper.maxAmount = maxAmount;
    return wrapper;
  }

  private static KitItemWrapper createKitItemWrapper(final int id, final String material,
      final String name, final List<String> lore,
      final List<SpigotGuiEnchantmentWrapper> enchantments, final short data, final int amount) {
    final KitItemWrapper wrapper = new KitItemWrapper();
    wrapper.id = id;
    wrapper.material = material;
    wrapper.name = name;
    wrapper.lore = lore;
    wrapper.enchantments = enchantments;
    wrapper.data = data;
    wrapper.amount = amount;
    return wrapper;
  }

  private static RankWrapper createRankWrapper(final String name, final String chatPrefix,
      final String chatSuffix, final String nameTagPrefix, final String nameTagSuffix,
      final List<String> permissions, final int priority, final boolean defaultRank) {
    final RankWrapper wrapper = new RankWrapper();
    wrapper.name = name;
    wrapper.chatPrefix = chatPrefix;
    wrapper.chatSuffix = chatSuffix;
    wrapper.nameTagPrefix = nameTagPrefix;
    wrapper.nameTagSuffix = nameTagSuffix;
    wrapper.permissions = permissions;
    wrapper.priority = priority;
    wrapper.defaultRank = defaultRank;
    return wrapper;
  }

  private static SimpleCustomCommandWrapper createSimpleCustomCommandWrapper(final String name,
      final String description, final List<String> aliases, final List<String> messages) {
    final SimpleCustomCommandWrapper wrapper = new SimpleCustomCommandWrapper();
    wrapper.name = name;
    wrapper.description = description;
    wrapper.aliases = aliases;
    wrapper.messages = messages;
    return wrapper;
  }

  private static KitWrapper createKitWrapper(final String name, final String permission,
      final List<KitItemWrapper> items, final String time) {
    final KitWrapper wrapper = new KitWrapper();
    wrapper.name = name;
    wrapper.permission = permission;
    wrapper.items = items;
    wrapper.time = time;
    return wrapper;
  }

  private static SpigotGuiEnchantmentWrapper createEnchantmentWrapper(final String enchantmentName,
      final int enchantmentLevel) {
    final SpigotGuiEnchantmentWrapper wrapper = new SpigotGuiEnchantmentWrapper();
    wrapper.enchantmentName = enchantmentName;
    wrapper.enchantmentLevel = enchantmentLevel;
    return wrapper;
  }

  @SuppressWarnings("SpellCheckingInspection")
  public enum CustomItemType {

    GHEAD, MAGIC_CASE,
    COBBLEX, STONE_GENERATOR
  }

  public static final class MessagesWrapper {

    // GLOBAL
    public String playerIsOffline = "&cGracz o nicku {PLAYER_NAME} jest aktualnie offline!";
    public String playerNotFound = "&cGracz o nicku {PLAYER_NAME} nie istnieje w bazie danych!";
    public String cannotExecuteThisActionOnYourself = "&cNie mo??esz wykona?? tej akcji na sobie!";

    // SPIGOT
    public String sectorChangeIsCooldowned = "&cNie mo??esz zmieni?? sektora jeszcze przez {TIME}!";
    public String sectorIsFull = "&cSektor, na kt??ry chcesz si?? po????czy?? jest aktualnie pe??en!";
    public String sectorNotFound = "&cSektor o nazwie {SECTOR_NAME} nie istnieje!";
    public String playerLoggedOutWhileRequestingTheirLocation = "&cGracz wylogowa?? si?? podczas pr??by pobrania lokacji!";
    public String successfullyTeleportedToThePlayer = "&7Przeteleportowa??e?? si?? do gracza &d{PLAYER_NAME}&7!";
    public String successfullySelfTeleportedThePlayer = "&7Pomy??lnie przeteleportowa??e?? gracza &d{PLAYER_NAME} &7do Ciebie!";
    public String successfullyTeleportedToTheSector = "&7Przeteleportowa??e?? si?? na ??rodek sektora &d{SECTOR_NAME}&7!";
    public String gameModeNotFound = "&cTaki tryb gry nie istnieje!";
    public String gameModeSuccessfullyChanged = "&7Zmieniono tryb gry na &d{MODE_NAME}!";
    public String changedSpawnLocationSuccessfully = "&7Pomy??lnie zmieni??e?? lokacj?? &dspawna&7!";
    public String teleportRequestAlreadySent = "&cWys??a??e?? ju?? pro??b?? o teleportacj?? do tego gracza!";
    public String teleportRequestNotSent = "&cNie posiadasz pro??by o teleportacj?? od tego gracza!";
    public String teleportRequestsNotFound = "&cNie posiadasz ??adnej aktywnej pro??by o teleportacj??!";
    public String teleportRequestSuccessfullySentPlayer = "&7Wys??a??e?? pro??b?? o teleportacj?? do gracza &d{PLAYER_NAME}&7!";
    public String teleportRequestSuccessfullySentTarget =
        "&7Gracz &d{PLAYER_NAME} &7wys??a?? pro??b?? do teleportacj?? do ciebie!\n"
            + "&7U??yj: &d/tpaccept <nick> &7aby zaakceptowa?? pro??b??!\n"
            + "&7U??yj: &5/tpdeny <nick> &7aby odrzuci?? pro??b??!";
    public String teleportRequestSuccessfullyAcceptedOne = "&7Pomy??lnie zaakceptowa??e?? pro??b?? o teleportacj?? od gracza &d{PLAYER_NAME}&7!";
    public String teleportRequestSuccessfullyAcceptedAll = "&7Pomy??lnie zaakceptowa??e?? pro??b?? o teleportacj?? od &dka??dego gracza&7, kt??ry j?? do ciebie wys??a??!";
    public String teleportRequestSuccessfullyAcceptedTarget = "&d{PLAYER_NAME} &7zaakceptowa?? twoj?? pro??b?? o teleportacj??!";
    public String teleportRequestSuccessfullyDeniedPlayer = "&7Pomy??lnie odrzuci??e?? pro??b?? o teleportacj?? od gracza &d{PLAYER_NAME}&7!";
    public String teleportRequestSuccessfullyDeniedTarget = "&d{PLAYER_NAME} &7odrzuci?? twoj?? pro??b?? o teleportacj??!";
    public String teleportationHasBeenStarted = "&7Teleportacja na wyznaczone miejsce za &d{SECONDS}s&7...";
    public String teleportationHasBeenCancelled = "&cTeleportacja na wyznaczone miejsce zosta??a przerwana!";
    public String teleportationHasBeenFinished = "&aTeleportacja na wyznaczone miejsce powiod??a si??!";
    public String teleportationInfoActionBar = "&7Teleportacja nast??pi za: &d{SECONDS}s";
    public String teleportationHasBeenFinishedActionBar = this.teleportationHasBeenFinished;
    public String privateMessageCannotBeEmpty = "&cWiadomo???? prywatna nie mo??e by?? pusta!";
    public String privateMessageFormatPlayer = "&dJa &8-> &d{PLAYER_NAME}&7: {MESSAGE}";
    public String privateMessageLastPlayerNotFound = "&cNie znaleziono ??adnego gracza, z kt??rym pisa??e??!";
    public String privateMessageFormatTarget = "&d{PLAYER_NAME} &8-> &dJa&7: {MESSAGE}";
    public String privateMessageTargetPlayerHasDisabledPMS = "&cPodany gracz ma wy????czone wiadomo??ci prywatne do siebie!";
    public String privateMessageTargetPlayerIsIgnoringYou = "&cPodany gracz ma ci?? w li??cie ignorowanych!";
    public String channelIsACurrentSector = "&cTen kana?? jest twoim aktualnym sektorem, nie mo??esz si?? na niego prze????czy??!";
    public String chatMessageIsCooldowned = "&cNie mo??esz wysy??a?? wiadomo??ci na chacie jeszcze przez {TIME}!";
    public String chatMessageCannotBeEmpty = "&cNie mo??esz wysy??a?? pustej wiadomo??ci na chacie!";
    public String chatIsCurrentlyDisabled = "&cChat jest aktualnie wy????czony!";
    public String chatIsAlreadyDisabled = "&cChat jest ju?? wy????czony!";
    public String chatHasBeenSuccessfullyDisabledSender = "&cChat zosta?? pomy??lnie wy????czony przez ciebie!";
    public String chatHasBeenSuccessfullyDisabledGlobal = "&7Chat zosta?? &cwy????czony &7przez administratora &d{PLAYER_NAME}&7!";
    public String chatIsAlreadyEnabled = "&cChat jest ju?? w????czony!";
    public String chatHasBeenSuccessfullyEnabledSender = "&aChat zosta?? pomy??lnie w????czony przez ciebie!";
    public String chatHasBeenSuccessfullyEnabledGlobal = "&7Chat zosta?? &aw????czony &7przez administratora &d{PLAYER_NAME}&7!";
    public String chatPremiumIsCurrentlyEnabled = "&cChat jest w????czony aktualnie tylko dla rang PREMIUM!";
    public String chatPremiumIsAlreadyEnabled = "&cChat dla rang premium jest ju?? wy????czony!";
    public String chatPremiumHasBeenSuccessfullyEnabledSender = "&aChat dla rang premium zosta?? pomy??lnie w????czony przez ciebie!";
    public String chatPremiumHasBeenSuccessfullyEnabledGlobal = "&7Chat dla rang &5&lPREMIUM &7zosta?? &aw????czony &7przez administratora &d{PLAYER_NAME}&7!";
    public String chatHasBeenCleared = "&7Chat zosta?? wyczyszczony przez administratora &d{PLAYER_NAME}&7!";
    public String chatCommandUsage = "&5/chat clear/cc - &dCzy??ci ca??y chat serwerowy\n"
        + "&5/chat disable/off - &dWy????cza ca??y chat serwerowy\n"
        + "&5/chat enable/on - &dW????cza ca??y chat serwerowy\n"
        + "&5/chat premium - &dW????cza ca??y chat serwerowy, ale tylko dla rang premium";
    public String chatFormatAdmin = "{CHAT_PREFIX}%1$s&8: {CHAT_SUFFIX}%2$s";
    public String chatFormatPlayer = "{CHAT_PREFIX}%1$s&8: {CHAT_SUFFIX}%2$s";
    public String guiNotFound = "&cPodane GUI nie zosta??o skonfigurowane!";
    public String rankNotFound = "&cPodana ranga nie istnieje!";
    public String rankListStart = "&cLista rang:";
    public String rankListFormat = "&c{RANK_NAME}";
    public String rankSuccessfullySetSender = "&7Pomy??lnie ustawi??e?? rang?? &d{RANK_NAME} &7dla gracza &d{PLAYER_NAME} &7na czas: &d{TIME}&7!";
    public String rankSuccessfullySetReceiver = "&7Pomy??lnie otrzyma??e?? rang?? &d{RANK_NAME} &7od administratora &d{PLAYER_NAME} &7na czas: &d{TIME}&7!";
    public String magicCaseItemLeftTimeInfo = "&7DROP ZA &d{TIME}&7...";
    public String magicCaseItemDroppedInfo = "&7Wydropiony item: &d{ITEM_NAME}x{ITEM_AMOUNT}";
    public String magicCaseItemNotDroppedInfo = "&cNic nie wydropi??e?? :(";
    public String magicCaseIsAlreadyBeingOpened = "&cOtwierasz ju?? jedn?? skrzynk??! Nie mo??esz otworzy?? drugiej.";
    public String magicCaseGivenAll = "&7Ca??y serwer otrzyma?? &aMagiczn?? Skrzynk??x{AMOUNT} &7od administratora &d{PLAYER_NAME}&7!";
    public String magicCaseGivenSender = "&7Pomy??lnie da??e?? &aMagiczn?? Skrzynk??x{AMOUNT} &7dla gracza &d{PLAYER_NAME}&7!";
    public String magicCaseGivenReceiver = "&7Otrzyma??e?? &aMagiczn?? Skrzynk??x{AMOUNT} &7od administratora &d{PLAYER_NAME}&7!";
    public String magicCaseCommandUsage =
        "&5/magiccase all <ilo????> - &dRozdaje x magicznych skrzynek dla ka??dego gracza\n"
            + "&5/magiccase player <nick> <ilo????> - &dRozdaje x magicznych skrzynek dla podanego gracza";
    public String homeNoPermission = "&cNie posiadasz uprawnie?? do tego domu!";
    public String homeNotSet = "&cNie ustawi??e?? jeszcze tego domu!";
    public String homeSuccessfullySet = "&7Pomy??lnie ustawi??e?? dom o identyfikatorze &d{HOME_IDENTIFIER}&7!";
    public String homeCannotBeSet = "&cNie mo??esz ustawi?? tutaj domu!";
    public String deathKickInfo = "&d{SECTOR_NAME} &8-> &5Umar??e??! Relognij aby gra?? ponownie.";
    public String kitNoPermission = "&cNie posiadasz uprawnie?? do tego kita! ({PERMISSION_NAME})";
    public String kitAlreadyReceived = "&cJu?? odebra??e?? tego kita! Mo??esz go odebra?? dopiero za: {TIME}";
    public String kitSuccessfullyReceived = "&7Pomy??lnie odebra??e?? zestaw o nazwie &d{KIT_NAME}&7!";
    public String cannotChangeSectorInCombat = "&cNie mo??esz zmieni?? sektora podczas walki!";
    public String cannotExecuteThisCommandInCombat = "&cNie mo??esz wykonywa?? tej komendy podczas walki!";
    public String cannotCraftItemsInCombat = "&cNie mo??esz craftowa?? przedmiot??w podczas walki z innym graczem!";
    public String combatEndInfo = "&aWalka si?? sko??czy??a, mo??esz si?? ju?? bezpiecznie wylogowa??!";
    public String combatLeftTimeInfo = "&5ANTY-LOGOUT &8(&d{TIME}&8)";
    public String combatTaggedInfo = "&7Jeste?? podczas walki z &d{PLAYER_NAME}&7! Nie mo??esz wylogowa?? si?? przez &d21s&7!";
    public String commandIsBlocked = "&cTa komenda jest zablokowana! Nie mo??esz jej u??ywa??.";
    public String commandNotFound = "&cPodana komenda nie istnieje! Aby sprawdzi?? list?? dost??pnych komend, wpisz: /pomoc";
    public String vanishEnabledInfo = "&aVanish zosta?? w????czony!";
    public String vanishDisabledInfo = "&cVanish zosta?? wy????czony :(";
    public String vanishYouAreInvisibleActionBar = "&7Vanish jest aktualnie &5w????czony&7!";
    public String vanishNameTagSuffix = " &d&lVANISH";
    public String godEnabledInfo = "&aGod zosta?? w????czony!";
    public String godDisabledInfo = "&cGod zosta?? wy????czony :(";
    public String alertPrefixTitle = "&8[&4ALERT&8]";
    public String depositLimitReached = "&7Znaleziono nadmiar przedmiot??w w Twoim ekwipunku. Zosta?? on przeniesiony do: &d/schowek";
    public String depositNoItemsToWithdrawFound = "&cNie znaleziono ??adnych item??w do wyp??acenia w twoim depozycie!";
    public String serverIsAlreadyFrozen = "&cSerwer jest ju?? zamro??ony! Nie mo??esz zamrozi?? go ponownie.";
    public String serverIsNotFrozen = "&cSerwer nie jest zamro??ony! Nie mo??esz odmrozi?? go ponownie.";
    public String successfullyFrozenTheServer = "&aPomy??lnie zamrozi??e?? ca??y serwer!";
    public String successfullyUnfrozenTheServer = "&aPomy??lnie odmrozi??e?? ca??y serwer!";
    public String serverIsFrozenInfoTitle = "&8[&d&lZAMRO??ENIE&8]";
    public String serverIsFrozenInfoSubTitle = "&7Oczekuj na start edycji.";
    public String serverGotUnfrozenInfoTitle = "&d&lSERWER ODMRO??ONY!";
    public String serverGotUnfrozenInfoSubTitle = "&5 &lPowodzenia :)";
    public String bossBarSuccessfullyUpdated = "&aPomy??lnie zmodyfikowano bossbara.";
    public String bossBarSuccessfullyRemoved = "&cPomy??lnie usuni??to bossbara.";
    public String bossBarUsage =
        "&5/bossbar update <czas (0 = perm)> <kolor> <styl> <tytu??>"
            + " - &dWykonuje modyfikacj?? specjalnego bossbara dla ka??dego gracza\n"
            + "&5/bossbar remove - &dUsuwa specjalnego bossbara";
    public String flightEnabledInfo = "&aLatanie zosta??o w????czone!";
    public String flightDisabledInfo = "&cLatanie zosta??o wy????czone :(";
    public String flightSpeedSuccessfullyChanged = "&7Szybko???? latania zosta??a pomy??lnie zmieniona na &d{SPEED}&7!";
    public String walkingSpeedSuccessfullyChanged = "&7Szybko???? chodzenia zosta??a pomy??lnie zmieniona na &d{SPEED}&7!";
    public String yourInventoryHasBeenCleared = "&aTwoje inventory zosta??o pomy??lnie wyczyszczone!";
    public String targetInventoryHasBeenClearedSender = "&aPomy??lnie wyczy??ci??e?? inventory gracza {PLAYER_NAME}!";
    public String targetInventoryHasBeenClearedReceiver = "&aTwoje inventory zosta??o wyczyszczone przez administratora {PLAYER_NAME}!";
    public String youHaveBeenHealed = "&aZosta??e?? pomy??lnie uleczony!";
    public String targetHaveBeenHealedSender = "&aPomy??lnie uleczy??e?? gracza {PLAYER_NAME}!";
    public String targetHaveBeenHealedReceiver = "&aZosta??e?? pomy??lnie wyczyszczony przez administratora {PLAYER_NAME}!";
    public String cannotEquipGoldenHead = "&cNie mo??esz za??o??y?? golden heada na g??ow??!";
    public String safeIsBeingModified = "&cSejf jest aktualnie modyfikowany przez gracza o nicku: {PLAYER_NAME}!";
    public String safeIsBeingSaved = "&cSejf jest aktualnie zapisywany!";
    public String safeIsNotYours = "&cSejf nie nale??y do ciebie! Nie mo??esz go otworzy??.";
    public String noSafeInInventory = "&cNie posiadasz sejfu w inventory!";
    public String safeNotFoundInDatabase = "&cSejf nie istnieje w bazie danych!";
    public String safeDescriptionCannotBeEmpty = "&cOpis sejfu nie mo??e by?? pusty!";
    public String safeDescriptionHasTooManyChars = "&cOpis sejfu nie mo??e mie?? wi??cej ni?? 16 znak??w!";
    public String safeDescriptionHasBeenChanged = "&7Pomy??lnie zmieni??e?? opis sejfu na &d{DESCRIPTION}&7!";
    public String onlySafeCanBeTakenOverByCrowbar = "&cTylko sejf mo??e zosta?? przej??ty przez ??om!";
    public String youCannotTakeoverYourOwnSafe = "&cNie mo??esz przej???? w??asnego sejfu!";
    public String safeHaveBeenSuccessfullyTakenOver = "&aPomy??lnie przej????e?? sejf o identyfikatorze {SAFE_UNIQUE_ID}!";
    public String cannotUsePearlsOnEndShockwave = "&cNie mo??esz u??ywa?? pere?? w locie podczas fali uderzeniowej!";
    public String endWaterWillBeRemovedSoon = "&aPostawi??e?? wod??! Zostanie ona usuni??ta w ci??gu 10 sekund je??eli jej nie zbierzesz!";
    public String endWaterHasBeenSuccessfullyFilled = "&aPomy??lnie zebra??e?? wod??!";
    public String endPortalPointNotSet = "&c??aden punkt od portalu nie zosta?? ustalony!";
    public String endPortalPointNotActive = "&cTen portal jest aktualnie nieaktywny!";
    public String endPortalPointEditingSessionIsAlreadyActive = "&cSesja edytowania punkt??w portalu jest ju?? aktywna!";
    public String endPortalPointEditingSessionIsNotActive = "&cSesja edytowania punkt??w portalu nie jest aktywna!";
    public String endPortalPointEditingSessionHasBeenActivated =
        "&aSesja edytowania punkt??w portalu zosta??a w????czona!\n"
            + "&aU??yj komendy: /portalpoint setpoint aby ustawi?? punkt\n"
            + "&aUzyj komendy: /portalpoint edit stop aby zako??czy?? edycj??.";
    public String endPortalPointEditingSessionPointsAreNotSet = "&cSesja edytowania punkt??w portalu nie posiada ??adnych punkt??w! Anuluj?? dodanie nowego punktu.";
    public String endPortalPointEditingSessionHasBeenSuccessfullyEnded = "&aPomy??lnie zako??czono sesj?? edytowania punkt??w portalu i dodano nowy punkt!";
    public String endPortalPointCannotBeSetHere = "&cNie mo??esz ustawi?? w tym miejscu punktu portalu!";
    public String endPortalPointEditingFirstPointIsAlreadySet = "&cPierwszy punkt portalu jest ju?? ustawiony!";
    public String endPortalPointEditingSecondPointIsAlreadySet = "&cDrugi punkt portalu jest ju?? ustawiony!";
    public String endPortalPointEditingFirstPointHasBeenSuccessfullySet = "&aPierwszy punkt portalu zosta?? pomy??lnie ustawiony!";
    public String endPortalPointEditingSecondPointHasBeenSuccessfullySet = "&aDrugi punkt portalu zosta?? pomy??lnie ustawiony!";
    public String endPortalPointDoesNotExists = "&cPunkt portalu o identyfikatorze {IDENTIFIER} nie istnieje!";
    public String endPortalPointHasBeenSuccessfullyDeleted = "&aPomy??lnie usuni??to punkt portalu o identyfikatorze {IDENTIFIER}";
    public String endPortalPointCommandUsage =
        "&5/portalpoint edit start - &dTworzy i startuje sesj?? edytowania portali\n"
            + "&5/portalpoint edit stop - &dKo??czy sesj?? tworzenia portali i dodaje nowy punkt do konfiguracji\n"
            + "&5/portalpoint delete <id> - &dUsuwa dany punkt portalu z konfiguracji\n"
            + "&5/portalpoint setpoint - &dUstawia pierwszy lub drugi punkt w sesji edytowania portali";
    public String youAreBannedInEnd = "&cJeste?? zbanowany! Nie mo??esz wej???? do endu przez: {TIME}";
    public String cannotCraftEnchantedGoldenApples = "&cNie mo??esz craftowa?? kox??w, poniewa?? na naszym serwerze s?? gheady!";
    public String cannotEatEnchantedGoldenApples = "&cNie mo??esz je???? kox??w, poniewa?? na naszym serwerze s?? gheady!";
    public String globalTurboDropIsActiveActionBarInfo = "&5Turbo&fDrop &7globalny jest aktywny jeszcze przez &d{TIME}&7! &8(&d{MULTIPLIER}x&8)";
    public String yourTurboDropIsActiveActionBarInfo = "&5Turbo&fDrop &7dla ciebie jest aktywny jeszcze przez &d{TIME}&7! &8(&d{MULTIPLIER}x&8)";
    public String turboDropPickingActivatedInfo = "&8[&dLOSOWANIE TURBODROPU&8] &7Trwa wybieranie graczy na ka??dym sektorze gildyjnym...";
    public String turboDropPickingNoPlayersFound = "&8[&dLOSOWANIE TURBODROPU&8] &cNie odnaleziono ??adnych graczy na sektorach grywalnych!";
    public String turboDropPickingSucceed = "&8[&dLOSOWANIE TURBODROPU&8] &7Wylosowano &dTurboDrop na 15m &7dla: &d{PICKED_PLAYER_NAMES}";
    public String turboDropForPlayerHasBeenActivatedSender = "&7Pomy??lnie aktywowa??e?? &dTurboDrop &7na czas &d{TIME} &7dla gracza &d{PLAYER_NAME}&7!";
    public String turboDropForPlayerHasBeenActivatedReceiver = "&dTurboDrop &7na czas &d{TIME} &7zosta?? dla Ciebie zaktywowany przez administratora &d{PLAYER_NAME}&7!";
    public String turboDropGlobalHasBeenActivated = "&7Pomy??lnie aktywowa??e?? &dTurboDrop &7na czas &d{TIME} &7dla ka??dego gracza!";
    public String turboDropCommandUsage =
        "&5/turbodrop player <nickname> <multiplier> <time> - &dCzy??ci ca??y chat serwerowy\n"
            + "&5/turbodrop global <multiplier> <time> - &dCzy??ci ca??y chat serwerowy";
    public String dropItemDroppedActionBarInfo = "&7Wydropi??e??: &d{DROP_NAME} &7x&d{AMOUNT} &8(&d+{XP} &7exp&8)";
    public String youDidALevelUpTitle = "&5&lGratulacj??!";
    public String youDidALevelUpSubTitle = "&7Awansowa??e?? na level &d{LEVEL}&7!";
    public String userLevelInfoTarget = "&7Nick: &d{PLAYER_NAME}"
        + "\n&7Level: &d{LEVEL}"
        + "\n&7EXP: &d{CURRENT_EXP}"
        + "\n&7Wymagany EXP do awansu: &d{NEEDED_EXP}";
    public String userLevelInfoYourself = "&7Level: &d{LEVEL}"
        + "\n&7EXP: &d{CURRENT_EXP}"
        + "\n&7Wymagany EXP do awansu: &d{NEEDED_EXP}";
    public String cobbleXNoNeededItems = "&cNie posiadasz potrzebnych item??w! Brakuje ci: {AMOUNT_LEFT} cobbla.";
    public String cobbleXSuccessfullyCreated = "&aPomy??lnie stworzono cobblexa!";
    public String antiGriefBlockWillBeVanishedSoon = "&cAntyGrif: &7Blok, kt??ry postawi??e?? zniknie za &d30m&7!";
    public String stoneGeneratorHasBeenSuccessfullyCreated = "&aPomy??lnie stworzy??e?? generator stone'a!";
    public String stoneGeneratorHasBeenSuccessfullyDestroyed = "&aPomy??lnie zniszczy??e?? generator stone'a!";
    public String repairPickaxeIsCooldowned = "&cNie mo??esz naprawi?? kilofa jeszcze przez {TIME}!";
    public String repairPickaxeCannotRepairItemThatIsNotAPickaxe = "&cNie mo??esz naprawi?? przedmiotu kt??ry nie jest kilofem!";
    public String repairPickaxeNoRequiredDiamonds = "&cNie posiadasz wymaganej ilo??ci diament??w do naprawienia kilofa (16)!";
    public String repairPickaxeNoRequiredLevel = "&cNie posiadasz wymaganego levela do naprawienia kilofa (30)!";
    public String repairPickaxeHasBeenSuccessfullyRepaired = "&aPomy??lnie naprawi??e?? sw??j kilof!";
    public String repairSingleCannotRepairThisItem = "&cNie mo??esz naprawi?? tego przedmiotu!";
    public String repairSingleSuccessfullyRepaired = "&aPomy??lnie naprawi??e?? przedmiot kt??ry trzymasz w r??ce!";
    public String repairAllNoItemsFound = "&cNie posiadasz ??adnych item??w do naprawy!";
    public String repairAllSuccessfullyRepaired = "&aPomy??lnie naprawi??e?? wszystkie przedmioty w twoim EQ!";
    public String blocksCannotBeConverted = "&cNie mo??na by??o przekonwertowa?? sztabek na bloki!";
    public String blocksSuccessfullyConverted = "&aPomy??lnie zamieniono wszystkie sztabki na bloki!";
    public String discordRewardReceived = "&8&m--------&8[&9DISCORD&8]&8&m--------"
        + "\n&8>> &7Gracz &d{PLAYER_NAME} &7odebra?? nagrod??"
        + "\n&8>> &7za do????czenie na &9Discorda&7!"
        + "\n&8>> &7Chcesz te??? Do????cz na naszego dc: &ddc.rosehc.pl"
        + "\n&8&m--------&8[&9DISCORD&8]&8&m--------";
    public String healthInfoAfterProjectileHitActionBarInfo = "&7Gracz &d{PLAYER_NAME} &7posiada &d{HEALTH} &4???";
    public String ignoreNowIgnoringPlayer = "&7Od teraz ignorujesz gracza o nicku: &d{PLAYER_NAME}";
    public String ignoreNotIgnoringPlayer = "&7Od teraz nie ignorujesz ju?? gracza o nicku: &d{PLAYER_NAME}";

    // PROXY
    public String accountCreated = "&aTwoje konto zosta??o pomy??lnie stworzone! Relognij.";
    public String proxyIsFull = "&cSerwer jest aktualnie pe??en graczy!";
    public String proxyJoinIsCooldowned = "&cMusisz odczeka?? {TIME} przed nast??pn?? pr??b?? po????czenia si?? z serwerem!";
    public String configReloadRequested = "&aPro??ba o prze??adowanie configu zosta??a pomy??lnie wys??ana!";
    public String whitelistIsAlreadyEnabled = "&cWhitelista jest ju?? w????czona!";
    public String whitelistGotSuccessfullyEnabled = "&aPomy??lnie w????czono whitelist?? na serwerach proxy!";
    public String whitelistIsAlreadyDisabled = "&cWhitelista jest ju?? wy????czona!";
    public String whitelistGotSuccessfullyDisabled = "&aPomy??lnie wy????czono whitelist?? na serwerach proxy!";
    public String whitelistPlayerIsAlreadyWhitelisted = "&cPodany gracz jest ju?? w whiteli??cie!";
    public String whitelistPlayerHasBeenSuccessfullyAdded = "&aPomy??lnie dodano gracza {PLAYER_NAME} do whitelisty!";
    public String whitelistPlayerIsNotWhitelisted = "&cPodany gracz nie jest w whiteli??cie!";
    public String whitelistPlayerHasBeenSuccessfullyRemoved = "&aPomy??lnie usuni??to gracza {PLAYER_NAME} do whitelisty!";
    public String whitelistPlayerList = "&7Lista graczy w whiteli??cie: &5{PLAYERS}";
    public String whitelistReasonHasBeenSuccessfullyChanged = "&aPomy??lnie zmieniono pow??d whitelisty na: &r{REASON}";
    public String whitelistUsage = "&5/whitelist add <nick> - &dDodaje gracza do whitelisty\n"
        + "&5/whitelist remove <nick> - &dUsuwa gracza z whitelisty\n"
        + "&5/whitelist on - &dW????cza whiteliste\n"
        + "&5/whitelist off - &dWy????cza whiteliste\n"
        + "&5/whitelist reason <pow??d> - &dUstawia pow??d whitelisty\n"
        + "&5/whitelist list - &dWy??wietla list?? os??b w whiteli??cie";
    public String slotsUsage =
        "&5/setslots proxy <ilo????> - &dUstawia sloty na podan?? ilo???? na ka??dym proxy\n"
            + "&5/setslots sectors <ilo????> - &dUstawia sloty na podan?? ilo???? na ka??dym sektorze";
    public String slotsSuccessfullySet = "&aPomy??lnie zmieniono sloty na {SLOTS}!";
    public String maskSuccessfullySet = "&aPomy??lnie ustawiono mask?? na {LIMIT}!";
    public String maskSuccessfullyDisabled = "&aPomy??lnie wy????czono mask??!";
    public String sectorListInfo = "&5[{SECTOR_NAME}] &d{SECTOR_ONLINE_PLAYERS} &8- &r{FORMATTED_TPS} &8(&5{FORMATTED_LOAD}%&8)";
    public String proxyListInfo = "&5[{PROXY_IDENTIFIER}] &d{PROXY_ONLINE_PLAYERS} &8- &5{FORMATTED_LOAD}%";
    public String globalListInfo = "  &7Razem graczy &d{GLOBAL_ONLINE_PLAYERS} &8(&5{CURRENT_ONLINE_PLAYERS}&8)";
    public String successfullyKicked = "&7Pomy??lnie wyrzuci??e?? gracza o nicku &d{PLAYER_NAME} &7z powodem: &r{REASON}&7!";
    public String helpopIsCooldowned = "&cNie mo??esz wysy??a?? wiadomo??ci na helpopie jeszcze przez {TIME}!";
    public String helpopMessageCannotBeEmpty = "&cWiadomo???? na helpopie nie mo??e by?? pusta!";
    public String helpopMessageSuccessfullySent = "&aPomy??lnie wys??a??e?? wiadomo???? do administracji!";
    public String helpopFormat = "&dHELPOP &8[&5proxy_{PROXY_IDENTIFIER}&8] [&5{SECTOR_NAME}&8] &d{PLAYER_NAME} &8-> &7{MESSAGE}";
    public String blazingPackIsOutdated = "&5Posiadasz nieaktualn?? wersj?? paczki!\n"
        + "&aJak pobra?? now?? wersj???\n"
        + "&7Wejdz na stron??: &dhttps://www.blazingpack.pl\n"
        + "&7Kliknij przycisk: &dPOBIERZ PACZK??/POBIERZ 1.8.8! (lub Pobierz automatyczny instalator (Windows only) na dole strony)\n"
        + "&7Odpakuj, przenie?? do %appdata% -> .minecraft -> .versions, zrestartuj gr??\n"
        + "&7i gotowe! Mo??esz cieszy?? si?? ponownie gr?? na naszym serwerze :)";
    public String banUserIsAlreadyBanned = "&cTen u??ytkownik posiada ju?? bana!";
    public String banUserIsNotBanned = "&cTen u??ytkownik nie posiada bana!";
    public String banCannotBeCreated = "&cNie mo??na by??o stworzy?? bana.";
    public String banCannotBeDeleted = "&cNie mo??na by??o usun???? bana.";
    public String banPermBroadcastSilent = "&8[&cUKRYTY&8] &7Gracz &d{PLAYER_NAME} &7zosta?? permanentnie zbanowany przez administratora &d{STAFF_NAME} &7z powodem: &d{REASON}&7!";
    public String banPermBroadcastGlobal = "&7Gracz &d{PLAYER_NAME} &7zosta?? permanentnie zbanowany przez administratora &d{STAFF_NAME} &7z powodem: &d{REASON}&7!";
    public String banTempBroadcastSilent = "&8[&cUKRYTY&8] &7Gracz &d{PLAYER_NAME} &7zosta?? tymczasowo zbanowany przez administratora &d{STAFF_NAME} &7z powodem: &d{REASON} &7na czas: &d{TIME}&7!";
    public String banTempBroadcastGlobal = " &7Gracz &d{PLAYER_NAME} &7zosta?? tymczasowo zbanowany przez administratora &d{STAFF_NAME} &7z powodem: &d{REASON} &7na czas: &d{TIME}&7!";
    public String banUnBanBroadcastSilent = "&8[&cUKRYTY&8] &7Gracz &d{PLAYER_NAME} &7zosta?? odbanowany przez administratora &d{STAFF_NAME}&7!";
    public String banUnBanBroadcastGlobal = "&7Gracz &d{PLAYER_NAME} &7zosta?? odbanowany przez administratora &d{STAFF_NAME}&7!";
    public String banKickCommandPerm =
        "&cZosta??e?? permanentnie zbanowany przez administratora {STAFF_NAME}"
            + "\n&cRelognij, aby dowiedzie?? si?? wi??cej!";
    public String banKickCommandTemp =
        "&cZosta??e?? tymczasowo zbanowany przez administratora {STAFF_NAME}"
            + "\n&cRelognij, aby dowiedzie?? si?? wi??cej!";
    public String banKickJoinPerm = "&cZosta??e?? permanentnie przez administratora: &4{STAFF_NAME}"
        + "\n&cNick: &4{PLAYER_NAME}"
        + "\n&cPow??d: &4{REASON}"
        + "\n&cBana utworzono: &4{CREATION_TIME}"
        + "\n&cNies??uszny ban? Zg??o?? si?? do nas na ts: &4ts.rosehc.pl &club dc: &4dc.rosehc.pl";
    public String banKickJoinTemp =
        "&cZosta??e?? tymczasowo zbanowany przez administratora: &4{STAFF_NAME}"
            + "\n&cNick: &4{PLAYER_NAME}"
            + "\n&cPow??d: &4{REASON}"
            + "\n&cWygasa: &4za {LEFT_TIME}"
            + "\n&cBana utworzono: &4{CREATION_TIME}"
            + "\n&cNies??uszny ban? Zg??o?? si?? do nas na ts: &4ts.rosehc.pl &club dc: &4dc.rosehc.pl";
  }

  public static final class CustomItemsWrapper {

    @SerializedName("custom_crafts")
    public List<CustomCraftingWrapper> customCraftingWrapperList = Arrays.asList(
        createCustomCraftingWrapper(
            createCraftingItemWrapper(
                createCustomItemWrapper(
                    null,
                    null,
                    null,
                    null,
                    (short) 0,
                    1
                ),
                CustomItemType.GHEAD
            ),
            new HashMap<Integer, CraftingItemWrapper>() {{
              final CustomItemWrapper goldenAppleItemWrapper = createCustomItemWrapper(
                  "GOLDEN_APPLE",
                  null,
                  null,
                  null,
                  (short) 0,
                  1
              );
              for (int i = 0; i < 9; i++) {
                this.put(i, createCraftingItemWrapper(i == 4 ? createCustomItemWrapper(
                    "DIAMOND",
                    null,
                    null,
                    null,
                    (short) 0,
                    1
                ) : goldenAppleItemWrapper));
              }
            }}
        ),
        createCustomCraftingWrapper(
            createCraftingItemWrapper(
                createCustomItemWrapper(
                    null,
                    null,
                    null,
                    null,
                    (short) 0,
                    1
                ),
                CustomItemType.COBBLEX
            ),
            new HashMap<Integer, CraftingItemWrapper>() {{
              final CustomItemWrapper cobbleStoneItemWrapper = createCustomItemWrapper(
                  "COBBLESTONE",
                  null,
                  null,
                  null,
                  (short) 0,
                  64
              );
              for (int i = 0; i < 9; i++) {
                this.put(i, createCraftingItemWrapper(cobbleStoneItemWrapper));
              }
            }}
        ),
        createCustomCraftingWrapper(
            createCraftingItemWrapper(
                createCustomItemWrapper(
                    null,
                    null,
                    null,
                    null,
                    (short) 0,
                    1
                ),
                CustomItemType.STONE_GENERATOR
            ),
            new HashMap<Integer, CraftingItemWrapper>() {{
              final CustomItemWrapper stoneItemWrapper = createCustomItemWrapper(
                  "STONE",
                  null,
                  null,
                  null,
                  (short) 0,
                  1
              );
              for (int i = 0; i < 9; i++) {
                this.put(i, i == 4 ? createCraftingItemWrapper(createCustomItemWrapper(
                    "DIAMOND",
                    null,
                    null,
                    null,
                    (short) 0,
                    1
                )) : createCraftingItemWrapper(stoneItemWrapper));
              }
            }}
        )
    );
    @SerializedName("reward_items")
    public List<RewardItemWrapper> rewardItemWrapperList = Arrays.asList(
        createRewardItemWrapper(
            createCustomItemWrapper(
                "MOSSY_COBBLESTONE",
                null,
                null,
                null,
                (byte) 0,
                1
            ),
            CustomItemType.COBBLEX
        ),
        createRewardItemWrapper(
            createCustomItemWrapper(
                "STONE",
                "Stone",
                null,
                null,
                (byte) 0,
                4
            )
        )
    );
    @SerializedName("first_join_items")
    public List<CustomItemWrapper> firstJoinItemList = Arrays.asList(
        createCustomItemWrapper(
            "STONE_PICKAXE",
            null,
            null,
            null,
            (short) 0,
            1
        ),
        createCustomItemWrapper(
            "COOKED_BEEF",
            null,
            null,
            null,
            (short) 0,
            128
        )
    );
    @SerializedName("respawn_items")
    public List<CustomItemWrapper> respawnItemList = Collections.singletonList(
        createCustomItemWrapper(
            "COOKED_BEEF",
            null,
            null,
            null,
            (short) 0,
            128
        )
    );
    @SerializedName("golden_apple_effects")
    public List<PotionEffectWrapper> goldenAppleEffectWrapperList = Arrays.asList(
        new PotionEffectWrapper(
            "ABSORPTION",
            0,
            120
        ),
        new PotionEffectWrapper(
            "REGENERATION",
            1,
            5
        )
    );
    @SerializedName("golden_head")
    public GoldenHeadWrapper goldenHeadWrapper = new GoldenHeadWrapper();
    @SerializedName("magicCase")
    public CustomItemWrapper magicCaseWrapper = createCustomItemWrapper("SKULL_ITEM",
        "&5&lMagiczna Skrzynka",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZmYjliM2UzZjY1MGI3YjI1OGMwNGZmY2I4NWMxYjVkY2FjOTJiODFlNTJkOTkyYzUxMjRiNjcwZmU4ZDYifX19",
        "", Collections.singletonList(
            "&aPostaw na ziemi, aby otworzy??"
        ), Collections.singletonList(
            createEnchantmentWrapper(
                "PROTECTION_ENVIRONMENTAL",
                10
            )
        ), (short) 0, 1);
    @SerializedName("cobbleX")
    public CustomItemWrapper cobbleXWrapper = createCustomItemWrapper("MOSSY_COBBLESTONE",
        "&9&lCobbleX", null, Collections.singletonList(
            createEnchantmentWrapper(
                "PROTECTION_ENVIRONMENTAL",
                10
            )
        ), (short) 0, 1);
    @SerializedName("safe_item")
    public SafeItemWrapper safeItemWrapper = new SafeItemWrapper();
    @SerializedName("stone_generator")
    public GeneratorItemWrapper generatorItemWrapper = new GeneratorItemWrapper();
    @SerializedName("crowbar")
    public CustomItemWrapper crowbarWrapper = createCustomItemWrapper("STICK", "&d&l??om do sejfu",
        null, null, (short) 0, 1);

    private static CustomItemWrapper createCustomItemWrapper(final String material,
        final String name, final String skinValue, final String skinSignature,
        final List<String> lore, final List<SpigotGuiEnchantmentWrapper> enchantments,
        final short data, final int amount) {
      final CustomItemWrapper wrapper = new CustomItemWrapper();
      wrapper.material = material;
      wrapper.name = name;
      wrapper.skinValue = skinValue;
      wrapper.skinSignature = skinSignature;
      wrapper.lore = lore;
      wrapper.enchantments = enchantments;
      wrapper.data = data;
      wrapper.amount = amount;
      return wrapper;
    }

    public static CustomCraftingWrapper createCustomCraftingWrapper(
        final CraftingItemWrapper resultWrapper,
        final Map<Integer, CraftingItemWrapper> ingredientWrappersMap) {
      final CustomCraftingWrapper wrapper = new CustomCraftingWrapper();
      wrapper.resultWrapper = resultWrapper;
      wrapper.ingredientWrappersMap = ingredientWrappersMap;
      return wrapper;
    }

    private static CraftingItemWrapper createCraftingItemWrapper(
        final CustomItemWrapper normalItemWrapper, final CustomItemType customItemType) {
      final CraftingItemWrapper wrapper = new CraftingItemWrapper();
      wrapper.normalItemWrapper = normalItemWrapper;
      wrapper.customItemType = customItemType;
      return wrapper;
    }

    private static RewardItemWrapper createRewardItemWrapper(
        final CustomItemWrapper normalItemWrapper, final CustomItemType customItemType) {
      final RewardItemWrapper wrapper = new RewardItemWrapper();
      wrapper.normalItemWrapper = normalItemWrapper;
      wrapper.customItemType = customItemType;
      return wrapper;
    }

    public static CustomItemWrapper createCustomItemWrapper(final String material,
        final String name, final List<String> lore,
        final List<SpigotGuiEnchantmentWrapper> enchantments, final short data, final int amount) {
      return createCustomItemWrapper(material, name, null, null, lore, enchantments, data, amount);
    }

    private static CraftingItemWrapper createCraftingItemWrapper(
        final CustomItemWrapper normalItemWrapper) {
      return createCraftingItemWrapper(normalItemWrapper, null);
    }

    private static RewardItemWrapper createRewardItemWrapper(
        final CustomItemWrapper normalItemWrapper) {
      return createRewardItemWrapper(normalItemWrapper, null);
    }

    public static final class GoldenHeadWrapper {

      public String name = "&6GHEAD";
      public List<String> lore = Arrays.asList(
          "&cdo_ustawienia1",
          "&ado_ustawienia2"
      );
      public List<SpigotGuiEnchantmentWrapper> enchantments = new ArrayList<>();
      @SerializedName("potion_effects")
      public List<PotionEffectWrapper> potionEffectWrapperList = Arrays.asList(
          new PotionEffectWrapper(
              "SPEED",
              1,
              120
          ),
          new PotionEffectWrapper(
              "JUMP",
              3,
              120
          )
      );
      @SerializedName("skin_value")
      public String skinValue = "do_ustawienia1";
      @SerializedName("skin_signature")
      public String skinSignature = "do_ustawienia2";
    }

    public static final class CustomCraftingWrapper {

      @SerializedName("result")
      public CraftingItemWrapper resultWrapper;
      @SerializedName("ingredients")
      public Map<Integer, CraftingItemWrapper> ingredientWrappersMap;

      public static final class CraftingItemWrapper {

        @SerializedName("normal_item")
        public CustomItemWrapper normalItemWrapper;
        @SerializedName("custom_item")
        public CustomItemType customItemType;
      }
    }

    public static final class SafeItemWrapper {

      public String name = "&dSejf";
      public String inventoryName = "&7Sejf: &d{SAFE_UNIQUE_ID}";
      public List<String> loreWithoutDescription = Arrays.asList(
          "&7ID Sejfu: &d{SAFE_UNIQUE_ID}",
          "&7Data utworzenia sejfu: &d{CREATION_DATE}",
          "&7Ostatnie otworzenie sejfu: &d{LAST_OPENED_DATE}",
          "&7W??a??ciciel sejfu: &d{SAFE_OWNER}"
      );
      public List<String> loreWithDescription = Arrays.asList(
          "&7ID Sejfu: &d{SAFE_UNIQUE_ID}",
          "&7Data utworzenia sejfu: &d{CREATION_DATE}",
          "&7Ostatnie otworzenie sejfu: &d{LAST_OPENED_DATE}",
          "&7W??a??ciciel sejfu: &d{SAFE_OWNER}",
          "&7Opis sejfu: &d{SAFE_DESCRIPTION}"
      );
    }

    public static final class GeneratorItemWrapper {

      public String name = "&6Generator Stone";
      public List<String> lore = Arrays.asList(
          "&8>> &7Aby utworzy?? &6Generator Stone",
          "&8>> &7postaw go na ziemie w odpowiednim",
          "&8>> &7i bezpiecznym miejscu!",
          "&8>> &7Nie chcesz mie?? ju?? generatora?",
          "&8>> &7Mo??esz go zniszczy?? u??ywaj??c &6z??otego kilofa&7!"
      );
      public List<SpigotGuiEnchantmentWrapper> enchantments = Collections.singletonList(
          createEnchantmentWrapper(
              "PROTECTION_ENVIRONMENTAL",
              10
          )
      );
    }

    public static final class CustomItemWrapper {

      public String material;
      public String name;
      public List<String> lore;
      public List<SpigotGuiEnchantmentWrapper> enchantments;
      @SerializedName("skin_value")
      public String skinValue;
      @SerializedName("skin_signature")
      public String skinSignature;
      public short data;
      public int amount;
    }

    public static final class RewardItemWrapper {

      @SerializedName("normal_item")
      public CustomItemWrapper normalItemWrapper;
      @SerializedName("custom_item")
      public CustomItemType customItemType;
    }
  }

  public static final class EnchantmentBlockadesWrapper {

    @SerializedName("item_blockades")
    public Map<String, List<EnchantmentBlockadeWrapper>> blockedEnchantmentsOnItemsMap = new LinkedHashMap<String, List<EnchantmentBlockadeWrapper>>() {{
      this.put("DIAMOND_SWORD", Collections.singletonList(
          createEnchantmentBlockadeWrapper(
              "DAMAGE_ALL",
              2
          )
      ));
      this.put("IRON_SWORD", Collections.singletonList(
          createEnchantmentBlockadeWrapper(
              "DAMAGE_ALL",
              3
          )
      ));
    }};
    @SerializedName("global_blockades")
    public List<EnchantmentBlockadeWrapper> blockedEnchantmentList = Collections.singletonList(
        createEnchantmentBlockadeWrapper(
            "DIG_SPEED",
            3
        )
    );

    private static EnchantmentBlockadeWrapper createEnchantmentBlockadeWrapper(
        final String enchantmentName, final int maxEnchantmentLevel) {
      final EnchantmentBlockadeWrapper wrapper = new EnchantmentBlockadeWrapper();
      wrapper.enchantmentName = enchantmentName;
      wrapper.maxEnchantmentLevel = maxEnchantmentLevel;
      return wrapper;
    }

    public static final class EnchantmentBlockadeWrapper {

      @SerializedName("enchantment_name")
      public String enchantmentName;
      @SerializedName("max_level")
      public int maxEnchantmentLevel;
    }
  }

  public static final class DropSettingsWrapper {

    @SerializedName("permissions_multipliers")
    public Map<String, Double> dropMultipliersPerPermissionsMap = new HashMap<String, Double>() {{
      this.put("platform-drop-vip", 1.2D);
      this.put("platform-drop-svip", 1.4D);
      this.put("platform-drop-champion", 1.6D);
    }};
    @SerializedName("drops")
    public List<DropWrapper> dropWrapperList = Collections.singletonList(
        createDropWrapper(
            "DIAMENT",
            "DIAMOND",
            100D,
            true,
            (short) 0,
            1,
            3,
            0,
            55,
            1F
        )
    );
    public double turboDropMultiplier = 2D;
    public long turboDropTime;

    private static DropWrapper createDropWrapper(final String name, final String material,
        final double chance, final boolean fortune, final short data, final int minAmount,
        final int maxAmount, final int minY, final int maxY, final float exp) {
      final DropWrapper wrapper = new DropWrapper();
      wrapper.name = name;
      wrapper.material = material;
      wrapper.chance = chance;
      wrapper.fortune = fortune;
      wrapper.data = data;
      wrapper.minAmount = minAmount;
      wrapper.maxAmount = maxAmount;
      wrapper.minY = minY;
      wrapper.maxY = maxY;
      wrapper.exp = exp;
      return wrapper;
    }

    public static class DropWrapper {

      public String name, material;
      public double chance;
      public boolean fortune;
      public short data;
      public int minAmount, maxAmount;
      public int minY, maxY;
      public float exp;
    }
  }

  public static final class KitWrapper {

    public String name;
    public String permission;
    public String time;
    public List<KitItemWrapper> items;

    public static class KitItemWrapper {

      public int id;
      public String material;
      public String name;
      public List<String> lore;
      public List<SpigotGuiEnchantmentWrapper> enchantments;
      public short data;
      public int amount;
      @SerializedName("custom_item")
      public CustomItemType customItemType;
    }
  }

  public static final class BlockedCommandsWrapper {

    @SerializedName("mainBlockedCommands")
    public List<String> mainBlockedCommandList = Arrays.asList(
        "/me",
        "/minecraft:me",
        "/bukkit:me"
    );
    @SerializedName("combatAllowedCommands")
    public List<String> combatAllowedCommandList = Arrays.asList(
        "/help",
        "/pomoc",
        "/vip",
        "/svip",
        "/yt",
        "/tell",
        "/msg",
        "/m",
        "/reply",
        "/r"
    );
  }

  public static final class EndScoreboardProfileWrapper {

    @SerializedName("title")
    public String endScoreboardTitle = "&5&lRose&f&lHc&f&l&7&l.pl";
    @SerializedName("lines")
    public List<String> endScoreboardEntries = Arrays.asList(
        "",
        " &fZnajdujesz si?? na",
        " sektorze: &d{SECTOR_NAME}",
        "",
        " &fGraczy: &d{ONLINE_PLAYERS}&7/&d{MAX_PLAYERS}",
        " &fTPS: &r{FORMATTED_TPS}",
        "",
        " &fZmiana miejsca teleportacji",
        " &fportalu za: &d{TELEPORTATION_POINT_CHANGE_TIME}",
        " &fZmiana po??o??enia portalu",
        " &fza: &d{PORTAL_POINT_CHANGE_TIME}"
    );
  }

  public static final class SpawnScoreboardProfileWrapper {

    @SerializedName("title")
    public String spawnScoreboardTitle = "&5&lRose&f&lHc&f&l&7&l.pl";
    @SerializedName("lines")
    public List<String> spawnScoreboardEntries = Arrays.asList(
        "",
        " &fZnajdujesz si?? na",
        " kanale: &d{SECTOR_NAME}",
        "",
        " &fGraczy: &d{ONLINE_PLAYERS}&7/&d{MAX_PLAYERS}",
        " &fTPS: &r{FORMATTED_TPS}",
        "",
        " &fAby zmieni?? kana?? spawna",
        " &fskorzystaj z komendy &d/ch"
    );
  }

  public static final class ProxyMotdWrapper {

    public String firstLine = "pierwsza", secondLine = "druga", thirdLine = "trzecia";
    public String playersInfo = "&7{ONLINE_PLAYERS}&8/&7{MAX_PLAYERS}";
    public List<String> hoverLines = Arrays.asList(
        "&7Strona: &dwww.rosehc.pl",
        "&7TS3: &dts.rosehc.pl",
        "&7Facebook: &dfb.rosehc.pl",
        "&7Discord: &ddc.rosehc.pl",
        "",
        "&7Proxy: &dproxy_{PROXY_IDENTIFIER}",
        "&7U??ycie procesora: &d{PROXY_CPU_USAGE}",
        "&7Licznik nie poka??e wi??cej graczy ni??: &d{COUNTER_PLAYERS_LIMIT}"
    );
    public int thirdLineSpacing = 24;
    public int counterPlayersLimit = 2000;
  }

  public static final class AntiGriefSettingsWrapper {

    public int minY = 40;
    public String removalTime = "30m";
    public List<String> ignoredAntiGriefBlockList = Arrays.asList(
        "ENDER_CHEST",
        "CHEST",
        "FURNACE",
        "WORKBENCH",
        "BOOKSHELF",
        "ENCHANTMENT_TABLE",
        "STONE_GENERATOR"
    );
  }

  public static final class AutoMessagesSettingsWrapper {

    public String broadcastTime = "1m";
    public transient long parsedBroadcastTime;
    public List<String> messages = Arrays.asList(
        "&1Sample Message1",
        "&2Sample Message2",
        "&3Sample Message3",
        "&4Sample Message4",
        "&5Sample Message5",
        "&6Sample Message6",
        "&7Sample Message7"
    );
  }

  public static final class MagicCaseItemWrapper {

    public String material;
    public String name;
    public List<String> lore;
    public List<SpigotGuiEnchantmentWrapper> enchantments;
    public double chance;
    public short data;
    public int minAmount, maxAmount;
    @SerializedName("custom_item")
    public CustomItemType customItemType;
  }

  public static final class CobbleXItemWrapper {

    public String material;
    public String name;
    public List<String> lore;
    public List<SpigotGuiEnchantmentWrapper> enchantments;
    public short data;
    public int minAmount, maxAmount;
  }

  public static final class SpecialBossBarWrapper {

    public String title = "&cTo przyk??adowy tytu?? specjalnego bossbara";
    public BarStyleWrapper barStyleWrapper = BarStyleWrapper.SOLID;
    public BarColorWrapper barColorWrapper = BarColorWrapper.PURPLE;
    public long expiryTime = System.currentTimeMillis() + 18_000_000L;
    public float expiryMaxBars = TimeUnit.MILLISECONDS.toSeconds(
        this.expiryTime - System.currentTimeMillis());
  }

  public static final class SimpleCustomCommandWrapper {

    public String name;
    public String description;
    public List<String> aliases;
    public List<String> messages;
  }

  public static final class RankWrapper {

    public String name, chatPrefix, chatSuffix, nameTagPrefix, nameTagSuffix;
    public List<String> permissions;
    public int priority;
    public boolean defaultRank;
  }

  public static final class ProxyWhitelistWrapper {

    public List<String> players = new ArrayList<>(Arrays.asList("inzynierr", "squeru"));
    public String reason = "&cPrzerwa techniczna.";
    public boolean enabled = true;
  }

  public static final class SlotWrapper {

    @SerializedName("proxy_slots")
    public int proxySlots = 2000;
    @SerializedName("spigot_slots")
    public int spigotSlots = 500;
  }
}
