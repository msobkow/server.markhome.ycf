// Description: Java 25 JavaFX Display Element Factory Interface for TopProject.

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
 *	IIntNetJavaFXTopProjectFactory JavaFX Display Element Factory Interface
 *	for TopProject.
 */
public interface IIntNetJavaFXTopProjectFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetTopProjectObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetTopDomainObj argContainer,
		IIntNetTopProjectObj argFocus,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetTopProjectObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IIntNetJavaFXTopProjectChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, IIntNetTopProjectObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetTopProjectObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, IIntNetTopProjectObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, IIntNetTopProjectObj javaFXFocus );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetTopProjectObj javaFXFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetTopProjectObj> argDataCollection,
		IIntNetJavaFXTopProjectChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetTopProjectObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetTopProjectObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
