package cn.junbing.struct;

public class User {	
	
	private String name;
	private String sex;
	private String school;
	private String birthday;
	private String region;
	private String about;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getRegion() {
		return region;
	}
	public String getAbout() {
		return about;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}


	
}
