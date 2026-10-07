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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *	An XML Core Element Handler is a named evaluator for the JAXP
 *	callback events <tt>beginElement()</tt> and <tt>endElement()</tt>.
 *	<p>
 *	Each element parse context has a map by QName, resolving to
 *	XmlCoreElementParser instances.
 */
public abstract class YCFXmlCoreElementHandler {

	/**
	 *	The XML Core Parser which owns this Element Handler.
	 */
	private YCFXmlCoreParser parser = null;

	/**
	 *	The Map by QName for resolving sub-element handlers.
	 */
	private Map<String,YCFXmlCoreElementHandler> elementHandler = new HashMap<String,YCFXmlCoreElementHandler>();

//	Constructors

	/**
	 *	Construct an XML Core Element Handler owned by the
	 *	specified parser.
	 *	<p>
	 *	The logger associated with the parser is used for
	 *	processing messages.
	 *
	 *	@param	coreParser	The parser which owns this instance.
	 */
	public YCFXmlCoreElementHandler( YCFXmlCoreParser coreParser ) {
		assert coreParser != null : "coreParser (arg 1) is null";
		// Deprecated by Log4J 2 debugLogger.setLevel( Level.INFO );
		setParser( coreParser );
	}

//	Accessors: Logger
	
	/**
	 *	Get the Log4J Logger for processing messages.
	 *
	 *	@return	Logger
	 */
	public IYCFMessageLog getLog() {
		YCFXmlCoreContext context = ( parser != null ) ? parser.getCurContext() : null;
		IYCFMessageLog retval = ( context != null ) ? context.getLog() : null;
		if( retval == null ) {
			if( parser != null ) {
				retval = parser.getLog();
			}
		}
		return( retval );
	}

//	Accessors: Parser

	/**
	 *	Get the XML Core Parser which owns this element handler.
	 *
	 *	@return	The XML Core Parser which owns this element handler.
	 */
	public YCFXmlCoreParser getParser() {
		return( parser );
	}

	/**
	 *	Set the XML Core Parser which owns this element handler.
	 *
	 *	@param	coreParser	The parser which owns this instance.
	 */
	protected void setParser( YCFXmlCoreParser coreParser ) {
		assert coreParser != null : "coreParser (arg 1) is null";
		parser = coreParser;
	}

//	Accessors: ElementHandler

	/**
	 *	Add an element handler to be invoked when the named sub-element QName
	 *	is encountered.
	 *
	 *	@param	qName	The QName to map to the handler
	 *	@param	handler	The XmlCoreElementHandler to process the element events.
	 */
	public void addElementHandler( String qName, YCFXmlCoreElementHandler handler ) {
		assert qName != null && qName.length() > 0 : "qName (arg 1) is null or empty";
		assert handler != null : "handler (arg 2) is null";
		assert ! elementHandler.containsKey( qName ) : "Duplicate qName=\"" + qName + "\" in elementHandler map";
		elementHandler.put( new String( qName ), handler );
	}

	/**
	 *	Locate the named element handler.
	 *
	 *	@param	qName	The QName used to locate the handler.
	 *	@return	The XmlCoreElementHandler mapped to the specified name or null.
	 */
	public YCFXmlCoreElementHandler getElementHandler( String qName ) {
		YCFXmlCoreElementHandler retval = (YCFXmlCoreElementHandler)elementHandler.get( qName );
		return( retval );
	}

//	Element Event Handlers

	/**
	 *	Receive notification of the beginning of an element.
	 *	<p>
	 *	@see org.xml.sax.ContentHandler
	 *
	 *	@param	uri	the Namespace URI, or the empty string if the
	 *				element has no Namespace URI or if Namespace
	 *				processing is not being performed
	 *	@param	localName	the local name (without prefix), or the
	 *						empty string if Namespace processing
	 *						is not being performed
	 *	@param	qName	the qualified name (with prefix), or the
	 *					empty string if qualified names are not available
	 *	@param	attrs	the attributes attached to the element.  If
	 *					there are no attributes, it shall be an empty
	 *					Attributes object.  The value of this object after
	 *					startElement returns is undefined.
	 *
	 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
	 *			wrapping another exception
	 */
	public abstract void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException;


	/**
	 *	Receive notification of the end of an element.
	 *	<p>
	 *	@see org.xml.sax.ContentHandler
	 *
	 *	@param	uri	the Namespace URI, or the empty string if the
	 *				element has no Namespace URI or if Namespace
	 *				processing is not being performed
	 *	@param	localName	the local name (without prefix), or the
	 *						empty string if Namespace processing
	 *						is not being performed
	 *	@param	qName	the qualified name (with prefix), or the
	 *					empty string if qualified names are not available
	 *
	 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
	 *			wrapping another exception
	 */
	public abstract void endElement(
		String	uri,
		String	localName,
		String	qName)
	throws SAXException;

}
