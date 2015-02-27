/**
 * 
 */
package com.kishore.itunes.tools ;

import org.apache.log4j.PropertyConfigurator ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

/**
 * @author Kishore Donthineni
 *
 */
public class MainClass
{
	private static Logger logger = LoggerFactory.getLogger(MainClass.class) ;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties") ;
		
		logger.info("Hello, World!") ;
	}

}
