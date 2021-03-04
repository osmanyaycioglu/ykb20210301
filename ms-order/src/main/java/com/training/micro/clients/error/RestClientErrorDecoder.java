package com.training.micro.clients.error;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.micro.rest.error.ErrorObject;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class RestClientErrorDecoder implements ErrorDecoder {

    @Override
    public RestClientException decode(final String methodKeyParam,
                                      final Response responseParam) {
        if (responseParam.status() != 404) {
            try {
                InputStream asInputStreamLoc = responseParam.body()
                                                            .asInputStream();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                               ErrorObject.class);
                return new RestClientException(readValueLoc);
            } catch (Exception eLoc) {
                return new RestClientException();
            }
        }
        return new RestClientException();
    }

}
