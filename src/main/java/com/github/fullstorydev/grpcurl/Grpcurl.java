package com.github.fullstorydev.grpcurl;


import com.github.fullstorydev.grpcurl.osx.grpcurl_h;
import lombok.extern.slf4j.Slf4j;

import java.lang.foreign.MemoryAddress;
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

            var cString = session.allocateUtf8String(osArgsString);
            MemoryAddress memoryAddress = grpcurl_h.cmain(cString);
            System.out.println(memoryAddress);

            String json = memoryAddress.getUtf8String(0);
            exitCodeMessage = ExitCodeMessage.fromJson(json);
        }
        return exitCodeMessage;

    }
}