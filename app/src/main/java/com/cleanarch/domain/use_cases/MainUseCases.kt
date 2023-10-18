package com.cleanarch.domain.use_cases

import javax.inject.Inject

data class MainUseCases @Inject constructor(
    val getUser: GetUser,
    val getAllUser: GetAllUser
)
