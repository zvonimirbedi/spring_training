package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.Subscription;

@Component
public class DAOSubscription {

	public boolean getServerConnection(Subscription theSubscription, boolean vipFlag) {		
		System.out.println(getClass() + ": Doing db work: log in console");
		return true;
	}
	
	public void goToSleep() {		
		System.out.println(getClass() + ": Going to sleep... zzzzz");
	}
}
