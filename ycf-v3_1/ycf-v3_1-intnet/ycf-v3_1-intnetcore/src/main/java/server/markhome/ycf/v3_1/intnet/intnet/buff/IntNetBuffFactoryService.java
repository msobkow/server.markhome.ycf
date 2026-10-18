// Description: Java 25 buffer implementation of a IntNet factory service.

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

package server.markhome.ycf.v3_1.intnet.intnet.buff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

@Service("intnet31BuffFactoryService")
public class IntNetBuffFactoryService
	implements IIntNetFactory
{

	@Autowired
	@Qualifier("intnet31BuffLicenseFactoryService")
	protected IntNetBuffLicenseFactoryService licenseFactoryService;

	@Autowired
	@Qualifier("intnet31BuffMajorVersionFactoryService")
	protected IntNetBuffMajorVersionFactoryService majorversionFactoryService;

	@Autowired
	@Qualifier("intnet31BuffMimeTypeFactoryService")
	protected IntNetBuffMimeTypeFactoryService mimetypeFactoryService;

	@Autowired
	@Qualifier("intnet31BuffMinorVersionFactoryService")
	protected IntNetBuffMinorVersionFactoryService minorversionFactoryService;

	@Autowired
	@Qualifier("intnet31BuffSubProjectFactoryService")
	protected IntNetBuffSubProjectFactoryService subprojectFactoryService;

	@Autowired
	@Qualifier("intnet31BuffTldFactoryService")
	protected IntNetBuffTldFactoryService tldFactoryService;

	@Autowired
	@Qualifier("intnet31BuffTopDomainFactoryService")
	protected IntNetBuffTopDomainFactoryService topdomainFactoryService;

	@Autowired
	@Qualifier("intnet31BuffTopProjectFactoryService")
	protected IntNetBuffTopProjectFactoryService topprojectFactoryService;

	@Autowired
	@Qualifier("intnet31BuffURLProtocolFactoryService")
	protected IntNetBuffURLProtocolFactoryService urlprotocolFactoryService;


	public IntNetBuffFactoryService() { }

	@Override
	public IIntNetLicenseFactory getFactoryLicense() {
		return(licenseFactoryService);
	}

	public IntNetBuffLicenseFactoryService getLicenseFactoryService() {
		return(licenseFactoryService);
	}

	@Override
	public IIntNetMajorVersionFactory getFactoryMajorVersion() {
		return(majorversionFactoryService);
	}

	public IntNetBuffMajorVersionFactoryService getMajorVersionFactoryService() {
		return(majorversionFactoryService);
	}

	@Override
	public IIntNetMimeTypeFactory getFactoryMimeType() {
		return(mimetypeFactoryService);
	}

	public IntNetBuffMimeTypeFactoryService getMimeTypeFactoryService() {
		return(mimetypeFactoryService);
	}

	@Override
	public IIntNetMinorVersionFactory getFactoryMinorVersion() {
		return(minorversionFactoryService);
	}

	public IntNetBuffMinorVersionFactoryService getMinorVersionFactoryService() {
		return(minorversionFactoryService);
	}

	@Override
	public IIntNetSubProjectFactory getFactorySubProject() {
		return(subprojectFactoryService);
	}

	public IntNetBuffSubProjectFactoryService getSubProjectFactoryService() {
		return(subprojectFactoryService);
	}

	@Override
	public IIntNetTldFactory getFactoryTld() {
		return(tldFactoryService);
	}

	public IntNetBuffTldFactoryService getTldFactoryService() {
		return(tldFactoryService);
	}

	@Override
	public IIntNetTopDomainFactory getFactoryTopDomain() {
		return(topdomainFactoryService);
	}

	public IntNetBuffTopDomainFactoryService getTopDomainFactoryService() {
		return(topdomainFactoryService);
	}

	@Override
	public IIntNetTopProjectFactory getFactoryTopProject() {
		return(topprojectFactoryService);
	}

	public IntNetBuffTopProjectFactoryService getTopProjectFactoryService() {
		return(topprojectFactoryService);
	}

	@Override
	public IIntNetURLProtocolFactory getFactoryURLProtocol() {
		return(urlprotocolFactoryService);
	}

	public IntNetBuffURLProtocolFactoryService getURLProtocolFactoryService() {
		return(urlprotocolFactoryService);
	}

}
