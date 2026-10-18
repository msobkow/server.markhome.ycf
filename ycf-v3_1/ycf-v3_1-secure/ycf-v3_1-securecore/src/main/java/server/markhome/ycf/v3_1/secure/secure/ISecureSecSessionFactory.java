
// Description: Java JPA Factory interface for SecSession.

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
 *	ISecureSecSessionFactory interface for SecSession
 */
public interface ISecureSecSessionFactory extends ISecureProtSecSessionFactory
{

	/**
	 *	Allocate a primary history key for SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureSecSessionHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SecSession instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtSecSessionHPKey asProtected(ISecureSecSessionHPKey src);

	/**
	 *	Allocate a public primary history key for SecSession instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubSecSessionHPKey asPublic(ISecureSecSessionHPKey src);

	/**
	 *	Allocate a SecUserIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSessionBySecUserIdxKey newBySecUserIdxKey();

	/**
	 *	Allocate a protected SecUserIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionBySecUserIdxKey asProtected(ISecureSecSessionBySecUserIdxKey src);

	/**
	 *	Allocate a public SecUserIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionBySecUserIdxKey asPublic(ISecureSecSessionBySecUserIdxKey src);

	/**
	 *	Allocate a StartIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSessionByStartIdxKey newByStartIdxKey();

	/**
	 *	Allocate a protected StartIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionByStartIdxKey asProtected(ISecureSecSessionByStartIdxKey src);

	/**
	 *	Allocate a public StartIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionByStartIdxKey asPublic(ISecureSecSessionByStartIdxKey src);

	/**
	 *	Allocate a FinishIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSessionByFinishIdxKey newByFinishIdxKey();

	/**
	 *	Allocate a protected FinishIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionByFinishIdxKey asProtected(ISecureSecSessionByFinishIdxKey src);

	/**
	 *	Allocate a public FinishIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionByFinishIdxKey asPublic(ISecureSecSessionByFinishIdxKey src);

	/**
	 *	Allocate a SecProxyIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSessionBySecProxyIdxKey newBySecProxyIdxKey();

	/**
	 *	Allocate a protected SecProxyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionBySecProxyIdxKey asProtected(ISecureSecSessionBySecProxyIdxKey src);

	/**
	 *	Allocate a SecSession interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSession newRec();

	/**
	 *	Allocate a protected SecSession interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSession asProtected(ISecureSecSession src);

	/**
	 *	Allocate a public SecSession interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSession asPublic(ISecureSecSession src);

	/**
	 *	Allocate a SecSession history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureSecSessionH newHRec();

	/**
	 *	Allocate a protected SecSession history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtSecSessionH asProtected(ISecureSecSessionH src);

	/**
	 *	Allocate a public SecSession history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubSecSessionH asPublic(ISecureSecSessionH src);

}
