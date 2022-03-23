package com.ktb.auth.configure;

import lombok.Data;

@Data
public class FebsClientsProperties {

    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
