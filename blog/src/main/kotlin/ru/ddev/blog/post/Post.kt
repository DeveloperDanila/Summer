package ru.ddev.blog.post

import ru.ddev.blog.model.entity.PostEntity
import ru.ddev.blog.model.entity.UserEntity

data class Post(val id: Long?, val title: String, val body: String) {


    companion object {
        fun from(entity: PostEntity): Post = Post(entity.id, entity.title, entity.body)
    }

    fun toEntity(user: UserEntity): PostEntity {
        return PostEntity(id, user, title, toSlug(title), body, )
    }

    private fun toSlug(title: String): String {
        return title.replace(" ", "-")
    }
}
