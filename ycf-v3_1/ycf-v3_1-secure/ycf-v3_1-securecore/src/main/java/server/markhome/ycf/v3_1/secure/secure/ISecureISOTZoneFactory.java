
// Description: Java JPA Factory interface for ISOTZone.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secure;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	ISecureISOTZoneFactory interface for ISOTZone
 */
public interface ISecureISOTZoneFactory extends ISecureProtISOTZoneFactory
{

	/**
	 *	Allocate a primary history key for ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOTZoneHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOTZone instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOTZoneHPKey asProtected(ISecureISOTZoneHPKey src);

	/**
	 *	Allocate a public primary history key for ISOTZone instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOTZoneHPKey asPublic(ISecureISOTZoneHPKey src);

	/**
	 *	Allocate a OffsetIdx key over ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOTZoneByOffsetIdxKey newByOffsetIdxKey();

	/**
	 *	Allocate a protected OffsetIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByOffsetIdxKey asProtected(ISecureISOTZoneByOffsetIdxKey src);

	/**
	 *	Allocate a public OffsetIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByOffsetIdxKey asPublic(ISecureISOTZoneByOffsetIdxKey src);

	/**
	 *	Allocate a UTZNameIdx key over ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOTZoneByUTZNameIdxKey newByUTZNameIdxKey();

	/**
	 *	Allocate a protected UTZNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByUTZNameIdxKey asProtected(ISecureISOTZoneByUTZNameIdxKey src);

	/**
	 *	Allocate a public UTZNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByUTZNameIdxKey asPublic(ISecureISOTZoneByUTZNameIdxKey src);

	/**
	 *	Allocate a Iso8601Idx key over ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOTZoneByIso8601IdxKey newByIso8601IdxKey();

	/**
	 *	Allocate a protected Iso8601Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByIso8601IdxKey asProtected(ISecureISOTZoneByIso8601IdxKey src);

	/**
	 *	Allocate a public Iso8601Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByIso8601IdxKey asPublic(ISecureISOTZoneByIso8601IdxKey src);

	/**
	 *	Allocate a ISOTZone interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOTZone newRec();

	/**
	 *	Allocate a protected ISOTZone interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZone asProtected(ISecureISOTZone src);

	/**
	 *	Allocate a public ISOTZone interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZone asPublic(ISecureISOTZone src);

	/**
	 *	Allocate a ISOTZone history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOTZoneH newHRec();

	/**
	 *	Allocate a protected ISOTZone history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneH asProtected(ISecureISOTZoneH src);

	/**
	 *	Allocate a public ISOTZone history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneH asPublic(ISecureISOTZoneH src);

}
