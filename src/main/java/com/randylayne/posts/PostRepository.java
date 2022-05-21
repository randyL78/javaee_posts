package com.randylayne.posts;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class PostRepository {
  private static Set<PostEntity> posts = new HashSet<>();

  public PostRepository() {
  }

  public static PostEntity createPost(PostEntity post) {
    posts.add(post);
    return post;
  }

  public static PostEntity getPost(UUID uuid) {
    return posts.stream().filter(post -> post.getUuid().equals(uuid)).collect(Collectors.toList()).get(0);
  }

  public static Set<PostEntity> getPosts() {
    return posts;
  }

  public static void setPosts(Set<PostEntity> posts) {
    PostRepository.posts = posts;
  }
}
