package ru.ddev.blog.post

import org.springframework.stereotype.Service
import ru.ddev.blog.api.view.PostView
import ru.ddev.blog.domain.user.UserService
import ru.ddev.blog.model.entity.PostEntity
import ru.ddev.blog.model.repository.PostRepository
import ru.ddev.blog.model.repository.UserRepository

@Service
class PostService(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val userService: UserService
    ) {

    fun findAllPosts(): List<Post> {
        return postRepository.findAll().map { Post.from(it) }
    }

    fun createPostBy(title: String, body: String): Post {
        val post = Post(null, title, body)
        val user = userService.getCurrentUser()
        val userEntity = userRepository.findByUsername(user.username) // TODO: find or create user
        val entity = post.toEntity(userEntity)
        return postRepository.save(entity).let { Post.from(it) }
    }
}