// Description: Java 25 base object instance implementation for ISOCtryLang

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

public class IntNetISOCtryLangObj
	implements IIntNetISOCtryLangObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureISOCtryLangEditObj edit;
	protected ISecureSchemaObj schema;
	protected ISecureISOCtryLangPKey pKey;
	protected ISecureISOCtryLang rec;
	protected ISecureISOCtryObj requiredContainerCtry;
	protected ISecureISOLangObj requiredParentLang;

	public IntNetISOCtryLangObj() {
		isNew = true;
		requiredContainerCtry = null;
		requiredParentLang = null;
	}

	public IntNetISOCtryLangObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCtry = null;
		requiredParentLang = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getISOCtryLangTableObj().getClassCode() );
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
	public ISecureISOCtryLangObj realise() {
		ISecureISOCtryLangObj retobj = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().realiseISOCtryLang(
			(ISecureISOCtryLangObj)this );
		return( (ISecureISOCtryLangObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().reallyDeepDisposeISOCtryLang( (ISecureISOCtryLangObj)this );
	}

	@Override
	public ISecureISOCtryLangObj read() {
		ISecureISOCtryLangObj retobj = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByIdIdx( getPKey().getRequiredISOCtryId(),
			getPKey().getRequiredISOLangId(), false );
		return( (ISecureISOCtryLangObj)retobj );
	}

	@Override
	public ISecureISOCtryLangObj read( boolean forceRead ) {
		ISecureISOCtryLangObj retobj = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByIdIdx( getPKey().getRequiredISOCtryId(),
			getPKey().getRequiredISOLangId(), forceRead );
		return( (ISecureISOCtryLangObj)retobj );
	}

	@Override
	public ISecureISOCtryLangTableObj getISOCtryLangTable() {
		return( ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj() );
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
	public ISecureISOCtryLang getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableISOCtryLang().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredISOCtryId(),
						getPKey().getRequiredISOLangId() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureISOCtryLang value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureISOCtryLang ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureISOCtryLangRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerCtry = null;
		requiredParentLang = null;
	}

	@Override
	public ISecureISOCtryLang getISOCtryLangRec() {
		return( (ISecureISOCtryLang)getRec() );
	}

	@Override
	public ISecureISOCtryLangPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ISecureISOCtryLangPKey value ) {
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
	public ISecureISOCtryLangEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureISOCtryLangObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureISOCtryLangObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().lockISOCtryLang( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getISOCtryLangTableObj().newEditInstance( lockobj );
		return( (ISecureISOCtryLangEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureISOCtryLangEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureISOCtryLangEditObj getEditAsISOCtryLang() {
		return( (ISecureISOCtryLangEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureISOCtryLang rec = getRec();
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
			ISecureISOCtryLang rec = getRec();
			updatedBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
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
		if( ( requiredContainerCtry == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCtry = ((IIntNetSchemaObj)getSchema()).getISOCtryTableObj().readISOCtryByIdIdx( getPKey().getRequiredISOCtryId(), forceRead );
			}
		}
		return( requiredContainerCtry );
	}

	@Override
	public ISecureISOLangObj getRequiredParentLang() {
		return( getRequiredParentLang( false ) );
	}

	@Override
	public ISecureISOLangObj getRequiredParentLang( boolean forceRead ) {
		if( ( requiredParentLang == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentLang = ((IIntNetSchemaObj)getSchema()).getISOLangTableObj().readISOLangByIdIdx( getPKey().getRequiredISOLangId(), forceRead );
			}
		}
		return( requiredParentLang );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredISOCtryId(getPKey().getRequiredISOCtryId());
			rec.getPKey().setRequiredISOLangId(getPKey().getRequiredISOLangId());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredISOCtryId(rec.getPKey().getRequiredISOCtryId());
			getPKey().setRequiredISOLangId(rec.getPKey().getRequiredISOLangId());
		}
	}
}
