package org.inventivetalent.particle;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ParticleException extends RuntimeException {
	public ParticleException() {
	}

	public ParticleException(String message) {
		super(message);
	}

	public ParticleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParticleException(Throwable cause) {
		super(cause);
	}

	public ParticleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
