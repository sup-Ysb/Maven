package maven.p01.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TaskFactory {

	public String get(int i) {
		// TODO Auto-generated method stub
		if(i>5)	return null;
			
		List<Task> tasks=new ArrayList<Task>();
		for (int j = 0; j < 5; j++) {
			Task task=new Task(j,"17205124-姚绍博");
			tasks.add(task);
		}
		
		return tasks.get(i).getDiscription();
	}
	
}
