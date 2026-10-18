// Description: Java 25 JavaFX Schema for BusModel.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;
import server.markhome.ycf.v3_1.intnet.intnetjavafx.*;

public class BusModelJavaFXSchema
implements IBusModelJavaFXSchema
{
	protected IBusModelSchemaObj schema = null;
	protected String clusterName = "system";
	protected ISecureClusterObj clusterObj = null;
	protected String tenantName = "system";
	protected ISecureTenantObj tenantObj = null;
	protected String secUserName = "system";
	protected ISecureSecUserObj secUserObj = null;
	protected ISecureSecSessionObj secSessionObj = null;
	protected IBusModelJavaFXAtomFactory factoryAtom = null;
	protected IBusModelJavaFXBlobColFactory factoryBlobCol = null;
	protected IBusModelJavaFXBlobDefFactory factoryBlobDef = null;
	protected IBusModelJavaFXBlobTypeFactory factoryBlobType = null;
	protected IBusModelJavaFXBoolColFactory factoryBoolCol = null;
	protected IBusModelJavaFXBoolDefFactory factoryBoolDef = null;
	protected IBusModelJavaFXBoolTypeFactory factoryBoolType = null;
	protected IBusModelJavaFXChainFactory factoryChain = null;
	protected IBusModelJavaFXClearDepFactory factoryClearDep = null;
	protected IBusModelJavaFXClearSubDep1Factory factoryClearSubDep1 = null;
	protected IBusModelJavaFXClearSubDep2Factory factoryClearSubDep2 = null;
	protected IBusModelJavaFXClearSubDep3Factory factoryClearSubDep3 = null;
	protected IBusModelJavaFXClearTopDepFactory factoryClearTopDep = null;
	protected ISecureJavaFXClusterFactory factoryCluster = null;
	protected IBusModelJavaFXDateColFactory factoryDateCol = null;
	protected IBusModelJavaFXDateDefFactory factoryDateDef = null;
	protected IBusModelJavaFXDateTypeFactory factoryDateType = null;
	protected IBusModelJavaFXDbKeyHash128ColFactory factoryDbKeyHash128Col = null;
	protected IBusModelJavaFXDbKeyHash128DefFactory factoryDbKeyHash128Def = null;
	protected IBusModelJavaFXDbKeyHash128GenFactory factoryDbKeyHash128Gen = null;
	protected IBusModelJavaFXDbKeyHash128TypeFactory factoryDbKeyHash128Type = null;
	protected IBusModelJavaFXDbKeyHash160ColFactory factoryDbKeyHash160Col = null;
	protected IBusModelJavaFXDbKeyHash160DefFactory factoryDbKeyHash160Def = null;
	protected IBusModelJavaFXDbKeyHash160GenFactory factoryDbKeyHash160Gen = null;
	protected IBusModelJavaFXDbKeyHash160TypeFactory factoryDbKeyHash160Type = null;
	protected IBusModelJavaFXDbKeyHash224ColFactory factoryDbKeyHash224Col = null;
	protected IBusModelJavaFXDbKeyHash224DefFactory factoryDbKeyHash224Def = null;
	protected IBusModelJavaFXDbKeyHash224GenFactory factoryDbKeyHash224Gen = null;
	protected IBusModelJavaFXDbKeyHash224TypeFactory factoryDbKeyHash224Type = null;
	protected IBusModelJavaFXDbKeyHash256ColFactory factoryDbKeyHash256Col = null;
	protected IBusModelJavaFXDbKeyHash256DefFactory factoryDbKeyHash256Def = null;
	protected IBusModelJavaFXDbKeyHash256GenFactory factoryDbKeyHash256Gen = null;
	protected IBusModelJavaFXDbKeyHash256TypeFactory factoryDbKeyHash256Type = null;
	protected IBusModelJavaFXDbKeyHash384ColFactory factoryDbKeyHash384Col = null;
	protected IBusModelJavaFXDbKeyHash384DefFactory factoryDbKeyHash384Def = null;
	protected IBusModelJavaFXDbKeyHash384GenFactory factoryDbKeyHash384Gen = null;
	protected IBusModelJavaFXDbKeyHash384TypeFactory factoryDbKeyHash384Type = null;
	protected IBusModelJavaFXDbKeyHash512ColFactory factoryDbKeyHash512Col = null;
	protected IBusModelJavaFXDbKeyHash512DefFactory factoryDbKeyHash512Def = null;
	protected IBusModelJavaFXDbKeyHash512GenFactory factoryDbKeyHash512Gen = null;
	protected IBusModelJavaFXDbKeyHash512TypeFactory factoryDbKeyHash512Type = null;
	protected IBusModelJavaFXDelDepFactory factoryDelDep = null;
	protected IBusModelJavaFXDelSubDep1Factory factoryDelSubDep1 = null;
	protected IBusModelJavaFXDelSubDep2Factory factoryDelSubDep2 = null;
	protected IBusModelJavaFXDelSubDep3Factory factoryDelSubDep3 = null;
	protected IBusModelJavaFXDelTopDepFactory factoryDelTopDep = null;
	protected IBusModelJavaFXDoubleColFactory factoryDoubleCol = null;
	protected IBusModelJavaFXDoubleDefFactory factoryDoubleDef = null;
	protected IBusModelJavaFXDoubleTypeFactory factoryDoubleType = null;
	protected IBusModelJavaFXEnumDefFactory factoryEnumDef = null;
	protected IBusModelJavaFXEnumTagFactory factoryEnumTag = null;
	protected IBusModelJavaFXEnumTypeFactory factoryEnumType = null;
	protected IBusModelJavaFXFloatColFactory factoryFloatCol = null;
	protected IBusModelJavaFXFloatDefFactory factoryFloatDef = null;
	protected IBusModelJavaFXFloatTypeFactory factoryFloatType = null;
	protected ISecureJavaFXISOCcyFactory factoryISOCcy = null;
	protected ISecureJavaFXISOCtryFactory factoryISOCtry = null;
	protected ISecureJavaFXISOCtryCcyFactory factoryISOCtryCcy = null;
	protected ISecureJavaFXISOCtryLangFactory factoryISOCtryLang = null;
	protected ISecureJavaFXISOLangFactory factoryISOLang = null;
	protected ISecureJavaFXISOTZoneFactory factoryISOTZone = null;
	protected IBusModelJavaFXId16GenFactory factoryId16Gen = null;
	protected IBusModelJavaFXId32GenFactory factoryId32Gen = null;
	protected IBusModelJavaFXId64GenFactory factoryId64Gen = null;
	protected IBusModelJavaFXIndexFactory factoryIndex = null;
	protected IBusModelJavaFXIndexColFactory factoryIndexCol = null;
	protected IBusModelJavaFXIndexTweakFactory factoryIndexTweak = null;
	protected IBusModelJavaFXInt16ColFactory factoryInt16Col = null;
	protected IBusModelJavaFXInt16DefFactory factoryInt16Def = null;
	protected IBusModelJavaFXInt16TypeFactory factoryInt16Type = null;
	protected IBusModelJavaFXInt32ColFactory factoryInt32Col = null;
	protected IBusModelJavaFXInt32DefFactory factoryInt32Def = null;
	protected IBusModelJavaFXInt32TypeFactory factoryInt32Type = null;
	protected IBusModelJavaFXInt64ColFactory factoryInt64Col = null;
	protected IBusModelJavaFXInt64DefFactory factoryInt64Def = null;
	protected IBusModelJavaFXInt64TypeFactory factoryInt64Type = null;
	protected IIntNetJavaFXLicenseFactory factoryLicense = null;
	protected IIntNetJavaFXMajorVersionFactory factoryMajorVersion = null;
	protected IIntNetJavaFXMimeTypeFactory factoryMimeType = null;
	protected IIntNetJavaFXMinorVersionFactory factoryMinorVersion = null;
	protected IBusModelJavaFXNmTokenColFactory factoryNmTokenCol = null;
	protected IBusModelJavaFXNmTokenDefFactory factoryNmTokenDef = null;
	protected IBusModelJavaFXNmTokenTypeFactory factoryNmTokenType = null;
	protected IBusModelJavaFXNmTokensColFactory factoryNmTokensCol = null;
	protected IBusModelJavaFXNmTokensDefFactory factoryNmTokensDef = null;
	protected IBusModelJavaFXNmTokensTypeFactory factoryNmTokensType = null;
	protected IBusModelJavaFXNumberColFactory factoryNumberCol = null;
	protected IBusModelJavaFXNumberDefFactory factoryNumberDef = null;
	protected IBusModelJavaFXNumberTypeFactory factoryNumberType = null;
	protected IBusModelJavaFXParamFactory factoryParam = null;
	protected IBusModelJavaFXPopDepFactory factoryPopDep = null;
	protected IBusModelJavaFXPopSubDep1Factory factoryPopSubDep1 = null;
	protected IBusModelJavaFXPopSubDep2Factory factoryPopSubDep2 = null;
	protected IBusModelJavaFXPopSubDep3Factory factoryPopSubDep3 = null;
	protected IBusModelJavaFXPopTopDepFactory factoryPopTopDep = null;
	protected IBusModelJavaFXRelationFactory factoryRelation = null;
	protected IBusModelJavaFXRelationColFactory factoryRelationCol = null;
	protected IBusModelJavaFXRoleDefFactory factoryRoleDef = null;
	protected IBusModelJavaFXSchemaDefFactory factorySchemaDef = null;
	protected IBusModelJavaFXSchemaRefFactory factorySchemaRef = null;
	protected IBusModelJavaFXSchemaRoleFactory factorySchemaRole = null;
	protected IBusModelJavaFXSchemaTweakFactory factorySchemaTweak = null;
	protected IBusModelJavaFXScopeFactory factoryScope = null;
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
	protected IBusModelJavaFXServerListFuncFactory factoryServerListFunc = null;
	protected IBusModelJavaFXServerMethodFactory factoryServerMethod = null;
	protected IBusModelJavaFXServerObjFuncFactory factoryServerObjFunc = null;
	protected IBusModelJavaFXServerProcFactory factoryServerProc = null;
	protected IBusModelJavaFXStringColFactory factoryStringCol = null;
	protected IBusModelJavaFXStringDefFactory factoryStringDef = null;
	protected IBusModelJavaFXStringTypeFactory factoryStringType = null;
	protected IIntNetJavaFXSubProjectFactory factorySubProject = null;
	protected ISecureJavaFXSysClusterFactory factorySysCluster = null;
	protected IBusModelJavaFXTZDateColFactory factoryTZDateCol = null;
	protected IBusModelJavaFXTZDateDefFactory factoryTZDateDef = null;
	protected IBusModelJavaFXTZDateTypeFactory factoryTZDateType = null;
	protected IBusModelJavaFXTZTimeColFactory factoryTZTimeCol = null;
	protected IBusModelJavaFXTZTimeDefFactory factoryTZTimeDef = null;
	protected IBusModelJavaFXTZTimeTypeFactory factoryTZTimeType = null;
	protected IBusModelJavaFXTZTimestampColFactory factoryTZTimestampCol = null;
	protected IBusModelJavaFXTZTimestampDefFactory factoryTZTimestampDef = null;
	protected IBusModelJavaFXTZTimestampTypeFactory factoryTZTimestampType = null;
	protected IBusModelJavaFXTableFactory factoryTable = null;
	protected IBusModelJavaFXTableColFactory factoryTableCol = null;
	protected ISecureJavaFXTableInfoFactory factoryTableInfo = null;
	protected IBusModelJavaFXTableTweakFactory factoryTableTweak = null;
	protected ISecureJavaFXTenantFactory factoryTenant = null;
	protected IBusModelJavaFXTextColFactory factoryTextCol = null;
	protected IBusModelJavaFXTextDefFactory factoryTextDef = null;
	protected IBusModelJavaFXTextTypeFactory factoryTextType = null;
	protected IBusModelJavaFXTimeColFactory factoryTimeCol = null;
	protected IBusModelJavaFXTimeDefFactory factoryTimeDef = null;
	protected IBusModelJavaFXTimeTypeFactory factoryTimeType = null;
	protected IBusModelJavaFXTimestampColFactory factoryTimestampCol = null;
	protected IBusModelJavaFXTimestampDefFactory factoryTimestampDef = null;
	protected IBusModelJavaFXTimestampTypeFactory factoryTimestampType = null;
	protected IIntNetJavaFXTldFactory factoryTld = null;
	protected IBusModelJavaFXTokenColFactory factoryTokenCol = null;
	protected IBusModelJavaFXTokenDefFactory factoryTokenDef = null;
	protected IBusModelJavaFXTokenTypeFactory factoryTokenType = null;
	protected IIntNetJavaFXTopDomainFactory factoryTopDomain = null;
	protected IIntNetJavaFXTopProjectFactory factoryTopProject = null;
	protected IBusModelJavaFXTweakFactory factoryTweak = null;
	protected IBusModelJavaFXUInt16ColFactory factoryUInt16Col = null;
	protected IBusModelJavaFXUInt16DefFactory factoryUInt16Def = null;
	protected IBusModelJavaFXUInt16TypeFactory factoryUInt16Type = null;
	protected IBusModelJavaFXUInt32ColFactory factoryUInt32Col = null;
	protected IBusModelJavaFXUInt32DefFactory factoryUInt32Def = null;
	protected IBusModelJavaFXUInt32TypeFactory factoryUInt32Type = null;
	protected IBusModelJavaFXUInt64ColFactory factoryUInt64Col = null;
	protected IBusModelJavaFXUInt64DefFactory factoryUInt64Def = null;
	protected IBusModelJavaFXUInt64TypeFactory factoryUInt64Type = null;
	protected IIntNetJavaFXURLProtocolFactory factoryURLProtocol = null;
	protected IBusModelJavaFXUuid6ColFactory factoryUuid6Col = null;
	protected IBusModelJavaFXUuid6DefFactory factoryUuid6Def = null;
	protected IBusModelJavaFXUuid6GenFactory factoryUuid6Gen = null;
	protected IBusModelJavaFXUuid6TypeFactory factoryUuid6Type = null;
	protected IBusModelJavaFXUuidColFactory factoryUuidCol = null;
	protected IBusModelJavaFXUuidDefFactory factoryUuidDef = null;
	protected IBusModelJavaFXUuidGenFactory factoryUuidGen = null;
	protected IBusModelJavaFXUuidTypeFactory factoryUuidType = null;
	protected IBusModelJavaFXValueFactory factoryValue = null;

	public BusModelJavaFXSchema() {
		BusModelJavaFX.init();
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
		if( ! ( argSchema instanceof IBusModelSchemaObj ) ) {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"argSchema",
				argSchema,
				"IBusModelSchemaObj" );
		}
		schema = (IBusModelSchemaObj)argSchema;
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

	public IBusModelJavaFXAtomFactory getAtomFactory() {
		if( factoryAtom == null ) {
			factoryAtom = new BusModelJavaFXAtomFactory( this );
		}
		return( factoryAtom );
	}

	public IBusModelJavaFXBlobColFactory getBlobColFactory() {
		if( factoryBlobCol == null ) {
			factoryBlobCol = new BusModelJavaFXBlobColFactory( this );
		}
		return( factoryBlobCol );
	}

	public IBusModelJavaFXBlobDefFactory getBlobDefFactory() {
		if( factoryBlobDef == null ) {
			factoryBlobDef = new BusModelJavaFXBlobDefFactory( this );
		}
		return( factoryBlobDef );
	}

	public IBusModelJavaFXBlobTypeFactory getBlobTypeFactory() {
		if( factoryBlobType == null ) {
			factoryBlobType = new BusModelJavaFXBlobTypeFactory( this );
		}
		return( factoryBlobType );
	}

	public IBusModelJavaFXBoolColFactory getBoolColFactory() {
		if( factoryBoolCol == null ) {
			factoryBoolCol = new BusModelJavaFXBoolColFactory( this );
		}
		return( factoryBoolCol );
	}

	public IBusModelJavaFXBoolDefFactory getBoolDefFactory() {
		if( factoryBoolDef == null ) {
			factoryBoolDef = new BusModelJavaFXBoolDefFactory( this );
		}
		return( factoryBoolDef );
	}

	public IBusModelJavaFXBoolTypeFactory getBoolTypeFactory() {
		if( factoryBoolType == null ) {
			factoryBoolType = new BusModelJavaFXBoolTypeFactory( this );
		}
		return( factoryBoolType );
	}

	public IBusModelJavaFXChainFactory getChainFactory() {
		if( factoryChain == null ) {
			factoryChain = new BusModelJavaFXChainFactory( this );
		}
		return( factoryChain );
	}

	public IBusModelJavaFXClearDepFactory getClearDepFactory() {
		if( factoryClearDep == null ) {
			factoryClearDep = new BusModelJavaFXClearDepFactory( this );
		}
		return( factoryClearDep );
	}

	public IBusModelJavaFXClearSubDep1Factory getClearSubDep1Factory() {
		if( factoryClearSubDep1 == null ) {
			factoryClearSubDep1 = new BusModelJavaFXClearSubDep1Factory( this );
		}
		return( factoryClearSubDep1 );
	}

	public IBusModelJavaFXClearSubDep2Factory getClearSubDep2Factory() {
		if( factoryClearSubDep2 == null ) {
			factoryClearSubDep2 = new BusModelJavaFXClearSubDep2Factory( this );
		}
		return( factoryClearSubDep2 );
	}

	public IBusModelJavaFXClearSubDep3Factory getClearSubDep3Factory() {
		if( factoryClearSubDep3 == null ) {
			factoryClearSubDep3 = new BusModelJavaFXClearSubDep3Factory( this );
		}
		return( factoryClearSubDep3 );
	}

	public IBusModelJavaFXClearTopDepFactory getClearTopDepFactory() {
		if( factoryClearTopDep == null ) {
			factoryClearTopDep = new BusModelJavaFXClearTopDepFactory( this );
		}
		return( factoryClearTopDep );
	}

	public ISecureJavaFXClusterFactory getClusterFactory() {
		if( factoryCluster == null ) {
			factoryCluster = new SecureJavaFXClusterFactory( this );
		}
		return( factoryCluster );
	}

	public IBusModelJavaFXDateColFactory getDateColFactory() {
		if( factoryDateCol == null ) {
			factoryDateCol = new BusModelJavaFXDateColFactory( this );
		}
		return( factoryDateCol );
	}

	public IBusModelJavaFXDateDefFactory getDateDefFactory() {
		if( factoryDateDef == null ) {
			factoryDateDef = new BusModelJavaFXDateDefFactory( this );
		}
		return( factoryDateDef );
	}

	public IBusModelJavaFXDateTypeFactory getDateTypeFactory() {
		if( factoryDateType == null ) {
			factoryDateType = new BusModelJavaFXDateTypeFactory( this );
		}
		return( factoryDateType );
	}

	public IBusModelJavaFXDbKeyHash128ColFactory getDbKeyHash128ColFactory() {
		if( factoryDbKeyHash128Col == null ) {
			factoryDbKeyHash128Col = new BusModelJavaFXDbKeyHash128ColFactory( this );
		}
		return( factoryDbKeyHash128Col );
	}

	public IBusModelJavaFXDbKeyHash128DefFactory getDbKeyHash128DefFactory() {
		if( factoryDbKeyHash128Def == null ) {
			factoryDbKeyHash128Def = new BusModelJavaFXDbKeyHash128DefFactory( this );
		}
		return( factoryDbKeyHash128Def );
	}

	public IBusModelJavaFXDbKeyHash128GenFactory getDbKeyHash128GenFactory() {
		if( factoryDbKeyHash128Gen == null ) {
			factoryDbKeyHash128Gen = new BusModelJavaFXDbKeyHash128GenFactory( this );
		}
		return( factoryDbKeyHash128Gen );
	}

	public IBusModelJavaFXDbKeyHash128TypeFactory getDbKeyHash128TypeFactory() {
		if( factoryDbKeyHash128Type == null ) {
			factoryDbKeyHash128Type = new BusModelJavaFXDbKeyHash128TypeFactory( this );
		}
		return( factoryDbKeyHash128Type );
	}

	public IBusModelJavaFXDbKeyHash160ColFactory getDbKeyHash160ColFactory() {
		if( factoryDbKeyHash160Col == null ) {
			factoryDbKeyHash160Col = new BusModelJavaFXDbKeyHash160ColFactory( this );
		}
		return( factoryDbKeyHash160Col );
	}

	public IBusModelJavaFXDbKeyHash160DefFactory getDbKeyHash160DefFactory() {
		if( factoryDbKeyHash160Def == null ) {
			factoryDbKeyHash160Def = new BusModelJavaFXDbKeyHash160DefFactory( this );
		}
		return( factoryDbKeyHash160Def );
	}

	public IBusModelJavaFXDbKeyHash160GenFactory getDbKeyHash160GenFactory() {
		if( factoryDbKeyHash160Gen == null ) {
			factoryDbKeyHash160Gen = new BusModelJavaFXDbKeyHash160GenFactory( this );
		}
		return( factoryDbKeyHash160Gen );
	}

	public IBusModelJavaFXDbKeyHash160TypeFactory getDbKeyHash160TypeFactory() {
		if( factoryDbKeyHash160Type == null ) {
			factoryDbKeyHash160Type = new BusModelJavaFXDbKeyHash160TypeFactory( this );
		}
		return( factoryDbKeyHash160Type );
	}

	public IBusModelJavaFXDbKeyHash224ColFactory getDbKeyHash224ColFactory() {
		if( factoryDbKeyHash224Col == null ) {
			factoryDbKeyHash224Col = new BusModelJavaFXDbKeyHash224ColFactory( this );
		}
		return( factoryDbKeyHash224Col );
	}

	public IBusModelJavaFXDbKeyHash224DefFactory getDbKeyHash224DefFactory() {
		if( factoryDbKeyHash224Def == null ) {
			factoryDbKeyHash224Def = new BusModelJavaFXDbKeyHash224DefFactory( this );
		}
		return( factoryDbKeyHash224Def );
	}

	public IBusModelJavaFXDbKeyHash224GenFactory getDbKeyHash224GenFactory() {
		if( factoryDbKeyHash224Gen == null ) {
			factoryDbKeyHash224Gen = new BusModelJavaFXDbKeyHash224GenFactory( this );
		}
		return( factoryDbKeyHash224Gen );
	}

	public IBusModelJavaFXDbKeyHash224TypeFactory getDbKeyHash224TypeFactory() {
		if( factoryDbKeyHash224Type == null ) {
			factoryDbKeyHash224Type = new BusModelJavaFXDbKeyHash224TypeFactory( this );
		}
		return( factoryDbKeyHash224Type );
	}

	public IBusModelJavaFXDbKeyHash256ColFactory getDbKeyHash256ColFactory() {
		if( factoryDbKeyHash256Col == null ) {
			factoryDbKeyHash256Col = new BusModelJavaFXDbKeyHash256ColFactory( this );
		}
		return( factoryDbKeyHash256Col );
	}

	public IBusModelJavaFXDbKeyHash256DefFactory getDbKeyHash256DefFactory() {
		if( factoryDbKeyHash256Def == null ) {
			factoryDbKeyHash256Def = new BusModelJavaFXDbKeyHash256DefFactory( this );
		}
		return( factoryDbKeyHash256Def );
	}

	public IBusModelJavaFXDbKeyHash256GenFactory getDbKeyHash256GenFactory() {
		if( factoryDbKeyHash256Gen == null ) {
			factoryDbKeyHash256Gen = new BusModelJavaFXDbKeyHash256GenFactory( this );
		}
		return( factoryDbKeyHash256Gen );
	}

	public IBusModelJavaFXDbKeyHash256TypeFactory getDbKeyHash256TypeFactory() {
		if( factoryDbKeyHash256Type == null ) {
			factoryDbKeyHash256Type = new BusModelJavaFXDbKeyHash256TypeFactory( this );
		}
		return( factoryDbKeyHash256Type );
	}

	public IBusModelJavaFXDbKeyHash384ColFactory getDbKeyHash384ColFactory() {
		if( factoryDbKeyHash384Col == null ) {
			factoryDbKeyHash384Col = new BusModelJavaFXDbKeyHash384ColFactory( this );
		}
		return( factoryDbKeyHash384Col );
	}

	public IBusModelJavaFXDbKeyHash384DefFactory getDbKeyHash384DefFactory() {
		if( factoryDbKeyHash384Def == null ) {
			factoryDbKeyHash384Def = new BusModelJavaFXDbKeyHash384DefFactory( this );
		}
		return( factoryDbKeyHash384Def );
	}

	public IBusModelJavaFXDbKeyHash384GenFactory getDbKeyHash384GenFactory() {
		if( factoryDbKeyHash384Gen == null ) {
			factoryDbKeyHash384Gen = new BusModelJavaFXDbKeyHash384GenFactory( this );
		}
		return( factoryDbKeyHash384Gen );
	}

	public IBusModelJavaFXDbKeyHash384TypeFactory getDbKeyHash384TypeFactory() {
		if( factoryDbKeyHash384Type == null ) {
			factoryDbKeyHash384Type = new BusModelJavaFXDbKeyHash384TypeFactory( this );
		}
		return( factoryDbKeyHash384Type );
	}

	public IBusModelJavaFXDbKeyHash512ColFactory getDbKeyHash512ColFactory() {
		if( factoryDbKeyHash512Col == null ) {
			factoryDbKeyHash512Col = new BusModelJavaFXDbKeyHash512ColFactory( this );
		}
		return( factoryDbKeyHash512Col );
	}

	public IBusModelJavaFXDbKeyHash512DefFactory getDbKeyHash512DefFactory() {
		if( factoryDbKeyHash512Def == null ) {
			factoryDbKeyHash512Def = new BusModelJavaFXDbKeyHash512DefFactory( this );
		}
		return( factoryDbKeyHash512Def );
	}

	public IBusModelJavaFXDbKeyHash512GenFactory getDbKeyHash512GenFactory() {
		if( factoryDbKeyHash512Gen == null ) {
			factoryDbKeyHash512Gen = new BusModelJavaFXDbKeyHash512GenFactory( this );
		}
		return( factoryDbKeyHash512Gen );
	}

	public IBusModelJavaFXDbKeyHash512TypeFactory getDbKeyHash512TypeFactory() {
		if( factoryDbKeyHash512Type == null ) {
			factoryDbKeyHash512Type = new BusModelJavaFXDbKeyHash512TypeFactory( this );
		}
		return( factoryDbKeyHash512Type );
	}

	public IBusModelJavaFXDelDepFactory getDelDepFactory() {
		if( factoryDelDep == null ) {
			factoryDelDep = new BusModelJavaFXDelDepFactory( this );
		}
		return( factoryDelDep );
	}

	public IBusModelJavaFXDelSubDep1Factory getDelSubDep1Factory() {
		if( factoryDelSubDep1 == null ) {
			factoryDelSubDep1 = new BusModelJavaFXDelSubDep1Factory( this );
		}
		return( factoryDelSubDep1 );
	}

	public IBusModelJavaFXDelSubDep2Factory getDelSubDep2Factory() {
		if( factoryDelSubDep2 == null ) {
			factoryDelSubDep2 = new BusModelJavaFXDelSubDep2Factory( this );
		}
		return( factoryDelSubDep2 );
	}

	public IBusModelJavaFXDelSubDep3Factory getDelSubDep3Factory() {
		if( factoryDelSubDep3 == null ) {
			factoryDelSubDep3 = new BusModelJavaFXDelSubDep3Factory( this );
		}
		return( factoryDelSubDep3 );
	}

	public IBusModelJavaFXDelTopDepFactory getDelTopDepFactory() {
		if( factoryDelTopDep == null ) {
			factoryDelTopDep = new BusModelJavaFXDelTopDepFactory( this );
		}
		return( factoryDelTopDep );
	}

	public IBusModelJavaFXDoubleColFactory getDoubleColFactory() {
		if( factoryDoubleCol == null ) {
			factoryDoubleCol = new BusModelJavaFXDoubleColFactory( this );
		}
		return( factoryDoubleCol );
	}

	public IBusModelJavaFXDoubleDefFactory getDoubleDefFactory() {
		if( factoryDoubleDef == null ) {
			factoryDoubleDef = new BusModelJavaFXDoubleDefFactory( this );
		}
		return( factoryDoubleDef );
	}

	public IBusModelJavaFXDoubleTypeFactory getDoubleTypeFactory() {
		if( factoryDoubleType == null ) {
			factoryDoubleType = new BusModelJavaFXDoubleTypeFactory( this );
		}
		return( factoryDoubleType );
	}

	public IBusModelJavaFXEnumDefFactory getEnumDefFactory() {
		if( factoryEnumDef == null ) {
			factoryEnumDef = new BusModelJavaFXEnumDefFactory( this );
		}
		return( factoryEnumDef );
	}

	public IBusModelJavaFXEnumTagFactory getEnumTagFactory() {
		if( factoryEnumTag == null ) {
			factoryEnumTag = new BusModelJavaFXEnumTagFactory( this );
		}
		return( factoryEnumTag );
	}

	public IBusModelJavaFXEnumTypeFactory getEnumTypeFactory() {
		if( factoryEnumType == null ) {
			factoryEnumType = new BusModelJavaFXEnumTypeFactory( this );
		}
		return( factoryEnumType );
	}

	public IBusModelJavaFXFloatColFactory getFloatColFactory() {
		if( factoryFloatCol == null ) {
			factoryFloatCol = new BusModelJavaFXFloatColFactory( this );
		}
		return( factoryFloatCol );
	}

	public IBusModelJavaFXFloatDefFactory getFloatDefFactory() {
		if( factoryFloatDef == null ) {
			factoryFloatDef = new BusModelJavaFXFloatDefFactory( this );
		}
		return( factoryFloatDef );
	}

	public IBusModelJavaFXFloatTypeFactory getFloatTypeFactory() {
		if( factoryFloatType == null ) {
			factoryFloatType = new BusModelJavaFXFloatTypeFactory( this );
		}
		return( factoryFloatType );
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

	public IBusModelJavaFXId16GenFactory getId16GenFactory() {
		if( factoryId16Gen == null ) {
			factoryId16Gen = new BusModelJavaFXId16GenFactory( this );
		}
		return( factoryId16Gen );
	}

	public IBusModelJavaFXId32GenFactory getId32GenFactory() {
		if( factoryId32Gen == null ) {
			factoryId32Gen = new BusModelJavaFXId32GenFactory( this );
		}
		return( factoryId32Gen );
	}

	public IBusModelJavaFXId64GenFactory getId64GenFactory() {
		if( factoryId64Gen == null ) {
			factoryId64Gen = new BusModelJavaFXId64GenFactory( this );
		}
		return( factoryId64Gen );
	}

	public IBusModelJavaFXIndexFactory getIndexFactory() {
		if( factoryIndex == null ) {
			factoryIndex = new BusModelJavaFXIndexFactory( this );
		}
		return( factoryIndex );
	}

	public IBusModelJavaFXIndexColFactory getIndexColFactory() {
		if( factoryIndexCol == null ) {
			factoryIndexCol = new BusModelJavaFXIndexColFactory( this );
		}
		return( factoryIndexCol );
	}

	public IBusModelJavaFXIndexTweakFactory getIndexTweakFactory() {
		if( factoryIndexTweak == null ) {
			factoryIndexTweak = new BusModelJavaFXIndexTweakFactory( this );
		}
		return( factoryIndexTweak );
	}

	public IBusModelJavaFXInt16ColFactory getInt16ColFactory() {
		if( factoryInt16Col == null ) {
			factoryInt16Col = new BusModelJavaFXInt16ColFactory( this );
		}
		return( factoryInt16Col );
	}

	public IBusModelJavaFXInt16DefFactory getInt16DefFactory() {
		if( factoryInt16Def == null ) {
			factoryInt16Def = new BusModelJavaFXInt16DefFactory( this );
		}
		return( factoryInt16Def );
	}

	public IBusModelJavaFXInt16TypeFactory getInt16TypeFactory() {
		if( factoryInt16Type == null ) {
			factoryInt16Type = new BusModelJavaFXInt16TypeFactory( this );
		}
		return( factoryInt16Type );
	}

	public IBusModelJavaFXInt32ColFactory getInt32ColFactory() {
		if( factoryInt32Col == null ) {
			factoryInt32Col = new BusModelJavaFXInt32ColFactory( this );
		}
		return( factoryInt32Col );
	}

	public IBusModelJavaFXInt32DefFactory getInt32DefFactory() {
		if( factoryInt32Def == null ) {
			factoryInt32Def = new BusModelJavaFXInt32DefFactory( this );
		}
		return( factoryInt32Def );
	}

	public IBusModelJavaFXInt32TypeFactory getInt32TypeFactory() {
		if( factoryInt32Type == null ) {
			factoryInt32Type = new BusModelJavaFXInt32TypeFactory( this );
		}
		return( factoryInt32Type );
	}

	public IBusModelJavaFXInt64ColFactory getInt64ColFactory() {
		if( factoryInt64Col == null ) {
			factoryInt64Col = new BusModelJavaFXInt64ColFactory( this );
		}
		return( factoryInt64Col );
	}

	public IBusModelJavaFXInt64DefFactory getInt64DefFactory() {
		if( factoryInt64Def == null ) {
			factoryInt64Def = new BusModelJavaFXInt64DefFactory( this );
		}
		return( factoryInt64Def );
	}

	public IBusModelJavaFXInt64TypeFactory getInt64TypeFactory() {
		if( factoryInt64Type == null ) {
			factoryInt64Type = new BusModelJavaFXInt64TypeFactory( this );
		}
		return( factoryInt64Type );
	}

	public IIntNetJavaFXLicenseFactory getLicenseFactory() {
		if( factoryLicense == null ) {
			factoryLicense = new IntNetJavaFXLicenseFactory( this );
		}
		return( factoryLicense );
	}

	public IIntNetJavaFXMajorVersionFactory getMajorVersionFactory() {
		if( factoryMajorVersion == null ) {
			factoryMajorVersion = new IntNetJavaFXMajorVersionFactory( this );
		}
		return( factoryMajorVersion );
	}

	public IIntNetJavaFXMimeTypeFactory getMimeTypeFactory() {
		if( factoryMimeType == null ) {
			factoryMimeType = new IntNetJavaFXMimeTypeFactory( this );
		}
		return( factoryMimeType );
	}

	public IIntNetJavaFXMinorVersionFactory getMinorVersionFactory() {
		if( factoryMinorVersion == null ) {
			factoryMinorVersion = new IntNetJavaFXMinorVersionFactory( this );
		}
		return( factoryMinorVersion );
	}

	public IBusModelJavaFXNmTokenColFactory getNmTokenColFactory() {
		if( factoryNmTokenCol == null ) {
			factoryNmTokenCol = new BusModelJavaFXNmTokenColFactory( this );
		}
		return( factoryNmTokenCol );
	}

	public IBusModelJavaFXNmTokenDefFactory getNmTokenDefFactory() {
		if( factoryNmTokenDef == null ) {
			factoryNmTokenDef = new BusModelJavaFXNmTokenDefFactory( this );
		}
		return( factoryNmTokenDef );
	}

	public IBusModelJavaFXNmTokenTypeFactory getNmTokenTypeFactory() {
		if( factoryNmTokenType == null ) {
			factoryNmTokenType = new BusModelJavaFXNmTokenTypeFactory( this );
		}
		return( factoryNmTokenType );
	}

	public IBusModelJavaFXNmTokensColFactory getNmTokensColFactory() {
		if( factoryNmTokensCol == null ) {
			factoryNmTokensCol = new BusModelJavaFXNmTokensColFactory( this );
		}
		return( factoryNmTokensCol );
	}

	public IBusModelJavaFXNmTokensDefFactory getNmTokensDefFactory() {
		if( factoryNmTokensDef == null ) {
			factoryNmTokensDef = new BusModelJavaFXNmTokensDefFactory( this );
		}
		return( factoryNmTokensDef );
	}

	public IBusModelJavaFXNmTokensTypeFactory getNmTokensTypeFactory() {
		if( factoryNmTokensType == null ) {
			factoryNmTokensType = new BusModelJavaFXNmTokensTypeFactory( this );
		}
		return( factoryNmTokensType );
	}

	public IBusModelJavaFXNumberColFactory getNumberColFactory() {
		if( factoryNumberCol == null ) {
			factoryNumberCol = new BusModelJavaFXNumberColFactory( this );
		}
		return( factoryNumberCol );
	}

	public IBusModelJavaFXNumberDefFactory getNumberDefFactory() {
		if( factoryNumberDef == null ) {
			factoryNumberDef = new BusModelJavaFXNumberDefFactory( this );
		}
		return( factoryNumberDef );
	}

	public IBusModelJavaFXNumberTypeFactory getNumberTypeFactory() {
		if( factoryNumberType == null ) {
			factoryNumberType = new BusModelJavaFXNumberTypeFactory( this );
		}
		return( factoryNumberType );
	}

	public IBusModelJavaFXParamFactory getParamFactory() {
		if( factoryParam == null ) {
			factoryParam = new BusModelJavaFXParamFactory( this );
		}
		return( factoryParam );
	}

	public IBusModelJavaFXPopDepFactory getPopDepFactory() {
		if( factoryPopDep == null ) {
			factoryPopDep = new BusModelJavaFXPopDepFactory( this );
		}
		return( factoryPopDep );
	}

	public IBusModelJavaFXPopSubDep1Factory getPopSubDep1Factory() {
		if( factoryPopSubDep1 == null ) {
			factoryPopSubDep1 = new BusModelJavaFXPopSubDep1Factory( this );
		}
		return( factoryPopSubDep1 );
	}

	public IBusModelJavaFXPopSubDep2Factory getPopSubDep2Factory() {
		if( factoryPopSubDep2 == null ) {
			factoryPopSubDep2 = new BusModelJavaFXPopSubDep2Factory( this );
		}
		return( factoryPopSubDep2 );
	}

	public IBusModelJavaFXPopSubDep3Factory getPopSubDep3Factory() {
		if( factoryPopSubDep3 == null ) {
			factoryPopSubDep3 = new BusModelJavaFXPopSubDep3Factory( this );
		}
		return( factoryPopSubDep3 );
	}

	public IBusModelJavaFXPopTopDepFactory getPopTopDepFactory() {
		if( factoryPopTopDep == null ) {
			factoryPopTopDep = new BusModelJavaFXPopTopDepFactory( this );
		}
		return( factoryPopTopDep );
	}

	public IBusModelJavaFXRelationFactory getRelationFactory() {
		if( factoryRelation == null ) {
			factoryRelation = new BusModelJavaFXRelationFactory( this );
		}
		return( factoryRelation );
	}

	public IBusModelJavaFXRelationColFactory getRelationColFactory() {
		if( factoryRelationCol == null ) {
			factoryRelationCol = new BusModelJavaFXRelationColFactory( this );
		}
		return( factoryRelationCol );
	}

	public IBusModelJavaFXRoleDefFactory getRoleDefFactory() {
		if( factoryRoleDef == null ) {
			factoryRoleDef = new BusModelJavaFXRoleDefFactory( this );
		}
		return( factoryRoleDef );
	}

	public IBusModelJavaFXSchemaDefFactory getSchemaDefFactory() {
		if( factorySchemaDef == null ) {
			factorySchemaDef = new BusModelJavaFXSchemaDefFactory( this );
		}
		return( factorySchemaDef );
	}

	public IBusModelJavaFXSchemaRefFactory getSchemaRefFactory() {
		if( factorySchemaRef == null ) {
			factorySchemaRef = new BusModelJavaFXSchemaRefFactory( this );
		}
		return( factorySchemaRef );
	}

	public IBusModelJavaFXSchemaRoleFactory getSchemaRoleFactory() {
		if( factorySchemaRole == null ) {
			factorySchemaRole = new BusModelJavaFXSchemaRoleFactory( this );
		}
		return( factorySchemaRole );
	}

	public IBusModelJavaFXSchemaTweakFactory getSchemaTweakFactory() {
		if( factorySchemaTweak == null ) {
			factorySchemaTweak = new BusModelJavaFXSchemaTweakFactory( this );
		}
		return( factorySchemaTweak );
	}

	public IBusModelJavaFXScopeFactory getScopeFactory() {
		if( factoryScope == null ) {
			factoryScope = new BusModelJavaFXScopeFactory( this );
		}
		return( factoryScope );
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

	public IBusModelJavaFXServerListFuncFactory getServerListFuncFactory() {
		if( factoryServerListFunc == null ) {
			factoryServerListFunc = new BusModelJavaFXServerListFuncFactory( this );
		}
		return( factoryServerListFunc );
	}

	public IBusModelJavaFXServerMethodFactory getServerMethodFactory() {
		if( factoryServerMethod == null ) {
			factoryServerMethod = new BusModelJavaFXServerMethodFactory( this );
		}
		return( factoryServerMethod );
	}

	public IBusModelJavaFXServerObjFuncFactory getServerObjFuncFactory() {
		if( factoryServerObjFunc == null ) {
			factoryServerObjFunc = new BusModelJavaFXServerObjFuncFactory( this );
		}
		return( factoryServerObjFunc );
	}

	public IBusModelJavaFXServerProcFactory getServerProcFactory() {
		if( factoryServerProc == null ) {
			factoryServerProc = new BusModelJavaFXServerProcFactory( this );
		}
		return( factoryServerProc );
	}

	public IBusModelJavaFXStringColFactory getStringColFactory() {
		if( factoryStringCol == null ) {
			factoryStringCol = new BusModelJavaFXStringColFactory( this );
		}
		return( factoryStringCol );
	}

	public IBusModelJavaFXStringDefFactory getStringDefFactory() {
		if( factoryStringDef == null ) {
			factoryStringDef = new BusModelJavaFXStringDefFactory( this );
		}
		return( factoryStringDef );
	}

	public IBusModelJavaFXStringTypeFactory getStringTypeFactory() {
		if( factoryStringType == null ) {
			factoryStringType = new BusModelJavaFXStringTypeFactory( this );
		}
		return( factoryStringType );
	}

	public IIntNetJavaFXSubProjectFactory getSubProjectFactory() {
		if( factorySubProject == null ) {
			factorySubProject = new IntNetJavaFXSubProjectFactory( this );
		}
		return( factorySubProject );
	}

	public ISecureJavaFXSysClusterFactory getSysClusterFactory() {
		if( factorySysCluster == null ) {
			factorySysCluster = new SecureJavaFXSysClusterFactory( this );
		}
		return( factorySysCluster );
	}

	public IBusModelJavaFXTZDateColFactory getTZDateColFactory() {
		if( factoryTZDateCol == null ) {
			factoryTZDateCol = new BusModelJavaFXTZDateColFactory( this );
		}
		return( factoryTZDateCol );
	}

	public IBusModelJavaFXTZDateDefFactory getTZDateDefFactory() {
		if( factoryTZDateDef == null ) {
			factoryTZDateDef = new BusModelJavaFXTZDateDefFactory( this );
		}
		return( factoryTZDateDef );
	}

	public IBusModelJavaFXTZDateTypeFactory getTZDateTypeFactory() {
		if( factoryTZDateType == null ) {
			factoryTZDateType = new BusModelJavaFXTZDateTypeFactory( this );
		}
		return( factoryTZDateType );
	}

	public IBusModelJavaFXTZTimeColFactory getTZTimeColFactory() {
		if( factoryTZTimeCol == null ) {
			factoryTZTimeCol = new BusModelJavaFXTZTimeColFactory( this );
		}
		return( factoryTZTimeCol );
	}

	public IBusModelJavaFXTZTimeDefFactory getTZTimeDefFactory() {
		if( factoryTZTimeDef == null ) {
			factoryTZTimeDef = new BusModelJavaFXTZTimeDefFactory( this );
		}
		return( factoryTZTimeDef );
	}

	public IBusModelJavaFXTZTimeTypeFactory getTZTimeTypeFactory() {
		if( factoryTZTimeType == null ) {
			factoryTZTimeType = new BusModelJavaFXTZTimeTypeFactory( this );
		}
		return( factoryTZTimeType );
	}

	public IBusModelJavaFXTZTimestampColFactory getTZTimestampColFactory() {
		if( factoryTZTimestampCol == null ) {
			factoryTZTimestampCol = new BusModelJavaFXTZTimestampColFactory( this );
		}
		return( factoryTZTimestampCol );
	}

	public IBusModelJavaFXTZTimestampDefFactory getTZTimestampDefFactory() {
		if( factoryTZTimestampDef == null ) {
			factoryTZTimestampDef = new BusModelJavaFXTZTimestampDefFactory( this );
		}
		return( factoryTZTimestampDef );
	}

	public IBusModelJavaFXTZTimestampTypeFactory getTZTimestampTypeFactory() {
		if( factoryTZTimestampType == null ) {
			factoryTZTimestampType = new BusModelJavaFXTZTimestampTypeFactory( this );
		}
		return( factoryTZTimestampType );
	}

	public IBusModelJavaFXTableFactory getTableFactory() {
		if( factoryTable == null ) {
			factoryTable = new BusModelJavaFXTableFactory( this );
		}
		return( factoryTable );
	}

	public IBusModelJavaFXTableColFactory getTableColFactory() {
		if( factoryTableCol == null ) {
			factoryTableCol = new BusModelJavaFXTableColFactory( this );
		}
		return( factoryTableCol );
	}

	public ISecureJavaFXTableInfoFactory getTableInfoFactory() {
		if( factoryTableInfo == null ) {
			factoryTableInfo = new SecureJavaFXTableInfoFactory( this );
		}
		return( factoryTableInfo );
	}

	public IBusModelJavaFXTableTweakFactory getTableTweakFactory() {
		if( factoryTableTweak == null ) {
			factoryTableTweak = new BusModelJavaFXTableTweakFactory( this );
		}
		return( factoryTableTweak );
	}

	public ISecureJavaFXTenantFactory getTenantFactory() {
		if( factoryTenant == null ) {
			factoryTenant = new SecureJavaFXTenantFactory( this );
		}
		return( factoryTenant );
	}

	public IBusModelJavaFXTextColFactory getTextColFactory() {
		if( factoryTextCol == null ) {
			factoryTextCol = new BusModelJavaFXTextColFactory( this );
		}
		return( factoryTextCol );
	}

	public IBusModelJavaFXTextDefFactory getTextDefFactory() {
		if( factoryTextDef == null ) {
			factoryTextDef = new BusModelJavaFXTextDefFactory( this );
		}
		return( factoryTextDef );
	}

	public IBusModelJavaFXTextTypeFactory getTextTypeFactory() {
		if( factoryTextType == null ) {
			factoryTextType = new BusModelJavaFXTextTypeFactory( this );
		}
		return( factoryTextType );
	}

	public IBusModelJavaFXTimeColFactory getTimeColFactory() {
		if( factoryTimeCol == null ) {
			factoryTimeCol = new BusModelJavaFXTimeColFactory( this );
		}
		return( factoryTimeCol );
	}

	public IBusModelJavaFXTimeDefFactory getTimeDefFactory() {
		if( factoryTimeDef == null ) {
			factoryTimeDef = new BusModelJavaFXTimeDefFactory( this );
		}
		return( factoryTimeDef );
	}

	public IBusModelJavaFXTimeTypeFactory getTimeTypeFactory() {
		if( factoryTimeType == null ) {
			factoryTimeType = new BusModelJavaFXTimeTypeFactory( this );
		}
		return( factoryTimeType );
	}

	public IBusModelJavaFXTimestampColFactory getTimestampColFactory() {
		if( factoryTimestampCol == null ) {
			factoryTimestampCol = new BusModelJavaFXTimestampColFactory( this );
		}
		return( factoryTimestampCol );
	}

	public IBusModelJavaFXTimestampDefFactory getTimestampDefFactory() {
		if( factoryTimestampDef == null ) {
			factoryTimestampDef = new BusModelJavaFXTimestampDefFactory( this );
		}
		return( factoryTimestampDef );
	}

	public IBusModelJavaFXTimestampTypeFactory getTimestampTypeFactory() {
		if( factoryTimestampType == null ) {
			factoryTimestampType = new BusModelJavaFXTimestampTypeFactory( this );
		}
		return( factoryTimestampType );
	}

	public IIntNetJavaFXTldFactory getTldFactory() {
		if( factoryTld == null ) {
			factoryTld = new IntNetJavaFXTldFactory( this );
		}
		return( factoryTld );
	}

	public IBusModelJavaFXTokenColFactory getTokenColFactory() {
		if( factoryTokenCol == null ) {
			factoryTokenCol = new BusModelJavaFXTokenColFactory( this );
		}
		return( factoryTokenCol );
	}

	public IBusModelJavaFXTokenDefFactory getTokenDefFactory() {
		if( factoryTokenDef == null ) {
			factoryTokenDef = new BusModelJavaFXTokenDefFactory( this );
		}
		return( factoryTokenDef );
	}

	public IBusModelJavaFXTokenTypeFactory getTokenTypeFactory() {
		if( factoryTokenType == null ) {
			factoryTokenType = new BusModelJavaFXTokenTypeFactory( this );
		}
		return( factoryTokenType );
	}

	public IIntNetJavaFXTopDomainFactory getTopDomainFactory() {
		if( factoryTopDomain == null ) {
			factoryTopDomain = new IntNetJavaFXTopDomainFactory( this );
		}
		return( factoryTopDomain );
	}

	public IIntNetJavaFXTopProjectFactory getTopProjectFactory() {
		if( factoryTopProject == null ) {
			factoryTopProject = new IntNetJavaFXTopProjectFactory( this );
		}
		return( factoryTopProject );
	}

	public IBusModelJavaFXTweakFactory getTweakFactory() {
		if( factoryTweak == null ) {
			factoryTweak = new BusModelJavaFXTweakFactory( this );
		}
		return( factoryTweak );
	}

	public IBusModelJavaFXUInt16ColFactory getUInt16ColFactory() {
		if( factoryUInt16Col == null ) {
			factoryUInt16Col = new BusModelJavaFXUInt16ColFactory( this );
		}
		return( factoryUInt16Col );
	}

	public IBusModelJavaFXUInt16DefFactory getUInt16DefFactory() {
		if( factoryUInt16Def == null ) {
			factoryUInt16Def = new BusModelJavaFXUInt16DefFactory( this );
		}
		return( factoryUInt16Def );
	}

	public IBusModelJavaFXUInt16TypeFactory getUInt16TypeFactory() {
		if( factoryUInt16Type == null ) {
			factoryUInt16Type = new BusModelJavaFXUInt16TypeFactory( this );
		}
		return( factoryUInt16Type );
	}

	public IBusModelJavaFXUInt32ColFactory getUInt32ColFactory() {
		if( factoryUInt32Col == null ) {
			factoryUInt32Col = new BusModelJavaFXUInt32ColFactory( this );
		}
		return( factoryUInt32Col );
	}

	public IBusModelJavaFXUInt32DefFactory getUInt32DefFactory() {
		if( factoryUInt32Def == null ) {
			factoryUInt32Def = new BusModelJavaFXUInt32DefFactory( this );
		}
		return( factoryUInt32Def );
	}

	public IBusModelJavaFXUInt32TypeFactory getUInt32TypeFactory() {
		if( factoryUInt32Type == null ) {
			factoryUInt32Type = new BusModelJavaFXUInt32TypeFactory( this );
		}
		return( factoryUInt32Type );
	}

	public IBusModelJavaFXUInt64ColFactory getUInt64ColFactory() {
		if( factoryUInt64Col == null ) {
			factoryUInt64Col = new BusModelJavaFXUInt64ColFactory( this );
		}
		return( factoryUInt64Col );
	}

	public IBusModelJavaFXUInt64DefFactory getUInt64DefFactory() {
		if( factoryUInt64Def == null ) {
			factoryUInt64Def = new BusModelJavaFXUInt64DefFactory( this );
		}
		return( factoryUInt64Def );
	}

	public IBusModelJavaFXUInt64TypeFactory getUInt64TypeFactory() {
		if( factoryUInt64Type == null ) {
			factoryUInt64Type = new BusModelJavaFXUInt64TypeFactory( this );
		}
		return( factoryUInt64Type );
	}

	public IIntNetJavaFXURLProtocolFactory getURLProtocolFactory() {
		if( factoryURLProtocol == null ) {
			factoryURLProtocol = new IntNetJavaFXURLProtocolFactory( this );
		}
		return( factoryURLProtocol );
	}

	public IBusModelJavaFXUuid6ColFactory getUuid6ColFactory() {
		if( factoryUuid6Col == null ) {
			factoryUuid6Col = new BusModelJavaFXUuid6ColFactory( this );
		}
		return( factoryUuid6Col );
	}

	public IBusModelJavaFXUuid6DefFactory getUuid6DefFactory() {
		if( factoryUuid6Def == null ) {
			factoryUuid6Def = new BusModelJavaFXUuid6DefFactory( this );
		}
		return( factoryUuid6Def );
	}

	public IBusModelJavaFXUuid6GenFactory getUuid6GenFactory() {
		if( factoryUuid6Gen == null ) {
			factoryUuid6Gen = new BusModelJavaFXUuid6GenFactory( this );
		}
		return( factoryUuid6Gen );
	}

	public IBusModelJavaFXUuid6TypeFactory getUuid6TypeFactory() {
		if( factoryUuid6Type == null ) {
			factoryUuid6Type = new BusModelJavaFXUuid6TypeFactory( this );
		}
		return( factoryUuid6Type );
	}

	public IBusModelJavaFXUuidColFactory getUuidColFactory() {
		if( factoryUuidCol == null ) {
			factoryUuidCol = new BusModelJavaFXUuidColFactory( this );
		}
		return( factoryUuidCol );
	}

	public IBusModelJavaFXUuidDefFactory getUuidDefFactory() {
		if( factoryUuidDef == null ) {
			factoryUuidDef = new BusModelJavaFXUuidDefFactory( this );
		}
		return( factoryUuidDef );
	}

	public IBusModelJavaFXUuidGenFactory getUuidGenFactory() {
		if( factoryUuidGen == null ) {
			factoryUuidGen = new BusModelJavaFXUuidGenFactory( this );
		}
		return( factoryUuidGen );
	}

	public IBusModelJavaFXUuidTypeFactory getUuidTypeFactory() {
		if( factoryUuidType == null ) {
			factoryUuidType = new BusModelJavaFXUuidTypeFactory( this );
		}
		return( factoryUuidType );
	}

	public IBusModelJavaFXValueFactory getValueFactory() {
		if( factoryValue == null ) {
			factoryValue = new BusModelJavaFXValueFactory( this );
		}
		return( factoryValue );
	}
}
