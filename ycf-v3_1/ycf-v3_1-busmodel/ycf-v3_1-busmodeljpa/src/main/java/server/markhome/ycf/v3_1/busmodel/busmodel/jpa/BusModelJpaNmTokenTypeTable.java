
// Description: Java 25 DbIO implementation for NmTokenType.

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
 *	BusModelJpaNmTokenTypeTable database implementation for NmTokenType
 */
public class BusModelJpaNmTokenTypeTable implements IBusModelNmTokenTypeTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaNmTokenTypeTable(IBusModelSchema schema) {
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

	protected boolean canCreateNmTokenType(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createnmtokentype");
		}
		return( permissionGranted );
	}

	protected boolean canReadNmTokenType(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readnmtokentype");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateNmTokenType(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updatenmtokentype");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteNmTokenType(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deletenmtokentype");
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
	public IBusModelNmTokenType createNmTokenType( ISecureAuthorization Authorization,
		IBusModelNmTokenType rec )
	{
		final String S_ProcName = "createNmTokenType";
		boolean permissionGranted = canCreateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createNmTokenType", 1, "rec");
		}
		else if (rec instanceof BusModelJpaNmTokenType) {
			BusModelJpaNmTokenType jparec = (BusModelJpaNmTokenType)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createNmTokenType", "rec", rec, "BusModelJpaNmTokenType");
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
	public IBusModelNmTokenType updateNmTokenType( ISecureAuthorization Authorization,
		IBusModelNmTokenType rec )
	{
		final String S_ProcName = "updateNmTokenType";
		boolean permissionGranted = canUpdateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateNmTokenType", 1, "rec");
		}
		else if (rec instanceof BusModelJpaNmTokenType) {
			BusModelJpaNmTokenType jparec = (BusModelJpaNmTokenType)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateNmTokenType", "rec", rec, "BusModelJpaNmTokenType");
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
	public void deleteNmTokenType( ISecureAuthorization Authorization,
		IBusModelNmTokenType rec )
	{
		final String S_ProcName = "deleteNmTokenType";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaNmTokenType) {
			BusModelJpaNmTokenType jparec = (BusModelJpaNmTokenType)rec;
			schema.getJpaHooksSchema().getNmTokenTypeService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteNmTokenType", "rec", rec, "BusModelJpaNmTokenType");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteNmTokenType");
	}

	/**
	 *	Delete the NmTokenType instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "deleteNmTokenTypeBySchemaIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteBySchemaIdx(argSchemaDefId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelNmTokenTypeBySchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeBySchemaIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteBySchemaIdx(argKey.getRequiredSchemaDefId());
	}

	/**
	 *	Delete the NmTokenType instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByIdIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the NmTokenType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteNmTokenTypeByUNameIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByUNameIdx(argScopeId,
		argName);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByUNameIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByUNameIdx(argKey.getRequiredScopeId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "deleteNmTokenTypeByScopeIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByScopeIdx(argScopeId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByScopeIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByScopeIdx(argKey.getRequiredScopeId());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "deleteNmTokenTypeByDefSchemaIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByDefSchemaIdx(argDefSchemaId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByDefSchemaIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByDefSchemaIdx(argKey.getOptionalDefSchemaId());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteNmTokenTypeByPrevIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByPrevIdx(argPrevId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByPrevIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByPrevIdx(argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteNmTokenTypeByNextIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByNextIdx(argNextId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByNextIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByNextIdx(argKey.getOptionalNextId());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "deleteNmTokenTypeByContPrevIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByContPrevIdx(argScopeId,
		argPrevId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByContPrevIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByContPrevIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId());
	}

	/**
	 *	Delete the NmTokenType instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 */
	@Override
	public void deleteNmTokenTypeByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "deleteNmTokenTypeByContNextIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByContNextIdx(argScopeId,
		argNextId);
	}


	/**
	 *	Delete the NmTokenType instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteNmTokenTypeByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenTypeByContNextIdx";
		boolean permissionGranted = canDeleteNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deletenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getNmTokenTypeService().deleteByContNextIdx(argKey.getRequiredScopeId(),
			argKey.getOptionalNextId());
	}


	/**
	 *	Read the derived NmTokenType record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the NmTokenType instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelNmTokenType readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived NmTokenType record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the NmTokenType instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelNmTokenType lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all NmTokenType instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findAll();
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived NmTokenType record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelNmTokenType readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerSchemaDef().getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readnmtokentype")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read the derived NmTokenType record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelNmTokenType readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelNmTokenType retval = schema.getJpaHooksSchema().getNmTokenTypeService().findByUNameIdx(argScopeId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredContainerSchemaDef().getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readnmtokentype")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByScopeIdx(argScopeId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByDefSchemaIdx(argDefSchemaId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByPrevIdx(argPrevId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByNextIdx(argNextId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByContPrevIdx(argScopeId,
		argPrevId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findByContNextIdx(argScopeId,
		argNextId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived NmTokenType record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelNmTokenType[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "readDerivedBySchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaNmTokenType> retlist = schema.getJpaHooksSchema().getNmTokenTypeService().findBySchemaIdx(argSchemaDefId);
		IBusModelNmTokenType[] retset = new IBusModelNmTokenType[retlist.size()];
		int idx = 0;
		for (BusModelJpaNmTokenType cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the specific NmTokenType record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the NmTokenType instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific NmTokenType record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the NmTokenType instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific NmTokenType record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific NmTokenType instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelNmTokenType[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific NmTokenType record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read the specific NmTokenType record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		final String S_ProcName = "readRecByScopeIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByScopeIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		final String S_ProcName = "readRecByDefSchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByDefSchemaIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByPrevIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByNextIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		final String S_ProcName = "readRecByContPrevIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContPrevIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		final String S_ProcName = "readRecByContNextIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByContNextIdx");
	}

	/**
	 *	Read an array of the specific NmTokenType record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelNmTokenType[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		final String S_ProcName = "readRecBySchemaIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadNmTokenType(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readnmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecBySchemaIdx");
	}

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelNmTokenType moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecUp";
		boolean permissionGranted = canUpdateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecUp");
	}

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	@Override
	public IBusModelNmTokenType moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId,
		int revision )
	{
		final String S_ProcName = "moveRecDown";
		boolean permissionGranted = canUpdateNmTokenType(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updatenmtokentype", IBusModelSchema.SCHEMA_NAME, IBusModelNmTokenTypeTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "moveRecDown");
	}
}
