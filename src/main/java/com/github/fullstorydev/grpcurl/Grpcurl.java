package com.github.fullstorydev.grpcurl;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;

public class Grpcurl {


    public static void main(String[] osArgs) {

        // Use auto-closable session so don't need to manage off-heap memory
        try (MemorySession session = MemorySession.openConfined()) {

            // Allocate off-heap memory to store pointers for each arg cString
            MemorySegment cStrings = session.allocateArray(ValueLayout.ADDRESS, osArgs.length);

            // Copy the strings from on-heap String[] to off-heap MemorySegments
            for (int i = 0; i < osArgs.length; i++) {
                // Allocate a string off-heap, then store a pointer to it
                MemorySegment cString = session.allocateUtf8String(osArgs[i]);
                cStrings.setAtIndex(ValueLayout.ADDRESS, i, cString);
            }

            grpcurl_h.mainExport(cStrings);
        }
    }
}