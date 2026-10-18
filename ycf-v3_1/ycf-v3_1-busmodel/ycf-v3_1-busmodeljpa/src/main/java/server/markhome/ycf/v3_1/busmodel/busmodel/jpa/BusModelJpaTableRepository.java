// Description: Java 25 Spring JPA Repository for Table

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
 *	JpaRepository for the BusModelJpaTable entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaTableRepository extends JpaRepository<BusModelJpaTable, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaTable save(BusModelJpaTable obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaTable get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaScope specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaTable> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaTable specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableBySchemaDefIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaTable> findBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelTableBySchemaDefIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		return( findBySchemaDefIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByCodeVisIdxKey as arguments.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.requiredCodeVis = :codeVis")
	List<BusModelJpaTable> findByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableByCodeVisIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		return( findByCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableBySchemaCodeVisIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredCodeVis = :codeVis")
	List<BusModelJpaTable> findBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableBySchemaCodeVisIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		return( findBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaTable> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTableByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelTableByUNameIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredName = :name")
	BusModelJpaTable findByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTableByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaTable findByUNameIdx(IBusModelTableByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName()));
	}

	/**
	 *	Read an entity using the columns of the BusModelTableBySchemaCdIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredTableClassCode = :tableClassCode")
	BusModelJpaTable findBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode);

	/**
	 *	BusModelTableBySchemaCdIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaCdIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaTable findBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		return( findBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByPrimaryIndexIdxKey as arguments.
	 *
	 *		@param optionalPrimaryIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.optionalLookupPrimaryIndex.requiredId = :primaryIndexId")
	List<BusModelJpaTable> findByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId);

	/**
	 *	BusModelTableByPrimaryIndexIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByPrimaryIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		return( findByPrimaryIndexIdx(key.getOptionalPrimaryIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByLookupIndexIdxKey as arguments.
	 *
	 *		@param optionalLookupIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.optionalLookupLookupIndex.requiredId = :lookupIndexId")
	List<BusModelJpaTable> findByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId);

	/**
	 *	BusModelTableByLookupIndexIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByLookupIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		return( findByLookupIndexIdx(key.getOptionalLookupIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByAltIndexIdxKey as arguments.
	 *
	 *		@param optionalAltIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.optionalLookupAltIndex.requiredId = :altIndexId")
	List<BusModelJpaTable> findByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId);

	/**
	 *	BusModelTableByAltIndexIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByAltIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		return( findByAltIndexIdx(key.getOptionalAltIndexId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelTableByQualTableIdxKey as arguments.
	 *
	 *		@param optionalQualifyingTableId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaTable r where r.optionalLookupQualTable.requiredId = :qualifyingTableId")
	List<BusModelJpaTable> findByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId);

	/**
	 *	BusModelTableByQualTableIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelTableByQualTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaTable> findByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		return( findByQualTableIdx(key.getOptionalQualifyingTableId()));
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
	BusModelJpaTable lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	List<BusModelJpaTable> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaTable specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaTable> lockBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelTableBySchemaDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		return( lockBySchemaDefIdx(key.getRequiredSchemaDefId()));
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
	@Query("select r from BusModelJpaTable r where r.requiredCodeVis = :codeVis")
	List<BusModelJpaTable> lockByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableByCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		return( lockByCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredCodeVis = :codeVis")
	List<BusModelJpaTable> lockBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableBySchemaCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		return( lockBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis()));
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
	@Query("select r from BusModelJpaTable r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaTable> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTableByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredName = :name")
	BusModelJpaTable lockByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTableByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaTable lockByUNameIdx(IBusModelTableByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredTableClassCode = :tableClassCode")
	BusModelJpaTable lockBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode);

	/**
	 *	BusModelTableBySchemaCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaTable lockBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		return( lockBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrimaryIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.optionalLookupPrimaryIndex.requiredId = :primaryIndexId")
	List<BusModelJpaTable> lockByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId);

	/**
	 *	BusModelTableByPrimaryIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		return( lockByPrimaryIndexIdx(key.getOptionalPrimaryIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalLookupIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.optionalLookupLookupIndex.requiredId = :lookupIndexId")
	List<BusModelJpaTable> lockByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId);

	/**
	 *	BusModelTableByLookupIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		return( lockByLookupIndexIdx(key.getOptionalLookupIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalAltIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.optionalLookupAltIndex.requiredId = :altIndexId")
	List<BusModelJpaTable> lockByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId);

	/**
	 *	BusModelTableByAltIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		return( lockByAltIndexIdx(key.getOptionalAltIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalQualifyingTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaTable r where r.optionalLookupQualTable.requiredId = :qualifyingTableId")
	List<BusModelJpaTable> lockByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId);

	/**
	 *	BusModelTableByQualTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaTable> lockByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		return( lockByQualTableIdx(key.getOptionalQualifyingTableId()));
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

	// BusModelJpaTable specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	void deleteBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelTableBySchemaDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaDefIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		deleteBySchemaDefIdx(key.getRequiredSchemaDefId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.requiredCodeVis = :codeVis")
	void deleteByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableByCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByCodeVisIdxKey of the entity to be locked.
	 */
	default void deleteByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		deleteByCodeVisIdx(key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredCodeVis = :codeVis")
	void deleteBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis);

	/**
	 *	BusModelTableBySchemaCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaCodeVisIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		deleteBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelTableByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName);

	/**
	 *	BusModelTableByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelTableByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredTableClassCode = :tableClassCode")
	void deleteBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode);

	/**
	 *	BusModelTableBySchemaCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableBySchemaCdIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		deleteBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrimaryIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.optionalLookupPrimaryIndex.requiredId = :primaryIndexId")
	void deleteByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId);

	/**
	 *	BusModelTableByPrimaryIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByPrimaryIndexIdxKey of the entity to be locked.
	 */
	default void deleteByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		deleteByPrimaryIndexIdx(key.getOptionalPrimaryIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalLookupIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.optionalLookupLookupIndex.requiredId = :lookupIndexId")
	void deleteByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId);

	/**
	 *	BusModelTableByLookupIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByLookupIndexIdxKey of the entity to be locked.
	 */
	default void deleteByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		deleteByLookupIndexIdx(key.getOptionalLookupIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalAltIndexId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.optionalLookupAltIndex.requiredId = :altIndexId")
	void deleteByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId);

	/**
	 *	BusModelTableByAltIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByAltIndexIdxKey of the entity to be locked.
	 */
	default void deleteByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		deleteByAltIndexIdx(key.getOptionalAltIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalQualifyingTableId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaTable r where r.optionalLookupQualTable.requiredId = :qualifyingTableId")
	void deleteByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId);

	/**
	 *	BusModelTableByQualTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelTableByQualTableIdxKey of the entity to be locked.
	 */
	default void deleteByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		deleteByQualTableIdx(key.getOptionalQualifyingTableId());
	}

}
