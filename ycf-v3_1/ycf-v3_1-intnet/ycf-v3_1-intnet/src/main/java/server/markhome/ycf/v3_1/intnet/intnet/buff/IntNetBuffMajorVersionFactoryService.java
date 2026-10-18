
// Description: Java 25 Factory service implementation for MajorVersion buffers

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
 *	Java 25 Factory service implementation for MajorVersion buffers.
 */
@Service("intnet31BuffMajorVersionFactoryService")
public class IntNetBuffMajorVersionFactoryService
	implements IIntNetMajorVersionFactory
{
	public IntNetBuffMajorVersionFactoryService() {
	}

	@Override
	public IIntNetMajorVersionHPKey newHPKey() {
		IIntNetMajorVersionHPKey hpkey =
			new IntNetBuffMajorVersionHPKey();
		return( hpkey );
	}

	public IntNetBuffMajorVersionHPKey ensureHPKey(IIntNetMajorVersionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffMajorVersionHPKey) {
			return( (IntNetBuffMajorVersionHPKey)key );
		}
		else {
			IntNetBuffMajorVersionHPKey mapped = new IntNetBuffMajorVersionHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMajorVersionByTenantIdxKey newByTenantIdxKey() {
		IIntNetMajorVersionByTenantIdxKey key =
			new IntNetBuffMajorVersionByTenantIdxKey();
		return( key );
	}

	public IntNetBuffMajorVersionByTenantIdxKey ensureByTenantIdxKey(IIntNetMajorVersionByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffMajorVersionByTenantIdxKey) {
			return( (IntNetBuffMajorVersionByTenantIdxKey)key );
		}
		else {
			IntNetBuffMajorVersionByTenantIdxKey mapped = new IntNetBuffMajorVersionByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMajorVersionBySubProjectIdxKey newBySubProjectIdxKey() {
		IIntNetMajorVersionBySubProjectIdxKey key =
			new IntNetBuffMajorVersionBySubProjectIdxKey();
		return( key );
	}

	public IntNetBuffMajorVersionBySubProjectIdxKey ensureBySubProjectIdxKey(IIntNetMajorVersionBySubProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffMajorVersionBySubProjectIdxKey) {
			return( (IntNetBuffMajorVersionBySubProjectIdxKey)key );
		}
		else {
			IntNetBuffMajorVersionBySubProjectIdxKey mapped = new IntNetBuffMajorVersionBySubProjectIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMajorVersionByNameIdxKey newByNameIdxKey() {
		IIntNetMajorVersionByNameIdxKey key =
			new IntNetBuffMajorVersionByNameIdxKey();
		return( key );
	}

	public IntNetBuffMajorVersionByNameIdxKey ensureByNameIdxKey(IIntNetMajorVersionByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffMajorVersionByNameIdxKey) {
			return( (IntNetBuffMajorVersionByNameIdxKey)key );
		}
		else {
			IntNetBuffMajorVersionByNameIdxKey mapped = new IntNetBuffMajorVersionByNameIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMajorVersion newRec() {
		IIntNetMajorVersion rec =
			new IntNetBuffMajorVersion();
		return( rec );
	}

	public IntNetBuffMajorVersion ensureRec(IIntNetMajorVersion rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffMajorVersion) {
			return ((IntNetBuffMajorVersion)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetMajorVersion.CLASS_CODE: {
					IntNetBuffMajorVersion mapped = new IntNetBuffMajorVersion();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMajorVersion",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMajorVersion");
			}
		}
	}

	@Override
	public IIntNetMajorVersionH newHRec() {
		IIntNetMajorVersionH hrec =
			new IntNetBuffMajorVersionH();
		return( hrec );
	}

	public IntNetBuffMajorVersionH ensureHRec(IIntNetMajorVersionH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffMajorVersionH) {
			return ((IntNetBuffMajorVersionH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetMajorVersion.CLASS_CODE: {
					IntNetBuffMajorVersionH mapped = new IntNetBuffMajorVersionH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMajorVersion",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMajorVersion");
			}
		}
	}
}
