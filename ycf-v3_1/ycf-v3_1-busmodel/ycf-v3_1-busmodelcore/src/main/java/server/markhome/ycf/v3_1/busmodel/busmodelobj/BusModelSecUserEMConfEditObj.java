// Description: Java 25 edit object instance implementation for BusModel SecUserEMConf.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSecUserEMConfEditObj
	implements IBusModelSecUserEMConfEditObj
{
	protected ISecureSecUserEMConfObj orig;
	protected ISecureSecUserEMConf rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecUserObj requiredContainerUser;

	public BusModelSecUserEMConfEditObj( ISecureSecUserEMConfObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecUserEMConf origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerUser = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecUserEMConf rec = getRec();
			createdBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			ISecureSecUserEMConf rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecUserEMConfTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecUserEMConf" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecUserObj scope = getRequiredContainerUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		IYCFUuid6 val = rec.getRequiredEMConfirmationUuid6();
		if (val != null) {
			objName = val.toString();
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
	public ISecureSecUserEMConfObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecUserEMConfObj retobj = getSchema().getSecUserEMConfTableObj().realiseSecUserEMConf( (IBusModelSecUserEMConfObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecUserEMConf().forget();
	}

	@Override
	public ISecureSecUserEMConfObj read() {
		ISecureSecUserEMConfObj retval = getOrigAsSecUserEMConf().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserEMConfObj read( boolean forceRead ) {
		ISecureSecUserEMConfObj retval = getOrigAsSecUserEMConf().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserEMConfObj create() {
		copyRecToOrig();
		ISecureSecUserEMConfObj retobj = ((IBusModelSchemaObj)getOrigAsSecUserEMConf().getSchema()).getSecUserEMConfTableObj().createSecUserEMConf( getOrigAsSecUserEMConf() );
		if( retobj == getOrigAsSecUserEMConf() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecUserEMConfEditObj update() {
		getSchema().getSecUserEMConfTableObj().updateSecUserEMConf( (ISecureSecUserEMConfObj)this );
		return( null );
	}

	@Override
	public SecureSecUserEMConfEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecUserEMConfTableObj().deleteSecUserEMConf( getOrigAsSecUserEMConf() );
		return( null );
	}

	@Override
	public ISecureSecUserEMConfTableObj getSecUserEMConfTable() {
		return( orig.getSchema().getSecUserEMConfTableObj() );
	}

	@Override
	public ISecureSecUserEMConfEditObj getEdit() {
		return( (ISecureSecUserEMConfEditObj)this );
	}

	@Override
	public ISecureSecUserEMConfEditObj getEditAsSecUserEMConf() {
		return( (ISecureSecUserEMConfEditObj)this );
	}

	@Override
	public ISecureSecUserEMConfEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecUserEMConfObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecUserEMConfObj getOrigAsSecUserEMConf() {
		return( (ISecureSecUserEMConfObj)orig );
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
	public ISecureSecUserEMConf getRec() {
		if( rec == null ) {
			rec = getOrigAsSecUserEMConf().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUserEMConf value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerUser = null;
		}
	}

	@Override
	public ISecureSecUserEMConf getSecUserEMConfRec() {
		return( (ISecureSecUserEMConf)getRec() );
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
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getPKey() );
	}

	@Override
	public String getRequiredConfirmEMailAddr() {
		return( getSecUserEMConfRec().getRequiredConfirmEMailAddr() );
	}

	@Override
	public void setRequiredConfirmEMailAddr( String value ) {
		if( getSecUserEMConfRec().getRequiredConfirmEMailAddr() != value ) {
			getSecUserEMConfRec().setRequiredConfirmEMailAddr( value );
		}
	}

	@Override
	public LocalDateTime getRequiredEMailSentStamp() {
		return( getSecUserEMConfRec().getRequiredEMailSentStamp() );
	}

	@Override
	public void setRequiredEMailSentStamp( LocalDateTime value ) {
		if( getSecUserEMConfRec().getRequiredEMailSentStamp() != value ) {
			getSecUserEMConfRec().setRequiredEMailSentStamp( value );
		}
	}

	@Override
	public IYCFUuid6 getRequiredEMConfirmationUuid6() {
		return( getSecUserEMConfRec().getRequiredEMConfirmationUuid6() );
	}

	@Override
	public void setRequiredEMConfirmationUuid6( IYCFUuid6 value ) {
		if( getSecUserEMConfRec().getRequiredEMConfirmationUuid6() != value ) {
			getSecUserEMConfRec().setRequiredEMConfirmationUuid6( value );
		}
	}

	@Override
	public boolean getRequiredNewAccount() {
		return( getSecUserEMConfRec().getRequiredNewAccount() );
	}

	@Override
	public void setRequiredNewAccount( boolean value ) {
		if( getSecUserEMConfRec().getRequiredNewAccount() != value ) {
			getSecUserEMConfRec().setRequiredNewAccount( value );
		}
	}

	@Override
	public ISecureSecUserObj getRequiredContainerUser() {
		return( getRequiredContainerUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredContainerUser( boolean forceRead ) {
		if( forceRead || ( requiredContainerUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((IBusModelSchemaObj)getOrigAsSecUserEMConf().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey() );
				requiredContainerUser = obj;
				if( obj != null ) {
					requiredContainerUser = obj;
				}
			}
		}
		return( requiredContainerUser );
	}

	@Override
	public void setRequiredContainerUser( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecUserEMConfRec();
		}
		if( value != null ) {
			requiredContainerUser = value;
			getSecUserEMConfRec().setRequiredContainerUser(value.getSecUserRec());
		}
		requiredContainerUser = value;
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
		ISecureSecUserEMConf origRec = getOrigAsSecUserEMConf().getSecUserEMConfRec();
		ISecureSecUserEMConf myRec = getSecUserEMConfRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecUserEMConf origRec = getOrigAsSecUserEMConf().getSecUserEMConfRec();
		ISecureSecUserEMConf myRec = getSecUserEMConfRec();
		myRec.set( origRec );
	}
}
