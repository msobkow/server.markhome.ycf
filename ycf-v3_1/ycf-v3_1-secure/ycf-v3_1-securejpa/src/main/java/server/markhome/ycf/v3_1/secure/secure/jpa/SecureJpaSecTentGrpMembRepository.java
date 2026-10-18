// Description: Java 25 Spring JPA Repository for SecTentGrpMemb

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
 *	JpaRepository for the SecureJpaSecTentGrpMemb entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecTentGrpMembRepository extends JpaRepository<SecureJpaSecTentGrpMemb, SecureJpaSecTentGrpMembPKey> {

	@Transactional
	@Modifying
	SecureJpaSecTentGrpMemb save(SecureJpaSecTentGrpMemb obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecTentGrpId
	 *		@param requiredLoginId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecTentGrpMemb get(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecTentGrpMemb get(ISecureSecTentGrpMembPKey key) {
		return( get(key.getRequiredSecTentGrpId(), key.getRequiredLoginId()));
	}

	// SecureJpaSecTentGrpMemb specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentGrpMembByTentGrpIdxKey as arguments.
	 *
	 *		@param requiredSecTentGrpId
	 *
	 *		@return List&lt;SecureJpaSecTentGrpMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId")
	List<SecureJpaSecTentGrpMemb> findByTentGrpIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	/**
	 *	SecureSecTentGrpMembByTentGrpIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpMembByTentGrpIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentGrpMemb> findByTentGrpIdx(ISecureSecTentGrpMembByTentGrpIdxKey key) {
		return( findByTentGrpIdx(key.getRequiredSecTentGrpId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentGrpMembByUserIdxKey as arguments.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return List&lt;SecureJpaSecTentGrpMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecTentGrpMemb> findByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembByUserIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpMembByUserIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentGrpMemb> findByUserIdx(ISecureSecTentGrpMembByUserIdxKey key) {
		return( findByUserIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecTentGrpMemb specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 *		@param requiredLoginId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecTentGrpMemb lockByIdIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecTentGrpMemb lockByIdIdx(ISecureSecTentGrpMembPKey key) {
		return( lockByIdIdx(key.getRequiredSecTentGrpId(), key.getRequiredLoginId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId")
	List<SecureJpaSecTentGrpMemb> lockByTentGrpIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	/**
	 *	SecureSecTentGrpMembByTentGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentGrpMemb> lockByTentGrpIdx(ISecureSecTentGrpMembByTentGrpIdxKey key) {
		return( lockByTentGrpIdx(key.getRequiredSecTentGrpId()));
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
	@Query("select r from SecureJpaSecTentGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecTentGrpMemb> lockByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentGrpMemb> lockByUserIdx(ISecureSecTentGrpMembByUserIdxKey key) {
		return( lockByUserIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecTentGrpMemb specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId and r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByIdIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpMembByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecTentGrpMembPKey key) {
		deleteByIdIdx(key.getRequiredSecTentGrpId(), key.getRequiredLoginId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrpMemb r where r.requiredContainerGroup.requiredSecTentGrpId = :secTentGrpId")
	void deleteByTentGrpIdx(@Param("secTentGrpId") IYCFKeyHash256 requiredSecTentGrpId);

	/**
	 *	SecureSecTentGrpMembByTentGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpMembByTentGrpIdxKey of the entity to be locked.
	 */
	default void deleteByTentGrpIdx(ISecureSecTentGrpMembByTentGrpIdxKey key) {
		deleteByTentGrpIdx(key.getRequiredSecTentGrpId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentGrpMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentGrpMembByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentGrpMembByUserIdxKey of the entity to be locked.
	 */
	default void deleteByUserIdx(ISecureSecTentGrpMembByUserIdxKey key) {
		deleteByUserIdx(key.getRequiredLoginId());
	}

}
