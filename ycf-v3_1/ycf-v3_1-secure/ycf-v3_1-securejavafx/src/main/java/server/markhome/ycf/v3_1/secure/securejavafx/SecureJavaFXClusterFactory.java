// Description: Java 25 JavaFX Display Element Factory for Cluster.

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
 *	SecureJavaFXClusterFactory JavaFX Display Element Factory
 *	for Cluster.
 */
public class SecureJavaFXClusterFactory
implements ISecureJavaFXClusterFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXClusterFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureClusterObj argFocus ) {
		SecureJavaFXClusterAttrPane retnew = new SecureJavaFXClusterAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureClusterObj argFocus,
		ISecureJavaFXClusterPageCallback argPageCallback,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXClusterListPane retnew = new SecureJavaFXClusterListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureClusterObj argFocus,
		IYCFLibAnyObj argContainer,
		ISecureJavaFXClusterPageCallback argPageCallback,
		ISecureJavaFXClusterChosen whenChosen )
	{
		SecureJavaFXClusterPickerPane retnew = new SecureJavaFXClusterPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureClusterObj argFocus ) {
		SecureJavaFXClusterEltTabPane retnew = new SecureJavaFXClusterEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureClusterObj argFocus ) {
		SecureJavaFXClusterAddPane retnew = new SecureJavaFXClusterAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureClusterObj argFocus ) {
		SecureJavaFXClusterViewEditPane retnew = new SecureJavaFXClusterViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureClusterObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXClusterAskDeleteForm retnew = new SecureJavaFXClusterAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXClusterFinderForm retnew = new SecureJavaFXClusterFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureClusterObj argFocus,
		IYCFLibAnyObj argContainer,
		ISecureJavaFXClusterPageCallback argPageCallback,
		ISecureJavaFXClusterChosen whenChosen )
	{
		SecureJavaFXClusterPickerForm retnew = new SecureJavaFXClusterPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureClusterObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXClusterAddForm retnew = new SecureJavaFXClusterAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureClusterObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXClusterViewEditForm retnew = new SecureJavaFXClusterViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
