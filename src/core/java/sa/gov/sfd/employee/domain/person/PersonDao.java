package sa.gov.sfd.employee.domain.person;

import sa.gov.sfd.employee.model.PersonModel;

import java.util.List;

public interface PersonDao {
    boolean insert(PersonModel prApp);

    List<PersonModel> findAll();

    PersonModel update(int id, PersonModel prApp);

    void delete(int prApp);

    PersonModel findByUserNid(int userNID);
}
