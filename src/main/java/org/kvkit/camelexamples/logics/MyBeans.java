package org.kvkit.camelexamples.logics;

import org.apache.camel.Exchange;

public class MyBeans {
	public String appendCamel(String msg) {
		return msg + " Camel";
	}
	
	public String justToPrint(String msg) {
		return msg + " Printed";
	}
	
	public void exchageFirst(Exchange exchange) {
		System.out.println(exchange.toString());
		System.out.println(exchange.getIn().getBody());
		exchange.getOut().setBody("This message is from Exchange");
	}
	
	public void exchageSecond(Exchange exchange) {
		System.out.println("sysout: "+exchange.getIn().getBody());
	}
	
	public void timerSample(Exchange exchange) {
		System.out.println("Counter : "+exchange.getProperty(Exchange.TIMER_COUNTER));
		System.out.println("Time : "+exchange.getProperty(Exchange.TIMER_FIRED_TIME));
		System.out.println("Hello World Camel fired at "+exchange.getIn().getHeader("firedTime"));
	}
}
