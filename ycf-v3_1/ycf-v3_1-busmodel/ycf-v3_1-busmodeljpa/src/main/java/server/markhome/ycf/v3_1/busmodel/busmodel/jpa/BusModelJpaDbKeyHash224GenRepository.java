// Description: Java 25 Spring JPA Repository for DbKeyHash224Gen

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
 *	JpaRepository for the BusModelJpaDbKeyHash224Gen entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaDbKeyHash224GenRepository extends JpaRepository<BusModelJpaDbKeyHash224Gen, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaDbKeyHash224Gen save(BusModelJpaDbKeyHash224Gen obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaValue r where r.requiredId = :id")
	BusModelJpaDbKeyHash224Gen get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaValue specified index readers

	/**
	 *	Read an entity using the columns of the BusModelValueByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaDbKeyHash224Gen findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelValueByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaDbKeyHash224Gen findByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId")
	List<BusModelJpaDbKeyHash224Gen> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelValueByScopeIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByScopeIdx(IBusModelValueByScopeIdxKey key) {
		return( findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaDbKeyHash224Gen> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelValueByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaDbKeyHash224Gen> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByPrevIdx(IBusModelValueByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaDbKeyHash224Gen> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByNextIdx(IBusModelValueByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByContPrevIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaDbKeyHash224Gen> findByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByContPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByContPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( findByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelValueByContNextIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaDbKeyHash224Gen> findByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByContNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelValueByContNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( findByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelJpaAtom specified index readers

	// BusModelJpaDbKeyHash224Def specified index readers

	// BusModelJpaDbKeyHash224Type specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelDbKeyHash224TypeBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash224Gen&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaDbKeyHash224Type r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaDbKeyHash224Gen> findBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelDbKeyHash224TypeBySchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelDbKeyHash224TypeBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaDbKeyHash224Gen> findBySchemaIdx(IBusModelDbKeyHash224TypeBySchemaIdxKey key) {
		return( findBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	// BusModelJpaDbKeyHash224Gen specified index readers

	// BusModelJpaValue specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaValue r where r.requiredId = :id")
	BusModelJpaDbKeyHash224Gen lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaDbKeyHash224Gen lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaDbKeyHash224Gen lockByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
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
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId")
	List<BusModelJpaDbKeyHash224Gen> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByScopeIdx(IBusModelValueByScopeIdxKey key) {
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
	@Query("select r from BusModelJpaValue r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaDbKeyHash224Gen> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
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
	@Query("select r from BusModelJpaValue r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaDbKeyHash224Gen> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByPrevIdx(IBusModelValueByPrevIdxKey key) {
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
	@Query("select r from BusModelJpaValue r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaDbKeyHash224Gen> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByNextIdx(IBusModelValueByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaDbKeyHash224Gen> lockByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( lockByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaDbKeyHash224Gen> lockByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( lockByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelJpaAtom specified delete-by-index methods

	// BusModelJpaDbKeyHash224Def specified delete-by-index methods

	// BusModelJpaDbKeyHash224Type specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaDbKeyHash224Type r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaDbKeyHash224Gen> lockBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelDbKeyHash224TypeBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaDbKeyHash224Gen> lockBySchemaIdx(IBusModelDbKeyHash224TypeBySchemaIdxKey key) {
		return( lockBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	// BusModelJpaDbKeyHash224Gen specified delete-by-index methods

	// BusModelJpaValue specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelValueByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId")
	void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByScopeIdxKey of the entity to be locked.
	 */
	default void deleteByScopeIdx(IBusModelValueByScopeIdxKey key) {
		deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelValueByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelValueByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupPrev.requiredId = :prevId")
	void deleteByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByContPrevIdxKey of the entity to be locked.
	 */
	default void deleteByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		deleteByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaValue r where r.requiredContainerScope.requiredId = :scopeId and r.optionalLookupNext.requiredId = :nextId")
	void deleteByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelValueByContNextIdxKey of the entity to be locked.
	 */
	default void deleteByContNextIdx(IBusModelValueByContNextIdxKey key) {
		deleteByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId());
	}

	// BusModelJpaAtom specified delete-by-index methods

	// BusModelJpaDbKeyHash224Def specified delete-by-index methods

	// BusModelJpaDbKeyHash224Type specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaDbKeyHash224Type r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	void deleteBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelDbKeyHash224TypeBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelDbKeyHash224TypeBySchemaIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaIdx(IBusModelDbKeyHash224TypeBySchemaIdxKey key) {
		deleteBySchemaIdx(key.getRequiredSchemaDefId());
	}

	// BusModelJpaDbKeyHash224Gen specified delete-by-index methods

}
