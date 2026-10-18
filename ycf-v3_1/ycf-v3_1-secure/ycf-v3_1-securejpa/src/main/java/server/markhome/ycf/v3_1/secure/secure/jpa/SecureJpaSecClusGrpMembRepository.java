// Description: Java 25 Spring JPA Repository for SecClusGrpMemb

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
 *	JpaRepository for the SecureJpaSecClusGrpMemb entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecClusGrpMembRepository extends JpaRepository<SecureJpaSecClusGrpMemb, SecureJpaSecClusGrpMembPKey> {

	@Transactional
	@Modifying
	SecureJpaSecClusGrpMemb save(SecureJpaSecClusGrpMemb obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecClusGrpId
	 *		@param requiredLoginId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecClusGrpMemb get(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecClusGrpMemb get(ISecureSecClusGrpMembPKey key) {
		return( get(key.getRequiredSecClusGrpId(), key.getRequiredLoginId()));
	}

	// SecureJpaSecClusGrpMemb specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusGrpMembByClusGrpIdxKey as arguments.
	 *
	 *		@param requiredSecClusGrpId
	 *
	 *		@return List&lt;SecureJpaSecClusGrpMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId")
	List<SecureJpaSecClusGrpMemb> findByClusGrpIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	/**
	 *	SecureSecClusGrpMembByClusGrpIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpMembByClusGrpIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusGrpMemb> findByClusGrpIdx(ISecureSecClusGrpMembByClusGrpIdxKey key) {
		return( findByClusGrpIdx(key.getRequiredSecClusGrpId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecClusGrpMembByLoginIdxKey as arguments.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return List&lt;SecureJpaSecClusGrpMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecClusGrpMemb> findByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembByLoginIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpMembByLoginIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecClusGrpMemb> findByLoginIdx(ISecureSecClusGrpMembByLoginIdxKey key) {
		return( findByLoginIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecClusGrpMemb specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 *		@param requiredLoginId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecClusGrpMemb lockByIdIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecClusGrpMemb lockByIdIdx(ISecureSecClusGrpMembPKey key) {
		return( lockByIdIdx(key.getRequiredSecClusGrpId(), key.getRequiredLoginId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId")
	List<SecureJpaSecClusGrpMemb> lockByClusGrpIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	/**
	 *	SecureSecClusGrpMembByClusGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusGrpMemb> lockByClusGrpIdx(ISecureSecClusGrpMembByClusGrpIdxKey key) {
		return( lockByClusGrpIdx(key.getRequiredSecClusGrpId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecClusGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecClusGrpMemb> lockByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembByLoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecClusGrpMemb> lockByLoginIdx(ISecureSecClusGrpMembByLoginIdxKey key) {
		return( lockByLoginIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecClusGrpMemb specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByIdIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpMembByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecClusGrpMembPKey key) {
		deleteByIdIdx(key.getRequiredSecClusGrpId(), key.getRequiredLoginId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecClusGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrpMemb r where r.requiredContainerGroup.requiredSecClusGrpId = :secClusGrpId")
	void deleteByClusGrpIdx(@Param("secClusGrpId") IYCFKeyHash256 requiredSecClusGrpId);

	/**
	 *	SecureSecClusGrpMembByClusGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpMembByClusGrpIdxKey of the entity to be locked.
	 */
	default void deleteByClusGrpIdx(ISecureSecClusGrpMembByClusGrpIdxKey key) {
		deleteByClusGrpIdx(key.getRequiredSecClusGrpId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecClusGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecClusGrpMembByLoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecClusGrpMembByLoginIdxKey of the entity to be locked.
	 */
	default void deleteByLoginIdx(ISecureSecClusGrpMembByLoginIdxKey key) {
		deleteByLoginIdx(key.getRequiredLoginId());
	}

}
