package com.example.soap.service;

import com.example.soap.domain.AddClientInfoRequest;
import com.example.soap.domain.ClientInfoResponseDto;
import com.example.soap.domain.GetClientsResponseDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.namespace.QName;

@WebService(
        portName = "ClientPort",
        serviceName = "ClientService",
        targetNamespace = "http://rebel.com/govnocode",
        endpointInterface = "com.example.soap.service.ClientService"
)
public interface ClientService {

    public static final QName SERVICE_QNAME =
            new QName("http://rebel.com/govnocode", "ClientService");

    @WebMethod
    ClientInfoResponseDto addClientInfo(
            @WebParam(name = "ClientInfo") @XmlElement(required = true) AddClientInfoRequest clientInfo);

    @WebMethod
    GetClientsResponseDto getClients();
}