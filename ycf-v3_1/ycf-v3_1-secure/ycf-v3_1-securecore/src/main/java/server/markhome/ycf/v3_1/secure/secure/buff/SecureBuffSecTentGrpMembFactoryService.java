
// Description: Java 25 Factory service implementation for SecTentGrpMemb buffers

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
 *	Java 25 Factory service implementation for SecTentGrpMemb buffers.
 */
@Service("secure31BuffSecTentGrpMembFactoryService")
public class SecureBuffSecTentGrpMembFactoryService
	implements ISecureSecTentGrpMembFactory
{
	public SecureBuffSecTentGrpMembFactoryService() {
	}

    @Override
    public ISecureSecTentGrpMembPKey newPKey() {
        ISecureSecTentGrpMembPKey pkey =
            new SecureBuffSecTentGrpMembPKey();
        return( pkey );
    }

	public SecureBuffSecTentGrpMembPKey ensurePKey(ISecureSecTentGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpMembPKey) {
			return( (SecureBuffSecTentGrpMembPKey)key );
		}
		else {
			SecureBuffSecTentGrpMembPKey mapped = new SecureBuffSecTentGrpMembPKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpMembHPKey newHPKey() {
		ISecureSecTentGrpMembHPKey hpkey =
			new SecureBuffSecTentGrpMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecTentGrpMembHPKey ensureHPKey(ISecureSecTentGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecTentGrpMembHPKey) {
			return( (SecureBuffSecTentGrpMembHPKey)key );
		}
		else {
			SecureBuffSecTentGrpMembHPKey mapped = new SecureBuffSecTentGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpMembByTentGrpIdxKey newByTentGrpIdxKey() {
		ISecureSecTentGrpMembByTentGrpIdxKey key =
			new SecureBuffSecTentGrpMembByTentGrpIdxKey();
		return( key );
	}

	public SecureBuffSecTentGrpMembByTentGrpIdxKey ensureByTentGrpIdxKey(ISecureSecTentGrpMembByTentGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpMembByTentGrpIdxKey) {
			return( (SecureBuffSecTentGrpMembByTentGrpIdxKey)key );
		}
		else {
			SecureBuffSecTentGrpMembByTentGrpIdxKey mapped = new SecureBuffSecTentGrpMembByTentGrpIdxKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpMembByUserIdxKey newByUserIdxKey() {
		ISecureSecTentGrpMembByUserIdxKey key =
			new SecureBuffSecTentGrpMembByUserIdxKey();
		return( key );
	}

	public SecureBuffSecTentGrpMembByUserIdxKey ensureByUserIdxKey(ISecureSecTentGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpMembByUserIdxKey) {
			return( (SecureBuffSecTentGrpMembByUserIdxKey)key );
		}
		else {
			SecureBuffSecTentGrpMembByUserIdxKey mapped = new SecureBuffSecTentGrpMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpMemb newRec() {
		ISecureSecTentGrpMemb rec =
			new SecureBuffSecTentGrpMemb();
		return( rec );
	}

	public SecureBuffSecTentGrpMemb ensureRec(ISecureSecTentGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecTentGrpMemb) {
			return ((SecureBuffSecTentGrpMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecTentGrpMemb.CLASS_CODE: {
					SecureBuffSecTentGrpMemb mapped = new SecureBuffSecTentGrpMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb");
			}
		}
	}

	@Override
	public ISecureSecTentGrpMembH newHRec() {
		ISecureSecTentGrpMembH hrec =
			new SecureBuffSecTentGrpMembH();
		return( hrec );
	}

	public SecureBuffSecTentGrpMembH ensureHRec(ISecureSecTentGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecTentGrpMembH) {
			return ((SecureBuffSecTentGrpMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecTentGrpMemb.CLASS_CODE: {
					SecureBuffSecTentGrpMembH mapped = new SecureBuffSecTentGrpMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb");
			}
		}
	}
}
