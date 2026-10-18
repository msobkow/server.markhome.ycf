
// Description: Java JPA Factory interface for SecTentGrpMemb.

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
 *	ISecureSecTentGrpMembFactory interface for SecTentGrpMemb
 */
public interface ISecureSecTentGrpMembFactory extends ISecureProtSecTentGrpMembFactory
{

	/**
	 *	Allocate a primary key for SecTentGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpMembPKey newPKey();

	/**
	 *	Allocate a protected key for SecTentGrpMemb instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpMembPKey asProtected(ISecureSecTentGrpMembPKey src);

	/**
	 *	Allocate a primary history key for SecTentGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecTentGrpMembHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecTentGrpMemb instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecTentGrpMembHPKey asProtected(ISecureSecTentGrpMembHPKey src);

	/**
	 *	Allocate a TentGrpIdx key over SecTentGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpMembByTentGrpIdxKey newByTentGrpIdxKey();

	/**
	 *	Allocate a protected TentGrpIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpMembByTentGrpIdxKey asProtected(ISecureSecTentGrpMembByTentGrpIdxKey src);

	/**
	 *	Allocate a UserIdx key over SecTentGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpMembByUserIdxKey newByUserIdxKey();

	/**
	 *	Allocate a protected UserIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpMembByUserIdxKey asProtected(ISecureSecTentGrpMembByUserIdxKey src);

	/**
	 *	Allocate a SecTentGrpMemb interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpMemb newRec();

	/**
	 *	Allocate a protected SecTentGrpMemb interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpMemb asProtected(ISecureSecTentGrpMemb src);

	/**
	 *	Allocate a SecTentGrpMemb history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpMembH newHRec();

	/**
	 *	Allocate a protected SecTentGrpMemb history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpMembH asProtected(ISecureSecTentGrpMembH src);

}
