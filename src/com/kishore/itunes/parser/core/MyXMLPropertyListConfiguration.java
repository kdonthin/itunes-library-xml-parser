/**
 * 
 */
package com.kishore.itunes.parser.core ;

import java.util.Date ;

import org.apache.commons.configuration.ConfigurationException ;
import org.apache.commons.configuration.ConversionException ;
import org.apache.commons.configuration.plist.XMLPropertyListConfiguration ;

/**
 * @author Kishore Donthineni
 *
 */
public class MyXMLPropertyListConfiguration extends XMLPropertyListConfiguration
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4601380451284420649L ;

	public MyXMLPropertyListConfiguration(String location) throws ConfigurationException
	{
		super(location) ;
	}

	public Date getDate(String key)
	{
		return (getDate(key, AppConstants.MinDate)) ;
	}

	public Date getDate(String key, Date defaultValue)
	{
		Object value = resolveContainerStore(key) ;

		if ( value instanceof Date )
		{
			return (Date) interpolate(value) ;
		}
		else if ( value == null )
		{
			return (Date) interpolate(defaultValue) ;
		}
		else
		{
			throw new ConversionException('\'' + key + "' doesn't map to a Date object") ;
		}
	}
}
