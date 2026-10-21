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
 * IYCFReqKeyHash128 extends IYCFKeyHash128 with the appropriate behavior for the isNull() and setNull() method signatures.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFReqKeyHash128 extends IYCFKeyHash128 {

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<IYCFReqKeyHash128> singleton = IYCFMtReference<IYCFReqKeyHash128>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IYCFReqKeyHash128 getService() {
		IYCFReqKeyHash128 ref = singleton.get();
		if (ref == null) {
			ref = new IYCFReqKeyHash128();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	IYCFReqKeyHash128 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return An instance that provides the service method implementations.
	 */
	@JSExport
	public IYCFReqKeyHash128 getInstance();

	/**
	 *	Is this value null?
	 *
	 *	@throws IYCFInvalidStateException if the superinterface implementation of isNull() returns true.
	 */
	@Override
	public boolean isNull() {
		if (super.isNull()) {
			throw new IYCFInvalidStateException(getClass(), "isNull", 0, "super.isNull()", "superinterface value is not allowed to be null", null);
		}
		return(false);
	}

	/**
	 *	Make this value null.
	 *
	 *	@throws IYCFNullArgumentException
	 */
	@Override
	public void setNull() {
		throw new IYCFNullArgumentException(getClass(), "setNull", 0, "required-attribute");
	}
}
