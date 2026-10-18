
// Description: Java 25 XML SAX Element Handler for SecSysRoleEnables

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
 *	IntNetSaxLoaderSecSysRoleEnablesParse XML SAX Element Handler implementation
 *	for SecSysRoleEnables.
 */
public class IntNetSaxLoaderSecSysRoleEnables
	extends YCFLibXmlCoreElementHandler
{
	public IntNetSaxLoaderSecSysRoleEnables( IntNetSaxLoader saxLoader ) {
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
		IIntNetSecSysRoleEnablesObj origBuff = null;
		IIntNetSecSysRoleEnablesEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecSysRoleEnables Attributes
		String attrEnableGroup = null;
		// SecSysRoleEnables References
		IIntNetSecSysRoleObj refSysRole = null;
		IIntNetSecSysGrpObj refEnableGroup = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecSysRoleEnables" );

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
			origBuff = (IIntNetSecSysRoleEnablesObj)schemaObj.getSecSysRoleEnablesTableObj().newInstance();
			editBuff = (IIntNetSecSysRoleEnablesEditObj)origBuff.beginEdit();

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
			else if( scopeObj instanceof IIntNetSecSysRoleObj ) {
				refSysRole = (IIntNetSecSysRoleObj) scopeObj;
				editBuff.setRequiredContainerSysRole( refSysRole );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IIntNetSecSysRoleObj" );
			}

			// Lookup refEnableGroup by key name value attr
			if( ( attrEnableGroup != null ) && ( attrEnableGroup.length() > 0 ) ) {
				refEnableGroup = (IIntNetSecSysGrpObj)schemaObj.getSecSysGrpTableObj().readSecSysGrpByUNameIdx( attrEnableGroup );
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

			IntNetSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecSysRoleEnablesLoaderBehaviour();
			IIntNetSecSysRoleEnablesEditObj editSecSysRoleEnables = null;
			IIntNetSecSysRoleEnablesObj origSecSysRoleEnables = (IIntNetSecSysRoleEnablesObj)schemaObj.getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByIdIdx( refSysRole.getRequiredSecSysRoleId(),
			refEnableGroup.getRequiredName() );
			if( origSecSysRoleEnables == null ) {
				editSecSysRoleEnables = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecSysRoleEnables = (IIntNetSecSysRoleEnablesEditObj)origSecSysRoleEnables.beginEdit();
						editSecSysRoleEnables.setRequiredParentEnableGroup( editBuff.getRequiredParentEnableGroup() );
						break;
					case Replace:
						editSecSysRoleEnables = (IIntNetSecSysRoleEnablesEditObj)origSecSysRoleEnables.beginEdit();
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
					origSecSysRoleEnables = (IIntNetSecSysRoleEnablesObj)editSecSysRoleEnables.create();
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
