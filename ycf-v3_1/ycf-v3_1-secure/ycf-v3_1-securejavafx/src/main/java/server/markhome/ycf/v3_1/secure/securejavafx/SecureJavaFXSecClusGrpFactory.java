// Description: Java 25 JavaFX Display Element Factory for SecClusGrp.

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
 *	SecureJavaFXSecClusGrpFactory JavaFX Display Element Factory
 *	for SecClusGrp.
 */
public class SecureJavaFXSecClusGrpFactory
implements ISecureJavaFXSecClusGrpFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecClusGrpFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus ) {
		SecureJavaFXSecClusGrpAttrPane retnew = new SecureJavaFXSecClusGrpAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecSysGrpObj argContainer,
		ISecureSecClusGrpObj argFocus,
		Collection<ISecureSecClusGrpObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecClusGrpListPane retnew = new SecureJavaFXSecClusGrpListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecClusGrpObj argFocus,
		ISecureSecSysGrpObj argContainer,
		Collection<ISecureSecClusGrpObj> argDataCollection,
		ISecureJavaFXSecClusGrpChosen whenChosen )
	{
		SecureJavaFXSecClusGrpPickerPane retnew = new SecureJavaFXSecClusGrpPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus ) {
		SecureJavaFXSecClusGrpEltTabPane retnew = new SecureJavaFXSecClusGrpEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus ) {
		SecureJavaFXSecClusGrpAddPane retnew = new SecureJavaFXSecClusGrpAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus ) {
		SecureJavaFXSecClusGrpViewEditPane retnew = new SecureJavaFXSecClusGrpViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecClusGrpAskDeleteForm retnew = new SecureJavaFXSecClusGrpAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecClusGrpObj argFocus,
		ISecureSecSysGrpObj argContainer,
		Collection<ISecureSecClusGrpObj> argDataCollection,
		ISecureJavaFXSecClusGrpChosen whenChosen )
	{
		SecureJavaFXSecClusGrpPickerForm retnew = new SecureJavaFXSecClusGrpPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecClusGrpAddForm retnew = new SecureJavaFXSecClusGrpAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecClusGrpObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecClusGrpViewEditForm retnew = new SecureJavaFXSecClusGrpViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
