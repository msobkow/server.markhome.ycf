// Description: Java 25 JavaFX Display Element Factory for MajorVersion.

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
 *	IntNetJavaFXMajorVersionFactory JavaFX Display Element Factory
 *	for MajorVersion.
 */
public class IntNetJavaFXMajorVersionFactory
implements IIntNetJavaFXMajorVersionFactory
{
	protected IIntNetJavaFXSchema javafxSchema = null;

	public IntNetJavaFXMajorVersionFactory( IIntNetJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus ) {
		IntNetJavaFXMajorVersionAttrPane retnew = new IntNetJavaFXMajorVersionAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetSubProjectObj argContainer,
		IIntNetMajorVersionObj argFocus,
		Collection<IIntNetMajorVersionObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		IntNetJavaFXMajorVersionListPane retnew = new IntNetJavaFXMajorVersionListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetMajorVersionObj argFocus,
		IIntNetSubProjectObj argContainer,
		Collection<IIntNetMajorVersionObj> argDataCollection,
		IIntNetJavaFXMajorVersionChosen whenChosen )
	{
		IntNetJavaFXMajorVersionPickerPane retnew = new IntNetJavaFXMajorVersionPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus ) {
		IntNetJavaFXMajorVersionEltTabPane retnew = new IntNetJavaFXMajorVersionEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus ) {
		IntNetJavaFXMajorVersionAddPane retnew = new IntNetJavaFXMajorVersionAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus ) {
		IntNetJavaFXMajorVersionViewEditPane retnew = new IntNetJavaFXMajorVersionViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus, IYCFDeleteCallback callback ) {
		IntNetJavaFXMajorVersionAskDeleteForm retnew = new IntNetJavaFXMajorVersionAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetMajorVersionObj argFocus,
		IIntNetSubProjectObj argContainer,
		Collection<IIntNetMajorVersionObj> argDataCollection,
		IIntNetJavaFXMajorVersionChosen whenChosen )
	{
		IntNetJavaFXMajorVersionPickerForm retnew = new IntNetJavaFXMajorVersionPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		IntNetJavaFXMajorVersionAddForm retnew = new IntNetJavaFXMajorVersionAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetMajorVersionObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		IntNetJavaFXMajorVersionViewEditForm retnew = new IntNetJavaFXMajorVersionViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
