// Description: Java 25 Spring JPA Repository for ISOCtryCcy

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
 *	JpaRepository for the SecureJpaISOCtryCcy entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaISOCtryCcyRepository extends JpaRepository<SecureJpaISOCtryCcy, SecureJpaISOCtryCcyPKey> {

	@Transactional
	@Modifying
	SecureJpaISOCtryCcy save(SecureJpaISOCtryCcy obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredISOCtryId
	 *		@param requiredISOCcyId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId and r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	SecureJpaISOCtryCcy get(@Param("iSOCtryId") short requiredISOCtryId,
		@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOCtryCcy get(ISecureISOCtryCcyPKey key) {
		return( get(key.getRequiredISOCtryId(), key.getRequiredISOCcyId()));
	}

	// SecureJpaISOCtryCcy specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureISOCtryCcyByCtryIdxKey as arguments.
	 *
	 *		@param requiredISOCtryId
	 *
	 *		@return List&lt;SecureJpaISOCtryCcy&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId")
	List<SecureJpaISOCtryCcy> findByCtryIdx(@Param("iSOCtryId") short requiredISOCtryId);

	/**
	 *	SecureISOCtryCcyByCtryIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCtryCcyByCtryIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaISOCtryCcy> findByCtryIdx(ISecureISOCtryCcyByCtryIdxKey key) {
		return( findByCtryIdx(key.getRequiredISOCtryId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureISOCtryCcyByCcyIdxKey as arguments.
	 *
	 *		@param requiredISOCcyId
	 *
	 *		@return List&lt;SecureJpaISOCtryCcy&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	List<SecureJpaISOCtryCcy> findByCcyIdx(@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyByCcyIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCtryCcyByCcyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaISOCtryCcy> findByCcyIdx(ISecureISOCtryCcyByCcyIdxKey key) {
		return( findByCcyIdx(key.getRequiredISOCcyId()));
	}

	// SecureJpaISOCtryCcy specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 *		@param requiredISOCcyId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId and r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	SecureJpaISOCtryCcy lockByIdIdx(@Param("iSOCtryId") short requiredISOCtryId,
		@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOCtryCcy lockByIdIdx(ISecureISOCtryCcyPKey key) {
		return( lockByIdIdx(key.getRequiredISOCtryId(), key.getRequiredISOCcyId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId")
	List<SecureJpaISOCtryCcy> lockByCtryIdx(@Param("iSOCtryId") short requiredISOCtryId);

	/**
	 *	SecureISOCtryCcyByCtryIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaISOCtryCcy> lockByCtryIdx(ISecureISOCtryCcyByCtryIdxKey key) {
		return( lockByCtryIdx(key.getRequiredISOCtryId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCcyId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtryCcy r where r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	List<SecureJpaISOCtryCcy> lockByCcyIdx(@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyByCcyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaISOCtryCcy> lockByCcyIdx(ISecureISOCtryCcyByCcyIdxKey key) {
		return( lockByCcyIdx(key.getRequiredISOCcyId()));
	}

	// SecureJpaISOCtryCcy specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 *		@param requiredISOCcyId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId and r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	void deleteByIdIdx(@Param("iSOCtryId") short requiredISOCtryId,
		@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCtryCcyByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureISOCtryCcyPKey key) {
		deleteByIdIdx(key.getRequiredISOCtryId(), key.getRequiredISOCcyId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtryCcy r where r.requiredContainerCtry.requiredISOCtryId = :iSOCtryId")
	void deleteByCtryIdx(@Param("iSOCtryId") short requiredISOCtryId);

	/**
	 *	SecureISOCtryCcyByCtryIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCtryCcyByCtryIdxKey of the entity to be locked.
	 */
	default void deleteByCtryIdx(ISecureISOCtryCcyByCtryIdxKey key) {
		deleteByCtryIdx(key.getRequiredISOCtryId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCcyId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtryCcy r where r.requiredParentCcy.requiredISOCcyId = :iSOCcyId")
	void deleteByCcyIdx(@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	SecureISOCtryCcyByCcyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCtryCcyByCcyIdxKey of the entity to be locked.
	 */
	default void deleteByCcyIdx(ISecureISOCtryCcyByCcyIdxKey key) {
		deleteByCcyIdx(key.getRequiredISOCcyId());
	}

}
