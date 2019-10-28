package io.ffreedom.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class UserLoginActor extends AbstractActor {
//    private Object parameters;

	public static Props props() {
		return Props.create(UserLoginActor.class, UserLoginActor::new);
	}

	private UserLoginActor() {
	}

	// 如果有构造参数, 便按照如下方式构造 Props 即可
//    public static Props props(Object parameters) {
//        return Props.create(UserLoginActor.class, () -> new UserLoginActor(parameters));
//    }
//
//    private UserLoginActor(Object parameters) {
//        this.parameters = parameters;
//    }

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(User.class, this::handleUser).matchAny(this::handleElse).build();
	}

	private void handleUser(User user) {
		getSender().tell("received user ", ActorRef.noSender());
	}

	private void handleElse(Object obj) {

	}

}