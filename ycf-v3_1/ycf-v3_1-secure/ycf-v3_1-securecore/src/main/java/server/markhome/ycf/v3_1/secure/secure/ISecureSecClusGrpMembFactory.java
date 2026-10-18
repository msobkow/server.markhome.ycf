
// Description: Java JPA Factory interface for SecClusGrpMemb.

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
 *	ISecureSecClusGrpMembFactory interface for SecClusGrpMemb
 */
public interface ISecureSecClusGrpMembFactory extends ISecureProtSecClusGrpMembFactory
{

	/**
	 *	Allocate a primary key for SecClusGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpMembPKey newPKey();

	/**
	 *	Allocate a protected key for SecClusGrpMemb instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpMembPKey asProtected(ISecureSecClusGrpMembPKey src);

	/**
	 *	Allocate a primary history key for SecClusGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecClusGrpMembHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecClusGrpMemb instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecClusGrpMembHPKey asProtected(ISecureSecClusGrpMembHPKey src);

	/**
	 *	Allocate a ClusGrpIdx key over SecClusGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpMembByClusGrpIdxKey newByClusGrpIdxKey();

	/**
	 *	Allocate a protected ClusGrpIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpMembByClusGrpIdxKey asProtected(ISecureSecClusGrpMembByClusGrpIdxKey src);

	/**
	 *	Allocate a LoginIdx key over SecClusGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpMembByLoginIdxKey newByLoginIdxKey();

	/**
	 *	Allocate a protected LoginIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpMembByLoginIdxKey asProtected(ISecureSecClusGrpMembByLoginIdxKey src);

	/**
	 *	Allocate a SecClusGrpMemb interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpMemb newRec();

	/**
	 *	Allocate a protected SecClusGrpMemb interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpMemb asProtected(ISecureSecClusGrpMemb src);

	/**
	 *	Allocate a SecClusGrpMemb history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecClusGrpMembH newHRec();

	/**
	 *	Allocate a protected SecClusGrpMemb history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecClusGrpMembH asProtected(ISecureSecClusGrpMembH src);

}
