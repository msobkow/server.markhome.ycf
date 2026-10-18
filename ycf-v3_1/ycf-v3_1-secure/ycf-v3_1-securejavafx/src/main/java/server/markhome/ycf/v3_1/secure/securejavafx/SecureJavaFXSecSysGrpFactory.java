// Description: Java 25 JavaFX Display Element Factory for SecSysGrp.

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
 *	SecureJavaFXSecSysGrpFactory JavaFX Display Element Factory
 *	for SecSysGrp.
 */
public class SecureJavaFXSecSysGrpFactory
implements ISecureJavaFXSecSysGrpFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecSysGrpFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus ) {
		SecureJavaFXSecSysGrpAttrPane retnew = new SecureJavaFXSecSysGrpAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureSecSysGrpObj argFocus,
		Collection<ISecureSecSysGrpObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecSysGrpListPane retnew = new SecureJavaFXSecSysGrpListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecSysGrpObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureSecSysGrpObj> argDataCollection,
		ISecureJavaFXSecSysGrpChosen whenChosen )
	{
		SecureJavaFXSecSysGrpPickerPane retnew = new SecureJavaFXSecSysGrpPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus ) {
		SecureJavaFXSecSysGrpEltTabPane retnew = new SecureJavaFXSecSysGrpEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus ) {
		SecureJavaFXSecSysGrpAddPane retnew = new SecureJavaFXSecSysGrpAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus ) {
		SecureJavaFXSecSysGrpViewEditPane retnew = new SecureJavaFXSecSysGrpViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecSysGrpAskDeleteForm retnew = new SecureJavaFXSecSysGrpAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXSecSysGrpFinderForm retnew = new SecureJavaFXSecSysGrpFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecSysGrpObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureSecSysGrpObj> argDataCollection,
		ISecureJavaFXSecSysGrpChosen whenChosen )
	{
		SecureJavaFXSecSysGrpPickerForm retnew = new SecureJavaFXSecSysGrpPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecSysGrpAddForm retnew = new SecureJavaFXSecSysGrpAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecSysGrpObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecSysGrpViewEditForm retnew = new SecureJavaFXSecSysGrpViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
