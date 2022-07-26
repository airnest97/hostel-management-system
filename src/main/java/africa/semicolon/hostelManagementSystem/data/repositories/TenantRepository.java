package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.models.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, String> {

}
