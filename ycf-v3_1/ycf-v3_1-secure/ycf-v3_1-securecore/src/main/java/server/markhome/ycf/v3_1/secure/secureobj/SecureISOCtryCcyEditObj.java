// Description: Java 25 edit object instance implementation for Secure ISOCtryCcy.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public class SecureISOCtryCcyEditObj
	implements ISecureISOCtryCcyEditObj
{
	protected ISecureISOCtryCcyObj orig;
	protected ISecureISOCtryCcy rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureISOCtryObj requiredContainerCtry;
	protected ISecureISOCcyObj requiredParentCcy;

	public SecureISOCtryCcyEditObj( ISecureISOCtryCcyObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOCtryCcy origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerCtry = null;
		requiredParentCcy = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCtryCcy rec = getRec();
			createdBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
		}
		return( createdBy );
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( getRec().getCreatedAt() );
	}

	@Override
	public ISecureSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			ISecureISOCtryCcy rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public void setCreatedBy( ISecureSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getRec().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		getRec().setCreatedAt( value );
	}

	@Override
	public void setUpdatedBy( ISecureSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getRec().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		getRec().setUpdatedAt( value );
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)orig.getSchema()).getISOCtryCcyTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOCtryCcy" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureISOCtryObj scope = getRequiredContainerCtry();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		short val = rec.getRequiredISOCcyId();
		objName = Short.toString( val );
		return( objName );
	}

	@Override
	public IYCFAnyObj getObjQualifier( Class qualifyingClass ) {
		IYCFAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
	public ISecureISOCtryCcyObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOCtryCcyObj retobj = getSchema().getISOCtryCcyTableObj().realiseISOCtryCcy( (ISecureISOCtryCcyObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOCtryCcy().forget();
	}

	@Override
	public ISecureISOCtryCcyObj read() {
		ISecureISOCtryCcyObj retval = getOrigAsISOCtryCcy().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryCcyObj read( boolean forceRead ) {
		ISecureISOCtryCcyObj retval = getOrigAsISOCtryCcy().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryCcyObj create() {
		copyRecToOrig();
		ISecureISOCtryCcyObj retobj = ((ISecureSchemaObj)getOrigAsISOCtryCcy().getSchema()).getISOCtryCcyTableObj().createISOCtryCcy( getOrigAsISOCtryCcy() );
		if( retobj == getOrigAsISOCtryCcy() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOCtryCcyEditObj update() {
		getSchema().getISOCtryCcyTableObj().updateISOCtryCcy( (ISecureISOCtryCcyObj)this );
		return( null );
	}

	@Override
	public SecureISOCtryCcyEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOCtryCcyTableObj().deleteISOCtryCcy( getOrigAsISOCtryCcy() );
		return( null );
	}

	@Override
	public ISecureISOCtryCcyTableObj getISOCtryCcyTable() {
		return( orig.getSchema().getISOCtryCcyTableObj() );
	}

	@Override
	public ISecureISOCtryCcyEditObj getEdit() {
		return( (ISecureISOCtryCcyEditObj)this );
	}

	@Override
	public ISecureISOCtryCcyEditObj getEditAsISOCtryCcy() {
		return( (ISecureISOCtryCcyEditObj)this );
	}

	@Override
	public ISecureISOCtryCcyEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOCtryCcyObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOCtryCcyObj getOrigAsISOCtryCcy() {
		return( (ISecureISOCtryCcyObj)orig );
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
	public ISecureISOCtryCcy getRec() {
		if( rec == null ) {
			rec = getOrigAsISOCtryCcy().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCtryCcy value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerCtry = null;
			requiredParentCcy = null;
		}
	}

	@Override
	public ISecureISOCtryCcy getISOCtryCcyRec() {
		return( (ISecureISOCtryCcy)getRec() );
	}

	@Override
	public ISecureISOCtryCcyPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureISOCtryCcyPKey value ) {
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
	public short getRequiredISOCtryId() {
		return( getPKey().getRequiredISOCtryId() );
	}

	@Override
	public short getRequiredISOCcyId() {
		return( getPKey().getRequiredISOCcyId() );
	}

	@Override
	public ISecureISOCtryObj getRequiredContainerCtry() {
		return( getRequiredContainerCtry( false ) );
	}

	@Override
	public ISecureISOCtryObj getRequiredContainerCtry( boolean forceRead ) {
		if( forceRead || ( requiredContainerCtry == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureISOCtryObj obj = ((ISecureSchemaObj)getOrigAsISOCtryCcy().getSchema()).getISOCtryTableObj().readISOCtryByIdIdx( getPKey().getRequiredISOCtryId() );
				requiredContainerCtry = obj;
				if( obj != null ) {
					requiredContainerCtry = obj;
				}
			}
		}
		return( requiredContainerCtry );
	}

	@Override
	public void setRequiredContainerCtry( ISecureISOCtryObj value ) {
		if( rec == null ) {
			getISOCtryCcyRec();
		}
		if( value != null ) {
			requiredContainerCtry = value;
			getISOCtryCcyRec().setRequiredContainerCtry(value.getISOCtryRec());
		}
		requiredContainerCtry = value;
	}

	@Override
	public ISecureISOCcyObj getRequiredParentCcy() {
		return( getRequiredParentCcy( false ) );
	}

	@Override
	public ISecureISOCcyObj getRequiredParentCcy( boolean forceRead ) {
		if( forceRead || ( requiredParentCcy == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureISOCcyObj obj = ((ISecureSchemaObj)getOrigAsISOCtryCcy().getSchema()).getISOCcyTableObj().readISOCcyByIdIdx( getPKey().getRequiredISOCcyId() );
				requiredParentCcy = obj;
			}
		}
		return( requiredParentCcy );
	}

	@Override
	public void setRequiredParentCcy( ISecureISOCcyObj value ) {
		if( rec == null ) {
			getISOCtryCcyRec();
		}
		if( value != null ) {
			requiredParentCcy = value;
			getISOCtryCcyRec().setRequiredParentCcy(value.getISOCcyRec());
		}
		else {
			requiredParentCcy = null;
			getISOCtryCcyRec().setRequiredParentCcy((ISecureISOCcy)null);
		}
		requiredParentCcy = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredISOCtryId(getPKey().getRequiredISOCtryId());
			rec.getPKey().setRequiredISOCcyId(getPKey().getRequiredISOCcyId());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredISOCtryId(rec.getPKey().getRequiredISOCtryId());
			getPKey().setRequiredISOCcyId(rec.getPKey().getRequiredISOCcyId());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureISOCtryCcy origRec = getOrigAsISOCtryCcy().getISOCtryCcyRec();
		ISecureISOCtryCcy myRec = getISOCtryCcyRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOCtryCcy origRec = getOrigAsISOCtryCcy().getISOCtryCcyRec();
		ISecureISOCtryCcy myRec = getISOCtryCcyRec();
		myRec.set( origRec );
	}
}
