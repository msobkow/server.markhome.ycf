
// Description: Java 25 Factory service implementation for SecSession buffers

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
 *	Java 25 Factory service implementation for SecSession buffers.
 */
@Service("secure31BuffSecSessionFactoryService")
public class SecureBuffSecSessionFactoryService
	implements ISecureSecSessionFactory
{
	public SecureBuffSecSessionFactoryService() {
	}

	@Override
	public ISecureSecSessionHPKey newHPKey() {
		ISecureSecSessionHPKey hpkey =
			new SecureBuffSecSessionHPKey();
		return( hpkey );
	}

	public SecureBuffSecSessionHPKey ensureHPKey(ISecureSecSessionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSessionHPKey) {
			return( (SecureBuffSecSessionHPKey)key );
		}
		else {
			SecureBuffSecSessionHPKey mapped = new SecureBuffSecSessionHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSessionId( key.getRequiredSecSessionId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSessionBySecUserIdxKey newBySecUserIdxKey() {
		ISecureSecSessionBySecUserIdxKey key =
			new SecureBuffSecSessionBySecUserIdxKey();
		return( key );
	}

	public SecureBuffSecSessionBySecUserIdxKey ensureBySecUserIdxKey(ISecureSecSessionBySecUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSessionBySecUserIdxKey) {
			return( (SecureBuffSecSessionBySecUserIdxKey)key );
		}
		else {
			SecureBuffSecSessionBySecUserIdxKey mapped = new SecureBuffSecSessionBySecUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSessionByStartIdxKey newByStartIdxKey() {
		ISecureSecSessionByStartIdxKey key =
			new SecureBuffSecSessionByStartIdxKey();
		return( key );
	}

	public SecureBuffSecSessionByStartIdxKey ensureByStartIdxKey(ISecureSecSessionByStartIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSessionByStartIdxKey) {
			return( (SecureBuffSecSessionByStartIdxKey)key );
		}
		else {
			SecureBuffSecSessionByStartIdxKey mapped = new SecureBuffSecSessionByStartIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredStart( key.getRequiredStart() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSessionByFinishIdxKey newByFinishIdxKey() {
		ISecureSecSessionByFinishIdxKey key =
			new SecureBuffSecSessionByFinishIdxKey();
		return( key );
	}

	public SecureBuffSecSessionByFinishIdxKey ensureByFinishIdxKey(ISecureSecSessionByFinishIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSessionByFinishIdxKey) {
			return( (SecureBuffSecSessionByFinishIdxKey)key );
		}
		else {
			SecureBuffSecSessionByFinishIdxKey mapped = new SecureBuffSecSessionByFinishIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setOptionalFinish( key.getOptionalFinish() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSessionBySecProxyIdxKey newBySecProxyIdxKey() {
		ISecureSecSessionBySecProxyIdxKey key =
			new SecureBuffSecSessionBySecProxyIdxKey();
		return( key );
	}

	public SecureBuffSecSessionBySecProxyIdxKey ensureBySecProxyIdxKey(ISecureSecSessionBySecProxyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSessionBySecProxyIdxKey) {
			return( (SecureBuffSecSessionBySecProxyIdxKey)key );
		}
		else {
			SecureBuffSecSessionBySecProxyIdxKey mapped = new SecureBuffSecSessionBySecProxyIdxKey();
			mapped.setOptionalSecProxyId( key.getOptionalSecProxyId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSession newRec() {
		ISecureSecSession rec =
			new SecureBuffSecSession();
		return( rec );
	}

	public SecureBuffSecSession ensureRec(ISecureSecSession rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSession) {
			return ((SecureBuffSecSession)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSession.CLASS_CODE: {
					SecureBuffSecSession mapped = new SecureBuffSecSession();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSession",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSession");
			}
		}
	}

	@Override
	public ISecureSecSessionH newHRec() {
		ISecureSecSessionH hrec =
			new SecureBuffSecSessionH();
		return( hrec );
	}

	public SecureBuffSecSessionH ensureHRec(ISecureSecSessionH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSessionH) {
			return ((SecureBuffSecSessionH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSession.CLASS_CODE: {
					SecureBuffSecSessionH mapped = new SecureBuffSecSessionH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSession",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSession");
			}
		}
	}
}
