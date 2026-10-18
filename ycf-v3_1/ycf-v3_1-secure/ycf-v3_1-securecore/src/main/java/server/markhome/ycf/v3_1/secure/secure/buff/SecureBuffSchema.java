// Description: Java 25 buffer implementation of a Secure schema.

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
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffHooksSchema;

public class SecureBuffSchema
	implements ISecureSchema
{
	private static SecureBuffHooksSchema secureBuffHooksSchema = null;

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
					ISecureCluster ret = new SecureBuffCluster();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureCluster.CLASS_CODE)[" + ISecureCluster.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureTenant.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureTenant ret = new SecureBuffTenant();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureTenant.CLASS_CODE)[" + ISecureTenant.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureTableInfo.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureTableInfo ret = new SecureBuffTableInfo();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureTableInfo.CLASS_CODE)[" + ISecureTableInfo.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCcy ret = new SecureBuffISOCcy();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCcy.CLASS_CODE)[" + ISecureISOCcy.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtry.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtry ret = new SecureBuffISOCtry();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtry.CLASS_CODE)[" + ISecureISOCtry.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtryCcy ret = new SecureBuffISOCtryCcy();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryCcy.CLASS_CODE)[" + ISecureISOCtryCcy.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOCtryLang ret = new SecureBuffISOCtryLang();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOCtryLang.CLASS_CODE)[" + ISecureISOCtryLang.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOLang ret = new SecureBuffISOLang();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOLang.CLASS_CODE)[" + ISecureISOLang.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureISOTZone.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureISOTZone ret = new SecureBuffISOTZone();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureISOTZone.CLASS_CODE)[" + ISecureISOTZone.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUser.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUser ret = new SecureBuffSecUser();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUser.CLASS_CODE)[" + ISecureSecUser.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPassword.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPassword ret = new SecureBuffSecUserPassword();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPassword.CLASS_CODE)[" + ISecureSecUserPassword.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserEMConf.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserEMConf ret = new SecureBuffSecUserEMConf();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserEMConf.CLASS_CODE)[" + ISecureSecUserEMConf.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWReset.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPWReset ret = new SecureBuffSecUserPWReset();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWReset.CLASS_CODE)[" + ISecureSecUserPWReset.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWHistory.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecUserPWHistory ret = new SecureBuffSecUserPWHistory();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecUserPWHistory.CLASS_CODE)[" + ISecureSecUserPWHistory.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrp ret = new SecureBuffSecSysGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrp.CLASS_CODE)[" + ISecureSecSysGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrpInc ret = new SecureBuffSecSysGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpInc.CLASS_CODE)[" + ISecureSecSysGrpInc.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysGrpMemb ret = new SecureBuffSecSysGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysGrpMemb.CLASS_CODE)[" + ISecureSecSysGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusGrp ret = new SecureBuffSecClusGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrp.CLASS_CODE)[" + ISecureSecClusGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusGrpMemb ret = new SecureBuffSecClusGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusGrpMemb.CLASS_CODE)[" + ISecureSecClusGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentGrp ret = new SecureBuffSecTentGrp();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrp.CLASS_CODE)[" + ISecureSecTentGrp.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentGrpMemb ret = new SecureBuffSecTentGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentGrpMemb.CLASS_CODE)[" + ISecureSecTentGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRole ret = new SecureBuffSecSysRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRole.CLASS_CODE)[" + ISecureSecSysRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleEnables.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRoleEnables ret = new SecureBuffSecSysRoleEnables();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleEnables.CLASS_CODE)[" + ISecureSecSysRoleEnables.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSysRoleMemb ret = new SecureBuffSecSysRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSysRoleMemb.CLASS_CODE)[" + ISecureSecSysRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusRole ret = new SecureBuffSecClusRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRole.CLASS_CODE)[" + ISecureSecClusRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecClusRoleMemb ret = new SecureBuffSecClusRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecClusRoleMemb.CLASS_CODE)[" + ISecureSecClusRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentRole ret = new SecureBuffSecTentRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRole.CLASS_CODE)[" + ISecureSecTentRole.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecTentRoleMemb ret = new SecureBuffSecTentRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecTentRoleMemb.CLASS_CODE)[" + ISecureSecTentRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSecSession.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSecSession ret = new SecureBuffSecSession();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSecSession.CLASS_CODE)[" + ISecureSecSession.CLASS_CODE + "]");
		}
	
		entry = ISecureSchema.getClassMapByBackingClassCode(ISecureSysCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ISecureSysCluster ret = new SecureBuffSysCluster();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(SecureBuffSchema.class, "wireRecConstructors", 0, "ISecureSchema.getClassMapByBackingClassCode(ISecureSysCluster.CLASS_CODE)[" + ISecureSysCluster.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new YCFMustOverrideException(getClass(), "wireTableTableInstances");
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

	public static SecureBuffHooksSchema getBuffHooksSchema() {
		return( secureBuffHooksSchema );
	}

	public static void setBuffHooksSchema(SecureBuffHooksSchema buffHooksSchema) {
		secureBuffHooksSchema = buffHooksSchema;
	}

	@Override
	public ISecureFactory getSecureFactory() {
		return(SecureBuffSchema.getBuffHooksSchema().getFactoryService());
	}

	@Override
	public SecureBuffFactoryService getSecureBuffFactory() {
		return((SecureBuffFactoryService)(SecureBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public SecureBuffSchema() {

	tableCluster = null; // new SecureBuffClusterTable();
	tableISOCcy = null; // new SecureBuffISOCcyTable();
	tableISOCtry = null; // new SecureBuffISOCtryTable();
	tableISOCtryCcy = null; // new SecureBuffISOCtryCcyTable();
	tableISOCtryLang = null; // new SecureBuffISOCtryLangTable();
	tableISOLang = null; // new SecureBuffISOLangTable();
	tableISOTZone = null; // new SecureBuffISOTZoneTable();
	tableSecClusGrp = null; // new SecureBuffSecClusGrpTable();
	tableSecClusGrpMemb = null; // new SecureBuffSecClusGrpMembTable();
	tableSecClusRole = null; // new SecureBuffSecClusRoleTable();
	tableSecClusRoleMemb = null; // new SecureBuffSecClusRoleMembTable();
	tableSecSession = null; // new SecureBuffSecSessionTable();
	tableSecSysGrp = null; // new SecureBuffSecSysGrpTable();
	tableSecSysGrpInc = null; // new SecureBuffSecSysGrpIncTable();
	tableSecSysGrpMemb = null; // new SecureBuffSecSysGrpMembTable();
	tableSecSysRole = null; // new SecureBuffSecSysRoleTable();
	tableSecSysRoleEnables = null; // new SecureBuffSecSysRoleEnablesTable();
	tableSecSysRoleMemb = null; // new SecureBuffSecSysRoleMembTable();
	tableSecTentGrp = null; // new SecureBuffSecTentGrpTable();
	tableSecTentGrpMemb = null; // new SecureBuffSecTentGrpMembTable();
	tableSecTentRole = null; // new SecureBuffSecTentRoleTable();
	tableSecTentRoleMemb = null; // new SecureBuffSecTentRoleMembTable();
	tableSecUser = null; // new SecureBuffSecUserTable();
	tableSecUserEMConf = null; // new SecureBuffSecUserEMConfTable();
	tableSecUserPWHistory = null; // new SecureBuffSecUserPWHistoryTable();
	tableSecUserPWReset = null; // new SecureBuffSecUserPWResetTable();
	tableSecUserPassword = null; // new SecureBuffSecUserPasswordTable();
	tableSysCluster = null; // new SecureBuffSysClusterTable();
	tableTableInfo = null; // new SecureBuffTableInfoTable();
	tableTenant = null; // new SecureBuffTenantTable();
	}

	public ISecureSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextTableInfoIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextClusterIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecUserIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTenantIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
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

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	public void bootstrapSchema(SecurePubTableData tableData[]) {
	}
	
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
	}
}
