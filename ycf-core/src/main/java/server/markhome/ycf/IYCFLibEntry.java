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

public final interface IYCFLibEntry extends JSObject {

	/**
	 *	The OIDs of the interfaces and objects.
	 */
	@JSExport
	public final static int YCFFalseOidFlag = 0x0000;

	@JSExport
	public final static int YCFTrueOidFlag = 0x0001;

	@JSExport
	public final static int YCFNullOidFlag = 0x0000;

	@JSExport
	public final static int YCFNotNullOidFlag = 0x0002;

	@JSExport
	public final static int YCFSendOidFlag = 0x0000;

	@JSExport
	public final static int YCFReceiveOidFlag = 0x0004;

	@JSExport
	public final static int YCFInvisibleOidFlag = 0x0000;

	@JSExport
	public final static int YCFVisibleOidFlag = 0x0008;

	@JSExport
	public final static int YCFOptionalOidFlag = 0x0000;

	@JSExport
	public final static int YCFRequiredOidFlag = 0x0010;

	@JSExport
	public final static int YCFInstanceOidFlag = 0x0000;

	@JSExport
	public final static int YCFArrayOidFlag = 0x0020;

	@JSExport
	public final static int YCFVArrayOidFlag = 0x0040;

	@JSExport
	public final static int YCFJSObjectOid = 0x0080;

	@JSExport
	public final static int YCFIncOidBy = YCFJSObjectOid;

	@JSExport
	public final static int YCFBlobOid = 0x0100;

	@JSExport
	public final static int YCFBooleanOid = 0x0180;

	@JSExport
	public final static int YCFCharOid = 0x0200;

	@JSExport
	public final static int YCFUTF8CharOid = 0x0280;

	@JSExport
	public final static int YCFInt8Oid = 0x0300;

	@JSExport
	public final static int YCFInt16Oid = 0x0380;

	@JSExport
	public final static int YCFInt32Oid = 0x0400;

	@JSExport
	public final static int YCFInt64Oid = 0x0480;

	@JSExport
	public final static int YCFByteOid = YCFInt8Oid;

	@JSExport
	public final static int YCFShortOid = YCFInt16Oid;

	@JSExport
	public final static int YCFIntegerOid = YCFInt32Oid;

	@JSExport
	public final static int YCFLongOid = YCFInt64Oid;

	@JSExport
	public final static int YCFFloatOid = 0x0500;

	@JSExport
	public final static int YCFDoubleOid = 0x0580;

	@JSExport
	public final static int YCFNumberOid = 0x0600;

	@JSExport
	public final static int YCFDateOid = 0x0680;

	@JSExport
	public final static int YCFTimeOid = 0x0700;

	@JSExport
	public final static int YCFDateTimeOid = 0x0780;

	@JSExport
	public final static int YCFTZDateOid = 0x0800;

	@JSExport
	public final static int YCFTZTimeOid = 0x0880;

	@JSExport
	public final static int YCFTZDateTimeOid = 0x0900;

	@JSExport
	public final static int YCFStringOid = 0x0980;

	@JSExport
	public final static int YCFVStringOid = 0x0a00;

	@JSExport
	public final static int YCFTokenOid = 0x0a80;

	@JSExport
	public final static int YCFVTokenOid = 0x0b00;

	@JSExport
	public final static int YCFNmTokenOid = 0x0b80;

	@JSExport
	public final static int YCFVNmTokenOid = 0x0c00;

	@JSExport
	public final static int YCFTokensOid = 0x0c80;

	@JSExport
	public final static int YCFVTokensOid = 0x0d00;

	@JSExport
	public final static int YCFNmTokensOid = 0x0d80;

	@JSExport
	public final static int YCFVNmTokensOid = 0x0e00;

	@JSExport
	public final static int YCFKeyHash128Oid = 0x0e80;

	@JSExport
	public final static int YCFKeyHash160Oid = 0x0f00;

	@JSExport
	public final static int YCFKeyHash224Oid = 0x0f80;

	@JSExport
	public final static int YCFKeyHash256Oid = 0x1000;

	@JSExport
	public final static int YCFKeyHash384Oid = 0x1080;

	@JSExport
	public final static int YCFKeyHash512Oid = 0x1100;

	@JSExport
	public final static int YCFEnumOid = 0x1180;

	@JSExport
	public final static int YCFId8Oid = 0x1200;

	@JSExport
	public final static int YCFId16Oid = 0x1280;

	@JSExport
	public final static int YCFId32Oid = 0x1300;

	@JSExport
	public final static int YCFId64Oid = 0x1380;

	@JSExport
	public final static int YCFUInt8Oid = 0x1400;

	@JSExport
	public final static int YCFUInt16Oid = 0x1480;

	@JSExport
	public final static int YCFUInt32Oid = 0x1500;

	@JSExport
	public final static int YCFUInt64Oid = 0x1580;

	@JSExport
	public final static int YCFUuidOid = 0x1600;

	@JSExport
	public final static int YCFUuid6Oid = 0x1680;

	@JSExport
	public final static int YCFArrayOid = 0x1700;

	@JSExport
	public final static int YCFVArrayOid = 0x1780;

	@JSExport
	public final static int YCFLibEntryOid = 0x1800;

	@JSExport
	public final static int YCFLastOid = YCFLibEntryOid;

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
	public static final String YCF_LIB_NAME = IYCF_LIB_PARENT_NAME + ".ycf";

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
	protected final static AtomicReference<YCFLibEntry> singleton = new AtomicReference<IYCFLibEntry>(null);

	/**
	 *	Default constructor is protected so that only a singleton can be created.
	 *
	 *	<tt>public static IYCFLibEntry getInstance(){ }</tt>
	 */
	@JSExport
	public static IYCFLibEntry getInstance() { return(new YCFLibEntry()); }

	/**
	 *	Get the singleton.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public final static YCFLibEntry getIYCFLibEntrySingleton()</tt>
	 *
	 *	@return Return the library singleton. Always returns the same instance after the first invocation unless reset(true) is invoked.
	 */
	@JSExport
	public static IYCFLibEntry getSingleton() {
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
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public final static YCFLibEntry getIYCFLibEntryInstance()</tt>
	 *
	 *	@return The instance, if any. Always returns null.
	 */
	@JSExport
	public static IYCFLibEntry getInstance() { return(null); }

	/**
	 *	Reset the singleton and any data caches after an application reload or other package or executable reloading event.
	 *
	 *	Implementations should define a public static final method with the following signature, using the uppercase package name before "Lib" as appropriate.
	 *
	 *	<tt>public static boolean execIYCFLibEntryLibReset(boolean yesReally)</tt>
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
				singleton.compareAndSet(sgl, null);
			}

			sgl = getIYCFLibEntrySingleton();
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
