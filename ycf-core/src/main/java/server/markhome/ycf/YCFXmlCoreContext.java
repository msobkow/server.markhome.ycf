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

import java.util.HashMap;
import java.util.Map;

import server.markhome.ycf.IYCFMessageLog;

/**
 *	An XML Core Context is a processing stack entry pushed
 *	at the start of each element or document and popped
 *	at the end of their processing.
 */
public class YCFXmlCoreContext {

	/**
	 *	Context stack chain.
	 *	<p>
	 *	This had been handled via Java collections, but that
	 *	made the access of stack top - 1 inefficient.
	 */
	private YCFXmlCoreContext prevContext = null;

	/**
	 *	The StringBuilder to receive character event data.
	 */
	private StringBuilder elementText = new StringBuilder();

	/**
	 *	The XmlCoreElementHandler selected to handle the
	 *	beginElement and endElement events.
	 */
	private YCFXmlCoreElementHandler elementHandler = null;

	/**
	 *	The Log4J log to receive parser processing messages.
	 *	<p>
	 *	Programmer debug and trace messages should go to <tt>debuglog</tt>.
	 */
	private IYCFMessageLog log = null;

	/**
	 *	The XML Core Parser which owns this processing Context.
	 */
	private YCFXmlCoreParser parser = null;

	/**
	 *	The QName of the element being processed.
	 */
	private String elementQName = null;

	/**
	 *	Named attribute map.  Used to retain startElement data for use in endElement.
	 */
	private Map<String,Object> valueMap = new HashMap<String,Object>();

//	Constructors

	/**
	 *	Copy and link an XML Core Context.
	 *	<p>
	 *	The specified source element becomes the PrevContext.
	 *
	 *	@param	src	The context to copy.
	 *	@param	qName	The QName of the element about to be processed.
	 *	@param	handler	The XmlCoreElementHandler which will be used for processing.
	 */
	public YCFXmlCoreContext(
		YCFXmlCoreContext src,
		String qName,
		YCFXmlCoreElementHandler handler )
	{
		assert src != null : "src (arg 1) is null";

		prevContext = src;
		setElementHandler( src.getElementHandler() );
		setLog( src.getLog() );
		setParser( src.getParser() );
		setQNameElementHandler( qName, handler );

//		debuglog.setLevel( Level.INFO );
	}

	/**
	 *	Construct a "root" XML Core Context instance.
	 *
	 *	@param	coreParser	The parser which owns this instance.
	 *	@param	jlog	Log4J log to use, if null, use parser's log.
	 *	@param	handler	The XmlCoreElementHandler which will be processing the doc root.
	 */
	public YCFXmlCoreContext(
		YCFXmlCoreParser coreParser,
		IYCFMessageLog jlog,
		YCFXmlCoreElementHandler elementHandler )
	{
		assert coreParser != null : "coreParser (arg 1) is null";
		assert elementHandler != null : "elementHandler (arg 3) is null";
		
		prevContext = null;
		
		setParser( coreParser );
		
		if( jlog != null ) {
			setLog( jlog );
		}
		else {
			setLog( coreParser.getLog() );
		}

		setQNameElementHandler( ".", elementHandler );
	}

//	Accessors: PrevContext

	/**
	 *	Get the previous context in the stack.
	 *
	 *	@return	The previous context or null if this is
	 *			the bottom of the stack.
	 */
	public YCFXmlCoreContext getPrevContext() {
		return( prevContext );
	}

//	Accessors: ValueMap

	/**
	 *	Is there a mapping for the named value slot?
	 *
	 *	@param	name	The name of the object
	 *
	 *	@return	True if there is a mapping for the name.
	 */
	public boolean hasNamedValue( String key ) {
		boolean retval = valueMap.containsKey( key );
		return( retval );
	}
	
	/**
	 *	Get the object for the named value slot.
	 *
	 *	@param	name	The name of the object
	 *	@return	The object associated with the name or null.
	 */
	public Object getNamedValue( String key ) {
		Object retval = valueMap.get( key );
		return( retval );
	}
	
	/**
	 *	Put a named value.
	 *
	 *	@param	name	The name of the object
	 *	@param	value	The object to store for the name
	 *
	 *	@return	The object previously associated with the name or null
	 */
	public Object putNamedValue( String key, Object value ) {
		Object retval = valueMap.put( key, value );
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

//	Accessors: log

	/**
	 *	Get the runtime processing log.
	 *
	 *	@return	Log4J log
	 */
	public IYCFMessageLog getLog() {
		if( log != null ) {
			return( log );
		}
		if( parser != null ) {
			return( parser.getLog() );
		}
		return( null );
	}

	/**
	 *	Set the runtime processing log.
	 *
	 *	@param	jlog	The log to use for runtime processing messages
	 */
	public void setLog( IYCFMessageLog jlog ) {
		log = jlog;
	}

//	Accessors: ElementText
	
	/**
	 *	Get the ElementText for the current context.
	 *
	 * 	@return	The element text collected so far.
	 */
	public String getElementText() {
		return( elementText.toString() );
	}

	/**
	 *	Append a character segment to the element text.
	 */
	public void appendElementText( char ch[], int start, int length ) {
		elementText.append( ch, start, length );
	}

//	Accessors: ElementHandler

	/**
	 *	Retrieve the element handler for this processing context.
	 *
	 *	@return	The element handler selected for processing the current element.
	 */
	public YCFXmlCoreElementHandler getElementHandler() {
		return( elementHandler );
	}

	/**
	 *	Set the element handler for this processing context.
	 *
	 *	@param	handler	The XmlCoreElementHandler selected to process the element.
	 */
	protected void setElementHandler( YCFXmlCoreElementHandler handler ) {
		assert handler != null : "handler (arg 1) is null";
		elementHandler = handler;
	}

	/**
	 *	Set the element handler and QName for this processing context.
	 *
	 *	@param	qName	The QName of the element or document being processed.
	 *	@param	handler	The XmlCoreElementHandler selected to process the element.
	 */
	public void setQNameElementHandler( String qName, YCFXmlCoreElementHandler handler ) {
		assert elementQName == null : "Element context QName has already been set";
		assert qName != null && qName.length() > 0 : "qName (arg 1) is null or empty";
		assert handler != null : "handler (arg 2) is null";
		elementHandler = handler;
		elementQName = new String( qName );
	}
}
