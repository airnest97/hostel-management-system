package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.models.Admin;
import africa.semicolon.hostelManagementSystem.data.models.Tenant;
import africa.semicolon.hostelManagementSystem.data.repositories.AdminRepository;
import africa.semicolon.hostelManagementSystem.data.repositories.TenantRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.AddTenantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.LoginAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.AddTenantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.LoginAdminResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAdminResponse;
import africa.semicolon.hostelManagementSystem.exceptions.AdminDoesNotExistException;
import africa.semicolon.hostelManagementSystem.exceptions.DuplicateEmailException;
import africa.semicolon.hostelManagementSystem.exceptions.InvalidDetailsException;
import africa.semicolon.hostelManagementSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServices {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest request) {
        if (adminRepository.existsByEmail(request.getEmail())) throw new DuplicateEmailException(request.getEmail() + " already exists");

        Admin admin = new Admin();
        Mapper.map(request, admin);
        Admin savedAdmin = adminRepository.save(admin);
        RegisterAdminResponse response = new RegisterAdminResponse();
        Mapper.map(savedAdmin, response);
        return response;
    }

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest request) {
//        Admin foundAdmin = adminRepository.findByEmail(request.getEmail());
//        if (!adminRepository.existsByEmail(request.getEmail())) throw new InvalidDetailsException("Invalid login details");

        Optional<Admin> admin = adminRepository.findAdminByEmail(request.getEmail());
        if (admin.isEmpty()) throw new IllegalArgumentException();

        Admin foundAdmin = admin.get();

        LoginAdminResponse response = new LoginAdminResponse();
        if (foundAdmin.getPassword().equals(request.getPassword())){
            response.setMessage("Logged in successfully");
            return response;
        }
        throw new InvalidDetailsException("Invalid login details");
    }

    @Override
    public AddTenantResponse addTenant(AddTenantRequest request) {
        Admin admin = adminRepository.findByEmail(request.getEmail());
        if (!adminRepository.existsByEmail(request.getEmail())) throw new AdminDoesNotExistException(request.getEmail() + " does not exist");

        Tenant tenant = new Tenant();
        Mapper.map(request, tenant);
        Tenant savedTenant = tenantRepository.save(tenant);
        admin.getTenants().add(savedTenant);
        adminRepository.save(admin);

        AddTenantResponse response = new AddTenantResponse();
        Mapper.map(admin, savedTenant, response);

        return response;
    }
}
