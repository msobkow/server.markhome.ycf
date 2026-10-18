// Description: Java 25 Schema Object implementation for IntNet.

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

package server.markhome.ycf.v3_1.intnet.intnetobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public class IntNetSchemaObj
	implements IIntNetSchemaObj
{
	public static final String SCHEMA_NAME = IIntNetSchema.SCHEMA_NAME;
	public static final String SCHEMA_DBNAME = IIntNetSchema.DBSCHEMA_NAME;
	protected ISecureAuthorization authorization = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ISecureClusterObj secCluster = null;
	protected YCFDbKeyHash256 secClusterId = null;
	protected ISecureTenantObj secTenant = null;
	protected YCFDbKeyHash256 secTenantId = null;
	protected ISecureSecUserObj secUser = null;
	protected YCFDbKeyHash256 secSessionUserId = null;
	protected ISecureSecSessionObj secSession = null;
	protected YCFDbKeyHash256 secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();

	protected ISecureSchema secureBackingStore;
	protected IIntNetSchema intnetBackingStore;
	protected IIntNetClusterTableObj clusterTableObj;
	protected IIntNetISOCcyTableObj iSOCcyTableObj;
	protected IIntNetISOCtryTableObj iSOCtryTableObj;
	protected IIntNetISOCtryCcyTableObj iSOCtryCcyTableObj;
	protected IIntNetISOCtryLangTableObj iSOCtryLangTableObj;
	protected IIntNetISOLangTableObj iSOLangTableObj;
	protected IIntNetISOTZoneTableObj iSOTZoneTableObj;
	protected IIntNetLicenseTableObj licenseTableObj;
	protected IIntNetMajorVersionTableObj majorVersionTableObj;
	protected IIntNetMimeTypeTableObj mimeTypeTableObj;
	protected IIntNetMinorVersionTableObj minorVersionTableObj;
	protected IIntNetSecClusGrpTableObj secClusGrpTableObj;
	protected IIntNetSecClusGrpMembTableObj secClusGrpMembTableObj;
	protected IIntNetSecClusRoleTableObj secClusRoleTableObj;
	protected IIntNetSecClusRoleMembTableObj secClusRoleMembTableObj;
	protected IIntNetSecSessionTableObj secSessionTableObj;
	protected IIntNetSecSysGrpTableObj secSysGrpTableObj;
	protected IIntNetSecSysGrpIncTableObj secSysGrpIncTableObj;
	protected IIntNetSecSysGrpMembTableObj secSysGrpMembTableObj;
	protected IIntNetSecSysRoleTableObj secSysRoleTableObj;
	protected IIntNetSecSysRoleEnablesTableObj secSysRoleEnablesTableObj;
	protected IIntNetSecSysRoleMembTableObj secSysRoleMembTableObj;
	protected IIntNetSecTentGrpTableObj secTentGrpTableObj;
	protected IIntNetSecTentGrpMembTableObj secTentGrpMembTableObj;
	protected IIntNetSecTentRoleTableObj secTentRoleTableObj;
	protected IIntNetSecTentRoleMembTableObj secTentRoleMembTableObj;
	protected IIntNetSecUserTableObj secUserTableObj;
	protected IIntNetSecUserEMConfTableObj secUserEMConfTableObj;
	protected IIntNetSecUserPWHistoryTableObj secUserPWHistoryTableObj;
	protected IIntNetSecUserPWResetTableObj secUserPWResetTableObj;
	protected IIntNetSecUserPasswordTableObj secUserPasswordTableObj;
	protected IIntNetSubProjectTableObj subProjectTableObj;
	protected IIntNetSysClusterTableObj sysClusterTableObj;
	protected IIntNetTableInfoTableObj tableInfoTableObj;
	protected IIntNetTenantTableObj tenantTableObj;
	protected IIntNetTldTableObj tldTableObj;
	protected IIntNetTopDomainTableObj topDomainTableObj;
	protected IIntNetTopProjectTableObj topProjectTableObj;
	protected IIntNetURLProtocolTableObj uRLProtocolTableObj;

	public IntNetSchemaObj() {

		secureBackingStore = null;
		intnetBackingStore = null;
		clusterTableObj = new IntNetClusterTableObj( this );
		iSOCcyTableObj = new IntNetISOCcyTableObj( this );
		iSOCtryTableObj = new IntNetISOCtryTableObj( this );
		iSOCtryCcyTableObj = new IntNetISOCtryCcyTableObj( this );
		iSOCtryLangTableObj = new IntNetISOCtryLangTableObj( this );
		iSOLangTableObj = new IntNetISOLangTableObj( this );
		iSOTZoneTableObj = new IntNetISOTZoneTableObj( this );
		licenseTableObj = new IntNetLicenseTableObj( this );
		majorVersionTableObj = new IntNetMajorVersionTableObj( this );
		mimeTypeTableObj = new IntNetMimeTypeTableObj( this );
		minorVersionTableObj = new IntNetMinorVersionTableObj( this );
		secClusGrpTableObj = new IntNetSecClusGrpTableObj( this );
		secClusGrpMembTableObj = new IntNetSecClusGrpMembTableObj( this );
		secClusRoleTableObj = new IntNetSecClusRoleTableObj( this );
		secClusRoleMembTableObj = new IntNetSecClusRoleMembTableObj( this );
		secSessionTableObj = new IntNetSecSessionTableObj( this );
		secSysGrpTableObj = new IntNetSecSysGrpTableObj( this );
		secSysGrpIncTableObj = new IntNetSecSysGrpIncTableObj( this );
		secSysGrpMembTableObj = new IntNetSecSysGrpMembTableObj( this );
		secSysRoleTableObj = new IntNetSecSysRoleTableObj( this );
		secSysRoleEnablesTableObj = new IntNetSecSysRoleEnablesTableObj( this );
		secSysRoleMembTableObj = new IntNetSecSysRoleMembTableObj( this );
		secTentGrpTableObj = new IntNetSecTentGrpTableObj( this );
		secTentGrpMembTableObj = new IntNetSecTentGrpMembTableObj( this );
		secTentRoleTableObj = new IntNetSecTentRoleTableObj( this );
		secTentRoleMembTableObj = new IntNetSecTentRoleMembTableObj( this );
		secUserTableObj = new IntNetSecUserTableObj( this );
		secUserEMConfTableObj = new IntNetSecUserEMConfTableObj( this );
		secUserPWHistoryTableObj = new IntNetSecUserPWHistoryTableObj( this );
		secUserPWResetTableObj = new IntNetSecUserPWResetTableObj( this );
		secUserPasswordTableObj = new IntNetSecUserPasswordTableObj( this );
		subProjectTableObj = new IntNetSubProjectTableObj( this );
		sysClusterTableObj = new IntNetSysClusterTableObj( this );
		tableInfoTableObj = new IntNetTableInfoTableObj( this );
		tenantTableObj = new IntNetTenantTableObj( this );
		tldTableObj = new IntNetTldTableObj( this );
		topDomainTableObj = new IntNetTopDomainTableObj( this );
		topProjectTableObj = new IntNetTopProjectTableObj( this );
		uRLProtocolTableObj = new IntNetURLProtocolTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ISecureClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomNameIdx( secClusterName );
				if( secCluster == null && secClusterId != null && !secClusterId.isNull() ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ISecureClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public YCFDbKeyHash256 getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ISecureTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null && secTenantId != null && !secTenantId.isNull() ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ISecureTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public YCFDbKeyHash256 getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ISecureSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}

	public void setSecUser( ISecureSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ISecureSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ISecureSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( YCFDbKeyHash256 value ) {
		secSessionSessionId = value;
	}

	public YCFDbKeyHash256 getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public YCFDbKeyHash256 getSecSessionUserId() {
		return( secSessionUserId );
	}

	public ISecureAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( ISecureAuthorization value ) {
		authorization = value;
	}

	@Override
	public ISecureSchema getSecureBackingStore() {
		return( secureBackingStore );
	}

	@Override
	public void setSecureBackingStore(ISecureSchema secureBackingStore) {
		if (secureBackingStore == null) {
			throw new YCFNullArgumentException(getClass(), "setSecureBackingStore", 1, "secureBackingStore");
		}
		this.secureBackingStore = secureBackingStore;
	}

	@Override
	public IIntNetSchema getIntNetBackingStore() {
		return( intnetBackingStore );
	}

	@Override
	public void setIntNetBackingStore(IIntNetSchema intnetBackingStore) {
		if (intnetBackingStore == null) {
			throw new YCFNullArgumentException(getClass(), "setIntNetBackingStore", 1, "intnetBackingStore");
		}
		this.intnetBackingStore = intnetBackingStore;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public void minimizeMemory() {
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( iSOCcyTableObj != null ) {
			iSOCcyTableObj.minimizeMemory();
		}
		if( iSOCtryTableObj != null ) {
			iSOCtryTableObj.minimizeMemory();
		}
		if( iSOCtryCcyTableObj != null ) {
			iSOCtryCcyTableObj.minimizeMemory();
		}
		if( iSOCtryLangTableObj != null ) {
			iSOCtryLangTableObj.minimizeMemory();
		}
		if( iSOLangTableObj != null ) {
			iSOLangTableObj.minimizeMemory();
		}
		if( iSOTZoneTableObj != null ) {
			iSOTZoneTableObj.minimizeMemory();
		}
		if( licenseTableObj != null ) {
			licenseTableObj.minimizeMemory();
		}
		if( majorVersionTableObj != null ) {
			majorVersionTableObj.minimizeMemory();
		}
		if( mimeTypeTableObj != null ) {
			mimeTypeTableObj.minimizeMemory();
		}
		if( minorVersionTableObj != null ) {
			minorVersionTableObj.minimizeMemory();
		}
		if( secClusGrpTableObj != null ) {
			secClusGrpTableObj.minimizeMemory();
		}
		if( secClusGrpMembTableObj != null ) {
			secClusGrpMembTableObj.minimizeMemory();
		}
		if( secClusRoleTableObj != null ) {
			secClusRoleTableObj.minimizeMemory();
		}
		if( secClusRoleMembTableObj != null ) {
			secClusRoleMembTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secSysGrpTableObj != null ) {
			secSysGrpTableObj.minimizeMemory();
		}
		if( secSysGrpIncTableObj != null ) {
			secSysGrpIncTableObj.minimizeMemory();
		}
		if( secSysGrpMembTableObj != null ) {
			secSysGrpMembTableObj.minimizeMemory();
		}
		if( secSysRoleTableObj != null ) {
			secSysRoleTableObj.minimizeMemory();
		}
		if( secSysRoleEnablesTableObj != null ) {
			secSysRoleEnablesTableObj.minimizeMemory();
		}
		if( secSysRoleMembTableObj != null ) {
			secSysRoleMembTableObj.minimizeMemory();
		}
		if( secTentGrpTableObj != null ) {
			secTentGrpTableObj.minimizeMemory();
		}
		if( secTentGrpMembTableObj != null ) {
			secTentGrpMembTableObj.minimizeMemory();
		}
		if( secTentRoleTableObj != null ) {
			secTentRoleTableObj.minimizeMemory();
		}
		if( secTentRoleMembTableObj != null ) {
			secTentRoleMembTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( secUserEMConfTableObj != null ) {
			secUserEMConfTableObj.minimizeMemory();
		}
		if( secUserPWHistoryTableObj != null ) {
			secUserPWHistoryTableObj.minimizeMemory();
		}
		if( secUserPWResetTableObj != null ) {
			secUserPWResetTableObj.minimizeMemory();
		}
		if( secUserPasswordTableObj != null ) {
			secUserPasswordTableObj.minimizeMemory();
		}
		if( subProjectTableObj != null ) {
			subProjectTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tableInfoTableObj != null ) {
			tableInfoTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
		if( tldTableObj != null ) {
			tldTableObj.minimizeMemory();
		}
		if( topDomainTableObj != null ) {
			topDomainTableObj.minimizeMemory();
		}
		if( topProjectTableObj != null ) {
			topProjectTableObj.minimizeMemory();
		}
		if( uRLProtocolTableObj != null ) {
			uRLProtocolTableObj.minimizeMemory();
		}
	}

	public void logout() {
		if( authorization == null ) {
			return;
		}
		setAuthorization( null );
		YCFDbKeyHash256 secSessionId = authorization.getSecSessionId();
		if( secSessionId != null ) {
			ISecureSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
			if( secSession != null ) {
				if( secSession.getOptionalFinish() == null ) {
					ISecureSecSessionEditObj editSecSession = secSession.beginEdit();
					editSecSession.setOptionalFinish( LocalDateTime.now() );
					editSecSession.update();
					editSecSession = null;
				}
			}
		}
	}

	public IIntNetClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public IIntNetISOCcyTableObj getISOCcyTableObj() {
		return( iSOCcyTableObj );
	}

	public IIntNetISOCtryTableObj getISOCtryTableObj() {
		return( iSOCtryTableObj );
	}

	public IIntNetISOCtryCcyTableObj getISOCtryCcyTableObj() {
		return( iSOCtryCcyTableObj );
	}

	public IIntNetISOCtryLangTableObj getISOCtryLangTableObj() {
		return( iSOCtryLangTableObj );
	}

	public IIntNetISOLangTableObj getISOLangTableObj() {
		return( iSOLangTableObj );
	}

	public IIntNetISOTZoneTableObj getISOTZoneTableObj() {
		return( iSOTZoneTableObj );
	}

	public IIntNetLicenseTableObj getLicenseTableObj() {
		return( licenseTableObj );
	}

	public IIntNetMajorVersionTableObj getMajorVersionTableObj() {
		return( majorVersionTableObj );
	}

	public IIntNetMimeTypeTableObj getMimeTypeTableObj() {
		return( mimeTypeTableObj );
	}

	public IIntNetMinorVersionTableObj getMinorVersionTableObj() {
		return( minorVersionTableObj );
	}

	public IIntNetSecClusGrpTableObj getSecClusGrpTableObj() {
		return( secClusGrpTableObj );
	}

	public IIntNetSecClusGrpMembTableObj getSecClusGrpMembTableObj() {
		return( secClusGrpMembTableObj );
	}

	public IIntNetSecClusRoleTableObj getSecClusRoleTableObj() {
		return( secClusRoleTableObj );
	}

	public IIntNetSecClusRoleMembTableObj getSecClusRoleMembTableObj() {
		return( secClusRoleMembTableObj );
	}

	public IIntNetSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public IIntNetSecSysGrpTableObj getSecSysGrpTableObj() {
		return( secSysGrpTableObj );
	}

	public IIntNetSecSysGrpIncTableObj getSecSysGrpIncTableObj() {
		return( secSysGrpIncTableObj );
	}

	public IIntNetSecSysGrpMembTableObj getSecSysGrpMembTableObj() {
		return( secSysGrpMembTableObj );
	}

	public IIntNetSecSysRoleTableObj getSecSysRoleTableObj() {
		return( secSysRoleTableObj );
	}

	public IIntNetSecSysRoleEnablesTableObj getSecSysRoleEnablesTableObj() {
		return( secSysRoleEnablesTableObj );
	}

	public IIntNetSecSysRoleMembTableObj getSecSysRoleMembTableObj() {
		return( secSysRoleMembTableObj );
	}

	public IIntNetSecTentGrpTableObj getSecTentGrpTableObj() {
		return( secTentGrpTableObj );
	}

	public IIntNetSecTentGrpMembTableObj getSecTentGrpMembTableObj() {
		return( secTentGrpMembTableObj );
	}

	public IIntNetSecTentRoleTableObj getSecTentRoleTableObj() {
		return( secTentRoleTableObj );
	}

	public IIntNetSecTentRoleMembTableObj getSecTentRoleMembTableObj() {
		return( secTentRoleMembTableObj );
	}

	public IIntNetSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public IIntNetSecUserEMConfTableObj getSecUserEMConfTableObj() {
		return( secUserEMConfTableObj );
	}

	public IIntNetSecUserPWHistoryTableObj getSecUserPWHistoryTableObj() {
		return( secUserPWHistoryTableObj );
	}

	public IIntNetSecUserPWResetTableObj getSecUserPWResetTableObj() {
		return( secUserPWResetTableObj );
	}

	public IIntNetSecUserPasswordTableObj getSecUserPasswordTableObj() {
		return( secUserPasswordTableObj );
	}

	public IIntNetSubProjectTableObj getSubProjectTableObj() {
		return( subProjectTableObj );
	}

	public IIntNetSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public IIntNetTableInfoTableObj getTableInfoTableObj() {
		return( tableInfoTableObj );
	}

	public IIntNetTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public IIntNetTldTableObj getTldTableObj() {
		return( tldTableObj );
	}

	public IIntNetTopDomainTableObj getTopDomainTableObj() {
		return( topDomainTableObj );
	}

	public IIntNetTopProjectTableObj getTopProjectTableObj() {
		return( topProjectTableObj );
	}

	public IIntNetURLProtocolTableObj getURLProtocolTableObj() {
		return( uRLProtocolTableObj );
	}
}
