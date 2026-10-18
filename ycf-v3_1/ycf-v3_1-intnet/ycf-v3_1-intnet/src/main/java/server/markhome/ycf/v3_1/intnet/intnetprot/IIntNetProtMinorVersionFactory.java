
// Description: Java Protected Factory interface for MinorVersion.

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
 *	IIntNetProtMinorVersionFactory protected interface for MinorVersion
 */
public interface IIntNetProtMinorVersionFactory extends IIntNetPubMinorVersionFactory
{

	/**
	 *	Allocate a protected primary history key for MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtMinorVersionHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for MinorVersion instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubMinorVersionHPKey asPublic(IIntNetProtMinorVersionHPKey src);

	/**
	 *	Allocate a protected TenantIdx key over protected MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByTenantIdxKey newProtByTenantIdxKey();

	/**
	 *	Allocate a public TenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByTenantIdxKey asPublic(IIntNetProtMinorVersionByTenantIdxKey src);

	/**
	 *	Allocate a protected MajorVerIdx key over protected MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByMajorVerIdxKey newProtByMajorVerIdxKey();

	/**
	 *	Allocate a public MajorVerIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByMajorVerIdxKey asPublic(IIntNetProtMinorVersionByMajorVerIdxKey src);

	/**
	 *	Allocate a protected NameIdx key over protected MinorVersion instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionByNameIdxKey newProtByNameIdxKey();

	/**
	 *	Allocate a public NameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionByNameIdxKey asPublic(IIntNetProtMinorVersionByNameIdxKey src);

	/**
	 *	Allocate a protected MinorVersion interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersion newProtRec();

	/**
	 *	Allocate a public MinorVersion interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersion asPublic(IIntNetProtMinorVersion src);

	/**
	 *	Allocate a protected MinorVersion history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtMinorVersionH newProtHRec();

	/**
	 *	Allocate a public MinorVersion history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubMinorVersionH asPublic(IIntNetProtMinorVersionH src);

}
