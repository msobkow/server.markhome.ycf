// Description: Java 25 edit object instance implementation for Secure ISOCtryLang.

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

public class SecureISOCtryLangEditObj
	implements ISecureISOCtryLangEditObj
{
	protected ISecureISOCtryLangObj orig;
	protected ISecureISOCtryLang rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureISOCtryObj requiredContainerCtry;
	protected ISecureISOLangObj requiredParentLang;

	public SecureISOCtryLangEditObj( ISecureISOCtryLangObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOCtryLang origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerCtry = null;
		requiredParentLang = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCtryLang rec = getRec();
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
			ISecureISOCtryLang rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getISOCtryLangTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOCtryLang" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureISOCtryObj scope = getRequiredContainerCtry();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		short val = rec.getRequiredISOLangId();
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
	public ISecureISOCtryLangObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOCtryLangObj retobj = getSchema().getISOCtryLangTableObj().realiseISOCtryLang( (ISecureISOCtryLangObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOCtryLang().forget();
	}

	@Override
	public ISecureISOCtryLangObj read() {
		ISecureISOCtryLangObj retval = getOrigAsISOCtryLang().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryLangObj read( boolean forceRead ) {
		ISecureISOCtryLangObj retval = getOrigAsISOCtryLang().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryLangObj create() {
		copyRecToOrig();
		ISecureISOCtryLangObj retobj = ((ISecureSchemaObj)getOrigAsISOCtryLang().getSchema()).getISOCtryLangTableObj().createISOCtryLang( getOrigAsISOCtryLang() );
		if( retobj == getOrigAsISOCtryLang() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOCtryLangEditObj update() {
		getSchema().getISOCtryLangTableObj().updateISOCtryLang( (ISecureISOCtryLangObj)this );
		return( null );
	}

	@Override
	public SecureISOCtryLangEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOCtryLangTableObj().deleteISOCtryLang( getOrigAsISOCtryLang() );
		return( null );
	}

	@Override
	public ISecureISOCtryLangTableObj getISOCtryLangTable() {
		return( orig.getSchema().getISOCtryLangTableObj() );
	}

	@Override
	public ISecureISOCtryLangEditObj getEdit() {
		return( (ISecureISOCtryLangEditObj)this );
	}

	@Override
	public ISecureISOCtryLangEditObj getEditAsISOCtryLang() {
		return( (ISecureISOCtryLangEditObj)this );
	}

	@Override
	public ISecureISOCtryLangEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOCtryLangObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOCtryLangObj getOrigAsISOCtryLang() {
		return( (ISecureISOCtryLangObj)orig );
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
	public ISecureISOCtryLang getRec() {
		if( rec == null ) {
			rec = getOrigAsISOCtryLang().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCtryLang value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerCtry = null;
			requiredParentLang = null;
		}
	}

	@Override
	public ISecureISOCtryLang getISOCtryLangRec() {
		return( (ISecureISOCtryLang)getRec() );
	}

	@Override
	public ISecureISOCtryLangPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureISOCtryLangPKey value ) {
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
	public short getRequiredISOLangId() {
		return( getPKey().getRequiredISOLangId() );
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
				ISecureISOCtryObj obj = ((ISecureSchemaObj)getOrigAsISOCtryLang().getSchema()).getISOCtryTableObj().readISOCtryByIdIdx( getPKey().getRequiredISOCtryId() );
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
			getISOCtryLangRec();
		}
		if( value != null ) {
			requiredContainerCtry = value;
			getISOCtryLangRec().setRequiredContainerCtry(value.getISOCtryRec());
		}
		requiredContainerCtry = value;
	}

	@Override
	public ISecureISOLangObj getRequiredParentLang() {
		return( getRequiredParentLang( false ) );
	}

	@Override
	public ISecureISOLangObj getRequiredParentLang( boolean forceRead ) {
		if( forceRead || ( requiredParentLang == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureISOLangObj obj = ((ISecureSchemaObj)getOrigAsISOCtryLang().getSchema()).getISOLangTableObj().readISOLangByIdIdx( getPKey().getRequiredISOLangId() );
				requiredParentLang = obj;
			}
		}
		return( requiredParentLang );
	}

	@Override
	public void setRequiredParentLang( ISecureISOLangObj value ) {
		if( rec == null ) {
			getISOCtryLangRec();
		}
		if( value != null ) {
			requiredParentLang = value;
			getISOCtryLangRec().setRequiredParentLang(value.getISOLangRec());
		}
		else {
			requiredParentLang = null;
			getISOCtryLangRec().setRequiredParentLang((ISecureISOLang)null);
		}
		requiredParentLang = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredISOCtryId(getPKey().getRequiredISOCtryId());
			rec.getPKey().setRequiredISOLangId(getPKey().getRequiredISOLangId());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredISOCtryId(rec.getPKey().getRequiredISOCtryId());
			getPKey().setRequiredISOLangId(rec.getPKey().getRequiredISOLangId());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureISOCtryLang origRec = getOrigAsISOCtryLang().getISOCtryLangRec();
		ISecureISOCtryLang myRec = getISOCtryLangRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOCtryLang origRec = getOrigAsISOCtryLang().getISOCtryLangRec();
		ISecureISOCtryLang myRec = getISOCtryLangRec();
		myRec.set( origRec );
	}
}
