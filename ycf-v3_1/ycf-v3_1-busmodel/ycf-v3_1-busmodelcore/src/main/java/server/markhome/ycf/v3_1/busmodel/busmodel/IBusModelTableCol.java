// Description: Java 25 interface for a TableCol record declementation

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
 *	IBusModelTableCol persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelTableCol
	extends IBusModelValue
{
	public static final String S_TABLEID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TABLEID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TABLEID_INIT_VALUE );
	public static final String S_DATAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 DATAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_DATAID_INIT_VALUE );
	public static final String XMLELEMENTNAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa85c;
	public final static String S_CLASS_CODE = "a85c";

	public IBusModelTable getRequiredContainerTable();

	public void setRequiredContainerTable(IYCFKeyHash256 argTableId);

	public void setRequiredContainerTable(IBusModelTable argObj);

	public void setRequiredContainerTable(IBusModelProtTable argObj);

	public void setRequiredContainerTable(IBusModelPubTable argObj);

	public IBusModelValue getRequiredParentDataType();

	public void setRequiredParentDataType(IYCFKeyHash256 argDataId);

	public void setRequiredParentDataType(IBusModelValue argObj);

	public void setRequiredParentDataType(IBusModelProtValue argObj);

	public void setRequiredParentDataType(IBusModelPubValue argObj);

	public IYCFKeyHash256 getRequiredTableId();
	public void setRequiredTableId( IYCFKeyHash256 value );
	public String getOptionalDbName();
	public void setOptionalDbName( String value );
	public IYCFKeyHash256 getOptionalDataId();
	public void setOptionalDataId( IYCFKeyHash256 value );
	public String getOptionalXmlElementName();
	public void setOptionalXmlElementName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelValue src );

	public void setTableCol( IBusModelTableCol src );

	public void set( IBusModelValueH src );

	public void setTableCol( IBusModelTableColH src );

	public void set( IBusModelProtValue src );

	public void setTableCol( IBusModelProtTableCol src );

	public void set( IBusModelProtValueH src );

	public void setTableCol( IBusModelProtTableColH src );

	public void set( IBusModelPubValue src );

	public void setTableCol( IBusModelPubTableCol src );

	public void set( IBusModelPubValueH src );

	public void setTableCol( IBusModelPubTableColH src );

	public String getXmlAttrFragment();

	public String toString();
}
