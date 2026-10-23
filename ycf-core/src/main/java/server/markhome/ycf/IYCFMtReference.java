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
 *	The IYCFMtReference interface is a rich specification of all the system-level interfaces expected at runtime by the system which are available at various times during processing. All of the methods can theoretically return null at certain points during normal system operations, so be careful in your code to allow for that.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFMtReference<T> extends IYCFMtReferenceBase {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference<IYCFMtReference> singleton = IYCFMtReference<>.getService().getInstance(null);

	/**
	 *	Get the service singleton that provides the getInstance() implementations.
	 *
	 *	@return The service singleton that provides the getInstance() implementations.
	 */
	@JSExport
	public static IYCFMtReference getService() {
		IYCFMtReference myref = singleton.get();
		if (myref == null) {
			myref = new YCFMtReference();
			myref = singleton.set(null, myref);
		}
		return(myref);
	}

	/**
	 *	Get the service singleton that provides the getInstance() implementations specifying the initial service provider to use if the singleton has to be constructed.
	 *
	 *	@return The service singleton that provides the getInstance() implementations specifying the initial service provider to use if the singleton has to be constructed.
	 */
	@JSExport
	public static IYCFMtReference getService(IYCFMtReference initObj) {
		IYCFMtReference myref = singleton.get();
		if (myref == null) {
			myref = new YCFMtReference(initObj);
			myref = singleton.set(null, myref);
		}
		return(myref);
	}

	/**
	 *	The LibEntry object for a package always defines the OIDs for the package.
	 */
	public static final int YCFMTREFERENCE_OID = MyReferenceOid;

	/**
	 *	Get the Oid value that implementations return to identify their class.  Note that you cannot count on an interface always returning the same Oid; only concrete implementations will return the same Oid values. Oids are unique in the runtime; one per instantiable class and a minimum of one per interface.
	 *
	 *	@return Oid value implementations return to identify their class.
	 */
	@JSExport
	public static int getOid() {
		return(YCFMTREFERENCE_OID);
	}

	/**
	 *	Get an instance that provides the service method implementations.
	 *
	 *	@return An instance that provides the service method implementations.
	 */
	@JSExport
	public static IYCFMtReference getInstance() {
		return(new YCFMtReference());
	}

	/**
	 *	Get an instance that provides the service method implementations specifying the initial instance to be referenced.
	 *
	 *	@param initObj The object to use to copy from or reference from the newly created instance.
	 *
	 *	@return The Any instance that provides the service method implementations.
	 */
	 @JSExport
	 public static IYCFMtReference getInstance(IYCFMtReference initObj) {
		return(new YCFMtReference(initObj));
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
	 *	@return The value this instance references after attempting to change the value; it may be either the value passed in or a completely different reference, but it will only be <i>expected</i> iff <i>value</i> and <i>expected</i> are identical.
	 */
	@JSProperty
	public T set(T expected, T value);
}
