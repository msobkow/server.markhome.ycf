// Description: Java 25 public interface for a EnumTag record implementation

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
//import server.markhome.mcf.v3_1.cfbam.cfbampub.*;

/**
 *	ICFBamPubEnumTag persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamPubEnumTag
{
	public static final short ENUMCODE_MIN_VALUE = (short)0;
	public static final short ENUMCODE_MAX_VALUE = (short)32767;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 INIT_CREATED_BY = MCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 INIT_UPDATED_BY = MCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 ID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_DEFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 DEFSCHEMAID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_DEFSCHEMAID_INIT_VALUE );
	public static final String S_ENUMID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 ENUMID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_ENUMID_INIT_VALUE );
	public static final short ENUMCODE_INIT_VALUE = (short)0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String S_PREVID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 PREVID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_PREVID_INIT_VALUE );
	public static final String S_NEXTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 NEXTID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_NEXTID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa822;
	public final static String S_CLASS_CODE = "a822";

	public int getClassCode();

	public MCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( MCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public MCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( MCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public IMCFKeyHash256 getPKey();
	public void setPKey(IMCFKeyHash256 requiredId);
	public MCFDbKeyHash256 getRequiredId();
	public void setRequiredId( MCFDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFBamPubEnumDef getRequiredContainerEnumDef();

	public void setRequiredContainerEnumDef(ICFBamPubEnumDef argObj);
	public void setRequiredContainerEnumDef(IMCFKeyHash256 argEnumId);

	public ICFBamPubSchemaDef getOptionalLookupDefSchema();

	public void setOptionalLookupDefSchema(ICFBamPubSchemaDef argObj);
	public void setOptionalLookupDefSchema(IMCFKeyHash256 argDefSchemaId);

	public ICFBamPubEnumTag getOptionalLookupPrev();

	public void setOptionalLookupPrev(ICFBamPubEnumTag argObj);
	public void setOptionalLookupPrev(IMCFKeyHash256 argPrevId);

	public ICFBamPubEnumTag getOptionalLookupNext();

	public void setOptionalLookupNext(ICFBamPubEnumTag argObj);
	public void setOptionalLookupNext(IMCFKeyHash256 argNextId);

	public MCFDbKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getRequiredEnumId();
	public void setRequiredEnumId( MCFDbKeyHash256 value );
	public Short getOptionalEnumCode();
	public void setOptionalEnumCode( Short value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public MCFDbKeyHash256 getOptionalPrevId();
	public void setOptionalPrevId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getOptionalNextId();
	public void setOptionalNextId( MCFDbKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ICFBamPubEnumTag src );

	public void setEnumTag( ICFBamPubEnumTag src );

	public void set( ICFBamPubEnumTagH src );

	public void setEnumTag( ICFBamPubEnumTagH src );

	public String getXmlAttrFragment();

	public String toString();
}
