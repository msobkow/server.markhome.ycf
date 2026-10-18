
// Description: Java Protected Factory interface for SubProject.

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
 *	IIntNetProtSubProjectFactory protected interface for SubProject
 */
public interface IIntNetProtSubProjectFactory extends IIntNetPubSubProjectFactory
{

	/**
	 *	Allocate a protected primary history key for SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtSubProjectHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for SubProject instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubSubProjectHPKey asPublic(IIntNetProtSubProjectHPKey src);

	/**
	 *	Allocate a protected TenantIdx key over protected SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByTenantIdxKey newProtByTenantIdxKey();

	/**
	 *	Allocate a public TenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByTenantIdxKey asPublic(IIntNetProtSubProjectByTenantIdxKey src);

	/**
	 *	Allocate a protected TopProjectIdx key over protected SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByTopProjectIdxKey newProtByTopProjectIdxKey();

	/**
	 *	Allocate a public TopProjectIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByTopProjectIdxKey asPublic(IIntNetProtSubProjectByTopProjectIdxKey src);

	/**
	 *	Allocate a protected NameIdx key over protected SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectByNameIdxKey newProtByNameIdxKey();

	/**
	 *	Allocate a public NameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectByNameIdxKey asPublic(IIntNetProtSubProjectByNameIdxKey src);

	/**
	 *	Allocate a protected SubProject interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProject newProtRec();

	/**
	 *	Allocate a public SubProject interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProject asPublic(IIntNetProtSubProject src);

	/**
	 *	Allocate a protected SubProject history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtSubProjectH newProtHRec();

	/**
	 *	Allocate a public SubProject history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubSubProjectH asPublic(IIntNetProtSubProjectH src);

}
