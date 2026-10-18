// Description: Java 25 JavaFX Display Element Factory for TopProject.

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
 *	IntNetJavaFXTopProjectFactory JavaFX Display Element Factory
 *	for TopProject.
 */
public class IntNetJavaFXTopProjectFactory
implements IIntNetJavaFXTopProjectFactory
{
	protected IIntNetJavaFXSchema javafxSchema = null;

	public IntNetJavaFXTopProjectFactory( IIntNetJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetTopProjectObj argFocus ) {
		IntNetJavaFXTopProjectAttrPane retnew = new IntNetJavaFXTopProjectAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetTopDomainObj argContainer,
		IIntNetTopProjectObj argFocus,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		IntNetJavaFXTopProjectListPane retnew = new IntNetJavaFXTopProjectListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetTopProjectObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IIntNetJavaFXTopProjectChosen whenChosen )
	{
		IntNetJavaFXTopProjectPickerPane retnew = new IntNetJavaFXTopProjectPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IIntNetTopProjectObj argFocus ) {
		IntNetJavaFXTopProjectEltTabPane retnew = new IntNetJavaFXTopProjectEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IIntNetTopProjectObj argFocus ) {
		IntNetJavaFXTopProjectAddPane retnew = new IntNetJavaFXTopProjectAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IIntNetTopProjectObj argFocus ) {
		IntNetJavaFXTopProjectViewEditPane retnew = new IntNetJavaFXTopProjectViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetTopProjectObj argFocus, IYCFDeleteCallback callback ) {
		IntNetJavaFXTopProjectAskDeleteForm retnew = new IntNetJavaFXTopProjectAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetTopProjectObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IIntNetJavaFXTopProjectChosen whenChosen )
	{
		IntNetJavaFXTopProjectPickerForm retnew = new IntNetJavaFXTopProjectPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetTopProjectObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		IntNetJavaFXTopProjectAddForm retnew = new IntNetJavaFXTopProjectAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetTopProjectObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		IntNetJavaFXTopProjectViewEditForm retnew = new IntNetJavaFXTopProjectViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
