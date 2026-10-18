// Description: Java 25 Spring JPA Repository for IndexCol

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
 *	JpaRepository for the BusModelJpaIndexCol entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaIndexColRepository extends JpaRepository<BusModelJpaIndexCol, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaIndexCol save(BusModelJpaIndexCol obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredId = :id")
	BusModelJpaIndexCol get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaIndexCol specified index readers

	/**
	 *	Read an entity using the columns of the BusModelIndexColByUNameIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.requiredName = :name")
	BusModelJpaIndexCol findByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName);

	/**
	 *	BusModelIndexColByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaIndexCol findByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredIndexId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByIndexIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId")
	List<BusModelJpaIndexCol> findByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexColByIndexIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		return( findByIndexIdx(key.getRequiredIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaIndexCol> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelIndexColByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByColIdxKey as arguments.
	 *
	 *		@param requiredColumnId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredLookupColumn.requiredId = :columnId")
	List<BusModelJpaIndexCol> findByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId);

	/**
	 *	BusModelIndexColByColIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByColIdx(IBusModelIndexColByColIdxKey key) {
		return( findByColIdx(key.getRequiredColumnId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaIndexCol> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaIndexCol> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByNextIdx(IBusModelIndexColByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByIdxPrevIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaIndexCol> findByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByIdxPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIdxPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		return( findByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelIndexColByIdxNextIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaIndexCol> findByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByIdxNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIdxNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaIndexCol> findByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		return( findByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId()));
	}

	// BusModelJpaIndexCol specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredId = :id")
	BusModelJpaIndexCol lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.requiredName = :name")
	BusModelJpaIndexCol lockByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName);

	/**
	 *	BusModelIndexColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaIndexCol lockByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredIndexId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId")
	List<BusModelJpaIndexCol> lockByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexColByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		return( lockByIndexIdx(key.getRequiredIndexId()));
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
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaIndexCol> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelIndexColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredColumnId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredLookupColumn.requiredId = :columnId")
	List<BusModelJpaIndexCol> lockByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId);

	/**
	 *	BusModelIndexColByColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByColIdx(IBusModelIndexColByColIdxKey key) {
		return( lockByColIdx(key.getRequiredColumnId()));
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
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaIndexCol> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
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
	@Query("select r from BusModelJpaIndexCol r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaIndexCol> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByNextIdx(IBusModelIndexColByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaIndexCol> lockByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByIdxPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		return( lockByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaIndexCol> lockByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByIdxNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaIndexCol> lockByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		return( lockByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId()));
	}

	// BusModelJpaIndexCol specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName);

	/**
	 *	BusModelIndexColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredIndexId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId")
	void deleteByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId);

	/**
	 *	BusModelIndexColByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIndexIdxKey of the entity to be locked.
	 */
	default void deleteByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		deleteByIndexIdx(key.getRequiredIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelIndexColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredColumnId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredLookupColumn.requiredId = :columnId")
	void deleteByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId);

	/**
	 *	BusModelIndexColByColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByColIdxKey of the entity to be locked.
	 */
	default void deleteByColIdx(IBusModelIndexColByColIdxKey key) {
		deleteByColIdx(key.getRequiredColumnId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelIndexColByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupPrev.requiredId = :prevId")
	void deleteByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelIndexColByIdxPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIdxPrevIdxKey of the entity to be locked.
	 */
	default void deleteByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		deleteByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaIndexCol r where r.requiredContainerIndex.requiredId = :indexId and r.optionalLookupNext.requiredId = :nextId")
	void deleteByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelIndexColByIdxNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelIndexColByIdxNextIdxKey of the entity to be locked.
	 */
	default void deleteByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		deleteByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId());
	}

}
