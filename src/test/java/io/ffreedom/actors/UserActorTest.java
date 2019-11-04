package io.ffreedom.actors;

import akka.actor.ActorRef;
import io.ffreedom.actors.base.CommonActorSystem;
import io.ffreedom.common.thread.ThreadUtil;

public class UserActorTest {

	public static void main(String[] args) {

		CommonActorSystem actorSystem = CommonActorSystem.newInstance("data-center");

		ActorRef userLoginActor = actorSystem.actorOf(UserActor.props(), UserActor.class.getName());

		userLoginActor.tell(new User(1, "user1", 10), ActorRef.noSender());
		userLoginActor.tell("dafaf", ActorRef.noSender());

		ThreadUtil.sleep(3000);
		System.exit(0);

	}

}
