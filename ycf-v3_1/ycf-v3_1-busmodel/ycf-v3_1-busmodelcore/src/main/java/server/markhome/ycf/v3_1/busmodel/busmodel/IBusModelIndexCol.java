// Description: Java 25 interface for a IndexCol record declementation

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
 *	IBusModelIndexCol persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelIndexCol
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_INDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INDEXID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_INDEXID_INIT_VALUE );
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_DEFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 DEFSCHEMAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_DEFSCHEMAID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String S_COLUMNID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 COLUMNID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_COLUMNID_INIT_VALUE );
	public final static boolean ISASCENDING_INIT_VALUE = true;
	public static final String S_PREVID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 PREVID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_PREVID_INIT_VALUE );
	public static final String S_NEXTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 NEXTID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_NEXTID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa826;
	public final static String S_CLASS_CODE = "a826";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public $implCommaIJavaOptAtomType$ getPKey();
	public void setPKey($implCommaIJavaOptAtomType$ requiredId);
	public List<IBusModelRelationCol> getOptionalChildrenRefRelFromCol();

	public List<IBusModelRelationCol> getOptionalChildrenRefRelToCol();

	public IYCFKeyHash256 getRequiredId();
	public void setRequiredId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public IBusModelIndex getRequiredContainerIndex();

	public void setRequiredContainerIndex(IYCFKeyHash256 argIndexId);

	public void setRequiredContainerIndex(IBusModelIndex argObj);

	public void setRequiredContainerIndex(IBusModelProtIndex argObj);

	public void setRequiredContainerIndex(IBusModelPubIndex argObj);

	public IBusModelSchemaDef getOptionalLookupDefSchema();

	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId);

	public void setOptionalLookupDefSchema(IBusModelSchemaDef argObj);

	public void setOptionalLookupDefSchema(IBusModelProtSchemaDef argObj);

	public void setOptionalLookupDefSchema(IBusModelPubSchemaDef argObj);

	public IBusModelIndexCol getOptionalLookupPrev();

	public void setOptionalLookupPrev(IYCFKeyHash256 argPrevId);

	public void setOptionalLookupPrev(IBusModelIndexCol argObj);

	public void setOptionalLookupPrev(IBusModelProtIndexCol argObj);

	public void setOptionalLookupPrev(IBusModelPubIndexCol argObj);

	public IBusModelIndexCol getOptionalLookupNext();

	public void setOptionalLookupNext(IYCFKeyHash256 argNextId);

	public void setOptionalLookupNext(IBusModelIndexCol argObj);

	public void setOptionalLookupNext(IBusModelProtIndexCol argObj);

	public void setOptionalLookupNext(IBusModelPubIndexCol argObj);

	public IBusModelValue getRequiredLookupColumn();

	public void setRequiredLookupColumn(IYCFKeyHash256 argColumnId);

	public void setRequiredLookupColumn(IBusModelValue argObj);

	public void setRequiredLookupColumn(IBusModelProtValue argObj);

	public void setRequiredLookupColumn(IBusModelPubValue argObj);

	public IYCFKeyHash256 getRequiredIndexId();
	public void setRequiredIndexId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalShortName();
	public void setOptionalShortName( String value );
	public String getOptionalLabel();
	public void setOptionalLabel( String value );
	public String getOptionalShortDescription();
	public void setOptionalShortDescription( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public IYCFKeyHash256 getRequiredColumnId();
	public void setRequiredColumnId( IYCFKeyHash256 value );
	public boolean getRequiredIsAscending();
	public void setRequiredIsAscending( boolean value );
	public IYCFKeyHash256 getOptionalPrevId();
	public void setOptionalPrevId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getOptionalNextId();
	public void setOptionalNextId( IYCFKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelIndexCol src );

	public void setIndexCol( IBusModelIndexCol src );

	public void set( IBusModelIndexColH src );

	public void setIndexCol( IBusModelIndexColH src );

	public void set( IBusModelProtIndexCol src );

	public void setIndexCol( IBusModelProtIndexCol src );

	public void set( IBusModelProtIndexColH src );

	public void setIndexCol( IBusModelProtIndexColH src );

	public void set( IBusModelPubIndexCol src );

	public void setIndexCol( IBusModelPubIndexCol src );

	public void set( IBusModelPubIndexColH src );

	public void setIndexCol( IBusModelPubIndexColH src );

	public String getXmlAttrFragment();

	public String toString();
}
