// Description: Java 25 JavaFX Element TabPane implementation for TopDomain.

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/**
 *	IntNetJavaFXTopDomainEltTabPane JavaFX Element TabPane implementation
 *	for TopDomain.
 */
public class IntNetJavaFXTopDomainEltTabPane
extends YCFTabPane
implements IIntNetJavaFXTopDomainPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsTopProjectList = "Optional Components Top Project";
	protected YCFTab tabComponentsTopProject = null;
	public final String LABEL_TabComponentsLicenseList = "Optional Components License";
	protected YCFTab tabComponentsLicense = null;
	protected YCFBorderPane tabViewComponentsTopProjectListPane = null;
	protected YCFBorderPane tabViewComponentsLicenseListPane = null;

	public IntNetJavaFXTopDomainEltTabPane( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema, IIntNetTopDomainObj argFocus ) {
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
		setJavaFXFocusAsTopDomain( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsTopProject = new YCFTab();
		tabComponentsTopProject.setText( LABEL_TabComponentsTopProjectList );
		tabComponentsTopProject.setContent( getTabViewComponentsTopProjectListPane() );
		getTabs().add( tabComponentsTopProject );
		tabComponentsLicense = new YCFTab();
		tabComponentsLicense.setText( LABEL_TabComponentsLicenseList );
		tabComponentsLicense.setContent( getTabViewComponentsLicenseListPane() );
		getTabs().add( tabComponentsLicense );
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IIntNetTopDomainObj ) ) {
			super.setJavaFXFocus( value );
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

	protected class RefreshComponentsTopProjectList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTopProjectList() {
		}

		public void refreshMe() {
			Collection<IIntNetTopProjectObj> dataCollection;
			IIntNetTopDomainObj focus = (IIntNetTopDomainObj)getJavaFXFocusAsTopDomain();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTopProject( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsTopProjectListPane();
			IIntNetJavaFXTopProjectPaneList jpList = (IIntNetJavaFXTopProjectPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsTopProjectListPane() {
		if( tabViewComponentsTopProjectListPane == null ) {
			IIntNetTopDomainObj focus = (IIntNetTopDomainObj)getJavaFXFocusAsTopDomain();
			Collection<IIntNetTopProjectObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTopProject( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IIntNetTopDomainObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IIntNetTopDomainObj ) ) {
				javafxContainer = (IIntNetTopDomainObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsTopProjectListPane = javafxSchema.getTopProjectFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsTopProjectList(), false );
		}
		return( tabViewComponentsTopProjectListPane );
	}

	protected class RefreshComponentsLicenseList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsLicenseList() {
		}

		public void refreshMe() {
			Collection<IIntNetLicenseObj> dataCollection;
			IIntNetTopDomainObj focus = (IIntNetTopDomainObj)getJavaFXFocusAsTopDomain();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsLicense( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsLicenseListPane();
			IIntNetJavaFXLicensePaneList jpList = (IIntNetJavaFXLicensePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsLicenseListPane() {
		if( tabViewComponentsLicenseListPane == null ) {
			IIntNetTopDomainObj focus = (IIntNetTopDomainObj)getJavaFXFocusAsTopDomain();
			Collection<IIntNetLicenseObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsLicense( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IIntNetTopDomainObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IIntNetTopDomainObj ) ) {
				javafxContainer = (IIntNetTopDomainObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsLicenseListPane = javafxSchema.getLicenseFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsLicenseList(), false );
		}
		return( tabViewComponentsLicenseListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsTopProjectListPane != null ) {
			((IIntNetJavaFXTopProjectPaneCommon)tabViewComponentsTopProjectListPane).setPaneMode( value );
		}
		if( tabViewComponentsLicenseListPane != null ) {
			((IIntNetJavaFXLicensePaneCommon)tabViewComponentsLicenseListPane).setPaneMode( value );
		}
	}
}
