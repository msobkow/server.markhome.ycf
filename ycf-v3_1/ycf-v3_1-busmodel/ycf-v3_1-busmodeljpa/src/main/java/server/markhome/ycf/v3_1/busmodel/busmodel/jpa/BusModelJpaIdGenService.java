// Description: Java 25 Spring JPA Id Generator Service for BusModel

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
 *	Service for the BusModelId generation methods defined in server.markhome.ycf.v3_1.busmodel.busmodel application model.
 */
@Service("BusModel31JpaIdGenService")
public class BusModelJpaIdGenService {

    @Autowired
    @Qualifier("busmodel31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean busmodelEntityManagerFactory;

	/**
	 *	Generate a ChainIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateChainIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a EnumTagIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateEnumTagIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a IndexColIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateIndexColIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a ParamIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateParamIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a RelationColIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateRelationColIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a TweakIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateTweakIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a ScopeIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateScopeIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a ValueIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateValueIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a RoleIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodelTransactionManager")
	public YCFDbKeyHash256 generateRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

}
