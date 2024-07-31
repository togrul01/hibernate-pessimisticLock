package org.example.hibernatepessimist.services;

import org.apache.catalina.security.SecurityClassLoad;
import org.example.hibernatepessimist.entity.AuditRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        String currentUser= Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)//  hemen andaki melumatlarini alir
                .map(User.class::cast)
                .map(User::getUsername)
                .orElse("Unknown user");

        AuditRevisionEntity audit=(AuditRevisionEntity) revisionEntity;
        audit.setUser(currentUser);

    }
}
