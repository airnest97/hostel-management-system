package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.dto.requests.AddTenantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.LoginAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.AddTenantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.LoginAdminResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAdminResponse;

public interface AdminServices {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest request);

    LoginAdminResponse loginAdmin(LoginAdminRequest request);

    AddTenantResponse addTenant(AddTenantRequest request);
}
