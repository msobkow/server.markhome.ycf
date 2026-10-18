
// Description: Java JPA Factory interface for MajorVersion.

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
 *	IIntNetMajorVersionFactory interface for MajorVersion
 */
public interface IIntNetMajorVersionFactory extends IIntNetProtMajorVersionFactory
{

	/**
	 *	Allocate a primary history key for MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetMajorVersionHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for MajorVersion instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtMajorVersionHPKey asProtected(IIntNetMajorVersionHPKey src);

	/**
	 *	Allocate a public primary history key for MajorVersion instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMajorVersionHPKey asPublic(IIntNetMajorVersionHPKey src);

	/**
	 *	Allocate a TenantIdx key over MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMajorVersionByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionByTenantIdxKey asProtected(IIntNetMajorVersionByTenantIdxKey src);

	/**
	 *	Allocate a public TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionByTenantIdxKey asPublic(IIntNetMajorVersionByTenantIdxKey src);

	/**
	 *	Allocate a SubProjectIdx key over MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMajorVersionBySubProjectIdxKey newBySubProjectIdxKey();

	/**
	 *	Allocate a protected SubProjectIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionBySubProjectIdxKey asProtected(IIntNetMajorVersionBySubProjectIdxKey src);

	/**
	 *	Allocate a public SubProjectIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionBySubProjectIdxKey asPublic(IIntNetMajorVersionBySubProjectIdxKey src);

	/**
	 *	Allocate a NameIdx key over MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMajorVersionByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionByNameIdxKey asProtected(IIntNetMajorVersionByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionByNameIdxKey asPublic(IIntNetMajorVersionByNameIdxKey src);

	/**
	 *	Allocate a MajorVersion interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMajorVersion newRec();

	/**
	 *	Allocate a protected MajorVersion interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersion asProtected(IIntNetMajorVersion src);

	/**
	 *	Allocate a public MajorVersion interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersion asPublic(IIntNetMajorVersion src);

	/**
	 *	Allocate a MajorVersion history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetMajorVersionH newHRec();

	/**
	 *	Allocate a protected MajorVersion history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionH asProtected(IIntNetMajorVersionH src);

	/**
	 *	Allocate a public MajorVersion history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionH asPublic(IIntNetMajorVersionH src);

}
