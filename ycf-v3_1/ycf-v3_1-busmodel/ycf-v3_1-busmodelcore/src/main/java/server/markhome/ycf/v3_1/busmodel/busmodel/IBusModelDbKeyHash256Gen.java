// Description: Java 25 interface for a DbKeyHash256Gen record declementation

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

package server.markhome.ycf.v3_1.busmodel.busmodel;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

/**
 *	IBusModelDbKeyHash256Gen persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelDbKeyHash256Gen
	extends IBusModelDbKeyHash256Type
{
	public static final short SLICE_MIN_VALUE = (short)0;
	public static final int BLOCKSIZE_MIN_VALUE = 1;
	public static final short SLICE_MAX_VALUE = (short)32767;
	public static final int BLOCKSIZE_MAX_VALUE = 2147483647;
	public static final short SLICE_INIT_VALUE = (short)0;
	public static final int BLOCKSIZE_INIT_VALUE = 1;
	public final static int CLASS_CODE = 0xa84b;
	public final static String S_CLASS_CODE = "a84b";

	public short getRequiredSlice();
	public void setRequiredSlice( short value );
	public int getRequiredBlockSize();
	public void setRequiredBlockSize( int value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelValue src );

	public void setDbKeyHash256Gen( IBusModelDbKeyHash256Gen src );

	public void set( IBusModelValueH src );

	public void setDbKeyHash256Gen( IBusModelDbKeyHash256GenH src );

	public void set( IBusModelProtValue src );

	public void setDbKeyHash256Gen( IBusModelProtDbKeyHash256Gen src );

	public void set( IBusModelProtValueH src );

	public void setDbKeyHash256Gen( IBusModelProtDbKeyHash256GenH src );

	public void set( IBusModelPubValue src );

	public void setDbKeyHash256Gen( IBusModelPubDbKeyHash256Gen src );

	public void set( IBusModelPubValueH src );

	public void setDbKeyHash256Gen( IBusModelPubDbKeyHash256GenH src );

	public String getXmlAttrFragment();

	public String toString();
}
