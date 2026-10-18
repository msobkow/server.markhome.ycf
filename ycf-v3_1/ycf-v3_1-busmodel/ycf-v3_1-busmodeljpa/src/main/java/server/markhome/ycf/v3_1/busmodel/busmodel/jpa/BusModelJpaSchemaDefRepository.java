// Description: Java 25 Spring JPA Repository for SchemaDef

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
 *	JpaRepository for the BusModelJpaSchemaDef entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface BusModelJpaSchemaDefRepository extends JpaRepository<BusModelJpaSchemaDef, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	BusModelJpaSchemaDef save(BusModelJpaSchemaDef obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredId = :id")
	BusModelJpaSchemaDef get(@Param("id") IYCFKeyHash256 requiredId);

	// BusModelJpaScope specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaScope r where r.requiredTenantId = :tenantId")
	List<BusModelJpaSchemaDef> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaDef> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaSchemaDef specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaDefByCTenantIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId")
	List<BusModelJpaSchemaDef> findByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId);

	/**
	 *	BusModelSchemaDefByCTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByCTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaDef> findByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		return( findByCTenantIdx(key.getRequiredCTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaDefByMinorVersionIdxKey as arguments.
	 *
	 *		@param requiredMinorVersionId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId")
	List<BusModelJpaSchemaDef> findByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId);

	/**
	 *	BusModelSchemaDefByMinorVersionIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByMinorVersionIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaDef> findByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		return( findByMinorVersionIdx(key.getRequiredMinorVersionId()));
	}

	/**
	 *	Read an entity using the columns of the BusModelSchemaDefByUNameIdxKey as arguments.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId and r.requiredName = :name")
	BusModelJpaSchemaDef findByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaDefByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaSchemaDef findByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaDefByAuthEMailIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredAuthorEMail = :authorEMail")
	List<BusModelJpaSchemaDef> findByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail);

	/**
	 *	BusModelSchemaDefByAuthEMailIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByAuthEMailIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaDef> findByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		return( findByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the BusModelSchemaDefByProjectURLIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredProjectURL = :projectURL")
	List<BusModelJpaSchemaDef> findByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL);

	/**
	 *	BusModelSchemaDefByProjectURLIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByProjectURLIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<BusModelJpaSchemaDef> findByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		return( findByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL()));
	}

	/**
	 *	Read an entity using the columns of the BusModelSchemaDefByPubURIIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredPublishURI = :publishURI")
	BusModelJpaSchemaDef findByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI);

	/**
	 *	BusModelSchemaDefByPubURIIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByPubURIIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default BusModelJpaSchemaDef findByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		return( findByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI()));
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
	BusModelJpaSchemaDef lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

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
	List<BusModelJpaSchemaDef> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	BusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaDef> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelJpaSchemaDef specified delete-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId")
	List<BusModelJpaSchemaDef> lockByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId);

	/**
	 *	BusModelSchemaDefByCTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaDef> lockByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		return( lockByCTenantIdx(key.getRequiredCTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId")
	List<BusModelJpaSchemaDef> lockByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId);

	/**
	 *	BusModelSchemaDefByMinorVersionIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaDef> lockByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		return( lockByMinorVersionIdx(key.getRequiredMinorVersionId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId and r.requiredName = :name")
	BusModelJpaSchemaDef lockByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaSchemaDef lockByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredAuthorEMail = :authorEMail")
	List<BusModelJpaSchemaDef> lockByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail);

	/**
	 *	BusModelSchemaDefByAuthEMailIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaDef> lockByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		return( lockByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredProjectURL = :projectURL")
	List<BusModelJpaSchemaDef> lockByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL);

	/**
	 *	BusModelSchemaDefByProjectURLIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<BusModelJpaSchemaDef> lockByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		return( lockByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredPublishURI = :publishURI")
	BusModelJpaSchemaDef lockByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI);

	/**
	 *	BusModelSchemaDefByPubURIIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default BusModelJpaSchemaDef lockByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		return( lockByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI()));
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

	// BusModelJpaSchemaDef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId")
	void deleteByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId);

	/**
	 *	BusModelSchemaDefByCTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByCTenantIdxKey of the entity to be locked.
	 */
	default void deleteByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		deleteByCTenantIdx(key.getRequiredCTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId")
	void deleteByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId);

	/**
	 *	BusModelSchemaDefByMinorVersionIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByMinorVersionIdxKey of the entity to be locked.
	 */
	default void deleteByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		deleteByMinorVersionIdx(key.getRequiredMinorVersionId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredMinorVersionId = :minorVersionId and r.requiredName = :name")
	void deleteByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName);

	/**
	 *	BusModelSchemaDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredAuthorEMail = :authorEMail")
	void deleteByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail);

	/**
	 *	BusModelSchemaDefByAuthEMailIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByAuthEMailIdxKey of the entity to be locked.
	 */
	default void deleteByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		deleteByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredProjectURL = :projectURL")
	void deleteByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL);

	/**
	 *	BusModelSchemaDefByProjectURLIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByProjectURLIdxKey of the entity to be locked.
	 */
	default void deleteByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		deleteByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 */
	@Transactional
	@Modifying
	@Query("delete from BusModelJpaSchemaDef r where r.requiredCTenantId = :cTenantId and r.requiredPublishURI = :publishURI")
	void deleteByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI);

	/**
	 *	BusModelSchemaDefByPubURIIdxKey based lock method for object-cored access.
	 *
	 *		@param key The BusModelSchemaDefByPubURIIdxKey of the entity to be locked.
	 */
	default void deleteByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		deleteByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI());
	}

}
