
// Description: Java JPA Factory interface for ISOCcy.

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
 *	ISecureISOCcyFactory interface for ISOCcy
 */
public interface ISecureISOCcyFactory extends ISecureProtISOCcyFactory
{

	/**
	 *	Allocate a primary history key for ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOCcyHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOCcy instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOCcyHPKey asProtected(ISecureISOCcyHPKey src);

	/**
	 *	Allocate a public primary history key for ISOCcy instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCcyHPKey asPublic(ISecureISOCcyHPKey src);

	/**
	 *	Allocate a CcyCdIdx key over ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCcyByCcyCdIdxKey newByCcyCdIdxKey();

	/**
	 *	Allocate a protected CcyCdIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyByCcyCdIdxKey asProtected(ISecureISOCcyByCcyCdIdxKey src);

	/**
	 *	Allocate a public CcyCdIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyByCcyCdIdxKey asPublic(ISecureISOCcyByCcyCdIdxKey src);

	/**
	 *	Allocate a CcyNmIdx key over ISOCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCcyByCcyNmIdxKey newByCcyNmIdxKey();

	/**
	 *	Allocate a protected CcyNmIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyByCcyNmIdxKey asProtected(ISecureISOCcyByCcyNmIdxKey src);

	/**
	 *	Allocate a public CcyNmIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyByCcyNmIdxKey asPublic(ISecureISOCcyByCcyNmIdxKey src);

	/**
	 *	Allocate a ISOCcy interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCcy newRec();

	/**
	 *	Allocate a protected ISOCcy interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcy asProtected(ISecureISOCcy src);

	/**
	 *	Allocate a public ISOCcy interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcy asPublic(ISecureISOCcy src);

	/**
	 *	Allocate a ISOCcy history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCcyH newHRec();

	/**
	 *	Allocate a protected ISOCcy history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCcyH asProtected(ISecureISOCcyH src);

	/**
	 *	Allocate a public ISOCcy history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCcyH asPublic(ISecureISOCcyH src);

}
