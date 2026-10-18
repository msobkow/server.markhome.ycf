// Description: Java 25 Spring JPA Repository for ISOCtry

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
 *	JpaRepository for the SecureJpaISOCtry entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaISOCtryRepository extends JpaRepository<SecureJpaISOCtry, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaISOCtry save(SecureJpaISOCtry obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredISOCtryId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCtry r where r.requiredISOCtryId = :iSOCtryId")
	SecureJpaISOCtry get(@Param("iSOCtryId") short requiredISOCtryId);

	// SecureJpaISOCtry specified index readers

	/**
	 *	Read an entity using the columns of the SecureISOCtryByISOCodeIdxKey as arguments.
	 *
	 *		@param requiredISOCode
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCtry r where r.requiredISOCode = :iSOCode")
	SecureJpaISOCtry findByISOCodeIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCtryByISOCodeIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCtryByISOCodeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOCtry findByISOCodeIdx(ISecureISOCtryByISOCodeIdxKey key) {
		return( findByISOCodeIdx(key.getRequiredISOCode()));
	}

	/**
	 *	Read an entity using the columns of the SecureISOCtryByNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCtry r where r.requiredName = :name")
	SecureJpaISOCtry findByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCtryByNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCtryByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOCtry findByNameIdx(ISecureISOCtryByNameIdxKey key) {
		return( findByNameIdx(key.getRequiredName()));
	}

	// SecureJpaISOCtry specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtry r where r.requiredISOCtryId = :iSOCtryId")
	SecureJpaISOCtry lockByIdIdx(@Param("iSOCtryId") short requiredISOCtryId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtry r where r.requiredISOCode = :iSOCode")
	SecureJpaISOCtry lockByISOCodeIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCtryByISOCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOCtry lockByISOCodeIdx(ISecureISOCtryByISOCodeIdxKey key) {
		return( lockByISOCodeIdx(key.getRequiredISOCode()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCtry r where r.requiredName = :name")
	SecureJpaISOCtry lockByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCtryByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOCtry lockByNameIdx(ISecureISOCtryByNameIdxKey key) {
		return( lockByNameIdx(key.getRequiredName()));
	}

	// SecureJpaISOCtry specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCtryId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtry r where r.requiredISOCtryId = :iSOCtryId")
	void deleteByIdIdx(@Param("iSOCtryId") short requiredISOCtryId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCode
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtry r where r.requiredISOCode = :iSOCode")
	void deleteByISOCodeIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCtryByISOCodeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCtryByISOCodeIdxKey of the entity to be locked.
	 */
	default void deleteByISOCodeIdx(ISecureISOCtryByISOCodeIdxKey key) {
		deleteByISOCodeIdx(key.getRequiredISOCode());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCtry r where r.requiredName = :name")
	void deleteByNameIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCtryByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCtryByNameIdxKey of the entity to be locked.
	 */
	default void deleteByNameIdx(ISecureISOCtryByNameIdxKey key) {
		deleteByNameIdx(key.getRequiredName());
	}

}
