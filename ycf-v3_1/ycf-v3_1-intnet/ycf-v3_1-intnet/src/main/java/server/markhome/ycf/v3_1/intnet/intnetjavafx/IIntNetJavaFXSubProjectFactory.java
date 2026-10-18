// Description: Java 25 JavaFX Display Element Factory Interface for SubProject.

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
 *	IIntNetJavaFXSubProjectFactory JavaFX Display Element Factory Interface
 *	for SubProject.
 */
public interface IIntNetJavaFXSubProjectFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetSubProjectObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetTopProjectObj argContainer,
		IIntNetSubProjectObj argFocus,
		Collection<IIntNetSubProjectObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetSubProjectObj argFocus,
		IIntNetTopProjectObj argContainer,
		Collection<IIntNetSubProjectObj> argDataCollection,
		IIntNetJavaFXSubProjectChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, IIntNetSubProjectObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetSubProjectObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, IIntNetSubProjectObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, IIntNetSubProjectObj javaFXFocus );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetSubProjectObj javaFXFocus,
		IIntNetTopProjectObj argContainer,
		Collection<IIntNetSubProjectObj> argDataCollection,
		IIntNetJavaFXSubProjectChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetSubProjectObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetSubProjectObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
