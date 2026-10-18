
// Description: Java Protected Factory interface for ISOTZone.

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

package server.markhome.ycf.v3_1.secure.secureprot;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	ISecureProtISOTZoneFactory protected interface for ISOTZone
 */
public interface ISecureProtISOTZoneFactory extends ISecurePubISOTZoneFactory
{

	/**
	 *	Allocate a protected primary history key for ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOTZoneHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for ISOTZone instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOTZoneHPKey asPublic(ISecureProtISOTZoneHPKey src);

	/**
	 *	Allocate a protected OffsetIdx key over protected ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByOffsetIdxKey newProtByOffsetIdxKey();

	/**
	 *	Allocate a public OffsetIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByOffsetIdxKey asPublic(ISecureProtISOTZoneByOffsetIdxKey src);

	/**
	 *	Allocate a protected UTZNameIdx key over protected ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByUTZNameIdxKey newProtByUTZNameIdxKey();

	/**
	 *	Allocate a public UTZNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByUTZNameIdxKey asPublic(ISecureProtISOTZoneByUTZNameIdxKey src);

	/**
	 *	Allocate a protected Iso8601Idx key over protected ISOTZone instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneByIso8601IdxKey newProtByIso8601IdxKey();

	/**
	 *	Allocate a public Iso8601Idx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneByIso8601IdxKey asPublic(ISecureProtISOTZoneByIso8601IdxKey src);

	/**
	 *	Allocate a protected ISOTZone interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZone newProtRec();

	/**
	 *	Allocate a public ISOTZone interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZone asPublic(ISecureProtISOTZone src);

	/**
	 *	Allocate a protected ISOTZone history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOTZoneH newProtHRec();

	/**
	 *	Allocate a public ISOTZone history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOTZoneH asPublic(ISecureProtISOTZoneH src);

}
