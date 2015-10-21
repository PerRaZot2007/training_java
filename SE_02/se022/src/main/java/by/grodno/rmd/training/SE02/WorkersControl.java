package by.grodno.rmd.training.SE02;

import java.util.ArrayList;

public class WorkersControl {
	
	private ArrayList<Worker> workersList;
	
	public WorkersControl() {
		this.workersList = new ArrayList<Worker>();
	}
	
	public void addWorker(Worker newWorker){
		workersList.add(newWorker);
	}
	
	public Worker getWorker(int id) {
		try {
			return workersList.get(id);
		}
		catch(IndexOutOfBoundsException e){
			System.err.println("Wrong worker-ID");
		}
		return null;
	}
	
	public void removeWorker(int id){
		try{
			workersList.remove(id);
		}
		catch(IndexOutOfBoundsException e) {
			System.err.print("Wrong worker-ID");
		}
	}
	
	public void showAllWorkers() {
		if(!workersList.isEmpty()) {
			for(Worker w : workersList) {
				System.out.println(w.getFirstName() + " " + w.getSurName());
			}
		}
		else {
			System.err.println("You don't have any worker");
		}
	}
	
}
