// Description: Java 25 Spring JPA Repository for SecUser

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
 *	JpaRepository for the SecureJpaSecUser entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecUserRepository extends JpaRepository<SecureJpaSecUser, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecUser save(SecureJpaSecUser obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUser r where r.requiredSecUserId = :secUserId")
	SecureJpaSecUser get(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	// SecureJpaSecUser specified index readers

	/**
	 *	Read an entity using the columns of the SecureSecUserByULoginIdxKey as arguments.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecUser r where r.requiredLoginId = :loginId")
	SecureJpaSecUser findByULoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecUserByULoginIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecUserByULoginIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecUser findByULoginIdx(ISecureSecUserByULoginIdxKey key) {
		return( findByULoginIdx(key.getRequiredLoginId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecUserByEMAddrIdxKey as arguments.
	 *
	 *		@param requiredEMailAddress
	 *
	 *		@return List&lt;SecureJpaSecUser&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecUser r where r.requiredEMailAddress = :eMailAddress")
	List<SecureJpaSecUser> findByEMAddrIdx(@Param("eMailAddress") String requiredEMailAddress);

	/**
	 *	SecureSecUserByEMAddrIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecUserByEMAddrIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecUser> findByEMAddrIdx(ISecureSecUserByEMAddrIdxKey key) {
		return( findByEMAddrIdx(key.getRequiredEMailAddress()));
	}

	// SecureJpaSecUser specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUser r where r.requiredSecUserId = :secUserId")
	SecureJpaSecUser lockByIdIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUser r where r.requiredLoginId = :loginId")
	SecureJpaSecUser lockByULoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecUserByULoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecUser lockByULoginIdx(ISecureSecUserByULoginIdxKey key) {
		return( lockByULoginIdx(key.getRequiredLoginId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEMailAddress
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecUser r where r.requiredEMailAddress = :eMailAddress")
	List<SecureJpaSecUser> lockByEMAddrIdx(@Param("eMailAddress") String requiredEMailAddress);

	/**
	 *	SecureSecUserByEMAddrIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecUser> lockByEMAddrIdx(ISecureSecUserByEMAddrIdxKey key) {
		return( lockByEMAddrIdx(key.getRequiredEMailAddress()));
	}

	// SecureJpaSecUser specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecUserId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUser r where r.requiredSecUserId = :secUserId")
	void deleteByIdIdx(@Param("secUserId") IYCFKeyHash256 requiredSecUserId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUser r where r.requiredLoginId = :loginId")
	void deleteByULoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecUserByULoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserByULoginIdxKey of the entity to be locked.
	 */
	default void deleteByULoginIdx(ISecureSecUserByULoginIdxKey key) {
		deleteByULoginIdx(key.getRequiredLoginId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEMailAddress
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecUser r where r.requiredEMailAddress = :eMailAddress")
	void deleteByEMAddrIdx(@Param("eMailAddress") String requiredEMailAddress);

	/**
	 *	SecureSecUserByEMAddrIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecUserByEMAddrIdxKey of the entity to be locked.
	 */
	default void deleteByEMAddrIdx(ISecureSecUserByEMAddrIdxKey key) {
		deleteByEMAddrIdx(key.getRequiredEMailAddress());
	}

}
