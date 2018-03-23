package studentSide;
/*
 * class Major: a major has a name, code, and option
 *              i.e., Computer Science, CSIS, CS option
 */
public class Major {
	
	private String name;
	private String code;
	private String option;
	
	public Major (String name, String code, String option)
	{
		this.name = name;
		this.code = code;
		this.option = option;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
