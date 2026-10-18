// Description: Java 25 implementation of an in-memory RAM Secure schema.

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

package server.markhome.ycf.v3_1.secure.secureram;

import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.secure.securesaxloader.*;

//import server.markhome.ycf.v3_1.secure.securepub.buff.SecurePubBuffFactoryService;

public class SecureRamSchema
	extends SecureBuffSchema
	implements ISecureSchema
{
	protected short nextISOCcyIdGenValue = 1;
	protected short nextISOCtryIdGenValue = 1;
	protected short nextISOLangIdGenValue = 1;
	protected short nextISOTZoneIdGenValue = 1;
	protected int nextTableInfoIdGenValue = 1;


	public SecureRamSchema() {
		super();
		tableCluster = new SecureRamClusterTable( this );
		tableISOCcy = new SecureRamISOCcyTable( this );
		tableISOCtry = new SecureRamISOCtryTable( this );
		tableISOCtryCcy = new SecureRamISOCtryCcyTable( this );
		tableISOCtryLang = new SecureRamISOCtryLangTable( this );
		tableISOLang = new SecureRamISOLangTable( this );
		tableISOTZone = new SecureRamISOTZoneTable( this );
		tableSecClusGrp = new SecureRamSecClusGrpTable( this );
		tableSecClusGrpMemb = new SecureRamSecClusGrpMembTable( this );
		tableSecClusRole = new SecureRamSecClusRoleTable( this );
		tableSecClusRoleMemb = new SecureRamSecClusRoleMembTable( this );
		tableSecSession = new SecureRamSecSessionTable( this );
		tableSecSysGrp = new SecureRamSecSysGrpTable( this );
		tableSecSysGrpInc = new SecureRamSecSysGrpIncTable( this );
		tableSecSysGrpMemb = new SecureRamSecSysGrpMembTable( this );
		tableSecSysRole = new SecureRamSecSysRoleTable( this );
		tableSecSysRoleEnables = new SecureRamSecSysRoleEnablesTable( this );
		tableSecSysRoleMemb = new SecureRamSecSysRoleMembTable( this );
		tableSecTentGrp = new SecureRamSecTentGrpTable( this );
		tableSecTentGrpMemb = new SecureRamSecTentGrpMembTable( this );
		tableSecTentRole = new SecureRamSecTentRoleTable( this );
		tableSecTentRoleMemb = new SecureRamSecTentRoleMembTable( this );
		tableSecUser = new SecureRamSecUserTable( this );
		tableSecUserEMConf = new SecureRamSecUserEMConfTable( this );
		tableSecUserPWHistory = new SecureRamSecUserPWHistoryTable( this );
		tableSecUserPWReset = new SecureRamSecUserPWResetTable( this );
		tableSecUserPassword = new SecureRamSecUserPasswordTable( this );
		tableSysCluster = new SecureRamSysClusterTable( this );
		tableTableInfo = new SecureRamTableInfoTable( this );
		tableTenant = new SecureRamTenantTable( this );
	}

	@Override
	public ISecureSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	@Override
	public short nextISOCcyIdGen() {
		short next = nextISOCcyIdGenValue++;
		return( next );
	}

	@Override
	public short nextISOCtryIdGen() {
		short next = nextISOCtryIdGenValue++;
		return( next );
	}

	@Override
	public short nextISOLangIdGen() {
		short next = nextISOLangIdGenValue++;
		return( next );
	}

	@Override
	public short nextISOTZoneIdGen() {
		short next = nextISOTZoneIdGenValue++;
		return( next );
	}

	@Override
	public int nextTableInfoIdGen() {
		int next = nextTableInfoIdGenValue++;
		return( next );
	}

	@Override
	public YCFDbKeyHash256 nextClusterIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecUserIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTenantIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	public String fileImport( SecureAuthorization Authorization,
		String fileName,
		String fileContent )
	{
		final String S_ProcName = "fileImport";
		if( ( fileName == null ) || ( fileName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				1,
				"fileName" );
		}
		if( ( fileContent == null ) || ( fileContent.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				2,
				"fileContent" );
		}

		SecureSaxLoader saxLoader = new SecureSaxLoader();
		ISecureSchemaObj schemaObj = new SecureSchemaObj();
		schemaObj.setSecureBackingStore( this );
		saxLoader.setSchemaObj( schemaObj );
		ISecureClusterObj useCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( Authorization.getSecClusterId() );
		ISecureTenantObj useTenant = schemaObj.getTenantTableObj().readTenantByIdIdx( Authorization.getSecTenantId() );
		YCFCachedMessageLog runlog = new YCFCachedMessageLog();
		saxLoader.setLog( runlog );
		saxLoader.setUseCluster( useCluster );
		saxLoader.setUseTenant( useTenant );
		saxLoader.parseStringContents( fileContent );
		String logFileContent = runlog.getCacheContents();
		if( logFileContent == null ) {
			logFileContent = "";
		}

		return( logFileContent );
	}

		
	@Override
	public void wireTableTableInstances() {
		if (tableCluster == null || !(tableCluster instanceof SecureRamClusterTable)) {
			tableCluster = new SecureRamClusterTable(this);
		}
		if (tableTenant == null || !(tableTenant instanceof SecureRamTenantTable)) {
			tableTenant = new SecureRamTenantTable(this);
		}
		if (tableTableInfo == null || !(tableTableInfo instanceof SecureRamTableInfoTable)) {
			tableTableInfo = new SecureRamTableInfoTable(this);
		}
		if (tableISOCcy == null || !(tableISOCcy instanceof SecureRamISOCcyTable)) {
			tableISOCcy = new SecureRamISOCcyTable(this);
		}
		if (tableISOCtry == null || !(tableISOCtry instanceof SecureRamISOCtryTable)) {
			tableISOCtry = new SecureRamISOCtryTable(this);
		}
		if (tableISOCtryCcy == null || !(tableISOCtryCcy instanceof SecureRamISOCtryCcyTable)) {
			tableISOCtryCcy = new SecureRamISOCtryCcyTable(this);
		}
		if (tableISOCtryLang == null || !(tableISOCtryLang instanceof SecureRamISOCtryLangTable)) {
			tableISOCtryLang = new SecureRamISOCtryLangTable(this);
		}
		if (tableISOLang == null || !(tableISOLang instanceof SecureRamISOLangTable)) {
			tableISOLang = new SecureRamISOLangTable(this);
		}
		if (tableISOTZone == null || !(tableISOTZone instanceof SecureRamISOTZoneTable)) {
			tableISOTZone = new SecureRamISOTZoneTable(this);
		}
		if (tableSecUser == null || !(tableSecUser instanceof SecureRamSecUserTable)) {
			tableSecUser = new SecureRamSecUserTable(this);
		}
		if (tableSecUserPassword == null || !(tableSecUserPassword instanceof SecureRamSecUserPasswordTable)) {
			tableSecUserPassword = new SecureRamSecUserPasswordTable(this);
		}
		if (tableSecUserEMConf == null || !(tableSecUserEMConf instanceof SecureRamSecUserEMConfTable)) {
			tableSecUserEMConf = new SecureRamSecUserEMConfTable(this);
		}
		if (tableSecUserPWReset == null || !(tableSecUserPWReset instanceof SecureRamSecUserPWResetTable)) {
			tableSecUserPWReset = new SecureRamSecUserPWResetTable(this);
		}
		if (tableSecUserPWHistory == null || !(tableSecUserPWHistory instanceof SecureRamSecUserPWHistoryTable)) {
			tableSecUserPWHistory = new SecureRamSecUserPWHistoryTable(this);
		}
		if (tableSecSysGrp == null || !(tableSecSysGrp instanceof SecureRamSecSysGrpTable)) {
			tableSecSysGrp = new SecureRamSecSysGrpTable(this);
		}
		if (tableSecSysGrpInc == null || !(tableSecSysGrpInc instanceof SecureRamSecSysGrpIncTable)) {
			tableSecSysGrpInc = new SecureRamSecSysGrpIncTable(this);
		}
		if (tableSecSysGrpMemb == null || !(tableSecSysGrpMemb instanceof SecureRamSecSysGrpMembTable)) {
			tableSecSysGrpMemb = new SecureRamSecSysGrpMembTable(this);
		}
		if (tableSecClusGrp == null || !(tableSecClusGrp instanceof SecureRamSecClusGrpTable)) {
			tableSecClusGrp = new SecureRamSecClusGrpTable(this);
		}
		if (tableSecClusGrpMemb == null || !(tableSecClusGrpMemb instanceof SecureRamSecClusGrpMembTable)) {
			tableSecClusGrpMemb = new SecureRamSecClusGrpMembTable(this);
		}
		if (tableSecTentGrp == null || !(tableSecTentGrp instanceof SecureRamSecTentGrpTable)) {
			tableSecTentGrp = new SecureRamSecTentGrpTable(this);
		}
		if (tableSecTentGrpMemb == null || !(tableSecTentGrpMemb instanceof SecureRamSecTentGrpMembTable)) {
			tableSecTentGrpMemb = new SecureRamSecTentGrpMembTable(this);
		}
		if (tableSecSysRole == null || !(tableSecSysRole instanceof SecureRamSecSysRoleTable)) {
			tableSecSysRole = new SecureRamSecSysRoleTable(this);
		}
		if (tableSecSysRoleEnables == null || !(tableSecSysRoleEnables instanceof SecureRamSecSysRoleEnablesTable)) {
			tableSecSysRoleEnables = new SecureRamSecSysRoleEnablesTable(this);
		}
		if (tableSecSysRoleMemb == null || !(tableSecSysRoleMemb instanceof SecureRamSecSysRoleMembTable)) {
			tableSecSysRoleMemb = new SecureRamSecSysRoleMembTable(this);
		}
		if (tableSecClusRole == null || !(tableSecClusRole instanceof SecureRamSecClusRoleTable)) {
			tableSecClusRole = new SecureRamSecClusRoleTable(this);
		}
		if (tableSecClusRoleMemb == null || !(tableSecClusRoleMemb instanceof SecureRamSecClusRoleMembTable)) {
			tableSecClusRoleMemb = new SecureRamSecClusRoleMembTable(this);
		}
		if (tableSecTentRole == null || !(tableSecTentRole instanceof SecureRamSecTentRoleTable)) {
			tableSecTentRole = new SecureRamSecTentRoleTable(this);
		}
		if (tableSecTentRoleMemb == null || !(tableSecTentRoleMemb instanceof SecureRamSecTentRoleMembTable)) {
			tableSecTentRoleMemb = new SecureRamSecTentRoleMembTable(this);
		}
		if (tableSecSession == null || !(tableSecSession instanceof SecureRamSecSessionTable)) {
			tableSecSession = new SecureRamSecSessionTable(this);
		}
		if (tableSysCluster == null || !(tableSysCluster instanceof SecureRamSysClusterTable)) {
			tableSysCluster = new SecureRamSysClusterTable(this);
		}
	}
}
