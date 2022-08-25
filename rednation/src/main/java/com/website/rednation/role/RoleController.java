package com.website.rednation.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles/all")
    public List <Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @PostMapping("/roles/add")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @GetMapping("/roles/get/{roleId}")
    public ResponseEntity <Role> getRoleById(@PathVariable Integer roleId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role does not exist with that id :" + roleId));
        return ResponseEntity.ok(role);
    }

    @PutMapping("/roles/update/{roleId}")
    public ResponseEntity < Role > updateRole(@PathVariable Integer roleId, @RequestBody Role roleDetails) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role does not exist with id :" + roleId));

        role.setRoleId(roleDetails.getRoleId());
        role.setRoleName(roleDetails.getRoleName());

        Role updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/roles/delete/{roleId}")
    public ResponseEntity <Map< String, Boolean >> deleteRole(@PathVariable Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role not exist with id :" + roleId));

        roleRepository.delete(role);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
