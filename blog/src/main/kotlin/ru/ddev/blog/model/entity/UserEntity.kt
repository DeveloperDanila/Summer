package ru.ddev.blog.model.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import ru.ddev.blog.model.enums.UserRole
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class UserEntity (
    @Id
    @Column(name = "user_id", nullable = false)
    val id: Long?,

    @Column(name = "username", nullable = false, length = 100)
    val username: String,

    @Column(name = "email", nullable = false, length = 150)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    val createdAt: LocalDateTime,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    val role: UserRole,
) {
}