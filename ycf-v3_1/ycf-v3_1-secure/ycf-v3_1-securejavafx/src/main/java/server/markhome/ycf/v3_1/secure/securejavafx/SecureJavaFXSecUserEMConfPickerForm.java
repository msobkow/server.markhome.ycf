// Description: Java 25 JavaFX Picker Form implementation for SecUserEMConf.

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
 *	SecureJavaFXSecUserEMConfPickerForm JavaFX Picker Form implementation
 *	for SecUserEMConf.
 */
public class SecureJavaFXSecUserEMConfPickerForm
extends YCFBorderPane
implements ISecureJavaFXSecUserEMConfPaneList,
	IYCFForm
{
	protected IYCFFormManager ycfFormManager = null;
	protected YCFBorderPane javafxPickerPane = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected ISecureJavaFXSecUserEMConfPageCallback pageCallback;
	protected YCFButton buttonRefresh = null;
	protected YCFButton buttonMoreData = null;
	protected boolean endOfData = true;

	public SecureJavaFXSecUserEMConfPickerForm( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecUserEMConfObj argFocus,
		ISecureSecUserObj argContainer,
		ISecureJavaFXSecUserEMConfPageCallback argPageCallback,
		ISecureJavaFXSecUserEMConfChosen whenChosen )
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
		javafxPickerPane = argSchema.getSecUserEMConfFactory().newPickerPane( ycfFormManager, argFocus, argContainer, argPageCallback, whenChosen );
		setJavaFXFocusAsSecUserEMConf( argFocus );
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

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureSecUserEMConfObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserEMConfObj" );
		}
		((ISecureJavaFXSecUserEMConfPaneCommon)javafxPickerPane).setJavaFXFocus( (ISecureSecUserEMConfObj)value );
	}

	public ISecureSecUserEMConfObj getJavaFXFocusAsSecUserEMConf() {
		return( (ISecureSecUserEMConfObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUserEMConf( ISecureSecUserEMConfObj value ) {
		setJavaFXFocus( value );
	}

	public Collection<ISecureSecUserEMConfObj> getJavaFXDataCollection() {
		ISecureJavaFXSecUserEMConfPaneList jplPicker = (ISecureJavaFXSecUserEMConfPaneList)javafxPickerPane;
		Collection<ISecureSecUserEMConfObj> cltn = jplPicker.getJavaFXDataCollection();
		return( cltn );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecUserEMConfObj> value ) {
		ISecureJavaFXSecUserEMConfPaneList jplPicker = (ISecureJavaFXSecUserEMConfPaneList)javafxPickerPane;
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
			ISecureJavaFXSecUserEMConfPaneCommon jpanelCommon = (ISecureJavaFXSecUserEMConfPaneCommon)javafxPickerPane;
			jpanelCommon.setPaneMode( value );
		}
	}

	public ISecureSecUserObj getJavaFXContainer() {
		ISecureJavaFXSecUserEMConfPaneList jplPicker = (ISecureJavaFXSecUserEMConfPaneList)javafxPickerPane;
		ISecureSecUserObj cnt = jplPicker.getJavaFXContainer();
		return( cnt );
	}

	public void setJavaFXContainer( ISecureSecUserObj value ) {
		ISecureJavaFXSecUserEMConfPaneList jplPicker = (ISecureJavaFXSecUserEMConfPaneList)javafxPickerPane;
		jplPicker.setJavaFXContainer( value );
	}
}
