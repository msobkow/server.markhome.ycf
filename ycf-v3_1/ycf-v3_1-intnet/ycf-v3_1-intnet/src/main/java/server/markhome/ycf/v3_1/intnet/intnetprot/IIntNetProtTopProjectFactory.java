
// Description: Java Protected Factory interface for TopProject.

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
 *	IIntNetProtTopProjectFactory protected interface for TopProject
 */
public interface IIntNetProtTopProjectFactory extends IIntNetPubTopProjectFactory
{

	/**
	 *	Allocate a protected primary history key for TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtTopProjectHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for TopProject instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubTopProjectHPKey asPublic(IIntNetProtTopProjectHPKey src);

	/**
	 *	Allocate a protected TenantIdx key over protected TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByTenantIdxKey newProtByTenantIdxKey();

	/**
	 *	Allocate a public TenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByTenantIdxKey asPublic(IIntNetProtTopProjectByTenantIdxKey src);

	/**
	 *	Allocate a protected TopDomainIdx key over protected TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByTopDomainIdxKey newProtByTopDomainIdxKey();

	/**
	 *	Allocate a public TopDomainIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByTopDomainIdxKey asPublic(IIntNetProtTopProjectByTopDomainIdxKey src);

	/**
	 *	Allocate a protected NameIdx key over protected TopProject instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectByNameIdxKey newProtByNameIdxKey();

	/**
	 *	Allocate a public NameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectByNameIdxKey asPublic(IIntNetProtTopProjectByNameIdxKey src);

	/**
	 *	Allocate a protected TopProject interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProject newProtRec();

	/**
	 *	Allocate a public TopProject interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProject asPublic(IIntNetProtTopProject src);

	/**
	 *	Allocate a protected TopProject history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopProjectH newProtHRec();

	/**
	 *	Allocate a public TopProject history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopProjectH asPublic(IIntNetProtTopProjectH src);

}
