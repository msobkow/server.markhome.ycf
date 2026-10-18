
// Description: Java JPA Factory interface for SecSysRole.

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
 *	ISecureSecSysRoleFactory interface for SecSysRole
 */
public interface ISecureSecSysRoleFactory extends ISecureProtSecSysRoleFactory
{

	/**
	 *	Allocate a primary history key for SecSysRole instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecSysRoleHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecSysRole instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecSysRoleHPKey asProtected(ISecureSecSysRoleHPKey src);

	/**
	 *	Allocate a public primary history key for SecSysRole instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSecSysRoleHPKey asPublic(ISecureSecSysRoleHPKey src);

	/**
	 *	Allocate a UNameIdx key over SecSysRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleByUNameIdxKey asProtected(ISecureSecSysRoleByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysRoleByUNameIdxKey asPublic(ISecureSecSysRoleByUNameIdxKey src);

	/**
	 *	Allocate a SecSysRole interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRole newRec();

	/**
	 *	Allocate a protected SecSysRole interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRole asProtected(ISecureSecSysRole src);

	/**
	 *	Allocate a public SecSysRole interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysRole asPublic(ISecureSecSysRole src);

	/**
	 *	Allocate a SecSysRole history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysRoleH newHRec();

	/**
	 *	Allocate a protected SecSysRole history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysRoleH asProtected(ISecureSecSysRoleH src);

	/**
	 *	Allocate a public SecSysRole history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysRoleH asPublic(ISecureSecSysRoleH src);

}
