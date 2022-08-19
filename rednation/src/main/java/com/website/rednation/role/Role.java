package com.website.rednation.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    private Integer id;

    @Column (name = "role_name")
    private String roleName;

    public Role(){

    }

    public Role (Integer id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getRoleId() { return this.id;}

    public void setRoleId(Integer Id) {this.id = Id;}

    public String getRoleName() {return this.roleName;}

    public void setRoleName(String roleName) {this.roleName = roleName;}



}
