// Description: Java 25 JavaFX Display Element Factory for SecTentGrpMemb.

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
 *	SecureJavaFXSecTentGrpMembFactory JavaFX Display Element Factory
 *	for SecTentGrpMemb.
 */
public class SecureJavaFXSecTentGrpMembFactory
implements ISecureJavaFXSecTentGrpMembFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecTentGrpMembFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus ) {
		SecureJavaFXSecTentGrpMembAttrPane retnew = new SecureJavaFXSecTentGrpMembAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecTentGrpObj argContainer,
		ISecureSecTentGrpMembObj argFocus,
		ISecureJavaFXSecTentGrpMembPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecTentGrpMembListPane retnew = new SecureJavaFXSecTentGrpMembListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecTentGrpMembObj argFocus,
		ISecureSecTentGrpObj argContainer,
		ISecureJavaFXSecTentGrpMembPageCallback argPageCallback,
		ISecureJavaFXSecTentGrpMembChosen whenChosen )
	{
		SecureJavaFXSecTentGrpMembPickerPane retnew = new SecureJavaFXSecTentGrpMembPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus ) {
		SecureJavaFXSecTentGrpMembEltTabPane retnew = new SecureJavaFXSecTentGrpMembEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus ) {
		SecureJavaFXSecTentGrpMembAddPane retnew = new SecureJavaFXSecTentGrpMembAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus ) {
		SecureJavaFXSecTentGrpMembViewEditPane retnew = new SecureJavaFXSecTentGrpMembViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecTentGrpMembAskDeleteForm retnew = new SecureJavaFXSecTentGrpMembAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecTentGrpMembObj argFocus,
		ISecureSecTentGrpObj argContainer,
		ISecureJavaFXSecTentGrpMembPageCallback argPageCallback,
		ISecureJavaFXSecTentGrpMembChosen whenChosen )
	{
		SecureJavaFXSecTentGrpMembPickerForm retnew = new SecureJavaFXSecTentGrpMembPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecTentGrpMembAddForm retnew = new SecureJavaFXSecTentGrpMembAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecTentGrpMembObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecTentGrpMembViewEditForm retnew = new SecureJavaFXSecTentGrpMembViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
