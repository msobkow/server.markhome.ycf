// Description: Java 17 implJustProtementation of a DelSubDep3 buffer

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

public class CFBamProtBuffDelSubDep3
	extends CFBamProtBuffDelDep
	implements ICFBamDelSubDep3
{
	protected IMCFKeyHash256 requiredDelSubDep2Id;
	protected String requiredName;

	public CFBamProtBuffDelSubDep3() {
		super();
		requiredDelSubDep2Id = MCFDbKeyHash256.fromHex( ICFBamPubDelSubDep3.DELSUBDEP2ID_INIT_VALUE.toString() );
		requiredName = ICFBamPubDelSubDep3.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( ICFBamProtDelSubDep3.CLASS_CODE );
	}

	@Override
	public ICFBamProtDelSubDep2 getRequiredContainerDelSubDep2(IMCFKeyHash256 argDelSubDep2Id) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep2", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtDelSubDep2Table targetTable = targetBackingCFBam.getTableDelSubDep2();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep2", 0, "ICFBamProtSchema.getBackingCFBam().getTableDelSubDep2()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelSubDep2Id()));
	}

	@Override
	public void setRequiredContainerDelSubDep2(IMCFKeyHash256 argDelSubDep2Id) {
		ICFBamProtSchema targetBackingCFBam = ICFBamProtSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep2-args", 0, "ICFBamProtSchema.getBackingCFBam()");
		}
		ICFBamProtDelSubDep2Table targetTable = targetBackingCFBam.getTableDelSubDep2();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep2", 0, "ICFBamSchema.getBackingCFBam().getTableDelSubDep2()");
		}
		ICFBamProtDelSubDep2 found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelSubDep2Id);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep2-args", 0, "found");
		}
		else if (found instanceof ICFBamProtDelSubDep2) || (found instanceof ICFBamProtDelSubDep2) || (found instanceof ICFBamPubDelSubDep2)) {
			super.setRequiredContainerDelSubDep2(argDelSubDep2Id);
		requiredDelSubDep2Id = argDelSubDep2Id;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerDelSubDep2-args", "found", found, "ICFBamProtDelSubDep2ICFBamProtDelSubDep2ICFBamPubDelSubDep2");
		}
	}

	@Override
	public void setRequiredContainerDelSubDep2(ICFBamProtDelSubDep2 argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerDelSubDep2", 1, "argObj");
		}
		else {
			setJustProtRequiredDelSubDep2Id(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerDelSubDep2(ICFBamPubDelSubDep2 argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerDelSubDep2", 1, "argObj");
		}
		else {
			setJustProtRequiredDelSubDep2Id(argObj.getRequiredId());
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredDelSubDep2Id() {
		return(requiredDelSubDep2Id);
	}

	public void setRequiredDelSubDep2Id( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredDelSubDep2Id",
				1,
				"value" );
		}
		requiredDelSubDep2Id = value;
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
		else if( obj instanceof ICFBamProtDelSubDep3 rhs ) {
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
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamProtDelSubDep3H rhs ) {
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
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamProtDelSubDep3ByDelSubDep2IdxKey rhs ) {
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtDelSubDep3ByUNameIdxKey rhs ) {
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubDelSubDep3 rhs ) {
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
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamPubDelSubDep3H rhs ) {
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
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if( obj instanceof ICFBamProtDelSubDep3ByDelSubDep2IdxKey rhs ) {
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFBamProtDelSubDep3ByUNameIdxKey rhs ) {
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		hashCode = hashCode + getRequiredDelSubDep2Id().hashCode();
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
		else if( obj instanceof ICFBamProtDelSubDep3 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamProtDelSubDep3H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamProtDelSubDep3ByDelSubDep2IdxKey rhs ) {
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamProtDelSubDep3ByUNameIdxKey rhs ) {
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubDelSubDep3 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubDelSubDep3H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof ICFBamPubDelSubDep3ByDelSubDep2IdxKey rhs ) {
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFBamPubDelSubDep3ByUNameIdxKey rhs ) {
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
	public void set( ICFBamProtScope src ) {
		if( src instanceof CFBamProtBuffDelSubDep3 ) {
			setJustProtDelSubDep3( (CFBamProtBuffDelSubDep3)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamProtBuffDelSubDep3" );
		}
	}

	@Override
	public void setDelSubDep3( ICFBamProtDelSubDep3 src ) {
		super.setDelDep( src );
		setJustProtRequiredContainerDelSubDep2(src.getRequiredContainerDelSubDep2());
		setJustProtRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setJustProtRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamProtScopeH src ) {
		if( src instanceof ICFBamPubDelSubDep3H ) {
			setDelSubDep3( (ICFBamPubDelSubDep3H)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubDelSubDep3H" );
		}
	}

	@Override
	public void setDelSubDep3( ICFBamProtDelSubDep3H src ) {
		super.setDelDep( src );
		setJustProtRequiredContainerDelSubDep2(src.getRequiredContainerDelSubDep2());
		setJustProtRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setJustProtRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubProtBuffDelSubDep3 ) {
			setJustProtDelSubDep3( (CFBamPubProtBuffDelSubDep3)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubProtBuffDelSubDep3" );
		}
	}

	@Override
	public void setDelSubDep3( ICFBamPubDelSubDep3 src ) {
		super.setDelDep( src );
		setJustProtRequiredContainerDelSubDep2(src.getRequiredContainerDelSubDep2());
		setJustProtRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setJustProtRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubDelSubDep3H ) {
			setDelSubDep3( (ICFBamPubDelSubDep3H)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubDelSubDep3H" );
		}
	}

	@Override
	public void setDelSubDep3( ICFBamPubDelSubDep3H src ) {
		super.setDelDep( src );
		setJustProtRequiredContainerDelSubDep2(src.getRequiredContainerDelSubDep2());
		setJustProtRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setJustProtRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredDelSubDep2Id().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamProtBuffDelSubDep3" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
