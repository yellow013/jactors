package io.ffreedom.actors.reference;

import io.ffreedom.actors.base.CommonActor;

public abstract class TripleGenericActor<T1, T2, T3> extends CommonActor {

	private Class<T1> type1;
	private Class<T2> type2;
	private Class<T3> type3;

	protected TripleGenericActor() {
		this.type1 = getType1();
		this.type2 = getType2();
		this.type3 = getType3();
	}

	@Override
	public final Receive createReceive() {
		return newReceiveBuilder().match(type1, this::handleType1).match(type2, this::handleType2)
				.match(type3, this::handleType3).build();
	}

	protected abstract Class<T1> getType1();

	protected abstract Class<T2> getType2();

	protected abstract Class<T3> getType3();

	protected abstract void handleType1(T1 t1);

	protected abstract void handleType2(T2 t2);

	protected abstract void handleType3(T3 t2);

}
