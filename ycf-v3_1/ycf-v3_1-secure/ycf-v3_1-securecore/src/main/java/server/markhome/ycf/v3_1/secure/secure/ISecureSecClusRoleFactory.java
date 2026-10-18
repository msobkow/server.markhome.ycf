
// Description: Java JPA Factory interface for SecClusRole.

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
 *	ISecureSecClusRoleFactory interface for SecClusRole
 */
public interface ISecureSecClusRoleFactory extends ISecureProtSecClusRoleFactory
{

	/**
	 *	Allocate a primary history key for SecClusRole instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecClusRoleHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecClusRole instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecClusRoleHPKey asProtected(ISecureSecClusRoleHPKey src);

	/**
	 *	Allocate a ClusterIdx key over SecClusRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleByClusterIdxKey newByClusterIdxKey();

	/**
	 *	Allocate a protected ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleByClusterIdxKey asProtected(ISecureSecClusRoleByClusterIdxKey src);

	/**
	 *	Allocate a NameIdx key over SecClusRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleByNameIdxKey asProtected(ISecureSecClusRoleByNameIdxKey src);

	/**
	 *	Allocate a UNameIdx key over SecClusRole instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleByUNameIdxKey asProtected(ISecureSecClusRoleByUNameIdxKey src);

	/**
	 *	Allocate a SecClusRole interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRole newRec();

	/**
	 *	Allocate a protected SecClusRole interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRole asProtected(ISecureSecClusRole src);

	/**
	 *	Allocate a SecClusRole history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusRoleH newHRec();

	/**
	 *	Allocate a protected SecClusRole history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusRoleH asProtected(ISecureSecClusRoleH src);

}
