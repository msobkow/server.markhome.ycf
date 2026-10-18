// Description: Java 25 JavaFX Display Element Factory for SecUserEMConf.

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
 *	SecureJavaFXSecUserEMConfFactory JavaFX Display Element Factory
 *	for SecUserEMConf.
 */
public class SecureJavaFXSecUserEMConfFactory
implements ISecureJavaFXSecUserEMConfFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecUserEMConfFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus ) {
		SecureJavaFXSecUserEMConfAttrPane retnew = new SecureJavaFXSecUserEMConfAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecUserObj argContainer,
		ISecureSecUserEMConfObj argFocus,
		ISecureJavaFXSecUserEMConfPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecUserEMConfListPane retnew = new SecureJavaFXSecUserEMConfListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecUserEMConfObj argFocus,
		ISecureSecUserObj argContainer,
		ISecureJavaFXSecUserEMConfPageCallback argPageCallback,
		ISecureJavaFXSecUserEMConfChosen whenChosen )
	{
		SecureJavaFXSecUserEMConfPickerPane retnew = new SecureJavaFXSecUserEMConfPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus ) {
		SecureJavaFXSecUserEMConfEltTabPane retnew = new SecureJavaFXSecUserEMConfEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus ) {
		SecureJavaFXSecUserEMConfAddPane retnew = new SecureJavaFXSecUserEMConfAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus ) {
		SecureJavaFXSecUserEMConfViewEditPane retnew = new SecureJavaFXSecUserEMConfViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecUserEMConfAskDeleteForm retnew = new SecureJavaFXSecUserEMConfAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecUserEMConfObj argFocus,
		ISecureSecUserObj argContainer,
		ISecureJavaFXSecUserEMConfPageCallback argPageCallback,
		ISecureJavaFXSecUserEMConfChosen whenChosen )
	{
		SecureJavaFXSecUserEMConfPickerForm retnew = new SecureJavaFXSecUserEMConfPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecUserEMConfAddForm retnew = new SecureJavaFXSecUserEMConfAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecUserEMConfObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecUserEMConfViewEditForm retnew = new SecureJavaFXSecUserEMConfViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
