package com.authlibrary.controller;

import com.authlibrary.builder.ApiResponse;
import com.authlibrary.builder.ApiResponseBuilder;
import com.authlibrary.exception.BadApiRequestException;
import com.authlibrary.model.UserRequestDto;
import com.authlibrary.util.ApiConstant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.authlibrary.model.JwtTokenResponse;
import com.authlibrary.model.LoginRequest;
import com.authlibrary.model.UserDto;
import com.authlibrary.service.UserService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_USER_CONTROLLER)
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = ApiConstant.EP_CREATE_USER)
    @Operation(summary = "Create User", description = "Create User")
    public ResponseEntity<ApiResponse> createProject(@RequestBody @Valid UserRequestDto request) throws Exception {
        log.info("usercontroller::createuser " + request);
        try {
            UserDto userDto = userService.saveUser(request);
            return ApiResponseBuilder.getSuccessResponse(userDto, "User created successfully", HttpStatus.CREATED);
        } catch (BadApiRequestException ex) {
            log.error("bad api request in creating user", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("exception in creating user");
            return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @PostMapping(value = ApiConstant.EP_LOGIN)
    @Operation(summary = "User Login", description = "User Login")
    public ResponseEntity<ApiResponse> generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
        try{
            log.info("UserController::login " + loginRequest);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
            if(authentication.isAuthenticated()){
                JwtTokenResponse response = userService.generateToken(loginRequest.getUserName());
                return ApiResponseBuilder.getSuccessResponse(response, "User Login successfully", HttpStatus.OK);
            }else{
                throw new BadApiRequestException("Invalid Credentials");
            }
        }catch (Exception e){
            throw new BadApiRequestException("Invalid Credentials");
        }
    }

}
