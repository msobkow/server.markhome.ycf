
// Description: Java Protected Factory interface for TableInfo.

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

package server.markhome.ycf.v3_1.secure.secureprot;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	ISecureProtTableInfoFactory protected interface for TableInfo
 */
public interface ISecureProtTableInfoFactory extends ISecurePubTableInfoFactory
{

	/**
	 *	Allocate a protected primary history key for TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	ISecureProtTableInfoHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for TableInfo instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ISecurePubTableInfoHPKey asPublic(ISecureProtTableInfoHPKey src);

	/**
	 *	Allocate a protected TableNameIdx key over protected TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoByTableNameIdxKey newProtByTableNameIdxKey();

	/**
	 *	Allocate a public TableNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoByTableNameIdxKey asPublic(ISecureProtTableInfoByTableNameIdxKey src);

	/**
	 *	Allocate a protected SuperNameIdx key over protected TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySuperNameIdxKey newProtBySuperNameIdxKey();

	/**
	 *	Allocate a public SuperNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySuperNameIdxKey asPublic(ISecureProtTableInfoBySuperNameIdxKey src);

	/**
	 *	Allocate a protected SchemaNameIdx key over protected TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaNameIdxKey newProtBySchemaNameIdxKey();

	/**
	 *	Allocate a public SchemaNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaNameIdxKey asPublic(ISecureProtTableInfoBySchemaNameIdxKey src);

	/**
	 *	Allocate a protected SchemaBkCodeIdx key over protected TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaBkCodeIdxKey newProtBySchemaBkCodeIdxKey();

	/**
	 *	Allocate a public SchemaBkCodeIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaBkCodeIdxKey asPublic(ISecureProtTableInfoBySchemaBkCodeIdxKey src);

	/**
	 *	Allocate a protected SchemaRTCodeIdx key over protected TableInfo instances.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoBySchemaRTCodeIdxKey newProtBySchemaRTCodeIdxKey();

	/**
	 *	Allocate a public SchemaRTCodeIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoBySchemaRTCodeIdxKey asPublic(ISecureProtTableInfoBySchemaRTCodeIdxKey src);

	/**
	 *	Allocate a protected TableInfo interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfo newProtRec();

	/**
	 *	Allocate a public TableInfo interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfo asPublic(ISecureProtTableInfo src);

	/**
	 *	Allocate a protected TableInfo history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ISecureProtTableInfoH newProtHRec();

	/**
	 *	Allocate a public TableInfo history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ISecurePubTableInfoH asPublic(ISecureProtTableInfoH src);

}
