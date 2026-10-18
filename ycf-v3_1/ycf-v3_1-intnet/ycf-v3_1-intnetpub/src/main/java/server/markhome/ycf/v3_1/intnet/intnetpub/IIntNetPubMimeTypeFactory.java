
// Description: Java Public Factory interface for MimeType.

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

package server.markhome.ycf.v3_1.intnet.intnetpub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.securepub.*;

/*
 *	IIntNetPubMimeTypeFactory public interface for MimeType
 */
public interface IIntNetPubMimeTypeFactory
{

	/**
	 *	Allocate a public primary history key for MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMimeTypeHPKey newPubHPKey();

	/**
	 *	Allocate a public UNameIdx key over public MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeTypeByUNameIdxKey newPubByUNameIdxKey();

	/**
	 *	Allocate a public MimeType interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeType newPubRec();

	/**
	 *	Allocate a public MimeType history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMimeTypeH newPubHRec();

}
