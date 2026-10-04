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

import java.io.File;
import java.io.InputStream;

/**
 * An IInzPathEntry can represent either a resource path, in which case it needs to specify a interface for resource loading, and use a path
 * that starts with "resource:", or a file system path, in which case it accesses files directly from the file system.
 */
public interface IInzPathEntry extends JSObject {

    /**
     * Constructs an IInzPathEntry with the specified file system path.
     *
     * @param path the path for this entry
     *
     * public IInzPathEntry(String path)
	 */

    /**
     * Constructs an IInzPathEntry with the specified interface and file system path.
     *
     * @param clazz the class associated with this entry
     * @param path  the path for this entry
     *
     * public IInzPathEntry(Class<?> clazz, String path)
	 */

	@JSProperty
    public String getPath();

	@JSProperty
    public void setPath(String path);

	@JSProperty
    public Class<?> getClazz();

	@JSProperty
    public void setClazz(Class<?> clazz);

    /**
     * Returns the resource associated with this path entry.
     * This method should be overridden by subclasses that represent resource paths.
     */
	@Export
    public InputStream getInputStream(String resourceName);
}
