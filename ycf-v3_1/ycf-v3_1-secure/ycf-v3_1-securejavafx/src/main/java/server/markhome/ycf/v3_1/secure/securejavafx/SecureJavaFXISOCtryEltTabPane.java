// Description: Java 25 JavaFX Element TabPane implementation for ISOCtry.

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
 *	SecureJavaFXISOCtryEltTabPane JavaFX Element TabPane implementation
 *	for ISOCtry.
 */
public class SecureJavaFXISOCtryEltTabPane
extends YCFTabPane
implements ISecureJavaFXISOCtryPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsCcyList = "Optional Components Ccy";
	protected YCFTab tabComponentsCcy = null;
	public final String LABEL_TabComponentsLangList = "Optional Components Lang";
	protected YCFTab tabComponentsLang = null;
	protected YCFBorderPane tabViewComponentsCcyListPane = null;
	protected YCFBorderPane tabViewComponentsLangListPane = null;

	public SecureJavaFXISOCtryEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureISOCtryObj argFocus ) {
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
		setJavaFXFocusAsISOCtry( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsCcy = new YCFTab();
		tabComponentsCcy.setText( LABEL_TabComponentsCcyList );
		tabComponentsCcy.setContent( getTabViewComponentsCcyListPane() );
		getTabs().add( tabComponentsCcy );
		tabComponentsLang = new YCFTab();
		tabComponentsLang.setText( LABEL_TabComponentsLangList );
		tabComponentsLang.setContent( getTabViewComponentsLangListPane() );
		getTabs().add( tabComponentsLang );
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
		if( ( value == null ) || ( value instanceof ISecureISOCtryObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOCtryObj" );
		}
	}

	public void setJavaFXFocusAsISOCtry( ISecureISOCtryObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureISOCtryObj getJavaFXFocusAsISOCtry() {
		return( (ISecureISOCtryObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsCcyList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsCcyList() {
		}

		public void refreshMe() {
			Collection<ISecureISOCtryCcyObj> dataCollection;
			ISecureISOCtryObj focus = (ISecureISOCtryObj)getJavaFXFocusAsISOCtry();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsCcy( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsCcyListPane();
			ISecureJavaFXISOCtryCcyPaneList jpList = (ISecureJavaFXISOCtryCcyPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsCcyListPane() {
		if( tabViewComponentsCcyListPane == null ) {
			ISecureISOCtryObj focus = (ISecureISOCtryObj)getJavaFXFocusAsISOCtry();
			Collection<ISecureISOCtryCcyObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsCcy( javafxIsInitializing );
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
			tabViewComponentsCcyListPane = javafxSchema.getISOCtryCcyFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsCcyList(), false );
		}
		return( tabViewComponentsCcyListPane );
	}

	protected class RefreshComponentsLangList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsLangList() {
		}

		public void refreshMe() {
			Collection<ISecureISOCtryLangObj> dataCollection;
			ISecureISOCtryObj focus = (ISecureISOCtryObj)getJavaFXFocusAsISOCtry();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsLang( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsLangListPane();
			ISecureJavaFXISOCtryLangPaneList jpList = (ISecureJavaFXISOCtryLangPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsLangListPane() {
		if( tabViewComponentsLangListPane == null ) {
			ISecureISOCtryObj focus = (ISecureISOCtryObj)getJavaFXFocusAsISOCtry();
			Collection<ISecureISOCtryLangObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsLang( javafxIsInitializing );
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
			tabViewComponentsLangListPane = javafxSchema.getISOCtryLangFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsLangList(), false );
		}
		return( tabViewComponentsLangListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsCcyListPane != null ) {
			((ISecureJavaFXISOCtryCcyPaneCommon)tabViewComponentsCcyListPane).setPaneMode( value );
		}
		if( tabViewComponentsLangListPane != null ) {
			((ISecureJavaFXISOCtryLangPaneCommon)tabViewComponentsLangListPane).setPaneMode( value );
		}
	}
}
