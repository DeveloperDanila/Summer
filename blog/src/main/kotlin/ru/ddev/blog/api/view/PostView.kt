package ru.ddev.blog.api.view

import ru.ddev.blog.post.Post

data class PostView(val id: Long, val title: String, val body: String) {

    companion object {
        fun from(entity: Post): PostView = PostView(entity.id!!, entity.title, entity.body)
    }
}
