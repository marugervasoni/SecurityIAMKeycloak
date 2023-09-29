package com.example.msusers.repository;

import com.example.msusers.domain.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class KeycloakUserRepository {

    @Autowired
    private Keycloak keycloakClient;

    @Value("${dh.keycloak.realm}")
    private String realm;

    public User findById(String id){
        UserRepresentation userRep = keycloakClient
                .realm(realm)
                .users()
                .get(id)
                .toRepresentation();
        return toUser(userRep);
    }

    private User toUser(UserRepresentation userRepresentation) {
        return new User(
                userRepresentation.getId(),
                userRepresentation.getUsername(),
                userRepresentation.getEmail(),
                userRepresentation.getFirstName());
    }
}
