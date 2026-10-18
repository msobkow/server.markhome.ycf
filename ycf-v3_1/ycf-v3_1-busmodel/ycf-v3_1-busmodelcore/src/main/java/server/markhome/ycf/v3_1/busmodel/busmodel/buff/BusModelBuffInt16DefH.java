// Description: Java 25 implementation of a Int16Def history buffer object

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

public class BusModelBuffInt16DefH extends BusModelBuffAtomH
    implements IBusModelInt16DefH
{
	protected Short optionalInitValue;
	protected Short optionalMinValue;
	protected Short optionalMaxValue;

    public BusModelBuffInt16DefH() {
            super();
		optionalInitValue = null;
		optionalMinValue = null;
		optionalMaxValue = null;
    }

    @Override
    public int getClassCode() {
            return( IBusModelInt16Def.CLASS_CODE );
    }

	@Override
	public Short getOptionalInitValue() {
		return(optionalInitValue);
	}

	@Override
	public void setOptionalInitValue( Short value ) {
		if( value < IBusModelPubInt16Def.INITVALUE_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.INITVALUE_MIN_VALUE );
		}
		if( value > IBusModelPubInt16Def.INITVALUE_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.INITVALUE_MAX_VALUE );
		}
		optionalInitValue = value;
	}

	@Override
	public Short getOptionalMinValue() {
		return(optionalMinValue);
	}

	@Override
	public void setOptionalMinValue( Short value ) {
		if( value < IBusModelPubInt16Def.MINVALUE_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.MINVALUE_MIN_VALUE );
		}
		if( value > IBusModelPubInt16Def.MINVALUE_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.MINVALUE_MAX_VALUE );
		}
		optionalMinValue = value;
	}

	@Override
	public Short getOptionalMaxValue() {
		return(optionalMaxValue);
	}

	@Override
	public void setOptionalMaxValue( Short value ) {
		if( value < IBusModelPubInt16Def.MAXVALUE_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.MAXVALUE_MIN_VALUE );
		}
		if( value > IBusModelPubInt16Def.MAXVALUE_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				IBusModelPubInt16Def.MAXVALUE_MAX_VALUE );
		}
		optionalMaxValue = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof IBusModelInt16Def) {
            IBusModelInt16Def rhs = (IBusModelInt16Def)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelInt16DefH) {
			if (!super.equals(obj)) {
				return( false );
			}
            IBusModelInt16DefH rhs = (IBusModelInt16DefH)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelValueHPKey) {
			return( super.equals(obj) );
        }
        else {
			return( super.equals(obj) );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
		if( getOptionalInitValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalInitValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMinValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMinValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMaxValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMaxValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof IBusModelInt16Def) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelInt16Def rhs = (IBusModelInt16Def)obj;
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					cmp = lhsInitValue.compareTo( rhsInitValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelValueHPKey) {
        return( super.compareTo(obj) );
        }
        else if (obj instanceof IBusModelInt16DefH) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelInt16DefH rhs = (IBusModelInt16DefH)obj;
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					cmp = lhsInitValue.compareTo( rhsInitValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else {
        return( super.compareTo(obj) );
        }
    }
	@Override
    public void set( IBusModelValue src ) {
		if( src instanceof BusModelBuffInt16Def ) {
			setInt16Def( (BusModelBuffInt16Def)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffInt16Def" );
		}
    }

	@Override
    public void setInt16Def( IBusModelInt16Def src ) {
        super.setAtom( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
    }

	@Override
    public void set( IBusModelValueH src ) {
		if( src instanceof IBusModelInt16DefH ) {
			setInt16Def( (IBusModelInt16DefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelInt16DefH" );
		}
    }

	@Override
    public void setInt16Def( IBusModelInt16DefH src ) {
        super.setAtom( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
    }

    public String getXmlAttrFragment() {
        String ret = super.getXmlAttrFragment() 
			+ " OptionalInitValue=" + ( ( getOptionalInitValue() == null ) ? "null" : "\"" + getOptionalInitValue().toString() + "\"" )
			+ " OptionalMinValue=" + ( ( getOptionalMinValue() == null ) ? "null" : "\"" + getOptionalMinValue().toString() + "\"" )
			+ " OptionalMaxValue=" + ( ( getOptionalMaxValue() == null ) ? "null" : "\"" + getOptionalMaxValue().toString() + "\"" );
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelBuffInt16DefH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
