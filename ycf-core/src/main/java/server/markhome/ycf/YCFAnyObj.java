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
public class YCFAnyObj implements IYCFAnyObj {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference<YCFAnyObj> singleton = IYCFMtReference<YCFAnyObj>.getService().getInstance(null);

	/**
	 *	Get the service singleton that provides the getInstance() implementations.
	 *
	 *	@return The service singleton that provides the getInstance() implementations.
	 */
	@JSExport
	public static YCFAnyObj getService() {
		YCFAnyObj ref = singleton.get();
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
	public static YCFAnyObj getService(IYCFAnyObj initObj) {
		YCFAnyObj ref = singleton.get();
		if (ref == null) {
			ref = new YCFAnyObj(initObj);
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	Construct an instance that provides the service method implementations.
	 */
	@JSExport
	public YCFAnyObj() {
	}

	/**
	 *	Construct an instance that provides the service method implementations.
	 */
	@JSExport
	public YCFAnyObj(IYCFAnyObj initObj) {
	}
}