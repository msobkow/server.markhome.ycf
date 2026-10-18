// Description: Java 17 implJustPubementation of a PopTopDep buffer

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
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public class CFBamPubBuffPopTopDep
	extends CFBamPubBuffPopDep
	implements ICFBamPopTopDep
{
	protected IMCFKeyHash256 requiredContRelationId;
	protected String requiredName;

	public CFBamPubBuffPopTopDep() {
		super();
		requiredContRelationId = MCFDbKeyHash256.fromHex( ICFBamPubPopTopDep.CONTRELATIONID_INIT_VALUE.toString() );
		requiredName = ICFBamPubPopTopDep.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( ICFBamPubPopTopDep.CLASS_CODE );
	}

	@Override
	public ICFBamPubRelation getRequiredContainerContRelation(IMCFKeyHash256 argContRelationId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubRelationTable targetTable = targetBackingCFBam.getTableRelation();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "ICFBamPubSchema.getBackingCFBam().getTableRelation()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredContRelationId()));
	}

	@Override
	public void setRequiredContainerContRelation(IMCFKeyHash256 argContRelationId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerContRelation-args", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubRelationTable targetTable = targetBackingCFBam.getTableRelation();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerContRelation", 0, "ICFBamSchema.getBackingCFBam().getTableRelation()");
		}
		ICFBamPubRelation found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argContRelationId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerContRelation-args", 0, "found");
		}
		else if (found instanceof ICFBamPubRelation) || (found instanceof ICFBamPubRelation)) {
			super.setRequiredContainerContRelation(argContRelationId);
		requiredContRelationId = argContRelationId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerContRelation-args", "found", found, "ICFBamPubRelationICFBamPubRelation");
		}
	}

	@Override
	public void setRequiredContainerContRelation(ICFBamPubRelation argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerContRelation", 1, "argObj");
		}
		else {
			setRequiredContRelationId(argObj.getRequiredId());
		}
	}

	@Override
	public List<ICFBamPubPopSubDep1> getOptionalComponentsPopDep(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubPopSubDep1Table targetTable = targetBackingCFBam.getTablePopSubDep1();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "ICFBamPubSchema.getBackingCFBam().getTablePopSubDep1()");
		}
		ICFBamPubPopSubDep1[] targetArr = targetTable.readDerivedByPopTopDepIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubPopSubDep1> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubPopSubDep1> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredContRelationId() {
		return(requiredContRelationId);
	}

	public void setRequiredContRelationId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredContRelationId",
				1,
				"value" );
		}
		requiredContRelationId = value;
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
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFBamPubPopTopDep rhs ) {
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
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if( obj instanceof ICFBamPubPopTopDepH rhs ) {
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
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if( obj instanceof ICFBamPubScopeHPKey ) {
			ICFBamPubScopeHPKey rhs = (ICFBamPubScopeHPKey)obj;
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
		else if( obj instanceof ICFBamPubPopTopDepByContRelIdxKey rhs ) {
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubPopTopDepByUNameIdxKey rhs ) {
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if( obj instanceof ICFBamPubPopTopDep rhs ) {
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
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if( obj instanceof ICFBamPubPopTopDepH rhs ) {
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
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if( obj instanceof ICFBamPubPopTopDepByContRelIdxKey rhs ) {
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubPopTopDepByUNameIdxKey rhs ) {
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredContRelationId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFBamPubPopTopDep rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else if( obj instanceof ICFBamPubPopTopDepH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
			return( 0 );
		}
		else if( obj instanceof ICFBamPubPopTopDepByContRelIdxKey rhs ) {
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubPopTopDepByUNameIdxKey rhs ) {
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else if( obj instanceof ICFBamPubPopTopDep rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else if( obj instanceof ICFBamPubPopTopDepH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
			return( 0 );
		}
		else if( obj instanceof ICFBamPubPopTopDepByContRelIdxKey rhs ) {
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubPopTopDepByUNameIdxKey rhs ) {
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubBuffPopTopDep ) {
			setJustPubPopTopDep( (CFBamPubBuffPopTopDep)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubBuffPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( ICFBamPubPopTopDep src ) {
		super.setPopDep( src );
		setJustPubRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setJustPubRequiredContRelationId(src.getRequiredContRelationId());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubPopTopDepH ) {
			setPopTopDep( (ICFBamPubPopTopDepH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( ICFBamPubPopTopDepH src ) {
		super.setPopDep( src );
		setJustPubRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setJustPubRequiredContRelationId(src.getRequiredContRelationId());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubPubBuffPopTopDep ) {
			setJustPubPopTopDep( (CFBamPubPubBuffPopTopDep)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubPubBuffPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( ICFBamPubPopTopDep src ) {
		super.setPopDep( src );
		setJustPubRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setJustPubRequiredContRelationId(src.getRequiredContRelationId());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubPopTopDepH ) {
			setPopTopDep( (ICFBamPubPopTopDepH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( ICFBamPubPopTopDepH src ) {
		super.setPopDep( src );
		setJustPubRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setJustPubRequiredContRelationId(src.getRequiredContRelationId());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredContRelationId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamPubBuffPopTopDep" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
