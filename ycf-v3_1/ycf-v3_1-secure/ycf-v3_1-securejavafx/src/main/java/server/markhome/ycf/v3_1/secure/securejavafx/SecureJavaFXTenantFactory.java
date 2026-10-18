// Description: Java 25 JavaFX Display Element Factory for Tenant.

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

package server.markhome.ycf.v3_1.secure.securejavafx;

import java.math.*;
import java.time.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXTenantFactory JavaFX Display Element Factory
 *	for Tenant.
 */
public class SecureJavaFXTenantFactory
implements ISecureJavaFXTenantFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXTenantFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureTenantObj argFocus ) {
		SecureJavaFXTenantAttrPane retnew = new SecureJavaFXTenantAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureClusterObj argContainer,
		ISecureTenantObj argFocus,
		ISecureJavaFXTenantPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXTenantListPane retnew = new SecureJavaFXTenantListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureTenantObj argFocus,
		ISecureClusterObj argContainer,
		ISecureJavaFXTenantPageCallback argPageCallback,
		ISecureJavaFXTenantChosen whenChosen )
	{
		SecureJavaFXTenantPickerPane retnew = new SecureJavaFXTenantPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureTenantObj argFocus ) {
		SecureJavaFXTenantEltTabPane retnew = new SecureJavaFXTenantEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureTenantObj argFocus ) {
		SecureJavaFXTenantAddPane retnew = new SecureJavaFXTenantAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureTenantObj argFocus ) {
		SecureJavaFXTenantViewEditPane retnew = new SecureJavaFXTenantViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureTenantObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXTenantAskDeleteForm retnew = new SecureJavaFXTenantAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXTenantFinderForm retnew = new SecureJavaFXTenantFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureTenantObj argFocus,
		ISecureClusterObj argContainer,
		ISecureJavaFXTenantPageCallback argPageCallback,
		ISecureJavaFXTenantChosen whenChosen )
	{
		SecureJavaFXTenantPickerForm retnew = new SecureJavaFXTenantPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureTenantObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXTenantAddForm retnew = new SecureJavaFXTenantAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureTenantObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXTenantViewEditForm retnew = new SecureJavaFXTenantViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
