
// Description: Java Protected Factory interface for SecSession.

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
 *	ISecureProtSecSessionFactory protected interface for SecSession
 */
public interface ISecureProtSecSessionFactory extends ISecurePubSecSessionFactory
{

	/**
	 *	Allocate a protected primary history key for SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecSessionHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for SecSession instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSecSessionHPKey asPublic(ISecureProtSecSessionHPKey src);

	/**
	 *	Allocate a protected SecUserIdx key over protected SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionBySecUserIdxKey newProtBySecUserIdxKey();

	/**
	 *	Allocate a public SecUserIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionBySecUserIdxKey asPublic(ISecureProtSecSessionBySecUserIdxKey src);

	/**
	 *	Allocate a protected StartIdx key over protected SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionByStartIdxKey newProtByStartIdxKey();

	/**
	 *	Allocate a public StartIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionByStartIdxKey asPublic(ISecureProtSecSessionByStartIdxKey src);

	/**
	 *	Allocate a protected FinishIdx key over protected SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionByFinishIdxKey newProtByFinishIdxKey();

	/**
	 *	Allocate a public FinishIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionByFinishIdxKey asPublic(ISecureProtSecSessionByFinishIdxKey src);

	/**
	 *	Allocate a protected SecProxyIdx key over protected SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionBySecProxyIdxKey newProtBySecProxyIdxKey();

	/**
	 *	Allocate a protected SecSession interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSession newProtRec();

	/**
	 *	Allocate a public SecSession interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSession asPublic(ISecureProtSecSession src);

	/**
	 *	Allocate a protected SecSession history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionH newProtHRec();

	/**
	 *	Allocate a public SecSession history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionH asPublic(ISecureProtSecSessionH src);

}
