package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {

}
