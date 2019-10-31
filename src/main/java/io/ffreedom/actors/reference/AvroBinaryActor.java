package io.ffreedom.actors.reference;

import java.io.IOException;
import java.nio.ByteBuffer;

import io.ffreedom.actors.messages.AvroMessage;

public abstract class AvroBinaryActor extends SingleGenericActor<ByteBuffer> {

	@Override
	protected Class<ByteBuffer> eventType() {
		return ByteBuffer.class;
	}

	@Override
	protected final void onEvent(ByteBuffer binary) {
		try {
			AvroMessage message = AvroMessage.fromByteBuffer(binary);
			onAvroMessage(message);
		} catch (IOException e) {
			logger.error("ByteBuffer deserialization throw IOException, message==[{}], binary.capacity==[{}]",
					e.getMessage(), binary.capacity(), e);
		}
	}

	protected abstract void onAvroMessage(AvroMessage message);

}
