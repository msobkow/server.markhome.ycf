// Description: Java 25 implementation of a DelSubDep2 buffer

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

public class BusModelBuffDelSubDep2
	extends BusModelBuffDelDep
	implements IBusModelDelSubDep2
{
	protected IYCFKeyHash256 requiredDelSubDep1Id;
	protected String requiredName;

	public BusModelBuffDelSubDep2() {
		super();
		requiredDelSubDep1Id = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep2.DELSUBDEP1ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubDelSubDep2.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelSubDep2.CLASS_CODE );
	}

	@Override
	public IBusModelDelSubDep1 getRequiredContainerDelSubDep1() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1Table targetTable = targetBackingBusModel.getTableDelSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep1()");
		}
		IBusModelDelSubDep1 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelSubDep1Id());
		return(targetRec);
	}

	@Override
	public IBusModelDelSubDep1 getRequiredContainerDelSubDep1() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1Table targetTable = targetBackingBusModel.getTableDelSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep1()");
		}
		IBusModelDelSubDep1 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelSubDep1Id());
		return(targetRec);
	}

	@Override
	public IBusModelDelSubDep1 getRequiredContainerDelSubDep1() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1Table targetTable = targetBackingBusModel.getTableDelSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep1()");
		}
		IBusModelPubDelSubDep1 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredDelSubDep1Id());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerDelSubDep1(IYCFKeyHash256 argDelSubDep1Id) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep1-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1Table targetTable = targetBackingBusModel.getTableDelSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1 found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelSubDep1Id);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep1-args", 0, "found");
		}
		else if ((found instanceof IBusModelDelSubDep1) || (found instanceof IBusModelProtDelSubDep1) || (found instanceof IBusModelPubDelSubDep1)) {
		requiredDelSubDep1Id = argDelSubDep1Id;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerDelSubDep1-args", "found", found, "IBusModelDelSubDep1IBusModelProtDelSubDep1IBusModelPubDelSubDep1");
		}
	}

	@Override
	public void setRequiredContainerDelSubDep1(IBusModelDelSubDep1 argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerDelSubDep1", 1, "argObj");
		}
		else {
			setRequiredDelSubDep1Id(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelDelSubDep3> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep3Table targetTable = targetBackingBusModel.getTableDelSubDep3();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep3()");
		}
		IBusModelDelSubDep3[] targetArr = targetTable.readDerivedByDelSubDep2Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelDelSubDep3> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelDelSubDep3> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelDelSubDep3> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep3Table targetTable = targetBackingBusModel.getTableDelSubDep3();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep3()");
		}
		IBusModelDelSubDep3[] targetArr = targetTable.readDerivedByDelSubDep2Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelDelSubDep3> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelDelSubDep3> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelDelSubDep3> getOptionalComponentsDelDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep3Table targetTable = targetBackingBusModel.getTableDelSubDep3();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep3()");
		}
		IBusModelPubDelSubDep3[] targetArr = targetTable.readDerivedByDelSubDep2Idx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubDelSubDep3> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPubDelSubDep3> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredDelSubDep1Id() {
		return(requiredDelSubDep1Id);
	}

	public void setRequiredDelSubDep1Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredDelSubDep1Id",
				1,
				"value" );
		}
		requiredDelSubDep1Id = value;
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
		else if( obj instanceof IBusModelDelSubDep2 rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep2H rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep2ByUNameIdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelProtDelSubDep2 rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelProtDelSubDep2H rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep2ByUNameIdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubDelSubDep2 rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelPubDelSubDep2H rhs ) {
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
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if( obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelDelSubDep2ByUNameIdxKey rhs ) {
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		hashCode = hashCode + getRequiredDelSubDep1Id().hashCode();
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
		else if( obj instanceof IBusModelDelSubDep2 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelDelSubDep2H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelDelSubDep2ByUNameIdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelProtDelSubDep2 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelProtDelSubDep2H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelProtDelSubDep2ByContDelDep1IdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtDelSubDep2ByUNameIdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep2 rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep2H rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPubDelSubDep2ByContDelDep1IdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubDelSubDep2ByUNameIdxKey rhs ) {
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		if( src instanceof BusModelBuffDelSubDep2 ) {
			setDelSubDep2( (BusModelBuffDelSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffDelSubDep2" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelDelSubDep2 src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelSubDep2H ) {
			setDelSubDep2( (IBusModelDelSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelSubDep2H" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelDelSubDep2H src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffDelSubDep2 ) {
			setDelSubDep2( (BusModelProtBuffDelSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffDelSubDep2" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelProtDelSubDep2 src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelProtDelSubDep2H ) {
			setDelSubDep2( (IBusModelProtDelSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtDelSubDep2H" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelProtDelSubDep2H src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffDelSubDep2 ) {
			setDelSubDep2( (BusModelPubBuffDelSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffDelSubDep2" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelPubDelSubDep2 src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubDelSubDep2H ) {
			setDelSubDep2( (IBusModelPubDelSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubDelSubDep2H" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelPubDelSubDep2H src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredDelSubDep1Id=" + "\"" + getRequiredDelSubDep1Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffDelSubDep2" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
