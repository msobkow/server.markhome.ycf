// Description: Java 25 JavaFX Display Element Factory for ISOCtryLang.

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
 *	SecureJavaFXISOCtryLangFactory JavaFX Display Element Factory
 *	for ISOCtryLang.
 */
public class SecureJavaFXISOCtryLangFactory
implements ISecureJavaFXISOCtryLangFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXISOCtryLangFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus ) {
		SecureJavaFXISOCtryLangAttrPane retnew = new SecureJavaFXISOCtryLangAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureISOCtryObj argContainer,
		ISecureISOCtryLangObj argFocus,
		Collection<ISecureISOCtryLangObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXISOCtryLangListPane retnew = new SecureJavaFXISOCtryLangListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureISOCtryLangObj argFocus,
		ISecureISOCtryObj argContainer,
		Collection<ISecureISOCtryLangObj> argDataCollection,
		ISecureJavaFXISOCtryLangChosen whenChosen )
	{
		SecureJavaFXISOCtryLangPickerPane retnew = new SecureJavaFXISOCtryLangPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus ) {
		SecureJavaFXISOCtryLangEltTabPane retnew = new SecureJavaFXISOCtryLangEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus ) {
		SecureJavaFXISOCtryLangAddPane retnew = new SecureJavaFXISOCtryLangAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus ) {
		SecureJavaFXISOCtryLangViewEditPane retnew = new SecureJavaFXISOCtryLangViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXISOCtryLangAskDeleteForm retnew = new SecureJavaFXISOCtryLangAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureISOCtryLangObj argFocus,
		ISecureISOCtryObj argContainer,
		Collection<ISecureISOCtryLangObj> argDataCollection,
		ISecureJavaFXISOCtryLangChosen whenChosen )
	{
		SecureJavaFXISOCtryLangPickerForm retnew = new SecureJavaFXISOCtryLangPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXISOCtryLangAddForm retnew = new SecureJavaFXISOCtryLangAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureISOCtryLangObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXISOCtryLangViewEditForm retnew = new SecureJavaFXISOCtryLangViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
