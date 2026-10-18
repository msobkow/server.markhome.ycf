// Description: Java 25 XML SAX Parser for BusModel.

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

package server.markhome.ycf.v3_1.busmodel.busmodelsaxloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.*;
import java.math.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.xml.sax.*;

import server.markhome.ycf.*;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

public class BusModelSaxLoader
	extends YCFLibXmlCoreSaxParser
	implements ContentHandler
{

	// The namespace URI of the supported schema
	public final static String	SCHEMA_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/busmodel-structured.xsd";

	// The source for loading the supported schema
	public final static String	SCHEMA_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/busmodel-structured.xsd";
	public final static String	SCHEMA_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/busmodel-structured.xsd";
	public final static String SECURE_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";
	public final static String SECURE_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";
	public final static String SECURE_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";

	public final static String INTNET_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";
	public final static String INTNET_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";
	public final static String INTNET_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";


	// The schema instance to load in to

	private IBusModelSchemaObj schemaObj = null;

	// The cluster to use for loading

	private ISecureClusterObj useCluster = null;

	public ISecureClusterObj getUseCluster() {
		return( useCluster );
	}

	public void setUseCluster( ISecureClusterObj value ) {
		useCluster = value;
	}

	// The tenant to use for loading

	private ISecureTenantObj useTenant = null;

	public ISecureTenantObj getUseTenant() {
		return( useTenant );
	}

	public void setUseTenant( ISecureTenantObj value ) {
		useTenant = value;
	}

	// Loader behaviour configuration attributes

	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};
	private LoaderBehaviourEnum atomLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum blobColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum blobDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum blobTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum chainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum dateColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dateDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dateTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash128ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash128DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash128GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash128TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash160ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash160DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash160GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash160TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash224ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash224DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash224GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash224TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash256ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash256DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash256GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash256TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash384ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash384DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash384GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash384TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash512ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash512DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash512GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dbKeyHash512TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumTagLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCcyLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCtryLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCtryCcyLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOCtryLangLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOLangLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOTZoneLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id16GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id32GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id64GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum indexLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum indexColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum indexTweakLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum licenseLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum majorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum mimeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum minorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum paramLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum relationLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum relationColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum roleDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum schemaDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum schemaRefLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum schemaRoleLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum schemaTweakLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum scopeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum secClusGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSessionLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpIncLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleEnablesLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserEMConfLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPWHistoryLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPWResetLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPasswordLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum serverListFuncLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverMethodLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverObjFuncLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverProcLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum stringColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum stringDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum stringTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum subProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum sysClusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tZDateColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZDateDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZDateTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableInfoLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableTweakLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tenantLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum textColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum textDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum textTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tldLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topDomainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tweakLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uRLProtocolLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuid6ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuid6DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuid6GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuid6TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidGenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum valueLoaderBehaviour = LoaderBehaviourEnum.Update;


	// Constructors

	public BusModelSaxLoader() {
		super();
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	public BusModelSaxLoader( IYCFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	// Element Handler instances

	private BusModelSaxLoaderAtom atomHandler = null;
	private BusModelSaxLoaderBlobCol blobColHandler = null;
	private BusModelSaxLoaderBlobDef blobDefHandler = null;
	private BusModelSaxLoaderBlobType blobTypeHandler = null;
	private BusModelSaxLoaderBoolCol boolColHandler = null;
	private BusModelSaxLoaderBoolDef boolDefHandler = null;
	private BusModelSaxLoaderBoolType boolTypeHandler = null;
	private BusModelSaxLoaderChain chainHandler = null;
	private BusModelSaxLoaderClearDep clearDepHandler = null;
	private BusModelSaxLoaderClearSubDep1 clearSubDep1Handler = null;
	private BusModelSaxLoaderClearSubDep2 clearSubDep2Handler = null;
	private BusModelSaxLoaderClearSubDep3 clearSubDep3Handler = null;
	private BusModelSaxLoaderClearTopDep clearTopDepHandler = null;
	private BusModelSaxLoaderCluster clusterHandler = null;
	private BusModelSaxLoaderDateCol dateColHandler = null;
	private BusModelSaxLoaderDateDef dateDefHandler = null;
	private BusModelSaxLoaderDateType dateTypeHandler = null;
	private BusModelSaxLoaderDbKeyHash128Col dbKeyHash128ColHandler = null;
	private BusModelSaxLoaderDbKeyHash128Def dbKeyHash128DefHandler = null;
	private BusModelSaxLoaderDbKeyHash128Gen dbKeyHash128GenHandler = null;
	private BusModelSaxLoaderDbKeyHash128Type dbKeyHash128TypeHandler = null;
	private BusModelSaxLoaderDbKeyHash160Col dbKeyHash160ColHandler = null;
	private BusModelSaxLoaderDbKeyHash160Def dbKeyHash160DefHandler = null;
	private BusModelSaxLoaderDbKeyHash160Gen dbKeyHash160GenHandler = null;
	private BusModelSaxLoaderDbKeyHash160Type dbKeyHash160TypeHandler = null;
	private BusModelSaxLoaderDbKeyHash224Col dbKeyHash224ColHandler = null;
	private BusModelSaxLoaderDbKeyHash224Def dbKeyHash224DefHandler = null;
	private BusModelSaxLoaderDbKeyHash224Gen dbKeyHash224GenHandler = null;
	private BusModelSaxLoaderDbKeyHash224Type dbKeyHash224TypeHandler = null;
	private BusModelSaxLoaderDbKeyHash256Col dbKeyHash256ColHandler = null;
	private BusModelSaxLoaderDbKeyHash256Def dbKeyHash256DefHandler = null;
	private BusModelSaxLoaderDbKeyHash256Gen dbKeyHash256GenHandler = null;
	private BusModelSaxLoaderDbKeyHash256Type dbKeyHash256TypeHandler = null;
	private BusModelSaxLoaderDbKeyHash384Col dbKeyHash384ColHandler = null;
	private BusModelSaxLoaderDbKeyHash384Def dbKeyHash384DefHandler = null;
	private BusModelSaxLoaderDbKeyHash384Gen dbKeyHash384GenHandler = null;
	private BusModelSaxLoaderDbKeyHash384Type dbKeyHash384TypeHandler = null;
	private BusModelSaxLoaderDbKeyHash512Col dbKeyHash512ColHandler = null;
	private BusModelSaxLoaderDbKeyHash512Def dbKeyHash512DefHandler = null;
	private BusModelSaxLoaderDbKeyHash512Gen dbKeyHash512GenHandler = null;
	private BusModelSaxLoaderDbKeyHash512Type dbKeyHash512TypeHandler = null;
	private BusModelSaxLoaderDelDep delDepHandler = null;
	private BusModelSaxLoaderDelSubDep1 delSubDep1Handler = null;
	private BusModelSaxLoaderDelSubDep2 delSubDep2Handler = null;
	private BusModelSaxLoaderDelSubDep3 delSubDep3Handler = null;
	private BusModelSaxLoaderDelTopDep delTopDepHandler = null;
	private BusModelSaxLoaderDoubleCol doubleColHandler = null;
	private BusModelSaxLoaderDoubleDef doubleDefHandler = null;
	private BusModelSaxLoaderDoubleType doubleTypeHandler = null;
	private BusModelSaxLoaderEnumDef enumDefHandler = null;
	private BusModelSaxLoaderEnumTag enumTagHandler = null;
	private BusModelSaxLoaderEnumType enumTypeHandler = null;
	private BusModelSaxLoaderFloatCol floatColHandler = null;
	private BusModelSaxLoaderFloatDef floatDefHandler = null;
	private BusModelSaxLoaderFloatType floatTypeHandler = null;
	private BusModelSaxLoaderISOCcy iSOCcyHandler = null;
	private BusModelSaxLoaderISOCtry iSOCtryHandler = null;
	private BusModelSaxLoaderISOCtryCcy iSOCtryCcyHandler = null;
	private BusModelSaxLoaderISOCtryLang iSOCtryLangHandler = null;
	private BusModelSaxLoaderISOLang iSOLangHandler = null;
	private BusModelSaxLoaderISOTZone iSOTZoneHandler = null;
	private BusModelSaxLoaderId16Gen id16GenHandler = null;
	private BusModelSaxLoaderId32Gen id32GenHandler = null;
	private BusModelSaxLoaderId64Gen id64GenHandler = null;
	private BusModelSaxLoaderIndex indexHandler = null;
	private BusModelSaxLoaderIndexCol indexColHandler = null;
	private BusModelSaxLoaderIndexTweak indexTweakHandler = null;
	private BusModelSaxLoaderInt16Col int16ColHandler = null;
	private BusModelSaxLoaderInt16Def int16DefHandler = null;
	private BusModelSaxLoaderInt16Type int16TypeHandler = null;
	private BusModelSaxLoaderInt32Col int32ColHandler = null;
	private BusModelSaxLoaderInt32Def int32DefHandler = null;
	private BusModelSaxLoaderInt32Type int32TypeHandler = null;
	private BusModelSaxLoaderInt64Col int64ColHandler = null;
	private BusModelSaxLoaderInt64Def int64DefHandler = null;
	private BusModelSaxLoaderInt64Type int64TypeHandler = null;
	private BusModelSaxLoaderLicense licenseHandler = null;
	private BusModelSaxLoaderMajorVersion majorVersionHandler = null;
	private BusModelSaxLoaderMimeType mimeTypeHandler = null;
	private BusModelSaxLoaderMinorVersion minorVersionHandler = null;
	private BusModelSaxLoaderNmTokenCol nmTokenColHandler = null;
	private BusModelSaxLoaderNmTokenDef nmTokenDefHandler = null;
	private BusModelSaxLoaderNmTokenType nmTokenTypeHandler = null;
	private BusModelSaxLoaderNmTokensCol nmTokensColHandler = null;
	private BusModelSaxLoaderNmTokensDef nmTokensDefHandler = null;
	private BusModelSaxLoaderNmTokensType nmTokensTypeHandler = null;
	private BusModelSaxLoaderNumberCol numberColHandler = null;
	private BusModelSaxLoaderNumberDef numberDefHandler = null;
	private BusModelSaxLoaderNumberType numberTypeHandler = null;
	private BusModelSaxLoaderParam paramHandler = null;
	private BusModelSaxLoaderPopDep popDepHandler = null;
	private BusModelSaxLoaderPopSubDep1 popSubDep1Handler = null;
	private BusModelSaxLoaderPopSubDep2 popSubDep2Handler = null;
	private BusModelSaxLoaderPopSubDep3 popSubDep3Handler = null;
	private BusModelSaxLoaderPopTopDep popTopDepHandler = null;
	private BusModelSaxLoaderRelation relationHandler = null;
	private BusModelSaxLoaderRelationCol relationColHandler = null;
	private BusModelSaxLoaderRoleDef roleDefHandler = null;
	private BusModelSaxLoaderSchemaDef schemaDefHandler = null;
	private BusModelSaxLoaderSchemaRef schemaRefHandler = null;
	private BusModelSaxLoaderSchemaRole schemaRoleHandler = null;
	private BusModelSaxLoaderSchemaTweak schemaTweakHandler = null;
	private BusModelSaxLoaderScope scopeHandler = null;
	private BusModelSaxLoaderSecClusGrp secClusGrpHandler = null;
	private BusModelSaxLoaderSecClusGrpMemb secClusGrpMembHandler = null;
	private BusModelSaxLoaderSecClusRole secClusRoleHandler = null;
	private BusModelSaxLoaderSecClusRoleMemb secClusRoleMembHandler = null;
	private BusModelSaxLoaderSecSession secSessionHandler = null;
	private BusModelSaxLoaderSecSysGrp secSysGrpHandler = null;
	private BusModelSaxLoaderSecSysGrpInc secSysGrpIncHandler = null;
	private BusModelSaxLoaderSecSysGrpMemb secSysGrpMembHandler = null;
	private BusModelSaxLoaderSecSysRole secSysRoleHandler = null;
	private BusModelSaxLoaderSecSysRoleEnables secSysRoleEnablesHandler = null;
	private BusModelSaxLoaderSecSysRoleMemb secSysRoleMembHandler = null;
	private BusModelSaxLoaderSecTentGrp secTentGrpHandler = null;
	private BusModelSaxLoaderSecTentGrpMemb secTentGrpMembHandler = null;
	private BusModelSaxLoaderSecTentRole secTentRoleHandler = null;
	private BusModelSaxLoaderSecTentRoleMemb secTentRoleMembHandler = null;
	private BusModelSaxLoaderSecUser secUserHandler = null;
	private BusModelSaxLoaderSecUserEMConf secUserEMConfHandler = null;
	private BusModelSaxLoaderSecUserPWHistory secUserPWHistoryHandler = null;
	private BusModelSaxLoaderSecUserPWReset secUserPWResetHandler = null;
	private BusModelSaxLoaderSecUserPassword secUserPasswordHandler = null;
	private BusModelSaxLoaderServerListFunc serverListFuncHandler = null;
	private BusModelSaxLoaderServerMethod serverMethodHandler = null;
	private BusModelSaxLoaderServerObjFunc serverObjFuncHandler = null;
	private BusModelSaxLoaderServerProc serverProcHandler = null;
	private BusModelSaxLoaderStringCol stringColHandler = null;
	private BusModelSaxLoaderStringDef stringDefHandler = null;
	private BusModelSaxLoaderStringType stringTypeHandler = null;
	private BusModelSaxLoaderSubProject subProjectHandler = null;
	private BusModelSaxLoaderSysCluster sysClusterHandler = null;
	private BusModelSaxLoaderTZDateCol tZDateColHandler = null;
	private BusModelSaxLoaderTZDateDef tZDateDefHandler = null;
	private BusModelSaxLoaderTZDateType tZDateTypeHandler = null;
	private BusModelSaxLoaderTZTimeCol tZTimeColHandler = null;
	private BusModelSaxLoaderTZTimeDef tZTimeDefHandler = null;
	private BusModelSaxLoaderTZTimeType tZTimeTypeHandler = null;
	private BusModelSaxLoaderTZTimestampCol tZTimestampColHandler = null;
	private BusModelSaxLoaderTZTimestampDef tZTimestampDefHandler = null;
	private BusModelSaxLoaderTZTimestampType tZTimestampTypeHandler = null;
	private BusModelSaxLoaderTable tableHandler = null;
	private BusModelSaxLoaderTableCol tableColHandler = null;
	private BusModelSaxLoaderTableInfo tableInfoHandler = null;
	private BusModelSaxLoaderTableTweak tableTweakHandler = null;
	private BusModelSaxLoaderTenant tenantHandler = null;
	private BusModelSaxLoaderTextCol textColHandler = null;
	private BusModelSaxLoaderTextDef textDefHandler = null;
	private BusModelSaxLoaderTextType textTypeHandler = null;
	private BusModelSaxLoaderTimeCol timeColHandler = null;
	private BusModelSaxLoaderTimeDef timeDefHandler = null;
	private BusModelSaxLoaderTimeType timeTypeHandler = null;
	private BusModelSaxLoaderTimestampCol timestampColHandler = null;
	private BusModelSaxLoaderTimestampDef timestampDefHandler = null;
	private BusModelSaxLoaderTimestampType timestampTypeHandler = null;
	private BusModelSaxLoaderTld tldHandler = null;
	private BusModelSaxLoaderTokenCol tokenColHandler = null;
	private BusModelSaxLoaderTokenDef tokenDefHandler = null;
	private BusModelSaxLoaderTokenType tokenTypeHandler = null;
	private BusModelSaxLoaderTopDomain topDomainHandler = null;
	private BusModelSaxLoaderTopProject topProjectHandler = null;
	private BusModelSaxLoaderTweak tweakHandler = null;
	private BusModelSaxLoaderUInt16Col uInt16ColHandler = null;
	private BusModelSaxLoaderUInt16Def uInt16DefHandler = null;
	private BusModelSaxLoaderUInt16Type uInt16TypeHandler = null;
	private BusModelSaxLoaderUInt32Col uInt32ColHandler = null;
	private BusModelSaxLoaderUInt32Def uInt32DefHandler = null;
	private BusModelSaxLoaderUInt32Type uInt32TypeHandler = null;
	private BusModelSaxLoaderUInt64Col uInt64ColHandler = null;
	private BusModelSaxLoaderUInt64Def uInt64DefHandler = null;
	private BusModelSaxLoaderUInt64Type uInt64TypeHandler = null;
	private BusModelSaxLoaderURLProtocol uRLProtocolHandler = null;
	private BusModelSaxLoaderUuid6Col uuid6ColHandler = null;
	private BusModelSaxLoaderUuid6Def uuid6DefHandler = null;
	private BusModelSaxLoaderUuid6Gen uuid6GenHandler = null;
	private BusModelSaxLoaderUuid6Type uuid6TypeHandler = null;
	private BusModelSaxLoaderUuidCol uuidColHandler = null;
	private BusModelSaxLoaderUuidDef uuidDefHandler = null;
	private BusModelSaxLoaderUuidGen uuidGenHandler = null;
	private BusModelSaxLoaderUuidType uuidTypeHandler = null;
	private BusModelSaxLoaderValue valueHandler = null;
	private BusModelSaxRootHandler saxRootHandler = null;

	private BusModelSaxDocHandler saxDocHandler = null;

	// Schema object accessors

	// SchemaObj accessors

	public IBusModelSchemaObj getSchemaObj() {
		return( schemaObj );
	}

	public void setSchemaObj( IBusModelSchemaObj value ) {
		schemaObj = value;
	}

	// Element Handler Resolver Factories

	protected BusModelSaxLoaderAtom getAtomHandler() {
		if( atomHandler == null ) {
			atomHandler = new BusModelSaxLoaderAtom( this );
		}
		return( atomHandler );
	}
	protected BusModelSaxLoaderBlobCol getBlobColHandler() {
		if( blobColHandler == null ) {
			blobColHandler = new BusModelSaxLoaderBlobCol( this );
		}
		return( blobColHandler );
	}
	protected BusModelSaxLoaderBlobDef getBlobDefHandler() {
		if( blobDefHandler == null ) {
			blobDefHandler = new BusModelSaxLoaderBlobDef( this );
		}
		return( blobDefHandler );
	}
	protected BusModelSaxLoaderBlobType getBlobTypeHandler() {
		if( blobTypeHandler == null ) {
			blobTypeHandler = new BusModelSaxLoaderBlobType( this );
		}
		return( blobTypeHandler );
	}
	protected BusModelSaxLoaderBoolCol getBoolColHandler() {
		if( boolColHandler == null ) {
			boolColHandler = new BusModelSaxLoaderBoolCol( this );
		}
		return( boolColHandler );
	}
	protected BusModelSaxLoaderBoolDef getBoolDefHandler() {
		if( boolDefHandler == null ) {
			boolDefHandler = new BusModelSaxLoaderBoolDef( this );
		}
		return( boolDefHandler );
	}
	protected BusModelSaxLoaderBoolType getBoolTypeHandler() {
		if( boolTypeHandler == null ) {
			boolTypeHandler = new BusModelSaxLoaderBoolType( this );
		}
		return( boolTypeHandler );
	}
	protected BusModelSaxLoaderChain getChainHandler() {
		if( chainHandler == null ) {
			chainHandler = new BusModelSaxLoaderChain( this );
		}
		return( chainHandler );
	}
	protected BusModelSaxLoaderClearDep getClearDepHandler() {
		if( clearDepHandler == null ) {
			clearDepHandler = new BusModelSaxLoaderClearDep( this );
		}
		return( clearDepHandler );
	}
	protected BusModelSaxLoaderClearSubDep1 getClearSubDep1Handler() {
		if( clearSubDep1Handler == null ) {
			clearSubDep1Handler = new BusModelSaxLoaderClearSubDep1( this );
			clearSubDep1Handler.addElementHandler( "ClearSubDep2", getClearSubDep2Handler() );
		}
		return( clearSubDep1Handler );
	}
	protected BusModelSaxLoaderClearSubDep2 getClearSubDep2Handler() {
		if( clearSubDep2Handler == null ) {
			clearSubDep2Handler = new BusModelSaxLoaderClearSubDep2( this );
			clearSubDep2Handler.addElementHandler( "ClearSubDep3", getClearSubDep3Handler() );
		}
		return( clearSubDep2Handler );
	}
	protected BusModelSaxLoaderClearSubDep3 getClearSubDep3Handler() {
		if( clearSubDep3Handler == null ) {
			clearSubDep3Handler = new BusModelSaxLoaderClearSubDep3( this );
		}
		return( clearSubDep3Handler );
	}
	protected BusModelSaxLoaderClearTopDep getClearTopDepHandler() {
		if( clearTopDepHandler == null ) {
			clearTopDepHandler = new BusModelSaxLoaderClearTopDep( this );
			clearTopDepHandler.addElementHandler( "ClearSubDep1", getClearSubDep1Handler() );
		}
		return( clearTopDepHandler );
	}
	protected BusModelSaxLoaderCluster getClusterHandler() {
		if( clusterHandler == null ) {
			clusterHandler = new BusModelSaxLoaderCluster( this );
			clusterHandler.addElementHandler( "Tenant", getTenantHandler() );
		}
		return( clusterHandler );
	}
	protected BusModelSaxLoaderDateCol getDateColHandler() {
		if( dateColHandler == null ) {
			dateColHandler = new BusModelSaxLoaderDateCol( this );
		}
		return( dateColHandler );
	}
	protected BusModelSaxLoaderDateDef getDateDefHandler() {
		if( dateDefHandler == null ) {
			dateDefHandler = new BusModelSaxLoaderDateDef( this );
		}
		return( dateDefHandler );
	}
	protected BusModelSaxLoaderDateType getDateTypeHandler() {
		if( dateTypeHandler == null ) {
			dateTypeHandler = new BusModelSaxLoaderDateType( this );
		}
		return( dateTypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash128Col getDbKeyHash128ColHandler() {
		if( dbKeyHash128ColHandler == null ) {
			dbKeyHash128ColHandler = new BusModelSaxLoaderDbKeyHash128Col( this );
		}
		return( dbKeyHash128ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash128Def getDbKeyHash128DefHandler() {
		if( dbKeyHash128DefHandler == null ) {
			dbKeyHash128DefHandler = new BusModelSaxLoaderDbKeyHash128Def( this );
		}
		return( dbKeyHash128DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash128Gen getDbKeyHash128GenHandler() {
		if( dbKeyHash128GenHandler == null ) {
			dbKeyHash128GenHandler = new BusModelSaxLoaderDbKeyHash128Gen( this );
		}
		return( dbKeyHash128GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash128Type getDbKeyHash128TypeHandler() {
		if( dbKeyHash128TypeHandler == null ) {
			dbKeyHash128TypeHandler = new BusModelSaxLoaderDbKeyHash128Type( this );
		}
		return( dbKeyHash128TypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash160Col getDbKeyHash160ColHandler() {
		if( dbKeyHash160ColHandler == null ) {
			dbKeyHash160ColHandler = new BusModelSaxLoaderDbKeyHash160Col( this );
		}
		return( dbKeyHash160ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash160Def getDbKeyHash160DefHandler() {
		if( dbKeyHash160DefHandler == null ) {
			dbKeyHash160DefHandler = new BusModelSaxLoaderDbKeyHash160Def( this );
		}
		return( dbKeyHash160DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash160Gen getDbKeyHash160GenHandler() {
		if( dbKeyHash160GenHandler == null ) {
			dbKeyHash160GenHandler = new BusModelSaxLoaderDbKeyHash160Gen( this );
		}
		return( dbKeyHash160GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash160Type getDbKeyHash160TypeHandler() {
		if( dbKeyHash160TypeHandler == null ) {
			dbKeyHash160TypeHandler = new BusModelSaxLoaderDbKeyHash160Type( this );
		}
		return( dbKeyHash160TypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash224Col getDbKeyHash224ColHandler() {
		if( dbKeyHash224ColHandler == null ) {
			dbKeyHash224ColHandler = new BusModelSaxLoaderDbKeyHash224Col( this );
		}
		return( dbKeyHash224ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash224Def getDbKeyHash224DefHandler() {
		if( dbKeyHash224DefHandler == null ) {
			dbKeyHash224DefHandler = new BusModelSaxLoaderDbKeyHash224Def( this );
		}
		return( dbKeyHash224DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash224Gen getDbKeyHash224GenHandler() {
		if( dbKeyHash224GenHandler == null ) {
			dbKeyHash224GenHandler = new BusModelSaxLoaderDbKeyHash224Gen( this );
		}
		return( dbKeyHash224GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash224Type getDbKeyHash224TypeHandler() {
		if( dbKeyHash224TypeHandler == null ) {
			dbKeyHash224TypeHandler = new BusModelSaxLoaderDbKeyHash224Type( this );
		}
		return( dbKeyHash224TypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash256Col getDbKeyHash256ColHandler() {
		if( dbKeyHash256ColHandler == null ) {
			dbKeyHash256ColHandler = new BusModelSaxLoaderDbKeyHash256Col( this );
		}
		return( dbKeyHash256ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash256Def getDbKeyHash256DefHandler() {
		if( dbKeyHash256DefHandler == null ) {
			dbKeyHash256DefHandler = new BusModelSaxLoaderDbKeyHash256Def( this );
		}
		return( dbKeyHash256DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash256Gen getDbKeyHash256GenHandler() {
		if( dbKeyHash256GenHandler == null ) {
			dbKeyHash256GenHandler = new BusModelSaxLoaderDbKeyHash256Gen( this );
		}
		return( dbKeyHash256GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash256Type getDbKeyHash256TypeHandler() {
		if( dbKeyHash256TypeHandler == null ) {
			dbKeyHash256TypeHandler = new BusModelSaxLoaderDbKeyHash256Type( this );
		}
		return( dbKeyHash256TypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash384Col getDbKeyHash384ColHandler() {
		if( dbKeyHash384ColHandler == null ) {
			dbKeyHash384ColHandler = new BusModelSaxLoaderDbKeyHash384Col( this );
		}
		return( dbKeyHash384ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash384Def getDbKeyHash384DefHandler() {
		if( dbKeyHash384DefHandler == null ) {
			dbKeyHash384DefHandler = new BusModelSaxLoaderDbKeyHash384Def( this );
		}
		return( dbKeyHash384DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash384Gen getDbKeyHash384GenHandler() {
		if( dbKeyHash384GenHandler == null ) {
			dbKeyHash384GenHandler = new BusModelSaxLoaderDbKeyHash384Gen( this );
		}
		return( dbKeyHash384GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash384Type getDbKeyHash384TypeHandler() {
		if( dbKeyHash384TypeHandler == null ) {
			dbKeyHash384TypeHandler = new BusModelSaxLoaderDbKeyHash384Type( this );
		}
		return( dbKeyHash384TypeHandler );
	}
	protected BusModelSaxLoaderDbKeyHash512Col getDbKeyHash512ColHandler() {
		if( dbKeyHash512ColHandler == null ) {
			dbKeyHash512ColHandler = new BusModelSaxLoaderDbKeyHash512Col( this );
		}
		return( dbKeyHash512ColHandler );
	}
	protected BusModelSaxLoaderDbKeyHash512Def getDbKeyHash512DefHandler() {
		if( dbKeyHash512DefHandler == null ) {
			dbKeyHash512DefHandler = new BusModelSaxLoaderDbKeyHash512Def( this );
		}
		return( dbKeyHash512DefHandler );
	}
	protected BusModelSaxLoaderDbKeyHash512Gen getDbKeyHash512GenHandler() {
		if( dbKeyHash512GenHandler == null ) {
			dbKeyHash512GenHandler = new BusModelSaxLoaderDbKeyHash512Gen( this );
		}
		return( dbKeyHash512GenHandler );
	}
	protected BusModelSaxLoaderDbKeyHash512Type getDbKeyHash512TypeHandler() {
		if( dbKeyHash512TypeHandler == null ) {
			dbKeyHash512TypeHandler = new BusModelSaxLoaderDbKeyHash512Type( this );
		}
		return( dbKeyHash512TypeHandler );
	}
	protected BusModelSaxLoaderDelDep getDelDepHandler() {
		if( delDepHandler == null ) {
			delDepHandler = new BusModelSaxLoaderDelDep( this );
		}
		return( delDepHandler );
	}
	protected BusModelSaxLoaderDelSubDep1 getDelSubDep1Handler() {
		if( delSubDep1Handler == null ) {
			delSubDep1Handler = new BusModelSaxLoaderDelSubDep1( this );
			delSubDep1Handler.addElementHandler( "DelSubDep2", getDelSubDep2Handler() );
		}
		return( delSubDep1Handler );
	}
	protected BusModelSaxLoaderDelSubDep2 getDelSubDep2Handler() {
		if( delSubDep2Handler == null ) {
			delSubDep2Handler = new BusModelSaxLoaderDelSubDep2( this );
			delSubDep2Handler.addElementHandler( "DelSubDep3", getDelSubDep3Handler() );
		}
		return( delSubDep2Handler );
	}
	protected BusModelSaxLoaderDelSubDep3 getDelSubDep3Handler() {
		if( delSubDep3Handler == null ) {
			delSubDep3Handler = new BusModelSaxLoaderDelSubDep3( this );
		}
		return( delSubDep3Handler );
	}
	protected BusModelSaxLoaderDelTopDep getDelTopDepHandler() {
		if( delTopDepHandler == null ) {
			delTopDepHandler = new BusModelSaxLoaderDelTopDep( this );
			delTopDepHandler.addElementHandler( "DelSubDep1", getDelSubDep1Handler() );
		}
		return( delTopDepHandler );
	}
	protected BusModelSaxLoaderDoubleCol getDoubleColHandler() {
		if( doubleColHandler == null ) {
			doubleColHandler = new BusModelSaxLoaderDoubleCol( this );
		}
		return( doubleColHandler );
	}
	protected BusModelSaxLoaderDoubleDef getDoubleDefHandler() {
		if( doubleDefHandler == null ) {
			doubleDefHandler = new BusModelSaxLoaderDoubleDef( this );
		}
		return( doubleDefHandler );
	}
	protected BusModelSaxLoaderDoubleType getDoubleTypeHandler() {
		if( doubleTypeHandler == null ) {
			doubleTypeHandler = new BusModelSaxLoaderDoubleType( this );
		}
		return( doubleTypeHandler );
	}
	protected BusModelSaxLoaderEnumDef getEnumDefHandler() {
		if( enumDefHandler == null ) {
			enumDefHandler = new BusModelSaxLoaderEnumDef( this );
			enumDefHandler.addElementHandler( "EnumTag", getEnumTagHandler() );
		}
		return( enumDefHandler );
	}
	protected BusModelSaxLoaderEnumTag getEnumTagHandler() {
		if( enumTagHandler == null ) {
			enumTagHandler = new BusModelSaxLoaderEnumTag( this );
		}
		return( enumTagHandler );
	}
	protected BusModelSaxLoaderEnumType getEnumTypeHandler() {
		if( enumTypeHandler == null ) {
			enumTypeHandler = new BusModelSaxLoaderEnumType( this );
			enumTypeHandler.addElementHandler( "EnumTag", getEnumTagHandler() );
		}
		return( enumTypeHandler );
	}
	protected BusModelSaxLoaderFloatCol getFloatColHandler() {
		if( floatColHandler == null ) {
			floatColHandler = new BusModelSaxLoaderFloatCol( this );
		}
		return( floatColHandler );
	}
	protected BusModelSaxLoaderFloatDef getFloatDefHandler() {
		if( floatDefHandler == null ) {
			floatDefHandler = new BusModelSaxLoaderFloatDef( this );
		}
		return( floatDefHandler );
	}
	protected BusModelSaxLoaderFloatType getFloatTypeHandler() {
		if( floatTypeHandler == null ) {
			floatTypeHandler = new BusModelSaxLoaderFloatType( this );
		}
		return( floatTypeHandler );
	}
	protected BusModelSaxLoaderISOCcy getISOCcyHandler() {
		if( iSOCcyHandler == null ) {
			iSOCcyHandler = new BusModelSaxLoaderISOCcy( this );
		}
		return( iSOCcyHandler );
	}
	protected BusModelSaxLoaderISOCtry getISOCtryHandler() {
		if( iSOCtryHandler == null ) {
			iSOCtryHandler = new BusModelSaxLoaderISOCtry( this );
			iSOCtryHandler.addElementHandler( "ISOCtryCcy", getISOCtryCcyHandler() );
			iSOCtryHandler.addElementHandler( "ISOCtryLang", getISOCtryLangHandler() );
		}
		return( iSOCtryHandler );
	}
	protected BusModelSaxLoaderISOCtryCcy getISOCtryCcyHandler() {
		if( iSOCtryCcyHandler == null ) {
			iSOCtryCcyHandler = new BusModelSaxLoaderISOCtryCcy( this );
		}
		return( iSOCtryCcyHandler );
	}
	protected BusModelSaxLoaderISOCtryLang getISOCtryLangHandler() {
		if( iSOCtryLangHandler == null ) {
			iSOCtryLangHandler = new BusModelSaxLoaderISOCtryLang( this );
		}
		return( iSOCtryLangHandler );
	}
	protected BusModelSaxLoaderISOLang getISOLangHandler() {
		if( iSOLangHandler == null ) {
			iSOLangHandler = new BusModelSaxLoaderISOLang( this );
		}
		return( iSOLangHandler );
	}
	protected BusModelSaxLoaderISOTZone getISOTZoneHandler() {
		if( iSOTZoneHandler == null ) {
			iSOTZoneHandler = new BusModelSaxLoaderISOTZone( this );
		}
		return( iSOTZoneHandler );
	}
	protected BusModelSaxLoaderId16Gen getId16GenHandler() {
		if( id16GenHandler == null ) {
			id16GenHandler = new BusModelSaxLoaderId16Gen( this );
		}
		return( id16GenHandler );
	}
	protected BusModelSaxLoaderId32Gen getId32GenHandler() {
		if( id32GenHandler == null ) {
			id32GenHandler = new BusModelSaxLoaderId32Gen( this );
		}
		return( id32GenHandler );
	}
	protected BusModelSaxLoaderId64Gen getId64GenHandler() {
		if( id64GenHandler == null ) {
			id64GenHandler = new BusModelSaxLoaderId64Gen( this );
		}
		return( id64GenHandler );
	}
	protected BusModelSaxLoaderIndex getIndexHandler() {
		if( indexHandler == null ) {
			indexHandler = new BusModelSaxLoaderIndex( this );
			indexHandler.addElementHandler( "IndexCol", getIndexColHandler() );
			indexHandler.addElementHandler( "IndexTweak", getIndexTweakHandler() );
		}
		return( indexHandler );
	}
	protected BusModelSaxLoaderIndexCol getIndexColHandler() {
		if( indexColHandler == null ) {
			indexColHandler = new BusModelSaxLoaderIndexCol( this );
		}
		return( indexColHandler );
	}
	protected BusModelSaxLoaderIndexTweak getIndexTweakHandler() {
		if( indexTweakHandler == null ) {
			indexTweakHandler = new BusModelSaxLoaderIndexTweak( this );
		}
		return( indexTweakHandler );
	}
	protected BusModelSaxLoaderInt16Col getInt16ColHandler() {
		if( int16ColHandler == null ) {
			int16ColHandler = new BusModelSaxLoaderInt16Col( this );
		}
		return( int16ColHandler );
	}
	protected BusModelSaxLoaderInt16Def getInt16DefHandler() {
		if( int16DefHandler == null ) {
			int16DefHandler = new BusModelSaxLoaderInt16Def( this );
		}
		return( int16DefHandler );
	}
	protected BusModelSaxLoaderInt16Type getInt16TypeHandler() {
		if( int16TypeHandler == null ) {
			int16TypeHandler = new BusModelSaxLoaderInt16Type( this );
		}
		return( int16TypeHandler );
	}
	protected BusModelSaxLoaderInt32Col getInt32ColHandler() {
		if( int32ColHandler == null ) {
			int32ColHandler = new BusModelSaxLoaderInt32Col( this );
		}
		return( int32ColHandler );
	}
	protected BusModelSaxLoaderInt32Def getInt32DefHandler() {
		if( int32DefHandler == null ) {
			int32DefHandler = new BusModelSaxLoaderInt32Def( this );
		}
		return( int32DefHandler );
	}
	protected BusModelSaxLoaderInt32Type getInt32TypeHandler() {
		if( int32TypeHandler == null ) {
			int32TypeHandler = new BusModelSaxLoaderInt32Type( this );
		}
		return( int32TypeHandler );
	}
	protected BusModelSaxLoaderInt64Col getInt64ColHandler() {
		if( int64ColHandler == null ) {
			int64ColHandler = new BusModelSaxLoaderInt64Col( this );
		}
		return( int64ColHandler );
	}
	protected BusModelSaxLoaderInt64Def getInt64DefHandler() {
		if( int64DefHandler == null ) {
			int64DefHandler = new BusModelSaxLoaderInt64Def( this );
		}
		return( int64DefHandler );
	}
	protected BusModelSaxLoaderInt64Type getInt64TypeHandler() {
		if( int64TypeHandler == null ) {
			int64TypeHandler = new BusModelSaxLoaderInt64Type( this );
		}
		return( int64TypeHandler );
	}
	protected BusModelSaxLoaderLicense getLicenseHandler() {
		if( licenseHandler == null ) {
			licenseHandler = new BusModelSaxLoaderLicense( this );
		}
		return( licenseHandler );
	}
	protected BusModelSaxLoaderMajorVersion getMajorVersionHandler() {
		if( majorVersionHandler == null ) {
			majorVersionHandler = new BusModelSaxLoaderMajorVersion( this );
			majorVersionHandler.addElementHandler( "MinorVersion", getMinorVersionHandler() );
		}
		return( majorVersionHandler );
	}
	protected BusModelSaxLoaderMimeType getMimeTypeHandler() {
		if( mimeTypeHandler == null ) {
			mimeTypeHandler = new BusModelSaxLoaderMimeType( this );
		}
		return( mimeTypeHandler );
	}
	protected BusModelSaxLoaderMinorVersion getMinorVersionHandler() {
		if( minorVersionHandler == null ) {
			minorVersionHandler = new BusModelSaxLoaderMinorVersion( this );
			minorVersionHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
		}
		return( minorVersionHandler );
	}
	protected BusModelSaxLoaderNmTokenCol getNmTokenColHandler() {
		if( nmTokenColHandler == null ) {
			nmTokenColHandler = new BusModelSaxLoaderNmTokenCol( this );
		}
		return( nmTokenColHandler );
	}
	protected BusModelSaxLoaderNmTokenDef getNmTokenDefHandler() {
		if( nmTokenDefHandler == null ) {
			nmTokenDefHandler = new BusModelSaxLoaderNmTokenDef( this );
		}
		return( nmTokenDefHandler );
	}
	protected BusModelSaxLoaderNmTokenType getNmTokenTypeHandler() {
		if( nmTokenTypeHandler == null ) {
			nmTokenTypeHandler = new BusModelSaxLoaderNmTokenType( this );
		}
		return( nmTokenTypeHandler );
	}
	protected BusModelSaxLoaderNmTokensCol getNmTokensColHandler() {
		if( nmTokensColHandler == null ) {
			nmTokensColHandler = new BusModelSaxLoaderNmTokensCol( this );
		}
		return( nmTokensColHandler );
	}
	protected BusModelSaxLoaderNmTokensDef getNmTokensDefHandler() {
		if( nmTokensDefHandler == null ) {
			nmTokensDefHandler = new BusModelSaxLoaderNmTokensDef( this );
		}
		return( nmTokensDefHandler );
	}
	protected BusModelSaxLoaderNmTokensType getNmTokensTypeHandler() {
		if( nmTokensTypeHandler == null ) {
			nmTokensTypeHandler = new BusModelSaxLoaderNmTokensType( this );
		}
		return( nmTokensTypeHandler );
	}
	protected BusModelSaxLoaderNumberCol getNumberColHandler() {
		if( numberColHandler == null ) {
			numberColHandler = new BusModelSaxLoaderNumberCol( this );
		}
		return( numberColHandler );
	}
	protected BusModelSaxLoaderNumberDef getNumberDefHandler() {
		if( numberDefHandler == null ) {
			numberDefHandler = new BusModelSaxLoaderNumberDef( this );
		}
		return( numberDefHandler );
	}
	protected BusModelSaxLoaderNumberType getNumberTypeHandler() {
		if( numberTypeHandler == null ) {
			numberTypeHandler = new BusModelSaxLoaderNumberType( this );
		}
		return( numberTypeHandler );
	}
	protected BusModelSaxLoaderParam getParamHandler() {
		if( paramHandler == null ) {
			paramHandler = new BusModelSaxLoaderParam( this );
		}
		return( paramHandler );
	}
	protected BusModelSaxLoaderPopDep getPopDepHandler() {
		if( popDepHandler == null ) {
			popDepHandler = new BusModelSaxLoaderPopDep( this );
		}
		return( popDepHandler );
	}
	protected BusModelSaxLoaderPopSubDep1 getPopSubDep1Handler() {
		if( popSubDep1Handler == null ) {
			popSubDep1Handler = new BusModelSaxLoaderPopSubDep1( this );
			popSubDep1Handler.addElementHandler( "PopSubDep2", getPopSubDep2Handler() );
		}
		return( popSubDep1Handler );
	}
	protected BusModelSaxLoaderPopSubDep2 getPopSubDep2Handler() {
		if( popSubDep2Handler == null ) {
			popSubDep2Handler = new BusModelSaxLoaderPopSubDep2( this );
			popSubDep2Handler.addElementHandler( "PopSubDep3", getPopSubDep3Handler() );
		}
		return( popSubDep2Handler );
	}
	protected BusModelSaxLoaderPopSubDep3 getPopSubDep3Handler() {
		if( popSubDep3Handler == null ) {
			popSubDep3Handler = new BusModelSaxLoaderPopSubDep3( this );
		}
		return( popSubDep3Handler );
	}
	protected BusModelSaxLoaderPopTopDep getPopTopDepHandler() {
		if( popTopDepHandler == null ) {
			popTopDepHandler = new BusModelSaxLoaderPopTopDep( this );
			popTopDepHandler.addElementHandler( "PopSubDep1", getPopSubDep1Handler() );
		}
		return( popTopDepHandler );
	}
	protected BusModelSaxLoaderRelation getRelationHandler() {
		if( relationHandler == null ) {
			relationHandler = new BusModelSaxLoaderRelation( this );
			relationHandler.addElementHandler( "RelationCol", getRelationColHandler() );
			relationHandler.addElementHandler( "PopTopDep", getPopTopDepHandler() );
		}
		return( relationHandler );
	}
	protected BusModelSaxLoaderRelationCol getRelationColHandler() {
		if( relationColHandler == null ) {
			relationColHandler = new BusModelSaxLoaderRelationCol( this );
		}
		return( relationColHandler );
	}
	protected BusModelSaxLoaderRoleDef getRoleDefHandler() {
		if( roleDefHandler == null ) {
			roleDefHandler = new BusModelSaxLoaderRoleDef( this );
		}
		return( roleDefHandler );
	}
	protected BusModelSaxLoaderSchemaDef getSchemaDefHandler() {
		if( schemaDefHandler == null ) {
			schemaDefHandler = new BusModelSaxLoaderSchemaDef( this );
			schemaDefHandler.addElementHandler( "Table", getTableHandler() );
			schemaDefHandler.addElementHandler( "BlobType", getBlobTypeHandler() );
			schemaDefHandler.addElementHandler( "BoolType", getBoolTypeHandler() );
			schemaDefHandler.addElementHandler( "DateType", getDateTypeHandler() );
			schemaDefHandler.addElementHandler( "DoubleType", getDoubleTypeHandler() );
			schemaDefHandler.addElementHandler( "FloatType", getFloatTypeHandler() );
			schemaDefHandler.addElementHandler( "Int16Type", getInt16TypeHandler() );
			schemaDefHandler.addElementHandler( "Id16Gen", getId16GenHandler() );
			schemaDefHandler.addElementHandler( "EnumType", getEnumTypeHandler() );
			schemaDefHandler.addElementHandler( "Int32Type", getInt32TypeHandler() );
			schemaDefHandler.addElementHandler( "Id32Gen", getId32GenHandler() );
			schemaDefHandler.addElementHandler( "Int64Type", getInt64TypeHandler() );
			schemaDefHandler.addElementHandler( "Id64Gen", getId64GenHandler() );
			schemaDefHandler.addElementHandler( "NmTokenType", getNmTokenTypeHandler() );
			schemaDefHandler.addElementHandler( "NmTokensType", getNmTokensTypeHandler() );
			schemaDefHandler.addElementHandler( "NumberType", getNumberTypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash128Type", getDbKeyHash128TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash128Gen", getDbKeyHash128GenHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash160Type", getDbKeyHash160TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash160Gen", getDbKeyHash160GenHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash224Type", getDbKeyHash224TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash224Gen", getDbKeyHash224GenHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash256Type", getDbKeyHash256TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash256Gen", getDbKeyHash256GenHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash384Type", getDbKeyHash384TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash384Gen", getDbKeyHash384GenHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash512Type", getDbKeyHash512TypeHandler() );
			schemaDefHandler.addElementHandler( "DbKeyHash512Gen", getDbKeyHash512GenHandler() );
			schemaDefHandler.addElementHandler( "StringType", getStringTypeHandler() );
			schemaDefHandler.addElementHandler( "TZDateType", getTZDateTypeHandler() );
			schemaDefHandler.addElementHandler( "TZTimeType", getTZTimeTypeHandler() );
			schemaDefHandler.addElementHandler( "TZTimestampType", getTZTimestampTypeHandler() );
			schemaDefHandler.addElementHandler( "TextType", getTextTypeHandler() );
			schemaDefHandler.addElementHandler( "TimeType", getTimeTypeHandler() );
			schemaDefHandler.addElementHandler( "TimestampType", getTimestampTypeHandler() );
			schemaDefHandler.addElementHandler( "TokenType", getTokenTypeHandler() );
			schemaDefHandler.addElementHandler( "UInt16Type", getUInt16TypeHandler() );
			schemaDefHandler.addElementHandler( "UInt32Type", getUInt32TypeHandler() );
			schemaDefHandler.addElementHandler( "UInt64Type", getUInt64TypeHandler() );
			schemaDefHandler.addElementHandler( "UuidType", getUuidTypeHandler() );
			schemaDefHandler.addElementHandler( "UuidGen", getUuidGenHandler() );
			schemaDefHandler.addElementHandler( "Uuid6Type", getUuid6TypeHandler() );
			schemaDefHandler.addElementHandler( "Uuid6Gen", getUuid6GenHandler() );
			schemaDefHandler.addElementHandler( "SchemaRef", getSchemaRefHandler() );
			schemaDefHandler.addElementHandler( "SchemaTweak", getSchemaTweakHandler() );
			schemaDefHandler.addElementHandler( "SchemaRole", getSchemaRoleHandler() );
		}
		return( schemaDefHandler );
	}
	protected BusModelSaxLoaderSchemaRef getSchemaRefHandler() {
		if( schemaRefHandler == null ) {
			schemaRefHandler = new BusModelSaxLoaderSchemaRef( this );
		}
		return( schemaRefHandler );
	}
	protected BusModelSaxLoaderSchemaRole getSchemaRoleHandler() {
		if( schemaRoleHandler == null ) {
			schemaRoleHandler = new BusModelSaxLoaderSchemaRole( this );
		}
		return( schemaRoleHandler );
	}
	protected BusModelSaxLoaderSchemaTweak getSchemaTweakHandler() {
		if( schemaTweakHandler == null ) {
			schemaTweakHandler = new BusModelSaxLoaderSchemaTweak( this );
		}
		return( schemaTweakHandler );
	}
	protected BusModelSaxLoaderScope getScopeHandler() {
		if( scopeHandler == null ) {
			scopeHandler = new BusModelSaxLoaderScope( this );
		}
		return( scopeHandler );
	}
	protected BusModelSaxLoaderSecClusGrp getSecClusGrpHandler() {
		if( secClusGrpHandler == null ) {
			secClusGrpHandler = new BusModelSaxLoaderSecClusGrp( this );
		}
		return( secClusGrpHandler );
	}
	protected BusModelSaxLoaderSecClusGrpMemb getSecClusGrpMembHandler() {
		if( secClusGrpMembHandler == null ) {
			secClusGrpMembHandler = new BusModelSaxLoaderSecClusGrpMemb( this );
		}
		return( secClusGrpMembHandler );
	}
	protected BusModelSaxLoaderSecClusRole getSecClusRoleHandler() {
		if( secClusRoleHandler == null ) {
			secClusRoleHandler = new BusModelSaxLoaderSecClusRole( this );
		}
		return( secClusRoleHandler );
	}
	protected BusModelSaxLoaderSecClusRoleMemb getSecClusRoleMembHandler() {
		if( secClusRoleMembHandler == null ) {
			secClusRoleMembHandler = new BusModelSaxLoaderSecClusRoleMemb( this );
		}
		return( secClusRoleMembHandler );
	}
	protected BusModelSaxLoaderSecSession getSecSessionHandler() {
		if( secSessionHandler == null ) {
			secSessionHandler = new BusModelSaxLoaderSecSession( this );
		}
		return( secSessionHandler );
	}
	protected BusModelSaxLoaderSecSysGrp getSecSysGrpHandler() {
		if( secSysGrpHandler == null ) {
			secSysGrpHandler = new BusModelSaxLoaderSecSysGrp( this );
			secSysGrpHandler.addElementHandler( "SecSysGrpInc", getSecSysGrpIncHandler() );
			secSysGrpHandler.addElementHandler( "SecClusGrp", getSecClusGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecTentGrp", getSecTentGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecClusRole", getSecClusRoleHandler() );
			secSysGrpHandler.addElementHandler( "SecTentRole", getSecTentRoleHandler() );
		}
		return( secSysGrpHandler );
	}
	protected BusModelSaxLoaderSecSysGrpInc getSecSysGrpIncHandler() {
		if( secSysGrpIncHandler == null ) {
			secSysGrpIncHandler = new BusModelSaxLoaderSecSysGrpInc( this );
		}
		return( secSysGrpIncHandler );
	}
	protected BusModelSaxLoaderSecSysGrpMemb getSecSysGrpMembHandler() {
		if( secSysGrpMembHandler == null ) {
			secSysGrpMembHandler = new BusModelSaxLoaderSecSysGrpMemb( this );
		}
		return( secSysGrpMembHandler );
	}
	protected BusModelSaxLoaderSecSysRole getSecSysRoleHandler() {
		if( secSysRoleHandler == null ) {
			secSysRoleHandler = new BusModelSaxLoaderSecSysRole( this );
			secSysRoleHandler.addElementHandler( "SecSysRoleEnables", getSecSysRoleEnablesHandler() );
		}
		return( secSysRoleHandler );
	}
	protected BusModelSaxLoaderSecSysRoleEnables getSecSysRoleEnablesHandler() {
		if( secSysRoleEnablesHandler == null ) {
			secSysRoleEnablesHandler = new BusModelSaxLoaderSecSysRoleEnables( this );
		}
		return( secSysRoleEnablesHandler );
	}
	protected BusModelSaxLoaderSecSysRoleMemb getSecSysRoleMembHandler() {
		if( secSysRoleMembHandler == null ) {
			secSysRoleMembHandler = new BusModelSaxLoaderSecSysRoleMemb( this );
		}
		return( secSysRoleMembHandler );
	}
	protected BusModelSaxLoaderSecTentGrp getSecTentGrpHandler() {
		if( secTentGrpHandler == null ) {
			secTentGrpHandler = new BusModelSaxLoaderSecTentGrp( this );
		}
		return( secTentGrpHandler );
	}
	protected BusModelSaxLoaderSecTentGrpMemb getSecTentGrpMembHandler() {
		if( secTentGrpMembHandler == null ) {
			secTentGrpMembHandler = new BusModelSaxLoaderSecTentGrpMemb( this );
		}
		return( secTentGrpMembHandler );
	}
	protected BusModelSaxLoaderSecTentRole getSecTentRoleHandler() {
		if( secTentRoleHandler == null ) {
			secTentRoleHandler = new BusModelSaxLoaderSecTentRole( this );
		}
		return( secTentRoleHandler );
	}
	protected BusModelSaxLoaderSecTentRoleMemb getSecTentRoleMembHandler() {
		if( secTentRoleMembHandler == null ) {
			secTentRoleMembHandler = new BusModelSaxLoaderSecTentRoleMemb( this );
		}
		return( secTentRoleMembHandler );
	}
	protected BusModelSaxLoaderSecUser getSecUserHandler() {
		if( secUserHandler == null ) {
			secUserHandler = new BusModelSaxLoaderSecUser( this );
			secUserHandler.addElementHandler( "SecSession", getSecSessionHandler() );
			secUserHandler.addElementHandler( "SecUserPassword", getSecUserPasswordHandler() );
			secUserHandler.addElementHandler( "SecUserEMConf", getSecUserEMConfHandler() );
			secUserHandler.addElementHandler( "SecUserPWReset", getSecUserPWResetHandler() );
		}
		return( secUserHandler );
	}
	protected BusModelSaxLoaderSecUserEMConf getSecUserEMConfHandler() {
		if( secUserEMConfHandler == null ) {
			secUserEMConfHandler = new BusModelSaxLoaderSecUserEMConf( this );
		}
		return( secUserEMConfHandler );
	}
	protected BusModelSaxLoaderSecUserPWHistory getSecUserPWHistoryHandler() {
		if( secUserPWHistoryHandler == null ) {
			secUserPWHistoryHandler = new BusModelSaxLoaderSecUserPWHistory( this );
		}
		return( secUserPWHistoryHandler );
	}
	protected BusModelSaxLoaderSecUserPWReset getSecUserPWResetHandler() {
		if( secUserPWResetHandler == null ) {
			secUserPWResetHandler = new BusModelSaxLoaderSecUserPWReset( this );
		}
		return( secUserPWResetHandler );
	}
	protected BusModelSaxLoaderSecUserPassword getSecUserPasswordHandler() {
		if( secUserPasswordHandler == null ) {
			secUserPasswordHandler = new BusModelSaxLoaderSecUserPassword( this );
		}
		return( secUserPasswordHandler );
	}
	protected BusModelSaxLoaderServerListFunc getServerListFuncHandler() {
		if( serverListFuncHandler == null ) {
			serverListFuncHandler = new BusModelSaxLoaderServerListFunc( this );
			serverListFuncHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverListFuncHandler );
	}
	protected BusModelSaxLoaderServerMethod getServerMethodHandler() {
		if( serverMethodHandler == null ) {
			serverMethodHandler = new BusModelSaxLoaderServerMethod( this );
			serverMethodHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverMethodHandler );
	}
	protected BusModelSaxLoaderServerObjFunc getServerObjFuncHandler() {
		if( serverObjFuncHandler == null ) {
			serverObjFuncHandler = new BusModelSaxLoaderServerObjFunc( this );
			serverObjFuncHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverObjFuncHandler );
	}
	protected BusModelSaxLoaderServerProc getServerProcHandler() {
		if( serverProcHandler == null ) {
			serverProcHandler = new BusModelSaxLoaderServerProc( this );
			serverProcHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverProcHandler );
	}
	protected BusModelSaxLoaderStringCol getStringColHandler() {
		if( stringColHandler == null ) {
			stringColHandler = new BusModelSaxLoaderStringCol( this );
		}
		return( stringColHandler );
	}
	protected BusModelSaxLoaderStringDef getStringDefHandler() {
		if( stringDefHandler == null ) {
			stringDefHandler = new BusModelSaxLoaderStringDef( this );
		}
		return( stringDefHandler );
	}
	protected BusModelSaxLoaderStringType getStringTypeHandler() {
		if( stringTypeHandler == null ) {
			stringTypeHandler = new BusModelSaxLoaderStringType( this );
		}
		return( stringTypeHandler );
	}
	protected BusModelSaxLoaderSubProject getSubProjectHandler() {
		if( subProjectHandler == null ) {
			subProjectHandler = new BusModelSaxLoaderSubProject( this );
			subProjectHandler.addElementHandler( "MajorVersion", getMajorVersionHandler() );
		}
		return( subProjectHandler );
	}
	protected BusModelSaxLoaderSysCluster getSysClusterHandler() {
		if( sysClusterHandler == null ) {
			sysClusterHandler = new BusModelSaxLoaderSysCluster( this );
		}
		return( sysClusterHandler );
	}
	protected BusModelSaxLoaderTZDateCol getTZDateColHandler() {
		if( tZDateColHandler == null ) {
			tZDateColHandler = new BusModelSaxLoaderTZDateCol( this );
		}
		return( tZDateColHandler );
	}
	protected BusModelSaxLoaderTZDateDef getTZDateDefHandler() {
		if( tZDateDefHandler == null ) {
			tZDateDefHandler = new BusModelSaxLoaderTZDateDef( this );
		}
		return( tZDateDefHandler );
	}
	protected BusModelSaxLoaderTZDateType getTZDateTypeHandler() {
		if( tZDateTypeHandler == null ) {
			tZDateTypeHandler = new BusModelSaxLoaderTZDateType( this );
		}
		return( tZDateTypeHandler );
	}
	protected BusModelSaxLoaderTZTimeCol getTZTimeColHandler() {
		if( tZTimeColHandler == null ) {
			tZTimeColHandler = new BusModelSaxLoaderTZTimeCol( this );
		}
		return( tZTimeColHandler );
	}
	protected BusModelSaxLoaderTZTimeDef getTZTimeDefHandler() {
		if( tZTimeDefHandler == null ) {
			tZTimeDefHandler = new BusModelSaxLoaderTZTimeDef( this );
		}
		return( tZTimeDefHandler );
	}
	protected BusModelSaxLoaderTZTimeType getTZTimeTypeHandler() {
		if( tZTimeTypeHandler == null ) {
			tZTimeTypeHandler = new BusModelSaxLoaderTZTimeType( this );
		}
		return( tZTimeTypeHandler );
	}
	protected BusModelSaxLoaderTZTimestampCol getTZTimestampColHandler() {
		if( tZTimestampColHandler == null ) {
			tZTimestampColHandler = new BusModelSaxLoaderTZTimestampCol( this );
		}
		return( tZTimestampColHandler );
	}
	protected BusModelSaxLoaderTZTimestampDef getTZTimestampDefHandler() {
		if( tZTimestampDefHandler == null ) {
			tZTimestampDefHandler = new BusModelSaxLoaderTZTimestampDef( this );
		}
		return( tZTimestampDefHandler );
	}
	protected BusModelSaxLoaderTZTimestampType getTZTimestampTypeHandler() {
		if( tZTimestampTypeHandler == null ) {
			tZTimestampTypeHandler = new BusModelSaxLoaderTZTimestampType( this );
		}
		return( tZTimestampTypeHandler );
	}
	protected BusModelSaxLoaderTable getTableHandler() {
		if( tableHandler == null ) {
			tableHandler = new BusModelSaxLoaderTable( this );
			tableHandler.addElementHandler( "Relation", getRelationHandler() );
			tableHandler.addElementHandler( "Index", getIndexHandler() );
			tableHandler.addElementHandler( "BlobCol", getBlobColHandler() );
			tableHandler.addElementHandler( "BoolCol", getBoolColHandler() );
			tableHandler.addElementHandler( "DateCol", getDateColHandler() );
			tableHandler.addElementHandler( "DoubleCol", getDoubleColHandler() );
			tableHandler.addElementHandler( "FloatCol", getFloatColHandler() );
			tableHandler.addElementHandler( "Int16Col", getInt16ColHandler() );
			tableHandler.addElementHandler( "Int32Col", getInt32ColHandler() );
			tableHandler.addElementHandler( "Int64Col", getInt64ColHandler() );
			tableHandler.addElementHandler( "NmTokenCol", getNmTokenColHandler() );
			tableHandler.addElementHandler( "NmTokensCol", getNmTokensColHandler() );
			tableHandler.addElementHandler( "NumberCol", getNumberColHandler() );
			tableHandler.addElementHandler( "DbKeyHash128Col", getDbKeyHash128ColHandler() );
			tableHandler.addElementHandler( "DbKeyHash160Col", getDbKeyHash160ColHandler() );
			tableHandler.addElementHandler( "DbKeyHash224Col", getDbKeyHash224ColHandler() );
			tableHandler.addElementHandler( "DbKeyHash256Col", getDbKeyHash256ColHandler() );
			tableHandler.addElementHandler( "DbKeyHash384Col", getDbKeyHash384ColHandler() );
			tableHandler.addElementHandler( "DbKeyHash512Col", getDbKeyHash512ColHandler() );
			tableHandler.addElementHandler( "StringCol", getStringColHandler() );
			tableHandler.addElementHandler( "TZDateCol", getTZDateColHandler() );
			tableHandler.addElementHandler( "TZTimeCol", getTZTimeColHandler() );
			tableHandler.addElementHandler( "TZTimestampCol", getTZTimestampColHandler() );
			tableHandler.addElementHandler( "TextCol", getTextColHandler() );
			tableHandler.addElementHandler( "TimeCol", getTimeColHandler() );
			tableHandler.addElementHandler( "TimestampCol", getTimestampColHandler() );
			tableHandler.addElementHandler( "TokenCol", getTokenColHandler() );
			tableHandler.addElementHandler( "UInt16Col", getUInt16ColHandler() );
			tableHandler.addElementHandler( "UInt32Col", getUInt32ColHandler() );
			tableHandler.addElementHandler( "UInt64Col", getUInt64ColHandler() );
			tableHandler.addElementHandler( "UuidCol", getUuidColHandler() );
			tableHandler.addElementHandler( "Uuid6Col", getUuid6ColHandler() );
			tableHandler.addElementHandler( "TableCol", getTableColHandler() );
			tableHandler.addElementHandler( "Chain", getChainHandler() );
			tableHandler.addElementHandler( "DelTopDep", getDelTopDepHandler() );
			tableHandler.addElementHandler( "ClearTopDep", getClearTopDepHandler() );
			tableHandler.addElementHandler( "ServerMethod", getServerMethodHandler() );
			tableHandler.addElementHandler( "ServerObjFunc", getServerObjFuncHandler() );
			tableHandler.addElementHandler( "ServerProc", getServerProcHandler() );
			tableHandler.addElementHandler( "ServerListFunc", getServerListFuncHandler() );
			tableHandler.addElementHandler( "TableTweak", getTableTweakHandler() );
		}
		return( tableHandler );
	}
	protected BusModelSaxLoaderTableCol getTableColHandler() {
		if( tableColHandler == null ) {
			tableColHandler = new BusModelSaxLoaderTableCol( this );
		}
		return( tableColHandler );
	}
	protected BusModelSaxLoaderTableInfo getTableInfoHandler() {
		if( tableInfoHandler == null ) {
			tableInfoHandler = new BusModelSaxLoaderTableInfo( this );
		}
		return( tableInfoHandler );
	}
	protected BusModelSaxLoaderTableTweak getTableTweakHandler() {
		if( tableTweakHandler == null ) {
			tableTweakHandler = new BusModelSaxLoaderTableTweak( this );
		}
		return( tableTweakHandler );
	}
	protected BusModelSaxLoaderTenant getTenantHandler() {
		if( tenantHandler == null ) {
			tenantHandler = new BusModelSaxLoaderTenant( this );
			tenantHandler.addElementHandler( "Tld", getTldHandler() );
		}
		return( tenantHandler );
	}
	protected BusModelSaxLoaderTextCol getTextColHandler() {
		if( textColHandler == null ) {
			textColHandler = new BusModelSaxLoaderTextCol( this );
		}
		return( textColHandler );
	}
	protected BusModelSaxLoaderTextDef getTextDefHandler() {
		if( textDefHandler == null ) {
			textDefHandler = new BusModelSaxLoaderTextDef( this );
		}
		return( textDefHandler );
	}
	protected BusModelSaxLoaderTextType getTextTypeHandler() {
		if( textTypeHandler == null ) {
			textTypeHandler = new BusModelSaxLoaderTextType( this );
		}
		return( textTypeHandler );
	}
	protected BusModelSaxLoaderTimeCol getTimeColHandler() {
		if( timeColHandler == null ) {
			timeColHandler = new BusModelSaxLoaderTimeCol( this );
		}
		return( timeColHandler );
	}
	protected BusModelSaxLoaderTimeDef getTimeDefHandler() {
		if( timeDefHandler == null ) {
			timeDefHandler = new BusModelSaxLoaderTimeDef( this );
		}
		return( timeDefHandler );
	}
	protected BusModelSaxLoaderTimeType getTimeTypeHandler() {
		if( timeTypeHandler == null ) {
			timeTypeHandler = new BusModelSaxLoaderTimeType( this );
		}
		return( timeTypeHandler );
	}
	protected BusModelSaxLoaderTimestampCol getTimestampColHandler() {
		if( timestampColHandler == null ) {
			timestampColHandler = new BusModelSaxLoaderTimestampCol( this );
		}
		return( timestampColHandler );
	}
	protected BusModelSaxLoaderTimestampDef getTimestampDefHandler() {
		if( timestampDefHandler == null ) {
			timestampDefHandler = new BusModelSaxLoaderTimestampDef( this );
		}
		return( timestampDefHandler );
	}
	protected BusModelSaxLoaderTimestampType getTimestampTypeHandler() {
		if( timestampTypeHandler == null ) {
			timestampTypeHandler = new BusModelSaxLoaderTimestampType( this );
		}
		return( timestampTypeHandler );
	}
	protected BusModelSaxLoaderTld getTldHandler() {
		if( tldHandler == null ) {
			tldHandler = new BusModelSaxLoaderTld( this );
			tldHandler.addElementHandler( "TopDomain", getTopDomainHandler() );
		}
		return( tldHandler );
	}
	protected BusModelSaxLoaderTokenCol getTokenColHandler() {
		if( tokenColHandler == null ) {
			tokenColHandler = new BusModelSaxLoaderTokenCol( this );
		}
		return( tokenColHandler );
	}
	protected BusModelSaxLoaderTokenDef getTokenDefHandler() {
		if( tokenDefHandler == null ) {
			tokenDefHandler = new BusModelSaxLoaderTokenDef( this );
		}
		return( tokenDefHandler );
	}
	protected BusModelSaxLoaderTokenType getTokenTypeHandler() {
		if( tokenTypeHandler == null ) {
			tokenTypeHandler = new BusModelSaxLoaderTokenType( this );
		}
		return( tokenTypeHandler );
	}
	protected BusModelSaxLoaderTopDomain getTopDomainHandler() {
		if( topDomainHandler == null ) {
			topDomainHandler = new BusModelSaxLoaderTopDomain( this );
			topDomainHandler.addElementHandler( "TopProject", getTopProjectHandler() );
			topDomainHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( topDomainHandler );
	}
	protected BusModelSaxLoaderTopProject getTopProjectHandler() {
		if( topProjectHandler == null ) {
			topProjectHandler = new BusModelSaxLoaderTopProject( this );
			topProjectHandler.addElementHandler( "SubProject", getSubProjectHandler() );
		}
		return( topProjectHandler );
	}
	protected BusModelSaxLoaderTweak getTweakHandler() {
		if( tweakHandler == null ) {
			tweakHandler = new BusModelSaxLoaderTweak( this );
		}
		return( tweakHandler );
	}
	protected BusModelSaxLoaderUInt16Col getUInt16ColHandler() {
		if( uInt16ColHandler == null ) {
			uInt16ColHandler = new BusModelSaxLoaderUInt16Col( this );
		}
		return( uInt16ColHandler );
	}
	protected BusModelSaxLoaderUInt16Def getUInt16DefHandler() {
		if( uInt16DefHandler == null ) {
			uInt16DefHandler = new BusModelSaxLoaderUInt16Def( this );
		}
		return( uInt16DefHandler );
	}
	protected BusModelSaxLoaderUInt16Type getUInt16TypeHandler() {
		if( uInt16TypeHandler == null ) {
			uInt16TypeHandler = new BusModelSaxLoaderUInt16Type( this );
		}
		return( uInt16TypeHandler );
	}
	protected BusModelSaxLoaderUInt32Col getUInt32ColHandler() {
		if( uInt32ColHandler == null ) {
			uInt32ColHandler = new BusModelSaxLoaderUInt32Col( this );
		}
		return( uInt32ColHandler );
	}
	protected BusModelSaxLoaderUInt32Def getUInt32DefHandler() {
		if( uInt32DefHandler == null ) {
			uInt32DefHandler = new BusModelSaxLoaderUInt32Def( this );
		}
		return( uInt32DefHandler );
	}
	protected BusModelSaxLoaderUInt32Type getUInt32TypeHandler() {
		if( uInt32TypeHandler == null ) {
			uInt32TypeHandler = new BusModelSaxLoaderUInt32Type( this );
		}
		return( uInt32TypeHandler );
	}
	protected BusModelSaxLoaderUInt64Col getUInt64ColHandler() {
		if( uInt64ColHandler == null ) {
			uInt64ColHandler = new BusModelSaxLoaderUInt64Col( this );
		}
		return( uInt64ColHandler );
	}
	protected BusModelSaxLoaderUInt64Def getUInt64DefHandler() {
		if( uInt64DefHandler == null ) {
			uInt64DefHandler = new BusModelSaxLoaderUInt64Def( this );
		}
		return( uInt64DefHandler );
	}
	protected BusModelSaxLoaderUInt64Type getUInt64TypeHandler() {
		if( uInt64TypeHandler == null ) {
			uInt64TypeHandler = new BusModelSaxLoaderUInt64Type( this );
		}
		return( uInt64TypeHandler );
	}
	protected BusModelSaxLoaderURLProtocol getURLProtocolHandler() {
		if( uRLProtocolHandler == null ) {
			uRLProtocolHandler = new BusModelSaxLoaderURLProtocol( this );
		}
		return( uRLProtocolHandler );
	}
	protected BusModelSaxLoaderUuid6Col getUuid6ColHandler() {
		if( uuid6ColHandler == null ) {
			uuid6ColHandler = new BusModelSaxLoaderUuid6Col( this );
		}
		return( uuid6ColHandler );
	}
	protected BusModelSaxLoaderUuid6Def getUuid6DefHandler() {
		if( uuid6DefHandler == null ) {
			uuid6DefHandler = new BusModelSaxLoaderUuid6Def( this );
		}
		return( uuid6DefHandler );
	}
	protected BusModelSaxLoaderUuid6Gen getUuid6GenHandler() {
		if( uuid6GenHandler == null ) {
			uuid6GenHandler = new BusModelSaxLoaderUuid6Gen( this );
		}
		return( uuid6GenHandler );
	}
	protected BusModelSaxLoaderUuid6Type getUuid6TypeHandler() {
		if( uuid6TypeHandler == null ) {
			uuid6TypeHandler = new BusModelSaxLoaderUuid6Type( this );
		}
		return( uuid6TypeHandler );
	}
	protected BusModelSaxLoaderUuidCol getUuidColHandler() {
		if( uuidColHandler == null ) {
			uuidColHandler = new BusModelSaxLoaderUuidCol( this );
		}
		return( uuidColHandler );
	}
	protected BusModelSaxLoaderUuidDef getUuidDefHandler() {
		if( uuidDefHandler == null ) {
			uuidDefHandler = new BusModelSaxLoaderUuidDef( this );
		}
		return( uuidDefHandler );
	}
	protected BusModelSaxLoaderUuidGen getUuidGenHandler() {
		if( uuidGenHandler == null ) {
			uuidGenHandler = new BusModelSaxLoaderUuidGen( this );
		}
		return( uuidGenHandler );
	}
	protected BusModelSaxLoaderUuidType getUuidTypeHandler() {
		if( uuidTypeHandler == null ) {
			uuidTypeHandler = new BusModelSaxLoaderUuidType( this );
		}
		return( uuidTypeHandler );
	}
	protected BusModelSaxLoaderValue getValueHandler() {
		if( valueHandler == null ) {
			valueHandler = new BusModelSaxLoaderValue( this );
		}
		return( valueHandler );
	}
	// Root Element Handler Resolver Factory

	protected BusModelSaxRootHandler getSaxRootHandler() {
		if( saxRootHandler == null ) {
			saxRootHandler = new BusModelSaxRootHandler( this );
			saxRootHandler.addElementHandler( "BusModel", getSaxDocHandler() );
			saxRootHandler.addElementHandler( "Secure", getSaxDocHandler() );
			saxRootHandler.addElementHandler( "IntNet", getSaxDocHandler() );
		}
		return( saxRootHandler );
	}

	// Root Element Handler

	/*
	 *	BusModelSaxRootHandler XML SAX Root Element Handler implementation
	 */
	public class BusModelSaxRootHandler
		extends YCFLibXmlCoreElementHandler
	{
		public BusModelSaxRootHandler( BusModelSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Document Element Handler Resolver Factory

	protected BusModelSaxDocHandler getSaxDocHandler() {
		if( saxDocHandler == null ) {
			saxDocHandler = new BusModelSaxDocHandler( this );
			saxDocHandler.addElementHandler( "Cluster", getClusterHandler() );
			saxDocHandler.addElementHandler( "ISOCcy", getISOCcyHandler() );
			saxDocHandler.addElementHandler( "ISOCtry", getISOCtryHandler() );
			saxDocHandler.addElementHandler( "ISOLang", getISOLangHandler() );
			saxDocHandler.addElementHandler( "ISOTZone", getISOTZoneHandler() );
			saxDocHandler.addElementHandler( "MimeType", getMimeTypeHandler() );
			saxDocHandler.addElementHandler( "SecSysGrp", getSecSysGrpHandler() );
			saxDocHandler.addElementHandler( "SecSysRole", getSecSysRoleHandler() );
			saxDocHandler.addElementHandler( "SecUser", getSecUserHandler() );
			saxDocHandler.addElementHandler( "SecUserPWHistory", getSecUserPWHistoryHandler() );
			saxDocHandler.addElementHandler( "TableInfo", getTableInfoHandler() );
			saxDocHandler.addElementHandler( "URLProtocol", getURLProtocolHandler() );
		}
		return( saxDocHandler );
	}

	// Document Element Handler

	/*
	 *	BusModelSaxDocHandler XML SAX Doc Element Handler implementation
	 */
	public class BusModelSaxDocHandler
		extends YCFLibXmlCoreElementHandler
	{
		public BusModelSaxDocHandler( BusModelSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Loader behaviour configuration accessors

	public LoaderBehaviourEnum getAtomLoaderBehaviour() {
		return( atomLoaderBehaviour );
	}

	public void setAtomLoaderBehaviour( LoaderBehaviourEnum value ) {
		atomLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobColLoaderBehaviour() {
		return( blobColLoaderBehaviour );
	}

	public void setBlobColLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobDefLoaderBehaviour() {
		return( blobDefLoaderBehaviour );
	}

	public void setBlobDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobTypeLoaderBehaviour() {
		return( blobTypeLoaderBehaviour );
	}

	public void setBlobTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolColLoaderBehaviour() {
		return( boolColLoaderBehaviour );
	}

	public void setBoolColLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolDefLoaderBehaviour() {
		return( boolDefLoaderBehaviour );
	}

	public void setBoolDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolTypeLoaderBehaviour() {
		return( boolTypeLoaderBehaviour );
	}

	public void setBoolTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getChainLoaderBehaviour() {
		return( chainLoaderBehaviour );
	}

	public void setChainLoaderBehaviour( LoaderBehaviourEnum value ) {
		chainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearDepLoaderBehaviour() {
		return( clearDepLoaderBehaviour );
	}

	public void setClearDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		clearDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep1LoaderBehaviour() {
		return( clearSubDep1LoaderBehaviour );
	}

	public void setClearSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep2LoaderBehaviour() {
		return( clearSubDep2LoaderBehaviour );
	}

	public void setClearSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep3LoaderBehaviour() {
		return( clearSubDep3LoaderBehaviour );
	}

	public void setClearSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearTopDepLoaderBehaviour() {
		return( clearTopDepLoaderBehaviour );
	}

	public void setClearTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		clearTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClusterLoaderBehaviour() {
		return( clusterLoaderBehaviour );
	}

	public void setClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		clusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateColLoaderBehaviour() {
		return( dateColLoaderBehaviour );
	}

	public void setDateColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateDefLoaderBehaviour() {
		return( dateDefLoaderBehaviour );
	}

	public void setDateDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateTypeLoaderBehaviour() {
		return( dateTypeLoaderBehaviour );
	}

	public void setDateTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash128ColLoaderBehaviour() {
		return( dbKeyHash128ColLoaderBehaviour );
	}

	public void setDbKeyHash128ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash128ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash128DefLoaderBehaviour() {
		return( dbKeyHash128DefLoaderBehaviour );
	}

	public void setDbKeyHash128DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash128DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash128GenLoaderBehaviour() {
		return( dbKeyHash128GenLoaderBehaviour );
	}

	public void setDbKeyHash128GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash128GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash128TypeLoaderBehaviour() {
		return( dbKeyHash128TypeLoaderBehaviour );
	}

	public void setDbKeyHash128TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash128TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash160ColLoaderBehaviour() {
		return( dbKeyHash160ColLoaderBehaviour );
	}

	public void setDbKeyHash160ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash160ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash160DefLoaderBehaviour() {
		return( dbKeyHash160DefLoaderBehaviour );
	}

	public void setDbKeyHash160DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash160DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash160GenLoaderBehaviour() {
		return( dbKeyHash160GenLoaderBehaviour );
	}

	public void setDbKeyHash160GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash160GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash160TypeLoaderBehaviour() {
		return( dbKeyHash160TypeLoaderBehaviour );
	}

	public void setDbKeyHash160TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash160TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash224ColLoaderBehaviour() {
		return( dbKeyHash224ColLoaderBehaviour );
	}

	public void setDbKeyHash224ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash224ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash224DefLoaderBehaviour() {
		return( dbKeyHash224DefLoaderBehaviour );
	}

	public void setDbKeyHash224DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash224DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash224GenLoaderBehaviour() {
		return( dbKeyHash224GenLoaderBehaviour );
	}

	public void setDbKeyHash224GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash224GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash224TypeLoaderBehaviour() {
		return( dbKeyHash224TypeLoaderBehaviour );
	}

	public void setDbKeyHash224TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash224TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash256ColLoaderBehaviour() {
		return( dbKeyHash256ColLoaderBehaviour );
	}

	public void setDbKeyHash256ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash256ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash256DefLoaderBehaviour() {
		return( dbKeyHash256DefLoaderBehaviour );
	}

	public void setDbKeyHash256DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash256DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash256GenLoaderBehaviour() {
		return( dbKeyHash256GenLoaderBehaviour );
	}

	public void setDbKeyHash256GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash256GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash256TypeLoaderBehaviour() {
		return( dbKeyHash256TypeLoaderBehaviour );
	}

	public void setDbKeyHash256TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash256TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash384ColLoaderBehaviour() {
		return( dbKeyHash384ColLoaderBehaviour );
	}

	public void setDbKeyHash384ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash384ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash384DefLoaderBehaviour() {
		return( dbKeyHash384DefLoaderBehaviour );
	}

	public void setDbKeyHash384DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash384DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash384GenLoaderBehaviour() {
		return( dbKeyHash384GenLoaderBehaviour );
	}

	public void setDbKeyHash384GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash384GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash384TypeLoaderBehaviour() {
		return( dbKeyHash384TypeLoaderBehaviour );
	}

	public void setDbKeyHash384TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash384TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash512ColLoaderBehaviour() {
		return( dbKeyHash512ColLoaderBehaviour );
	}

	public void setDbKeyHash512ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash512ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash512DefLoaderBehaviour() {
		return( dbKeyHash512DefLoaderBehaviour );
	}

	public void setDbKeyHash512DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash512DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash512GenLoaderBehaviour() {
		return( dbKeyHash512GenLoaderBehaviour );
	}

	public void setDbKeyHash512GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash512GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDbKeyHash512TypeLoaderBehaviour() {
		return( dbKeyHash512TypeLoaderBehaviour );
	}

	public void setDbKeyHash512TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dbKeyHash512TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelDepLoaderBehaviour() {
		return( delDepLoaderBehaviour );
	}

	public void setDelDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		delDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep1LoaderBehaviour() {
		return( delSubDep1LoaderBehaviour );
	}

	public void setDelSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep2LoaderBehaviour() {
		return( delSubDep2LoaderBehaviour );
	}

	public void setDelSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep3LoaderBehaviour() {
		return( delSubDep3LoaderBehaviour );
	}

	public void setDelSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelTopDepLoaderBehaviour() {
		return( delTopDepLoaderBehaviour );
	}

	public void setDelTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		delTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleColLoaderBehaviour() {
		return( doubleColLoaderBehaviour );
	}

	public void setDoubleColLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleDefLoaderBehaviour() {
		return( doubleDefLoaderBehaviour );
	}

	public void setDoubleDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleTypeLoaderBehaviour() {
		return( doubleTypeLoaderBehaviour );
	}

	public void setDoubleTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumDefLoaderBehaviour() {
		return( enumDefLoaderBehaviour );
	}

	public void setEnumDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumTagLoaderBehaviour() {
		return( enumTagLoaderBehaviour );
	}

	public void setEnumTagLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumTagLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumTypeLoaderBehaviour() {
		return( enumTypeLoaderBehaviour );
	}

	public void setEnumTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatColLoaderBehaviour() {
		return( floatColLoaderBehaviour );
	}

	public void setFloatColLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatDefLoaderBehaviour() {
		return( floatDefLoaderBehaviour );
	}

	public void setFloatDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatTypeLoaderBehaviour() {
		return( floatTypeLoaderBehaviour );
	}

	public void setFloatTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCcyLoaderBehaviour() {
		return( iSOCcyLoaderBehaviour );
	}

	public void setISOCcyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCcyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryLoaderBehaviour() {
		return( iSOCtryLoaderBehaviour );
	}

	public void setISOCtryLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryCcyLoaderBehaviour() {
		return( iSOCtryCcyLoaderBehaviour );
	}

	public void setISOCtryCcyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryCcyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryLangLoaderBehaviour() {
		return( iSOCtryLangLoaderBehaviour );
	}

	public void setISOCtryLangLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryLangLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOLangLoaderBehaviour() {
		return( iSOLangLoaderBehaviour );
	}

	public void setISOLangLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOLangLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOTZoneLoaderBehaviour() {
		return( iSOTZoneLoaderBehaviour );
	}

	public void setISOTZoneLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOTZoneLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId16GenLoaderBehaviour() {
		return( id16GenLoaderBehaviour );
	}

	public void setId16GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id16GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId32GenLoaderBehaviour() {
		return( id32GenLoaderBehaviour );
	}

	public void setId32GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id32GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId64GenLoaderBehaviour() {
		return( id64GenLoaderBehaviour );
	}

	public void setId64GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id64GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getIndexLoaderBehaviour() {
		return( indexLoaderBehaviour );
	}

	public void setIndexLoaderBehaviour( LoaderBehaviourEnum value ) {
		indexLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getIndexColLoaderBehaviour() {
		return( indexColLoaderBehaviour );
	}

	public void setIndexColLoaderBehaviour( LoaderBehaviourEnum value ) {
		indexColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getIndexTweakLoaderBehaviour() {
		return( indexTweakLoaderBehaviour );
	}

	public void setIndexTweakLoaderBehaviour( LoaderBehaviourEnum value ) {
		indexTweakLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16ColLoaderBehaviour() {
		return( int16ColLoaderBehaviour );
	}

	public void setInt16ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16DefLoaderBehaviour() {
		return( int16DefLoaderBehaviour );
	}

	public void setInt16DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16TypeLoaderBehaviour() {
		return( int16TypeLoaderBehaviour );
	}

	public void setInt16TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32ColLoaderBehaviour() {
		return( int32ColLoaderBehaviour );
	}

	public void setInt32ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32DefLoaderBehaviour() {
		return( int32DefLoaderBehaviour );
	}

	public void setInt32DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32TypeLoaderBehaviour() {
		return( int32TypeLoaderBehaviour );
	}

	public void setInt32TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64ColLoaderBehaviour() {
		return( int64ColLoaderBehaviour );
	}

	public void setInt64ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64DefLoaderBehaviour() {
		return( int64DefLoaderBehaviour );
	}

	public void setInt64DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64TypeLoaderBehaviour() {
		return( int64TypeLoaderBehaviour );
	}

	public void setInt64TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getLicenseLoaderBehaviour() {
		return( licenseLoaderBehaviour );
	}

	public void setLicenseLoaderBehaviour( LoaderBehaviourEnum value ) {
		licenseLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMajorVersionLoaderBehaviour() {
		return( majorVersionLoaderBehaviour );
	}

	public void setMajorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		majorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMimeTypeLoaderBehaviour() {
		return( mimeTypeLoaderBehaviour );
	}

	public void setMimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		mimeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMinorVersionLoaderBehaviour() {
		return( minorVersionLoaderBehaviour );
	}

	public void setMinorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		minorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenColLoaderBehaviour() {
		return( nmTokenColLoaderBehaviour );
	}

	public void setNmTokenColLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenDefLoaderBehaviour() {
		return( nmTokenDefLoaderBehaviour );
	}

	public void setNmTokenDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenTypeLoaderBehaviour() {
		return( nmTokenTypeLoaderBehaviour );
	}

	public void setNmTokenTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensColLoaderBehaviour() {
		return( nmTokensColLoaderBehaviour );
	}

	public void setNmTokensColLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensDefLoaderBehaviour() {
		return( nmTokensDefLoaderBehaviour );
	}

	public void setNmTokensDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensTypeLoaderBehaviour() {
		return( nmTokensTypeLoaderBehaviour );
	}

	public void setNmTokensTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberColLoaderBehaviour() {
		return( numberColLoaderBehaviour );
	}

	public void setNumberColLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberDefLoaderBehaviour() {
		return( numberDefLoaderBehaviour );
	}

	public void setNumberDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberTypeLoaderBehaviour() {
		return( numberTypeLoaderBehaviour );
	}

	public void setNumberTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getParamLoaderBehaviour() {
		return( paramLoaderBehaviour );
	}

	public void setParamLoaderBehaviour( LoaderBehaviourEnum value ) {
		paramLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopDepLoaderBehaviour() {
		return( popDepLoaderBehaviour );
	}

	public void setPopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		popDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep1LoaderBehaviour() {
		return( popSubDep1LoaderBehaviour );
	}

	public void setPopSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep2LoaderBehaviour() {
		return( popSubDep2LoaderBehaviour );
	}

	public void setPopSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep3LoaderBehaviour() {
		return( popSubDep3LoaderBehaviour );
	}

	public void setPopSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopTopDepLoaderBehaviour() {
		return( popTopDepLoaderBehaviour );
	}

	public void setPopTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		popTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRelationLoaderBehaviour() {
		return( relationLoaderBehaviour );
	}

	public void setRelationLoaderBehaviour( LoaderBehaviourEnum value ) {
		relationLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRelationColLoaderBehaviour() {
		return( relationColLoaderBehaviour );
	}

	public void setRelationColLoaderBehaviour( LoaderBehaviourEnum value ) {
		relationColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRoleDefLoaderBehaviour() {
		return( roleDefLoaderBehaviour );
	}

	public void setRoleDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		roleDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaDefLoaderBehaviour() {
		return( schemaDefLoaderBehaviour );
	}

	public void setSchemaDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaRefLoaderBehaviour() {
		return( schemaRefLoaderBehaviour );
	}

	public void setSchemaRefLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaRefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaRoleLoaderBehaviour() {
		return( schemaRoleLoaderBehaviour );
	}

	public void setSchemaRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaTweakLoaderBehaviour() {
		return( schemaTweakLoaderBehaviour );
	}

	public void setSchemaTweakLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaTweakLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getScopeLoaderBehaviour() {
		return( scopeLoaderBehaviour );
	}

	public void setScopeLoaderBehaviour( LoaderBehaviourEnum value ) {
		scopeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusGrpLoaderBehaviour() {
		return( secClusGrpLoaderBehaviour );
	}

	public void setSecClusGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusGrpMembLoaderBehaviour() {
		return( secClusGrpMembLoaderBehaviour );
	}

	public void setSecClusGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusRoleLoaderBehaviour() {
		return( secClusRoleLoaderBehaviour );
	}

	public void setSecClusRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusRoleMembLoaderBehaviour() {
		return( secClusRoleMembLoaderBehaviour );
	}

	public void setSecClusRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSessionLoaderBehaviour() {
		return( secSessionLoaderBehaviour );
	}

	public void setSecSessionLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSessionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpLoaderBehaviour() {
		return( secSysGrpLoaderBehaviour );
	}

	public void setSecSysGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpIncLoaderBehaviour() {
		return( secSysGrpIncLoaderBehaviour );
	}

	public void setSecSysGrpIncLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpIncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpMembLoaderBehaviour() {
		return( secSysGrpMembLoaderBehaviour );
	}

	public void setSecSysGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleLoaderBehaviour() {
		return( secSysRoleLoaderBehaviour );
	}

	public void setSecSysRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleEnablesLoaderBehaviour() {
		return( secSysRoleEnablesLoaderBehaviour );
	}

	public void setSecSysRoleEnablesLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleEnablesLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleMembLoaderBehaviour() {
		return( secSysRoleMembLoaderBehaviour );
	}

	public void setSecSysRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentGrpLoaderBehaviour() {
		return( secTentGrpLoaderBehaviour );
	}

	public void setSecTentGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentGrpMembLoaderBehaviour() {
		return( secTentGrpMembLoaderBehaviour );
	}

	public void setSecTentGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentRoleLoaderBehaviour() {
		return( secTentRoleLoaderBehaviour );
	}

	public void setSecTentRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentRoleMembLoaderBehaviour() {
		return( secTentRoleMembLoaderBehaviour );
	}

	public void setSecTentRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserLoaderBehaviour() {
		return( secUserLoaderBehaviour );
	}

	public void setSecUserLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserEMConfLoaderBehaviour() {
		return( secUserEMConfLoaderBehaviour );
	}

	public void setSecUserEMConfLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserEMConfLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPWHistoryLoaderBehaviour() {
		return( secUserPWHistoryLoaderBehaviour );
	}

	public void setSecUserPWHistoryLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPWHistoryLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPWResetLoaderBehaviour() {
		return( secUserPWResetLoaderBehaviour );
	}

	public void setSecUserPWResetLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPWResetLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPasswordLoaderBehaviour() {
		return( secUserPasswordLoaderBehaviour );
	}

	public void setSecUserPasswordLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPasswordLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerListFuncLoaderBehaviour() {
		return( serverListFuncLoaderBehaviour );
	}

	public void setServerListFuncLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverListFuncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerMethodLoaderBehaviour() {
		return( serverMethodLoaderBehaviour );
	}

	public void setServerMethodLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverMethodLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerObjFuncLoaderBehaviour() {
		return( serverObjFuncLoaderBehaviour );
	}

	public void setServerObjFuncLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverObjFuncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerProcLoaderBehaviour() {
		return( serverProcLoaderBehaviour );
	}

	public void setServerProcLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverProcLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringColLoaderBehaviour() {
		return( stringColLoaderBehaviour );
	}

	public void setStringColLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringDefLoaderBehaviour() {
		return( stringDefLoaderBehaviour );
	}

	public void setStringDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringTypeLoaderBehaviour() {
		return( stringTypeLoaderBehaviour );
	}

	public void setStringTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSubProjectLoaderBehaviour() {
		return( subProjectLoaderBehaviour );
	}

	public void setSubProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		subProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSysClusterLoaderBehaviour() {
		return( sysClusterLoaderBehaviour );
	}

	public void setSysClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		sysClusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateColLoaderBehaviour() {
		return( tZDateColLoaderBehaviour );
	}

	public void setTZDateColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateDefLoaderBehaviour() {
		return( tZDateDefLoaderBehaviour );
	}

	public void setTZDateDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateTypeLoaderBehaviour() {
		return( tZDateTypeLoaderBehaviour );
	}

	public void setTZDateTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeColLoaderBehaviour() {
		return( tZTimeColLoaderBehaviour );
	}

	public void setTZTimeColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeDefLoaderBehaviour() {
		return( tZTimeDefLoaderBehaviour );
	}

	public void setTZTimeDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeTypeLoaderBehaviour() {
		return( tZTimeTypeLoaderBehaviour );
	}

	public void setTZTimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampColLoaderBehaviour() {
		return( tZTimestampColLoaderBehaviour );
	}

	public void setTZTimestampColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampDefLoaderBehaviour() {
		return( tZTimestampDefLoaderBehaviour );
	}

	public void setTZTimestampDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampTypeLoaderBehaviour() {
		return( tZTimestampTypeLoaderBehaviour );
	}

	public void setTZTimestampTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableLoaderBehaviour() {
		return( tableLoaderBehaviour );
	}

	public void setTableLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableColLoaderBehaviour() {
		return( tableColLoaderBehaviour );
	}

	public void setTableColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableInfoLoaderBehaviour() {
		return( tableInfoLoaderBehaviour );
	}

	public void setTableInfoLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableInfoLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableTweakLoaderBehaviour() {
		return( tableTweakLoaderBehaviour );
	}

	public void setTableTweakLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableTweakLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTenantLoaderBehaviour() {
		return( tenantLoaderBehaviour );
	}

	public void setTenantLoaderBehaviour( LoaderBehaviourEnum value ) {
		tenantLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextColLoaderBehaviour() {
		return( textColLoaderBehaviour );
	}

	public void setTextColLoaderBehaviour( LoaderBehaviourEnum value ) {
		textColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextDefLoaderBehaviour() {
		return( textDefLoaderBehaviour );
	}

	public void setTextDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		textDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextTypeLoaderBehaviour() {
		return( textTypeLoaderBehaviour );
	}

	public void setTextTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		textTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeColLoaderBehaviour() {
		return( timeColLoaderBehaviour );
	}

	public void setTimeColLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeDefLoaderBehaviour() {
		return( timeDefLoaderBehaviour );
	}

	public void setTimeDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeTypeLoaderBehaviour() {
		return( timeTypeLoaderBehaviour );
	}

	public void setTimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampColLoaderBehaviour() {
		return( timestampColLoaderBehaviour );
	}

	public void setTimestampColLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampDefLoaderBehaviour() {
		return( timestampDefLoaderBehaviour );
	}

	public void setTimestampDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampTypeLoaderBehaviour() {
		return( timestampTypeLoaderBehaviour );
	}

	public void setTimestampTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTldLoaderBehaviour() {
		return( tldLoaderBehaviour );
	}

	public void setTldLoaderBehaviour( LoaderBehaviourEnum value ) {
		tldLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenColLoaderBehaviour() {
		return( tokenColLoaderBehaviour );
	}

	public void setTokenColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenDefLoaderBehaviour() {
		return( tokenDefLoaderBehaviour );
	}

	public void setTokenDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenTypeLoaderBehaviour() {
		return( tokenTypeLoaderBehaviour );
	}

	public void setTokenTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopDomainLoaderBehaviour() {
		return( topDomainLoaderBehaviour );
	}

	public void setTopDomainLoaderBehaviour( LoaderBehaviourEnum value ) {
		topDomainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopProjectLoaderBehaviour() {
		return( topProjectLoaderBehaviour );
	}

	public void setTopProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		topProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTweakLoaderBehaviour() {
		return( tweakLoaderBehaviour );
	}

	public void setTweakLoaderBehaviour( LoaderBehaviourEnum value ) {
		tweakLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16ColLoaderBehaviour() {
		return( uInt16ColLoaderBehaviour );
	}

	public void setUInt16ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16DefLoaderBehaviour() {
		return( uInt16DefLoaderBehaviour );
	}

	public void setUInt16DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16TypeLoaderBehaviour() {
		return( uInt16TypeLoaderBehaviour );
	}

	public void setUInt16TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32ColLoaderBehaviour() {
		return( uInt32ColLoaderBehaviour );
	}

	public void setUInt32ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32DefLoaderBehaviour() {
		return( uInt32DefLoaderBehaviour );
	}

	public void setUInt32DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32TypeLoaderBehaviour() {
		return( uInt32TypeLoaderBehaviour );
	}

	public void setUInt32TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64ColLoaderBehaviour() {
		return( uInt64ColLoaderBehaviour );
	}

	public void setUInt64ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64DefLoaderBehaviour() {
		return( uInt64DefLoaderBehaviour );
	}

	public void setUInt64DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64TypeLoaderBehaviour() {
		return( uInt64TypeLoaderBehaviour );
	}

	public void setUInt64TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getURLProtocolLoaderBehaviour() {
		return( uRLProtocolLoaderBehaviour );
	}

	public void setURLProtocolLoaderBehaviour( LoaderBehaviourEnum value ) {
		uRLProtocolLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuid6ColLoaderBehaviour() {
		return( uuid6ColLoaderBehaviour );
	}

	public void setUuid6ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuid6ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuid6DefLoaderBehaviour() {
		return( uuid6DefLoaderBehaviour );
	}

	public void setUuid6DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuid6DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuid6GenLoaderBehaviour() {
		return( uuid6GenLoaderBehaviour );
	}

	public void setUuid6GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuid6GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuid6TypeLoaderBehaviour() {
		return( uuid6TypeLoaderBehaviour );
	}

	public void setUuid6TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuid6TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidColLoaderBehaviour() {
		return( uuidColLoaderBehaviour );
	}

	public void setUuidColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidDefLoaderBehaviour() {
		return( uuidDefLoaderBehaviour );
	}

	public void setUuidDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidGenLoaderBehaviour() {
		return( uuidGenLoaderBehaviour );
	}

	public void setUuidGenLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidGenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidTypeLoaderBehaviour() {
		return( uuidTypeLoaderBehaviour );
	}

	public void setUuidTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getValueLoaderBehaviour() {
		return( valueLoaderBehaviour );
	}

	public void setValueLoaderBehaviour( LoaderBehaviourEnum value ) {
		valueLoaderBehaviour = value;
	}

	// Parse a file

	public void parseFile( String url ) {
		parse( url );
	}
}
