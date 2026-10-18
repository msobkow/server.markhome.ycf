
// Description: Java Public Factory interface for Cluster.

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;

/*
 *	ISecurePubClusterFactory public interface for Cluster
 */
public interface ISecurePubClusterFactory
{

	/**
	 *	Allocate a public primary history key for Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubClusterHPKey newPubHPKey();

	/**
	 *	Allocate a public UDomNameIdx key over public Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDomNameIdxKey newPubByUDomNameIdxKey();

	/**
	 *	Allocate a public UDescrIdx key over public Cluster instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterByUDescrIdxKey newPubByUDescrIdxKey();

	/**
	 *	Allocate a public Cluster interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubCluster newPubRec();

	/**
	 *	Allocate a public Cluster history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubClusterH newPubHRec();

}
