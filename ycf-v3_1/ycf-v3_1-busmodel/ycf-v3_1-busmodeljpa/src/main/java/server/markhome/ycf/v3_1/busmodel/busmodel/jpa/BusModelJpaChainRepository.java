// Description: Java 25 Spring JPA Repository for Chain

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
 *	JpaRepository for the BusModelJpaChain entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaChainRepository extends JpaRepository<BusModelJpaChain, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaChain save(BusModelJpaChain obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaChain r where r.requiredId = :id")
	BusModelJpaChain get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaChain specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelChainByChainTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId")
	List<BusModelJpaChain> findByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelChainByChainTableIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelChainByChainTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaChain> findByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		return( findByChainTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelChainByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaChain r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaChain> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelChainByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelChainByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaChain> findByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelChainByUNameIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId and r.requiredName = :name")
	BusModelJpaChain findByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelChainByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelChainByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaChain findByUNameIdx(IBusModelChainByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelChainByPrevRelIdxKey as arguments.
	 *
	 *		@param requiredPrevRelationId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaChain r where r.requiredLookupPrevRel.requiredId = :prevRelationId")
	List<BusModelJpaChain> findByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId);

	/**
	 *	BusModelChainByPrevRelIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelChainByPrevRelIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaChain> findByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		return( findByPrevRelIdx(key.getRequiredPrevRelationId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelChainByNextRelIdxKey as arguments.
	 *
	 *		@param requiredNextRelationId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaChain r where r.requiredLookupNextRel.requiredId = :nextRelationId")
	List<BusModelJpaChain> findByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId);

	/**
	 *	BusModelChainByNextRelIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelChainByNextRelIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaChain> findByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		return( findByNextRelIdx(key.getRequiredNextRelationId()));
	}

	// BusModelJpaChain specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaChain r where r.requiredId = :id")
	BusModelJpaChain lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId")
	List<BusModelJpaChain> lockByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelChainByChainTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaChain> lockByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		return( lockByChainTableIdx(key.getRequiredTableId()));
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
	@Query("select r from BusModelJpaChain r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaChain> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelChainByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaChain> lockByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId and r.requiredName = :name")
	BusModelJpaChain lockByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelChainByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaChain lockByUNameIdx(IBusModelChainByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPrevRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaChain r where r.requiredLookupPrevRel.requiredId = :prevRelationId")
	List<BusModelJpaChain> lockByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId);

	/**
	 *	BusModelChainByPrevRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaChain> lockByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		return( lockByPrevRelIdx(key.getRequiredPrevRelationId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredNextRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaChain r where r.requiredLookupNextRel.requiredId = :nextRelationId")
	List<BusModelJpaChain> lockByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId);

	/**
	 *	BusModelChainByNextRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaChain> lockByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		return( lockByNextRelIdx(key.getRequiredNextRelationId()));
	}

	// BusModelJpaChain specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId")
	void deleteByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelChainByChainTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelChainByChainTableIdxKey of the entity to be locked.
	 */
	default void deleteByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		deleteByChainTableIdx(key.getRequiredTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelChainByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelChainByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.requiredContainerTable.requiredId = :tableId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelChainByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelChainByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelChainByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredTableId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPrevRelationId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.requiredLookupPrevRel.requiredId = :prevRelationId")
	void deleteByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId);

	/**
	 *	BusModelChainByPrevRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelChainByPrevRelIdxKey of the entity to be locked.
	 */
	default void deleteByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		deleteByPrevRelIdx(key.getRequiredPrevRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredNextRelationId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaChain r where r.requiredLookupNextRel.requiredId = :nextRelationId")
	void deleteByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId);

	/**
	 *	BusModelChainByNextRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelChainByNextRelIdxKey of the entity to be locked.
	 */
	default void deleteByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		deleteByNextRelIdx(key.getRequiredNextRelationId());
	}

}
