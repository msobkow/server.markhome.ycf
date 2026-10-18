// Description: Java 25 JavaFX Schema Interface for IntNet.

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

package server.markhome.ycf.v3_1.intnet.intnetjavafx;

import java.math.*;
import java.time.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;

/**
 *	The IIntNetJavaFXSchema defines the factory interface for the
 *	for the various panes and components used to construct a GUI interface
 *	using the JavaFX framework.
 */
public interface IIntNetJavaFXSchema
	extends ISecureJavaFXSchema
{
	ISecureSchemaObj getSchema();
	void setSchema( ISecureSchemaObj argSchema );

	String getClusterName();
	void setClusterName( String argClusterName );
	ISecureClusterObj getClusterObj();

	String getTenantName();
	void setTenantName( String argTenantName );
	ISecureTenantObj getTenantObj();

	String getSecUserName();
	void setSecUserName( String argSecUserName );
	ISecureSecUserObj getSecUserObj();

	ISecureSecSessionObj getSecSessionObj();

	public ISecureJavaFXClusterFactory getClusterFactory();

	public ISecureJavaFXISOCcyFactory getISOCcyFactory();

	public ISecureJavaFXISOCtryFactory getISOCtryFactory();

	public ISecureJavaFXISOCtryCcyFactory getISOCtryCcyFactory();

	public ISecureJavaFXISOCtryLangFactory getISOCtryLangFactory();

	public ISecureJavaFXISOLangFactory getISOLangFactory();

	public ISecureJavaFXISOTZoneFactory getISOTZoneFactory();

	public IIntNetJavaFXLicenseFactory getLicenseFactory();

	public IIntNetJavaFXMajorVersionFactory getMajorVersionFactory();

	public IIntNetJavaFXMimeTypeFactory getMimeTypeFactory();

	public IIntNetJavaFXMinorVersionFactory getMinorVersionFactory();

	public ISecureJavaFXSecClusGrpFactory getSecClusGrpFactory();

	public ISecureJavaFXSecClusGrpMembFactory getSecClusGrpMembFactory();

	public ISecureJavaFXSecClusRoleFactory getSecClusRoleFactory();

	public ISecureJavaFXSecClusRoleMembFactory getSecClusRoleMembFactory();

	public ISecureJavaFXSecSessionFactory getSecSessionFactory();

	public ISecureJavaFXSecSysGrpFactory getSecSysGrpFactory();

	public ISecureJavaFXSecSysGrpIncFactory getSecSysGrpIncFactory();

	public ISecureJavaFXSecSysGrpMembFactory getSecSysGrpMembFactory();

	public ISecureJavaFXSecSysRoleFactory getSecSysRoleFactory();

	public ISecureJavaFXSecSysRoleEnablesFactory getSecSysRoleEnablesFactory();

	public ISecureJavaFXSecSysRoleMembFactory getSecSysRoleMembFactory();

	public ISecureJavaFXSecTentGrpFactory getSecTentGrpFactory();

	public ISecureJavaFXSecTentGrpMembFactory getSecTentGrpMembFactory();

	public ISecureJavaFXSecTentRoleFactory getSecTentRoleFactory();

	public ISecureJavaFXSecTentRoleMembFactory getSecTentRoleMembFactory();

	public ISecureJavaFXSecUserFactory getSecUserFactory();

	public ISecureJavaFXSecUserEMConfFactory getSecUserEMConfFactory();

	public ISecureJavaFXSecUserPWHistoryFactory getSecUserPWHistoryFactory();

	public ISecureJavaFXSecUserPWResetFactory getSecUserPWResetFactory();

	public ISecureJavaFXSecUserPasswordFactory getSecUserPasswordFactory();

	public IIntNetJavaFXSubProjectFactory getSubProjectFactory();

	public ISecureJavaFXSysClusterFactory getSysClusterFactory();

	public ISecureJavaFXTableInfoFactory getTableInfoFactory();

	public ISecureJavaFXTenantFactory getTenantFactory();

	public IIntNetJavaFXTldFactory getTldFactory();

	public IIntNetJavaFXTopDomainFactory getTopDomainFactory();

	public IIntNetJavaFXTopProjectFactory getTopProjectFactory();

	public IIntNetJavaFXURLProtocolFactory getURLProtocolFactory();
}
