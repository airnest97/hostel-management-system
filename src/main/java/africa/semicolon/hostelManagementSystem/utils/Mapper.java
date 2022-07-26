package africa.semicolon.hostelManagementSystem.utils;

import africa.semicolon.hostelManagementSystem.data.models.Admin;
import africa.semicolon.hostelManagementSystem.data.models.Tenant;
import africa.semicolon.hostelManagementSystem.dto.requests.AddTenantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.AddTenantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAdminResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(RegisterAdminRequest request, Admin admin) {
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setEmail(request.getEmail());
        admin.setGender(request.getGender());
        admin.setPassword(request.getPassword());
    }

    public static void map(Admin savedAmin, RegisterAdminResponse response) {
        response.setEmail(savedAmin.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(savedAmin.getDateRegistered()));
    }

    public static void map(AddTenantRequest request, Tenant tenant) {
        tenant.setFirstName(request.getFirstName());
        tenant.setLastName(request.getLastName());
        tenant.setEmail(request.getEmail());
        tenant.setGender(request.getGender());
        tenant.setPhoneNumber(request.getPhoneNumber());
        tenant.setDateOfBirth(request.getDateOfBirth());
    }

    public static void map(Admin admin, Tenant savedTenant, AddTenantResponse response) {
        response.setTenantName(savedTenant.getFirstName());
        response.setDateRegistered(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(savedTenant.getDateRegistered()));
        response.setAddedBy(admin.getFirstName());
    }
}
