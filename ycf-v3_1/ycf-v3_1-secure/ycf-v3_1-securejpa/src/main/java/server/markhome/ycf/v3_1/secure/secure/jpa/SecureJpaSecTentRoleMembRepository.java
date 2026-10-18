// Description: Java 25 Spring JPA Repository for SecTentRoleMemb

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
 *	JpaRepository for the SecureJpaSecTentRoleMemb entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecTentRoleMembRepository extends JpaRepository<SecureJpaSecTentRoleMemb, SecureJpaSecTentRoleMembPKey> {

	@Transactional
	@Modifying
	SecureJpaSecTentRoleMemb save(SecureJpaSecTentRoleMemb obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecTentRoleId
	 *		@param requiredLoginId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecTentRoleMemb get(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecTentRoleMemb get(ISecureSecTentRoleMembPKey key) {
		return( get(key.getRequiredSecTentRoleId(), key.getRequiredLoginId()));
	}

	// SecureJpaSecTentRoleMemb specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentRoleMembByTentRoleIdxKey as arguments.
	 *
	 *		@param requiredSecTentRoleId
	 *
	 *		@return List&lt;SecureJpaSecTentRoleMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId")
	List<SecureJpaSecTentRoleMemb> findByTentRoleIdx(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId);

	/**
	 *	SecureSecTentRoleMembByTentRoleIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentRoleMembByTentRoleIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentRoleMemb> findByTentRoleIdx(ISecureSecTentRoleMembByTentRoleIdxKey key) {
		return( findByTentRoleIdx(key.getRequiredSecTentRoleId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecTentRoleMembByUserIdxKey as arguments.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return List&lt;SecureJpaSecTentRoleMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecTentRoleMemb> findByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembByUserIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecTentRoleMembByUserIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecTentRoleMemb> findByUserIdx(ISecureSecTentRoleMembByUserIdxKey key) {
		return( findByUserIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecTentRoleMemb specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentRoleId
	 *		@param requiredLoginId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecTentRoleMemb lockByIdIdx(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecTentRoleMemb lockByIdIdx(ISecureSecTentRoleMembPKey key) {
		return( lockByIdIdx(key.getRequiredSecTentRoleId(), key.getRequiredLoginId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentRoleId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId")
	List<SecureJpaSecTentRoleMemb> lockByTentRoleIdx(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId);

	/**
	 *	SecureSecTentRoleMembByTentRoleIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentRoleMemb> lockByTentRoleIdx(ISecureSecTentRoleMembByTentRoleIdxKey key) {
		return( lockByTentRoleIdx(key.getRequiredSecTentRoleId()));
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
	@Query("select r from SecureJpaSecTentRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecTentRoleMemb> lockByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecTentRoleMemb> lockByUserIdx(ISecureSecTentRoleMembByUserIdxKey key) {
		return( lockByUserIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecTentRoleMemb specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentRoleId
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByIdIdx(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentRoleMembByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecTentRoleMembPKey key) {
		deleteByIdIdx(key.getRequiredSecTentRoleId(), key.getRequiredLoginId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecTentRoleId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentRoleMemb r where r.requiredContainerRole.requiredSecTentRoleId = :secTentRoleId")
	void deleteByTentRoleIdx(@Param("secTentRoleId") IYCFKeyHash256 requiredSecTentRoleId);

	/**
	 *	SecureSecTentRoleMembByTentRoleIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentRoleMembByTentRoleIdxKey of the entity to be locked.
	 */
	default void deleteByTentRoleIdx(ISecureSecTentRoleMembByTentRoleIdxKey key) {
		deleteByTentRoleIdx(key.getRequiredSecTentRoleId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecTentRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByUserIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecTentRoleMembByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecTentRoleMembByUserIdxKey of the entity to be locked.
	 */
	default void deleteByUserIdx(ISecureSecTentRoleMembByUserIdxKey key) {
		deleteByUserIdx(key.getRequiredLoginId());
	}

}
