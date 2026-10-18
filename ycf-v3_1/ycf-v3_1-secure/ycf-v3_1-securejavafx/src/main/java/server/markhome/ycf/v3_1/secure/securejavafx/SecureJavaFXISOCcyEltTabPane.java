// Description: Java 25 JavaFX Element TabPane implementation for ISOCcy.

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
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXISOCcyEltTabPane JavaFX Element TabPane implementation
 *	for ISOCcy.
 */
public class SecureJavaFXISOCcyEltTabPane
extends YCFTabPane
implements ISecureJavaFXISOCcyPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabChildrenCtryList = "Optional Children Ctry";
	protected YCFTab tabChildrenCtry = null;
	protected YCFBorderPane tabViewChildrenCtryListPane = null;

	public SecureJavaFXISOCcyEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureISOCcyObj argFocus ) {
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
		setJavaFXFocusAsISOCcy( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabChildrenCtry = new YCFTab();
		tabChildrenCtry.setText( LABEL_TabChildrenCtryList );
		tabChildrenCtry.setContent( getTabViewChildrenCtryListPane() );
		getTabs().add( tabChildrenCtry );
		javafxIsInitializing = false;
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

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureISOCcyObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOCcyObj" );
		}
	}

	public void setJavaFXFocusAsISOCcy( ISecureISOCcyObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureISOCcyObj getJavaFXFocusAsISOCcy() {
		return( (ISecureISOCcyObj)getJavaFXFocus() );
	}

	protected class RefreshChildrenCtryList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenCtryList() {
		}

		public void refreshMe() {
			Collection<ISecureISOCtryCcyObj> dataCollection;
			ISecureISOCcyObj focus = (ISecureISOCcyObj)getJavaFXFocusAsISOCcy();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenCtry( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewChildrenCtryListPane();
			ISecureJavaFXISOCtryCcyPaneList jpList = (ISecureJavaFXISOCtryCcyPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewChildrenCtryListPane() {
		if( tabViewChildrenCtryListPane == null ) {
			ISecureISOCcyObj focus = (ISecureISOCcyObj)getJavaFXFocusAsISOCcy();
			Collection<ISecureISOCtryCcyObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenCtry( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ISecureISOCtryObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureISOCtryObj ) ) {
				javafxContainer = (ISecureISOCtryObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenCtryListPane = javafxSchema.getISOCtryCcyFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshChildrenCtryList(), false );
		}
		return( tabViewChildrenCtryListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewChildrenCtryListPane != null ) {
			((ISecureJavaFXISOCtryCcyPaneCommon)tabViewChildrenCtryListPane).setPaneMode( value );
		}
	}
}
