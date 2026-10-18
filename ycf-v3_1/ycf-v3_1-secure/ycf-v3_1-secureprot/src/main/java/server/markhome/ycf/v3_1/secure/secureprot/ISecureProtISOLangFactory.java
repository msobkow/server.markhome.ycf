
// Description: Java Protected Factory interface for ISOLang.

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
 *	ISecureProtISOLangFactory protected interface for ISOLang
 */
public interface ISecureProtISOLangFactory extends ISecurePubISOLangFactory
{

	/**
	 *	Allocate a protected primary history key for ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtISOLangHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for ISOLang instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOLangHPKey asPublic(ISecureProtISOLangHPKey src);

	/**
	 *	Allocate a protected Code3Idx key over protected ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangByCode3IdxKey newProtByCode3IdxKey();

	/**
	 *	Allocate a public Code3Idx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangByCode3IdxKey asPublic(ISecureProtISOLangByCode3IdxKey src);

	/**
	 *	Allocate a protected Code2Idx key over protected ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangByCode2IdxKey newProtByCode2IdxKey();

	/**
	 *	Allocate a public Code2Idx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangByCode2IdxKey asPublic(ISecureProtISOLangByCode2IdxKey src);

	/**
	 *	Allocate a protected ISOLang interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLang newProtRec();

	/**
	 *	Allocate a public ISOLang interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLang asPublic(ISecureProtISOLang src);

	/**
	 *	Allocate a protected ISOLang history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtISOLangH newProtHRec();

	/**
	 *	Allocate a public ISOLang history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOLangH asPublic(ISecureProtISOLangH src);

}
