// Description: Java 25 Spring JPA Repository for TopDomain

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
 *	JpaRepository for the IntNetJpaTopDomain entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface IntNetJpaTopDomainRepository extends JpaRepository<IntNetJpaTopDomain, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	IntNetJpaTopDomain save(IntNetJpaTopDomain obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaTopDomain r where r.requiredId = :id")
	IntNetJpaTopDomain get(@Param("id") IYCFKeyHash256 requiredId);

	// IntNetJpaTopDomain specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetTopDomainByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;IntNetJpaTopDomain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaTopDomain r where r.requiredTenantId = :tenantId")
	List<IntNetJpaTopDomain> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopDomainByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaTopDomain> findByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the IntNetTopDomainByTldIdxKey as arguments.
	 *
	 *		@param requiredTldId
	 *
	 *		@return List&lt;IntNetJpaTopDomain&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId")
	List<IntNetJpaTopDomain> findByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId);

	/**
	 *	IntNetTopDomainByTldIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByTldIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<IntNetJpaTopDomain> findByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		return( findByTldIdx(key.getRequiredTldId()));
	}

	/**
	 *	Read an entity using the columns of the IntNetTopDomainByNameIdxKey as arguments.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId and r.requiredName = :name")
	IntNetJpaTopDomain findByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopDomainByNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default IntNetJpaTopDomain findByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredTldId(), key.getRequiredName()));
	}

	// IntNetJpaTopDomain specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopDomain r where r.requiredId = :id")
	IntNetJpaTopDomain lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopDomain r where r.requiredTenantId = :tenantId")
	List<IntNetJpaTopDomain> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopDomainByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaTopDomain> lockByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId")
	List<IntNetJpaTopDomain> lockByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId);

	/**
	 *	IntNetTopDomainByTldIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<IntNetJpaTopDomain> lockByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		return( lockByTldIdx(key.getRequiredTldId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId and r.requiredName = :name")
	IntNetJpaTopDomain lockByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopDomainByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default IntNetJpaTopDomain lockByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredTldId(), key.getRequiredName()));
	}

	// IntNetJpaTopDomain specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopDomain r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopDomain r where r.requiredTenantId = :tenantId")
	void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	IntNetTopDomainByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByTenantIdxKey of the entity to be locked.
	 */
	default void deleteByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		deleteByTenantIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId")
	void deleteByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId);

	/**
	 *	IntNetTopDomainByTldIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByTldIdxKey of the entity to be locked.
	 */
	default void deleteByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		deleteByTldIdx(key.getRequiredTldId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaTopDomain r where r.requiredContainerParentTld.requiredId = :tldId and r.requiredName = :name")
	void deleteByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName);

	/**
	 *	IntNetTopDomainByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetTopDomainByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredTldId(), key.getRequiredName());
	}

}
