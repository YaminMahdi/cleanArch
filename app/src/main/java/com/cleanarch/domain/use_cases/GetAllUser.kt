package com.cleanarch.domain.use_cases

import com.cleanarch.domain.repo.MainRepo
import javax.inject.Inject

class GetAllUser @Inject constructor(
    val repo: MainRepo
) {
    suspend operator fun invoke() = repo.getAllUser()
}