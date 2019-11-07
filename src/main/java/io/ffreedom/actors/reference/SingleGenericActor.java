package io.ffreedom.actors.reference;

import io.ffreedom.actors.base.CommonActor;

public abstract class SingleGenericActor<T> extends CommonActor {

	private Class<T> type;

	protected SingleGenericActor() {
		this.type = eventType();
	}

	@Override
	public final Receive createReceive() {
		return receiveBuilder().match(type, this::onEvent).matchAny(this::handleUnknown).build();
	}

	private void handleUnknown(Object obj) {
		commonHandleUnknown(obj);
		handleUnknown0(obj);
	}

	protected abstract Class<T> eventType();

	protected abstract void onEvent(T t);

	protected abstract void handleUnknown0(Object t);

}
