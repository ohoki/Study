package co.youngho.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.youngho.prj.common.Command;

public class Contact implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "member/contact";
	}

}
