
// Description: Java JPA Factory interface for License.

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
 *	IIntNetLicenseFactory interface for License
 */
public interface IIntNetLicenseFactory extends IIntNetProtLicenseFactory
{

	/**
	 *	Allocate a primary history key for License instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetLicenseHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for License instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtLicenseHPKey asProtected(IIntNetLicenseHPKey src);

	/**
	 *	Allocate a public primary history key for License instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubLicenseHPKey asPublic(IIntNetLicenseHPKey src);

	/**
	 *	Allocate a LicnTenantIdx key over License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetLicenseByLicnTenantIdxKey newByLicnTenantIdxKey();

	/**
	 *	Allocate a protected LicnTenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByLicnTenantIdxKey asProtected(IIntNetLicenseByLicnTenantIdxKey src);

	/**
	 *	Allocate a public LicnTenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByLicnTenantIdxKey asPublic(IIntNetLicenseByLicnTenantIdxKey src);

	/**
	 *	Allocate a DomainIdx key over License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetLicenseByDomainIdxKey newByDomainIdxKey();

	/**
	 *	Allocate a protected DomainIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByDomainIdxKey asProtected(IIntNetLicenseByDomainIdxKey src);

	/**
	 *	Allocate a public DomainIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByDomainIdxKey asPublic(IIntNetLicenseByDomainIdxKey src);

	/**
	 *	Allocate a UNameIdx key over License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetLicenseByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByUNameIdxKey asProtected(IIntNetLicenseByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByUNameIdxKey asPublic(IIntNetLicenseByUNameIdxKey src);

	/**
	 *	Allocate a License interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetLicense newRec();

	/**
	 *	Allocate a protected License interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicense asProtected(IIntNetLicense src);

	/**
	 *	Allocate a public License interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicense asPublic(IIntNetLicense src);

	/**
	 *	Allocate a License history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetLicenseH newHRec();

	/**
	 *	Allocate a protected License history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseH asProtected(IIntNetLicenseH src);

	/**
	 *	Allocate a public License history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseH asPublic(IIntNetLicenseH src);

}
