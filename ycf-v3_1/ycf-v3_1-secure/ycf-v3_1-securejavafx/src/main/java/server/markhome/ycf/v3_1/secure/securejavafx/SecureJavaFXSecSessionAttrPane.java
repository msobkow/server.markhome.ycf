// Description: Java 25 JavaFX Attribute Pane implementation for SecSession.

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import server.markhome.ycf.javafx.YCFReferenceEditor.IYCFReferenceCallback;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXSecSessionAttrPane JavaFX Attribute Pane implementation
 *	for SecSession.
 */
public class SecureJavaFXSecSessionAttrPane
extends YCFGridPane
implements ISecureJavaFXSecSessionPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class SecSessionProxyYCFLabel
		extends YCFLabel
	{
		public SecSessionProxyYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecSession.AttrPane.ParentSecProxy.EffLabel"));
		}
	}

	protected class CallbackSecSessionProxyChosen
	implements ISecureJavaFXSecUserChosen
	{
		public CallbackSecSessionProxyChosen() {
		}

		public void choseSecUser( ISecureSecUserObj value ) {
			if( javafxReferenceParentSecProxy != null ) {
				ISecureSecSessionObj cur = getJavaFXFocusAsSecSession();
				if( cur != null ) {
					ISecureSecSessionEditObj editObj = (ISecureSecSessionEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceParentSecProxy.setReferencedObject( value );
							editObj.setRequiredParentSecProxy( value );
						}
					}
				}
			}
		}
	}

	protected class PageDataParentSecProxyList
	implements ISecureJavaFXSecUserPageCallback
	{
		public PageDataParentSecProxyList() {
		}

		public List<ISecureSecUserObj> pageData( IYCFKeyHash256 priorSecUserId )
		{
			java.util.List<ISecureSecUserObj> listOfSecUser = null;
			ISecureSecSessionObj focus = (ISecureSecSessionObj)getEffJavaFXFocus();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
			listOfSecUser = schemaObj.getSecUserTableObj().pageAllSecUser( priorSecUserId );
			}
			else {
				listOfSecUser = new ArrayList<ISecureSecUserObj>();
			}
			return( listOfSecUser  );
		}
	}

	protected class SecSessionProxyReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
			ISecureSecSessionObj focus = getEffJavaFXFocus();
			ISecureSecUserObj referencedObj = (ISecureSecUserObj)javafxReferenceParentSecProxy.getReferencedObject();
			YCFBorderPane form = javafxSchema.getSecUserFactory().newPickerForm( ycfFormManager, referencedObj, null, new PageDataParentSecProxyList(), new CallbackSecSessionProxyChosen() );
			((ISecureJavaFXSecUserPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			ISecureSecSessionObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				ISecureSecUserObj referencedObj = (ISecureSecUserObj)javafxReferenceParentSecProxy.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureSecUser.CLASS_CODE ) {
						form = javafxSchema.getSecUserFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						ISecureJavaFXSecUserPaneCommon spec = (ISecureJavaFXSecUserPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"ISecureSecUserObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class SecSessionProxyYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public SecSessionProxyYCFReferenceEditor() {
			super( new SecSessionProxyReferenceCallback() );
			setFieldNameInzTag( "secure.javafx.SecSession.AttrPane.SecSessionProxy.EffLabel" );
		}
	}

	protected class SecSessionIdYCFLabel
		extends YCFLabel
	{
		public SecSessionIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecSession.AttrPane.SecSessionId.EffLabel"));
		}
	}

	protected class SecSessionIdEditor
		extends YCFDbKeyHash256Editor
	{
		public SecSessionIdEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecSession.AttrPane.SecSessionId.EffLabel" );
		}
	}

	protected class StartYCFLabel
		extends YCFLabel
	{
		public StartYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecSession.AttrPane.Start.EffLabel"));
		}
	}

	protected class StartEditor
		extends YCFTimestampEditor
	{
		public StartEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecSession.AttrPane.Start.EffLabel" );
		}
	}

	protected class FinishYCFLabel
		extends YCFLabel
	{
		public FinishYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecSession.AttrPane.Finish.EffLabel"));
		}
	}

	protected class FinishEditor
		extends YCFTimestampEditor
	{
		public FinishEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecSession.AttrPane.Finish.EffLabel" );
		}
	}

	protected ISecureSecUserObj javafxParentSecProxyObj = null;
	protected SecSessionProxyYCFLabel javafxLabelParentSecProxy = null;
	protected SecSessionProxyYCFReferenceEditor javafxReferenceParentSecProxy = null;
	protected SecSessionIdYCFLabel javafxLabelSecSessionId = null;
	protected SecSessionIdEditor javafxEditorSecSessionId = null;
	protected StartYCFLabel javafxLabelStart = null;
	protected StartEditor javafxEditorStart = null;
	protected FinishYCFLabel javafxLabelFinish = null;
	protected FinishEditor javafxEditorFinish = null;

	public SecureJavaFXSecSessionAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecSessionObj argFocus ) {
		super();
		Control ctrl;
		YCFLabel label;
		YCFReferenceEditor reference;
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
		setJavaFXFocusAsSecSession( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelParentSecProxy();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceParentSecProxy();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelSecSessionId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSecSessionId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelStart();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorStart();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelFinish();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorFinish();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		populateFields();
		adjustComponentEnableStates();
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
		if( ( value == null ) || ( value instanceof ISecureSecSessionObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSessionObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureSecSessionObj getJavaFXFocusAsSecSession() {
		return( (ISecureSecSessionObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecSession( ISecureSecSessionObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecSessionObj getEffJavaFXFocus() {
		ISecureSecSessionObj eff = (ISecureSecSessionObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureSecSessionObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISecureSecUserObj getJavaFXParentSecProxyObj() {
		return( javafxParentSecProxyObj );
	}

	public void setJavaFXParentSecProxyObj( ISecureSecUserObj value ) {
		javafxParentSecProxyObj = value;
	}

	public YCFLabel getJavaFXLabelParentSecProxy() {
		if( javafxLabelParentSecProxy == null ) {
			javafxLabelParentSecProxy = new SecSessionProxyYCFLabel();
		}
		return( javafxLabelParentSecProxy );
	}

	public YCFReferenceEditor getJavaFXReferenceParentSecProxy() {
		if( javafxReferenceParentSecProxy == null ) {
			javafxReferenceParentSecProxy = new SecSessionProxyYCFReferenceEditor();
		}
		return( javafxReferenceParentSecProxy );
	}

	public void setJavaFXReferenceParentSecProxy( SecSessionProxyYCFReferenceEditor value ) {
		javafxReferenceParentSecProxy = value;
	}

	public SecSessionIdYCFLabel getJavaFXLabelSecSessionId() {
		if( javafxLabelSecSessionId == null ) {
			javafxLabelSecSessionId = new SecSessionIdYCFLabel();
		}
		return( javafxLabelSecSessionId );
	}

	public void setJavaFXLabelSecSessionId( SecSessionIdYCFLabel value ) {
		javafxLabelSecSessionId = value;
	}

	public SecSessionIdEditor getJavaFXEditorSecSessionId() {
		if( javafxEditorSecSessionId == null ) {
			javafxEditorSecSessionId = new SecSessionIdEditor();
		}
		return( javafxEditorSecSessionId );
	}

	public void setJavaFXEditorSecSessionId( SecSessionIdEditor value ) {
		javafxEditorSecSessionId = value;
	}

	public StartYCFLabel getJavaFXLabelStart() {
		if( javafxLabelStart == null ) {
			javafxLabelStart = new StartYCFLabel();
		}
		return( javafxLabelStart );
	}

	public void setJavaFXLabelStart( StartYCFLabel value ) {
		javafxLabelStart = value;
	}

	public StartEditor getJavaFXEditorStart() {
		if( javafxEditorStart == null ) {
			javafxEditorStart = new StartEditor();
		}
		return( javafxEditorStart );
	}

	public void setJavaFXEditorStart( StartEditor value ) {
		javafxEditorStart = value;
	}

	public FinishYCFLabel getJavaFXLabelFinish() {
		if( javafxLabelFinish == null ) {
			javafxLabelFinish = new FinishYCFLabel();
		}
		return( javafxLabelFinish );
	}

	public void setJavaFXLabelFinish( FinishYCFLabel value ) {
		javafxLabelFinish = value;
	}

	public FinishEditor getJavaFXEditorFinish() {
		if( javafxEditorFinish == null ) {
			javafxEditorFinish = new FinishEditor();
		}
		return( javafxEditorFinish );
	}

	public void setJavaFXEditorFinish( FinishEditor value ) {
		javafxEditorFinish = value;
	}

	public void populateFields()
	{
		ISecureSecSessionObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxParentSecProxyObj = null;
		}
		else {
			javafxParentSecProxyObj = (ISecureSecUserObj)popObj.getRequiredParentSecProxy( javafxIsInitializing );
		}
		if( javafxReferenceParentSecProxy != null ) {
			javafxReferenceParentSecProxy.setReferencedObject( javafxParentSecProxyObj );
		}

		if( popObj == null ) {
			getJavaFXEditorSecSessionId().setDbKeyHash256Value( null );
		}
		else {
			getJavaFXEditorSecSessionId().setDbKeyHash256Value( popObj.getRequiredSecSessionId() );
		}

		if( popObj == null ) {
			getJavaFXEditorStart().setTimestampValue( null );
		}
		else {
			getJavaFXEditorStart().setTimestampValue( popObj.getRequiredStart() );
		}

		if( popObj == null ) {
			getJavaFXEditorFinish().setTimestampValue( null );
		}
		else {
			getJavaFXEditorFinish().setTimestampValue( popObj.getOptionalFinish() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureSecSessionObj focus = getJavaFXFocusAsSecSession();
		ISecureSecSessionEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureSecSessionEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw new YCFLibUsageException( getClass(),
				S_ProcName,
				Inz.s("ycflibjavafx.common.PaneIsUnfocusedOrNotEditing"),
				Inz.x("ycflibjavafx.common.PaneIsUnfocusedOrNotEditing") );
		}

		javafxParentSecProxyObj = (ISecureSecUserObj)( javafxReferenceParentSecProxy.getReferencedObject() );
		editObj.setRequiredParentSecProxy( javafxParentSecProxyObj );

		editObj.setRequiredStart( getJavaFXEditorStart().getTimestampValue() );

		editObj.setOptionalFinish( getJavaFXEditorFinish().getTimestampValue() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureSecSessionObj focus = getJavaFXFocusAsSecSession();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureSecSessionEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureSecSessionEditObj)focus.getEdit();
		}
		else {
			editObj = null;
		}
		switch( value ) {
			case Unknown:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
			case Add:
				switch( oldValue ) {
					case Unknown:
					case Add:
					case View:
						if( editObj == null ) {
							if( focus != null ) {
								if( ! focus.getIsNew() ) {
									throw new YCFLibUsageException( getClass(),
										S_ProcName,
										Inz.x("ycflibjavafx.common.MustBeNew"),
										Inz.s("ycflibjavafx.common.MustBeNew") );
								}
								editObj = (ISecureSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw new YCFLibUsageException( getClass(),
										S_ProcName,
										Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
										Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
							else {
								throw new YCFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"focus" );
							}
						}
						break;
					case Edit:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionEditToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionEditToAdd") );
					case Update:
						if( ( editObj == null ) || ( ! editObj.getIsNew() ) ) {
							throw new YCFLibUsageException( getClass(),
								S_ProcName,
								Inz.x("ycflibjavafx.common.CannotTransitionUpdateToAdd"),
								Inz.s("ycflibjavafx.common.CannotTransitionUpdateToAdd") );
						}
						break;
					case Delete:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionDeleteToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionDeleteToAdd") );
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionDefaultToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionDefaultToAdd") );
				}
				break;
			case View:
				switch( oldValue ) {
					case Unknown:
						break;
					case View:
						break;
					case Edit:
						break;
					case Update:
						break;
					case Delete:
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToView"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToView"), oldValue) );
				}
				if( editObj != null ) {
					editObj.endEdit();
					editObj = null;
				}
				break;
			case Edit:
				switch( oldValue ) {
					case Unknown:
						if( editObj == null ) {
							editObj = (ISecureSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ISecureSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ISecureSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case Update:
						if( editObj == null ) {
							throw new YCFLibUsageException( getClass(),
								S_ProcName,
								String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue),
								String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue) );
						}
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue) );
				}
				break;
			case Update:
				if( ( oldValue != YCFPane.PaneMode.Edit ) && ( oldValue != YCFPane.PaneMode.Add ) ) {
					throw new YCFLibUsageException( getClass(),
						S_ProcName,
						String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToUpdate"), oldValue),
						String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToUpdate"), oldValue) );
				}
				super.setPaneMode( value );
				if( editObj != null ) {
					postFields();
					if( editObj.getIsNew() ) {
						focus = (ISecureSecSessionObj)editObj.create();
						setJavaFXFocus( focus );
					}
					else {
						editObj.update();
					}
					editObj = null;
				}
				setPaneMode( YCFPane.PaneMode.View );
				break;
			case Delete:
				switch( oldValue ) {
					case View:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ISecureSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
						}
						break;
					case Edit:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ISecureSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
						}
						break;
					case Update:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue) );
					case Delete:
						if( editObj == null ) {
							editObj = (ISecureSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue) );
				}
				editObj.deleteInstance();
				editObj = null;
				setJavaFXFocus( null );
				setPaneMode( YCFPane.PaneMode.Unknown );
				break;
			default:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
		}
		super.setPaneMode( value );
		populateFields();
		adjustComponentEnableStates();
	}

	public void adjustComponentEnableStates() {
		YCFPane.PaneMode mode = getPaneMode();
		boolean isEditing;
		switch( mode ) {
			case Unknown:
			case View:
			case Delete:
				isEditing = false;
				break;
			case Add:
			case Edit:
			case Update:
				isEditing = true;
				break;
			default:
				isEditing = false;
				break;
		}
		if( isEditing ) {
			ISecureSecSessionObj focus = getJavaFXFocusAsSecSession();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceParentSecProxy != null ) {
			javafxReferenceParentSecProxy.setCustomDisable( ! isEditing );
		}
		if( javafxEditorSecSessionId != null ) {
			javafxEditorSecSessionId.setDisable( true );
		}
		if( javafxEditorStart != null ) {
			javafxEditorStart.setDisable( ! isEditing );
		}
		if( javafxEditorFinish != null ) {
			javafxEditorFinish.setDisable( ! isEditing );
		}
	}
}
