
// Description: Java 25 DbIO implementation for SchemaDef.

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
 *	BusModelJpaSchemaDefTable database implementation for SchemaDef
 */
public class BusModelJpaSchemaDefTable implements IBusModelSchemaDefTable
{
	protected BusModelJpaSchema schema;


	public BusModelJpaSchemaDefTable(IBusModelSchema schema) {
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

	protected boolean canCreateSchemaDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "createschemadef");
		}
		return( permissionGranted );
	}

	protected boolean canReadSchemaDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), Authorization.getSecClusterId(), Authorization.getSecTenantId(), "readschemadef");
		}
		return( permissionGranted );
	}

	protected boolean canUpdateSchemaDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "updateschemadef");
		}
		return( permissionGranted );
	}

	protected boolean canDeleteSchemaDef(String S_ProcName, ISecureAuthorization Authorization) {
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
			permissionGranted = ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), "deleteschemadef");
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
	public IBusModelSchemaDef createSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef rec )
	{
		final String S_ProcName = "createSchemaDef";
		boolean permissionGranted = canCreateSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "createschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "createSchemaDef", 1, "rec");
		}
		else if (rec instanceof BusModelJpaSchemaDef) {
			BusModelJpaSchemaDef jparec = (BusModelJpaSchemaDef)rec;
			jparec.setCreatedAt(LocalDateTime.now());
			jparec.setUpdatedAt(jparec.getCreatedAt());
			jparec.setCreatedByUserId(Authorization.getSecUserId());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().create(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "createSchemaDef", "rec", rec, "BusModelJpaSchemaDef");
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
	public IBusModelSchemaDef updateSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef rec )
	{
		final String S_ProcName = "updateSchemaDef";
		boolean permissionGranted = canUpdateSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			throw new YCFNullArgumentException(getClass(), "updateSchemaDef", 1, "rec");
		}
		else if (rec instanceof BusModelJpaSchemaDef) {
			BusModelJpaSchemaDef jparec = (BusModelJpaSchemaDef)rec;
			jparec.setUpdatedAt(LocalDateTime.now());
			jparec.setUpdatedByUserId(Authorization.getSecUserId());
			BusModelJpaSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().update(jparec);
		return(retval);
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "updateSchemaDef", "rec", rec, "BusModelJpaSchemaDef");
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
	public void deleteSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef rec )
	{
		final String S_ProcName = "deleteSchemaDef";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		if (rec == null) {
			return;
		}
		if (rec instanceof BusModelJpaSchemaDef) {
			BusModelJpaSchemaDef jparec = (BusModelJpaSchemaDef)rec;
			schema.getJpaHooksSchema().getSchemaDefService().deleteByIdIdx(jparec.getPKey());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "deleteSchemaDef", "rec", rec, "BusModelJpaSchemaDef");
		}

		throw new YCFNotImplementedYetException(getClass(), "deleteSchemaDef");
	}

	/**
	 *	Delete the SchemaDef instances identified by the key CTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId )
	{
		final String S_ProcName = "deleteSchemaDefByCTenantIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByCTenantIdx(argCTenantId);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key CTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByCTenantIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByCTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByCTenantIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByCTenantIdx(argKey.getRequiredCTenantId());
	}

	/**
	 *	Delete the SchemaDef instances identified by the key MinorVersionIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId )
	{
		final String S_ProcName = "deleteSchemaDefByMinorVersionIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByMinorVersionIdx(argMinorVersionId);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key MinorVersionIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByMinorVersionIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByMinorVersionIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByMinorVersionIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByMinorVersionIdx(argKey.getRequiredMinorVersionId());
	}

	/**
	 *	Delete the SchemaDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId,
		String argName )
	{
		final String S_ProcName = "deleteSchemaDefByUNameIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByUNameIdx(argMinorVersionId,
		argName);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByUNameIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByUNameIdx(argKey.getRequiredMinorVersionId(),
			argKey.getRequiredName());
	}

	/**
	 *	Delete the SchemaDef instances identified by the key AuthEMailIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argAuthorEMail )
	{
		final String S_ProcName = "deleteSchemaDefByAuthEMailIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByAuthEMailIdx(argCTenantId,
		argAuthorEMail);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key AuthEMailIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByAuthEMailIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByAuthEMailIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByAuthEMailIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByAuthEMailIdx(argKey.getRequiredCTenantId(),
			argKey.getRequiredAuthorEMail());
	}

	/**
	 *	Delete the SchemaDef instances identified by the key ProjectURLIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argProjectURL )
	{
		final String S_ProcName = "deleteSchemaDefByProjectURLIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByProjectURLIdx(argCTenantId,
		argProjectURL);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key ProjectURLIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByProjectURLIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByProjectURLIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByProjectURLIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByProjectURLIdx(argKey.getRequiredCTenantId(),
			argKey.getRequiredProjectURL());
	}

	/**
	 *	Delete the SchemaDef instances identified by the key PubURIIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argPublishURI )
	{
		final String S_ProcName = "deleteSchemaDefByPubURIIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByPubURIIdx(argCTenantId,
		argPublishURI);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key PubURIIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByPubURIIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByPubURIIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByPubURIIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByPubURIIdx(argKey.getRequiredCTenantId(),
			argKey.getRequiredPublishURI());
	}

	/**
	 *	Delete the SchemaDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	@Override
	public void deleteSchemaDefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteSchemaDefByIdIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByIdIdx(argKey);
	}

	/**
	 *	Delete the SchemaDef instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	@Override
	public void deleteSchemaDefByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "deleteSchemaDefByTenantIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByTenantIdx(argTenantId);
	}


	/**
	 *	Delete the SchemaDef instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	@Override
	public void deleteSchemaDefByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteSchemaDefByTenantIdx";
		boolean permissionGranted = canDeleteSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "deleteschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		schema.getJpaHooksSchema().getSchemaDefService().deleteByTenantIdx(argKey.getRequiredTenantId());
	}


	/**
	 *	Read the derived SchemaDef record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaDef instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelSchemaDef readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readDerived";
		boolean permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().find(PKey);
		return(retval);
	}

	/**
	 *	Lock the derived SchemaDef record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelSchemaDef lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockDerived";
		boolean permissionGranted = canUpdateSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		IBusModelSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().lockByIdIdx(PKey);
		return(retval);
	}

	/**
	 *	Read all SchemaDef instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		boolean permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findAll();
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived SchemaDef record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelSchemaDef readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().find(argId);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readschemadef")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived SchemaDef record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findByTenantIdx(argTenantId);
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived SchemaDef record instances identified by the duplicate key CTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readDerivedByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId )
	{
		final String S_ProcName = "readDerivedByCTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findByCTenantIdx(argCTenantId);
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived SchemaDef record instances identified by the duplicate key MinorVersionIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readDerivedByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId )
	{
		final String S_ProcName = "readDerivedByMinorVersionIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findByMinorVersionIdx(argMinorVersionId);
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived SchemaDef record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelSchemaDef readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId,
		String argName )
	{
		final String S_ProcName = "readDerivedByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().findByUNameIdx(argMinorVersionId,
		argName);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readschemadef")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read an array of the derived SchemaDef record instances identified by the duplicate key AuthEMailIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readDerivedByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argAuthorEMail )
	{
		final String S_ProcName = "readDerivedByAuthEMailIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findByAuthEMailIdx(argCTenantId,
		argAuthorEMail);
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read an array of the derived SchemaDef record instances identified by the duplicate key ProjectURLIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	@Override
	public IBusModelSchemaDef[] readDerivedByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argProjectURL )
	{
		final String S_ProcName = "readDerivedByProjectURLIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		List<BusModelJpaSchemaDef> retlist = schema.getJpaHooksSchema().getSchemaDefService().findByProjectURLIdx(argCTenantId,
		argProjectURL);
		IBusModelSchemaDef[] retset = new IBusModelSchemaDef[retlist.size()];
		int idx = 0;
		for (BusModelJpaSchemaDef cur: retlist) {
			retset[idx++] = cur;
		}
		return( retset );
	}

	/**
	 *	Read the derived SchemaDef record instance identified by the unique key PubURIIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	@Override
	public IBusModelSchemaDef readDerivedByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argPublishURI )
	{
		final String S_ProcName = "readDerivedByPubURIIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		IBusModelSchemaDef retval = schema.getJpaHooksSchema().getSchemaDefService().findByPubURIIdx(argCTenantId,
		argPublishURI);
		if(retval != null && !ISecureSchema.getSystemId().equals(Authorization.getSecUserId())) {
				ISecureTenant tenant = retval.getRequiredOwnerCTenant();
				ISecureCluster cluster = tenant.getRequiredContainerCluster();
			YCFDbKeyHash256 effClusterId = cluster.getRequiredId();
			YCFDbKeyHash256 effTenantId = tenant.getRequiredId();
			if (!ISecureSchema.getSecurityService().isMemberOfTenantGroup(Authorization.getSecUserId(), effClusterId, effTenantId, "readschemadef")) {
				retval = null;
			}
		}
		return(retval);
	}

	/**
	 *	Read the specific SchemaDef record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "readRec";
		boolean permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readRec");
	}

	/**
	 *	Lock the specific SchemaDef record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaDef instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		boolean permissionGranted = canUpdateSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "updateschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "lockRec");
	}

	/**
	 *	Read all the specific SchemaDef record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SchemaDef instances in the database accessible for the Authorization.
	 */
	@Override
	public IBusModelSchemaDef[] readAllRec( ISecureAuthorization Authorization ) {
		final String S_ProcName = "readAllRec";
		boolean permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}

		throw new YCFNotImplementedYetException(getClass(), "readAllRec");
	}


	/**
	 *	Read the specific SchemaDef record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argId )
	{
		final String S_ProcName = "readRecByIdIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByIdIdx");
	}

	/**
	 *	Read an array of the specific SchemaDef record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		final String S_ProcName = "readRecByTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByTenantIdx");
	}

	/**
	 *	Read an array of the specific SchemaDef record instances identified by the duplicate key CTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef[] readRecByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId )
	{
		final String S_ProcName = "readRecByCTenantIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByCTenantIdx");
	}

	/**
	 *	Read an array of the specific SchemaDef record instances identified by the duplicate key MinorVersionIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef[] readRecByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId )
	{
		final String S_ProcName = "readRecByMinorVersionIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByMinorVersionIdx");
	}

	/**
	 *	Read the specific SchemaDef record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId,
		String argName )
	{
		final String S_ProcName = "readRecByUNameIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByUNameIdx");
	}

	/**
	 *	Read an array of the specific SchemaDef record instances identified by the duplicate key AuthEMailIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef[] readRecByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argAuthorEMail )
	{
		final String S_ProcName = "readRecByAuthEMailIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByAuthEMailIdx");
	}

	/**
	 *	Read an array of the specific SchemaDef record instances identified by the duplicate key ProjectURLIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef[] readRecByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argProjectURL )
	{
		final String S_ProcName = "readRecByProjectURLIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByProjectURLIdx");
	}

	/**
	 *	Read the specific SchemaDef record instance identified by the unique key PubURIIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public IBusModelSchemaDef readRecByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argPublishURI )
	{
		final String S_ProcName = "readRecByPubURIIdx";
		boolean permissionGranted = false;
		if (!permissionGranted) {
			permissionGranted = canReadSchemaDef(S_ProcName, Authorization);
		}
		if (!permissionGranted) {
			throw new YCFPermissionDeniedException(getClass(), S_ProcName, "readschemadef", IBusModelSchema.SCHEMA_NAME, IBusModelSchemaDefTable.TABLE_NAME, Authorization.getAuthUuid6().toString());//"Permission '%4$s' denied attempting to access %1$s.%2$s for user id %3$s"
		}
		throw new YCFNotImplementedYetException(getClass(), "readRecByPubURIIdx");
	}
}
