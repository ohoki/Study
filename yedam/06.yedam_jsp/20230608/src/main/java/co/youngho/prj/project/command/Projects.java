package co.youngho.prj.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.youngho.prj.common.Command;

public class Projects implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "project/project";
	}

}
