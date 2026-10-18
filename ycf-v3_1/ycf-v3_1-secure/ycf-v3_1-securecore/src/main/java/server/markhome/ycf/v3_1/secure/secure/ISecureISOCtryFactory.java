
// Description: Java JPA Factory interface for ISOCtry.

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
 *	ISecureISOCtryFactory interface for ISOCtry
 */
public interface ISecureISOCtryFactory extends ISecureProtISOCtryFactory
{

	/**
	 *	Allocate a primary history key for ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOCtryHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOCtry instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOCtryHPKey asProtected(ISecureISOCtryHPKey src);

	/**
	 *	Allocate a public primary history key for ISOCtry instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCtryHPKey asPublic(ISecureISOCtryHPKey src);

	/**
	 *	Allocate a ISOCodeIdx key over ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryByISOCodeIdxKey newByISOCodeIdxKey();

	/**
	 *	Allocate a protected ISOCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryByISOCodeIdxKey asProtected(ISecureISOCtryByISOCodeIdxKey src);

	/**
	 *	Allocate a public ISOCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryByISOCodeIdxKey asPublic(ISecureISOCtryByISOCodeIdxKey src);

	/**
	 *	Allocate a NameIdx key over ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryByNameIdxKey asProtected(ISecureISOCtryByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryByNameIdxKey asPublic(ISecureISOCtryByNameIdxKey src);

	/**
	 *	Allocate a ISOCtry interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtry newRec();

	/**
	 *	Allocate a protected ISOCtry interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtry asProtected(ISecureISOCtry src);

	/**
	 *	Allocate a public ISOCtry interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtry asPublic(ISecureISOCtry src);

	/**
	 *	Allocate a ISOCtry history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryH newHRec();

	/**
	 *	Allocate a protected ISOCtry history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryH asProtected(ISecureISOCtryH src);

	/**
	 *	Allocate a public ISOCtry history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryH asPublic(ISecureISOCtryH src);

}
