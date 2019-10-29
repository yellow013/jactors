package io.ffreedom.actors;

import akka.actor.ActorRef;

public class ActorTest {

	public static void main(String[] args) {

		ActorRef userLoginActor = ActorSysRoot.INSTANCE.actorAtRootOf(UserLoginActor.props(),
				UserLoginActor.class.getName());
		userLoginActor.tell(new User(1, "user1", 10), ActorRef.noSender());
		userLoginActor.tell("dafaf", ActorRef.noSender());

	}

}
