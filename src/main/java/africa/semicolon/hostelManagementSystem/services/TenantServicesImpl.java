package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.models.Tenant;
import africa.semicolon.hostelManagementSystem.data.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServicesImpl implements TenantServices{
    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public Tenant addTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
