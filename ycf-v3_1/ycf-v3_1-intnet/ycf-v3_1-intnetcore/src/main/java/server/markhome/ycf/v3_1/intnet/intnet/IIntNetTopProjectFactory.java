
// Description: Java JPA Factory interface for TopProject.

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
 *	IIntNetTopProjectFactory interface for TopProject
 */
public interface IIntNetTopProjectFactory extends IIntNetProtTopProjectFactory
{

	/**
	 *	Allocate a primary history key for TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetTopProjectHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for TopProject instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtTopProjectHPKey asProtected(IIntNetTopProjectHPKey src);

	/**
	 *	Allocate a public primary history key for TopProject instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubTopProjectHPKey asPublic(IIntNetTopProjectHPKey src);

	/**
	 *	Allocate a TenantIdx key over TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopProjectByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByTenantIdxKey asProtected(IIntNetTopProjectByTenantIdxKey src);

	/**
	 *	Allocate a public TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByTenantIdxKey asPublic(IIntNetTopProjectByTenantIdxKey src);

	/**
	 *	Allocate a TopDomainIdx key over TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopProjectByTopDomainIdxKey newByTopDomainIdxKey();

	/**
	 *	Allocate a protected TopDomainIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByTopDomainIdxKey asProtected(IIntNetTopProjectByTopDomainIdxKey src);

	/**
	 *	Allocate a public TopDomainIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByTopDomainIdxKey asPublic(IIntNetTopProjectByTopDomainIdxKey src);

	/**
	 *	Allocate a NameIdx key over TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopProjectByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByNameIdxKey asProtected(IIntNetTopProjectByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByNameIdxKey asPublic(IIntNetTopProjectByNameIdxKey src);

	/**
	 *	Allocate a TopProject interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopProject newRec();

	/**
	 *	Allocate a protected TopProject interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProject asProtected(IIntNetTopProject src);

	/**
	 *	Allocate a public TopProject interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProject asPublic(IIntNetTopProject src);

	/**
	 *	Allocate a TopProject history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopProjectH newHRec();

	/**
	 *	Allocate a protected TopProject history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectH asProtected(IIntNetTopProjectH src);

	/**
	 *	Allocate a public TopProject history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectH asPublic(IIntNetTopProjectH src);

}
