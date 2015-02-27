/**
 * 
 */
package com.kishore.itunes.parser.core ;

import org.apache.commons.configuration.ConfigurationException ;
import org.apache.commons.configuration.plist.XMLPropertyListConfiguration ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

/**
 * @author Kishore Donthineni
 *
 */
public class TunesLibrary
{
	private String location ;
	private XMLPropertyListConfiguration config = null ;
	private Logger logger = LoggerFactory.getLogger(TunesLibrary.class) ;

	public TunesLibrary(String location)
	{
		this.setLocation(location) ;

		try
		{
			config = new XMLPropertyListConfiguration(location) ;
		}
		catch ( ConfigurationException ce )
		{
			logger.error("Caught Exception while loading iTunes Library file..." + ce.getMessage()) ;

			ce.printStackTrace() ;
		}
	}

	public String getLocation()
	{
		return location ;
	}

	private void setLocation(String location)
	{
		this.location = location ;
	}

	public String getMusicFolder()
	{
		String musicFolder = "" ;

		if ( config != null )
		{
			musicFolder = config.getString(AppConstants.MusicFolderKey) ;
		}

		return (musicFolder) ;
	}

	public void loadLibrary()
	{

	}
}
