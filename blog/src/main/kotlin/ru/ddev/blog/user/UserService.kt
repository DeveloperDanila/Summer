package ru.ddev.blog.domain.user

import org.springframework.stereotype.Service
import ru.ddev.blog.domain.user.User.Companion.from
import ru.ddev.blog.model.enums.UserRole
import ru.ddev.blog.model.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAllUsers() : List<User> {
       return userRepository.findAll().map { from(it) }
    }

    fun getCurrentUser(): User {
        //TODO: get from jwt token from request
        return User(1, "admin", UserRole.ADMIN)
    }
}
