
// Description: Java JPA Factory interface for SecTentRole.

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
 *	ISecureSecTentRoleFactory interface for SecTentRole
 */
public interface ISecureSecTentRoleFactory extends ISecureProtSecTentRoleFactory
{

	/**
	 *	Allocate a primary history key for SecTentRole instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecTentRoleHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecTentRole instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecTentRoleHPKey asProtected(ISecureSecTentRoleHPKey src);

	/**
	 *	Allocate a TenantIdx key over SecTentRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleByTenantIdxKey asProtected(ISecureSecTentRoleByTenantIdxKey src);

	/**
	 *	Allocate a NameIdx key over SecTentRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleByNameIdxKey asProtected(ISecureSecTentRoleByNameIdxKey src);

	/**
	 *	Allocate a UNameIdx key over SecTentRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleByUNameIdxKey asProtected(ISecureSecTentRoleByUNameIdxKey src);

	/**
	 *	Allocate a SecTentRole interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRole newRec();

	/**
	 *	Allocate a protected SecTentRole interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRole asProtected(ISecureSecTentRole src);

	/**
	 *	Allocate a SecTentRole history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentRoleH newHRec();

	/**
	 *	Allocate a protected SecTentRole history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentRoleH asProtected(ISecureSecTentRoleH src);

}
