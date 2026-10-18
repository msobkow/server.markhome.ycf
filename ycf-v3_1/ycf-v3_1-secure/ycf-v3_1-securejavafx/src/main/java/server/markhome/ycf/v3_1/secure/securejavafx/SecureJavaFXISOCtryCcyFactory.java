// Description: Java 25 JavaFX Display Element Factory for ISOCtryCcy.

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
 *	SecureJavaFXISOCtryCcyFactory JavaFX Display Element Factory
 *	for ISOCtryCcy.
 */
public class SecureJavaFXISOCtryCcyFactory
implements ISecureJavaFXISOCtryCcyFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXISOCtryCcyFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus ) {
		SecureJavaFXISOCtryCcyAttrPane retnew = new SecureJavaFXISOCtryCcyAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureISOCtryObj argContainer,
		ISecureISOCtryCcyObj argFocus,
		Collection<ISecureISOCtryCcyObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXISOCtryCcyListPane retnew = new SecureJavaFXISOCtryCcyListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureISOCtryCcyObj argFocus,
		ISecureISOCtryObj argContainer,
		Collection<ISecureISOCtryCcyObj> argDataCollection,
		ISecureJavaFXISOCtryCcyChosen whenChosen )
	{
		SecureJavaFXISOCtryCcyPickerPane retnew = new SecureJavaFXISOCtryCcyPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus ) {
		SecureJavaFXISOCtryCcyEltTabPane retnew = new SecureJavaFXISOCtryCcyEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus ) {
		SecureJavaFXISOCtryCcyAddPane retnew = new SecureJavaFXISOCtryCcyAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus ) {
		SecureJavaFXISOCtryCcyViewEditPane retnew = new SecureJavaFXISOCtryCcyViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXISOCtryCcyAskDeleteForm retnew = new SecureJavaFXISOCtryCcyAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureISOCtryCcyObj argFocus,
		ISecureISOCtryObj argContainer,
		Collection<ISecureISOCtryCcyObj> argDataCollection,
		ISecureJavaFXISOCtryCcyChosen whenChosen )
	{
		SecureJavaFXISOCtryCcyPickerForm retnew = new SecureJavaFXISOCtryCcyPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXISOCtryCcyAddForm retnew = new SecureJavaFXISOCtryCcyAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureISOCtryCcyObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXISOCtryCcyViewEditForm retnew = new SecureJavaFXISOCtryCcyViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
