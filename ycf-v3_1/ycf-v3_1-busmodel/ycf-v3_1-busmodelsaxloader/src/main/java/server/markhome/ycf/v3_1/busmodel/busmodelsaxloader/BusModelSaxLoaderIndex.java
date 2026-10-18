
// Description: Java 25 XML SAX Element Handler for Index

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
 *	BusModelSaxLoaderIndexParse XML SAX Element Handler implementation
 *	for Index.
 */
public class BusModelSaxLoaderIndex
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderIndex( BusModelSaxLoader saxLoader ) {
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
		IBusModelIndexObj origBuff = null;
		IBusModelIndexEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// Scope Attributes
		// Scope References
		IBusModelTenantObj refTenant = null;
		// Index Attributes
		String attrName = null;
		String attrShortName = null;
		String attrLabel = null;
		String attrShortDescription = null;
		String attrDescription = null;
		String attrDbName = null;
		String attrSuffix = null;
		String attrIsUnique = null;
		String attrIsDbMapped = null;
		String attrCodeVis = null;
		String attrDefSchema = null;
		// Index References
		IBusModelTableObj refTable = null;
		IBusModelSchemaDefObj refDefSchema = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "Index" );

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
			origBuff = (IBusModelIndexObj)schemaObj.getIndexTableObj().newInstance();
			editBuff = (IBusModelIndexEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "ShortName" ) ) {
					if( attrShortName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Label" ) ) {
					if( attrLabel != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLabel = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ShortDescription" ) ) {
					if( attrShortDescription != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortDescription = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Suffix" ) ) {
					if( attrSuffix != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSuffix = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsUnique" ) ) {
					if( attrIsUnique != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsUnique = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsDbMapped" ) ) {
					if( attrIsDbMapped != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsDbMapped = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CodeVis" ) ) {
					if( attrCodeVis != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCodeVis = attrs.getValue( idxAttr );
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
			if( attrName == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( ( attrIsUnique == null ) || ( attrIsUnique.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsUnique" );
			}
			if( ( attrIsDbMapped == null ) || ( attrIsDbMapped.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsDbMapped" );
			}
			if( ( attrCodeVis == null ) || ( attrCodeVis.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CodeVis" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "Suffix", attrSuffix );
			curContext.putNamedValue( "IsUnique", attrIsUnique );
			curContext.putNamedValue( "IsDbMapped", attrIsDbMapped );
			curContext.putNamedValue( "CodeVis", attrCodeVis );
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
			String natName = attrName;
			editBuff.setRequiredName( natName );

			String natShortName = attrShortName;
			editBuff.setOptionalShortName( natShortName );

			String natLabel = attrLabel;
			editBuff.setOptionalLabel( natLabel );

			String natShortDescription = attrShortDescription;
			editBuff.setOptionalShortDescription( natShortDescription );

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

			String natSuffix = attrSuffix;
			editBuff.setOptionalSuffix( natSuffix );

			boolean natIsUnique;
			if( attrIsUnique.equals( "true" ) || attrIsUnique.equals( "yes" ) || attrIsUnique.equals( "1" ) ) {
				natIsUnique = true;
			}
			else if( attrIsUnique.equals( "false" ) || attrIsUnique.equals( "no" ) || attrIsUnique.equals( "0" ) ) {
				natIsUnique = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsUnique", attrIsUnique),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsUnique", attrIsUnique));
			}
			editBuff.setRequiredIsUnique( natIsUnique );

			boolean natIsDbMapped;
			if( attrIsDbMapped.equals( "true" ) || attrIsDbMapped.equals( "yes" ) || attrIsDbMapped.equals( "1" ) ) {
				natIsDbMapped = true;
			}
			else if( attrIsDbMapped.equals( "false" ) || attrIsDbMapped.equals( "no" ) || attrIsDbMapped.equals( "0" ) ) {
				natIsDbMapped = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsDbMapped", attrIsDbMapped),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsDbMapped", attrIsDbMapped));
			}
			editBuff.setRequiredIsDbMapped( natIsDbMapped );

			IBusModelSchema.CodeVisibilityEnum natCodeVis = IBusModelSchema.parseCodeVisibilityEnum( attrCodeVis );
			editBuff.setRequiredCodeVis( natCodeVis );

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
			else if( scopeObj instanceof IBusModelTableObj ) {
				refTable = (IBusModelTableObj) scopeObj;
				editBuff.setRequiredContainerTable( refTable );
				refTenant = (IBusModelTenantObj)editBuff.getRequiredOwnerTenant();
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IBusModelTableObj" );
			}

			// Resolve and apply Owner reference

			if( refTenant == null ) {
				if( scopeObj instanceof IBusModelTenantObj ) {
					refTenant = (IBusModelTenantObj) scopeObj;
					editBuff.setRequiredOwnerTenant( refTenant );
				}
				else {
					throw new YCFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<Tenant>" );
				}
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

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getIndexLoaderBehaviour();
			IBusModelIndexEditObj editIndex = null;
			IBusModelIndexObj origIndex = (IBusModelIndexObj)schemaObj.getIndexTableObj().readIndexByUNameIdx( refTable.getRequiredId(),
			editBuff.getRequiredName() );
			if( origIndex == null ) {
				editIndex = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editIndex = (IBusModelIndexEditObj)origIndex.beginEdit();
						editIndex.setRequiredName( editBuff.getRequiredName() );
						editIndex.setOptionalShortName( editBuff.getOptionalShortName() );
						editIndex.setOptionalLabel( editBuff.getOptionalLabel() );
						editIndex.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editIndex.setOptionalDescription( editBuff.getOptionalDescription() );
						editIndex.setOptionalDbName( editBuff.getOptionalDbName() );
						editIndex.setOptionalSuffix( editBuff.getOptionalSuffix() );
						editIndex.setRequiredIsUnique( editBuff.getRequiredIsUnique() );
						editIndex.setRequiredIsDbMapped( editBuff.getRequiredIsDbMapped() );
						editIndex.setRequiredCodeVis( editBuff.getRequiredCodeVis() );
						editIndex.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						break;
					case Replace:
						editIndex = (IBusModelIndexEditObj)origIndex.beginEdit();
						editIndex.deleteInstance();
						editIndex = null;
						origIndex = null;
						editIndex = editBuff;
						break;
				}
			}

			if( editIndex != null ) {
				if( origIndex != null ) {
					editIndex.update();
				}
				else {
					origIndex = (IBusModelIndexObj)editIndex.create();
				}
				editIndex = null;
			}

			curContext.putNamedValue( "Object", origIndex );
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
