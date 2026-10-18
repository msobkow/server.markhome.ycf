// Description: Java 25 implementation of a DelSubDep1 buffer

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

public class BusModelBuffDelSubDep1
	extends BusModelBuffDelDep
	implements IBusModelDelSubDep1
{
	protected IYCFKeyHash256 requiredDelTopDepId;
	protected String requiredName;

	public BusModelBuffDelSubDep1() {
		super();
		requiredDelTopDepId = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep1.DELTOPDEPID_INIT_VALUE.toString() );
		requiredName = IBusModelPubDelSubDep1.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelSubDep1.CLASS_CODE );
	}

	@Override
	public IBusModelDelTopDep getRequiredContainerDelTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDepTable targetTable = targetBackingBusModel.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelTopDep()");
		}
		IBusModelDelTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelDelTopDep getRequiredContainerDelTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDepTable targetTable = targetBackingBusModel.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelTopDep()");
		}
		IBusModelDelTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelDelTopDep getRequiredContainerDelTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDepTable targetTable = targetBackingBusModel.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelTopDep()");
		}
		IBusModelPubDelTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelTopDepId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerDelTopDep(IYCFKeyHash256 argDelTopDepId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelTopDep-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDepTable targetTable = targetBackingBusModel.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDep found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelTopDepId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelTopDep-args", 0, "found");
		}
		else if ((found instanceof IBusModelDelTopDep) || (found instanceof IBusModelProtDelTopDep) || (found instanceof IBusModelPubDelTopDep)) {
		requiredDelTopDepId = argDelTopDepId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerDelTopDep-args", "found", found, "IBusModelDelTopDepIBusModelProtDelTopDepIBusModelPubDelTopDep");
		}
	}

	@Override
	public void setRequiredContainerDelTopDep(IBusModelDelTopDep argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerDelTopDep", 1, "argObj");
		}
		else {
			setRequiredDelTopDepId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelDelSubDep2> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep2Table targetTable = targetBackingBusModel.getTableDelSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep2()");
		}
		IBusModelDelSubDep2[] targetArr = targetTable.readDerivedByContDelDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelDelSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelDelSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelDelSubDep2> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep2Table targetTable = targetBackingBusModel.getTableDelSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep2()");
		}
		IBusModelDelSubDep2[] targetArr = targetTable.readDerivedByContDelDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelDelSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelDelSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelDelSubDep2> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep2Table targetTable = targetBackingBusModel.getTableDelSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep2()");
		}
		IBusModelPubDelSubDep2[] targetArr = targetTable.readDerivedByContDelDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubDelSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPubDelSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredDelTopDepId() {
		return(requiredDelTopDepId);
	}

	public void setRequiredDelTopDepId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredDelTopDepId",
				1,
				"value" );
		}
		requiredDelTopDepId = value;
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
		else if( obj instanceof IBusModelDelSubDep1 rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep1H rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelScopeHPKey ) {
			IBusModelScopeHPKey rhs = (IBusModelScopeHPKey)obj;
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
		else if( obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtDelSubDep1 rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtDelSubDep1H rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubDelSubDep1 rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubDelSubDep1H rhs ) {
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
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		hashCode = hashCode + getRequiredDelTopDepId().hashCode();
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
		else if( obj instanceof IBusModelDelSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelDelSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelDelSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtDelSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelProtDelSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtDelSubDep1ByDelTopDepIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtDelSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep1ByDelTopDepIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubDelSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
	public void set( IBusModelScope src ) {
		if( src instanceof BusModelBuffDelSubDep1 ) {
			setDelSubDep1( (BusModelBuffDelSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffDelSubDep1" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelDelSubDep1 src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelSubDep1H ) {
			setDelSubDep1( (IBusModelDelSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelSubDep1H" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelDelSubDep1H src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffDelSubDep1 ) {
			setDelSubDep1( (BusModelProtBuffDelSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffDelSubDep1" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelProtDelSubDep1 src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelProtDelSubDep1H ) {
			setDelSubDep1( (IBusModelProtDelSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtDelSubDep1H" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelProtDelSubDep1H src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffDelSubDep1 ) {
			setDelSubDep1( (BusModelPubBuffDelSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffDelSubDep1" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelPubDelSubDep1 src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubDelSubDep1H ) {
			setDelSubDep1( (IBusModelPubDelSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubDelSubDep1H" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelPubDelSubDep1H src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredDelTopDepId=" + "\"" + getRequiredDelTopDepId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffDelSubDep1" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
