// Description: Java 17 implJustProtementation of a SchemaRef buffer

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

public class CFBamProtBuffSchemaRef
	extends CFBamProtBuffScope
	implements ICFBamSchemaRef
{
	protected IMCFKeyHash256 requiredSchemaId;
	protected String requiredName;
	protected String requiredRefModelName;
	protected String requiredIncludeRoot;
	protected IMCFKeyHash256 optionalRefSchemaId;
	protected IMCFKeyHash256 optionalPrevId;
	protected IMCFKeyHash256 optionalNextId;

	public CFBamProtBuffSchemaRef() {
		super();
		requiredSchemaId = MCFDbKeyHash256.fromHex( ICFBamPubSchemaRef.SCHEMAID_INIT_VALUE.toString() );
		requiredName = ICFBamPubSchemaRef.NAME_INIT_VALUE;
		requiredRefModelName = ICFBamPubSchemaRef.REFMODELNAME_INIT_VALUE;
		requiredIncludeRoot = ICFBamPubSchemaRef.INCLUDEROOT_INIT_VALUE;
		optionalRefSchemaId = MCFDbKeyHash256.nullGet();
		optionalPrevId = MCFDbKeyHash256.nullGet();
		optionalNextId = MCFDbKeyHash256.nullGet();
	}

	@Override
	public int getClassCode() {
		return( ICFBamProtSchemaRef.CLASS_CODE );
	}

	@Override
	public ICFBamProtSchemaDef getRequiredContainerSchema(IMCFKeyHash256 argSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerSchema", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerSchema", 0, "ICFBamProtSchema.getBackingCFBam().getTableSchemaDef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSchemaId()));
	}

	@Override
	public void setRequiredContainerSchema(IMCFKeyHash256 argSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerSchema-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerSchema", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaDef()");
		}
		ICFBamProtSchemaDef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerSchema-args", 0, "found");
		}
		else if (found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamPubSchemaDef)) {
			super.setRequiredContainerSchema(argSchemaId);
		requiredSchemaId = argSchemaId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerSchema-args", "found", found, "ICFBamProtSchemaDefICFBamProtSchemaDefICFBamPubSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerSchema(ICFBamProtSchemaDef argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerSchema", 1, "argObj");
		}
		else {
			setJustProtRequiredSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerSchema(ICFBamPubSchemaDef argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerSchema", 1, "argObj");
		}
		else {
			setJustProtRequiredSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFBamProtSchemaDef getOptionalLookupRefSchema(IMCFKeyHash256 argRefSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupRefSchema", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupRefSchema", 0, "ICFBamProtSchema.getBackingCFBam().getTableSchemaDef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalRefSchemaId()));
	}

	@Override
	public void setOptionalLookupRefSchema(IMCFKeyHash256 argRefSchemaId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupRefSchema-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaDefTable targetTable = targetBackingCFBam.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupRefSchema", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaDef()");
		}
		ICFBamProtSchemaDef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argRefSchemaId);
		if (found == null || (found != null && ((found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamProtSchemaDef) || (found instanceof ICFBamPubSchemaDef)))) {
			super.setOptionalLookupRefSchema(argRefSchemaId);
		optionalRefSchemaId = argRefSchemaId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupRefSchema-args", "found", found, "ICFBamProtSchemaDefICFBamProtSchemaDefICFBamPubSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupRefSchema(ICFBamProtSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalRefSchemaId(null);
		}
		else {
			setJustProtOptionalRefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupRefSchema(ICFBamPubSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalRefSchemaId(null);
		}
		else {
			setJustProtOptionalRefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFBamProtSchemaRef getOptionalLookupPrev(IMCFKeyHash256 argPrevId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupPrev", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaRefTable targetTable = targetBackingCFBam.getTableSchemaRef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupPrev", 0, "ICFBamProtSchema.getBackingCFBam().getTableSchemaRef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalPrevId()));
	}

	@Override
	public void setOptionalLookupPrev(IMCFKeyHash256 argPrevId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaRefTable targetTable = targetBackingCFBam.getTableSchemaRef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaRef()");
		}
		ICFBamProtSchemaRef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrevId);
		if (found == null || (found != null && ((found instanceof ICFBamProtSchemaRef) || (found instanceof ICFBamProtSchemaRef) || (found instanceof ICFBamPubSchemaRef)))) {
			super.setOptionalLookupPrev(argPrevId);
		optionalPrevId = argPrevId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupPrev-args", "found", found, "ICFBamProtSchemaRefICFBamProtSchemaRefICFBamPubSchemaRef");
		}
	}

	@Override
	public void setOptionalLookupPrev(ICFBamProtSchemaRef argObj) {

		if(argObj == null) {
			setJustProtOptionalPrevId(null);
		}
		else {
			setJustProtOptionalPrevId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupPrev(ICFBamPubSchemaRef argObj) {

		if(argObj == null) {
			setJustProtOptionalPrevId(null);
		}
		else {
			setJustProtOptionalPrevId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFBamProtSchemaRef getOptionalLookupNext(IMCFKeyHash256 argNextId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupNext", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaRefTable targetTable = targetBackingCFBam.getTableSchemaRef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalLookupNext", 0, "ICFBamProtSchema.getBackingCFBam().getTableSchemaRef()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalNextId()));
	}

	@Override
	public void setOptionalLookupNext(IMCFKeyHash256 argNextId) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtSchemaRefTable targetTable = targetBackingCFBam.getTableSchemaRef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaRef()");
		}
		ICFBamProtSchemaRef found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNextId);
		if (found == null || (found != null && ((found instanceof ICFBamProtSchemaRef) || (found instanceof ICFBamProtSchemaRef) || (found instanceof ICFBamPubSchemaRef)))) {
			super.setOptionalLookupNext(argNextId);
		optionalNextId = argNextId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setOptionalLookupNext-args", "found", found, "ICFBamProtSchemaRefICFBamProtSchemaRefICFBamPubSchemaRef");
		}
	}

	@Override
	public void setOptionalLookupNext(ICFBamProtSchemaRef argObj) {

		if(argObj == null) {
			setJustProtOptionalNextId(null);
		}
		else {
			setJustProtOptionalNextId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupNext(ICFBamPubSchemaRef argObj) {

		if(argObj == null) {
			setJustProtOptionalNextId(null);
		}
		else {
			setJustProtOptionalNextId(argObj.getRequiredId());
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredSchemaId() {
		return(requiredSchemaId);
	}

	public void setRequiredSchemaId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredSchemaId",
				1,
				"value" );
		}
		requiredSchemaId = value;
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
	public String getRequiredRefModelName() {
		return(requiredRefModelName);
	}

	public void setRequiredRefModelName( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredRefModelName",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredRefModelName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredRefModelName = value;
	}

	@Override
	public String getRequiredIncludeRoot() {
		return(requiredIncludeRoot);
	}

	public void setRequiredIncludeRoot( String value ) {
		if( value == null ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredIncludeRoot = value;
	}

	@Override
	public IMCFKeyHash256 getOptionalRefSchemaId() {
		return(optionalRefSchemaId);
	}

	public void setOptionalRefSchemaId( IMCFKeyHash256 value ) {
		optionalRefSchemaId = value;
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
		else if( obj instanceof ICFBamProtSchemaRef rhs ) {
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
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		else if( obj instanceof ICFBamProtSchemaRefH rhs ) {
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
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		else if( obj instanceof ICFBamProtSchemaRefBySchemaIdxKey rhs ) {
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtSchemaRefByUNameIdxKey rhs ) {
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
		else if( obj instanceof ICFBamProtSchemaRefByRefSchemaIdxKey rhs ) {
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtSchemaRefByPrevIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtSchemaRefByNextIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaRef rhs ) {
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
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		else if( obj instanceof ICFBamPubSchemaRefH rhs ) {
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
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		else if( obj instanceof ICFBamProtSchemaRefBySchemaIdxKey rhs ) {
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtSchemaRefByUNameIdxKey rhs ) {
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
		else if( obj instanceof ICFBamProtSchemaRefByRefSchemaIdxKey rhs ) {
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtSchemaRefByPrevIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtSchemaRefByNextIdxKey rhs ) {
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
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredSchemaId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredRefModelName() != null ) {
			hashCode = hashCode + getRequiredRefModelName().hashCode();
		}
		if( getRequiredIncludeRoot() != null ) {
			hashCode = hashCode + getRequiredIncludeRoot().hashCode();
		}
		if( getOptionalRefSchemaId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaId().hashCode();
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
		else if( obj instanceof ICFBamProtSchemaRef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			}
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
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
		else if( obj instanceof ICFBamProtSchemaRefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			}
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
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
		else if( obj instanceof ICFBamProtSchemaRefBySchemaIdxKey rhs ) {
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtSchemaRefByUNameIdxKey rhs ) {
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
		else if( obj instanceof ICFBamProtSchemaRefByRefSchemaIdxKey rhs ) {
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtSchemaRefByPrevIdxKey rhs ) {
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
		else if( obj instanceof ICFBamProtSchemaRefByNextIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaRef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			}
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
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
		else if( obj instanceof ICFBamPubSchemaRefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			}
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
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
		else if( obj instanceof ICFBamPubSchemaRefBySchemaIdxKey rhs ) {
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubSchemaRefByUNameIdxKey rhs ) {
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
		else if( obj instanceof ICFBamPubSchemaRefByRefSchemaIdxKey rhs ) {
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubSchemaRefByPrevIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaRefByNextIdxKey rhs ) {
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
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( ICFBamProtScope src ) {
		if( src instanceof CFBamProtBuffSchemaRef ) {
			setJustProtSchemaRef( (CFBamProtBuffSchemaRef)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamProtBuffSchemaRef" );
		}
	}

	@Override
	public void setSchemaRef( ICFBamProtSchemaRef src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchema(src.getRequiredContainerSchema());
		setJustProtOptionalLookupRefSchema(src.getOptionalLookupRefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtRequiredSchemaId(src.getRequiredSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtRequiredRefModelName(src.getRequiredRefModelName());
		setJustProtRequiredIncludeRoot(src.getRequiredIncludeRoot());
		setJustProtOptionalRefSchemaId(src.getOptionalRefSchemaId());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamProtScopeH src ) {
		if( src instanceof ICFBamPubSchemaRefH ) {
			setSchemaRef( (ICFBamPubSchemaRefH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubSchemaRefH" );
		}
	}

	@Override
	public void setSchemaRef( ICFBamProtSchemaRefH src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchema(src.getRequiredContainerSchema());
		setJustProtOptionalLookupRefSchema(src.getOptionalLookupRefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtRequiredSchemaId(src.getRequiredSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtRequiredRefModelName(src.getRequiredRefModelName());
		setJustProtRequiredIncludeRoot(src.getRequiredIncludeRoot());
		setJustProtOptionalRefSchemaId(src.getOptionalRefSchemaId());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubProtBuffSchemaRef ) {
			setJustProtSchemaRef( (CFBamPubProtBuffSchemaRef)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubProtBuffSchemaRef" );
		}
	}

	@Override
	public void setSchemaRef( ICFBamPubSchemaRef src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchema(src.getRequiredContainerSchema());
		setJustProtOptionalLookupRefSchema(src.getOptionalLookupRefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtRequiredSchemaId(src.getRequiredSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtRequiredRefModelName(src.getRequiredRefModelName());
		setJustProtRequiredIncludeRoot(src.getRequiredIncludeRoot());
		setJustProtOptionalRefSchemaId(src.getOptionalRefSchemaId());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubSchemaRefH ) {
			setSchemaRef( (ICFBamPubSchemaRefH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubSchemaRefH" );
		}
	}

	@Override
	public void setSchemaRef( ICFBamPubSchemaRefH src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchema(src.getRequiredContainerSchema());
		setJustProtOptionalLookupRefSchema(src.getOptionalLookupRefSchema());
		setJustProtOptionalLookupPrev(src.getOptionalLookupPrev());
		setJustProtOptionalLookupNext(src.getOptionalLookupNext());
		setJustProtRequiredSchemaId(src.getRequiredSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtRequiredRefModelName(src.getRequiredRefModelName());
		setJustProtRequiredIncludeRoot(src.getRequiredIncludeRoot());
		setJustProtOptionalRefSchemaId(src.getOptionalRefSchemaId());
		setJustProtOptionalPrevId(src.getOptionalPrevId());
		setJustProtOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredSchemaId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredRefModelName() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredIncludeRoot() ) + "\"" + ( ( getOptionalRefSchemaId() == null ) ? "null" : "\"" + getOptionalRefSchemaId().toString() + "\"" ) + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" ) + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamProtBuffSchemaRef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
