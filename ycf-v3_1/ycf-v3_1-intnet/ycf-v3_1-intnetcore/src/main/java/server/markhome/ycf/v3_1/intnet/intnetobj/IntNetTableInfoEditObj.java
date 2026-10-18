// Description: Java 25 edit object instance implementation for IntNet TableInfo.

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

public class IntNetTableInfoEditObj
	implements IIntNetTableInfoEditObj
{
	protected ISecureTableInfoObj orig;
	protected ISecureTableInfo rec;
	protected ISecureTableInfoObj optionalParentSuperRef;
	protected List<ISecureTableInfoObj> optionalChildrenSubRefs;

	public IntNetTableInfoEditObj( ISecureTableInfoObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureTableInfo origRec = orig.getRec();
		rec.set( origRec );
		optionalParentSuperRef = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)orig.getSchema()).getTableInfoTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "TableInfo" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredTableName();
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
	public ISecureTableInfoObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureTableInfoObj retobj = getSchema().getTableInfoTableObj().realiseTableInfo( (IIntNetTableInfoObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsTableInfo().forget();
	}

	@Override
	public ISecureTableInfoObj read() {
		ISecureTableInfoObj retval = getOrigAsTableInfo().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureTableInfoObj read( boolean forceRead ) {
		ISecureTableInfoObj retval = getOrigAsTableInfo().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureTableInfoObj create() {
		copyRecToOrig();
		ISecureTableInfoObj retobj = ((IIntNetSchemaObj)getOrigAsTableInfo().getSchema()).getTableInfoTableObj().createTableInfo( getOrigAsTableInfo() );
		if( retobj == getOrigAsTableInfo() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureTableInfoEditObj update() {
		getSchema().getTableInfoTableObj().updateTableInfo( (ISecureTableInfoObj)this );
		return( null );
	}

	@Override
	public SecureTableInfoEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getTableInfoTableObj().deleteTableInfo( getOrigAsTableInfo() );
		return( null );
	}

	@Override
	public ISecureTableInfoTableObj getTableInfoTable() {
		return( orig.getSchema().getTableInfoTableObj() );
	}

	@Override
	public ISecureTableInfoEditObj getEdit() {
		return( (ISecureTableInfoEditObj)this );
	}

	@Override
	public ISecureTableInfoEditObj getEditAsTableInfo() {
		return( (ISecureTableInfoEditObj)this );
	}

	@Override
	public ISecureTableInfoEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureTableInfoObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureTableInfoObj getOrigAsTableInfo() {
		return( (ISecureTableInfoObj)orig );
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
	public ISecureTableInfo getRec() {
		if( rec == null ) {
			rec = getOrigAsTableInfo().getSchema().getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureTableInfo value ) {
		if( rec != value ) {
			rec = value;
			optionalParentSuperRef = null;
		}
	}

	@Override
	public ISecureTableInfo getTableInfoRec() {
		return( (ISecureTableInfo)getRec() );
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
	public int getRequiredTableInfoId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredTableInfoId(int value) {
		if (getPKey() != value) {
			setPKey(value);
		}
	}

	@Override
	public String getRequiredSchemaName() {
		return( getTableInfoRec().getRequiredSchemaName() );
	}

	@Override
	public void setRequiredSchemaName( String value ) {
		if( getTableInfoRec().getRequiredSchemaName() != value ) {
			getTableInfoRec().setRequiredSchemaName( value );
		}
	}

	@Override
	public String getRequiredTableName() {
		return( getTableInfoRec().getRequiredTableName() );
	}

	@Override
	public void setRequiredTableName( String value ) {
		if( getTableInfoRec().getRequiredTableName() != value ) {
			getTableInfoRec().setRequiredTableName( value );
			optionalParentSuperRef = null;
			optionalChildrenSubRefs = null;
		}
	}

	@Override
	public String getOptionalSuperName() {
		return( getTableInfoRec().getOptionalSuperName() );
	}

	@Override
	public int getRequiredBackingClassCode() {
		return( getTableInfoRec().getRequiredBackingClassCode() );
	}

	@Override
	public void setRequiredBackingClassCode( int value ) {
		if( getTableInfoRec().getRequiredBackingClassCode() != value ) {
			getTableInfoRec().setRequiredBackingClassCode( value );
		}
	}

	@Override
	public int getRequiredRuntimeClassCode() {
		return( getTableInfoRec().getRequiredRuntimeClassCode() );
	}

	@Override
	public void setRequiredRuntimeClassCode( int value ) {
		if( getTableInfoRec().getRequiredRuntimeClassCode() != value ) {
			getTableInfoRec().setRequiredRuntimeClassCode( value );
		}
	}

	@Override
	public boolean getRequiredHasHistory() {
		return( getTableInfoRec().getRequiredHasHistory() );
	}

	@Override
	public void setRequiredHasHistory( boolean value ) {
		if( getTableInfoRec().getRequiredHasHistory() != value ) {
			getTableInfoRec().setRequiredHasHistory( value );
		}
	}

	@Override
	public boolean getRequiredIsMutable() {
		return( getTableInfoRec().getRequiredIsMutable() );
	}

	@Override
	public void setRequiredIsMutable( boolean value ) {
		if( getTableInfoRec().getRequiredIsMutable() != value ) {
			getTableInfoRec().setRequiredIsMutable( value );
		}
	}

	@Override
	public String getRequiredSecScopeName() {
		return( getTableInfoRec().getRequiredSecScopeName() );
	}

	@Override
	public void setRequiredSecScopeName( String value ) {
		if( getTableInfoRec().getRequiredSecScopeName() != value ) {
			getTableInfoRec().setRequiredSecScopeName( value );
		}
	}

	@Override
	public String getRequiredCodeVis() {
		return( getTableInfoRec().getRequiredCodeVis() );
	}

	@Override
	public void setRequiredCodeVis( String value ) {
		if( getTableInfoRec().getRequiredCodeVis() != value ) {
			getTableInfoRec().setRequiredCodeVis( value );
		}
	}

	@Override
	public ISecureTableInfoObj getOptionalParentSuperRef() {
		return( getOptionalParentSuperRef( false ) );
	}

	@Override
	public ISecureTableInfoObj getOptionalParentSuperRef( boolean forceRead ) {
		if( forceRead || ( optionalParentSuperRef == null ) ) {
			boolean anyMissing = false;
			if( getTableInfoRec().getOptionalSuperName() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ISecureTableInfoObj obj = ((IIntNetSchemaObj)getOrigAsTableInfo().getSchema()).getTableInfoTableObj().readTableInfoByTableNameIdx( getTableInfoRec().getOptionalSuperName() );
				optionalParentSuperRef = obj;
			}
		}
		return( optionalParentSuperRef );
	}

	@Override
	public void setOptionalParentSuperRef( ISecureTableInfoObj value ) {
		if( rec == null ) {
			getTableInfoRec();
		}
		if( value != null ) {
			optionalParentSuperRef = value;
			getTableInfoRec().setOptionalParentSuperRef(value.getTableInfoRec());
		}
		else {
			optionalParentSuperRef = null;
			getTableInfoRec().setOptionalParentSuperRef((ISecureTableInfo)null);
		}
		optionalParentSuperRef = value;
	}

	@Override
	public List<ISecureTableInfoObj> getOptionalChildrenSubRefs() {
		List<ISecureTableInfoObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoBySuperNameIdx( getTableInfoRec().getRequiredTableName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureTableInfoObj> getOptionalChildrenSubRefs( boolean forceRead ) {
		List<ISecureTableInfoObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoBySuperNameIdx( getTableInfoRec().getRequiredTableName(),
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
		ISecureTableInfo origRec = getOrigAsTableInfo().getTableInfoRec();
		ISecureTableInfo myRec = getTableInfoRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureTableInfo origRec = getOrigAsTableInfo().getTableInfoRec();
		ISecureTableInfo myRec = getTableInfoRec();
		myRec.set( origRec );
	}
}
