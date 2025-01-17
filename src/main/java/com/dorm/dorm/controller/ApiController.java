package com.dorm.dorm.controller;

import com.dorm.dorm.entity.Student;
import com.dorm.dorm.mapper.RsMapper;
import com.dorm.dorm.request.LoginRequest;
import com.dorm.dorm.request.PasswordChangeRequest;
import com.dorm.dorm.request.RegisterRequest;
import com.dorm.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private RsMapper rsMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Student student = userService.getStudentByCredentials(username, password);
        Map<String, Object> response = new HashMap<>();
        String rNo = rsMapper.getRoomNoBySNo(loginRequest.getUsername());
        if (student != null) {
            response.put("success", true);
            response.put("student", student);
            response.put("rNo", rNo);
        } else {
            response.put("success", false);
            response.put("error", "账号或密码错误");

        }
        return response;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        Map<String, Object> response = new HashMap<>();

        // 验证用户输入
        if (request.getUsername() == null || request.getPassword() == null || request.getName() == null) {
            response.put("success", false);
            response.put("message", "所有字段都必须填写");
            return ResponseEntity.badRequest().body(response);
        }

        // 调用服务层进行注册
        boolean isRegistered = userService.registerUser(request);
        if (isRegistered) {
            response.put("success", true);
            response.put("message", "注册成功");
        } else {
            response.put("success", false);
            response.put("message", "注册失败，学号已存在");
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping("/change-password")
    public ResponseEntity<Map<String, Object>> changePassword(@RequestBody PasswordChangeRequest request) {
        Map<String, Object> response = new HashMap<>();

        // 校验请求中的新密码与确认密码是否一致
        if (!request.getNew_password().equals(request.getAgain_password())) {
            response.put("success", false);
            response.put("message", "新密码与确认密码不一致");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // 校验旧密码是否正确
        boolean isOldPasswordCorrect = checkOldPassword(request.getOld_password(), request.getS_no()); // 假设你有一个方法来验证旧密码
        if (!isOldPasswordCorrect) {
            response.put("success", false);
            response.put("message", "旧密码错误");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // 执行更新密码的操作
        boolean isPasswordUpdated = updatePassword(request.getNew_password(), request.getS_no()); // 假设你有一个方法来更新密码
        if (isPasswordUpdated) {
            response.put("success", true);
            response.put("message", "密码修改成功");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("message", "密码修改失败");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 假设的验证旧密码的方法
    private boolean checkOldPassword(String oldPassword, String s_no) {
        return userService.getStudentByCredentials(s_no, oldPassword) != null;
    }

    // 假设的更新密码的方法
    private boolean updatePassword(String newPassword, String s_no) {
        try {
            userService.updatePassword(newPassword, s_no);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
