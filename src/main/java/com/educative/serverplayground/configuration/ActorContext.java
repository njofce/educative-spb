package com.educative.serverplayground.configuration;

import com.educative.serverplayground.actor.Actor;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class ActorContext {

  private final Map<String, Actor> actors;
  private final Map<String, Object> boundObjects;

  public ActorContext(Map<String, Actor> actors) {
    this.actors = actors;
    this.boundObjects = new ConcurrentHashMap<>();
  }

  public Actor getActor(String name) {
    if (actors.containsKey(name)) return actors.get(name);
    throw new NoSuchElementException();
  }

  public Object getBoundObject(String actorName) {
    return boundObjects.get(actorName);
  }

  public void setBoundObject(String actorName, Object o) {
    boundObjects.put(actorName, o);
  }

  public Object removeBoundObject(String actorName) {
    return boundObjects.remove(actorName);
  }
}
