// Description: Java 25 Spring JPA Repository for SchemaRole

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
 *	JpaRepository for the BusModelJpaSchemaRole entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaSchemaRoleRepository extends JpaRepository<BusModelJpaSchemaRole, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaSchemaRole save(BusModelJpaSchemaRole obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRoleDef r where r.requiredId = :id")
	BusModelJpaSchemaRole get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaRoleDef specified index readers

	/**
	 *	Read an entity using the columns of the BusModelRoleDefByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaSchemaRole findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRole findByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRoleDefByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId")
	List<BusModelJpaSchemaRole> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelRoleDefByScopeIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRole> findByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
		return( findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelRoleDefByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaRoleDef r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaSchemaRole> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRoleDefByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRole> findByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelRoleDefByUDefIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	BusModelJpaSchemaRole findByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUDefIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByUDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRole findByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		return( findByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelJpaSchemaRole specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRoleBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaSchemaRole> findBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelSchemaRoleBySchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRole> findBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		return( findBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRoleByRoleScopeIdxKey as arguments.
	 *
	 *		@param requiredRoleScope
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRole r where r.requiredRoleScope = :roleScope")
	List<BusModelJpaSchemaRole> findByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleByRoleScopeIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleByRoleScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRole> findByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		return( findByRoleScopeIdx(key.getRequiredRoleScope()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaRoleBySchRoleScpIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredRoleScope = :roleScope")
	List<BusModelJpaSchemaRole> findBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleBySchRoleScpIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleBySchRoleScpIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaRole> findBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		return( findBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope()));
	}

	// BusModelJpaRoleDef specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRoleDef r where r.requiredId = :id")
	BusModelJpaSchemaRole lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	BusModelJpaSchemaRole lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRole lockByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
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
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId")
	List<BusModelJpaSchemaRole> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelRoleDefByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRole> lockByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
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
	@Query("select r from BusModelJpaRoleDef r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaSchemaRole> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRoleDefByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRole> lockByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	BusModelJpaSchemaRole lockByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaSchemaRole lockByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		return( lockByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelJpaSchemaRole specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	List<BusModelJpaSchemaRole> lockBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelSchemaRoleBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRole> lockBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		return( lockBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRoleScope
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRole r where r.requiredRoleScope = :roleScope")
	List<BusModelJpaSchemaRole> lockByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleByRoleScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRole> lockByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		return( lockByRoleScopeIdx(key.getRequiredRoleScope()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredRoleScope = :roleScope")
	List<BusModelJpaSchemaRole> lockBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleBySchRoleScpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaRole> lockBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		return( lockBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope()));
	}

	// BusModelJpaRoleDef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRoleDef r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId")
	void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId);

	/**
	 *	BusModelRoleDefByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByScopeIdxKey of the entity to be locked.
	 */
	default void deleteByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
		deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRoleDef r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelRoleDefByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaRoleDef r where r.requiredContainerScopeDef.requiredId = :scopeId and r.optionalLookupDefSchema.requiredId = :defSchemaId and r.requiredName = :name")
	void deleteByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName);

	/**
	 *	BusModelRoleDefByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelRoleDefByUDefIdxKey of the entity to be locked.
	 */
	default void deleteByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		deleteByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName());
	}

	// BusModelJpaSchemaRole specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId")
	void deleteBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId);

	/**
	 *	BusModelSchemaRoleBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleBySchemaIdxKey of the entity to be locked.
	 */
	default void deleteBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		deleteBySchemaIdx(key.getRequiredSchemaDefId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRoleScope
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRole r where r.requiredRoleScope = :roleScope")
	void deleteByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleByRoleScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleByRoleScopeIdxKey of the entity to be locked.
	 */
	default void deleteByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		deleteByRoleScopeIdx(key.getRequiredRoleScope());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaRole r where r.requiredContainerSchemaDef.requiredId = :schemaDefId and r.requiredRoleScope = :roleScope")
	void deleteBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope);

	/**
	 *	BusModelSchemaRoleBySchRoleScpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaRoleBySchRoleScpIdxKey of the entity to be locked.
	 */
	default void deleteBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		deleteBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope());
	}

}
