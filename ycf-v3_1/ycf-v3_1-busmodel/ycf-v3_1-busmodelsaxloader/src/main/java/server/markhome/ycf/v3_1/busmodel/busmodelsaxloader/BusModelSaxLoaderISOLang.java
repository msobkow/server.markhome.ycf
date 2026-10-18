
// Description: Java 25 XML SAX Element Handler for ISOLang

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelsaxloader;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	BusModelSaxLoaderISOLangParse XML SAX Element Handler implementation
 *	for ISOLang.
 */
public class BusModelSaxLoaderISOLang
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderISOLang( BusModelSaxLoader saxLoader ) {
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
		IBusModelISOLangObj origBuff = null;
		IBusModelISOLangEditObj editBuff = null;
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

			BusModelSaxLoader saxLoader = (BusModelSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			IBusModelSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			origBuff = (IBusModelISOLangObj)schemaObj.getISOLangTableObj().newInstance();
			editBuff = (IBusModelISOLangEditObj)origBuff.beginEdit();

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

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getISOLangLoaderBehaviour();
			IBusModelISOLangEditObj editISOLang = null;
			IBusModelISOLangObj origISOLang = (IBusModelISOLangObj)schemaObj.getISOLangTableObj().readISOLangByCode3Idx( editBuff.getRequiredISO6392Code() );
			if( origISOLang == null ) {
				editISOLang = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editISOLang = (IBusModelISOLangEditObj)origISOLang.beginEdit();
						editISOLang.setRequiredISO6392Code( editBuff.getRequiredISO6392Code() );
						editISOLang.setOptionalISO6391Code( editBuff.getOptionalISO6391Code() );
						editISOLang.setRequiredEnglishName( editBuff.getRequiredEnglishName() );
						break;
					case Replace:
						editISOLang = (IBusModelISOLangEditObj)origISOLang.beginEdit();
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
					origISOLang = (IBusModelISOLangObj)editISOLang.create();
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
