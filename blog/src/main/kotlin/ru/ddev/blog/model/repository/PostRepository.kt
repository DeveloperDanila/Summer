package ru.ddev.blog.model.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ddev.blog.model.entity.PostEntity

@Repository
interface PostRepository : JpaRepository<PostEntity, Long> {
}