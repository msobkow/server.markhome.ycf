// Description: Java 25 JavaFX Display Element Factory Interface for License.

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
 *	IIntNetJavaFXLicenseFactory JavaFX Display Element Factory Interface
 *	for License.
 */
public interface IIntNetJavaFXLicenseFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, IIntNetLicenseObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IIntNetTopDomainObj argContainer,
		IIntNetLicenseObj argFocus,
		Collection<IIntNetLicenseObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		IIntNetLicenseObj argFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetLicenseObj> argDataCollection,
		IIntNetJavaFXLicenseChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, IIntNetLicenseObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, IIntNetLicenseObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, IIntNetLicenseObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, IIntNetLicenseObj javaFXFocus );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		IIntNetLicenseObj javaFXFocus,
		IIntNetTopDomainObj argContainer,
		Collection<IIntNetLicenseObj> argDataCollection,
		IIntNetJavaFXLicenseChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, IIntNetLicenseObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, IIntNetLicenseObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
