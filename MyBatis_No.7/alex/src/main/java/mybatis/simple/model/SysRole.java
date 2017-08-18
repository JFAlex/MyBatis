package mybatis.simple.model;

import java.sql.Date;

public class SysRole {
	private Long id;
	private String role_name;
	private Integer enabled;
	private Long create_by;
	private Date create_time;
	
	private SysUser user;

	public SysRole() {
		super();
	}

	public SysRole(Long id, String role_name, Integer enabled, Long create_by, Date create_time) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.enabled = enabled;
		this.create_by = create_by;
		this.create_time = create_time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Long getCreate_by() {
		return create_by;
	}

	public void setCreate_by(Long create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", role_name=" + role_name + ", enabled=" + enabled + ", create_by=" + create_by
				+ ", create_time=" + create_time + "]";
	}

}
