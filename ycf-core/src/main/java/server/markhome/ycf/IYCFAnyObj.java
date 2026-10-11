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
	 *	Get the operating system user login name running the application process.
	 *
	 *	@return String Operating system user login name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public String getUserLogin();

	/**
	 *	Get the operating system group name running the application process.
	 *
	 *	@return String Operating system group name running the application process, treated as case-sensitive by the application code.
	 */
	@JSExport
	public String getUserGroup();

	/**
	 *	Get the operating system host name running the application process.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public String getHostName();

	/**
	 *	Get the operating system host IP address running the application process. Note that in the case of a load-balanced cluster, more than one physical host might be assigned the same host IP address for access by the load balancer, particularly in network environments managed by Cisco or equivalent hardware.
	 *
	 *	@return String Operating system host name running the application process, treated as case-insensitive and coerced to lowercase by the application code.
	 */
	@JSExport
	public long getHostIPAddr();

	/**
	 *	Get the process id for this program.
	 *
	 *	@return long Process id
	 */
	@JSExport
	public long getProcessId();

	/**
	 *	Get the thread id currently executing this code.
	 *
	 *	@return long Thread id
	 */
	@JSExport
	public long getThreadId();

	/**
	 *	Get the cluster code for this process. The core server uses the system cluster table cluster code value so that it's internal keys will be consistent locally and publicly.  Clients connecting to the server are assigned a generated cluster code guaranteed to be unique in the cluster during runtime and to not be the system cluster code.  This ensures that each host node/program running in the clustered network is using a different cluster code so that it's generated KeyHash ids will truly be unique and distinct without further effort required by the application logic.  The application code relies on this feature to provide maximum throughput and performance of the data processing operations.
	 *
	 *	@return long Cluster code
	 */
	@JSExport
	public long getClusterCode();

	/**
	 *	Get the current runtime cluster id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current runtime cluster id.
	 */
	@JSExport
	public IYCFKeyHash256 getClusterId();

	/**
	 *	Get the current runtime tenant id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current runtime tenant id.
	 */
	@JSExport
	public IYCFKeyHash256 getTenantId();

	/**
	 *	Get the default security group in effect for this current dataset. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current runtime security group id.
	 */
	@JSExport
	public IYCFKeyHash256 getSecGroupId();

	/**
	 *	Get the current user id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current user id.
	 */
	@JSExport
	public IYCFKeyHash256 getUserId();

	/**
	 *	Get the current session id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public IYCFKeyHash256 getSessionId();

	/**
	 *	Get the current transaction id. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current transaction id.
	 */
	@JSExport
	public IYCFKeyHash256 getTxnId();

	/**
	 *	Get the current generation definition. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current generation defintion.
	 */
	@JSExport
	public IYCFAnyObj getGenDef();

	/**
	 *	Get the current scope generation definition . Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current session id.
	 */
	@JSExport
	public IYCFAnyObj getScopeDef();

	/**
	 *	Get the current object named objName from the current generation definition for the specified qualifyingClass as a starting point. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with the specified qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getNamedObject( Class<?> qualifyingClass, String objName );

	/**
	 *	Get the current object named objName from the current generation definition making no presumptions about the qualifyingClass. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object named objName with an indeterminate qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getNamedObject( String objName );

	/**
	 *	Get the object qualifier for the specified qualifying class from the engine. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return IYCFKeyHash256 Current object qualifier for the specified qualifyingClass.
	 */
	@JSExport
	public IYCFAnyObj getObjQualifier( Class<?> qualifyingClass );

	/**
	 *	Get the current login name for the operating system. Not expected to change between invocations, but might if this program spawns threads owned by different user ids.
	 *
	 *	@return String Current operating system user login name.
	 */
	@JSExport
	public String getLoginName();

	/**
	 *	Get the current user name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current user name.
	 */
	@JSExport
	public String getUserName();

	/**
	 *	Get the current session name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current session name.
	 */
	@JSExport
	public String getSessionName();

	/**
	 *	Get the current transaction name. Will change between invocations as the threads of this process bind to different data sets.
	 *
	 *	@return String Current transaction name.
	 */
	@JSExport
	public String getTxnName();

	/**
	 *	Get current case-sensitive generation definition name.
	 *
	 *	@return String Current case-sensitive generation definition name.
	 */
	@JSExport
	public String getGenDefName();

	/**
	 *	Get current case-sensitive scoping generation definition name.
	 *
	 *	@return String Current case-sensitive scoping generation definition name.
	 */
	@JSExport
	public String getScopeGenDefName();

	/**
	 *	Get current case-sensitive object name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object name.
	 */
	@JSExport
	public String getObjName();

	/**
	 *	Get current case-sensitive object qualified name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive qualified object name.
	 */
	@JSExport
	public String getObjQualifiedName();

	/**
	 *	Get current case-sensitive object full name, which might be different than the gen def name, which only defines the data being processed.
	 *
	 *	@return String Current case-sensitive object full name.
	 */
	@JSExport
	public String getObjFullName();
}
