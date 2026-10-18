// Description: Java 25 Protected Table Object interface for IntNetProt.

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

package server.markhome.ycf.v3_1.intnet.intnetprotobj;

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
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IIntNetProtLicenseTableObj
{
	public IIntNetProtSchemaObj getSchema();
	public void setSchema( IIntNetProtSchemaObj value );

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
	IIntNetProtLicenseObj newInstance();

	/**
	 *	Instantiate a new License edition of the specified License instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtLicenseEditObj newEditInstance( IIntNetProtLicenseObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtLicenseEditObj instance, which may be a subclass of a License instance.
	 */
	IIntNetProtLicenseObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtLicenseObj realiseLicense( IIntNetProtLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtLicenseObj createLicense( IIntNetProtLicenseObj Obj );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtLicenseObj readLicense( YCFDbKeyHash256 pkey );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtLicenseObj readLicense( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtLicenseObj readCachedLicense( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeLicense( IIntNetProtLicenseObj obj );

	void deepDisposeLicense( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtLicenseObj lockLicense( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the License-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtLicenseObj> readAllLicense();

	/**
	 *	Return a sorted map of all the License-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtLicenseObj> readAllLicense( boolean forceRead );

	List<IIntNetProtLicenseObj> readCachedAllLicense();

	/**
	 *	Get the IIntNetProtLicenseObj instance for the primary key attributes.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtLicenseObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtLicenseObj readLicenseByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtLicenseObj instance for the primary key attributes.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtLicenseObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtLicenseObj readLicenseByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtLicenseObj> instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtLicenseObj> cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtLicenseObj> readLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtLicenseObj> instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtLicenseObj> cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtLicenseObj> readLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtLicenseObj> instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtLicenseObj> cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtLicenseObj> readLicenseByDomainIdx( IYCFKeyHash256 TopDomainId );

	/**
	 *	Get the map of List<IIntNetProtLicenseObj> instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtLicenseObj> cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtLicenseObj> readLicenseByDomainIdx( IYCFKeyHash256 TopDomainId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtLicenseObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtLicenseObj readLicenseByUNameIdx(IYCFKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Get the IIntNetProtLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtLicenseObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtLicenseObj readLicenseByUNameIdx(IYCFKeyHash256 TopDomainId,
		String Name,
		boolean forceRead );

	IIntNetProtLicenseObj readCachedLicenseByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtLicenseObj>> readCachedLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IIntNetProtLicenseObj>> readCachedLicenseByDomainIdx( IYCFKeyHash256 TopDomainId );

	IIntNetProtLicenseObj readCachedLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name );

	void deepDisposeLicenseByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeLicenseByDomainIdx( IYCFKeyHash256 TopDomainId );

	void deepDisposeLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtLicenseObj updateLicense( IIntNetProtLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteLicense( IIntNetProtLicenseObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByDomainIdx( IYCFKeyHash256 TopDomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	Name	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByUNameIdx(IYCFKeyHash256 TopDomainId,
		String Name );
}
