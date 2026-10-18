
// Description: Java JPA Factory interface for ISOLang.

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
 *	ISecureISOLangFactory interface for ISOLang
 */
public interface ISecureISOLangFactory extends ISecureProtISOLangFactory
{

	/**
	 *	Allocate a primary history key for ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureISOLangHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for ISOLang instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOLangHPKey asProtected(ISecureISOLangHPKey src);

	/**
	 *	Allocate a public primary history key for ISOLang instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOLangHPKey asPublic(ISecureISOLangHPKey src);

	/**
	 *	Allocate a Code3Idx key over ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOLangByCode3IdxKey newByCode3IdxKey();

	/**
	 *	Allocate a protected Code3Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangByCode3IdxKey asProtected(ISecureISOLangByCode3IdxKey src);

	/**
	 *	Allocate a public Code3Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangByCode3IdxKey asPublic(ISecureISOLangByCode3IdxKey src);

	/**
	 *	Allocate a Code2Idx key over ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOLangByCode2IdxKey newByCode2IdxKey();

	/**
	 *	Allocate a protected Code2Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangByCode2IdxKey asProtected(ISecureISOLangByCode2IdxKey src);

	/**
	 *	Allocate a public Code2Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangByCode2IdxKey asPublic(ISecureISOLangByCode2IdxKey src);

	/**
	 *	Allocate a ISOLang interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOLang newRec();

	/**
	 *	Allocate a protected ISOLang interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLang asProtected(ISecureISOLang src);

	/**
	 *	Allocate a public ISOLang interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLang asPublic(ISecureISOLang src);

	/**
	 *	Allocate a ISOLang history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureISOLangH newHRec();

	/**
	 *	Allocate a protected ISOLang history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangH asProtected(ISecureISOLangH src);

	/**
	 *	Allocate a public ISOLang history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangH asPublic(ISecureISOLangH src);

}
