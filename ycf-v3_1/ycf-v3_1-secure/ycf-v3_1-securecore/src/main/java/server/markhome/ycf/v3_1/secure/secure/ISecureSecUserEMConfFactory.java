
// Description: Java JPA Factory interface for SecUserEMConf.

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
 *	ISecureSecUserEMConfFactory interface for SecUserEMConf
 */
public interface ISecureSecUserEMConfFactory extends ISecureProtSecUserEMConfFactory
{

	/**
	 *	Allocate a primary history key for SecUserEMConf instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecUserEMConfHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecUserEMConf instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecUserEMConfHPKey asProtected(ISecureSecUserEMConfHPKey src);

	/**
	 *	Allocate a UUuid6Idx key over SecUserEMConf instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConfByUUuid6IdxKey newByUUuid6IdxKey();

	/**
	 *	Allocate a protected UUuid6Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConfByUUuid6IdxKey asProtected(ISecureSecUserEMConfByUUuid6IdxKey src);

	/**
	 *	Allocate a ConfEMAddrIdx key over SecUserEMConf instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConfByConfEMAddrIdxKey newByConfEMAddrIdxKey();

	/**
	 *	Allocate a protected ConfEMAddrIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConfByConfEMAddrIdxKey asProtected(ISecureSecUserEMConfByConfEMAddrIdxKey src);

	/**
	 *	Allocate a SentStampIdx key over SecUserEMConf instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConfBySentStampIdxKey newBySentStampIdxKey();

	/**
	 *	Allocate a protected SentStampIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConfBySentStampIdxKey asProtected(ISecureSecUserEMConfBySentStampIdxKey src);

	/**
	 *	Allocate a NewAcctIdx key over SecUserEMConf instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConfByNewAcctIdxKey newByNewAcctIdxKey();

	/**
	 *	Allocate a protected NewAcctIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConfByNewAcctIdxKey asProtected(ISecureSecUserEMConfByNewAcctIdxKey src);

	/**
	 *	Allocate a SecUserEMConf interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConf newRec();

	/**
	 *	Allocate a protected SecUserEMConf interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConf asProtected(ISecureSecUserEMConf src);

	/**
	 *	Allocate a SecUserEMConf history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecUserEMConfH newHRec();

	/**
	 *	Allocate a protected SecUserEMConf history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecUserEMConfH asProtected(ISecureSecUserEMConfH src);

}
