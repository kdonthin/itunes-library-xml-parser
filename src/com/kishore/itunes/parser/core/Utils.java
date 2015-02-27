/**
 * 
 */
package com.kishore.itunes.parser.core ;

import java.text.ParseException ;
import java.text.SimpleDateFormat ;
import java.util.Date ;

/**
 * @author Kishore Donthineni
 *
 */
public class Utils
{
	public static Date getISODate(String isoDateString)
	{
		Date date = new Date() ;
		SimpleDateFormat isoDateFormat = new SimpleDateFormat(AppConstants.ISODateTimeFormat) ;

		try
		{
			date = isoDateFormat.parse(isoDateString) ;
		}
		catch ( ParseException e )
		{
			// e.printStackTrace();
		}

		return (date) ;
	}
}
