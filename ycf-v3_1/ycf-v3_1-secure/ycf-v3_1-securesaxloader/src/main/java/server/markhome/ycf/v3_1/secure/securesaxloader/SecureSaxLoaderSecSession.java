
// Description: Java 25 XML SAX Element Handler for SecSession

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.securesaxloader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.xml.sax.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/*
 *	SecureSaxLoaderSecSessionParse XML SAX Element Handler implementation
 *	for SecSession.
 */
public class SecureSaxLoaderSecSession
	extends YCFLibXmlCoreElementHandler
{
	public SecureSaxLoaderSecSession( SecureSaxLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		final String S_ProcName = "startElement";
		ISecureSecSessionObj origBuff = null;
		ISecureSecSessionEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecSession Attributes
		String attrStart = null;
		String attrFinish = null;
		String attrSecProxy = null;
		// SecSession References
		ISecureSecUserObj refSecUser = null;
		ISecureSecUserObj refSecProxy = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecSession" );

			SecureSaxLoader saxLoader = (SecureSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ISecureSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			origBuff = (ISecureSecSessionObj)schemaObj.getSecSessionTableObj().newInstance();
			editBuff = (ISecureSecSessionEditObj)origBuff.beginEdit();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Start" ) ) {
					if( attrStart != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrStart = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Finish" ) ) {
					if( attrFinish != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrFinish = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SecProxy" ) ) {
					if( attrSecProxy != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecProxy = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw new YCFLibUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values
			if( ( attrStart == null ) || ( attrStart.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Start" );
			}
			if( ( attrSecProxy == null ) || ( attrSecProxy.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecProxy" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Start", attrStart );
			curContext.putNamedValue( "Finish", attrFinish );
			curContext.putNamedValue( "SecProxy", attrSecProxy );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			LocalDateTime natStart;
			try {
				natStart = YCFLibXmlUtil.parseTimestamp( attrStart );
			}
			catch( RuntimeException e ) {
				throw new YCFLibInvalidArgumentException( getClass(),
					S_ProcName,
					0,
					"Start",
					e );
			}
			editBuff.setRequiredStart( natStart );

			LocalDateTime natFinish;
			if( ( attrFinish == null ) || ( attrFinish.length() <= 0 ) ) {
				natFinish = null;
			}
			else {
				try {
					natFinish = YCFLibXmlUtil.parseTimestamp( attrFinish );
				}
				catch( RuntimeException e ) {
					throw new YCFLibInvalidArgumentException( getClass(),
						S_ProcName,
						0,
						"Finish",
						e );
				}
			}
			editBuff.setOptionalFinish( natFinish );

			// Get the scope/container object

			YCFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			// Resolve and apply required Container reference

			if( scopeObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"scopeObj" );
			}
			else if( scopeObj instanceof ISecureSecUserObj ) {
				refSecUser = (ISecureSecUserObj) scopeObj;
				editBuff.setRequiredContainerSecUser( refSecUser );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ISecureSecUserObj" );
			}

			// Lookup refSecProxy by key name value attr
			if( ( attrSecProxy != null ) && ( attrSecProxy.length() > 0 ) ) {
				refSecProxy = (ISecureSecUserObj)schemaObj.getSecUserTableObj().readSecUserByULoginIdx( attrSecProxy );
				if( refSecProxy == null ) {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve SecProxy reference named \"" + attrSecProxy + "\" to table SecUser" );
				}
			}
			else {
				refSecProxy = null;
			}
			editBuff.setRequiredParentSecProxy( refSecProxy );

			ISecureSecSessionObj origSecSession;
			ISecureSecSessionEditObj editSecSession = editBuff;
			origSecSession = (ISecureSecSessionObj)editSecSession.create();
			editSecSession = null;

			curContext.putNamedValue( "Object", origSecSession );
		}
		catch( RuntimeException e ) {
			throw new SAXException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
		catch( Error e ) {
			throw new SAXException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage() );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
