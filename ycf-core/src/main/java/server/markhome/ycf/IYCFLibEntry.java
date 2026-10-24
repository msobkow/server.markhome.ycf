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

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFLibEntry extends IYCFAnyObj {

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
	public static IYCFLibEntry getService() {
		IYCFLibEntry ref = ((IYCFLibEntry)(singleton.get()));
		if (ref == null) {
			ref = new YCFLibEntry();
			singleton.set(null, ref);
			ref = ((IYCFLibEntry)(singleton.get()));
		}
		return(ref);
	}

	/**
	 *	The public resource name for the parent library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<i>public static final String YCF_LIB_PARENT_NAME = "server.markhome";</i>
	 */
	public static final String YCF_LIB_PARENT_NAME = "server.markhome";

	/**
	 *	The parent resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<i>public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260918";</i>
	 */
	public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260918";

	/**
	 *	The public resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<i>public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".ycf";</i>
	 */
	public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".ycf";

	/**
	 *	The public version string for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<i>public static final String YCF_LIB_VERSION = YCF_LIB_PARENT_VERSION;</i>
	 */
	public static final String YCF_LIB_VERSION = YCF_LIB_PARENT_VERSION;

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<i>public static boolean execIYCFLibEntryLibReset(boolean yesReally)</i>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public static boolean libReset(boolean yesReally) {
		IYCFLibEntry sgl = singleton.get();
		boolean retval;
		if (sgl == null || yesReally) {
			retval = false;

			if (yesReally && sgl != null) {
				singleton.set(sgl, null);
			}

			sgl = getService();
			assert sgl != null: "Singleton must not be null after initialization";

			retval = true;
		}
		else {
			retval = false;
		}
		return (retval);
	}

	/**
	 *	Reset the singleton and any other data caches after an application reload or other package or executable reloading event.
	 *
	 *	Invokes libReset(false) under the hood.
	 *
	 *	@return True if the library was reinitialized, false if the code detected that the library has not been used since the last reinitialization.
	 */
	@JSExport
	public static boolean libReset() { return libReset(false); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 *
	 *	@return	True if the singleton was reset, false if the singleton was set and yesReally was false.
	 */
	@JSExport
	public static boolean resetLib(boolean yesReally) { return libReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@return	True if the value was reset, false if the singleton was already initialized.
	 */
	@JSExport
	public static boolean resetLib() { return(libReset(false)); }

	/**
	 *	Get the parent's public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The parent's public resource name used for named resource resolution.
	 */
	@JSExport
	public static String getParentLibName() { return(YCF_LIB_PARENT_NAME); }

	/**
	 *	Get name public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getParentLibVersion() { return(YCF_LIB_PARENT_VERSION); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getLibName() { return(YCF_LIB_NAME); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getLibVersion() { return(YCF_LIB_VERSION); }

	/**
	 *	The default main does nothing.
	 *
	 *	<i>public static void main(int argc, String[] argv) { return 0; }</i>
	 */
	@JSExport
	public static void main(int argc, String[] argv) { }

	/**
	 *	The default main does nothing.
	 *
	 *	<i>public static void main(String[] argv) { main(argv.length, argv); }</i>
	 */
	@JSExport
	public static void main(String[] argv) { main(argv.length, argv); }
}
