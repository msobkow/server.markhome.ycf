
// Description: Java Protected Factory interface for URLProtocol.

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

package server.markhome.ycf.v3_1.intnet.intnetprot;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/*
 *	IIntNetProtURLProtocolFactory protected interface for URLProtocol
 */
public interface IIntNetProtURLProtocolFactory extends IIntNetPubURLProtocolFactory
{

	/**
	 *	Allocate a protected primary history key for URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtURLProtocolHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for URLProtocol instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubURLProtocolHPKey asPublic(IIntNetProtURLProtocolHPKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolByUNameIdxKey asPublic(IIntNetProtURLProtocolByUNameIdxKey src);

	/**
	 *	Allocate a protected IsSecureIdx key over protected URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolByIsSecureIdxKey newProtByIsSecureIdxKey();

	/**
	 *	Allocate a public IsSecureIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolByIsSecureIdxKey asPublic(IIntNetProtURLProtocolByIsSecureIdxKey src);

	/**
	 *	Allocate a protected URLProtocol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocol newProtRec();

	/**
	 *	Allocate a public URLProtocol interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocol asPublic(IIntNetProtURLProtocol src);

	/**
	 *	Allocate a protected URLProtocol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolH newProtHRec();

	/**
	 *	Allocate a public URLProtocol history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolH asPublic(IIntNetProtURLProtocolH src);

}
