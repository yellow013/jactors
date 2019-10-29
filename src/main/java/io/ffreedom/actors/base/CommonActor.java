package io.ffreedom.actors.base;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public abstract class CommonActor extends AbstractActor {

	protected ActorRef self = getSelf();

	protected LoggingAdapter logger = Logging.getLogger(getContext().getSystem(), this);

	protected ReceiveBuilder newReceiveBuilder() {
		return receiveBuilder().matchAny(this::commonHandleUnknown);
	}

	private void commonHandleUnknown(Object obj) {
		logger.error("Received unmatched message -> class==[{}] obj==[{}]", obj.getClass(), obj);
		handleUnknown(obj);
	}

	protected abstract void handleUnknown(Object obj);

}
