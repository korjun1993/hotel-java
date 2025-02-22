package com.hotelJava.member.application.service;

import com.hotelJava.member.application.port.in.ChangePasswordUseCase;
import com.hotelJava.member.application.port.out.persistence.FindMemberPort;
import com.hotelJava.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangePasswordService implements ChangePasswordUseCase {

  private final FindMemberPort findMemberPort;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void changePassword(String email, String password) {
    Member member = findMemberPort.findByEmail(email);
    member.changePassword(passwordEncoder.encode(password));
  }
}
