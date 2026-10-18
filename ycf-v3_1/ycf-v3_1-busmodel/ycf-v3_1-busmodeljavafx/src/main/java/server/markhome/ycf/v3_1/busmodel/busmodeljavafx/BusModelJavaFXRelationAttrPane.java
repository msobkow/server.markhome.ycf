// Description: Java 25 JavaFX Attribute Pane implementation for Relation.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;
import server.markhome.ycf.v3_1.intnet.intnetjavafx.*;

/**
 *	BusModelJavaFXRelationAttrPane JavaFX Attribute Pane implementation
 *	for Relation.
 */
public class BusModelJavaFXRelationAttrPane
extends YCFGridPane
implements IBusModelJavaFXRelationPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected ObservableList<String> observableListOfRelationType =
		FXCollections.observableArrayList(
			"Unknown",
			"Lookup",
			"Superclass",
			"Container",
			"Components",
			"Owner",
			"Parent",
			"Children" );

	protected ObservableList<String> observableListOfCodeVis =
		FXCollections.observableArrayList(
			"Public",
			"Protected",
			"Private" );

	protected class DefSchemaYCFLabel
		extends YCFLabel
	{
		public DefSchemaYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.LookupDefSchema.EffLabel"));
		}
	}

	protected class CallbackDefSchemaChosen
	implements IBusModelJavaFXSchemaDefChosen
	{
		public CallbackDefSchemaChosen() {
		}

		public void choseSchemaDef( IBusModelSchemaDefObj value ) {
			if( javafxReferenceLookupDefSchema != null ) {
				IBusModelRelationObj cur = getJavaFXFocusAsRelation();
				if( cur != null ) {
					IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupDefSchema.setReferencedObject( value );
							editObj.setOptionalLookupDefSchema( value );
						}
					}
				}
			}
		}
	}

	protected class DefSchemaReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelRelationObj focus = getEffJavaFXFocus();
			IBusModelSchemaDefObj referencedObj = (IBusModelSchemaDefObj)javafxReferenceLookupDefSchema.getReferencedObject();
			java.util.List<IBusModelSchemaDefObj> listOfSchemaDef = null;
			Collection<IBusModelSchemaDefObj> cltn = null;
			YCFBorderPane form = javafxSchema.getSchemaDefFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackDefSchemaChosen() );
			((IBusModelJavaFXSchemaDefPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelRelationObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelSchemaDefObj referencedObj = (IBusModelSchemaDefObj)javafxReferenceLookupDefSchema.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelSchemaDef.CLASS_CODE ) {
						form = javafxSchema.getSchemaDefFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXSchemaDefPaneCommon spec = (IBusModelJavaFXSchemaDefPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelSchemaDefObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class DefSchemaYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public DefSchemaYCFReferenceEditor() {
			super( new DefSchemaReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.DefSchema.EffLabel" );
		}
	}

	protected class FromIndexYCFLabel
		extends YCFLabel
	{
		public FromIndexYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.LookupFromIndex.EffLabel"));
		}
	}

	protected class CallbackFromIndexChosen
	implements IBusModelJavaFXIndexChosen
	{
		public CallbackFromIndexChosen() {
		}

		public void choseIndex( IBusModelIndexObj value ) {
			if( javafxReferenceLookupFromIndex != null ) {
				IBusModelRelationObj cur = getJavaFXFocusAsRelation();
				if( cur != null ) {
					IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupFromIndex.setReferencedObject( value );
							editObj.setRequiredLookupFromIndex( value );
						}
					}
				}
			}
		}
	}

	protected class FromIndexReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelRelationObj focus = getEffJavaFXFocus();
			IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupFromIndex.getReferencedObject();
			java.util.List<IBusModelIndexObj> listOfIndex = null;
			IBusModelTableObj refFromTable = (IBusModelTableObj)focus.getRequiredContainerFromTable( javafxIsInitializing );
			if( refFromTable == null ) {
				YCFConsole.message( String.format(Inz.s("ycflibjavafx.common.SpecifyRelationBeforeSelectingTarget"), Inz.s("busmodel.javafx.Relation.AttrPane.ContainerFromTable.EffLabel"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupFromIndex.EffLabel")));
				return;
			}
			listOfIndex = refFromTable.getOptionalComponentsIndex( javafxIsInitializing );
			if( listOfIndex == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<IBusModelIndexObj> cltn = listOfIndex;
			YCFBorderPane form = javafxSchema.getIndexFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackFromIndexChosen() );
			((IBusModelJavaFXIndexPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelRelationObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupFromIndex.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelIndex.CLASS_CODE ) {
						form = javafxSchema.getIndexFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXIndexPaneCommon spec = (IBusModelJavaFXIndexPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelIndexObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class FromIndexYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public FromIndexYCFReferenceEditor() {
			super( new FromIndexReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.FromIndex.EffLabel" );
		}
	}

	protected class ToTableYCFLabel
		extends YCFLabel
	{
		public ToTableYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.LookupToTable.EffLabel"));
		}
	}

	protected class CallbackToTableChosen
	implements IBusModelJavaFXTableChosen
	{
		public CallbackToTableChosen() {
		}

		public void choseTable( IBusModelTableObj value ) {
			if( javafxReferenceLookupToTable != null ) {
				IBusModelRelationObj cur = getJavaFXFocusAsRelation();
				if( cur != null ) {
					IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupToTable.setReferencedObject( value );
							editObj.setRequiredLookupToTable( value );
						}
					}
				}
			}
		}
	}

	protected class ToTableReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelRelationObj focus = getEffJavaFXFocus();
			IBusModelTableObj referencedObj = (IBusModelTableObj)javafxReferenceLookupToTable.getReferencedObject();
			java.util.List<IBusModelTableObj> listOfTable = null;
			IBusModelTableObj refFromTable = (IBusModelTableObj)focus.getRequiredContainerFromTable( javafxIsInitializing );
			if( refFromTable == null ) {
				YCFConsole.message( String.format(Inz.s("ycflibjavafx.common.SpecifyRelationBeforeSelectingTarget"), Inz.s("busmodel.javafx.Relation.AttrPane.ContainerFromTable.EffLabel"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupToTable.EffLabel")));
				return;
			}
			IBusModelSchemaDefObj refSchemaDef = refFromTable.getRequiredContainerSchemaDef( javafxIsInitializing );
			if( refSchemaDef == null ) {
				YCFConsole.message( String.format(Inz.s("ycflibjavafx.common.SpecifyRelationBeforeSelectingTarget"), Inz.s("busmodel.javafx.Table.AttrPane.ContainerSchemaDef.EffLabel"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupToTable.EffLabel")));
				return;
			}
			listOfTable = refSchemaDef.getOptionalComponentsTables( javafxIsInitializing );
			if( listOfTable == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfTable" );
			}
			Collection<IBusModelTableObj> cltn = listOfTable;
			YCFBorderPane form = javafxSchema.getTableFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackToTableChosen() );
			((IBusModelJavaFXTablePaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelRelationObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelTableObj referencedObj = (IBusModelTableObj)javafxReferenceLookupToTable.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTable.CLASS_CODE ) {
						form = javafxSchema.getTableFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXTablePaneCommon spec = (IBusModelJavaFXTablePaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelTableObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class ToTableYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public ToTableYCFReferenceEditor() {
			super( new ToTableReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.ToTable.EffLabel" );
		}
	}

	protected class ToIndexYCFLabel
		extends YCFLabel
	{
		public ToIndexYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.LookupToIndex.EffLabel"));
		}
	}

	protected class CallbackToIndexChosen
	implements IBusModelJavaFXIndexChosen
	{
		public CallbackToIndexChosen() {
		}

		public void choseIndex( IBusModelIndexObj value ) {
			if( javafxReferenceLookupToIndex != null ) {
				IBusModelRelationObj cur = getJavaFXFocusAsRelation();
				if( cur != null ) {
					IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupToIndex.setReferencedObject( value );
							editObj.setRequiredLookupToIndex( value );
						}
					}
				}
			}
		}
	}

	protected class ToIndexReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelRelationObj focus = getEffJavaFXFocus();
			IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupToIndex.getReferencedObject();
			java.util.List<IBusModelIndexObj> listOfIndex = null;
			IBusModelTableObj refToTable = (IBusModelTableObj)focus.getRequiredLookupToTable( javafxIsInitializing );
			if( refToTable == null ) {
				YCFConsole.message( String.format(Inz.s("ycflibjavafx.common.SpecifyRelationBeforeSelectingTarget"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupToTable.EffLabel"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupToIndex.EffLabel")));
				return;
			}
			listOfIndex = refToTable.getOptionalComponentsIndex( javafxIsInitializing );
			if( listOfIndex == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<IBusModelIndexObj> cltn = listOfIndex;
			YCFBorderPane form = javafxSchema.getIndexFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackToIndexChosen() );
			((IBusModelJavaFXIndexPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelRelationObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupToIndex.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelIndex.CLASS_CODE ) {
						form = javafxSchema.getIndexFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXIndexPaneCommon spec = (IBusModelJavaFXIndexPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelIndexObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class ToIndexYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public ToIndexYCFReferenceEditor() {
			super( new ToIndexReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.ToIndex.EffLabel" );
		}
	}

	protected class NarrowedRelationYCFLabel
		extends YCFLabel
	{
		public NarrowedRelationYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.LookupNarrowed.EffLabel"));
		}
	}

	protected class CallbackNarrowedRelationChosen
	implements IBusModelJavaFXRelationChosen
	{
		public CallbackNarrowedRelationChosen() {
		}

		public void choseRelation( IBusModelRelationObj value ) {
			if( javafxReferenceLookupNarrowed != null ) {
				IBusModelRelationObj cur = getJavaFXFocusAsRelation();
				if( cur != null ) {
					IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupNarrowed.setReferencedObject( value );
							editObj.setOptionalLookupNarrowed( value );
						}
					}
				}
			}
		}
	}

	protected class NarrowedRelationReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelRelationObj focus = getEffJavaFXFocus();
			IBusModelRelationObj referencedObj = (IBusModelRelationObj)javafxReferenceLookupNarrowed.getReferencedObject();
			java.util.List<IBusModelRelationObj> listOfRelation = null;
			IBusModelTableObj refFromTable = (IBusModelTableObj)focus.getRequiredContainerFromTable( javafxIsInitializing );
			if( refFromTable == null ) {
				YCFConsole.message( String.format(Inz.s("ycflibjavafx.common.SpecifyRelationBeforeSelectingTarget"), Inz.s("busmodel.javafx.Relation.AttrPane.ContainerFromTable.EffLabel"), Inz.s("busmodel.javafx.Relation.AttrPane.LookupNarrowed.EffLabel")));
				return;
			}
			listOfRelation = refFromTable.getOptionalComponentsRelation( javafxIsInitializing );
			if( listOfRelation == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfRelation" );
			}
			Collection<IBusModelRelationObj> cltn = listOfRelation;
			YCFBorderPane form = javafxSchema.getRelationFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackNarrowedRelationChosen() );
			((IBusModelJavaFXRelationPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelRelationObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelRelationObj referencedObj = (IBusModelRelationObj)javafxReferenceLookupNarrowed.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelRelation.CLASS_CODE ) {
						form = javafxSchema.getRelationFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXRelationPaneCommon spec = (IBusModelJavaFXRelationPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelRelationObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class NarrowedRelationYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public NarrowedRelationYCFReferenceEditor() {
			super( new NarrowedRelationReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.NarrowedRelation.EffLabel" );
		}
	}

	protected class IdYCFLabel
		extends YCFLabel
	{
		public IdYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Scope.AttrPane.Id.EffLabel"));
		}
	}

	protected class IdEditor
		extends YCFDbKeyHash256Editor
	{
		public IdEditor() {
			super();
			setFieldNameInzTag( "busmodel.javafx.Scope.AttrPane.Id.EffLabel" );
		}
	}

	protected class NameYCFLabel
		extends YCFLabel
	{
		public NameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.Name.EffLabel"));
		}
	}

	protected class NameEditor
		extends YCFStringEditor
	{
		public NameEditor() {
			super();
			setMaxLen( 192 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.Name.EffLabel" );
		}
	}

	protected class ShortNameYCFLabel
		extends YCFLabel
	{
		public ShortNameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.ShortName.EffLabel"));
		}
	}

	protected class ShortNameEditor
		extends YCFStringEditor
	{
		public ShortNameEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.ShortName.EffLabel" );
		}
	}

	protected class LabelYCFLabel
		extends YCFLabel
	{
		public LabelYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.Label.EffLabel"));
		}
	}

	protected class LabelEditor
		extends YCFStringEditor
	{
		public LabelEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.Label.EffLabel" );
		}
	}

	protected class ShortDescriptionYCFLabel
		extends YCFLabel
	{
		public ShortDescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.ShortDescription.EffLabel"));
		}
	}

	protected class ShortDescriptionEditor
		extends YCFStringEditor
	{
		public ShortDescriptionEditor() {
			super();
			setMaxLen( 128 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.ShortDescription.EffLabel" );
		}
	}

	protected class DescriptionYCFLabel
		extends YCFLabel
	{
		public DescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.Description.EffLabel"));
		}
	}

	protected class DescriptionEditor
		extends YCFStringEditor
	{
		public DescriptionEditor() {
			super();
			setMaxLen( 1023 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.Description.EffLabel" );
		}
	}

	protected class RelationTypeYCFLabel
		extends YCFLabel
	{
		public RelationTypeYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.RelationType.EffLabel"));
		}
	}

	protected class RelationTypeEditor
		extends ComboBox<String>
	{
		public RelationTypeEditor() {
			super();
			setItems( observableListOfRelationType );
		}
	}

	protected class DbNameYCFLabel
		extends YCFLabel
	{
		public DbNameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.DbName.EffLabel"));
		}
	}

	protected class DbNameEditor
		extends YCFStringEditor
	{
		public DbNameEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.DbName.EffLabel" );
		}
	}

	protected class SuffixYCFLabel
		extends YCFLabel
	{
		public SuffixYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.Suffix.EffLabel"));
		}
	}

	protected class SuffixEditor
		extends YCFStringEditor
	{
		public SuffixEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.Suffix.EffLabel" );
		}
	}

	protected class IsRequiredYCFLabel
		extends YCFLabel
	{
		public IsRequiredYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.IsRequired.EffLabel"));
		}
	}

	protected class IsRequiredEditor
		extends YCFBoolEditor
	{
		public IsRequiredEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.IsRequired.EffLabel" );
		}
	}

	protected class IsXsdContainerYCFLabel
		extends YCFLabel
	{
		public IsXsdContainerYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.IsXsdContainer.EffLabel"));
		}
	}

	protected class IsXsdContainerEditor
		extends YCFBoolEditor
	{
		public IsXsdContainerEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.IsXsdContainer.EffLabel" );
		}
	}

	protected class IsLateResolverYCFLabel
		extends YCFLabel
	{
		public IsLateResolverYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.IsLateResolver.EffLabel"));
		}
	}

	protected class IsLateResolverEditor
		extends YCFBoolEditor
	{
		public IsLateResolverEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.IsLateResolver.EffLabel" );
		}
	}

	protected class AllowAddendumYCFLabel
		extends YCFLabel
	{
		public AllowAddendumYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.AllowAddendum.EffLabel"));
		}
	}

	protected class AllowAddendumEditor
		extends YCFBoolEditor
	{
		public AllowAddendumEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Relation.AttrPane.AllowAddendum.EffLabel" );
		}
	}

	protected class CodeVisYCFLabel
		extends YCFLabel
	{
		public CodeVisYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Relation.AttrPane.CodeVis.EffLabel"));
		}
	}

	protected class CodeVisEditor
		extends ComboBox<String>
	{
		public CodeVisEditor() {
			super();
			setItems( observableListOfCodeVis );
		}
	}

	protected IBusModelSchemaDefObj javafxLookupDefSchemaObj = null;
	protected DefSchemaYCFLabel javafxLabelLookupDefSchema = null;
	protected DefSchemaYCFReferenceEditor javafxReferenceLookupDefSchema = null;
	protected IBusModelIndexObj javafxLookupFromIndexObj = null;
	protected FromIndexYCFLabel javafxLabelLookupFromIndex = null;
	protected FromIndexYCFReferenceEditor javafxReferenceLookupFromIndex = null;
	protected IBusModelTableObj javafxLookupToTableObj = null;
	protected ToTableYCFLabel javafxLabelLookupToTable = null;
	protected ToTableYCFReferenceEditor javafxReferenceLookupToTable = null;
	protected IBusModelIndexObj javafxLookupToIndexObj = null;
	protected ToIndexYCFLabel javafxLabelLookupToIndex = null;
	protected ToIndexYCFReferenceEditor javafxReferenceLookupToIndex = null;
	protected IBusModelRelationObj javafxLookupNarrowedObj = null;
	protected NarrowedRelationYCFLabel javafxLabelLookupNarrowed = null;
	protected NarrowedRelationYCFReferenceEditor javafxReferenceLookupNarrowed = null;
	protected IdYCFLabel javafxLabelId = null;
	protected IdEditor javafxEditorId = null;
	protected NameYCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected ShortNameYCFLabel javafxLabelShortName = null;
	protected ShortNameEditor javafxEditorShortName = null;
	protected LabelYCFLabel javafxLabelLabel = null;
	protected LabelEditor javafxEditorLabel = null;
	protected ShortDescriptionYCFLabel javafxLabelShortDescription = null;
	protected ShortDescriptionEditor javafxEditorShortDescription = null;
	protected DescriptionYCFLabel javafxLabelDescription = null;
	protected DescriptionEditor javafxEditorDescription = null;
	protected RelationTypeYCFLabel javafxLabelRelationType = null;
	protected RelationTypeEditor javafxEditorRelationType = null;
	protected DbNameYCFLabel javafxLabelDbName = null;
	protected DbNameEditor javafxEditorDbName = null;
	protected SuffixYCFLabel javafxLabelSuffix = null;
	protected SuffixEditor javafxEditorSuffix = null;
	protected IsRequiredYCFLabel javafxLabelIsRequired = null;
	protected IsRequiredEditor javafxEditorIsRequired = null;
	protected IsXsdContainerYCFLabel javafxLabelIsXsdContainer = null;
	protected IsXsdContainerEditor javafxEditorIsXsdContainer = null;
	protected IsLateResolverYCFLabel javafxLabelIsLateResolver = null;
	protected IsLateResolverEditor javafxEditorIsLateResolver = null;
	protected AllowAddendumYCFLabel javafxLabelAllowAddendum = null;
	protected AllowAddendumEditor javafxEditorAllowAddendum = null;
	protected CodeVisYCFLabel javafxLabelCodeVis = null;
	protected CodeVisEditor javafxEditorCodeVis = null;

	public BusModelJavaFXRelationAttrPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelRelationObj argFocus ) {
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
		setJavaFXFocusAsRelation( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelLookupDefSchema();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupDefSchema();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupFromIndex();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupFromIndex();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupToTable();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupToTable();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupToIndex();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupToIndex();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupNarrowed();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupNarrowed();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelShortName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorShortName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLabel();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorLabel();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelShortDescription();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorShortDescription();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDescription();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDescription();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelRelationType();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorRelationType();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDbName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDbName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelSuffix();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSuffix();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsRequired();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsRequired();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsXsdContainer();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsXsdContainer();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsLateResolver();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsLateResolver();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelAllowAddendum();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorAllowAddendum();
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

	public IBusModelJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelRelationObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelRelationObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public IBusModelRelationObj getJavaFXFocusAsRelation() {
		return( (IBusModelRelationObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsRelation( IBusModelRelationObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelRelationObj getEffJavaFXFocus() {
		IBusModelRelationObj eff = (IBusModelRelationObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (IBusModelRelationObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public IBusModelSchemaDefObj getJavaFXLookupDefSchemaObj() {
		return( javafxLookupDefSchemaObj );
	}

	public void setJavaFXLookupDefSchemaObj( IBusModelSchemaDefObj value ) {
		javafxLookupDefSchemaObj = value;
	}

	public YCFLabel getJavaFXLabelLookupDefSchema() {
		if( javafxLabelLookupDefSchema == null ) {
			javafxLabelLookupDefSchema = new DefSchemaYCFLabel();
		}
		return( javafxLabelLookupDefSchema );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupDefSchema() {
		if( javafxReferenceLookupDefSchema == null ) {
			javafxReferenceLookupDefSchema = new DefSchemaYCFReferenceEditor();
		}
		return( javafxReferenceLookupDefSchema );
	}

	public void setJavaFXReferenceLookupDefSchema( DefSchemaYCFReferenceEditor value ) {
		javafxReferenceLookupDefSchema = value;
	}

	public IBusModelIndexObj getJavaFXLookupFromIndexObj() {
		return( javafxLookupFromIndexObj );
	}

	public void setJavaFXLookupFromIndexObj( IBusModelIndexObj value ) {
		javafxLookupFromIndexObj = value;
	}

	public YCFLabel getJavaFXLabelLookupFromIndex() {
		if( javafxLabelLookupFromIndex == null ) {
			javafxLabelLookupFromIndex = new FromIndexYCFLabel();
		}
		return( javafxLabelLookupFromIndex );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupFromIndex() {
		if( javafxReferenceLookupFromIndex == null ) {
			javafxReferenceLookupFromIndex = new FromIndexYCFReferenceEditor();
		}
		return( javafxReferenceLookupFromIndex );
	}

	public void setJavaFXReferenceLookupFromIndex( FromIndexYCFReferenceEditor value ) {
		javafxReferenceLookupFromIndex = value;
	}

	public IBusModelTableObj getJavaFXLookupToTableObj() {
		return( javafxLookupToTableObj );
	}

	public void setJavaFXLookupToTableObj( IBusModelTableObj value ) {
		javafxLookupToTableObj = value;
	}

	public YCFLabel getJavaFXLabelLookupToTable() {
		if( javafxLabelLookupToTable == null ) {
			javafxLabelLookupToTable = new ToTableYCFLabel();
		}
		return( javafxLabelLookupToTable );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupToTable() {
		if( javafxReferenceLookupToTable == null ) {
			javafxReferenceLookupToTable = new ToTableYCFReferenceEditor();
		}
		return( javafxReferenceLookupToTable );
	}

	public void setJavaFXReferenceLookupToTable( ToTableYCFReferenceEditor value ) {
		javafxReferenceLookupToTable = value;
	}

	public IBusModelIndexObj getJavaFXLookupToIndexObj() {
		return( javafxLookupToIndexObj );
	}

	public void setJavaFXLookupToIndexObj( IBusModelIndexObj value ) {
		javafxLookupToIndexObj = value;
	}

	public YCFLabel getJavaFXLabelLookupToIndex() {
		if( javafxLabelLookupToIndex == null ) {
			javafxLabelLookupToIndex = new ToIndexYCFLabel();
		}
		return( javafxLabelLookupToIndex );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupToIndex() {
		if( javafxReferenceLookupToIndex == null ) {
			javafxReferenceLookupToIndex = new ToIndexYCFReferenceEditor();
		}
		return( javafxReferenceLookupToIndex );
	}

	public void setJavaFXReferenceLookupToIndex( ToIndexYCFReferenceEditor value ) {
		javafxReferenceLookupToIndex = value;
	}

	public IBusModelRelationObj getJavaFXLookupNarrowedObj() {
		return( javafxLookupNarrowedObj );
	}

	public void setJavaFXLookupNarrowedObj( IBusModelRelationObj value ) {
		javafxLookupNarrowedObj = value;
	}

	public YCFLabel getJavaFXLabelLookupNarrowed() {
		if( javafxLabelLookupNarrowed == null ) {
			javafxLabelLookupNarrowed = new NarrowedRelationYCFLabel();
		}
		return( javafxLabelLookupNarrowed );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupNarrowed() {
		if( javafxReferenceLookupNarrowed == null ) {
			javafxReferenceLookupNarrowed = new NarrowedRelationYCFReferenceEditor();
		}
		return( javafxReferenceLookupNarrowed );
	}

	public void setJavaFXReferenceLookupNarrowed( NarrowedRelationYCFReferenceEditor value ) {
		javafxReferenceLookupNarrowed = value;
	}

	public IdYCFLabel getJavaFXLabelId() {
		if( javafxLabelId == null ) {
			javafxLabelId = new IdYCFLabel();
		}
		return( javafxLabelId );
	}

	public void setJavaFXLabelId( IdYCFLabel value ) {
		javafxLabelId = value;
	}

	public IdEditor getJavaFXEditorId() {
		if( javafxEditorId == null ) {
			javafxEditorId = new IdEditor();
		}
		return( javafxEditorId );
	}

	public void setJavaFXEditorId( IdEditor value ) {
		javafxEditorId = value;
	}

	public NameYCFLabel getJavaFXLabelName() {
		if( javafxLabelName == null ) {
			javafxLabelName = new NameYCFLabel();
		}
		return( javafxLabelName );
	}

	public void setJavaFXLabelName( NameYCFLabel value ) {
		javafxLabelName = value;
	}

	public NameEditor getJavaFXEditorName() {
		if( javafxEditorName == null ) {
			javafxEditorName = new NameEditor();
		}
		return( javafxEditorName );
	}

	public void setJavaFXEditorName( NameEditor value ) {
		javafxEditorName = value;
	}

	public ShortNameYCFLabel getJavaFXLabelShortName() {
		if( javafxLabelShortName == null ) {
			javafxLabelShortName = new ShortNameYCFLabel();
		}
		return( javafxLabelShortName );
	}

	public void setJavaFXLabelShortName( ShortNameYCFLabel value ) {
		javafxLabelShortName = value;
	}

	public ShortNameEditor getJavaFXEditorShortName() {
		if( javafxEditorShortName == null ) {
			javafxEditorShortName = new ShortNameEditor();
		}
		return( javafxEditorShortName );
	}

	public void setJavaFXEditorShortName( ShortNameEditor value ) {
		javafxEditorShortName = value;
	}

	public LabelYCFLabel getJavaFXLabelLabel() {
		if( javafxLabelLabel == null ) {
			javafxLabelLabel = new LabelYCFLabel();
		}
		return( javafxLabelLabel );
	}

	public void setJavaFXLabelLabel( LabelYCFLabel value ) {
		javafxLabelLabel = value;
	}

	public LabelEditor getJavaFXEditorLabel() {
		if( javafxEditorLabel == null ) {
			javafxEditorLabel = new LabelEditor();
		}
		return( javafxEditorLabel );
	}

	public void setJavaFXEditorLabel( LabelEditor value ) {
		javafxEditorLabel = value;
	}

	public ShortDescriptionYCFLabel getJavaFXLabelShortDescription() {
		if( javafxLabelShortDescription == null ) {
			javafxLabelShortDescription = new ShortDescriptionYCFLabel();
		}
		return( javafxLabelShortDescription );
	}

	public void setJavaFXLabelShortDescription( ShortDescriptionYCFLabel value ) {
		javafxLabelShortDescription = value;
	}

	public ShortDescriptionEditor getJavaFXEditorShortDescription() {
		if( javafxEditorShortDescription == null ) {
			javafxEditorShortDescription = new ShortDescriptionEditor();
		}
		return( javafxEditorShortDescription );
	}

	public void setJavaFXEditorShortDescription( ShortDescriptionEditor value ) {
		javafxEditorShortDescription = value;
	}

	public DescriptionYCFLabel getJavaFXLabelDescription() {
		if( javafxLabelDescription == null ) {
			javafxLabelDescription = new DescriptionYCFLabel();
		}
		return( javafxLabelDescription );
	}

	public void setJavaFXLabelDescription( DescriptionYCFLabel value ) {
		javafxLabelDescription = value;
	}

	public DescriptionEditor getJavaFXEditorDescription() {
		if( javafxEditorDescription == null ) {
			javafxEditorDescription = new DescriptionEditor();
		}
		return( javafxEditorDescription );
	}

	public void setJavaFXEditorDescription( DescriptionEditor value ) {
		javafxEditorDescription = value;
	}

	public RelationTypeYCFLabel getJavaFXLabelRelationType() {
		if( javafxLabelRelationType == null ) {
			javafxLabelRelationType = new RelationTypeYCFLabel();
		}
		return( javafxLabelRelationType );
	}

	public void setJavaFXLabelRelationType( RelationTypeYCFLabel value ) {
		javafxLabelRelationType = value;
	}

	public RelationTypeEditor getJavaFXEditorRelationType() {
		if( javafxEditorRelationType == null ) {
			javafxEditorRelationType = new RelationTypeEditor();
		}
		return( javafxEditorRelationType );
	}

	public void setJavaFXEditorRelationType( RelationTypeEditor value ) {
		javafxEditorRelationType = value;
	}

	public DbNameYCFLabel getJavaFXLabelDbName() {
		if( javafxLabelDbName == null ) {
			javafxLabelDbName = new DbNameYCFLabel();
		}
		return( javafxLabelDbName );
	}

	public void setJavaFXLabelDbName( DbNameYCFLabel value ) {
		javafxLabelDbName = value;
	}

	public DbNameEditor getJavaFXEditorDbName() {
		if( javafxEditorDbName == null ) {
			javafxEditorDbName = new DbNameEditor();
		}
		return( javafxEditorDbName );
	}

	public void setJavaFXEditorDbName( DbNameEditor value ) {
		javafxEditorDbName = value;
	}

	public SuffixYCFLabel getJavaFXLabelSuffix() {
		if( javafxLabelSuffix == null ) {
			javafxLabelSuffix = new SuffixYCFLabel();
		}
		return( javafxLabelSuffix );
	}

	public void setJavaFXLabelSuffix( SuffixYCFLabel value ) {
		javafxLabelSuffix = value;
	}

	public SuffixEditor getJavaFXEditorSuffix() {
		if( javafxEditorSuffix == null ) {
			javafxEditorSuffix = new SuffixEditor();
		}
		return( javafxEditorSuffix );
	}

	public void setJavaFXEditorSuffix( SuffixEditor value ) {
		javafxEditorSuffix = value;
	}

	public IsRequiredYCFLabel getJavaFXLabelIsRequired() {
		if( javafxLabelIsRequired == null ) {
			javafxLabelIsRequired = new IsRequiredYCFLabel();
		}
		return( javafxLabelIsRequired );
	}

	public void setJavaFXLabelIsRequired( IsRequiredYCFLabel value ) {
		javafxLabelIsRequired = value;
	}

	public IsRequiredEditor getJavaFXEditorIsRequired() {
		if( javafxEditorIsRequired == null ) {
			javafxEditorIsRequired = new IsRequiredEditor();
		}
		return( javafxEditorIsRequired );
	}

	public void setJavaFXEditorIsRequired( IsRequiredEditor value ) {
		javafxEditorIsRequired = value;
	}

	public IsXsdContainerYCFLabel getJavaFXLabelIsXsdContainer() {
		if( javafxLabelIsXsdContainer == null ) {
			javafxLabelIsXsdContainer = new IsXsdContainerYCFLabel();
		}
		return( javafxLabelIsXsdContainer );
	}

	public void setJavaFXLabelIsXsdContainer( IsXsdContainerYCFLabel value ) {
		javafxLabelIsXsdContainer = value;
	}

	public IsXsdContainerEditor getJavaFXEditorIsXsdContainer() {
		if( javafxEditorIsXsdContainer == null ) {
			javafxEditorIsXsdContainer = new IsXsdContainerEditor();
		}
		return( javafxEditorIsXsdContainer );
	}

	public void setJavaFXEditorIsXsdContainer( IsXsdContainerEditor value ) {
		javafxEditorIsXsdContainer = value;
	}

	public IsLateResolverYCFLabel getJavaFXLabelIsLateResolver() {
		if( javafxLabelIsLateResolver == null ) {
			javafxLabelIsLateResolver = new IsLateResolverYCFLabel();
		}
		return( javafxLabelIsLateResolver );
	}

	public void setJavaFXLabelIsLateResolver( IsLateResolverYCFLabel value ) {
		javafxLabelIsLateResolver = value;
	}

	public IsLateResolverEditor getJavaFXEditorIsLateResolver() {
		if( javafxEditorIsLateResolver == null ) {
			javafxEditorIsLateResolver = new IsLateResolverEditor();
		}
		return( javafxEditorIsLateResolver );
	}

	public void setJavaFXEditorIsLateResolver( IsLateResolverEditor value ) {
		javafxEditorIsLateResolver = value;
	}

	public AllowAddendumYCFLabel getJavaFXLabelAllowAddendum() {
		if( javafxLabelAllowAddendum == null ) {
			javafxLabelAllowAddendum = new AllowAddendumYCFLabel();
		}
		return( javafxLabelAllowAddendum );
	}

	public void setJavaFXLabelAllowAddendum( AllowAddendumYCFLabel value ) {
		javafxLabelAllowAddendum = value;
	}

	public AllowAddendumEditor getJavaFXEditorAllowAddendum() {
		if( javafxEditorAllowAddendum == null ) {
			javafxEditorAllowAddendum = new AllowAddendumEditor();
		}
		return( javafxEditorAllowAddendum );
	}

	public void setJavaFXEditorAllowAddendum( AllowAddendumEditor value ) {
		javafxEditorAllowAddendum = value;
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
		IBusModelRelationObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxLookupDefSchemaObj = null;
		}
		else {
			javafxLookupDefSchemaObj = (IBusModelSchemaDefObj)popObj.getOptionalLookupDefSchema( javafxIsInitializing );
		}
		if( javafxReferenceLookupDefSchema != null ) {
			javafxReferenceLookupDefSchema.setReferencedObject( javafxLookupDefSchemaObj );
		}

		if( popObj == null ) {
			javafxLookupFromIndexObj = null;
		}
		else {
			javafxLookupFromIndexObj = (IBusModelIndexObj)popObj.getRequiredLookupFromIndex( javafxIsInitializing );
		}
		if( javafxReferenceLookupFromIndex != null ) {
			javafxReferenceLookupFromIndex.setReferencedObject( javafxLookupFromIndexObj );
		}

		if( popObj == null ) {
			javafxLookupToTableObj = null;
		}
		else {
			javafxLookupToTableObj = (IBusModelTableObj)popObj.getRequiredLookupToTable( javafxIsInitializing );
		}
		if( javafxReferenceLookupToTable != null ) {
			javafxReferenceLookupToTable.setReferencedObject( javafxLookupToTableObj );
		}

		if( popObj == null ) {
			javafxLookupToIndexObj = null;
		}
		else {
			javafxLookupToIndexObj = (IBusModelIndexObj)popObj.getRequiredLookupToIndex( javafxIsInitializing );
		}
		if( javafxReferenceLookupToIndex != null ) {
			javafxReferenceLookupToIndex.setReferencedObject( javafxLookupToIndexObj );
		}

		if( popObj == null ) {
			javafxLookupNarrowedObj = null;
		}
		else {
			javafxLookupNarrowedObj = (IBusModelRelationObj)popObj.getOptionalLookupNarrowed( javafxIsInitializing );
		}
		if( javafxReferenceLookupNarrowed != null ) {
			javafxReferenceLookupNarrowed.setReferencedObject( javafxLookupNarrowedObj );
		}

		if( popObj == null ) {
			getJavaFXEditorId().setDbKeyHash256Value( null );
		}
		else {
			getJavaFXEditorId().setDbKeyHash256Value( popObj.getRequiredId() );
		}

		if( popObj == null ) {
			getJavaFXEditorName().setStringValue( null );
		}
		else {
			getJavaFXEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getJavaFXEditorShortName().setStringValue( null );
		}
		else {
			getJavaFXEditorShortName().setStringValue( popObj.getOptionalShortName() );
		}

		if( popObj == null ) {
			getJavaFXEditorLabel().setStringValue( null );
		}
		else {
			getJavaFXEditorLabel().setStringValue( popObj.getOptionalLabel() );
		}

		if( popObj == null ) {
			getJavaFXEditorShortDescription().setStringValue( null );
		}
		else {
			getJavaFXEditorShortDescription().setStringValue( popObj.getOptionalShortDescription() );
		}

		if( popObj == null ) {
			getJavaFXEditorDescription().setStringValue( null );
		}
		else {
			getJavaFXEditorDescription().setStringValue( popObj.getOptionalDescription() );
		}

		if( popObj == null ) {
			getJavaFXEditorRelationType().setValue( null );
		}
		else {
			getJavaFXEditorRelationType().setValue(
				( popObj.getRequiredRelationType() == null )
					? null
					: popObj.getRequiredRelationType().toString() );
		}

		if( popObj == null ) {
			getJavaFXEditorDbName().setStringValue( null );
		}
		else {
			getJavaFXEditorDbName().setStringValue( popObj.getOptionalDbName() );
		}

		if( popObj == null ) {
			getJavaFXEditorSuffix().setStringValue( null );
		}
		else {
			getJavaFXEditorSuffix().setStringValue( popObj.getOptionalSuffix() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsRequired().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsRequired().setBooleanValue( popObj.getRequiredIsRequired() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsXsdContainer().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsXsdContainer().setBooleanValue( popObj.getRequiredIsXsdContainer() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsLateResolver().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsLateResolver().setBooleanValue( popObj.getRequiredIsLateResolver() );
		}

		if( popObj == null ) {
			getJavaFXEditorAllowAddendum().setBooleanValue( null );
		}
		else {
			getJavaFXEditorAllowAddendum().setBooleanValue( popObj.getRequiredAllowAddendum() );
		}

		if( popObj == null ) {
			getJavaFXEditorCodeVis().setValue( null );
		}
		else {
			getJavaFXEditorCodeVis().setValue(
				( popObj.getRequiredCodeVis() == null )
					? null
					: popObj.getRequiredCodeVis().toString() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		IBusModelRelationObj focus = getJavaFXFocusAsRelation();
		IBusModelRelationEditObj editObj;
		if( focus != null ) {
			editObj = (IBusModelRelationEditObj)(focus.getEdit());
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

		javafxLookupDefSchemaObj = (IBusModelSchemaDefObj)( javafxReferenceLookupDefSchema.getReferencedObject() );
		editObj.setOptionalLookupDefSchema( javafxLookupDefSchemaObj );

		javafxLookupFromIndexObj = (IBusModelIndexObj)( javafxReferenceLookupFromIndex.getReferencedObject() );
		editObj.setRequiredLookupFromIndex( javafxLookupFromIndexObj );

		javafxLookupToTableObj = (IBusModelTableObj)( javafxReferenceLookupToTable.getReferencedObject() );
		editObj.setRequiredLookupToTable( javafxLookupToTableObj );

		javafxLookupToIndexObj = (IBusModelIndexObj)( javafxReferenceLookupToIndex.getReferencedObject() );
		editObj.setRequiredLookupToIndex( javafxLookupToIndexObj );

		javafxLookupNarrowedObj = (IBusModelRelationObj)( javafxReferenceLookupNarrowed.getReferencedObject() );
		editObj.setOptionalLookupNarrowed( javafxLookupNarrowedObj );

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( ( getJavaFXEditorShortName().getStringValue() != null ) && ( getJavaFXEditorShortName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalShortName( null );
		}
		else {
			editObj.setOptionalShortName( getJavaFXEditorShortName().getStringValue() );
		}

		if( ( getJavaFXEditorLabel().getStringValue() != null ) && ( getJavaFXEditorLabel().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalLabel( null );
		}
		else {
			editObj.setOptionalLabel( getJavaFXEditorLabel().getStringValue() );
		}

		if( ( getJavaFXEditorShortDescription().getStringValue() != null ) && ( getJavaFXEditorShortDescription().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalShortDescription( null );
		}
		else {
			editObj.setOptionalShortDescription( getJavaFXEditorShortDescription().getStringValue() );
		}

		if( ( getJavaFXEditorDescription().getStringValue() != null ) && ( getJavaFXEditorDescription().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDescription( null );
		}
		else {
			editObj.setOptionalDescription( getJavaFXEditorDescription().getStringValue() );
		}

		String strrelationtype = getJavaFXEditorRelationType().getValue();
		IBusModelSchema.RelationTypeEnum currelationtype = IBusModelSchema.parseRelationTypeEnum( "RelationType", strrelationtype );
		editObj.setRequiredRelationType( currelationtype );

		if( ( getJavaFXEditorDbName().getStringValue() != null ) && ( getJavaFXEditorDbName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDbName( null );
		}
		else {
			editObj.setOptionalDbName( getJavaFXEditorDbName().getStringValue() );
		}

		if( ( getJavaFXEditorSuffix().getStringValue() != null ) && ( getJavaFXEditorSuffix().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalSuffix( null );
		}
		else {
			editObj.setOptionalSuffix( getJavaFXEditorSuffix().getStringValue() );
		}

		editObj.setRequiredIsRequired( getJavaFXEditorIsRequired().getBooleanValue() );

		editObj.setRequiredIsXsdContainer( getJavaFXEditorIsXsdContainer().getBooleanValue() );

		editObj.setRequiredIsLateResolver( getJavaFXEditorIsLateResolver().getBooleanValue() );

		editObj.setRequiredAllowAddendum( getJavaFXEditorAllowAddendum().getBooleanValue() );

		String strcodevis = getJavaFXEditorCodeVis().getValue();
		IBusModelSchema.CodeVisibilityEnum curcodevis = IBusModelSchema.parseCodeVisibilityEnum( "CodeVis", strcodevis );
		editObj.setRequiredCodeVis( curcodevis );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		IBusModelRelationObj focus = getJavaFXFocusAsRelation();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		IBusModelRelationEditObj editObj;
		if( focus != null ) {
			editObj  = (IBusModelRelationEditObj)focus.getEdit();
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
								editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
							editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
							editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
							editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
						focus = (IBusModelRelationObj)editObj.create();
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
								editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
								editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
							editObj = (IBusModelRelationEditObj)focus.beginEdit();
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
			IBusModelRelationObj focus = getJavaFXFocusAsRelation();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceLookupDefSchema != null ) {
			javafxReferenceLookupDefSchema.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupFromIndex != null ) {
			javafxReferenceLookupFromIndex.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupToTable != null ) {
			javafxReferenceLookupToTable.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupToIndex != null ) {
			javafxReferenceLookupToIndex.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupNarrowed != null ) {
			javafxReferenceLookupNarrowed.setCustomDisable( ! isEditing );
		}
		if( javafxEditorId != null ) {
			javafxEditorId.setDisable( true );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorShortName != null ) {
			javafxEditorShortName.setDisable( ! isEditing );
		}
		if( javafxEditorLabel != null ) {
			javafxEditorLabel.setDisable( ! isEditing );
		}
		if( javafxEditorShortDescription != null ) {
			javafxEditorShortDescription.setDisable( ! isEditing );
		}
		if( javafxEditorDescription != null ) {
			javafxEditorDescription.setDisable( ! isEditing );
		}
		if( javafxEditorRelationType != null ) {
			javafxEditorRelationType.setDisable( ! isEditing );
		}
		if( javafxEditorDbName != null ) {
			javafxEditorDbName.setDisable( ! isEditing );
		}
		if( javafxEditorSuffix != null ) {
			javafxEditorSuffix.setDisable( ! isEditing );
		}
		if( javafxEditorIsRequired != null ) {
			javafxEditorIsRequired.setDisable( ! isEditing );
		}
		if( javafxEditorIsXsdContainer != null ) {
			javafxEditorIsXsdContainer.setDisable( ! isEditing );
		}
		if( javafxEditorIsLateResolver != null ) {
			javafxEditorIsLateResolver.setDisable( ! isEditing );
		}
		if( javafxEditorAllowAddendum != null ) {
			javafxEditorAllowAddendum.setDisable( ! isEditing );
		}
		if( javafxEditorCodeVis != null ) {
			javafxEditorCodeVis.setDisable( ! isEditing );
		}
	}
}
