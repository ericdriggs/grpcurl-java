package com.github.fullstorydev.grpcurl.osx;

import java.lang.foreign.Linker;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;


final class RuntimeHelper {

    private RuntimeHelper() {}
    private final static Linker LINKER = Linker.nativeLinker();
    private final static SymbolLookup SYMBOL_LOOKUP;


    static {
        System.load("/usr/local/lib/grpcurl/grpcurl.dylib");
        //System.loadLibrary("grpcurl");
        SymbolLookup loaderLookup = SymbolLookup.loaderLookup();
        SYMBOL_LOOKUP = name -> loaderLookup.lookup(name).or(() -> LINKER.defaultLookup().lookup(name));
    }

    static <T> T requireNonNull(T obj, String symbolName) {
        if (obj == null) {
            throw new UnsatisfiedLinkError("unresolved symbol: " + symbolName);
        }
        return obj;
    }

    static final MethodHandle downcallHandle(String name, FunctionDescriptor fdesc) {
        return SYMBOL_LOOKUP.lookup(name).
                map(addr -> LINKER.downcallHandle(addr, fdesc)).
                orElse(null);
    }
}
