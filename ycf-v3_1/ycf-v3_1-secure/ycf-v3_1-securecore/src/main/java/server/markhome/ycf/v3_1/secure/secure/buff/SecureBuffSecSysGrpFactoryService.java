
// Description: Java 25 Factory service implementation for SecSysGrp buffers

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
 *	Java 25 Factory service implementation for SecSysGrp buffers.
 */
@Service("secure31BuffSecSysGrpFactoryService")
public class SecureBuffSecSysGrpFactoryService
	implements ISecureSecSysGrpFactory
{
	public SecureBuffSecSysGrpFactoryService() {
	}

	@Override
	public ISecureSecSysGrpHPKey newHPKey() {
		ISecureSecSysGrpHPKey hpkey =
			new SecureBuffSecSysGrpHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysGrpHPKey ensureHPKey(ISecureSecSysGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysGrpHPKey) {
			return( (SecureBuffSecSysGrpHPKey)key );
		}
		else {
			SecureBuffSecSysGrpHPKey mapped = new SecureBuffSecSysGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecSysGrpByUNameIdxKey key =
			new SecureBuffSecSysGrpByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecSysGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpByUNameIdxKey) {
			return( (SecureBuffSecSysGrpByUNameIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpByUNameIdxKey mapped = new SecureBuffSecSysGrpByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrpBySecLevelIdxKey newBySecLevelIdxKey() {
		ISecureSecSysGrpBySecLevelIdxKey key =
			new SecureBuffSecSysGrpBySecLevelIdxKey();
		return( key );
	}

	public SecureBuffSecSysGrpBySecLevelIdxKey ensureBySecLevelIdxKey(ISecureSecSysGrpBySecLevelIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysGrpBySecLevelIdxKey) {
			return( (SecureBuffSecSysGrpBySecLevelIdxKey)key );
		}
		else {
			SecureBuffSecSysGrpBySecLevelIdxKey mapped = new SecureBuffSecSysGrpBySecLevelIdxKey();
			mapped.setRequiredSecLevel( key.getRequiredSecLevel() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysGrp newRec() {
		ISecureSecSysGrp rec =
			new SecureBuffSecSysGrp();
		return( rec );
	}

	public SecureBuffSecSysGrp ensureRec(ISecureSecSysGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysGrp) {
			return ((SecureBuffSecSysGrp)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysGrp.CLASS_CODE: {
					SecureBuffSecSysGrp mapped = new SecureBuffSecSysGrp();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrp");
			}
		}
	}

	@Override
	public ISecureSecSysGrpH newHRec() {
		ISecureSecSysGrpH hrec =
			new SecureBuffSecSysGrpH();
		return( hrec );
	}

	public SecureBuffSecSysGrpH ensureHRec(ISecureSecSysGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysGrpH) {
			return ((SecureBuffSecSysGrpH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysGrp.CLASS_CODE: {
					SecureBuffSecSysGrpH mapped = new SecureBuffSecSysGrpH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrp");
			}
		}
	}
}
