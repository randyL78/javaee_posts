package com.randylayne.posts;

import java.util.UUID;

public class PostEntity {
  private String title;
  private UUID uuid;

  public PostEntity() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
