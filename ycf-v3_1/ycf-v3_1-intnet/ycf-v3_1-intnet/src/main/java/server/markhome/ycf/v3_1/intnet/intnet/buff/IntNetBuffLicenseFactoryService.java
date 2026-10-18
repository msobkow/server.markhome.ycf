
// Description: Java 25 Factory service implementation for License buffers

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
 *	Java 25 Factory service implementation for License buffers.
 */
@Service("intnet31BuffLicenseFactoryService")
public class IntNetBuffLicenseFactoryService
	implements IIntNetLicenseFactory
{
	public IntNetBuffLicenseFactoryService() {
	}

	@Override
	public IIntNetLicenseHPKey newHPKey() {
		IIntNetLicenseHPKey hpkey =
			new IntNetBuffLicenseHPKey();
		return( hpkey );
	}

	public IntNetBuffLicenseHPKey ensureHPKey(IIntNetLicenseHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffLicenseHPKey) {
			return( (IntNetBuffLicenseHPKey)key );
		}
		else {
			IntNetBuffLicenseHPKey mapped = new IntNetBuffLicenseHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetLicenseByLicnTenantIdxKey newByLicnTenantIdxKey() {
		IIntNetLicenseByLicnTenantIdxKey key =
			new IntNetBuffLicenseByLicnTenantIdxKey();
		return( key );
	}

	public IntNetBuffLicenseByLicnTenantIdxKey ensureByLicnTenantIdxKey(IIntNetLicenseByLicnTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffLicenseByLicnTenantIdxKey) {
			return( (IntNetBuffLicenseByLicnTenantIdxKey)key );
		}
		else {
			IntNetBuffLicenseByLicnTenantIdxKey mapped = new IntNetBuffLicenseByLicnTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetLicenseByDomainIdxKey newByDomainIdxKey() {
		IIntNetLicenseByDomainIdxKey key =
			new IntNetBuffLicenseByDomainIdxKey();
		return( key );
	}

	public IntNetBuffLicenseByDomainIdxKey ensureByDomainIdxKey(IIntNetLicenseByDomainIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffLicenseByDomainIdxKey) {
			return( (IntNetBuffLicenseByDomainIdxKey)key );
		}
		else {
			IntNetBuffLicenseByDomainIdxKey mapped = new IntNetBuffLicenseByDomainIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetLicenseByUNameIdxKey newByUNameIdxKey() {
		IIntNetLicenseByUNameIdxKey key =
			new IntNetBuffLicenseByUNameIdxKey();
		return( key );
	}

	public IntNetBuffLicenseByUNameIdxKey ensureByUNameIdxKey(IIntNetLicenseByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffLicenseByUNameIdxKey) {
			return( (IntNetBuffLicenseByUNameIdxKey)key );
		}
		else {
			IntNetBuffLicenseByUNameIdxKey mapped = new IntNetBuffLicenseByUNameIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetLicense newRec() {
		IIntNetLicense rec =
			new IntNetBuffLicense();
		return( rec );
	}

	public IntNetBuffLicense ensureRec(IIntNetLicense rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffLicense) {
			return ((IntNetBuffLicense)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetLicense.CLASS_CODE: {
					IntNetBuffLicense mapped = new IntNetBuffLicense();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetLicense",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetLicense");
			}
		}
	}

	@Override
	public IIntNetLicenseH newHRec() {
		IIntNetLicenseH hrec =
			new IntNetBuffLicenseH();
		return( hrec );
	}

	public IntNetBuffLicenseH ensureHRec(IIntNetLicenseH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffLicenseH) {
			return ((IntNetBuffLicenseH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetLicense.CLASS_CODE: {
					IntNetBuffLicenseH mapped = new IntNetBuffLicenseH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetLicense",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetLicense");
			}
		}
	}
}
