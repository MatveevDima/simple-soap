package com.example.soap.configuration;

import com.example.soap.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class SoapConfiguration {

    private final Bus bus;

    @Bean
    public Endpoint endpoint1(ClientService clientServiceEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, clientServiceEndpoint);
        endpoint.setServiceName(ClientService.SERVICE_QNAME);
        endpoint.publish("/ClientService");
        return endpoint;
    }
}