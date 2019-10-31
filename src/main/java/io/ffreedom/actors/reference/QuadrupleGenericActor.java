package io.ffreedom.actors.reference;

import io.ffreedom.actors.base.CommonActor;

public abstract class QuadrupleGenericActor<T1, T2, T3, T4> extends CommonActor {

	private Class<T1> type1;
	private Class<T2> type2;
	private Class<T3> type3;
	private Class<T4> type4;

	protected QuadrupleGenericActor() {
		this.type1 = getType1();
		this.type2 = getType2();
		this.type3 = getType3();
		this.type4 = getType4();
	}

	@Override
	public final Receive createReceive() {
		return receiveBuilder().match(type1, this::handleType1).match(type2, this::handleType2)
				.match(type3, this::handleType3).match(type4, this::handleType4).matchAny(super::handleUnknown).build();
	}

	protected abstract Class<T1> getType1();

	protected abstract Class<T2> getType2();

	protected abstract Class<T3> getType3();

	protected abstract Class<T4> getType4();

	protected abstract void handleType1(T1 t1);

	protected abstract void handleType2(T2 t2);

	protected abstract void handleType3(T3 t2);

	protected abstract void handleType4(T4 t4);

}
