
// Description: Java 25 Factory service implementation for SecSysGrpMemb buffers

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
 *	Java 25 Factory service implementation for SecSysGrpMemb buffers.
 */
@Service("secure31BuffSecSysGrpMembFactoryService")
public class SecureBuffSecSysGrpMembFactoryService
	implements ISecureSecSysGrpMembFactory
{
	public SecureBuffSecSysGrpMembFactoryService() {
	}

    @Override
    public ISecureSecSysGrpMembPKey newPKey() {
        ISecureSecSysGrpMembPKey pkey =
            new SecureBuffSecSysGrpMembPKey();
        return( pkey );
    }

	public SecureBuffSecSysGrpMembPKey ensurePKey(ISecureSecSysGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpMembPKey) {
			return( (SecureBuffSecSysGrpMembPKey)key );
		}
		else {
			SecureBuffSecSysGrpMembPKey mapped = new SecureBuffSecSysGrpMembPKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpMembHPKey newHPKey() {
		ISecureSecSysGrpMembHPKey hpkey =
			new SecureBuffSecSysGrpMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysGrpMembHPKey ensureHPKey(ISecureSecSysGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysGrpMembHPKey) {
			return( (SecureBuffSecSysGrpMembHPKey)key );
		}
		else {
			SecureBuffSecSysGrpMembHPKey mapped = new SecureBuffSecSysGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpMembBySysGrpIdxKey newBySysGrpIdxKey() {
		ISecureSecSysGrpMembBySysGrpIdxKey key =
			new SecureBuffSecSysGrpMembBySysGrpIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpMembBySysGrpIdxKey ensureBySysGrpIdxKey(ISecureSecSysGrpMembBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpMembBySysGrpIdxKey) {
			return( (SecureBuffSecSysGrpMembBySysGrpIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpMembBySysGrpIdxKey mapped = new SecureBuffSecSysGrpMembBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecSysGrpMembByLoginIdxKey key =
			new SecureBuffSecSysGrpMembByLoginIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecSysGrpMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpMembByLoginIdxKey) {
			return( (SecureBuffSecSysGrpMembByLoginIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpMembByLoginIdxKey mapped = new SecureBuffSecSysGrpMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpMemb newRec() {
		ISecureSecSysGrpMemb rec =
			new SecureBuffSecSysGrpMemb();
		return( rec );
	}

	public SecureBuffSecSysGrpMemb ensureRec(ISecureSecSysGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysGrpMemb) {
			return ((SecureBuffSecSysGrpMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysGrpMemb.CLASS_CODE: {
					SecureBuffSecSysGrpMemb mapped = new SecureBuffSecSysGrpMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb");
			}
		}
	}

	@Override
	public ISecureSecSysGrpMembH newHRec() {
		ISecureSecSysGrpMembH hrec =
			new SecureBuffSecSysGrpMembH();
		return( hrec );
	}

	public SecureBuffSecSysGrpMembH ensureHRec(ISecureSecSysGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysGrpMembH) {
			return ((SecureBuffSecSysGrpMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysGrpMemb.CLASS_CODE: {
					SecureBuffSecSysGrpMembH mapped = new SecureBuffSecSysGrpMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb");
			}
		}
	}
}
