package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Badge;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BadgeRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BadgeRepository badgeRepository;


//    Optional<Badge> findByBadgeId(String badgeId);

    @Test
    public void findByBadgeId_thenReturnBadge() {
        Badge badge = new Badge("Abel", "Active", "123");
        entityManager.persist(badge);
        entityManager.flush();
        Optional<Badge> optionalBadge = badgeRepository.findByBadgeId(badge.getBadgeId());
        assertTrue(optionalBadge.isPresent());
        Badge found = optionalBadge.get();
        AssertionsForInterfaceTypes.assertThat(found.getBadgeId()).isEqualTo(badge.getBadgeId());
    }
}
