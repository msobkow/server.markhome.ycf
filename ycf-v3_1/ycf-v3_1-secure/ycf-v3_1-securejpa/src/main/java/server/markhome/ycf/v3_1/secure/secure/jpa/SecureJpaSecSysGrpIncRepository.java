// Description: Java 25 Spring JPA Repository for SecSysGrpInc

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
 *	JpaRepository for the SecureJpaSecSysGrpInc entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecSysGrpIncRepository extends JpaRepository<SecureJpaSecSysGrpInc, SecureJpaSecSysGrpIncPKey> {

	@Transactional
	@Modifying
	SecureJpaSecSysGrpInc save(SecureJpaSecSysGrpInc obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecSysGrpId
	 *		@param requiredInclName
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId and r.requiredParentSubGroup.requiredName = :inclName")
	SecureJpaSecSysGrpInc get(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId,
		@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecSysGrpInc get(ISecureSecSysGrpIncPKey key) {
		return( get(key.getRequiredSecSysGrpId(), key.getRequiredInclName()));
	}

	// SecureJpaSecSysGrpInc specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSysGrpIncBySysGrpIdxKey as arguments.
	 *
	 *		@param requiredSecSysGrpId
	 *
	 *		@return List&lt;SecureJpaSecSysGrpInc&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId")
	List<SecureJpaSecSysGrpInc> findBySysGrpIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	/**
	 *	SecureSecSysGrpIncBySysGrpIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpIncBySysGrpIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSysGrpInc> findBySysGrpIdx(ISecureSecSysGrpIncBySysGrpIdxKey key) {
		return( findBySysGrpIdx(key.getRequiredSecSysGrpId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSysGrpIncByNameIdxKey as arguments.
	 *
	 *		@param requiredInclName
	 *
	 *		@return List&lt;SecureJpaSecSysGrpInc&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredParentSubGroup.requiredName = :inclName")
	List<SecureJpaSecSysGrpInc> findByNameIdx(@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncByNameIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpIncByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSysGrpInc> findByNameIdx(ISecureSecSysGrpIncByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredInclName()));
	}

	// SecureJpaSecSysGrpInc specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 *		@param requiredInclName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId and r.requiredParentSubGroup.requiredName = :inclName")
	SecureJpaSecSysGrpInc lockByIdIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId,
		@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecSysGrpInc lockByIdIdx(ISecureSecSysGrpIncPKey key) {
		return( lockByIdIdx(key.getRequiredSecSysGrpId(), key.getRequiredInclName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId")
	List<SecureJpaSecSysGrpInc> lockBySysGrpIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	/**
	 *	SecureSecSysGrpIncBySysGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSysGrpInc> lockBySysGrpIdx(ISecureSecSysGrpIncBySysGrpIdxKey key) {
		return( lockBySysGrpIdx(key.getRequiredSecSysGrpId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredInclName
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrpInc r where r.requiredParentSubGroup.requiredName = :inclName")
	List<SecureJpaSecSysGrpInc> lockByNameIdx(@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSysGrpInc> lockByNameIdx(ISecureSecSysGrpIncByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredInclName()));
	}

	// SecureJpaSecSysGrpInc specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 *		@param requiredInclName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId and r.requiredParentSubGroup.requiredName = :inclName")
	void deleteByIdIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId,
		@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpIncByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecSysGrpIncPKey key) {
		deleteByIdIdx(key.getRequiredSecSysGrpId(), key.getRequiredInclName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrpInc r where r.requiredContainerGroup.requiredSecSysGrpId = :secSysGrpId")
	void deleteBySysGrpIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	/**
	 *	SecureSecSysGrpIncBySysGrpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpIncBySysGrpIdxKey of the entity to be locked.
	 */
	default void deleteBySysGrpIdx(ISecureSecSysGrpIncBySysGrpIdxKey key) {
		deleteBySysGrpIdx(key.getRequiredSecSysGrpId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredInclName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrpInc r where r.requiredParentSubGroup.requiredName = :inclName")
	void deleteByNameIdx(@Param("inclName") String requiredInclName);

	/**
	 *	SecureSecSysGrpIncByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpIncByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(ISecureSecSysGrpIncByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredInclName());
	}

}
