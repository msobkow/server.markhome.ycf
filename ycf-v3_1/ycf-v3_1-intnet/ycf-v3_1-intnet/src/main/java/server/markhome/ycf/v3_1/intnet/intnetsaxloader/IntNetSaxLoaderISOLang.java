
// Description: Java 25 XML SAX Element Handler for ISOLang

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetsaxloader;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/*
 *	IntNetSaxLoaderISOLangParse XML SAX Element Handler implementation
 *	for ISOLang.
 */
public class IntNetSaxLoaderISOLang
	extends YCFLibXmlCoreElementHandler
{
	public IntNetSaxLoaderISOLang( IntNetSaxLoader saxLoader ) {
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
		IIntNetISOLangObj origBuff = null;
		IIntNetISOLangEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// ISOLang Attributes
		String attrISO6392Code = null;
		String attrISO6391Code = null;
		String attrEnglishName = null;
		// ISOLang References
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "ISOLang" );

			IntNetSaxLoader saxLoader = (IntNetSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			IIntNetSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			origBuff = (IIntNetISOLangObj)schemaObj.getISOLangTableObj().newInstance();
			editBuff = (IIntNetISOLangEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "ISO6392Code" ) ) {
					if( attrISO6392Code != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrISO6392Code = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ISO6391Code" ) ) {
					if( attrISO6391Code != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrISO6391Code = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EnglishName" ) ) {
					if( attrEnglishName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEnglishName = attrs.getValue( idxAttr );
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
			if( attrISO6392Code == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ISO6392Code" );
			}
			if( attrEnglishName == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"EnglishName" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "ISO6392Code", attrISO6392Code );
			curContext.putNamedValue( "ISO6391Code", attrISO6391Code );
			curContext.putNamedValue( "EnglishName", attrEnglishName );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natISO6392Code = attrISO6392Code;
			editBuff.setRequiredISO6392Code( natISO6392Code );

			String natISO6391Code = attrISO6391Code;
			editBuff.setOptionalISO6391Code( natISO6391Code );

			String natEnglishName = attrEnglishName;
			editBuff.setRequiredEnglishName( natEnglishName );

			// Get the scope/container object

			YCFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			IntNetSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getISOLangLoaderBehaviour();
			IIntNetISOLangEditObj editISOLang = null;
			IIntNetISOLangObj origISOLang = (IIntNetISOLangObj)schemaObj.getISOLangTableObj().readISOLangByCode3Idx( editBuff.getRequiredISO6392Code() );
			if( origISOLang == null ) {
				editISOLang = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editISOLang = (IIntNetISOLangEditObj)origISOLang.beginEdit();
						editISOLang.setRequiredISO6392Code( editBuff.getRequiredISO6392Code() );
						editISOLang.setOptionalISO6391Code( editBuff.getOptionalISO6391Code() );
						editISOLang.setRequiredEnglishName( editBuff.getRequiredEnglishName() );
						break;
					case Replace:
						editISOLang = (IIntNetISOLangEditObj)origISOLang.beginEdit();
						editISOLang.deleteInstance();
						editISOLang = null;
						origISOLang = null;
						editISOLang = editBuff;
						break;
				}
			}

			if( editISOLang != null ) {
				if( origISOLang != null ) {
					editISOLang.update();
				}
				else {
					origISOLang = (IIntNetISOLangObj)editISOLang.create();
				}
				editISOLang = null;
			}

			curContext.putNamedValue( "Object", origISOLang );
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
