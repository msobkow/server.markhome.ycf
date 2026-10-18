// Description: Java 25 JavaFX Display Element Factory for SecSysRoleEnables.

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
 *	SecureJavaFXSecSysRoleEnablesFactory JavaFX Display Element Factory
 *	for SecSysRoleEnables.
 */
public class SecureJavaFXSecSysRoleEnablesFactory
implements ISecureJavaFXSecSysRoleEnablesFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecSysRoleEnablesFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus ) {
		SecureJavaFXSecSysRoleEnablesAttrPane retnew = new SecureJavaFXSecSysRoleEnablesAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecSysRoleObj argContainer,
		ISecureSecSysRoleEnablesObj argFocus,
		ISecureJavaFXSecSysRoleEnablesPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecSysRoleEnablesListPane retnew = new SecureJavaFXSecSysRoleEnablesListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecSysRoleEnablesObj argFocus,
		ISecureSecSysRoleObj argContainer,
		ISecureJavaFXSecSysRoleEnablesPageCallback argPageCallback,
		ISecureJavaFXSecSysRoleEnablesChosen whenChosen )
	{
		SecureJavaFXSecSysRoleEnablesPickerPane retnew = new SecureJavaFXSecSysRoleEnablesPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus ) {
		SecureJavaFXSecSysRoleEnablesEltTabPane retnew = new SecureJavaFXSecSysRoleEnablesEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus ) {
		SecureJavaFXSecSysRoleEnablesAddPane retnew = new SecureJavaFXSecSysRoleEnablesAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus ) {
		SecureJavaFXSecSysRoleEnablesViewEditPane retnew = new SecureJavaFXSecSysRoleEnablesViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecSysRoleEnablesAskDeleteForm retnew = new SecureJavaFXSecSysRoleEnablesAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecSysRoleEnablesObj argFocus,
		ISecureSecSysRoleObj argContainer,
		ISecureJavaFXSecSysRoleEnablesPageCallback argPageCallback,
		ISecureJavaFXSecSysRoleEnablesChosen whenChosen )
	{
		SecureJavaFXSecSysRoleEnablesPickerForm retnew = new SecureJavaFXSecSysRoleEnablesPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecSysRoleEnablesAddForm retnew = new SecureJavaFXSecSysRoleEnablesAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecSysRoleEnablesObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecSysRoleEnablesViewEditForm retnew = new SecureJavaFXSecSysRoleEnablesViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
