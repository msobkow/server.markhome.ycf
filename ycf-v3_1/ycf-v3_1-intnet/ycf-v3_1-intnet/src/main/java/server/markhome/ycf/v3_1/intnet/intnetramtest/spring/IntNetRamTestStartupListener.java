
// Description: Spring StartupListener for the RamTest program

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

package server.markhome.ycf.v3_1.intnet.intnetramtest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;

@Component
public class IntNetRamTestStartupListener {
    @Autowired
    // @Qualifier("TestSecure")
    private SecureRamTestTestSchema testSecure;

    @Autowired
    // @Qualifier("TestIntNet")
    private IntNetRamTestTestSchema testIntNet;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("IntNetRamTest StartupListener tests beginning...");

		ISecureSchema.getBackingSecure().wireTableTableInstances();
		IIntNetSchema.getBackingIntNet().wireTableTableInstances();

		IIntNetSchema.getBackingIntNet().bootstrapSchema(IIntNetSchema.getConsolidatedTableData());

        System.err.println("Executing testSecure.performTests()");
        try {
            String response = testSecure.performTests(null);
            if (response != null) {
                System.err.println("SecureRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("SecureRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testSecure.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testIntNet.performTests()");
        try {
            String response = testIntNet.performTests(null);
            if (response != null) {
                System.err.println("IntNetRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("IntNetRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testIntNet.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("IntNetRamTest StartupListener tests complete.");
    }
}
