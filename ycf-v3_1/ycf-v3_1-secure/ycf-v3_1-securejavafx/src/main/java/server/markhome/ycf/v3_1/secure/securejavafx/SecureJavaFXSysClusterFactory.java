// Description: Java 25 JavaFX Display Element Factory for SysCluster.

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
 *	SecureJavaFXSysClusterFactory JavaFX Display Element Factory
 *	for SysCluster.
 */
public class SecureJavaFXSysClusterFactory
implements ISecureJavaFXSysClusterFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXSysClusterFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSysClusterObj argFocus ) {
		SecureJavaFXSysClusterAttrPane retnew = new SecureJavaFXSysClusterAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureClusterObj argContainer,
		ISecureSysClusterObj argFocus,
		Collection<ISecureSysClusterObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXSysClusterListPane retnew = new SecureJavaFXSysClusterListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSysClusterObj argFocus,
		ISecureClusterObj argContainer,
		Collection<ISecureSysClusterObj> argDataCollection,
		ISecureJavaFXSysClusterChosen whenChosen )
	{
		SecureJavaFXSysClusterPickerPane retnew = new SecureJavaFXSysClusterPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureSysClusterObj argFocus ) {
		SecureJavaFXSysClusterEltTabPane retnew = new SecureJavaFXSysClusterEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureSysClusterObj argFocus ) {
		SecureJavaFXSysClusterAddPane retnew = new SecureJavaFXSysClusterAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureSysClusterObj argFocus ) {
		SecureJavaFXSysClusterViewEditPane retnew = new SecureJavaFXSysClusterViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSysClusterObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXSysClusterAskDeleteForm retnew = new SecureJavaFXSysClusterAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXSysClusterFinderForm retnew = new SecureJavaFXSysClusterFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSysClusterObj argFocus,
		ISecureClusterObj argContainer,
		Collection<ISecureSysClusterObj> argDataCollection,
		ISecureJavaFXSysClusterChosen whenChosen )
	{
		SecureJavaFXSysClusterPickerForm retnew = new SecureJavaFXSysClusterPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSysClusterObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXSysClusterAddForm retnew = new SecureJavaFXSysClusterAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSysClusterObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXSysClusterViewEditForm retnew = new SecureJavaFXSysClusterViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
