package com.cleanarch.domain.use_cases

import com.cleanarch.domain.repo.MainRepo
import javax.inject.Inject

class GetUser @Inject constructor(
    val repo: MainRepo
) {
    operator fun invoke() = repo.getUser()
}