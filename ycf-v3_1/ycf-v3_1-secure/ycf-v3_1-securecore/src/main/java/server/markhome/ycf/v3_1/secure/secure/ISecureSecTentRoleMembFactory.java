
// Description: Java JPA Factory interface for SecTentRoleMemb.

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
 *	ISecureSecTentRoleMembFactory interface for SecTentRoleMemb
 */
public interface ISecureSecTentRoleMembFactory extends ISecureProtSecTentRoleMembFactory
{

	/**
	 *	Allocate a primary key for SecTentRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleMembPKey newPKey();

	/**
	 *	Allocate a protected key for SecTentRoleMemb instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleMembPKey asProtected(ISecureSecTentRoleMembPKey src);

	/**
	 *	Allocate a primary history key for SecTentRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecTentRoleMembHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecTentRoleMemb instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecTentRoleMembHPKey asProtected(ISecureSecTentRoleMembHPKey src);

	/**
	 *	Allocate a TentRoleIdx key over SecTentRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleMembByTentRoleIdxKey newByTentRoleIdxKey();

	/**
	 *	Allocate a protected TentRoleIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleMembByTentRoleIdxKey asProtected(ISecureSecTentRoleMembByTentRoleIdxKey src);

	/**
	 *	Allocate a UserIdx key over SecTentRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleMembByUserIdxKey newByUserIdxKey();

	/**
	 *	Allocate a protected UserIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleMembByUserIdxKey asProtected(ISecureSecTentRoleMembByUserIdxKey src);

	/**
	 *	Allocate a SecTentRoleMemb interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleMemb newRec();

	/**
	 *	Allocate a protected SecTentRoleMemb interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleMemb asProtected(ISecureSecTentRoleMemb src);

	/**
	 *	Allocate a SecTentRoleMemb history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleMembH newHRec();

	/**
	 *	Allocate a protected SecTentRoleMemb history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleMembH asProtected(ISecureSecTentRoleMembH src);

}
