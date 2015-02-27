/**
 * 
 */
package com.kishore.itunes.parser.core ;

import java.util.Date ;

import org.apache.commons.configuration.ConfigurationException ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

/**
 * @author Kishore Donthineni
 *
 */
public class TunesLibrary
{
	private String location ;
	private int majorVersion ;
	private int minorVersion ;
	private Date modifiedDate ;
	private String applicationVersion ;
	private int features ;
	private boolean showContentRatings ;
	private String musicFolder ;
	private String libraryPersistentId ;
	private MyXMLPropertyListConfiguration config = null ;
	private Logger logger = LoggerFactory.getLogger(TunesLibrary.class) ;

	public TunesLibrary(String location)
	{
		this.setLocation(location) ;

		try
		{
			config = new MyXMLPropertyListConfiguration(location) ;

			setMajorVersion(config.getInt(AppConstants.MajorVersionKey, 0)) ;
			setMinorVersion(config.getInt(AppConstants.MinorVersionKey, 0)) ;
			setModifiedDate(config.getDate(AppConstants.ModifiedDateKey)) ;
			setApplicationVersion(config.getString(AppConstants.ApplicationVersionKey, "")) ;
			setFeatures(config.getInt(AppConstants.FeaturesKey, 0)) ;
			setShowContentRatings(config.getBoolean(AppConstants.ShowContentRatingsKey, false)) ;
			setMusicFolder(config.getString(AppConstants.MusicFolderKey, "")) ;
			setLibraryPersistentId(config.getString(AppConstants.LibraryPersistentIdKey, "")) ;
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

	public int getMajorVersion()
	{
		return majorVersion ;
	}

	private void setMajorVersion(int majorVersion)
	{
		this.majorVersion = majorVersion ;
	}

	public int getMinorVersion()
	{
		return minorVersion ;
	}

	private void setMinorVersion(int minorVersion)
	{
		this.minorVersion = minorVersion ;
	}

	public Date getModifiedDate()
	{
		return modifiedDate ;
	}

	private void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate ;
	}

	public String getApplicationVersion()
	{
		return applicationVersion ;
	}

	private void setApplicationVersion(String applicationVersion)
	{
		this.applicationVersion = applicationVersion ;
	}

	public int getFeatures()
	{
		return features ;
	}

	private void setFeatures(int features)
	{
		this.features = features ;
	}

	public boolean isShowContentRatings()
	{
		return showContentRatings ;
	}

	private void setShowContentRatings(boolean showContentRatings)
	{
		this.showContentRatings = showContentRatings ;
	}

	public String getMusicFolder()
	{
		return musicFolder ;
	}

	private void setMusicFolder(String musicFolder)
	{
		this.musicFolder = musicFolder ;
	}

	public String getLibraryPersistentId()
	{
		return libraryPersistentId ;
	}

	private void setLibraryPersistentId(String libraryPersistentId)
	{
		this.libraryPersistentId = libraryPersistentId ;
	}

	public void loadLibrary()
	{

	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder() ;

		builder.append("TunesLibrary:\n") ;
		builder.append(AppConstants.MajorVersionKey + " : " + getMajorVersion() + "\n") ;
		builder.append(AppConstants.MinorVersionKey + " : " + getMinorVersion() + "\n") ;
		builder.append("Modified Date : " + getModifiedDate() + "\n") ;
		builder.append(AppConstants.ApplicationVersionKey + " : " + getApplicationVersion() + "\n") ;
		builder.append(AppConstants.FeaturesKey + " : " + getFeatures() + "\n") ;
		builder.append(AppConstants.ShowContentRatingsKey + " : " + isShowContentRatings() + "\n") ;
		builder.append(AppConstants.MusicFolderKey + " : " + getMusicFolder() + "\n") ;
		builder.append(AppConstants.LibraryPersistentIdKey + " : " + getLibraryPersistentId() + "\n") ;

		return builder.toString() ;
	}
}
