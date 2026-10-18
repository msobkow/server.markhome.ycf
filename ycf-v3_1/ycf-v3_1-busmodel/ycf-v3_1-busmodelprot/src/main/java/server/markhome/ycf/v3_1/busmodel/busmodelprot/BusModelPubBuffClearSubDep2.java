// Description: Java 17 implJustPubementation of a ClearSubDep2 buffer

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public class BusModelPubBuffClearSubDep2
	extends BusModelPubBuffClearDep
	implements IBusModelClearSubDep2
{
	protected IYCFKeyHash256 requiredClearSubDep1Id;
	protected String requiredName;

	public BusModelPubBuffClearSubDep2() {
		super();
		requiredClearSubDep1Id = YCFDbKeyHash256.fromHex( IBusModelPubClearSubDep2.CLEARSUBDEP1ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubClearSubDep2.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPubClearSubDep2.CLASS_CODE );
	}

	@Override
	public IBusModelPubClearSubDep1 getRequiredContainerClearSubDep1(IYCFKeyHash256 argClearSubDep1Id) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearSubDep1", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubClearSubDep1Table targetTable = targetBackingBusModel.getTableClearSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearSubDep1", 0, "IBusModelPubSchema.getBackingBusModel().getTableClearSubDep1()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredClearSubDep1Id()));
	}

	@Override
	public void setRequiredContainerClearSubDep1(IYCFKeyHash256 argClearSubDep1Id) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep1-args", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubClearSubDep1Table targetTable = targetBackingBusModel.getTableClearSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTableClearSubDep1()");
		}
		IBusModelPubClearSubDep1 found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argClearSubDep1Id);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearSubDep1-args", 0, "found");
		}
		else if (found instanceof IBusModelPubClearSubDep1) || (found instanceof IBusModelPubClearSubDep1)) {
			super.setRequiredContainerClearSubDep1(argClearSubDep1Id);
		requiredClearSubDep1Id = argClearSubDep1Id;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerClearSubDep1-args", "found", found, "IBusModelPubClearSubDep1IBusModelPubClearSubDep1");
		}
	}

	@Override
	public void setRequiredContainerClearSubDep1(IBusModelPubClearSubDep1 argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerClearSubDep1", 1, "argObj");
		}
		else {
			setRequiredClearSubDep1Id(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelPubClearSubDep3> getOptionalComponentsClearDep(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubClearSubDep3Table targetTable = targetBackingBusModel.getTableClearSubDep3();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelPubSchema.getBackingBusModel().getTableClearSubDep3()");
		}
		IBusModelPubClearSubDep3[] targetArr = targetTable.readDerivedByClearSubDep2Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubClearSubDep3> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubClearSubDep3> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredClearSubDep1Id() {
		return(requiredClearSubDep1Id);
	}

	public void setRequiredClearSubDep1Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredClearSubDep1Id",
				1,
				"value" );
		}
		requiredClearSubDep1Id = value;
	}

	@Override
	public String getRequiredName() {
		return(requiredName);
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new YCFArgumentOverflowException( getClass(),
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
		else if( obj instanceof IBusModelPubClearSubDep2 rhs ) {
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
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2H rhs ) {
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
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubScopeHPKey ) {
			IBusModelPubScopeHPKey rhs = (IBusModelPubScopeHPKey)obj;
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
		else if( obj instanceof IBusModelPubClearSubDep2ByClearSubDep1IdxKey rhs ) {
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubClearSubDep2ByUNameIdxKey rhs ) {
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2 rhs ) {
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
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2H rhs ) {
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
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2ByClearSubDep1IdxKey rhs ) {
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubClearSubDep2ByUNameIdxKey rhs ) {
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		hashCode = hashCode + getRequiredClearSubDep1Id().hashCode();
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
		else if( obj instanceof IBusModelPubClearSubDep2 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep2ByClearSubDep1IdxKey rhs ) {
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubClearSubDep2ByUNameIdxKey rhs ) {
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep2 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubClearSubDep2H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep2ByClearSubDep1IdxKey rhs ) {
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubClearSubDep2ByUNameIdxKey rhs ) {
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffClearSubDep2 ) {
			setJustPubClearSubDep2( (BusModelPubBuffClearSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffClearSubDep2" );
		}
	}

	@Override
	public void setClearSubDep2( IBusModelPubClearSubDep2 src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep1(src.getRequiredContainerClearSubDep1());
		setJustPubRequiredClearSubDep1Id(src.getRequiredClearSubDep1Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubClearSubDep2H ) {
			setClearSubDep2( (IBusModelPubClearSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubClearSubDep2H" );
		}
	}

	@Override
	public void setClearSubDep2( IBusModelPubClearSubDep2H src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep1(src.getRequiredContainerClearSubDep1());
		setJustPubRequiredClearSubDep1Id(src.getRequiredClearSubDep1Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubPubBuffClearSubDep2 ) {
			setJustPubClearSubDep2( (BusModelPubPubBuffClearSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubPubBuffClearSubDep2" );
		}
	}

	@Override
	public void setClearSubDep2( IBusModelPubClearSubDep2 src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep1(src.getRequiredContainerClearSubDep1());
		setJustPubRequiredClearSubDep1Id(src.getRequiredClearSubDep1Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubClearSubDep2H ) {
			setClearSubDep2( (IBusModelPubClearSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubClearSubDep2H" );
		}
	}

	@Override
	public void setClearSubDep2( IBusModelPubClearSubDep2H src ) {
		super.setClearDep( src );
		setJustPubRequiredContainerClearSubDep1(src.getRequiredContainerClearSubDep1());
		setJustPubRequiredClearSubDep1Id(src.getRequiredClearSubDep1Id());
		setJustPubRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredClearSubDep1Id().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelPubBuffClearSubDep2" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
