// Description: Java 25 Spring JPA Service for UInt64Type

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;

/**
 *	Service for the BusModelUInt64Type entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelUInt64TypeRepository to access them.
 */
@Service("busmodel31JpaUInt64TypeService")
public class BusModelJpaUInt64TypeService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaUInt64TypeRepository busmodel31UInt64TypeRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaUInt64Type, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type create(BusModelJpaUInt64Type data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerScope() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScope",
				"data.requiredContainerScope",
				"Scope",
				"Scope",
				null);
		}
		if(data.getRequiredScopeId() == null || data.getRequiredScopeId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredScopeId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if( data.getOptionalInitValue() != null && data.getOptionalInitValue().compareTo(IBusModelUInt64Def.INITVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalInitValue()",
				data.getOptionalInitValue().toString(),
				IBusModelUInt64Def.INITVALUE_MIN_VALUE.toString() );
		}
		if( data.getOptionalMinValue() != null && data.getOptionalMinValue().compareTo(IBusModelUInt64Def.MINVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalMinValue()",
				data.getOptionalMinValue().toString(),
				IBusModelUInt64Def.MINVALUE_MIN_VALUE.toString() );
		}
		if( data.getOptionalMaxValue() != null && data.getOptionalMaxValue().compareTo(IBusModelUInt64Def.MAXVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalMaxValue()",
				data.getOptionalMaxValue().toString(),
				IBusModelUInt64Def.MAXVALUE_MIN_VALUE.toString() );
		}
		if (data.getRequiredContainerSchemaDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchemaDef",
				"data.requiredContainerSchemaDef",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaDefId() == null || data.getRequiredSchemaDefId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaDefId");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31UInt64TypeRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaUInt64Type)(busmodel31UInt64TypeRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
			}
			if (data.getRequiredRevision() <= 0) {
				data.setRequiredRevision(1);
			}
			if (data.getRequiredId() == null || data.getRequiredId().isNull()) {
				data.setRequiredId(new YCFDbKeyHash256(0));
				generatedRequiredId = true;
			}
			LocalDateTime now = LocalDateTime.now();
			data.setCreatedAt(now);
			data.setUpdatedAt(now);
			return busmodel31UInt64TypeRepository.save(data);
		}
		catch(Exception ex) {
				if(generatedRequiredId) {
					data.setRequiredId(originalRequiredId);
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type update(BusModelJpaUInt64Type data) {
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
		if (data.getRequiredContainerScope() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScope",
				"data.requiredContainerScope",
				"Scope",
				"Scope",
				null);
		}
		if(data.getRequiredScopeId() == null || data.getRequiredScopeId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredScopeId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if( data.getOptionalInitValue() != null && data.getOptionalInitValue().compareTo(IBusModelUInt64Def.INITVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalInitValue()",
				data.getOptionalInitValue().toString(),
				IBusModelUInt64Def.INITVALUE_MIN_VALUE.toString() );
		}
		if( data.getOptionalMinValue() != null && data.getOptionalMinValue().compareTo(IBusModelUInt64Def.MINVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalMinValue()",
				data.getOptionalMinValue().toString(),
				IBusModelUInt64Def.MINVALUE_MIN_VALUE.toString() );
		}
		if( data.getOptionalMaxValue() != null && data.getOptionalMaxValue().compareTo(IBusModelUInt64Def.MAXVALUE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalMaxValue()",
				data.getOptionalMaxValue().toString(),
				IBusModelUInt64Def.MAXVALUE_MIN_VALUE.toString() );
		}
		if (data.getRequiredContainerSchemaDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchemaDef",
				"data.requiredContainerSchemaDef",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaDefId() == null || data.getRequiredSchemaDefId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaDefId");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaUInt64Type existing = busmodel31UInt64TypeRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelValue to existing object
		existing.setRequiredContainerScope(data.getRequiredContainerScope());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		// Apply data columns of BusModelValue to existing object
		existing.setRequiredScopeId(data.getRequiredScopeId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setOptionalDefaultXmlValue(data.getOptionalDefaultXmlValue());
		existing.setRequiredIsNullable(data.getRequiredIsNullable());
		existing.setOptionalGenerateId(data.getOptionalGenerateId());
		existing.setRequiredImplementsPolymorph(data.getRequiredImplementsPolymorph());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Apply superior data relationships of BusModelAtom to existing object
		// Apply data columns of BusModelAtom to existing object
		existing.setOptionalDbName(data.getOptionalDbName());
		// Apply superior data relationships of BusModelUInt64Def to existing object
		// Apply data columns of BusModelUInt64Def to existing object
		existing.setOptionalInitValue(data.getOptionalInitValue());
		existing.setOptionalMinValue(data.getOptionalMinValue());
		existing.setOptionalMaxValue(data.getOptionalMaxValue());
		// Apply superior data relationships of BusModelUInt64Type to existing object
		existing.setRequiredContainerSchemaDef(data.getRequiredContainerSchemaDef());
		// Apply data columns of BusModelUInt64Type to existing object
		existing.setRequiredSchemaDefId(data.getRequiredSchemaDefId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31UInt64TypeRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31UInt64TypeRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findAll() {
		return( busmodel31UInt64TypeRepository.findAll() );
	}

	// BusModelValue specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelValueByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31UInt64TypeRepository.findByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelValueByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type findByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31UInt64TypeRepository.findByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelValueByScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByScopeIdx(IBusModelValueByScopeIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31UInt64TypeRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31UInt64TypeRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelValueByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByPrevIdx(IBusModelValueByPrevIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31UInt64TypeRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelValueByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByNextIdx(IBusModelValueByNextIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByContPrevIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31UInt64TypeRepository.findByContPrevIdx(requiredScopeId,
			optionalPrevId));
	}

	/**
	 *	IBusModelValueByContPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByContNextIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31UInt64TypeRepository.findByContNextIdx(requiredScopeId,
			optionalNextId));
	}

	/**
	 *	IBusModelValueByContNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( busmodel31UInt64TypeRepository.findByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelAtom specified index finders

	// BusModelUInt64Def specified index finders

	// BusModelUInt64Type specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelUInt64TypeBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaUInt64Type&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31UInt64TypeRepository.findBySchemaIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelUInt64TypeBySchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelUInt64TypeBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> findBySchemaIdx(IBusModelUInt64TypeBySchemaIdxKey key) {
		return( busmodel31UInt64TypeRepository.findBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	// BusModelValue specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31UInt64TypeRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31UInt64TypeRepository.lockByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt64Type lockByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31UInt64TypeRepository.lockByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByScopeIdx(IBusModelValueByScopeIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31UInt64TypeRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31UInt64TypeRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByPrevIdx(IBusModelValueByPrevIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31UInt64TypeRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByNextIdx(IBusModelValueByNextIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31UInt64TypeRepository.lockByContPrevIdx(requiredScopeId,
			optionalPrevId));
	}

	/**
	 *	IBusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31UInt64TypeRepository.lockByContNextIdx(requiredScopeId,
			optionalNextId));
	}

	/**
	 *	IBusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelAtom specified lock-by-index methods

	// BusModelUInt64Def specified lock-by-index methods

	// BusModelUInt64Type specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31UInt64TypeRepository.lockBySchemaIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelUInt64TypeBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaUInt64Type> lockBySchemaIdx(IBusModelUInt64TypeBySchemaIdxKey key) {
		return( busmodel31UInt64TypeRepository.lockBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	// BusModelValue specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31UInt64TypeRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		busmodel31UInt64TypeRepository.deleteByUNameIdx(requiredScopeId,
			requiredName);
	}

	/**
	 *	IBusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelValueByUNameIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		busmodel31UInt64TypeRepository.deleteByScopeIdx(requiredScopeId);
	}

	/**
	 *	IBusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(IBusModelValueByScopeIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31UInt64TypeRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31UInt64TypeRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelValueByPrevIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31UInt64TypeRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelValueByNextIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31UInt64TypeRepository.deleteByContPrevIdx(requiredScopeId,
			optionalPrevId);
	}

	/**
	 *	IBusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31UInt64TypeRepository.deleteByContNextIdx(requiredScopeId,
			optionalNextId);
	}

	/**
	 *	IBusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(IBusModelValueByContNextIdxKey key) {
		busmodel31UInt64TypeRepository.deleteByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId());
	}

	// BusModelAtom specified delete-by-index methods

	// BusModelUInt64Def specified delete-by-index methods

	// BusModelUInt64Type specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		busmodel31UInt64TypeRepository.deleteBySchemaIdx(requiredSchemaDefId);
	}

	/**
	 *	IBusModelUInt64TypeBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelUInt64TypeBySchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(IBusModelUInt64TypeBySchemaIdxKey key) {
		busmodel31UInt64TypeRepository.deleteBySchemaIdx(key.getRequiredSchemaDefId());
	}

}
