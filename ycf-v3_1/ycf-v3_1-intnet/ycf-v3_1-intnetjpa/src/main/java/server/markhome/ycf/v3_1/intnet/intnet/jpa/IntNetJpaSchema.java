// Description: Java 25 JPA implementation of a IntNet schema.

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

package server.markhome.ycf.v3_1.intnet.intnet.jpa;
//package server.markhome.ycf.v3_1.intnet.intnet.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.net.InetAddress;
import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.IntNetJpaHooksSchema;

import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffSchema;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffFactoryService;

public class IntNetJpaSchema
	implements IIntNetSchema,
		ISecureSchema
{
	private static IntNetJpaHooksSchema intnetJpaHooksSchema = null;

	protected ISecureClusterTable tableCluster;
	protected ISecureISOCcyTable tableISOCcy;
	protected ISecureISOCtryTable tableISOCtry;
	protected ISecureISOCtryCcyTable tableISOCtryCcy;
	protected ISecureISOCtryLangTable tableISOCtryLang;
	protected ISecureISOLangTable tableISOLang;
	protected ISecureISOTZoneTable tableISOTZone;
	protected IIntNetLicenseTable tableLicense;
	protected IIntNetMajorVersionTable tableMajorVersion;
	protected IIntNetMimeTypeTable tableMimeType;
	protected IIntNetMinorVersionTable tableMinorVersion;
	protected ISecureSecClusGrpTable tableSecClusGrp;
	protected ISecureSecClusGrpMembTable tableSecClusGrpMemb;
	protected ISecureSecClusRoleTable tableSecClusRole;
	protected ISecureSecClusRoleMembTable tableSecClusRoleMemb;
	protected ISecureSecSessionTable tableSecSession;
	protected ISecureSecSysGrpTable tableSecSysGrp;
	protected ISecureSecSysGrpIncTable tableSecSysGrpInc;
	protected ISecureSecSysGrpMembTable tableSecSysGrpMemb;
	protected ISecureSecSysRoleTable tableSecSysRole;
	protected ISecureSecSysRoleEnablesTable tableSecSysRoleEnables;
	protected ISecureSecSysRoleMembTable tableSecSysRoleMemb;
	protected ISecureSecTentGrpTable tableSecTentGrp;
	protected ISecureSecTentGrpMembTable tableSecTentGrpMemb;
	protected ISecureSecTentRoleTable tableSecTentRole;
	protected ISecureSecTentRoleMembTable tableSecTentRoleMemb;
	protected ISecureSecUserTable tableSecUser;
	protected ISecureSecUserEMConfTable tableSecUserEMConf;
	protected ISecureSecUserPWHistoryTable tableSecUserPWHistory;
	protected ISecureSecUserPWResetTable tableSecUserPWReset;
	protected ISecureSecUserPasswordTable tableSecUserPassword;
	protected IIntNetSubProjectTable tableSubProject;
	protected ISecureSysClusterTable tableSysCluster;
	protected ISecureTableInfoTable tableTableInfo;
	protected ISecureTenantTable tableTenant;
	protected IIntNetTldTable tableTld;
	protected IIntNetTopDomainTable tableTopDomain;
	protected IIntNetTopProjectTable tableTopProject;
	protected IIntNetURLProtocolTable tableURLProtocol;


	@Override
	public int initClassMapEntries(int value) {
		return( IIntNetSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ISecureSchema.ClassMapEntry entry;
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetLicense.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetLicense ret = new IntNetJpaLicense();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetLicense.CLASS_CODE)[" + IIntNetLicense.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMajorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMajorVersion ret = new IntNetJpaMajorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMajorVersion.CLASS_CODE)[" + IIntNetMajorVersion.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMimeType ret = new IntNetJpaMimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMimeType.CLASS_CODE)[" + IIntNetMimeType.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMinorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMinorVersion ret = new IntNetJpaMinorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMinorVersion.CLASS_CODE)[" + IIntNetMinorVersion.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetSubProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetSubProject ret = new IntNetJpaSubProject();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetSubProject.CLASS_CODE)[" + IIntNetSubProject.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTld.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTld ret = new IntNetJpaTld();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTld.CLASS_CODE)[" + IIntNetTld.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopDomain.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTopDomain ret = new IntNetJpaTopDomain();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopDomain.CLASS_CODE)[" + IIntNetTopDomain.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTopProject ret = new IntNetJpaTopProject();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopProject.CLASS_CODE)[" + IIntNetTopProject.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetURLProtocol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetURLProtocol ret = new IntNetJpaURLProtocol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetJpaSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetURLProtocol.CLASS_CODE)[" + IIntNetURLProtocol.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		if (tableLicense == null || !(tableLicense instanceof IntNetJpaLicenseTable)) {
			tableLicense = new IntNetJpaLicenseTable(this);
		}
		if (tableMajorVersion == null || !(tableMajorVersion instanceof IntNetJpaMajorVersionTable)) {
			tableMajorVersion = new IntNetJpaMajorVersionTable(this);
		}
		if (tableMimeType == null || !(tableMimeType instanceof IntNetJpaMimeTypeTable)) {
			tableMimeType = new IntNetJpaMimeTypeTable(this);
		}
		if (tableMinorVersion == null || !(tableMinorVersion instanceof IntNetJpaMinorVersionTable)) {
			tableMinorVersion = new IntNetJpaMinorVersionTable(this);
		}
		if (tableSubProject == null || !(tableSubProject instanceof IntNetJpaSubProjectTable)) {
			tableSubProject = new IntNetJpaSubProjectTable(this);
		}
		if (tableTld == null || !(tableTld instanceof IntNetJpaTldTable)) {
			tableTld = new IntNetJpaTldTable(this);
		}
		if (tableTopDomain == null || !(tableTopDomain instanceof IntNetJpaTopDomainTable)) {
			tableTopDomain = new IntNetJpaTopDomainTable(this);
		}
		if (tableTopProject == null || !(tableTopProject instanceof IntNetJpaTopProjectTable)) {
			tableTopProject = new IntNetJpaTopProjectTable(this);
		}
		if (tableURLProtocol == null || !(tableURLProtocol instanceof IntNetJpaURLProtocolTable)) {
			tableURLProtocol = new IntNetJpaURLProtocolTable(this);
		}
	}

	@Override		
	public ISecureSchema getSecureSchema() {
		return( ISecureSchema.getBackingSecure() );
	}

	@Override
	public void setSecureSchema(ISecureSchema schema) {
		ISecureSchema.setBackingSecure(schema);
		schema.wireRecConstructors();
	}

	@Override		
	public IIntNetSchema getIntNetSchema() {
		return( IIntNetSchema.getBackingIntNet() );
	}

	@Override
	public void setIntNetSchema(IIntNetSchema schema) {
		IIntNetSchema.setBackingIntNet(schema);
		schema.wireRecConstructors();
	}

	public static IntNetJpaHooksSchema getJpaHooksSchema() {
		return( intnetJpaHooksSchema );
	}

	public static void setJpaHooksSchema(IntNetJpaHooksSchema jpaHooksSchema) {
		intnetJpaHooksSchema = jpaHooksSchema;
	}

	@Override
	public ISecureFactory getSecureFactory() {
		ISecureSchema sch = ISecureSchema.getBackingSecure();
		if (sch == null) {
			return null;
		}
		else {
			return(sch.getSecureFactory());
		}
	}
	
	@Override
	public SecureBuffFactoryService getSecureBuffFactory() {
		return(SecureBuffSchema.getBuffHooksSchema().getFactoryService());
	}

	@Override
	public IIntNetFactory getIntNetFactory() {
		return(IntNetJpaSchema.getJpaHooksSchema().getFactoryService());
	}

	@Override
	public IntNetBuffFactoryService getIntNetBuffFactory() {
		return((IntNetBuffFactoryService)(IntNetBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public IntNetJpaSchemaService getSchemaService() {
		return( IntNetJpaSchema.getJpaHooksSchema().getSchemaService() );
	}

	public IntNetJpaSchema() {

		tableCluster = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableLicense = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableSecClusGrp = null;
		tableSecClusGrpMemb = null;
		tableSecClusRole = null;
		tableSecClusRoleMemb = null;
		tableSecSession = null;
		tableSecSysGrp = null;
		tableSecSysGrpInc = null;
		tableSecSysGrpMemb = null;
		tableSecSysRole = null;
		tableSecSysRoleEnables = null;
		tableSecSysRoleMemb = null;
		tableSecTentGrp = null;
		tableSecTentGrpMemb = null;
		tableSecTentRole = null;
		tableSecTentRoleMemb = null;
		tableSecUser = null;
		tableSecUserEMConf = null;
		tableSecUserPWHistory = null;
		tableSecUserPWReset = null;
		tableSecUserPassword = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTableInfo = null;
		tableTenant = null;
		tableTld = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableURLProtocol = null;
	}

	@Override
	public IIntNetSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	@Override
	public short nextISOCcyIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCcyIdGen" );
	}

	@Override
	public short nextISOCtryIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCtryIdGen" );
	}

	@Override
	public short nextISOLangIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOLangIdGen" );
	}

	@Override
	public short nextISOTZoneIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOTZoneIdGen" );
	}

	@Override
	public int nextTableInfoIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextTableInfoIdGen" );
	}

	@Override
	public int nextMimeTypeIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextMimeTypeIdGen" );
	}

	@Override
	public int nextURLProtocolIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextURLProtocolIdGen" );
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

	@Override
	public YCFDbKeyHash256 nextMajorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextMinorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSubProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTldIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopDomainIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextLicenseIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	public ISecureClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ISecureClusterTable value ) {
		tableCluster = value;
	}

	public ISecureISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ISecureISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ISecureISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ISecureISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ISecureISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ISecureISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ISecureISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ISecureISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ISecureISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ISecureISOLangTable value ) {
		tableISOLang = value;
	}

	public ISecureISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ISecureISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public IIntNetLicenseTable getTableLicense() {
		return( tableLicense );
	}

	public void setTableLicense( IIntNetLicenseTable value ) {
		tableLicense = value;
	}

	public IIntNetMajorVersionTable getTableMajorVersion() {
		return( tableMajorVersion );
	}

	public void setTableMajorVersion( IIntNetMajorVersionTable value ) {
		tableMajorVersion = value;
	}

	public IIntNetMimeTypeTable getTableMimeType() {
		return( tableMimeType );
	}

	public void setTableMimeType( IIntNetMimeTypeTable value ) {
		tableMimeType = value;
	}

	public IIntNetMinorVersionTable getTableMinorVersion() {
		return( tableMinorVersion );
	}

	public void setTableMinorVersion( IIntNetMinorVersionTable value ) {
		tableMinorVersion = value;
	}

	public ISecureSecClusGrpTable getTableSecClusGrp() {
		return( tableSecClusGrp );
	}

	public void setTableSecClusGrp( ISecureSecClusGrpTable value ) {
		tableSecClusGrp = value;
	}

	public ISecureSecClusGrpMembTable getTableSecClusGrpMemb() {
		return( tableSecClusGrpMemb );
	}

	public void setTableSecClusGrpMemb( ISecureSecClusGrpMembTable value ) {
		tableSecClusGrpMemb = value;
	}

	public ISecureSecClusRoleTable getTableSecClusRole() {
		return( tableSecClusRole );
	}

	public void setTableSecClusRole( ISecureSecClusRoleTable value ) {
		tableSecClusRole = value;
	}

	public ISecureSecClusRoleMembTable getTableSecClusRoleMemb() {
		return( tableSecClusRoleMemb );
	}

	public void setTableSecClusRoleMemb( ISecureSecClusRoleMembTable value ) {
		tableSecClusRoleMemb = value;
	}

	public ISecureSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ISecureSecSessionTable value ) {
		tableSecSession = value;
	}

	public ISecureSecSysGrpTable getTableSecSysGrp() {
		return( tableSecSysGrp );
	}

	public void setTableSecSysGrp( ISecureSecSysGrpTable value ) {
		tableSecSysGrp = value;
	}

	public ISecureSecSysGrpIncTable getTableSecSysGrpInc() {
		return( tableSecSysGrpInc );
	}

	public void setTableSecSysGrpInc( ISecureSecSysGrpIncTable value ) {
		tableSecSysGrpInc = value;
	}

	public ISecureSecSysGrpMembTable getTableSecSysGrpMemb() {
		return( tableSecSysGrpMemb );
	}

	public void setTableSecSysGrpMemb( ISecureSecSysGrpMembTable value ) {
		tableSecSysGrpMemb = value;
	}

	public ISecureSecSysRoleTable getTableSecSysRole() {
		return( tableSecSysRole );
	}

	public void setTableSecSysRole( ISecureSecSysRoleTable value ) {
		tableSecSysRole = value;
	}

	public ISecureSecSysRoleEnablesTable getTableSecSysRoleEnables() {
		return( tableSecSysRoleEnables );
	}

	public void setTableSecSysRoleEnables( ISecureSecSysRoleEnablesTable value ) {
		tableSecSysRoleEnables = value;
	}

	public ISecureSecSysRoleMembTable getTableSecSysRoleMemb() {
		return( tableSecSysRoleMemb );
	}

	public void setTableSecSysRoleMemb( ISecureSecSysRoleMembTable value ) {
		tableSecSysRoleMemb = value;
	}

	public ISecureSecTentGrpTable getTableSecTentGrp() {
		return( tableSecTentGrp );
	}

	public void setTableSecTentGrp( ISecureSecTentGrpTable value ) {
		tableSecTentGrp = value;
	}

	public ISecureSecTentGrpMembTable getTableSecTentGrpMemb() {
		return( tableSecTentGrpMemb );
	}

	public void setTableSecTentGrpMemb( ISecureSecTentGrpMembTable value ) {
		tableSecTentGrpMemb = value;
	}

	public ISecureSecTentRoleTable getTableSecTentRole() {
		return( tableSecTentRole );
	}

	public void setTableSecTentRole( ISecureSecTentRoleTable value ) {
		tableSecTentRole = value;
	}

	public ISecureSecTentRoleMembTable getTableSecTentRoleMemb() {
		return( tableSecTentRoleMemb );
	}

	public void setTableSecTentRoleMemb( ISecureSecTentRoleMembTable value ) {
		tableSecTentRoleMemb = value;
	}

	public ISecureSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ISecureSecUserTable value ) {
		tableSecUser = value;
	}

	public ISecureSecUserEMConfTable getTableSecUserEMConf() {
		return( tableSecUserEMConf );
	}

	public void setTableSecUserEMConf( ISecureSecUserEMConfTable value ) {
		tableSecUserEMConf = value;
	}

	public ISecureSecUserPWHistoryTable getTableSecUserPWHistory() {
		return( tableSecUserPWHistory );
	}

	public void setTableSecUserPWHistory( ISecureSecUserPWHistoryTable value ) {
		tableSecUserPWHistory = value;
	}

	public ISecureSecUserPWResetTable getTableSecUserPWReset() {
		return( tableSecUserPWReset );
	}

	public void setTableSecUserPWReset( ISecureSecUserPWResetTable value ) {
		tableSecUserPWReset = value;
	}

	public ISecureSecUserPasswordTable getTableSecUserPassword() {
		return( tableSecUserPassword );
	}

	public void setTableSecUserPassword( ISecureSecUserPasswordTable value ) {
		tableSecUserPassword = value;
	}

	public IIntNetSubProjectTable getTableSubProject() {
		return( tableSubProject );
	}

	public void setTableSubProject( IIntNetSubProjectTable value ) {
		tableSubProject = value;
	}

	public ISecureSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ISecureSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ISecureTableInfoTable getTableTableInfo() {
		return( tableTableInfo );
	}

	public void setTableTableInfo( ISecureTableInfoTable value ) {
		tableTableInfo = value;
	}

	public ISecureTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ISecureTenantTable value ) {
		tableTenant = value;
	}

	public IIntNetTldTable getTableTld() {
		return( tableTld );
	}

	public void setTableTld( IIntNetTldTable value ) {
		tableTld = value;
	}

	public IIntNetTopDomainTable getTableTopDomain() {
		return( tableTopDomain );
	}

	public void setTableTopDomain( IIntNetTopDomainTable value ) {
		tableTopDomain = value;
	}

	public IIntNetTopProjectTable getTableTopProject() {
		return( tableTopProject );
	}

	public void setTableTopProject( IIntNetTopProjectTable value ) {
		tableTopProject = value;
	}

	public IIntNetURLProtocolTable getTableURLProtocol() {
		return( tableURLProtocol );
	}

	public void setTableURLProtocol( IIntNetURLProtocolTable value ) {
		tableURLProtocol = value;
	}

	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}

	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}
}
