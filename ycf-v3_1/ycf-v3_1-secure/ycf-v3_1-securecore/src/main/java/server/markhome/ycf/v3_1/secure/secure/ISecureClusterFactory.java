
// Description: Java JPA Factory interface for Cluster.

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
 *	ISecureClusterFactory interface for Cluster
 */
public interface ISecureClusterFactory extends ISecureProtClusterFactory
{

	/**
	 *	Allocate a primary history key for Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureClusterHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Cluster instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtClusterHPKey asProtected(ISecureClusterHPKey src);

	/**
	 *	Allocate a public primary history key for Cluster instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubClusterHPKey asPublic(ISecureClusterHPKey src);

	/**
	 *	Allocate a UDomNameIdx key over Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureClusterByUDomNameIdxKey newByUDomNameIdxKey();

	/**
	 *	Allocate a protected UDomNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterByUDomNameIdxKey asProtected(ISecureClusterByUDomNameIdxKey src);

	/**
	 *	Allocate a public UDomNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDomNameIdxKey asPublic(ISecureClusterByUDomNameIdxKey src);

	/**
	 *	Allocate a UDescrIdx key over Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureClusterByUDescrIdxKey newByUDescrIdxKey();

	/**
	 *	Allocate a protected UDescrIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterByUDescrIdxKey asProtected(ISecureClusterByUDescrIdxKey src);

	/**
	 *	Allocate a public UDescrIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDescrIdxKey asPublic(ISecureClusterByUDescrIdxKey src);

	/**
	 *	Allocate a Cluster interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureCluster newRec();

	/**
	 *	Allocate a protected Cluster interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtCluster asProtected(ISecureCluster src);

	/**
	 *	Allocate a public Cluster interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubCluster asPublic(ISecureCluster src);

	/**
	 *	Allocate a Cluster history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureClusterH newHRec();

	/**
	 *	Allocate a protected Cluster history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterH asProtected(ISecureClusterH src);

	/**
	 *	Allocate a public Cluster history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterH asPublic(ISecureClusterH src);

}
