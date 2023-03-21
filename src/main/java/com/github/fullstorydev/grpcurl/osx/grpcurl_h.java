package com.github.fullstorydev.grpcurl.osx;

import java.lang.invoke.MethodHandle;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
public class grpcurl_h  {

    /* package-private */ grpcurl_h() {}
    static final  OfAddress C_POINTER$LAYOUT = ADDRESS.withBitAlignment(64);

    static final FunctionDescriptor cmain$FUNC = FunctionDescriptor.of(C_POINTER$LAYOUT,
            C_POINTER$LAYOUT
    );
    static final MethodHandle cmain$MH = RuntimeHelper.downcallHandle(
            "cmain",
            cmain$FUNC
    );

    public static MethodHandle cmain$MH() {
        return RuntimeHelper.requireNonNull(cmain$MH,"cmain");
    }
    public static MemoryAddress cmain ( Addressable osArgsC) {
        var mh$ = cmain$MH();
        try {
            return (java.lang.foreign.MemoryAddress)mh$.invokeExact(osArgsC);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}


