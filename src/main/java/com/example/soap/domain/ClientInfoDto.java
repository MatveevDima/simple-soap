package com.example.soap.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ClientInfo")
@XmlType(name = "ClientInfoDto", namespace = "http://rebel.com/govnocode")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class ClientInfoDto {

    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String id;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String name;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String phone;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String mail;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String address;
}
