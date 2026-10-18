
// Description: Java 25 Factory service implementation for Cluster buffers

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
 *	Java 25 Factory service implementation for Cluster buffers.
 */
@Service("secure31BuffClusterFactoryService")
public class SecureBuffClusterFactoryService
	implements ISecureClusterFactory
{
	public SecureBuffClusterFactoryService() {
	}

	@Override
	public ISecureClusterHPKey newHPKey() {
		ISecureClusterHPKey hpkey =
			new SecureBuffClusterHPKey();
		return( hpkey );
	}

	public SecureBuffClusterHPKey ensureHPKey(ISecureClusterHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffClusterHPKey) {
			return( (SecureBuffClusterHPKey)key );
		}
		else {
			SecureBuffClusterHPKey mapped = new SecureBuffClusterHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ISecureClusterByUDomNameIdxKey newByUDomNameIdxKey() {
		ISecureClusterByUDomNameIdxKey key =
			new SecureBuffClusterByUDomNameIdxKey();
		return( key );
	}

	public SecureBuffClusterByUDomNameIdxKey ensureByUDomNameIdxKey(ISecureClusterByUDomNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffClusterByUDomNameIdxKey) {
			return( (SecureBuffClusterByUDomNameIdxKey)key );
		}
		else {
			SecureBuffClusterByUDomNameIdxKey mapped = new SecureBuffClusterByUDomNameIdxKey();
			mapped.setRequiredFullDomName( key.getRequiredFullDomName() );
			return( mapped );
		}
	}

	@Override
	public ISecureClusterByUDescrIdxKey newByUDescrIdxKey() {
		ISecureClusterByUDescrIdxKey key =
			new SecureBuffClusterByUDescrIdxKey();
		return( key );
	}

	public SecureBuffClusterByUDescrIdxKey ensureByUDescrIdxKey(ISecureClusterByUDescrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffClusterByUDescrIdxKey) {
			return( (SecureBuffClusterByUDescrIdxKey)key );
		}
		else {
			SecureBuffClusterByUDescrIdxKey mapped = new SecureBuffClusterByUDescrIdxKey();
			mapped.setRequiredDescription( key.getRequiredDescription() );
			return( mapped );
		}
	}

	@Override
	public ISecureCluster newRec() {
		ISecureCluster rec =
			new SecureBuffCluster();
		return( rec );
	}

	public SecureBuffCluster ensureRec(ISecureCluster rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffCluster) {
			return ((SecureBuffCluster)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureCluster.CLASS_CODE: {
					SecureBuffCluster mapped = new SecureBuffCluster();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureCluster",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureCluster");
			}
		}
	}

	@Override
	public ISecureClusterH newHRec() {
		ISecureClusterH hrec =
			new SecureBuffClusterH();
		return( hrec );
	}

	public SecureBuffClusterH ensureHRec(ISecureClusterH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffClusterH) {
			return ((SecureBuffClusterH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureCluster.CLASS_CODE: {
					SecureBuffClusterH mapped = new SecureBuffClusterH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureCluster",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureCluster");
			}
		}
	}
}
