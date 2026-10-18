
// Description: Java 25 Factory service implementation for SecClusGrp buffers

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
 *	Java 25 Factory service implementation for SecClusGrp buffers.
 */
@Service("secure31BuffSecClusGrpFactoryService")
public class SecureBuffSecClusGrpFactoryService
	implements ISecureSecClusGrpFactory
{
	public SecureBuffSecClusGrpFactoryService() {
	}

	@Override
	public ISecureSecClusGrpHPKey newHPKey() {
		ISecureSecClusGrpHPKey hpkey =
			new SecureBuffSecClusGrpHPKey();
		return( hpkey );
	}

	public SecureBuffSecClusGrpHPKey ensureHPKey(ISecureSecClusGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecClusGrpHPKey) {
			return( (SecureBuffSecClusGrpHPKey)key );
		}
		else {
			SecureBuffSecClusGrpHPKey mapped = new SecureBuffSecClusGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpByClusterIdxKey newByClusterIdxKey() {
		ISecureSecClusGrpByClusterIdxKey key =
			new SecureBuffSecClusGrpByClusterIdxKey();
		return( key );
	}

	public SecureBuffSecClusGrpByClusterIdxKey ensureByClusterIdxKey(ISecureSecClusGrpByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpByClusterIdxKey) {
			return( (SecureBuffSecClusGrpByClusterIdxKey)key );
		}
		else {
			SecureBuffSecClusGrpByClusterIdxKey mapped = new SecureBuffSecClusGrpByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpByNameIdxKey newByNameIdxKey() {
		ISecureSecClusGrpByNameIdxKey key =
			new SecureBuffSecClusGrpByNameIdxKey();
		return( key );
	}

	public SecureBuffSecClusGrpByNameIdxKey ensureByNameIdxKey(ISecureSecClusGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpByNameIdxKey) {
			return( (SecureBuffSecClusGrpByNameIdxKey)key );
		}
		else {
			SecureBuffSecClusGrpByNameIdxKey mapped = new SecureBuffSecClusGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecClusGrpByUNameIdxKey key =
			new SecureBuffSecClusGrpByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecClusGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecClusGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusGrpByUNameIdxKey) {
			return( (SecureBuffSecClusGrpByUNameIdxKey)key );
		}
		else {
			SecureBuffSecClusGrpByUNameIdxKey mapped = new SecureBuffSecClusGrpByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusGrp newRec() {
		ISecureSecClusGrp rec =
			new SecureBuffSecClusGrp();
		return( rec );
	}

	public SecureBuffSecClusGrp ensureRec(ISecureSecClusGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecClusGrp) {
			return ((SecureBuffSecClusGrp)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecClusGrp.CLASS_CODE: {
					SecureBuffSecClusGrp mapped = new SecureBuffSecClusGrp();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrp");
			}
		}
	}

	@Override
	public ISecureSecClusGrpH newHRec() {
		ISecureSecClusGrpH hrec =
			new SecureBuffSecClusGrpH();
		return( hrec );
	}

	public SecureBuffSecClusGrpH ensureHRec(ISecureSecClusGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecClusGrpH) {
			return ((SecureBuffSecClusGrpH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecClusGrp.CLASS_CODE: {
					SecureBuffSecClusGrpH mapped = new SecureBuffSecClusGrpH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrp");
			}
		}
	}
}
