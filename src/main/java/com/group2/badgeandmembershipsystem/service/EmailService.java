package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Email;

import javax.mail.MessagingException;

public interface EmailService {

    public void sendEmail(Email email) throws MessagingException;
}
