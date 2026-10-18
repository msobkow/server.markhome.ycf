// Description: Java 25 Spring JPA Repository for SecClusGrp

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
 *	JpaRepository for the SecureJpaSecClusGrp entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecClusGrpRepository extends JpaRepository<SecureJpaSecClusGrp, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecClusGrp save(SecureJpaSecClusGrp obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecClusGrpId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecClusGrp r where r.requiredSecClusGrpId = :secClusGrpId")
	SecureJpaSecClusGrp get(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	// SecureJpaSecClusGrp specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusGrpByClusterIdxKey as arguments.
	 *
	 *		@param requiredClusterId
	 *
	 *		@return List&lt;SecureJpaSecClusGrp&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId")
	List<SecureJpaSecClusGrp> findByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusGrpByClusterIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByClusterIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusGrp> findByClusterIdx(ISecureSecClusGrpByClusterIdxKey key) {
		return( findByClusterIdx(key.getRequiredClusterId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusGrpByNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return List&lt;SecureJpaSecClusGrp&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusGrp r where r.requiredContainerSysGrp.requiredName = :name")
	List<SecureJpaSecClusGrp> findByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusGrp> findByNameIdx(ISecureSecClusGrpByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredName()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecClusGrpByUNameIdxKey as arguments.
	 *
	 *		@param requiredClusterId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysGrp.requiredName = :name")
	SecureJpaSecClusGrp findByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecClusGrp findByUNameIdx(ISecureSecClusGrpByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredClusterId(), key.getRequiredName()));
	}

	// SecureJpaSecClusGrp specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusGrp r where r.requiredSecClusGrpId = :secClusGrpId")
	SecureJpaSecClusGrp lockByIdIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId")
	List<SecureJpaSecClusGrp> lockByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusGrpByClusterIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusGrp> lockByClusterIdx(ISecureSecClusGrpByClusterIdxKey key) {
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
	@Query("select r from SecureJpaSecClusGrp r where r.requiredContainerSysGrp.requiredName = :name")
	List<SecureJpaSecClusGrp> lockByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusGrp> lockByNameIdx(ISecureSecClusGrpByNameIdxKey key) {
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
	@Query("select r from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysGrp.requiredName = :name")
	SecureJpaSecClusGrp lockByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecClusGrp lockByUNameIdx(ISecureSecClusGrpByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredClusterId(), key.getRequiredName()));
	}

	// SecureJpaSecClusGrp specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrp r where r.requiredSecClusGrpId = :secClusGrpId")
	void deleteByIdIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredClusterId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId")
	void deleteByClusterIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId);

	/**
	 *	SecureSecClusGrpByClusterIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByClusterIdxKey of the entity to be locked.
	 */
	default void deleteByClusterIdx(ISecureSecClusGrpByClusterIdxKey key) {
		deleteByClusterIdx(key.getRequiredClusterId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrp r where r.requiredContainerSysGrp.requiredName = :name")
	void deleteByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(ISecureSecClusGrpByNameIdxKey key) {
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
	@Query("delete from SecureJpaSecClusGrp r where r.requiredOwnerCluster.requiredId = :clusterId and r.requiredContainerSysGrp.requiredName = :name")
	void deleteByUNameIdx(@Param("clusterId") IYCFKeyHash256 requiredClusterId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecClusGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(ISecureSecClusGrpByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredClusterId(), key.getRequiredName());
	}

}
