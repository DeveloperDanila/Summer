package ru.ddev.blog.model.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import ru.ddev.blog.model.enums.PostStatus
import java.time.Instant
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
class PostEntity(
    @Id
    @Column(name = "post_id", nullable = false)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,
    @Column(name = "title", nullable = false)
    val title: String,
    @Column(name = "slug", nullable = false)
    val slug: String,
    @Column(name = "body", nullable = false, length = Integer.MAX_VALUE)
    val body: String,
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    @ColumnDefault("'draft'")
    @Column(name = "status", columnDefinition = "post_status_type")
    @Enumerated(EnumType.STRING)
    val status: PostStatus = PostStatus.DRAFT,
) {

}