
// Description: Java 25 Factory service implementation for TopDomain buffers

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
 *	Java 25 Factory service implementation for TopDomain buffers.
 */
@Service("intnet31BuffTopDomainFactoryService")
public class IntNetBuffTopDomainFactoryService
	implements IIntNetTopDomainFactory
{
	public IntNetBuffTopDomainFactoryService() {
	}

	@Override
	public IIntNetTopDomainHPKey newHPKey() {
		IIntNetTopDomainHPKey hpkey =
			new IntNetBuffTopDomainHPKey();
		return( hpkey );
	}

	public IntNetBuffTopDomainHPKey ensureHPKey(IIntNetTopDomainHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffTopDomainHPKey) {
			return( (IntNetBuffTopDomainHPKey)key );
		}
		else {
			IntNetBuffTopDomainHPKey mapped = new IntNetBuffTopDomainHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopDomainByTenantIdxKey newByTenantIdxKey() {
		IIntNetTopDomainByTenantIdxKey key =
			new IntNetBuffTopDomainByTenantIdxKey();
		return( key );
	}

	public IntNetBuffTopDomainByTenantIdxKey ensureByTenantIdxKey(IIntNetTopDomainByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopDomainByTenantIdxKey) {
			return( (IntNetBuffTopDomainByTenantIdxKey)key );
		}
		else {
			IntNetBuffTopDomainByTenantIdxKey mapped = new IntNetBuffTopDomainByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopDomainByTldIdxKey newByTldIdxKey() {
		IIntNetTopDomainByTldIdxKey key =
			new IntNetBuffTopDomainByTldIdxKey();
		return( key );
	}

	public IntNetBuffTopDomainByTldIdxKey ensureByTldIdxKey(IIntNetTopDomainByTldIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopDomainByTldIdxKey) {
			return( (IntNetBuffTopDomainByTldIdxKey)key );
		}
		else {
			IntNetBuffTopDomainByTldIdxKey mapped = new IntNetBuffTopDomainByTldIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopDomainByNameIdxKey newByNameIdxKey() {
		IIntNetTopDomainByNameIdxKey key =
			new IntNetBuffTopDomainByNameIdxKey();
		return( key );
	}

	public IntNetBuffTopDomainByNameIdxKey ensureByNameIdxKey(IIntNetTopDomainByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTopDomainByNameIdxKey) {
			return( (IntNetBuffTopDomainByNameIdxKey)key );
		}
		else {
			IntNetBuffTopDomainByNameIdxKey mapped = new IntNetBuffTopDomainByNameIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTopDomain newRec() {
		IIntNetTopDomain rec =
			new IntNetBuffTopDomain();
		return( rec );
	}

	public IntNetBuffTopDomain ensureRec(IIntNetTopDomain rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffTopDomain) {
			return ((IntNetBuffTopDomain)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetTopDomain.CLASS_CODE: {
					IntNetBuffTopDomain mapped = new IntNetBuffTopDomain();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopDomain",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopDomain");
			}
		}
	}

	@Override
	public IIntNetTopDomainH newHRec() {
		IIntNetTopDomainH hrec =
			new IntNetBuffTopDomainH();
		return( hrec );
	}

	public IntNetBuffTopDomainH ensureHRec(IIntNetTopDomainH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffTopDomainH) {
			return ((IntNetBuffTopDomainH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetTopDomain.CLASS_CODE: {
					IntNetBuffTopDomainH mapped = new IntNetBuffTopDomainH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopDomain",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopDomain");
			}
		}
	}
}
