// Description: Java 25 Spring JPA Repository for SecClusRole

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secure.jpa;

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

/**
 *	JpaRepository for the SecureJpaSecClusRole entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecClusRoleRepository extends JpaRepository<SecureJpaSecClusRole, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecClusRole save(SecureJpaSecClusRole obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecClusRoleId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecClusRole r where r.requiredSecClusRoleId = :secClusRoleId")
	SecureJpaSecClusRole get(@Param("secClusRoleId") IYCFKeyHash256 requiredSecClusRoleId);

	// SecureJpaSecClusRole specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusRoleByClusterIdxKey as arguments.
	 *
	 *		@param requiredClusterId
	 *
	 *		@return List&lt;SecureJpaSecClusRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId")
	List<SecureJpaSecClusRole> findByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusRoleByClusterIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByClusterIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusRole> findByClusterIdx(ISecureSecClusRoleByClusterIdxKey key) {
		return( findByClusterIdx(key.getRequiredClusterId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusRoleByNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return List&lt;SecureJpaSecClusRole&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusRole r where r.requiredContainerSysRole.requiredName = :name")
	List<SecureJpaSecClusRole> findByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusRole> findByNameIdx(ISecureSecClusRoleByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredName()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecClusRoleByUNameIdxKey as arguments.
	 *
	 *		@param requiredClusterId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysRole.requiredName = :name")
	SecureJpaSecClusRole findByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecClusRole findByUNameIdx(ISecureSecClusRoleByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredClusterId(), key.getRequiredName()));
	}

	// SecureJpaSecClusRole specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusRoleId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusRole r where r.requiredSecClusRoleId = :secClusRoleId")
	SecureJpaSecClusRole lockByIdIdx(@Param("secClusRoleId") IYCFKeyHash256 requiredSecClusRoleId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId")
	List<SecureJpaSecClusRole> lockByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusRoleByClusterIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusRole> lockByClusterIdx(ISecureSecClusRoleByClusterIdxKey key) {
		return( lockByClusterIdx(key.getRequiredClusterId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusRole r where r.requiredContainerSysRole.requiredName = :name")
	List<SecureJpaSecClusRole> lockByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusRole> lockByNameIdx(ISecureSecClusRoleByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysRole.requiredName = :name")
	SecureJpaSecClusRole lockByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecClusRole lockByUNameIdx(ISecureSecClusRoleByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredClusterId(), key.getRequiredName()));
	}

	// SecureJpaSecClusRole specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusRoleId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusRole r where r.requiredSecClusRoleId = :secClusRoleId")
	void deleteByIdIdx(@Param("secClusRoleId") IYCFKeyHash256 requiredSecClusRoleId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId")
	void deleteByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusRoleByClusterIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByClusterIdxKey of the entity to be locked.
	 */
	default void deleteByClusterIdx(ISecureSecClusRoleByClusterIdxKey key) {
		deleteByClusterIdx(key.getRequiredClusterId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusRole r where r.requiredContainerSysRole.requiredName = :name")
	void deleteByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(ISecureSecClusRoleByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusRole r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysRole.requiredName = :name")
	void deleteByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusRoleByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusRoleByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(ISecureSecClusRoleByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredClusterId(), key.getRequiredName());
	}

}
