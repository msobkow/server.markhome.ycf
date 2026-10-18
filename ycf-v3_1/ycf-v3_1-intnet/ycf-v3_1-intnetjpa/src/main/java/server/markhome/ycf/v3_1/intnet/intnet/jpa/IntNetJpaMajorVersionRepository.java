// Description: Java 25 Spring JPA Repository for MajorVersion

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

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

/**
 *	JpaRepository for the IntNetJpaMajorVersion entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface IntNetJpaMajorVersionRepository extends JpaRepository<IntNetJpaMajorVersion, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	IntNetJpaMajorVersion save(IntNetJpaMajorVersion obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaMajorVersion r where r.requiredId = :id")
	IntNetJpaMajorVersion get(@Param("id") IYCFKeyHash256 requiredId);

	// IntNetJpaMajorVersion specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetMajorVersionByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;IntNetJpaMajorVersion&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaMajorVersion r where r.requiredTenantId = :tenantId")
	List<IntNetJpaMajorVersion> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetMajorVersionByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaMajorVersion> findByTenantIdx(IIntNetMajorVersionByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetMajorVersionBySubProjectIdxKey as arguments.
	 *
	 *		@param requiredSubProjectId
	 *
	 *		@return List&lt;IntNetJpaMajorVersion&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId")
	List<IntNetJpaMajorVersion> findBySubProjectIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId);

	/**
	 *	IntNetMajorVersionBySubProjectIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionBySubProjectIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaMajorVersion> findBySubProjectIdx(IIntNetMajorVersionBySubProjectIdxKey key) {
		return( findBySubProjectIdx(key.getRequiredSubProjectId()));
	}

	/**
	 *	Read an entity using the columns of the IntNetMajorVersionByNameIdxKey as arguments.
	 *
	 *		@param requiredSubProjectId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId and r.requiredName = :name")
	IntNetJpaMajorVersion findByNameIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId,
		@Param("name") String requiredName);

	/**
	 *	IntNetMajorVersionByNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default IntNetJpaMajorVersion findByNameIdx(IIntNetMajorVersionByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredSubProjectId(), key.getRequiredName()));
	}

	// IntNetJpaMajorVersion specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMajorVersion r where r.requiredId = :id")
	IntNetJpaMajorVersion lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMajorVersion r where r.requiredTenantId = :tenantId")
	List<IntNetJpaMajorVersion> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetMajorVersionByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaMajorVersion> lockByTenantIdx(IIntNetMajorVersionByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSubProjectId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId")
	List<IntNetJpaMajorVersion> lockBySubProjectIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId);

	/**
	 *	IntNetMajorVersionBySubProjectIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaMajorVersion> lockBySubProjectIdx(IIntNetMajorVersionBySubProjectIdxKey key) {
		return( lockBySubProjectIdx(key.getRequiredSubProjectId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSubProjectId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId and r.requiredName = :name")
	IntNetJpaMajorVersion lockByNameIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId,
		@Param("name") String requiredName);

	/**
	 *	IntNetMajorVersionByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default IntNetJpaMajorVersion lockByNameIdx(IIntNetMajorVersionByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredSubProjectId(), key.getRequiredName()));
	}

	// IntNetJpaMajorVersion specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMajorVersion r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMajorVersion r where r.requiredTenantId = :tenantId")
	void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetMajorVersionByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionByTenantIdxKey of the entity to be locked.
	 */
	default void deleteByTenantIdx(IIntNetMajorVersionByTenantIdxKey key) {
		deleteByTenantIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSubProjectId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId")
	void deleteBySubProjectIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId);

	/**
	 *	IntNetMajorVersionBySubProjectIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionBySubProjectIdxKey of the entity to be locked.
	 */
	default void deleteBySubProjectIdx(IIntNetMajorVersionBySubProjectIdxKey key) {
		deleteBySubProjectIdx(key.getRequiredSubProjectId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSubProjectId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMajorVersion r where r.requiredContainerParentSPrj.requiredId = :subProjectId and r.requiredName = :name")
	void deleteByNameIdx(@Param("subProjectId") IYCFKeyHash256 requiredSubProjectId,
		@Param("name") String requiredName);

	/**
	 *	IntNetMajorVersionByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetMajorVersionByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(IIntNetMajorVersionByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredSubProjectId(), key.getRequiredName());
	}

}
