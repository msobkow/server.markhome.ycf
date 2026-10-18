// Description: Java 25 JavaFX Picker Form implementation for UInt64Def.

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
 *	BusModelJavaFXUInt64DefPickerForm JavaFX Picker Form implementation
 *	for UInt64Def.
 */
public class BusModelJavaFXUInt64DefPickerForm
extends YCFBorderPane
implements IBusModelJavaFXUInt64DefPaneList,
	IYCFForm
{
	protected IYCFFormManager ycfFormManager = null;
	protected YCFBorderPane javafxPickerPane = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelUInt64DefObj> javafxDataCollection = null;

	public BusModelJavaFXUInt64DefPickerForm( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelUInt64DefObj argFocus,
		IBusModelScopeObj argContainer,
		Collection<IBusModelUInt64DefObj> argDataCollection,
		IBusModelJavaFXUInt64DefChosen whenChosen )
	{
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		ycfFormManager = formManager;
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argSchema" );
		}
		if( whenChosen == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javafxPickerPane = argSchema.getUInt64DefFactory().newPickerPane( ycfFormManager, argFocus, argContainer, argDataCollection, whenChosen );
		setJavaFXFocusAsUInt64Def( argFocus );
		setJavaFXDataCollection( argDataCollection );
		setJavaFXContainer( argContainer );
		setCenter( javafxPickerPane );
		setPaneMode( YCFPane.PaneMode.View );
	}

	public IYCFFormManager getYCFFormManager() {
		return( ycfFormManager );
	}

	public void setYCFFormManager( IYCFFormManager value ) {
		final String S_ProcName = "setYCFFormManager";
		if( value == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		ycfFormManager = value;
	}

	public void forceCancelAndClose() {
		if( ycfFormManager != null ) {
			if( ycfFormManager.getCurrentForm() == this ) {
				ycfFormManager.closeCurrentForm();
			}
		}
	}

	public IBusModelJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelUInt64DefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelUInt64DefObj" );
		}
		((IBusModelJavaFXUInt64DefPaneCommon)javafxPickerPane).setJavaFXFocus( (IBusModelUInt64DefObj)value );
	}

	public IBusModelUInt64DefObj getJavaFXFocusAsUInt64Def() {
		return( (IBusModelUInt64DefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsUInt64Def( IBusModelUInt64DefObj value ) {
		setJavaFXFocus( value );
	}

	public Collection<IBusModelUInt64DefObj> getJavaFXDataCollection() {
		IBusModelJavaFXUInt64DefPaneList jplPicker = (IBusModelJavaFXUInt64DefPaneList)javafxPickerPane;
		Collection<IBusModelUInt64DefObj> cltn = jplPicker.getJavaFXDataCollection();
		return( cltn );
	}

	public void setJavaFXDataCollection( Collection<IBusModelUInt64DefObj> value ) {
		IBusModelJavaFXUInt64DefPaneList jplPicker = (IBusModelJavaFXUInt64DefPaneList)javafxPickerPane;
		jplPicker.setJavaFXDataCollection( value );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		if( value != YCFPane.PaneMode.View ) {
			throw new YCFLibUsageException( getClass(),
				S_ProcName,
				Inz.x("ycflibjavafx.common.PickerFormModes"),
				Inz.s("ycflibjavafx.common.PickerFormModes") );
		}
		super.setPaneMode( value );
		if( javafxPickerPane != null ) {
			IBusModelJavaFXUInt64DefPaneCommon jpanelCommon = (IBusModelJavaFXUInt64DefPaneCommon)javafxPickerPane;
			jpanelCommon.setPaneMode( value );
		}
	}

	public IBusModelScopeObj getJavaFXContainer() {
		IBusModelJavaFXUInt64DefPaneList jplPicker = (IBusModelJavaFXUInt64DefPaneList)javafxPickerPane;
		IBusModelScopeObj cnt = jplPicker.getJavaFXContainer();
		return( cnt );
	}

	public void setJavaFXContainer( IBusModelScopeObj value ) {
		IBusModelJavaFXUInt64DefPaneList jplPicker = (IBusModelJavaFXUInt64DefPaneList)javafxPickerPane;
		jplPicker.setJavaFXContainer( value );
	}
}
