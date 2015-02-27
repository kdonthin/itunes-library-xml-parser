/**
 * 
 */
package com.kishore.itunes.tools ;

import org.apache.log4j.PropertyConfigurator ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

import com.kishore.itunes.parser.core.TunesLibrary ;

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
		String libraryLocation = "" ;
		PropertyConfigurator.configure("log4j.properties") ;

		logger.info("Hello, World!") ;

		if ( args.length != 1 )
		{
			usage() ;

			return ;
		}

		libraryLocation = args[0] ;

		logger.info("Library Location : " + libraryLocation) ;
		
		TunesLibrary tunesLibrary = new TunesLibrary(libraryLocation) ;
		
		logger.info( tunesLibrary.toString() );
	}

	private static void usage()
	{
		String usageText = "usage:\njava -jar com.kishore.itunes.tools.jar <library file path>" ;

		logger.error(usageText) ;
	}

}
