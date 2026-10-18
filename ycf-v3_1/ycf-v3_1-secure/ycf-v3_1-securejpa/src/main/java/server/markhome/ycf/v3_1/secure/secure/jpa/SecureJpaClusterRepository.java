// Description: Java 25 Spring JPA Repository for Cluster

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
 *	JpaRepository for the SecureJpaCluster entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaClusterRepository extends JpaRepository<SecureJpaCluster, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	SecureJpaCluster save(SecureJpaCluster obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaCluster r where r.requiredId = :id")
	SecureJpaCluster get(@Param("id") IYCFKeyHash256 requiredId);

	// SecureJpaCluster specified index readers

	/**
	 *	Read an entity using the columns of the SecureClusterByUDomNameIdxKey as arguments.
	 *
	 *		@param requiredFullDomName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaCluster r where r.requiredFullDomName = :fullDomName")
	SecureJpaCluster findByUDomNameIdx(@Param("fullDomName") String requiredFullDomName);

	/**
	 *	SecureClusterByUDomNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureClusterByUDomNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaCluster findByUDomNameIdx(ISecureClusterByUDomNameIdxKey key) {
		return( findByUDomNameIdx(key.getRequiredFullDomName()));
	}

	/**
	 *	Read an entity using the columns of the SecureClusterByUDescrIdxKey as arguments.
	 *
	 *		@param requiredDescription
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaCluster r where r.requiredDescription = :description")
	SecureJpaCluster findByUDescrIdx(@Param("description") String requiredDescription);

	/**
	 *	SecureClusterByUDescrIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The SecureClusterByUDescrIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaCluster findByUDescrIdx(ISecureClusterByUDescrIdxKey key) {
		return( findByUDescrIdx(key.getRequiredDescription()));
	}

	// SecureJpaCluster specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaCluster r where r.requiredId = :id")
	SecureJpaCluster lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFullDomName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaCluster r where r.requiredFullDomName = :fullDomName")
	SecureJpaCluster lockByUDomNameIdx(@Param("fullDomName") String requiredFullDomName);

	/**
	 *	SecureClusterByUDomNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaCluster lockByUDomNameIdx(ISecureClusterByUDomNameIdxKey key) {
		return( lockByUDomNameIdx(key.getRequiredFullDomName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDescription
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaCluster r where r.requiredDescription = :description")
	SecureJpaCluster lockByUDescrIdx(@Param("description") String requiredDescription);

	/**
	 *	SecureClusterByUDescrIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaCluster lockByUDescrIdx(ISecureClusterByUDescrIdxKey key) {
		return( lockByUDescrIdx(key.getRequiredDescription()));
	}

	// SecureJpaCluster specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaCluster r where r.requiredId = :id")
	void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFullDomName
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaCluster r where r.requiredFullDomName = :fullDomName")
	void deleteByUDomNameIdx(@Param("fullDomName") String requiredFullDomName);

	/**
	 *	SecureClusterByUDomNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureClusterByUDomNameIdxKey of the entity to be locked.
	 */
	default void deleteByUDomNameIdx(ISecureClusterByUDomNameIdxKey key) {
		deleteByUDomNameIdx(key.getRequiredFullDomName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDescription
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaCluster r where r.requiredDescription = :description")
	void deleteByUDescrIdx(@Param("description") String requiredDescription);

	/**
	 *	SecureClusterByUDescrIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureClusterByUDescrIdxKey of the entity to be locked.
	 */
	default void deleteByUDescrIdx(ISecureClusterByUDescrIdxKey key) {
		deleteByUDescrIdx(key.getRequiredDescription());
	}

}
