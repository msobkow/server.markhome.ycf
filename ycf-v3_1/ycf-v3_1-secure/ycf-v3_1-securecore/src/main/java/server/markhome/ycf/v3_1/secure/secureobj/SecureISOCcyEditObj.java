// Description: Java 25 edit object instance implementation for Secure ISOCcy.

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

public class SecureISOCcyEditObj
	implements ISecureISOCcyEditObj
{
	protected ISecureISOCcyObj orig;
	protected ISecureISOCcy rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureISOCtryCcyObj> optionalChildrenCtry;

	public SecureISOCcyEditObj( ISecureISOCcyObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOCcy origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCcy rec = getRec();
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
			ISecureISOCcy rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getISOCcyTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOCcy" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredISOCode();
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
	public ISecureISOCcyObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOCcyObj retobj = getSchema().getISOCcyTableObj().realiseISOCcy( (ISecureISOCcyObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOCcy().forget();
	}

	@Override
	public ISecureISOCcyObj read() {
		ISecureISOCcyObj retval = getOrigAsISOCcy().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCcyObj read( boolean forceRead ) {
		ISecureISOCcyObj retval = getOrigAsISOCcy().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCcyObj create() {
		copyRecToOrig();
		ISecureISOCcyObj retobj = ((ISecureSchemaObj)getOrigAsISOCcy().getSchema()).getISOCcyTableObj().createISOCcy( getOrigAsISOCcy() );
		if( retobj == getOrigAsISOCcy() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOCcyEditObj update() {
		getSchema().getISOCcyTableObj().updateISOCcy( (ISecureISOCcyObj)this );
		return( null );
	}

	@Override
	public SecureISOCcyEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOCcyTableObj().deleteISOCcy( getOrigAsISOCcy() );
		return( null );
	}

	@Override
	public ISecureISOCcyTableObj getISOCcyTable() {
		return( orig.getSchema().getISOCcyTableObj() );
	}

	@Override
	public ISecureISOCcyEditObj getEdit() {
		return( (ISecureISOCcyEditObj)this );
	}

	@Override
	public ISecureISOCcyEditObj getEditAsISOCcy() {
		return( (ISecureISOCcyEditObj)this );
	}

	@Override
	public ISecureISOCcyEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOCcyObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOCcyObj getOrigAsISOCcy() {
		return( (ISecureISOCcyObj)orig );
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
	public ISecureISOCcy getRec() {
		if( rec == null ) {
			rec = getOrigAsISOCcy().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCcy value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureISOCcy getISOCcyRec() {
		return( (ISecureISOCcy)getRec() );
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( $implCommaIJavaOptAtomType$ value ) {
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
	public short getRequiredISOCcyId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredISOCcyId(short value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalChildrenCtry = null;
		}
	}

	@Override
	public String getRequiredISOCode() {
		return( getISOCcyRec().getRequiredISOCode() );
	}

	@Override
	public void setRequiredISOCode( String value ) {
		if( getISOCcyRec().getRequiredISOCode() != value ) {
			getISOCcyRec().setRequiredISOCode( value );
		}
	}

	@Override
	public String getRequiredName() {
		return( getISOCcyRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getISOCcyRec().getRequiredName() != value ) {
			getISOCcyRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalUnitSymbol() {
		return( getISOCcyRec().getOptionalUnitSymbol() );
	}

	@Override
	public void setOptionalUnitSymbol( String value ) {
		if( getISOCcyRec().getOptionalUnitSymbol() != value ) {
			getISOCcyRec().setOptionalUnitSymbol( value );
		}
	}

	@Override
	public short getRequiredPrecis() {
		return( getISOCcyRec().getRequiredPrecis() );
	}

	@Override
	public void setRequiredPrecis( short value ) {
		if( getISOCcyRec().getRequiredPrecis() != value ) {
			getISOCcyRec().setRequiredPrecis( value );
		}
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalChildrenCtry() {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCcyIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalChildrenCtry( boolean forceRead ) {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCcyIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				setPKey(rec.getPKey());
			}
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureISOCcy origRec = getOrigAsISOCcy().getISOCcyRec();
		ISecureISOCcy myRec = getISOCcyRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOCcy origRec = getOrigAsISOCcy().getISOCcyRec();
		ISecureISOCcy myRec = getISOCcyRec();
		myRec.set( origRec );
	}
}
