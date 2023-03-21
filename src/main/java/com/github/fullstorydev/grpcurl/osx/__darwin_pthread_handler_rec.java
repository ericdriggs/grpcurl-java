// Generated by jextract

package com.github.fullstorydev.grpcurl.osx;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
public class __darwin_pthread_handler_rec {

    static final  GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
        Constants$root.C_POINTER$LAYOUT.withName("__routine"),
        Constants$root.C_POINTER$LAYOUT.withName("__arg"),
        Constants$root.C_POINTER$LAYOUT.withName("__next")
    ).withName("__darwin_pthread_handler_rec");
    public static MemoryLayout $LAYOUT() {
        return __darwin_pthread_handler_rec.$struct$LAYOUT;
    }
    static final FunctionDescriptor __routine$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle __routine$MH = RuntimeHelper.downcallHandle(
        __darwin_pthread_handler_rec.__routine$FUNC
    );
    public interface __routine {

        void apply(java.lang.foreign.MemoryAddress _x0);
        static MemorySegment allocate(__routine fi, MemorySession session) {
            return RuntimeHelper.upcallStub(__routine.class, fi, __darwin_pthread_handler_rec.__routine$FUNC, session);
        }
        static __routine ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    __darwin_pthread_handler_rec.__routine$MH.invokeExact((Addressable)symbol, (java.lang.foreign.Addressable)__x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle __routine$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("__routine"));
    public static VarHandle __routine$VH() {
        return __darwin_pthread_handler_rec.__routine$VH;
    }
    public static MemoryAddress __routine$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__routine$VH.get(seg);
    }
    public static void __routine$set( MemorySegment seg, MemoryAddress x) {
        __darwin_pthread_handler_rec.__routine$VH.set(seg, x);
    }
    public static MemoryAddress __routine$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__routine$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void __routine$set(MemorySegment seg, long index, MemoryAddress x) {
        __darwin_pthread_handler_rec.__routine$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static __routine __routine (MemorySegment segment, MemorySession session) {
        return __routine.ofAddress(__routine$get(segment), session);
    }
    static final VarHandle __arg$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("__arg"));
    public static VarHandle __arg$VH() {
        return __darwin_pthread_handler_rec.__arg$VH;
    }
    public static MemoryAddress __arg$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__arg$VH.get(seg);
    }
    public static void __arg$set( MemorySegment seg, MemoryAddress x) {
        __darwin_pthread_handler_rec.__arg$VH.set(seg, x);
    }
    public static MemoryAddress __arg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__arg$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void __arg$set(MemorySegment seg, long index, MemoryAddress x) {
        __darwin_pthread_handler_rec.__arg$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle __next$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("__next"));
    public static VarHandle __next$VH() {
        return __darwin_pthread_handler_rec.__next$VH;
    }
    public static MemoryAddress __next$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__next$VH.get(seg);
    }
    public static void __next$set( MemorySegment seg, MemoryAddress x) {
        __darwin_pthread_handler_rec.__next$VH.set(seg, x);
    }
    public static MemoryAddress __next$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)__darwin_pthread_handler_rec.__next$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void __next$set(MemorySegment seg, long index, MemoryAddress x) {
        __darwin_pthread_handler_rec.__next$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session); }
}


