// Description: Java 25 JavaFX Element TabPane implementation for SecUser.

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
 *	SecureJavaFXSecUserEltTabPane JavaFX Element TabPane implementation
 *	for SecUser.
 */
public class SecureJavaFXSecUserEltTabPane
extends YCFTabPane
implements ISecureJavaFXSecUserPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsPasswordAttr = "Optional Components Password Singleton";
	protected YCFTab tabComponentsPassword = null;
	public final String LABEL_TabComponentsEMConfAttr = "Optional Components EMail Confirmation Singleton";
	protected YCFTab tabComponentsEMConf = null;
	public final String LABEL_TabComponentsPWResetAttr = "Optional Components Password Reset Singleton";
	protected YCFTab tabComponentsPWReset = null;
	public final String LABEL_TabChildrenPWHistoryAttr = "Optional Children Password History Entries";
	protected YCFTab tabChildrenPWHistory = null;
	public final String LABEL_TabComponentsSecSessList = "Optional Components Security Session";
	protected YCFTab tabComponentsSecSess = null;
	public final String LABEL_TabChildrenSecProxyList = "Optional Children Security Proxy Session";
	protected YCFTab tabChildrenSecProxy = null;
	public final String LABEL_TabChildrenSysSecGrpMembList = "Optional Children System Security Group Members";
	protected YCFTab tabChildrenSysSecGrpMemb = null;
	public final String LABEL_TabChildrenClusSecGrpMembList = "Optional Children Cluster Security Group Members";
	protected YCFTab tabChildrenClusSecGrpMemb = null;
	public final String LABEL_TabChildrenTentSecGrpMembList = "Optional Children Tenant Security Group Members";
	protected YCFTab tabChildrenTentSecGrpMemb = null;
	protected ScrollPane tabViewComponentsPasswordAttrScrollPane = null;
	protected YCFGridPane tabViewComponentsPasswordAttrPane = null;
	protected ScrollPane tabViewComponentsEMConfAttrScrollPane = null;
	protected YCFGridPane tabViewComponentsEMConfAttrPane = null;
	protected ScrollPane tabViewComponentsPWResetAttrScrollPane = null;
	protected YCFGridPane tabViewComponentsPWResetAttrPane = null;
	protected ScrollPane tabViewChildrenPWHistoryAttrScrollPane = null;
	protected YCFGridPane tabViewChildrenPWHistoryAttrPane = null;
	protected YCFBorderPane tabViewComponentsSecSessListPane = null;
	protected YCFBorderPane tabViewChildrenSecProxyListPane = null;
	protected YCFBorderPane tabViewChildrenSysSecGrpMembListPane = null;
	protected YCFBorderPane tabViewChildrenClusSecGrpMembListPane = null;
	protected YCFBorderPane tabViewChildrenTentSecGrpMembListPane = null;

	public SecureJavaFXSecUserEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecUserObj argFocus ) {
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
		setJavaFXFocusAsSecUser( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsPassword = new YCFTab();
		tabComponentsPassword.setText( LABEL_TabComponentsPasswordAttr );
		tabComponentsPassword.setContent( getTabViewComponentsPasswordAttrScrollPane() );
		getTabs().add( tabComponentsPassword );
		tabComponentsEMConf = new YCFTab();
		tabComponentsEMConf.setText( LABEL_TabComponentsEMConfAttr );
		tabComponentsEMConf.setContent( getTabViewComponentsEMConfAttrScrollPane() );
		getTabs().add( tabComponentsEMConf );
		tabComponentsPWReset = new YCFTab();
		tabComponentsPWReset.setText( LABEL_TabComponentsPWResetAttr );
		tabComponentsPWReset.setContent( getTabViewComponentsPWResetAttrScrollPane() );
		getTabs().add( tabComponentsPWReset );
		tabChildrenPWHistory = new YCFTab();
		tabChildrenPWHistory.setText( LABEL_TabChildrenPWHistoryAttr );
		tabChildrenPWHistory.setContent( getTabViewChildrenPWHistoryAttrScrollPane() );
		getTabs().add( tabChildrenPWHistory );
		tabComponentsSecSess = new YCFTab();
		tabComponentsSecSess.setText( LABEL_TabComponentsSecSessList );
		tabComponentsSecSess.setContent( getTabViewComponentsSecSessListPane() );
		getTabs().add( tabComponentsSecSess );
		tabChildrenSecProxy = new YCFTab();
		tabChildrenSecProxy.setText( LABEL_TabChildrenSecProxyList );
		tabChildrenSecProxy.setContent( getTabViewChildrenSecProxyListPane() );
		getTabs().add( tabChildrenSecProxy );
		tabChildrenSysSecGrpMemb = new YCFTab();
		tabChildrenSysSecGrpMemb.setText( LABEL_TabChildrenSysSecGrpMembList );
		tabChildrenSysSecGrpMemb.setContent( getTabViewChildrenSysSecGrpMembListPane() );
		getTabs().add( tabChildrenSysSecGrpMemb );
		tabChildrenClusSecGrpMemb = new YCFTab();
		tabChildrenClusSecGrpMemb.setText( LABEL_TabChildrenClusSecGrpMembList );
		tabChildrenClusSecGrpMemb.setContent( getTabViewChildrenClusSecGrpMembListPane() );
		getTabs().add( tabChildrenClusSecGrpMemb );
		tabChildrenTentSecGrpMemb = new YCFTab();
		tabChildrenTentSecGrpMemb.setText( LABEL_TabChildrenTentSecGrpMembList );
		tabChildrenTentSecGrpMemb.setContent( getTabViewChildrenTentSecGrpMembListPane() );
		getTabs().add( tabChildrenTentSecGrpMemb );
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
		if( ( value == null ) || ( value instanceof ISecureSecUserObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserObj" );
		}
	}

	public void setJavaFXFocusAsSecUser( ISecureSecUserObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecUserObj getJavaFXFocusAsSecUser() {
		return( (ISecureSecUserObj)getJavaFXFocus() );
	}

	public ScrollPane getTabViewComponentsPasswordAttrScrollPane() {
		if( tabViewComponentsPasswordAttrScrollPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserPasswordObj refPassword =
				( focus != null )
					? focus.getOptionalComponentsPassword()
					: null;
			tabViewComponentsPasswordAttrPane = javafxSchema.getSecUserPasswordFactory().newAttrPane( ycfFormManager, refPassword );
			tabViewComponentsPasswordAttrScrollPane = new ScrollPane();
			tabViewComponentsPasswordAttrScrollPane.setFitToWidth( true );
			tabViewComponentsPasswordAttrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
			tabViewComponentsPasswordAttrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
			tabViewComponentsPasswordAttrScrollPane.setContent( tabViewComponentsPasswordAttrPane );
		}
		return( tabViewComponentsPasswordAttrScrollPane );
	}

	public ScrollPane getTabViewComponentsEMConfAttrScrollPane() {
		if( tabViewComponentsEMConfAttrScrollPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserEMConfObj refEMConf =
				( focus != null )
					? focus.getOptionalComponentsEMConf()
					: null;
			tabViewComponentsEMConfAttrPane = javafxSchema.getSecUserEMConfFactory().newAttrPane( ycfFormManager, refEMConf );
			tabViewComponentsEMConfAttrScrollPane = new ScrollPane();
			tabViewComponentsEMConfAttrScrollPane.setFitToWidth( true );
			tabViewComponentsEMConfAttrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
			tabViewComponentsEMConfAttrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
			tabViewComponentsEMConfAttrScrollPane.setContent( tabViewComponentsEMConfAttrPane );
		}
		return( tabViewComponentsEMConfAttrScrollPane );
	}

	public ScrollPane getTabViewComponentsPWResetAttrScrollPane() {
		if( tabViewComponentsPWResetAttrScrollPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserPWResetObj refPWReset =
				( focus != null )
					? focus.getOptionalComponentsPWReset()
					: null;
			tabViewComponentsPWResetAttrPane = javafxSchema.getSecUserPWResetFactory().newAttrPane( ycfFormManager, refPWReset );
			tabViewComponentsPWResetAttrScrollPane = new ScrollPane();
			tabViewComponentsPWResetAttrScrollPane.setFitToWidth( true );
			tabViewComponentsPWResetAttrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
			tabViewComponentsPWResetAttrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
			tabViewComponentsPWResetAttrScrollPane.setContent( tabViewComponentsPWResetAttrPane );
		}
		return( tabViewComponentsPWResetAttrScrollPane );
	}

	public ScrollPane getTabViewChildrenPWHistoryAttrScrollPane() {
		if( tabViewChildrenPWHistoryAttrScrollPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserPWHistoryObj refPWHistory =
				( focus != null )
					? focus.getOptionalChildrenPWHistory()
					: null;
			tabViewChildrenPWHistoryAttrPane = javafxSchema.getSecUserPWHistoryFactory().newAttrPane( ycfFormManager, refPWHistory );
			tabViewChildrenPWHistoryAttrScrollPane = new ScrollPane();
			tabViewChildrenPWHistoryAttrScrollPane.setFitToWidth( true );
			tabViewChildrenPWHistoryAttrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
			tabViewChildrenPWHistoryAttrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
			tabViewChildrenPWHistoryAttrScrollPane.setContent( tabViewChildrenPWHistoryAttrPane );
		}
		return( tabViewChildrenPWHistoryAttrScrollPane );
	}

	protected class RefreshComponentsSecSessList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSecSessList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataComponentsSecSessList
	implements ISecureJavaFXSecSessionPageCallback
	{
		public PageDataComponentsSecSessList() {
		}

		public List<ISecureSecSessionObj> pageData( IYCFKeyHash256 priorSecSessionId )
		{
			List<ISecureSecSessionObj> dataList;
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSessionTableObj().pageSecSessionBySecUserIdx( focus.getRequiredSecUserId(),
					priorSecSessionId );
			}
			else {
				dataList = new ArrayList<ISecureSecSessionObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewComponentsSecSessListPane() {
		if( tabViewComponentsSecSessListPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecUserObj ) ) {
				javafxContainer = (ISecureSecUserObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSecSessListPane = javafxSchema.getSecSessionFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataComponentsSecSessList(), new RefreshComponentsSecSessList(), false );
		}
		return( tabViewComponentsSecSessListPane );
	}

	protected class RefreshChildrenSecProxyList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenSecProxyList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenSecProxyList
	implements ISecureJavaFXSecSessionPageCallback
	{
		public PageDataChildrenSecProxyList() {
		}

		public List<ISecureSecSessionObj> pageData( IYCFKeyHash256 priorSecSessionId )
		{
			List<ISecureSecSessionObj> dataList;
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSessionTableObj().pageSecSessionBySecProxyIdx( focus.getRequiredSecUserId(),
					priorSecSessionId );
			}
			else {
				dataList = new ArrayList<ISecureSecSessionObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenSecProxyListPane() {
		if( tabViewChildrenSecProxyListPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecUserObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecUserObj ) ) {
				javafxContainer = (ISecureSecUserObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenSecProxyListPane = javafxSchema.getSecSessionFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenSecProxyList(), new RefreshChildrenSecProxyList(), false );
		}
		return( tabViewChildrenSecProxyListPane );
	}

	protected class RefreshChildrenSysSecGrpMembList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenSysSecGrpMembList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenSysSecGrpMembList
	implements ISecureJavaFXSecSysGrpMembPageCallback
	{
		public PageDataChildrenSysSecGrpMembList() {
		}

		public List<ISecureSecSysGrpMembObj> pageData( IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
		{
			List<ISecureSecSysGrpMembObj> dataList;
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysGrpMembTableObj().pageSecSysGrpMembByLoginIdx( focus.getRequiredLoginId(),
					priorSecSysGrpId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecSysGrpMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenSysSecGrpMembListPane() {
		if( tabViewChildrenSysSecGrpMembListPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenSysSecGrpMembListPane = javafxSchema.getSecSysGrpMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenSysSecGrpMembList(), new RefreshChildrenSysSecGrpMembList(), false );
		}
		return( tabViewChildrenSysSecGrpMembListPane );
	}

	protected class RefreshChildrenClusSecGrpMembList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenClusSecGrpMembList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenClusSecGrpMembList
	implements ISecureJavaFXSecClusGrpMembPageCallback
	{
		public PageDataChildrenClusSecGrpMembList() {
		}

		public List<ISecureSecClusGrpMembObj> pageData( IYCFKeyHash256 priorSecClusGrpId,
		String priorLoginId )
		{
			List<ISecureSecClusGrpMembObj> dataList;
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecClusGrpMembTableObj().pageSecClusGrpMembByLoginIdx( focus.getRequiredLoginId(),
					priorSecClusGrpId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecClusGrpMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenClusSecGrpMembListPane() {
		if( tabViewChildrenClusSecGrpMembListPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecClusGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecClusGrpObj ) ) {
				javafxContainer = (ISecureSecClusGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenClusSecGrpMembListPane = javafxSchema.getSecClusGrpMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenClusSecGrpMembList(), new RefreshChildrenClusSecGrpMembList(), false );
		}
		return( tabViewChildrenClusSecGrpMembListPane );
	}

	protected class RefreshChildrenTentSecGrpMembList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenTentSecGrpMembList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenTentSecGrpMembList
	implements ISecureJavaFXSecTentGrpMembPageCallback
	{
		public PageDataChildrenTentSecGrpMembList() {
		}

		public List<ISecureSecTentGrpMembObj> pageData( IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
		{
			List<ISecureSecTentGrpMembObj> dataList;
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecTentGrpMembTableObj().pageSecTentGrpMembByUserIdx( focus.getRequiredLoginId(),
					priorSecTentGrpId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecTentGrpMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenTentSecGrpMembListPane() {
		if( tabViewChildrenTentSecGrpMembListPane == null ) {
			ISecureSecUserObj focus = (ISecureSecUserObj)getJavaFXFocusAsSecUser();
			ISecureSecTentGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecTentGrpObj ) ) {
				javafxContainer = (ISecureSecTentGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenTentSecGrpMembListPane = javafxSchema.getSecTentGrpMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenTentSecGrpMembList(), new RefreshChildrenTentSecGrpMembList(), false );
		}
		return( tabViewChildrenTentSecGrpMembListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
	if( tabViewComponentsPasswordAttrPane != null ) {
		((ISecureJavaFXSecUserPasswordPaneCommon)tabViewComponentsPasswordAttrPane).setPaneMode( YCFPane.PaneMode.View );
	}
	if( tabViewComponentsEMConfAttrPane != null ) {
		((ISecureJavaFXSecUserEMConfPaneCommon)tabViewComponentsEMConfAttrPane).setPaneMode( YCFPane.PaneMode.View );
	}
	if( tabViewComponentsPWResetAttrPane != null ) {
		((ISecureJavaFXSecUserPWResetPaneCommon)tabViewComponentsPWResetAttrPane).setPaneMode( YCFPane.PaneMode.View );
	}
	if( tabViewChildrenPWHistoryAttrPane != null ) {
		((ISecureJavaFXSecUserPWHistoryPaneCommon)tabViewChildrenPWHistoryAttrPane).setPaneMode( YCFPane.PaneMode.View );
	}
		if( tabViewComponentsSecSessListPane != null ) {
			((ISecureJavaFXSecSessionPaneCommon)tabViewComponentsSecSessListPane).setPaneMode( value );
		}
		if( tabViewChildrenSecProxyListPane != null ) {
			((ISecureJavaFXSecSessionPaneCommon)tabViewChildrenSecProxyListPane).setPaneMode( value );
		}
		if( tabViewChildrenSysSecGrpMembListPane != null ) {
			((ISecureJavaFXSecSysGrpMembPaneCommon)tabViewChildrenSysSecGrpMembListPane).setPaneMode( value );
		}
		if( tabViewChildrenClusSecGrpMembListPane != null ) {
			((ISecureJavaFXSecClusGrpMembPaneCommon)tabViewChildrenClusSecGrpMembListPane).setPaneMode( value );
		}
		if( tabViewChildrenTentSecGrpMembListPane != null ) {
			((ISecureJavaFXSecTentGrpMembPaneCommon)tabViewChildrenTentSecGrpMembListPane).setPaneMode( value );
		}
	}
}
