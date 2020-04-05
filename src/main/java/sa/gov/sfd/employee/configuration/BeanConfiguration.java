package sa.gov.sfd.employee.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sa.gov.sfd.employee.domain.path.ApprovalPathDao;
import sa.gov.sfd.employee.domain.path.ApprovalPathService;
import sa.gov.sfd.employee.domain.path.ApprovalPathServiceImpl;
import sa.gov.sfd.employee.domain.permissions.PermissionsGroupDao;
import sa.gov.sfd.employee.domain.permissions.PermissionsGroupService;
import sa.gov.sfd.employee.domain.permissions.PermissionsGroupServiceImpl;
import sa.gov.sfd.employee.domain.person.PersonDao;
import sa.gov.sfd.employee.domain.person.PersonService;
import sa.gov.sfd.employee.domain.person.PersonServiceImpl;
import sa.gov.sfd.employee.domain.workflow.WorkflowDao;
import sa.gov.sfd.employee.domain.workflow.WorkflowService;
import sa.gov.sfd.employee.domain.workflow.WorkflowServiceImpl;

@Configuration
public class BeanConfiguration {


  @Bean
  public ApprovalPathService approvalPathService(ApprovalPathDao dao) {
    return new ApprovalPathServiceImpl(dao);
  }

  @Bean
  public PermissionsGroupService permissionsGroupService(PermissionsGroupDao dao) {
    return new PermissionsGroupServiceImpl(dao);
  }

  @Bean
  public WorkflowService workflowService(WorkflowDao dao) {
    return new WorkflowServiceImpl(dao);
  }

  @Bean
  public PersonService personService(PersonDao dao){
    return new PersonServiceImpl(dao);
  }

}
