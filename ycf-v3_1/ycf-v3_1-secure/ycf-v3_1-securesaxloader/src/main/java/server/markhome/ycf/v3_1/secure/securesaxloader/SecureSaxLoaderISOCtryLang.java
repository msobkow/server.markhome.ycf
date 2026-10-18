
// Description: Java 25 XML SAX Element Handler for ISOCtryLang

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
 *	SecureSaxLoaderISOCtryLangParse XML SAX Element Handler implementation
 *	for ISOCtryLang.
 */
public class SecureSaxLoaderISOCtryLang
	extends YCFLibXmlCoreElementHandler
{
	public SecureSaxLoaderISOCtryLang( SecureSaxLoader saxLoader ) {
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
		ISecureISOCtryLangObj origBuff = null;
		ISecureISOCtryLangEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// ISOCtryLang Attributes
		String attrLang = null;
		// ISOCtryLang References
		ISecureISOCtryObj refCtry = null;
		ISecureISOLangObj refLang = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "ISOCtryLang" );

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
			origBuff = (ISecureISOCtryLangObj)schemaObj.getISOCtryLangTableObj().newInstance();
			editBuff = (ISecureISOCtryLangEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "Lang" ) ) {
					if( attrLang != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLang = attrs.getValue( idxAttr );
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
			if( ( attrLang == null ) || ( attrLang.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Lang" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Lang", attrLang );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
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
			else if( scopeObj instanceof ISecureISOCtryObj ) {
				refCtry = (ISecureISOCtryObj) scopeObj;
				editBuff.setRequiredContainerCtry( refCtry );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ISecureISOCtryObj" );
			}

			// Lookup refLang by key name value attr
			if( ( attrLang != null ) && ( attrLang.length() > 0 ) ) {
				refLang = (ISecureISOLangObj)schemaObj.getISOLangTableObj().readISOLangByCode3Idx( attrLang );
				if( refLang == null ) {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve Lang reference named \"" + attrLang + "\" to table ISOLang" );
				}
			}
			else {
				refLang = null;
			}
			editBuff.setRequiredParentLang( refLang );

			SecureSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getISOCtryLangLoaderBehaviour();
			ISecureISOCtryLangEditObj editISOCtryLang = null;
			ISecureISOCtryLangObj origISOCtryLang = (ISecureISOCtryLangObj)schemaObj.getISOCtryLangTableObj().readISOCtryLangByIdIdx( refCtry.getRequiredISOCtryId(),
			refLang.getRequiredISOLangId() );
			if( origISOCtryLang == null ) {
				editISOCtryLang = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editISOCtryLang = (ISecureISOCtryLangEditObj)origISOCtryLang.beginEdit();
						editISOCtryLang.setRequiredParentLang( editBuff.getRequiredParentLang() );
						break;
					case Replace:
						editISOCtryLang = (ISecureISOCtryLangEditObj)origISOCtryLang.beginEdit();
						editISOCtryLang.deleteInstance();
						editISOCtryLang = null;
						origISOCtryLang = null;
						editISOCtryLang = editBuff;
						break;
				}
			}

			if( editISOCtryLang != null ) {
				if( origISOCtryLang != null ) {
					editISOCtryLang.update();
				}
				else {
					origISOCtryLang = (ISecureISOCtryLangObj)editISOCtryLang.create();
				}
				editISOCtryLang = null;
			}

			curContext.putNamedValue( "Object", origISOCtryLang );
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
