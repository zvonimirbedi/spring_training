package com.aop.dao.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ServiceTraffic {

	public String getTraffic() {
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return delay	
		return "5 seconds delay on highway";
	}

	public String getTraffic(boolean tripWire) {
		
		if (tripWire)
			throw new RuntimeException("Big accident on the road! Dense traffic on highway!");
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return delay	
		return getTraffic();
	}
	
}
