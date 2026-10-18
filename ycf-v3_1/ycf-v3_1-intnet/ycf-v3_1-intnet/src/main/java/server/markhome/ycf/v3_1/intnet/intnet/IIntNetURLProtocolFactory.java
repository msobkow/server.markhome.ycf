
// Description: Java JPA Factory interface for URLProtocol.

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
 *	IIntNetURLProtocolFactory interface for URLProtocol
 */
public interface IIntNetURLProtocolFactory extends IIntNetProtURLProtocolFactory
{

	/**
	 *	Allocate a primary history key for URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetURLProtocolHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for URLProtocol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtURLProtocolHPKey asProtected(IIntNetURLProtocolHPKey src);

	/**
	 *	Allocate a public primary history key for URLProtocol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubURLProtocolHPKey asPublic(IIntNetURLProtocolHPKey src);

	/**
	 *	Allocate a UNameIdx key over URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetURLProtocolByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolByUNameIdxKey asProtected(IIntNetURLProtocolByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolByUNameIdxKey asPublic(IIntNetURLProtocolByUNameIdxKey src);

	/**
	 *	Allocate a IsSecureIdx key over URLProtocol instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetURLProtocolByIsSecureIdxKey newByIsSecureIdxKey();

	/**
	 *	Allocate a protected IsSecureIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolByIsSecureIdxKey asProtected(IIntNetURLProtocolByIsSecureIdxKey src);

	/**
	 *	Allocate a public IsSecureIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolByIsSecureIdxKey asPublic(IIntNetURLProtocolByIsSecureIdxKey src);

	/**
	 *	Allocate a URLProtocol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetURLProtocol newRec();

	/**
	 *	Allocate a protected URLProtocol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocol asProtected(IIntNetURLProtocol src);

	/**
	 *	Allocate a public URLProtocol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocol asPublic(IIntNetURLProtocol src);

	/**
	 *	Allocate a URLProtocol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetURLProtocolH newHRec();

	/**
	 *	Allocate a protected URLProtocol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtURLProtocolH asProtected(IIntNetURLProtocolH src);

	/**
	 *	Allocate a public URLProtocol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubURLProtocolH asPublic(IIntNetURLProtocolH src);

}
