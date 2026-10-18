
// Description: Java 25 Factory service implementation for SecUserPWHistory buffers

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
 *	Java 25 Factory service implementation for SecUserPWHistory buffers.
 */
@Service("secure31BuffSecUserPWHistoryFactoryService")
public class SecureBuffSecUserPWHistoryFactoryService
	implements ISecureSecUserPWHistoryFactory
{
	public SecureBuffSecUserPWHistoryFactoryService() {
	}

    @Override
    public ISecureSecUserPWHistoryPKey newPKey() {
        ISecureSecUserPWHistoryPKey pkey =
            new SecureBuffSecUserPWHistoryPKey();
        return( pkey );
    }

	public SecureBuffSecUserPWHistoryPKey ensurePKey(ISecureSecUserPWHistoryPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWHistoryPKey) {
			return( (SecureBuffSecUserPWHistoryPKey)key );
		}
		else {
			SecureBuffSecUserPWHistoryPKey mapped = new SecureBuffSecUserPWHistoryPKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWHistoryHPKey newHPKey() {
		ISecureSecUserPWHistoryHPKey hpkey =
			new SecureBuffSecUserPWHistoryHPKey();
		return( hpkey );
	}

	public SecureBuffSecUserPWHistoryHPKey ensureHPKey(ISecureSecUserPWHistoryHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecUserPWHistoryHPKey) {
			return( (SecureBuffSecUserPWHistoryHPKey)key );
		}
		else {
			SecureBuffSecUserPWHistoryHPKey mapped = new SecureBuffSecUserPWHistoryHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWHistoryByUserIdxKey newByUserIdxKey() {
		ISecureSecUserPWHistoryByUserIdxKey key =
			new SecureBuffSecUserPWHistoryByUserIdxKey();
		return( key );
	}

	public SecureBuffSecUserPWHistoryByUserIdxKey ensureByUserIdxKey(ISecureSecUserPWHistoryByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWHistoryByUserIdxKey) {
			return( (SecureBuffSecUserPWHistoryByUserIdxKey)key );
		}
		else {
			SecureBuffSecUserPWHistoryByUserIdxKey mapped = new SecureBuffSecUserPWHistoryByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWHistoryBySetStampIdxKey newBySetStampIdxKey() {
		ISecureSecUserPWHistoryBySetStampIdxKey key =
			new SecureBuffSecUserPWHistoryBySetStampIdxKey();
		return( key );
	}

	public SecureBuffSecUserPWHistoryBySetStampIdxKey ensureBySetStampIdxKey(ISecureSecUserPWHistoryBySetStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWHistoryBySetStampIdxKey) {
			return( (SecureBuffSecUserPWHistoryBySetStampIdxKey)key );
		}
		else {
			SecureBuffSecUserPWHistoryBySetStampIdxKey mapped = new SecureBuffSecUserPWHistoryBySetStampIdxKey();
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWHistoryByReplacedStampIdxKey newByReplacedStampIdxKey() {
		ISecureSecUserPWHistoryByReplacedStampIdxKey key =
			new SecureBuffSecUserPWHistoryByReplacedStampIdxKey();
		return( key );
	}

	public SecureBuffSecUserPWHistoryByReplacedStampIdxKey ensureByReplacedStampIdxKey(ISecureSecUserPWHistoryByReplacedStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWHistoryByReplacedStampIdxKey) {
			return( (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)key );
		}
		else {
			SecureBuffSecUserPWHistoryByReplacedStampIdxKey mapped = new SecureBuffSecUserPWHistoryByReplacedStampIdxKey();
			mapped.setRequiredPWReplacedStamp( key.getRequiredPWReplacedStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWHistory newRec() {
		ISecureSecUserPWHistory rec =
			new SecureBuffSecUserPWHistory();
		return( rec );
	}

	public SecureBuffSecUserPWHistory ensureRec(ISecureSecUserPWHistory rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecUserPWHistory) {
			return ((SecureBuffSecUserPWHistory)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecUserPWHistory.CLASS_CODE: {
					SecureBuffSecUserPWHistory mapped = new SecureBuffSecUserPWHistory();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWHistory",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWHistory");
			}
		}
	}

	@Override
	public ISecureSecUserPWHistoryH newHRec() {
		ISecureSecUserPWHistoryH hrec =
			new SecureBuffSecUserPWHistoryH();
		return( hrec );
	}

	public SecureBuffSecUserPWHistoryH ensureHRec(ISecureSecUserPWHistoryH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecUserPWHistoryH) {
			return ((SecureBuffSecUserPWHistoryH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecUserPWHistory.CLASS_CODE: {
					SecureBuffSecUserPWHistoryH mapped = new SecureBuffSecUserPWHistoryH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWHistory",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWHistory");
			}
		}
	}
}
