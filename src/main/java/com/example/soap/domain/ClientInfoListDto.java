package com.example.soap.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ClientsInfo")
@XmlType(name = "ClientInfoListDto", namespace = "http://rebel.com/govnocode")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClientInfoListDto {

    @XmlElement(name = "clientInfo", nillable = true, namespace = "http://rebel.com/govnocode")
    private List<ClientInfoDto> clientsInfo;
}