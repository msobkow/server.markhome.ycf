
// Description: Java 25 DbIO interface for TableInfo.

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

package server.markhome.ycf.v3_1.secure.secure;

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
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	SecureTableInfoTable database interface for TableInfo has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureTableInfoTable
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
	ISecureTableInfo createTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureTableInfo updateTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo rec );
	/**
	 *	Delete the TableInfo instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTableInfoByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey );
	/**
	 *	Delete the TableInfo instances identified by the key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoByTableNameIdx( ISecureAuthorization Authorization,
		String argTableName );

	/**
	 *	Delete the TableInfo instances identified by the key TableNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableInfoByTableNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoByTableNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySuperNameIdx( ISecureAuthorization Authorization,
		String argSuperName );

	/**
	 *	Delete the TableInfo instances identified by the key SuperNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableInfoBySuperNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySuperNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaNameIdx( ISecureAuthorization Authorization,
		String argSchemaName );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableInfoBySchemaNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaNameIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		String argSchemaName,
		int argBackingClassCode );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaBkCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableInfoBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaBkCodeIdxKey argKey );
	/**
	 *	Delete the TableInfo instances identified by the key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		int argRuntimeClassCode );

	/**
	 *	Delete the TableInfo instances identified by the key SchemaRTCodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableInfoBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaRTCodeIdxKey argKey );


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
	ISecureTableInfo readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey );

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
	ISecureTableInfo lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey );

	/**
	 *	Read all TableInfo instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureTableInfo[] readAllDerived( ISecureAuthorization Authorization );

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
	ISecureTableInfo readDerivedByIdIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readDerivedByTableNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo[] readDerivedBySuperNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo[] readDerivedBySchemaNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readDerivedBySchemaBkCodeIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readDerivedBySchemaRTCodeIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey );

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
	ISecureTableInfo lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey );

	/**
	 *	Read all the specific TableInfo record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TableInfo instances in the database accessible for the Authorization.
	 */
	ISecureTableInfo[] readAllRec( ISecureAuthorization Authorization );

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
	ISecureTableInfo readRecByIdIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readRecByTableNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo[] readRecBySuperNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo[] readRecBySchemaNameIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readRecBySchemaBkCodeIdx( ISecureAuthorization Authorization,
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
	ISecureTableInfo readRecBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		int RuntimeClassCode );
}
