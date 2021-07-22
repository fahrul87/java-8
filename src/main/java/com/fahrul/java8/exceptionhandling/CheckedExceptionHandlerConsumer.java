package com.fahrul.java8.exceptionhandling;

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target, ExObj extends Exception> {

	public void accept(Target target) throws ExObj;
}