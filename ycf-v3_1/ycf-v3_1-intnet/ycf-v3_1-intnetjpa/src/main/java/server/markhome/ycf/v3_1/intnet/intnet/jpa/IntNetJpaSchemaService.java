// Description: Java 25 Spring JPA Service for IntNet

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
import java.net.InetAddress;
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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

/**
 *	Services for schema IntNet defined in server.markhome.ycf.v3_1.intnet.intnet.jpa
 *	using the IntNet*Repository objects to access the data directly, bypassing normal application security for the bootstrap and login processing.
 */
@Service("intnet31JpaSchemaService")
public class IntNetJpaSchemaService {

	@Autowired
	@Qualifier("intnet31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean intnet31EntityManagerFactory;
	@Autowired
	private IntNetJpaLicenseService licenseService;

	@Autowired
	private IntNetJpaMajorVersionService majorversionService;

	@Autowired
	private IntNetJpaMimeTypeService mimetypeService;

	@Autowired
	private IntNetJpaMinorVersionService minorversionService;

	@Autowired
	private IntNetJpaSubProjectService subprojectService;

	@Autowired
	private IntNetJpaTldService tldService;

	@Autowired
	private IntNetJpaTopDomainService topdomainService;

	@Autowired
	private IntNetJpaTopProjectService topprojectService;

	@Autowired
	private IntNetJpaURLProtocolService urlprotocolService;


	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(SecurePubTableData tableData[]) {
		bootstrapAllTablesSecurity(ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), tableData);
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}


		// Customized schematweak [Secure::IntNet].JpaSchemaServiceCustomServices
}
