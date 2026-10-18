// Description: Java 25 public interface for a RelationCol record implementation

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

package server.markhome.ycf.v3_1.busmodel.busmodelpub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
//import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;

/**
 *	IBusModelPubRelationCol persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubRelationCol
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_RELATIONID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 RELATIONID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_RELATIONID_INIT_VALUE );
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_DEFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 DEFSCHEMAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_DEFSCHEMAID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String S_FROMCOLID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 FROMCOLID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_FROMCOLID_INIT_VALUE );
	public static final String S_TOCOLID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TOCOLID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TOCOLID_INIT_VALUE );
	public static final String S_PREVID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 PREVID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_PREVID_INIT_VALUE );
	public static final String S_NEXTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 NEXTID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_NEXTID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa83a;
	public final static String S_CLASS_CODE = "a83a";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public IYCFKeyHash256 getPKey();
	public void setPKey(IYCFKeyHash256 requiredId);
	public YCFDbKeyHash256 getRequiredId();
	public void setRequiredId( YCFDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public IBusModelPubRelation getRequiredContainerRelation();

	public void setRequiredContainerRelation(IBusModelPubRelation argObj);
	public void setRequiredContainerRelation(IYCFKeyHash256 argRelationId);

	public IBusModelPubSchemaDef getOptionalLookupDefSchema();

	public void setOptionalLookupDefSchema(IBusModelPubSchemaDef argObj);
	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId);

	public IBusModelPubRelationCol getOptionalLookupPrev();

	public void setOptionalLookupPrev(IBusModelPubRelationCol argObj);
	public void setOptionalLookupPrev(IYCFKeyHash256 argPrevId);

	public IBusModelPubRelationCol getOptionalLookupNext();

	public void setOptionalLookupNext(IBusModelPubRelationCol argObj);
	public void setOptionalLookupNext(IYCFKeyHash256 argNextId);

	public IBusModelPubIndexCol getRequiredLookupFromCol();

	public void setRequiredLookupFromCol(IBusModelPubIndexCol argObj);
	public void setRequiredLookupFromCol(IYCFKeyHash256 argFromColId);

	public IBusModelPubIndexCol getRequiredLookupToCol();

	public void setRequiredLookupToCol(IBusModelPubIndexCol argObj);
	public void setRequiredLookupToCol(IYCFKeyHash256 argToColId);

	public YCFDbKeyHash256 getRequiredRelationId();
	public void setRequiredRelationId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( YCFDbKeyHash256 value );
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
	public YCFDbKeyHash256 getRequiredFromColId();
	public void setRequiredFromColId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getRequiredToColId();
	public void setRequiredToColId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalPrevId();
	public void setOptionalPrevId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalNextId();
	public void setOptionalNextId( YCFDbKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelPubRelationCol src );

	public void setRelationCol( IBusModelPubRelationCol src );

	public void set( IBusModelPubRelationColH src );

	public void setRelationCol( IBusModelPubRelationColH src );

	public String getXmlAttrFragment();

	public String toString();
}
