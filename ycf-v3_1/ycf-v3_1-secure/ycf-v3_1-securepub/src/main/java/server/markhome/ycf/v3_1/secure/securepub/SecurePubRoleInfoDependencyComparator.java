// Description: Java 25 Secure Public Role Information Implementation

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.util.Comparator;

/*
 *	The SecurePubRoleInfoDependencyComparator objects are passed in to the SecurePub schema implementation to be bound
 *	to the security system.  Their natural order is to compare by dependency first, and by name second.
 */
public class SecurePubRoleInfoDependencyComparator implements Comparator<SecurePubRoleInfo>
{
	@Override
	public int compare( SecurePubRoleInfo lhs, SecurePubRoleInfo rhs ) {
		if( lhs == null ) {
			if ( rhs == null ) {
				return( 0 );
			}
			else {
				return( -1 );
			}
		}
		else if( rhs == null ) {
			return( 1 );
		}
		else {
			String lhsName = lhs.getRoleName();
			String rhsName = rhs.getRoleName();

			String lhsEnables = lhs.getEnables();
			String rhsEnables = rhs.getEnables();
			String lhsEnablesArr[] = lhsEnables.split(" ");
			String rhsEnablesArr[] = rhsEnables.split(" ");
			boolean rhsEnablesLhs = false;
			boolean lhsEnablesRhs = false;
			for (String v: lhsEnablesArr) {
				if (rhsName.equals(v)) {
					lhsEnablesRhs = true;
					break;
				}
			}
			for (String v: rhsEnablesArr) {
				if (lhsName.equals(v)) {
					rhsEnablesLhs = true;
					break;
				}
			}

			String lhsIncludes = lhs.getIncludes();
			String rhsIncludes = rhs.getIncludes();
			String lhsIncludesArr[] = lhsIncludes.split(" ");
			String rhsIncludesArr[] = rhsIncludes.split(" ");
			boolean rhsIncludesLhs = false;
			boolean lhsIncludesRhs = false;
			for (String v: lhsIncludesArr) {
				if (rhsName.equals(v)) {
					lhsIncludesRhs = true;
					break;
				}
			}
			for (String v: rhsIncludesArr) {
				if (lhsName.equals(v)) {
					rhsIncludesLhs = true;
					break;
				}
			}

			int ret;

			if (lhsEnablesRhs) {
				if (rhsEnablesLhs) {
					if (lhsIncludesRhs) {
						if (rhsIncludesLhs) {
							ret = lhsName.compareTo(rhsName);
						}
						else {
							ret = 1;
						}
					}
					else {
						if (rhsIncludesLhs) {
							ret = -1;
						}
						else {
							ret = lhsName.compareTo(rhsName);
						}
					}
				}
				else {
					ret = 1;
				}
			}
			else {
				if (rhsEnablesLhs) {
					ret = -1;
				}
				else {
					if (lhsIncludesRhs) {
						if (rhsIncludesLhs) {
							ret = lhsName.compareTo(rhsName);
						}
						else {
							ret = 1;
						}
					}
					else {
						if (rhsIncludesLhs) {
							ret = -1;
						}
						else {
							ret = lhsName.compareTo(rhsName);
						}
					}
				}
			}
			return( ret );
		}
	}
}
