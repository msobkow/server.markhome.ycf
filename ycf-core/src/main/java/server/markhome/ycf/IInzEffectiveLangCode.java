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
 *  IInzEffectiveLangCode callbacks implementing this interface are registered with IInz to allow different user presentation layers to wire a current-session-language type hook based on the APIs for the presentation layer, instead of making assumptions or imposing restrictions on how such callbacks are registered.
 *	<p>
 *	All methods of the interface are expected to be synchronized through the use of the IYCFMt interfaces and their implementations.
 * 
 *  @see IInz
 */
public interface IInzEffectiveLangCode extends IYCFAnyObj {

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<InzEffectiveLangCode> singleton = IYCFMtReference<InzEffectiveLangCode>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static InzEffectiveLangCode getService() {
		InzEffectiveLangCode ref = singleton.get();
		if (ref == null) {
			ref = new InzEffectiveLangCode();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@return IInzEffectiveLangCode An instance of the interface.
	 *
	 *	@JSExport
	 *	public static IInzEffectiveLangCode InzEffectiveLangCode_getInstance();
	 */

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@return IInzEffectiveLangCode An instance of the interface.
	 */
	@JSExport
	public IInzEffectiveLangCode getInstance();

    /**
     * Get the effective language code for NLS translation.
	 *
     * @return String The current effective language code.
     */
	@JSProperty
    public String getEffectiveLangCode();

    /**
     * Set the effective language code for NLS translation.
	 *
     * @param String expected The current effective language code.
     * @param String value The language code to apply.
	 *
     * @return String The new effective language code.
     */
	@JSProperty
    public String setEffectiveLangCode(String expected, String value);

    /**
     * Get the effective language name for NLS translation.
	 *
     * @return String The current effective language name.
     */
	@JSProperty
    public String getEffectiveLangName();

    /**
     * Set the effective language name for NLS translation.
	 *
     * @param String expected The current effective language name.
     * @param String value The language name to apply.
	 *
     * @return String The new effective language name.
     */
	@JSProperty
    public String setEffectiveLangName(String expected, String value);

    /**
     * Get the effective language description for NLS translation.
	 *
     * @return String The current effective language description.
     */
	@JSProperty
    public String getEffectiveLangDescription();

    /**
     * Set the effective language description for NLS translation.
	 *
     * @param String expected The current effective language description.
     * @param String value The language description to apply.
	 *
     * @return String The new effective language description.
     */
	@JSProperty
    public String setEffectiveLangDescription(String expected, String value);

    /**
     * Get the effective translated language code for NLS translation.
	 *
     * @return String The current effective translated language code.
     */
	@JSProperty
    public String getEffectiveXLangCode();

    /**
     * Set the effective translated language code for NLS translation.
	 *
     * @param String expected The current effective translated language code.
     * @param String value The language code to apply.
	 *
     * @return String The new effective translated language code.
     */
	@JSProperty
    public String setEffectiveXLangCode(String expected, String value);

    /**
     * Get the effective translated language name for NLS translation.
	 *
     * @return String The current effective translated language name.
     */
	@JSProperty
    public String getEffectiveXLangName();

    /**
     * Set the effective translated language name for NLS translation.
	 *
     * @param String expected The current effective translated language name.
     * @param String value The language name to apply.
	 *
     * @return String The new effective translated language name.
     */
	@JSProperty
    public String setEffectiveXLangName(String expected, String value);

    /**
     * Get the effective translated language description for NLS translation.
	 *
     * @return String The current effective translated language description.
     */
	@JSProperty
    public String getEffectiveXLangDescription();

    /**
     * Set the effective translated language description for NLS translation.
	 *
     * @param String expected The current effective translated language description.
     * @param String value The language description to apply.
	 *
     * @return String The new effective translated language description.
     */
	@JSProperty
    public String setEffectiveXLangDescription(String expected, String value);
}
