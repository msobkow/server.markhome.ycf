// Description: Java 25 Spring JPA Repository for Param

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
 *	JpaRepository for the BusModelJpaParam entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaParamRepository extends JpaRepository<BusModelJpaParam, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaParam save(BusModelJpaParam obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredId = :id")
	BusModelJpaParam get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaParam specified index readers

	/**
	 *	Read an entity using the columns of the BusModelParamByUNameIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.requiredName = :name")
	BusModelJpaParam findByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName);

	/**
	 *	BusModelParamByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaParam findByUNameIdx(IBusModelParamByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByServerMethodIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId")
	List<BusModelJpaParam> findByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId);

	/**
	 *	BusModelParamByServerMethodIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByServerMethodIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		return( findByServerMethodIdx(key.getRequiredServerMethodId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaParam> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelParamByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByServerTypeIdxKey as arguments.
	 *
	 *		@param optionalTypeId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredLookupType.requiredId = :typeId")
	List<BusModelJpaParam> findByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId);

	/**
	 *	BusModelParamByServerTypeIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByServerTypeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		return( findByServerTypeIdx(key.getOptionalTypeId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaParam> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByPrevIdx(IBusModelParamByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaParam> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByNextIdx(IBusModelParamByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByContPrevIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaParam> findByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByContPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByContPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		return( findByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelParamByContNextIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaParam> findByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByContNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelParamByContNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaParam> findByContNextIdx(IBusModelParamByContNextIdxKey key) {
		return( findByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId()));
	}

	// BusModelJpaParam specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredId = :id")
	BusModelJpaParam lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.requiredName = :name")
	BusModelJpaParam lockByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName);

	/**
	 *	BusModelParamByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaParam lockByUNameIdx(IBusModelParamByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId")
	List<BusModelJpaParam> lockByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId);

	/**
	 *	BusModelParamByServerMethodIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		return( lockByServerMethodIdx(key.getRequiredServerMethodId()));
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
	@Query("select r from BusModelJpaParam r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaParam> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelParamByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalTypeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredLookupType.requiredId = :typeId")
	List<BusModelJpaParam> lockByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId);

	/**
	 *	BusModelParamByServerTypeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		return( lockByServerTypeIdx(key.getOptionalTypeId()));
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
	@Query("select r from BusModelJpaParam r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaParam> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByPrevIdx(IBusModelParamByPrevIdxKey key) {
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
	@Query("select r from BusModelJpaParam r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaParam> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByNextIdx(IBusModelParamByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaParam> lockByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		return( lockByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaParam> lockByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaParam> lockByContNextIdx(IBusModelParamByContNextIdxKey key) {
		return( lockByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId()));
	}

	// BusModelJpaParam specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName);

	/**
	 *	BusModelParamByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelParamByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId")
	void deleteByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId);

	/**
	 *	BusModelParamByServerMethodIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByServerMethodIdxKey of the entity to be locked.
	 */
	default void deleteByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		deleteByServerMethodIdx(key.getRequiredServerMethodId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelParamByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalTypeId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredLookupType.requiredId = :typeId")
	void deleteByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId);

	/**
	 *	BusModelParamByServerTypeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByServerTypeIdxKey of the entity to be locked.
	 */
	default void deleteByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		deleteByServerTypeIdx(key.getOptionalTypeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelParamByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelParamByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupPrev.requiredId = :prevId")
	void deleteByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelParamByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByContPrevIdxKey of the entity to be locked.
	 */
	default void deleteByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		deleteByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaParam r where r.requiredContainerServerMeth.requiredId = :serverMethodId and r.optionalLookupNext.requiredId = :nextId")
	void deleteByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelParamByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelParamByContNextIdxKey of the entity to be locked.
	 */
	default void deleteByContNextIdx(IBusModelParamByContNextIdxKey key) {
		deleteByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId());
	}

}
