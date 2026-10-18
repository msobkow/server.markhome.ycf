// Description: Java 25 JavaFX Add Pane implementation for TopDomain.

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
 *	IntNetJavaFXTopDomainAddPane JavaFX Add Pane implementation
 *	for TopDomain.
 */
public class IntNetJavaFXTopDomainAddPane
extends YCFSplitPane
implements IIntNetJavaFXTopDomainPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected ScrollPane attrScrollPane = null;
	protected YCFGridPane attrPane = null;

	public IntNetJavaFXTopDomainAddPane( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema, IIntNetTopDomainObj argFocus ) {
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
		attrPane = argSchema.getTopDomainFactory().newAttrPane( ycfFormManager, argFocus );
		attrScrollPane = new ScrollPane( attrPane );
		attrScrollPane.setFitToWidth( true );
		attrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
		attrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		attrScrollPane.setContent( attrPane );
		setOrientation( Orientation.VERTICAL );
		getItems().add( attrScrollPane );
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

	public IYCFLibAnyObj getJavaFXFocus() {
		IYCFLibAnyObj obj;
		if( attrPane != null ) {
			obj = attrPane.getJavaFXFocus();
		}
		else {
			obj = null;
		}
		return( obj );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IIntNetTopDomainObj ) ) {
			super.setJavaFXFocus( value );
			if( ( attrPane != null ) && ( attrPane.getJavaFXFocus() != value ) ) {
				attrPane.setJavaFXFocus( value );
			}
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetTopDomainObj" );
		}
	}

	public void setJavaFXFocusAsTopDomain( IIntNetTopDomainObj value ) {
		setJavaFXFocus( value );
	}

	public IIntNetTopDomainObj getJavaFXFocusAsTopDomain() {
		return( (IIntNetTopDomainObj)getJavaFXFocus() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldValue = getPaneMode();
		if( value == oldValue ) {
			return;
		}
		try {
			super.setPaneMode( value );
			((IIntNetJavaFXTopDomainPaneCommon)attrPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldValue );
			((IIntNetJavaFXTopDomainPaneCommon)attrPane).setPaneMode( oldValue );
			throw t;
		}
	}
}
