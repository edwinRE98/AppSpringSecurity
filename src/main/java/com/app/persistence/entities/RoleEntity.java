package com.app.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private EnumRole enumRole;

    //Usamos CascadeType.ALL para que cuando se inserten los roles tambien se inserten los permisos
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "permissions_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();

    //Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }

    public Set<PermissionEntity> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<PermissionEntity> permissionList) {
        this.permissionList = permissionList;
    }
}
