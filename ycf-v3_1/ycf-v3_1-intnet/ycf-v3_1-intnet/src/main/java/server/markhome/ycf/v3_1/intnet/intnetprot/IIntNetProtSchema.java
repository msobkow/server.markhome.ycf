// Description: Java 25 protected interface for a IntNet schema.

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

package server.markhome.ycf.v3_1.intnet.intnetprot;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;

//import server.markhome.ycf.v3_1.secure.secureprot.buff.SecureProtBuffFactoryService;
//import server.markhome.ycf.v3_1.intnet.intnetprot.buff.IntNetProtBuffSchema;
//import server.markhome.ycf.v3_1.intnet.intnetprot.buff.IntNetProtBuffFactoryService;

public interface IIntNetProtSchema
extends ISecureProtSchema
{

	public static final String SCHEMA_NAME = "IntNet";
	public static final String DBSCHEMA_NAME = "IntNet31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);
	public static final SecurePubTableData TABLE_DATA[] = {new SecurePubTableData("IntNet", "License", null, false, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "MajorVersion", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "MimeType", null, true, false, "System", "Public"),
		new SecurePubTableData("IntNet", "MinorVersion", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "SubProject", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "Tld", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "TopDomain", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "TopProject", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("IntNet", "URLProtocol", null, true, false, "System", "Public")};
	public static final AtomicReference<SecurePubTableData[]> consolidatedTableData = new AtomicReference<>(null);
	public static final SecurePubRoleInfo ROLE_INFO[] = {};
	public static final AtomicReference<SecurePubRoleInfo[]> consolidatedRoleInfo = new AtomicReference<>(null);
	public static SecurePubTableData[] getTableData() {
		return TABLE_DATA;
	}

	public static SecurePubTableData[] getConsolidatedTableData() {
		if (consolidatedTableData.get() == null) {
			ArrayList<SecurePubTableData> lst = new ArrayList<>();
			for( SecurePubTableData data: ISecureProtSchema.getTableData()) {
				lst.add(data);
			}
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
			for( SecurePubRoleInfo info: ISecureProtSchema.getRoleInfo()) {
				lst.add(info);
			}
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

		final static ArrayList<ISecureProtSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<IIntNetProtSchema> backingIntNet = new AtomicReference<>();
		public static IIntNetProtSchema getBackingIntNet() {
			return( IIntNetProtSchema.backingIntNet.get() );
		}
		
		public static void setBackingIntNet(IIntNetProtSchema backingSchema) {
			IIntNetProtSchema.backingIntNet.set(backingSchema);
		}
		
		public IIntNetProtSchema getIntNetSchema();
		public void setIntNetSchema(IIntNetProtSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			value = ISecureProtSchema.doInitClassMapEntries(value);
			if (IIntNetProtSchema.entries.isEmpty()) {
				ISecureProtSchema.ClassMapEntry entry;
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "License", IIntNetProtLicense.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "MajorVersion", IIntNetProtMajorVersion.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "MimeType", IIntNetProtMimeType.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "MinorVersion", IIntNetProtMinorVersion.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "SubProject", IIntNetProtSubProject.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "Tld", IIntNetProtTld.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "TopDomain", IIntNetProtTopDomain.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "TopProject", IIntNetProtTopProject.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IIntNetProtSchema.SCHEMA_NAME, "URLProtocol", IIntNetProtURLProtocol.CLASS_CODE);
				IIntNetProtSchema.entries.add(entry);
				for( ISecureProtSchema.ClassMapEntry cur: IIntNetProtSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				IIntNetProtSchema.mapBackingClassCodeToEntry.clear();
				IIntNetProtSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecureProtSchema.ClassMapEntry cur: IIntNetProtSchema.entries) {
					IIntNetProtSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					IIntNetProtSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
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
			entry = IIntNetProtSchema.mapBackingClassCodeToEntry.get(code);
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
			entry = IIntNetProtSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen();

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen();

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
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMajorVersionIdGen();

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMinorVersionIdGen();

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSubProjectIdGen();

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTldIdGen();

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopDomainIdGen();

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopProjectIdGen();

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextLicenseIdGen();

	/**
	 *	Get the factory for SecureProt data objects.
	 */
	// public ISecureProtFactory getSecureFactory();

	/**
	 *	Get the buffer factory for SecureProt data buffers.
	 */
	// public SecureProtBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the factory for IntNetProt data objects.
	 */
	// public IIntNetProtFactory getIntNetFactory();

	/**
	 *	Get the buffer factory for IntNetProt data buffers.
	 */
	// public IntNetProtBuffFactoryService getIntNetBuffFactory();

	/**
	 *	Get the License Table interface for the schema.
	 *
	 *	@return	The License Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtLicenseTable getTableLicense();

	/**
	 *	Get the MajorVersion Table interface for the schema.
	 *
	 *	@return	The MajorVersion Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMajorVersionTable getTableMajorVersion();

	/**
	 *	Get the MimeType Table interface for the schema.
	 *
	 *	@return	The MimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMimeTypeTable getTableMimeType();

	/**
	 *	Get the MinorVersion Table interface for the schema.
	 *
	 *	@return	The MinorVersion Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersionTable getTableMinorVersion();

	/**
	 *	Get the SubProject Table interface for the schema.
	 *
	 *	@return	The SubProject Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProjectTable getTableSubProject();

	/**
	 *	Get the Tld Table interface for the schema.
	 *
	 *	@return	The Tld Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtTldTable getTableTld();

	/**
	 *	Get the TopDomain Table interface for the schema.
	 *
	 *	@return	The TopDomain Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtTopDomainTable getTableTopDomain();

	/**
	 *	Get the TopProject Table interface for the schema.
	 *
	 *	@return	The TopProject Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtTopProjectTable getTableTopProject();

	/**
	 *	Get the URLProtocol Table interface for the schema.
	 *
	 *	@return	The URLProtocol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtURLProtocolTable getTableURLProtocol();

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
