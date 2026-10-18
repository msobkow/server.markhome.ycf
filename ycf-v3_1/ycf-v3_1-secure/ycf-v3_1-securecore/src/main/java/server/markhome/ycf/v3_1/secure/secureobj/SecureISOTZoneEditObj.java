// Description: Java 25 edit object instance implementation for Secure ISOTZone.

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

public class SecureISOTZoneEditObj
	implements ISecureISOTZoneEditObj
{
	protected ISecureISOTZoneObj orig;
	protected ISecureISOTZone rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;

	public SecureISOTZoneEditObj( ISecureISOTZoneObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOTZone origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOTZone rec = getRec();
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
			ISecureISOTZone rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getISOTZoneTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOTZone" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredTZName();
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
	public ISecureISOTZoneObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOTZoneObj retobj = getSchema().getISOTZoneTableObj().realiseISOTZone( (ISecureISOTZoneObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOTZone().forget();
	}

	@Override
	public ISecureISOTZoneObj read() {
		ISecureISOTZoneObj retval = getOrigAsISOTZone().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOTZoneObj read( boolean forceRead ) {
		ISecureISOTZoneObj retval = getOrigAsISOTZone().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOTZoneObj create() {
		copyRecToOrig();
		ISecureISOTZoneObj retobj = ((ISecureSchemaObj)getOrigAsISOTZone().getSchema()).getISOTZoneTableObj().createISOTZone( getOrigAsISOTZone() );
		if( retobj == getOrigAsISOTZone() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOTZoneEditObj update() {
		getSchema().getISOTZoneTableObj().updateISOTZone( (ISecureISOTZoneObj)this );
		return( null );
	}

	@Override
	public SecureISOTZoneEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOTZoneTableObj().deleteISOTZone( getOrigAsISOTZone() );
		return( null );
	}

	@Override
	public ISecureISOTZoneTableObj getISOTZoneTable() {
		return( orig.getSchema().getISOTZoneTableObj() );
	}

	@Override
	public ISecureISOTZoneEditObj getEdit() {
		return( (ISecureISOTZoneEditObj)this );
	}

	@Override
	public ISecureISOTZoneEditObj getEditAsISOTZone() {
		return( (ISecureISOTZoneEditObj)this );
	}

	@Override
	public ISecureISOTZoneEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOTZoneObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOTZoneObj getOrigAsISOTZone() {
		return( (ISecureISOTZoneObj)orig );
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
	public ISecureISOTZone getRec() {
		if( rec == null ) {
			rec = getOrigAsISOTZone().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOTZone value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureISOTZone getISOTZoneRec() {
		return( (ISecureISOTZone)getRec() );
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
	public short getRequiredISOTZoneId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredISOTZoneId(short value) {
		if (getPKey() != value) {
			setPKey(value);
		}
	}

	@Override
	public String getRequiredIso8601() {
		return( getISOTZoneRec().getRequiredIso8601() );
	}

	@Override
	public void setRequiredIso8601( String value ) {
		if( getISOTZoneRec().getRequiredIso8601() != value ) {
			getISOTZoneRec().setRequiredIso8601( value );
		}
	}

	@Override
	public String getRequiredTZName() {
		return( getISOTZoneRec().getRequiredTZName() );
	}

	@Override
	public void setRequiredTZName( String value ) {
		if( getISOTZoneRec().getRequiredTZName() != value ) {
			getISOTZoneRec().setRequiredTZName( value );
		}
	}

	@Override
	public short getRequiredTZHourOffset() {
		return( getISOTZoneRec().getRequiredTZHourOffset() );
	}

	@Override
	public void setRequiredTZHourOffset( short value ) {
		if( getISOTZoneRec().getRequiredTZHourOffset() != value ) {
			getISOTZoneRec().setRequiredTZHourOffset( value );
		}
	}

	@Override
	public short getRequiredTZMinOffset() {
		return( getISOTZoneRec().getRequiredTZMinOffset() );
	}

	@Override
	public void setRequiredTZMinOffset( short value ) {
		if( getISOTZoneRec().getRequiredTZMinOffset() != value ) {
			getISOTZoneRec().setRequiredTZMinOffset( value );
		}
	}

	@Override
	public String getRequiredDescription() {
		return( getISOTZoneRec().getRequiredDescription() );
	}

	@Override
	public void setRequiredDescription( String value ) {
		if( getISOTZoneRec().getRequiredDescription() != value ) {
			getISOTZoneRec().setRequiredDescription( value );
		}
	}

	@Override
	public boolean getRequiredVisible() {
		return( getISOTZoneRec().getRequiredVisible() );
	}

	@Override
	public void setRequiredVisible( boolean value ) {
		if( getISOTZoneRec().getRequiredVisible() != value ) {
			getISOTZoneRec().setRequiredVisible( value );
		}
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
		ISecureISOTZone origRec = getOrigAsISOTZone().getISOTZoneRec();
		ISecureISOTZone myRec = getISOTZoneRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOTZone origRec = getOrigAsISOTZone().getISOTZoneRec();
		ISecureISOTZone myRec = getISOTZoneRec();
		myRec.set( origRec );
	}
}
