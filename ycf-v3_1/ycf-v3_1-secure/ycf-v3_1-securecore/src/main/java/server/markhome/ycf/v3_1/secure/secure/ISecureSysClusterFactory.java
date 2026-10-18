
// Description: Java JPA Factory interface for SysCluster.

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
 *	ISecureSysClusterFactory interface for SysCluster
 */
public interface ISecureSysClusterFactory extends ISecureProtSysClusterFactory
{

	/**
	 *	Allocate a primary history key for SysCluster instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSysClusterHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SysCluster instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSysClusterHPKey asProtected(ISecureSysClusterHPKey src);

	/**
	 *	Allocate a public primary history key for SysCluster instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSysClusterHPKey asPublic(ISecureSysClusterHPKey src);

	/**
	 *	Allocate a ClusterIdx key over SysCluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSysClusterByClusterIdxKey newByClusterIdxKey();

	/**
	 *	Allocate a protected ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSysClusterByClusterIdxKey asProtected(ISecureSysClusterByClusterIdxKey src);

	/**
	 *	Allocate a public ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSysClusterByClusterIdxKey asPublic(ISecureSysClusterByClusterIdxKey src);

	/**
	 *	Allocate a SysCluster interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSysCluster newRec();

	/**
	 *	Allocate a protected SysCluster interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSysCluster asProtected(ISecureSysCluster src);

	/**
	 *	Allocate a public SysCluster interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSysCluster asPublic(ISecureSysCluster src);

	/**
	 *	Allocate a SysCluster history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSysClusterH newHRec();

	/**
	 *	Allocate a protected SysCluster history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSysClusterH asProtected(ISecureSysClusterH src);

	/**
	 *	Allocate a public SysCluster history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSysClusterH asPublic(ISecureSysClusterH src);

}
