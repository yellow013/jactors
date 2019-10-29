package io.ffreedom.actors.primitive;

import io.ffreedom.actors.base.CommonActor;

public abstract class DoubleActor extends CommonActor {

	@Override
	public Receive createReceive() {
		return newReceiveBuilder().match(Double.class, this::handle).build();
	}

	private void handle(Double d) {
		handleDouble(d.doubleValue());
	}

	protected abstract void handleDouble(double d);

}
