// Description: Java 25 JavaFX Schema Interface for BusModel.

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

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

import java.math.*;
import java.time.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;
import server.markhome.ycf.v3_1.intnet.intnetjavafx.*;

/**
 *	The IBusModelJavaFXSchema defines the factory interface for the
 *	for the various panes and components used to construct a GUI interface
 *	using the JavaFX framework.
 */
public interface IBusModelJavaFXSchema
	extends ISecureJavaFXSchema,
		IIntNetJavaFXSchema
{
	ISecureSchemaObj getSchema();
	void setSchema( ISecureSchemaObj argSchema );

	String getClusterName();
	void setClusterName( String argClusterName );
	ISecureClusterObj getClusterObj();

	String getTenantName();
	void setTenantName( String argTenantName );
	ISecureTenantObj getTenantObj();

	String getSecUserName();
	void setSecUserName( String argSecUserName );
	ISecureSecUserObj getSecUserObj();

	ISecureSecSessionObj getSecSessionObj();

	public IBusModelJavaFXAtomFactory getAtomFactory();

	public IBusModelJavaFXBlobColFactory getBlobColFactory();

	public IBusModelJavaFXBlobDefFactory getBlobDefFactory();

	public IBusModelJavaFXBlobTypeFactory getBlobTypeFactory();

	public IBusModelJavaFXBoolColFactory getBoolColFactory();

	public IBusModelJavaFXBoolDefFactory getBoolDefFactory();

	public IBusModelJavaFXBoolTypeFactory getBoolTypeFactory();

	public IBusModelJavaFXChainFactory getChainFactory();

	public IBusModelJavaFXClearDepFactory getClearDepFactory();

	public IBusModelJavaFXClearSubDep1Factory getClearSubDep1Factory();

	public IBusModelJavaFXClearSubDep2Factory getClearSubDep2Factory();

	public IBusModelJavaFXClearSubDep3Factory getClearSubDep3Factory();

	public IBusModelJavaFXClearTopDepFactory getClearTopDepFactory();

	public ISecureJavaFXClusterFactory getClusterFactory();

	public IBusModelJavaFXDateColFactory getDateColFactory();

	public IBusModelJavaFXDateDefFactory getDateDefFactory();

	public IBusModelJavaFXDateTypeFactory getDateTypeFactory();

	public IBusModelJavaFXDbKeyHash128ColFactory getDbKeyHash128ColFactory();

	public IBusModelJavaFXDbKeyHash128DefFactory getDbKeyHash128DefFactory();

	public IBusModelJavaFXDbKeyHash128GenFactory getDbKeyHash128GenFactory();

	public IBusModelJavaFXDbKeyHash128TypeFactory getDbKeyHash128TypeFactory();

	public IBusModelJavaFXDbKeyHash160ColFactory getDbKeyHash160ColFactory();

	public IBusModelJavaFXDbKeyHash160DefFactory getDbKeyHash160DefFactory();

	public IBusModelJavaFXDbKeyHash160GenFactory getDbKeyHash160GenFactory();

	public IBusModelJavaFXDbKeyHash160TypeFactory getDbKeyHash160TypeFactory();

	public IBusModelJavaFXDbKeyHash224ColFactory getDbKeyHash224ColFactory();

	public IBusModelJavaFXDbKeyHash224DefFactory getDbKeyHash224DefFactory();

	public IBusModelJavaFXDbKeyHash224GenFactory getDbKeyHash224GenFactory();

	public IBusModelJavaFXDbKeyHash224TypeFactory getDbKeyHash224TypeFactory();

	public IBusModelJavaFXDbKeyHash256ColFactory getDbKeyHash256ColFactory();

	public IBusModelJavaFXDbKeyHash256DefFactory getDbKeyHash256DefFactory();

	public IBusModelJavaFXDbKeyHash256GenFactory getDbKeyHash256GenFactory();

	public IBusModelJavaFXDbKeyHash256TypeFactory getDbKeyHash256TypeFactory();

	public IBusModelJavaFXDbKeyHash384ColFactory getDbKeyHash384ColFactory();

	public IBusModelJavaFXDbKeyHash384DefFactory getDbKeyHash384DefFactory();

	public IBusModelJavaFXDbKeyHash384GenFactory getDbKeyHash384GenFactory();

	public IBusModelJavaFXDbKeyHash384TypeFactory getDbKeyHash384TypeFactory();

	public IBusModelJavaFXDbKeyHash512ColFactory getDbKeyHash512ColFactory();

	public IBusModelJavaFXDbKeyHash512DefFactory getDbKeyHash512DefFactory();

	public IBusModelJavaFXDbKeyHash512GenFactory getDbKeyHash512GenFactory();

	public IBusModelJavaFXDbKeyHash512TypeFactory getDbKeyHash512TypeFactory();

	public IBusModelJavaFXDelDepFactory getDelDepFactory();

	public IBusModelJavaFXDelSubDep1Factory getDelSubDep1Factory();

	public IBusModelJavaFXDelSubDep2Factory getDelSubDep2Factory();

	public IBusModelJavaFXDelSubDep3Factory getDelSubDep3Factory();

	public IBusModelJavaFXDelTopDepFactory getDelTopDepFactory();

	public IBusModelJavaFXDoubleColFactory getDoubleColFactory();

	public IBusModelJavaFXDoubleDefFactory getDoubleDefFactory();

	public IBusModelJavaFXDoubleTypeFactory getDoubleTypeFactory();

	public IBusModelJavaFXEnumDefFactory getEnumDefFactory();

	public IBusModelJavaFXEnumTagFactory getEnumTagFactory();

	public IBusModelJavaFXEnumTypeFactory getEnumTypeFactory();

	public IBusModelJavaFXFloatColFactory getFloatColFactory();

	public IBusModelJavaFXFloatDefFactory getFloatDefFactory();

	public IBusModelJavaFXFloatTypeFactory getFloatTypeFactory();

	public ISecureJavaFXISOCcyFactory getISOCcyFactory();

	public ISecureJavaFXISOCtryFactory getISOCtryFactory();

	public ISecureJavaFXISOCtryCcyFactory getISOCtryCcyFactory();

	public ISecureJavaFXISOCtryLangFactory getISOCtryLangFactory();

	public ISecureJavaFXISOLangFactory getISOLangFactory();

	public ISecureJavaFXISOTZoneFactory getISOTZoneFactory();

	public IBusModelJavaFXId16GenFactory getId16GenFactory();

	public IBusModelJavaFXId32GenFactory getId32GenFactory();

	public IBusModelJavaFXId64GenFactory getId64GenFactory();

	public IBusModelJavaFXIndexFactory getIndexFactory();

	public IBusModelJavaFXIndexColFactory getIndexColFactory();

	public IBusModelJavaFXIndexTweakFactory getIndexTweakFactory();

	public IBusModelJavaFXInt16ColFactory getInt16ColFactory();

	public IBusModelJavaFXInt16DefFactory getInt16DefFactory();

	public IBusModelJavaFXInt16TypeFactory getInt16TypeFactory();

	public IBusModelJavaFXInt32ColFactory getInt32ColFactory();

	public IBusModelJavaFXInt32DefFactory getInt32DefFactory();

	public IBusModelJavaFXInt32TypeFactory getInt32TypeFactory();

	public IBusModelJavaFXInt64ColFactory getInt64ColFactory();

	public IBusModelJavaFXInt64DefFactory getInt64DefFactory();

	public IBusModelJavaFXInt64TypeFactory getInt64TypeFactory();

	public IIntNetJavaFXLicenseFactory getLicenseFactory();

	public IIntNetJavaFXMajorVersionFactory getMajorVersionFactory();

	public IIntNetJavaFXMimeTypeFactory getMimeTypeFactory();

	public IIntNetJavaFXMinorVersionFactory getMinorVersionFactory();

	public IBusModelJavaFXNmTokenColFactory getNmTokenColFactory();

	public IBusModelJavaFXNmTokenDefFactory getNmTokenDefFactory();

	public IBusModelJavaFXNmTokenTypeFactory getNmTokenTypeFactory();

	public IBusModelJavaFXNmTokensColFactory getNmTokensColFactory();

	public IBusModelJavaFXNmTokensDefFactory getNmTokensDefFactory();

	public IBusModelJavaFXNmTokensTypeFactory getNmTokensTypeFactory();

	public IBusModelJavaFXNumberColFactory getNumberColFactory();

	public IBusModelJavaFXNumberDefFactory getNumberDefFactory();

	public IBusModelJavaFXNumberTypeFactory getNumberTypeFactory();

	public IBusModelJavaFXParamFactory getParamFactory();

	public IBusModelJavaFXPopDepFactory getPopDepFactory();

	public IBusModelJavaFXPopSubDep1Factory getPopSubDep1Factory();

	public IBusModelJavaFXPopSubDep2Factory getPopSubDep2Factory();

	public IBusModelJavaFXPopSubDep3Factory getPopSubDep3Factory();

	public IBusModelJavaFXPopTopDepFactory getPopTopDepFactory();

	public IBusModelJavaFXRelationFactory getRelationFactory();

	public IBusModelJavaFXRelationColFactory getRelationColFactory();

	public IBusModelJavaFXRoleDefFactory getRoleDefFactory();

	public IBusModelJavaFXSchemaDefFactory getSchemaDefFactory();

	public IBusModelJavaFXSchemaRefFactory getSchemaRefFactory();

	public IBusModelJavaFXSchemaRoleFactory getSchemaRoleFactory();

	public IBusModelJavaFXSchemaTweakFactory getSchemaTweakFactory();

	public IBusModelJavaFXScopeFactory getScopeFactory();

	public ISecureJavaFXSecClusGrpFactory getSecClusGrpFactory();

	public ISecureJavaFXSecClusGrpMembFactory getSecClusGrpMembFactory();

	public ISecureJavaFXSecClusRoleFactory getSecClusRoleFactory();

	public ISecureJavaFXSecClusRoleMembFactory getSecClusRoleMembFactory();

	public ISecureJavaFXSecSessionFactory getSecSessionFactory();

	public ISecureJavaFXSecSysGrpFactory getSecSysGrpFactory();

	public ISecureJavaFXSecSysGrpIncFactory getSecSysGrpIncFactory();

	public ISecureJavaFXSecSysGrpMembFactory getSecSysGrpMembFactory();

	public ISecureJavaFXSecSysRoleFactory getSecSysRoleFactory();

	public ISecureJavaFXSecSysRoleEnablesFactory getSecSysRoleEnablesFactory();

	public ISecureJavaFXSecSysRoleMembFactory getSecSysRoleMembFactory();

	public ISecureJavaFXSecTentGrpFactory getSecTentGrpFactory();

	public ISecureJavaFXSecTentGrpMembFactory getSecTentGrpMembFactory();

	public ISecureJavaFXSecTentRoleFactory getSecTentRoleFactory();

	public ISecureJavaFXSecTentRoleMembFactory getSecTentRoleMembFactory();

	public ISecureJavaFXSecUserFactory getSecUserFactory();

	public ISecureJavaFXSecUserEMConfFactory getSecUserEMConfFactory();

	public ISecureJavaFXSecUserPWHistoryFactory getSecUserPWHistoryFactory();

	public ISecureJavaFXSecUserPWResetFactory getSecUserPWResetFactory();

	public ISecureJavaFXSecUserPasswordFactory getSecUserPasswordFactory();

	public IBusModelJavaFXServerListFuncFactory getServerListFuncFactory();

	public IBusModelJavaFXServerMethodFactory getServerMethodFactory();

	public IBusModelJavaFXServerObjFuncFactory getServerObjFuncFactory();

	public IBusModelJavaFXServerProcFactory getServerProcFactory();

	public IBusModelJavaFXStringColFactory getStringColFactory();

	public IBusModelJavaFXStringDefFactory getStringDefFactory();

	public IBusModelJavaFXStringTypeFactory getStringTypeFactory();

	public IIntNetJavaFXSubProjectFactory getSubProjectFactory();

	public ISecureJavaFXSysClusterFactory getSysClusterFactory();

	public IBusModelJavaFXTZDateColFactory getTZDateColFactory();

	public IBusModelJavaFXTZDateDefFactory getTZDateDefFactory();

	public IBusModelJavaFXTZDateTypeFactory getTZDateTypeFactory();

	public IBusModelJavaFXTZTimeColFactory getTZTimeColFactory();

	public IBusModelJavaFXTZTimeDefFactory getTZTimeDefFactory();

	public IBusModelJavaFXTZTimeTypeFactory getTZTimeTypeFactory();

	public IBusModelJavaFXTZTimestampColFactory getTZTimestampColFactory();

	public IBusModelJavaFXTZTimestampDefFactory getTZTimestampDefFactory();

	public IBusModelJavaFXTZTimestampTypeFactory getTZTimestampTypeFactory();

	public IBusModelJavaFXTableFactory getTableFactory();

	public IBusModelJavaFXTableColFactory getTableColFactory();

	public ISecureJavaFXTableInfoFactory getTableInfoFactory();

	public IBusModelJavaFXTableTweakFactory getTableTweakFactory();

	public ISecureJavaFXTenantFactory getTenantFactory();

	public IBusModelJavaFXTextColFactory getTextColFactory();

	public IBusModelJavaFXTextDefFactory getTextDefFactory();

	public IBusModelJavaFXTextTypeFactory getTextTypeFactory();

	public IBusModelJavaFXTimeColFactory getTimeColFactory();

	public IBusModelJavaFXTimeDefFactory getTimeDefFactory();

	public IBusModelJavaFXTimeTypeFactory getTimeTypeFactory();

	public IBusModelJavaFXTimestampColFactory getTimestampColFactory();

	public IBusModelJavaFXTimestampDefFactory getTimestampDefFactory();

	public IBusModelJavaFXTimestampTypeFactory getTimestampTypeFactory();

	public IIntNetJavaFXTldFactory getTldFactory();

	public IBusModelJavaFXTokenColFactory getTokenColFactory();

	public IBusModelJavaFXTokenDefFactory getTokenDefFactory();

	public IBusModelJavaFXTokenTypeFactory getTokenTypeFactory();

	public IIntNetJavaFXTopDomainFactory getTopDomainFactory();

	public IIntNetJavaFXTopProjectFactory getTopProjectFactory();

	public IBusModelJavaFXTweakFactory getTweakFactory();

	public IBusModelJavaFXUInt16ColFactory getUInt16ColFactory();

	public IBusModelJavaFXUInt16DefFactory getUInt16DefFactory();

	public IBusModelJavaFXUInt16TypeFactory getUInt16TypeFactory();

	public IBusModelJavaFXUInt32ColFactory getUInt32ColFactory();

	public IBusModelJavaFXUInt32DefFactory getUInt32DefFactory();

	public IBusModelJavaFXUInt32TypeFactory getUInt32TypeFactory();

	public IBusModelJavaFXUInt64ColFactory getUInt64ColFactory();

	public IBusModelJavaFXUInt64DefFactory getUInt64DefFactory();

	public IBusModelJavaFXUInt64TypeFactory getUInt64TypeFactory();

	public IIntNetJavaFXURLProtocolFactory getURLProtocolFactory();

	public IBusModelJavaFXUuid6ColFactory getUuid6ColFactory();

	public IBusModelJavaFXUuid6DefFactory getUuid6DefFactory();

	public IBusModelJavaFXUuid6GenFactory getUuid6GenFactory();

	public IBusModelJavaFXUuid6TypeFactory getUuid6TypeFactory();

	public IBusModelJavaFXUuidColFactory getUuidColFactory();

	public IBusModelJavaFXUuidDefFactory getUuidDefFactory();

	public IBusModelJavaFXUuidGenFactory getUuidGenFactory();

	public IBusModelJavaFXUuidTypeFactory getUuidTypeFactory();

	public IBusModelJavaFXValueFactory getValueFactory();
}
