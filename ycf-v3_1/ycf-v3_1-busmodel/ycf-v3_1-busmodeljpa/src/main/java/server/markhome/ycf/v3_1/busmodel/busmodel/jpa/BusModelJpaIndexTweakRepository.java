// Description: Java 25 Spring JPA Repository for IndexTweak

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;

/**
 *	JpaRepository for the BusModelJpaIndexTweak entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaIndexTweakRepository extends JpaRepository<BusModelJpaIndexTweak, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaIndexTweak save(BusModelJpaIndexTweak obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaTweak r where r.requiredId = :id")
	BusModelJpaIndexTweak get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaTweak specified index readers

	/**
	 *	Read an entity using the columns of the BusModelTweakByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaIndexTweak findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTweakByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaIndexTweak findByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTweakByValTentIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaIndexTweak&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTweak r where r.requiredTenantId = :tenantId")
	List<BusModelJpaIndexTweak> findByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelTweakByValTentIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTweakByValTentIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexTweak> findByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( findByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTweakByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaIndexTweak&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId")
	List<BusModelJpaIndexTweak> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelTweakByScopeIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTweakByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexTweak> findByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTweakByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaIndexTweak&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTweak r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaIndexTweak> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTweakByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTweakByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexTweak> findByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelTweakByUDefIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaTweak r where r.requiredTenantId = :tenantId and r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalDefSchemaTenantId = :defSchemaTenantId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	BusModelJpaIndexTweak findByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUDefIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTweakByUDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaIndexTweak findByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( findByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelJpaIndexTweak specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexTweakByIndexIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return List&lt;BusModelJpaIndexTweak&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexTweak r where r.requiredContainerIndexDef.requiredId = :indexId")
	List<BusModelJpaIndexTweak> findByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexTweakByIndexIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexTweakByIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexTweak> findByIndexIdx(IBusModelIndexTweakByIndexIdxKey key) {
		return( findByIndexIdx(key.getRequiredIndexId()));
	}

	// BusModelJpaTweak specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.requiredId = :id")
	BusModelJpaIndexTweak lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaIndexTweak lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaIndexTweak lockByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.requiredTenantId = :tenantId")
	List<BusModelJpaIndexTweak> lockByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexTweak> lockByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( lockByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId")
	List<BusModelJpaIndexTweak> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexTweak> lockByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaIndexTweak> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexTweak> lockByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTweak r where r.requiredTenantId = :tenantId and r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalDefSchemaTenantId = :defSchemaTenantId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	BusModelJpaIndexTweak lockByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaIndexTweak lockByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( lockByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelJpaIndexTweak specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexTweak r where r.requiredContainerIndexDef.requiredId = :indexId")
	List<BusModelJpaIndexTweak> lockByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexTweakByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexTweak> lockByIndexIdx(IBusModelIndexTweakByIndexIdxKey key) {
		return( lockByIndexIdx(key.getRequiredIndexId()));
	}

	// BusModelJpaTweak specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTweakByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.requiredTenantId = :tenantId")
	void deleteByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTweakByValTentIdxKey of the entity to be locked.
	 */
	default void deleteByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		deleteByValTentIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.requiredContainerScopeDef.requiredId = :scopeId")
	void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTweakByScopeIdxKey of the entity to be locked.
	 */
	default void deleteByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTweakByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTweak r where r.requiredTenantId = :tenantId and r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalDefSchemaTenantId = :defSchemaTenantId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	void deleteByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTweakByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTweakByUDefIdxKey of the entity to be locked.
	 */
	default void deleteByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		deleteByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName());
	}

	// BusModelJpaIndexTweak specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexTweak r where r.requiredContainerIndexDef.requiredId = :indexId")
	void deleteByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexTweakByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexTweakByIndexIdxKey of the entity to be locked.
	 */
	default void deleteByIndexIdx(IBusModelIndexTweakByIndexIdxKey key) {
		deleteByIndexIdx(key.getRequiredIndexId());
	}

}
