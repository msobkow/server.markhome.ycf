
// Description: Java JPA Factory interface for Tenant.

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
 *	ISecureTenantFactory interface for Tenant
 */
public interface ISecureTenantFactory extends ISecureProtTenantFactory
{

	/**
	 *	Allocate a primary history key for Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureTenantHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Tenant instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtTenantHPKey asProtected(ISecureTenantHPKey src);

	/**
	 *	Allocate a public primary history key for Tenant instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubTenantHPKey asPublic(ISecureTenantHPKey src);

	/**
	 *	Allocate a ClusterIdx key over Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTenantByClusterIdxKey newByClusterIdxKey();

	/**
	 *	Allocate a protected ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantByClusterIdxKey asProtected(ISecureTenantByClusterIdxKey src);

	/**
	 *	Allocate a public ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantByClusterIdxKey asPublic(ISecureTenantByClusterIdxKey src);

	/**
	 *	Allocate a UNameIdx key over Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTenantByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantByUNameIdxKey asProtected(ISecureTenantByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantByUNameIdxKey asPublic(ISecureTenantByUNameIdxKey src);

	/**
	 *	Allocate a Tenant interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTenant newRec();

	/**
	 *	Allocate a protected Tenant interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenant asProtected(ISecureTenant src);

	/**
	 *	Allocate a public Tenant interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenant asPublic(ISecureTenant src);

	/**
	 *	Allocate a Tenant history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTenantH newHRec();

	/**
	 *	Allocate a protected Tenant history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantH asProtected(ISecureTenantH src);

	/**
	 *	Allocate a public Tenant history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantH asPublic(ISecureTenantH src);

}
