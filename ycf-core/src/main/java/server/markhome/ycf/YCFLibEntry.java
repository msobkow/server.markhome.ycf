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

@JSExportClasses({IYCFLibEntry.class, YCFLibEntry.class })
public final class YCFLibEntry implements IYCFLibEntry {

	/**
	 *	The public resource name for the parent library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_NAME = "server.markhome";</tt>
	 */
	public static final String YCF_LIB_PARENT_NAME = "server.markhome";

	/**
	 *	The parent resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260918";</tt>
	 */
	public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260918";

	/**
	 *	The public resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".ycf";</tt>
	 */
	public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".ycf";

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
	 *	<tt>protected final static singleton = new AtomicReference<YCFLibEntry>(null);</tt>
	 */
	protected final static AtomicReference<YCFLibEntry> singleton = new AtomicReference<YCFLibEntry>(null);

	/**
	 *	Default constructor is protected so that only a singleton can be created.
	 *
	 *	<tt>protected YCFLibEntry { }</tt>
	 */
	@JSExport
	protected YCFLibEntry() { }

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
	public final static YCFLibEntry getYCFLibEntrySingleton() {
		YCFLibEntry retval = singleton.get();
		if( retval == null ) {
			retval = new YCFLibEntry();
			singleton.compareAndSet(null, retval);
			retval = singleton.get();
		}
		return(retval);
	}

	/**
	 *	Get an instance. Because this is a singleton, getInstance() always returns null, as it just invokes YCFLibEntry() under the hood.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "YCF" as appropriate.
	 *
	 *	<tt>public final static YCFLibEntry getYCFLibEntryInstance()</tt>
	 *
	 *	@return The instance, if any. Always returns null.
	 */
	@JSExport
	public static YCFLibEntry getYCFLibEntryInstance() { return(null); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "YCF" as appropriate.
	 *
	 *	<tt>public static boolean execYCFLibEntryYCFReset(boolean yesReally)</tt>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public static boolean execYCFLibEntryYCFReset(boolean yesReally) {
		YCFLibEntry sgl = singleton.get();
		boolean retval;
		if (sgl == null || yesReally) {
			retval = false;

			if (yesReally && sgl != null) {
				singleton.compareAndSet(sgl, null);
			}

			sgl = getYCFLibEntrySingleton();
			assert sgl != null: "Singleton must not be null after initialization";

			retval = true;
		}
		else {
			retval = false;
		}
		return (retval);
	}

	/**
	 *	Get an instance, if possible.  Invokes getYCFLibEntryInstance() under the hood.
	 *
	 *	@return Return an instance if dynamically allocated, otherwise null. Because this is a singleton, null will always be returned.
	 */
	@JSExport
	public YCFLibEntry getInstance() { return(getYCFLibEntryInstance()); }

	/**
	 *	Get the singleton instance, if any. Invokes getYCFLibEntrySingleton() under the hood.
	 *
	 *	@return Return the library singleton, if any. Always returns the same value after the first invocation unless reset(true) is invoked.
	 */
	@JSExport
	public YCFLibEntry getSingleton() { return(getYCFLibEntrySingleton()); }

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
	public boolean libReset(boolean yesReally) { return execYCFLibEntryYCFReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 *
	 *	@return	True if the singleton was reset, false if the singleton was set and yesReally was false.
	 */
	@JSExport
	public boolean resetYCF(boolean yesReally) { return execYCFLibEntryYCFReset(yesReally); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@return	True if the value was reset, false if the singleton was already initialized.
	 */
	@JSExport
	public boolean resetYCF() { return(resetYCF(false)); }

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
