// Description: Java 25 interface for a TableTweak record declementation

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
 *	IBusModelTableTweak persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelTableTweak
	extends IBusModelTweak
{
	public static final String S_TABLEID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TABLEID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TABLEID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa809;
	public final static String S_CLASS_CODE = "a809";

	public IBusModelTable getRequiredContainerTableDef();

	public void setRequiredContainerTableDef(IYCFKeyHash256 argTableId);

	public void setRequiredContainerTableDef(IBusModelTable argObj);

	public void setRequiredContainerTableDef(IBusModelProtTable argObj);

	public void setRequiredContainerTableDef(IBusModelPubTable argObj);

	public IYCFKeyHash256 getRequiredTableId();
	public void setRequiredTableId( IYCFKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelTweak src );

	public void setTableTweak( IBusModelTableTweak src );

	public void set( IBusModelTweakH src );

	public void setTableTweak( IBusModelTableTweakH src );

	public void set( IBusModelProtTweak src );

	public void setTableTweak( IBusModelProtTableTweak src );

	public void set( IBusModelProtTweakH src );

	public void setTableTweak( IBusModelProtTableTweakH src );

	public void set( IBusModelPubTweak src );

	public void setTableTweak( IBusModelPubTableTweak src );

	public void set( IBusModelPubTweakH src );

	public void setTableTweak( IBusModelPubTableTweakH src );

	public String getXmlAttrFragment();

	public String toString();
}
