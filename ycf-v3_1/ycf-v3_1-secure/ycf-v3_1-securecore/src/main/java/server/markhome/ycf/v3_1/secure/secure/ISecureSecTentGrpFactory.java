
// Description: Java JPA Factory interface for SecTentGrp.

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
 *	ISecureSecTentGrpFactory interface for SecTentGrp
 */
public interface ISecureSecTentGrpFactory extends ISecureProtSecTentGrpFactory
{

	/**
	 *	Allocate a primary history key for SecTentGrp instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecTentGrpHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecTentGrp instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecTentGrpHPKey asProtected(ISecureSecTentGrpHPKey src);

	/**
	 *	Allocate a TenantIdx key over SecTentGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpByTenantIdxKey asProtected(ISecureSecTentGrpByTenantIdxKey src);

	/**
	 *	Allocate a NameIdx key over SecTentGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpByNameIdxKey asProtected(ISecureSecTentGrpByNameIdxKey src);

	/**
	 *	Allocate a UNameIdx key over SecTentGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpByUNameIdxKey asProtected(ISecureSecTentGrpByUNameIdxKey src);

	/**
	 *	Allocate a SecTentGrp interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrp newRec();

	/**
	 *	Allocate a protected SecTentGrp interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrp asProtected(ISecureSecTentGrp src);

	/**
	 *	Allocate a SecTentGrp history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecTentGrpH newHRec();

	/**
	 *	Allocate a protected SecTentGrp history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecTentGrpH asProtected(ISecureSecTentGrpH src);

}
