package mybatis.simple.model;

public class SysRolePrivilege {
	private Long role_id;
	private Long privilege;

	public SysRolePrivilege() {
		super();
	}

	public SysRolePrivilege(Long role_id, Long privilege) {
		super();
		this.role_id = role_id;
		this.privilege = privilege;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Long privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "SysRolePrivilege [role_id=" + role_id + ", privilege=" + privilege + "]";
	}

}
