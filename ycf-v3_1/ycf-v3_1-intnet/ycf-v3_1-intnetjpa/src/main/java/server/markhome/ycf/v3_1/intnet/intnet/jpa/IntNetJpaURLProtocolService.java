// Description: Java 25 Spring JPA Service for URLProtocol

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;

/**
 *	Service for the IntNetURLProtocol entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa
 *	using the IntNetURLProtocolRepository to access them.
 */
@Service("intnet31JpaURLProtocolService")
public class IntNetJpaURLProtocolService {

	@Autowired
	@Qualifier("intnet31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean intnet31EntityManagerFactory;

	@Autowired
	private IntNetJpaURLProtocolRepository intnet31URLProtocolRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of IntNetJpaURLProtocol, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol create(IntNetJpaURLProtocol data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		int originalRequiredURLProtocolId = data.getRequiredURLProtocolId();
		boolean generatedRequiredURLProtocolId = false;
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredDescription() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredDescription");
		}
		try {
			if(data.getPKey() != null && intnet31URLProtocolRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (IntNetJpaURLProtocol)(intnet31URLProtocolRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
			}
			if (data.getRequiredRevision() <= 0) {
				data.setRequiredRevision(1);
			}
			LocalDateTime now = LocalDateTime.now();
			data.setCreatedAt(now);
			data.setUpdatedAt(now);
			return intnet31URLProtocolRepository.save(data);
		}
		catch(Exception ex) {
				if(generatedRequiredURLProtocolId) {
					data.setRequiredURLProtocolId(originalRequiredURLProtocolId);
				}
			throw new YCFDbException(getClass(),
				S_ProcName,
				ex);
		}
	}

	/**
	 *	Update an existing entity.
	 *
	 *		@param	data	The entity to be updated.
	 *
	 *		@return The updated entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol update(IntNetJpaURLProtocol data) {
		final String S_ProcName = "update";
		if (data == null) {
			return( null );
		}
		if (data.getPKey() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.getPKey()");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredDescription() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredDescription");
		}
		// Ensure the entity exists and that the revision matches
		IntNetJpaURLProtocol existing = intnet31URLProtocolRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of IntNetURLProtocol to existing object
		// Apply data columns of IntNetURLProtocol to existing object
		existing.setRequiredName(data.getRequiredName());
		existing.setRequiredDescription(data.getRequiredDescription());
		existing.setRequiredIsSecure(data.getRequiredIsSecure());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return intnet31URLProtocolRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredURLProtocolId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol find(@Param("uRLProtocolId") int requiredURLProtocolId) {
		return( intnet31URLProtocolRepository.get(requiredURLProtocolId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaURLProtocol> findAll() {
		return( intnet31URLProtocolRepository.findAll() );
	}

	// IntNetURLProtocol specified index finders

	/**
	 *	Find an entity using the columns of the IIntNetURLProtocolByUNameIdxKey as arguments.
	 *
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol findByUNameIdx(@Param("name") String requiredName) {
		return( intnet31URLProtocolRepository.findByUNameIdx(requiredName));
	}

	/**
	 *	IIntNetURLProtocolByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IIntNetURLProtocolByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol findByUNameIdx(IIntNetURLProtocolByUNameIdxKey key) {
		return( intnet31URLProtocolRepository.findByUNameIdx(key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IIntNetURLProtocolByIsSecureIdxKey as arguments.
	 *
	 *		@param requiredIsSecure
	 *
	 *		@return List&lt;IntNetJpaURLProtocol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaURLProtocol> findByIsSecureIdx(@Param("isSecure") boolean requiredIsSecure) {
		return( intnet31URLProtocolRepository.findByIsSecureIdx(requiredIsSecure));
	}

	/**
	 *	IIntNetURLProtocolByIsSecureIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IIntNetURLProtocolByIsSecureIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaURLProtocol> findByIsSecureIdx(IIntNetURLProtocolByIsSecureIdxKey key) {
		return( intnet31URLProtocolRepository.findByIsSecureIdx(key.getRequiredIsSecure()));
	}

	// IntNetURLProtocol specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredURLProtocolId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol lockByIdIdx(@Param("uRLProtocolId") int requiredURLProtocolId) {
		return( intnet31URLProtocolRepository.lockByIdIdx(requiredURLProtocolId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol lockByUNameIdx(@Param("name") String requiredName) {
		return( intnet31URLProtocolRepository.lockByUNameIdx(requiredName));
	}

	/**
	 *	IIntNetURLProtocolByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol lockByUNameIdx(IIntNetURLProtocolByUNameIdxKey key) {
		return( intnet31URLProtocolRepository.lockByUNameIdx(key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIsSecure
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaURLProtocol> lockByIsSecureIdx(@Param("isSecure") boolean requiredIsSecure) {
		return( intnet31URLProtocolRepository.lockByIsSecureIdx(requiredIsSecure));
	}

	/**
	 *	IIntNetURLProtocolByIsSecureIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaURLProtocol> lockByIsSecureIdx(IIntNetURLProtocolByIsSecureIdxKey key) {
		return( intnet31URLProtocolRepository.lockByIsSecureIdx(key.getRequiredIsSecure()));
	}

	// IntNetURLProtocol specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredURLProtocolId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByIdIdx(@Param("uRLProtocolId") int requiredURLProtocolId) {
		intnet31URLProtocolRepository.deleteByIdIdx(requiredURLProtocolId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByUNameIdx(@Param("name") String requiredName) {
		intnet31URLProtocolRepository.deleteByUNameIdx(requiredName);
	}

	/**
	 *	IIntNetURLProtocolByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IIntNetURLProtocolByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByUNameIdx(IIntNetURLProtocolByUNameIdxKey key) {
		intnet31URLProtocolRepository.deleteByUNameIdx(key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIsSecure
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByIsSecureIdx(@Param("isSecure") boolean requiredIsSecure) {
		intnet31URLProtocolRepository.deleteByIsSecureIdx(requiredIsSecure);
	}

	/**
	 *	IIntNetURLProtocolByIsSecureIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IIntNetURLProtocolByIsSecureIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByIsSecureIdx(IIntNetURLProtocolByIsSecureIdxKey key) {
		intnet31URLProtocolRepository.deleteByIsSecureIdx(key.getRequiredIsSecure());
	}

}
