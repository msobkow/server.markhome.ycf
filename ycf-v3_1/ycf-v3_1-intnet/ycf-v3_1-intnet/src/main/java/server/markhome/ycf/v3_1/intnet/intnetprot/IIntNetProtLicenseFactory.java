
// Description: Java Protected Factory interface for License.

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
 *	IIntNetProtLicenseFactory protected interface for License
 */
public interface IIntNetProtLicenseFactory extends IIntNetPubLicenseFactory
{

	/**
	 *	Allocate a protected primary history key for License instances.
	 *
	 *	@return	The new instance.
	 */
	IIntNetProtLicenseHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for License instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IIntNetPubLicenseHPKey asPublic(IIntNetProtLicenseHPKey src);

	/**
	 *	Allocate a protected LicnTenantIdx key over protected License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByLicnTenantIdxKey newProtByLicnTenantIdxKey();

	/**
	 *	Allocate a public LicnTenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByLicnTenantIdxKey asPublic(IIntNetProtLicenseByLicnTenantIdxKey src);

	/**
	 *	Allocate a protected DomainIdx key over protected License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByDomainIdxKey newProtByDomainIdxKey();

	/**
	 *	Allocate a public DomainIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByDomainIdxKey asPublic(IIntNetProtLicenseByDomainIdxKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected License instances.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseByUNameIdxKey asPublic(IIntNetProtLicenseByUNameIdxKey src);

	/**
	 *	Allocate a protected License interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicense newProtRec();

	/**
	 *	Allocate a public License interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicense asPublic(IIntNetProtLicense src);

	/**
	 *	Allocate a protected License history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetProtLicenseH newProtHRec();

	/**
	 *	Allocate a public License history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IIntNetPubLicenseH asPublic(IIntNetProtLicenseH src);

}
