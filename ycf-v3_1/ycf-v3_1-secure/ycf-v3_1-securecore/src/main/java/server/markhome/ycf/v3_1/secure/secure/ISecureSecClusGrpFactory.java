
// Description: Java JPA Factory interface for SecClusGrp.

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
 *	ISecureSecClusGrpFactory interface for SecClusGrp
 */
public interface ISecureSecClusGrpFactory extends ISecureProtSecClusGrpFactory
{

	/**
	 *	Allocate a primary history key for SecClusGrp instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecClusGrpHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecClusGrp instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecClusGrpHPKey asProtected(ISecureSecClusGrpHPKey src);

	/**
	 *	Allocate a ClusterIdx key over SecClusGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpByClusterIdxKey newByClusterIdxKey();

	/**
	 *	Allocate a protected ClusterIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpByClusterIdxKey asProtected(ISecureSecClusGrpByClusterIdxKey src);

	/**
	 *	Allocate a NameIdx key over SecClusGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpByNameIdxKey asProtected(ISecureSecClusGrpByNameIdxKey src);

	/**
	 *	Allocate a UNameIdx key over SecClusGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpByUNameIdxKey asProtected(ISecureSecClusGrpByUNameIdxKey src);

	/**
	 *	Allocate a SecClusGrp interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrp newRec();

	/**
	 *	Allocate a protected SecClusGrp interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrp asProtected(ISecureSecClusGrp src);

	/**
	 *	Allocate a SecClusGrp history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpH newHRec();

	/**
	 *	Allocate a protected SecClusGrp history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpH asProtected(ISecureSecClusGrpH src);

}
