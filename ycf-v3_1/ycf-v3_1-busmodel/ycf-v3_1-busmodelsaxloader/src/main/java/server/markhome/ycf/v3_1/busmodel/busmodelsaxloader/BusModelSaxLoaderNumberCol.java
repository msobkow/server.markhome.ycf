
// Description: Java 25 XML SAX Element Handler for NumberCol

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
 *	BusModelSaxLoaderNumberColParse XML SAX Element Handler implementation
 *	for NumberCol.
 */
public class BusModelSaxLoaderNumberCol
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderNumberCol( BusModelSaxLoader saxLoader ) {
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
		IBusModelNumberColObj origBuff = null;
		IBusModelNumberColEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// Value Attributes
		String attrName = null;
		String attrShortName = null;
		String attrLabel = null;
		String attrShortDescription = null;
		String attrDescription = null;
		String attrDefaultXmlValue = null;
		String attrIsNullable = null;
		String attrGenerateId = null;
		String attrImplementsPolymorph = null;
		String attrDefSchema = null;
		// Value References
		IBusModelScopeObj refScope = null;
		IBusModelSchemaDefObj refDefSchema = null;
		// Atom Attributes
		String attrDbName = null;
		// Atom References
		// NumberDef Attributes
		String attrDigits = null;
		String attrPrecis = null;
		String attrInitValue = null;
		String attrMinValue = null;
		String attrMaxValue = null;
		// NumberDef References
		// NumberCol Attributes
		// NumberCol References
		IBusModelTableObj refTable = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "NumberCol" );

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
			origBuff = (IBusModelNumberColObj)schemaObj.getNumberColTableObj().newInstance();
			editBuff = (IBusModelNumberColEditObj)origBuff.beginEdit();

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
				else if( attrLocalName.equals( "DefaultXmlValue" ) ) {
					if( attrDefaultXmlValue != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultXmlValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsNullable" ) ) {
					if( attrIsNullable != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsNullable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenerateId" ) ) {
					if( attrGenerateId != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrGenerateId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ImplementsPolymorph" ) ) {
					if( attrImplementsPolymorph != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrImplementsPolymorph = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Digits" ) ) {
					if( attrDigits != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDigits = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Precis" ) ) {
					if( attrPrecis != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPrecis = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "InitValue" ) ) {
					if( attrInitValue != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrInitValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "MinValue" ) ) {
					if( attrMinValue != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrMinValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "MaxValue" ) ) {
					if( attrMaxValue != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrMaxValue = attrs.getValue( idxAttr );
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
			if( ( attrIsNullable == null ) || ( attrIsNullable.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsNullable" );
			}
			if( ( attrImplementsPolymorph == null ) || ( attrImplementsPolymorph.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ImplementsPolymorph" );
			}
			if( ( attrDigits == null ) || ( attrDigits.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Digits" );
			}
			if( ( attrPrecis == null ) || ( attrPrecis.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Precis" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "DefaultXmlValue", attrDefaultXmlValue );
			curContext.putNamedValue( "IsNullable", attrIsNullable );
			curContext.putNamedValue( "GenerateId", attrGenerateId );
			curContext.putNamedValue( "ImplementsPolymorph", attrImplementsPolymorph );
			curContext.putNamedValue( "DefSchema", attrDefSchema );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "Digits", attrDigits );
			curContext.putNamedValue( "Precis", attrPrecis );
			curContext.putNamedValue( "InitValue", attrInitValue );
			curContext.putNamedValue( "MinValue", attrMinValue );
			curContext.putNamedValue( "MaxValue", attrMaxValue );

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

			String natDefaultXmlValue = attrDefaultXmlValue;
			editBuff.setOptionalDefaultXmlValue( natDefaultXmlValue );

			boolean natIsNullable;
			if( attrIsNullable.equals( "true" ) || attrIsNullable.equals( "yes" ) || attrIsNullable.equals( "1" ) ) {
				natIsNullable = true;
			}
			else if( attrIsNullable.equals( "false" ) || attrIsNullable.equals( "no" ) || attrIsNullable.equals( "0" ) ) {
				natIsNullable = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsNullable", attrIsNullable),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "IsNullable", attrIsNullable));
			}
			editBuff.setRequiredIsNullable( natIsNullable );

			Boolean natGenerateId;
			if( ( attrGenerateId == null ) || ( attrGenerateId.length() <= 0 ) ) {
				natGenerateId = null;
			}
			else if( attrGenerateId.equals( "true" ) || attrGenerateId.equals( "yes" ) || attrGenerateId.equals( "1" ) ) {
				natGenerateId = true;
			}
			else if( attrGenerateId.equals( "false" ) || attrGenerateId.equals( "no" ) || attrGenerateId.equals( "0" ) ) {
				natGenerateId = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "GenerateId", attrGenerateId),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "GenerateId", attrGenerateId));
			}
			editBuff.setOptionalGenerateId( natGenerateId );

			boolean natImplementsPolymorph;
			if( attrImplementsPolymorph.equals( "true" ) || attrImplementsPolymorph.equals( "yes" ) || attrImplementsPolymorph.equals( "1" ) ) {
				natImplementsPolymorph = true;
			}
			else if( attrImplementsPolymorph.equals( "false" ) || attrImplementsPolymorph.equals( "no" ) || attrImplementsPolymorph.equals( "0" ) ) {
				natImplementsPolymorph = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "ImplementsPolymorph", attrImplementsPolymorph),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "ImplementsPolymorph", attrImplementsPolymorph));
			}
			editBuff.setRequiredImplementsPolymorph( natImplementsPolymorph );

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

			short natDigits = Short.parseShort( attrDigits );
			editBuff.setRequiredDigits( natDigits );

			short natPrecis = Short.parseShort( attrPrecis );
			editBuff.setRequiredPrecis( natPrecis );

			BigDecimal natInitValue;
			if( ( attrInitValue == null ) || ( attrInitValue.length() <= 0 ) ) {
				natInitValue = null;
			}
			else {
				natInitValue= YCFLibBigDecimalUtil.parse( "BusModel.NumberDef.InitValue", "BusModel.NumberDef.InitValue", 31, 5, attrInitValue );
			}
			editBuff.setOptionalInitValue( natInitValue );

			BigDecimal natMinValue;
			if( ( attrMinValue == null ) || ( attrMinValue.length() <= 0 ) ) {
				natMinValue = null;
			}
			else {
				natMinValue= YCFLibBigDecimalUtil.parse( "BusModel.NumberDef.MinValue", "BusModel.NumberDef.MinValue", 31, 5, attrMinValue );
			}
			editBuff.setOptionalMinValue( natMinValue );

			BigDecimal natMaxValue;
			if( ( attrMaxValue == null ) || ( attrMaxValue.length() <= 0 ) ) {
				natMaxValue = null;
			}
			else {
				natMaxValue= YCFLibBigDecimalUtil.parse( "BusModel.NumberDef.MaxValue", "BusModel.NumberDef.MaxValue", 31, 5, attrMaxValue );
			}
			editBuff.setOptionalMaxValue( natMaxValue );

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
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IBusModelTableObj" );
			}

			refScope = refTable;
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

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getNumberColLoaderBehaviour();
			IBusModelNumberColEditObj editNumberCol = null;
			IBusModelNumberColObj origNumberCol = (IBusModelNumberColObj)schemaObj.getNumberColTableObj().readNumberColByUNameIdx( refScope.getRequiredId(),
			editBuff.getRequiredName() );
			if( origNumberCol == null ) {
				editNumberCol = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editNumberCol = (IBusModelNumberColEditObj)origNumberCol.beginEdit();
						editNumberCol.setRequiredName( editBuff.getRequiredName() );
						editNumberCol.setOptionalShortName( editBuff.getOptionalShortName() );
						editNumberCol.setOptionalLabel( editBuff.getOptionalLabel() );
						editNumberCol.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editNumberCol.setOptionalDescription( editBuff.getOptionalDescription() );
						editNumberCol.setOptionalDefaultXmlValue( editBuff.getOptionalDefaultXmlValue() );
						editNumberCol.setRequiredIsNullable( editBuff.getRequiredIsNullable() );
						editNumberCol.setOptionalGenerateId( editBuff.getOptionalGenerateId() );
						editNumberCol.setRequiredImplementsPolymorph( editBuff.getRequiredImplementsPolymorph() );
						editNumberCol.setOptionalDbName( editBuff.getOptionalDbName() );
						editNumberCol.setRequiredDigits( editBuff.getRequiredDigits() );
						editNumberCol.setRequiredPrecis( editBuff.getRequiredPrecis() );
						editNumberCol.setOptionalInitValue( editBuff.getOptionalInitValue() );
						editNumberCol.setOptionalMinValue( editBuff.getOptionalMinValue() );
						editNumberCol.setOptionalMaxValue( editBuff.getOptionalMaxValue() );
						editNumberCol.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						break;
					case Replace:
						editNumberCol = (IBusModelNumberColEditObj)origNumberCol.beginEdit();
						editNumberCol.deleteInstance();
						editNumberCol = null;
						origNumberCol = null;
						editNumberCol = editBuff;
						break;
				}
			}

			if( editNumberCol != null ) {
				if( origNumberCol != null ) {
					editNumberCol.update();
				}
				else {
					origNumberCol = (IBusModelNumberColObj)editNumberCol.create();
				}
				editNumberCol = null;
			}

			curContext.putNamedValue( "Object", origNumberCol );
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
