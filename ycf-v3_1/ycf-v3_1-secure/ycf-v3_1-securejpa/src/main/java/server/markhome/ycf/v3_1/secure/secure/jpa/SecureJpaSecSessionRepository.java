// Description: Java 25 Spring JPA Repository for SecSession

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
 *	JpaRepository for the SecureJpaSecSession entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecSessionRepository extends JpaRepository<SecureJpaSecSession, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecSession save(SecureJpaSecSession obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecSessionId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSession r where r.requiredSecSessionId = :secSessionId")
	SecureJpaSecSession get(@Param("secSessionId") IYCFKeyHash256 requiredSecSessionId);

	// SecureJpaSecSession specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSessionBySecUserIdxKey as arguments.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return List&lt;SecureJpaSecSession&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId")
	List<SecureJpaSecSession> findBySecUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecSessionBySecUserIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSessionBySecUserIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSession> findBySecUserIdx(ISecureSecSessionBySecUserIdxKey key) {
		return( findBySecUserIdx(key.getRequiredSecUserId()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecSessionByStartIdxKey as arguments.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredStart
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.requiredStart = :start")
	SecureJpaSecSession findByStartIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("start") LocalDateTime requiredStart);

	/**
	 *	SecureSecSessionByStartIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSessionByStartIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecSession findByStartIdx(ISecureSecSessionByStartIdxKey key) {
		return( findByStartIdx(key.getRequiredSecUserId(), key.getRequiredStart()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSessionByFinishIdxKey as arguments.
	 *
	 *		@param requiredSecUserId
	 *		@param optionalFinish
	 *
	 *		@return List&lt;SecureJpaSecSession&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.optionalFinish = :finish")
	List<SecureJpaSecSession> findByFinishIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("finish") LocalDateTime optionalFinish);

	/**
	 *	SecureSecSessionByFinishIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSessionByFinishIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSession> findByFinishIdx(ISecureSecSessionByFinishIdxKey key) {
		return( findByFinishIdx(key.getRequiredSecUserId(), key.getOptionalFinish()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSessionBySecProxyIdxKey as arguments.
	 *
	 *		@param optionalSecProxyId
	 *
	 *		@return List&lt;SecureJpaSecSession&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSession r where r.requiredParentSecProxy.requiredSecUserId = :secProxyId")
	List<SecureJpaSecSession> findBySecProxyIdx(@Param("secProxyId") IYCFKeyHash256 optionalSecProxyId);

	/**
	 *	SecureSecSessionBySecProxyIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSessionBySecProxyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSession> findBySecProxyIdx(ISecureSecSessionBySecProxyIdxKey key) {
		return( findBySecProxyIdx(key.getOptionalSecProxyId()));
	}

	// SecureJpaSecSession specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSessionId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSession r where r.requiredSecSessionId = :secSessionId")
	SecureJpaSecSession lockByIdIdx(@Param("secSessionId") IYCFKeyHash256 requiredSecSessionId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId")
	List<SecureJpaSecSession> lockBySecUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecSessionBySecUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSession> lockBySecUserIdx(ISecureSecSessionBySecUserIdxKey key) {
		return( lockBySecUserIdx(key.getRequiredSecUserId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredStart
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.requiredStart = :start")
	SecureJpaSecSession lockByStartIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("start") LocalDateTime requiredStart);

	/**
	 *	SecureSecSessionByStartIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecSession lockByStartIdx(ISecureSecSessionByStartIdxKey key) {
		return( lockByStartIdx(key.getRequiredSecUserId(), key.getRequiredStart()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param optionalFinish
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.optionalFinish = :finish")
	List<SecureJpaSecSession> lockByFinishIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("finish") LocalDateTime optionalFinish);

	/**
	 *	SecureSecSessionByFinishIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSession> lockByFinishIdx(ISecureSecSessionByFinishIdxKey key) {
		return( lockByFinishIdx(key.getRequiredSecUserId(), key.getOptionalFinish()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalSecProxyId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSession r where r.requiredParentSecProxy.requiredSecUserId = :secProxyId")
	List<SecureJpaSecSession> lockBySecProxyIdx(@Param("secProxyId") IYCFKeyHash256 optionalSecProxyId);

	/**
	 *	SecureSecSessionBySecProxyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSession> lockBySecProxyIdx(ISecureSecSessionBySecProxyIdxKey key) {
		return( lockBySecProxyIdx(key.getOptionalSecProxyId()));
	}

	// SecureJpaSecSession specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSessionId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSession r where r.requiredSecSessionId = :secSessionId")
	void deleteByIdIdx(@Param("secSessionId") IYCFKeyHash256 requiredSecSessionId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId")
	void deleteBySecUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecSessionBySecUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSessionBySecUserIdxKey of the entity to be locked.
	 */
	default void deleteBySecUserIdx(ISecureSecSessionBySecUserIdxKey key) {
		deleteBySecUserIdx(key.getRequiredSecUserId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredStart
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.requiredStart = :start")
	void deleteByStartIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("start") LocalDateTime requiredStart);

	/**
	 *	SecureSecSessionByStartIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSessionByStartIdxKey of the entity to be locked.
	 */
	default void deleteByStartIdx(ISecureSecSessionByStartIdxKey key) {
		deleteByStartIdx(key.getRequiredSecUserId(), key.getRequiredStart());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param optionalFinish
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSession r where r.requiredContainerSecUser.requiredSecUserId = :secUserId and r.optionalFinish = :finish")
	void deleteByFinishIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("finish") LocalDateTime optionalFinish);

	/**
	 *	SecureSecSessionByFinishIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSessionByFinishIdxKey of the entity to be locked.
	 */
	default void deleteByFinishIdx(ISecureSecSessionByFinishIdxKey key) {
		deleteByFinishIdx(key.getRequiredSecUserId(), key.getOptionalFinish());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalSecProxyId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSession r where r.requiredParentSecProxy.requiredSecUserId = :secProxyId")
	void deleteBySecProxyIdx(@Param("secProxyId") IYCFKeyHash256 optionalSecProxyId);

	/**
	 *	SecureSecSessionBySecProxyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSessionBySecProxyIdxKey of the entity to be locked.
	 */
	default void deleteBySecProxyIdx(ISecureSecSessionBySecProxyIdxKey key) {
		deleteBySecProxyIdx(key.getOptionalSecProxyId());
	}

}
