// Description: Java 25 interface for a Secure schema.

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

package server.markhome.ycf.v3_1.secure.secure;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;

public interface ISecureSchema
{
	public static final String SCHEMA_NAME = "Secure";
	public static final String DBSCHEMA_NAME = "Secure31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);
	public static final SecurePubTableData TABLE_DATA[] = {new SecurePubTableData("Secure", "Cluster", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOCcy", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOCtry", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOCtryCcy", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOCtryLang", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOLang", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "ISOTZone", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "SecClusGrp", null, true, false, "Cluster", "Protected"),
		new SecurePubTableData("Secure", "SecClusGrpMemb", null, true, false, "Cluster", "Protected"),
		new SecurePubTableData("Secure", "SecClusRole", null, true, false, "Cluster", "Protected"),
		new SecurePubTableData("Secure", "SecClusRoleMemb", null, true, false, "Cluster", "Protected"),
		new SecurePubTableData("Secure", "SecSession", null, false, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecSysGrp", null, true, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecSysGrpInc", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecSysGrpMemb", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecSysRole", null, true, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecSysRoleEnables", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecSysRoleMemb", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecTentGrp", null, true, false, "Tenant", "Protected"),
		new SecurePubTableData("Secure", "SecTentGrpMemb", null, true, false, "Tenant", "Protected"),
		new SecurePubTableData("Secure", "SecTentRole", null, true, false, "Tenant", "Protected"),
		new SecurePubTableData("Secure", "SecTentRoleMemb", null, true, false, "Tenant", "Protected"),
		new SecurePubTableData("Secure", "SecUser", null, true, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecUserEMConf", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecUserPWHistory", null, false, false, "System", "Private"),
		new SecurePubTableData("Secure", "SecUserPWReset", null, true, false, "System", "Protected"),
		new SecurePubTableData("Secure", "SecUserPassword", null, false, false, "System", "Private"),
		new SecurePubTableData("Secure", "SysCluster", null, false, false, "System", "Public"),
		new SecurePubTableData("Secure", "TableInfo", null, true, false, "Global", "Public"),
		new SecurePubTableData("Secure", "Tenant", null, true, false, "System", "Public")};
	public static final AtomicReference<SecurePubTableData[]> consolidatedTableData = new AtomicReference<>(null);
	public static final SecurePubRoleInfo ROLE_INFO[] = {new SecurePubRoleInfo("secclusmanager", "ClusRole", "sectentmanager createsecclusmemb updatesecclusmemb deletesecclusmemb createsecclusrolememb updatesecclusrolememb deletesecclusrolememb", "systemadmin"),
		new SecurePubRoleInfo("secclusadmin", "ClusRole", "secclusmanager createsecclusgrp updatesecclusgrp deletesecclusgrp readsecclusrole updatesecclusrole createsecclusrole deletesecclusrole", "systemadmin"),
		new SecurePubRoleInfo("secsysmanager", "SysRole", "secuser secclusmanager createsecsysmemb updatesecsysmemb deletesecsysmemb create secsysrolememb updatesecsysrolememb deletesecsysrolememb", "systemadmin"),
		new SecurePubRoleInfo("sectentmanager", "TentRole", "secuser createsectentmemb updatesectentmemb deletesectentmemb createsectentrolememb updatesectentrolememb deletesectentrolememb", "systemadmin"),
		new SecurePubRoleInfo("sectentadmin", "TentRole", "sectentmanager createsectentgrp updatesectentgrp deletesectentgrp createsectentrole updatesectentrole deletesectentrole", "systemadmin"),
		new SecurePubRoleInfo("secsysadmin", "SysRole", "sectentadmin secclusadmin secsysmanager updatecluster deletecluster updatetenant deletetenant createsecsysgrp updatesecsysgrp deletesecsysgrp createsecsysrole updatesecsysrole deletesecsysrole createsecsysinc updatesecsysinc deletesecsysinc ", "systemadmin"),
		new SecurePubRoleInfo("secuser", "SysRole", "readcluster readtenant readsecsysgrp readsecsysinc readsecsysmemb readsecsysrole readsecsysinc readsecsysroleenable readsecsysrolememb readsecclusgrp readsecclusmemb readsecclusrole readsecclusrolememb readsectentgrp readsectentmemb readsectentrole readsectentrolememb", "systemadmin")};
	public static final AtomicReference<SecurePubRoleInfo[]> consolidatedRoleInfo = new AtomicReference<>(null);

	public static SecurePubTableData[] getTableData() {
		return TABLE_DATA;
	}

	public static SecurePubTableData[] getConsolidatedTableData() {
		if (consolidatedTableData.get() == null) {
			ArrayList<SecurePubTableData> lst = new ArrayList<>();
			for( SecurePubTableData data: TABLE_DATA) {
				lst.add(data);
			}
			SecurePubTableData arr[] = new SecurePubTableData[lst.size()];
			int idx = 0;
			for(SecurePubTableData data: lst) {
				arr[idx++] = data;
			}
			consolidatedTableData.compareAndSet(null, arr);
		}
		return(consolidatedTableData.get());
	}

	public static SecurePubRoleInfo[] getRoleInfo() {
		return ROLE_INFO;
	}

	public static SecurePubRoleInfo[] getConsolidatedRoleInfo() {
		if (consolidatedRoleInfo.get() == null) {
			ArrayList<SecurePubRoleInfo> lst = new ArrayList<>();
			for( SecurePubRoleInfo info: ROLE_INFO) {
				lst.add(info);
			}
			// Dependency order is the natural order of role info comparison
			lst.sort(new SecurePubRoleInfoDependencyComparator());
			SecurePubRoleInfo arr[] = new SecurePubRoleInfo[lst.size()];
			int idx = 0;
			for(SecurePubRoleInfo info: lst) {
				arr[idx++] = info;
			}
			consolidatedRoleInfo.compareAndSet(null, arr);
		}
		return(consolidatedRoleInfo.get());
	}

	public default void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}

	public static interface BackingRecConstructor {
		public Object instantiate();
	}
	
	public static class ClassMapEntry {
		final String schemaName;
		final String tableName;
		final int backingClassCode;
		int runtimeClassCode;
		BackingRecConstructor cbRecConstructor;
		
		public ClassMapEntry(String schemaName, String tableName, int backingClassCode) {
			this.schemaName = schemaName;
			this.tableName = tableName;
			this.backingClassCode = backingClassCode;
			runtimeClassCode = 0;
			cbRecConstructor = null;
		}
		
		public String getSchemaName() { return schemaName; }
		public String getTableName() { return tableName; }
		public int getBackingClassCode() { return backingClassCode; }

		public int getRuntimeClassCode() { return runtimeClassCode; }
		public void setRuntimeClassCode(int runtimeClassCode) { this.runtimeClassCode = runtimeClassCode; }
		
		public BackingRecConstructor getBackingRecConstructor() { return cbRecConstructor; }
		public void setBackingRecConstructor(BackingRecConstructor backingRecConstructor) { this.cbRecConstructor = backingRecConstructor; }
	}

		final static ArrayList<ISecureSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecureSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecureSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ISecureSchema> backingSecure = new AtomicReference<>();
	final static AtomicReference<ISecureAuthorizationCallback> authorizationCallback = new AtomicReference<>();
	
	public static ISecureAuthorizationCallback getAuthorizationCallback() {
		ISecureAuthorizationCallback retval = authorizationCallback.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecureSchema.class, "getAuthorizationCallback", 0, "authorizationCallback.get()");
		}
		return( retval );
	}
	
	public static void setAuthorizationCallback(ISecureAuthorizationCallback callback) {
		if (callback == null) {
			throw new YCFNullArgumentException(ISecureSchema.class, "setAuthorizationCallback", 0, "callback");
		}
		authorizationCallback.set(callback);
	}

	final static AtomicReference<ISecureSecurityControl> securityControl = new AtomicReference<>();
	
	public static ISecureSecurityService getSecurityService() {
		ISecureSecurityService retval = securityControl.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecureSchema.class, "getSecurityService", 0, "securityControl.get()");
		}
		return( retval );
	}
	
	public static ISecureSecurityControl getSecurityControl() {
		ISecureSecurityControl retval = securityControl.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecureSchema.class, "getSecurityService", 0, "securityControl.get()");
		}
		return( retval );
	}
	
	public static void setSecurityControl(ISecureSecurityControl control) {
		if (control == null) {
			throw new YCFNullArgumentException(ISecureSchema.class, "setSecurityControl", 0, "control");
		}
		securityControl.set(control);
	}

	static final AtomicReference<YCFDbKeyHash256> sysClusterId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> sysTenantId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> systemId = new AtomicReference<>();

	public static String getPasswordHash(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new YCFNullArgumentException(ISecureSchema.class, "getPasswordHash", 1, "pw");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(pw.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
	}

	public static YCFDbKeyHash256 getSysClusterId() {
		return (sysClusterId.get());
	}

	public static void setSysClusterId(YCFDbKeyHash256 argClusterId) {
		if (argClusterId == null || argClusterId.isNull()) {
			throw new YCFNullArgumentException(ISecureSchema.class, "setSysClusterId", 1, "argClusterId");
		}
		YCFDbKeyHash256 oldid = sysClusterId.get();
		if (oldid == null) {
			sysClusterId.compareAndSet(null, argClusterId);
		}
		else if (oldid.isNull()) {
			sysClusterId.compareAndSet(oldid, argClusterId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureSchema.class, "setSysClusterId", "sysClusterId has already been set", "sysClusterId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSysTenantId() {
		return (sysTenantId.get());
	}

	public static void setSysTenantId(YCFDbKeyHash256 argTenantId) {
		if (argTenantId == null || argTenantId.isNull()) {
			throw new YCFNullArgumentException(ISecureSchema.class, "setSysTenantId", 1, "argTenantId");
		}
		YCFDbKeyHash256 oldid = sysTenantId.get();
		if (oldid == null) {
			sysTenantId.compareAndSet(null, argTenantId);
		}
		else if (oldid.isNull()) {
			sysTenantId.compareAndSet(oldid, argTenantId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureSchema.class, "setSysTenantId", "sysTenantId has already been set", "sysTenantId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSystemId() {
		return (systemId.get());
	}

	public static void setSystemId(YCFDbKeyHash256 argSystemId) {
		if (argSystemId == null || argSystemId.isNull()) {
			throw new YCFNullArgumentException(ISecureSchema.class, "setSystemId", 1, "argSystemId");
		}
		YCFDbKeyHash256 oldid = systemId.get();
		if (oldid == null) {
			systemId.compareAndSet(null, argSystemId);
		}
		else if (oldid.isNull()) {
			systemId.compareAndSet(oldid, argSystemId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureSchema.class, "setSystemId", "systemId has already been set", "systemId has already been set");
		}
	}

		public static ISecureSchema getBackingSecure() {
			return( ISecureSchema.backingSecure.get() );
		}
		
		public static void setBackingSecure(ISecureSchema backingSchema) {
			ISecureSchema.backingSecure.set(backingSchema);
		}
		
		public ISecureSchema getSecureSchema();
		public void setSecureSchema(ISecureSchema schema);

		public static int doInitClassMapEntries(int value) {
			if (ISecureSchema.entries.isEmpty()) {
				ISecureSchema.ClassMapEntry entry;
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "Cluster", ISecureCluster.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "Tenant", ISecureTenant.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "TableInfo", ISecureTableInfo.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOCcy", ISecureISOCcy.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOCtry", ISecureISOCtry.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOCtryCcy", ISecureISOCtryCcy.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOCtryLang", ISecureISOCtryLang.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOLang", ISecureISOLang.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "ISOTZone", ISecureISOTZone.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecUser", ISecureSecUser.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecUserPassword", ISecureSecUserPassword.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecUserEMConf", ISecureSecUserEMConf.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecUserPWReset", ISecureSecUserPWReset.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecUserPWHistory", ISecureSecUserPWHistory.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysGrp", ISecureSecSysGrp.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysGrpInc", ISecureSecSysGrpInc.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysGrpMemb", ISecureSecSysGrpMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecClusGrp", ISecureSecClusGrp.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecClusGrpMemb", ISecureSecClusGrpMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecTentGrp", ISecureSecTentGrp.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecTentGrpMemb", ISecureSecTentGrpMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysRole", ISecureSecSysRole.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysRoleEnables", ISecureSecSysRoleEnables.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSysRoleMemb", ISecureSecSysRoleMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecClusRole", ISecureSecClusRole.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecClusRoleMemb", ISecureSecClusRoleMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecTentRole", ISecureSecTentRole.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecTentRoleMemb", ISecureSecTentRoleMemb.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SecSession", ISecureSecSession.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(ISecureSchema.SCHEMA_NAME, "SysCluster", ISecureSysCluster.CLASS_CODE);
				ISecureSchema.entries.add(entry);
				for( ISecureSchema.ClassMapEntry cur: ISecureSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ISecureSchema.mapBackingClassCodeToEntry.clear();
				ISecureSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecureSchema.ClassMapEntry cur: ISecureSchema.entries) {
					ISecureSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ISecureSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecureSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecureSchema.ClassMapEntry entry;
			entry = ISecureSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecureSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecureSchema.ClassMapEntry entry;
			entry = ISecureSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public int initClassMapEntries(int value);
		public void wireRecConstructors();
		public void wireTableTableInstances();

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ISecureSchema instance.
	 */
	public ISecureSchema newSchema();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen();

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextClusterIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecUserIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTenantIdGen();

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSysGrpIdGen();

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusGrpIdGen();

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusRoleIdGen();

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentGrpIdGen();

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentRoleIdGen();

	/**
	 *	Get the factory for Secure data objects.
	 */
	public ISecureFactory getSecureFactory();

	/**
	 *	Get the buffer factory for Secure data buffers.
	 */
	public SecureBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureClusterTable getTableCluster();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOLangTable getTableISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOTZoneTable getTableISOTZone();

	/**
	 *	Get the SecClusGrp Table interface for the schema.
	 *
	 *	@return	The SecClusGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusGrpTable getTableSecClusGrp();

	/**
	 *	Get the SecClusGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusGrpMembTable getTableSecClusGrpMemb();

	/**
	 *	Get the SecClusRole Table interface for the schema.
	 *
	 *	@return	The SecClusRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusRoleTable getTableSecClusRole();

	/**
	 *	Get the SecClusRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecClusRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusRoleMembTable getTableSecClusRoleMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysGrpInc Table interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpIncTable getTableSecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpMembTable getTableSecSysGrpMemb();

	/**
	 *	Get the SecSysRole Table interface for the schema.
	 *
	 *	@return	The SecSysRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleTable getTableSecSysRole();

	/**
	 *	Get the SecSysRoleEnables Table interface for the schema.
	 *
	 *	@return	The SecSysRoleEnables Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleEnablesTable getTableSecSysRoleEnables();

	/**
	 *	Get the SecSysRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecSysRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleMembTable getTableSecSysRoleMemb();

	/**
	 *	Get the SecTentGrp Table interface for the schema.
	 *
	 *	@return	The SecTentGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentGrpTable getTableSecTentGrp();

	/**
	 *	Get the SecTentGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentGrpMembTable getTableSecTentGrpMemb();

	/**
	 *	Get the SecTentRole Table interface for the schema.
	 *
	 *	@return	The SecTentRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentRoleTable getTableSecTentRole();

	/**
	 *	Get the SecTentRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecTentRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentRoleMembTable getTableSecTentRoleMemb();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserTable getTableSecUser();

	/**
	 *	Get the SecUserEMConf Table interface for the schema.
	 *
	 *	@return	The SecUserEMConf Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserEMConfTable getTableSecUserEMConf();

	/**
	 *	Get the SecUserPWHistory Table interface for the schema.
	 *
	 *	@return	The SecUserPWHistory Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPWHistoryTable getTableSecUserPWHistory();

	/**
	 *	Get the SecUserPWReset Table interface for the schema.
	 *
	 *	@return	The SecUserPWReset Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPWResetTable getTableSecUserPWReset();

	/**
	 *	Get the SecUserPassword Table interface for the schema.
	 *
	 *	@return	The SecUserPassword Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPasswordTable getTableSecUserPassword();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSysClusterTable getTableSysCluster();

	/**
	 *	Get the TableInfo Table interface for the schema.
	 *
	 *	@return	The TableInfo Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureTableInfoTable getTableTableInfo();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureTenantTable getTableTenant();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecureTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecureTablePerms getSecureTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecureTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecureTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
