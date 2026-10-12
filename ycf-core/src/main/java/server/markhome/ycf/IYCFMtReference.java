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
public interface IYCFMtReference extends JSObject {

	protected final static IYCFMtReference<IYCFMtReference> singleton = IYCFMtReference<IYCFMtRefence>.getSingleton().getInstance(null);

	/**
	 *	IYCFMtReference getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate for the method name.
	 *
	 *	<tt>public final static IYCFMtReference getYCFMtReferenceSingleton()</tt>
	 *
	 *	@return The singleton instance that provides the getInstance() and service method implementations.
	 */
	@JSExport
	public IYCFMtReference getSingleton() {
		return(YCFMtReference_getSingleton());
	}

	/**
	 *	public static IYCFMtReference YCFMtReference_getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate for the method name.
	 *
	 *	<tt>public final static IYCFMtReference singleton = YCFMtReference_getSingleton().getInstance(null);</tt>
	 *
	 *	@return The singleton instance that provides the getInstance() and service method implementations.
	 */
	@JSExport
	public static IYCFMtReference YCFMtReference_getSingleton() {
		IYCFMtRefernce sgl = singleton.get();
		if(sgl == null) {
			sgl = new YCFMtReference(null);
			singleton.set(null, sgl);
			sgl = singleton.get();
		}
		return(sgl);
	}

	/**
	 *	Get the Oid for YCFMtReferences.
	 *
	 *	@return Oid for YCFMtReferences
	 */
	@JSExport
	public int getOid() {
		return(YCFMtReference_getOid());
	}

	/**
	 *	Get the Oid for YCFMtReferences.
	 *
	 *	@return Oid for YCFMtReferences
	 */
	@JSExport
	public final static int YCFMtReference_getOid(){
		return(IYCFLibEntry.YCFMtReferenceOid);
	}

	/**
	 *	The public resource name for the parent library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_NAME = "server.markhome";</tt>
	 */
	public static final String YCF_LIB_PARENT_NAME = IYCFLibEntry.getParentLibName();

	/**
	 *	The parent resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_PARENT_VERSION = "3.1.42-20260918";</tt>
	 */
	public static final String YCF_LIB_PARENT_VERSION = IYCFLibEntry.getParentLibVersion();

	/**
	 *	The public resource name for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_NAME = YCF_LIB_PARENT_NAME + ".ycf";</tt>
	 */
	public static final String YCF_LIB_NAME = IYCF_LIB_PARENT_NAME + IYCFLibEntry.getLibName();

	/**
	 *	The public version string for this library.
	 *
	 *	Implementations should define a public static final constant string prefixed by the uppercase library name matching the following signature:
	 *
	 *	<tt>public static final String YCF_LIB_VERSION = YCF_LIB_PARENT_VERSION;</tt>
	 */
	public static final String YCF_LIB_VERSION = IYCFEntry.getLibVersion();

	/**
	 *	Implementations must be a singleton, returning the same instance over and over after initialization. How this is achieved may vary.
	 *
	 *	<tt>protected final static singleton = IYCFMtReference<IYCFMtReference>.getSingleton().getInstance(null);</tt>
	 */
	protected final static IYCFMtReference<IYCFMtReference> singleton = IYCFMtReference<IYCFMtReference>.getSingleton().getInstance(null);

	/**
	 *	Default constructor is protected so that only a singleton can be created.
	 *
	 *	<tt>public static IYCFMtReference getInstance(Class<?> clazz){ }</tt>
	 */
	@JSExport
	public IYCFMtReference<?> getInstance(Class<?> clazz) { return(IYCFMtReference<clazz>.getSingleton().getInstance(null)); }

	/**
	 *	Get an instance. Because this is a singleton, getInstance() always returns null, as it just invokes YCFMtReference() under the hood.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public final static YCFMtReference getIYCFMtReferenceInstance()</tt>
	 *
	 *	@return The instance, if any. Always returns null.
	 */
	@JSExport
	public static IYCFMtReference<?> getInstance(Class<?> clazz) { new YCFMtReference<clazz>.getClass()(); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public static boolean execIYCFMtReferenceLibReset(boolean yesReally)</tt>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public boolean libReset(boolean yesReally) {

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public static boolean execIYCFMtReferenceLibReset(boolean yesReally)</tt>
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 */
	@JSExport
	public static boolean YCFMtReference.libReset(boolean yesReally) {
		IYCFMtReference sgl = singleton.get();
		boolean retval;
		if (sgl == null || yesReally) {
			retval = false;

			if (yesReally && sgl != null) {
				singleton.compareAndSet(sgl, null);
			}

			sgl = getIYCFMtReferenceSingleton();
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
	public static boolean YCFMtReference.libReset() { return(libReset(false)); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@param	yesReally Are you sure you want to reset the value?
	 *
	 *	@return	True if the singleton was reset, false if the singleton was set and yesReally was false.
	 */
	@JSExport
	public static boolean YCFMtReference.resetLib(boolean yesReally) { return(YCFMtReference.libReset(yesReally)); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	@return	True if the value was reset, false if the singleton was already initialized.
	 */
	@JSExport
	public static boolean YCFMtReference.resetLib() { return(YCFMtReference.libReset(false)); }

	/**
	 *	Get the parent's public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The parent's public resource name used for named resource resolution.
	 */
	@JSExport
	public static String getParentLibName() { return(IYCFMtReference.YCF_LIB_PARENT_NAME); }

	/**
	 *	Get name public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getParentLibVersion() { return(IYCFMtReference.YCF_LIB_PARENT_VERSION); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getLibName() { return(IYCFMtReference.YCF_LIB_NAME); }

	/**
	 *	Get the public resource name of this library or package, used in searches to resolve the package for runtimes or compilation and test.
	 *
	 *	@return The name of this package used for public naming resolution.
	 */
	@JSExport
	public static String getLibVersion() { return(IYCFMtReference.YCF_LIB_VERSION); }

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
