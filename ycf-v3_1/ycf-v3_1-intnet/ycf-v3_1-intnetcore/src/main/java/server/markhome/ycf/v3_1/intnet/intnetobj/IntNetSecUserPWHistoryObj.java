// Description: Java 25 base object instance implementation for SecUserPWHistory

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetobj;

import java.math.*;
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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class IntNetSecUserPWHistoryObj
	implements IIntNetSecUserPWHistoryObj
{
	protected boolean isNew;
	protected ISecureSecUserPWHistoryEditObj edit;
	protected ISecureSchemaObj schema;
	protected ISecureSecUserPWHistoryPKey pKey;
	protected ISecureSecUserPWHistory rec;

	public IntNetSecUserPWHistoryObj() {
		isNew = true;
	}

	public IntNetSecUserPWHistoryObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecUserPWHistoryTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecUserPWHistory" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		LocalDateTime val = rec.getRequiredPWSetStamp();
		if (val != null) {
			objName = YCFXmlUtil.formatTimestamp(val);
		}
		else {
			objName = "";
		}
		return( objName );
	}

	@Override
	public IYCFAnyObj getObjQualifier( Class qualifyingClass ) {
		IYCFAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof IIntNetClusterObj ) {
					break;
				}
				else if( container instanceof IIntNetTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof IIntNetClusterObj ) {
					break;
				}
				else if( container instanceof IIntNetTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	@Override
	public IYCFAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		IYCFAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		IYCFAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
	}

	@Override
	public IYCFAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		IYCFAnyObj subObj = null;
		IYCFAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	@Override
	public String getObjQualifiedName() {
		String qualName = getObjName();
		IYCFAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ISecureClusterObj ) {
				container = null;
			}
			else if( container instanceof ISecureTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	@Override
	public String getObjFullName() {
		String fullName = getObjName();
		IYCFAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ISecureClusterObj ) {
				container = null;
			}
			else if( container instanceof ISecureTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	@Override
	public ISecureSecUserPWHistoryObj realise() {
		ISecureSecUserPWHistoryObj retobj = ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().realiseSecUserPWHistory(
			(ISecureSecUserPWHistoryObj)this );
		return( (ISecureSecUserPWHistoryObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().reallyDeepDisposeSecUserPWHistory( (ISecureSecUserPWHistoryObj)this );
	}

	@Override
	public ISecureSecUserPWHistoryObj read() {
		ISecureSecUserPWHistoryObj retobj = ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().readSecUserPWHistoryByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredPWSetStamp(), false );
		return( (ISecureSecUserPWHistoryObj)retobj );
	}

	@Override
	public ISecureSecUserPWHistoryObj read( boolean forceRead ) {
		ISecureSecUserPWHistoryObj retobj = ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().readSecUserPWHistoryByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredPWSetStamp(), forceRead );
		return( (ISecureSecUserPWHistoryObj)retobj );
	}

	@Override
	public ISecureSecUserPWHistoryTableObj getSecUserPWHistoryTable() {
		return( ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		schema = value;
	}

	@Override
	public ISecureSecUserPWHistory getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecUserPWHistory().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecUserId(),
						getPKey().getRequiredPWSetStamp() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUserPWHistory value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecUserPWHistory ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecUserPWHistoryRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ISecureSecUserPWHistory getSecUserPWHistoryRec() {
		return( (ISecureSecUserPWHistory)getRec() );
	}

	@Override
	public ISecureSecUserPWHistoryPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ISecureSecUserPWHistoryPKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToRec();
		}
	}

	@Override
	public boolean getIsNew() {
		return( isNew );
	}

	@Override
	public void setIsNew( boolean value ) {
		isNew = value;
	}

	@Override
	public ISecureSecUserPWHistoryEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecUserPWHistoryObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecUserPWHistoryObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().lockSecUserPWHistory( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getSecUserPWHistoryTableObj().newEditInstance( lockobj );
		return( (ISecureSecUserPWHistoryEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecUserPWHistoryEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecUserPWHistoryEditObj getEditAsSecUserPWHistory() {
		return( (ISecureSecUserPWHistoryEditObj)edit );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	@Override
	public LocalDateTime getRequiredPWSetStamp() {
		return( getPKey().getRequiredPWSetStamp() );
	}

	@Override
	public LocalDateTime getRequiredPWReplacedStamp() {
		return( getSecUserPWHistoryRec().getRequiredPWReplacedStamp() );
	}

	@Override
	public String getRequiredPasswordHash() {
		return( getSecUserPWHistoryRec().getRequiredPasswordHash() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecUserId(getPKey().getRequiredSecUserId());
			rec.getPKey().setRequiredPWSetStamp(getPKey().getRequiredPWSetStamp());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecUserId(rec.getPKey().getRequiredSecUserId());
			getPKey().setRequiredPWSetStamp(rec.getPKey().getRequiredPWSetStamp());
		}
	}
}
