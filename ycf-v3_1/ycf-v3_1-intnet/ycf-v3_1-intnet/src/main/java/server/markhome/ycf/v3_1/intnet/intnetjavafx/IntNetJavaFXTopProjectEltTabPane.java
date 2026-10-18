// Description: Java 25 JavaFX Element TabPane implementation for TopProject.

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
 *	IntNetJavaFXTopProjectEltTabPane JavaFX Element TabPane implementation
 *	for TopProject.
 */
public class IntNetJavaFXTopProjectEltTabPane
extends YCFTabPane
implements IIntNetJavaFXTopProjectPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsSubProjectList = "Optional Components Sub Project";
	protected YCFTab tabComponentsSubProject = null;
	protected YCFBorderPane tabViewComponentsSubProjectListPane = null;

	public IntNetJavaFXTopProjectEltTabPane( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema, IIntNetTopProjectObj argFocus ) {
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
		setJavaFXFocusAsTopProject( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsSubProject = new YCFTab();
		tabComponentsSubProject.setText( LABEL_TabComponentsSubProjectList );
		tabComponentsSubProject.setContent( getTabViewComponentsSubProjectListPane() );
		getTabs().add( tabComponentsSubProject );
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
		if( ( value == null ) || ( value instanceof IIntNetTopProjectObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetTopProjectObj" );
		}
	}

	public void setJavaFXFocusAsTopProject( IIntNetTopProjectObj value ) {
		setJavaFXFocus( value );
	}

	public IIntNetTopProjectObj getJavaFXFocusAsTopProject() {
		return( (IIntNetTopProjectObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsSubProjectList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSubProjectList() {
		}

		public void refreshMe() {
			Collection<IIntNetSubProjectObj> dataCollection;
			IIntNetTopProjectObj focus = (IIntNetTopProjectObj)getJavaFXFocusAsTopProject();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSubProject( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSubProjectListPane();
			IIntNetJavaFXSubProjectPaneList jpList = (IIntNetJavaFXSubProjectPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSubProjectListPane() {
		if( tabViewComponentsSubProjectListPane == null ) {
			IIntNetTopProjectObj focus = (IIntNetTopProjectObj)getJavaFXFocusAsTopProject();
			Collection<IIntNetSubProjectObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSubProject( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IIntNetTopProjectObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IIntNetTopProjectObj ) ) {
				javafxContainer = (IIntNetTopProjectObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSubProjectListPane = javafxSchema.getSubProjectFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSubProjectList(), false );
		}
		return( tabViewComponentsSubProjectListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsSubProjectListPane != null ) {
			((IIntNetJavaFXSubProjectPaneCommon)tabViewComponentsSubProjectListPane).setPaneMode( value );
		}
	}
}
