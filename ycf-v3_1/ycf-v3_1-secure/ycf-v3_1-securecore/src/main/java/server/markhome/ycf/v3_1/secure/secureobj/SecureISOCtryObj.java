// Description: Java 25 base object instance implementation for ISOCtry

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

public class SecureISOCtryObj
	implements ISecureISOCtryObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureISOCtryEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureISOCtry rec;
	protected List<ISecureISOCtryCcyObj> optionalComponentsCcy;
	protected List<ISecureISOCtryLangObj> optionalComponentsLang;

	public SecureISOCtryObj() {
		isNew = true;
	}

	public SecureISOCtryObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getISOCtryTableObj().getClassCode() );
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
	public ISecureISOCtryObj realise() {
		ISecureISOCtryObj retobj = ((ISecureSchemaObj)getSchema()).getISOCtryTableObj().realiseISOCtry(
			(ISecureISOCtryObj)this );
		return( (ISecureISOCtryObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getISOCtryTableObj().reallyDeepDisposeISOCtry( (ISecureISOCtryObj)this );
	}

	@Override
	public ISecureISOCtryObj read() {
		ISecureISOCtryObj retobj = ((ISecureSchemaObj)getSchema()).getISOCtryTableObj().readISOCtryByIdIdx( getPKey(), false );
		return( (ISecureISOCtryObj)retobj );
	}

	@Override
	public ISecureISOCtryObj read( boolean forceRead ) {
		ISecureISOCtryObj retobj = ((ISecureSchemaObj)getSchema()).getISOCtryTableObj().readISOCtryByIdIdx( getPKey(), forceRead );
		return( (ISecureISOCtryObj)retobj );
	}

	@Override
	public ISecureISOCtryTableObj getISOCtryTable() {
		return( ((ISecureSchemaObj)getSchema()).getISOCtryTableObj() );
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
	public ISecureISOCtry getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableISOCtry().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCtry value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureISOCtry ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureISOCtryRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ISecureISOCtry getISOCtryRec() {
		return( (ISecureISOCtry)getRec() );
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( $implCommaIJavaOptAtomType$ value ) {
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
	public ISecureISOCtryEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureISOCtryObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureISOCtryObj)this;
		}
		else {
			lockobj = ((ISecureSchemaObj)getSchema()).getISOCtryTableObj().lockISOCtry( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getISOCtryTableObj().newEditInstance( lockobj );
		return( (ISecureISOCtryEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureISOCtryEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureISOCtryEditObj getEditAsISOCtry() {
		return( (ISecureISOCtryEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCtry rec = getRec();
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
			ISecureISOCtry rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public short getRequiredISOCtryId() {
		return( getPKey() );
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalComponentsCcy() {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCtryIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryCcyObj> getOptionalComponentsCcy( boolean forceRead ) {
		List<ISecureISOCtryCcyObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryCcyTableObj().readISOCtryCcyByCtryIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalComponentsLang() {
		List<ISecureISOCtryLangObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByCtryIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureISOCtryLangObj> getOptionalComponentsLang( boolean forceRead ) {
		List<ISecureISOCtryLangObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByCtryIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredISOCode() {
		return( getISOCtryRec().getRequiredISOCode() );
	}

	@Override
	public String getRequiredName() {
		return( getISOCtryRec().getRequiredName() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
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
}
