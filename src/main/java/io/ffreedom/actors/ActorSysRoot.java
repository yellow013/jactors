package io.ffreedom.actors;

import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import io.ffreedom.actors.base.CommonActorSystem;

public enum ActorSysRoot {

	INSTANCE,

	;

	private CommonActorSystem actorSystem = new CommonActorSystem("root");

	public ActorSystem getActorSystem() {
		return actorSystem.getInternal();
	}

	public ActorRef actorAtRootOf(Props props) {
		return actorSystem.actorOf(props);
	}

	public ActorRef actorAtRootOf(Props props, String name) {
		return actorSystem.actorOf(props, name);
	}

	public ActorSelection actorSelectionAtRootOf(String path) {
		return actorSystem.actorSelectionOf(path);
	}

	public ActorSelection actorSelectionAtRootOf(ActorPath path) {
		return actorSystem.actorSelectionOf(path);
	}

	public static void main(String[] args) {

	}

}
