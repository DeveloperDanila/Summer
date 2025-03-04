package ru.ddev.blog.api.view

import ru.ddev.blog.domain.user.User
import ru.ddev.blog.model.enums.UserRole

data class UserView(val id: Long, val username: String, val role: UserRole) {
    companion object {
        fun from(user: User) : UserView{
            return UserView(user.id, user.username, user.role)
        }
    }
}