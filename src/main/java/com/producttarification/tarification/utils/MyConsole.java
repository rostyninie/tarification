package com.producttarification.tarification.utils;

public final class MyConsole {
	
	private static final MyConsole instance = new MyConsole();

    private MyConsole(){}

    public static MyConsole getInstance(){
        return instance;
    }

    public void displayF(String message){
    	
        System.out.println(message);
    }
}
