// Description: Java 25 Spring JPA Repository for SecUserPWHistory

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
 *	JpaRepository for the SecureJpaSecUserPWHistory entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecUserPWHistoryRepository extends JpaRepository<SecureJpaSecUserPWHistory, SecureJpaSecUserPWHistoryPKey> {

	@Transactional
	@Modifying
	SecureJpaSecUserPWHistory save(SecureJpaSecUserPWHistory obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredPWSetStamp
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId and r.pkey.requiredPWSetStamp = :pWSetStamp")
	SecureJpaSecUserPWHistory get(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory get(ISecureSecUserPWHistoryPKey key) {
		return( get(key.getRequiredSecUserId(), key.getRequiredPWSetStamp()));
	}

	// SecureJpaSecUserPWHistory specified index readers

	/**
	 *	Read an entity using the columns of the SecureSecUserPWHistoryByUserIdxKey as arguments.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId")
	SecureJpaSecUserPWHistory findByUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecUserPWHistoryByUserIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryByUserIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory findByUserIdx(ISecureSecUserPWHistoryByUserIdxKey key) {
		return( findByUserIdx(key.getRequiredSecUserId()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecUserPWHistoryBySetStampIdxKey as arguments.
	 *
	 *		@param requiredPWSetStamp
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredPWSetStamp = :pWSetStamp")
	SecureJpaSecUserPWHistory findBySetStampIdx(@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryBySetStampIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryBySetStampIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory findBySetStampIdx(ISecureSecUserPWHistoryBySetStampIdxKey key) {
		return( findBySetStampIdx(key.getRequiredPWSetStamp()));
	}

	/**
	 *	Read an entity using the columns of the SecureSecUserPWHistoryByReplacedStampIdxKey as arguments.
	 *
	 *		@param requiredPWReplacedStamp
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUserPWHistory r where r.requiredPWReplacedStamp = :pWReplacedStamp")
	SecureJpaSecUserPWHistory findByReplacedStampIdx(@Param("pWReplacedStamp") LocalDateTime requiredPWReplacedStamp);

	/**
	 *	SecureSecUserPWHistoryByReplacedStampIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryByReplacedStampIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory findByReplacedStampIdx(ISecureSecUserPWHistoryByReplacedStampIdxKey key) {
		return( findByReplacedStampIdx(key.getRequiredPWReplacedStamp()));
	}

	// SecureJpaSecUserPWHistory specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredPWSetStamp
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId and r.pkey.requiredPWSetStamp = :pWSetStamp")
	SecureJpaSecUserPWHistory lockByIdIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory lockByIdIdx(ISecureSecUserPWHistoryPKey key) {
		return( lockByIdIdx(key.getRequiredSecUserId(), key.getRequiredPWSetStamp()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId")
	SecureJpaSecUserPWHistory lockByUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecUserPWHistoryByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory lockByUserIdx(ISecureSecUserPWHistoryByUserIdxKey key) {
		return( lockByUserIdx(key.getRequiredSecUserId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPWSetStamp
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUserPWHistory r where r.pkey.requiredPWSetStamp = :pWSetStamp")
	SecureJpaSecUserPWHistory lockBySetStampIdx(@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryBySetStampIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory lockBySetStampIdx(ISecureSecUserPWHistoryBySetStampIdxKey key) {
		return( lockBySetStampIdx(key.getRequiredPWSetStamp()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPWReplacedStamp
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUserPWHistory r where r.requiredPWReplacedStamp = :pWReplacedStamp")
	SecureJpaSecUserPWHistory lockByReplacedStampIdx(@Param("pWReplacedStamp") LocalDateTime requiredPWReplacedStamp);

	/**
	 *	SecureSecUserPWHistoryByReplacedStampIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecUserPWHistory lockByReplacedStampIdx(ISecureSecUserPWHistoryByReplacedStampIdxKey key) {
		return( lockByReplacedStampIdx(key.getRequiredPWReplacedStamp()));
	}

	// SecureJpaSecUserPWHistory specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *		@param requiredPWSetStamp
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId and r.pkey.requiredPWSetStamp = :pWSetStamp")
	void deleteByIdIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId,
		@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecUserPWHistoryPKey key) {
		deleteByIdIdx(key.getRequiredSecUserId(), key.getRequiredPWSetStamp());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUserPWHistory r where r.pkey.requiredSecUserId = :secUserId")
	void deleteByUserIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	SecureSecUserPWHistoryByUserIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryByUserIdxKey of the entity to be locked.
	 */
	default void deleteByUserIdx(ISecureSecUserPWHistoryByUserIdxKey key) {
		deleteByUserIdx(key.getRequiredSecUserId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPWSetStamp
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUserPWHistory r where r.pkey.requiredPWSetStamp = :pWSetStamp")
	void deleteBySetStampIdx(@Param("pWSetStamp") LocalDateTime requiredPWSetStamp);

	/**
	 *	SecureSecUserPWHistoryBySetStampIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryBySetStampIdxKey of the entity to be locked.
	 */
	default void deleteBySetStampIdx(ISecureSecUserPWHistoryBySetStampIdxKey key) {
		deleteBySetStampIdx(key.getRequiredPWSetStamp());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPWReplacedStamp
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUserPWHistory r where r.requiredPWReplacedStamp = :pWReplacedStamp")
	void deleteByReplacedStampIdx(@Param("pWReplacedStamp") LocalDateTime requiredPWReplacedStamp);

	/**
	 *	SecureSecUserPWHistoryByReplacedStampIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserPWHistoryByReplacedStampIdxKey of the entity to be locked.
	 */
	default void deleteByReplacedStampIdx(ISecureSecUserPWHistoryByReplacedStampIdxKey key) {
		deleteByReplacedStampIdx(key.getRequiredPWReplacedStamp());
	}

}
