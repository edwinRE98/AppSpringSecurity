package com.app;

import com.app.persistence.entities.EnumRole;
import com.app.persistence.entities.PermissionEntity;
import com.app.persistence.entities.RoleEntity;
import com.app.persistence.entities.UserEntity;
import com.app.persistence.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringSecurityApplication.class, args);
		//Usamos BCryptPasswordEncoder para encriptar una cadena.
		//System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

	//CommandLineRunner se usa para que todos los métodos que este dentro de este se ejecuten inmediatamente al arrancar el programa.
	@Bean
	CommandLineRunner init(IUserRepository iUserRepository){
		return args -> {
			//Permiso de leer
			PermissionEntity readPermision = PermissionEntity.builder()
					.name("read")
					.build();

			//Permiso de crear
			PermissionEntity createPermision = PermissionEntity.builder()
					.name("create")
					.build();

			//Permiso de actualizar
			PermissionEntity updatePermision = PermissionEntity.builder()
					.name("update")
					.build();

			//Permiso de borrar
			PermissionEntity deletePermision = PermissionEntity.builder()
					.name("delete")
					.build();

			//Roles
			RoleEntity admin = RoleEntity.builder()
					.enumRole(EnumRole.admin)
					.permissionList(Set.of(readPermision,createPermision,updatePermision,deletePermision))
					.build();

			RoleEntity standard = RoleEntity.builder()
					.enumRole(EnumRole.standard)
					.permissionList(Set.of(readPermision))
					.build();

			//Usuarios
			UserEntity userSantiago = UserEntity.builder()
					.username("Santiago")
					.password("$2a$10$eVoQP3ydyACxxd1PqOzfyetc83XMqYKZsuOUdQpMx1iUF84lJB9f6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roleList(Set.of(admin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("Daniel")
					.password("$2a$10$eVoQP3ydyACxxd1PqOzfyetc83XMqYKZsuOUdQpMx1iUF84lJB9f6")
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