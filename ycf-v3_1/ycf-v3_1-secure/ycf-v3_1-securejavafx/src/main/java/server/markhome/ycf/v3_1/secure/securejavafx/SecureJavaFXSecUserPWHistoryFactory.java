// Description: Java 25 JavaFX Display Element Factory for SecUserPWHistory.

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
 *	SecureJavaFXSecUserPWHistoryFactory JavaFX Display Element Factory
 *	for SecUserPWHistory.
 */
public class SecureJavaFXSecUserPWHistoryFactory
implements ISecureJavaFXSecUserPWHistoryFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSecUserPWHistoryFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus ) {
		SecureJavaFXSecUserPWHistoryAttrPane retnew = new SecureJavaFXSecUserPWHistoryAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureSecUserPWHistoryObj argFocus,
		ISecureJavaFXSecUserPWHistoryPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSecUserPWHistoryListPane retnew = new SecureJavaFXSecUserPWHistoryListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecUserPWHistoryObj argFocus,
		IYCFLibAnyObj argContainer,
		ISecureJavaFXSecUserPWHistoryPageCallback argPageCallback,
		ISecureJavaFXSecUserPWHistoryChosen whenChosen )
	{
		SecureJavaFXSecUserPWHistoryPickerPane retnew = new SecureJavaFXSecUserPWHistoryPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus ) {
		SecureJavaFXSecUserPWHistoryEltTabPane retnew = new SecureJavaFXSecUserPWHistoryEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus ) {
		SecureJavaFXSecUserPWHistoryAddPane retnew = new SecureJavaFXSecUserPWHistoryAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus ) {
		SecureJavaFXSecUserPWHistoryViewEditPane retnew = new SecureJavaFXSecUserPWHistoryViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSecUserPWHistoryAskDeleteForm retnew = new SecureJavaFXSecUserPWHistoryAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXSecUserPWHistoryFinderForm retnew = new SecureJavaFXSecUserPWHistoryFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecUserPWHistoryObj argFocus,
		IYCFLibAnyObj argContainer,
		ISecureJavaFXSecUserPWHistoryPageCallback argPageCallback,
		ISecureJavaFXSecUserPWHistoryChosen whenChosen )
	{
		SecureJavaFXSecUserPWHistoryPickerForm retnew = new SecureJavaFXSecUserPWHistoryPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSecUserPWHistoryAddForm retnew = new SecureJavaFXSecUserPWHistoryAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecUserPWHistoryObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSecUserPWHistoryViewEditForm retnew = new SecureJavaFXSecUserPWHistoryViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
