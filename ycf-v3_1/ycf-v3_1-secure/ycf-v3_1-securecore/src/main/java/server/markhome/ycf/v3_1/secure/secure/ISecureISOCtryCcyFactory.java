
// Description: Java JPA Factory interface for ISOCtryCcy.

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
 *	ISecureISOCtryCcyFactory interface for ISOCtryCcy
 */
public interface ISecureISOCtryCcyFactory extends ISecureProtISOCtryCcyFactory
{

	/**
	 *	Allocate a primary key for ISOCtryCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryCcyPKey newPKey();

	/**
	 *	Allocate a protected key for ISOCtryCcy instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryCcyPKey asProtected(ISecureISOCtryCcyPKey src);

	/**
	 *	Allocate a public key for ISOCtryCcy instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryCcyPKey asPublic(ISecureISOCtryCcyPKey src);

	/**
	 *	Allocate a primary history key for ISOCtryCcy instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOCtryCcyHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOCtryCcy instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOCtryCcyHPKey asProtected(ISecureISOCtryCcyHPKey src);

	/**
	 *	Allocate a public primary history key for ISOCtryCcy instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCtryCcyHPKey asPublic(ISecureISOCtryCcyHPKey src);

	/**
	 *	Allocate a CtryIdx key over ISOCtryCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryCcyByCtryIdxKey newByCtryIdxKey();

	/**
	 *	Allocate a protected CtryIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryCcyByCtryIdxKey asProtected(ISecureISOCtryCcyByCtryIdxKey src);

	/**
	 *	Allocate a public CtryIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryCcyByCtryIdxKey asPublic(ISecureISOCtryCcyByCtryIdxKey src);

	/**
	 *	Allocate a CcyIdx key over ISOCtryCcy instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryCcyByCcyIdxKey newByCcyIdxKey();

	/**
	 *	Allocate a protected CcyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryCcyByCcyIdxKey asProtected(ISecureISOCtryCcyByCcyIdxKey src);

	/**
	 *	Allocate a public CcyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryCcyByCcyIdxKey asPublic(ISecureISOCtryCcyByCcyIdxKey src);

	/**
	 *	Allocate a ISOCtryCcy interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryCcy newRec();

	/**
	 *	Allocate a protected ISOCtryCcy interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryCcy asProtected(ISecureISOCtryCcy src);

	/**
	 *	Allocate a public ISOCtryCcy interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryCcy asPublic(ISecureISOCtryCcy src);

	/**
	 *	Allocate a ISOCtryCcy history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryCcyH newHRec();

	/**
	 *	Allocate a protected ISOCtryCcy history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryCcyH asProtected(ISecureISOCtryCcyH src);

	/**
	 *	Allocate a public ISOCtryCcy history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryCcyH asPublic(ISecureISOCtryCcyH src);

}
