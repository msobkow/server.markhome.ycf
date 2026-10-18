// Description: Java 25 Public Table Object interface for IntNetPub.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetpubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubLicenseTableObj
{
	public IIntNetPubSchemaObj getSchema();
	public void setSchema( IIntNetPubSchemaObj value );

	public void minimizeMemory();

	public String getTableName();
	public String getTableDbName();

	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	public int getClassCode();

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	// public static int getBackingClassCode();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new License instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetPubLicenseObj newInstance();

	/**
	 *	Instantiate a new License edition of the specified License instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubLicenseEditObj newEditInstance( IIntNetPubLicenseObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubLicenseObj instance, which may be a subclass of a License instance.
	 */
	IIntNetPubLicenseObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubLicenseObj realiseLicense( IIntNetPubLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubLicenseObj createLicense( IIntNetPubLicenseObj Obj );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubLicenseObj readLicense( IYCFKeyHash256 pkey );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubLicenseObj readLicense( IYCFKeyHash256 pkey,
		boolean forceRead );

	IIntNetPubLicenseObj readCachedLicense( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeLicense( IIntNetPubLicenseObj obj );

	void deepDisposeLicense( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubLicenseObj lockLicense( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the License-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubLicenseObj> readAllLicense();

	/**
	 *	Return a sorted map of all the License-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubLicenseObj> readAllLicense( boolean forceRead );

	List<IIntNetPubLicenseObj> readCachedAllLicense();

	/**
	 *	Get the IntNetPubLicenseObj instance for the primary key attributes.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubLicenseObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubLicenseObj readLicenseByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the IntNetPubLicenseObj instance for the primary key attributes.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubLicenseObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubLicenseObj readLicenseByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubLicenseObj instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubLicenseObj cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubLicenseObj> readLicenseByLicnTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of IntNetPubLicenseObj instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubLicenseObj cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubLicenseObj> readLicenseByLicnTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubLicenseObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubLicenseObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubLicenseObj> readLicenseByDomainIdx( YCFDbKeyHash256 TopDomainId );

	/**
	 *	Get the map of IntNetPubLicenseObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubLicenseObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubLicenseObj> readLicenseByDomainIdx( YCFDbKeyHash256 TopDomainId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubLicenseObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubLicenseObj readLicenseByUNameIdx(YCFDbKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Get the IntNetPubLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubLicenseObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubLicenseObj readLicenseByUNameIdx(YCFDbKeyHash256 TopDomainId,
		String Name,
		boolean forceRead );

	IIntNetPubLicenseObj readCachedLicenseByIdIdx( YCFDbKeyHash256 Id );

	List<IIntNetPubLicenseObj> readCachedLicenseByLicnTenantIdx( YCFDbKeyHash256 TenantId );

	List<IIntNetPubLicenseObj> readCachedLicenseByDomainIdx( YCFDbKeyHash256 TopDomainId );

	IIntNetPubLicenseObj readCachedLicenseByUNameIdx( YCFDbKeyHash256 TopDomainId,
		String Name );

	void deepDisposeLicenseByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeLicenseByLicnTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeLicenseByDomainIdx( YCFDbKeyHash256 TopDomainId );

	void deepDisposeLicenseByUNameIdx( YCFDbKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubLicenseObj updateLicense( IIntNetPubLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteLicense( IIntNetPubLicenseObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByLicnTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByDomainIdx( YCFDbKeyHash256 TopDomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByUNameIdx(YCFDbKeyHash256 TopDomainId,
		String Name );
}
