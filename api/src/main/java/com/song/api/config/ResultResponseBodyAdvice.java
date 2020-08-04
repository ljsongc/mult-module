package com.song.api.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * api接口返回时封装成 Result
 *
 * @author songlijun
 * @date 2020/7/21
 */
@ControllerAdvice("com.song.api.controller")
public class ResultResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (MappingJackson2HttpMessageConverter.class.isAssignableFrom(selectedConverterType)) {
            return new Result<>(ResultStatus.SUCCESS, body);
        } else {
            return body;
        }
    }
}
