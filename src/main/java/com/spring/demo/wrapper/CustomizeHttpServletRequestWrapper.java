package com.spring.demo.wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.CharStreams;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName RequestWrapper
 * @Author leichen.china@gmail.com
 * @Date 2019-08-21 16:11
 * @Describe TODO
 */
public class CustomizeHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private String requestBody;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public CustomizeHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        try (InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream())) {
            requestBody = CharStreams.toString(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        JsonNode jsonNode = new ObjectMapper().reader().readTree(requestBody);
        ((ObjectNode) jsonNode).put("userId", "administrator");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jsonNode.toString().getBytes());

        return new ServletInputStream() {
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}
