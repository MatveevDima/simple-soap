package com.example.soap.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.cxf.common.util.StringUtils;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ClientInfo")
@XmlType(name = "AddClientInfoRequest", namespace = "http://rebel.com/govnocode")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class AddClientInfoRequest {

    @XmlElement(name = "name", required = true, namespace = "http://rebel.com/govnocode")
    private String name;
    @XmlElement(name = "phone", required = true, namespace = "http://rebel.com/govnocode")
    private String phone;
    @XmlElement(name = "mail", required = true, namespace = "http://rebel.com/govnocode")
    private String mail;
    @XmlElement(name = "address", required = true, namespace = "http://rebel.com/govnocode")
    private String address;

    public boolean isValid() {
        return (!StringUtils.isEmpty(name) &&
                !StringUtils.isEmpty(phone) &&
                !StringUtils.isEmpty(mail) &&
                !StringUtils.isEmpty(address));
    }
}