
// Description: Java 25 DbIO implementation for ServerObjFunc.

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

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.jpa.BusModelJpaHooksSchema;

/*
 *	BusModelJpaServerObjFuncTable database implementation for ServerObjFunc
 */
public class BusModelJpaServerObjFuncTable implements IBusModelServerObjFuncTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaServerObjFuncTable(IBusModelSchema schema) {
		if( schema == null ) {
			throw new YCFNullArgumentException(getClass(), "constructor", 1, "schema" );
		}
		if (schema instanceof BusModelJpaSchema) {
			this.schema = (BusModelJpaSchema)schema;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "constructor", "schema", schema, "BusModelJpaSchema");
		}
	}

	protected boolean canCreateServerObjFunc(String S_ProcName, ISecureAuthorization Authorization) {
		if (Authorization == null) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization");
		}
		boolean permissionGranted = false;
		YCFDbKeyHash256 authUserId = Authorization.getSecUserId();
		if ((!permissionGranted) && (authUserId == null || authUserId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization.getSecUserId()");
		}
		// Check for "system" user
		YCFDbKeyHash256 systemId = ISecureSchema.getSystemId();
		if ((!permissionGranted) && (systemId != null && !systemId.isNull() && systemId.equals(authUserId))) {
			permissionGranted = true;
		}
		else if ((!permissionGranted) && (systemId == null || systemId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "ISecureSchema.getSystemId()");
		}
		if(!permissionGranted) {
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createserverobjfunc");
		}
		return( permissionGranted );
	}

	protected boolean canReadServerObjFunc(String S_ProcName, ISecureAuthorization Authorization) {
		if (Authorization == null) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization");
		}
		boolean permissionGranted = false;
		YCFDbKeyHash256 authUserId = Authorization.getSecUserId();
		if ((!permissionGranted) && (authUserId == null || authUserId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization.getSecUserId()");
		}
		// Check for "system" user
		YCFDbKeyHash256 systemId = ISecureSchema.getSystemId();
		if ((!permissionGranted) && (systemId != null && !systemId.isNull() && systemId.equals(authUserId))) {
			permissionGranted = true;
		}
		else if ((!permissionGranted) && (systemId == null || systemId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "ISecureSchema.getSystemId()");
		}
		if(!permissionGranted) {
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readserverobjfunc");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateServerObjFunc(String S_ProcName, ISecureAuthorization Authorization) {
		if (Authorization == null) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization");
		}
		boolean permissionGranted = false;
		YCFDbKeyHash256 authUserId = Authorization.getSecUserId();
		if ((!permissionGranted) && (authUserId == null || authUserId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization.getSecUserId()");
		}
		// Check for "system" user
		YCFDbKeyHash256 systemId = ISecureSchema.getSystemId();
		if ((!permissionGranted) && (systemId != null && !systemId.isNull() && systemId.equals(authUserId))) {
			permissionGranted = true;
		}
		else if ((!permissionGranted) && (systemId == null || systemId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "ISecureSchema.getSystemId()");
		}
		if(!permissionGranted) {
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updateserverobjfunc");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteServerObjFunc(String S_ProcName, ISecureAuthorization Authorization) {
		if (Authorization == null) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization");
		}
		boolean permissionGranted = false;
		YCFDbKeyHash256 authUserId = Authorization.getSecUserId();
		if ((!permissionGranted) && (authUserId == null || authUserId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "Authorization.getSecUserId()");
		}
		// Check for "system" user
		YCFDbKeyHash256 systemId = ISecureSchema.getSystemId();
		if ((!permissionGranted) && (systemId != null && !systemId.isNull() && systemId.equals(authUserId))) {
			permissionGranted = true;
		}
		else if ((!permissionGranted) && (systemId == null || systemId.isNull())) {
			throw new YCFNullArgumentException(getClass(), S_ProcName, 0, "ISecureSchema.getSystemId()");
		}
		if(!permissionGranted) {
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deleteserverobjfunc");
		}
		return( permissionGranted );
	}

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	@Override
	public IBusModelServerObjFunc createServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc rec )
	{
		final String S_ProcName = "createServerObjFunc";
		boolean permissionGranted = canCreateServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createServerObjFunc", 1, "rec");
		}
		else if (rec instanceof BusModelJpaServerObjFunc) {
			BusModelJpaServerObjFunc jparec = (BusModelJpaServerObjFunc)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createServerObjFunc", "rec", rec, "BusModelJpaServerObjFunc");
		}
	}

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	@Override
	public IBusModelServerObjFunc updateServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc rec )
	{
		final String S_ProcName = "updateServerObjFunc";
		boolean permissionGranted = canUpdateServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateServerObjFunc", 1, "rec");
		}
		else if (rec instanceof BusModelJpaServerObjFunc) {
			BusModelJpaServerObjFunc jparec = (BusModelJpaServerObjFunc)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateServerObjFunc", "rec", rec, "BusModelJpaServerObjFunc");
		}
	}

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	@Override
	public void deleteServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc rec )
	{
		final String S_ProcName = "deleteServerObjFunc";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaServerObjFunc) {
			BusModelJpaServerObjFunc jparec = (BusModelJpaServerObjFunc)rec;
			schema.getJpaHooksSchema().getServerObjFuncService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteServerObjFunc", "rec", rec, "BusModelJpaServerObjFunc");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteServerObjFunc");
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRetTableId )
	{
		final String S_ProcName = "deleteServerObjFuncByRetTblIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByRetTblIdx(argRetTableId);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByRetTblIdx( ISecureAuthorization Authorization,
		IBusModelServerObjFuncByRetTblIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByRetTblIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByRetTblIdx(argKey.getOptionalRetTableId());
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		final String S_ProcName = "deleteServerObjFuncByUNameIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByUNameIdx(argTableId,
		argName);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByUNameIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByUNameIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByUNameIdx(argKey.getRequiredTableId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		final String S_ProcName = "deleteServerObjFuncByMethTableIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethTableIdx(argTableId);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByMethTableIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByMethTableIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethTableIdx(argKey.getRequiredTableId());
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key MethCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "deleteServerObjFuncByMethCodeVisIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethCodeVisIdx(argCodeVis);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key MethCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethCodeVisIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByMethCodeVisIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethCodeVisIdx(argKey.getRequiredCodeVis());
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "deleteServerObjFuncByMethTableVisIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethTableVisIdx(argTableId,
		argCodeVis);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableVisIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByMethTableVisIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByMethTableVisIdx(argKey.getRequiredTableId(),
			argKey.getRequiredCodeVis());
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "deleteServerObjFuncByDefSchemaIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByDefSchemaIdx(argDefSchemaId);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByDefSchemaIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByDefSchemaIdx(argKey.getOptionalDefSchemaId());
	}

	/**
	 *	Delete the ServerObjFunc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByIdIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the ServerObjFunc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	@Override
	public void deleteServerObjFuncByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "deleteServerObjFuncByTenantIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByTenantIdx(argTenantId);
	}


	/**
	 *	Delete the ServerObjFunc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteServerObjFuncByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteServerObjFuncByTenantIdx";
		boolean permissionGranted = canDeleteServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getServerObjFuncService().deleteByTenantIdx(argKey.getRequiredTenantId());
	}


	/**
	 *	Read the derived ServerObjFunc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelServerObjFunc readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived ServerObjFunc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelServerObjFunc lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all ServerObjFunc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findAll();
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived ServerObjFunc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelServerObjFunc readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readserverobjfunc")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByTenantIdx(argTenantId);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived ServerObjFunc record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelServerObjFunc readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelServerObjFunc retval = schema.getJpaHooksSchema().getServerObjFuncService().findByUNameIdx(argTableId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readserverobjfunc")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		final String S_ProcName = "readDerivedByMethTableIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByMethTableIdx(argTableId);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key MethCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "readDerivedByMethCodeVisIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByMethCodeVisIdx(argCodeVis);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key MethTableVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "readDerivedByMethTableVisIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByMethTableVisIdx(argTableId,
		argCodeVis);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByDefSchemaIdx(argDefSchemaId);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived ServerObjFunc record instances identified by the duplicate key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelServerObjFunc[] readDerivedByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRetTableId )
	{
		final String S_ProcName = "readDerivedByRetTblIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaServerObjFunc> retlist = schema.getJpaHooksSchema().getServerObjFuncService().findByRetTblIdx(argRetTableId);
		IBusModelServerObjFunc[] retset = new IBusModelServerObjFunc[retlist.size()];
		int idx = 0;
		for (BusModelJpaServerObjFunc cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the specific ServerObjFunc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific ServerObjFunc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific ServerObjFunc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ServerObjFunc instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelServerObjFunc[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific ServerObjFunc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "readRecByTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByTenantIdx");
	}

	/**
	 *	Read the specific ServerObjFunc record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		final String S_ProcName = "readRecByMethTableIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByMethTableIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key MethCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "readRecByMethCodeVisIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByMethCodeVisIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key MethTableVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		final String S_ProcName = "readRecByMethTableVisIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByMethTableVisIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readRecByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByDefSchemaIdx");
	}

	/**
	 *	Read an array of the specific ServerObjFunc record instances identified by the duplicate key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelServerObjFunc[] readRecByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRetTableId )
	{
		final String S_ProcName = "readRecByRetTblIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadServerObjFunc(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readserverobjfunc", IBusModelSchema.SCHEMA_NAME, IBusModelServerObjFuncTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByRetTblIdx");
	}
}
