package io.ffreedom.actors;

import org.eclipse.collections.api.list.MutableList;

import akka.actor.ActorRef;
import io.ffreedom.actors.messages.RegisterMsg;
import io.ffreedom.actors.reference.DoubleGenericActor;
import io.ffreedom.common.collections.MutableLists;

public abstract class SimpleDealerActor<T> extends DoubleGenericActor<RegisterMsg, T> {

	private MutableList<ActorRef> registered;

	private int turn = -1;

	protected SimpleDealerActor() {
		this.registered = MutableLists.newFastList(8);
	}

	@Override
	protected Class<RegisterMsg> eventType1() {
		return RegisterMsg.class;
	}

	@Override
	protected void onEvent1(RegisterMsg t1) {
		// TODO 添加到注册列表
		registered.add(null);
	}

	@Override
	protected void onEvent2(T t2) {
		if (registered.isEmpty()) {
			// TODO 处理注册列表为空
		} else {
			registered.get(nextActor()).tell(t2, self);
		}
	}

	private int nextActor() {
		if (++turn == registered.size())
			turn = 0;
		return turn;
	}

}
