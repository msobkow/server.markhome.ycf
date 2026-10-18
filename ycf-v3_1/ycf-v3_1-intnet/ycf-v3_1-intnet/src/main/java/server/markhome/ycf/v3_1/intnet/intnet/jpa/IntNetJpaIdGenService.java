// Description: Java 25 Spring JPA Id Generator Service for IntNet

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
 *	Service for the IntNetId generation methods defined in server.markhome.ycf.v3_1.intnet.intnet application model.
 */
@Service("IntNet31JpaIdGenService")
public class IntNetJpaIdGenService {

    @Autowired
    @Qualifier("intnet31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean intnetEntityManagerFactory;

	/**
	 *	Generate a MajorVersionIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateMajorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	*	Generate a MimeTypeIdGen integer id.
	*
	*		@return The next integer value for the MimeTypeIdGen type.
	*/
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	@SequenceGenerator(name = "MimeTypeIdGenSeq", allocationSize = 1, initialValue = 0, schema = "IntNet31")
	public int generateMimeTypeIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "generateMimeTypeIdGen" );
	}

	/**
	 *	Generate a MinorVersionIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateMinorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a SubProjectIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateSubProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a TldIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateTldIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a TopDomainIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateTopDomainIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Generate a TopProjectIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateTopProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	*	Generate a URLProtocolIdGen integer id.
	*
	*		@return The next integer value for the URLProtocolIdGen type.
	*/
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	@SequenceGenerator(name = "URLProtoIdGenSeq", allocationSize = 1, initialValue = 0, schema = "IntNet31")
	public int generateURLProtocolIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "generateURLProtocolIdGen" );
	}

	/**
	 *	Generate a LicenseIdGen YCFDbKeyHash256 id.
	 *
	 *		@return A cryptographically-random generated YCFDBKeyHash128 value
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnetTransactionManager")
	public YCFDbKeyHash256 generateLicenseIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

}
