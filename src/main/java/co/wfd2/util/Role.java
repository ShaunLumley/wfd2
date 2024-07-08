package co.wfd2.util;


public enum Role {

	ADMIN(1),
	USER(2),
	READ_ONLY(3);

	private Integer id;
	
	Role(Integer id) {
		this.id = id;
	}
	
	public Boolean isAdmin() {
		return this == ADMIN;
	}
	
	public Boolean isAtLeastUser() {
		return this == USER || this.isAdmin();
	}
	
	public Boolean isAtLeastReadOnly() {
		return this == READ_ONLY || this.isAtLeastUser();
	}
}

/*
 * 
 * 
INSERT INTO `wfd`.`tbl_role`
(`id`,
`role`)
VALUES
(1, "ADMIN"),
(2, "USER"),
(3, "READ_ONLY");
 */
