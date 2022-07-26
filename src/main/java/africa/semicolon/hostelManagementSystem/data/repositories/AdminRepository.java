package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    boolean existsByEmail(String email);

    Admin findByEmail(String email);

    Optional<Admin> findAdminByEmail(String email);
}
