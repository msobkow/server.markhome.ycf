
// Description: Spring Ram storage tests for IntNet for the RamTest program

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

package server.markhome.ycf.v3_1.busmodel.busmodelramtest.spring;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
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