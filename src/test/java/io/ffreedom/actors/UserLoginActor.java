package io.ffreedom.actors;

import akka.actor.Props;
import io.ffreedom.actors.reference.SingleGenericActor;

public class UserLoginActor extends SingleGenericActor<User> {
//    private Object parameters;

	public static Props props() {
		return Props.create(UserLoginActor.class, UserLoginActor::new);
	}

	// 如果有构造参数, 便按照如下方式构造 Props 即可
//    public static Props props(Object parameters) {
//        return Props.create(UserLoginActor.class, () -> new UserLoginActor(parameters));
//    }
//
//    private UserLoginActor(Object parameters) {
//        this.parameters = parameters;
//    }

	@Override
	protected void handle(User user) {
		System.out.println("received user -> userId==[" + user.getUserId() + "], userName==[" + user.getUserName()
				+ "], age==[" + user.getAge() + "]");
	}

	@Override
	protected Class<User> getType() {
		return User.class;
	}

	@Override
	protected void handleUnknown(Object obj) {

	}

}