
// Description: Java JPA Factory interface for ISOCtryLang.

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
 *	ISecureISOCtryLangFactory interface for ISOCtryLang
 */
public interface ISecureISOCtryLangFactory extends ISecureProtISOCtryLangFactory
{

	/**
	 *	Allocate a primary key for ISOCtryLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryLangPKey newPKey();

	/**
	 *	Allocate a protected key for ISOCtryLang instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryLangPKey asProtected(ISecureISOCtryLangPKey src);

	/**
	 *	Allocate a public key for ISOCtryLang instances from a private key.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryLangPKey asPublic(ISecureISOCtryLangPKey src);

	/**
	 *	Allocate a primary history key for ISOCtryLang instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOCtryLangHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOCtryLang instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOCtryLangHPKey asProtected(ISecureISOCtryLangHPKey src);

	/**
	 *	Allocate a public primary history key for ISOCtryLang instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCtryLangHPKey asPublic(ISecureISOCtryLangHPKey src);

	/**
	 *	Allocate a CtryIdx key over ISOCtryLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryLangByCtryIdxKey newByCtryIdxKey();

	/**
	 *	Allocate a protected CtryIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryLangByCtryIdxKey asProtected(ISecureISOCtryLangByCtryIdxKey src);

	/**
	 *	Allocate a public CtryIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryLangByCtryIdxKey asPublic(ISecureISOCtryLangByCtryIdxKey src);

	/**
	 *	Allocate a LangIdx key over ISOCtryLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryLangByLangIdxKey newByLangIdxKey();

	/**
	 *	Allocate a protected LangIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryLangByLangIdxKey asProtected(ISecureISOCtryLangByLangIdxKey src);

	/**
	 *	Allocate a public LangIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryLangByLangIdxKey asPublic(ISecureISOCtryLangByLangIdxKey src);

	/**
	 *	Allocate a ISOCtryLang interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryLang newRec();

	/**
	 *	Allocate a protected ISOCtryLang interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryLang asProtected(ISecureISOCtryLang src);

	/**
	 *	Allocate a public ISOCtryLang interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryLang asPublic(ISecureISOCtryLang src);

	/**
	 *	Allocate a ISOCtryLang history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOCtryLangH newHRec();

	/**
	 *	Allocate a protected ISOCtryLang history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOCtryLangH asProtected(ISecureISOCtryLangH src);

	/**
	 *	Allocate a public ISOCtryLang history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryLangH asPublic(ISecureISOCtryLangH src);

}
