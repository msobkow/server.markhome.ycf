// Description: Java 25 public interface for a Table record implementation

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
 *	IBusModelPubTable persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubTable
	extends IBusModelPubScope
{
	public static final IBusModelPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MIN_VALUE = IBusModelPubSchema.LoaderBehaviourEnum.Insert;
	public static final IBusModelPubSchema.SecScopeEnum SECSCOPE_MIN_VALUE = IBusModelPubSchema.SecScopeEnum.None;
	public static final IBusModelPubSchema.CodeVisibilityEnum CODEVIS_MIN_VALUE = IBusModelPubSchema.CodeVisibilityEnum.Public;
	public static final IBusModelPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MAX_VALUE = IBusModelPubSchema.LoaderBehaviourEnum.Replace;
	public static final IBusModelPubSchema.SecScopeEnum SECSCOPE_MAX_VALUE = IBusModelPubSchema.SecScopeEnum.TenantGroup;
	public static final IBusModelPubSchema.CodeVisibilityEnum CODEVIS_MAX_VALUE = IBusModelPubSchema.CodeVisibilityEnum.Private;
	public static final String S_SCHEMADEFID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SCHEMADEFID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SCHEMADEFID_INIT_VALUE );
	public static final String S_DEFSCHEMAID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 DEFSCHEMAID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_DEFSCHEMAID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public final static boolean PAGEDATA_INIT_VALUE = false;
	public static final String S_PRIMARYINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 PRIMARYINDEXID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_PRIMARYINDEXID_INIT_VALUE );
	public static final String TABLECLASSCODE_INIT_VALUE = new String( "" );
	public static final String S_LOOKUPINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 LOOKUPINDEXID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_LOOKUPINDEXID_INIT_VALUE );
	public static final String S_ALTINDEXID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ALTINDEXID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ALTINDEXID_INIT_VALUE );
	public static final String S_QUALIFYINGTABLEID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 QUALIFYINGTABLEID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_QUALIFYINGTABLEID_INIT_VALUE );
	public final static boolean ISINSTANTIABLE_INIT_VALUE = true;
	public final static boolean HASHISTORY_INIT_VALUE = false;
	public final static boolean HASAUDITCOLUMNS_INIT_VALUE = false;
	public final static boolean ISMUTABLE_INIT_VALUE = false;
	public final static boolean ISSERVERONLY_INIT_VALUE = false;
	public static final IBusModelPubSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_INIT_VALUE = IBusModelPubSchema.ordinalToLoaderBehaviourEnum( 0 );
	public static final IBusModelPubSchema.SecScopeEnum SECSCOPE_INIT_VALUE = IBusModelPubSchema.ordinalToSecScopeEnum( 0 );
	public static final IBusModelPubSchema.CodeVisibilityEnum CODEVIS_INIT_VALUE = IBusModelPubSchema.ordinalToCodeVisibilityEnum( 0 );
	public final static int CLASS_CODE = 0xa807;
	public final static String S_CLASS_CODE = "a807";

	public IBusModelPubSchemaDef getRequiredContainerSchemaDef();

	public void setRequiredContainerSchemaDef(IBusModelPubSchemaDef argObj);
	public void setRequiredContainerSchemaDef(IYCFKeyHash256 argSchemaDefId);

	public IBusModelPubSchemaDef getOptionalLookupDefSchema();

	public void setOptionalLookupDefSchema(IBusModelPubSchemaDef argObj);
	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId);

	public IBusModelPubIndex getOptionalLookupLookupIndex();

	public void setOptionalLookupLookupIndex(IBusModelPubIndex argObj);
	public void setOptionalLookupLookupIndex(IYCFKeyHash256 argLookupIndexId);

	public IBusModelPubIndex getOptionalLookupAltIndex();

	public void setOptionalLookupAltIndex(IBusModelPubIndex argObj);
	public void setOptionalLookupAltIndex(IYCFKeyHash256 argAltIndexId);

	public IBusModelPubTable getOptionalLookupQualTable();

	public void setOptionalLookupQualTable(IBusModelPubTable argObj);
	public void setOptionalLookupQualTable(IYCFKeyHash256 argQualifyingTableId);

	public IBusModelPubIndex getOptionalLookupPrimaryIndex();

	public void setOptionalLookupPrimaryIndex(IBusModelPubIndex argObj);
	public void setOptionalLookupPrimaryIndex(IYCFKeyHash256 argPrimaryIndexId);

	public List<IBusModelPubRelation> getOptionalComponentsRelation();

	public List<IBusModelPubIndex> getOptionalComponentsIndex();

	public List<IBusModelPubValue> getOptionalComponentsColumns();

	public List<IBusModelPubRelation> getOptionalChildrenReverseRelations();

	public List<IBusModelPubChain> getOptionalComponentsChains();

	public List<IBusModelPubDelTopDep> getOptionalComponentsDelDep();

	public List<IBusModelPubClearTopDep> getOptionalComponentsClearDep();

	public List<IBusModelPubServerMethod> getOptionalComponentsServerMethods();

	public List<IBusModelPubTweak> getOptionalComponentsTweaks();

	public YCFDbKeyHash256 getRequiredSchemaDefId();
	public void setRequiredSchemaDefId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( YCFDbKeyHash256 value );
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
	public YCFDbKeyHash256 getOptionalPrimaryIndexId();
	public void setOptionalPrimaryIndexId( YCFDbKeyHash256 value );
	public String getRequiredTableClassCode();
	public void setRequiredTableClassCode( String value );
	public YCFDbKeyHash256 getOptionalLookupIndexId();
	public void setOptionalLookupIndexId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalAltIndexId();
	public void setOptionalAltIndexId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getOptionalQualifyingTableId();
	public void setOptionalQualifyingTableId( YCFDbKeyHash256 value );
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
	public IBusModelPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();
	public void setRequiredLoaderBehaviour( IBusModelPubSchema.LoaderBehaviourEnum value );
	public IBusModelPubSchema.SecScopeEnum getRequiredSecScope();
	public void setRequiredSecScope( IBusModelPubSchema.SecScopeEnum value );
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis();
	public void setRequiredCodeVis( IBusModelPubSchema.CodeVisibilityEnum value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IBusModelPubScope src );

	public void setTable( IBusModelPubTable src );

	public void set( IBusModelPubScopeH src );

	public void setTable( IBusModelPubTableH src );

	public String getXmlAttrFragment();

	public String toString();
}
