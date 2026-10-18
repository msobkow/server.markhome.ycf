
// Description: Java JPA Factory interface for MinorVersion.

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
 *	IIntNetMinorVersionFactory interface for MinorVersion
 */
public interface IIntNetMinorVersionFactory extends IIntNetProtMinorVersionFactory
{

	/**
	 *	Allocate a primary history key for MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetMinorVersionHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for MinorVersion instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtMinorVersionHPKey asProtected(IIntNetMinorVersionHPKey src);

	/**
	 *	Allocate a public primary history key for MinorVersion instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMinorVersionHPKey asPublic(IIntNetMinorVersionHPKey src);

	/**
	 *	Allocate a TenantIdx key over MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMinorVersionByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByTenantIdxKey asProtected(IIntNetMinorVersionByTenantIdxKey src);

	/**
	 *	Allocate a public TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByTenantIdxKey asPublic(IIntNetMinorVersionByTenantIdxKey src);

	/**
	 *	Allocate a MajorVerIdx key over MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMinorVersionByMajorVerIdxKey newByMajorVerIdxKey();

	/**
	 *	Allocate a protected MajorVerIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByMajorVerIdxKey asProtected(IIntNetMinorVersionByMajorVerIdxKey src);

	/**
	 *	Allocate a public MajorVerIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByMajorVerIdxKey asPublic(IIntNetMinorVersionByMajorVerIdxKey src);

	/**
	 *	Allocate a NameIdx key over MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMinorVersionByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByNameIdxKey asProtected(IIntNetMinorVersionByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByNameIdxKey asPublic(IIntNetMinorVersionByNameIdxKey src);

	/**
	 *	Allocate a MinorVersion interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMinorVersion newRec();

	/**
	 *	Allocate a protected MinorVersion interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersion asProtected(IIntNetMinorVersion src);

	/**
	 *	Allocate a public MinorVersion interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersion asPublic(IIntNetMinorVersion src);

	/**
	 *	Allocate a MinorVersion history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMinorVersionH newHRec();

	/**
	 *	Allocate a protected MinorVersion history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionH asProtected(IIntNetMinorVersionH src);

	/**
	 *	Allocate a public MinorVersion history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionH asPublic(IIntNetMinorVersionH src);

}
