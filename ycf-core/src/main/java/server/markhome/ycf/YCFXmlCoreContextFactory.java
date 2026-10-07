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

import server.markhome.ycf.IYCFMessageLog;

/**
 *	An XML Core Context Factory instantiates new instances
 *	derived from XmlCoreContext. 
 */
public interface YCFXmlCoreContextFactory {

	/**
	 *	Get the application processing logger.
	 *
	 *	@return	The application processing Log4J Logger.
	 */
	public IYCFMessageLog getLog();

	/**
	 *	Copy an XML Core Context.
	 *
	 *	@param	src	The context to copy.
	 *	@param	qName	The QName of the element about to be processed.
	 *	@param	handler	The XmlCoreElementHandler which will be used for processing.
	 */
	public YCFXmlCoreContext newXmlCoreContext(
		YCFXmlCoreContext src,
		String qName,
		YCFXmlCoreElementHandler handler );

	/**
	 *	Construct a "root" XML Core Context instance.
	 *
	 *	@param	coreParser	The parser which owns this instance.
	 *	@param	log	IYCFMessageLog to use, if null, use parser's logger.
	 *	@param	handler	The XmlCoreElementHandler which will be processing the doc root.
	 */
	public YCFXmlCoreContext newXmlCoreContext(
		YCFXmlCoreParser coreParser,
		IYCFMessageLog jLogger,
		YCFXmlCoreElementHandler elementHandler );

}
