
// Description: Java JPA Factory interface for TableInfo.

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
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	ISecureTableInfoFactory interface for TableInfo
 */
public interface ISecureTableInfoFactory extends ISecureProtTableInfoFactory
{

	/**
	 *	Allocate a primary history key for TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureTableInfoHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for TableInfo instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtTableInfoHPKey asProtected(ISecureTableInfoHPKey src);

	/**
	 *	Allocate a public primary history key for TableInfo instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubTableInfoHPKey asPublic(ISecureTableInfoHPKey src);

	/**
	 *	Allocate a TableNameIdx key over TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoByTableNameIdxKey newByTableNameIdxKey();

	/**
	 *	Allocate a protected TableNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoByTableNameIdxKey asProtected(ISecureTableInfoByTableNameIdxKey src);

	/**
	 *	Allocate a public TableNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoByTableNameIdxKey asPublic(ISecureTableInfoByTableNameIdxKey src);

	/**
	 *	Allocate a SuperNameIdx key over TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoBySuperNameIdxKey newBySuperNameIdxKey();

	/**
	 *	Allocate a protected SuperNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySuperNameIdxKey asProtected(ISecureTableInfoBySuperNameIdxKey src);

	/**
	 *	Allocate a public SuperNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySuperNameIdxKey asPublic(ISecureTableInfoBySuperNameIdxKey src);

	/**
	 *	Allocate a SchemaNameIdx key over TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoBySchemaNameIdxKey newBySchemaNameIdxKey();

	/**
	 *	Allocate a protected SchemaNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaNameIdxKey asProtected(ISecureTableInfoBySchemaNameIdxKey src);

	/**
	 *	Allocate a public SchemaNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaNameIdxKey asPublic(ISecureTableInfoBySchemaNameIdxKey src);

	/**
	 *	Allocate a SchemaBkCodeIdx key over TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoBySchemaBkCodeIdxKey newBySchemaBkCodeIdxKey();

	/**
	 *	Allocate a protected SchemaBkCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaBkCodeIdxKey asProtected(ISecureTableInfoBySchemaBkCodeIdxKey src);

	/**
	 *	Allocate a public SchemaBkCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaBkCodeIdxKey asPublic(ISecureTableInfoBySchemaBkCodeIdxKey src);

	/**
	 *	Allocate a SchemaRTCodeIdx key over TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoBySchemaRTCodeIdxKey newBySchemaRTCodeIdxKey();

	/**
	 *	Allocate a protected SchemaRTCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaRTCodeIdxKey asProtected(ISecureTableInfoBySchemaRTCodeIdxKey src);

	/**
	 *	Allocate a public SchemaRTCodeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaRTCodeIdxKey asPublic(ISecureTableInfoBySchemaRTCodeIdxKey src);

	/**
	 *	Allocate a TableInfo interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfo newRec();

	/**
	 *	Allocate a protected TableInfo interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfo asProtected(ISecureTableInfo src);

	/**
	 *	Allocate a public TableInfo interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfo asPublic(ISecureTableInfo src);

	/**
	 *	Allocate a TableInfo history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureTableInfoH newHRec();

	/**
	 *	Allocate a protected TableInfo history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoH asProtected(ISecureTableInfoH src);

	/**
	 *	Allocate a public TableInfo history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoH asPublic(ISecureTableInfoH src);

}
