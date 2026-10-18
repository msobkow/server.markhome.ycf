
// Description: Java 25 XML SAX Element Handler for SecTentRoleMemb

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
 *	SecureSaxLoaderSecTentRoleMembParse XML SAX Element Handler implementation
 *	for SecTentRoleMemb.
 */
public class SecureSaxLoaderSecTentRoleMemb
	extends YCFLibXmlCoreElementHandler
{
	public SecureSaxLoaderSecTentRoleMemb( SecureSaxLoader saxLoader ) {
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
		ISecureSecTentRoleMembObj origBuff = null;
		ISecureSecTentRoleMembEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecTentRoleMemb Attributes
		String attrUser = null;
		// SecTentRoleMemb References
		ISecureSecTentRoleObj refRole = null;
		ISecureSecUserObj refUser = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecTentRoleMemb" );

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
			origBuff = (ISecureSecTentRoleMembObj)schemaObj.getSecTentRoleMembTableObj().newInstance();
			editBuff = (ISecureSecTentRoleMembEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "User" ) ) {
					if( attrUser != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrUser = attrs.getValue( idxAttr );
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
			if( ( attrUser == null ) || ( attrUser.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"User" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "User", attrUser );

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
			else if( scopeObj instanceof ISecureSecTentRoleObj ) {
				refRole = (ISecureSecTentRoleObj) scopeObj;
				editBuff.setRequiredContainerRole( refRole );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ISecureSecTentRoleObj" );
			}

			// Lookup refUser by key name value attr
			if( ( attrUser != null ) && ( attrUser.length() > 0 ) ) {
				refUser = (ISecureSecUserObj)schemaObj.getSecUserTableObj().readSecUserByULoginIdx( attrUser );
				if( refUser == null ) {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve User reference named \"" + attrUser + "\" to table SecUser" );
				}
			}
			else {
				refUser = null;
			}
			editBuff.setRequiredParentUser( refUser );

			SecureSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecTentRoleMembLoaderBehaviour();
			ISecureSecTentRoleMembEditObj editSecTentRoleMemb = null;
			ISecureSecTentRoleMembObj origSecTentRoleMemb = (ISecureSecTentRoleMembObj)schemaObj.getSecTentRoleMembTableObj().readSecTentRoleMembByIdIdx( refRole.getRequiredSecTentRoleId(),
			refUser.getRequiredLoginId() );
			if( origSecTentRoleMemb == null ) {
				editSecTentRoleMemb = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecTentRoleMemb = (ISecureSecTentRoleMembEditObj)origSecTentRoleMemb.beginEdit();
						editSecTentRoleMemb.setRequiredParentUser( editBuff.getRequiredParentUser() );
						break;
					case Replace:
						editSecTentRoleMemb = (ISecureSecTentRoleMembEditObj)origSecTentRoleMemb.beginEdit();
						editSecTentRoleMemb.deleteInstance();
						editSecTentRoleMemb = null;
						origSecTentRoleMemb = null;
						editSecTentRoleMemb = editBuff;
						break;
				}
			}

			if( editSecTentRoleMemb != null ) {
				if( origSecTentRoleMemb != null ) {
					editSecTentRoleMemb.update();
				}
				else {
					origSecTentRoleMemb = (ISecureSecTentRoleMembObj)editSecTentRoleMemb.create();
				}
				editSecTentRoleMemb = null;
			}

			curContext.putNamedValue( "Object", origSecTentRoleMemb );
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
