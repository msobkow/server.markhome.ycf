/**
 *	server.markhome.ycf-v3_1 - Yorkton Code Fractal Version 3.1 Services
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
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

@JSExportClasses({IYCFLibEntry.class, YCFLibEntry.class })
public final class YCFV3_1LibEntry implements IYCFV3_1LibEntry {

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
	 *	<tt>public static final String YCF_LIB_PARENT_VERSION = "20260930";</tt>
	 */
	public static final String YCF_LIB_PARENT_VERSION = "20260930";

	/**
	 *	The public resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".v3_1";</tt>
	 */
	public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".v3_1";

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
	 *	<tt>protected final static singleton = new AtomicReference<YCFV3_1LibEntry>(null);</tt>
	 */
	protected final static AtomicReference<YCFV3_1LibEntry> singleton = new AtomicReference<YCFV3_1LibEntry>(null);

	/**
	 *	Default constructor is protected so that only a singleton can be created.
	 *
	 *	<tt>protected YCFV3_1LibEntry { }</tt>
	 */
	@JSExport
	protected YCFV3_1LibEntry() { }

	/**
	 *	Get the singleton.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "YCF" as appropriate.
	 *
	 *	<tt>public final static YCFLibEntry getYCFLibEntrySingleton()</tt>
	 *
	 *	@return Return the library singleton. Always returns the same instance after the first invocation unless reset(true) is invoked.
	 */
	@JSExport
	public final static YCFV3_1LibEntry getYCFV3_1LibEntrySingleton() {
		YCFV3_1LibEntry retval = singleton.get();
		if( retval == null ) {
			retval = new YCFV3_1LibEntry();
			singleton.compareAndSet(null, retval);
			retval = singleton.get();
		}
		return(retval);
	}

	/**
	 *	Get an instance. Because this is a singleton, getInstance() always returns null, as it just invokes YCFV3_1LibEntry() under the hood.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "YCF" as appropriate.
	 *
	 *	<tt>public final static YCFV3_1LibEntry getYCFV3_1LibEntryInstance()</tt>
	 *
	 *	@return The instance, if any. Always returns null.
	 */
	@JSExport
	public static YCFV3_1LibEntry getYCFV3_1LibEntryInstance() { return(null); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "YCF" as appropriate.
	 *
	 *	<tt>public static boolean execYCFV3_1LibEntryYCFReset(boolean yesReally)</tt>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public static boolean execYCFV3_1LibEntryYCFReset(boolean yesReally) {
		YCFLibEntry sgl = singleton.get();
		boolean retval;
		if (sgl == null || yesReally) {
			retval = false;

			if (yesReally && sgl != null) {
				singleton.compareAndSet(sgl, null);
			}

			sgl = getYCFV3_1LibEntrySingleton();
			assert sgl != null: "Singleton must not be null after initialization";

			retval = true;
		}
		else {
			retval = false;
		}
		return (retval);
	}

	/**
	 *	Get an instance, if possible.  Invokes getYCFV3_1LibEntryInstance() under the hood.
	 *
	 *	@return Return an instance if dynamically allocated, otherwise null. Because this is a singleton, null will always be returned.
	 */
	@JSExport
	public YCFV3_1LibEntry getInstance() { return(getYCFV3_1LibEntryInstance()); }

	/**
	 *	Get the singleton instance, if any. Invokes getYCFV3_1LibEntrySingleton() under the hood.
	 *
	 *	@return Return the library singleton, if any. Always returns the same value after the first invocation unless reset(true) is invoked.
	 */
	@JSExport
	public YCFV3_1LibEntry getSingleton() { return(getYCFV3_1LibEntrySingleton()); }

	/**
	 *	Reset the singleton and any other data caches after an application reload or other package or executable reloading event.
	 *
	 *	Invokes libReset(false) under the hood.
	 *
	 *	@return True if the library was reinitialized, false if the code detected that the library has not been used since the last reinitialization.
	 */
	@JSExport
	public boolean libReset() { return libReset(false); }

	/**
	 *	Reset the singleton and any other data caches after an application reload or other package or executable reloading event.
	 *
	 *	Invokes execYCFLibEntryReset(false) under the hood.
	 *
	 *	@return True if the library was reinitialized, false if the code detected that the library has not been used since the last reinitialization.
	 */
	@JSExport
	public boolean libReset(boolean yesReally) { return execYCFV3_1LibEntryYCFReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 *
	 *	@return	True if the singleton was reset, false if the singleton was set and yesReally was false.
	 */
	@JSExport
	public boolean resetYCF(boolean yesReally) { return execYCFV3_1LibEntryYCFReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@return	True if the value was reset, false if the singleton was already initialized.
	 */
	@JSExport
	public boolean resetYCF() { return(resetYCFV3_1(false)); }

	/**
	 *	Get the parent's public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The parent's public resource name used for named resource resolution.
	 */
	@JSExport
	public String getParentYCFName() { return(YCF_LIB_PARENT_NAME); }

	/**
	 *	Get name public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public String getParentYCFVersion() { return(YCF_LIB_PARENT_VERSION); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public String getYCFName() { return(YCF_LIB_NAME); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public String getYCFVersion() { return(YCF_LIB_VERSION); }

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
