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

import server.markhome.mycf.v3_1.ycflib.Inz;
import server.markhome.mycf.v3_1.ycflib.YCFXmlUtil;

/**
 * The YCFRelationType defines the common relationship types found in a generic business ERD model.
 * 
 * Note that Container-Component, Parent-Child, and Master-Detail are NOT identical relationships.
 * For example, there can only be one Container relationship from a Component to it's document Container,
 * but there can be multiple Parent-Child relationships which perform a similar function of implying cascading
 * deletion of Component/Child relationship data when the Container/Parent is deleted, but do not define the
 * container hierarchy used by XML and JSON structured document formats in the same way. The Container-Component
 * relationship defines the document hierarchy for XML and JSON structured document formats. The document hierarchy
 * name also defines the dot-name hierarchy, where applicable.
 * 
 * For the sake of simplicity and efficiency, the JSON data types use the same XML utilities as the XML document
 * formats, so the JSON data stream looks like it is comprised of XML data which has just had it's structural
 * details changed.
 * 
 * @see YCFXmlUtil
 * 
 * The Lookup relationship is special; it implies that the target does not allow deletion and has to be pre-loaded and cached by the client and middleware.
 * You can add new lookups, but you can't delete them. It also doesn't block deletion of the object which defines the relationship.
 * 
 * The Unknown relationship does not do cascading deletes, but nor does it block deletion of the object which defines the relationship.
 */
@SuppressWarnings("unused")
public enum YCFRelationType {
    Container("N", "Container", "ycflib.YCFRelationType.Container"),
    Component("P", "Component", "ycflib.YCFRelationType.Component"),
    Parent( "P", "Parent", "ycflib.YCFRelationType.Parent"),
    Child("C", "Child", "ycflib.YCFRelationType.Child"),
    Master("M", "Master", "ycflib.YCFRelationType.Master"),
    Detail("D", "Detail", "ycflib.YCFRelationType.Detail"),
    Lookup("L", "Lookup", "ycflib.YCFRelationType.Lookup"),
    Unknown("U", "Unknown", "ycflib.YCFRelationType.Unknown");

    private final String key;
    private final String label;
    private final String inzLabelKey;

    private YCFRelationType(String key, String label, String inzLabelKey) {
        this.key = key;
        this.label = label;
        this.inzLabelKey = inzLabelKey;
    }

    /**
     * Get the one-character key string for this enum value.
     * 
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the character key for this enum value.
     * 
     * @return
     */
    public Character getChKey() {
        return key.charAt(0);
    }

    /**
     * Return the compiled-in label for this enum value.
     * 
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     * Return the Inz key for the NLS label corresponding to this enum value.
     * 
     * @return
     */
    public String getInzLabelKey() {
        return inzLabelKey;
    }

    /**
     * Return the Inz.s() value for the Inz label key of this enum value. Might not be equal to the compiled-in English labels.
     * 
     * @see Inz.s
     * 
     * @return
     */
    public String s() {
        return Inz.s(inzLabelKey);
    }

    /**
     * Return the Inz.x() value for the Inz label key of this enum value. Never cache the result, as it changes depending on the user's runtime context.
     * 
     * @see Inz.x
     * 
     * @return
     */
    public String x() {
        return Inz.x(inzLabelKey);
    }
}
