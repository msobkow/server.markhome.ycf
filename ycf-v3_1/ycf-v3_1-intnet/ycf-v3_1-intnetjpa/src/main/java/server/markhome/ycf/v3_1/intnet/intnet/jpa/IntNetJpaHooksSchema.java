// Description: Java 25 Spring JPA Hooks for IntNet

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
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

/**
 *	Hooks for schema IntNet Spring resources that need to be used by getter-wrappers for AtomicReference members of the multi-threaded wedge between Spring resources and POJO code.
 *	This implementation wraps the Spring singletons instantiated during Spring's boot process for the server.markhome.ycf.v3_1.intnet.intnet.jpa package.  It resolves all known standard Spring resources for the LocalContainerEntityManagerFactoryBean, SchemaService, IdGenService, and the IntNet*Repository and IntNet*Service singletons that the POJOs need to invoke.  However, it relies on late-initialization during dynamic instance creation (i.e. new IntNetJpaSchemaHooks()) instead of being initialized as a Spring singleton. As the Spring instance hierarchy is instantiated before any instances of this class are instantiated, the net result bridges the gap between POJO and Spring JPA.
 */
@Service("intnet31JpaHooksSchema")
public class IntNetJpaHooksSchema {

	@Autowired
	@Qualifier("intnet31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean intnet31EntityManagerFactory;

	@Autowired
	private IntNetJpaLicenseRepository licenseRepository;

	@Autowired
	private IntNetJpaMajorVersionRepository majorVersionRepository;

	@Autowired
	private IntNetJpaMimeTypeRepository mimeTypeRepository;

	@Autowired
	private IntNetJpaMinorVersionRepository minorVersionRepository;

	@Autowired
	private IntNetJpaSubProjectRepository subProjectRepository;

	@Autowired
	private IntNetJpaTldRepository tldRepository;

	@Autowired
	private IntNetJpaTopDomainRepository topDomainRepository;

	@Autowired
	private IntNetJpaTopProjectRepository topProjectRepository;

	@Autowired
	private IntNetJpaURLProtocolRepository uRLProtocolRepository;

	@Autowired
	@Qualifier("intnet31JpaSchemaService")
	private IntNetJpaSchemaService schemaService;

	@Autowired
	@Qualifier("intnet31JpaFactory")
	private IntNetJpaFactoryService factoryService;

	@Autowired
	@Qualifier("IntNet31JpaIdGenService")
	private IntNetJpaIdGenService idGenService;

	@Autowired
	@Qualifier("intnet31JpaLicenseService")
	private IntNetJpaLicenseService licenseService;

	@Autowired
	@Qualifier("intnet31JpaMajorVersionService")
	private IntNetJpaMajorVersionService majorVersionService;

	@Autowired
	@Qualifier("intnet31JpaMimeTypeService")
	private IntNetJpaMimeTypeService mimeTypeService;

	@Autowired
	@Qualifier("intnet31JpaMinorVersionService")
	private IntNetJpaMinorVersionService minorVersionService;

	@Autowired
	@Qualifier("intnet31JpaSubProjectService")
	private IntNetJpaSubProjectService subProjectService;

	@Autowired
	@Qualifier("intnet31JpaTldService")
	private IntNetJpaTldService tldService;

	@Autowired
	@Qualifier("intnet31JpaTopDomainService")
	private IntNetJpaTopDomainService topDomainService;

	@Autowired
	@Qualifier("intnet31JpaTopProjectService")
	private IntNetJpaTopProjectService topProjectService;

	@Autowired
	@Qualifier("intnet31JpaURLProtocolService")
	private IntNetJpaURLProtocolService uRLProtocolService;

	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		if ( intnet31EntityManagerFactory == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getEntityManagerFactoryBean",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( intnet31EntityManagerFactory );
	}

	public IntNetJpaSchemaService getSchemaService() {
		if ( schemaService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaService );
	}

	public IntNetJpaFactoryService getFactoryService() {
		if ( factoryService == null ) {
			// Dynamically resolve the factory by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getFactoryService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( factoryService );
	}

	public IntNetJpaIdGenService getIdGenService() {
		if ( idGenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getIdGenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( idGenService );
	}

	public IntNetJpaLicenseRepository getLicenseRepository() {
		if ( licenseRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getLicenseRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( licenseRepository );
	}

	public IntNetJpaMajorVersionRepository getMajorVersionRepository() {
		if ( majorVersionRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getMajorVersionRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( majorVersionRepository );
	}

	public IntNetJpaMimeTypeRepository getMimeTypeRepository() {
		if ( mimeTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getMimeTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( mimeTypeRepository );
	}

	public IntNetJpaMinorVersionRepository getMinorVersionRepository() {
		if ( minorVersionRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getMinorVersionRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( minorVersionRepository );
	}

	public IntNetJpaSubProjectRepository getSubProjectRepository() {
		if ( subProjectRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getSubProjectRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( subProjectRepository );
	}

	public IntNetJpaTldRepository getTldRepository() {
		if ( tldRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTldRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tldRepository );
	}

	public IntNetJpaTopDomainRepository getTopDomainRepository() {
		if ( topDomainRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTopDomainRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( topDomainRepository );
	}

	public IntNetJpaTopProjectRepository getTopProjectRepository() {
		if ( topProjectRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTopProjectRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( topProjectRepository );
	}

	public IntNetJpaURLProtocolRepository getURLProtocolRepository() {
		if ( uRLProtocolRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getURLProtocolRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uRLProtocolRepository );
	}

	public IntNetJpaLicenseService getLicenseService() {
		if ( licenseService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getLicenseService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( licenseService );
	}

	public IntNetJpaMajorVersionService getMajorVersionService() {
		if ( majorVersionService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getMajorVersionService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( majorVersionService );
	}

	public IntNetJpaMimeTypeService getMimeTypeService() {
		if ( mimeTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getMimeTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( mimeTypeService );
	}

	public IntNetJpaMinorVersionService getMinorVersionService() {
		if ( minorVersionService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getMinorVersionService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( minorVersionService );
	}

	public IntNetJpaSubProjectService getSubProjectService() {
		if ( subProjectService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSubProjectService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( subProjectService );
	}

	public IntNetJpaTldService getTldService() {
		if ( tldService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTldService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tldService );
	}

	public IntNetJpaTopDomainService getTopDomainService() {
		if ( topDomainService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTopDomainService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( topDomainService );
	}

	public IntNetJpaTopProjectService getTopProjectService() {
		if ( topProjectService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTopProjectService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( topProjectService );
	}

	public IntNetJpaURLProtocolService getURLProtocolService() {
		if ( uRLProtocolService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getURLProtocolService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uRLProtocolService );
	}
}
