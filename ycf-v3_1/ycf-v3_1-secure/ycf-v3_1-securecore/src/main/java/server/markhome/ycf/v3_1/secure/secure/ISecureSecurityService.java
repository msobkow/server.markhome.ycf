// Description: Java 25 Private Security Service Interface.

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

package server.markhome.ycf.v3_1.secure.secure;

import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFDbKeyHash256;
import server.markhome.ycf.v3_1.secure.securepub.ISecurePubSecurityService;
import server.markhome.ycf.v3_1.secure.secureprot.ISecureProtSecurityService;
import server.markhome.ycf.v3_1.secure.secureprot.ISecureProtSecurityControl;

/*
 *	An ISecureSecurityService is the private service interface used in
 *	application server code to implement a SecurityService cache that can accept new
 *	server registrations.
 *	The ISecureSecurityControl interface is a private interface used by the
 *	security server to control security server caches that have registered interest
 *	in the security server. The control interface is used to communicate between the
 *	root security server and the security server caches.
 */
public interface ISecureSecurityService extends ISecureProtSecurityService {

	/**
	 *	Register a SecurityControl implementation as an interested listener to receive propagation of the forget commands filtered by their
	 *	intersection with information in this cache.
	 *
	 *	@param securityControl If you can't control it, you can't register it.
	 *
	 *	@return true if a new interest registration was established, false if the interest had been previously established.
	 */
	public default boolean registerInterest(ISecureSecurityControl securityControl) {
		return registerInterest((ISecureProtSecurityControl)securityControl);
	};

	/**
	 *	Remove a SecurityControl implementation from the registered list of listeners.
	 *
	 *	@param securityControl If you can't control it, you can't register it.
	 *
	 *	@return true if the security control was removed, false if it was not found.
	 */
	public default boolean forgetInterest(ISecureSecurityControl securityControl) {
		return forgetInterest((ISecureProtSecurityControl)securityControl);
	};

	/**
	 *	Did the specified SecurityControl register interest in filtered forget commands?
	 *
	 *	@param securityControl If you can't control it, you can't register it.
	 *
	 *	@return true if the SecurityControl is in the interest registration list, otherwise false.
	 */
	public default boolean isInterested(ISecureSecurityControl securityControl) {
		return isInterested((ISecureProtSecurityControl)securityControl);
	};
}
