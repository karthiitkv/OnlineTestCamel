package org.kvkit.camelexamples;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCamel {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void main(String[] args) throws Exception {
		
		//springBasic();
		//springMultiRoutes();
		//directExample();
		//redirectExample();
		//camelExchange();
		timerSample();
	}

	private static void springBasic() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:test.queue", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	
	private static void springMultiRoutes() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:test.queue1", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	
	private static void directExample() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("direct:example", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	
	private static void redirectExample() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("direct:redirectExample", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	
	private static void camelExchange() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("direct:exchange", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	
	private static void timerSample() throws Exception {
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("controlbus:route?routeId=timerSample&action=start", "Hello World");
			Thread.sleep(10000);
		} finally {
			camelContext.stop();
		}
	}
	
}
