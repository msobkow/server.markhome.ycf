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
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public class YCFMtReference<T extends IYCFAnyObj > implement IYCFMtReference<T> {

	/**
	 *	Get the value this instance currently references.
	 *
	 *	@return The currently referenced value.
	 */
	@JSProperty
	public T get() {
		return((T)(super.ref));
	}

	/**
	 *	Set the <i>value</i> this instance is to reference if the current value matches <i>expected</i>.
	 *
	 *	@param expected The value expected to be referenced if the value is to be changed.
	 *	@param value The value to be referenced in the future if the current value matches expected.
	 *
	 *	@return The value this instance references after attempting to change the value; it may be either the value passed in or a completely different reference, but it will only be <i>expected</i> iff <i>value</i> and <i>expected</i> are identical.
	 */
	@JSProperty
	public T set(T expected, T value) {
		if (super.ref == expected) {
			synchronized (this) {
				if (super.ref == expected) {
					super.ref = value;
				}
			}
		}
		return((T)(super.ref));
	}

	/**
	 *	Get the operating system user login name running the application process.
	 *
	 *	@return String Operating system user login name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public String getUserLogin() {
		if(get() != null) {
			return(get().getUserLogin());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the operating system group name running the application process.
	 *
	 *	@return String Operating system group name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public String getUserGroup() {
		if(get() != null) {
			return(get().getUserGroup());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the operating system host name running the application process.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public String getHostName() {
		if(get() != null) {
			return(get().getHostName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the operating system host IP address running the application process. Note that in the case of a load-balanced cluster, more than one physical host might be assigned the same host IP address for access by the load balancer, particularly in network environments managed by Cisco or equivalent hardware.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public long getHostIPAddr() {
		if(get() != null) {
			return(get().getHostIPAddr());
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Get the process id for this program.
	 *
	 *	@return long Process id
	 */
	@JSExport
	public long getProcessId() {
		if(get() != null) {
			return(get().getProcessId());
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Get the thread id currently executing this code.
	 *
	 *	@return long Thread id
	 */
	@JSExport
	public long getThreadId() {
		if(get() != null) {
			return(get().getThreadId());
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Get the cluster code for this process. The core server uses the system cluster table cluster code value so that it's internal keys will be consistent locally and publicly.  Clients connecting to the server are assigned a generated cluster code guaranteed to be unique in the cluster during runtime and to not be the system cluster code.  This ensures that each host node/program running in the clustered network is using a different cluster code so that it's generated KeyHash ids will truly be unique and distinct without further effort required by the application logic.  The application code relies on this feature to provide maximum throughput and performance of the data processing operations.
	 *
	 *	@return long Cluster code
	 */
	@JSExport
	public long getClusterCode() {
		if(get() != null) {
			return(get().getClusterCode());
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Get the cluster id that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's cluster id.
	 */
	@JSProperty
	public IYCFKeyHash256 getClusterId() {
		if(get() != null) {
			return(get().getClusterId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the node id that owns this piece of information resides.
	 *
	 *	@return IYCFKeyHash256 Data residence node id.
	 */
	@JSProperty
	public IYCFKeyHash256 getNodeId() {
		if(get() != null) {
			return(get().getNodeId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the tenant id that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's tenant id.
	 */
	@JSExport
	public IYCFKeyHash256 getTenantId() {
		if(get() != null) {
			return(get().getTenantId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the security group that applies to this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's group id.
	 */
	@JSExport
	public IYCFKeyHash256 getSecGroupId() {
		if(get() != null) {
			return(get().getSecGroupId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the id of the user that owns this piece of information.
	 *
	 *	@return IYCFKeyHash256 Owner's user id.
	 */
	@JSExport
	public IYCFKeyHash256 getUserId() {
		if(get() != null) {
			return(get().getUserId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current session id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public IYCFKeyHash256 getSessionId() {
		if(get() != null) {
			return(get().getSessionId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current transaction id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current transaction id.
	 */
	@JSExport
	public IYCFKeyHash256 getTxnId() {
		if(get() != null) {
			return(get().getTxnId());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current generation definition. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current generation defintion.
	 */
	@JSExport
	public IYCFAnyObj getGenDef() {
		if(get() != null) {
			return(get().getGenDef());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current scope generation definition . Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public IYCFAnyObj getScopeDef() {
		if(get() != null) {
			return(get().getScopeDef());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current object named objName from the current generation definition for the specified qualifyingClass as a starting point. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with the specified qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getNamedObject(Class<?> qualifyingClass, String objName) {
		if(get() != null) {
			return(get().getNamedObject());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current object named objName from the current generation definition making no presumptions about the qualifyingClass. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with an indeterminate qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getNamedObject(String objName) {
		if(get() != null) {
			return(get().getNamedObject());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the object qualifier for the specified qualifying class from the engine. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object qualifier for the specified qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getObjQualifier(Class<?> qualifyingClass) {
		if(get() != null) {
			return(get().getObjQualifier());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current login name for the operating system. Not expected to change between invocations, but might if this program spawns threads owned by different user ids.
	 *
	 *	@return String Current operating system user login name.
	 */
	@JSExport
	public String getLoginName() {
		if(get() != null) {
			return(get().getLoginName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current user name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current user name.
	 */
	@JSExport
	public String getUserName() {
		if(get() != null) {
			return(get().getUserName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current session name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current session name.
	 */
	@JSExport
	public String getSessionName() {
		if(get() != null) {
			return(get().getSessionName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the current transaction name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current transaction name.
	 */
	@JSExport
	public String getTxnName() {
		if(get() != null) {
			return(get().getTxnName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get current case-sensitive generation definition name.
	 *
	 *	@return String Current case-sensitive generation definition name.
	 */
	@JSExport
	public String getGenDefName() {
		if(get() != null) {
			return(get().getGenDefName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get current case-sensitive scoping generation definition name.
	 *
	 *	@return String Current case-sensitive scoping generation definition name.
	 */
	@JSExport
	public String getScopeGenDefName() {
		if(get() != null) {
			return(get().getScopeDefName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get current case-sensitive object name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object name.
	 */
	@JSExport
	public String getObjName() {
		if(get() != null) {
			return(get().getObjName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get current case-sensitive object qualified name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive qualified object name.
	 */
	@JSExport
	public String getObjQualifiedName() {
		if(get() != null) {
			return(get().getObjQualifiedName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get current case-sensitive object full name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object full name.
	 */
	@JSExport
	public String getObjFullName() {
		if(get() != null) {
			return(get().getObjFullName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the value this instance currently references.
	 *
	 *	@return The currently referenced value.
	 */
	@JSProperty
	public T get();

	/**
	 *	Set the <i>value</i> this instance is to reference if the current value matches <i>expected</i>.
	 *
	 *	@param expected The value expected to be referenced if the value is to be changed.
	 *	@param value The value to be referenced in the future if the current value matches expected.
	 *
	 *	@return The value this instance references after aiempting to change the value; it may be either the value passed in or a completely different reference, but it will only be <i>expected</i> iff <i>value</i> and <i>expected</i> are identical.
	 */
	@JSProperty
	public T set(T expected, T value);
}
