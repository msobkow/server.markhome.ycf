
// Description: Java JPA Factory interface for SecClusRoleMemb.

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
 *	ISecureSecClusRoleMembFactory interface for SecClusRoleMemb
 */
public interface ISecureSecClusRoleMembFactory extends ISecureProtSecClusRoleMembFactory
{

	/**
	 *	Allocate a primary key for SecClusRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleMembPKey newPKey();

	/**
	 *	Allocate a protected key for SecClusRoleMemb instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleMembPKey asProtected(ISecureSecClusRoleMembPKey src);

	/**
	 *	Allocate a primary history key for SecClusRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecClusRoleMembHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecClusRoleMemb instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecClusRoleMembHPKey asProtected(ISecureSecClusRoleMembHPKey src);

	/**
	 *	Allocate a ClusRoleIdx key over SecClusRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleMembByClusRoleIdxKey newByClusRoleIdxKey();

	/**
	 *	Allocate a protected ClusRoleIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleMembByClusRoleIdxKey asProtected(ISecureSecClusRoleMembByClusRoleIdxKey src);

	/**
	 *	Allocate a LoginIdx key over SecClusRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleMembByLoginIdxKey newByLoginIdxKey();

	/**
	 *	Allocate a protected LoginIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleMembByLoginIdxKey asProtected(ISecureSecClusRoleMembByLoginIdxKey src);

	/**
	 *	Allocate a SecClusRoleMemb interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleMemb newRec();

	/**
	 *	Allocate a protected SecClusRoleMemb interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleMemb asProtected(ISecureSecClusRoleMemb src);

	/**
	 *	Allocate a SecClusRoleMemb history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleMembH newHRec();

	/**
	 *	Allocate a protected SecClusRoleMemb history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleMembH asProtected(ISecureSecClusRoleMembH src);

}
