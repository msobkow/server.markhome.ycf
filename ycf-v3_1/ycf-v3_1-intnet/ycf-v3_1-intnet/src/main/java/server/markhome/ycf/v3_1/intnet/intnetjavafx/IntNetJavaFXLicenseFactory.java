// Description: Java 25 JavaFX Display Element Factory for License.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetjavafx;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/**
 *	IntNetJavaFXLicenseFactory JavaFX Display Element Factory
 *	for License.
 */
public class IntNetJavaFXLicenseFactory
implements IIntNetJavaFXLicenseFactory
{
	protected IIntNetJavaFXSchema javafxSchema = null;

	public IntNetJavaFXLicenseFactory( IIntNetJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetLicenseObj argFocus ) {
		IntNetJavaFXLicenseAttrPane retnew = new IntNetJavaFXLicenseAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetTopDomainObj argContainer,
		IIntNetLicenseObj argFocus,
		Collection<IIntNetLicenseObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		IntNetJavaFXLicenseListPane retnew = new IntNetJavaFXLicenseListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetLicenseObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetLicenseObj> argDataCollection,
		IIntNetJavaFXLicenseChosen whenChosen )
	{
		IntNetJavaFXLicensePickerPane retnew = new IntNetJavaFXLicensePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IIntNetLicenseObj argFocus ) {
		IntNetJavaFXLicenseEltTabPane retnew = new IntNetJavaFXLicenseEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IIntNetLicenseObj argFocus ) {
		IntNetJavaFXLicenseAddPane retnew = new IntNetJavaFXLicenseAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IIntNetLicenseObj argFocus ) {
		IntNetJavaFXLicenseViewEditPane retnew = new IntNetJavaFXLicenseViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetLicenseObj argFocus, IYCFDeleteCallback callback ) {
		IntNetJavaFXLicenseAskDeleteForm retnew = new IntNetJavaFXLicenseAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetLicenseObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetLicenseObj> argDataCollection,
		IIntNetJavaFXLicenseChosen whenChosen )
	{
		IntNetJavaFXLicensePickerForm retnew = new IntNetJavaFXLicensePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetLicenseObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		IntNetJavaFXLicenseAddForm retnew = new IntNetJavaFXLicenseAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetLicenseObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		IntNetJavaFXLicenseViewEditForm retnew = new IntNetJavaFXLicenseViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
