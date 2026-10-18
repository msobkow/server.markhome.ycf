// Description: Java 17 implJustProtementation of a BoolDef buffer

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

public class BusModelProtBuffBoolDef
	extends BusModelProtBuffAtom
	implements IBusModelBoolDef
{
	protected Boolean optionalInitValue;
	protected String optionalFalseString;
	protected String optionalTrueString;
	protected String optionalNullString;

	public BusModelProtBuffBoolDef() {
		super();
		optionalInitValue = null;
		optionalFalseString = null;
		optionalTrueString = null;
		optionalNullString = null;
	}

	@Override
	public int getClassCode() {
		return( IBusModelProtBoolDef.CLASS_CODE );
	}

	@Override
	public Boolean getOptionalInitValue() {
		return(optionalInitValue);
	}

	public void setOptionalInitValue( Boolean value ) {
		optionalInitValue = value;
	}

	@Override
	public String getOptionalFalseString() {
		return(optionalFalseString);
	}

	public void setOptionalFalseString( String value ) {
		if( value != null && value.length() > 32 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalFalseString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		optionalFalseString = value;
	}

	@Override
	public String getOptionalTrueString() {
		return(optionalTrueString);
	}

	public void setOptionalTrueString( String value ) {
		if( value != null && value.length() > 32 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalTrueString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		optionalTrueString = value;
	}

	@Override
	public String getOptionalNullString() {
		return(optionalNullString);
	}

	public void setOptionalNullString( String value ) {
		if( value != null && value.length() > 32 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalNullString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		optionalNullString = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelProtBoolDef rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtBoolDefH rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtValueHPKey ) {
			IBusModelProtValueHPKey rhs = (IBusModelProtValueHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubBoolDef rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubBoolDefH rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubValueHPKey rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		if( getOptionalInitValue() != null ) {
			if( getOptionalInitValue() ) {
				hashCode = ( hashCode * 4 ) + 1;
			}
			else {
				hashCode = hashCode * 4;
			}
		}
		else {
			hashCode = (hashCode * 4 ) + 3;
		}
		if( getOptionalFalseString() != null ) {
			hashCode = hashCode + getOptionalFalseString().hashCode();
		}
		if( getOptionalTrueString() != null ) {
			hashCode = hashCode + getOptionalTrueString().hashCode();
		}
		if( getOptionalNullString() != null ) {
			hashCode = hashCode + getOptionalNullString().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelProtBoolDef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( -1 );
				}
			}
			return( 0 );
 		}
		else if( obj instanceof IBusModelProtValueHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtBoolDefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubBoolDef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubValueHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubBoolDefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelProtValue src ) {
		if( src instanceof BusModelProtBuffBoolDef ) {
			setJustProtBoolDef( (BusModelProtBuffBoolDef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffBoolDef" );
		}
	}

	@Override
	public void setBoolDef( IBusModelProtBoolDef src ) {
		super.setAtom( src );
		setJustProtOptionalInitValue(src.getOptionalInitValue());
		setJustProtOptionalFalseString(src.getOptionalFalseString());
		setJustProtOptionalTrueString(src.getOptionalTrueString());
		setJustProtOptionalNullString(src.getOptionalNullString());
	}

	@Override
	public void set( IBusModelProtValueH src ) {
		if( src instanceof IBusModelPubBoolDefH ) {
			setBoolDef( (IBusModelPubBoolDefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubBoolDefH" );
		}
	}

	@Override
	public void setBoolDef( IBusModelProtBoolDefH src ) {
		super.setAtom( src );
		setJustProtOptionalInitValue(src.getOptionalInitValue());
		setJustProtOptionalFalseString(src.getOptionalFalseString());
		setJustProtOptionalTrueString(src.getOptionalTrueString());
		setJustProtOptionalNullString(src.getOptionalNullString());
	}

	@Override
	public void set( IBusModelPubValue src ) {
		if( src instanceof BusModelPubProtBuffBoolDef ) {
			setJustProtBoolDef( (BusModelPubProtBuffBoolDef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubProtBuffBoolDef" );
		}
	}

	@Override
	public void setBoolDef( IBusModelPubBoolDef src ) {
		super.setAtom( src );
		setJustProtOptionalInitValue(src.getOptionalInitValue());
		setJustProtOptionalFalseString(src.getOptionalFalseString());
		setJustProtOptionalTrueString(src.getOptionalTrueString());
		setJustProtOptionalNullString(src.getOptionalNullString());
	}

	@Override
	public void set( IBusModelPubValueH src ) {
		if( src instanceof IBusModelPubBoolDefH ) {
			setBoolDef( (IBusModelPubBoolDefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubBoolDefH" );
		}
	}

	@Override
	public void setBoolDef( IBusModelPubBoolDefH src ) {
		super.setAtom( src );
		setJustProtOptionalInitValue(src.getOptionalInitValue());
		setJustProtOptionalFalseString(src.getOptionalFalseString());
		setJustProtOptionalTrueString(src.getOptionalTrueString());
		setJustProtOptionalNullString(src.getOptionalNullString());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + ( ( getOptionalInitValue() == null ) ? "null" : ( ( getOptionalInitValue() ) ? "\"true\"" : "\"false\"" ) ) + ( ( getOptionalFalseString() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalFalseString() ) + "\"" ) + ( ( getOptionalTrueString() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalTrueString() ) + "\"" ) + ( ( getOptionalNullString() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalNullString() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelProtBuffBoolDef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
