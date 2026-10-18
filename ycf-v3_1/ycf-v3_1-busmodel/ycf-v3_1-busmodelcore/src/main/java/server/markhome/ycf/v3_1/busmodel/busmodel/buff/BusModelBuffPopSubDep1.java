// Description: Java 25 implementation of a PopSubDep1 buffer

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

public class BusModelBuffPopSubDep1
	extends BusModelBuffPopDep
	implements IBusModelPopSubDep1
{
	protected IYCFKeyHash256 requiredPopTopDepId;
	protected String requiredName;

	public BusModelBuffPopSubDep1() {
		super();
		requiredPopTopDepId = YCFDbKeyHash256.fromHex( IBusModelPubPopSubDep1.POPTOPDEPID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopSubDep1.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopSubDep1.CLASS_CODE );
	}

	@Override
	public IBusModelPopTopDep getRequiredContainerContPopTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDepTable targetTable = targetBackingBusModel.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopTopDep()");
		}
		IBusModelPopTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredPopTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelPopTopDep getRequiredContainerContPopTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDepTable targetTable = targetBackingBusModel.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopTopDep()");
		}
		IBusModelPopTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredPopTopDepId());
		return(targetRec);
	}

	@Override
	public IBusModelPopTopDep getRequiredContainerContPopTopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDepTable targetTable = targetBackingBusModel.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopTopDep()");
		}
		IBusModelPubPopTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredPopTopDepId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerContPopTopDep(IYCFKeyHash256 argPopTopDepId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContPopTopDep-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDepTable targetTable = targetBackingBusModel.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDep found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPopTopDepId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContPopTopDep-args", 0, "found");
		}
		else if ((found instanceof IBusModelPopTopDep) || (found instanceof IBusModelProtPopTopDep) || (found instanceof IBusModelPubPopTopDep)) {
		requiredPopTopDepId = argPopTopDepId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerContPopTopDep-args", "found", found, "IBusModelPopTopDepIBusModelProtPopTopDepIBusModelPubPopTopDep");
		}
	}

	@Override
	public void setRequiredContainerContPopTopDep(IBusModelPopTopDep argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerContPopTopDep", 1, "argObj");
		}
		else {
			setRequiredPopTopDepId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelPopSubDep2> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep2Table targetTable = targetBackingBusModel.getTablePopSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep2()");
		}
		IBusModelPopSubDep2[] targetArr = targetTable.readDerivedByPopSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPopSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPopSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelPopSubDep2> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep2Table targetTable = targetBackingBusModel.getTablePopSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep2()");
		}
		IBusModelPopSubDep2[] targetArr = targetTable.readDerivedByPopSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPopSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPopSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelPopSubDep2> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep2Table targetTable = targetBackingBusModel.getTablePopSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep2()");
		}
		IBusModelPubPopSubDep2[] targetArr = targetTable.readDerivedByPopSubDep1Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubPopSubDep2> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPubPopSubDep2> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredPopTopDepId() {
		return(requiredPopTopDepId);
	}

	public void setRequiredPopTopDepId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPopTopDepId",
				1,
				"value" );
		}
		requiredPopTopDepId = value;
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
		else if( obj instanceof IBusModelPopSubDep1 rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPopSubDep1H rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPopSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtPopSubDep1 rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelProtPopSubDep1H rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPopSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubPopSubDep1 rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPubPopSubDep1H rhs ) {
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
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if( obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPopSubDep1ByUNameIdxKey rhs ) {
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		hashCode = hashCode + getRequiredPopTopDepId().hashCode();
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
		else if( obj instanceof IBusModelPopSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPopSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPopSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtPopSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtPopSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelProtPopSubDep1ByPopTopDepIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtPopSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubPopSubDep1 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubPopSubDep1H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPubPopSubDep1ByPopTopDepIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubPopSubDep1ByUNameIdxKey rhs ) {
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		if( src instanceof BusModelBuffPopSubDep1 ) {
			setPopSubDep1( (BusModelBuffPopSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffPopSubDep1" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPopSubDep1 src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopSubDep1H ) {
			setPopSubDep1( (IBusModelPopSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopSubDep1H" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPopSubDep1H src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffPopSubDep1 ) {
			setPopSubDep1( (BusModelProtBuffPopSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffPopSubDep1" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelProtPopSubDep1 src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelProtPopSubDep1H ) {
			setPopSubDep1( (IBusModelProtPopSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtPopSubDep1H" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelProtPopSubDep1H src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffPopSubDep1 ) {
			setPopSubDep1( (BusModelPubBuffPopSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffPopSubDep1" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPubPopSubDep1 src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubPopSubDep1H ) {
			setPopSubDep1( (IBusModelPubPopSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubPopSubDep1H" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPubPopSubDep1H src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredPopTopDepId=" + "\"" + getRequiredPopTopDepId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffPopSubDep1" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
