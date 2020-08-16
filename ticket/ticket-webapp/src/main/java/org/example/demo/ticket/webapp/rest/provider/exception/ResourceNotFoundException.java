package org.example.demo.ticket.webapp.rest.provider.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(Long id) {
		super("Resource introuvable" + id);
	}
}