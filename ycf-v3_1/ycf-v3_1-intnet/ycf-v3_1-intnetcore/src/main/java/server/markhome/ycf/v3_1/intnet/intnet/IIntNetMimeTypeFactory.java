
// Description: Java JPA Factory interface for MimeType.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnet;

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

import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/*
 *	IIntNetMimeTypeFactory interface for MimeType
 */
public interface IIntNetMimeTypeFactory extends IIntNetProtMimeTypeFactory
{

	/**
	 *	Allocate a primary history key for MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetMimeTypeHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for MimeType instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtMimeTypeHPKey asProtected(IIntNetMimeTypeHPKey src);

	/**
	 *	Allocate a public primary history key for MimeType instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMimeTypeHPKey asPublic(IIntNetMimeTypeHPKey src);

	/**
	 *	Allocate a UNameIdx key over MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMimeTypeByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMimeTypeByUNameIdxKey asProtected(IIntNetMimeTypeByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeTypeByUNameIdxKey asPublic(IIntNetMimeTypeByUNameIdxKey src);

	/**
	 *	Allocate a MimeType interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMimeType newRec();

	/**
	 *	Allocate a protected MimeType interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMimeType asProtected(IIntNetMimeType src);

	/**
	 *	Allocate a public MimeType interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeType asPublic(IIntNetMimeType src);

	/**
	 *	Allocate a MimeType history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMimeTypeH newHRec();

	/**
	 *	Allocate a protected MimeType history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMimeTypeH asProtected(IIntNetMimeTypeH src);

	/**
	 *	Allocate a public MimeType history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeTypeH asPublic(IIntNetMimeTypeH src);

}
