package pl.rosehc.controller.packet.guild.user;

import pl.rosehc.adapter.redis.callback.CallbackPacket;
import pl.rosehc.adapter.redis.packet.PacketHandler;

public final class GuildUsersRequestPacket extends CallbackPacket {

  private String sectorName;

  private GuildUsersRequestPacket() {
  }

  public GuildUsersRequestPacket(final String sectorName) {
    this.sectorName = sectorName;
  }

  @Override
  public void handle(final PacketHandler ignored) {
  }

  public String getSectorName() {
    return this.sectorName;
  }
}