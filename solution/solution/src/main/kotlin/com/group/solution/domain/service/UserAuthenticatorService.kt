package com.group.solution.domain.service

import com.group.solution.domain.service.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserAuthenticatorService (val repositoy: UserRepository){
}