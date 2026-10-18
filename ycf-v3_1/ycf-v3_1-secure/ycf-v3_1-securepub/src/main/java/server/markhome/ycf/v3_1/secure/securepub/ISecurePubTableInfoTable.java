
// Description: Java 25 public DbIO interface for TableInfo.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.securepub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

/*
 *	SecurePubTableInfoTable public database interface for TableInfo has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecurePubTableInfoTable
{
	public static final String TABLE_NAME = "TableInfo";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecurePubTableInfo pubcreateTableInfo( ISecurePubAuthorization Authorization,
		ISecurePubTableInfo rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecurePubTableInfo pubupdateTableInfo( ISecurePubAuthorization Authorization,
		ISecurePubTableInfo rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteTableInfo( ISecurePubAuthorization Authorization,
		ISecurePubTableInfo rec );
	/**
	 *	Delete the TableInfo instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteTableInfoByIdIdx( ISecurePubAuthorization Authorization,
		Integer argKey );
	/**
	 *	Delete the TableInfo instances identified by the key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 */
	public void pubdeleteTableInfoByTableNameIdx( ISecurePubAuthorization Authorization,
		String argTableName );

	/**
	 *	Delete the TableInfo instances identified by the key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteTableInfoByTableNameIdx( ISecurePubAuthorization Authorization,
		ISecurePubTableInfoByTableNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 */
	public void pubdeleteTableInfoBySuperNameIdx( ISecurePubAuthorization Authorization,
		String argSuperName );

	/**
	 *	Delete the TableInfo instances identified by the key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteTableInfoBySuperNameIdx( ISecurePubAuthorization Authorization,
		ISecurePubTableInfoBySuperNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 */
	public void pubdeleteTableInfoBySchemaNameIdx( ISecurePubAuthorization Authorization,
		String argSchemaName );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteTableInfoBySchemaNameIdx( ISecurePubAuthorization Authorization,
		ISecurePubTableInfoBySchemaNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	public void pubdeleteTableInfoBySchemaBkCodeIdx( ISecurePubAuthorization Authorization,
		String argSchemaName,
		int argBackingClassCode );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteTableInfoBySchemaBkCodeIdx( ISecurePubAuthorization Authorization,
		ISecurePubTableInfoBySchemaBkCodeIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	public void pubdeleteTableInfoBySchemaRTCodeIdx( ISecurePubAuthorization Authorization,
		int argRuntimeClassCode );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteTableInfoBySchemaRTCodeIdx( ISecurePubAuthorization Authorization,
		ISecurePubTableInfoBySchemaRTCodeIdxKey argKey );


	/**
	 *	Read the derived TableInfo record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TableInfo instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo pubreadDerived( ISecurePubAuthorization Authorization,
		Integer PKey );

	/**
	 *	Lock the derived TableInfo record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TableInfo instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo publockDerived( ISecurePubAuthorization Authorization,
		Integer PKey );

	/**
	 *	Read all TableInfo instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecurePubTableInfo[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived TableInfo record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableInfoId	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		int TableInfoId );

	/**
	 *	Read the derived TableInfo record instance identified by the unique key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo pubreadDerivedByTableNameIdx( ISecurePubAuthorization Authorization,
		String TableName );

	/**
	 *	Read an array of the derived TableInfo record instances identified by the duplicate key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecurePubTableInfo[] pubreadDerivedBySuperNameIdx( ISecurePubAuthorization Authorization,
		String SuperName );

	/**
	 *	Read an array of the derived TableInfo record instances identified by the duplicate key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecurePubTableInfo[] pubreadDerivedBySchemaNameIdx( ISecurePubAuthorization Authorization,
		String SchemaName );

	/**
	 *	Read the derived TableInfo record instance identified by the unique key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo pubreadDerivedBySchemaBkCodeIdx( ISecurePubAuthorization Authorization,
		String SchemaName,
		int BackingClassCode );

	/**
	 *	Read the derived TableInfo record instance identified by the unique key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubTableInfo pubreadDerivedBySchemaRTCodeIdx( ISecurePubAuthorization Authorization,
		int RuntimeClassCode );

	/**
	 *	Read the specific TableInfo record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TableInfo instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo pubreadRec( ISecurePubAuthorization Authorization,
		Integer PKey );

	/**
	 *	Lock the specific TableInfo record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TableInfo instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo publockRec( ISecurePubAuthorization Authorization,
		Integer PKey );

	/**
	 *	Read all the specific TableInfo record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TableInfo instances in the database accessible for the Authorization.
	 */
	public ISecurePubTableInfo[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific TableInfo record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableInfoId	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		int TableInfoId );

	/**
	 *	Read the specific TableInfo record instance identified by the unique key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo pubreadRecByTableNameIdx( ISecurePubAuthorization Authorization,
		String TableName );

	/**
	 *	Read an array of the specific TableInfo record instances identified by the duplicate key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo[] pubreadRecBySuperNameIdx( ISecurePubAuthorization Authorization,
		String SuperName );

	/**
	 *	Read an array of the specific TableInfo record instances identified by the duplicate key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo[] pubreadRecBySchemaNameIdx( ISecurePubAuthorization Authorization,
		String SchemaName );

	/**
	 *	Read the specific TableInfo record instance identified by the unique key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo pubreadRecBySchemaBkCodeIdx( ISecurePubAuthorization Authorization,
		String SchemaName,
		int BackingClassCode );

	/**
	 *	Read the specific TableInfo record instance identified by the unique key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubTableInfo pubreadRecBySchemaRTCodeIdx( ISecurePubAuthorization Authorization,
		int RuntimeClassCode );
}
