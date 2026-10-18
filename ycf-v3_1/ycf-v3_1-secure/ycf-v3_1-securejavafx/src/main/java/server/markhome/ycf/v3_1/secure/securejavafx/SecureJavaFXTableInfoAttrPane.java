// Description: Java 25 JavaFX Attribute Pane implementation for TableInfo.

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
 *	SecureJavaFXTableInfoAttrPane JavaFX Attribute Pane implementation
 *	for TableInfo.
 */
public class SecureJavaFXTableInfoAttrPane
extends YCFGridPane
implements ISecureJavaFXTableInfoPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class TableInfoSuperRefYCFLabel
		extends YCFLabel
	{
		public TableInfoSuperRefYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.ParentSuperRef.EffLabel"));
		}
	}

	protected class CallbackTableInfoSuperRefChosen
	implements ISecureJavaFXTableInfoChosen
	{
		public CallbackTableInfoSuperRefChosen() {
		}

		public void choseTableInfo( ISecureTableInfoObj value ) {
			if( javafxReferenceParentSuperRef != null ) {
				ISecureTableInfoObj cur = getJavaFXFocusAsTableInfo();
				if( cur != null ) {
					ISecureTableInfoEditObj editObj = (ISecureTableInfoEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceParentSuperRef.setReferencedObject( value );
							editObj.setOptionalParentSuperRef( value );
						}
					}
				}
			}
		}
	}

	protected class TableInfoSuperRefReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
			ISecureTableInfoObj focus = getEffJavaFXFocus();
			ISecureTableInfoObj referencedObj = (ISecureTableInfoObj)javafxReferenceParentSuperRef.getReferencedObject();
			java.util.List<ISecureTableInfoObj> listOfTableInfo = null;
			listOfTableInfo = schemaObj.getTableInfoTableObj().readAllTableInfo();
			if( listOfTableInfo == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTableInfo" );
			}
			Collection<ISecureTableInfoObj> cltn = listOfTableInfo;
			YCFBorderPane form = javafxSchema.getTableInfoFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackTableInfoSuperRefChosen() );
			((ISecureJavaFXTableInfoPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			ISecureTableInfoObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				ISecureTableInfoObj referencedObj = (ISecureTableInfoObj)javafxReferenceParentSuperRef.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureTableInfo.CLASS_CODE ) {
						form = javafxSchema.getTableInfoFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						ISecureJavaFXTableInfoPaneCommon spec = (ISecureJavaFXTableInfoPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"ISecureTableInfoObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class TableInfoSuperRefYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public TableInfoSuperRefYCFReferenceEditor() {
			super( new TableInfoSuperRefReferenceCallback() );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.TableInfoSuperRef.EffLabel" );
		}
	}

	protected class TableInfoIdYCFLabel
		extends YCFLabel
	{
		public TableInfoIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.TableInfoId.EffLabel"));
		}
	}

	protected class TableInfoIdEditor
		extends YCFInt32Editor
	{
		public TableInfoIdEditor() {
			super();
			setMinValue( ISecureTableInfo.TABLEINFOID_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.TableInfoId.EffLabel" );
		}
	}

	protected class SchemaNameYCFLabel
		extends YCFLabel
	{
		public SchemaNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.SchemaName.EffLabel"));
		}
	}

	protected class SchemaNameEditor
		extends YCFStringEditor
	{
		public SchemaNameEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.SchemaName.EffLabel" );
		}
	}

	protected class TableNameYCFLabel
		extends YCFLabel
	{
		public TableNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.TableName.EffLabel"));
		}
	}

	protected class TableNameEditor
		extends YCFStringEditor
	{
		public TableNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.TableName.EffLabel" );
		}
	}

	protected class BackingClassCodeYCFLabel
		extends YCFLabel
	{
		public BackingClassCodeYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.BackingClassCode.EffLabel"));
		}
	}

	protected class BackingClassCodeEditor
		extends YCFInt32Editor
	{
		public BackingClassCodeEditor() {
			super();
			setMinValue( ISecureTableInfo.BACKINGCLASSCODE_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.BackingClassCode.EffLabel" );
		}
	}

	protected class RuntimeClassCodeYCFLabel
		extends YCFLabel
	{
		public RuntimeClassCodeYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.RuntimeClassCode.EffLabel"));
		}
	}

	protected class RuntimeClassCodeEditor
		extends YCFInt32Editor
	{
		public RuntimeClassCodeEditor() {
			super();
			setMinValue( ISecureTableInfo.RUNTIMECLASSCODE_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.RuntimeClassCode.EffLabel" );
		}
	}

	protected class HasHistoryYCFLabel
		extends YCFLabel
	{
		public HasHistoryYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.HasHistory.EffLabel"));
		}
	}

	protected class HasHistoryEditor
		extends YCFBoolEditor
	{
		public HasHistoryEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.HasHistory.EffLabel" );
		}
	}

	protected class IsMutableYCFLabel
		extends YCFLabel
	{
		public IsMutableYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.IsMutable.EffLabel"));
		}
	}

	protected class IsMutableEditor
		extends YCFBoolEditor
	{
		public IsMutableEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.IsMutable.EffLabel" );
		}
	}

	protected class SecScopeNameYCFLabel
		extends YCFLabel
	{
		public SecScopeNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.SecScopeName.EffLabel"));
		}
	}

	protected class SecScopeNameEditor
		extends YCFStringEditor
	{
		public SecScopeNameEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.SecScopeName.EffLabel" );
		}
	}

	protected class CodeVisYCFLabel
		extends YCFLabel
	{
		public CodeVisYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.TableInfo.AttrPane.CodeVis.EffLabel"));
		}
	}

	protected class CodeVisEditor
		extends YCFStringEditor
	{
		public CodeVisEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "secure.javafx.TableInfo.AttrPane.CodeVis.EffLabel" );
		}
	}

	protected ISecureTableInfoObj javafxParentSuperRefObj = null;
	protected TableInfoSuperRefYCFLabel javafxLabelParentSuperRef = null;
	protected TableInfoSuperRefYCFReferenceEditor javafxReferenceParentSuperRef = null;
	protected TableInfoIdYCFLabel javafxLabelTableInfoId = null;
	protected TableInfoIdEditor javafxEditorTableInfoId = null;
	protected SchemaNameYCFLabel javafxLabelSchemaName = null;
	protected SchemaNameEditor javafxEditorSchemaName = null;
	protected TableNameYCFLabel javafxLabelTableName = null;
	protected TableNameEditor javafxEditorTableName = null;
	protected BackingClassCodeYCFLabel javafxLabelBackingClassCode = null;
	protected BackingClassCodeEditor javafxEditorBackingClassCode = null;
	protected RuntimeClassCodeYCFLabel javafxLabelRuntimeClassCode = null;
	protected RuntimeClassCodeEditor javafxEditorRuntimeClassCode = null;
	protected HasHistoryYCFLabel javafxLabelHasHistory = null;
	protected HasHistoryEditor javafxEditorHasHistory = null;
	protected IsMutableYCFLabel javafxLabelIsMutable = null;
	protected IsMutableEditor javafxEditorIsMutable = null;
	protected SecScopeNameYCFLabel javafxLabelSecScopeName = null;
	protected SecScopeNameEditor javafxEditorSecScopeName = null;
	protected CodeVisYCFLabel javafxLabelCodeVis = null;
	protected CodeVisEditor javafxEditorCodeVis = null;

	public SecureJavaFXTableInfoAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureTableInfoObj argFocus ) {
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
		setJavaFXFocusAsTableInfo( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelParentSuperRef();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceParentSuperRef();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTableInfoId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTableInfoId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelSchemaName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSchemaName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTableName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTableName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelBackingClassCode();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorBackingClassCode();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelRuntimeClassCode();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorRuntimeClassCode();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelHasHistory();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorHasHistory();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsMutable();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsMutable();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelSecScopeName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSecScopeName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelCodeVis();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorCodeVis();
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
		if( ( value == null ) || ( value instanceof ISecureTableInfoObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureTableInfoObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureTableInfoObj getJavaFXFocusAsTableInfo() {
		return( (ISecureTableInfoObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTableInfo( ISecureTableInfoObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureTableInfoObj getEffJavaFXFocus() {
		ISecureTableInfoObj eff = (ISecureTableInfoObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureTableInfoObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISecureTableInfoObj getJavaFXParentSuperRefObj() {
		return( javafxParentSuperRefObj );
	}

	public void setJavaFXParentSuperRefObj( ISecureTableInfoObj value ) {
		javafxParentSuperRefObj = value;
	}

	public YCFLabel getJavaFXLabelParentSuperRef() {
		if( javafxLabelParentSuperRef == null ) {
			javafxLabelParentSuperRef = new TableInfoSuperRefYCFLabel();
		}
		return( javafxLabelParentSuperRef );
	}

	public YCFReferenceEditor getJavaFXReferenceParentSuperRef() {
		if( javafxReferenceParentSuperRef == null ) {
			javafxReferenceParentSuperRef = new TableInfoSuperRefYCFReferenceEditor();
		}
		return( javafxReferenceParentSuperRef );
	}

	public void setJavaFXReferenceParentSuperRef( TableInfoSuperRefYCFReferenceEditor value ) {
		javafxReferenceParentSuperRef = value;
	}

	public TableInfoIdYCFLabel getJavaFXLabelTableInfoId() {
		if( javafxLabelTableInfoId == null ) {
			javafxLabelTableInfoId = new TableInfoIdYCFLabel();
		}
		return( javafxLabelTableInfoId );
	}

	public void setJavaFXLabelTableInfoId( TableInfoIdYCFLabel value ) {
		javafxLabelTableInfoId = value;
	}

	public TableInfoIdEditor getJavaFXEditorTableInfoId() {
		if( javafxEditorTableInfoId == null ) {
			javafxEditorTableInfoId = new TableInfoIdEditor();
		}
		return( javafxEditorTableInfoId );
	}

	public void setJavaFXEditorTableInfoId( TableInfoIdEditor value ) {
		javafxEditorTableInfoId = value;
	}

	public SchemaNameYCFLabel getJavaFXLabelSchemaName() {
		if( javafxLabelSchemaName == null ) {
			javafxLabelSchemaName = new SchemaNameYCFLabel();
		}
		return( javafxLabelSchemaName );
	}

	public void setJavaFXLabelSchemaName( SchemaNameYCFLabel value ) {
		javafxLabelSchemaName = value;
	}

	public SchemaNameEditor getJavaFXEditorSchemaName() {
		if( javafxEditorSchemaName == null ) {
			javafxEditorSchemaName = new SchemaNameEditor();
		}
		return( javafxEditorSchemaName );
	}

	public void setJavaFXEditorSchemaName( SchemaNameEditor value ) {
		javafxEditorSchemaName = value;
	}

	public TableNameYCFLabel getJavaFXLabelTableName() {
		if( javafxLabelTableName == null ) {
			javafxLabelTableName = new TableNameYCFLabel();
		}
		return( javafxLabelTableName );
	}

	public void setJavaFXLabelTableName( TableNameYCFLabel value ) {
		javafxLabelTableName = value;
	}

	public TableNameEditor getJavaFXEditorTableName() {
		if( javafxEditorTableName == null ) {
			javafxEditorTableName = new TableNameEditor();
		}
		return( javafxEditorTableName );
	}

	public void setJavaFXEditorTableName( TableNameEditor value ) {
		javafxEditorTableName = value;
	}

	public BackingClassCodeYCFLabel getJavaFXLabelBackingClassCode() {
		if( javafxLabelBackingClassCode == null ) {
			javafxLabelBackingClassCode = new BackingClassCodeYCFLabel();
		}
		return( javafxLabelBackingClassCode );
	}

	public void setJavaFXLabelBackingClassCode( BackingClassCodeYCFLabel value ) {
		javafxLabelBackingClassCode = value;
	}

	public BackingClassCodeEditor getJavaFXEditorBackingClassCode() {
		if( javafxEditorBackingClassCode == null ) {
			javafxEditorBackingClassCode = new BackingClassCodeEditor();
		}
		return( javafxEditorBackingClassCode );
	}

	public void setJavaFXEditorBackingClassCode( BackingClassCodeEditor value ) {
		javafxEditorBackingClassCode = value;
	}

	public RuntimeClassCodeYCFLabel getJavaFXLabelRuntimeClassCode() {
		if( javafxLabelRuntimeClassCode == null ) {
			javafxLabelRuntimeClassCode = new RuntimeClassCodeYCFLabel();
		}
		return( javafxLabelRuntimeClassCode );
	}

	public void setJavaFXLabelRuntimeClassCode( RuntimeClassCodeYCFLabel value ) {
		javafxLabelRuntimeClassCode = value;
	}

	public RuntimeClassCodeEditor getJavaFXEditorRuntimeClassCode() {
		if( javafxEditorRuntimeClassCode == null ) {
			javafxEditorRuntimeClassCode = new RuntimeClassCodeEditor();
		}
		return( javafxEditorRuntimeClassCode );
	}

	public void setJavaFXEditorRuntimeClassCode( RuntimeClassCodeEditor value ) {
		javafxEditorRuntimeClassCode = value;
	}

	public HasHistoryYCFLabel getJavaFXLabelHasHistory() {
		if( javafxLabelHasHistory == null ) {
			javafxLabelHasHistory = new HasHistoryYCFLabel();
		}
		return( javafxLabelHasHistory );
	}

	public void setJavaFXLabelHasHistory( HasHistoryYCFLabel value ) {
		javafxLabelHasHistory = value;
	}

	public HasHistoryEditor getJavaFXEditorHasHistory() {
		if( javafxEditorHasHistory == null ) {
			javafxEditorHasHistory = new HasHistoryEditor();
		}
		return( javafxEditorHasHistory );
	}

	public void setJavaFXEditorHasHistory( HasHistoryEditor value ) {
		javafxEditorHasHistory = value;
	}

	public IsMutableYCFLabel getJavaFXLabelIsMutable() {
		if( javafxLabelIsMutable == null ) {
			javafxLabelIsMutable = new IsMutableYCFLabel();
		}
		return( javafxLabelIsMutable );
	}

	public void setJavaFXLabelIsMutable( IsMutableYCFLabel value ) {
		javafxLabelIsMutable = value;
	}

	public IsMutableEditor getJavaFXEditorIsMutable() {
		if( javafxEditorIsMutable == null ) {
			javafxEditorIsMutable = new IsMutableEditor();
		}
		return( javafxEditorIsMutable );
	}

	public void setJavaFXEditorIsMutable( IsMutableEditor value ) {
		javafxEditorIsMutable = value;
	}

	public SecScopeNameYCFLabel getJavaFXLabelSecScopeName() {
		if( javafxLabelSecScopeName == null ) {
			javafxLabelSecScopeName = new SecScopeNameYCFLabel();
		}
		return( javafxLabelSecScopeName );
	}

	public void setJavaFXLabelSecScopeName( SecScopeNameYCFLabel value ) {
		javafxLabelSecScopeName = value;
	}

	public SecScopeNameEditor getJavaFXEditorSecScopeName() {
		if( javafxEditorSecScopeName == null ) {
			javafxEditorSecScopeName = new SecScopeNameEditor();
		}
		return( javafxEditorSecScopeName );
	}

	public void setJavaFXEditorSecScopeName( SecScopeNameEditor value ) {
		javafxEditorSecScopeName = value;
	}

	public CodeVisYCFLabel getJavaFXLabelCodeVis() {
		if( javafxLabelCodeVis == null ) {
			javafxLabelCodeVis = new CodeVisYCFLabel();
		}
		return( javafxLabelCodeVis );
	}

	public void setJavaFXLabelCodeVis( CodeVisYCFLabel value ) {
		javafxLabelCodeVis = value;
	}

	public CodeVisEditor getJavaFXEditorCodeVis() {
		if( javafxEditorCodeVis == null ) {
			javafxEditorCodeVis = new CodeVisEditor();
		}
		return( javafxEditorCodeVis );
	}

	public void setJavaFXEditorCodeVis( CodeVisEditor value ) {
		javafxEditorCodeVis = value;
	}

	public void populateFields()
	{
		ISecureTableInfoObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxParentSuperRefObj = null;
		}
		else {
			javafxParentSuperRefObj = (ISecureTableInfoObj)popObj.getOptionalParentSuperRef( javafxIsInitializing );
		}
		if( javafxReferenceParentSuperRef != null ) {
			javafxReferenceParentSuperRef.setReferencedObject( javafxParentSuperRefObj );
		}

		if( popObj == null ) {
			getJavaFXEditorTableInfoId().setInt32Value( null );
		}
		else {
			getJavaFXEditorTableInfoId().setInt32Value( popObj.getRequiredTableInfoId() );
		}

		if( popObj == null ) {
			getJavaFXEditorSchemaName().setStringValue( null );
		}
		else {
			getJavaFXEditorSchemaName().setStringValue( popObj.getRequiredSchemaName() );
		}

		if( popObj == null ) {
			getJavaFXEditorTableName().setStringValue( null );
		}
		else {
			getJavaFXEditorTableName().setStringValue( popObj.getRequiredTableName() );
		}

		if( popObj == null ) {
			getJavaFXEditorBackingClassCode().setInt32Value( null );
		}
		else {
			getJavaFXEditorBackingClassCode().setInt32Value( popObj.getRequiredBackingClassCode() );
		}

		if( popObj == null ) {
			getJavaFXEditorRuntimeClassCode().setInt32Value( null );
		}
		else {
			getJavaFXEditorRuntimeClassCode().setInt32Value( popObj.getRequiredRuntimeClassCode() );
		}

		if( popObj == null ) {
			getJavaFXEditorHasHistory().setBooleanValue( null );
		}
		else {
			getJavaFXEditorHasHistory().setBooleanValue( popObj.getRequiredHasHistory() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsMutable().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsMutable().setBooleanValue( popObj.getRequiredIsMutable() );
		}

		if( popObj == null ) {
			getJavaFXEditorSecScopeName().setStringValue( null );
		}
		else {
			getJavaFXEditorSecScopeName().setStringValue( popObj.getRequiredSecScopeName() );
		}

		if( popObj == null ) {
			getJavaFXEditorCodeVis().setStringValue( null );
		}
		else {
			getJavaFXEditorCodeVis().setStringValue( popObj.getRequiredCodeVis() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureTableInfoObj focus = getJavaFXFocusAsTableInfo();
		ISecureTableInfoEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureTableInfoEditObj)(focus.getEdit());
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

		javafxParentSuperRefObj = (ISecureTableInfoObj)( javafxReferenceParentSuperRef.getReferencedObject() );
		editObj.setOptionalParentSuperRef( javafxParentSuperRefObj );

		if( getJavaFXEditorSchemaName().getStringValue() == null ) {
			editObj.setRequiredSchemaName( "" );
		}
		else {
			editObj.setRequiredSchemaName( getJavaFXEditorSchemaName().getStringValue() );
		}

		if( getJavaFXEditorTableName().getStringValue() == null ) {
			editObj.setRequiredTableName( "" );
		}
		else {
			editObj.setRequiredTableName( getJavaFXEditorTableName().getStringValue() );
		}

		editObj.setRequiredBackingClassCode( getJavaFXEditorBackingClassCode().getInt32Value() );

		editObj.setRequiredRuntimeClassCode( getJavaFXEditorRuntimeClassCode().getInt32Value() );

		editObj.setRequiredHasHistory( getJavaFXEditorHasHistory().getBooleanValue() );

		editObj.setRequiredIsMutable( getJavaFXEditorIsMutable().getBooleanValue() );

		if( getJavaFXEditorSecScopeName().getStringValue() == null ) {
			editObj.setRequiredSecScopeName( "" );
		}
		else {
			editObj.setRequiredSecScopeName( getJavaFXEditorSecScopeName().getStringValue() );
		}

		if( getJavaFXEditorCodeVis().getStringValue() == null ) {
			editObj.setRequiredCodeVis( "" );
		}
		else {
			editObj.setRequiredCodeVis( getJavaFXEditorCodeVis().getStringValue() );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureTableInfoObj focus = getJavaFXFocusAsTableInfo();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureTableInfoEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureTableInfoEditObj)focus.getEdit();
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
								editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
							editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
							editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
							editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
						focus = (ISecureTableInfoObj)editObj.create();
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
								editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
								editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
							editObj = (ISecureTableInfoEditObj)focus.beginEdit();
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
			ISecureTableInfoObj focus = getJavaFXFocusAsTableInfo();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceParentSuperRef != null ) {
			javafxReferenceParentSuperRef.setCustomDisable( ! isEditing );
		}
		if( javafxEditorTableInfoId != null ) {
			javafxEditorTableInfoId.setDisable( true );
		}
		if( javafxEditorSchemaName != null ) {
			javafxEditorSchemaName.setDisable( ! isEditing );
		}
		if( javafxEditorTableName != null ) {
			javafxEditorTableName.setDisable( ! isEditing );
		}
		if( javafxEditorBackingClassCode != null ) {
			javafxEditorBackingClassCode.setDisable( ! isEditing );
		}
		if( javafxEditorRuntimeClassCode != null ) {
			javafxEditorRuntimeClassCode.setDisable( ! isEditing );
		}
		if( javafxEditorHasHistory != null ) {
			javafxEditorHasHistory.setDisable( ! isEditing );
		}
		if( javafxEditorIsMutable != null ) {
			javafxEditorIsMutable.setDisable( ! isEditing );
		}
		if( javafxEditorSecScopeName != null ) {
			javafxEditorSecScopeName.setDisable( ! isEditing );
		}
		if( javafxEditorCodeVis != null ) {
			javafxEditorCodeVis.setDisable( ! isEditing );
		}
	}
}
