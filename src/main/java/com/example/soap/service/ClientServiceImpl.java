package com.example.soap.service;

import com.example.soap.dao.ClientRepository;
import com.example.soap.domain.AddClientInfoRequest;
import com.example.soap.domain.ClientInfoDto;
import com.example.soap.domain.ClientInfoResponseDto;
import com.example.soap.domain.GetClientsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceProvider;
import java.util.List;
import java.util.logging.Logger;

import static com.example.soap.resources.ClientState.*;
import static com.example.soap.resources.LoggerResources.*;
import static java.util.logging.Level.INFO;

@Service
@WebServiceProvider(portName = "ClientPort")
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final static Logger LOG = Logger.getLogger(ClientServiceImpl.class.getCanonicalName());
    private final ClientRepository repository;

    @Override
    public ClientInfoResponseDto addClientInfo(AddClientInfoRequest clientInfo) {

        LOG.log(INFO, ENTRY);
        if (clientInfo == null) {
            LOG.log(INFO, EXIT);
            return new ClientInfoResponseDto(OUT_OF_INPUT_VALUE);
        }
        if (!clientInfo.isValid()) {
            LOG.log(INFO, EXIT);
            return new ClientInfoResponseDto(EMPTY_OF_INPUT_VALUE);
        }
        try {
            repository.addClientInfo(clientInfo);
        } catch (Exception ex) {
            LOG.log(INFO, THROW, ex);
            LOG.log(INFO, EXIT);
            return new ClientInfoResponseDto(SAVE_TO_DB_FAILED);
        }
        LOG.log(INFO, EXIT);
        return new ClientInfoResponseDto(SUCCESSFUL);
    }

    @Override
    public GetClientsResponseDto getClients() {

        LOG.log(INFO, ENTRY);
        List<ClientInfoDto> response;
        try {
            response = repository.getClients();
        } catch (Exception ex) {
            LOG.log(INFO, THROW, ex);
            LOG.log(INFO, EXIT);
            return new GetClientsResponseDto(SAVE_TO_DB_FAILED);
        }
        LOG.log(INFO, EXIT);
        return new GetClientsResponseDto(SUCCESSFUL, response);
    }
}