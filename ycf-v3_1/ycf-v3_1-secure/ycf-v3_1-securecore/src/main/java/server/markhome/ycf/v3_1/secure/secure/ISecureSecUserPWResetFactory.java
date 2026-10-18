
// Description: Java JPA Factory interface for SecUserPWReset.

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
 *	ISecureSecUserPWResetFactory interface for SecUserPWReset
 */
public interface ISecureSecUserPWResetFactory extends ISecureProtSecUserPWResetFactory
{

	/**
	 *	Allocate a primary history key for SecUserPWReset instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecUserPWResetHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecUserPWReset instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecUserPWResetHPKey asProtected(ISecureSecUserPWResetHPKey src);

	/**
	 *	Allocate a UUuid6Idx key over SecUserPWReset instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserPWResetByUUuid6IdxKey newByUUuid6IdxKey();

	/**
	 *	Allocate a protected UUuid6Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserPWResetByUUuid6IdxKey asProtected(ISecureSecUserPWResetByUUuid6IdxKey src);

	/**
	 *	Allocate a SentEMAddrIdx key over SecUserPWReset instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserPWResetBySentEMAddrIdxKey newBySentEMAddrIdxKey();

	/**
	 *	Allocate a protected SentEMAddrIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserPWResetBySentEMAddrIdxKey asProtected(ISecureSecUserPWResetBySentEMAddrIdxKey src);

	/**
	 *	Allocate a NewAcctIdx key over SecUserPWReset instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserPWResetByNewAcctIdxKey newByNewAcctIdxKey();

	/**
	 *	Allocate a protected NewAcctIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserPWResetByNewAcctIdxKey asProtected(ISecureSecUserPWResetByNewAcctIdxKey src);

	/**
	 *	Allocate a SecUserPWReset interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserPWReset newRec();

	/**
	 *	Allocate a protected SecUserPWReset interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserPWReset asProtected(ISecureSecUserPWReset src);

	/**
	 *	Allocate a SecUserPWReset history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserPWResetH newHRec();

	/**
	 *	Allocate a protected SecUserPWReset history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserPWResetH asProtected(ISecureSecUserPWResetH src);

}
