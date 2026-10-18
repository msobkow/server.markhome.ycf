// Description: Java 25 Spring JPA Repository for PopDep

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
 *	JpaRepository for the BusModelJpaPopDep entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaPopDepRepository extends JpaRepository<BusModelJpaPopDep, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaPopDep save(BusModelJpaPopDep obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaPopDep get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaScope specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaPopDep&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaPopDep> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaPopDep> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaPopDep specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelPopDepByRelationIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return List&lt;BusModelJpaPopDep&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaPopDep r where r.requiredLookupRelation.requiredId = :relationId")
	List<BusModelJpaPopDep> findByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelPopDepByRelationIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelPopDepByRelationIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaPopDep> findByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
		return( findByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelPopDepByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaPopDep&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaPopDep r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaPopDep> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelPopDepByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelPopDepByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaPopDep> findByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
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
	BusModelJpaPopDep lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	List<BusModelJpaPopDep> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaPopDep> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaPopDep specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaPopDep r where r.requiredLookupRelation.requiredId = :relationId")
	List<BusModelJpaPopDep> lockByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelPopDepByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaPopDep> lockByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
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
	@Query("select r from BusModelJpaPopDep r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaPopDep> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelPopDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaPopDep> lockByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
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

	// BusModelJpaPopDep specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaPopDep r where r.requiredLookupRelation.requiredId = :relationId")
	void deleteByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId);

	/**
	 *	BusModelPopDepByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelPopDepByRelationIdxKey of the entity to be locked.
	 */
	default void deleteByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
		deleteByRelationIdx(key.getRequiredRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaPopDep r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelPopDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelPopDepByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

}
