// Description: Java 25 JPA implementation of a IntNet factory service.

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;

/**
 *	JPA Factory Services for schema IntNet as specified by IIntNetFactory.
 */
@Service("intnet31JpaFactoryService")
public class IntNetJpaFactoryService
	implements IIntNetFactory
{

	@Autowired
	@Qualifier("intnet31JpaLicenseFactoryService")
	protected IntNetJpaLicenseFactoryService licenseFactoryService;

	@Autowired
	@Qualifier("intnet31JpaMajorVersionFactoryService")
	protected IntNetJpaMajorVersionFactoryService majorversionFactoryService;

	@Autowired
	@Qualifier("intnet31JpaMimeTypeFactoryService")
	protected IntNetJpaMimeTypeFactoryService mimetypeFactoryService;

	@Autowired
	@Qualifier("intnet31JpaMinorVersionFactoryService")
	protected IntNetJpaMinorVersionFactoryService minorversionFactoryService;

	@Autowired
	@Qualifier("intnet31JpaSubProjectFactoryService")
	protected IntNetJpaSubProjectFactoryService subprojectFactoryService;

	@Autowired
	@Qualifier("intnet31JpaTldFactoryService")
	protected IntNetJpaTldFactoryService tldFactoryService;

	@Autowired
	@Qualifier("intnet31JpaTopDomainFactoryService")
	protected IntNetJpaTopDomainFactoryService topdomainFactoryService;

	@Autowired
	@Qualifier("intnet31JpaTopProjectFactoryService")
	protected IntNetJpaTopProjectFactoryService topprojectFactoryService;

	@Autowired
	@Qualifier("intnet31JpaURLProtocolFactoryService")
	protected IntNetJpaURLProtocolFactoryService urlprotocolFactoryService;


	public IntNetJpaFactoryService() { }

	@Override
	public IIntNetLicenseFactory getFactoryLicense() {
		return(licenseFactoryService);
	}

	public IntNetJpaLicenseFactoryService getLicenseFactoryService() {
		return(licenseFactoryService);
	}

	@Override
	public IIntNetMajorVersionFactory getFactoryMajorVersion() {
		return(majorversionFactoryService);
	}

	public IntNetJpaMajorVersionFactoryService getMajorVersionFactoryService() {
		return(majorversionFactoryService);
	}

	@Override
	public IIntNetMimeTypeFactory getFactoryMimeType() {
		return(mimetypeFactoryService);
	}

	public IntNetJpaMimeTypeFactoryService getMimeTypeFactoryService() {
		return(mimetypeFactoryService);
	}

	@Override
	public IIntNetMinorVersionFactory getFactoryMinorVersion() {
		return(minorversionFactoryService);
	}

	public IntNetJpaMinorVersionFactoryService getMinorVersionFactoryService() {
		return(minorversionFactoryService);
	}

	@Override
	public IIntNetSubProjectFactory getFactorySubProject() {
		return(subprojectFactoryService);
	}

	public IntNetJpaSubProjectFactoryService getSubProjectFactoryService() {
		return(subprojectFactoryService);
	}

	@Override
	public IIntNetTldFactory getFactoryTld() {
		return(tldFactoryService);
	}

	public IntNetJpaTldFactoryService getTldFactoryService() {
		return(tldFactoryService);
	}

	@Override
	public IIntNetTopDomainFactory getFactoryTopDomain() {
		return(topdomainFactoryService);
	}

	public IntNetJpaTopDomainFactoryService getTopDomainFactoryService() {
		return(topdomainFactoryService);
	}

	@Override
	public IIntNetTopProjectFactory getFactoryTopProject() {
		return(topprojectFactoryService);
	}

	public IntNetJpaTopProjectFactoryService getTopProjectFactoryService() {
		return(topprojectFactoryService);
	}

	@Override
	public IIntNetURLProtocolFactory getFactoryURLProtocol() {
		return(urlprotocolFactoryService);
	}

	public IntNetJpaURLProtocolFactoryService getURLProtocolFactoryService() {
		return(urlprotocolFactoryService);
	}

}
