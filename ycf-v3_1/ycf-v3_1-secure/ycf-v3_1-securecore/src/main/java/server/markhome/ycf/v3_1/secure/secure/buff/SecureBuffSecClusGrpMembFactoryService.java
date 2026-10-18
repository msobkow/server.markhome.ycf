
// Description: Java 25 Factory service implementation for SecClusGrpMemb buffers

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
 *	Java 25 Factory service implementation for SecClusGrpMemb buffers.
 */
@Service("secure31BuffSecClusGrpMembFactoryService")
public class SecureBuffSecClusGrpMembFactoryService
	implements ISecureSecClusGrpMembFactory
{
	public SecureBuffSecClusGrpMembFactoryService() {
	}

    @Override
    public ISecureSecClusGrpMembPKey newPKey() {
        ISecureSecClusGrpMembPKey pkey =
            new SecureBuffSecClusGrpMembPKey();
        return( pkey );
    }

	public SecureBuffSecClusGrpMembPKey ensurePKey(ISecureSecClusGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpMembPKey) {
			return( (SecureBuffSecClusGrpMembPKey)key );
		}
		else {
			SecureBuffSecClusGrpMembPKey mapped = new SecureBuffSecClusGrpMembPKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpMembHPKey newHPKey() {
		ISecureSecClusGrpMembHPKey hpkey =
			new SecureBuffSecClusGrpMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecClusGrpMembHPKey ensureHPKey(ISecureSecClusGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecClusGrpMembHPKey) {
			return( (SecureBuffSecClusGrpMembHPKey)key );
		}
		else {
			SecureBuffSecClusGrpMembHPKey mapped = new SecureBuffSecClusGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpMembByClusGrpIdxKey newByClusGrpIdxKey() {
		ISecureSecClusGrpMembByClusGrpIdxKey key =
			new SecureBuffSecClusGrpMembByClusGrpIdxKey();
		return( key );
	}

	public SecureBuffSecClusGrpMembByClusGrpIdxKey ensureByClusGrpIdxKey(ISecureSecClusGrpMembByClusGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpMembByClusGrpIdxKey) {
			return( (SecureBuffSecClusGrpMembByClusGrpIdxKey)key );
		}
		else {
			SecureBuffSecClusGrpMembByClusGrpIdxKey mapped = new SecureBuffSecClusGrpMembByClusGrpIdxKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecClusGrpMembByLoginIdxKey key =
			new SecureBuffSecClusGrpMembByLoginIdxKey();
		return( key );
	}

	public SecureBuffSecClusGrpMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecClusGrpMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpMembByLoginIdxKey) {
			return( (SecureBuffSecClusGrpMembByLoginIdxKey)key );
		}
		else {
			SecureBuffSecClusGrpMembByLoginIdxKey mapped = new SecureBuffSecClusGrpMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpMemb newRec() {
		ISecureSecClusGrpMemb rec =
			new SecureBuffSecClusGrpMemb();
		return( rec );
	}

	public SecureBuffSecClusGrpMemb ensureRec(ISecureSecClusGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecClusGrpMemb) {
			return ((SecureBuffSecClusGrpMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecClusGrpMemb.CLASS_CODE: {
					SecureBuffSecClusGrpMemb mapped = new SecureBuffSecClusGrpMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb");
			}
		}
	}

	@Override
	public ISecureSecClusGrpMembH newHRec() {
		ISecureSecClusGrpMembH hrec =
			new SecureBuffSecClusGrpMembH();
		return( hrec );
	}

	public SecureBuffSecClusGrpMembH ensureHRec(ISecureSecClusGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecClusGrpMembH) {
			return ((SecureBuffSecClusGrpMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecClusGrpMemb.CLASS_CODE: {
					SecureBuffSecClusGrpMembH mapped = new SecureBuffSecClusGrpMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb");
			}
		}
	}
}
