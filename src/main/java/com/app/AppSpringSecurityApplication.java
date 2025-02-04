package com.app;

import com.app.persistence.entities.EnumRole;
import com.app.persistence.entities.PermissionEntity;
import com.app.persistence.entities.RoleEntity;
import com.app.persistence.entities.UserEntity;
import com.app.persistence.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringSecurityApplication.class, args);
	}

	CommandLineRunner init(IUserRepository iUserRepository){
		return args -> {
			//Leer permiso
			PermissionEntity readPermision = PermissionEntity.builder()
					.name("read")
					.build();

			//Crear permiso
			PermissionEntity createPermision = PermissionEntity.builder()
					.name("create")
					.build();

			//Actualizar permiso
			PermissionEntity updatePermision = PermissionEntity.builder()
					.name("update")
					.build();

			//Borrar permiso
			PermissionEntity deletePermision = PermissionEntity.builder()
					.name("delete")
					.build();

			//Crear rol
			RoleEntity admin = RoleEntity.builder()
					.enumRole(EnumRole.admin)
					.permissionList(Set.of(readPermision,createPermision,updatePermision,deletePermision))
					.build();

			RoleEntity standard = RoleEntity.builder()
					.enumRole(EnumRole.standard)
					.permissionList(Set.of(readPermision,createPermision))
					.build();

			//Crear usuario
			UserEntity userSantiago = UserEntity.builder()
					.username("Santiago")
					.password("123")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roleList(Set.of(admin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("Daniel")
					.password("123")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roleList(Set.of(standard))
					.build();

			//Guardar los usuarios
			iUserRepository.saveAll(List.of(userSantiago,userDaniel));
		};

	}

}
