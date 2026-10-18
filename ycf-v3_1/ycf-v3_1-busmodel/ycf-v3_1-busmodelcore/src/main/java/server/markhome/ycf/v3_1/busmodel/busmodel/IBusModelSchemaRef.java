// Description: Java 25 interface for a SchemaRef record declementation

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
 *	IBusModelSchemaRef persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelSchemaRef
	extends IBusModelScope
{
	public static final String S_SCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SCHEMAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SCHEMAID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String REFMODELNAME_INIT_VALUE = new String( "" );
	public static final String INCLUDEROOT_INIT_VALUE = new String( "" );
	public static final String S_REFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 REFSCHEMAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_REFSCHEMAID_INIT_VALUE );
	public static final String S_PREVID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 PREVID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_PREVID_INIT_VALUE );
	public static final String S_NEXTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 NEXTID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_NEXTID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa803;
	public final static String S_CLASS_CODE = "a803";

	public IBusModelSchemaDef getRequiredContainerSchema();

	public void setRequiredContainerSchema(IYCFKeyHash256 argSchemaId);

	public void setRequiredContainerSchema(IBusModelSchemaDef argObj);

	public void setRequiredContainerSchema(IBusModelProtSchemaDef argObj);

	public void setRequiredContainerSchema(IBusModelPubSchemaDef argObj);

	public IBusModelSchemaDef getOptionalLookupRefSchema();

	public void setOptionalLookupRefSchema(IYCFKeyHash256 argRefSchemaId);

	public void setOptionalLookupRefSchema(IBusModelSchemaDef argObj);

	public void setOptionalLookupRefSchema(IBusModelProtSchemaDef argObj);

	public void setOptionalLookupRefSchema(IBusModelPubSchemaDef argObj);

	public IBusModelSchemaRef getOptionalLookupPrev();

	public void setOptionalLookupPrev(IYCFKeyHash256 argPrevId);

	public void setOptionalLookupPrev(IBusModelSchemaRef argObj);

	public void setOptionalLookupPrev(IBusModelProtSchemaRef argObj);

	public void setOptionalLookupPrev(IBusModelPubSchemaRef argObj);

	public IBusModelSchemaRef getOptionalLookupNext();

	public void setOptionalLookupNext(IYCFKeyHash256 argNextId);

	public void setOptionalLookupNext(IBusModelSchemaRef argObj);

	public void setOptionalLookupNext(IBusModelProtSchemaRef argObj);

	public void setOptionalLookupNext(IBusModelPubSchemaRef argObj);

	public IYCFKeyHash256 getRequiredSchemaId();
	public void setRequiredSchemaId( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getRequiredRefModelName();
	public void setRequiredRefModelName( String value );
	public String getRequiredIncludeRoot();
	public void setRequiredIncludeRoot( String value );
	public IYCFKeyHash256 getOptionalRefSchemaId();
	public void setOptionalRefSchemaId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getOptionalPrevId();
	public void setOptionalPrevId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getOptionalNextId();
	public void setOptionalNextId( IYCFKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelScope src );

	public void setSchemaRef( IBusModelSchemaRef src );

	public void set( IBusModelScopeH src );

	public void setSchemaRef( IBusModelSchemaRefH src );

	public void set( IBusModelProtScope src );

	public void setSchemaRef( IBusModelProtSchemaRef src );

	public void set( IBusModelProtScopeH src );

	public void setSchemaRef( IBusModelProtSchemaRefH src );

	public void set( IBusModelPubScope src );

	public void setSchemaRef( IBusModelPubSchemaRef src );

	public void set( IBusModelPubScopeH src );

	public void setSchemaRef( IBusModelPubSchemaRefH src );

	public String getXmlAttrFragment();

	public String toString();
}
