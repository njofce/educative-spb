package com.educative.serverplayground.configuration;

import com.educative.serverplayground.actor.Actor;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ActorScope implements Scope {

  private final ActorContext actorContext;
  private final Map<String, Runnable> destructionCallbacks = new HashMap<>();

  public ActorScope(ActorContext actorContext) {
    this.actorContext = actorContext;
  }

  @Override
  public Object get(String actorName, ObjectFactory<?> objectFactory) {
    Actor actor = actorContext.getActor(actorName);
    if (actor.isActorAlive()) {
      Object boundObject = actorContext.getBoundObject(actorName);
      if (boundObject == null) {
        Object object = objectFactory.getObject();
        actorContext.setBoundObject(actorName, object);
        return object;
      }
      return boundObject;
    } else {
      throw new NoSuchElementException();
    }
  }

  @Override
  public Object remove(String actorName) {
    destructionCallbacks.remove(actorName);
    return actorContext.removeBoundObject(actorName);
  }

  @Override
  public void registerDestructionCallback(String actorName, Runnable callback) {
    destructionCallbacks.put(actorName, callback);
  }

  @Override
  public Object resolveContextualObject(String actorName) {
    return null;
  }

  @Override
  public String getConversationId() {
    return "actor";
  }
}
