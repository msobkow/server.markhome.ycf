
// Description: Java 25 DbIO implementation for UuidDef.

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
 *	BusModelJpaUuidDefTable database implementation for UuidDef
 */
public class BusModelJpaUuidDefTable implements IBusModelUuidDefTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaUuidDefTable(IBusModelSchema schema) {
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

	protected boolean canCreateUuidDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createuuiddef");
		}
		return( permissionGranted );
	}

	protected boolean canReadUuidDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readuuiddef");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateUuidDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updateuuiddef");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteUuidDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deleteuuiddef");
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
	public IBusModelUuidDef createUuidDef( ISecureAuthorization Authorization,
		IBusModelUuidDef rec )
	{
		final String S_ProcName = "createUuidDef";
		boolean permissionGranted = canCreateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createUuidDef", 1, "rec");
		}
		else if (rec instanceof BusModelJpaUuidDef) {
			BusModelJpaUuidDef jparec = (BusModelJpaUuidDef)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createUuidDef", "rec", rec, "BusModelJpaUuidDef");
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
	public IBusModelUuidDef updateUuidDef( ISecureAuthorization Authorization,
		IBusModelUuidDef rec )
	{
		final String S_ProcName = "updateUuidDef";
		boolean permissionGranted = canUpdateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateUuidDef", 1, "rec");
		}
		else if (rec instanceof BusModelJpaUuidDef) {
			BusModelJpaUuidDef jparec = (BusModelJpaUuidDef)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateUuidDef", "rec", rec, "BusModelJpaUuidDef");
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
	public void deleteUuidDef( ISecureAuthorization Authorization,
		IBusModelUuidDef rec )
	{
		final String S_ProcName = "deleteUuidDef";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaUuidDef) {
			BusModelJpaUuidDef jparec = (BusModelJpaUuidDef)rec;
			schema.getJpaHooksSchema().getUuidDefService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteUuidDef", "rec", rec, "BusModelJpaUuidDef");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteUuidDef");
	}

	/**
	 *	Delete the UuidDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteUuidDefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteUuidDefByIdIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the UuidDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteUuidDefByUNameIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByUNameIdx(argScopeId,
		argName);
	}


	/**
	 *	Delete the UuidDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByUNameIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByUNameIdx(argKey.getRequiredScopeId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the UuidDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "deleteUuidDefByScopeIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByScopeIdx(argScopeId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByScopeIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByScopeIdx(argKey.getRequiredScopeId());
	}

	/**
	 *	Delete the UuidDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "deleteUuidDefByDefSchemaIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByDefSchemaIdx(argDefSchemaId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByDefSchemaIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByDefSchemaIdx(argKey.getOptionalDefSchemaId());
	}

	/**
	 *	Delete the UuidDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteUuidDefByPrevIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByPrevIdx(argPrevId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByPrevIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByPrevIdx(argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the UuidDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteUuidDefByNextIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByNextIdx(argNextId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByNextIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByNextIdx(argKey.getOptionalNextId());
	}

	/**
	 *	Delete the UuidDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteUuidDefByContPrevIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByContPrevIdx(argScopeId,
		argPrevId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByContPrevIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByContPrevIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the UuidDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuidDefByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteUuidDefByContNextIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByContNextIdx(argScopeId,
		argNextId);
	}


	/**
	 *	Delete the UuidDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuidDefByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByContNextIdx";
		boolean permissionGranted = canDeleteUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuidDefService().deleteByContNextIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalNextId());
	}


	/**
	 *	Read the derived UuidDef record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidDef instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuidDef readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived UuidDef record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuidDef lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all UuidDef instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findAll();
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived UuidDef record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuidDef readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerScope().getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readuuiddef")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read the derived UuidDef record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuidDef readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelUuidDef retval = schema.getJpaHooksSchema().getUuidDefService().findByUNameIdx(argScopeId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerScope().getRequiredOwnerTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readuuiddef")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByScopeIdx(argScopeId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByDefSchemaIdx(argDefSchemaId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByPrevIdx(argPrevId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByNextIdx(argNextId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByContPrevIdx(argScopeId,
		argPrevId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived UuidDef record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuidDef[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuidDef> retlist = schema.getJpaHooksSchema().getUuidDefService().findByContNextIdx(argScopeId,
		argNextId);
		IBusModelUuidDef[] retset = new IBusModelUuidDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuidDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the specific UuidDef record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific UuidDef record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific UuidDef record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific UuidDef instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelUuidDef[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific UuidDef record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read the specific UuidDef record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readRecByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByScopeIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readRecByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByDefSchemaIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByPrevIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByNextIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContPrevIdx");
	}

	/**
	 *	Read an array of the specific UuidDef record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuidDef[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuidDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContNextIdx");
	}

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelUuidDef moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecUp";
		boolean permissionGranted = canUpdateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecUp");
	}

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelUuidDef moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecDown";
		boolean permissionGranted = canUpdateUuidDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuiddef", IBusModelSchema.SCHEMA_NAME, IBusModelUuidDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecDown");
	}
}
