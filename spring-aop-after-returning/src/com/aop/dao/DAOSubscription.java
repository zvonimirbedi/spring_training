package com.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.Subscription;

@Component
public class DAOSubscription {
	
	public List<Subscription> findSubscriptions(){
		
		List<Subscription> theSubscriptions =  new ArrayList<>();
		
		Subscription Ivo = new Subscription("Wool","Ivo@gmail.com","Ivo");
		Subscription Luka = new Subscription("Silk","Luka@hotmail.com","Luka");
		Subscription Steve = new Subscription("Cashmere","Steve@outlook.com","Steve");
		theSubscriptions.add(Ivo);
		theSubscriptions.add(Luka);
		theSubscriptions.add(Steve);
		
				return theSubscriptions;
	}

	public boolean getServerConnection(Subscription theSubscription, boolean vipFlag) {		
		System.out.println(getClass() + ": Doing db work: log in console");
		return true;
	}
	
	public void goToSleep() {		
		System.out.println(getClass() + ": Going to sleep... zzzzz");
	}
}
