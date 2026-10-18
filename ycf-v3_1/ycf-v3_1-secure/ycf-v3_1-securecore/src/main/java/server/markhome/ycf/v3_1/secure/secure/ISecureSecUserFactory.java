
// Description: Java JPA Factory interface for SecUser.

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
 *	ISecureSecUserFactory interface for SecUser
 */
public interface ISecureSecUserFactory extends ISecureProtSecUserFactory
{

	/**
	 *	Allocate a primary history key for SecUser instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecUserHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecUser instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecUserHPKey asProtected(ISecureSecUserHPKey src);

	/**
	 *	Allocate a public primary history key for SecUser instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSecUserHPKey asPublic(ISecureSecUserHPKey src);

	/**
	 *	Allocate a ULoginIdx key over SecUser instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserByULoginIdxKey newByULoginIdxKey();

	/**
	 *	Allocate a protected ULoginIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserByULoginIdxKey asProtected(ISecureSecUserByULoginIdxKey src);

	/**
	 *	Allocate a public ULoginIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecUserByULoginIdxKey asPublic(ISecureSecUserByULoginIdxKey src);

	/**
	 *	Allocate a EMAddrIdx key over SecUser instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserByEMAddrIdxKey newByEMAddrIdxKey();

	/**
	 *	Allocate a protected EMAddrIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserByEMAddrIdxKey asProtected(ISecureSecUserByEMAddrIdxKey src);

	/**
	 *	Allocate a SecUser interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUser newRec();

	/**
	 *	Allocate a protected SecUser interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUser asProtected(ISecureSecUser src);

	/**
	 *	Allocate a public SecUser interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecUser asPublic(ISecureSecUser src);

	/**
	 *	Allocate a SecUser history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserH newHRec();

	/**
	 *	Allocate a protected SecUser history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserH asProtected(ISecureSecUserH src);

	/**
	 *	Allocate a public SecUser history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecUserH asPublic(ISecureSecUserH src);

}
