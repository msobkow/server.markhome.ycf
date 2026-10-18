// Description: Java 25 Spring JPA Repository for SecSysGrp

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
 *	JpaRepository for the SecureJpaSecSysGrp entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecSysGrpRepository extends JpaRepository<SecureJpaSecSysGrp, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaSecSysGrp save(SecureJpaSecSysGrp obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecSysGrpId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSysGrp r where r.requiredSecSysGrpId = :secSysGrpId")
	SecureJpaSecSysGrp get(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	// SecureJpaSecSysGrp specified index readers

	/**
	 *	Read an entity using the columns of the SecureSecSysGrpByUNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSysGrp r where r.requiredName = :name")
	SecureJpaSecSysGrp findByUNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecSysGrpByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecSysGrp findByUNameIdx(ISecureSecSysGrpByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSysGrpBySecLevelIdxKey as arguments.
	 *
	 *		@param requiredSecLevel
	 *
	 *		@return List&lt;SecureJpaSecSysGrp&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSysGrp r where r.requiredSecLevel = :secLevel")
	List<SecureJpaSecSysGrp> findBySecLevelIdx(@Param("secLevel") ISecurePubSchema.SecLevelEnum requiredSecLevel);

	/**
	 *	SecureSecSysGrpBySecLevelIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpBySecLevelIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSysGrp> findBySecLevelIdx(ISecureSecSysGrpBySecLevelIdxKey key) {
		return( findBySecLevelIdx(key.getRequiredSecLevel()));
	}

	// SecureJpaSecSysGrp specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrp r where r.requiredSecSysGrpId = :secSysGrpId")
	SecureJpaSecSysGrp lockByIdIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrp r where r.requiredName = :name")
	SecureJpaSecSysGrp lockByUNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecSysGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecSysGrp lockByUNameIdx(ISecureSecSysGrpByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecLevel
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysGrp r where r.requiredSecLevel = :secLevel")
	List<SecureJpaSecSysGrp> lockBySecLevelIdx(@Param("secLevel") ISecurePubSchema.SecLevelEnum requiredSecLevel);

	/**
	 *	SecureSecSysGrpBySecLevelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSysGrp> lockBySecLevelIdx(ISecureSecSysGrpBySecLevelIdxKey key) {
		return( lockBySecLevelIdx(key.getRequiredSecLevel()));
	}

	// SecureJpaSecSysGrp specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysGrpId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrp r where r.requiredSecSysGrpId = :secSysGrpId")
	void deleteByIdIdx(@Param("secSysGrpId") IYCFKeyHash256 requiredSecSysGrpId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrp r where r.requiredName = :name")
	void deleteByUNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureSecSysGrpByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(ISecureSecSysGrpByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecLevel
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysGrp r where r.requiredSecLevel = :secLevel")
	void deleteBySecLevelIdx(@Param("secLevel") ISecurePubSchema.SecLevelEnum requiredSecLevel);

	/**
	 *	SecureSecSysGrpBySecLevelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysGrpBySecLevelIdxKey of the entity to be locked.
	 */
	default void deleteBySecLevelIdx(ISecureSecSysGrpBySecLevelIdxKey key) {
		deleteBySecLevelIdx(key.getRequiredSecLevel());
	}

}
