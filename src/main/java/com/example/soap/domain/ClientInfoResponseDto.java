package com.example.soap.domain;

import com.example.soap.resources.ClientState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ClientInfo")
@XmlType(name = "ClientInfoResponseDto", namespace = "http://rebel.com/govnocode")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class ClientInfoResponseDto {

    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String code;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String message;

    public ClientInfoResponseDto(ClientState state) {

        this.code = state.getCode();
        this.message = state.getDescription();
    }
}