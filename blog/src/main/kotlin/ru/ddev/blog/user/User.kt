package ru.ddev.blog.domain.user

import ru.ddev.blog.model.entity.UserEntity
import ru.ddev.blog.model.enums.UserRole

class User(val id: Long, val username: String, val role: UserRole) {

    companion object {
        fun from(user: UserEntity): User {
            return User(user.id!!, user.username, user.role)
        }
    }
}