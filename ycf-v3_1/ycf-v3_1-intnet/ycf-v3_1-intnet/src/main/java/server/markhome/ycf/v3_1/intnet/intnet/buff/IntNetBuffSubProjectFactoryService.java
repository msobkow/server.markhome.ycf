
// Description: Java 25 Factory service implementation for SubProject buffers

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
 *	Java 25 Factory service implementation for SubProject buffers.
 */
@Service("intnet31BuffSubProjectFactoryService")
public class IntNetBuffSubProjectFactoryService
	implements IIntNetSubProjectFactory
{
	public IntNetBuffSubProjectFactoryService() {
	}

	@Override
	public IIntNetSubProjectHPKey newHPKey() {
		IIntNetSubProjectHPKey hpkey =
			new IntNetBuffSubProjectHPKey();
		return( hpkey );
	}

	public IntNetBuffSubProjectHPKey ensureHPKey(IIntNetSubProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffSubProjectHPKey) {
			return( (IntNetBuffSubProjectHPKey)key );
		}
		else {
			IntNetBuffSubProjectHPKey mapped = new IntNetBuffSubProjectHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetSubProjectByTenantIdxKey newByTenantIdxKey() {
		IIntNetSubProjectByTenantIdxKey key =
			new IntNetBuffSubProjectByTenantIdxKey();
		return( key );
	}

	public IntNetBuffSubProjectByTenantIdxKey ensureByTenantIdxKey(IIntNetSubProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffSubProjectByTenantIdxKey) {
			return( (IntNetBuffSubProjectByTenantIdxKey)key );
		}
		else {
			IntNetBuffSubProjectByTenantIdxKey mapped = new IntNetBuffSubProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetSubProjectByTopProjectIdxKey newByTopProjectIdxKey() {
		IIntNetSubProjectByTopProjectIdxKey key =
			new IntNetBuffSubProjectByTopProjectIdxKey();
		return( key );
	}

	public IntNetBuffSubProjectByTopProjectIdxKey ensureByTopProjectIdxKey(IIntNetSubProjectByTopProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffSubProjectByTopProjectIdxKey) {
			return( (IntNetBuffSubProjectByTopProjectIdxKey)key );
		}
		else {
			IntNetBuffSubProjectByTopProjectIdxKey mapped = new IntNetBuffSubProjectByTopProjectIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetSubProjectByNameIdxKey newByNameIdxKey() {
		IIntNetSubProjectByNameIdxKey key =
			new IntNetBuffSubProjectByNameIdxKey();
		return( key );
	}

	public IntNetBuffSubProjectByNameIdxKey ensureByNameIdxKey(IIntNetSubProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffSubProjectByNameIdxKey) {
			return( (IntNetBuffSubProjectByNameIdxKey)key );
		}
		else {
			IntNetBuffSubProjectByNameIdxKey mapped = new IntNetBuffSubProjectByNameIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetSubProject newRec() {
		IIntNetSubProject rec =
			new IntNetBuffSubProject();
		return( rec );
	}

	public IntNetBuffSubProject ensureRec(IIntNetSubProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffSubProject) {
			return ((IntNetBuffSubProject)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetSubProject.CLASS_CODE: {
					IntNetBuffSubProject mapped = new IntNetBuffSubProject();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetSubProject",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetSubProject");
			}
		}
	}

	@Override
	public IIntNetSubProjectH newHRec() {
		IIntNetSubProjectH hrec =
			new IntNetBuffSubProjectH();
		return( hrec );
	}

	public IntNetBuffSubProjectH ensureHRec(IIntNetSubProjectH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffSubProjectH) {
			return ((IntNetBuffSubProjectH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetSubProject.CLASS_CODE: {
					IntNetBuffSubProjectH mapped = new IntNetBuffSubProjectH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetSubProject",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetSubProject");
			}
		}
	}
}
