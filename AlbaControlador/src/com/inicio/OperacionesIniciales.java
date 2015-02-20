package com.inicio;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OperacionesIniciales {

	private static ClassPathXmlApplicationContext ctx;
	public static void inicializa(){
		PropertyConfigurator.configure("log4j.properties");
		if(ctx == null)
			ctx = new ClassPathXmlApplicationContext( new String[] {"classpath:\\META-INF\\spring\\applicationContext.xml"});
	}
	
	
}
