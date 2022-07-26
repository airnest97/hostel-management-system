package africa.semicolon.hostelManagementSystem.controllers;

import africa.semicolon.hostelManagementSystem.dto.requests.AddTenantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.LoginAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.ApiResponse;
import africa.semicolon.hostelManagementSystem.exceptions.AdminDoesNotExistException;
import africa.semicolon.hostelManagementSystem.exceptions.DuplicateEmailException;
import africa.semicolon.hostelManagementSystem.exceptions.InvalidDetailsException;
import africa.semicolon.hostelManagementSystem.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private AdminServices adminServices;

    public AdminController(@Autowired AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @PostMapping("/admin")
    public ResponseEntity<?> register(@RequestBody RegisterAdminRequest registerAdminRequest) {
        try {
            var serviceResponse = adminServices.registerAdmin(registerAdminRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (DuplicateEmailException e) {
            ApiResponse response = new ApiResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/admin/login")
    public ResponseEntity<?> login (@RequestBody LoginAdminRequest loginAdminRequest) {
        try {
            var serviceResponse = adminServices.loginAdmin(loginAdminRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (InvalidDetailsException ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/tenant")
    public ResponseEntity<?> addTenant(@RequestBody AddTenantRequest addTenantRequest) {
        try {
            var serviceResponse = adminServices.addTenant(addTenantRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (AdminDoesNotExistException ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
