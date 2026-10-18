
// Description: Java 25 XML SAX Element Handler for SecSysGrp

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
 *	SecureSaxLoaderSecSysGrpParse XML SAX Element Handler implementation
 *	for SecSysGrp.
 */
public class SecureSaxLoaderSecSysGrp
	extends YCFLibXmlCoreElementHandler
{
	public SecureSaxLoaderSecSysGrp( SecureSaxLoader saxLoader ) {
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
		ISecureSecSysGrpObj origBuff = null;
		ISecureSecSysGrpEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecSysGrp Attributes
		String attrName = null;
		String attrSecLevel = null;
		String attrImplSysRole = null;
		// SecSysGrp References
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecSysGrp" );

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
			origBuff = (ISecureSecSysGrpObj)schemaObj.getSecSysGrpTableObj().newInstance();
			editBuff = (ISecureSecSysGrpEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "Name" ) ) {
					if( attrName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SecLevel" ) ) {
					if( attrSecLevel != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecLevel = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ImplSysRole" ) ) {
					if( attrImplSysRole != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrImplSysRole = attrs.getValue( idxAttr );
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
			if( attrName == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( ( attrSecLevel == null ) || ( attrSecLevel.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecLevel" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "SecLevel", attrSecLevel );
			curContext.putNamedValue( "ImplSysRole", attrImplSysRole );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natName = attrName;
			editBuff.setRequiredName( natName );

			ISecureSchema.SecLevelEnum natSecLevel = ISecureSchema.parseSecLevelEnum( attrSecLevel );
			editBuff.setRequiredSecLevel( natSecLevel );

			// Get the scope/container object

			YCFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			SecureSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecSysGrpLoaderBehaviour();
			ISecureSecSysGrpEditObj editSecSysGrp = null;
			ISecureSecSysGrpObj origSecSysGrp = (ISecureSecSysGrpObj)schemaObj.getSecSysGrpTableObj().readSecSysGrpByUNameIdx( editBuff.getRequiredName() );
			if( origSecSysGrp == null ) {
				editSecSysGrp = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecSysGrp = (ISecureSecSysGrpEditObj)origSecSysGrp.beginEdit();
						editSecSysGrp.setRequiredName( editBuff.getRequiredName() );
						editSecSysGrp.setRequiredSecLevel( editBuff.getRequiredSecLevel() );
						break;
					case Replace:
						editSecSysGrp = (ISecureSecSysGrpEditObj)origSecSysGrp.beginEdit();
						editSecSysGrp.deleteInstance();
						editSecSysGrp = null;
						origSecSysGrp = null;
						editSecSysGrp = editBuff;
						break;
				}
			}

			if( editSecSysGrp != null ) {
				if( origSecSysGrp != null ) {
					editSecSysGrp.update();
				}
				else {
					origSecSysGrp = (ISecureSecSysGrpObj)editSecSysGrp.create();
				}
				editSecSysGrp = null;
			}

			curContext.putNamedValue( "Object", origSecSysGrp );
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
