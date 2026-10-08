"use strict";
(function(module) {
    if (typeof define === 'function' && define.amd) {
        define(['exports'], function(exports)  {
            module(exports);
        });
    } else if (typeof exports === 'object' && exports !== null && typeof exports.nodeName !== 'string') {
        module(exports);
    } else {
        module(typeof self !== 'undefined' ? self : this);
}
}(function($rt_exports) {
let $rt_seed = 2463534242,
$rt_nextId = () => {
    let x = $rt_seed;
    x ^= x << 13;
    x ^= x >>> 17;
    x ^= x << 5;
    $rt_seed = x;
    return x;
},
$rt_wrapFunction0 = f => function() {
    return f(this);
},
$rt_wrapFunction1 = f => function(p1) {
    return f(this, p1);
},
$rt_wrapFunction2 = f => function(p1, p2) {
    return f(this, p1, p2);
},
$rt_wrapFunction3 = f => function(p1, p2, p3) {
    return f(this, p1, p2, p3);
},
$rt_mainStarter = f => (args, callback) => {
    if (!args) {
        args = [];
    }
    let javaArgs = $rt_createArray($rt_objcls(), args.length);
    for (let i = 0;i < args.length;++i) {
        javaArgs.data[i] = $rt_str(args[i]);
    }
    $rt_startThread(() => {
        f.call(null, javaArgs);
    }, callback);
},
$rt_eraseClinit = target => target.$clinit = () => {
},
$dbg_class = obj => {
    let cls = obj.constructor;
    let arrayDegree = 0;
    while (cls[$rt_meta] && cls[$rt_meta].item) {
        ++arrayDegree;
        cls = cls[$rt_meta].item;
    }
    let clsName = "";
    if (cls[$rt_meta].primitiveKind !== 0) {
        clsName = cls[$rt_meta].name;
    } else {
        clsName = cls[$rt_meta] ? cls[$rt_meta].name || "a/" + cls.name : "@" + cls.name;
    }
    while (arrayDegree-- > 0) {
        clsName += "[]";
    }
    return clsName;
},
$rt_classWithoutFields = superclass => {
    if (superclass === 0) {
        return function() {
        };
    }
    if (superclass === void 0) {
        superclass = $rt_objcls();
    }
    return function() {
        superclass.call(this);
    };
},
$rt_meta = Symbol("teavm_meta"),
$rt_cls = cls => {
    if (cls[$rt_meta].classObject === null) {
        cls[$rt_meta].classObject = jl_Class_createClass(cls);
    }
    return cls[$rt_meta].classObject;
},
$rt_objcls = () => jl_Object,
$rt_callWithReceiver = f => function() {
    return f.apply(null, [this].concat(Array.prototype.slice.call(arguments)));
},
$rt_newClassMetadata = source => {
    return Object.assign({ name : null, binaryName : null, parent : null, superinterfaces : [], modifiers : 0, primitiveKind : 0, itemType : null, arrayType : null, enclosingClass : null, declaringClass : null, simpleName : null, clinit : () => {
    }, constructor : null, enumConstants : () => null, resolvedEnumConstants : null, reflection : null, classObject : null, assignableCache : null, valueToObject : o => o, objectToValue : o => o }, source || {  });
},
$rt_createPrimitiveCls = (name, binaryName, kind, config) => {
    let cls = () => {
    };
    let meta = $rt_newClassMetadata({ name : name, binaryName : binaryName, modifiers : 1 | 1 << 4, primitiveKind : kind });
    cls[$rt_meta] = meta;
    if (typeof config === 'function') {
        config(meta);
    }
    return cls;
},
$rt_charcls = $rt_createPrimitiveCls("char", "C", 4, meta => {
}),
$rt_intcls = $rt_createPrimitiveCls("int", "I", 5, meta => {
}),
$rt_imul = Math.imul || function(a, b) {
    let ah = a >>> 16 & 0xFFFF;
    let al = a & 0xFFFF;
    let bh = b >>> 16 & 0xFFFF;
    let bl = b & 0xFFFF;
    return al * bl + (ah * bl + al * bh << 16 >>> 0) | 0;
},
$rt_createArray = (cls, sz) => {
    let data = new Array(sz);
    data.fill(null);
    return new ($rt_arraycls(cls))(data);
},
$rt_createCharArray = sz => new $rt_charArrayCls(new Uint16Array(sz)),
$rt_arraycls = cls => {
    let result = cls[$rt_meta].arrayType;
    if (result === null) {
        function JavaArray(data) {
            ($rt_objcls()).call(this);
            this.data = data;
        }
        JavaArray.prototype = Object.create(($rt_objcls()).prototype);
        JavaArray.prototype.type = cls;
        JavaArray.prototype.constructor = JavaArray;
        JavaArray.prototype.toString = function() {
            let str = "[";
            for (let i = 0;i < this.data.length;++i) {
                if (i > 0) {
                    str += ", ";
                }
                str += this.data[i].toString();
            }
            str += "]";
            return str;
        };
        JavaArray.prototype.$clone = function() {
            let dataCopy;
            if ('slice' in this.data) {
                dataCopy = this.data.slice();
            } else {
                dataCopy = new this.data.constructor(this.data.length);
                for (let i = 0;i < dataCopy.length;++i) {
                    dataCopy[i] = this.data[i];
                }
            }
            return new ($rt_arraycls(this.type))(dataCopy);
        };
        let name = "[" + cls[$rt_meta].binaryName;
        JavaArray[$rt_meta] = $rt_newClassMetadata({ name : name, binaryName : name, parent : $rt_objcls(), itemType : cls });
        result = JavaArray;
        cls[$rt_meta].arrayType = JavaArray;
    }
    return result;
};
function $rt_arrayLength(array) {
    return array.data.length;
}
let $rt_stringPool_instance,
$rt_stringPool = strings => {
    $rt_stringClassInit();
    $rt_stringPool_instance = new Array(strings.length);
    for (let i = 0;i < strings.length;++i) {
        $rt_stringPool_instance[i] = $rt_intern($rt_str(strings[i]));
    }
},
$rt_s = index => $rt_stringPool_instance[index],
$rt_charArrayToString = (array, offset, count) => {
    let result = "";
    let limit = offset + count;
    for (let i = offset;i < limit;i = i + 1024 | 0) {
        let next = Math.min(limit, i + 1024 | 0);
        result += String.fromCharCode.apply(null, array.subarray(i, next));
    }
    return result;
},
$rt_str = str => str === null ? null : jl_String__init_5(str),
$rt_ustr = str => str === null ? null : str.$nativeString,
$rt_stringClassInit = () => jl_String_$callClinit(),
$rt_intern;
{
    $rt_intern = str => str;
}
let $rt_castToClass = (obj, cls) => {
    if (obj !== null && !(obj instanceof cls)) {
        $rt_throwCCE();
    }
    return obj;
},
$rt_throw = ex => {
    throw $rt_exception(ex);
},
$rt_javaExceptionProp = Symbol("javaException"),
$rt_exception = ex => {
    if (!ex.$jsException) {
        $rt_fillNativeException(ex);
    }
    return ex.$jsException;
},
$rt_fillNativeException = ex => {
    let javaCause = $rt_throwableCause(ex);
    let jsCause = javaCause !== null ? javaCause.$jsException : void 0;
    let cause = typeof jsCause === "object" ? { cause : jsCause } : void 0;
    let err = new JavaError("Java exception thrown", cause);
    if (typeof Error.captureStackTrace === "function") {
        Error.captureStackTrace(err);
    }
    err[$rt_javaExceptionProp] = ex;
    ex.$jsException = err;
    $rt_fillStack(err, ex);
},
$rt_fillStack = (err, ex) => {
    if (typeof $rt_decodeStack === "function" && err.stack) {
        let stack = $rt_decodeStack(err.stack);
        let javaStack = $rt_createArray($rt_stecls(), stack.length);
        let elem;
        let noStack = false;
        for (let i = 0;i < stack.length;++i) {
            let element = stack[i];
            elem = $rt_createStackElement($rt_str(element.className), $rt_str(element.methodName), $rt_str(element.fileName), element.lineNumber);
            if (elem == null) {
                noStack = true;
                break;
            }
            javaStack.data[i] = elem;
        }
        if (!noStack) {
            $rt_setStack(ex, javaStack);
        }
    }
},
JavaError;
if (typeof Reflect === 'object') {
    let defaultMessage = Symbol("defaultMessage");
    JavaError = function JavaError(message, cause) {
        let self = Reflect.construct(Error, [void 0, cause], JavaError);
        Object.setPrototypeOf(self, JavaError.prototype);
        self[defaultMessage] = message;
        return self;
    }
    ;
    JavaError.prototype = Object.create(Error.prototype, { constructor : { configurable : true, writable : true, value : JavaError }, message : { get() {
        try {
            let javaException = this[$rt_javaExceptionProp];
            if (typeof javaException === 'object') {
                let javaMessage = $rt_throwableMessage(javaException);
                if (typeof javaMessage === "object") {
                    return javaMessage !== null ? javaMessage.toString() : null;
                }
            }
            return this[defaultMessage];
        } catch (e){
            return "Exception occurred trying to extract Java exception message: " + e;
        }
    } } });
} else {
    JavaError = Error;
}
let $rt_javaException = e => e instanceof Error && typeof e[$rt_javaExceptionProp] === 'object' ? e[$rt_javaExceptionProp] : null,
$rt_throwableMessage = t => jl_Throwable_getMessage(t),
$rt_throwableCause = t => jl_Throwable_getCause(t),
$rt_stecls = () => $rt_objcls(),
$rt_throwAIOOBE = () => $rt_throw(jl_ArrayIndexOutOfBoundsException__init_0()),
$rt_throwCCE = () => $rt_throw(jl_ClassCastException__init_0()),
$rt_throwCCEIfFalse = (value, o) => {
    if (!value) {
        $rt_throwCCE();
    }
    return o;
},
$rt_createStackElement = (className, methodName, fileName, lineNumber) => {
    {
        return null;
    }
},
$rt_setStack = (e, stack) => {
},
$rt_checkBounds = (index, array) => {
    if (index < 0 || index >= array.length) {
        $rt_throwAIOOBE();
    }
    return index;
},
$rt_checkUpperBound = (index, array) => {
    if (index >= array.length) {
        $rt_throwAIOOBE();
    }
    return index;
},
$rt_checkLowerBound = index => {
    if (index < 0) {
        $rt_throwAIOOBE();
    }
    return index;
},
$rt_nullCheck = val => {
    if (val === null) {
        $rt_throw(jl_NullPointerException__init_0());
    }
    return val;
},
$rt_packageData = null,
$rt_packages = data => {
    let i = 0;
    let packages = new Array(data.length);
    for (let j = 0;j < data.length;++j) {
        let prefixIndex = data[i++];
        let prefix = prefixIndex >= 0 ? packages[prefixIndex] : "";
        packages[j] = prefix + data[i++] + ".";
    }
    $rt_packageData = packages;
},
$rt_allClasses = [],
$rt_metadata = data => {
    let packages = $rt_packageData;
    let i = 0;
    while (i < data.length) {
        let cls = data[i++];
        $rt_allClasses.push(cls);
        let m = $rt_newClassMetadata();
        cls[$rt_meta] = m;
        let className = data[i++];
        m.name = className !== 0 ? className : null;
        if (m.name !== null) {
            let packageIndex = data[i++];
            if (packageIndex >= 0) {
                m.name = packages[packageIndex] + m.name;
            }
        }
        m.binaryName = "L" + m.name + ";";
        let superclass = data[i++];
        m.parent = superclass !== 0 ? superclass : null;
        m.superinterfaces = data[i++];
        if (m.parent) {
            cls.prototype = Object.create(m.parent.prototype);
        } else {
            cls.prototype = {  };
        }
        cls.prototype.constructor = cls;
        m.modifiers = data[i++];
        m.primitiveKind = 0;
        let innerClassInfo = data[i++];
        if (innerClassInfo !== 0) {
            let enclosingClass = innerClassInfo[0];
            m.enclosingClass = enclosingClass !== 0 ? enclosingClass : null;
            let declaringClass = innerClassInfo[1];
            m.declaringClass = declaringClass !== 0 ? declaringClass : null;
            let simpleName = innerClassInfo[2];
            m.simpleName = simpleName !== 0 ? simpleName : null;
        }
        let clinit = data[i++];
        m.clinit = clinit !== 0 ? () => {
            m.clinit = () => {
            };
            clinit();
        } : () => {
        };
        let virtualMethods = data[i++];
        if (virtualMethods !== 0) {
            for (let j = 0;j < virtualMethods.length;j += 2) {
                let name = virtualMethods[j];
                let func = virtualMethods[j + 1];
                if (typeof name === 'string') {
                    name = [name];
                }
                for (let k = 0;k < name.length;++k) {
                    cls.prototype[name[k]] = func;
                }
            }
        }
    }
},
$rt_startThread = (runner, callback) => {
    let result;
    try {
        result = runner();
    } catch (e){
        result = e;
    }
    if (typeof callback !== 'undefined') {
        callback(result);
    } else if (result instanceof Error) {
        throw result;
    }
};
function jl_Object() {
    this.$id$ = 0;
}
let jl_Object__init_ = $this => {
    return;
},
jl_Object__init_0 = () => {
    let var_0 = new jl_Object();
    jl_Object__init_(var_0);
    return var_0;
},
jl_Object_getClass = $this => {
    return $rt_castToClass($rt_cls($rt_nullCheck(jl_Object_getClassInfo($this))), jl_Class);
},
jl_Object_getClassInfo = var$0 => {
    return var$0.constructor;
},
jl_Object_toString = var$0 => {
    let var$1, var$2, var$3;
    var$1 = jl_Class_getName($rt_nullCheck(jl_Object_getClass(var$0)));
    var$2 = jl_Integer_toHexString(jl_Object_identity(var$0));
    var$3 = jl_StringBuilder__init_();
    jl_StringBuilder_append($rt_nullCheck(jl_StringBuilder_append0($rt_nullCheck(jl_StringBuilder_append(var$3, var$1)), 64)), var$2);
    return jl_StringBuilder_toString(var$3);
},
jl_Object_identity = $this => {
    let $platformThis;
    $platformThis = $this;
    if (!$platformThis.$id$)
        $platformThis.$id$ = $rt_nextId();
    return $this.$id$;
};
function jl_Throwable() {
    let a = this; jl_Object.call(a);
    a.$message = null;
    a.$cause = null;
    a.$suppressionEnabled = 0;
    a.$writableStackTrace = 0;
}
let jl_Throwable__init_0 = $this => {
    jl_Throwable_initNativeException($this);
    $this.$suppressionEnabled = 1;
    $this.$writableStackTrace = 1;
    $this.$fillInStackTrace();
},
jl_Throwable__init_1 = () => {
    let var_0 = new jl_Throwable();
    jl_Throwable__init_0(var_0);
    return var_0;
},
jl_Throwable__init_ = ($this, $message) => {
    jl_Throwable_initNativeException($this);
    $this.$suppressionEnabled = 1;
    $this.$writableStackTrace = 1;
    $this.$fillInStackTrace();
    $this.$message = $message;
},
jl_Throwable__init_2 = var_0 => {
    let var_1 = new jl_Throwable();
    jl_Throwable__init_(var_1, var_0);
    return var_1;
},
jl_Throwable_fillInStackTrace = $this => {
    return $this;
},
jl_Throwable_initNativeException = $this => {
    $rt_fillNativeException($this);
},
jl_Throwable_getMessage = $this => {
    return $this.$message;
},
jl_Throwable_getCause = $this => {
    return $this.$cause === $this ? null : $this.$cause;
},
jl_Exception = $rt_classWithoutFields(jl_Throwable),
jl_Exception__init_0 = $this => {
    jl_Throwable__init_0($this);
},
jl_Exception__init_1 = () => {
    let var_0 = new jl_Exception();
    jl_Exception__init_0(var_0);
    return var_0;
},
jl_Exception__init_ = ($this, $message) => {
    jl_Throwable__init_($this, $message);
},
jl_Exception__init_2 = var_0 => {
    let var_1 = new jl_Exception();
    jl_Exception__init_(var_1, var_0);
    return var_1;
},
jl_RuntimeException = $rt_classWithoutFields(jl_Exception),
jl_RuntimeException__init_ = $this => {
    jl_Exception__init_0($this);
},
jl_RuntimeException__init_1 = () => {
    let var_0 = new jl_RuntimeException();
    jl_RuntimeException__init_(var_0);
    return var_0;
},
jl_RuntimeException__init_0 = ($this, $message) => {
    jl_Exception__init_($this, $message);
},
jl_RuntimeException__init_2 = var_0 => {
    let var_1 = new jl_RuntimeException();
    jl_RuntimeException__init_0(var_1, var_0);
    return var_1;
},
jl_IndexOutOfBoundsException = $rt_classWithoutFields(jl_RuntimeException),
jl_IndexOutOfBoundsException__init_ = $this => {
    jl_RuntimeException__init_($this);
},
jl_IndexOutOfBoundsException__init_0 = () => {
    let var_0 = new jl_IndexOutOfBoundsException();
    jl_IndexOutOfBoundsException__init_(var_0);
    return var_0;
},
ju_Arrays = $rt_classWithoutFields(),
ju_Arrays_copyOf = ($array, $length) => {
    let $result, var$4, $sz, $i, var$7, var$8;
    $result = $rt_createCharArray($length);
    $array = $rt_nullCheck($array);
    var$4 = $array.data;
    $sz = jl_Math_min($length, var$4.length);
    $i = 0;
    while ($i < $sz) {
        var$7 = $result.data;
        $i = $rt_checkBounds($i, var$4);
        var$8 = var$4[$i];
        $i = $rt_checkUpperBound($i, var$7);
        var$7[$i] = var$8;
        $i = $i + 1 | 0;
    }
    return $result;
},
otj_JSObject = $rt_classWithoutFields(0),
jl_Error = $rt_classWithoutFields(jl_Throwable),
jl_Error__init_ = ($this, $message) => {
    jl_Throwable__init_($this, $message);
},
jl_Error__init_0 = var_0 => {
    let var_1 = new jl_Error();
    jl_Error__init_(var_1, var_0);
    return var_1;
},
jl_AssertionError = $rt_classWithoutFields(jl_Error),
jl_AssertionError__init_ = ($this, $message) => {
    jl_Error__init_($this, jl_String_valueOf($message));
},
jl_AssertionError__init_0 = var_0 => {
    let var_1 = new jl_AssertionError();
    jl_AssertionError__init_(var_1, var_0);
    return var_1;
},
ji_Serializable = $rt_classWithoutFields(0),
jl_Number = $rt_classWithoutFields(),
jl_Comparable = $rt_classWithoutFields(0),
jl_Integer = $rt_classWithoutFields(jl_Number),
jl_Integer_TYPE = null,
jl_Integer_$callClinit = () => {
    jl_Integer_$callClinit = $rt_eraseClinit(jl_Integer);
    jl_Integer__clinit_();
},
jl_Integer_toHexString = $i => {
    jl_Integer_$callClinit();
    return otci_IntegerUtil_toUnsignedLogRadixString($i, 4);
},
jl_Integer_numberOfLeadingZeros = $i => {
    let $n, var$3, var$4;
    jl_Integer_$callClinit();
    if (!$i)
        return 32;
    $n = 0;
    var$3 = $i >>> 16 | 0;
    if (var$3)
        $n = 16;
    else
        var$3 = $i;
    var$4 = var$3 >>> 8 | 0;
    if (!var$4)
        var$4 = var$3;
    else
        $n = $n | 8;
    var$3 = var$4 >>> 4 | 0;
    if (!var$3)
        var$3 = var$4;
    else
        $n = $n | 4;
    var$4 = var$3 >>> 2 | 0;
    if (!var$4)
        var$4 = var$3;
    else
        $n = $n | 2;
    if (var$4 >>> 1 | 0)
        $n = $n | 1;
    return (32 - $n | 0) - 1 | 0;
},
jl_Integer__clinit_ = () => {
    jl_Integer_TYPE = $rt_cls($rt_intcls);
},
jl_ClassCastException = $rt_classWithoutFields(jl_RuntimeException),
jl_ClassCastException__init_ = $this => {
    jl_RuntimeException__init_($this);
},
jl_ClassCastException__init_0 = () => {
    let var_0 = new jl_ClassCastException();
    jl_ClassCastException__init_(var_0);
    return var_0;
};
function otji_JSWrapper() {
    jl_Object.call(this);
    this.$js = null;
}
let otji_JSWrapper_unwrap = $o => {
    if ($o === null)
        return null;
    return !($o instanceof otji_JSWrapper) ? $o : ($rt_nullCheck($rt_castToClass($o, otji_JSWrapper))).$js;
},
otji_JSWrapper_maybeUnwrap = $o => {
    if ($o === null)
        return null;
    return !($o instanceof $rt_objcls()) ? $o : otji_JSWrapper_unwrap($o);
};
function juca_AtomicReference() {
    let a = this; jl_Object.call(a);
    a.$value = null;
    a.$version = 0;
}
let juca_AtomicReference__init_ = ($this, $value) => {
    jl_Object__init_($this);
    $this.$value = $value;
},
juca_AtomicReference__init_0 = var_0 => {
    let var_1 = new juca_AtomicReference();
    juca_AtomicReference__init_(var_1, var_0);
    return var_1;
},
juca_AtomicReference_get = $this => {
    return $this.$value;
},
juca_AtomicReference_compareAndSet = ($this, $expect, $update) => {
    if ($this.$value !== $expect)
        return 0;
    $this.$value = $update;
    $this.$version = $this.$version + 1 | 0;
    return 1;
},
jl_NullPointerException = $rt_classWithoutFields(jl_RuntimeException),
jl_NullPointerException__init_ = $this => {
    jl_RuntimeException__init_($this);
},
jl_NullPointerException__init_0 = () => {
    let var_0 = new jl_NullPointerException();
    jl_NullPointerException__init_(var_0);
    return var_0;
},
otp_Platform = $rt_classWithoutFields(),
jl_Character = $rt_classWithoutFields(),
jl_Character_TYPE = null,
jl_Character_characterCache = null,
jl_Character_$callClinit = () => {
    jl_Character_$callClinit = $rt_eraseClinit(jl_Character);
    jl_Character__clinit_();
},
jl_Character_forDigit = ($digit, $radix) => {
    jl_Character_$callClinit();
    if ($radix >= 2 && $radix <= 36 && $digit >= 0 && $digit < $radix)
        return $digit < 10 ? (48 + $digit | 0) & 65535 : ((97 + $digit | 0) - 10 | 0) & 65535;
    return 0;
},
jl_Character__clinit_ = () => {
    jl_Character_TYPE = $rt_cls($rt_charcls);
    jl_Character_characterCache = $rt_createArray(jl_Character, 128);
},
otci_IntegerUtil = $rt_classWithoutFields(),
otci_IntegerUtil_toUnsignedLogRadixString = ($value, $radixLog2) => {
    let $radix, $mask, $sz, $chars, $pos, $target, var$9, $target_0, var$11;
    if (!$value)
        return $rt_s(0);
    $radix = 1 << $radixLog2;
    $mask = $radix - 1 | 0;
    $sz = (((32 - jl_Integer_numberOfLeadingZeros($value) | 0) + $radixLog2 | 0) - 1 | 0) / $radixLog2 | 0;
    $chars = $rt_createCharArray($sz);
    $pos = $rt_imul($sz - 1 | 0, $radixLog2);
    $target = 0;
    while ($pos >= 0) {
        var$9 = $chars.data;
        $target_0 = $target + 1 | 0;
        var$11 = jl_Character_forDigit(($value >>> $pos | 0) & $mask, $radix);
        $target = $rt_checkBounds($target, var$9);
        var$9[$target] = var$11;
        $pos = $pos - $radixLog2 | 0;
        $target = $target_0;
    }
    return jl_String__init_4($chars);
},
jl_CharSequence = $rt_classWithoutFields(0);
function jl_AbstractStringBuilder() {
    let a = this; jl_Object.call(a);
    a.$buffer = null;
    a.$length0 = 0;
}
let jl_AbstractStringBuilder__init_0 = $this => {
    jl_AbstractStringBuilder__init_($this, 16);
},
jl_AbstractStringBuilder__init_2 = () => {
    let var_0 = new jl_AbstractStringBuilder();
    jl_AbstractStringBuilder__init_0(var_0);
    return var_0;
},
jl_AbstractStringBuilder__init_ = ($this, $capacity) => {
    jl_Object__init_($this);
    $this.$buffer = $rt_createCharArray($capacity);
},
jl_AbstractStringBuilder__init_1 = var_0 => {
    let var_1 = new jl_AbstractStringBuilder();
    jl_AbstractStringBuilder__init_(var_1, var_0);
    return var_1;
},
jl_AbstractStringBuilder_append0 = ($this, $obj) => {
    return $this.$insert($this.$length0, $obj);
},
jl_AbstractStringBuilder_insert = ($this, $index, $string) => {
    let $i, var$4, var$5, var$6, var$7;
    if ($index >= 0 && $index <= $this.$length0) {
        if ($string === null)
            $string = $rt_s(1);
        else if ($string.$isEmpty())
            return $this;
        $this.$ensureCapacity($this.$length0 + $string.$length() | 0);
        $i = $this.$length0 - 1 | 0;
        while ($i >= $index) {
            var$4 = $this.$buffer;
            var$5 = $i + $string.$length() | 0;
            var$6 = ($rt_nullCheck($this.$buffer)).data;
            $i = $rt_checkBounds($i, var$6);
            var$7 = var$6[$i];
            var$4 = ($rt_nullCheck(var$4)).data;
            var$4[$rt_checkBounds(var$5, var$4)] = var$7;
            $i = $i + (-1) | 0;
        }
        $this.$length0 = $this.$length0 + $string.$length() | 0;
        $i = 0;
        while ($i < $string.$length()) {
            var$4 = $this.$buffer;
            var$5 = $index + 1 | 0;
            var$7 = $string.$charAt($i);
            var$4 = ($rt_nullCheck(var$4)).data;
            var$4[$rt_checkBounds($index, var$4)] = var$7;
            $i = $i + 1 | 0;
            $index = var$5;
        }
        return $this;
    }
    $rt_throw(jl_StringIndexOutOfBoundsException__init_());
},
jl_AbstractStringBuilder_append = ($this, $c) => {
    return $this.$insert0($this.$length0, $c);
},
jl_AbstractStringBuilder_insert1 = ($this, $index, $c) => {
    let var$3;
    jl_AbstractStringBuilder_insertSpace($this, $index, $index + 1 | 0);
    var$3 = ($rt_nullCheck($this.$buffer)).data;
    $index = $rt_checkBounds($index, var$3);
    var$3[$index] = $c;
    return $this;
},
jl_AbstractStringBuilder_insert0 = ($this, $index, $obj) => {
    return $this.$insert1($index, $obj === null ? $rt_s(1) : $obj.$toString());
},
jl_AbstractStringBuilder_ensureCapacity = ($this, $capacity) => {
    let $newLength;
    if (($rt_nullCheck($this.$buffer)).data.length >= $capacity)
        return;
    $newLength = ($rt_nullCheck($this.$buffer)).data.length >= 1073741823 ? 2147483647 : jl_Math_max($capacity, jl_Math_max(($rt_nullCheck($this.$buffer)).data.length * 2 | 0, 5));
    $this.$buffer = ju_Arrays_copyOf($this.$buffer, $newLength);
},
jl_AbstractStringBuilder_toString = $this => {
    return jl_String__init_3($this.$buffer, 0, $this.$length0);
},
jl_AbstractStringBuilder_insertSpace = ($this, $start, $end) => {
    let $sz, $i, var$5, var$6, var$7, var$8;
    $sz = $this.$length0 - $start | 0;
    $this.$ensureCapacity(($this.$length0 + $end | 0) - $start | 0);
    $i = $sz - 1 | 0;
    while ($i >= 0) {
        var$5 = $this.$buffer;
        var$6 = $end + $i | 0;
        var$7 = $this.$buffer;
        var$8 = $start + $i | 0;
        var$7 = ($rt_nullCheck(var$7)).data;
        var$8 = var$7[$rt_checkBounds(var$8, var$7)];
        var$5 = ($rt_nullCheck(var$5)).data;
        var$5[$rt_checkBounds(var$6, var$5)] = var$8;
        $i = $i + (-1) | 0;
    }
    $this.$length0 = $this.$length0 + ($end - $start | 0) | 0;
},
otrr_ReflectionInfo = $rt_classWithoutFields(),
otr_StringInfo = $rt_classWithoutFields(otrr_ReflectionInfo),
jl_Math = $rt_classWithoutFields(),
jl_Math_min = ($a, $b) => {
    if ($a < $b)
        $b = $a;
    return $b;
},
jl_Math_max = ($a, $b) => {
    if ($a > $b)
        $b = $a;
    return $b;
},
jl_String = $rt_classWithoutFields(),
jl_String_EMPTY_CHARS = null,
jl_String_EMPTY = null,
jl_String_CASE_INSENSITIVE_ORDER = null,
jl_String_$callClinit = () => {
    jl_String_$callClinit = $rt_eraseClinit(jl_String);
    jl_String__clinit_();
},
jl_String__init_1 = $this => {
    jl_String_$callClinit();
    jl_Object__init_($this);
    $this.$nativeString = "";
},
jl_String__init_6 = () => {
    let var_0 = new jl_String();
    jl_String__init_1(var_0);
    return var_0;
},
jl_String__init_ = ($this, $characters) => {
    jl_String_$callClinit();
    jl_Object__init_($this);
    $characters = $rt_nullCheck($characters);
    $this.$nativeString = $rt_charArrayToString($characters.data, 0, $characters.data.length);
},
jl_String__init_4 = var_0 => {
    let var_1 = new jl_String();
    jl_String__init_(var_1, var_0);
    return var_1;
},
jl_String__init_0 = (var$0, var$1) => {
    var$0.$nativeString = var$1;
},
jl_String__init_5 = var_0 => {
    let var_1 = new jl_String();
    jl_String__init_0(var_1, var_0);
    return var_1;
},
jl_String__init_2 = (var$0, var$1, $offset, $count) => {
    jl_String_$callClinit();
    jl_Object__init_(var$0);
    var$1 = $rt_nullCheck(var$1);
    ju_Objects_checkFromIndexSize($offset, $count, var$1.data.length);
    var$0.$nativeString = $rt_charArrayToString(var$1.data, $offset, $count);
},
jl_String__init_3 = (var_0, var_1, var_2) => {
    let var_3 = new jl_String();
    jl_String__init_2(var_3, var_0, var_1, var_2);
    return var_3;
},
jl_String_charAt = ($this, $index) => {
    if ($index >= 0 && $index < $this.$nativeString.length)
        return $this.$nativeString.charCodeAt($index);
    $rt_throw(jl_StringIndexOutOfBoundsException__init_());
},
jl_String_length = $this => {
    return $this.$nativeString.length;
},
jl_String_isEmpty = $this => {
    return $this.$nativeString.length ? 0 : 1;
},
jl_String_toString = $this => {
    return $rt_castToClass($this, jl_String);
},
jl_String_valueOf = $obj => {
    jl_String_$callClinit();
    return $obj === null ? $rt_s(1) : $obj.$toString();
},
jl_String__clinit_ = () => {
    jl_String_EMPTY_CHARS = $rt_createCharArray(0);
    jl_String_EMPTY = jl_String__init_6();
    jl_String_CASE_INSENSITIVE_ORDER = jl_String$_clinit_$lambda$_118_0__init_0();
},
otjc_JSString = $rt_classWithoutFields(),
otjc_JSString_stringValue$static = $this => {
    return $rt_str($this);
},
jlr_AnnotatedElement = $rt_classWithoutFields(0),
jlr_GenericDeclaration = $rt_classWithoutFields(0),
smm_IMcfLibEntry = $rt_classWithoutFields(0),
otji_JS = $rt_classWithoutFields(),
otji_JS_unwrapStringArray = $array => {
    let $result, $i, var$4, var$5;
    if ($array === null)
        return null;
    $result = $rt_createArray(jl_String, $array.length);
    $i = 0;
    while (true) {
        var$4 = $result.data;
        if ($i >= var$4.length)
            break;
        var$5 = otji_JSWrapper_maybeUnwrap($array[$i]);
        var$5 = otjc_JSString_stringValue$static($rt_throwCCEIfFalse(typeof var$5 === "string" ? 1 : 0, var$5));
        $i = $rt_checkLowerBound($i);
        var$4[$i] = var$5;
        $i = $i + 1 | 0;
    }
    return $result;
},
jl_Appendable = $rt_classWithoutFields(0),
smm_McfLibEntry = $rt_classWithoutFields(),
smm_McfLibEntry_singleton = null,
smm_McfLibEntry_$assertionsDisabled = 0,
smm_McfLibEntry_$callClinit = () => {
    smm_McfLibEntry_$callClinit = $rt_eraseClinit(smm_McfLibEntry);
    smm_McfLibEntry__clinit_();
},
smm_McfLibEntry__init_ = $this => {
    smm_McfLibEntry_$callClinit();
    jl_Object__init_($this);
},
smm_McfLibEntry__init_0 = () => {
    let var_0 = new smm_McfLibEntry();
    smm_McfLibEntry__init_(var_0);
    return var_0;
};
let smm_McfLibEntry_getMcfLibEntrySingleton = () => {
    let $retval, var$2;
    smm_McfLibEntry_$callClinit();
    $retval = $rt_castToClass(juca_AtomicReference_get($rt_nullCheck(smm_McfLibEntry_singleton)), smm_McfLibEntry);
    if ($retval === null) {
        var$2 = smm_McfLibEntry__init_0();
        juca_AtomicReference_compareAndSet($rt_nullCheck(smm_McfLibEntry_singleton), null, var$2);
        $retval = $rt_castToClass(juca_AtomicReference_get($rt_nullCheck(smm_McfLibEntry_singleton)), smm_McfLibEntry);
    }
    return $retval;
},
smm_McfLibEntry_getMcfLibEntryInstance = () => {
    smm_McfLibEntry_$callClinit();
    return null;
},
smm_McfLibEntry_execMcfLibEntryLibReset = $yesReally => {
    let $sgl, $retval, var$4;
    smm_McfLibEntry_$callClinit();
    $sgl = $rt_castToClass(juca_AtomicReference_get($rt_nullCheck(smm_McfLibEntry_singleton)), smm_McfLibEntry);
    if ($sgl !== null && !$yesReally)
        $retval = 0;
    else {
        if ($yesReally && $sgl !== null)
            juca_AtomicReference_compareAndSet($rt_nullCheck(smm_McfLibEntry_singleton), $sgl, null);
        var$4 = smm_McfLibEntry_getMcfLibEntrySingleton();
        if (!smm_McfLibEntry_$assertionsDisabled && var$4 === null)
            $rt_throw(jl_AssertionError__init_0($rt_s(2)));
        $retval = 1;
    }
    return $retval;
},
smm_McfLibEntry_getInstance = $this => {
    return smm_McfLibEntry_getMcfLibEntryInstance();
},
smm_McfLibEntry_getSingleton = $this => {
    return smm_McfLibEntry_getMcfLibEntrySingleton();
},
smm_McfLibEntry_libReset0 = $this => {
    return smm_McfLibEntry_libReset($this, 0);
},
smm_McfLibEntry_libReset = ($this, $yesReally) => {
    return smm_McfLibEntry_execMcfLibEntryLibReset($yesReally);
},
smm_McfLibEntry_resetLib = ($this, $yesReally) => {
    return smm_McfLibEntry_execMcfLibEntryLibReset($yesReally);
},
smm_McfLibEntry_resetLib0 = $this => {
    return smm_McfLibEntry_resetLib($this, 0);
},
smm_McfLibEntry_getParentLibName = $this => {
    return $rt_s(3);
},
smm_McfLibEntry_getParentLibVersion = $this => {
    return $rt_s(4);
},
smm_McfLibEntry_getLibName = $this => {
    return $rt_s(5);
},
smm_McfLibEntry_getLibVersion = $this => {
    return $rt_s(4);
},
smm_McfLibEntry_main0 = ($argc, $argv) => {
    smm_McfLibEntry_$callClinit();
},
smm_McfLibEntry_main = $argv => {
    smm_McfLibEntry_$callClinit();
    $argv = $rt_nullCheck($argv);
    smm_McfLibEntry_main0($argv.data.length, $argv);
},
smm_McfLibEntry__clinit_ = () => {
    smm_McfLibEntry_$assertionsDisabled = jl_Class_desiredAssertionStatus($rt_cls(smm_McfLibEntry)) ? 0 : 1;
    smm_McfLibEntry_singleton = juca_AtomicReference__init_0(null);
},
smm_McfLibEntry_getSingleton$exported$0 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return smm_McfLibEntry_getSingleton($rt_nullCheck(var$1));
},
smm_McfLibEntry_getParentLibName$exported$1 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return $rt_ustr(smm_McfLibEntry_getParentLibName($rt_nullCheck(var$1)));
},
smm_McfLibEntry_resetLib$exported$2 = (var$1, var$2) => {
    let var$3;
    smm_McfLibEntry_$callClinit();
    var$3 = var$2 ? 1 : 0;
    return !!smm_McfLibEntry_resetLib($rt_nullCheck(var$1), var$3);
},
smm_McfLibEntry_getInstance$exported$3 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return smm_McfLibEntry_getInstance($rt_nullCheck(var$1));
},
smm_McfLibEntry_libReset$exported$4 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return !!smm_McfLibEntry_libReset0($rt_nullCheck(var$1));
},
smm_McfLibEntry_libReset$exported$5 = (var$1, var$2) => {
    let var$3;
    smm_McfLibEntry_$callClinit();
    var$3 = var$2 ? 1 : 0;
    return !!smm_McfLibEntry_libReset($rt_nullCheck(var$1), var$3);
},
smm_McfLibEntry_getParentLibVersion$exported$6 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return $rt_ustr(smm_McfLibEntry_getParentLibVersion($rt_nullCheck(var$1)));
},
smm_McfLibEntry_resetLib$exported$7 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return !!smm_McfLibEntry_resetLib0($rt_nullCheck(var$1));
},
smm_McfLibEntry_getLibName$exported$8 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return $rt_ustr(smm_McfLibEntry_getLibName($rt_nullCheck(var$1)));
},
smm_McfLibEntry_getLibVersion$exported$9 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return $rt_ustr(smm_McfLibEntry_getLibVersion($rt_nullCheck(var$1)));
},
smm_McfLibEntry_getMcfLibEntrySingleton$exported$0 = () => {
    smm_McfLibEntry_$callClinit();
    return smm_McfLibEntry_getMcfLibEntrySingleton();
},
smm_McfLibEntry_getMcfLibEntryInstance$exported$1 = () => {
    smm_McfLibEntry_$callClinit();
    return smm_McfLibEntry_getMcfLibEntryInstance();
},
smm_McfLibEntry_execMcfLibEntryLibReset$exported$2 = var$1 => {
    smm_McfLibEntry_$callClinit();
    return !!smm_McfLibEntry_execMcfLibEntryLibReset(var$1 ? 1 : 0);
},
smm_McfLibEntry_main$exported$3 = (var$1, var$2) => {
    smm_McfLibEntry_$callClinit();
    smm_McfLibEntry_main0(var$1, otji_JS_unwrapStringArray(var$2));
},
smm_McfLibEntry_main$exported$4 = var$1 => {
    smm_McfLibEntry_$callClinit();
    smm_McfLibEntry_main(otji_JS_unwrapStringArray(var$1));
},
jl_StringIndexOutOfBoundsException = $rt_classWithoutFields(jl_IndexOutOfBoundsException),
jl_StringIndexOutOfBoundsException__init_0 = $this => {
    jl_IndexOutOfBoundsException__init_($this);
},
jl_StringIndexOutOfBoundsException__init_ = () => {
    let var_0 = new jl_StringIndexOutOfBoundsException();
    jl_StringIndexOutOfBoundsException__init_0(var_0);
    return var_0;
},
jl_ArrayIndexOutOfBoundsException = $rt_classWithoutFields(jl_IndexOutOfBoundsException),
jl_ArrayIndexOutOfBoundsException__init_ = $this => {
    jl_IndexOutOfBoundsException__init_($this);
},
jl_ArrayIndexOutOfBoundsException__init_0 = () => {
    let var_0 = new jl_ArrayIndexOutOfBoundsException();
    jl_ArrayIndexOutOfBoundsException__init_(var_0);
    return var_0;
},
ju_Objects = $rt_classWithoutFields(),
ju_Objects_checkFromIndexSize = ($fromIndex, $size, $length) => {
    if ($fromIndex >= 0 && $size >= 0 && $size <= ($length - $fromIndex | 0))
        return $fromIndex;
    $rt_throw(jl_IndexOutOfBoundsException__init_0());
},
jlr_Type = $rt_classWithoutFields(0),
otrr_ClassInfo = $rt_classWithoutFields(otrr_ReflectionInfo),
ju_Comparator = $rt_classWithoutFields(0),
jl_String$_clinit_$lambda$_118_0 = $rt_classWithoutFields(),
jl_String$_clinit_$lambda$_118_0__init_ = var$0 => {
    jl_Object__init_(var$0);
},
jl_String$_clinit_$lambda$_118_0__init_0 = () => {
    let var_0 = new jl_String$_clinit_$lambda$_118_0();
    jl_String$_clinit_$lambda$_118_0__init_(var_0);
    return var_0;
};
function jl_Class() {
    let a = this; jl_Object.call(a);
    a.$flags = 0;
    a.$classInfo = null;
    a.$name = null;
}
let jl_Class__init_0 = ($this, $classInfo) => {
    jl_Object__init_($this);
    $this.$classInfo = $classInfo;
},
jl_Class__init_ = var_0 => {
    let var_1 = new jl_Class();
    jl_Class__init_0(var_1, var_0);
    return var_1;
},
jl_Class_createClass = $classInfo => {
    return jl_Class__init_($classInfo);
},
jl_Class_getName = $this => {
    let $metadataName, $result, $itemType, $itemName, var$5;
    if (!($this.$flags & 1)) {
        $this.$flags = $this.$flags | 1;
        $metadataName = ($rt_nullCheck($this.$classInfo))[$rt_meta].name;
        $result = $metadataName === null ? null : $rt_str($metadataName);
        if ($result === null) {
            $itemType = ($rt_nullCheck($this.$classInfo))[$rt_meta].itemType;
            if ($itemType !== null) {
                $itemName = jl_Class_getName($rt_nullCheck($rt_cls($itemType)));
                if ($itemName !== null) {
                    if ($itemType[$rt_meta].itemType !== null) {
                        var$5 = jl_StringBuilder__init_();
                        jl_StringBuilder_append($rt_nullCheck(jl_StringBuilder_append0(var$5, 91)), $itemName);
                        $result = jl_StringBuilder_toString(var$5);
                    } else {
                        var$5 = jl_StringBuilder__init_();
                        jl_StringBuilder_append0($rt_nullCheck(jl_StringBuilder_append($rt_nullCheck(jl_StringBuilder_append(var$5, $rt_s(6))), $itemName)), 59);
                        $result = jl_StringBuilder_toString(var$5);
                    }
                }
            }
        }
        $this.$name = $result;
    }
    return $this.$name;
},
jl_Class_desiredAssertionStatus = $this => {
    return 1;
},
jl_StringBuilder = $rt_classWithoutFields(jl_AbstractStringBuilder),
jl_StringBuilder__init_0 = $this => {
    jl_AbstractStringBuilder__init_0($this);
},
jl_StringBuilder__init_ = () => {
    let var_0 = new jl_StringBuilder();
    jl_StringBuilder__init_0(var_0);
    return var_0;
},
jl_StringBuilder_append = ($this, $obj) => {
    jl_AbstractStringBuilder_append0($this, $obj);
    return $this;
},
jl_StringBuilder_append0 = ($this, $c) => {
    jl_AbstractStringBuilder_append($this, $c);
    return $this;
},
jl_StringBuilder_insert = ($this, $index, $obj) => {
    jl_AbstractStringBuilder_insert0($this, $index, $obj);
    return $this;
},
jl_StringBuilder_insert2 = ($this, $index, $c) => {
    jl_AbstractStringBuilder_insert1($this, $index, $c);
    return $this;
},
jl_StringBuilder_insert1 = ($this, $index, $string) => {
    jl_AbstractStringBuilder_insert($this, $index, $string);
    return $this;
},
jl_StringBuilder_toString = $this => {
    return jl_AbstractStringBuilder_toString($this);
},
jl_StringBuilder_ensureCapacity = ($this, var$1) => {
    jl_AbstractStringBuilder_ensureCapacity($this, var$1);
},
jl_StringBuilder_insert3 = ($this, var$1, var$2) => {
    return $this.$insert2(var$1, var$2);
},
jl_StringBuilder_insert0 = ($this, var$1, var$2) => {
    return $this.$insert3(var$1, var$2);
},
jl_StringBuilder_insert4 = ($this, var$1, var$2) => {
    return $this.$insert4(var$1, var$2);
};
$rt_packages([-1, "java", 0, "lang"
]);
$rt_metadata([jl_Object, "Object", 1, 0, [], 1, 0, 0, ["$getClass", $rt_wrapFunction0(jl_Object_getClass), "$toString", $rt_wrapFunction0(jl_Object_toString), "$identity", $rt_wrapFunction0(jl_Object_identity)],
jl_Throwable, 0, jl_Object, [], 1, 0, 0, ["$fillInStackTrace", $rt_wrapFunction0(jl_Throwable_fillInStackTrace), "$getMessage", $rt_wrapFunction0(jl_Throwable_getMessage), "$getCause", $rt_wrapFunction0(jl_Throwable_getCause)],
jl_Exception, 0, jl_Throwable, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_Exception__init_0), "$_init_0", $rt_wrapFunction1(jl_Exception__init_)],
jl_RuntimeException, 0, jl_Exception, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_RuntimeException__init_), "$_init_0", $rt_wrapFunction1(jl_RuntimeException__init_0)],
jl_IndexOutOfBoundsException, 0, jl_RuntimeException, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_IndexOutOfBoundsException__init_)],
ju_Arrays, 0, jl_Object, [], 1, 0, 0, 0,
otj_JSObject, 0, jl_Object, [], 1537, 0, 0, 0,
jl_Error, 0, jl_Throwable, [], 1, 0, 0, ["$_init_0", $rt_wrapFunction1(jl_Error__init_)],
jl_AssertionError, 0, jl_Error, [], 1, 0, 0, ["$_init_4", $rt_wrapFunction1(jl_AssertionError__init_)],
ji_Serializable, 0, jl_Object, [], 1537, 0, 0, 0,
jl_Number, 0, jl_Object, [ji_Serializable], 1025, 0, 0, 0,
jl_Comparable, 0, jl_Object, [], 1537, 0, 0, 0,
jl_Integer, 0, jl_Number, [jl_Comparable], 1, 0, () => jl_Integer_$callClinit(), 0,
jl_ClassCastException, 0, jl_RuntimeException, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_ClassCastException__init_)],
otji_JSWrapper, 0, jl_Object, [], 17, 0, 0, 0,
juca_AtomicReference, 0, jl_Object, [ji_Serializable], 1, 0, 0, ["$_init_4", $rt_wrapFunction1(juca_AtomicReference__init_), "$get", $rt_wrapFunction0(juca_AtomicReference_get), "$compareAndSet", $rt_wrapFunction2(juca_AtomicReference_compareAndSet)],
jl_NullPointerException, 0, jl_RuntimeException, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_NullPointerException__init_)],
otp_Platform, 0, jl_Object, [], 17, 0, 0, 0,
jl_Character, 0, jl_Object, [jl_Comparable], 1, 0, () => jl_Character_$callClinit(), 0,
otci_IntegerUtil, 0, jl_Object, [], 17, 0, 0, 0,
jl_CharSequence, 0, jl_Object, [], 1537, 0, 0, 0,
jl_AbstractStringBuilder, 0, jl_Object, [ji_Serializable, jl_CharSequence], 0, 0, 0, ["$_init_", $rt_wrapFunction0(jl_AbstractStringBuilder__init_0), "$_init_2", $rt_wrapFunction1(jl_AbstractStringBuilder__init_), "$append1", $rt_wrapFunction1(jl_AbstractStringBuilder_append0), "$insert1", $rt_wrapFunction2(jl_AbstractStringBuilder_insert), "$append2", $rt_wrapFunction1(jl_AbstractStringBuilder_append), "$insert0", $rt_wrapFunction2(jl_AbstractStringBuilder_insert1), "$insert", $rt_wrapFunction2(jl_AbstractStringBuilder_insert0),
"$ensureCapacity", $rt_wrapFunction1(jl_AbstractStringBuilder_ensureCapacity), "$toString", $rt_wrapFunction0(jl_AbstractStringBuilder_toString)],
otrr_ReflectionInfo, 0, jl_Object, [], 1025, 0, 0, 0,
otr_StringInfo, 0, otrr_ReflectionInfo, [], 17, 0, 0, 0,
jl_Math, 0, jl_Object, [], 17, 0, 0, 0,
jl_String, 0, jl_Object, [ji_Serializable, jl_Comparable, jl_CharSequence], 1, 0, () => jl_String_$callClinit(), ["$_init_", $rt_wrapFunction0(jl_String__init_1), "$_init_1", $rt_wrapFunction1(jl_String__init_), "$_init_4", $rt_wrapFunction1(jl_String__init_0), "$_init_3", $rt_wrapFunction3(jl_String__init_2), "$charAt", $rt_wrapFunction1(jl_String_charAt), "$length", $rt_wrapFunction0(jl_String_length), "$isEmpty", $rt_wrapFunction0(jl_String_isEmpty), "$toString", $rt_wrapFunction0(jl_String_toString)],
otjc_JSString, 0, jl_Object, [otj_JSObject], 1025, 0, 0, 0,
jlr_AnnotatedElement, 0, jl_Object, [], 1537, 0, 0, 0,
jlr_GenericDeclaration, 0, jl_Object, [jlr_AnnotatedElement], 1537, 0, 0, 0,
smm_IMcfLibEntry, 0, jl_Object, [otj_JSObject], 1537, 0, 0, 0,
otji_JS, 0, jl_Object, [], 17, 0, 0, 0,
jl_Appendable, 0, jl_Object, [], 1537, 0, 0, 0,
smm_McfLibEntry, 0, jl_Object, [smm_IMcfLibEntry], 17, 0, () => smm_McfLibEntry_$callClinit(), ["$_init_", $rt_wrapFunction0(smm_McfLibEntry__init_), "$getInstance", $rt_wrapFunction0(smm_McfLibEntry_getInstance), "$getSingleton", $rt_wrapFunction0(smm_McfLibEntry_getSingleton), "$libReset0", $rt_wrapFunction0(smm_McfLibEntry_libReset0), "$libReset", $rt_wrapFunction1(smm_McfLibEntry_libReset), "$resetLib", $rt_wrapFunction1(smm_McfLibEntry_resetLib), "$resetLib0", $rt_wrapFunction0(smm_McfLibEntry_resetLib0),
"$getParentLibName", $rt_wrapFunction0(smm_McfLibEntry_getParentLibName), "$getParentLibVersion", $rt_wrapFunction0(smm_McfLibEntry_getParentLibVersion), "$getLibName", $rt_wrapFunction0(smm_McfLibEntry_getLibName), "$getLibVersion", $rt_wrapFunction0(smm_McfLibEntry_getLibVersion)],
jl_StringIndexOutOfBoundsException, 0, jl_IndexOutOfBoundsException, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_StringIndexOutOfBoundsException__init_0)],
jl_ArrayIndexOutOfBoundsException, 0, jl_IndexOutOfBoundsException, [], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_ArrayIndexOutOfBoundsException__init_)],
ju_Objects, 0, jl_Object, [], 17, 0, 0, 0,
jlr_Type, 0, jl_Object, [], 1537, 0, 0, 0,
otrr_ClassInfo, 0, otrr_ReflectionInfo, [], 17, 0, 0, 0,
ju_Comparator, 0, jl_Object, [], 1537, 0, 0, 0,
jl_String$_clinit_$lambda$_118_0, 0, jl_Object, [ju_Comparator], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_String$_clinit_$lambda$_118_0__init_)],
jl_Class, 0, jl_Object, [jlr_GenericDeclaration, jlr_Type], 17, 0, 0, ["$getName", $rt_wrapFunction0(jl_Class_getName), "$desiredAssertionStatus", $rt_wrapFunction0(jl_Class_desiredAssertionStatus)],
jl_StringBuilder, 0, jl_AbstractStringBuilder, [jl_Appendable], 1, 0, 0, ["$_init_", $rt_wrapFunction0(jl_StringBuilder__init_0), "$append", $rt_wrapFunction1(jl_StringBuilder_append), "$append0", $rt_wrapFunction1(jl_StringBuilder_append0), "$insert2", $rt_wrapFunction2(jl_StringBuilder_insert), "$insert3", $rt_wrapFunction2(jl_StringBuilder_insert2), "$insert4", $rt_wrapFunction2(jl_StringBuilder_insert1), "$toString", $rt_wrapFunction0(jl_StringBuilder_toString), "$ensureCapacity", $rt_wrapFunction1(jl_StringBuilder_ensureCapacity),
"$insert", $rt_wrapFunction2(jl_StringBuilder_insert3), "$insert0", $rt_wrapFunction2(jl_StringBuilder_insert0), "$insert1", $rt_wrapFunction2(jl_StringBuilder_insert4)]]);
let $rt_charArrayCls = $rt_arraycls($rt_charcls);
$rt_stringPool(["0", "null", "Singleton must not be null after initialization", "server.markhome", "3.1.42-20260918", "server.markhome.mcf", "[L"]);
jl_String.prototype.toString = function() {
    return $rt_ustr(this);
};
jl_String.prototype.valueOf = jl_String.prototype.toString;
jl_Object.prototype.toString = function() {
    return $rt_ustr(jl_Object_toString(this));
};
jl_Object.prototype.__teavm_class__ = function() {
    return $dbg_class(this);
};
let $rt_export_main = $rt_mainStarter(smm_McfLibEntry_main);
$rt_export_main.javaException = $rt_javaException;
let $rt_jso_marker = Symbol('jsoClass');
(() => {
    let c;
    c = smm_McfLibEntry.prototype;
    c.libReset = $rt_callWithReceiver(smm_McfLibEntry_libReset$exported$5);
    c.resetLib = $rt_callWithReceiver(smm_McfLibEntry_resetLib$exported$7);
    Object.defineProperty(c, "singleton", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getSingleton$exported$0)
    });
    Object.defineProperty(c, "parentLibVersion", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getParentLibVersion$exported$6)
    });
    Object.defineProperty(c, "parentLibName", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getParentLibName$exported$1)
    });
    Object.defineProperty(c, "instance", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getInstance$exported$3)
    });
    Object.defineProperty(c, "libName", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getLibName$exported$8)
    });
    Object.defineProperty(c, "libVersion", {
        get: $rt_callWithReceiver(smm_McfLibEntry_getLibVersion$exported$9)
    });
})();
$rt_exports.main = $rt_export_main;
$rt_exports.resetLib = smm_McfLibEntry_resetLib$exported$2;
$rt_exports.libReset = smm_McfLibEntry_libReset$exported$4;
$rt_exports.libReset = smm_McfLibEntry_libReset$exported$5;
$rt_exports.resetLib = smm_McfLibEntry_resetLib$exported$7;
$rt_exports.getMcfLibEntrySingleton = smm_McfLibEntry_getMcfLibEntrySingleton$exported$0;
$rt_exports.getMcfLibEntryInstance = smm_McfLibEntry_getMcfLibEntryInstance$exported$1;
$rt_exports.execMcfLibEntryLibReset = smm_McfLibEntry_execMcfLibEntryLibReset$exported$2;
$rt_exports.main = smm_McfLibEntry_main$exported$3;
$rt_exports.main = smm_McfLibEntry_main$exported$4;
}));

//# sourceMappingURL=server.markhome.mcfClasses.js.map