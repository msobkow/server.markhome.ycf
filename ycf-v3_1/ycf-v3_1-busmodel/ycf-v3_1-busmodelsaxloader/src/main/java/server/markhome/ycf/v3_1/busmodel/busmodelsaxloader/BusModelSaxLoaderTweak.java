
// Description: Java 25 XML SAX Element Handler for Tweak

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
 *	BusModelSaxLoaderTweakParse XML SAX Element Handler implementation
 *	for Tweak.
 */
public class BusModelSaxLoaderTweak
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderTweak( BusModelSaxLoader saxLoader ) {
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
		IBusModelTweakObj origBuff = null;
		IBusModelTweakEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// Tweak Attributes
		String attrTenantId = null;
		String attrDefSchemaTenantId = null;
		String attrName = null;
		String attrReplacesInherited = null;
		String attrTweakGelText = null;
		String attrDefSchema = null;
		// Tweak References
		IBusModelScopeObj refScopeDef = null;
		IBusModelSchemaDefObj refDefSchema = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "Tweak" );

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
			origBuff = (IBusModelTweakObj)schemaObj.getTweakTableObj().newInstance();
			editBuff = (IBusModelTweakEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "TenantId" ) ) {
					if( attrTenantId != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefSchemaTenantId" ) ) {
					if( attrDefSchemaTenantId != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchemaTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Name" ) ) {
					if( attrName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ReplacesInherited" ) ) {
					if( attrReplacesInherited != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrReplacesInherited = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TweakGelText" ) ) {
					if( attrTweakGelText != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTweakGelText = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefSchema" ) ) {
					if( attrDefSchema != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchema = attrs.getValue( idxAttr );
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
			if( ( attrTenantId == null ) || ( attrTenantId.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TenantId" );
			}
			if( attrName == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( ( attrReplacesInherited == null ) || ( attrReplacesInherited.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ReplacesInherited" );
			}
			if( attrTweakGelText == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TweakGelText" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "TenantId", attrTenantId );
			curContext.putNamedValue( "DefSchemaTenantId", attrDefSchemaTenantId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ReplacesInherited", attrReplacesInherited );
			curContext.putNamedValue( "TweakGelText", attrTweakGelText );
			curContext.putNamedValue( "DefSchema", attrDefSchema );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			YCFLibDbKeyHash256 natTenantId;
			try {
				natTenantId = YCFLibDbKeyHash256.fromHex( attrTenantId );
			}
			catch( RuntimeException e ) {
				throw new YCFLibInvalidArgumentException( getClass(),
					S_ProcName,
					0,
					"TenantId",
					e );
			}
			editBuff.setRequiredTenantId( natTenantId );

			YCFLibDbKeyHash256 natDefSchemaTenantId;
			if( ( attrDefSchemaTenantId == null ) || ( attrDefSchemaTenantId.length() <= 0 ) ) {
				natDefSchemaTenantId = null;
			}
			else {
				try {
					natDefSchemaTenantId = YCFLibDbKeyHash256.fromHex( attrDefSchemaTenantId );
				}
				catch( RuntimeException e ) {
					throw new YCFLibInvalidArgumentException( getClass(),
						S_ProcName,
						0,
						"DefSchemaTenantId",
						e );
				}
			}
			editBuff.setOptionalDefSchemaTenantId( natDefSchemaTenantId );

			String natName = attrName;
			editBuff.setRequiredName( natName );

			boolean natReplacesInherited;
			if( attrReplacesInherited.equals( "true" ) || attrReplacesInherited.equals( "yes" ) || attrReplacesInherited.equals( "1" ) ) {
				natReplacesInherited = true;
			}
			else if( attrReplacesInherited.equals( "false" ) || attrReplacesInherited.equals( "no" ) || attrReplacesInherited.equals( "0" ) ) {
				natReplacesInherited = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "ReplacesInherited", attrReplacesInherited),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "ReplacesInherited", attrReplacesInherited));
			}
			editBuff.setRequiredReplacesInherited( natReplacesInherited );

			String natTweakGelText = attrTweakGelText;
			editBuff.setRequiredTweakGelText( natTweakGelText );

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
			else if( scopeObj instanceof IBusModelScopeObj ) {
				refScopeDef = (IBusModelScopeObj) scopeObj;
				editBuff.setRequiredContainerScopeDef( refScopeDef );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IBusModelScopeObj" );
			}

			// Lookup refDefSchema by qualified name
			if( ( attrDefSchema != null ) && ( attrDefSchema.length() > 0 ) ) {
				refDefSchema = (IBusModelSchemaDefObj)(editBuff.getNamedObject( schemaObj.getSchemaDefTableObj().getObjQualifyingClass(),
					attrDefSchema ) );
				if( refDefSchema == null ) {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DefSchema reference qualified name \"" + attrDefSchema + "\" to table SchemaDef" );
				}
			}
			else {
				refDefSchema = null;
			}
			editBuff.setOptionalLookupDefSchema( refDefSchema );

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTweakLoaderBehaviour();
			IBusModelTweakEditObj editTweak = null;
			IBusModelTweakObj origTweak = (IBusModelTweakObj)schemaObj.getTweakTableObj().readTweakByUNameIdx( refScopeDef.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTweak == null ) {
				editTweak = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTweak = (IBusModelTweakEditObj)origTweak.beginEdit();
						editTweak.setRequiredTenantId( editBuff.getRequiredTenantId() );
						editTweak.setOptionalDefSchemaTenantId( editBuff.getOptionalDefSchemaTenantId() );
						editTweak.setRequiredName( editBuff.getRequiredName() );
						editTweak.setRequiredReplacesInherited( editBuff.getRequiredReplacesInherited() );
						editTweak.setRequiredTweakGelText( editBuff.getRequiredTweakGelText() );
						editTweak.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						break;
					case Replace:
						editTweak = (IBusModelTweakEditObj)origTweak.beginEdit();
						editTweak.deleteInstance();
						editTweak = null;
						origTweak = null;
						editTweak = editBuff;
						break;
				}
			}

			if( editTweak != null ) {
				if( origTweak != null ) {
					editTweak.update();
				}
				else {
					origTweak = (IBusModelTweakObj)editTweak.create();
				}
				editTweak = null;
			}

			curContext.putNamedValue( "Object", origTweak );
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
