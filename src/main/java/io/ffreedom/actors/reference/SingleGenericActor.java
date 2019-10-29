package io.ffreedom.actors.reference;

import io.ffreedom.actors.base.CommonActor;

public abstract class SingleGenericActor<T> extends CommonActor {

	private Class<T> type;

	protected SingleGenericActor() {
		this.type = getType();
	}

	@Override
	public final Receive createReceive() {
		return newReceiveBuilder().match(type, this::handle).build();
	}

	protected abstract Class<T> getType();

	protected abstract void handle(T t);

}
