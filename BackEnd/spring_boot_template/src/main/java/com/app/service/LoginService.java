package com.app.service;

import com.app.dto.HomeDto;
import com.app.dto.LoginDto;

public interface LoginService {

	HomeDto validateLogin(LoginDto login);

}
