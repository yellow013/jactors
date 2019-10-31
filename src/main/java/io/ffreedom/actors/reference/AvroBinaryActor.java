package io.ffreedom.actors.reference;

import java.io.IOException;
import java.nio.ByteBuffer;

import io.ffreedom.actors.messages.AvroMessage;

public abstract class AvroBinaryActor extends SingleGenericActor<ByteBuffer> {

	@Override
	protected Class<ByteBuffer> getType() {
		return ByteBuffer.class;
	}

	@Override
	protected final void handle(ByteBuffer binary) {
		try {
			AvroMessage message = AvroMessage.fromByteBuffer(binary);
			handleAvroMessage(message);
		} catch (IOException e) {
			logger.error("ByteBuffer deserialization throw IOException, message==[{}], binary.capacity==[{}]",
					e.getMessage(), binary.capacity(), e);
		}
	}

	protected abstract void handleAvroMessage(AvroMessage message);

}
