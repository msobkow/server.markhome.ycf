// Description: Java 25 JavaFX Display Element Factory for ISOCtry.

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
 *	SecureJavaFXISOCtryFactory JavaFX Display Element Factory
 *	for ISOCtry.
 */
public class SecureJavaFXISOCtryFactory
implements ISecureJavaFXISOCtryFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXISOCtryFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureISOCtryObj argFocus ) {
		SecureJavaFXISOCtryAttrPane retnew = new SecureJavaFXISOCtryAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureISOCtryObj argFocus,
		Collection<ISecureISOCtryObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXISOCtryListPane retnew = new SecureJavaFXISOCtryListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureISOCtryObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOCtryObj> argDataCollection,
		ISecureJavaFXISOCtryChosen whenChosen )
	{
		SecureJavaFXISOCtryPickerPane retnew = new SecureJavaFXISOCtryPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureISOCtryObj argFocus ) {
		SecureJavaFXISOCtryEltTabPane retnew = new SecureJavaFXISOCtryEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureISOCtryObj argFocus ) {
		SecureJavaFXISOCtryAddPane retnew = new SecureJavaFXISOCtryAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureISOCtryObj argFocus ) {
		SecureJavaFXISOCtryViewEditPane retnew = new SecureJavaFXISOCtryViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureISOCtryObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXISOCtryAskDeleteForm retnew = new SecureJavaFXISOCtryAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXISOCtryFinderForm retnew = new SecureJavaFXISOCtryFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureISOCtryObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOCtryObj> argDataCollection,
		ISecureJavaFXISOCtryChosen whenChosen )
	{
		SecureJavaFXISOCtryPickerForm retnew = new SecureJavaFXISOCtryPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureISOCtryObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXISOCtryAddForm retnew = new SecureJavaFXISOCtryAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureISOCtryObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXISOCtryViewEditForm retnew = new SecureJavaFXISOCtryViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
