// Description: Java 25 interface for a PopSubDep2 record declementation

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
 *	IBusModelPopSubDep2 persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPopSubDep2
	extends IBusModelPopDep
{
	public static final String S_POPSUBDEP1ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 POPSUBDEP1ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_POPSUBDEP1ID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa836;
	public final static String S_CLASS_CODE = "a836";

	public IBusModelPopSubDep1 getRequiredContainerPopSubDep1();

	public void setRequiredContainerPopSubDep1(IYCFKeyHash256 argPopSubDep1Id);

	public void setRequiredContainerPopSubDep1(IBusModelPopSubDep1 argObj);

	public void setRequiredContainerPopSubDep1(IBusModelProtPopSubDep1 argObj);

	public void setRequiredContainerPopSubDep1(IBusModelPubPopSubDep1 argObj);

	public List<IBusModelPopSubDep3> getOptionalComponentsPopDep();

	public IYCFKeyHash256 getRequiredPopSubDep1Id();
	public void setRequiredPopSubDep1Id( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelScope src );

	public void setPopSubDep2( IBusModelPopSubDep2 src );

	public void set( IBusModelScopeH src );

	public void setPopSubDep2( IBusModelPopSubDep2H src );

	public void set( IBusModelProtScope src );

	public void setPopSubDep2( IBusModelProtPopSubDep2 src );

	public void set( IBusModelProtScopeH src );

	public void setPopSubDep2( IBusModelProtPopSubDep2H src );

	public void set( IBusModelPubScope src );

	public void setPopSubDep2( IBusModelPubPopSubDep2 src );

	public void set( IBusModelPubScopeH src );

	public void setPopSubDep2( IBusModelPubPopSubDep2H src );

	public String getXmlAttrFragment();

	public String toString();
}
