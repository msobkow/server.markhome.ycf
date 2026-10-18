
// Description: Java 25 XML SAX Element Handler for SecSysRoleEnables

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
 *	BusModelSaxLoaderSecSysRoleEnablesParse XML SAX Element Handler implementation
 *	for SecSysRoleEnables.
 */
public class BusModelSaxLoaderSecSysRoleEnables
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderSecSysRoleEnables( BusModelSaxLoader saxLoader ) {
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
		IBusModelSecSysRoleEnablesObj origBuff = null;
		IBusModelSecSysRoleEnablesEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecSysRoleEnables Attributes
		String attrEnableGroup = null;
		// SecSysRoleEnables References
		IBusModelSecSysRoleObj refSysRole = null;
		IBusModelSecSysGrpObj refEnableGroup = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecSysRoleEnables" );

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
			origBuff = (IBusModelSecSysRoleEnablesObj)schemaObj.getSecSysRoleEnablesTableObj().newInstance();
			editBuff = (IBusModelSecSysRoleEnablesEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "EnableGroup" ) ) {
					if( attrEnableGroup != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEnableGroup = attrs.getValue( idxAttr );
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
			if( ( attrEnableGroup == null ) || ( attrEnableGroup.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"EnableGroup" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "EnableGroup", attrEnableGroup );

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
			else if( scopeObj instanceof IBusModelSecSysRoleObj ) {
				refSysRole = (IBusModelSecSysRoleObj) scopeObj;
				editBuff.setRequiredContainerSysRole( refSysRole );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IBusModelSecSysRoleObj" );
			}

			// Lookup refEnableGroup by key name value attr
			if( ( attrEnableGroup != null ) && ( attrEnableGroup.length() > 0 ) ) {
				refEnableGroup = (IBusModelSecSysGrpObj)schemaObj.getSecSysGrpTableObj().readSecSysGrpByUNameIdx( attrEnableGroup );
				if( refEnableGroup == null ) {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve EnableGroup reference named \"" + attrEnableGroup + "\" to table SecSysGrp" );
				}
			}
			else {
				refEnableGroup = null;
			}
			editBuff.setRequiredParentEnableGroup( refEnableGroup );

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecSysRoleEnablesLoaderBehaviour();
			IBusModelSecSysRoleEnablesEditObj editSecSysRoleEnables = null;
			IBusModelSecSysRoleEnablesObj origSecSysRoleEnables = (IBusModelSecSysRoleEnablesObj)schemaObj.getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByIdIdx( refSysRole.getRequiredSecSysRoleId(),
			refEnableGroup.getRequiredName() );
			if( origSecSysRoleEnables == null ) {
				editSecSysRoleEnables = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecSysRoleEnables = (IBusModelSecSysRoleEnablesEditObj)origSecSysRoleEnables.beginEdit();
						editSecSysRoleEnables.setRequiredParentEnableGroup( editBuff.getRequiredParentEnableGroup() );
						break;
					case Replace:
						editSecSysRoleEnables = (IBusModelSecSysRoleEnablesEditObj)origSecSysRoleEnables.beginEdit();
						editSecSysRoleEnables.deleteInstance();
						editSecSysRoleEnables = null;
						origSecSysRoleEnables = null;
						editSecSysRoleEnables = editBuff;
						break;
				}
			}

			if( editSecSysRoleEnables != null ) {
				if( origSecSysRoleEnables != null ) {
					editSecSysRoleEnables.update();
				}
				else {
					origSecSysRoleEnables = (IBusModelSecSysRoleEnablesObj)editSecSysRoleEnables.create();
				}
				editSecSysRoleEnables = null;
			}

			curContext.putNamedValue( "Object", origSecSysRoleEnables );
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
