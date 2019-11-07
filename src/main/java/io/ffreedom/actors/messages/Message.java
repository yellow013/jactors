package io.ffreedom.actors.messages;

public class RegisterMsg {

	private final String actor;

	public RegisterMsg(String actor) {
		super();
		this.actor = actor;
	}

	public String getActor() {
		return actor;
	}

}
