package com.wemakeprice.springbootstudy.persistence;

import com.wemakeprice.springbootstudy.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
