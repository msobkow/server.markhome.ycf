// Description: Java 17 implJustPubementation of a ClearSubDep3 buffer

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

public class CFBamPubBuffClearSubDep3
	extends CFBamPubBuffClearDep
	implements ICFBamClearSubDep3
{
	protected IMCFKeyHash256 requiredClearSubDep2Id;
	protected String requiredName;

	public CFBamPubBuffClearSubDep3() {
		super();
		requiredClearSubDep2Id = MCFDbKeyHash256.fromHex( ICFBamPubClearSubDep3.CLEARSUBDEP2ID_INIT_VALUE.toString() );
		requiredName = ICFBamPubClearSubDep3.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( ICFBamPubClearSubDep3.CLASS_CODE );
	}

	@Override
	public ICFBamPubClearSubDep2 getRequiredContainerClearSubDep2(IMCFKeyHash256 argClearSubDep2Id) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerClearSubDep2", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubClearSubDep2Table targetTable = targetBackingCFBam.getTableClearSubDep2();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerClearSubDep2", 0, "ICFBamPubSchema.getBackingCFBam().getTableClearSubDep2()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredClearSubDep2Id()));
	}

	@Override
	public void setRequiredContainerClearSubDep2(IMCFKeyHash256 argClearSubDep2Id) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep2-args", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubClearSubDep2Table targetTable = targetBackingCFBam.getTableClearSubDep2();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep2", 0, "ICFBamSchema.getBackingCFBam().getTableClearSubDep2()");
		}
		ICFBamPubClearSubDep2 found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argClearSubDep2Id);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep2-args", 0, "found");
		}
		else if (found instanceof ICFBamPubClearSubDep2) || (found instanceof ICFBamPubClearSubDep2)) {
			super.setRequiredContainerClearSubDep2(argClearSubDep2Id);
		requiredClearSubDep2Id = argClearSubDep2Id;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerClearSubDep2-args", "found", found, "ICFBamPubClearSubDep2ICFBamPubClearSubDep2");
		}
	}

	@Override
	public void setRequiredContainerClearSubDep2(ICFBamPubClearSubDep2 argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerClearSubDep2", 1, "argObj");
		}
		else {
			setRequiredClearSubDep2Id(argObj.getRequiredId());
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredClearSubDep2Id() {
		return(requiredClearSubDep2Id);
	}

	public void setRequiredClearSubDep2Id( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredClearSubDep2Id",
				1,
				"value" );
		}
		requiredClearSubDep2Id = value;
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
		else if( obj instanceof ICFBamPubClearSubDep3 rhs ) {
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
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubClearSubDep3H rhs ) {
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
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubClearSubDep3ByClearSubDep2IdxKey rhs ) {
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubClearSubDep3ByUNameIdxKey rhs ) {
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubClearSubDep3 rhs ) {
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
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubClearSubDep3H rhs ) {
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
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubClearSubDep3ByClearSubDep2IdxKey rhs ) {
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamPubClearSubDep3ByUNameIdxKey rhs ) {
			if( getRequiredClearSubDep2Id() != null ) {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
					if( ! getRequiredClearSubDep2Id().equals( rhs.getRequiredClearSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep2Id() != null ) {
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
		hashCode = hashCode + getRequiredClearSubDep2Id().hashCode();
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
		else if( obj instanceof ICFBamPubClearSubDep3 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubClearSubDep3H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubClearSubDep3ByClearSubDep2IdxKey rhs ) {
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubClearSubDep3ByUNameIdxKey rhs ) {
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubClearSubDep3 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubClearSubDep3H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubClearSubDep3ByClearSubDep2IdxKey rhs ) {
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubClearSubDep3ByUNameIdxKey rhs ) {
			if (getRequiredClearSubDep2Id() != null) {
				if (rhs.getRequiredClearSubDep2Id() != null) {
					cmp = getRequiredClearSubDep2Id().compareTo( rhs.getRequiredClearSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep2Id() != null) {
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
		if( src instanceof CFBamPubBuffClearSubDep3 ) {
			setJustPubClearSubDep3( (CFBamPubBuffClearSubDep3)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubBuffClearSubDep3" );
		}
	}

	@Override
	public void setClearSubDep3( ICFBamPubClearSubDep3 src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep2(src.getRequiredContainerClearSubDep2());
		setJustPubRequiredClearSubDep2Id(src.getRequiredClearSubDep2Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubClearSubDep3H ) {
			setClearSubDep3( (ICFBamPubClearSubDep3H)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubClearSubDep3H" );
		}
	}

	@Override
	public void setClearSubDep3( ICFBamPubClearSubDep3H src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep2(src.getRequiredContainerClearSubDep2());
		setJustPubRequiredClearSubDep2Id(src.getRequiredClearSubDep2Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubPubBuffClearSubDep3 ) {
			setJustPubClearSubDep3( (CFBamPubPubBuffClearSubDep3)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubPubBuffClearSubDep3" );
		}
	}

	@Override
	public void setClearSubDep3( ICFBamPubClearSubDep3 src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep2(src.getRequiredContainerClearSubDep2());
		setJustPubRequiredClearSubDep2Id(src.getRequiredClearSubDep2Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubClearSubDep3H ) {
			setClearSubDep3( (ICFBamPubClearSubDep3H)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubClearSubDep3H" );
		}
	}

	@Override
	public void setClearSubDep3( ICFBamPubClearSubDep3H src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep2(src.getRequiredContainerClearSubDep2());
		setJustPubRequiredClearSubDep2Id(src.getRequiredClearSubDep2Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredClearSubDep2Id().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamPubBuffClearSubDep3" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
