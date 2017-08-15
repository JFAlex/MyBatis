package mybatis.simple.model;

public class SysPrivilege {

	private Long id;
	private String privilege_name;
	private String privilege_uri;

	public SysPrivilege() {
		super();
	}

	public SysPrivilege(Long id, String privilege_name, String privilege_uri) {
		super();
		this.id = id;
		this.privilege_name = privilege_name;
		this.privilege_uri = privilege_uri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivilege_name() {
		return privilege_name;
	}

	public void setPrivilege_name(String privilege_name) {
		this.privilege_name = privilege_name;
	}

	public String getPrivilege_uri() {
		return privilege_uri;
	}

	public void setPrivilege_uri(String privilege_uri) {
		this.privilege_uri = privilege_uri;
	}

	@Override
	public String toString() {
		return "SysPrivilege [id=" + id + ", privilege_name=" + privilege_name + ", privilege_uri=" + privilege_uri
				+ "]";
	}

}
