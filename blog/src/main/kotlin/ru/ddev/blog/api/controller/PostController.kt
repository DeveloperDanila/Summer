package ru.ddev.blog.api.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.ddev.blog.api.request.PostCreateRq
import ru.ddev.blog.api.view.PostView
import ru.ddev.blog.post.PostService

@RestController
class PostController(private val postService: PostService) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/api/v1/posts")
    fun getAllPosts() : List<PostView> {
        log.info("GET all posts request")
        return postService.findAllPosts().map { PostView.from(it) }
    }

    @PostMapping("/api/v1/posts")
    fun createPost(@RequestBody rq : PostCreateRq) : PostView {
        log.info("POST create post request")
        return postService.createPostBy(rq.title, rq.body).let { PostView.from(it) }
    }

}