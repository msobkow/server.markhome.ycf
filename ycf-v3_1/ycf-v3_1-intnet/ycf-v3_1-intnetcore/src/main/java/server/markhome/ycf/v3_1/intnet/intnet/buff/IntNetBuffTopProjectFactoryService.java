
// Description: Java 25 Factory service implementation for TopProject buffers

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

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/*
 *	Java 25 Factory service implementation for TopProject buffers.
 */
@Service("intnet31BuffTopProjectFactoryService")
public class IntNetBuffTopProjectFactoryService
	implements IIntNetTopProjectFactory
{
	public IntNetBuffTopProjectFactoryService() {
	}

	@Override
	public IIntNetTopProjectHPKey newHPKey() {
		IIntNetTopProjectHPKey hpkey =
			new IntNetBuffTopProjectHPKey();
		return( hpkey );
	}

	public IntNetBuffTopProjectHPKey ensureHPKey(IIntNetTopProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffTopProjectHPKey) {
			return( (IntNetBuffTopProjectHPKey)key );
		}
		else {
			IntNetBuffTopProjectHPKey mapped = new IntNetBuffTopProjectHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopProjectByTenantIdxKey newByTenantIdxKey() {
		IIntNetTopProjectByTenantIdxKey key =
			new IntNetBuffTopProjectByTenantIdxKey();
		return( key );
	}

	public IntNetBuffTopProjectByTenantIdxKey ensureByTenantIdxKey(IIntNetTopProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopProjectByTenantIdxKey) {
			return( (IntNetBuffTopProjectByTenantIdxKey)key );
		}
		else {
			IntNetBuffTopProjectByTenantIdxKey mapped = new IntNetBuffTopProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopProjectByTopDomainIdxKey newByTopDomainIdxKey() {
		IIntNetTopProjectByTopDomainIdxKey key =
			new IntNetBuffTopProjectByTopDomainIdxKey();
		return( key );
	}

	public IntNetBuffTopProjectByTopDomainIdxKey ensureByTopDomainIdxKey(IIntNetTopProjectByTopDomainIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopProjectByTopDomainIdxKey) {
			return( (IntNetBuffTopProjectByTopDomainIdxKey)key );
		}
		else {
			IntNetBuffTopProjectByTopDomainIdxKey mapped = new IntNetBuffTopProjectByTopDomainIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopProjectByNameIdxKey newByNameIdxKey() {
		IIntNetTopProjectByNameIdxKey key =
			new IntNetBuffTopProjectByNameIdxKey();
		return( key );
	}

	public IntNetBuffTopProjectByNameIdxKey ensureByNameIdxKey(IIntNetTopProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopProjectByNameIdxKey) {
			return( (IntNetBuffTopProjectByNameIdxKey)key );
		}
		else {
			IntNetBuffTopProjectByNameIdxKey mapped = new IntNetBuffTopProjectByNameIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopProject newRec() {
		IIntNetTopProject rec =
			new IntNetBuffTopProject();
		return( rec );
	}

	public IntNetBuffTopProject ensureRec(IIntNetTopProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffTopProject) {
			return ((IntNetBuffTopProject)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetTopProject.CLASS_CODE: {
					IntNetBuffTopProject mapped = new IntNetBuffTopProject();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopProject",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopProject");
			}
		}
	}

	@Override
	public IIntNetTopProjectH newHRec() {
		IIntNetTopProjectH hrec =
			new IntNetBuffTopProjectH();
		return( hrec );
	}

	public IntNetBuffTopProjectH ensureHRec(IIntNetTopProjectH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffTopProjectH) {
			return ((IntNetBuffTopProjectH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetTopProject.CLASS_CODE: {
					IntNetBuffTopProjectH mapped = new IntNetBuffTopProjectH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopProject",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopProject");
			}
		}
	}
}
