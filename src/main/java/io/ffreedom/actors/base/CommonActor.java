package io.ffreedom.actors.base;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class CommonActor extends AbstractActor {

	protected final ActorRef self = getSelf();

	protected final LoggingAdapter logger = Logging.getLogger(getContext().getSystem(), this);

	protected void handleUnknown(Object obj) {
		logger.error("Received unmatched message -> class==[{}] obj==[{}]", obj.getClass(), obj);
	}

}
