// Description: Java 25 Spring JPA Repository for TopProject

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
 *	JpaRepository for the IntNetJpaTopProject entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface IntNetJpaTopProjectRepository extends JpaRepository<IntNetJpaTopProject, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	IntNetJpaTopProject save(IntNetJpaTopProject obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaTopProject r where r.requiredId = :id")
	IntNetJpaTopProject get(@Param("id") IYCFKeyHash256 requiredId);

	// IntNetJpaTopProject specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetTopProjectByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;IntNetJpaTopProject&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaTopProject r where r.requiredTenantId = :tenantId")
	List<IntNetJpaTopProject> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopProjectByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaTopProject> findByTenantIdx(IIntNetTopProjectByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetTopProjectByTopDomainIdxKey as arguments.
	 *
	 *		@param requiredTopDomainId
	 *
	 *		@return List&lt;IntNetJpaTopProject&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId")
	List<IntNetJpaTopProject> findByTopDomainIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId);

	/**
	 *	IntNetTopProjectByTopDomainIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByTopDomainIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaTopProject> findByTopDomainIdx(IIntNetTopProjectByTopDomainIdxKey key) {
		return( findByTopDomainIdx(key.getRequiredTopDomainId()));
	}

	/**
	 *	Read an entity using the columns of the IntNetTopProjectByNameIdxKey as arguments.
	 *
	 *		@param requiredTopDomainId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId and r.requiredName = :name")
	IntNetJpaTopProject findByNameIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopProjectByNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default IntNetJpaTopProject findByNameIdx(IIntNetTopProjectByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredTopDomainId(), key.getRequiredName()));
	}

	// IntNetJpaTopProject specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopProject r where r.requiredId = :id")
	IntNetJpaTopProject lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopProject r where r.requiredTenantId = :tenantId")
	List<IntNetJpaTopProject> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopProjectByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaTopProject> lockByTenantIdx(IIntNetTopProjectByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTopDomainId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId")
	List<IntNetJpaTopProject> lockByTopDomainIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId);

	/**
	 *	IntNetTopProjectByTopDomainIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaTopProject> lockByTopDomainIdx(IIntNetTopProjectByTopDomainIdxKey key) {
		return( lockByTopDomainIdx(key.getRequiredTopDomainId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTopDomainId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId and r.requiredName = :name")
	IntNetJpaTopProject lockByNameIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopProjectByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default IntNetJpaTopProject lockByNameIdx(IIntNetTopProjectByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredTopDomainId(), key.getRequiredName()));
	}

	// IntNetJpaTopProject specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopProject r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopProject r where r.requiredTenantId = :tenantId")
	void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopProjectByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByTenantIdxKey of the entity to be locked.
	 */
	default void deleteByTenantIdx(IIntNetTopProjectByTenantIdxKey key) {
		deleteByTenantIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTopDomainId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId")
	void deleteByTopDomainIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId);

	/**
	 *	IntNetTopProjectByTopDomainIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByTopDomainIdxKey of the entity to be locked.
	 */
	default void deleteByTopDomainIdx(IIntNetTopProjectByTopDomainIdxKey key) {
		deleteByTopDomainIdx(key.getRequiredTopDomainId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTopDomainId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopProject r where r.requiredContainerParentSDom.requiredId = :topDomainId and r.requiredName = :name")
	void deleteByNameIdx(@Param("topDomainId") IYCFKeyHash256 requiredTopDomainId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopProjectByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopProjectByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(IIntNetTopProjectByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredTopDomainId(), key.getRequiredName());
	}

}
