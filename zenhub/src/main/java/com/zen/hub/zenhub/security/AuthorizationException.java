package com.zen.hub.zenhub.security;

public class AuthorizationException extends RuntimeException {
	
	public AuthorizationException() {
	super("Access Denied");
	}
}
