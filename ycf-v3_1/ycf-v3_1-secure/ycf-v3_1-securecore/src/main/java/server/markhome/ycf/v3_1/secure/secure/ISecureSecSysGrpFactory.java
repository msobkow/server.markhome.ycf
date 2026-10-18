
// Description: Java JPA Factory interface for SecSysGrp.

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
 *	ISecureSecSysGrpFactory interface for SecSysGrp
 */
public interface ISecureSecSysGrpFactory extends ISecureProtSecSysGrpFactory
{

	/**
	 *	Allocate a primary history key for SecSysGrp instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecSysGrpHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecSysGrp instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecSysGrpHPKey asProtected(ISecureSecSysGrpHPKey src);

	/**
	 *	Allocate a public primary history key for SecSysGrp instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSecSysGrpHPKey asPublic(ISecureSecSysGrpHPKey src);

	/**
	 *	Allocate a UNameIdx key over SecSysGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysGrpByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysGrpByUNameIdxKey asProtected(ISecureSecSysGrpByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysGrpByUNameIdxKey asPublic(ISecureSecSysGrpByUNameIdxKey src);

	/**
	 *	Allocate a SecLevelIdx key over SecSysGrp instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysGrpBySecLevelIdxKey newBySecLevelIdxKey();

	/**
	 *	Allocate a protected SecLevelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysGrpBySecLevelIdxKey asProtected(ISecureSecSysGrpBySecLevelIdxKey src);

	/**
	 *	Allocate a public SecLevelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysGrpBySecLevelIdxKey asPublic(ISecureSecSysGrpBySecLevelIdxKey src);

	/**
	 *	Allocate a SecSysGrp interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysGrp newRec();

	/**
	 *	Allocate a protected SecSysGrp interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysGrp asProtected(ISecureSecSysGrp src);

	/**
	 *	Allocate a public SecSysGrp interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysGrp asPublic(ISecureSecSysGrp src);

	/**
	 *	Allocate a SecSysGrp history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSysGrpH newHRec();

	/**
	 *	Allocate a protected SecSysGrp history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSysGrpH asProtected(ISecureSecSysGrpH src);

	/**
	 *	Allocate a public SecSysGrp history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSysGrpH asPublic(ISecureSecSysGrpH src);

}
