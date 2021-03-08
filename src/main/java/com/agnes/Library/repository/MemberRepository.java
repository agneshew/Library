package com.agnes.Library.repository;

import com.agnes.Library.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
