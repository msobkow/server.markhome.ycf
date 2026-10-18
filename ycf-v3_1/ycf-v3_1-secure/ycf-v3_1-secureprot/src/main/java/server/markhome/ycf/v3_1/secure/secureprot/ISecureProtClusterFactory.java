
// Description: Java Protected Factory interface for Cluster.

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
 *	ISecureProtClusterFactory protected interface for Cluster
 */
public interface ISecureProtClusterFactory extends ISecurePubClusterFactory
{

	/**
	 *	Allocate a protected primary history key for Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtClusterHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for Cluster instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubClusterHPKey asPublic(ISecureProtClusterHPKey src);

	/**
	 *	Allocate a protected UDomNameIdx key over protected Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterByUDomNameIdxKey newProtByUDomNameIdxKey();

	/**
	 *	Allocate a public UDomNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDomNameIdxKey asPublic(ISecureProtClusterByUDomNameIdxKey src);

	/**
	 *	Allocate a protected UDescrIdx key over protected Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterByUDescrIdxKey newProtByUDescrIdxKey();

	/**
	 *	Allocate a public UDescrIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDescrIdxKey asPublic(ISecureProtClusterByUDescrIdxKey src);

	/**
	 *	Allocate a protected Cluster interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtCluster newProtRec();

	/**
	 *	Allocate a public Cluster interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubCluster asPublic(ISecureProtCluster src);

	/**
	 *	Allocate a protected Cluster history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtClusterH newProtHRec();

	/**
	 *	Allocate a public Cluster history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterH asPublic(ISecureProtClusterH src);

}
