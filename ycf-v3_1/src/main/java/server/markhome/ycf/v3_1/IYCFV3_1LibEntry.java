/**
 *	server.markhome.ycf-v3_1 - Mark's Code Fractal Version 3.1 Services
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

package server.markhome.ycf.v3_1;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.util.*;

import java.util.concurrent.atomic.AtomicReference;

/**
 *	The YCF V3_1 LibEntry binds the package information used for resolving and loading the implementation code and data definitions for Version 3.1 of Yorkton Code Fractal.  The library entries have an Oid of 0 to ensure that they get loaded before any other definitions during application initialization.  All other Oids eventually find themselves defined by this initial bootstrap Oid.
 */
public final interface IYCFV3_1LibEntry extends JSObject {

	/**
	 *	The OID of the interface.
	 */
	@JSExport
	public final static int YCFV3_1LibEntryOid = YCFLastOid + YCFIncOidBy;

	/**
	 *	The public resource name for the parent library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_NAME = "server.markhome";</tt>
	 */
	public static final String YCF_LIB_PARENT_NAME = "server.markhome.ycf";

	/**
	 *	The parent resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260930";</tt>
	 */
	public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260930";

	/**
	 *	The public resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_NAME = IYCF_LIB_PARENT_NAME + ".v3_1";</tt>
	 */
	public static final String YCF_LIB_NAME = IYCF_LIB_PARENT_NAME + ".v3_1";

	/**
	 *	The public version string for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_VERSION = YCF_LIB_PARENT_VERSION;</tt>
	 */
	public static final String YCF_LIB_VERSION = YCF_LIB_PARENT_VERSION;

	/**
	 *	Implementations must be a singleton, returning the same instance over and over after initialization. How this is achieved may vary.
	 *
	 *	<tt>protected final static singleton = new AtomicReference<IYCFLibEntry>(null);</tt>
	 */
	protected final static AtomicReference<IYCFV3_1LibEntry> singleton = new AtomicReference<IYCFV3_1LibEntry>(null);

	/**
	 *	Default constructor is public.
	 *
	 *	<tt>public IYCFV3_1LibEntry { }</tt>
	 *	<tt>public static IYCFV3_1LibEntry getInstance { return new YCFV3_1LibEntry(); }</tt>
	 */
	@JSExport
	public static IYCFV3_1LibEntry getInstance() { return new YCFV3_1LibEntry(); }

	/**
	 *	Get the singleton.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public final static IYCFV3_1LibEntry getSingleton()</tt>
	 *
	 *	@return Return the library singleton. Always returns the same instance after the first invocation unless reset(true) is invoked.
	 */
	@JSExport
	public static IYCFV3_1LibEntry getSingleton() {
		IYCFV3_1LibEntry retval = singleton.get();
		if( retval == null ) {
			retval = new IYCFV3_1LibEntry();
			singleton.compareAndSet(null, retval);
			retval = singleton.get();
		}
		return(retval);
	}

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public static boolean execIYCFV3_1LibEntryLibReset(boolean yesReally)</tt>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public static boolean execLibReset(boolean yesReally) {
		IYCFV3_1LibEntry sgl = singleton.get();
		boolean retval;
		if (sgl == null || yesReally) {
			retval = false;

			if (yesReally && sgl != null) {
				singleton.compareAndSet(sgl, null);
			}

			sgl = getIYCFV3_1LibEntrySingleton();
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
	public static boolean resetLib(boolean yesReally) { return execIYCFLibEntryLibReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@return	True if the value was reset, false if the singleton was already initialized.
	 */
	@JSExport
	public static boolean resetLib() { return(resetLib(false)); }

	/**
	 *	Get the parent's public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The parent's public resource name used for named resource resolution.
	 */
	@JSExport
	public static String getParentLibName() { return(YCF_LIB_PARENT_NAME); }

	/**
	 *	Get the parent's public version string for this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The version string for this package's parent library or package used for public naming resolution.
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
	 *	Get the public version string for this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The version string for this library or package used for public naming resolution.
	 */
	@JSExport
	public static String getLibVersion() { return(YCF_LIB_VERSION); }

	/**
	 *	The default main does nothing.
	 *
	 *	<tt>public static void main(int argc, String[] argv) { return 0; }</tt>
	 */
	@JSExport
	public static void main(int argc, String[] argv) { }

	/**
	 *	The default main does nothing.
	 *
	 *	<tt>public static void main(String[] argv) { main(argv.length, argv); }</tt>
	 */
	@JSExport
	public static void main(String[] argv) { main(argv.length, argv); }
}
