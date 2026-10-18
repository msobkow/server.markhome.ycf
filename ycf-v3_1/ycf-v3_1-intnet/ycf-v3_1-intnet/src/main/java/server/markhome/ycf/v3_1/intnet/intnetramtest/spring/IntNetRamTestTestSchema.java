
// Description: Spring Ram storage tests for IntNet for the RamTest program

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

package server.markhome.ycf.v3_1.intnet.intnetramtest.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

@Service("RamTestIntNet")
public class IntNetRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting IntNet tests...\n");
		IIntNetLicense[] licenseResults = IIntNetSchema.getBackingIntNet().getTableLicense().readAllDerived(null);
		if (licenseResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getLicenseTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + licenseResults.length + " entities from IntNet.License\n");
		}

		IIntNetMajorVersion[] majorVersionResults = IIntNetSchema.getBackingIntNet().getTableMajorVersion().readAllDerived(null);
		if (majorVersionResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getMajorVersionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + majorVersionResults.length + " entities from IntNet.MajorVersion\n");
		}

		IIntNetMimeType[] mimeTypeResults = IIntNetSchema.getBackingIntNet().getTableMimeType().readAllDerived(null);
		if (mimeTypeResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getMimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + mimeTypeResults.length + " entities from IntNet.MimeType\n");
		}

		IIntNetMinorVersion[] minorVersionResults = IIntNetSchema.getBackingIntNet().getTableMinorVersion().readAllDerived(null);
		if (minorVersionResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getMinorVersionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + minorVersionResults.length + " entities from IntNet.MinorVersion\n");
		}

		IIntNetSubProject[] subProjectResults = IIntNetSchema.getBackingIntNet().getTableSubProject().readAllDerived(null);
		if (subProjectResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getSubProjectTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + subProjectResults.length + " entities from IntNet.SubProject\n");
		}

		IIntNetTld[] tldResults = IIntNetSchema.getBackingIntNet().getTableTld().readAllDerived(null);
		if (tldResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getTldTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tldResults.length + " entities from IntNet.Tld\n");
		}

		IIntNetTopDomain[] topDomainResults = IIntNetSchema.getBackingIntNet().getTableTopDomain().readAllDerived(null);
		if (topDomainResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getTopDomainTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + topDomainResults.length + " entities from IntNet.TopDomain\n");
		}

		IIntNetTopProject[] topProjectResults = IIntNetSchema.getBackingIntNet().getTableTopProject().readAllDerived(null);
		if (topProjectResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getTopProjectTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + topProjectResults.length + " entities from IntNet.TopProject\n");
		}

		IIntNetURLProtocol[] uRLProtocolResults = IIntNetSchema.getBackingIntNet().getTableURLProtocol().readAllDerived(null);
		if (uRLProtocolResults == null) {
			messages.append("Erroneously retrieved null for IIntNetSchema.getURLProtocolTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uRLProtocolResults.length + " entities from IntNet.URLProtocol\n");
		}

		messages.append("IntNet tests complete\n");
		return( messages.toString() );
	}
}