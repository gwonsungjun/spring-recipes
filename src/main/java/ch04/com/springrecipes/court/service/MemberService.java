package ch04.com.springrecipes.court.service;

import java.util.Collection;

import ch04.com.springrecipes.court.domain.Member;

public interface MemberService {

    Collection<Member> findAll();
    Member find(long id);
}
