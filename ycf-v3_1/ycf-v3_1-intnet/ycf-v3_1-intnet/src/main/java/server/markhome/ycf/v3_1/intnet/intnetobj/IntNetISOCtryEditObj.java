// Description: Java 25 edit object instance implementation for IntNet ISOCtry.

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

public class IntNetISOCtryEditObj
	implements IIntNetISOCtryEditObj
{
	protected ISecureISOCtryObj orig;
	protected ISecureISOCtry rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureISOCtryCcyObj> optionalComponentsCcy;
	protected List<ISecureISOCtryLangObj> optionalComponentsLang;

	public IntNetISOCtryEditObj( ISecureISOCtryObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureISOCtry origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCtry rec = getRec();
			createdBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			ISecureISOCtry rec = getRec();
			updatedBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getISOCtryTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOCtry" );
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
	public ISecureISOCtryObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureISOCtryObj retobj = getSchema().getISOCtryTableObj().realiseISOCtry( (IIntNetISOCtryObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsISOCtry().forget();
	}

	@Override
	public ISecureISOCtryObj read() {
		ISecureISOCtryObj retval = getOrigAsISOCtry().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryObj read( boolean forceRead ) {
		ISecureISOCtryObj retval = getOrigAsISOCtry().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureISOCtryObj create() {
		copyRecToOrig();
		ISecureISOCtryObj retobj = ((IIntNetSchemaObj)getOrigAsISOCtry().getSchema()).getISOCtryTableObj().createISOCtry( getOrigAsISOCtry() );
		if( retobj == getOrigAsISOCtry() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureISOCtryEditObj update() {
		getSchema().getISOCtryTableObj().updateISOCtry( (ISecureISOCtryObj)this );
		return( null );
	}

	@Override
	public SecureISOCtryEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getISOCtryTableObj().deleteISOCtry( getOrigAsISOCtry() );
		return( null );
	}

	@Override
	public ISecureISOCtryTableObj getISOCtryTable() {
		return( orig.getSchema().getISOCtryTableObj() );
	}

	@Override
	public ISecureISOCtryEditObj getEdit() {
		return( (ISecureISOCtryEditObj)this );
	}

	@Override
	public ISecureISOCtryEditObj getEditAsISOCtry() {
		return( (ISecureISOCtryEditObj)this );
	}

	@Override
	public ISecureISOCtryEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureISOCtryObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureISOCtryObj getOrigAsISOCtry() {
		return( (ISecureISOCtryObj)orig );
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
	public ISecureISOCtry getRec() {
		if( rec == null ) {
			rec = getOrigAsISOCtry().getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCtry value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureISOCtry getISOCtryRec() {
		return( (ISecureISOCtry)getRec() );
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
	public short getRequiredISOCtryId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredISOCtryId(short value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalComponentsCcy = null;
			optionalComponentsLang = null;
		}
	}

	@Override
	public String getRequiredISOCode() {
		return( getISOCtryRec().getRequiredISOCode() );
	}

	@Override
	public void setRequiredISOCode( String value ) {
		if( getISOCtryRec().getRequiredISOCode() != value ) {
			getISOCtryRec().setRequiredISOCode( value );
		}
	}

	@Override
	public String getRequiredName() {
		return( getISOCtryRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getISOCtryRec().getRequiredName() != value ) {
			getISOCtryRec().setRequiredName( value );
		}
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalComponentsCcy() {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCtryIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalComponentsCcy( boolean forceRead ) {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCtryIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalComponentsLang() {
		List<ISecureISOCtryLangObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByCtryIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalComponentsLang( boolean forceRead ) {
		List<ISecureISOCtryLangObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByCtryIdx( getPKey(),
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
		ISecureISOCtry origRec = getOrigAsISOCtry().getISOCtryRec();
		ISecureISOCtry myRec = getISOCtryRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureISOCtry origRec = getOrigAsISOCtry().getISOCtryRec();
		ISecureISOCtry myRec = getISOCtryRec();
		myRec.set( origRec );
	}
}
