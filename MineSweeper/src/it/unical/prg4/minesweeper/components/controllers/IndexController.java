package it.unical.prg4.minesweeper.components.controllers;

import java.util.concurrent.ForkJoinPool;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import it.unical.prg4.minesweeper.components.services.LoginService;



@Controller
public class IndexController {

	

	@Autowired
	private LoginService loginService;


	@GetMapping("/")
	public String goToIndex(Model model, HttpSession session) {

		if (session.getAttribute("user") != null) {

			//model.addAttribute("posts", blogService.getAllPosts());
			return "index";
		}
		return "login";
	}

	@GetMapping("/login")
	public String loginAttempt(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {

		if (loginService.login(username, password)) {
			session.setAttribute("user", username);
			return "redirect:/";
		}
		model.addAttribute("error", "Wrong credentials!");
		return "login";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	/*

	@GetMapping("/getEvents")
	@ResponseBody
	public DeferredResult<String> getEvents(HttpSession session) {

		DeferredResult<String> output = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
			try {
				output.setResult(eventsService.nextEvent(session.getId()));
			} catch (InterruptedException e) {
				output.setResult("An error occurred during event retrieval");
			}
		});

		return output;
	}
	*/

}
