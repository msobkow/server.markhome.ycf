// Description: Java 17 implJustProtementation of a IndexTweak buffer

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelProtBuffIndexTweak
	extends BusModelProtBuffTweak
	implements IBusModelIndexTweak
{
	protected IYCFKeyHash256 requiredIndexId;

	public BusModelProtBuffIndexTweak() {
		super();
		requiredIndexId = YCFDbKeyHash256.fromHex( IBusModelPubIndexTweak.INDEXID_INIT_VALUE.toString() );
	}

	@Override
	public int getClassCode() {
		return( IBusModelProtIndexTweak.CLASS_CODE );
	}

	@Override
	public IBusModelProtIndex getRequiredContainerIndexDef(IYCFKeyHash256 argIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerIndexDef", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerIndexDef", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredIndexId()));
	}

	@Override
	public void setRequiredContainerScopeDef(IYCFKeyHash256 argIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerIndexDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelProtScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelProtScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argIndexId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if (found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)) {
			super.setRequiredContainerScopeDef(argIndexId);
		requiredIndexId = argIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}
$reimplJustProtSchemaProtBuffTableNarrowedPubRelationSetter$
	@Override
	public void setRequiredContainerIndexDef(IYCFKeyHash256 argIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerIndexDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelProtScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelProtScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argIndexId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if (found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)) {
			super.setRequiredContainerScopeDef(argIndexId);
		requiredIndexId = argIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setRequiredContainerIndexDef(IBusModelProtIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerIndexDef", 1, "argObj");
		}
		else {
			setJustProtRequiredIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerIndexDef(IBusModelPubIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerIndexDef", 1, "argObj");
		}
		else {
			setJustProtRequiredIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredIndexId() {
		return(requiredIndexId);
	}

	public void setRequiredIndexId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredIndexId",
				1,
				"value" );
		}
		requiredIndexId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelProtIndexTweak rhs ) {
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
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtIndexTweakH rhs ) {
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
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTweakHPKey ) {
			IBusModelProtTweakHPKey rhs = (IBusModelProtTweakHPKey)obj;
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
		else if( obj instanceof IBusModelProtIndexTweakByIndexIdxKey rhs ) {
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubIndexTweak rhs ) {
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
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubIndexTweakH rhs ) {
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
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubTweakHPKey rhs ) {
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
		else if( obj instanceof IBusModelProtIndexTweakByIndexIdxKey rhs ) {
			if( getRequiredIndexId() != null ) {
				if( rhs.getRequiredIndexId() != null ) {
					if( ! getRequiredIndexId().equals( rhs.getRequiredIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIndexId() != null ) {
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
		hashCode = hashCode + getRequiredIndexId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelProtIndexTweak rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}
			return( 0 );
 		}
		else if( obj instanceof IBusModelProtTweakHPKey rhs ) {
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
		else if( obj instanceof IBusModelProtIndexTweakH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtIndexTweakByIndexIdxKey rhs ) {
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubIndexTweak rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubTweakHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubIndexTweakH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubIndexTweakByIndexIdxKey rhs ) {
			if (getRequiredIndexId() != null) {
				if (rhs.getRequiredIndexId() != null) {
					cmp = getRequiredIndexId().compareTo( rhs.getRequiredIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelProtTweak src ) {
		if( src instanceof BusModelProtBuffIndexTweak ) {
			setJustProtIndexTweak( (BusModelProtBuffIndexTweak)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffIndexTweak" );
		}
	}

	@Override
	public void setIndexTweak( IBusModelProtIndexTweak src ) {
		super.setTweak( src );
		setJustProtRequiredContainerIndexDef(src.getRequiredContainerIndexDef());
		setJustProtRequiredIndexId(src.getRequiredIndexId());
	}

	@Override
	public void set( IBusModelProtTweakH src ) {
		if( src instanceof IBusModelPubIndexTweakH ) {
			setIndexTweak( (IBusModelPubIndexTweakH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubIndexTweakH" );
		}
	}

	@Override
	public void setIndexTweak( IBusModelProtIndexTweakH src ) {
		super.setTweak( src );
		setJustProtRequiredContainerIndexDef(src.getRequiredContainerIndexDef());
		setJustProtRequiredIndexId(src.getRequiredIndexId());
	}

	@Override
	public void set( IBusModelPubTweak src ) {
		if( src instanceof BusModelPubProtBuffIndexTweak ) {
			setJustProtIndexTweak( (BusModelPubProtBuffIndexTweak)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubProtBuffIndexTweak" );
		}
	}

	@Override
	public void setIndexTweak( IBusModelPubIndexTweak src ) {
		super.setTweak( src );
		setJustProtRequiredContainerIndexDef(src.getRequiredContainerIndexDef());
		setJustProtRequiredIndexId(src.getRequiredIndexId());
	}

	@Override
	public void set( IBusModelPubTweakH src ) {
		if( src instanceof IBusModelPubIndexTweakH ) {
			setIndexTweak( (IBusModelPubIndexTweakH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubIndexTweakH" );
		}
	}

	@Override
	public void setIndexTweak( IBusModelPubIndexTweakH src ) {
		super.setTweak( src );
		setJustProtRequiredContainerIndexDef(src.getRequiredContainerIndexDef());
		setJustProtRequiredIndexId(src.getRequiredIndexId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredIndexId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelProtBuffIndexTweak" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
