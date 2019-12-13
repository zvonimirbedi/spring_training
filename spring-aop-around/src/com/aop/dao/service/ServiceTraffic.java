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
		return "5 seconds delay";
	}
	
}
