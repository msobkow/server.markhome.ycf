// Description: Java 25 JavaFX View/Edit Pane implementation for MajorVersion.

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
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
 *	IntNetJavaFXMajorVersionViewEditPane JavaFX View/Edit Pane implementation
 *	for MajorVersion.
 */
public class IntNetJavaFXMajorVersionViewEditPane
extends YCFSplitPane
implements IIntNetJavaFXMajorVersionPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected ScrollPane attrScrollPane = null;
	protected YCFGridPane attrPane = null;
	protected YCFTabPane eltTabPane = null;

	public IntNetJavaFXMajorVersionViewEditPane( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema, IIntNetMajorVersionObj argFocus ) {
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
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		setJavaFXFocus( argFocus );
		attrPane = argSchema.getMajorVersionFactory().newAttrPane( ycfFormManager, argFocus );
		attrScrollPane = new ScrollPane();
		attrScrollPane.setFitToWidth( true );
		attrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
		attrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		attrScrollPane.setContent( attrPane );
		eltTabPane = argSchema.getMajorVersionFactory().newEltTabPane( ycfFormManager, argFocus );
		setOrientation( Orientation.VERTICAL );
		getItems().add( attrScrollPane );
		getItems().add( eltTabPane );
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IIntNetMajorVersionObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetMajorVersionObj" );
		}
		if( attrPane != null ) {
			attrPane.setJavaFXFocus( value );
		}
		if( eltTabPane != null ) {
			eltTabPane.setJavaFXFocus( value );
		}
	}

	public void setJavaFXFocusAsMajorVersion( IIntNetMajorVersionObj value ) {
		setJavaFXFocus( value );
	}

	public IIntNetMajorVersionObj getJavaFXFocusAsMajorVersion() {
		return( (IIntNetMajorVersionObj)getJavaFXFocus() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		if( oldMode == value ) {
			return;
		}
		try {
			super.setPaneMode( value );
			((IIntNetJavaFXMajorVersionPaneCommon)attrPane).setPaneMode( value );
			((IIntNetJavaFXMajorVersionPaneCommon)eltTabPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldMode );
			((IIntNetJavaFXMajorVersionPaneCommon)attrPane).setPaneMode( oldMode );
			((IIntNetJavaFXMajorVersionPaneCommon)eltTabPane).setPaneMode( oldMode );
			throw t;
		}
	}
}
