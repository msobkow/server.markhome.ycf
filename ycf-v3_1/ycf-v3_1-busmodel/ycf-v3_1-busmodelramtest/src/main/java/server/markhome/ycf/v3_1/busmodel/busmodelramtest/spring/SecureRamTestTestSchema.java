
// Description: Spring Ram storage tests for Secure for the RamTest program

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelramtest.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

@Service("RamTestSecure")
public class SecureRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting Secure tests...\n");
		{
			try {
				LocalDateTime now = LocalDateTime.now();
				YCFDbKeyHash256 adminpid = new YCFDbKeyHash256("f012301230123012301230123012301230123012301230123012301230123012");
				YCFDbKeyHash256 mgrpid =   new YCFDbKeyHash256("fabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc");
				ISecureSecUser secUserResults = ISecureSchema.getBackingSecure().getTableSecUser().readDerived(null, adminpid);
				if( secUserResults == null ) {
					SecureBuffSecUser newuser = (SecureBuffSecUser)(ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecUser().newRec());
					newuser.setCreatedByUserId( adminpid );
					newuser.setCreatedAt( now );
					newuser.setUpdatedByUserId( adminpid );
					newuser.setUpdatedAt( now );
					newuser.setPKey(adminpid);
					newuser.setRequiredSecUserId( adminpid );
					newuser.setRequiredRevision( 1 );
					newuser.setRequiredLoginId( "admin" );
					newuser.setRequiredEMailAddress("admin@localhost");
					
					ISecureSecUser secUserCreated = ISecureSchema.getBackingSecure().getTableSecUser().createSecUser(null, newuser);
					if (secUserCreated == null) {
						messages.append("Error creating secuser admin - null returned\n");
					}
					else {
						messages.append("Created admin user: " + secUserCreated.toString() + "\n");
					}
				}
				else {
					messages.append("Admin user already exists: " + secUserResults.toString() + "\n");
				}
			}
			catch (Exception e) {
				String msg = "ERROR: performTests() Caught and rethrew " + e.getClass().getCanonicalName() + " while modifying or creating the 'admin' user - " + e.getMessage();
				messages.append(msg);
				System.err.println(msg);
				e.printStackTrace(System.err);
			}
		}

		ISecureCluster[] clusterResults = ISecureSchema.getBackingSecure().getTableCluster().readAllDerived(null);
		if (clusterResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getClusterTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clusterResults.length + " entities from Secure.Cluster\n");
		}

		ISecureTenant[] tenantResults = ISecureSchema.getBackingSecure().getTableTenant().readAllDerived(null);
		if (tenantResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getTenantTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tenantResults.length + " entities from Secure.Tenant\n");
		}

		ISecureTableInfo[] tableInfoResults = ISecureSchema.getBackingSecure().getTableTableInfo().readAllDerived(null);
		if (tableInfoResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getTableInfoTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableInfoResults.length + " entities from Secure.TableInfo\n");
		}

		ISecureISOCcy[] iSOCcyResults = ISecureSchema.getBackingSecure().getTableISOCcy().readAllDerived(null);
		if (iSOCcyResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOCcyTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCcyResults.length + " entities from Secure.ISOCcy\n");
		}

		ISecureISOCtry[] iSOCtryResults = ISecureSchema.getBackingSecure().getTableISOCtry().readAllDerived(null);
		if (iSOCtryResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOCtryTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryResults.length + " entities from Secure.ISOCtry\n");
		}

		ISecureISOCtryCcy[] iSOCtryCcyResults = ISecureSchema.getBackingSecure().getTableISOCtryCcy().readAllDerived(null);
		if (iSOCtryCcyResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOCtryCcyTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryCcyResults.length + " entities from Secure.ISOCtryCcy\n");
		}

		ISecureISOCtryLang[] iSOCtryLangResults = ISecureSchema.getBackingSecure().getTableISOCtryLang().readAllDerived(null);
		if (iSOCtryLangResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOCtryLangTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryLangResults.length + " entities from Secure.ISOCtryLang\n");
		}

		ISecureISOLang[] iSOLangResults = ISecureSchema.getBackingSecure().getTableISOLang().readAllDerived(null);
		if (iSOLangResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOLangTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOLangResults.length + " entities from Secure.ISOLang\n");
		}

		ISecureISOTZone[] iSOTZoneResults = ISecureSchema.getBackingSecure().getTableISOTZone().readAllDerived(null);
		if (iSOTZoneResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getISOTZoneTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOTZoneResults.length + " entities from Secure.ISOTZone\n");
		}

		ISecureSecUser[] secUserResults = ISecureSchema.getBackingSecure().getTableSecUser().readAllDerived(null);
		if (secUserResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecUserTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserResults.length + " entities from Secure.SecUser\n");
		}

		ISecureSecUserPassword[] secUserPasswordResults = ISecureSchema.getBackingSecure().getTableSecUserPassword().readAllDerived(null);
		if (secUserPasswordResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecUserPasswordTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserPasswordResults.length + " entities from Secure.SecUserPassword\n");
		}

		ISecureSecUserEMConf[] secUserEMConfResults = ISecureSchema.getBackingSecure().getTableSecUserEMConf().readAllDerived(null);
		if (secUserEMConfResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecUserEMConfTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserEMConfResults.length + " entities from Secure.SecUserEMConf\n");
		}

		ISecureSecUserPWReset[] secUserPWResetResults = ISecureSchema.getBackingSecure().getTableSecUserPWReset().readAllDerived(null);
		if (secUserPWResetResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecUserPWResetTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserPWResetResults.length + " entities from Secure.SecUserPWReset\n");
		}

		ISecureSecUserPWHistory[] secUserPWHistoryResults = ISecureSchema.getBackingSecure().getTableSecUserPWHistory().readAllDerived(null);
		if (secUserPWHistoryResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecUserPWHistoryTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserPWHistoryResults.length + " entities from Secure.SecUserPWHistory\n");
		}

		ISecureSecSysGrp[] secSysGrpResults = ISecureSchema.getBackingSecure().getTableSecSysGrp().readAllDerived(null);
		if (secSysGrpResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysGrpTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpResults.length + " entities from Secure.SecSysGrp\n");
		}

		ISecureSecSysGrpInc[] secSysGrpIncResults = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readAllDerived(null);
		if (secSysGrpIncResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysGrpIncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpIncResults.length + " entities from Secure.SecSysGrpInc\n");
		}

		ISecureSecSysGrpMemb[] secSysGrpMembResults = ISecureSchema.getBackingSecure().getTableSecSysGrpMemb().readAllDerived(null);
		if (secSysGrpMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysGrpMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpMembResults.length + " entities from Secure.SecSysGrpMemb\n");
		}

		ISecureSecClusGrp[] secClusGrpResults = ISecureSchema.getBackingSecure().getTableSecClusGrp().readAllDerived(null);
		if (secClusGrpResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecClusGrpTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpResults.length + " entities from Secure.SecClusGrp\n");
		}

		ISecureSecClusGrpMemb[] secClusGrpMembResults = ISecureSchema.getBackingSecure().getTableSecClusGrpMemb().readAllDerived(null);
		if (secClusGrpMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecClusGrpMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpMembResults.length + " entities from Secure.SecClusGrpMemb\n");
		}

		ISecureSecTentGrp[] secTentGrpResults = ISecureSchema.getBackingSecure().getTableSecTentGrp().readAllDerived(null);
		if (secTentGrpResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecTentGrpTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpResults.length + " entities from Secure.SecTentGrp\n");
		}

		ISecureSecTentGrpMemb[] secTentGrpMembResults = ISecureSchema.getBackingSecure().getTableSecTentGrpMemb().readAllDerived(null);
		if (secTentGrpMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecTentGrpMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpMembResults.length + " entities from Secure.SecTentGrpMemb\n");
		}

		ISecureSecSysRole[] secSysRoleResults = ISecureSchema.getBackingSecure().getTableSecSysRole().readAllDerived(null);
		if (secSysRoleResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysRoleTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleResults.length + " entities from Secure.SecSysRole\n");
		}

		ISecureSecSysRoleEnables[] secSysRoleEnablesResults = ISecureSchema.getBackingSecure().getTableSecSysRoleEnables().readAllDerived(null);
		if (secSysRoleEnablesResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysRoleEnablesTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleEnablesResults.length + " entities from Secure.SecSysRoleEnables\n");
		}

		ISecureSecSysRoleMemb[] secSysRoleMembResults = ISecureSchema.getBackingSecure().getTableSecSysRoleMemb().readAllDerived(null);
		if (secSysRoleMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSysRoleMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleMembResults.length + " entities from Secure.SecSysRoleMemb\n");
		}

		ISecureSecClusRole[] secClusRoleResults = ISecureSchema.getBackingSecure().getTableSecClusRole().readAllDerived(null);
		if (secClusRoleResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecClusRoleTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secClusRoleResults.length + " entities from Secure.SecClusRole\n");
		}

		ISecureSecClusRoleMemb[] secClusRoleMembResults = ISecureSchema.getBackingSecure().getTableSecClusRoleMemb().readAllDerived(null);
		if (secClusRoleMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecClusRoleMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secClusRoleMembResults.length + " entities from Secure.SecClusRoleMemb\n");
		}

		ISecureSecTentRole[] secTentRoleResults = ISecureSchema.getBackingSecure().getTableSecTentRole().readAllDerived(null);
		if (secTentRoleResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecTentRoleTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secTentRoleResults.length + " entities from Secure.SecTentRole\n");
		}

		ISecureSecTentRoleMemb[] secTentRoleMembResults = ISecureSchema.getBackingSecure().getTableSecTentRoleMemb().readAllDerived(null);
		if (secTentRoleMembResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecTentRoleMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secTentRoleMembResults.length + " entities from Secure.SecTentRoleMemb\n");
		}

		ISecureSecSession[] secSessionResults = ISecureSchema.getBackingSecure().getTableSecSession().readAllDerived(null);
		if (secSessionResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSecSessionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSessionResults.length + " entities from Secure.SecSession\n");
		}

		ISecureSysCluster[] sysClusterResults = ISecureSchema.getBackingSecure().getTableSysCluster().readAllDerived(null);
		if (sysClusterResults == null) {
			messages.append("Erroneously retrieved null for ISecureSchema.getSysClusterTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + sysClusterResults.length + " entities from Secure.SysCluster\n");
		}

		messages.append("Secure tests complete\n");
		return( messages.toString() );
	}

	// From Google's AI
    /**
     * Computes the SHA-256 hash of a given string and returns it as a hex string.
     *
     * @param text The input string to hash.
     * @return The SHA-256 hash in hexadecimal format.
     */
    public static String computeSHA256(String text) {
        try {
            // Step 1: Get a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Step 2: Convert the input string to bytes using UTF-8 encoding
            byte[] hashBytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));

            // Step 3: Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert byte to hex (ensure two characters per byte)
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the algorithm is not available (highly unlikely for SHA-256)
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }
}