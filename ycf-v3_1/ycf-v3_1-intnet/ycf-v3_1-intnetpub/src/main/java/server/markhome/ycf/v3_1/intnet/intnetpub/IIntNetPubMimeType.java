// Description: Java 25 public interface for a MimeType record implementation

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

package server.markhome.ycf.v3_1.intnet.intnetpub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
//import server.markhome.ycf.v3_1.intnet.intnetpub.*;

/**
 *	IIntNetPubMimeType persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetPubMimeType
{
	public static final int MIMETYPEID_MIN_VALUE = 0;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final int MIMETYPEID_INIT_VALUE = 0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String FILETYPES_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa103;
	public final static String S_CLASS_CODE = "a103";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public Integer getPKey();
	public void setPKey(Integer requiredMimeTypeId);
	public int getRequiredMimeTypeId();
	public void setRequiredMimeTypeId( int value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalFileTypes();
	public void setOptionalFileTypes( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IIntNetPubMimeType src );

	public void setMimeType( IIntNetPubMimeType src );

	public void set( IIntNetPubMimeTypeH src );

	public void setMimeType( IIntNetPubMimeTypeH src );

	public String getXmlAttrFragment();

	public String toString();
}
