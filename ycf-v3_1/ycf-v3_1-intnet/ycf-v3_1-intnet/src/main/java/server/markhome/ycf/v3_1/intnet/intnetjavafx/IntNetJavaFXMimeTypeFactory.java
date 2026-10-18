// Description: Java 25 JavaFX Display Element Factory for MimeType.

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
 *	IntNetJavaFXMimeTypeFactory JavaFX Display Element Factory
 *	for MimeType.
 */
public class IntNetJavaFXMimeTypeFactory
implements IIntNetJavaFXMimeTypeFactory
{
	protected IIntNetJavaFXSchema javafxSchema = null;

	public IntNetJavaFXMimeTypeFactory( IIntNetJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus ) {
		IntNetJavaFXMimeTypeAttrPane retnew = new IntNetJavaFXMimeTypeAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		IIntNetMimeTypeObj argFocus,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		IntNetJavaFXMimeTypeListPane retnew = new IntNetJavaFXMimeTypeListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetMimeTypeObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IIntNetJavaFXMimeTypeChosen whenChosen )
	{
		IntNetJavaFXMimeTypePickerPane retnew = new IntNetJavaFXMimeTypePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus ) {
		IntNetJavaFXMimeTypeEltTabPane retnew = new IntNetJavaFXMimeTypeEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus ) {
		IntNetJavaFXMimeTypeAddPane retnew = new IntNetJavaFXMimeTypeAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus ) {
		IntNetJavaFXMimeTypeViewEditPane retnew = new IntNetJavaFXMimeTypeViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus, IYCFDeleteCallback callback ) {
		IntNetJavaFXMimeTypeAskDeleteForm retnew = new IntNetJavaFXMimeTypeAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		IntNetJavaFXMimeTypeFinderForm retnew = new IntNetJavaFXMimeTypeFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetMimeTypeObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IIntNetJavaFXMimeTypeChosen whenChosen )
	{
		IntNetJavaFXMimeTypePickerForm retnew = new IntNetJavaFXMimeTypePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		IntNetJavaFXMimeTypeAddForm retnew = new IntNetJavaFXMimeTypeAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetMimeTypeObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		IntNetJavaFXMimeTypeViewEditForm retnew = new IntNetJavaFXMimeTypeViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
