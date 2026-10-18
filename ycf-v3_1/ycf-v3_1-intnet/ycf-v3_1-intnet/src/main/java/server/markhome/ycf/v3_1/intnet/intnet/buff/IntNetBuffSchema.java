// Description: Java 25 buffer implementation of a IntNet schema.

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

package server.markhome.ycf.v3_1.intnet.intnet.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffHooksSchema;

public class IntNetBuffSchema
	implements IIntNetSchema,
		ISecureSchema
{
	private static IntNetBuffHooksSchema intnetBuffHooksSchema = null;


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
					IIntNetLicense ret = new IntNetBuffLicense();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetLicense.CLASS_CODE)[" + IIntNetLicense.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMajorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMajorVersion ret = new IntNetBuffMajorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMajorVersion.CLASS_CODE)[" + IIntNetMajorVersion.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMimeType ret = new IntNetBuffMimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMimeType.CLASS_CODE)[" + IIntNetMimeType.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetMinorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetMinorVersion ret = new IntNetBuffMinorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetMinorVersion.CLASS_CODE)[" + IIntNetMinorVersion.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetSubProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetSubProject ret = new IntNetBuffSubProject();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetSubProject.CLASS_CODE)[" + IIntNetSubProject.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTld.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTld ret = new IntNetBuffTld();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTld.CLASS_CODE)[" + IIntNetTld.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopDomain.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTopDomain ret = new IntNetBuffTopDomain();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopDomain.CLASS_CODE)[" + IIntNetTopDomain.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetTopProject ret = new IntNetBuffTopProject();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetTopProject.CLASS_CODE)[" + IIntNetTopProject.CLASS_CODE + "]");
		}
	
		entry = IIntNetSchema.getClassMapByBackingClassCode(IIntNetURLProtocol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IIntNetURLProtocol ret = new IntNetBuffURLProtocol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(IntNetBuffSchema.class, "wireRecConstructors", 0, "IIntNetSchema.getClassMapByBackingClassCode(IIntNetURLProtocol.CLASS_CODE)[" + IIntNetURLProtocol.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new YCFMustOverrideException(getClass(), "wireTableTableInstances");
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

	public static IntNetBuffHooksSchema getBuffHooksSchema() {
		return( intnetBuffHooksSchema );
	}

	public static void setBuffHooksSchema(IntNetBuffHooksSchema buffHooksSchema) {
		intnetBuffHooksSchema = buffHooksSchema;
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
		ISecureSchema sch = ISecureSchema.getBackingSecure();
		if (sch == null) {
			return null;
		}
		else {
			return((SecureBuffFactoryService)(sch.getSecureBuffFactory()));
		}
	}

	@Override
	public IIntNetFactory getIntNetFactory() {
		return(IntNetBuffSchema.getBuffHooksSchema().getFactoryService());
	}

	@Override
	public IntNetBuffFactoryService getIntNetBuffFactory() {
		return((IntNetBuffFactoryService)(IntNetBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public IntNetBuffSchema() {

	tableLicense = null; // new IntNetBuffLicenseTable();
	tableMajorVersion = null; // new IntNetBuffMajorVersionTable();
	tableMimeType = null; // new IntNetBuffMimeTypeTable();
	tableMinorVersion = null; // new IntNetBuffMinorVersionTable();
	tableSubProject = null; // new IntNetBuffSubProjectTable();
	tableTld = null; // new IntNetBuffTldTable();
	tableTopDomain = null; // new IntNetBuffTopDomainTable();
	tableTopProject = null; // new IntNetBuffTopProjectTable();
	tableURLProtocol = null; // new IntNetBuffURLProtocolTable();
	}

	public IIntNetSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextTableInfoIdGen");
	}

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextMimeTypeIdGen");
	}

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextURLProtocolIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextClusterIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecUserIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTenantIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMajorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMinorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSubProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTldIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopDomainIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextLicenseIdGen() {
		return( new YCFDbKeyHash256(0) );
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

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}
	
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}
}
