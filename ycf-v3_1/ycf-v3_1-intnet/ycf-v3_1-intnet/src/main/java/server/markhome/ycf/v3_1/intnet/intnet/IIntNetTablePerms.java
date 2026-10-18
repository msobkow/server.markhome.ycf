// Description: Java 25 IntNet Table Permissions Interface.

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

import server.markhome.ycf.v3_1.secure.secure.*;

public interface IIntNetTablePerms
extends ISecureTablePerms
{
	/**
	 *	Is the session allowed to create License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateLicense( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadLicense( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateLicense( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteLicense( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMajorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMajorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMajorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMajorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMinorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMinorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMinorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMinorVersion( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSubProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSubProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSubProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSubProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTld( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTld( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTld( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTld( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopDomain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopDomain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopDomain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopDomain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopProject( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateURLProtocol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadURLProtocol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateURLProtocol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteURLProtocol( SecureAuthorization Authorization );
}
