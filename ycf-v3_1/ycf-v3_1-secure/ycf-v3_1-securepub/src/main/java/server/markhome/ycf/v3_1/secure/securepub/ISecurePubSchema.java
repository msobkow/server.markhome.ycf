// Description: Java 25 public interface for a Secure schema.

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//import server.markhome.ycf.v3_1.secure.securepub.buff.SecurePubBuffFactoryService;

public interface ISecurePubSchema
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
		new SecurePubTableData("Secure", "SecSession", null, false, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecSysGrp", null, true, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecSysRole", null, true, false, "System", "Public"),
		new SecurePubTableData("Secure", "SecUser", null, true, false, "System", "Public"),
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

		final static ArrayList<ISecurePubSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecurePubSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecurePubSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ISecurePubSchema> backingSecure = new AtomicReference<>();
	final static AtomicReference<ISecurePubAuthorizationCallback> authorizationCallback = new AtomicReference<>();
	
	public static ISecurePubAuthorizationCallback getAuthorizationCallback() {
		ISecurePubAuthorizationCallback retval = authorizationCallback.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "getAuthorizationCallback", 0, "authorizationCallback.get()");
		}
		return( retval );
	}
	
	public static void setAuthorizationCallback(ISecurePubAuthorizationCallback callback) {
		if (callback == null) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "setAuthorizationCallback", 0, "callback");
		}
		authorizationCallback.set(callback);
	}

	final static AtomicReference<ISecurePubSecurityService> securityService = new AtomicReference<>();
	
	public static ISecurePubSecurityService getSecurityService() {
		ISecurePubSecurityService retval = securityService.get();
		if (retval == null) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "getSecurityService", 0, "securityService.get()");
		}
		return( retval );
	}
	
	public static void setSecurityService(ISecurePubSecurityService service) {
		if (service == null) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "setSecurityService", 0, "service");
		}
		securityService.compareAndSet(null, service);
	}

	public enum AuditActionEnum {
		Created,
		Updated,
		Deleted,
		Mutated
	};

	static HashMap<String,AuditActionEnum> lookupAuditActionEnum = new HashMap<String,AuditActionEnum>();

	public static AuditActionEnum parseAuditActionEnum( String value ) {
		AuditActionEnum retval = parseAuditActionEnum( ISecurePubSchema.class.getName(), value );
		return( retval );
	}

	public static AuditActionEnum parseAuditActionEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseAuditActionEnum";
		if( lookupAuditActionEnum.isEmpty() ) {
			lookupAuditActionEnum.put( "Created", AuditActionEnum.Created );
			lookupAuditActionEnum.put( "Updated", AuditActionEnum.Updated );
			lookupAuditActionEnum.put( "Deleted", AuditActionEnum.Deleted );
			lookupAuditActionEnum.put( "Mutated", AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupAuditActionEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,AuditActionEnum> lookupOrdinalAuditActionEnum = new HashMap<Integer,AuditActionEnum>();

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Integer value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( ISecurePubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToAuditActionEnum";
		if( lookupOrdinalAuditActionEnum.isEmpty() ) {
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Created.ordinal() ), AuditActionEnum.Created );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Updated.ordinal() ), AuditActionEnum.Updated );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Deleted.ordinal() ), AuditActionEnum.Deleted );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Mutated.ordinal() ), AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalAuditActionEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecLevelEnum {
		System,
		Global,
		Cluster,
		Tenant,
		SysRole,
		ClusRole,
		TentRole
	};

	static HashMap<String,SecLevelEnum> lookupSecLevelEnum = new HashMap<String,SecLevelEnum>();

	public static SecLevelEnum parseSecLevelEnum( String value ) {
		SecLevelEnum retval = parseSecLevelEnum( ISecurePubSchema.class.getName(), value );
		return( retval );
	}

	public static SecLevelEnum parseSecLevelEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecLevelEnum";
		if( lookupSecLevelEnum.isEmpty() ) {
			lookupSecLevelEnum.put( "System", SecLevelEnum.System );
			lookupSecLevelEnum.put( "Global", SecLevelEnum.Global );
			lookupSecLevelEnum.put( "Cluster", SecLevelEnum.Cluster );
			lookupSecLevelEnum.put( "Tenant", SecLevelEnum.Tenant );
			lookupSecLevelEnum.put( "SysRole", SecLevelEnum.SysRole );
			lookupSecLevelEnum.put( "ClusRole", SecLevelEnum.ClusRole );
			lookupSecLevelEnum.put( "TentRole", SecLevelEnum.TentRole );
		}
		SecLevelEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecLevelEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecLevelEnum> lookupOrdinalSecLevelEnum = new HashMap<Integer,SecLevelEnum>();

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Integer value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( ISecurePubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecLevelEnum";
		if( lookupOrdinalSecLevelEnum.isEmpty() ) {
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.System.ordinal() ), SecLevelEnum.System );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Global.ordinal() ), SecLevelEnum.Global );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Cluster.ordinal() ), SecLevelEnum.Cluster );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Tenant.ordinal() ), SecLevelEnum.Tenant );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.SysRole.ordinal() ), SecLevelEnum.SysRole );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.ClusRole.ordinal() ), SecLevelEnum.ClusRole );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.TentRole.ordinal() ), SecLevelEnum.TentRole );
		}
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecLevelEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecAccountStatusEnum {
		System,
		VerifyingEmail,
		CreatingDevKey,
		NormalUser,
		ResettingPassword,
		Locked
	};

	static HashMap<String,SecAccountStatusEnum> lookupSecAccountStatusEnum = new HashMap<String,SecAccountStatusEnum>();

	public static SecAccountStatusEnum parseSecAccountStatusEnum( String value ) {
		SecAccountStatusEnum retval = parseSecAccountStatusEnum( ISecurePubSchema.class.getName(), value );
		return( retval );
	}

	public static SecAccountStatusEnum parseSecAccountStatusEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecAccountStatusEnum";
		if( lookupSecAccountStatusEnum.isEmpty() ) {
			lookupSecAccountStatusEnum.put( "System", SecAccountStatusEnum.System );
			lookupSecAccountStatusEnum.put( "VerifyingEmail", SecAccountStatusEnum.VerifyingEmail );
			lookupSecAccountStatusEnum.put( "CreatingDevKey", SecAccountStatusEnum.CreatingDevKey );
			lookupSecAccountStatusEnum.put( "NormalUser", SecAccountStatusEnum.NormalUser );
			lookupSecAccountStatusEnum.put( "ResettingPassword", SecAccountStatusEnum.ResettingPassword );
			lookupSecAccountStatusEnum.put( "Locked", SecAccountStatusEnum.Locked );
		}
		SecAccountStatusEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecAccountStatusEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecAccountStatusEnum> lookupOrdinalSecAccountStatusEnum = new HashMap<Integer,SecAccountStatusEnum>();

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( String fieldOrClassName, Short value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( Short value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( Integer value ) {
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecAccountStatusEnum( ISecurePubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecAccountStatusEnum ordinalToSecAccountStatusEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecAccountStatusEnum";
		if( lookupOrdinalSecAccountStatusEnum.isEmpty() ) {
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.System.ordinal() ), SecAccountStatusEnum.System );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.VerifyingEmail.ordinal() ), SecAccountStatusEnum.VerifyingEmail );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.CreatingDevKey.ordinal() ), SecAccountStatusEnum.CreatingDevKey );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.NormalUser.ordinal() ), SecAccountStatusEnum.NormalUser );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.ResettingPassword.ordinal() ), SecAccountStatusEnum.ResettingPassword );
			lookupOrdinalSecAccountStatusEnum.put( Integer.valueOf( SecAccountStatusEnum.Locked.ordinal() ), SecAccountStatusEnum.Locked );
		}
		SecAccountStatusEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecAccountStatusEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static final AtomicReference<YCFDbKeyHash256> sysClusterId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> sysTenantId = new AtomicReference<>();
	static final AtomicReference<YCFDbKeyHash256> systemId = new AtomicReference<>();

	public static String getPasswordHash(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "getPasswordHash", 1, "pw");
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
			throw new YCFNullArgumentException(ISecurePubSchema.class, "setSysClusterId", 1, "argClusterId");
		}
		YCFDbKeyHash256 oldid = sysClusterId.get();
		if (oldid == null) {
			sysClusterId.compareAndSet(null, argClusterId);
		}
		else if (oldid.isNull()) {
			sysClusterId.compareAndSet(oldid, argClusterId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecurePubSchema.class, "setSysClusterId", "sysClusterId has already been set", "sysClusterId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSysTenantId() {
		return (sysTenantId.get());
	}

	public static void setSysTenantId(YCFDbKeyHash256 argTenantId) {
		if (argTenantId == null || argTenantId.isNull()) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "setSysTenantId", 1, "argTenantId");
		}
		YCFDbKeyHash256 oldid = sysTenantId.get();
		if (oldid == null) {
			sysTenantId.compareAndSet(null, argTenantId);
		}
		else if (oldid.isNull()) {
			sysTenantId.compareAndSet(oldid, argTenantId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecurePubSchema.class, "setSysTenantId", "sysTenantId has already been set", "sysTenantId has already been set");
		}
	}

	public static YCFDbKeyHash256 getSystemId() {
		return (systemId.get());
	}

	public static void setSystemId(YCFDbKeyHash256 argSystemId) {
		if (argSystemId == null || argSystemId.isNull()) {
			throw new YCFNullArgumentException(ISecurePubSchema.class, "setSystemId", 1, "argSystemId");
		}
		YCFDbKeyHash256 oldid = systemId.get();
		if (oldid == null) {
			systemId.compareAndSet(null, argSystemId);
		}
		else if (oldid.isNull()) {
			systemId.compareAndSet(oldid, argSystemId);
		}
		else {
			throw new YCFInvalidArgumentException(ISecurePubSchema.class, "setSystemId", "systemId has already been set", "systemId has already been set");
		}
	}

		public static ISecurePubSchema getBackingSecure() {
			return( ISecurePubSchema.backingSecure.get() );
		}
		
		public static void setBackingPubSchema(ISecurePubSchema backingSchema) {
			ISecurePubSchema.backingSecure.set(backingSchema);
		}
		
		public ISecurePubSchema getSecureSchema();
		public void setSecureSchema(ISecurePubSchema schema);

		public static int doInitClassMapEntries(int value) {
			if (ISecurePubSchema.entries.isEmpty()) {
				ISecurePubSchema.ClassMapEntry entry;
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "Cluster", ISecurePubCluster.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOCcy", ISecurePubISOCcy.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOCtry", ISecurePubISOCtry.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOCtryCcy", ISecurePubISOCtryCcy.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOCtryLang", ISecurePubISOCtryLang.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOLang", ISecurePubISOLang.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "ISOTZone", ISecurePubISOTZone.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "SecSession", ISecurePubSecSession.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "SecSysGrp", ISecurePubSecSysGrp.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "SecSysRole", ISecurePubSecSysRole.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "SecUser", ISecurePubSecUser.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "SysCluster", ISecurePubSysCluster.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "TableInfo", ISecurePubTableInfo.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(ISecurePubSchema.SCHEMA_NAME, "Tenant", ISecurePubTenant.CLASS_CODE);
				ISecurePubSchema.entries.add(entry);
				for( ISecurePubSchema.ClassMapEntry cur: ISecurePubSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ISecurePubSchema.mapBackingClassCodeToEntry.clear();
				ISecurePubSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecurePubSchema.ClassMapEntry cur: ISecurePubSchema.entries) {
					ISecurePubSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ISecurePubSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecurePubSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecurePubSchema.ClassMapEntry entry;
			entry = ISecurePubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecurePubSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecurePubSchema.ClassMapEntry entry;
			entry = ISecurePubSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ISecurePubSchema instance.
	 */
	public ISecurePubSchema newSchema();

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
	 *	Get the factory for SecurePub data objects.
	 */
	// public ISecurePubFactory getSecureFactory();

	/**
	 *	Get the buffer factory for SecurePub data buffers.
	 */
	// public SecurePubBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubClusterTable getTableCluster();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLangTable getTableISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOTZoneTable getTableISOTZone();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysRole Table interface for the schema.
	 *
	 *	@return	The SecSysRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubSecSysRoleTable getTableSecSysRole();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubSecUserTable getTableSecUser();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubSysClusterTable getTableSysCluster();

	/**
	 *	Get the TableInfo Table interface for the schema.
	 *
	 *	@return	The TableInfo Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfoTable getTableTableInfo();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTenantTable getTableTenant();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecurePubTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecurePubTablePerms getSecurePubTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecurePubTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecurePubTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
