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

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import server.markhome.ycf.IYCFMessageLog;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import server.markhome.ycf.YCFNullArgumentException;

/**
 *	An XmlCoreSaxParser is an abstract JAXP DefaultHandler
 *	specialized for SAX2 parsing. 
 */
public abstract class YCFXmlCoreSaxParser extends YCFXmlCoreParser {

//	Instance Attributes

	/**
	 *	The SAX Parser for a SAX2 parser.
	 */
	protected SAXParser saxParser = null;

//	Constructors

	/**
	 *	Construct a default parser.
	 */
	public YCFXmlCoreSaxParser() {
		super();
	}

	/**
	 *	Construct a default XmlCoreParser logging to the
	 *	specified Log4J Logger.
	 *
	 *	@param	jLogger - Log4J Logger
	 */
	public YCFXmlCoreSaxParser( IYCFMessageLog jLogger ) {
		super( jLogger );
	}

//	Accessors: API

	/**
	 *	Get the API implemented.
	 */
	public String getAPI() {
		return( API_SAX );
	}
	
	/**
	 *	Initialize the parser.
	 *	<p>
	 *	Initialization pre-loads the XSD for documents accepted
	 *	by the parser.
	 */
	protected void initParser() {
		super.initParser();
		// final String S_ProcName = "initParser";

        try {
        	assert saxParser == null : "saxParser already exists";

        	SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware( true );
			spf.setXIncludeAware( false );
			//spf.setSchema( schema );
			// spf.setValidating( true );
			spf.setFeature( XMLConstants.FEATURE_SECURE_PROCESSING, false );
    		// spf.setFeature( "http://xml.org/sax/features/validation", true );
    		// spf.setFeature( "http://apache.org/xml/features/validation/schema", true );
    		// spf.setFeature( "http://apache.org/xml/features/validation/schema/normalized-value", true );
			
			// Create a SAXParser
			SAXParser sp = spf.newSAXParser();
	    	sp.setProperty( "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
	    		"http://www.w3.org/2001/XMLSchema" );
	    	// sp.setProperty( "http://apache.org/xml/properties/internal/grammar-pool", getGrammarPool() );
			
	    	XMLReader reader = sp.getXMLReader();
    		// reader.setFeature( "http://xml.org/sax/features/validation", true );
    		// reader.setFeature( "http://apache.org/xml/features/validation/schema", true );
    		// reader.setFeature( "http://apache.org/xml/features/validation/schema/normalized-value", true );
	    	// reader.setProperty( "http://apache.org/xml/properties/internal/grammar-pool", getGrammarPool() );

	    	saxParser = sp;
        }
        catch (SAXParseException e) {
            // ignore
        }
        catch (SAXException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "YCFXmlCoreSaxParser.initParser() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "YCFXmlCoreSaxParser.initParser() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
        }
        catch (Exception e) {
        	if( getLog() != null ) {
        		getLog().message( "YCFXmlCoreSaxParser.initParser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
        	}
        	else {
	    		System.err.append( "YCFXmlCoreSaxParser.initParser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
	    	}
        }
    }

	/**
	 *	Parse the specified URI
	 *
	 *	@param	uri - The URI for the document to parse.
	 */
	protected void parse( String uri ) {
		assert ( uri != null ) && ( uri.length() > 0 ) : "uri (parm 1) is null or empty";
		assert saxParser != null : "Parser must be initialized first";

        try {
    		saxParser.reset();
    		saxParser.parse( uri, this );
        }
        catch (SAXParseException e) {
            // ignore
        }
        catch (SAXException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "YCFXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: YCFXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
        }
		catch( FileNotFoundException e ) {
			if( getLog() != null ) {
				getLog().message( "YCFXmlCoreSaxParser.parse() Could not find file \"" + uri + "\"\n" );
			}
			else {
				System.err.append( "ERROR: YCFXmlCoreSaxParser.parse() Could not find file \"" + uri + "\"\n" );
			}
		}
		catch (Exception e) {
			if( getLog() != null ) {
				getLog().message( "YCFXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
			}
			else {
				System.err.append( "ERROR: YCFXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
			}
		}
	}

	/**
	 *	Parse the specified string contents.
	 *	<p>
	 *	The string passed to this method is typically
	 *	a request or response XML document to be processed
	 *	by an appropriate parser and applied to a storage
	 *	server layer.
	 *
	 *	@param	str The string contents to be parsed.
	 */
	public void parseStringContents( String str ) {
		final String S_ProcName = "parseStringContents";
		if( str == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				1,
				"str" );
		}
		byte bytes[] = str.getBytes();
		InputStream instream = new ByteArrayInputStream( bytes );
		parse( instream );
	}
	
	/**
	 *	Parse the specified Stream
	 *
	 *	@param	input - The InputStream for the document to parse.
	 */
	protected void parse( InputStream inputStream ) {
		assert inputStream != null : "inputStream (arg 1) is null";
		assert saxParser != null : "Parser must be initialized first";

        try {
    		saxParser.reset();
    		saxParser.parse( inputStream, this );
        }
        catch (SAXParseException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "YCFXmlCoreSaxParser.parse() Ignored SAXParseException exception " + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: YCFXmlCoreSaxParser.parse() Ignored SAXParseException exception " + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
        }
        catch (SAXException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "YCFXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: YCFXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getName() + " " + nested.getMessage() + "\n" );
    		}
        }
		catch (Exception e) {
			if( getLog() != null ) {
				getLog().message( "YCFXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
			}
			else {
				System.err.append( "ERROR: YCFXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getName() + " " + e.getMessage() + "\n" );
			}
		}
	}
}
