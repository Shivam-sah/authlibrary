package com.authlibrary.serviceimpl;

import com.authlibrary.exception.BadApiRequestException;
import com.authlibrary.model.JwtTokenResponse;
import com.authlibrary.entity.User;
import com.authlibrary.model.UserDto;
import com.authlibrary.model.UserRequestDto;
import com.authlibrary.repository.UserRepository;
import com.authlibrary.service.UserService;
import com.authlibrary.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    public JwtTokenResponse generateToken(String userName) {
        String token = jwtUtil.generateToken(userName);
         return JwtTokenResponse.builder().
                 token(token).
                 type("Bearer")
                 .validUntil(jwtUtil.extractExpiration(token).toString()).build();
    }

    @Override
    public UserDto saveUser(UserRequestDto request) {
        try {
            userRepository.findByUserNameAndActive(request.getUserName(),true).ifPresent(user -> {
                throw new BadApiRequestException("User already exists with username: " + request.getUserName());
            });
            User savedUser = userRepository.save(User.builder()
                            .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .userName(request.getUserName())
                    .roles(request.getRoles())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build());
            return modelMapper.map(savedUser, UserDto.class);
        }catch(Exception ex){
            throw ex;
        }
    }
}
