
// Description: Spring JPA tests for IntNet for the JpaTest program

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

package server.markhome.ycf.v3_1.intnet.intnetjpatest.spring;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

@Service("JpaTestIntNet")
public class IntNetJpaTestTestSchema {
    
    @Autowired
    @Qualifier("intnet31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean intNet31EntityManagerFactory;
	@Autowired
	private IntNetJpaLicenseService intNetLicenseService;

	@Autowired
	private IntNetJpaMajorVersionService intNetMajorVersionService;

	@Autowired
	private IntNetJpaMimeTypeService intNetMimeTypeService;

	@Autowired
	private IntNetJpaMinorVersionService intNetMinorVersionService;

	@Autowired
	private IntNetJpaSubProjectService intNetSubProjectService;

	@Autowired
	private IntNetJpaTldService intNetTldService;

	@Autowired
	private IntNetJpaTopDomainService intNetTopDomainService;

	@Autowired
	private IntNetJpaTopProjectService intNetTopProjectService;

	@Autowired
	private IntNetJpaURLProtocolService intNetURLProtocolService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    // @PersistenceContext(unitName = "IntNet31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting IntNet tests...\n");
		List<?> licenseResults = intNetLicenseService.findAll();
		if (licenseResults == null) {
			messages.append("Erroneously retrieved null for IntNetLicenseService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + licenseResults.size() + " entities from IntNet.License\n");
		}

		List<?> majorVersionResults = intNetMajorVersionService.findAll();
		if (majorVersionResults == null) {
			messages.append("Erroneously retrieved null for IntNetMajorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + majorVersionResults.size() + " entities from IntNet.MajorVersion\n");
		}

		List<?> mimeTypeResults = intNetMimeTypeService.findAll();
		if (mimeTypeResults == null) {
			messages.append("Erroneously retrieved null for IntNetMimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + mimeTypeResults.size() + " entities from IntNet.MimeType\n");
		}

		List<?> minorVersionResults = intNetMinorVersionService.findAll();
		if (minorVersionResults == null) {
			messages.append("Erroneously retrieved null for IntNetMinorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + minorVersionResults.size() + " entities from IntNet.MinorVersion\n");
		}

		List<?> subProjectResults = intNetSubProjectService.findAll();
		if (subProjectResults == null) {
			messages.append("Erroneously retrieved null for IntNetSubProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + subProjectResults.size() + " entities from IntNet.SubProject\n");
		}

		List<?> tldResults = intNetTldService.findAll();
		if (tldResults == null) {
			messages.append("Erroneously retrieved null for IntNetTldService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tldResults.size() + " entities from IntNet.Tld\n");
		}

		List<?> topDomainResults = intNetTopDomainService.findAll();
		if (topDomainResults == null) {
			messages.append("Erroneously retrieved null for IntNetTopDomainService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topDomainResults.size() + " entities from IntNet.TopDomain\n");
		}

		List<?> topProjectResults = intNetTopProjectService.findAll();
		if (topProjectResults == null) {
			messages.append("Erroneously retrieved null for IntNetTopProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topProjectResults.size() + " entities from IntNet.TopProject\n");
		}

		List<?> uRLProtocolResults = intNetURLProtocolService.findAll();
		if (uRLProtocolResults == null) {
			messages.append("Erroneously retrieved null for IntNetURLProtocolService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uRLProtocolResults.size() + " entities from IntNet.URLProtocol\n");
		}

		messages.append("IntNet tests complete\n");
		return( messages.toString() );
	}
}
