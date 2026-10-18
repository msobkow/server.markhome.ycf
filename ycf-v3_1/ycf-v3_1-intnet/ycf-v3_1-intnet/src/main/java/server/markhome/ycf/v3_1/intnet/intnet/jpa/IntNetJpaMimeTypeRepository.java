// Description: Java 25 Spring JPA Repository for MimeType

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;

/**
 *	JpaRepository for the IntNetJpaMimeType entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa.
 *	The manufactured repositories try to provide a rich, do-it-all interface to the JPA data store, with both object and argument-cored implementations of the interface defined.
 */
@Transactional(readOnly = true)
public interface IntNetJpaMimeTypeRepository extends JpaRepository<IntNetJpaMimeType, $implCommaIJavaOptAtomType$> {

	@Transactional
	@Modifying
	IntNetJpaMimeType save(IntNetJpaMimeType obj);

	/**
	 *	Argument-cored get database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredMimeTypeId
	 *
	 *		@return The retrieved entity, usually from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaMimeType r where r.requiredMimeTypeId = :mimeTypeId")
	IntNetJpaMimeType get(@Param("mimeTypeId") int requiredMimeTypeId);

	// IntNetJpaMimeType specified index readers

	/**
	 *	Read an entity using the columns of the IntNetMimeTypeByUNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	@Query("select r from IntNetJpaMimeType r where r.requiredName = :name")
	IntNetJpaMimeType findByUNameIdx(@Param("name") String requiredName);

	/**
	 *	IntNetMimeTypeByUNameIdxKey entity reader convenience method for object-cored access.
	 *
	 *		@param key The IntNetMimeTypeByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, typically from the JPA cache, or null if no such entity exists.
	 */
	default IntNetJpaMimeType findByUNameIdx(IIntNetMimeTypeByUNameIdxKey key) {
		return( findByUNameIdx(key.getRequiredName()));
	}

	// IntNetJpaMimeType specified delete-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMimeTypeId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMimeType r where r.requiredMimeTypeId = :mimeTypeId")
	IntNetJpaMimeType lockByIdIdx(@Param("mimeTypeId") int requiredMimeTypeId);

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional
	@Lock(LockModeType.WRITE)
	@Query("select r from IntNetJpaMimeType r where r.requiredName = :name")
	IntNetJpaMimeType lockByUNameIdx(@Param("name") String requiredName);

	/**
	 *	IntNetMimeTypeByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	default IntNetJpaMimeType lockByUNameIdx(IIntNetMimeTypeByUNameIdxKey key) {
		return( lockByUNameIdx(key.getRequiredName()));
	}

	// IntNetJpaMimeType specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMimeTypeId
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMimeType r where r.requiredMimeTypeId = :mimeTypeId")
	void deleteByIdIdx(@Param("mimeTypeId") int requiredMimeTypeId);

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional
	@Modifying
	@Query("delete from IntNetJpaMimeType r where r.requiredName = :name")
	void deleteByUNameIdx(@Param("name") String requiredName);

	/**
	 *	IntNetMimeTypeByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IntNetMimeTypeByUNameIdxKey of the entity to be locked.
	 */
	default void deleteByUNameIdx(IIntNetMimeTypeByUNameIdxKey key) {
		deleteByUNameIdx(key.getRequiredName());
	}

}
