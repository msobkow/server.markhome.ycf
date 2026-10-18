
// Description: Java Protected Factory interface for MajorVersion.

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
 *	IIntNetProtMajorVersionFactory protected interface for MajorVersion
 */
public interface IIntNetProtMajorVersionFactory extends IIntNetPubMajorVersionFactory
{

	/**
	 *	Allocate a protected primary history key for MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtMajorVersionHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for MajorVersion instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMajorVersionHPKey asPublic(IIntNetProtMajorVersionHPKey src);

	/**
	 *	Allocate a protected TenantIdx key over protected MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionByTenantIdxKey newProtByTenantIdxKey();

	/**
	 *	Allocate a public TenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionByTenantIdxKey asPublic(IIntNetProtMajorVersionByTenantIdxKey src);

	/**
	 *	Allocate a protected SubProjectIdx key over protected MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionBySubProjectIdxKey newProtBySubProjectIdxKey();

	/**
	 *	Allocate a public SubProjectIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionBySubProjectIdxKey asPublic(IIntNetProtMajorVersionBySubProjectIdxKey src);

	/**
	 *	Allocate a protected NameIdx key over protected MajorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionByNameIdxKey newProtByNameIdxKey();

	/**
	 *	Allocate a public NameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionByNameIdxKey asPublic(IIntNetProtMajorVersionByNameIdxKey src);

	/**
	 *	Allocate a protected MajorVersion interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersion newProtRec();

	/**
	 *	Allocate a public MajorVersion interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersion asPublic(IIntNetProtMajorVersion src);

	/**
	 *	Allocate a protected MajorVersion history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMajorVersionH newProtHRec();

	/**
	 *	Allocate a public MajorVersion history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMajorVersionH asPublic(IIntNetProtMajorVersionH src);

}
