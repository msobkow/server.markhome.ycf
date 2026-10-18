// Description: Java 25 protected interface for a Secure schema.

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

package server.markhome.ycf.v3_1.secure.secureprot;

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

//import server.markhome.ycf.v3_1.secure.secureprot.buff.SecureProtBuffSchema;
//import server.markhome.ycf.v3_1.secure.secureprot.buff.SecureProtBuffFactoryService;

public interface ISecureProtSchema
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
		new SecurePubTableData("Secure", "SecUserPWReset", null, true, false, "System", "Protected"),
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

		final static ArrayList<ISecureProtSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ISecureProtSchema> backingSecure = new AtomicReference<>();
	final static AtomicReference<ISecureProtAuthorizationCallback> authorizationCallback = new AtomicReference<>();
	
	public static ISecureProtAuthorizationCallback getAuthorizationCallback() {
		ISecureProtAuthorizationCallback retval = authorizationCallback.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "getAuthorizationCallback", 0, "authorizationCallback.get()");
		}
		return( retval );
	}
	
	public static void setAuthorizationCallback(ISecureProtAuthorizationCallback callback) {
		if (callback == null) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "setAuthorizationCallback", 0, "callback");
		}
		authorizationCallback.set(callback);
	}

	final static AtomicReference<ISecureProtSecurityService> securityService = new AtomicReference<>();
	
	public static ISecureProtSecurityService getSecurityService() {
		ISecureProtSecurityService retval = securityService.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "getSecurityService", 0, "securityService.get()");
		}
		return( retval );
	}
	
	public static void setSecurityService(ISecureProtSecurityService service) {
		if (service == null) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "setSecurityService", 0, "service");
		}
		securityService.compareAndSet(null, service);
	}

	static final AtomicReference<YCFDbKeyHash256> sysClusterId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> sysTenantId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> systemId = new AtomicReference<>();

	public static String getPasswordHash(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "getPasswordHash", 1, "pw");
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
			throw new YCFNullArgumentException(ISecureProtSchema.class, "setSysClusterId", 1, "argClusterId");
		}
		YCFDbKeyHash256 oldid = sysClusterId.get();
		if (oldid == null) {
			sysClusterId.compareAndSet(null, argClusterId);
		}
		else if (oldid.isNull()) {
			sysClusterId.compareAndSet(oldid, argClusterId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureProtSchema.class, "setSysClusterId", "sysClusterId has already been set", "sysClusterId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSysTenantId() {
		return (sysTenantId.get());
	}

	public static void setSysTenantId(YCFDbKeyHash256 argTenantId) {
		if (argTenantId == null || argTenantId.isNull()) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "setSysTenantId", 1, "argTenantId");
		}
		YCFDbKeyHash256 oldid = sysTenantId.get();
		if (oldid == null) {
			sysTenantId.compareAndSet(null, argTenantId);
		}
		else if (oldid.isNull()) {
			sysTenantId.compareAndSet(oldid, argTenantId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureProtSchema.class, "setSysTenantId", "sysTenantId has already been set", "sysTenantId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSystemId() {
		return (systemId.get());
	}

	public static void setSystemId(YCFDbKeyHash256 argSystemId) {
		if (argSystemId == null || argSystemId.isNull()) {
			throw new YCFNullArgumentException(ISecureProtSchema.class, "setSystemId", 1, "argSystemId");
		}
		YCFDbKeyHash256 oldid = systemId.get();
		if (oldid == null) {
			systemId.compareAndSet(null, argSystemId);
		}
		else if (oldid.isNull()) {
			systemId.compareAndSet(oldid, argSystemId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecureProtSchema.class, "setSystemId", "systemId has already been set", "systemId has already been set");
		}
	}

		public static ISecureProtSchema getBackingSecure() {
			return( ISecureProtSchema.backingSecure.get() );
		}
		
		public static void setBackingSecure(ISecureProtSchema backingSchema) {
			ISecureProtSchema.backingSecure.set(backingSchema);
		}
		
		public ISecureProtSchema getSecureSchema();
		public void setSecureSchema(ISecureProtSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			if (ISecureProtSchema.entries.isEmpty()) {
				ISecureProtSchema.ClassMapEntry entry;
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "Cluster", ISecureProtCluster.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOCcy", ISecureProtISOCcy.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOCtry", ISecureProtISOCtry.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOCtryCcy", ISecureProtISOCtryCcy.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOCtryLang", ISecureProtISOCtryLang.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOLang", ISecureProtISOLang.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "ISOTZone", ISecureProtISOTZone.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecClusGrp", ISecureProtSecClusGrp.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecClusGrpMemb", ISecureProtSecClusGrpMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecClusRole", ISecureProtSecClusRole.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecClusRoleMemb", ISecureProtSecClusRoleMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSession", ISecureProtSecSession.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysGrp", ISecureProtSecSysGrp.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysGrpInc", ISecureProtSecSysGrpInc.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysGrpMemb", ISecureProtSecSysGrpMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysRole", ISecureProtSecSysRole.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysRoleEnables", ISecureProtSecSysRoleEnables.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecSysRoleMemb", ISecureProtSecSysRoleMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecTentGrp", ISecureProtSecTentGrp.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecTentGrpMemb", ISecureProtSecTentGrpMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecTentRole", ISecureProtSecTentRole.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecTentRoleMemb", ISecureProtSecTentRoleMemb.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecUser", ISecureProtSecUser.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecUserEMConf", ISecureProtSecUserEMConf.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SecUserPWReset", ISecureProtSecUserPWReset.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "SysCluster", ISecureProtSysCluster.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "TableInfo", ISecureProtTableInfo.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(ISecureProtSchema.SCHEMA_NAME, "Tenant", ISecureProtTenant.CLASS_CODE);
				ISecureProtSchema.entries.add(entry);
				for( ISecureProtSchema.ClassMapEntry cur: ISecureProtSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ISecureProtSchema.mapBackingClassCodeToEntry.clear();
				ISecureProtSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecureProtSchema.ClassMapEntry cur: ISecureProtSchema.entries) {
					ISecureProtSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ISecureProtSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecureProtSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecureProtSchema.ClassMapEntry entry;
			entry = ISecureProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecureProtSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecureProtSchema.ClassMapEntry entry;
			entry = ISecureProtSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ISecureProtSchema instance.
	 */
	public ISecureProtSchema newSchema();

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
	 *	Get the factory for SecureProt data objects.
	 */
	// public ISecureProtFactory getSecureFactory();

	/**
	 *	Get the buffer factory for SecureProt data buffers.
	 */
	// public SecureProtBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtClusterTable getTableCluster();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOLangTable getTableISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtISOTZoneTable getTableISOTZone();

	/**
	 *	Get the SecClusGrp Table interface for the schema.
	 *
	 *	@return	The SecClusGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrpTable getTableSecClusGrp();

	/**
	 *	Get the SecClusGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrpMembTable getTableSecClusGrpMemb();

	/**
	 *	Get the SecClusRole Table interface for the schema.
	 *
	 *	@return	The SecClusRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusRoleTable getTableSecClusRole();

	/**
	 *	Get the SecClusRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecClusRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusRoleMembTable getTableSecClusRoleMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysGrpInc Table interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpIncTable getTableSecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpMembTable getTableSecSysGrpMemb();

	/**
	 *	Get the SecSysRole Table interface for the schema.
	 *
	 *	@return	The SecSysRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysRoleTable getTableSecSysRole();

	/**
	 *	Get the SecSysRoleEnables Table interface for the schema.
	 *
	 *	@return	The SecSysRoleEnables Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysRoleEnablesTable getTableSecSysRoleEnables();

	/**
	 *	Get the SecSysRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecSysRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysRoleMembTable getTableSecSysRoleMemb();

	/**
	 *	Get the SecTentGrp Table interface for the schema.
	 *
	 *	@return	The SecTentGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecTentGrpTable getTableSecTentGrp();

	/**
	 *	Get the SecTentGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecTentGrpMembTable getTableSecTentGrpMemb();

	/**
	 *	Get the SecTentRole Table interface for the schema.
	 *
	 *	@return	The SecTentRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecTentRoleTable getTableSecTentRole();

	/**
	 *	Get the SecTentRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecTentRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecTentRoleMembTable getTableSecTentRoleMemb();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserTable getTableSecUser();

	/**
	 *	Get the SecUserEMConf Table interface for the schema.
	 *
	 *	@return	The SecUserEMConf Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConfTable getTableSecUserEMConf();

	/**
	 *	Get the SecUserPWReset Table interface for the schema.
	 *
	 *	@return	The SecUserPWReset Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserPWResetTable getTableSecUserPWReset();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSysClusterTable getTableSysCluster();

	/**
	 *	Get the TableInfo Table interface for the schema.
	 *
	 *	@return	The TableInfo Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtTableInfoTable getTableTableInfo();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtTenantTable getTableTenant();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecureProtTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecureProtTablePerms getSecureProtTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecureProtTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecureProtTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
