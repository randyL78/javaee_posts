package com.randylayne.posts;

import com.randylayne.eventhandler.Event;

public class PostEvent extends Event {
  public enum TYPES {
    CREATED {
      @Override
      public String toString() {
        return  "PostCreated";
      };
    }
  }
  public PostEvent(TYPES type, PostEntity post) {
    super(TYPES.CREATED.toString(), post);
  }

  public static PostEvent buildPostCreated(PostEntity post) {
    return new PostEvent(TYPES.CREATED, post);
  }
}
