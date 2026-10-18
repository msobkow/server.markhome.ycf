
// Description: Java 25 Factory service implementation for SecUser buffers

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
 *	Java 25 Factory service implementation for SecUser buffers.
 */
@Service("secure31BuffSecUserFactoryService")
public class SecureBuffSecUserFactoryService
	implements ISecureSecUserFactory
{
	public SecureBuffSecUserFactoryService() {
	}

	@Override
	public ISecureSecUserHPKey newHPKey() {
		ISecureSecUserHPKey hpkey =
			new SecureBuffSecUserHPKey();
		return( hpkey );
	}

	public SecureBuffSecUserHPKey ensureHPKey(ISecureSecUserHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecUserHPKey) {
			return( (SecureBuffSecUserHPKey)key );
		}
		else {
			SecureBuffSecUserHPKey mapped = new SecureBuffSecUserHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserByULoginIdxKey newByULoginIdxKey() {
		ISecureSecUserByULoginIdxKey key =
			new SecureBuffSecUserByULoginIdxKey();
		return( key );
	}

	public SecureBuffSecUserByULoginIdxKey ensureByULoginIdxKey(ISecureSecUserByULoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserByULoginIdxKey) {
			return( (SecureBuffSecUserByULoginIdxKey)key );
		}
		else {
			SecureBuffSecUserByULoginIdxKey mapped = new SecureBuffSecUserByULoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserByEMAddrIdxKey newByEMAddrIdxKey() {
		ISecureSecUserByEMAddrIdxKey key =
			new SecureBuffSecUserByEMAddrIdxKey();
		return( key );
	}

	public SecureBuffSecUserByEMAddrIdxKey ensureByEMAddrIdxKey(ISecureSecUserByEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserByEMAddrIdxKey) {
			return( (SecureBuffSecUserByEMAddrIdxKey)key );
		}
		else {
			SecureBuffSecUserByEMAddrIdxKey mapped = new SecureBuffSecUserByEMAddrIdxKey();
			mapped.setRequiredEMailAddress( key.getRequiredEMailAddress() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUser newRec() {
		ISecureSecUser rec =
			new SecureBuffSecUser();
		return( rec );
	}

	public SecureBuffSecUser ensureRec(ISecureSecUser rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecUser) {
			return ((SecureBuffSecUser)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecUser.CLASS_CODE: {
					SecureBuffSecUser mapped = new SecureBuffSecUser();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUser",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUser");
			}
		}
	}

	@Override
	public ISecureSecUserH newHRec() {
		ISecureSecUserH hrec =
			new SecureBuffSecUserH();
		return( hrec );
	}

	public SecureBuffSecUserH ensureHRec(ISecureSecUserH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecUserH) {
			return ((SecureBuffSecUserH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecUser.CLASS_CODE: {
					SecureBuffSecUserH mapped = new SecureBuffSecUserH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUser",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUser");
			}
		}
	}
}
