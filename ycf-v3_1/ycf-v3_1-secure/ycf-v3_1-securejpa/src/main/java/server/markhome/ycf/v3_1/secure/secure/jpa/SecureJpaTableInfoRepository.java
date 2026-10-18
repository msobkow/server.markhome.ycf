// Description: Java 25 Spring JPA Repository for TableInfo

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

package server.markhome.ycf.v3_1.secure.secure.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import server.markhome.ycf.v3_1.secure.secure.*;

/**
 *	JpaRepository for the SecureJpaTableInfo entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaTableInfoRepository extends JpaRepository<SecureJpaTableInfo, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaTableInfo save(SecureJpaTableInfo obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredTableInfoId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaTableInfo r where r.requiredTableInfoId = :tableInfoId")
	SecureJpaTableInfo get(@Param("tableInfoId") int requiredTableInfoId);

	// SecureJpaTableInfo specified index readers

	/**
	 *	Read an entity using the columns of the SecureTableInfoByTableNameIdxKey as arguments.
	 *
	 *		@param requiredTableName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaTableInfo r where r.requiredTableName = :tableName")
	SecureJpaTableInfo findByTableNameIdx(@Param("tableName") String requiredTableName);

	/**
	 *	SecureTableInfoByTableNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureTableInfoByTableNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaTableInfo findByTableNameIdx(ISecureTableInfoByTableNameIdxKey key) {
		return( findByTableNameIdx(key.getRequiredTableName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureTableInfoBySuperNameIdxKey as arguments.
	 *
	 *		@param optionalSuperName
	 *
	 *		@return List&lt;SecureJpaTableInfo&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaTableInfo r where r.optionalParentSuperRef.requiredTableName = :superName")
	List<SecureJpaTableInfo> findBySuperNameIdx(@Param("superName") String optionalSuperName);

	/**
	 *	SecureTableInfoBySuperNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySuperNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaTableInfo> findBySuperNameIdx(ISecureTableInfoBySuperNameIdxKey key) {
		return( findBySuperNameIdx(key.getOptionalSuperName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureTableInfoBySchemaNameIdxKey as arguments.
	 *
	 *		@param requiredSchemaName
	 *
	 *		@return List&lt;SecureJpaTableInfo&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName")
	List<SecureJpaTableInfo> findBySchemaNameIdx(@Param("schemaName") String requiredSchemaName);

	/**
	 *	SecureTableInfoBySchemaNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaTableInfo> findBySchemaNameIdx(ISecureTableInfoBySchemaNameIdxKey key) {
		return( findBySchemaNameIdx(key.getRequiredSchemaName()));
	}

	/**
	 *	Read an entity using the columns of the SecureTableInfoBySchemaBkCodeIdxKey as arguments.
	 *
	 *		@param requiredSchemaName
	 *		@param requiredBackingClassCode
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName and r.requiredBackingClassCode = :backingClassCode")
	SecureJpaTableInfo findBySchemaBkCodeIdx(@Param("schemaName") String requiredSchemaName,
		@Param("backingClassCode") int requiredBackingClassCode);

	/**
	 *	SecureTableInfoBySchemaBkCodeIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaBkCodeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaTableInfo findBySchemaBkCodeIdx(ISecureTableInfoBySchemaBkCodeIdxKey key) {
		return( findBySchemaBkCodeIdx(key.getRequiredSchemaName(), key.getRequiredBackingClassCode()));
	}

	/**
	 *	Read an entity using the columns of the SecureTableInfoBySchemaRTCodeIdxKey as arguments.
	 *
	 *		@param requiredRuntimeClassCode
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaTableInfo r where r.requiredRuntimeClassCode = :runtimeClassCode")
	SecureJpaTableInfo findBySchemaRTCodeIdx(@Param("runtimeClassCode") int requiredRuntimeClassCode);

	/**
	 *	SecureTableInfoBySchemaRTCodeIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaRTCodeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaTableInfo findBySchemaRTCodeIdx(ISecureTableInfoBySchemaRTCodeIdxKey key) {
		return( findBySchemaRTCodeIdx(key.getRequiredRuntimeClassCode()));
	}

	// SecureJpaTableInfo specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableInfoId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.requiredTableInfoId = :tableInfoId")
	SecureJpaTableInfo lockByIdIdx(@Param("tableInfoId") int requiredTableInfoId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.requiredTableName = :tableName")
	SecureJpaTableInfo lockByTableNameIdx(@Param("tableName") String requiredTableName);

	/**
	 *	SecureTableInfoByTableNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaTableInfo lockByTableNameIdx(ISecureTableInfoByTableNameIdxKey key) {
		return( lockByTableNameIdx(key.getRequiredTableName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalSuperName
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.optionalParentSuperRef.requiredTableName = :superName")
	List<SecureJpaTableInfo> lockBySuperNameIdx(@Param("superName") String optionalSuperName);

	/**
	 *	SecureTableInfoBySuperNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaTableInfo> lockBySuperNameIdx(ISecureTableInfoBySuperNameIdxKey key) {
		return( lockBySuperNameIdx(key.getOptionalSuperName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaName
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName")
	List<SecureJpaTableInfo> lockBySchemaNameIdx(@Param("schemaName") String requiredSchemaName);

	/**
	 *	SecureTableInfoBySchemaNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaTableInfo> lockBySchemaNameIdx(ISecureTableInfoBySchemaNameIdxKey key) {
		return( lockBySchemaNameIdx(key.getRequiredSchemaName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaName
	 *		@param requiredBackingClassCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName and r.requiredBackingClassCode = :backingClassCode")
	SecureJpaTableInfo lockBySchemaBkCodeIdx(@Param("schemaName") String requiredSchemaName,
		@Param("backingClassCode") int requiredBackingClassCode);

	/**
	 *	SecureTableInfoBySchemaBkCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaTableInfo lockBySchemaBkCodeIdx(ISecureTableInfoBySchemaBkCodeIdxKey key) {
		return( lockBySchemaBkCodeIdx(key.getRequiredSchemaName(), key.getRequiredBackingClassCode()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRuntimeClassCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaTableInfo r where r.requiredRuntimeClassCode = :runtimeClassCode")
	SecureJpaTableInfo lockBySchemaRTCodeIdx(@Param("runtimeClassCode") int requiredRuntimeClassCode);

	/**
	 *	SecureTableInfoBySchemaRTCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaTableInfo lockBySchemaRTCodeIdx(ISecureTableInfoBySchemaRTCodeIdxKey key) {
		return( lockBySchemaRTCodeIdx(key.getRequiredRuntimeClassCode()));
	}

	// SecureJpaTableInfo specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableInfoId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.requiredTableInfoId = :tableInfoId")
	void deleteByIdIdx(@Param("tableInfoId") int requiredTableInfoId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.requiredTableName = :tableName")
	void deleteByTableNameIdx(@Param("tableName") String requiredTableName);

	/**
	 *	SecureTableInfoByTableNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureTableInfoByTableNameIdxKey of the entity to be locked.
	 */
	default void deleteByTableNameIdx(ISecureTableInfoByTableNameIdxKey key) {
		deleteByTableNameIdx(key.getRequiredTableName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalSuperName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.optionalParentSuperRef.requiredTableName = :superName")
	void deleteBySuperNameIdx(@Param("superName") String optionalSuperName);

	/**
	 *	SecureTableInfoBySuperNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySuperNameIdxKey of the entity to be locked.
	 */
	default void deleteBySuperNameIdx(ISecureTableInfoBySuperNameIdxKey key) {
		deleteBySuperNameIdx(key.getOptionalSuperName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName")
	void deleteBySchemaNameIdx(@Param("schemaName") String requiredSchemaName);

	/**
	 *	SecureTableInfoBySchemaNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaNameIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaNameIdx(ISecureTableInfoBySchemaNameIdxKey key) {
		deleteBySchemaNameIdx(key.getRequiredSchemaName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaName
	 *		@param requiredBackingClassCode
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.requiredSchemaName = :schemaName and r.requiredBackingClassCode = :backingClassCode")
	void deleteBySchemaBkCodeIdx(@Param("schemaName") String requiredSchemaName,
		@Param("backingClassCode") int requiredBackingClassCode);

	/**
	 *	SecureTableInfoBySchemaBkCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaBkCodeIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaBkCodeIdx(ISecureTableInfoBySchemaBkCodeIdxKey key) {
		deleteBySchemaBkCodeIdx(key.getRequiredSchemaName(), key.getRequiredBackingClassCode());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRuntimeClassCode
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaTableInfo r where r.requiredRuntimeClassCode = :runtimeClassCode")
	void deleteBySchemaRTCodeIdx(@Param("runtimeClassCode") int requiredRuntimeClassCode);

	/**
	 *	SecureTableInfoBySchemaRTCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureTableInfoBySchemaRTCodeIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaRTCodeIdx(ISecureTableInfoBySchemaRTCodeIdxKey key) {
		deleteBySchemaRTCodeIdx(key.getRequiredRuntimeClassCode());
	}

}
