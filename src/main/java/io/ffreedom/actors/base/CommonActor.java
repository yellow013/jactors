package io.ffreedom.actors.base;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class CommonActor extends AbstractActor {

	protected final ActorRef self = getSelf();

	protected final ActorContext context = getContext();

	protected final LoggingAdapter logger = Logging.getLogger(getContext().getSystem(), this);

	protected CommonActor() {
		logger.info("Created -> {}", self);
	}

	protected void handleUnknown(Object obj) {
		logger.error("Received unmatched message -> class==[{}] obj==[{}]", obj.getClass().getName(), obj);
	}

	protected void stop() {
		logger.info("Destroy -> {}", self);
		getContext().stop(self);
	}

}
