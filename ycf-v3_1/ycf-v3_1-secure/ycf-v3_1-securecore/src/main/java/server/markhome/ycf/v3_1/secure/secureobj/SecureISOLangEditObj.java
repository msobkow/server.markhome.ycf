// Description: Java 25 edit object instance implementation for Secure ISOLang.

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

public class SecureISOLangEditObj
	implements ISecureISOLangEditObj
{
	protected ISecureISOLangObj orig;
	protected ISecureISOLang rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureISOCtryLangObj> optionalChildrenCtry;

	public SecureISOLangEditObj( ISecureISOLangObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOLang origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOLang rec = getRec();
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
			ISecureISOLang rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getISOLangTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOLang" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredISO6392Code();
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
	public ISecureISOLangObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOLangObj retobj = getSchema().getISOLangTableObj().realiseISOLang( (ISecureISOLangObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOLang().forget();
	}

	@Override
	public ISecureISOLangObj read() {
		ISecureISOLangObj retval = getOrigAsISOLang().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOLangObj read( boolean forceRead ) {
		ISecureISOLangObj retval = getOrigAsISOLang().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOLangObj create() {
		copyRecToOrig();
		ISecureISOLangObj retobj = ((ISecureSchemaObj)getOrigAsISOLang().getSchema()).getISOLangTableObj().createISOLang( getOrigAsISOLang() );
		if( retobj == getOrigAsISOLang() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOLangEditObj update() {
		getSchema().getISOLangTableObj().updateISOLang( (ISecureISOLangObj)this );
		return( null );
	}

	@Override
	public SecureISOLangEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOLangTableObj().deleteISOLang( getOrigAsISOLang() );
		return( null );
	}

	@Override
	public ISecureISOLangTableObj getISOLangTable() {
		return( orig.getSchema().getISOLangTableObj() );
	}

	@Override
	public ISecureISOLangEditObj getEdit() {
		return( (ISecureISOLangEditObj)this );
	}

	@Override
	public ISecureISOLangEditObj getEditAsISOLang() {
		return( (ISecureISOLangEditObj)this );
	}

	@Override
	public ISecureISOLangEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOLangObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOLangObj getOrigAsISOLang() {
		return( (ISecureISOLangObj)orig );
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
	public ISecureISOLang getRec() {
		if( rec == null ) {
			rec = getOrigAsISOLang().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOLang().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOLang value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureISOLang getISOLangRec() {
		return( (ISecureISOLang)getRec() );
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
	public short getRequiredISOLangId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredISOLangId(short value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalChildrenCtry = null;
		}
	}

	@Override
	public String getRequiredISO6392Code() {
		return( getISOLangRec().getRequiredISO6392Code() );
	}

	@Override
	public void setRequiredISO6392Code( String value ) {
		if( getISOLangRec().getRequiredISO6392Code() != value ) {
			getISOLangRec().setRequiredISO6392Code( value );
		}
	}

	@Override
	public String getOptionalISO6391Code() {
		return( getISOLangRec().getOptionalISO6391Code() );
	}

	@Override
	public void setOptionalISO6391Code( String value ) {
		if( getISOLangRec().getOptionalISO6391Code() != value ) {
			getISOLangRec().setOptionalISO6391Code( value );
		}
	}

	@Override
	public String getRequiredEnglishName() {
		return( getISOLangRec().getRequiredEnglishName() );
	}

	@Override
	public void setRequiredEnglishName( String value ) {
		if( getISOLangRec().getRequiredEnglishName() != value ) {
			getISOLangRec().setRequiredEnglishName( value );
		}
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalChildrenCtry() {
		List<ISecureISOCtryLangObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalChildrenCtry( boolean forceRead ) {
		List<ISecureISOCtryLangObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey(),
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
		ISecureISOLang origRec = getOrigAsISOLang().getISOLangRec();
		ISecureISOLang myRec = getISOLangRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOLang origRec = getOrigAsISOLang().getISOLangRec();
		ISecureISOLang myRec = getISOLangRec();
		myRec.set( origRec );
	}
}
