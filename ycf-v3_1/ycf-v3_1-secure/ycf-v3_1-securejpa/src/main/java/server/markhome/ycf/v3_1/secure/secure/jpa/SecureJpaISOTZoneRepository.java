// Description: Java 25 Spring JPA Repository for ISOTZone

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
 *	JpaRepository for the SecureJpaISOTZone entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaISOTZoneRepository extends JpaRepository<SecureJpaISOTZone, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaISOTZone save(SecureJpaISOTZone obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredISOTZoneId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOTZone r where r.requiredISOTZoneId = :iSOTZoneId")
	SecureJpaISOTZone get(@Param("iSOTZoneId") short requiredISOTZoneId);

	// SecureJpaISOTZone specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureISOTZoneByOffsetIdxKey as arguments.
	 *
	 *		@param requiredTZHourOffset
	 *		@param requiredTZMinOffset
	 *
	 *		@return List&lt;SecureJpaISOTZone&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaISOTZone r where r.requiredTZHourOffset = :tZHourOffset and r.requiredTZMinOffset = :tZMinOffset")
	List<SecureJpaISOTZone> findByOffsetIdx(@Param("tZHourOffset") short requiredTZHourOffset,
		@Param("tZMinOffset") short requiredTZMinOffset);

	/**
	 *	SecureISOTZoneByOffsetIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByOffsetIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaISOTZone> findByOffsetIdx(ISecureISOTZoneByOffsetIdxKey key) {
		return( findByOffsetIdx(key.getRequiredTZHourOffset(), key.getRequiredTZMinOffset()));
	}

	/**
	 *	Read an entity using the columns of the SecureISOTZoneByUTZNameIdxKey as arguments.
	 *
	 *		@param requiredTZName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaISOTZone r where r.requiredTZName = :tZName")
	SecureJpaISOTZone findByUTZNameIdx(@Param("tZName") String requiredTZName);

	/**
	 *	SecureISOTZoneByUTZNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByUTZNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaISOTZone findByUTZNameIdx(ISecureISOTZoneByUTZNameIdxKey key) {
		return( findByUTZNameIdx(key.getRequiredTZName()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureISOTZoneByIso8601IdxKey as arguments.
	 *
	 *		@param requiredIso8601
	 *
	 *		@return List&lt;SecureJpaISOTZone&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaISOTZone r where r.requiredIso8601 = :iso8601")
	List<SecureJpaISOTZone> findByIso8601Idx(@Param("iso8601") String requiredIso8601);

	/**
	 *	SecureISOTZoneByIso8601IdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByIso8601IdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaISOTZone> findByIso8601Idx(ISecureISOTZoneByIso8601IdxKey key) {
		return( findByIso8601Idx(key.getRequiredIso8601()));
	}

	// SecureJpaISOTZone specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOTZoneId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOTZone r where r.requiredISOTZoneId = :iSOTZoneId")
	SecureJpaISOTZone lockByIdIdx(@Param("iSOTZoneId") short requiredISOTZoneId);

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTZHourOffset
	 *		@param requiredTZMinOffset
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOTZone r where r.requiredTZHourOffset = :tZHourOffset and r.requiredTZMinOffset = :tZMinOffset")
	List<SecureJpaISOTZone> lockByOffsetIdx(@Param("tZHourOffset") short requiredTZHourOffset,
		@Param("tZMinOffset") short requiredTZMinOffset);

	/**
	 *	SecureISOTZoneByOffsetIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaISOTZone> lockByOffsetIdx(ISecureISOTZoneByOffsetIdxKey key) {
		return( lockByOffsetIdx(key.getRequiredTZHourOffset(), key.getRequiredTZMinOffset()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTZName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOTZone r where r.requiredTZName = :tZName")
	SecureJpaISOTZone lockByUTZNameIdx(@Param("tZName") String requiredTZName);

	/**
	 *	SecureISOTZoneByUTZNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaISOTZone lockByUTZNameIdx(ISecureISOTZoneByUTZNameIdxKey key) {
		return( lockByUTZNameIdx(key.getRequiredTZName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIso8601
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaISOTZone r where r.requiredIso8601 = :iso8601")
	List<SecureJpaISOTZone> lockByIso8601Idx(@Param("iso8601") String requiredIso8601);

	/**
	 *	SecureISOTZoneByIso8601IdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaISOTZone> lockByIso8601Idx(ISecureISOTZoneByIso8601IdxKey key) {
		return( lockByIso8601Idx(key.getRequiredIso8601()));
	}

	// SecureJpaISOTZone specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredISOTZoneId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOTZone r where r.requiredISOTZoneId = :iSOTZoneId")
	void deleteByIdIdx(@Param("iSOTZoneId") short requiredISOTZoneId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTZHourOffset
	 *		@param requiredTZMinOffset
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOTZone r where r.requiredTZHourOffset = :tZHourOffset and r.requiredTZMinOffset = :tZMinOffset")
	void deleteByOffsetIdx(@Param("tZHourOffset") short requiredTZHourOffset,
		@Param("tZMinOffset") short requiredTZMinOffset);

	/**
	 *	SecureISOTZoneByOffsetIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByOffsetIdxKey of the entity to be locked.
	 */
	default void deleteByOffsetIdx(ISecureISOTZoneByOffsetIdxKey key) {
		deleteByOffsetIdx(key.getRequiredTZHourOffset(), key.getRequiredTZMinOffset());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTZName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOTZone r where r.requiredTZName = :tZName")
	void deleteByUTZNameIdx(@Param("tZName") String requiredTZName);

	/**
	 *	SecureISOTZoneByUTZNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByUTZNameIdxKey of the entity to be locked.
	 */
	default void deleteByUTZNameIdx(ISecureISOTZoneByUTZNameIdxKey key) {
		deleteByUTZNameIdx(key.getRequiredTZName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIso8601
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaISOTZone r where r.requiredIso8601 = :iso8601")
	void deleteByIso8601Idx(@Param("iso8601") String requiredIso8601);

	/**
	 *	SecureISOTZoneByIso8601IdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureISOTZoneByIso8601IdxKey of the entity to be locked.
	 */
	default void deleteByIso8601Idx(ISecureISOTZoneByIso8601IdxKey key) {
		deleteByIso8601Idx(key.getRequiredIso8601());
	}

}
