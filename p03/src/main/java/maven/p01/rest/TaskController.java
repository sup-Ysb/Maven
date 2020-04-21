package maven.p01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import maven.p01.entity.Task;
import maven.p01.factory.TaskFactory;

@CrossOrigin
@RestController
public class TaskController {
	@Autowired
	private TaskFactory tasks;
	
	@GetMapping("/msg")
	public String msg() {
		return "1";
	}
	
	@GetMapping("/task/{id}")
    public Task task(@PathVariable (value="id") int id) {
		System.out.println("ttttttttt");
		return new Task(id,tasks.get(id-1));
    }
}