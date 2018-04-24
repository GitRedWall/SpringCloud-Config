package com.ilabservice.intelab.service;

import com.ilabservice.intelab.model.Role;
import com.ilabservice.intelab.model.User;
import com.ilabservice.intelab.repository.PermissionRepository;
import com.ilabservice.intelab.repository.ResourceRoleUserMapRepository;
import com.ilabservice.intelab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorityCheck {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    ResourceRoleUserMapRepository resourceRoleUserMapRepository;

    private static final String[] measureTypeCreatePermissionsValue = new String[]{"ADMINSTRATOR"};
    public static final Set<String> measureTypeCreatePermissions = new HashSet<>(Arrays.asList(measureTypeCreatePermissionsValue));

    private static final String[] monTargetReadPermissionsValue = new String[]{"USER_PLATFORM_MANAGER", "USER_DEVICE_OWNER"};
    public static final Set<String> monTargetReaPermissionValue = new HashSet<>(Arrays.asList(monTargetReadPermissionsValue));


    public boolean checkPermissionsWithUserId(Long userId, Set<String> permissions){
        User user = userRepository.findById(userId);
        if(user == null)
            return false;

        boolean has_permission = false;
        for(Role role : user.getRoles()){
            if(permissions.contains(role.getName())){
                has_permission = true;
                break;
            }
        }

        return has_permission;
    }

}
