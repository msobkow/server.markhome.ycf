
// Description: Java 25 DbIO implementation for DbKeyHash512Def.

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
 *	BusModelJpaDbKeyHash512DefTable database implementation for DbKeyHash512Def
 */
public class BusModelJpaDbKeyHash512DefTable implements IBusModelDbKeyHash512DefTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaDbKeyHash512DefTable(IBusModelSchema schema) {
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

	protected boolean canCreateDbKeyHash512Def(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createdbkeyhash512def");
		}
		return( permissionGranted );
	}

	protected boolean canReadDbKeyHash512Def(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readdbkeyhash512def");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateDbKeyHash512Def(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updatedbkeyhash512def");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteDbKeyHash512Def(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deletedbkeyhash512def");
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
	public IBusModelDbKeyHash512Def createDbKeyHash512Def( ISecureAuthorization Authorization,
		IBusModelDbKeyHash512Def rec )
	{
		final String S_ProcName = "createDbKeyHash512Def";
		boolean permissionGranted = canCreateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createDbKeyHash512Def", 1, "rec");
		}
		else if (rec instanceof BusModelJpaDbKeyHash512Def) {
			BusModelJpaDbKeyHash512Def jparec = (BusModelJpaDbKeyHash512Def)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createDbKeyHash512Def", "rec", rec, "BusModelJpaDbKeyHash512Def");
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
	public IBusModelDbKeyHash512Def updateDbKeyHash512Def( ISecureAuthorization Authorization,
		IBusModelDbKeyHash512Def rec )
	{
		final String S_ProcName = "updateDbKeyHash512Def";
		boolean permissionGranted = canUpdateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateDbKeyHash512Def", 1, "rec");
		}
		else if (rec instanceof BusModelJpaDbKeyHash512Def) {
			BusModelJpaDbKeyHash512Def jparec = (BusModelJpaDbKeyHash512Def)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateDbKeyHash512Def", "rec", rec, "BusModelJpaDbKeyHash512Def");
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
	public void deleteDbKeyHash512Def( ISecureAuthorization Authorization,
		IBusModelDbKeyHash512Def rec )
	{
		final String S_ProcName = "deleteDbKeyHash512Def";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaDbKeyHash512Def) {
			BusModelJpaDbKeyHash512Def jparec = (BusModelJpaDbKeyHash512Def)rec;
			schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteDbKeyHash512Def", "rec", rec, "BusModelJpaDbKeyHash512Def");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteDbKeyHash512Def");
	}

	/**
	 *	Delete the DbKeyHash512Def instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByIdIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByUNameIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByUNameIdx(argScopeId,
		argName);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByUNameIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByUNameIdx(argKey.getRequiredScopeId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByScopeIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByScopeIdx(argScopeId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByScopeIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByScopeIdx(argKey.getRequiredScopeId());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByDefSchemaIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByDefSchemaIdx(argDefSchemaId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByDefSchemaIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByDefSchemaIdx(argKey.getOptionalDefSchemaId());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByPrevIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByPrevIdx(argPrevId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByPrevIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByPrevIdx(argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByNextIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByNextIdx(argNextId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByNextIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByNextIdx(argKey.getOptionalNextId());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByContPrevIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByContPrevIdx(argScopeId,
		argPrevId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByContPrevIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByContPrevIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 */
	@Override
	public void deleteDbKeyHash512DefByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByContNextIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByContNextIdx(argScopeId,
		argNextId);
	}


	/**
	 *	Delete the DbKeyHash512Def instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteDbKeyHash512DefByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash512DefByContNextIdx";
		boolean permissionGranted = canDeleteDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getDbKeyHash512DefService().deleteByContNextIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalNextId());
	}


	/**
	 *	Read the derived DbKeyHash512Def record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash512Def instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelDbKeyHash512Def readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived DbKeyHash512Def record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash512Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelDbKeyHash512Def lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all DbKeyHash512Def instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findAll();
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived DbKeyHash512Def record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelDbKeyHash512Def readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerScope().getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readdbkeyhash512def")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read the derived DbKeyHash512Def record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelDbKeyHash512Def readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelDbKeyHash512Def retval = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByUNameIdx(argScopeId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerScope().getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readdbkeyhash512def")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByScopeIdx(argScopeId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByDefSchemaIdx(argDefSchemaId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByPrevIdx(argPrevId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByNextIdx(argNextId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByContPrevIdx(argScopeId,
		argPrevId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived DbKeyHash512Def record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaDbKeyHash512Def> retlist = schema.getJpaHooksSchema().getDbKeyHash512DefService().findByContNextIdx(argScopeId,
		argNextId);
		IBusModelDbKeyHash512Def[] retset = new IBusModelDbKeyHash512Def[retlist.size()];
		int idx = 0;
		for (BusModelJpaDbKeyHash512Def cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the specific DbKeyHash512Def record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash512Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific DbKeyHash512Def record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash512Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific DbKeyHash512Def record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DbKeyHash512Def instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific DbKeyHash512Def record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read the specific DbKeyHash512Def record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readRecByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByScopeIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readRecByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByDefSchemaIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByPrevIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByNextIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContPrevIdx");
	}

	/**
	 *	Read an array of the specific DbKeyHash512Def record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash512Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelDbKeyHash512Def[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadDbKeyHash512Def(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readdbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContNextIdx");
	}

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelDbKeyHash512Def moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecUp";
		boolean permissionGranted = canUpdateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecUp");
	}

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelDbKeyHash512Def moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecDown";
		boolean permissionGranted = canUpdateDbKeyHash512Def(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatedbkeyhash512def", IBusModelSchema.SCHEMA_NAME, IBusModelDbKeyHash512DefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecDown");
	}
}
