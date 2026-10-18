
// Description: Spring StartupListener for the JpaTest program

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

package server.markhome.ycf.v3_1.busmodel.busmodeljpatest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.jpa.*;

@Component
public class BusModelJpaTestStartupListener implements ApplicationContextAware {
    @Autowired
    // @Qualifier("TestSecure")
    private SecureJpaTestTestSchema testSecure;

    @Autowired
    // @Qualifier("TestIntNet")
    private IntNetJpaTestTestSchema testIntNet;

    @Autowired
    // @Qualifier("TestBusModel")
    private BusModelJpaTestTestSchema testBusModel;


	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}


	@Autowired
	@Qualifier("secure31JpaHooksSchema")
	private SecureJpaHooksSchema secureJpaHooksSchema;

	@Autowired
	@Qualifier("intnet31JpaHooksSchema")
	private IntNetJpaHooksSchema intnetJpaHooksSchema;

	@Autowired
	@Qualifier("busmodel31JpaHooksSchema")
	private BusModelJpaHooksSchema busmodelJpaHooksSchema;

	@EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("BusModelJpaTest StartupListener tests beginning...");

		ISecureSchema.getBackingSecure().setApplicationContext(getApplicationContext());
		IIntNetSchema.getBackingIntNet().setApplicationContext(getApplicationContext());
		IBusModelSchema.getBackingBusModel().setApplicationContext(getApplicationContext());

		((SecureJpaSchema)ISecureSchema.getBackingSecure()).setJpaHooksSchema(secureJpaHooksSchema);
		((IntNetJpaSchema)IIntNetSchema.getBackingIntNet()).setJpaHooksSchema(intnetJpaHooksSchema);
		((BusModelJpaSchema)IBusModelSchema.getBackingBusModel()).setJpaHooksSchema(busmodelJpaHooksSchema);


		ISecureSchema.getBackingSecure().wireTableTableInstances();
		IIntNetSchema.getBackingIntNet().wireTableTableInstances();
		IBusModelSchema.getBackingBusModel().wireTableTableInstances();
		ISecureSchema.setSecurityControl(new SecureJpaSecurityCache());

		IBusModelSchema.getBackingBusModel().bootstrapSchema(IBusModelSchema.getConsolidatedTableData());

        System.err.println("Executing testSecure.performTests()");
        try {
            String response = testSecure.performTests(null);
            if (response != null) {
                System.err.println("SecureJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("SecureJpaTestTestSchema.performTests() did not return a response");
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
                System.err.println("IntNetJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("IntNetJpaTestTestSchema.performTests() did not return a response");
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
                System.err.println("BusModelJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("BusModelJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testBusModel.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("BusModelJpaTest StartupListener tests complete.");
    }
}
