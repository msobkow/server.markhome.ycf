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
 * IYCFOptKeyHash128 extends IYCFKeyHash128 with the appropriate behavior for the isNull() and setNull() method signatures.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFOptKeyHash128 extends IYCFKeyHash128 implements IYCFOptional {

	/**
	 *	IYCFOptKeyHash128 getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	@return The singleton instance that provides the getInstance() and service method implementations.
	 */
	@JSExport
	public IYCFOptKeyHash128  getSingleton();

	/**
	 *	IYCFOptKeyHash128 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return An instance that provides the service method implementations.
	 */
	@JSExport
	public IYCFOptKeyHash128 getInstance();

	/**
	 *	Make this value null.
	 *
	 *	@throws IYCFNullArgumentException
	 */
	@Override
	public void setNull() {
		byte[] ba = getBytes();
		if (ba != null ) {
			for( int i = 0; i < ba.length; i++ ) {
				ba[i] = 0;
			}
		}
	}
}
