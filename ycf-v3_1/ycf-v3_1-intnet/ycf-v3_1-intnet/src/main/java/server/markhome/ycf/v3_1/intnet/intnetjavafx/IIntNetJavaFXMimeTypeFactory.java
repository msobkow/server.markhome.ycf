// Description: Java 25 JavaFX Display Element Factory Interface for MimeType.

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
 *	IIntNetJavaFXMimeTypeFactory JavaFX Display Element Factory Interface
 *	for MimeType.
 */
public interface IIntNetJavaFXMimeTypeFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetMimeTypeObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		IIntNetMimeTypeObj argFocus,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetMimeTypeObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IIntNetJavaFXMimeTypeChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, IIntNetMimeTypeObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetMimeTypeObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, IIntNetMimeTypeObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, IIntNetMimeTypeObj javaFXFocus );

	public YCFBorderPane newFinderForm( IYCFFormManager formManager );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetMimeTypeObj javaFXFocus,
		IYCFLibAnyObj argContainer,
		Collection<IIntNetMimeTypeObj> argDataCollection,
		IIntNetJavaFXMimeTypeChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetMimeTypeObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetMimeTypeObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
