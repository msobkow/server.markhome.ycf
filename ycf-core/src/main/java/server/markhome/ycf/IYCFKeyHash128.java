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

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *	IYCFKeyHash128 implements a 128-bit key hash using a HASHALGO algorithm.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFKeyHash128 extends IYCFKeyHashBase<IYCFKeyHash128> {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference singleton = IYCFMtReference.getService().getInstance();

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IYCFKeyHash128 getService() {
		IYCFKeyHash128 ref = ((IYCFKeyHash128)(singleton.get()));
		if (ref == null) {
			ref = new YCFKeyHash128();
			singleton.set(null, ref);
			ref = ((IYCFKeyHash128)(singleton.get()));
		}
		return(ref);
	}

	/**
	 *	IYCFKeyHash128 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash128 The instance implementation.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance() {
		return(new YCFKeyHash128());
	}

	/**
	 *	IYCFKeyHash128 getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash128 The instance implementation with a generated value.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(int i) {
		return(new YCFKeyHash128(i));
	}

	/**
	 *	IYCFKeyHash128 getInstance(s)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(String s) {
		return(new YCFKeyHash128(s));
	}

	/**
	 *	IYCFKeyHash128 getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(byte[] a) {
		return(new YCFKeyHash128(a));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash128 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash160 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash224 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash256 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash384 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash128 getInstance(IYCFKeyHash512 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash128 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public static IYCFKeyHash128 fromInt(int i) {
		return(new YCFKeyHash128(i));
	}

	/**
	 *	IYCFKeyHash128 nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash128 A null instance
	 */
	@JSExport
	public static IYCFKeyHash128 nullGet() {
		return(new YCFKeyHash128());
	}

	/**
	 *	String nullString()
	 *		Get a null value string.
	 *
	 *	@return String The null value string.
	 */
	@JSExport
	public String nullString() {
		return(NULL_STRING);
	}

	/**
	 *	int getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public int getHashLength() {
		return(HASH_LENGTH);
	}

	/**
	 *	int getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public int getHashLengthString() {
		return(HASH_LENGTH_STRING);
	}

	/**
	 *	String getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public String getHashAlgo() {
		return(HASH_ALGO);
	}

	/**
	 *	int compare()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int compare(IYCFKeyHash128 a, IYCFKeyHash128 b) {
		if(a != null) {
			if(b != null) {
				return(a.compare(b));
			}
			else {
				return(1);
			}
		}
		else {
			if(b != null) {
				return(-1);
			}
			else {
				return(0);
			}
		}
	}

	/**
	 *	int compare(b)
	 *		Compare an instance.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compare(IYCFKeyHash128 b) {
		if(b != null) {
			return(Arrays.compare(a.getBytes(), b.getBytes()));
		}
		else {
			return(1);
		}
	}

	/**
	 *	int compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int compareOrdered(IYCFKeyHash128 a, IYCFKeyHash128 b) {
		if(a != null) {
			if(b != null) {
				return(a.compareOrdered(b));
			}
			else {
				return(1);
			}
		}
		else {
			if(b != null) {
				return(-1);
			}
			else {
				return(0);
			}
		}
	}

	/**
	 *	int compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compareOrdered(IYCFKeyHash128 b);

	/**
	 *	void initStatics()
	 *		Initialize the statics.
	 */
	@JSExport
  	public static void initStatics();

	/**
	 *	byte[] sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public static byte[] sbytesFromHex(String s);

	/**
	 *	IYCFKeyHash128 fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public static IYCFKeyHash128 fromHex(String s);

	/**
	 *	Comparator<IYCFKeyHash128> getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public static Comparator<IYCFKeyHash128> getComparator();

	/**
	 *	byte[] getBytes(k)
	 *		Get the byte array for key value k.
	 *
	 *	@param k The key value to be evaluated.
	 *
	 *	@return The byte array for key value k, or null if k is null.
	 */
	@JSExport
	public static byte[] getBytes(IYCFKeyHash128 k) {
		if(k != null) {
			return(k.getBytes());
		}
		else {
			return(null);
		}
	}

	/**
	 *	byte[] getBytes()
	 *		Get the byte array for this key.
	 *
	 *	@return The byte array for this key.
	 */
	@JSExport
	public byte[] getBytes();

	/**
	 *	void setBytes(k, a)
	 *		Set the byte array for key value k to a copy of the byte array a. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 */
	@JSExport
	public static void setBytes(IYCFKeyHash128 k, byte[] a) {
		if(k != null) {
			k.setBytes(a);
		}
		else {
			throw IYCFNullArgumentException.getInstance(YCFKeyHash128.class, "setBytes", 1, "k");
		}
	}

	/**
	 *	void setBytes(a)
	 *		Set the byte array for the key to a copy of the byte array a. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 */
	@JSExport
	public void setBytes(byte[] a);

	/**
	 *	void setBytes(k, a, o, l)
	 *		Set the byte array for key value k to a copy of the byte array a starting at the offset o for the length l. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public static void setBytes(IYCFKeyHash128 k, byte[] a, int o, int l) {
		if(k != null) {
			if(o < 0) {
				throw IYCFArgumentUnderflowException.getInstance(YCFKeyHash128.class, "setBytes", 2, "o", o, 0);
			}
			if(l < 0) {
				throw IYCFArgumentUnderflowException.getInstance(YCFKeyHash128.class, "setBytes", 3, "l", l, 0);
			}
			k.setBytes(a, o, l);
		}
		else {
			throw IYCFNullArgumentException.getInstance(YCFKeyHash128.class, "setBytes", 1, "k");
		}
	}

	/**
	 *	void setBytes(a, o, l)
	 *		Set the byte array for the key to a copy of the byte array a starting at the offset o for the length l. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public void setBytes(byte[] a, int o, int l) {
		if(a == null) {
			setNull();
		}
		else {
			if(o < 0) {
				throw IYCFArgumentUnderflowException.getInstance(YCFKeyHash128.class, "setBytes", 2, "o", o, 0);
			}
			if(l < 0) {
				throw IYCFArgumentUnderflowException.getInstance(YCFKeyHash128.class, "setBytes", 3, "l", l, 0);
			}
			bytes = Arrays.clone(a, o, l);
		}
	}

	/**
	 *	boolean isNull(k)
	 *		Is the key k null valued?
	 *
	 *	@return True if k is null or null valued, otherwise false.
	 */
	@JSExport
  	public static boolean isNull(IYCFKeyHash128 k) {
		if(k != null) {
			return(k.isNull());
		}
		else {
			return(true);
		}
	}

	/**
	 *	boolean isNull()
	 *		Is this key null valued?
	 *
	 *	@return True if this key is null valued, otherwise false.
	 */
	@JSExport
  	public boolean isNull();

	/**
	 *	IYCFKeyHash128 hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(String s);

	/**
	 *	IYCFKeyHash128 hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(byte[] a);

	/**
	 *	IYCFKeyHash128 hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(byte[]... a);

	/**
	 *	IYCFKeyHash128 hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(IYCFKeyHash128... k);

	/**
	 *	IYCFKeyHash128 hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param k... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(int... k);

	/**
	 *	IYCFKeyHash128 hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash128 hash(int[]... a);

	/**
	 *	IYCFKeyHash128 deepClone(k)
	 *		Create an instance by deep cloning the key data for k.
	 *
	 *	@param k The key value to clone.
	 *
	 *	@return An instance, or null if k is null.
	 */
	@JSExport
  	public static IYCFKeyHash128 deepClone(IYCFKeyHash128 k) {
		return(new YCFKeyHash128(k));
	}

	/**
	 *	IYCFKeyHash128 deepClone()
	 *		Create an instance by deep cloning this key's data.
	 *
	 *	@return An instance cloned from this one.
	 */
	@JSExport
  	public IYCFKeyHash128 deepClone();

	/**
	 *	IYCFKeyHash128 fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash128 fromHexQuick(String s) {
		return(new YCFKeyHash128(s));
	}

	/**
	 *	IYCFKeyHash128[] toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public static IYCFKeyHash128[] toKeyHashes(String[] a) {
		if(a == null) {
			return(null);
		}
		YCFKeyHash128[] arr = new IYCFKeyHash128[a.length()];
		int i = 0;
		for(String s: a) {
			if(s != null) {
				arr[i++] = new YCFKeyHash128(s);
			}
			else {
				arr[i++] = null;
			}
		}
		return(arr);
	}

	/**
	 *	List<IYCFKeyHash128> toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public static List<IYCFKeyHash128> toKeyHashesList(String[] a) {
		if(a == null) {
			return(null);
		}
		ArrayList<IYCFKeyHash128> arr = new ArrayList<>(a.length());
		int i = 0;
		for(String s: a) {
			if(s != null) {
				arr.add(new YCFKeyHash128(s));
			}
			else {
				arr.add(null);
			}
		}
		return(arr);
	}

	/**
	 *	Set<IYCFKeyHash128> toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public static Set<IYCFKeyHash128> toKeyHashesSet(String[] a) {
		if(a == null) {
			return(null);
		}
		HashSet<IYCFKeyHash128> set = new HashSet<>(a.length());
		int i = 0;
		for(String s: a) {
			if(s != null) {
				set.add(new YCFKeyHash128(s));
			}
			else {
				if(!set.contains(null)) {
					set.add(null);
				}
			}
		}
		return(set);
	}
}
