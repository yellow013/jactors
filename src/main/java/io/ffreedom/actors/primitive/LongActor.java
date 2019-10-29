package io.ffreedom.actors.primitive;

import io.ffreedom.actors.base.CommonActor;

public abstract class LongActor extends CommonActor {

	@Override
	public Receive createReceive() {
		return newReceiveBuilder().match(Long.class, this::handle).build();
	}

	private void handle(Long l) {
		handleLong(l.longValue());
	}

	protected abstract void handleLong(long l);

}
