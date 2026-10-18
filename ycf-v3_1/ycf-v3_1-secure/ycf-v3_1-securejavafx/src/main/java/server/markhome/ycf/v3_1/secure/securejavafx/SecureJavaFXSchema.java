// Description: Java 25 JavaFX Schema for Secure.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.securejavafx;

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
import server.markhome.ycf.v3_1.secure.secureobj.*;

public class SecureJavaFXSchema
implements ISecureJavaFXSchema
{
	protected ISecureSchemaObj schema = null;
	protected String clusterName = "system";
	protected ISecureClusterObj clusterObj = null;
	protected String tenantName = "system";
	protected ISecureTenantObj tenantObj = null;
	protected String secUserName = "system";
	protected ISecureSecUserObj secUserObj = null;
	protected ISecureSecSessionObj secSessionObj = null;
	protected ISecureJavaFXClusterFactory factoryCluster = null;
	protected ISecureJavaFXISOCcyFactory factoryISOCcy = null;
	protected ISecureJavaFXISOCtryFactory factoryISOCtry = null;
	protected ISecureJavaFXISOCtryCcyFactory factoryISOCtryCcy = null;
	protected ISecureJavaFXISOCtryLangFactory factoryISOCtryLang = null;
	protected ISecureJavaFXISOLangFactory factoryISOLang = null;
	protected ISecureJavaFXISOTZoneFactory factoryISOTZone = null;
	protected ISecureJavaFXSecClusGrpFactory factorySecClusGrp = null;
	protected ISecureJavaFXSecClusGrpMembFactory factorySecClusGrpMemb = null;
	protected ISecureJavaFXSecClusRoleFactory factorySecClusRole = null;
	protected ISecureJavaFXSecClusRoleMembFactory factorySecClusRoleMemb = null;
	protected ISecureJavaFXSecSessionFactory factorySecSession = null;
	protected ISecureJavaFXSecSysGrpFactory factorySecSysGrp = null;
	protected ISecureJavaFXSecSysGrpIncFactory factorySecSysGrpInc = null;
	protected ISecureJavaFXSecSysGrpMembFactory factorySecSysGrpMemb = null;
	protected ISecureJavaFXSecSysRoleFactory factorySecSysRole = null;
	protected ISecureJavaFXSecSysRoleEnablesFactory factorySecSysRoleEnables = null;
	protected ISecureJavaFXSecSysRoleMembFactory factorySecSysRoleMemb = null;
	protected ISecureJavaFXSecTentGrpFactory factorySecTentGrp = null;
	protected ISecureJavaFXSecTentGrpMembFactory factorySecTentGrpMemb = null;
	protected ISecureJavaFXSecTentRoleFactory factorySecTentRole = null;
	protected ISecureJavaFXSecTentRoleMembFactory factorySecTentRoleMemb = null;
	protected ISecureJavaFXSecUserFactory factorySecUser = null;
	protected ISecureJavaFXSecUserEMConfFactory factorySecUserEMConf = null;
	protected ISecureJavaFXSecUserPWHistoryFactory factorySecUserPWHistory = null;
	protected ISecureJavaFXSecUserPWResetFactory factorySecUserPWReset = null;
	protected ISecureJavaFXSecUserPasswordFactory factorySecUserPassword = null;
	protected ISecureJavaFXSysClusterFactory factorySysCluster = null;
	protected ISecureJavaFXTableInfoFactory factoryTableInfo = null;
	protected ISecureJavaFXTenantFactory factoryTenant = null;

	public SecureJavaFXSchema() {
		SecureJavaFX.init();
	}

	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ISecureSchemaObj argSchema ) {
		final String S_ProcName = "setSchema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		if( ! ( argSchema instanceof ISecureSchemaObj ) ) {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"argSchema",
				argSchema,
				"ISecureSchemaObj" );
		}
		schema = (ISecureSchemaObj)argSchema;
	}

	public String getClusterName() {
		return( clusterName );
	}

	public void setClusterName( String argClusterName ) {
		final String S_ProcName = "setClusterName";
		if( ( argClusterName == null ) || ( argClusterName.length() <= 0 ) ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argClusterName" );
		}
		clusterName = argClusterName;
		clusterObj = null;
	}

	public ISecureClusterObj getClusterObj() {
		if( clusterObj == null ) {
			if( schema != null ) {
				clusterObj = schema.getClusterTableObj().readClusterByUDomNameIdx( clusterName );
			}
			if( clusterObj == null ) {
				throw new YCFLibDataNotFoundException( getClass(),
					"getClusterObj",
					"UniqueDomainName",
					"UniqueDomainName",
					clusterName );
			}
		}
		else {
			throw new YCFLibRuntimeException( getClass(),
				"getClusterObj",
				String.format(Inz.x("ycflib.common.CannotResolveWithoutCnx"), "Cluster"),
				String.format(Inz.s("ycflib.common.CannotResolveWithoutCnx"), "Cluster") );
		}
		return( clusterObj );
	}

	public String getTenantName() {
		return( tenantName );
	}

	public void setTenantName( String argTenantName ) {
		final String S_ProcName = "setTenantName";
		if( ( argTenantName == null ) || ( argTenantName.length() <= 0 ) ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argTenantName" );
		}
		tenantName = argTenantName;
		tenantObj = null;
	}

	public ISecureTenantObj getTenantObj() {
		if( tenantObj == null ) {
			if( schema != null ) {
				tenantObj = schema.getTenantTableObj().readTenantByUNameIdx( getClusterObj().getRequiredId(), tenantName );
			}
			if( tenantObj == null ) {
				throw new YCFLibDataNotFoundException( getClass(),
					"getTenantObj",
					"UniqueTenantName",
					"UniqueTenantName",
					new Object() {	protected YCFLibDbKeyHash256 clusterId = getClusterObj().getRequiredId();
						protected String name = tenantName; } );
			}
		}
		else {
			throw new YCFLibRuntimeException( getClass(),
				"getTenantObj",
				String.format(Inz.x("ycflib.common.CannotResolveWithoutCnx"), "Tenant"),
				String.format(Inz.s("ycflib.common.CannotResolveWithoutCnx"), "Tenant") );
		}
		return( tenantObj );
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public void setSecUserName( String argSecUserName ) {
		final String S_ProcName = "setSecUserName";
		if( ( argSecUserName == null ) || ( argSecUserName.length() <= 0 ) ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSecUserName" );
		}
		secUserName = argSecUserName;
		secUserObj = null;
	}

	public ISecureSecUserObj getSecUserObj() {
		if( secUserObj == null ) {
			if( schema != null ) {
				secUserObj = schema.getSecUserTableObj().readSecUserByULoginIdx( secUserName );
			}
			if( secUserObj == null ) {
				throw new YCFLibDataNotFoundException( getClass(),
					"getSecUserObj",
					"UniqueLogin",
					"UniqueLogin",
					secUserName );

			}
		}
		else {
			throw new YCFLibRuntimeException( getClass(),
				"getSecUserObj",
				String.format(Inz.x("ycflib.common.CannotResolveWithoutCnx"), "SecUser"),
				String.format(Inz.s("ycflib.common.CannotResolveWithoutCnx"), "SecUser") );
		}
		return( secUserObj );
	}

	public ISecureSecSessionObj getSecSessionObj() {
		if( secSessionObj == null ) {
			if( schema != null ) {
				getClusterObj();
				getTenantObj();
				getSecUserObj();
				secSessionObj = schema.getSecSessionTableObj().newInstance();
				ISecureSecSessionEditObj sessionEdit = secSessionObj.beginEdit();
				sessionEdit.setRequiredSecUserId( secUserObj.getPKey() );
				sessionEdit.setRequiredStart( LocalDateTime.now() );
				sessionEdit.setOptionalFinish( null );
				secSessionObj = sessionEdit.create();
				sessionEdit = null;
			}
		}
		else {
			throw new YCFLibRuntimeException( getClass(),
				"getSecSessionObj",
				String.format(Inz.x("ycflib.common.CannotResolveWithoutCnx"), "SecSession"),
				String.format(Inz.s("ycflib.common.CannotResolveWithoutCnx"), "SecSession") );
		}
		return( secSessionObj );
	}

	public ISecureJavaFXClusterFactory getClusterFactory() {
		if( factoryCluster == null ) {
			factoryCluster = new SecureJavaFXClusterFactory( this );
		}
		return( factoryCluster );
	}

	public ISecureJavaFXISOCcyFactory getISOCcyFactory() {
		if( factoryISOCcy == null ) {
			factoryISOCcy = new SecureJavaFXISOCcyFactory( this );
		}
		return( factoryISOCcy );
	}

	public ISecureJavaFXISOCtryFactory getISOCtryFactory() {
		if( factoryISOCtry == null ) {
			factoryISOCtry = new SecureJavaFXISOCtryFactory( this );
		}
		return( factoryISOCtry );
	}

	public ISecureJavaFXISOCtryCcyFactory getISOCtryCcyFactory() {
		if( factoryISOCtryCcy == null ) {
			factoryISOCtryCcy = new SecureJavaFXISOCtryCcyFactory( this );
		}
		return( factoryISOCtryCcy );
	}

	public ISecureJavaFXISOCtryLangFactory getISOCtryLangFactory() {
		if( factoryISOCtryLang == null ) {
			factoryISOCtryLang = new SecureJavaFXISOCtryLangFactory( this );
		}
		return( factoryISOCtryLang );
	}

	public ISecureJavaFXISOLangFactory getISOLangFactory() {
		if( factoryISOLang == null ) {
			factoryISOLang = new SecureJavaFXISOLangFactory( this );
		}
		return( factoryISOLang );
	}

	public ISecureJavaFXISOTZoneFactory getISOTZoneFactory() {
		if( factoryISOTZone == null ) {
			factoryISOTZone = new SecureJavaFXISOTZoneFactory( this );
		}
		return( factoryISOTZone );
	}

	public ISecureJavaFXSecClusGrpFactory getSecClusGrpFactory() {
		if( factorySecClusGrp == null ) {
			factorySecClusGrp = new SecureJavaFXSecClusGrpFactory( this );
		}
		return( factorySecClusGrp );
	}

	public ISecureJavaFXSecClusGrpMembFactory getSecClusGrpMembFactory() {
		if( factorySecClusGrpMemb == null ) {
			factorySecClusGrpMemb = new SecureJavaFXSecClusGrpMembFactory( this );
		}
		return( factorySecClusGrpMemb );
	}

	public ISecureJavaFXSecClusRoleFactory getSecClusRoleFactory() {
		if( factorySecClusRole == null ) {
			factorySecClusRole = new SecureJavaFXSecClusRoleFactory( this );
		}
		return( factorySecClusRole );
	}

	public ISecureJavaFXSecClusRoleMembFactory getSecClusRoleMembFactory() {
		if( factorySecClusRoleMemb == null ) {
			factorySecClusRoleMemb = new SecureJavaFXSecClusRoleMembFactory( this );
		}
		return( factorySecClusRoleMemb );
	}

	public ISecureJavaFXSecSessionFactory getSecSessionFactory() {
		if( factorySecSession == null ) {
			factorySecSession = new SecureJavaFXSecSessionFactory( this );
		}
		return( factorySecSession );
	}

	public ISecureJavaFXSecSysGrpFactory getSecSysGrpFactory() {
		if( factorySecSysGrp == null ) {
			factorySecSysGrp = new SecureJavaFXSecSysGrpFactory( this );
		}
		return( factorySecSysGrp );
	}

	public ISecureJavaFXSecSysGrpIncFactory getSecSysGrpIncFactory() {
		if( factorySecSysGrpInc == null ) {
			factorySecSysGrpInc = new SecureJavaFXSecSysGrpIncFactory( this );
		}
		return( factorySecSysGrpInc );
	}

	public ISecureJavaFXSecSysGrpMembFactory getSecSysGrpMembFactory() {
		if( factorySecSysGrpMemb == null ) {
			factorySecSysGrpMemb = new SecureJavaFXSecSysGrpMembFactory( this );
		}
		return( factorySecSysGrpMemb );
	}

	public ISecureJavaFXSecSysRoleFactory getSecSysRoleFactory() {
		if( factorySecSysRole == null ) {
			factorySecSysRole = new SecureJavaFXSecSysRoleFactory( this );
		}
		return( factorySecSysRole );
	}

	public ISecureJavaFXSecSysRoleEnablesFactory getSecSysRoleEnablesFactory() {
		if( factorySecSysRoleEnables == null ) {
			factorySecSysRoleEnables = new SecureJavaFXSecSysRoleEnablesFactory( this );
		}
		return( factorySecSysRoleEnables );
	}

	public ISecureJavaFXSecSysRoleMembFactory getSecSysRoleMembFactory() {
		if( factorySecSysRoleMemb == null ) {
			factorySecSysRoleMemb = new SecureJavaFXSecSysRoleMembFactory( this );
		}
		return( factorySecSysRoleMemb );
	}

	public ISecureJavaFXSecTentGrpFactory getSecTentGrpFactory() {
		if( factorySecTentGrp == null ) {
			factorySecTentGrp = new SecureJavaFXSecTentGrpFactory( this );
		}
		return( factorySecTentGrp );
	}

	public ISecureJavaFXSecTentGrpMembFactory getSecTentGrpMembFactory() {
		if( factorySecTentGrpMemb == null ) {
			factorySecTentGrpMemb = new SecureJavaFXSecTentGrpMembFactory( this );
		}
		return( factorySecTentGrpMemb );
	}

	public ISecureJavaFXSecTentRoleFactory getSecTentRoleFactory() {
		if( factorySecTentRole == null ) {
			factorySecTentRole = new SecureJavaFXSecTentRoleFactory( this );
		}
		return( factorySecTentRole );
	}

	public ISecureJavaFXSecTentRoleMembFactory getSecTentRoleMembFactory() {
		if( factorySecTentRoleMemb == null ) {
			factorySecTentRoleMemb = new SecureJavaFXSecTentRoleMembFactory( this );
		}
		return( factorySecTentRoleMemb );
	}

	public ISecureJavaFXSecUserFactory getSecUserFactory() {
		if( factorySecUser == null ) {
			factorySecUser = new SecureJavaFXSecUserFactory( this );
		}
		return( factorySecUser );
	}

	public ISecureJavaFXSecUserEMConfFactory getSecUserEMConfFactory() {
		if( factorySecUserEMConf == null ) {
			factorySecUserEMConf = new SecureJavaFXSecUserEMConfFactory( this );
		}
		return( factorySecUserEMConf );
	}

	public ISecureJavaFXSecUserPWHistoryFactory getSecUserPWHistoryFactory() {
		if( factorySecUserPWHistory == null ) {
			factorySecUserPWHistory = new SecureJavaFXSecUserPWHistoryFactory( this );
		}
		return( factorySecUserPWHistory );
	}

	public ISecureJavaFXSecUserPWResetFactory getSecUserPWResetFactory() {
		if( factorySecUserPWReset == null ) {
			factorySecUserPWReset = new SecureJavaFXSecUserPWResetFactory( this );
		}
		return( factorySecUserPWReset );
	}

	public ISecureJavaFXSecUserPasswordFactory getSecUserPasswordFactory() {
		if( factorySecUserPassword == null ) {
			factorySecUserPassword = new SecureJavaFXSecUserPasswordFactory( this );
		}
		return( factorySecUserPassword );
	}

	public ISecureJavaFXSysClusterFactory getSysClusterFactory() {
		if( factorySysCluster == null ) {
			factorySysCluster = new SecureJavaFXSysClusterFactory( this );
		}
		return( factorySysCluster );
	}

	public ISecureJavaFXTableInfoFactory getTableInfoFactory() {
		if( factoryTableInfo == null ) {
			factoryTableInfo = new SecureJavaFXTableInfoFactory( this );
		}
		return( factoryTableInfo );
	}

	public ISecureJavaFXTenantFactory getTenantFactory() {
		if( factoryTenant == null ) {
			factoryTenant = new SecureJavaFXTenantFactory( this );
		}
		return( factoryTenant );
	}
}
