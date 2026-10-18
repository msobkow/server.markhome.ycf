// Description: Java 25 JavaFX Display Element Factory for SecSysGrpInc.

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
 *	SecureJavaFXSecSysGrpIncFactory JavaFX Display Element Factory
 *	for SecSysGrpInc.
 */
public class SecureJavaFXSecSysGrpIncFactory
implements ISecureJavaFXSecSysGrpIncFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecSysGrpIncFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus ) {
		SecureJavaFXSecSysGrpIncAttrPane retnew = new SecureJavaFXSecSysGrpIncAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecSysGrpObj argContainer,
		ISecureSecSysGrpIncObj argFocus,
		ISecureJavaFXSecSysGrpIncPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecSysGrpIncListPane retnew = new SecureJavaFXSecSysGrpIncListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecSysGrpIncObj argFocus,
		ISecureSecSysGrpObj argContainer,
		ISecureJavaFXSecSysGrpIncPageCallback argPageCallback,
		ISecureJavaFXSecSysGrpIncChosen whenChosen )
	{
		SecureJavaFXSecSysGrpIncPickerPane retnew = new SecureJavaFXSecSysGrpIncPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus ) {
		SecureJavaFXSecSysGrpIncEltTabPane retnew = new SecureJavaFXSecSysGrpIncEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus ) {
		SecureJavaFXSecSysGrpIncAddPane retnew = new SecureJavaFXSecSysGrpIncAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus ) {
		SecureJavaFXSecSysGrpIncViewEditPane retnew = new SecureJavaFXSecSysGrpIncViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecSysGrpIncAskDeleteForm retnew = new SecureJavaFXSecSysGrpIncAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecSysGrpIncObj argFocus,
		ISecureSecSysGrpObj argContainer,
		ISecureJavaFXSecSysGrpIncPageCallback argPageCallback,
		ISecureJavaFXSecSysGrpIncChosen whenChosen )
	{
		SecureJavaFXSecSysGrpIncPickerForm retnew = new SecureJavaFXSecSysGrpIncPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecSysGrpIncAddForm retnew = new SecureJavaFXSecSysGrpIncAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecSysGrpIncObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecSysGrpIncViewEditForm retnew = new SecureJavaFXSecSysGrpIncViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
