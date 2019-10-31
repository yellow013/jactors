package io.ffreedom.actors.reference;

import io.ffreedom.actors.base.CommonActor;

public abstract class DoubleGenericActor<T1, T2> extends CommonActor {

	private Class<T1> type1;
	private Class<T2> type2;

	protected DoubleGenericActor() {
		this.type1 = getType1();
		this.type2 = getType2();
	}

	@Override
	public final Receive createReceive() {
		return receiveBuilder().match(type1, this::handleType1).match(type2, this::handleType2)
				.matchAny(super::handleUnknown).build();
	}

	protected abstract Class<T1> getType1();

	protected abstract Class<T2> getType2();

	protected abstract void handleType1(T1 t1);

	protected abstract void handleType2(T2 t2);

}
