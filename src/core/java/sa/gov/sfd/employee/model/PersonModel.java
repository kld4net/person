package sa.gov.sfd.employee.model;

import javax.validation.constraints.Email;

public class PersonModel {
	
	private Long id;


    private String personFirstName;
    private String personSecondName;
    private String personThirdName;
    private String personFamilyName;
    private int personSex;
    private int personStatus;
    private String personBirthdate;
    private int personIdType;
    private int personIdNo;
	// @Email
	private String personEmail;

	private String personMobile;
    private String personAddress;
	
	public PersonModel() {}

	public PersonModel(
		String personFirstName,
		 String personSecondName,
		 String personThirdName,
		 String personFamilyName,
		 int personSex,
		 int personStatus,
		 String personBirthdate,
		 int personIdType,
		 int personIdNo,
		 String personEmail,
		 String personMobile,
		 String personAddress
	)
	{
	this.personFirstName=personFirstName;
    this.personSecondName=personSecondName;
    this.personThirdName=personThirdName;
    this.personFamilyName=personFamilyName;
    this.personSex=personSex;
	this.personStatus=personStatus;
    this.personBirthdate=personBirthdate;
    this.personIdType=personIdType;
    this.personIdNo=personIdNo;
	this.personEmail=personEmail;
	this.personMobile=personMobile;
    this.personAddress=personAddress;
	}


	public String getPersonFirstName() {
		return this.personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonSecondName() {
		return this.personSecondName;
	}

	public void setPersonSecondName(String personSecondName) {
		this.personSecondName = personSecondName;
	}

	public String getPersonThirdName() {
		return this.personThirdName;
	}

	public void setPersonThirdName(String personThirdName) {
		this.personThirdName = personThirdName;
	}

	public String getPersonFamilyName() {
		return this.personFamilyName;
	}

	public void setPersonFamilyName(String personFamilyName) {
		this.personFamilyName = personFamilyName;
	}

	public int getPersonSex() {
		return this.personSex;
	}

	public void setPersonSex(int personSex) {
		this.personSex = personSex;
	}

	public int getPersonStatus() {
		return this.personStatus;
	}

	public void setPersonStatus(int personStatus) {
		this.personStatus = personStatus;
	}

	public String getPersonBirthdate() {
		return this.personBirthdate;
	}

	public void setPersonBirthdate(String personBirthdate) {
		this.personBirthdate = personBirthdate;
	}

	public int getPersonIdType() {
		return this.personIdType;
	}

	public void setPersonIdType(int personIdType) {
		this.personIdType = personIdType;
	}

	public int getPersonIdNo() {
		return this.personIdNo;
	}

	public void setPersonIdNo(int personIdNo) {
		this.personIdNo = personIdNo;
	}

	public String getPersonEmail() {
		return this.personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonAddress() {
		return this.personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    
}