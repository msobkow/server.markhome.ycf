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
 * IInz is the main interface for the IYCF Internationalization (IInz) library.
 * It provides a framework for managing translations and language files.
 * The IInz interface is responsible for loading language files, managing language codes,
 * and providing access to translations through the IInzLang interface.
 */
public interface IInzEffectiveLangCodeCallback extends IYCFAnyObj {

	public String systemLangCode = IInz.DEFAULT_LANG_CODE;

	/**
	 * The initial default effective language code handler returns the system language code.
	 */
	public static IInzEffectiveLangCodeCallback effectiveLangCode = new IInzEffectiveLangCodeCallback() {
																@Override
																public String getEffectiveLangCode() {
																	return(systemLangCode);
																}

																@Override
																public void setEffectiveLangCode(String code) {
																	if (code != null && !code.isEmpty() && ((code.length() == 2 ) || (code.length() == 5))) {
																		systemLangCode = code;
																	}
																	else {
																		throw YCFInvalidArgumentException.getInstance(getClass(), "setEffectiveLangCode", 1, "code", code, "Language code must be 2 or 5 characters long", "Language code must be 2 or 5 characters long");
}
																}
															};

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<InzEffectiveLangCodeCallback> singleton = IYCFMtReference<InzEffectiveLangCodeCallback>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static InzEffectiveLangCodeCallback getService() {
		InzEffectiveLangCodeCallback ref = singleton.get();
		if (ref == null) {
			ref = new InzEffectiveLangCodeCallback();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	Get the current effective language code used for translated messaging.
	 *
	 *	@return IInzEffectiveLangCode The current/default effective language code used for translated system messages.
	 */
	 @JSExport
	 public String getEffectiveLangCode();

	/**
	 *	Set the current effective language code used for translated messaging.
	 *
	 *	@param IInzEffectiveLangCode code The new effective language code used for translated system messages.
	 */
	 @JSExport
	 public void setEffectiveLangCode(String code);

    /**
     *	Set the callback hook for getting the current session's language id String.
     * 
     *	@param callback
     *	@return The previously registered callback
	 *
	 *	@JSExport
     *	public static default IInzEffectiveLangCode installEffectiveLangCodeCallback(IInzEffectiveLangCode callback);
	 */
}
