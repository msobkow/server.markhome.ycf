
// Description: Java 25 Factory service implementation for SysCluster buffers

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
 *	Java 25 Factory service implementation for SysCluster buffers.
 */
@Service("secure31BuffSysClusterFactoryService")
public class SecureBuffSysClusterFactoryService
	implements ISecureSysClusterFactory
{
	public SecureBuffSysClusterFactoryService() {
	}

	@Override
	public ISecureSysClusterHPKey newHPKey() {
		ISecureSysClusterHPKey hpkey =
			new SecureBuffSysClusterHPKey();
		return( hpkey );
	}

	public SecureBuffSysClusterHPKey ensureHPKey(ISecureSysClusterHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSysClusterHPKey) {
			return( (SecureBuffSysClusterHPKey)key );
		}
		else {
			SecureBuffSysClusterHPKey mapped = new SecureBuffSysClusterHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSingletonId( key.getRequiredSingletonId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSysClusterByClusterIdxKey newByClusterIdxKey() {
		ISecureSysClusterByClusterIdxKey key =
			new SecureBuffSysClusterByClusterIdxKey();
		return( key );
	}

	public SecureBuffSysClusterByClusterIdxKey ensureByClusterIdxKey(ISecureSysClusterByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSysClusterByClusterIdxKey) {
			return( (SecureBuffSysClusterByClusterIdxKey)key );
		}
		else {
			SecureBuffSysClusterByClusterIdxKey mapped = new SecureBuffSysClusterByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSysCluster newRec() {
		ISecureSysCluster rec =
			new SecureBuffSysCluster();
		return( rec );
	}

	public SecureBuffSysCluster ensureRec(ISecureSysCluster rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSysCluster) {
			return ((SecureBuffSysCluster)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSysCluster.CLASS_CODE: {
					SecureBuffSysCluster mapped = new SecureBuffSysCluster();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSysCluster",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSysCluster");
			}
		}
	}

	@Override
	public ISecureSysClusterH newHRec() {
		ISecureSysClusterH hrec =
			new SecureBuffSysClusterH();
		return( hrec );
	}

	public SecureBuffSysClusterH ensureHRec(ISecureSysClusterH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSysClusterH) {
			return ((SecureBuffSysClusterH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSysCluster.CLASS_CODE: {
					SecureBuffSysClusterH mapped = new SecureBuffSysClusterH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSysCluster",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSysCluster");
			}
		}
	}
}
