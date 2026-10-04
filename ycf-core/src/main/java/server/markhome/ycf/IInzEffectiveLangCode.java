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
 * 
 *  @see IInz
 */
public interface IInzEffectiveLangCode extends JSObject {

    /**
     * Get the current effective language id for NLS translation.
     * @return
     */
	@JSProperty
    public String getEffectiveLangCode();
}
