
// Description: Java JPA Factory interface for SubProject.

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
 *	IIntNetSubProjectFactory interface for SubProject
 */
public interface IIntNetSubProjectFactory extends IIntNetProtSubProjectFactory
{

	/**
	 *	Allocate a primary history key for SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetSubProjectHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for SubProject instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtSubProjectHPKey asProtected(IIntNetSubProjectHPKey src);

	/**
	 *	Allocate a public primary history key for SubProject instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubSubProjectHPKey asPublic(IIntNetSubProjectHPKey src);

	/**
	 *	Allocate a TenantIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetSubProjectByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByTenantIdxKey asProtected(IIntNetSubProjectByTenantIdxKey src);

	/**
	 *	Allocate a public TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByTenantIdxKey asPublic(IIntNetSubProjectByTenantIdxKey src);

	/**
	 *	Allocate a TopProjectIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetSubProjectByTopProjectIdxKey newByTopProjectIdxKey();

	/**
	 *	Allocate a protected TopProjectIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByTopProjectIdxKey asProtected(IIntNetSubProjectByTopProjectIdxKey src);

	/**
	 *	Allocate a public TopProjectIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByTopProjectIdxKey asPublic(IIntNetSubProjectByTopProjectIdxKey src);

	/**
	 *	Allocate a NameIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetSubProjectByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByNameIdxKey asProtected(IIntNetSubProjectByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByNameIdxKey asPublic(IIntNetSubProjectByNameIdxKey src);

	/**
	 *	Allocate a SubProject interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetSubProject newRec();

	/**
	 *	Allocate a protected SubProject interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProject asProtected(IIntNetSubProject src);

	/**
	 *	Allocate a public SubProject interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProject asPublic(IIntNetSubProject src);

	/**
	 *	Allocate a SubProject history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetSubProjectH newHRec();

	/**
	 *	Allocate a protected SubProject history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectH asProtected(IIntNetSubProjectH src);

	/**
	 *	Allocate a public SubProject history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectH asPublic(IIntNetSubProjectH src);

}
