// Description: Java 25 implementation of a SchemaRole history buffer object

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

public class BusModelBuffSchemaRoleH extends BusModelBuffRoleDefH
    implements IBusModelSchemaRoleH
{
	protected IYCFKeyHash256 requiredSchemaDefId;
	protected IBusModelPubSchema.RoleScopeEnum requiredRoleScope;

    public BusModelBuffSchemaRoleH() {
            super();
		requiredSchemaDefId = YCFDbKeyHash256.fromHex( IBusModelPubSchemaRole.SCHEMADEFID_INIT_VALUE.toString() );
		requiredRoleScope = IBusModelPubSchemaRole.ROLESCOPE_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( IBusModelSchemaRole.CLASS_CODE );
    }

	@Override
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return(requiredSchemaDefId);
	}

	public void setRequiredSchemaDefId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value" );
		}
		requiredSchemaDefId = value;
	}

	@Override
	public IBusModelPubSchema.RoleScopeEnum getRequiredRoleScope() {
		return(requiredRoleScope);
	}

	public void setRequiredRoleScope( IBusModelPubSchema.RoleScopeEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredRoleScope",
				1,
				"value" );
		}
		requiredRoleScope = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof IBusModelSchemaRole) {
            IBusModelSchemaRole rhs = (IBusModelSchemaRole)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRoleH) {
			if (!super.equals(obj)) {
				return( false );
			}
            IBusModelSchemaRoleH rhs = (IBusModelSchemaRoleH)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelRoleDefHPKey) {
			return( super.equals(obj) );
        }
        else if (obj instanceof IBusModelSchemaRoleBySchemaIdxKey) {
            IBusModelSchemaRoleBySchemaIdxKey rhs = (IBusModelSchemaRoleBySchemaIdxKey)obj;
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey) {
            IBusModelSchemaRoleByRoleScopeIdxKey rhs = (IBusModelSchemaRoleByRoleScopeIdxKey)obj;
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey) {
            IBusModelSchemaRoleBySchRoleScpIdxKey rhs = (IBusModelSchemaRoleBySchRoleScpIdxKey)obj;
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else {
			return( super.equals(obj) );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredSchemaDefId().hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredRoleScope().ordinal();
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof IBusModelSchemaRole) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelSchemaRole rhs = (IBusModelSchemaRole)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelRoleDefHPKey) {
        return( super.compareTo(obj) );
        }
        else if (obj instanceof IBusModelSchemaRoleH) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelSchemaRoleH rhs = (IBusModelSchemaRoleH)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRoleBySchemaIdxKey ) {
            IBusModelSchemaRoleBySchemaIdxKey rhs = (IBusModelSchemaRoleBySchemaIdxKey)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey ) {
            IBusModelSchemaRoleByRoleScopeIdxKey rhs = (IBusModelSchemaRoleByRoleScopeIdxKey)obj;
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey ) {
            IBusModelSchemaRoleBySchRoleScpIdxKey rhs = (IBusModelSchemaRoleBySchRoleScpIdxKey)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else {
        return( super.compareTo(obj) );
        }
    }
	@Override
    public void set( IBusModelRoleDef src ) {
		if( src instanceof BusModelBuffSchemaRole ) {
			setSchemaRole( (BusModelBuffSchemaRole)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffSchemaRole" );
		}
    }

	@Override
    public void setSchemaRole( IBusModelSchemaRole src ) {
        super.setRoleDef( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setRequiredRoleScope( src.getRequiredRoleScope() );
    }

	@Override
    public void set( IBusModelRoleDefH src ) {
		if( src instanceof IBusModelSchemaRoleH ) {
			setSchemaRole( (IBusModelSchemaRoleH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelSchemaRoleH" );
		}
    }

	@Override
    public void setSchemaRole( IBusModelSchemaRoleH src ) {
        super.setRoleDef( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setRequiredRoleScope( src.getRequiredRoleScope() );
    }

    public String getXmlAttrFragment() {
        String ret = super.getXmlAttrFragment() 
			+ " RequiredSchemaDefId=" + "\"" + getRequiredSchemaDefId().toString() + "\""
			+ " RequiredRoleScope=" + "\"" + getRequiredRoleScope().toString() + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelBuffSchemaRoleH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
