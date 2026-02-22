package com.mynextjob.Backend.repositories;

import com.mynextjob.Backend.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // חיפוש לצורך התחברות (Login)
    Optional<User> findByEmail(String email);

    // ולידציה לפני הרשמה
    boolean existsByEmail(String email);

    // חיפוש גמיש לפי שם (למשל עבור דוחות או ניהול)
    // ה-Containing מאפשר חיפוש של חלק מהשם (כמו LIKE %name% ב-SQL)
    List<User> findByFullNameContainingIgnoreCase(String fullName);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.enabled = false WHERE u.id = :userId")
    void softDelete(@Param("userId") Long userId);
}