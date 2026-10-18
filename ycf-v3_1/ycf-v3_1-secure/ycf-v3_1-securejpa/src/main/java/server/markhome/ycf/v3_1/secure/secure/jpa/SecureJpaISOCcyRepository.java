// Description: Java 25 Spring JPA Repository for ISOCcy

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
 *	JpaRepository for the SecureJpaISOCcy entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaISOCcyRepository extends JpaRepository<SecureJpaISOCcy, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaISOCcy save(SecureJpaISOCcy obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredISOCcyId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCcy r where r.requiredISOCcyId = :iSOCcyId")
	SecureJpaISOCcy get(@Param("iSOCcyId") short requiredISOCcyId);

	// SecureJpaISOCcy specified index readers

	/**
	 *	Read an entity using the columns of the SecureISOCcyByCcyCdIdxKey as arguments.
	 *
	 *		@param requiredISOCode
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCcy r where r.requiredISOCode = :iSOCode")
	SecureJpaISOCcy findByCcyCdIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCcyByCcyCdIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCcyByCcyCdIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOCcy findByCcyCdIdx(ISecureISOCcyByCcyCdIdxKey key) {
		return( findByCcyCdIdx(key.getRequiredISOCode()));
	}

	/**
	 *	Read an entity using the columns of the SecureISOCcyByCcyNmIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOCcy r where r.requiredName = :name")
	SecureJpaISOCcy findByCcyNmIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCcyByCcyNmIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOCcyByCcyNmIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOCcy findByCcyNmIdx(ISecureISOCcyByCcyNmIdxKey key) {
		return( findByCcyNmIdx(key.getRequiredName()));
	}

	// SecureJpaISOCcy specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCcyId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCcy r where r.requiredISOCcyId = :iSOCcyId")
	SecureJpaISOCcy lockByIdIdx(@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOCcy r where r.requiredISOCode = :iSOCode")
	SecureJpaISOCcy lockByCcyCdIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCcyByCcyCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOCcy lockByCcyCdIdx(ISecureISOCcyByCcyCdIdxKey key) {
		return( lockByCcyCdIdx(key.getRequiredISOCode()));
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
	@Query("select r from SecureJpaISOCcy r where r.requiredName = :name")
	SecureJpaISOCcy lockByCcyNmIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCcyByCcyNmIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOCcy lockByCcyNmIdx(ISecureISOCcyByCcyNmIdxKey key) {
		return( lockByCcyNmIdx(key.getRequiredName()));
	}

	// SecureJpaISOCcy specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCcyId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCcy r where r.requiredISOCcyId = :iSOCcyId")
	void deleteByIdIdx(@Param("iSOCcyId") short requiredISOCcyId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOCode
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCcy r where r.requiredISOCode = :iSOCode")
	void deleteByCcyCdIdx(@Param("iSOCode") String requiredISOCode);

	/**
	 *	SecureISOCcyByCcyCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCcyByCcyCdIdxKey of the entity to be locked.
	 */
	default void deleteByCcyCdIdx(ISecureISOCcyByCcyCdIdxKey key) {
		deleteByCcyCdIdx(key.getRequiredISOCode());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOCcy r where r.requiredName = :name")
	void deleteByCcyNmIdx(@Param("name") String requiredName);

	/**
	 *	SecureISOCcyByCcyNmIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOCcyByCcyNmIdxKey of the entity to be locked.
	 */
	default void deleteByCcyNmIdx(ISecureISOCcyByCcyNmIdxKey key) {
		deleteByCcyNmIdx(key.getRequiredName());
	}

}
