package org.imdb.impl.service;

import org.imdb.api.service.UserService;
import org.imdb.model.domain.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends CRUDServiceImpl<User> implements UserService {}