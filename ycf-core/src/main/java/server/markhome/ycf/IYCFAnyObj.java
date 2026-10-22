/**
 *	server.markhome.ycf-core - Mark's Code Fractal Core Services
 *
 *	Copyright 2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://apache.org
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 *	SPDX-License-Identifier: Apache-2.0
**/

package server.markhome.ycf;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.util.*;

/**
 *	The IYCFAnyObj interface is a rich specification of all the system-level interfaces expected at runtime by the system which are available at various times during processing. All of the methods can theoretically return null at certain points during normal system operations, so be careful in your code to allow for that.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFAnyObj extends JSObject {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference<IYCFAnyObj> singleton = IYCFMtReference<IYCFAnyObj>.getService().getInstance(null);

	/**
	 *	Get the service singleton that provides the getInstance() implementations.
	 *
	 *	@return The service singleton that provides the getInstance() implementations.
	 */
	@JSExport
	public static IYCFAnyObj getService() {
		IYCFAnyObj ref = singleton.get();
		if (ref == null) {
			ref = new YCFAnyObj();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	Get the service singleton that provides the getInstance() implementations specifying the initial service provider to use if the singleton has to be constructed.
	 *
	 *	@return The service singleton that provides the getInstance() implementations specifying the initial service provider to use if the singleton has to be constructed.
	 */
	@JSExport
	public static IYCFAnyObj getService(IYCFAnyObj initObj) {
		IYCFAnyObj ref = singleton.get();
		if (ref == null) {
			ref = new YCFAnyObj(initObj);
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	The LibEntry object for a package always defines the OIDs for the package.
	 */
	public static final int YCFANYOBJ_OID = IYCFLibEntry.YCFAnyObjOid;

	/**
	 *	Get the Oid value that implementations return to identify their class.  Note that you cannot count on an interface always returning the same Oid; only concrete implementations will return the same Oid values. Oids are unique in the runtime; one per instantiable class and a minimum of one per interface.
	 *
	 *	@return Oid value implementations return to identify their class.
	 */
	@JSExport
	public static int getOid() {
		return(YCFANYOBJ_OID);
	}

	/**
	 *	Get an instance that provides the service method implementations.
	 *
	 *	@return An instance that provides the service method implementations.
	 */
	@JSExport
	public default IYCFAnyObj getInstance() {
		return(new YCFAnyObj());
	}

	/**
	 *	Get an instance that provides the service method implementations specifying the initial instance to be referenced.
	 *
	 *	@param initObj The object to use to copy from or reference from the newly created instance.
	 *
	 *	@return The Any instance that provides the service method implementations.
	 */
	 @JSExport
	 public default IYCFAnyObj getInstance(IYCFAnyObj initObj) {
		return(new YCFAnyObj(initObj));
	}

	/**
	 *	The public resource name for the parent library.
	 */
	public static final String YCF_LIB_PARENT_NAME = IYCFLibEntry.getParentLibName();

	/**
	 *	The parent version string for this library.
	 */
	public static final String YCF_LIB_PARENT_VERSION = IYCFLibEntry.getParentLibVersion();

	/**
	 *	The public resource name for this library.
	 */
	public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + IYCFLibEntry.getLibName();

	/**
	 *	The public version string for this library.
	 */
	public static final String YCF_LIB_VERSION = IYCFLibEntry.getLibVersion();

	/**
	 *	Get the public resource name for the parent library.
	 */
	@JSProperty
	public static String getParentLibName() {
		return(YCF_LIB_PARENT_NAME);
	}

	/**
	 *	Get the parent resource version for this library.
	 */
	@JSProperty
	public static String getParentLibVersion() {
		return(YCF_LIB_PARENT_VERSION);
	}

	/**
	 *	Get the public resource name for this library.
	 */
	@JSProperty
	public static String getLibName() {
		return(YCF_LIB_NAME);
	}

	/**
	 *	Get the public version string for this library.
	 */
	@JSProperty
	public static String getLibVersion() {
		return(YCF_LIB_VERSION);
	}

	/**
	 *	Get the operating system user login name running the application process.
	 *
	 *	@return String Operating system user login name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public default String getUserLogin() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the operating system group name running the application process.
	 *
	 *	@return String Operating system group name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public default String getUserGroup() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the operating system host name running the application process.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public default String getHostName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the operating system host IP address running the application process. Note that in the case of a load-balanced cluster, more than one physical host might be assigned the same host IP address for access by the load balancer, particularly in network environments managed by Cisco or equivalent hardware.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public default long getHostIPAddr() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(0L);
	}

	/**
	 *	Get the process id for this program.
	 *
	 *	@return long Process id
	 */
	@JSExport
	public default long getProcessId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(0L);
	}

	/**
	 *	Get the thread id currently executing this code.
	 *
	 *	@return long Thread id
	 */
	@JSExport
	public default long getThreadId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(0L);
	}

	/**
	 *	Get the cluster code for this process. The core server uses the system cluster table cluster code value so that it's internal keys will be consistent locally and publicly.  Clients connecting to the server are assigned a generated cluster code guaranteed to be unique in the cluster during runtime and to not be the system cluster code.  This ensures that each host node/program running in the clustered network is using a different cluster code so that it's generated KeyHash ids will truly be unique and distinct without further effort required by the application logic.  The application code relies on this feature to provide maximum throughput and performance of the data processing operations.
	 *
	 *	@return long Cluster code
	 */
	@JSExport
	public default long getClusterCode() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(0L);
	}

	/**
	 *	Get the cluster id that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's cluster id.
	 */
	@JSProperty
	public default IYCFKeyHash256 getClusterId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the node id that owns this piece of information resides.
	 *
	 *	@return IYCFKeyHash256 Data residence node id.
	 */
	@JSProperty
	public default IYCFKeyHash256 getNodeId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the tenant id that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's tenant id.
	 */
	@JSExport
	public default IYCFKeyHash256 getTenantId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the default security group that applies to this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's group id.
	 */
	@JSExport
	public default IYCFKeyHash256 getSecGroupId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the id of the user that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's user id.
	 */
	@JSExport
	public default IYCFKeyHash256 getUserId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current session id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public default IYCFKeyHash256 getSessionId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current transaction id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current transaction id.
	 */
	@JSExport
	public default IYCFKeyHash256 getTxnId() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current generation definition. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current generation defintion.
	 */
	@JSExport
	public default IYCFAnyObj getGenDef() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current scope generation definition . Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public default IYCFAnyObj getScopeDef() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current object named objName from the current generation definition for the specified qualifyingClass as a starting point. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with the specified qualifyingClass.
	 */
	@JSExport
	public default IYCFAnyObj getNamedObject(Class<?> qualifyingClass, String objName) {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current object named objName from the current generation definition making no presumptions about the qualifyingClass. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with an indeterminate qualifyingClass.
	 */
	@JSExport
	public default IYCFAnyObj getNamedObject(String objName) {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the object qualifier for the specified qualifying class from the engine. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object qualifier for the specified qualifyingClass.
	 */
	@JSExport
	public default IYCFAnyObj getObjQualifier(Class<?> qualifyingClass) {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current login name for the operating system. Not expected to change between invocations, but might if this program spawns threads owned by different user ids.
	 *
	 *	@return String Current operating system user login name.
	 */
	@JSExport
	public default String getLoginName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current user name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current user name.
	 */
	@JSExport
	public default String getUserName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current session name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current session name.
	 */
	@JSExport
	public default String getSessionName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get the current transaction name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current transaction name.
	 */
	@JSExport
	public default String getTxnName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get current case-sensitive generation definition name.
	 *
	 *	@return String Current case-sensitive generation definition name.
	 */
	@JSExport
	public default String getGenDefName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get current case-sensitive scoping generation definition name.
	 *
	 *	@return String Current case-sensitive scoping generation definition name.
	 */
	@JSExport
	public default String getScopeGenDefName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get current case-sensitive object name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object name.
	 */
	@JSExport
	public default String getObjName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get current case-sensitive object qualified name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive qualified object name.
	 */
	@JSExport
	public default String getObjQualifiedName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	/**
	 *	Get current case-sensitive object full name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object full name.
	 */
	@JSExport
	public default String getObjFullName() {
		// The generic base objects know absolutely nothing about the state of the world save for information about themselves.
		return(null);
	}

	public static final long NullOid = 1;
	public static final long Null = 0x0;
	public static final long NotNull = 0x1;
	public static final long MaskNull = 0x1;

	/**
	 *	Does this Oid indicate a Null value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Null value, otherwise false.
	 */
	@JSExport
	public static boolean isNull(long value) {
		return((value & MaskNull) == Null);
	}

	/**
	 *	Does this Oid indicate a Not Null value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Not Null value, otherwise false.
	 */
	@JSExport
	public static boolean isNotNull(long value) {
		return((value & MaskNull) == NotNull);
	}

	public static final long RequiredOid = 0x02;
    public static final long Optional = 0x00;
	public static final long Required = 0x02;
	public static final long MaskRequired = 0x02;

	/**
	 *	Does this Oid indicate a Required value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Required value, otherwise false.
	 */
	@JSExport
	public static boolean isRequired(long value) {
		return((value & MaskRequired) == Required);
	}

	/**
	 *	Does this Oid indicate a Not Null value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates an Optional value, otherwise false.
	 */
	@JSExport
	public static boolean isOptional(long value) {
		return((value & MaskRequired) == Optional);
	}

	public static final long ModifiableOid = 0x04;
	public static final long ReadOnly = 0x00;
    public static final long Modifiable = 0x04;
	public static final long MaskModifiable = 0x04;

	/**
	 *	Does this Oid indicate a Modifiable value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Modifiable value, otherwise false.
	 */
	@JSExport
	public static boolean isModifiable(long value) {
		return((value & MaskModifiable) == Modifiable);
	}

	/**
	 *	Does this Oid indicate a Read Only value?
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Read Only value, otherwise false.
	 */
	@JSExport
	public static boolean isReadOnly(long value) {
		return((value & MaskModifiable) == ReadOnly);
	}

	public static final long StaticOid = 0x08;
    public static final long Dynamic = 0x00;
	public static final long Static = 0x08;
	public static final long MaskStatic = 0x08;

	/**
	 *	Does this Oid indicate a Static value? Static values are usually implemented a singletons. Static values are never virtual because they can't be dereferenced from an instance that would support operator/method overloading.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Static value, otherwise false.
	 */
	@JSExport
	public static boolean isStatic(long value) {
		return((value & MaskStatic) == Static);
	}

	/**
	 *	Does this Oid indicate a Dynamic value?  Dynamic values are usually implemented as object properties. A dynamic value implies a virtual value as well, because the instance could overload the operator or method.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Dynamic value, otherwise false.
	 */
	@JSExport
	public static boolean isDynamic(long value) {
		return((value & MaskStatic) == Dynamic);
	}

	public static final long UnknownOid = 0x10;
	public static final long Unknown = 0x00;
	public static final long Known = 0x10;
	public static final long MaskUnknown = 0x10;

	/**
	 *	Does this Oid indicate an Unknown value? Unknown values are statistically irrelevant because they deviate by more than 30 percent from the average and the median.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates an Unknown value, otherwise false.
	 */
	@JSExport
	public static boolean isUnknown(long value) {
		return((value & MaskUnknown) == Unknown);
	}

	/**
	 *	Does this Oid indicate a Known value?  Known values are statistically relevant, though not necessarily strongly so.  They deviate by no more than 30 percent from the average or the median; either will qualify the value as relevant.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Known value, otherwise false.
	 */
	@JSExport
	public static boolean isKnown(long value) {
		return((value & MaskUnknown) == Known);
	}

	public static final long PKeyOid = 0x20;
	public static final long IsPKey = 0x20;
	public static final long MaskPKey = 0x20;

	/**
	 *	Does this Oid indicate a Primary Key value? Primary Key values are essential to the operation of the code.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Primary Key value, otherwise false.
	 */
	@JSExport
	public static boolean isPKey(long value) {
		return((value & MaskPKey) == IsPKey);
	}

	/**
	 *	Does this Oid indicate a Data value?  Any value which isn't part of the primary key must be data.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Data value, otherwise false.
	 */
	@JSExport
	public static boolean isData(long value) {
		return((value & MaskPKey) == 0x0);
	}

	public static final long HistoryPKeyOid = 0x40;
	public static final long IsHistoryPKey = 0x40;
	public static final long MaskHistoryPKey = 0x40;

	/**
	 *	Does this Oid indicate a History Primary Key value? History Primary Key values are essential for restoring prior versions of modifiable data.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a History Primary Key value, otherwise false.
	 */
	@JSExport
	public static boolean isHistoryPKey(long value) {
		return((value & MaskHistoryPKey) == IsHistoryPKey);
	}

	/**
	 *	Does this Oid indicate a History Data value?  Any value which isn't part of the history primary key must be data.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates History Data value, otherwise false.
	 */
	@JSExport
	public static boolean isHistoryData(long value) {
		return((value & MaskPKey) == 0x0);
	}

	public static final long RecordOid = 0x80;
	public static final long IsRecord = 0x80;
	public static final long MaskRecord = 0x80;

	/**
	 *	Does this Oid indicate a Record value? Records are essential to the operation of the code.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Record value, otherwise false.
	 */
	@JSExport
	public static boolean isRecord(long value) {
		return((value & MaskRecord) == IsRecord);
	}

	/**
	 *	Does this Oid indicate something other than a Record?  All values are either Records or they are not.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid does not indicate a Record value, otherwise false.
	 */
	@JSExport
	public static boolean isNotRecord(long value) {
		return((value & MaskRecord) == 0x0);
	}

	public static final long HistoryRecordOid = 0x100;
	public static final long IsHistoryRecord = 0x100;
	public static final long MaskHistoryRecord = 0x100;

	/**
	 *	Does this Oid indicate a History Record value? History Records are essential to the operation of the code.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a History Record value, otherwise false.
	 */
	@JSExport
	public static boolean isHistoryRecord(long value) {
		return((value & MaskHistoryRecord) == IsHistoryRecord);
	}

	/**
	 *	Does this Oid indicate something other than a History Record?  All values are either History Records or they are not.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid does not indicate a History Record value, otherwise false.
	 */
	@JSExport
	public static boolean isNotHistoryRecord(long value) {
		return((value & MaskHistoryRecord) == 0x0);
	}

	public static final long KeyOid = 0x200;
	public static final long IsKey = 0x200;
	public static final long MaskKey = 0x200;

	/**
	 *	Does this Oid indicate a Key value? Key values are imporant for improving the performance of code.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Key value, otherwise false.
	 */
	@JSExport
	public static boolean isKey(long value) {
		return((value & MaskKey) == IsKey);
	}

	/**
	 *	Does this Oid indicate a non-Key value?  Any value is either part of a key or it is not.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a non-Key value, otherwise false.
	 */
	@JSExport
	public static boolean isNotKey(long value) {
		return((value & MaskKey) == 0x0);
	}

	public static final long HistoryKeyOid = 0x400;
	public static final long IsHistoryKey = 0x400;
	public static final long MaskHistoryKey = 0x400;

	/**
	 *	Does this Oid indicate a History Key value? Key values are imporant for improving the performance of code.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a History Key value, otherwise false.
	 */
	@JSExport
	public static boolean isHistoryKey(long value) {
		return((value & MaskHistoryKey) == IsHistoryKey);
	}

	/**
	 *	Does this Oid indicate a non-History Key value?  Any value is either part of a history key or it is not.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a non-Key value, otherwise false.
	 */
	@JSExport
	public static boolean isNotHistoryKey(long value) {
		return((value & MaskHistoryKey) == 0x0);
	}

	public static final long SentOid = 0x800;
	public static final long IsSentObject = 0x800;
	public static final long MaskSentObject = 0x800;

	/**
	 *	Does this Oid indicate a Sent value? All communications are presumed to be bi-directional with a response received for every request sent.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Sent value, otherwise false.
	 */
	@JSExport
	public static boolean wasSent(long value) {
		return((value & MaskSentObject) == IsSentObject);
	}

	/**
	 *	Does this Oid indicate a Received value?  The fact that a value wasn't sent does not mean it was received; it could have come from data or some input stream.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Received value, otherwise false.
	 */
	@JSExport
	public static boolean wasReceived(long value) {
		return((value & MaskSentObject) == 0x0);
	}

	public static final long VisibleOid = 0x1000;
	public static final long IsVisible = 0x1000;
	public static final long MaskVisible = 0x1000;

	/**
	 *	Does this Oid indicate a Visible value? Visible values can be presented to the user, though user preferences might hide the value.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates a Visible value, otherwise false.
	 */
	@JSExport
	public static boolean isVisbile(long value) {
		return((value & MaskVisible) == IsVisible);
	}

	/**
	 *	Does this Oid indicate an Invisible value? Invisible values should never appear to the user except in error messages.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates an Invisible value, otherwise false.
	 */
	@JSExport
	public static boolean isInvisble(long value) {
		return((value & MaskVisible) == 0x0);
	}

	public static final long InstanceOid = 0x2000;
	public static final long IsInstance = 0x2000;
	public static final long MaskInstance = 0x2000;

	/**
	 *	Does this Oid indicate an Instance value? Instance values are usually from a data object or buffer.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates an Instance value, otherwise false.
	 */
	@JSExport
	public static boolean isInstance(long value) {
		return((value & MaskInstance) == IsInstance);
	}

	/**
	 *	Does this Oid indicate an Array value? All values are either instances or arrays of instances.
	 *
	 *	@param value
	 *
	 *	@return True if the Oid indicates an Array value, otherwise false.
	 */
	@JSExport
	public static boolean isArray(long value) {
		return((value & MaskInstance) == 0x0);
	}

	public final static long MtReferenceBaseOid = 0xb4000;
	public final static long AnyObjOid = 0x4000;

		public final static long LibEntryOid = 0xb8000;
	public final static long LibEntryOid = 0xb8000;
	public final static long BlobOid = 0x8000;
	public final static long BooleanOid = 0xb000;
	public final static long CharOid = 0x10000;
	public final static long UTF8CharOid = 0x14000;
	public final static long Int8Oid = 0x18000;
	public final static long Int16Oid = 0x1b000;
	public final static long Int32Oid = 0x20000;
	public final static long Int64Oid = 0x24000;
	public final static long ByteOid = YCFInt8Oid;
	public final static long ShortOid = YCFInt16Oid;
	public final static long IntegerOid = YCFInt32Oid;
	public final static long LongOid = YCFInt64Oid;
	public final static long FloatOid = 0x80000;
	public final static long DoubleOid = 0xb0000;
	public final static long NumberOid = 0x34000;
	public final static long DateOid = 0x38000;
	public final static long TimeOid = 0x3b000;
	public final static long DateTimeOid = 0x40000;
	public final static long TZDateOid = 0x48000;
	public final static long TZTimeOid = 0x4b000;
	public final static long TZDateTimeOid = 0x50000;
	public final static long StringOid = 0x54000;
	public final static long VStringOid = 0x58000;
	public final static long TokenOid = 0x5b000;
	public final static long VTokenOid = 0x60000;
	public final static long NmTokenOid = 0x64000;
	public final static long VNmTokenOid = 0x68000;
	public final static long TokensOid = 0x6b000;
	public final static long VTokensOid = 0x74000;
	public final static long NmTokensOid = 0x78000;
	public final static long VNmTokensOid = 0x7b000;
	public final static long KeyHash128Oid = 0x80000;
	public final static long KeyHash160Oid = 0x84000;
	public final static long KeyHash224Oid = 0x88000;
	public final static long KeyHash256Oid = 0x8b000;
	public final static long KeyHash384Oid = 0x90000;
	public final static long KeyHash512Oid = 0x94000;
	public final static long EnumOid = 0x98000;
	public final static long Id8Oid = 0x9b000;
	public final static long Id16Oid = 0xa0000;
	public final static long Id32Oid = 0xa4000;
	public final static long Id64Oid = 0xa8000;
	public final static long UInt8Oid = 0x8b000;
	public final static long UInt16Oid = 0x90000;
	public final static long UInt32Oid = 0x94000;
	public final static long UInt64Oid = 0x98000;
	public final static long UuidOid = 0x9b000;
	public final static long Uuid6Oid = 0xa0000;
	public final static long ArrayOid = 0xa4000;
	public final static long VArrayOid = 0xa48000;
}
