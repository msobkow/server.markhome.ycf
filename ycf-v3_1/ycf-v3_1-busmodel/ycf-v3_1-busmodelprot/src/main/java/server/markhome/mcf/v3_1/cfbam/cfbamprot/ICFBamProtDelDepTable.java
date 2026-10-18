
// Description: Java 25 protlic DbIO interface for DelDep.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprot;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprotobj.*;

/*
 *	CFBamProtDelDepTable protlic database interface for DelDep has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamProtDelDepTable
extends ICFBamProtScopeTable,
	ICFBamPubDelDepTable
{
	public static final String TABLE_NAME = "DelDep";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtDelDep protcreateDelDep( ICFSecPubAuthorization Authorization,
		ICFBamProtDelDep rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtDelDep protcreateDelDep( ICFSecPubAuthorization Authorization,
		ICFBamPubDelDep rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtDelDep protupdateDelDep( ICFSecPubAuthorization Authorization,
		ICFBamProtDelDep rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtDelDep protupdateDelDep( ICFSecPubAuthorization Authorization,
		ICFBamPubDelDep rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteDelDep( ICFSecPubAuthorization Authorization,
		ICFBamProtDelDep rec );
	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 */
	public void protdeleteDelDepByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtDelDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubDelDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 */
	public void protdeleteDelDepByDelDepIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argRelationId );

	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByDelDepIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtDelDepByDelDepIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByDelDepIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubDelDepByDelDepIdxKey argKey );
	/**
	 *	Delete the DelDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteDelDepByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argKey );
	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 */
	public void protdeleteDelDepByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argTenantId );

	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByTenantIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtScopeByTenantIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDelDepByTenantIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubScopeByTenantIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteDelDep( ICFSecPubAuthorization Authorization,
		ICFBamPubDelDep rec );


	/**
	 *	Read the derived DelDep record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDelDep protreadDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived DelDep record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDelDep protlockDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all DelDep instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamProtDelDep[] protreadProtAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived DelDep record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDelDep protreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDelDep[] protreadDerivedByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDelDep[] protreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDelDep[] protreadDerivedByDelDepIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 RelationId );

	/**
	 *	Read the specific DelDep record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep protreadRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific DelDep record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep protlockRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific DelDep record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DelDep instances in the database accessible for the Authorization.
	 */
	public ICFBamProtDelDep[] protreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific DelDep record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep protreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep[] protreadRecByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep[] protreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDep[] protreadRecByDelDepIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 RelationId );
}
