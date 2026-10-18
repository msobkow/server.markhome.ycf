
// Description: Java Protected Factory interface for ISOCcy.

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
 *	ISecureProtISOCcyFactory protected interface for ISOCcy
 */
public interface ISecureProtISOCcyFactory extends ISecurePubISOCcyFactory
{

	/**
	 *	Allocate a protected primary history key for ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOCcyHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for ISOCcy instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCcyHPKey asPublic(ISecureProtISOCcyHPKey src);

	/**
	 *	Allocate a protected CcyCdIdx key over protected ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyByCcyCdIdxKey newProtByCcyCdIdxKey();

	/**
	 *	Allocate a public CcyCdIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyByCcyCdIdxKey asPublic(ISecureProtISOCcyByCcyCdIdxKey src);

	/**
	 *	Allocate a protected CcyNmIdx key over protected ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyByCcyNmIdxKey newProtByCcyNmIdxKey();

	/**
	 *	Allocate a public CcyNmIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyByCcyNmIdxKey asPublic(ISecureProtISOCcyByCcyNmIdxKey src);

	/**
	 *	Allocate a protected ISOCcy interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcy newProtRec();

	/**
	 *	Allocate a public ISOCcy interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcy asPublic(ISecureProtISOCcy src);

	/**
	 *	Allocate a protected ISOCcy history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyH newProtHRec();

	/**
	 *	Allocate a public ISOCcy history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyH asPublic(ISecureProtISOCcyH src);

}
