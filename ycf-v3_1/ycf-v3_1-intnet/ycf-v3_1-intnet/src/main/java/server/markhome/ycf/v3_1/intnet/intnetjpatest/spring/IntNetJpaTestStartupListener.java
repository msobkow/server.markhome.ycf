
// Description: Spring StartupListener for the JpaTest program

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

package server.markhome.ycf.v3_1.intnet.intnetjpatest.spring;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

@Component
public class IntNetJpaTestStartupListener implements ApplicationContextAware {
    @Autowired
    // @Qualifier("TestSecure")
    private SecureJpaTestTestSchema testSecure;

    @Autowired
    // @Qualifier("TestIntNet")
    private IntNetJpaTestTestSchema testIntNet;


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

	@EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("IntNetJpaTest StartupListener tests beginning...");

		ISecureSchema.getBackingSecure().setApplicationContext(getApplicationContext());
		IIntNetSchema.getBackingIntNet().setApplicationContext(getApplicationContext());

		((SecureJpaSchema)ISecureSchema.getBackingSecure()).setJpaHooksSchema(secureJpaHooksSchema);
		((IntNetJpaSchema)IIntNetSchema.getBackingIntNet()).setJpaHooksSchema(intnetJpaHooksSchema);


		ISecureSchema.getBackingSecure().wireTableTableInstances();
		IIntNetSchema.getBackingIntNet().wireTableTableInstances();
		ISecureSchema.setSecurityControl(new SecureJpaSecurityCache());

		IIntNetSchema.getBackingIntNet().bootstrapSchema(IIntNetSchema.getConsolidatedTableData());

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

        System.err.println("IntNetJpaTest StartupListener tests complete.");
    }
}
