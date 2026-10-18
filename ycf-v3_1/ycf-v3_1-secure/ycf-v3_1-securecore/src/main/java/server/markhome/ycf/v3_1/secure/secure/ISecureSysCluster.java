// Description: Java 25 interface for a SysCluster record declementation

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

package server.markhome.ycf.v3_1.secure.secure;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureSysCluster persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureSysCluster
{
	public static final int SINGLETONID_MIN_VALUE = 1;
	public static final int SINGLETONID_MAX_VALUE = 1;
	public static final int SINGLETONID_INIT_VALUE = 1;
	public static final String S_CLUSTERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 CLUSTERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_CLUSTERID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa01f;
	public final static String S_CLASS_CODE = "a01f";

	public int getClassCode();

	public $implCommaIJavaOptAtomType$ getPKey();
	public void setPKey($implCommaIJavaOptAtomType$ requiredSingletonId);
	public int getRequiredSingletonId();
	public void setRequiredSingletonId( int value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ISecureCluster getRequiredContainerCluster();

	public void setRequiredContainerCluster(IYCFKeyHash256 argClusterId);

	public void setRequiredContainerCluster(ISecureCluster argObj);

	public void setRequiredContainerCluster(ISecureProtCluster argObj);

	public void setRequiredContainerCluster(ISecurePubCluster argObj);

	public IYCFKeyHash256 getRequiredClusterId();
	public void setRequiredClusterId( IYCFKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureSysCluster src );

	public void setSysCluster( ISecureSysCluster src );

	public void set( ISecureSysClusterH src );

	public void setSysCluster( ISecureSysClusterH src );

	public void set( ISecureProtSysCluster src );

	public void setSysCluster( ISecureProtSysCluster src );

	public void set( ISecureProtSysClusterH src );

	public void setSysCluster( ISecureProtSysClusterH src );

	public void set( ISecurePubSysCluster src );

	public void setSysCluster( ISecurePubSysCluster src );

	public void set( ISecurePubSysClusterH src );

	public void setSysCluster( ISecurePubSysClusterH src );

	public String getXmlAttrFragment();

	public String toString();
}
