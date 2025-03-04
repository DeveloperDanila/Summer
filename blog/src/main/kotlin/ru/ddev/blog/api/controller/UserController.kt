package ru.ddev.blog.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.ddev.blog.api.view.UserView
import ru.ddev.blog.domain.user.UserService
import ru.ddev.blog.model.enums.UserRole

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/api/v1/users")
    fun getAllUsers() : List<UserView> {
        return userService.findAllUsers().map { UserView.from(it) }
    }

    @PostMapping("/api/v1/users")
    fun createUser() : UserView {
        return UserView(1, "LoL", UserRole.SUBSCRIBER)
    }

}