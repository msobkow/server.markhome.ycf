// Description: Java 25 JavaFX Display Element Factory for SecSysGrpMemb.

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
 *	SecureJavaFXSecSysGrpMembFactory JavaFX Display Element Factory
 *	for SecSysGrpMemb.
 */
public class SecureJavaFXSecSysGrpMembFactory
implements ISecureJavaFXSecSysGrpMembFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecSysGrpMembFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus ) {
		SecureJavaFXSecSysGrpMembAttrPane retnew = new SecureJavaFXSecSysGrpMembAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecSysGrpObj argContainer,
		ISecureSecSysGrpMembObj argFocus,
		ISecureJavaFXSecSysGrpMembPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecSysGrpMembListPane retnew = new SecureJavaFXSecSysGrpMembListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecSysGrpMembObj argFocus,
		ISecureSecSysGrpObj argContainer,
		ISecureJavaFXSecSysGrpMembPageCallback argPageCallback,
		ISecureJavaFXSecSysGrpMembChosen whenChosen )
	{
		SecureJavaFXSecSysGrpMembPickerPane retnew = new SecureJavaFXSecSysGrpMembPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus ) {
		SecureJavaFXSecSysGrpMembEltTabPane retnew = new SecureJavaFXSecSysGrpMembEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus ) {
		SecureJavaFXSecSysGrpMembAddPane retnew = new SecureJavaFXSecSysGrpMembAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus ) {
		SecureJavaFXSecSysGrpMembViewEditPane retnew = new SecureJavaFXSecSysGrpMembViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecSysGrpMembAskDeleteForm retnew = new SecureJavaFXSecSysGrpMembAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecSysGrpMembObj argFocus,
		ISecureSecSysGrpObj argContainer,
		ISecureJavaFXSecSysGrpMembPageCallback argPageCallback,
		ISecureJavaFXSecSysGrpMembChosen whenChosen )
	{
		SecureJavaFXSecSysGrpMembPickerForm retnew = new SecureJavaFXSecSysGrpMembPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecSysGrpMembAddForm retnew = new SecureJavaFXSecSysGrpMembAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecSysGrpMembObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecSysGrpMembViewEditForm retnew = new SecureJavaFXSecSysGrpMembViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
