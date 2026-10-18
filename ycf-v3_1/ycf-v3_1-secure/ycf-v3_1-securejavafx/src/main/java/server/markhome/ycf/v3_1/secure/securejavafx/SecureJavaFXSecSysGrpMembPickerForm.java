// Description: Java 25 JavaFX Picker Form implementation for SecSysGrpMemb.

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
 *	SecureJavaFXSecSysGrpMembPickerForm JavaFX Picker Form implementation
 *	for SecSysGrpMemb.
 */
public class SecureJavaFXSecSysGrpMembPickerForm
extends YCFBorderPane
implements ISecureJavaFXSecSysGrpMembPaneList,
	IYCFForm
{
	protected IYCFFormManager ycfFormManager = null;
	protected YCFBorderPane javafxPickerPane = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected ISecureJavaFXSecSysGrpMembPageCallback pageCallback;
	protected YCFButton buttonRefresh = null;
	protected YCFButton buttonMoreData = null;
	protected boolean endOfData = true;

	public SecureJavaFXSecSysGrpMembPickerForm( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecSysGrpMembObj argFocus,
		ISecureSecSysGrpObj argContainer,
		ISecureJavaFXSecSysGrpMembPageCallback argPageCallback,
		ISecureJavaFXSecSysGrpMembChosen whenChosen )
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
		javafxPickerPane = argSchema.getSecSysGrpMembFactory().newPickerPane( ycfFormManager, argFocus, argContainer, argPageCallback, whenChosen );
		setJavaFXFocusAsSecSysGrpMemb( argFocus );
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
		if( ( value == null ) || ( value instanceof ISecureSecSysGrpMembObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysGrpMembObj" );
		}
		((ISecureJavaFXSecSysGrpMembPaneCommon)javafxPickerPane).setJavaFXFocus( (ISecureSecSysGrpMembObj)value );
	}

	public ISecureSecSysGrpMembObj getJavaFXFocusAsSecSysGrpMemb() {
		return( (ISecureSecSysGrpMembObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecSysGrpMemb( ISecureSecSysGrpMembObj value ) {
		setJavaFXFocus( value );
	}

	public Collection<ISecureSecSysGrpMembObj> getJavaFXDataCollection() {
		ISecureJavaFXSecSysGrpMembPaneList jplPicker = (ISecureJavaFXSecSysGrpMembPaneList)javafxPickerPane;
		Collection<ISecureSecSysGrpMembObj> cltn = jplPicker.getJavaFXDataCollection();
		return( cltn );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecSysGrpMembObj> value ) {
		ISecureJavaFXSecSysGrpMembPaneList jplPicker = (ISecureJavaFXSecSysGrpMembPaneList)javafxPickerPane;
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
			ISecureJavaFXSecSysGrpMembPaneCommon jpanelCommon = (ISecureJavaFXSecSysGrpMembPaneCommon)javafxPickerPane;
			jpanelCommon.setPaneMode( value );
		}
	}

	public ISecureSecSysGrpObj getJavaFXContainer() {
		ISecureJavaFXSecSysGrpMembPaneList jplPicker = (ISecureJavaFXSecSysGrpMembPaneList)javafxPickerPane;
		ISecureSecSysGrpObj cnt = jplPicker.getJavaFXContainer();
		return( cnt );
	}

	public void setJavaFXContainer( ISecureSecSysGrpObj value ) {
		ISecureJavaFXSecSysGrpMembPaneList jplPicker = (ISecureJavaFXSecSysGrpMembPaneList)javafxPickerPane;
		jplPicker.setJavaFXContainer( value );
	}
}
