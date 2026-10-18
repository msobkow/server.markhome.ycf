
// Description: Spring StartupListener for the RamTest program

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelram.*;

@Component
public class BusModelRamTestStartupListener {
    @Autowired
    // @Qualifier("TestSecure")
    private SecureRamTestTestSchema testSecure;

    @Autowired
    // @Qualifier("TestIntNet")
    private IntNetRamTestTestSchema testIntNet;

    @Autowired
    // @Qualifier("TestBusModel")
    private BusModelRamTestTestSchema testBusModel;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("BusModelRamTest StartupListener tests beginning...");

		ISecureSchema.getBackingSecure().wireTableTableInstances();
		IIntNetSchema.getBackingIntNet().wireTableTableInstances();
		IBusModelSchema.getBackingBusModel().wireTableTableInstances();

		IBusModelSchema.getBackingBusModel().bootstrapSchema(IBusModelSchema.getConsolidatedTableData());

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

        System.err.println("Executing testBusModel.performTests()");
        try {
            String response = testBusModel.performTests(null);
            if (response != null) {
                System.err.println("BusModelRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("BusModelRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testBusModel.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("BusModelRamTest StartupListener tests complete.");
    }
}
