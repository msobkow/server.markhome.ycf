// Description: Java 25 Spring JPA Repository for EnumTag

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
 *	JpaRepository for the BusModelJpaEnumTag entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaEnumTagRepository extends JpaRepository<BusModelJpaEnumTag, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaEnumTag save(BusModelJpaEnumTag obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.requiredId = :id")
	BusModelJpaEnumTag get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaEnumTag specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelEnumTagByEnumIdxKey as arguments.
	 *
	 *		@param requiredEnumId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId")
	List<BusModelJpaEnumTag> findByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId);

	/**
	 *	BusModelEnumTagByEnumIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByEnumIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaEnumTag> findByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		return( findByEnumIdx(key.getRequiredEnumId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelEnumTagByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaEnumTag> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelEnumTagByDefSchemaIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaEnumTag> findByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		return( findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelEnumTagByEnumNameIdxKey as arguments.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId and r.requiredName = :name")
	BusModelJpaEnumTag findByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName);

	/**
	 *	BusModelEnumTagByEnumNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByEnumNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaEnumTag findByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		return( findByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelEnumTagByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaEnumTag> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelEnumTagByPrevIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaEnumTag> findByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
		return( findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelEnumTagByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaEnumTag> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelEnumTagByNextIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaEnumTag> findByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		return( findByNextIdx(key.getOptionalNextId()));
	}

	// BusModelJpaEnumTag specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaEnumTag r where r.requiredId = :id")
	BusModelJpaEnumTag lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId")
	List<BusModelJpaEnumTag> lockByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId);

	/**
	 *	BusModelEnumTagByEnumIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaEnumTag> lockByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		return( lockByEnumIdx(key.getRequiredEnumId()));
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
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	List<BusModelJpaEnumTag> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelEnumTagByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaEnumTag> lockByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		return( lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId and r.requiredName = :name")
	BusModelJpaEnumTag lockByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName);

	/**
	 *	BusModelEnumTagByEnumNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaEnumTag lockByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		return( lockByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName()));
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
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupPrev.requiredId = :prevId")
	List<BusModelJpaEnumTag> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelEnumTagByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaEnumTag> lockByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
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
	@Query("select r from BusModelJpaEnumTag r where r.optionalLookupNext.requiredId = :nextId")
	List<BusModelJpaEnumTag> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelEnumTagByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaEnumTag> lockByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		return( lockByNextIdx(key.getOptionalNextId()));
	}

	// BusModelJpaEnumTag specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId")
	void deleteByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId);

	/**
	 *	BusModelEnumTagByEnumIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByEnumIdxKey of the entity to be locked.
	 */
	default void deleteByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		deleteByEnumIdx(key.getRequiredEnumId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.optionalLookupDefSchema.requiredId = :defSchemaId")
	void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId);

	/**
	 *	BusModelEnumTagByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByDefSchemaIdxKey of the entity to be locked.
	 */
	default void deleteByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.requiredContainerEnumDef.requiredId = :enumId and r.requiredName = :name")
	void deleteByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName);

	/**
	 *	BusModelEnumTagByEnumNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByEnumNameIdxKey of the entity to be locked.
	 */
	default void deleteByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		deleteByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.optionalLookupPrev.requiredId = :prevId")
	void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId);

	/**
	 *	BusModelEnumTagByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByPrevIdxKey of the entity to be locked.
	 */
	default void deleteByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
		deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaEnumTag r where r.optionalLookupNext.requiredId = :nextId")
	void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId);

	/**
	 *	BusModelEnumTagByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelEnumTagByNextIdxKey of the entity to be locked.
	 */
	default void deleteByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		deleteByNextIdx(key.getOptionalNextId());
	}

}
