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
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public class YCFMtReference implements IYCFMtReference {

	/**
	 *	The base reference is protected.
	 */
	@JSProperty
	protected IYCFAnyObj ref;

	/**
	 *	Get the value this instance currently references.
	 *
	 *	@return The currently referenced value.
	 */
	@JSProperty
	public IYCFAnyObj get() {
		return(ref);
	}

	/**
	 *	Set the <i>value</i> this instance is to reference if the current value matches <i>expected</i>.
	 *
	 *	@param expected The value expected to be referenced if the value is to be changed.
	 *	@param value The value to be referenced in the future if the current value matches expected.
	 *
	 *	@return The value this instance references after attempting to change the value; it may be either the value passed in or a completely different reference, but it will only be <i>expected</i> iff <i>value</i> and <i>expected</i> are identical.
	 */
	@JSProperty
	public IYCFAnyObj set(IYCFAnyObj expected, IYCFAnyObj value) {
		if (ref == expected) {
			synchronized (this) {
				if (ref == expected) {
					ref = value;
				}
			}
		}
		return(ref);
	}
}
