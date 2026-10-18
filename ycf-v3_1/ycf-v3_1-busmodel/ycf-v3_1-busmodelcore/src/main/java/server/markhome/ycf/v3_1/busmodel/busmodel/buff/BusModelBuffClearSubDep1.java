// Description: Java 25 implementation of a ClearSubDep1 buffer

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

public class BusModelBuffClearSubDep1
	extends BusModelBuffClearDep
	implements IBusModelClearSubDep1
{
	protected IYCFKeyHash256 requiredClearTopDepId;
	protected String requiredName;

	public BusModelBuffClearSubDep1() {
		super();
		requiredClearTopDepId = YCFDbKeyHash256.fromHex( IBusModelPubClearSubDep1.CLEARTOPDEPID_INIT_VALUE.toString() );
		requiredName = IBusModelPubClearSubDep1.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelClearSubDep1.CLASS_CODE );
	}

	@Override
	public IBusModelClearTopDep getRequiredContainerClearTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearTopDepTable targetTable = targetBackingBusModel.getTableClearTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearTopDep()");
		}
		IBusModelClearTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredClearTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelClearTopDep getRequiredContainerClearTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearTopDepTable targetTable = targetBackingBusModel.getTableClearTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearTopDep()");
		}
		IBusModelClearTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredClearTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelClearTopDep getRequiredContainerClearTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearTopDepTable targetTable = targetBackingBusModel.getTableClearTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearTopDep()");
		}
		IBusModelPubClearTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredClearTopDepId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerClearTopDep(IYCFKeyHash256 argClearTopDepId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearTopDep-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearTopDepTable targetTable = targetBackingBusModel.getTableClearTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearTopDep found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argClearTopDepId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerClearTopDep-args", 0, "found");
		}
		else if ((found instanceof IBusModelClearTopDep) || (found instanceof IBusModelProtClearTopDep) || (found instanceof IBusModelPubClearTopDep)) {
		requiredClearTopDepId = argClearTopDepId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerClearTopDep-args", "found", found, "IBusModelClearTopDepIBusModelProtClearTopDepIBusModelPubClearTopDep");
		}
	}

	@Override
	public void setRequiredContainerClearTopDep(IBusModelClearTopDep argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerClearTopDep", 1, "argObj");
		}
		else {
			setRequiredClearTopDepId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelClearSubDep2> getOptionalComponentsClearDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearSubDep2Table targetTable = targetBackingBusModel.getTableClearSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearSubDep2()");
		}
		IBusModelClearSubDep2[] targetArr = targetTable.readDerivedByClearSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelClearSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelClearSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelClearSubDep2> getOptionalComponentsClearDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearSubDep2Table targetTable = targetBackingBusModel.getTableClearSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearSubDep2()");
		}
		IBusModelClearSubDep2[] targetArr = targetTable.readDerivedByClearSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelClearSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelClearSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelClearSubDep2> getOptionalComponentsClearDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelClearSubDep2Table targetTable = targetBackingBusModel.getTableClearSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelSchema.getBackingBusModel().getTableClearSubDep2()");
		}
		IBusModelPubClearSubDep2[] targetArr = targetTable.readDerivedByClearSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubClearSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPubClearSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredClearTopDepId() {
		return(requiredClearTopDepId);
	}

	public void setRequiredClearTopDepId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredClearTopDepId",
				1,
				"value" );
		}
		requiredClearTopDepId = value;
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
		else if( obj instanceof IBusModelClearSubDep1 rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelClearSubDep1H rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelClearSubDep1ByClearTopDepIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelClearSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtClearSubDep1 rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtClearSubDep1H rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelClearSubDep1ByClearTopDepIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelClearSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubClearSubDep1 rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubClearSubDep1H rhs ) {
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
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		else if( obj instanceof IBusModelClearSubDep1ByClearTopDepIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelClearSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredClearTopDepId() != null ) {
				if( rhs.getRequiredClearTopDepId() != null ) {
					if( ! getRequiredClearTopDepId().equals( rhs.getRequiredClearTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearTopDepId() != null ) {
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
		hashCode = hashCode + getRequiredClearTopDepId().hashCode();
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
		else if( obj instanceof IBusModelClearSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelClearSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelClearSubDep1ByClearTopDepIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelClearSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtClearSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtClearSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtClearSubDep1ByClearTopDepIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtClearSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubClearSubDep1ByClearTopDepIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubClearSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredClearTopDepId() != null) {
				if (rhs.getRequiredClearTopDepId() != null) {
					cmp = getRequiredClearTopDepId().compareTo( rhs.getRequiredClearTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearTopDepId() != null) {
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
		if( src instanceof BusModelBuffClearSubDep1 ) {
			setClearSubDep1( (BusModelBuffClearSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffClearSubDep1" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelClearSubDep1 src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelClearSubDep1H ) {
			setClearSubDep1( (IBusModelClearSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelClearSubDep1H" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelClearSubDep1H src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffClearSubDep1 ) {
			setClearSubDep1( (BusModelProtBuffClearSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffClearSubDep1" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelProtClearSubDep1 src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelProtClearSubDep1H ) {
			setClearSubDep1( (IBusModelProtClearSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtClearSubDep1H" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelProtClearSubDep1H src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffClearSubDep1 ) {
			setClearSubDep1( (BusModelPubBuffClearSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffClearSubDep1" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelPubClearSubDep1 src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubClearSubDep1H ) {
			setClearSubDep1( (IBusModelPubClearSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubClearSubDep1H" );
		}
	}

	@Override
	public void setClearSubDep1( IBusModelPubClearSubDep1H src ) {
		super.setClearDep( src );
		setRequiredContainerClearTopDep(src.getRequiredContainerClearTopDep());
		setRequiredClearTopDepId(src.getRequiredClearTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredClearTopDepId=" + "\"" + getRequiredClearTopDepId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffClearSubDep1" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
