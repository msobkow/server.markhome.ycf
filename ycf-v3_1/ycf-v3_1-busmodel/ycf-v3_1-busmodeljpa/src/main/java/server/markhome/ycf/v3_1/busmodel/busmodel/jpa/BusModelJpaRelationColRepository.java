// Description: Java 25 Spring JPA Repository for RelationCol

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
 *	JpaRepository for the BusModelJpaRelationCol entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaRelationColRepository extends JpaRepository<BusModelJpaRelationCol, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaRelationCol save(BusModelJpaRelationCol obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredId = :id")
	BusModelJpaRelationCol get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaRelationCol specified index readers

	/**
	 *	Read an entity using the columns of the BusModelRelationColByUNameIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.requiredName = :name")
	BusModelJpaRelationCol findByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationColByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaRelationCol findByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredRelationId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByRelationIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId")
	List<BusModelJpaRelationCol> findByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelRelationColByRelationIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelationIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		return( findByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaRelationCol> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationColByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByFromColIdxKey as arguments.
	 *
	 *		@param requiredFromColId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredLookupFromCol.requiredId = :fromColId")
	List<BusModelJpaRelationCol> findByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId);

	/**
	 *	BusModelRelationColByFromColIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByFromColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		return( findByFromColIdx(key.getRequiredFromColId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByToColIdxKey as arguments.
	 *
	 *		@param requiredToColId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredLookupToCol.requiredId = :toColId")
	List<BusModelJpaRelationCol> findByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId);

	/**
	 *	BusModelRelationColByToColIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByToColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByToColIdx(IBusModelRelationColByToColIdxKey key) {
		return( findByToColIdx(key.getRequiredToColId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaRelationCol> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaRelationCol> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByNextIdx(IBusModelRelationColByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByRelPrevIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaRelationCol> findByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByRelPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		return( findByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationColByRelNextIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaRelationCol> findByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByRelNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelationCol> findByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		return( findByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId()));
	}

	// BusModelJpaRelationCol specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredId = :id")
	BusModelJpaRelationCol lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.requiredName = :name")
	BusModelJpaRelationCol lockByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaRelationCol lockByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredRelationId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId")
	List<BusModelJpaRelationCol> lockByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelRelationColByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		return( lockByRelationIdx(key.getRequiredRelationId()));
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
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaRelationCol> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromColId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredLookupFromCol.requiredId = :fromColId")
	List<BusModelJpaRelationCol> lockByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId);

	/**
	 *	BusModelRelationColByFromColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		return( lockByFromColIdx(key.getRequiredFromColId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToColId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredLookupToCol.requiredId = :toColId")
	List<BusModelJpaRelationCol> lockByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId);

	/**
	 *	BusModelRelationColByToColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByToColIdx(IBusModelRelationColByToColIdxKey key) {
		return( lockByToColIdx(key.getRequiredToColId()));
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
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaRelationCol> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
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
	@Query("select r from BusModelJpaRelationCol r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaRelationCol> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByNextIdx(IBusModelRelationColByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaRelationCol> lockByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByRelPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		return( lockByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaRelationCol> lockByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByRelNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelationCol> lockByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		return( lockByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId()));
	}

	// BusModelJpaRelationCol specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredRelationId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId")
	void deleteByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelRelationColByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelationIdxKey of the entity to be locked.
	 */
	default void deleteByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		deleteByRelationIdx(key.getRequiredRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromColId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredLookupFromCol.requiredId = :fromColId")
	void deleteByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId);

	/**
	 *	BusModelRelationColByFromColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByFromColIdxKey of the entity to be locked.
	 */
	default void deleteByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		deleteByFromColIdx(key.getRequiredFromColId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToColId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredLookupToCol.requiredId = :toColId")
	void deleteByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId);

	/**
	 *	BusModelRelationColByToColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByToColIdxKey of the entity to be locked.
	 */
	default void deleteByToColIdx(IBusModelRelationColByToColIdxKey key) {
		deleteByToColIdx(key.getRequiredToColId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelRelationColByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupPrev.requiredId = :prevId")
	void deleteByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelRelationColByRelPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelPrevIdxKey of the entity to be locked.
	 */
	default void deleteByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		deleteByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelationCol r where r.requiredContainerRelation.requiredId = :relationId and r.optionalLookupNext.requiredId = :nextId")
	void deleteByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelRelationColByRelNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationColByRelNextIdxKey of the entity to be locked.
	 */
	default void deleteByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		deleteByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId());
	}

}
