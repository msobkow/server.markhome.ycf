// Description: Java 25 edit object instance implementation for IntNet SecUserPWHistory.

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

public class IntNetSecUserPWHistoryEditObj
	implements IIntNetSecUserPWHistoryEditObj
{
	protected ISecureSecUserPWHistoryObj orig;
	protected ISecureSecUserPWHistory rec;

	public IntNetSecUserPWHistoryEditObj( ISecureSecUserPWHistoryObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecUserPWHistory origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)orig.getSchema()).getSecUserPWHistoryTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecUserPWHistoryObj retobj = getSchema().getSecUserPWHistoryTableObj().realiseSecUserPWHistory( (IIntNetSecUserPWHistoryObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecUserPWHistory().forget();
	}

	@Override
	public ISecureSecUserPWHistoryObj read() {
		ISecureSecUserPWHistoryObj retval = getOrigAsSecUserPWHistory().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPWHistoryObj read( boolean forceRead ) {
		ISecureSecUserPWHistoryObj retval = getOrigAsSecUserPWHistory().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPWHistoryObj create() {
		copyRecToOrig();
		ISecureSecUserPWHistoryObj retobj = ((IIntNetSchemaObj)getOrigAsSecUserPWHistory().getSchema()).getSecUserPWHistoryTableObj().createSecUserPWHistory( getOrigAsSecUserPWHistory() );
		if( retobj == getOrigAsSecUserPWHistory() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecUserPWHistoryEditObj update() {
		getSchema().getSecUserPWHistoryTableObj().updateSecUserPWHistory( (ISecureSecUserPWHistoryObj)this );
		return( null );
	}

	@Override
	public SecureSecUserPWHistoryEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecUserPWHistoryTableObj().deleteSecUserPWHistory( getOrigAsSecUserPWHistory() );
		return( null );
	}

	@Override
	public ISecureSecUserPWHistoryTableObj getSecUserPWHistoryTable() {
		return( orig.getSchema().getSecUserPWHistoryTableObj() );
	}

	@Override
	public ISecureSecUserPWHistoryEditObj getEdit() {
		return( (ISecureSecUserPWHistoryEditObj)this );
	}

	@Override
	public ISecureSecUserPWHistoryEditObj getEditAsSecUserPWHistory() {
		return( (ISecureSecUserPWHistoryEditObj)this );
	}

	@Override
	public ISecureSecUserPWHistoryEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecUserPWHistoryObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecUserPWHistoryObj getOrigAsSecUserPWHistory() {
		return( (ISecureSecUserPWHistoryObj)orig );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public ISecureSecUserPWHistory getRec() {
		if( rec == null ) {
			rec = getOrigAsSecUserPWHistory().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUserPWHistory value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureSecUserPWHistory getSecUserPWHistoryRec() {
		return( (ISecureSecUserPWHistory)getRec() );
	}

	@Override
	public ISecureSecUserPWHistoryPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureSecUserPWHistoryPKey value ) {
		orig.setPKey( value );
		copyPKeyToRec();
	}

	@Override
	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	@Override
	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	@Override
	public void setRequiredSecUserId(IYCFKeyHash256 value) {
		if ((getPKey().getRequiredSecUserId() != value ) || ( getSecUserPWHistoryRec().getRequiredSecUserId() != value )) {
			getPKey().setRequiredSecUserId(value);
			getSecUserPWHistoryRec().setRequiredSecUserId( value );
		}
	}

	@Override
	public LocalDateTime getRequiredPWSetStamp() {
		return( getPKey().getRequiredPWSetStamp() );
	}

	@Override
	public void setRequiredPWSetStamp(LocalDateTime value) {
		if ((getPKey().getRequiredPWSetStamp() != value ) || ( getSecUserPWHistoryRec().getRequiredPWSetStamp() != value )) {
			getPKey().setRequiredPWSetStamp(value);
			getSecUserPWHistoryRec().setRequiredPWSetStamp( value );
		}
	}

	@Override
	public LocalDateTime getRequiredPWReplacedStamp() {
		return( getSecUserPWHistoryRec().getRequiredPWReplacedStamp() );
	}

	@Override
	public void setRequiredPWReplacedStamp( LocalDateTime value ) {
		if( getSecUserPWHistoryRec().getRequiredPWReplacedStamp() != value ) {
			getSecUserPWHistoryRec().setRequiredPWReplacedStamp( value );
		}
	}

	@Override
	public String getRequiredPasswordHash() {
		return( getSecUserPWHistoryRec().getRequiredPasswordHash() );
	}

	@Override
	public void setRequiredPasswordHash( String value ) {
		if( getSecUserPWHistoryRec().getRequiredPasswordHash() != value ) {
			getSecUserPWHistoryRec().setRequiredPasswordHash( value );
		}
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecUserId(getPKey().getRequiredSecUserId());
			rec.getPKey().setRequiredPWSetStamp(getPKey().getRequiredPWSetStamp());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecUserId(rec.getPKey().getRequiredSecUserId());
			getPKey().setRequiredPWSetStamp(rec.getPKey().getRequiredPWSetStamp());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureSecUserPWHistory origRec = getOrigAsSecUserPWHistory().getSecUserPWHistoryRec();
		ISecureSecUserPWHistory myRec = getSecUserPWHistoryRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecUserPWHistory origRec = getOrigAsSecUserPWHistory().getSecUserPWHistoryRec();
		ISecureSecUserPWHistory myRec = getSecUserPWHistoryRec();
		myRec.set( origRec );
	}
}
