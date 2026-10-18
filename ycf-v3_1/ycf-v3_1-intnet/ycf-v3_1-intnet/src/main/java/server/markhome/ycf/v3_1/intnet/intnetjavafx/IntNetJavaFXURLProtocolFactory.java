// Description: Java 25 JavaFX Display Element Factory for URLProtocol.

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
 *	IntNetJavaFXURLProtocolFactory JavaFX Display Element Factory
 *	for URLProtocol.
 */
public class IntNetJavaFXURLProtocolFactory
implements IIntNetJavaFXURLProtocolFactory
{
	protected IIntNetJavaFXSchema javafxSchema = null;

	public IntNetJavaFXURLProtocolFactory( IIntNetJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus ) {
		IntNetJavaFXURLProtocolAttrPane retnew = new IntNetJavaFXURLProtocolAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		IIntNetURLProtocolObj argFocus,
		Collection<IIntNetURLProtocolObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		IntNetJavaFXURLProtocolListPane retnew = new IntNetJavaFXURLProtocolListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetURLProtocolObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetURLProtocolObj> argDataCollection,
		IIntNetJavaFXURLProtocolChosen whenChosen )
	{
		IntNetJavaFXURLProtocolPickerPane retnew = new IntNetJavaFXURLProtocolPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus ) {
		IntNetJavaFXURLProtocolEltTabPane retnew = new IntNetJavaFXURLProtocolEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus ) {
		IntNetJavaFXURLProtocolAddPane retnew = new IntNetJavaFXURLProtocolAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus ) {
		IntNetJavaFXURLProtocolViewEditPane retnew = new IntNetJavaFXURLProtocolViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus, IYCFDeleteCallback callback ) {
		IntNetJavaFXURLProtocolAskDeleteForm retnew = new IntNetJavaFXURLProtocolAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		IntNetJavaFXURLProtocolFinderForm retnew = new IntNetJavaFXURLProtocolFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetURLProtocolObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetURLProtocolObj> argDataCollection,
		IIntNetJavaFXURLProtocolChosen whenChosen )
	{
		IntNetJavaFXURLProtocolPickerForm retnew = new IntNetJavaFXURLProtocolPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		IntNetJavaFXURLProtocolAddForm retnew = new IntNetJavaFXURLProtocolAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetURLProtocolObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		IntNetJavaFXURLProtocolViewEditForm retnew = new IntNetJavaFXURLProtocolViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
