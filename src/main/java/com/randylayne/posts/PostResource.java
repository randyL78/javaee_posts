package com.randylayne.posts;

import com.randylayne.eventhandler.EventBusService;
import com.randylayne.eventhandler.NodeEventBusService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.UUID;

@Path("posts")
public class PostResource {
  private EventBusService bus = new NodeEventBusService();
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPosts() {
    return Response.ok(PostRepository.getPosts()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(@Context UriInfo uriInfo, PostEntity post) {
    post.setUuid(UUID.randomUUID());
    PostRepository.createPost(post);
    bus.sendEvent(PostEvent.buildPostCreated(post));
    return Response.created(URI.create(uriInfo.getRequestUri() + post.getUuid().toString())).entity(post).build();
  }
}