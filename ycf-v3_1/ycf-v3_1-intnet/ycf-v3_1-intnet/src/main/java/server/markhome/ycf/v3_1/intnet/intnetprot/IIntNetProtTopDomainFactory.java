
// Description: Java Protected Factory interface for TopDomain.

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
 *	IIntNetProtTopDomainFactory protected interface for TopDomain
 */
public interface IIntNetProtTopDomainFactory extends IIntNetPubTopDomainFactory
{

	/**
	 *	Allocate a protected primary history key for TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtTopDomainHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for TopDomain instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubTopDomainHPKey asPublic(IIntNetProtTopDomainHPKey src);

	/**
	 *	Allocate a protected TenantIdx key over protected TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByTenantIdxKey newProtByTenantIdxKey();

	/**
	 *	Allocate a public TenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByTenantIdxKey asPublic(IIntNetProtTopDomainByTenantIdxKey src);

	/**
	 *	Allocate a protected TldIdx key over protected TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByTldIdxKey newProtByTldIdxKey();

	/**
	 *	Allocate a public TldIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByTldIdxKey asPublic(IIntNetProtTopDomainByTldIdxKey src);

	/**
	 *	Allocate a protected NameIdx key over protected TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByNameIdxKey newProtByNameIdxKey();

	/**
	 *	Allocate a public NameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByNameIdxKey asPublic(IIntNetProtTopDomainByNameIdxKey src);

	/**
	 *	Allocate a protected TopDomain interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomain newProtRec();

	/**
	 *	Allocate a public TopDomain interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomain asPublic(IIntNetProtTopDomain src);

	/**
	 *	Allocate a protected TopDomain history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainH newProtHRec();

	/**
	 *	Allocate a public TopDomain history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainH asPublic(IIntNetProtTopDomainH src);

}
