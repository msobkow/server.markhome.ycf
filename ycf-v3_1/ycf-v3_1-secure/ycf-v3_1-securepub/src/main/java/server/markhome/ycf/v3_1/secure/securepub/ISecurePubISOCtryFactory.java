
// Description: Java Public Factory interface for ISOCtry.

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;

/*
 *	ISecurePubISOCtryFactory public interface for ISOCtry
 */
public interface ISecurePubISOCtryFactory
{

	/**
	 *	Allocate a public primary history key for ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubISOCtryHPKey newPubHPKey();

	/**
	 *	Allocate a public ISOCodeIdx key over public ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryByISOCodeIdxKey newPubByISOCodeIdxKey();

	/**
	 *	Allocate a public NameIdx key over public ISOCtry instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryByNameIdxKey newPubByNameIdxKey();

	/**
	 *	Allocate a public ISOCtry interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtry newPubRec();

	/**
	 *	Allocate a public ISOCtry history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubISOCtryH newPubHRec();

}
