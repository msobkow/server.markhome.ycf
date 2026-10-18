// Description: Java 17 implJustProtementation of a ServerMethod buffer

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbam.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprot.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprotobj.*;

public class CFBamProtBuffServerMethod
	extends CFBamProtBuffScope
	implements ICFBamServerMethod
{
	protected IMCFKeyHash256 requiredTableId;
	protected IMCFKeyHash256 optionalDefSchemaId;
	protected String requiredName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected String optionalSuffix;
	protected boolean requiredIsInstanceMethod;
	protected boolean requiredIsServerOnly;
	protected ICFBamPubSchema.CodeVisibilityEnum requiredCodeVis;
	protected String requiredJMethodBody;
	protected String requiredCppMethodBody;
	protected String requiredCsMethodBody;

	public CFBamProtBuffServerMethod() {
		super();
		requiredTableId = MCFDbKeyHash256.fromHex( ICFBamPubServerMethod.TABLEID_INIT_VALUE.toString() );
		optionalDefSchemaId = MCFDbKeyHash256.nullGet();
		requiredName = ICFBamPubServerMethod.NAME_INIT_VALUE;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		optionalSuffix = null;
		requiredIsInstanceMethod = ICFBamPubServerMethod.ISINSTANCEMETHOD_INIT_VALUE;
		requiredIsServerOnly = ICFBamPubServerMethod.ISSERVERONLY_INIT_VALUE;
		requiredCodeVis = ICFBamPubServerMethod.CODEVIS_INIT_VALUE;
		requiredJMethodBody = ICFBamPubServerMethod.JMETHODBODY_INIT_VALUE;
		requiredCppMethodBody = ICFBamPubServerMethod.CPPMETHODBODY_INIT_VALUE;
		requiredCsMethodBody = ICFBamPubServerMethod.CSMETHODBODY_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( ICFBamProtServerMethod.CLASS_CODE );
	}

	@Override
	public ICFBamProtSchemaDef getOptionalLookupDefSchema(IMCFKeyHash256 argDefSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "ICFBamProtSchema.getBackingCFBam().getTableSchemaDef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalDefSchemaId()));
	}

	@Override
	public void setOptionalLookupDefSchema(IMCFKeyHash256 argDefSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupDefSchema-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaDef()");
		}
		ICFBamProtSchemaDef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDefSchemaId);
		if (found == null || (found != null && ((found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamPubSchemaDef)))) {
			super.setOptionalLookupDefSchema(argDefSchemaId);
		optionalDefSchemaId = argDefSchemaId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupDefSchema-args", "found", found, "ICFBamProtSchemaDefICFBamProtSchemaDefICFBamPubSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupDefSchema(ICFBamProtSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalDefSchemaId(null);
		}
		else {
			setJustProtOptionalDefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupDefSchema(ICFBamPubSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalDefSchemaId(null);
		}
		else {
			setJustProtOptionalDefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFBamProtTable getRequiredContainerForTable(IMCFKeyHash256 argTableId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerForTable", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtTableTable targetTable = targetBackingCFBam.getTableTable();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerForTable", 0, "ICFBamProtSchema.getBackingCFBam().getTableTable()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTableId()));
	}

	@Override
	public void setRequiredContainerForTable(IMCFKeyHash256 argTableId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerForTable-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtTableTable targetTable = targetBackingCFBam.getTableTable();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerForTable", 0, "ICFBamSchema.getBackingCFBam().getTableTable()");
		}
		ICFBamProtTable found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTableId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerForTable-args", 0, "found");
		}
		else if (found instanceof ICFBamProtTable) || (found instanceof ICFBamProtTable) || (found instanceof ICFBamPubTable)) {
			super.setRequiredContainerForTable(argTableId);
		requiredTableId = argTableId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerForTable-args", "found", found, "ICFBamProtTableICFBamProtTableICFBamPubTable");
		}
	}

	@Override
	public void setRequiredContainerForTable(ICFBamProtTable argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerForTable", 1, "argObj");
		}
		else {
			setJustProtRequiredTableId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerForTable(ICFBamPubTable argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerForTable", 1, "argObj");
		}
		else {
			setJustProtRequiredTableId(argObj.getRequiredId());
		}
	}

	@Override
	public List<ICFBamProtParam> getOptionalComponentsParams(IMCFKeyHash256 argId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsParams", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtParamTable targetTable = targetBackingCFBam.getTableParam();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsParams", 0, "ICFBamProtSchema.getBackingCFBam().getTableParam()");
		}
		ICFBamProtParam[] targetArr = targetTable.readDerivedByServerMethodIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamProtParam> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamProtParam> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredTableId() {
		return(requiredTableId);
	}

	public void setRequiredTableId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredTableId",
				1,
				"value" );
		}
		requiredTableId = value;
	}

	@Override
	public IMCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IMCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public String getRequiredName() {
		return(requiredName);
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	@Override
	public String getOptionalShortName() {
		return(optionalShortName);
	}

	public void setOptionalShortName( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalShortName = value;
	}

	@Override
	public String getOptionalLabel() {
		return(optionalLabel);
	}

	public void setOptionalLabel( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalLabel = value;
	}

	@Override
	public String getOptionalShortDescription() {
		return(optionalShortDescription);
	}

	public void setOptionalShortDescription( String value ) {
		if( value != null && value.length() > 128 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		optionalShortDescription = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1023 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		optionalDescription = value;
	}

	@Override
	public String getOptionalSuffix() {
		return(optionalSuffix);
	}

	public void setOptionalSuffix( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalSuffix",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalSuffix = value;
	}

	@Override
	public boolean getRequiredIsInstanceMethod() {
		return(requiredIsInstanceMethod);
	}

	public void setRequiredIsInstanceMethod( boolean value ) {
		requiredIsInstanceMethod = value;
	}

	@Override
	public boolean getRequiredIsServerOnly() {
		return(requiredIsServerOnly);
	}

	public void setRequiredIsServerOnly( boolean value ) {
		requiredIsServerOnly = value;
	}

	@Override
	public ICFBamPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return(requiredCodeVis);
	}

	public void setRequiredCodeVis( ICFBamPubSchema.CodeVisibilityEnum value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCodeVis",
				1,
				"value" );
		}
		requiredCodeVis = value;
	}

	@Override
	public String getRequiredJMethodBody() {
		return(requiredJMethodBody);
	}

	public void setRequiredJMethodBody( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredJMethodBody",
				1,
				"value" );
		}
		else if( value.length() > 2000000 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredJMethodBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredJMethodBody = value;
	}

	@Override
	public String getRequiredCppMethodBody() {
		return(requiredCppMethodBody);
	}

	public void setRequiredCppMethodBody( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCppMethodBody",
				1,
				"value" );
		}
		else if( value.length() > 2000000 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredCppMethodBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredCppMethodBody = value;
	}

	@Override
	public String getRequiredCsMethodBody() {
		return(requiredCsMethodBody);
	}

	public void setRequiredCsMethodBody( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCsMethodBody",
				1,
				"value" );
		}
		else if( value.length() > 2000000 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredCsMethodBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredCsMethodBody = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFBamProtServerMethod rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstanceMethod() != rhs.getRequiredIsInstanceMethod() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			if( getRequiredJMethodBody() != null ) {
				if( rhs.getRequiredJMethodBody() != null ) {
					if( ! getRequiredJMethodBody().equals( rhs.getRequiredJMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredJMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCppMethodBody() != null ) {
				if( rhs.getRequiredCppMethodBody() != null ) {
					if( ! getRequiredCppMethodBody().equals( rhs.getRequiredCppMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCppMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCsMethodBody() != null ) {
				if( rhs.getRequiredCsMethodBody() != null ) {
					if( ! getRequiredCsMethodBody().equals( rhs.getRequiredCsMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCsMethodBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodH rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstanceMethod() != rhs.getRequiredIsInstanceMethod() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			if( getRequiredJMethodBody() != null ) {
				if( rhs.getRequiredJMethodBody() != null ) {
					if( ! getRequiredJMethodBody().equals( rhs.getRequiredJMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredJMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCppMethodBody() != null ) {
				if( rhs.getRequiredCppMethodBody() != null ) {
					if( ! getRequiredCppMethodBody().equals( rhs.getRequiredCppMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCppMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCsMethodBody() != null ) {
				if( rhs.getRequiredCsMethodBody() != null ) {
					if( ! getRequiredCsMethodBody().equals( rhs.getRequiredCsMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCsMethodBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtScopeHPKey ) {
			ICFBamProtScopeHPKey rhs = (ICFBamProtScopeHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByUNameIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethCodeVisIdxKey rhs ) {
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableVisIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubServerMethod rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstanceMethod() != rhs.getRequiredIsInstanceMethod() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			if( getRequiredJMethodBody() != null ) {
				if( rhs.getRequiredJMethodBody() != null ) {
					if( ! getRequiredJMethodBody().equals( rhs.getRequiredJMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredJMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCppMethodBody() != null ) {
				if( rhs.getRequiredCppMethodBody() != null ) {
					if( ! getRequiredCppMethodBody().equals( rhs.getRequiredCppMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCppMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCsMethodBody() != null ) {
				if( rhs.getRequiredCsMethodBody() != null ) {
					if( ! getRequiredCsMethodBody().equals( rhs.getRequiredCsMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCsMethodBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubServerMethodH rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstanceMethod() != rhs.getRequiredIsInstanceMethod() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			if( getRequiredJMethodBody() != null ) {
				if( rhs.getRequiredJMethodBody() != null ) {
					if( ! getRequiredJMethodBody().equals( rhs.getRequiredJMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredJMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCppMethodBody() != null ) {
				if( rhs.getRequiredCppMethodBody() != null ) {
					if( ! getRequiredCppMethodBody().equals( rhs.getRequiredCppMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCppMethodBody() != null ) {
					return( false );
				}
			}
			if( getRequiredCsMethodBody() != null ) {
				if( rhs.getRequiredCsMethodBody() != null ) {
					if( ! getRequiredCsMethodBody().equals( rhs.getRequiredCsMethodBody() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCsMethodBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubScopeHPKey rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByUNameIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethCodeVisIdxKey rhs ) {
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableVisIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtServerMethodByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredTableId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getOptionalSuffix() != null ) {
			hashCode = hashCode + getOptionalSuffix().hashCode();
		}
		if( getRequiredIsInstanceMethod() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsServerOnly() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredCodeVis().ordinal();
		if( getRequiredJMethodBody() != null ) {
			hashCode = hashCode + getRequiredJMethodBody().hashCode();
		}
		if( getRequiredCppMethodBody() != null ) {
			hashCode = hashCode + getRequiredCppMethodBody().hashCode();
		}
		if( getRequiredCsMethodBody() != null ) {
			hashCode = hashCode + getRequiredCsMethodBody().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFBamProtServerMethod rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstanceMethod() ) {
				if( ! rhs.getRequiredIsInstanceMethod() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstanceMethod() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			if (getRequiredJMethodBody() != null) {
				if (rhs.getRequiredJMethodBody() != null) {
					cmp = getRequiredJMethodBody().compareTo( rhs.getRequiredJMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredJMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCppMethodBody() != null) {
				if (rhs.getRequiredCppMethodBody() != null) {
					cmp = getRequiredCppMethodBody().compareTo( rhs.getRequiredCppMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCppMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCsMethodBody() != null) {
				if (rhs.getRequiredCsMethodBody() != null) {
					cmp = getRequiredCsMethodBody().compareTo( rhs.getRequiredCsMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCsMethodBody() != null) {
				return( -1 );
			}
			return( 0 );
 		}
		else if( obj instanceof ICFBamProtScopeHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstanceMethod() ) {
				if( ! rhs.getRequiredIsInstanceMethod() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstanceMethod() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			if (getRequiredJMethodBody() != null) {
				if (rhs.getRequiredJMethodBody() != null) {
					cmp = getRequiredJMethodBody().compareTo( rhs.getRequiredJMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredJMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCppMethodBody() != null) {
				if (rhs.getRequiredCppMethodBody() != null) {
					cmp = getRequiredCppMethodBody().compareTo( rhs.getRequiredCppMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCppMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCsMethodBody() != null) {
				if (rhs.getRequiredCsMethodBody() != null) {
					cmp = getRequiredCsMethodBody().compareTo( rhs.getRequiredCsMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCsMethodBody() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodByUNameIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethCodeVisIdxKey rhs ) {
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodByMethTableVisIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtServerMethodByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethod rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstanceMethod() ) {
				if( ! rhs.getRequiredIsInstanceMethod() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstanceMethod() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			if (getRequiredJMethodBody() != null) {
				if (rhs.getRequiredJMethodBody() != null) {
					cmp = getRequiredJMethodBody().compareTo( rhs.getRequiredJMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredJMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCppMethodBody() != null) {
				if (rhs.getRequiredCppMethodBody() != null) {
					cmp = getRequiredCppMethodBody().compareTo( rhs.getRequiredCppMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCppMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCsMethodBody() != null) {
				if (rhs.getRequiredCsMethodBody() != null) {
					cmp = getRequiredCsMethodBody().compareTo( rhs.getRequiredCsMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCsMethodBody() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamPubScopeHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstanceMethod() ) {
				if( ! rhs.getRequiredIsInstanceMethod() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstanceMethod() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			if (getRequiredJMethodBody() != null) {
				if (rhs.getRequiredJMethodBody() != null) {
					cmp = getRequiredJMethodBody().compareTo( rhs.getRequiredJMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredJMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCppMethodBody() != null) {
				if (rhs.getRequiredCppMethodBody() != null) {
					cmp = getRequiredCppMethodBody().compareTo( rhs.getRequiredCppMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCppMethodBody() != null) {
				return( -1 );
			}
			if (getRequiredCsMethodBody() != null) {
				if (rhs.getRequiredCsMethodBody() != null) {
					cmp = getRequiredCsMethodBody().compareTo( rhs.getRequiredCsMethodBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCsMethodBody() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodByUNameIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodByMethTableIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodByMethCodeVisIdxKey rhs ) {
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodByMethTableVisIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubServerMethodByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( ICFBamProtScope src ) {
		if( src instanceof CFBamProtBuffServerMethod ) {
			setJustProtServerMethod( (CFBamProtBuffServerMethod)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamProtBuffServerMethod" );
		}
	}

	@Override
	public void setServerMethod( ICFBamProtServerMethod src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerForTable(src.getRequiredContainerForTable());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredIsInstanceMethod(src.getRequiredIsInstanceMethod());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
		setJustProtRequiredJMethodBody(src.getRequiredJMethodBody());
		setJustProtRequiredCppMethodBody(src.getRequiredCppMethodBody());
		setJustProtRequiredCsMethodBody(src.getRequiredCsMethodBody());
	}

	@Override
	public void set( ICFBamProtScopeH src ) {
		if( src instanceof ICFBamPubServerMethodH ) {
			setServerMethod( (ICFBamPubServerMethodH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubServerMethodH" );
		}
	}

	@Override
	public void setServerMethod( ICFBamProtServerMethodH src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerForTable(src.getRequiredContainerForTable());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredIsInstanceMethod(src.getRequiredIsInstanceMethod());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
		setJustProtRequiredJMethodBody(src.getRequiredJMethodBody());
		setJustProtRequiredCppMethodBody(src.getRequiredCppMethodBody());
		setJustProtRequiredCsMethodBody(src.getRequiredCsMethodBody());
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubProtBuffServerMethod ) {
			setJustProtServerMethod( (CFBamPubProtBuffServerMethod)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubProtBuffServerMethod" );
		}
	}

	@Override
	public void setServerMethod( ICFBamPubServerMethod src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerForTable(src.getRequiredContainerForTable());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredIsInstanceMethod(src.getRequiredIsInstanceMethod());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
		setJustProtRequiredJMethodBody(src.getRequiredJMethodBody());
		setJustProtRequiredCppMethodBody(src.getRequiredCppMethodBody());
		setJustProtRequiredCsMethodBody(src.getRequiredCsMethodBody());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubServerMethodH ) {
			setServerMethod( (ICFBamPubServerMethodH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubServerMethodH" );
		}
	}

	@Override
	public void setServerMethod( ICFBamPubServerMethodH src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerForTable(src.getRequiredContainerForTable());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredIsInstanceMethod(src.getRequiredIsInstanceMethod());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
		setJustProtRequiredJMethodBody(src.getRequiredJMethodBody());
		setJustProtRequiredCppMethodBody(src.getRequiredCppMethodBody());
		setJustProtRequiredCsMethodBody(src.getRequiredCsMethodBody());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredTableId().toString() + "\"" + "\"" + getRequiredId().toString() + "\"" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" ) + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" ) + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" ) + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" ) + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" ) + ( ( getOptionalSuffix() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalSuffix() ) + "\"" ) + (( getRequiredIsInstanceMethod() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredIsServerOnly() ) ? "\"true\"" : "\"false\"" ) + "\"" + getRequiredCodeVis().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredJMethodBody() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredCppMethodBody() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredCsMethodBody() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamProtBuffServerMethod" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
