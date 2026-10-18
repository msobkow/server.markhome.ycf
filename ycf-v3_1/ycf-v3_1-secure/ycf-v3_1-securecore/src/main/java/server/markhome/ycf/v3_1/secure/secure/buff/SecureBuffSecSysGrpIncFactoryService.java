
// Description: Java 25 Factory service implementation for SecSysGrpInc buffers

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secure.buff;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/*
 *	Java 25 Factory service implementation for SecSysGrpInc buffers.
 */
@Service("secure31BuffSecSysGrpIncFactoryService")
public class SecureBuffSecSysGrpIncFactoryService
	implements ISecureSecSysGrpIncFactory
{
	public SecureBuffSecSysGrpIncFactoryService() {
	}

    @Override
    public ISecureSecSysGrpIncPKey newPKey() {
        ISecureSecSysGrpIncPKey pkey =
            new SecureBuffSecSysGrpIncPKey();
        return( pkey );
    }

	public SecureBuffSecSysGrpIncPKey ensurePKey(ISecureSecSysGrpIncPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpIncPKey) {
			return( (SecureBuffSecSysGrpIncPKey)key );
		}
		else {
			SecureBuffSecSysGrpIncPKey mapped = new SecureBuffSecSysGrpIncPKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpIncHPKey newHPKey() {
		ISecureSecSysGrpIncHPKey hpkey =
			new SecureBuffSecSysGrpIncHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysGrpIncHPKey ensureHPKey(ISecureSecSysGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysGrpIncHPKey) {
			return( (SecureBuffSecSysGrpIncHPKey)key );
		}
		else {
			SecureBuffSecSysGrpIncHPKey mapped = new SecureBuffSecSysGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpIncBySysGrpIdxKey newBySysGrpIdxKey() {
		ISecureSecSysGrpIncBySysGrpIdxKey key =
			new SecureBuffSecSysGrpIncBySysGrpIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpIncBySysGrpIdxKey ensureBySysGrpIdxKey(ISecureSecSysGrpIncBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpIncBySysGrpIdxKey) {
			return( (SecureBuffSecSysGrpIncBySysGrpIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpIncBySysGrpIdxKey mapped = new SecureBuffSecSysGrpIncBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpIncByNameIdxKey newByNameIdxKey() {
		ISecureSecSysGrpIncByNameIdxKey key =
			new SecureBuffSecSysGrpIncByNameIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpIncByNameIdxKey ensureByNameIdxKey(ISecureSecSysGrpIncByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpIncByNameIdxKey) {
			return( (SecureBuffSecSysGrpIncByNameIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpIncByNameIdxKey mapped = new SecureBuffSecSysGrpIncByNameIdxKey();
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpInc newRec() {
		ISecureSecSysGrpInc rec =
			new SecureBuffSecSysGrpInc();
		return( rec );
	}

	public SecureBuffSecSysGrpInc ensureRec(ISecureSecSysGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysGrpInc) {
			return ((SecureBuffSecSysGrpInc)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysGrpInc.CLASS_CODE: {
					SecureBuffSecSysGrpInc mapped = new SecureBuffSecSysGrpInc();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpInc",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpInc");
			}
		}
	}

	@Override
	public ISecureSecSysGrpIncH newHRec() {
		ISecureSecSysGrpIncH hrec =
			new SecureBuffSecSysGrpIncH();
		return( hrec );
	}

	public SecureBuffSecSysGrpIncH ensureHRec(ISecureSecSysGrpIncH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysGrpIncH) {
			return ((SecureBuffSecSysGrpIncH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysGrpInc.CLASS_CODE: {
					SecureBuffSecSysGrpIncH mapped = new SecureBuffSecSysGrpIncH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpInc",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpInc");
			}
		}
	}
}
