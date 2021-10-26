package com.example.soap.domain;

import com.example.soap.resources.ClientState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "GetClientsResponseDto")
@XmlType(name = "GetClientsResponseDto", namespace = "http://rebel.com/govnocode")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class GetClientsResponseDto {

    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String code;
    @XmlElement(namespace = "http://rebel.com/govnocode")
    private String message;
    @XmlElement(name = "clientsInfo", nillable = true, namespace = "http://rebel.com/govnocode")
    private ClientInfoListDto clientInfoList;

    public GetClientsResponseDto(ClientState state, List<ClientInfoDto> clientsInfo) {

        this.code = state.getCode();
        this.message = state.getDescription();
        this.clientInfoList = new ClientInfoListDto(clientsInfo);
    }

    public GetClientsResponseDto(ClientState state) {

        this.code = state.getCode();
        this.message = state.getDescription();
    }
}