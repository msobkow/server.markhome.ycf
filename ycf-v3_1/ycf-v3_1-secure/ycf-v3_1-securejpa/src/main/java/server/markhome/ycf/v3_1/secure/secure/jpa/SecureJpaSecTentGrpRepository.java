// Description: Java 25 Spring JPA Repository for SecTentGrp

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
 *	JpaRepository for the SecureJpaSecTentGrp entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecTentGrpRepository extends JpaRepository<SecureJpaSecTentGrp, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecTentGrp save(SecureJpaSecTentGrp obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecTentGrpId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecTentGrp r where r.requiredSecTentGrpId = :secTentGrpId")
	SecureJpaSecTentGrp get(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	// SecureJpaSecTentGrp specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentGrpByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;SecureJpaSecTentGrp&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId")
	List<SecureJpaSecTentGrp> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	SecureSecTentGrpByTenantIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentGrp> findByTenantIdx(ISecureSecTentGrpByTenantIdxKey key) {
		return( findByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentGrpByNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return List&lt;SecureJpaSecTentGrp&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentGrp r where r.requiredContainerSysGrp.requiredName = :name")
	List<SecureJpaSecTentGrp> findByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentGrp> findByNameIdx(ISecureSecTentGrpByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredName()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecTentGrpByUNameIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId and r.requiredContainerSysGrp.requiredName = :name")
	SecureJpaSecTentGrp findByUNameIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecTentGrp findByUNameIdx(ISecureSecTentGrpByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredTenantId(), key.getRequiredName()));
	}

	// SecureJpaSecTentGrp specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentGrp r where r.requiredSecTentGrpId = :secTentGrpId")
	SecureJpaSecTentGrp lockByIdIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId")
	List<SecureJpaSecTentGrp> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	SecureSecTentGrpByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentGrp> lockByTenantIdx(ISecureSecTentGrpByTenantIdxKey key) {
		return( lockByTenantIdx(key.getRequiredTenantId()));
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
	@Query("select r from SecureJpaSecTentGrp r where r.requiredContainerSysGrp.requiredName = :name")
	List<SecureJpaSecTentGrp> lockByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentGrp> lockByNameIdx(ISecureSecTentGrpByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId and r.requiredContainerSysGrp.requiredName = :name")
	SecureJpaSecTentGrp lockByUNameIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecTentGrp lockByUNameIdx(ISecureSecTentGrpByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredTenantId(), key.getRequiredName()));
	}

	// SecureJpaSecTentGrp specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrp r where r.requiredSecTentGrpId = :secTentGrpId")
	void deleteByIdIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId")
	void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId);

	/**
	 *	SecureSecTentGrpByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByTenantIdxKey of the entity to be locked.
	 */
	default void deleteByTenantIdx(ISecureSecTentGrpByTenantIdxKey key) {
		deleteByTenantIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrp r where r.requiredContainerSysGrp.requiredName = :name")
	void deleteByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(ISecureSecTentGrpByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrp r where r.requiredOwnerTenant.requiredId = :tenantId and r.requiredContainerSysGrp.requiredName = :name")
	void deleteByUNameIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("name") String requiredName);

	/**
	 *	SecureSecTentGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(ISecureSecTentGrpByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredTenantId(), key.getRequiredName());
	}

}
