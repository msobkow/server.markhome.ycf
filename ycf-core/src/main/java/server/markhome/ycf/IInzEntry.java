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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * An IInzEntry contains all IInzLang entries for a given entry in the language path defined by IInz.langPath.
 * 
 * When IInz does the top-level translation search, it probes the IInzEntry data in path-order sequence until
 * it finds a match for the requested key.  If the key ultimately could not be found, it returns "!key!".
 * 
 * IInzEntry is not intended to be instantiated directly by users of IYCF, but rather is used internally
 * by IInz to manage the language entries loaded from the properties files in the langPath.
 * 
 * @author Mark Stephen Sobkow
 * @see IInz
 * @see IInzLang
 */
public interface IInzEntry extends IYCFAnyObj {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference singleton = IYCFMtReference.getService().getInstance();

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IInzEntry getService() {
		IInzEntry ref = ((IInzEntry)(singleton.get()));
		if (ref == null) {
			ref = new InzEntry();
			singleton.set(null, ref);
			ref = ((IInzEntry)(singleton.get()));
		}
		return(ref);
	}

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public static IInzEntry InzEntry_getInstance() {
		IInzEntry retval = new InzEntry();
		return(retval);
	}

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public static IInzEntry InzEntry_getInstance(String pathName) {
		IInzEntry retval = new InzEntry(pathName);
		return(retval);
	}

	/**
     *	Construct an IInzEntry for the specified pathName, using it to open the directory specified as pathEntry,
     *	and then loading all the IInzLang entries from the properties files in that directory.
     * 
     *	@param IInzPathEntry pathEntry The path entry to construct the instance over; not allowed to be null.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public static IInzEntry InzEntry_getInstance(IInzPathEntry pathEntry) {
		IInzEntry retval = new InzEntry(pathEntry);
		return(retval);
	}

    /**
     *	Construct an IInzEntry for the specified pathName, using it to open the directory specified as pathEntry,
     *	and then loading all the IInzLang entries from the properties files in that directory.
     * 
     *	@param IInzPathEntry pathEntry The path entry to construct the instance over; not allowed to be null.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
    public IInzEntry getInstance(IInzPathEntry pathEntry);

	/**
	 *	Get the path name for an instance of the interface.
	 *
	 *	@return String The path name.
	 */
	@JSExport
	public static String InzEntry_getPathName(IInzEntry jthis) {
		if (jthis != null) {
			return(jthis.getPathName());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Set the path name for an instance of the interface.
	 *
	 *	@param IInzEntry jthis A reference to the instance in question.
	 *	@param String expected The expected value of the current path name.
	 *	@param String value The path name to be applied.
	 *
	 *	@return String The path name of the instance, which might be different than either parameter.
	 */
	@JSExport
	public static String InzEntry_setPathName(IInzEntry jthis, String expected, String value) {
		if (jthis != null) {
			if(jthis.getPathName() == expected || (jthis.getPathName() != null && jthis.getPathName().equals(value))) {
				jthis.setPathName(expected, value);
				String retval = jthis.getPathName();
				return(retval);
			}
			else {
				return(null);
			}
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get the path entry for an instance of the interface.
	 *
	 *	@return IInzPathEntry The path entry.
	 */
	@JSExport
	public static IInzPathEntry InzEntry_getPathEntry(IInzEntry jthis) {
		if (jthis != null) {
			return(jthis.getPathEntry());
		}
		else {
			return(null);
		}
	}

	/**
	 *	Set the path entry for an instance of the interface.
	 *
	 *	@param IInzEntry jthis A reference to the instance in question.
	 *	@param String expected The expected value of the current path entry.
	 *	@param String value The path entry to be applied.
	 *
	 *	@return String The path entry of the instance, which might be different than either parameter.
	 */
	@JSExport
	public static IInzPathEntry InzEntry_setPathEntry(IInzEntry jthis, IInzPathEntry expected, IInzPathEntry value) {
		if (jthis != null) {
			if(jthis.getPathEntry() == expected || (jthis.getPathEntry() != null && jthis.getPathEntry().equals(value))) {
				jthis.setPathEntry(expected, value);
				String retval = jthis.getPathEntry();
				return(retval);
			}
			else {
				return(null);
			}
		}
		else {
			return(null);
		}
	}

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public IInzEntry getInstance();

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@param String pathName The path name to be searched.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public IInzEntry getInstance(String pathName);

	/**
	 *	Get an instance that implements the service methods of the interface.
	 *
	 *	@param IInzPathEntry pathEntry The path entry to be searched.
	 *
	 *	@return IInzEntry An instance of the interface.
	 */
	@JSExport
	public IInzEntry getInstance(IInzPathEntry pathEntry);

    /**
     * Get the path name.
	 *
     * @return String The current path name.
     */
	@JSProperty
    public String getPathName();

    /**
     * Set the path name.
	 *
     * @param String expected The current path name.
     * @param String value The path name to apply.
	 *
     * @return String The new path name.
     */
	@JSProperty
    public String setPathName(String expected, String value);

    /**
     * Get the path entry.
	 *
     * @return IInzPathEntry The current path name.
     */
	@JSProperty
    public IInzPathEntry getPathEntry();

    /**
     * Set the path entry.
	 *
     * @param IInzPathEntry expected The current path name.
     * @param IInzPathEntry value The path name to apply.
	 *
     * @return IInzPathEntry The new path name.
     */
	@JSProperty
    public IInzPathEntry setPathEntry(IInzPathEntry expected, IInzPathEntry value);

    /**
     * Load all IInzLang entries from the properties files in the pathEntry directory.
     * Each properties file should be named with the language code (e.g., "en.properties" for English).
     * The IInzLang instances are stored in the langs map, keyed by their language code.
     * 
     * This method reads each properties file, validates the required properties,
     * and creates an IInzLang instance for each valid file. It also handles fallback languages
     * by linking them to their respective IInzLang instances.
     * 
     * If a properties file does not contain the required properties or has mismatched language codes,
     * an IllegalArgumentException is thrown.
     * 
     * In the case of resource entries, it expects to find a "propnames.txt" file that lists the names of the properties files.
     * 
     * @throws IOException if there is an error reading the directory or files.
     * @throws RuntimeException if there is an error loading the language files.
     * @throws IllegalArgumentException if a properties file is invalid or missing required properties.
     * @see IInzLang#LANG_CODE_PROP
     * @see IInzLang#ENGLISH_NAME_PROP
     * @see IInzLang#NLS_NAME_PROP
     * @see IInzLang#FALLBACK_LANG_PROP
     * @see IInzLang#setTranslations(Properties)
     * @see IInzLang#setFallbackLang(IInzLang)
     * 
     * Note: This method assumes that the properties files are well-formed and contain the required properties.
     * It does not handle malformed files or unexpected formats, which should be validated before calling this method.
	 */
	@JSExport
	public void loadLangs();

    /**
     * Load all IInzLang entries from the properties files in the pathEntry directory.
     * Each properties file should be named with the language code (e.g., "en.properties" for English).
     * The IInzLang instances are stored in the langs map, keyed by their language code.
     * 
     * This method reads each properties file, validates the required properties,
     * and creates an IInzLang instance for each valid file. It also handles fallback languages
     * by linking them to their respective IInzLang instances.
     * 
     * If a properties file does not contain the required properties or has mismatched language codes,
     * an IllegalArgumentException is thrown.
     * 
     * In the case of resource entries, it expects to find a "propnames.txt" file that lists the names of the properties files.
     * 
     * @throws IOException if there is an error reading the directory or files.
     * @throws RuntimeException if there is an error loading the language files.
     * @throws IllegalArgumentException if a properties file is invalid or missing required properties.
     * @see IInzLang#LANG_CODE_PROP
     * @see IInzLang#ENGLISH_NAME_PROP
     * @see IInzLang#NLS_NAME_PROP
     * @see IInzLang#FALLBACK_LANG_PROP
     * @see IInzLang#setTranslations(Properties)
     * @see IInzLang#setFallbackLang(IInzLang)
     * 
     * Note: This method assumes that the properties files are well-formed and contain the required properties.
     * It does not handle malformed files or unexpected formats, which should be validated before calling this method.
	 */
	@JSExport
    static public void YCFInzEntry_loadLangs();

    /**
     * Search for a translation for the given key, starting with the specified language code.
     * If the key is not found in the specified language, it will search through the fallback languages
     * until it finds a match or exhausts all options.
     * 
     * @param key The translation key to search for.
     * @return The translation for the key, or "!?key?!" if not found in any language.
     */
	@JSExport
	public static String YCFInzEntry_x(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return(null);
		}
		String useLangCode = IInz.getSingleton().getEffectiveLangCode();
		HashMap<String, IInzLang> map = YCFInzEntry_getLangs(this);
		if(map != null) {
			IInzLang lang = map.get(useLangCode);
			if(lang != null) {
				try {
					String retval = lang.x(key);
					return(retval);
				}
				catch(Throwable th) {
					// "Caught and ignored exception %1$s - %2$s"
					IYCFConsoleLog.getSingleton().getLog().warn(IInz.getSingleton().x("ycf.inzentry.warn.caughtignoredexception"), th.getClass().getSimpleName(), th.getMessage());
					return("!?" + key + "?!");
				}
			}
			else {
				return("!?" + key + "?!");
			}
		}
		else {
			return("!?" + key + "?!");
		}
	}

    /**
     * Search for a translation for the given key using the IInz.getEffectiveLangId() value.
     * 
     * @param key
     * @return
     */
	@JSExport
    public String x(String key);

    /**
     * Search for a translation for the given key, starting with the specified language code.
     * If the key is not found in the specified language, it will search through the fallback languages
     * until it finds a match or exhausts all options.
     * 
     * @param key The translation key to search for.
     * @param langCode The language code to start the search from.
     * @return The translation for the key, or "!?key?!" if not found in any language.
     */
	@JSExport
	public static String YCFInzEntry_x(String key, String langCode) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return(null);
		}
		String useLangCode = langCode;
		if(useLangCode == null || useLangCode.isEmpty() || useLangCode.isBlank()) {
			useLangCode = IInz.getSingleton().getEffectiveLangCode();
		}
		HashMap<String, IInzLang> map = YCFInzEntry_getLangs(this);
		if(map != null) {
			IInzLang lang = map.get(useLangCode);
			if(lang != null) {
				try {
					String retval = lang.x(key);
					return(retval);
				}
				catch(Throwable th) {
					// "Caught and ignored exception %1$s - %2$s"
					IYCFConsoleLog.getSingleton().getLog().warn(IInz.getSingleton().x("ycf.inzentry.warn.caughtignoredexception"), th.getClass().getSimpleName(), th.getMessage());
					return("!?" + key + "?!");
				}
			}
			else {
				return("!?" + key + "?!");
			}
		}
		else {
			return("!?" + key + "?!");
		}
	}

    /**
     * Search for a translation for the given key, starting with the specified language code.
     * If the key is not found in the specified language, it will search through the fallback languages
     * until it finds a match or exhausts all options.
     * 
     * @param key The translation key to search for.
     * @param langCode The language code to start the search from.
     * @return The translation for the key, or "!?key?!" if not found in any language.
     */
	@JSExport
    public String x(String key, String langCode);

    /**
     * Get the map of language codes to IInzLang instances for this IInzEntry.
     * 
	 *	@param IInzEntry jthis The instance to be evaluated
	 *
     *	@return A HashMap containing language codes and their corresponding IInzLang instances.
	 */
	@JSExport
    public static HashMap<String, IInzLang> YCFInzEntry_getLangs(IInzEntry jthis);

    /**
     * Get the map of language codes to IInzLang instances for this IInzEntry.
     * 
     * @return A HashMap containing language codes and their corresponding IInzLang instances.
	 */
	@JSExport
    public HashMap<String, IInzLang> getLangs();

    /**
     * Get the IInzLang instance for the specified language code.
     * 
     * @param langCode The language code to retrieve the IInzLang instance for.
     * @return The IInzLang instance for the specified language code, or null if not found.
	 */
	@JSExport
    public static IInzLang YCFInzEntry_getLang(String langCode);

    /**
     * Get the IInzLang instance for the specified language code.
     * 
     * @param langCode The language code to retrieve the IInzLang instance for.
     * @return The IInzLang instance for the specified language code, or null if not found.
	 */
	@JSExport
    public IInzLang getLang(String langCode);
}
