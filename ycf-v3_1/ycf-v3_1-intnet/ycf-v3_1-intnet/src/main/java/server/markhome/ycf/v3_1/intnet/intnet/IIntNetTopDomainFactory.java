
// Description: Java JPA Factory interface for TopDomain.

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
 *	IIntNetTopDomainFactory interface for TopDomain
 */
public interface IIntNetTopDomainFactory extends IIntNetProtTopDomainFactory
{

	/**
	 *	Allocate a primary history key for TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetTopDomainHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for TopDomain instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtTopDomainHPKey asProtected(IIntNetTopDomainHPKey src);

	/**
	 *	Allocate a public primary history key for TopDomain instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubTopDomainHPKey asPublic(IIntNetTopDomainHPKey src);

	/**
	 *	Allocate a TenantIdx key over TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopDomainByTenantIdxKey newByTenantIdxKey();

	/**
	 *	Allocate a protected TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByTenantIdxKey asProtected(IIntNetTopDomainByTenantIdxKey src);

	/**
	 *	Allocate a public TenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByTenantIdxKey asPublic(IIntNetTopDomainByTenantIdxKey src);

	/**
	 *	Allocate a TldIdx key over TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopDomainByTldIdxKey newByTldIdxKey();

	/**
	 *	Allocate a protected TldIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByTldIdxKey asProtected(IIntNetTopDomainByTldIdxKey src);

	/**
	 *	Allocate a public TldIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByTldIdxKey asPublic(IIntNetTopDomainByTldIdxKey src);

	/**
	 *	Allocate a NameIdx key over TopDomain instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopDomainByNameIdxKey newByNameIdxKey();

	/**
	 *	Allocate a protected NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainByNameIdxKey asProtected(IIntNetTopDomainByNameIdxKey src);

	/**
	 *	Allocate a public NameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainByNameIdxKey asPublic(IIntNetTopDomainByNameIdxKey src);

	/**
	 *	Allocate a TopDomain interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopDomain newRec();

	/**
	 *	Allocate a protected TopDomain interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomain asProtected(IIntNetTopDomain src);

	/**
	 *	Allocate a public TopDomain interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomain asPublic(IIntNetTopDomain src);

	/**
	 *	Allocate a TopDomain history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetTopDomainH newHRec();

	/**
	 *	Allocate a protected TopDomain history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtTopDomainH asProtected(IIntNetTopDomainH src);

	/**
	 *	Allocate a public TopDomain history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubTopDomainH asPublic(IIntNetTopDomainH src);

}
