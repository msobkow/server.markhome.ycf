
// Description: Java 25 XML SAX Element Handler for TopProject

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
 *	IntNetSaxLoaderTopProjectParse XML SAX Element Handler implementation
 *	for TopProject.
 */
public class IntNetSaxLoaderTopProject
	extends YCFLibXmlCoreElementHandler
{
	public IntNetSaxLoaderTopProject( IntNetSaxLoader saxLoader ) {
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
		IIntNetTopProjectObj origBuff = null;
		IIntNetTopProjectEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// TopProject Attributes
		String attrName = null;
		String attrDescription = null;
		// TopProject References
		IIntNetTenantObj refTenant = null;
		IIntNetTopDomainObj refParentSDom = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "TopProject" );

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
			origBuff = (IIntNetTopProjectObj)schemaObj.getTopProjectTableObj().newInstance();
			editBuff = (IIntNetTopProjectEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "Description" ) ) {
					if( attrDescription != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDescription = attrs.getValue( idxAttr );
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

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "Description", attrDescription );

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

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

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
			else if( scopeObj instanceof IIntNetTopDomainObj ) {
				refParentSDom = (IIntNetTopDomainObj) scopeObj;
				editBuff.setRequiredContainerParentSDom( refParentSDom );
				refTenant = (IIntNetTenantObj)editBuff.getRequiredOwnerTenant();
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IIntNetTopDomainObj" );
			}

			// Resolve and apply Owner reference

			if( refTenant == null ) {
				if( scopeObj instanceof IIntNetTenantObj ) {
					refTenant = (IIntNetTenantObj) scopeObj;
					editBuff.setRequiredOwnerTenant( refTenant );
				}
				else {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<Tenant>" );
				}
			}

			IntNetSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTopProjectLoaderBehaviour();
			IIntNetTopProjectEditObj editTopProject = null;
			IIntNetTopProjectObj origTopProject = (IIntNetTopProjectObj)schemaObj.getTopProjectTableObj().readTopProjectByNameIdx( refParentSDom.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTopProject == null ) {
				editTopProject = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTopProject = (IIntNetTopProjectEditObj)origTopProject.beginEdit();
						editTopProject.setRequiredName( editBuff.getRequiredName() );
						editTopProject.setOptionalDescription( editBuff.getOptionalDescription() );
						break;
					case Replace:
						editTopProject = (IIntNetTopProjectEditObj)origTopProject.beginEdit();
						editTopProject.deleteInstance();
						editTopProject = null;
						origTopProject = null;
						editTopProject = editBuff;
						break;
				}
			}

			if( editTopProject != null ) {
				if( origTopProject != null ) {
					editTopProject.update();
				}
				else {
					origTopProject = (IIntNetTopProjectObj)editTopProject.create();
				}
				editTopProject = null;
			}

			curContext.putNamedValue( "Object", origTopProject );
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
