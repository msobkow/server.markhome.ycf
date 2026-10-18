// Description: Java 25 Spring JPA Repository for Relation

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
 *	JpaRepository for the BusModelJpaRelation entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaRelationRepository extends JpaRepository<BusModelJpaRelation, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaRelation save(BusModelJpaRelation obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaRelation get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaScope specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaRelation> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaRelation specified index readers

	/**
	 *	Read an entity using the columns of the BusModelRelationByUNameIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredName = :name")
	BusModelJpaRelation findByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaRelation findByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByRelTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId")
	List<BusModelJpaRelation> findByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelRelationByRelTableIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		return( findByRelTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByRelCodeVisIdxKey as arguments.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredCodeVis = :codeVis")
	List<BusModelJpaRelation> findByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelCodeVisIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		return( findByRelCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByRelTableCodeVisXKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredCodeVis = :codeVis")
	List<BusModelJpaRelation> findByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelTableCodeVisXKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelTableCodeVisXKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		return( findByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaRelation> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByFromKeyIdxKey as arguments.
	 *
	 *		@param requiredFromIndexId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredLookupFromIndex.requiredId = :fromIndexId")
	List<BusModelJpaRelation> findByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId);

	/**
	 *	BusModelRelationByFromKeyIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByFromKeyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		return( findByFromKeyIdx(key.getRequiredFromIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByToTblIdxKey as arguments.
	 *
	 *		@param requiredToTableId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredLookupToTable.requiredId = :toTableId")
	List<BusModelJpaRelation> findByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId);

	/**
	 *	BusModelRelationByToTblIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByToTblIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		return( findByToTblIdx(key.getRequiredToTableId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByToKeyIdxKey as arguments.
	 *
	 *		@param requiredToIndexId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.requiredLookupToIndex.requiredId = :toIndexId")
	List<BusModelJpaRelation> findByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId);

	/**
	 *	BusModelRelationByToKeyIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByToKeyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		return( findByToKeyIdx(key.getRequiredToIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRelationByNarrowedIdxKey as arguments.
	 *
	 *		@param optionalNarrowedId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRelation r where r.optionalLookupNarrowed.requiredId = :narrowedId")
	List<BusModelJpaRelation> findByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId);

	/**
	 *	BusModelRelationByNarrowedIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRelationByNarrowedIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaRelation> findByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		return( findByNarrowedIdx(key.getOptionalNarrowedId()));
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
	BusModelJpaRelation lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	List<BusModelJpaRelation> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaRelation specified delete-by-index methods

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
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredName = :name")
	BusModelJpaRelation lockByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaRelation lockByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId")
	List<BusModelJpaRelation> lockByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelRelationByRelTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		return( lockByRelTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredCodeVis = :codeVis")
	List<BusModelJpaRelation> lockByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		return( lockByRelCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredCodeVis = :codeVis")
	List<BusModelJpaRelation> lockByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelTableCodeVisXKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		return( lockByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis()));
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
	@Query("select r from BusModelJpaRelation r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaRelation> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredLookupFromIndex.requiredId = :fromIndexId")
	List<BusModelJpaRelation> lockByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId);

	/**
	 *	BusModelRelationByFromKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		return( lockByFromKeyIdx(key.getRequiredFromIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredLookupToTable.requiredId = :toTableId")
	List<BusModelJpaRelation> lockByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId);

	/**
	 *	BusModelRelationByToTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		return( lockByToTblIdx(key.getRequiredToTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.requiredLookupToIndex.requiredId = :toIndexId")
	List<BusModelJpaRelation> lockByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId);

	/**
	 *	BusModelRelationByToKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		return( lockByToKeyIdx(key.getRequiredToIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNarrowedId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRelation r where r.optionalLookupNarrowed.requiredId = :narrowedId")
	List<BusModelJpaRelation> lockByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId);

	/**
	 *	BusModelRelationByNarrowedIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaRelation> lockByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		return( lockByNarrowedIdx(key.getOptionalNarrowedId()));
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

	// BusModelJpaRelation specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRelationByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredTableId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId")
	void deleteByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId);

	/**
	 *	BusModelRelationByRelTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelTableIdxKey of the entity to be locked.
	 */
	default void deleteByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		deleteByRelTableIdx(key.getRequiredTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredCodeVis = :codeVis")
	void deleteByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelCodeVisIdxKey of the entity to be locked.
	 */
	default void deleteByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		deleteByRelCodeVisIdx(key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredContainerFromTable.requiredId = :tableId and r.requiredCodeVis = :codeVis")
	void deleteByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelRelationByRelTableCodeVisXKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByRelTableCodeVisXKey of the entity to be locked.
	 */
	default void deleteByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		deleteByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRelationByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredLookupFromIndex.requiredId = :fromIndexId")
	void deleteByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId);

	/**
	 *	BusModelRelationByFromKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByFromKeyIdxKey of the entity to be locked.
	 */
	default void deleteByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		deleteByFromKeyIdx(key.getRequiredFromIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToTableId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredLookupToTable.requiredId = :toTableId")
	void deleteByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId);

	/**
	 *	BusModelRelationByToTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByToTblIdxKey of the entity to be locked.
	 */
	default void deleteByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		deleteByToTblIdx(key.getRequiredToTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.requiredLookupToIndex.requiredId = :toIndexId")
	void deleteByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId);

	/**
	 *	BusModelRelationByToKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByToKeyIdxKey of the entity to be locked.
	 */
	default void deleteByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		deleteByToKeyIdx(key.getRequiredToIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNarrowedId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRelation r where r.optionalLookupNarrowed.requiredId = :narrowedId")
	void deleteByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId);

	/**
	 *	BusModelRelationByNarrowedIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRelationByNarrowedIdxKey of the entity to be locked.
	 */
	default void deleteByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		deleteByNarrowedIdx(key.getOptionalNarrowedId());
	}

}
