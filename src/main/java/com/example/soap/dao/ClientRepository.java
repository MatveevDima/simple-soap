package com.example.soap.dao;

import com.example.soap.domain.AddClientInfoRequest;
import com.example.soap.domain.ClientInfoDto;

import java.util.List;

public interface ClientRepository {

    void addClientInfo(AddClientInfoRequest clientInfo);

    List<ClientInfoDto> getClients();
}