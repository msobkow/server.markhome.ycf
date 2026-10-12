/**
 *	server.markhome.ycf-core - Mark's Code Fractal Core Services
 *
 *	Copyright 2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://apache.org
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 *	SPDX-License-Identifier: Apache-2.0
**/

package server.markhome.ycf;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 *	IYCFFireOnInstanceOf Fires when an instance of the class specified at construction is detected by the <tt>onInstanceOf(value)</tt> method.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFFireOnInstanceOf extends JSObject {

	/**
	 *	IYCFFireOnInstanceOf getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFFireOnInstanceOf The singleton for the implementation.
	 */
	@JSExport
	public IYCFFireOnInstanceOf getSingleton();
	
	protected Class<?> instOf = null;

    public IYCFFireOnInstanceOf() {
    	setInstanceOf( Object.class );
    }

    public void setInstanceOf(Class<?> value) {
    	final String S_ProcName = "setInstanceOf";
        if( value == null ) {
            throw new IYCFNullArgumentException( getClass(),
                S_ProcName,
                1,
                "value" );
        }
        instOf = value;
    }

	public Class<?> getInstanceOf() {
        return( instOf );
    }

    public boolean isInstanceOf( IYCFAnyObj obj ) {
    	if( obj == null ) {
    		return( false );
    	}

    	if( instOf == null ) {
    		return( false );
    	}

    	return( instOf.isInstance( obj ) );
    }

    public void onInstanceOf( IYCFAnyObj obj ) {
        final String S_ProcName = "onInstanceOf";
        if( obj == null ) {
            return;
        }
        throw new IYCFNotImplementedYetException( getClass(),
        	S_ProcName );
    }

    public final void fireOnInstanceOf( IYCFAnyObj obj ) {
    	if( obj == null ) {
    		return;
    	}
        if( isInstanceOf( obj ) ) {
            onInstanceOf( obj );
        }
    }
}
