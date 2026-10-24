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

import server.markhome.ycf.IYCFFireOnInstanceOf;

/**
 *	Get a list of instance classes that should be fired upon when detected.  The list is evaluated in the order that entries were added, so be careful to add sub-class entries before their superclass entry.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFFiringList extends IYCFAnyObj {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference singleton = IYCFMtReference.getService().getInstance();

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IYCFFiringList getService() {
		IYCFFiringList ref = ((IYCFFiringList)(singleton.get()));
		if (ref == null) {
			ref = new YCFFiringList();
			singleton.set(null, ref);
			ref = ((IYCFFiringList)(singleton.get()));
		}
		return(ref);
	}

	/**
	 *	IYCFFiringList getInstance()
	 *		Get an instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFFiringList An instance implementing the interface.
	 */
	@JSExport
	public static IYCFFiringList YCFFiringList_getInstance();

	/**
	 *	IYCFFiringList getInstance()
	 *		Get an instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFFiringList An instance implementing the interface.
	 */
	@JSExport
	public IYCFFiringList getInstance();

	/**
	 *	fireOnInstanceOf(obj)
	 *		Fire the obj trigger when obj matches their pattern.  Needs to be overloaded by application implementations.
	 */
	@JSExport
	public static void YCFFiringList_fireOnInstanceOf(IYCFFiringList jthis, IYCFAnyObj obj);

	/**
	 *	fireOnInstanceOf(obj)
	 *		Fire list of triggers when obj matches their pattern.  Needs to be overloaded by application implementations.
	 *
	 *	@param obj The object to check for a matching class and fire upon when a match occurs.
	 */
	@JSExport
	public void fireOnInstanceOf(IYCFAnyObj obj);

	/**
	 *	Get the firing item registered for the specified class from this list, if any.
	 *
	 *	@param jthis Reference to the instance to be evaluated.
	 *	@param clazz The class to be scanned for.
	 *
	 *	@return IYCFFireOnInstanceOf The firing instance registed for the class if any, null otherwise.
	 */
	@JSExport
	public static IYCFFireOnInstanceOf YCFFiringList_find(IYCFFiringList jthis, Class<?> clazz);

	/**
	 *	Get the firing item registered for the specified class from this list, if any.
	 *
	 *	@param clazz The class to be scanned for.
	 *
	 *	@return IYCFFireOnInstanceOf The firing instance registed for the class if any, null otherwise.
	 */
	@JSExport
	public IYCFFireOnInstanceOf find(Class<?> clazz);

	/**
	 *	Add a firing item to be registered for the specified class to this list, if the class is not already present.
	 *
	 *	@param jthis Reference to the instance to be evaluated.
	 *	@param clazz The class to be scanned for.
	 *	@param value The firing item to trigger.
	 *
	 *	@return IYCFFireOnInstanceOf The firing instance previously registed for the class if any, otherwise value.
	 */
	@JSExport
	public static IYCFFireOnInstanceOf YCFFiringList_add(IYCFFiringList jthis, Class<?> clazz, IYCFFireOnInstanceOf value);

	/**
	 *	Add a firing item to be registered for the specified class to this list, if the class is not already present.
	 *
	 *	@param clazz The class to be scanned for.
	 *	@param value The firing item to trigger.
	 *
	 *	@return IYCFFireOnInstanceOf The firing instance previously registed for the class if any, otherwise value.
	 */
	@JSExport
	public IYCFFireOnInstanceOf add(Class<?> clazz, IYCFFireOnInstanceOf value);
}
