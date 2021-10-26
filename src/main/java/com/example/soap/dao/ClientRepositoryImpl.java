package com.example.soap.dao;

import com.example.soap.domain.AddClientInfoRequest;
import com.example.soap.domain.ClientInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.example.soap.resources.LoggerResources.ENTRY;
import static com.example.soap.resources.LoggerResources.EXIT;
import static java.sql.Types.VARCHAR;
import static java.util.logging.Level.INFO;

@Repository
@RequiredArgsConstructor
@Transactional(transactionManager = "transactionManager")
public class ClientRepositoryImpl implements ClientRepository {

    private final static Logger LOG = Logger.getLogger(ClientRepositoryImpl.class.getCanonicalName());
    private final NamedParameterJdbcTemplate jdbcNamedTemplate;

    private static final String SQL_ADD_CLIENT_INFO =
            "INSERT INTO CLIENT_INFO VALUES (null, :name, :phone, :mail, :address)";

    private static final String SQL_GET_CLIENTS =
            "SELECT * FROM CLIENT_INFO ";

    @Override
    public void addClientInfo(AddClientInfoRequest clientInfo) {

        LOG.log(INFO, ENTRY);
        jdbcNamedTemplate.update(SQL_ADD_CLIENT_INFO,
                new MapSqlParameterSource()
                        .addValue("name", clientInfo.getName(), VARCHAR)
                        .addValue("phone", clientInfo.getPhone(), VARCHAR)
                        .addValue("mail", clientInfo.getMail(), VARCHAR)
                        .addValue("address", clientInfo.getAddress(), VARCHAR));
        LOG.log(INFO, EXIT);
    }

    @Override
    public List<ClientInfoDto> getClients() {

        LOG.log(INFO, ENTRY);
        List<ClientInfoDto> result =
                jdbcNamedTemplate.query(SQL_GET_CLIENTS, new BeanPropertyRowMapper<>(ClientInfoDto.class));
        LOG.log(INFO, EXIT);
        return result;
    }
}
