// Description: Java 25 Spring JPA Repository for SecSysRoleMemb

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
 *	JpaRepository for the SecureJpaSecSysRoleMemb entities defined in server.markhome.ycf.v3_1.secure.secure.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface SecureJpaSecSysRoleMembRepository extends JpaRepository<SecureJpaSecSysRoleMemb, SecureJpaSecSysRoleMembPKey> {

	@Transactional
	@Modifying
	SecureJpaSecSysRoleMemb save(SecureJpaSecSysRoleMemb obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredSecSysRoleId
	 *		@param requiredLoginId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecSysRoleMemb get(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembPKey based read method for object-cored access.
	 *
	 *		@param key The key of the entity to be read.
	 *
	 *		@return The entity read, usually from the JPA cache, or null if no such entity exists.
	 */
	default SecureJpaSecSysRoleMemb get(ISecureSecSysRoleMembPKey key) {
		return( get(key.getRequiredSecSysRoleId(), key.getRequiredLoginId()));
	}

	// SecureJpaSecSysRoleMemb specified index readers

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSysRoleMembBySysRoleIdxKey as arguments.
	 *
	 *		@param requiredSecSysRoleId
	 *
	 *		@return List&lt;SecureJpaSecSysRoleMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId")
	List<SecureJpaSecSysRoleMemb> findBySysRoleIdx(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId);

	/**
	 *	SecureSecSysRoleMembBySysRoleIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysRoleMembBySysRoleIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSysRoleMemb> findBySysRoleIdx(ISecureSecSysRoleMembBySysRoleIdxKey key) {
		return( findBySysRoleIdx(key.getRequiredSecSysRoleId()));
	}

	/**
	 *	Read zero or more entities into a List using the columns of the SecureSecSysRoleMembByLoginIdxKey as arguments.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return List&lt;SecureJpaSecSysRoleMemb&gt; of the found entities, typically from the JPA cache, or an empty list if no such entities exist.
	 */
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecSysRoleMemb> findByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembByLoginIdxKey entity list reader convenience method for object-cored access.
	 *
	 *		@param key The SecureSecSysRoleMembByLoginIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty, typically populated from the JPA cache.
	 */
	default List<SecureJpaSecSysRoleMemb> findByLoginIdx(ISecureSecSysRoleMembByLoginIdxKey key) {
		return( findByLoginIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecSysRoleMemb specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysRoleId
	 *		@param requiredLoginId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	SecureJpaSecSysRoleMemb lockByIdIdx(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default SecureJpaSecSysRoleMemb lockByIdIdx(ISecureSecSysRoleMembPKey key) {
		return( lockByIdIdx(key.getRequiredSecSysRoleId(), key.getRequiredLoginId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysRoleId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId")
	List<SecureJpaSecSysRoleMemb> lockBySysRoleIdx(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId);

	/**
	 *	SecureSecSysRoleMembBySysRoleIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSysRoleMemb> lockBySysRoleIdx(ISecureSecSysRoleMembBySysRoleIdxKey key) {
		return( lockBySysRoleIdx(key.getRequiredSecSysRoleId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from SecureJpaSecSysRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	List<SecureJpaSecSysRoleMemb> lockByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembByLoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	default List<SecureJpaSecSysRoleMemb> lockByLoginIdx(ISecureSecSysRoleMembByLoginIdxKey key) {
		return( lockByLoginIdx(key.getRequiredLoginId()));
	}

	// SecureJpaSecSysRoleMemb specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysRoleId
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId and r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByIdIdx(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId,
		@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembByIdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysRoleMembByIdIdxKey of the entity to be locked.
	 */
	default void deleteByIdIdx(ISecureSecSysRoleMembPKey key) {
		deleteByIdIdx(key.getRequiredSecSysRoleId(), key.getRequiredLoginId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSecSysRoleId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysRoleMemb r where r.requiredContainerSysRole.requiredSecSysRoleId = :secSysRoleId")
	void deleteBySysRoleIdx(@Param("secSysRoleId") IYCFKeyHash256 requiredSecSysRoleId);

	/**
	 *	SecureSecSysRoleMembBySysRoleIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysRoleMembBySysRoleIdxKey of the entity to be locked.
	 */
	default void deleteBySysRoleIdx(ISecureSecSysRoleMembBySysRoleIdxKey key) {
		deleteBySysRoleIdx(key.getRequiredSecSysRoleId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredLoginId
	 */
	@Transactional
	@Modifying
	@Query("delete from SecureJpaSecSysRoleMemb r where r.requiredParentUser.requiredLoginId = :loginId")
	void deleteByLoginIdx(@Param("loginId") String requiredLoginId);

	/**
	 *	SecureSecSysRoleMembByLoginIdxKey based lock method for object-cored access.
	 *
	 *		@param key The SecureSecSysRoleMembByLoginIdxKey of the entity to be locked.
	 */
	default void deleteByLoginIdx(ISecureSecSysRoleMembByLoginIdxKey key) {
		deleteByLoginIdx(key.getRequiredLoginId());
	}

}
