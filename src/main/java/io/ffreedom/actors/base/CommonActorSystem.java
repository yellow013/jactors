package io.ffreedom.actors.base;

import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

public final class CommonActorSystem {

	private final ActorSystem internal;

	public CommonActorSystem(String name) {
		this.internal = ActorSystem.create(name);
		// Add ShutdownHook
		Runtime.getRuntime().addShutdownHook(new Thread(internal::terminate));
	}

	public ActorSystem getInternal() {
		return internal;
	}

	public ActorRef actorOf(Props props) {
		return internal.actorOf(props);
	}

	public ActorRef actorOf(Props props, String name) {
		return internal.actorOf(props, name);
	}

	public ActorSelection actorSelectionOf(String path) {
		return internal.actorSelection(path);
	}

	public ActorSelection actorSelectionOf(ActorPath path) {
		return internal.actorSelection(path);
	}

}
