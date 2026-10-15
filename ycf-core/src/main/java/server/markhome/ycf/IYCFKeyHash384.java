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

import java.util.*;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *	IYCFKeyHash384 implements a 384-bit key hash using a HASHALGO algorithm.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFKeyHash384 extends IYCFKeyHashBase<IYCFKeyHash384> {

	/**
	 *	IYCFKeyHash384 getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFKeyHash384 The singleton for the implementation.
	 */
	@JSExport
	public static IYCFKeyHash384 getSingleton();

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash384 The instance implementation.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance();

	/**
	 *	IYCFKeyHash384 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash384 The instance implementation.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance();

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash384 The instance implementation with a generated value.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(int i);

	/**
	 *	IYCFKeyHash384 getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash384 The instance implementation with a generated value.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(int i);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(s)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(String s);

	/**
	 *	IYCFKeyHash384 getInstance()
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(String s);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(byte[] a);

	/**
	 *	IYCFKeyHash384 getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(byte[] a);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash384 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash384 getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash384 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_fromInt(int i);

	/**
	 *	IYCFKeyHash384 fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash384 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public IYCFKeyHash384 fromInt(int i);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash384 A null instance
	 */
	@JSExport
	public static IYCFKeyHash384 YCFKeyHash384_nullGet();

	/**
	 *	IYCFKeyHash384 nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash384 A null instance.
	 */
	@JSExport
	public IYCFKeyHash384 nullGet();

	/**
	 *	String YCFKeyHash384_nullString()
	 *		Get a null value string.
	 *
	 *	@return String The null value string.
	 */
	@JSExport
	public static String YCFKeyHash384_nullString();

	/**
	 *	String nullString()
	 *		Get the null value string.
	 *
	 *	@return  String the null value string.
	 */
	@JSExport
	public String nullString();

	/**
	 *	int YCFKeyHash384_getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public static int YCFKeyHash384_getHashLength();

	/**
	 *	int getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public int getHashLength();

	/**
	 *	int YCFKeyHash384_getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public static int YCFKeyHash384_getHashLengthString();

	/**
	 *	int getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public int getHashLengthString();

	/**
	 *	String YCFKeyHash384_getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public static String YCFKeyHash384_getHashAlgo();

	/**
	 *	String getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public String getHashAlgo();

	/**
	 *	MessageDigest[] YCFKeyHash384_getM()
	 *		Get the message digest array.
	 *
	 *	@return The message digest array.
	 */
	@JSExport
  	public static MessageDigest[] YCFKeyHash384_getM();

	/**
	 *	MessageDigest[] getM()
	 *		Get the message digest array.
	 *
	 *	@return The message digest array.
	 */
	@JSExport
  	public MessageDigest[] getM();

	/**
	 *	int YCFKeyHash384_compare()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash384_compare(IYCFKeyHash384 a, IYCFKeyHash384 b);

	/**
	 *	int compare(b)
	 *		Compare an instance.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compare(IYCFKeyHash384 b);

	/**
	 *	int YCFKeyHash384_compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash384_compareOrdered(IYCFKeyHash384 a, IYCFKeyHash384 b);

	/**
	 *	int compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compareOrdered(IYCFKeyHash384 b);

	/**
	 *	void YCFKeyHash384_initStatics()
	 *		Initialize the statics.
	 */
	@JSExport
  	public static void YCFKeyHash384_initStatics();

	/**
	 *	byte[] YCFKeyHash384_sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public static byte[] YCFKeyHash384_sbytesFromHex(String s);

	/**
	 *	byte[] sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public byte[] sbytesFromHex(String s);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_fromHex(String s);

	/**
	 *	IYCFKeyHash384 fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash384_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public IYCFKeyHash384 fromHex(String s);

	/**
	 *	Comparator<IYCFKeyHash384> YCFKeyHash384_getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public static Comparator<IYCFKeyHash384> YCFKeyHash384_getComparator();

	/**
	 *	Comparator<IYCFKeyHash384> getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public Comparator<IYCFKeyHash384> getComparator();

	/**
	 *	byte[] YCFKeyHash384_getBytes(k)
	 *		Get the byte array for key value k.
	 *
	 *	@param k The key value to be evaluated.
	 *
	 *	@return The byte array for key value k, or null if k is null.
	 */
	@JSExport
	public static byte[] YCFKeyHash384_getBytes(IYCFKeyHash384 k);

	/**
	 *	byte[] getBytes()
	 *		Get the byte array for this key.
	 *
	 *	@return The byte array for this key.
	 */
	@JSExport
	public byte[] getBytes();

	/**
	 *	void YCFKeyHash384_setBytes(k, a)
	 *		Set the byte array for key value k to a copy of the byte array a. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 */
	@JSExport
	public static void YCFKeyHash384_setBytes(IYCFKeyHash384 k, byte[] a);

	/**
	 *	void setBytes(a)
	 *		Set the byte array for the key to a copy of the byte array a. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 */
	@JSExport
	public void setBytes(byte[] a);

	/**
	 *	void YCFKeyHash384_setBytes(k, a, o, l)
	 *		Set the byte array for key value k to a copy of the byte array a starting at the offset o for the length l. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public static void YCFKeyHash384_setBytes(IYCFKeyHash384 k, byte[] a, int o, int l);

	/**
	 *	void setBytes(a, o, l)
	 *		Set the byte array for the key to a copy of the byte array a starting at the offset o for the length l. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public void setBytes(byte[] a, int o, int l);

	/**
	 *	boolean YCFKeyHash384_isNull(k)
	 *		Is the key k null valued?
	 *
	 *	@return True if k is null or null valued, otherwise false.
	 */
	@JSExport
  	public static boolean YCFKeyHash384_isNull(IYCFKeyHash384 k);

	/**
	 *	boolean isNull()
	 *		Is this key null valued?
	 *
	 *	@return True if this key is null valued, otherwise false.
	 */
	@JSExport
  	public boolean isNull();

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(String s);

	/**
	 *	IYCFKeyHash384 hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(String s);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(byte[] a);

	/**
	 *	IYCFKeyHash384 hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(byte[] a);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(byte[]... a);

	/**
	 *	IYCFKeyHash384 hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(byte[]... a);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(IYCFKeyHash384... k);

	/**
	 *	IYCFKeyHash384 hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(IYCFKeyHash384... k);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param k... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(int... k);

	/**
	 *	IYCFKeyHash384 hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param i... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(int... i);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_hash(int[]... a);

	/**
	 *	IYCFKeyHash384 hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash384 hash(int[]... a);

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_deepClone(k)
	 *		Create an instance by deep cloning the key data for k.
	 *
	 *	@param k The key value to clone.
	 *
	 *	@return An instance, or null if k is null.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_deepClone(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash384 deepClone()
	 *		Create an instance by deep cloning this key's data.
	 *
	 *	@return An instance cloned from this one.
	 */
	@JSExport
  	public IYCFKeyHash384 deepClone();

	/**
	 *	IYCFKeyHash384 YCFKeyHash384_fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash384 YCFKeyHash384_fromHexQuick(String s);

	/**
	 *	IYCFKeyHash384 fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash384 fromHexQuick(String s);

	/**
	 *	IYCFKeyHash384[] YCFKeyHash384_toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public static IYCFKeyHash384[] YCFKeyHash384_toKeyHashes(String[] a);

	/**
	 *	IYCFKeyHash384[] toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public IYCFKeyHash384[] toKeyHashes(String[] a);

	/**
	 *	List<IYCFKeyHash384> YCFKeyHash384_toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public static List<IYCFKeyHash384> YCFKeyHash384_toKeyHashesList(String[] a);

	/**
	 *	List<IYCFKeyHash384> toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public List<IYCFKeyHash384> toKeyHashesList(String[] a);

	/**
	 *	Set<IYCFKeyHash384> YCFKeyHash384_toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public static Set<IYCFKeyHash384> YCFKeyHash384_toKeyHashesSet(String[] a);

	/**
	 *	Set<IYCFKeyHash384> toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public Set<IYCFKeyHash384> toKeyHashesSet(String[] a);
}
