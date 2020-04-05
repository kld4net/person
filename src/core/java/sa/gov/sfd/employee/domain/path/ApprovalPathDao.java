package sa.gov.sfd.employee.domain.path;



import sa.gov.sfd.employee.model.EmployeeApprovalPath;
import sa.gov.sfd.employee.model.Workflow;

import java.util.List;
import java.util.Optional;

public interface ApprovalPathDao {

    List<EmployeeApprovalPath> findByWorkflow(Workflow workflow);

    Optional<EmployeeApprovalPath> findById(Integer userNid);
}
