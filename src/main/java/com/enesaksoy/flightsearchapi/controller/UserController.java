package com.enesaksoy.flightsearchapi.controller;

import com.enesaksoy.flightsearchapi.RestResponse;
import com.enesaksoy.flightsearchapi.controller.contract.UserControllerContract;
import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;


    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll(){
        List<UserDTO> userDTOList = userControllerContract.findAll();
        return  ResponseEntity.ok(RestResponse.of(userDTOList));
    }


    @DeleteMapping
    public ResponseEntity<RestResponse<String>> delete(@RequestBody UserDeleteRequest userDeleteRequest){
        userControllerContract.delete(userDeleteRequest);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id){
        UserDTO userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/{username}")
    public ResponseEntity<RestResponse<UserDTO>> findByUsername(@PathVariable String username){
        UserDTO userDTO = userControllerContract.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> update(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        UserDTO userDTO = userControllerContract.update(id, userUpdateRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

}
