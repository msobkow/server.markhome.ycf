// Description: Java 25 Spring JPA Repository for SchemaRef

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
 *	JpaRepository for the BusModelJpaSchemaRef entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaSchemaRefRepository extends JpaRepository<BusModelJpaSchemaRef, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaSchemaRef save(BusModelJpaSchemaRef obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaSchemaRef get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaScope specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaSchemaRef> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRef> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaSchemaRef specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRefBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId")
	List<BusModelJpaSchemaRef> findBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId);

	/**
	 *	BusModelSchemaRefBySchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRef> findBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		return( findBySchemaIdx(key.getRequiredSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelSchemaRefByUNameIdxKey as arguments.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId and r.requiredName = :name")
	BusModelJpaSchemaRef findByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaRefByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRef findByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRefByRefSchemaIdxKey as arguments.
	 *
	 *		@param optionalRefSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupRefSchema.requiredId = :refSchemaId")
	List<BusModelJpaSchemaRef> findByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId);

	/**
	 *	BusModelSchemaRefByRefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByRefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRef> findByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		return( findByRefSchemaIdx(key.getOptionalRefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRefByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaSchemaRef> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelSchemaRefByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRef> findByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRefByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaSchemaRef> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelSchemaRefByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRef> findByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	// BusModelJpaScope specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaSchemaRef lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaSchemaRef> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRef> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaSchemaRef specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId")
	List<BusModelJpaSchemaRef> lockBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId);

	/**
	 *	BusModelSchemaRefBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRef> lockBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		return( lockBySchemaIdx(key.getRequiredSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId and r.requiredName = :name")
	BusModelJpaSchemaRef lockByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaRefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRef lockByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupRefSchema.requiredId = :refSchemaId")
	List<BusModelJpaSchemaRef> lockByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId);

	/**
	 *	BusModelSchemaRefByRefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRef> lockByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		return( lockByRefSchemaIdx(key.getOptionalRefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaSchemaRef> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelSchemaRefByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRef> lockByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		return( lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRef r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaSchemaRef> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelSchemaRefByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRef> lockByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	// BusModelJpaScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaScope r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	default void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelJpaSchemaRef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId")
	void deleteBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId);

	/**
	 *	BusModelSchemaRefBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefBySchemaIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		deleteBySchemaIdx(key.getRequiredSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRef r where r.requiredContainerSchema.requiredId = :schemaId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaRefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRef r where r.optionalLookupRefSchema.requiredId = :refSchemaId")
	void deleteByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId);

	/**
	 *	BusModelSchemaRefByRefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByRefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		deleteByRefSchemaIdx(key.getOptionalRefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRef r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelSchemaRefByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRef r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelSchemaRefByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRefByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

}
