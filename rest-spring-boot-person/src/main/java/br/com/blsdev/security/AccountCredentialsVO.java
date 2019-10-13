package br.com.blsdev.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {
    private String username;
    private String password;
}
