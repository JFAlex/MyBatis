package mybatis.simple.model;

public class SysUserRole {
	private Long user_id;
	private Long role_id;

	public SysUserRole() {
		super();
	}

	public SysUserRole(Long user_id, Long role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "SysUserRole [user_id=" + user_id + ", role_id=" + role_id + "]";
	}
}
