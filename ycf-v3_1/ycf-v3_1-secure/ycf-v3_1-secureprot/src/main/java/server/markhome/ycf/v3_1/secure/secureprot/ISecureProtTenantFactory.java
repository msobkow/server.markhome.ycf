
// Description: Java Protected Factory interface for Tenant.

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

package server.markhome.ycf.v3_1.secure.secureprot;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	ISecureProtTenantFactory protected interface for Tenant
 */
public interface ISecureProtTenantFactory extends ISecurePubTenantFactory
{

	/**
	 *	Allocate a protected primary history key for Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtTenantHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for Tenant instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubTenantHPKey asPublic(ISecureProtTenantHPKey src);

	/**
	 *	Allocate a protected ClusterIdx key over protected Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantByClusterIdxKey newProtByClusterIdxKey();

	/**
	 *	Allocate a public ClusterIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantByClusterIdxKey asPublic(ISecureProtTenantByClusterIdxKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected Tenant instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantByUNameIdxKey asPublic(ISecureProtTenantByUNameIdxKey src);

	/**
	 *	Allocate a protected Tenant interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenant newProtRec();

	/**
	 *	Allocate a public Tenant interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenant asPublic(ISecureProtTenant src);

	/**
	 *	Allocate a protected Tenant history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTenantH newProtHRec();

	/**
	 *	Allocate a public Tenant history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTenantH asPublic(ISecureProtTenantH src);

}
