
// Description: Java JPA Factory interface for SecSysRoleMemb.

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
 *	ISecureSecSysRoleMembFactory interface for SecSysRoleMemb
 */
public interface ISecureSecSysRoleMembFactory extends ISecureProtSecSysRoleMembFactory
{

	/**
	 *	Allocate a primary key for SecSysRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleMembPKey newPKey();

	/**
	 *	Allocate a protected key for SecSysRoleMemb instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleMembPKey asProtected(ISecureSecSysRoleMembPKey src);

	/**
	 *	Allocate a primary history key for SecSysRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecSysRoleMembHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecSysRoleMemb instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecSysRoleMembHPKey asProtected(ISecureSecSysRoleMembHPKey src);

	/**
	 *	Allocate a SysRoleIdx key over SecSysRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleMembBySysRoleIdxKey newBySysRoleIdxKey();

	/**
	 *	Allocate a protected SysRoleIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleMembBySysRoleIdxKey asProtected(ISecureSecSysRoleMembBySysRoleIdxKey src);

	/**
	 *	Allocate a LoginIdx key over SecSysRoleMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleMembByLoginIdxKey newByLoginIdxKey();

	/**
	 *	Allocate a protected LoginIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleMembByLoginIdxKey asProtected(ISecureSecSysRoleMembByLoginIdxKey src);

	/**
	 *	Allocate a SecSysRoleMemb interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleMemb newRec();

	/**
	 *	Allocate a protected SecSysRoleMemb interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleMemb asProtected(ISecureSecSysRoleMemb src);

	/**
	 *	Allocate a SecSysRoleMemb history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleMembH newHRec();

	/**
	 *	Allocate a protected SecSysRoleMemb history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleMembH asProtected(ISecureSecSysRoleMembH src);

}
