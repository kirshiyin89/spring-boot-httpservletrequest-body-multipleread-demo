package com.request.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class DemoController {

    @PostMapping(value = "/demo")
    public ResponseEntity<byte[]> demoMethod(HttpServletRequest request) throws IOException {

        // deliberately consume the stream. in real cases, the stream has been consumed by a logging request or similar operations
        StreamUtils.copyToByteArray(request.getInputStream());

        byte[] body = StreamUtils.copyToByteArray(request.getInputStream());

        log.info("Request body: {}", new String(body, StandardCharsets.UTF_8));

        return ResponseEntity.ok().body(body);
    }
}
