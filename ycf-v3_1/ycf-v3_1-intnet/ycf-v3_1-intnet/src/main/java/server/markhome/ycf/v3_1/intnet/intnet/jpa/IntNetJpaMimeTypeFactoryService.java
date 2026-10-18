
// Description: Java 25 Factory service implementation for MimeType JPA objects

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;

/*
 *	Java 25 Factory service implementation for MimeType JPA objects.
 */
public class IntNetJpaMimeTypeFactoryService
    implements IIntNetMimeTypeFactory
{
    public IntNetJpaMimeTypeFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMimeTypeHPKey newHPKey() {
        IIntNetMimeTypeHPKey hpkey = new IntNetJpaMimeTypeHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMimeTypeHPKey ensureHPKey(IIntNetMimeTypeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaMimeTypeHPKey) {
			return( (IntNetJpaMimeTypeHPKey)key );
		}
		else {
			IntNetJpaMimeTypeHPKey mapped = new IntNetJpaMimeTypeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredMimeTypeId( key.getRequiredMimeTypeId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMimeTypeByUNameIdxKey newByUNameIdxKey() {
		IIntNetMimeTypeByUNameIdxKey key = new IntNetJpaMimeTypeByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMimeTypeByUNameIdxKey ensureByUNameIdxKey(IIntNetMimeTypeByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMimeTypeByUNameIdxKey) {
			return( (IntNetJpaMimeTypeByUNameIdxKey)key );
		}
		else {
			IntNetJpaMimeTypeByUNameIdxKey mapped = new IntNetJpaMimeTypeByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMimeType newRec() {
        IIntNetMimeType rec = new IntNetJpaMimeType();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMimeType ensureRec(IIntNetMimeType rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaMimeType) {
			return( (IntNetJpaMimeType)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetMimeType.CLASS_CODE: {
					IntNetJpaMimeType mapped = new IntNetJpaMimeType();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMimeType",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMimeType");
			}
		}
	}

    @Override
    public IIntNetMimeTypeH newHRec() {
        IIntNetMimeTypeH hrec = new IntNetJpaMimeTypeH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMimeTypeH ensureHRec(IIntNetMimeTypeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaMimeTypeH) {
			return( (IntNetJpaMimeTypeH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetMimeType.CLASS_CODE: {
					IntNetJpaMimeTypeH mapped = new IntNetJpaMimeTypeH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMimeType",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMimeType");
			}
		}
	}
}
