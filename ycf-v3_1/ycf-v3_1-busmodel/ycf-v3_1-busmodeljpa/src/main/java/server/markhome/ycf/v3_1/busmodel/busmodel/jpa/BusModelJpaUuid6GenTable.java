
// Description: Java 25 DbIO implementation for Uuid6Gen.

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
 *	BusModelJpaUuid6GenTable database implementation for Uuid6Gen
 */
public class BusModelJpaUuid6GenTable implements IBusModelUuid6GenTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaUuid6GenTable(IBusModelSchema schema) {
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

	protected boolean canCreateUuid6Gen(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createuuid6gen");
		}
		return( permissionGranted );
	}

	protected boolean canReadUuid6Gen(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readuuid6gen");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateUuid6Gen(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updateuuid6gen");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteUuid6Gen(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deleteuuid6gen");
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
	public IBusModelUuid6Gen createUuid6Gen( ISecureAuthorization Authorization,
		IBusModelUuid6Gen rec )
	{
		final String S_ProcName = "createUuid6Gen";
		boolean permissionGranted = canCreateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createUuid6Gen", 1, "rec");
		}
		else if (rec instanceof BusModelJpaUuid6Gen) {
			BusModelJpaUuid6Gen jparec = (BusModelJpaUuid6Gen)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createUuid6Gen", "rec", rec, "BusModelJpaUuid6Gen");
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
	public IBusModelUuid6Gen updateUuid6Gen( ISecureAuthorization Authorization,
		IBusModelUuid6Gen rec )
	{
		final String S_ProcName = "updateUuid6Gen";
		boolean permissionGranted = canUpdateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateUuid6Gen", 1, "rec");
		}
		else if (rec instanceof BusModelJpaUuid6Gen) {
			BusModelJpaUuid6Gen jparec = (BusModelJpaUuid6Gen)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateUuid6Gen", "rec", rec, "BusModelJpaUuid6Gen");
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
	public void deleteUuid6Gen( ISecureAuthorization Authorization,
		IBusModelUuid6Gen rec )
	{
		final String S_ProcName = "deleteUuid6Gen";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaUuid6Gen) {
			BusModelJpaUuid6Gen jparec = (BusModelJpaUuid6Gen)rec;
			schema.getJpaHooksSchema().getUuid6GenService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteUuid6Gen", "rec", rec, "BusModelJpaUuid6Gen");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteUuid6Gen");
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "deleteUuid6GenBySchemaIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteBySchemaIdx(argSchemaDefId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelUuid6TypeBySchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenBySchemaIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteBySchemaIdx(argKey.getRequiredSchemaDefId());
	}

	/**
	 *	Delete the Uuid6Gen instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteUuid6GenByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteUuid6GenByIdIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteUuid6GenByUNameIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByUNameIdx(argScopeId,
		argName);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByUNameIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByUNameIdx(argKey.getRequiredScopeId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "deleteUuid6GenByScopeIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByScopeIdx(argScopeId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByScopeIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByScopeIdx(argKey.getRequiredScopeId());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "deleteUuid6GenByDefSchemaIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByDefSchemaIdx(argDefSchemaId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByDefSchemaIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByDefSchemaIdx(argKey.getOptionalDefSchemaId());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteUuid6GenByPrevIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByPrevIdx(argPrevId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByPrevIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByPrevIdx(argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteUuid6GenByNextIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByNextIdx(argNextId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByNextIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByNextIdx(argKey.getOptionalNextId());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteUuid6GenByContPrevIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByContPrevIdx(argScopeId,
		argPrevId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByContPrevIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByContPrevIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the Uuid6Gen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 */
	@Override
	public void deleteUuid6GenByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteUuid6GenByContNextIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByContNextIdx(argScopeId,
		argNextId);
	}


	/**
	 *	Delete the Uuid6Gen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteUuid6GenByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuid6GenByContNextIdx";
		boolean permissionGranted = canDeleteUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getUuid6GenService().deleteByContNextIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalNextId());
	}


	/**
	 *	Read the derived Uuid6Gen record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Uuid6Gen instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuid6Gen readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived Uuid6Gen record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Uuid6Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuid6Gen lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all Uuid6Gen instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findAll();
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived Uuid6Gen record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuid6Gen readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerSchemaDef().getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readuuid6gen")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read the derived Uuid6Gen record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelUuid6Gen readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelUuid6Gen retval = schema.getJpaHooksSchema().getUuid6GenService().findByUNameIdx(argScopeId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerSchemaDef().getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readuuid6gen")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByScopeIdx(argScopeId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByDefSchemaIdx(argDefSchemaId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByPrevIdx(argPrevId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByNextIdx(argNextId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByContPrevIdx(argScopeId,
		argPrevId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findByContNextIdx(argScopeId,
		argNextId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived Uuid6Gen record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelUuid6Gen[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "readDerivedBySchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaUuid6Gen> retlist = schema.getJpaHooksSchema().getUuid6GenService().findBySchemaIdx(argSchemaDefId);
		IBusModelUuid6Gen[] retset = new IBusModelUuid6Gen[retlist.size()];
		int idx = 0;
		for (BusModelJpaUuid6Gen cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the specific Uuid6Gen record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Uuid6Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific Uuid6Gen record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Uuid6Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific Uuid6Gen record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Uuid6Gen instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelUuid6Gen[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific Uuid6Gen record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read the specific Uuid6Gen record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readRecByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByScopeIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readRecByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByDefSchemaIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByPrevIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByNextIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContPrevIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContNextIdx");
	}

	/**
	 *	Read an array of the specific Uuid6Gen record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Uuid6Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelUuid6Gen[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "readRecBySchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadUuid6Gen(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecBySchemaIdx");
	}

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelUuid6Gen moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecUp";
		boolean permissionGranted = canUpdateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecUp");
	}

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelUuid6Gen moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecDown";
		boolean permissionGranted = canUpdateUuid6Gen(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateuuid6gen", IBusModelSchema.SCHEMA_NAME, IBusModelUuid6GenTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecDown");
	}
}
