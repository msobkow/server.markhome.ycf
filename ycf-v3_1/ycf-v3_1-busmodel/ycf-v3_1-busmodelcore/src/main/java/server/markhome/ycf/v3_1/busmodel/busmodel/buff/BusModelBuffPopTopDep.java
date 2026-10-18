// Description: Java 25 implementation of a PopTopDep buffer

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

public class BusModelBuffPopTopDep
	extends BusModelBuffPopDep
	implements IBusModelPopTopDep
{
	protected IYCFKeyHash256 requiredContRelationId;
	protected String requiredName;

	public BusModelBuffPopTopDep() {
		super();
		requiredContRelationId = YCFDbKeyHash256.fromHex( IBusModelPubPopTopDep.CONTRELATIONID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopTopDep.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopTopDep.CLASS_CODE );
	}

	@Override
	public IBusModelRelation getRequiredContainerContRelation() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredContRelationId());
		return(targetRec);
	}

	@Override
	public IBusModelRelation getRequiredContainerContRelation() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredContRelationId());
		return(targetRec);
	}

	@Override
	public IBusModelRelation getRequiredContainerContRelation() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelPubRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredContRelationId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerContRelation(IYCFKeyHash256 argContRelationId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContRelation-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelation found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argContRelationId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContRelation-args", 0, "found");
		}
		else if ((found instanceof IBusModelRelation) || (found instanceof IBusModelProtRelation) || (found instanceof IBusModelPubRelation)) {
		requiredContRelationId = argContRelationId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerContRelation-args", "found", found, "IBusModelRelationIBusModelProtRelationIBusModelPubRelation");
		}
	}

	@Override
	public void setRequiredContainerContRelation(IBusModelRelation argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerContRelation", 1, "argObj");
		}
		else {
			setRequiredContRelationId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelPopSubDep1> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep1Table targetTable = targetBackingBusModel.getTablePopSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep1()");
		}
		IBusModelPopSubDep1[] targetArr = targetTable.readDerivedByPopTopDepIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPopSubDep1> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPopSubDep1> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelPopSubDep1> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep1Table targetTable = targetBackingBusModel.getTablePopSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep1()");
		}
		IBusModelPopSubDep1[] targetArr = targetTable.readDerivedByPopTopDepIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPopSubDep1> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPopSubDep1> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public List<IBusModelPopSubDep1> getOptionalComponentsPopDep() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep1Table targetTable = targetBackingBusModel.getTablePopSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep1()");
		}
		IBusModelPubPopSubDep1[] targetArr = targetTable.readDerivedByPopTopDepIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubPopSubDep1> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<IBusModelPubPopSubDep1> results = new ArrayList<>();
			return( results );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredContRelationId() {
		return(requiredContRelationId);
	}

	public void setRequiredContRelationId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
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
		else if( obj instanceof IBusModelPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByUNameIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByUNameIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByUNameIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPopTopDepByUNameIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtPopTopDepByUNameIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDep rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDepH rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDepByContRelIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPubPopTopDepByUNameIdxKey rhs ) {
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
	public void set( IBusModelScope src ) {
		if( src instanceof BusModelBuffPopTopDep ) {
			setPopTopDep( (BusModelBuffPopTopDep)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPopTopDep src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopTopDepH ) {
			setPopTopDep( (IBusModelPopTopDepH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPopTopDepH src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffPopTopDep ) {
			setPopTopDep( (BusModelProtBuffPopTopDep)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelProtPopTopDep src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelProtPopTopDepH ) {
			setPopTopDep( (IBusModelProtPopTopDepH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelProtPopTopDepH src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffPopTopDep ) {
			setPopTopDep( (BusModelPubBuffPopTopDep)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPubPopTopDep src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubPopTopDepH ) {
			setPopTopDep( (IBusModelPubPopTopDepH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPubPopTopDepH src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredContRelationId=" + "\"" + getRequiredContRelationId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffPopTopDep" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
