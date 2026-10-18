// Description: Java 25 JPA implementation of a Secure schema.

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

package server.markhome.ycf.v3_1.secure.secure.jpa;
//package server.markhome.ycf.v3_1.secure.secure.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.net.InetAddress;
import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.SecureJpaHooksSchema;

import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;

public class SecureJpaSchema
	implements ISecureSchema
{
	private static SecureJpaHooksSchema secureJpaHooksSchema = null;

	protected static ISecureTablePerms tablePerms;
	protected ISecureClusterTable tableCluster;
	protected ISecureISOCcyTable tableISOCcy;
	protected ISecureISOCtryTable tableISOCtry;
	protected ISecureISOCtryCcyTable tableISOCtryCcy;
	protected ISecureISOCtryLangTable tableISOCtryLang;
	protected ISecureISOLangTable tableISOLang;
	protected ISecureISOTZoneTable tableISOTZone;
	protected ISecureSecClusGrpTable tableSecClusGrp;
	protected ISecureSecClusGrpMembTable tableSecClusGrpMemb;
	protected ISecureSecClusRoleTable tableSecClusRole;
	protected ISecureSecClusRoleMembTable tableSecClusRoleMemb;
	protected ISecureSecSessionTable tableSecSession;
	protected ISecureSecSysGrpTable tableSecSysGrp;
	protected ISecureSecSysGrpIncTable tableSecSysGrpInc;
	protected ISecureSecSysGrpMembTable tableSecSysGrpMemb;
	protected ISecureSecSysRoleTable tableSecSysRole;
	protected ISecureSecSysRoleEnablesTable tableSecSysRoleEnables;
	protected ISecureSecSysRoleMembTable tableSecSysRoleMemb;
	protected ISecureSecTentGrpTable tableSecTentGrp;
	protected ISecureSecTentGrpMembTable tableSecTentGrpMemb;
	protected ISecureSecTentRoleTable tableSecTentRole;
	protected ISecureSecTentRoleMembTable tableSecTentRoleMemb;
	protected ISecureSecUserTable tableSecUser;
	protected ISecureSecUserEMConfTable tableSecUserEMConf;
	protected ISecureSecUserPWHistoryTable tableSecUserPWHistory;
	protected ISecureSecUserPWResetTable tableSecUserPWReset;
	protected ISecureSecUserPasswordTable tableSecUserPassword;
	protected ISecureSysClusterTable tableSysCluster;
	protected ISecureTableInfoTable tableTableInfo;
	protected ISecureTenantTable tableTenant;


	@Override
	public int initClassMapEntries(int value) {
		return( ISecureSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ISecureSchema.ClassMapEntry entry;
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureCluster ret = new SecureJpaCluster();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureCluster.CLASS_CODE)[" + ISecureCluster.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureTenant.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureTenant ret = new SecureJpaTenant();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureTenant.CLASS_CODE)[" + ISecureTenant.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureTableInfo.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureTableInfo ret = new SecureJpaTableInfo();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureTableInfo.CLASS_CODE)[" + ISecureTableInfo.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCcy ret = new SecureJpaISOCcy();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCcy.CLASS_CODE)[" + ISecureISOCcy.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtry.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtry ret = new SecureJpaISOCtry();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtry.CLASS_CODE)[" + ISecureISOCtry.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtryCcy ret = new SecureJpaISOCtryCcy();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryCcy.CLASS_CODE)[" + ISecureISOCtryCcy.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtryLang ret = new SecureJpaISOCtryLang();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryLang.CLASS_CODE)[" + ISecureISOCtryLang.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOLang ret = new SecureJpaISOLang();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOLang.CLASS_CODE)[" + ISecureISOLang.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOTZone.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOTZone ret = new SecureJpaISOTZone();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOTZone.CLASS_CODE)[" + ISecureISOTZone.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUser.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUser ret = new SecureJpaSecUser();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUser.CLASS_CODE)[" + ISecureSecUser.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPassword.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPassword ret = new SecureJpaSecUserPassword();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPassword.CLASS_CODE)[" + ISecureSecUserPassword.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserEMConf.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserEMConf ret = new SecureJpaSecUserEMConf();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserEMConf.CLASS_CODE)[" + ISecureSecUserEMConf.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWReset.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPWReset ret = new SecureJpaSecUserPWReset();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWReset.CLASS_CODE)[" + ISecureSecUserPWReset.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWHistory.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPWHistory ret = new SecureJpaSecUserPWHistory();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWHistory.CLASS_CODE)[" + ISecureSecUserPWHistory.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrp ret = new SecureJpaSecSysGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrp.CLASS_CODE)[" + ISecureSecSysGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrpInc ret = new SecureJpaSecSysGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpInc.CLASS_CODE)[" + ISecureSecSysGrpInc.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrpMemb ret = new SecureJpaSecSysGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpMemb.CLASS_CODE)[" + ISecureSecSysGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusGrp ret = new SecureJpaSecClusGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrp.CLASS_CODE)[" + ISecureSecClusGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusGrpMemb ret = new SecureJpaSecClusGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrpMemb.CLASS_CODE)[" + ISecureSecClusGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentGrp ret = new SecureJpaSecTentGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrp.CLASS_CODE)[" + ISecureSecTentGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentGrpMemb ret = new SecureJpaSecTentGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrpMemb.CLASS_CODE)[" + ISecureSecTentGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRole ret = new SecureJpaSecSysRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRole.CLASS_CODE)[" + ISecureSecSysRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleEnables.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRoleEnables ret = new SecureJpaSecSysRoleEnables();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleEnables.CLASS_CODE)[" + ISecureSecSysRoleEnables.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRoleMemb ret = new SecureJpaSecSysRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleMemb.CLASS_CODE)[" + ISecureSecSysRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusRole ret = new SecureJpaSecClusRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRole.CLASS_CODE)[" + ISecureSecClusRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusRoleMemb ret = new SecureJpaSecClusRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRoleMemb.CLASS_CODE)[" + ISecureSecClusRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentRole ret = new SecureJpaSecTentRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRole.CLASS_CODE)[" + ISecureSecTentRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentRoleMemb ret = new SecureJpaSecTentRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRoleMemb.CLASS_CODE)[" + ISecureSecTentRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSession.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSession ret = new SecureJpaSecSession();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSession.CLASS_CODE)[" + ISecureSecSession.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSysCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSysCluster ret = new SecureJpaSysCluster();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureJpaSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSysCluster.CLASS_CODE)[" + ISecureSysCluster.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		if (tableCluster == null || !(tableCluster instanceof SecureJpaClusterTable)) {
			tableCluster = new SecureJpaClusterTable(this);
		}
		if (tableTenant == null || !(tableTenant instanceof SecureJpaTenantTable)) {
			tableTenant = new SecureJpaTenantTable(this);
		}
		if (tableTableInfo == null || !(tableTableInfo instanceof SecureJpaTableInfoTable)) {
			tableTableInfo = new SecureJpaTableInfoTable(this);
		}
		if (tableISOCcy == null || !(tableISOCcy instanceof SecureJpaISOCcyTable)) {
			tableISOCcy = new SecureJpaISOCcyTable(this);
		}
		if (tableISOCtry == null || !(tableISOCtry instanceof SecureJpaISOCtryTable)) {
			tableISOCtry = new SecureJpaISOCtryTable(this);
		}
		if (tableISOCtryCcy == null || !(tableISOCtryCcy instanceof SecureJpaISOCtryCcyTable)) {
			tableISOCtryCcy = new SecureJpaISOCtryCcyTable(this);
		}
		if (tableISOCtryLang == null || !(tableISOCtryLang instanceof SecureJpaISOCtryLangTable)) {
			tableISOCtryLang = new SecureJpaISOCtryLangTable(this);
		}
		if (tableISOLang == null || !(tableISOLang instanceof SecureJpaISOLangTable)) {
			tableISOLang = new SecureJpaISOLangTable(this);
		}
		if (tableISOTZone == null || !(tableISOTZone instanceof SecureJpaISOTZoneTable)) {
			tableISOTZone = new SecureJpaISOTZoneTable(this);
		}
		if (tableSecUser == null || !(tableSecUser instanceof SecureJpaSecUserTable)) {
			tableSecUser = new SecureJpaSecUserTable(this);
		}
		if (tableSecUserPassword == null || !(tableSecUserPassword instanceof SecureJpaSecUserPasswordTable)) {
			tableSecUserPassword = new SecureJpaSecUserPasswordTable(this);
		}
		if (tableSecUserEMConf == null || !(tableSecUserEMConf instanceof SecureJpaSecUserEMConfTable)) {
			tableSecUserEMConf = new SecureJpaSecUserEMConfTable(this);
		}
		if (tableSecUserPWReset == null || !(tableSecUserPWReset instanceof SecureJpaSecUserPWResetTable)) {
			tableSecUserPWReset = new SecureJpaSecUserPWResetTable(this);
		}
		if (tableSecUserPWHistory == null || !(tableSecUserPWHistory instanceof SecureJpaSecUserPWHistoryTable)) {
			tableSecUserPWHistory = new SecureJpaSecUserPWHistoryTable(this);
		}
		if (tableSecSysGrp == null || !(tableSecSysGrp instanceof SecureJpaSecSysGrpTable)) {
			tableSecSysGrp = new SecureJpaSecSysGrpTable(this);
		}
		if (tableSecSysGrpInc == null || !(tableSecSysGrpInc instanceof SecureJpaSecSysGrpIncTable)) {
			tableSecSysGrpInc = new SecureJpaSecSysGrpIncTable(this);
		}
		if (tableSecSysGrpMemb == null || !(tableSecSysGrpMemb instanceof SecureJpaSecSysGrpMembTable)) {
			tableSecSysGrpMemb = new SecureJpaSecSysGrpMembTable(this);
		}
		if (tableSecClusGrp == null || !(tableSecClusGrp instanceof SecureJpaSecClusGrpTable)) {
			tableSecClusGrp = new SecureJpaSecClusGrpTable(this);
		}
		if (tableSecClusGrpMemb == null || !(tableSecClusGrpMemb instanceof SecureJpaSecClusGrpMembTable)) {
			tableSecClusGrpMemb = new SecureJpaSecClusGrpMembTable(this);
		}
		if (tableSecTentGrp == null || !(tableSecTentGrp instanceof SecureJpaSecTentGrpTable)) {
			tableSecTentGrp = new SecureJpaSecTentGrpTable(this);
		}
		if (tableSecTentGrpMemb == null || !(tableSecTentGrpMemb instanceof SecureJpaSecTentGrpMembTable)) {
			tableSecTentGrpMemb = new SecureJpaSecTentGrpMembTable(this);
		}
		if (tableSecSysRole == null || !(tableSecSysRole instanceof SecureJpaSecSysRoleTable)) {
			tableSecSysRole = new SecureJpaSecSysRoleTable(this);
		}
		if (tableSecSysRoleEnables == null || !(tableSecSysRoleEnables instanceof SecureJpaSecSysRoleEnablesTable)) {
			tableSecSysRoleEnables = new SecureJpaSecSysRoleEnablesTable(this);
		}
		if (tableSecSysRoleMemb == null || !(tableSecSysRoleMemb instanceof SecureJpaSecSysRoleMembTable)) {
			tableSecSysRoleMemb = new SecureJpaSecSysRoleMembTable(this);
		}
		if (tableSecClusRole == null || !(tableSecClusRole instanceof SecureJpaSecClusRoleTable)) {
			tableSecClusRole = new SecureJpaSecClusRoleTable(this);
		}
		if (tableSecClusRoleMemb == null || !(tableSecClusRoleMemb instanceof SecureJpaSecClusRoleMembTable)) {
			tableSecClusRoleMemb = new SecureJpaSecClusRoleMembTable(this);
		}
		if (tableSecTentRole == null || !(tableSecTentRole instanceof SecureJpaSecTentRoleTable)) {
			tableSecTentRole = new SecureJpaSecTentRoleTable(this);
		}
		if (tableSecTentRoleMemb == null || !(tableSecTentRoleMemb instanceof SecureJpaSecTentRoleMembTable)) {
			tableSecTentRoleMemb = new SecureJpaSecTentRoleMembTable(this);
		}
		if (tableSecSession == null || !(tableSecSession instanceof SecureJpaSecSessionTable)) {
			tableSecSession = new SecureJpaSecSessionTable(this);
		}
		if (tableSysCluster == null || !(tableSysCluster instanceof SecureJpaSysClusterTable)) {
			tableSysCluster = new SecureJpaSysClusterTable(this);
		}
	}

	@Override		
	public ISecureSchema getSecureSchema() {
		return( ISecureSchema.getBackingSecure() );
	}

	@Override
	public void setSecureSchema(ISecureSchema schema) {
		ISecureSchema.setBackingSecure(schema);
		schema.wireRecConstructors();
	}

	public static SecureJpaHooksSchema getJpaHooksSchema() {
		return( secureJpaHooksSchema );
	}

	public static void setJpaHooksSchema(SecureJpaHooksSchema jpaHooksSchema) {
		secureJpaHooksSchema = jpaHooksSchema;
	}

	@Override
	public ISecureFactory getSecureFactory() {
		return(SecureJpaSchema.getJpaHooksSchema().getFactoryService());
	}

	@Override
	public SecureBuffFactoryService getSecureBuffFactory() {
		return((SecureBuffFactoryService)(SecureBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public SecureJpaSchemaService getSchemaService() {
		return( SecureJpaSchema.getJpaHooksSchema().getSchemaService() );
	}

	public SecureJpaSchema() {

		tableCluster = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableSecClusGrp = null;
		tableSecClusGrpMemb = null;
		tableSecClusRole = null;
		tableSecClusRoleMemb = null;
		tableSecSession = null;
		tableSecSysGrp = null;
		tableSecSysGrpInc = null;
		tableSecSysGrpMemb = null;
		tableSecSysRole = null;
		tableSecSysRoleEnables = null;
		tableSecSysRoleMemb = null;
		tableSecTentGrp = null;
		tableSecTentGrpMemb = null;
		tableSecTentRole = null;
		tableSecTentRoleMemb = null;
		tableSecUser = null;
		tableSecUserEMConf = null;
		tableSecUserPWHistory = null;
		tableSecUserPWReset = null;
		tableSecUserPassword = null;
		tableSysCluster = null;
		tableTableInfo = null;
		tableTenant = null;
	}

	@Override
	public ISecureSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	@Override
	public short nextISOCcyIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCcyIdGen" );
	}

	@Override
	public short nextISOCtryIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCtryIdGen" );
	}

	@Override
	public short nextISOLangIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOLangIdGen" );
	}

	@Override
	public short nextISOTZoneIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOTZoneIdGen" );
	}

	@Override
	public int nextTableInfoIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextTableInfoIdGen" );
	}

	@Override
	public YCFDbKeyHash256 nextClusterIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecUserIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTenantIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	public ISecureClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ISecureClusterTable value ) {
		tableCluster = value;
	}

	public ISecureISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ISecureISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ISecureISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ISecureISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ISecureISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ISecureISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ISecureISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ISecureISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ISecureISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ISecureISOLangTable value ) {
		tableISOLang = value;
	}

	public ISecureISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ISecureISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public ISecureSecClusGrpTable getTableSecClusGrp() {
		return( tableSecClusGrp );
	}

	public void setTableSecClusGrp( ISecureSecClusGrpTable value ) {
		tableSecClusGrp = value;
	}

	public ISecureSecClusGrpMembTable getTableSecClusGrpMemb() {
		return( tableSecClusGrpMemb );
	}

	public void setTableSecClusGrpMemb( ISecureSecClusGrpMembTable value ) {
		tableSecClusGrpMemb = value;
	}

	public ISecureSecClusRoleTable getTableSecClusRole() {
		return( tableSecClusRole );
	}

	public void setTableSecClusRole( ISecureSecClusRoleTable value ) {
		tableSecClusRole = value;
	}

	public ISecureSecClusRoleMembTable getTableSecClusRoleMemb() {
		return( tableSecClusRoleMemb );
	}

	public void setTableSecClusRoleMemb( ISecureSecClusRoleMembTable value ) {
		tableSecClusRoleMemb = value;
	}

	public ISecureSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ISecureSecSessionTable value ) {
		tableSecSession = value;
	}

	public ISecureSecSysGrpTable getTableSecSysGrp() {
		return( tableSecSysGrp );
	}

	public void setTableSecSysGrp( ISecureSecSysGrpTable value ) {
		tableSecSysGrp = value;
	}

	public ISecureSecSysGrpIncTable getTableSecSysGrpInc() {
		return( tableSecSysGrpInc );
	}

	public void setTableSecSysGrpInc( ISecureSecSysGrpIncTable value ) {
		tableSecSysGrpInc = value;
	}

	public ISecureSecSysGrpMembTable getTableSecSysGrpMemb() {
		return( tableSecSysGrpMemb );
	}

	public void setTableSecSysGrpMemb( ISecureSecSysGrpMembTable value ) {
		tableSecSysGrpMemb = value;
	}

	public ISecureSecSysRoleTable getTableSecSysRole() {
		return( tableSecSysRole );
	}

	public void setTableSecSysRole( ISecureSecSysRoleTable value ) {
		tableSecSysRole = value;
	}

	public ISecureSecSysRoleEnablesTable getTableSecSysRoleEnables() {
		return( tableSecSysRoleEnables );
	}

	public void setTableSecSysRoleEnables( ISecureSecSysRoleEnablesTable value ) {
		tableSecSysRoleEnables = value;
	}

	public ISecureSecSysRoleMembTable getTableSecSysRoleMemb() {
		return( tableSecSysRoleMemb );
	}

	public void setTableSecSysRoleMemb( ISecureSecSysRoleMembTable value ) {
		tableSecSysRoleMemb = value;
	}

	public ISecureSecTentGrpTable getTableSecTentGrp() {
		return( tableSecTentGrp );
	}

	public void setTableSecTentGrp( ISecureSecTentGrpTable value ) {
		tableSecTentGrp = value;
	}

	public ISecureSecTentGrpMembTable getTableSecTentGrpMemb() {
		return( tableSecTentGrpMemb );
	}

	public void setTableSecTentGrpMemb( ISecureSecTentGrpMembTable value ) {
		tableSecTentGrpMemb = value;
	}

	public ISecureSecTentRoleTable getTableSecTentRole() {
		return( tableSecTentRole );
	}

	public void setTableSecTentRole( ISecureSecTentRoleTable value ) {
		tableSecTentRole = value;
	}

	public ISecureSecTentRoleMembTable getTableSecTentRoleMemb() {
		return( tableSecTentRoleMemb );
	}

	public void setTableSecTentRoleMemb( ISecureSecTentRoleMembTable value ) {
		tableSecTentRoleMemb = value;
	}

	public ISecureSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ISecureSecUserTable value ) {
		tableSecUser = value;
	}

	public ISecureSecUserEMConfTable getTableSecUserEMConf() {
		return( tableSecUserEMConf );
	}

	public void setTableSecUserEMConf( ISecureSecUserEMConfTable value ) {
		tableSecUserEMConf = value;
	}

	public ISecureSecUserPWHistoryTable getTableSecUserPWHistory() {
		return( tableSecUserPWHistory );
	}

	public void setTableSecUserPWHistory( ISecureSecUserPWHistoryTable value ) {
		tableSecUserPWHistory = value;
	}

	public ISecureSecUserPWResetTable getTableSecUserPWReset() {
		return( tableSecUserPWReset );
	}

	public void setTableSecUserPWReset( ISecureSecUserPWResetTable value ) {
		tableSecUserPWReset = value;
	}

	public ISecureSecUserPasswordTable getTableSecUserPassword() {
		return( tableSecUserPassword );
	}

	public void setTableSecUserPassword( ISecureSecUserPasswordTable value ) {
		tableSecUserPassword = value;
	}

	public ISecureSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ISecureSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ISecureTableInfoTable getTableTableInfo() {
		return( tableTableInfo );
	}

	public void setTableTableInfo( ISecureTableInfoTable value ) {
		tableTableInfo = value;
	}

	public ISecureTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ISecureTenantTable value ) {
		tableTenant = value;
	}

	public void bootstrapSchema(SecurePubTableData tableData[]) {
		getSchemaService().bootstrapSchema(tableData);
	}

	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		getSchemaService().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}
}
