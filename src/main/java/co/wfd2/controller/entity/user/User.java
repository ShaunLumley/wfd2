package co.wfd2.controller.entity.user;

import java.util.List;

import co.wfd2.WfdMapper;
import co.wfd2.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

	private int id;
	private String userName;
	private String email;
	private String password;
	private String name;
	private String lastName;
	private Boolean active;
	private Role role;

	public static User map(co.wfd2.service.entity.user.User src) {
		return WfdMapper.getInstance()
				.map(src, User.class);
	}

	public static List<User> map(List<co.wfd2.service.entity.user.User> src) {
		return WfdMapper.getInstance()
				.mapAsList(src, User.class);
	}

	public co.wfd2.service.entity.user.User trace() {
		return WfdMapper.getInstance()
				.map(this, co.wfd2.service.entity.user.User.class);
	}

	public static List<co.wfd2.service.entity.user.User> trace(List<User> src) {
		return WfdMapper.getInstance()
				.mapAsList(src, co.wfd2.service.entity.user.User.class);
	}

}
