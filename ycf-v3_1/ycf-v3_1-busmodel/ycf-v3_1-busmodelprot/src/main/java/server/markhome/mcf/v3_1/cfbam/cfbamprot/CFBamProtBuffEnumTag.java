// Description: Java 17 implJustProtementation of a EnumTag buffer

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

public class CFBamProtBuffEnumTag
	implements ICFBamProtEnumTag, Comparable<Object>, Serializable
{
	protected IMCFKeyHash256 requiredId;
	protected int requiredRevision;
	protected MCFDbKeyHash256 createdByUserId = MCFDbKeyHash256.fromHex(ICFBamPubSecUser.S_INIT_CREATED_BY);
	protected MCFDbKeyHash256 createdBySessionId = MCFDbKeyHash256.fromHex(ICFBamPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected MCFDbKeyHash256 updatedByUserId = MCFDbKeyHash256.fromHex(ICFBamPubSecUser.S_INIT_UPDATED_BY);
	protected MCFDbKeyHash256 updatedBySessionId = MCFDbKeyHash256.fromHex(ICFBamPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected IMCFKeyHash256 optionalDefSchemaId;
	protected IMCFKeyHash256 requiredEnumId;
	protected Short optionalEnumCode;
	protected String requiredName;
	protected IMCFKeyHash256 optionalPrevId;
	protected IMCFKeyHash256 optionalNextId;

	public CFBamProtBuffEnumTag() {
		requiredId = MCFDbKeyHash256.fromHex( ICFBamPubEnumTag.ID_INIT_VALUE.toString() );
		optionalDefSchemaId = MCFDbKeyHash256.nullGet();
		requiredEnumId = MCFDbKeyHash256.fromHex( ICFBamPubEnumTag.ENUMID_INIT_VALUE.toString() );
		optionalEnumCode = null;
		requiredName = ICFBamPubEnumTag.NAME_INIT_VALUE;
		optionalPrevId = MCFDbKeyHash256.nullGet();
		optionalNextId = MCFDbKeyHash256.nullGet();
	}

	@Override
	public IMCFKeyHash256 getPKey() {
		return (requiredId);
	}

	@Override
	public void setPKey(IMCFKeyHash256 requiredId) {
		if(requiredId != null) {
			this.requiredId = requiredId;
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredId() {
		return(requiredId);
	}

	public void setRequiredId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		requiredId = value;
	}

	@Override
	public MCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setJustProtCreatedByUserId( MCFDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setJustProtCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public MCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setJustProtUpdatedByUserId( MCFDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setJustProtUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}

	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFBamProtEnumTag.CLASS_CODE );
	}

	@Override
	public ICFBamProtEnumDef getRequiredContainerEnumDef(IMCFKeyHash256 argEnumId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerEnumDef", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumDefTable targetTable = targetBackingCFBam.getTableEnumDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerEnumDef", 0, "ICFBamProtSchema.getBackingCFBam().getTableEnumDef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredEnumId()));
	}

	@Override
	public void setRequiredContainerEnumDef(IMCFKeyHash256 argEnumId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerEnumDef-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumDefTable targetTable = targetBackingCFBam.getTableEnumDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerEnumDef", 0, "ICFBamSchema.getBackingCFBam().getTableEnumDef()");
		}
		ICFBamProtEnumDef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argEnumId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerEnumDef-args", 0, "found");
		}
		else if (found instanceof ICFBamProtEnumDef) || (found instanceof ICFBamProtEnumDef) || (found instanceof ICFBamPubEnumDef)) {
			super.setRequiredContainerEnumDef(argEnumId);
		requiredEnumId = argEnumId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerEnumDef-args", "found", found, "ICFBamProtEnumDefICFBamProtEnumDefICFBamPubEnumDef");
		}
	}

	@Override
	public void setRequiredContainerEnumDef(ICFBamProtEnumDef argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerEnumDef", 1, "argObj");
		}
		else {
			setJustProtRequiredEnumId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerEnumDef(ICFBamPubEnumDef argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerEnumDef", 1, "argObj");
		}
		else {
			setJustProtRequiredEnumId(argObj.getRequiredId());
		}
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
	public ICFBamProtEnumTag getOptionalLookupPrev(IMCFKeyHash256 argPrevId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupPrev", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumTagTable targetTable = targetBackingCFBam.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupPrev", 0, "ICFBamProtSchema.getBackingCFBam().getTableEnumTag()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalPrevId()));
	}

	@Override
	public void setOptionalLookupPrev(IMCFKeyHash256 argPrevId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumTagTable targetTable = targetBackingCFBam.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "ICFBamSchema.getBackingCFBam().getTableEnumTag()");
		}
		ICFBamProtEnumTag found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrevId);
		if (found == null || (found != null && ((found instanceof ICFBamProtEnumTag) || (found instanceof ICFBamProtEnumTag) || (found instanceof ICFBamPubEnumTag)))) {
			super.setOptionalLookupPrev(argPrevId);
		optionalPrevId = argPrevId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupPrev-args", "found", found, "ICFBamProtEnumTagICFBamProtEnumTagICFBamPubEnumTag");
		}
	}

	@Override
	public void setOptionalLookupPrev(ICFBamProtEnumTag argObj) {

		if(argObj == null) {
			setJustProtOptionalPrevId(null);
		}
		else {
			setJustProtOptionalPrevId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupPrev(ICFBamPubEnumTag argObj) {

		if(argObj == null) {
			setJustProtOptionalPrevId(null);
		}
		else {
			setJustProtOptionalPrevId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFBamProtEnumTag getOptionalLookupNext(IMCFKeyHash256 argNextId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupNext", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumTagTable targetTable = targetBackingCFBam.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupNext", 0, "ICFBamProtSchema.getBackingCFBam().getTableEnumTag()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalNextId()));
	}

	@Override
	public void setOptionalLookupNext(IMCFKeyHash256 argNextId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtEnumTagTable targetTable = targetBackingCFBam.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "ICFBamSchema.getBackingCFBam().getTableEnumTag()");
		}
		ICFBamProtEnumTag found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNextId);
		if (found == null || (found != null && ((found instanceof ICFBamProtEnumTag) || (found instanceof ICFBamProtEnumTag) || (found instanceof ICFBamPubEnumTag)))) {
			super.setOptionalLookupNext(argNextId);
		optionalNextId = argNextId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupNext-args", "found", found, "ICFBamProtEnumTagICFBamProtEnumTagICFBamPubEnumTag");
		}
	}

	@Override
	public void setOptionalLookupNext(ICFBamProtEnumTag argObj) {

		if(argObj == null) {
			setJustProtOptionalNextId(null);
		}
		else {
			setJustProtOptionalNextId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupNext(ICFBamPubEnumTag argObj) {

		if(argObj == null) {
			setJustProtOptionalNextId(null);
		}
		else {
			setJustProtOptionalNextId(argObj.getRequiredId());
		}
	}

	@Override
	public IMCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IMCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public IMCFKeyHash256 getRequiredEnumId() {
		return(requiredEnumId);
	}

	public void setRequiredEnumId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredEnumId",
				1,
				"value" );
		}
		requiredEnumId = value;
	}

	@Override
	public Short getOptionalEnumCode() {
		return(optionalEnumCode);
	}

	@Override
	public void setOptionalEnumCode( Short value ) {
		if( value < ICFBamPubEnumTag.ENUMCODE_MIN_VALUE ) {
			throw new MCFArgumentUnderflowException( getClass(),
				"setOptionalEnumCode",
				1,
				"value",
				value,
				ICFBamPubEnumTag.ENUMCODE_MIN_VALUE );
		}
		if( value > ICFBamPubEnumTag.ENUMCODE_MAX_VALUE ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalEnumCode",
				1,
				"value",
				value,
				ICFBamPubEnumTag.ENUMCODE_MAX_VALUE );
		}
		optionalEnumCode = value;
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
		else if( value.length() > 64 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	@Override
	public IMCFKeyHash256 getOptionalPrevId() {
		return(optionalPrevId);
	}

	public void setOptionalPrevId( IMCFKeyHash256 value ) {
		optionalPrevId = value;
	}

	@Override
	public IMCFKeyHash256 getOptionalNextId() {
		return(optionalNextId);
	}

	public void setOptionalNextId( IMCFKeyHash256 value ) {
		optionalNextId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFBamProtEnumTag rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagH rhs ) {
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagHPKey ) {
			ICFBamProtEnumTagHPKey rhs = (ICFBamProtEnumTagHPKey)obj;
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
		else if( obj instanceof ICFBamProtEnumTagByEnumIdxKey rhs ) {
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtEnumTagByEnumNameIdxKey rhs ) {
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
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
		else if( obj instanceof ICFBamProtEnumTagByPrevIdxKey rhs ) {
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagByNextIdxKey rhs ) {
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubEnumTag rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubEnumTagH rhs ) {
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubEnumTagHPKey rhs ) {
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
		else if( obj instanceof ICFBamProtEnumTagByEnumIdxKey rhs ) {
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtEnumTagByEnumNameIdxKey rhs ) {
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
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
		else if( obj instanceof ICFBamProtEnumTagByPrevIdxKey rhs ) {
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtEnumTagByNextIdxKey rhs ) {
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		hashCode = hashCode + getRequiredEnumId().hashCode();
		if( getOptionalEnumCode() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalEnumCode();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalPrevId() != null ) {
			hashCode = hashCode + getOptionalPrevId().hashCode();
		}
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFBamProtEnumTag rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
 		}
		else if( obj instanceof ICFBamProtEnumTagHPKey rhs ) {
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
		else if( obj instanceof ICFBamProtEnumTagH rhs ) {
			cmp = 0;
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamProtEnumTagByEnumIdxKey rhs ) {
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtEnumTagByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtEnumTagByEnumNameIdxKey rhs ) {
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
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
		else if( obj instanceof ICFBamProtEnumTagByPrevIdxKey rhs ) {
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtEnumTagByNextIdxKey rhs ) {
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubEnumTag rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamPubEnumTagHPKey rhs ) {
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
		else if( obj instanceof ICFBamPubEnumTagH rhs ) {
			cmp = 0;
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFBamPubEnumTagByEnumIdxKey rhs ) {
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubEnumTagByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubEnumTagByEnumNameIdxKey rhs ) {
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
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
		else if( obj instanceof ICFBamPubEnumTagByPrevIdxKey rhs ) {
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubEnumTagByNextIdxKey rhs ) {
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFBamProtEnumTag src ) {
		setJustProtEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamProtEnumTag src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredContainerEnumDef(src.getRequiredContainerEnumDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredEnumId(src.getRequiredEnumId());
		setJustProtOptionalEnumCode(src.getOptionalEnumCode());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamProtEnumTagH src ) {
		setJustProtEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamProtEnumTagH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredContainerEnumDef(src.getRequiredContainerEnumDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredEnumId(src.getRequiredEnumId());
		setJustProtOptionalEnumCode(src.getOptionalEnumCode());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamPubEnumTag src ) {
		setJustProtEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamPubEnumTag src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredContainerEnumDef(src.getRequiredContainerEnumDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredEnumId(src.getRequiredEnumId());
		setJustProtOptionalEnumCode(src.getOptionalEnumCode());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamPubEnumTagH src ) {
		setJustProtEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamPubEnumTagH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredContainerEnumDef(src.getRequiredContainerEnumDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredEnumId(src.getRequiredEnumId());
		setJustProtOptionalEnumCode(src.getOptionalEnumCode());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment()
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\"" + "\"" + getRequiredId().toString() + "\"" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" ) + "\"" + getRequiredEnumId().toString() + "\"" + ( ( getOptionalEnumCode() == null ) ? "null" : "\"" + getOptionalEnumCode().toString() + "\"" ) + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" ) + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamProtBuffEnumTag" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
