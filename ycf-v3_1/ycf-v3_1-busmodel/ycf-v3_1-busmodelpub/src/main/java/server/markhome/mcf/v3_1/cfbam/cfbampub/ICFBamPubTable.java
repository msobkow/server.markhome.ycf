// Description: Java 25 public interface for a Table record implementation

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
 *	ICFBamPubTable persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamPubTable
	extends ICFBamPubScope
{
	public static final ICFBamPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MIN_VALUE = ICFBamPubSchema.LoaderBehaviourEnum.Insert;
	public static final ICFBamPubSchema.SecScopeEnum SECSCOPE_MIN_VALUE = ICFBamPubSchema.SecScopeEnum.None;
	public static final ICFBamPubSchema.CodeVisibilityEnum CODEVIS_MIN_VALUE = ICFBamPubSchema.CodeVisibilityEnum.Public;
	public static final ICFBamPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MAX_VALUE = ICFBamPubSchema.LoaderBehaviourEnum.Replace;
	public static final ICFBamPubSchema.SecScopeEnum SECSCOPE_MAX_VALUE = ICFBamPubSchema.SecScopeEnum.TenantGroup;
	public static final ICFBamPubSchema.CodeVisibilityEnum CODEVIS_MAX_VALUE = ICFBamPubSchema.CodeVisibilityEnum.Private;
	public static final String S_SCHEMADEFID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 SCHEMADEFID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_SCHEMADEFID_INIT_VALUE );
	public static final String S_DEFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 DEFSCHEMAID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_DEFSCHEMAID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public final static boolean PAGEDATA_INIT_VALUE = false;
	public static final String S_PRIMARYINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 PRIMARYINDEXID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_PRIMARYINDEXID_INIT_VALUE );
	public static final String TABLECLASSCODE_INIT_VALUE = new String( "" );
	public static final String S_LOOKUPINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 LOOKUPINDEXID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_LOOKUPINDEXID_INIT_VALUE );
	public static final String S_ALTINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 ALTINDEXID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_ALTINDEXID_INIT_VALUE );
	public static final String S_QUALIFYINGTABLEID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 QUALIFYINGTABLEID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_QUALIFYINGTABLEID_INIT_VALUE );
	public final static boolean ISINSTANTIABLE_INIT_VALUE = true;
	public final static boolean HASHISTORY_INIT_VALUE = false;
	public final static boolean HASAUDITCOLUMNS_INIT_VALUE = false;
	public final static boolean ISMUTABLE_INIT_VALUE = false;
	public final static boolean ISSERVERONLY_INIT_VALUE = false;
	public static final ICFBamPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_INIT_VALUE = ICFBamPubSchema.ordinalToLoaderBehaviourEnum( 0 );
	public static final ICFBamPubSchema.SecScopeEnum SECSCOPE_INIT_VALUE = ICFBamPubSchema.ordinalToSecScopeEnum( 0 );
	public static final ICFBamPubSchema.CodeVisibilityEnum CODEVIS_INIT_VALUE = ICFBamPubSchema.ordinalToCodeVisibilityEnum( 0 );
	public final static int CLASS_CODE = 0xa807;
	public final static String S_CLASS_CODE = "a807";

	public ICFBamPubSchemaDef getRequiredContainerSchemaDef();

	public void setRequiredContainerSchemaDef(ICFBamPubSchemaDef argObj);
	public void setRequiredContainerSchemaDef(IMCFKeyHash256 argSchemaDefId);

	public ICFBamPubSchemaDef getOptionalLookupDefSchema();

	public void setOptionalLookupDefSchema(ICFBamPubSchemaDef argObj);
	public void setOptionalLookupDefSchema(IMCFKeyHash256 argDefSchemaId);

	public ICFBamPubIndex getOptionalLookupLookupIndex();

	public void setOptionalLookupLookupIndex(ICFBamPubIndex argObj);
	public void setOptionalLookupLookupIndex(IMCFKeyHash256 argLookupIndexId);

	public ICFBamPubIndex getOptionalLookupAltIndex();

	public void setOptionalLookupAltIndex(ICFBamPubIndex argObj);
	public void setOptionalLookupAltIndex(IMCFKeyHash256 argAltIndexId);

	public ICFBamPubTable getOptionalLookupQualTable();

	public void setOptionalLookupQualTable(ICFBamPubTable argObj);
	public void setOptionalLookupQualTable(IMCFKeyHash256 argQualifyingTableId);

	public ICFBamPubIndex getOptionalLookupPrimaryIndex();

	public void setOptionalLookupPrimaryIndex(ICFBamPubIndex argObj);
	public void setOptionalLookupPrimaryIndex(IMCFKeyHash256 argPrimaryIndexId);

	public List<ICFBamPubRelation> getOptionalComponentsRelation();

	public List<ICFBamPubIndex> getOptionalComponentsIndex();

	public List<ICFBamPubValue> getOptionalComponentsColumns();

	public List<ICFBamPubRelation> getOptionalChildrenReverseRelations();

	public List<ICFBamPubChain> getOptionalComponentsChains();

	public List<ICFBamPubDelTopDep> getOptionalComponentsDelDep();

	public List<ICFBamPubClearTopDep> getOptionalComponentsClearDep();

	public List<ICFBamPubServerMethod> getOptionalComponentsServerMethods();

	public List<ICFBamPubTweak> getOptionalComponentsTweaks();

	public MCFDbKeyHash256 getRequiredSchemaDefId();
	public void setRequiredSchemaDefId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( MCFDbKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDbName();
	public void setOptionalDbName( String value );
	public String getOptionalShortName();
	public void setOptionalShortName( String value );
	public String getOptionalLabel();
	public void setOptionalLabel( String value );
	public String getOptionalShortDescription();
	public void setOptionalShortDescription( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public boolean getRequiredPageData();
	public void setRequiredPageData( boolean value );
	public MCFDbKeyHash256 getOptionalPrimaryIndexId();
	public void setOptionalPrimaryIndexId( MCFDbKeyHash256 value );
	public String getRequiredTableClassCode();
	public void setRequiredTableClassCode( String value );
	public MCFDbKeyHash256 getOptionalLookupIndexId();
	public void setOptionalLookupIndexId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getOptionalAltIndexId();
	public void setOptionalAltIndexId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getOptionalQualifyingTableId();
	public void setOptionalQualifyingTableId( MCFDbKeyHash256 value );
	public boolean getRequiredIsInstantiable();
	public void setRequiredIsInstantiable( boolean value );
	public boolean getRequiredHasHistory();
	public void setRequiredHasHistory( boolean value );
	public boolean getRequiredHasAuditColumns();
	public void setRequiredHasAuditColumns( boolean value );
	public boolean getRequiredIsMutable();
	public void setRequiredIsMutable( boolean value );
	public boolean getRequiredIsServerOnly();
	public void setRequiredIsServerOnly( boolean value );
	public ICFBamPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();
	public void setRequiredLoaderBehaviour( ICFBamPubSchema.LoaderBehaviourEnum value );
	public ICFBamPubSchema.SecScopeEnum getRequiredSecScope();
	public void setRequiredSecScope( ICFBamPubSchema.SecScopeEnum value );
	public ICFBamPubSchema.CodeVisibilityEnum getRequiredCodeVis();
	public void setRequiredCodeVis( ICFBamPubSchema.CodeVisibilityEnum value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ICFBamPubScope src );

	public void setTable( ICFBamPubTable src );

	public void set( ICFBamPubScopeH src );

	public void setTable( ICFBamPubTableH src );

	public String getXmlAttrFragment();

	public String toString();
}
