
// Description: Spring JPA tests for IntNet for the JpaTest program

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

package server.markhome.ycf.v3_1.busmodel.busmodeljpatest.spring;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
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
