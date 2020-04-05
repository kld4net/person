package sa.gov.sfd.employee.domain.permissions;


import sa.gov.sfd.employee.model.PermissionsGroup;

import java.util.List;

public class PermissionsGroupServiceImpl implements PermissionsGroupService {

    private final PermissionsGroupDao dao;

    public PermissionsGroupServiceImpl(PermissionsGroupDao dao) {
        this.dao = dao;
    }

    @Override
    public List<PermissionsGroup> findAllPermissions() {
        return dao.findAll();
    }

    @Override
    public String getAllEmployeesByPermission(Long permissionsGroup) {
        return dao.findById(permissionsGroup).orElseThrow(IllegalArgumentException::new).getEmployees();
    }

    @Override
    public PermissionsGroup findByPermissionId(Long id) {
        return dao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<PermissionsGroup> findByEmployeeId(Integer userNid) {
        return dao.findByUserNid(userNid);
    }
}
