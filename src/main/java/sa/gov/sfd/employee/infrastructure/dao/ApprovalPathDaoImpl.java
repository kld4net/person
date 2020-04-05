package sa.gov.sfd.employee.infrastructure.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sa.gov.sfd.employee.domain.path.ApprovalPathDao;
import sa.gov.sfd.employee.model.EmployeeApprovalPath;
import sa.gov.sfd.employee.model.Workflow;


import java.util.List;
import java.util.Optional;

@Repository
public class ApprovalPathDaoImpl implements ApprovalPathDao {

    private final JdbcTemplate template;


    public ApprovalPathDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<EmployeeApprovalPath> findByWorkflow(Workflow workflow) {
        return template.query("SELECT USER_NID, WORKFLOW FROM APPROVAL_PATH" +
                " WHERE WORKFLOW = ?", new Object[]{workflow}, new ApprovalPathMapper());
    }

    @Override
    public Optional<EmployeeApprovalPath> findById(Integer userNid) {
        return Optional.ofNullable(template.queryForObject("select USER_NID, WORKFLOW\n" +
                "from APPROVAL_PATH\n" +
                "where USER_NID = ?", new Object[]{userNid}, new ApprovalPathMapper()));
    }
}
