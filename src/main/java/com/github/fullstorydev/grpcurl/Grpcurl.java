package com.github.fullstorydev.grpcurl;


import lombok.extern.slf4j.Slf4j;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

@Slf4j
public class Grpcurl {


    public static void main(String[] osArgs) {

        ExitCodeMessage exitCodeMessage = grpcurl(osArgs);
        log.debug("exitCodeMessage: {}", exitCodeMessage);
    }

    public static ExitCodeMessage grpcurl(String[] osArgs) {
        // Use auto-closable session so don't need to manage off-heap memory
        String osArgsString = String.join("\n", osArgs);
        log.debug("osArgsString: {}", osArgsString);

        ExitCodeMessage exitCodeMessage = new ExitCodeMessage(-1,"not yet run");

        try (MemorySession session = MemorySession.openConfined()) {

            MemorySegment osArgsSegment = session.allocateUtf8String(osArgsString);

            //TODO: how do I free the memory from response MemoryAddress?
            MemoryAddress response = grpcurl_h.cmain(osArgsSegment);
            String responseJson = response.getUtf8String(0);

            exitCodeMessage = ExitCodeMessage.fromJson(responseJson);

        }
        return exitCodeMessage;


    }
}