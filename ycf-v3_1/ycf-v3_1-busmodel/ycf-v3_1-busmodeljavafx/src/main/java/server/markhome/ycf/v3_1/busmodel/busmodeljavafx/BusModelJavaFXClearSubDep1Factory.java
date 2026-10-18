// Description: Java 25 JavaFX Display Element Factory for ClearSubDep1.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/**
 *	BusModelJavaFXClearSubDep1Factory JavaFX Display Element Factory
 *	for ClearSubDep1.
 */
public class BusModelJavaFXClearSubDep1Factory
implements IBusModelJavaFXClearSubDep1Factory
{
	protected IBusModelJavaFXSchema javafxSchema = null;

	public BusModelJavaFXClearSubDep1Factory( IBusModelJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus ) {
		BusModelJavaFXClearSubDep1AttrPane retnew = new BusModelJavaFXClearSubDep1AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IBusModelClearTopDepObj argContainer,
		IBusModelClearSubDep1Obj argFocus,
		Collection<IBusModelClearSubDep1Obj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		BusModelJavaFXClearSubDep1ListPane retnew = new BusModelJavaFXClearSubDep1ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IBusModelClearSubDep1Obj argFocus,
		IBusModelClearTopDepObj argContainer,
		Collection<IBusModelClearSubDep1Obj> argDataCollection,
		IBusModelJavaFXClearSubDep1Chosen whenChosen )
	{
		BusModelJavaFXClearSubDep1PickerPane retnew = new BusModelJavaFXClearSubDep1PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus ) {
		BusModelJavaFXClearSubDep1EltTabPane retnew = new BusModelJavaFXClearSubDep1EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus ) {
		BusModelJavaFXClearSubDep1AddPane retnew = new BusModelJavaFXClearSubDep1AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus ) {
		BusModelJavaFXClearSubDep1ViewEditPane retnew = new BusModelJavaFXClearSubDep1ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus, IYCFDeleteCallback callback ) {
		BusModelJavaFXClearSubDep1AskDeleteForm retnew = new BusModelJavaFXClearSubDep1AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IBusModelClearSubDep1Obj argFocus,
		IBusModelClearTopDepObj argContainer,
		Collection<IBusModelClearSubDep1Obj> argDataCollection,
		IBusModelJavaFXClearSubDep1Chosen whenChosen )
	{
		BusModelJavaFXClearSubDep1PickerForm retnew = new BusModelJavaFXClearSubDep1PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		BusModelJavaFXClearSubDep1AddForm retnew = new BusModelJavaFXClearSubDep1AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IBusModelClearSubDep1Obj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		BusModelJavaFXClearSubDep1ViewEditForm retnew = new BusModelJavaFXClearSubDep1ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
