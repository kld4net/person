package sa.gov.sfd.employee.infrastructure.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Repository;
import sa.gov.sfd.employee.domain.person.PersonDao;
import sa.gov.sfd.employee.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
  private final
  JdbcTemplate template;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public PersonDaoImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.template = template;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
}


  @Override
  public boolean insert(PersonModel prApp) {
    template.update("insert into PERSONS(personFirstName,personSecondName,personThirdName,personFamilyName ,personSex ,personStatus ,personBirthdate,personIdType ,personIdNo ,personEmail ,personMobile ,personAddress) values(?,?,?,? ,? ,? ,?,? ,? ,?,? ,?)",new Object[]{prApp.getPersonFirstName(),prApp.getPersonSecondName(),prApp.getPersonThirdName(),prApp.getPersonFamilyName(),prApp.getPersonSex(),prApp.getPersonStatus(),prApp.getPersonBirthdate(),prApp.getPersonIdType(),prApp.getPersonIdNo(),prApp.getPersonEmail(),prApp.getPersonMobile(),prApp.getPersonAddress()});

    return true;
  }

  @Override
  public List<PersonModel> findAll() {
     return template.query("select * from persons", new PersonMapper());
  }

  @Override
  public PersonModel update(int personID, PersonModel prApp) {
    template.update("update persons set personFirstName = ?,personSecondName = ?, personThirdName = ?, personFamilyName = ? ,personSex = ? ,personStatus = ? ,personBirthdate = ?,personIdType = ? ,personIdNo = ? ,personEmail = ? ,personMobile = ? ,personAddress = ? where id = ?",new Object[]{prApp.getPersonFirstName(),prApp.getPersonSecondName(),prApp.getPersonThirdName(),prApp.getPersonFamilyName(),prApp.getPersonSex(),prApp.getPersonStatus(),prApp.getPersonBirthdate(),prApp.getPersonIdType(),prApp.getPersonIdNo(),prApp.getPersonEmail(),prApp.getPersonMobile(),prApp.getPersonAddress(),personID});

    return null;
  }

  @Override
  public void delete(int personID) {
    template.update("delete from persons where id = ?",new Object[]{personID});
    


  }

  @Override
  public PersonModel findByUserNid(int personID) {
    return template.queryForObject("select * from persons where id = ?",new Object[]{personID}, new PersonMapper());

    
  }
}
