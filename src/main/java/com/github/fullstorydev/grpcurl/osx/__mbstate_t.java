// Generated by jextract

package com.github.fullstorydev.grpcurl.osx;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
public class __mbstate_t {

    static final  GroupLayout $union$LAYOUT = MemoryLayout.unionLayout(
        MemoryLayout.sequenceLayout(128, Constants$root.C_CHAR$LAYOUT).withName("__mbstate8"),
        Constants$root.C_LONG_LONG$LAYOUT.withName("_mbstateL")
    );
    public static MemoryLayout $LAYOUT() {
        return __mbstate_t.$union$LAYOUT;
    }
    public static MemorySegment __mbstate8$slice(MemorySegment seg) {
        return seg.asSlice(0, 128);
    }
    static final VarHandle _mbstateL$VH = $union$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("_mbstateL"));
    public static VarHandle _mbstateL$VH() {
        return __mbstate_t._mbstateL$VH;
    }
    public static long _mbstateL$get(MemorySegment seg) {
        return (long)__mbstate_t._mbstateL$VH.get(seg);
    }
    public static void _mbstateL$set( MemorySegment seg, long x) {
        __mbstate_t._mbstateL$VH.set(seg, x);
    }
    public static long _mbstateL$get(MemorySegment seg, long index) {
        return (long)__mbstate_t._mbstateL$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void _mbstateL$set(MemorySegment seg, long index, long x) {
        __mbstate_t._mbstateL$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session); }
}


