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

/**
 *	IYCFFireOnInstanceOf Fires when an instance of the class specified at construction is detected by the <tt>onInstanceOf(value)</tt> method.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFFireOnInstanceOf extends IYCFAnyObj {

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<YCFFireOnInstanceOf> singleton = IYCFMtReference<YCFFireOnInstanceOf>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static YCFFireOnInstanceOf getService() {
		YCFFireOnInstanceOf ref = singleton.get();
		if (ref == null) {
			ref = new YCFFireOnInstanceOf();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	IYCFFireOnInstanceOf YCFFireOnInstanceOf_getInstance()
	 *		Get an instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFFireOnInstanceOf An instance for the implementation.
	 */
	@JSExport
	public static IYCFFireOnInstanceOf YCFFireOnInstanceOf_getInstance();

	/**
	 *	IYCFFireOnInstanceOf getInstance()
	 *		Get an instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFFireOnInstanceOf An instance for the implementation.
	 */
	@JSExport
	public IYCFFireOnInstanceOf getInstance();

	/**
	 *	void YCFFireOnInstanceOf_setInstanceOf(Class<?> value)
	 *		Set a class template for the kind of instances to detect for firing.
	 *
	 *	@param Class<?> value Fire when an instance of the class is detected.
	 */
	@JSExport
	public static void YCFFireOnInstanceOf_setInstanceOf(IYCFFireOnInstanceOf jthis, Class<?> value);

	/**
	 *	void setInstanceOf(Class<?> value)
	 *		Set a class template for the kind of instances to detect for firing.
	 *
	 *	@param Class<?> value Fire when an instance of the class is detected.
	 */
	@JSExport
	public void setInstanceOf(Class<?> value);

	/**
	 *	Class<?> YCFFireOnInstanceOf_getInstanceOf()
	 *		Get the class template for the kind of instances to detect for firing.
	 *
	 *	@return Class<?> value Fire when an instance of the class is detected.
	 */
	@JSExport
	public static Class<?> YCFFireOnInstanceOf_getInstanceOf(IYCFFireOnInstanceOf jthis);

	/**
	 *	Class<?> getInstanceOf()
	 *		Get the class template for the kind of instances to detect for firing.
	 *
	 *	@return Class<?> value Fire when an instance of the class is detected.
	 */
	@JSExport
	public Class<?> getInstanceOf();

	/**
	 *	boolean YCFFireOnInstanceOf_isInstanceOf()
	 *		Is the argument instance of the class associated with this firing entry?
	 *
	 *	@return True if the argument is an instance of the class associated with this firing entry, otherwise false.
	 */
	@JSExport
	public static boolean YCFFireOnInstanceOf_isInstanceOf(IYCFFireOnInstanceOf jthis, IYCFAnyObj obj);

	/**
	 *	boolean isInstanceOf()
	 *		Is the argument instance of the class associated with this firing entry?
	 *
	 *	@return True if the argument is an instance of the class associated with this firing entry, otherwise false.
	 */
	@JSExport
	public boolean isInstanceOf(IYCFAnyObj obj);

	/**
	 *	YCFFireOnInstanceOf_onInstanceOf(jthis, obj)
	 *		This method is invoked if the argument obj is an instance of the correct class and not null.
	 */
	@JSExport
	public static void YCFFireOnInstanceOf_onInstanceOf(IYCFFireOnInstanceOf jthis, IYCFAnyObj obj);

	/**
	 *	onInstanceOf(obj)
	 *		This method is invoked if the argument obj is an instance of the correct class and not null.
	 */
	@JSExport
	public void onInstanceOf(IYCFAnyObj obj);

	/**
	 *	YCFFireOnInstanceOf_fireOnInstanceOf(jthis, obj)
	 *		Invokes YCFFireOnInstanceOf_onInstanceOf(jthis, obj) if obj is an instance of the correct class and not null.
	 */
	@JSExport
	public static void YCFFireOnInstanceOf_onInstanceOf(IYCFFireOnInstanceOf jthis, IYCFAnyObj obj);

	/**
	 *	fireOnInstanceOf(obj)
	 *		Invokes YCFFireOnInstanceOf_onInstanceOf(jthis, obj) if obj is an instance of the correct class and not null.
	 */
	@JSExport
	public void onInstanceOf(IYCFAnyObj obj);
}
