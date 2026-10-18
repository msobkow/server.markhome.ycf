// Description: Java 25 JavaFX Display Element Factory for ISOLang.

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
 *	SecureJavaFXISOLangFactory JavaFX Display Element Factory
 *	for ISOLang.
 */
public class SecureJavaFXISOLangFactory
implements ISecureJavaFXISOLangFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXISOLangFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureISOLangObj argFocus ) {
		SecureJavaFXISOLangAttrPane retnew = new SecureJavaFXISOLangAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureISOLangObj argFocus,
		Collection<ISecureISOLangObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXISOLangListPane retnew = new SecureJavaFXISOLangListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureISOLangObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOLangObj> argDataCollection,
		ISecureJavaFXISOLangChosen whenChosen )
	{
		SecureJavaFXISOLangPickerPane retnew = new SecureJavaFXISOLangPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureISOLangObj argFocus ) {
		SecureJavaFXISOLangEltTabPane retnew = new SecureJavaFXISOLangEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureISOLangObj argFocus ) {
		SecureJavaFXISOLangAddPane retnew = new SecureJavaFXISOLangAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureISOLangObj argFocus ) {
		SecureJavaFXISOLangViewEditPane retnew = new SecureJavaFXISOLangViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureISOLangObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXISOLangAskDeleteForm retnew = new SecureJavaFXISOLangAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXISOLangFinderForm retnew = new SecureJavaFXISOLangFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureISOLangObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOLangObj> argDataCollection,
		ISecureJavaFXISOLangChosen whenChosen )
	{
		SecureJavaFXISOLangPickerForm retnew = new SecureJavaFXISOLangPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureISOLangObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXISOLangAddForm retnew = new SecureJavaFXISOLangAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureISOLangObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXISOLangViewEditForm retnew = new SecureJavaFXISOLangViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
