package by.grodno.training.se031;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLoggerRMD {
	
	private StringBuilder journal;
	private SimpleDateFormat sdf;
	
	public CrazyLoggerRMD(StringBuilder log) {
		journal = log;
		sdf =  new SimpleDateFormat("dd-MM-YYYY : hh-mm - ");
	}
	public void addInformation(String message){
		journal.append(sdf.format(new Date()) + message + " \n");
	}
	
	
	public void findInfoByMessage(String info) {
		if(journal.indexOf(info)>=0) {
			System.out.println(journal.substring(journal.indexOf(info)-sdf.toPattern().length(), journal.indexOf(info)+info.length()));
		} 
	}
	
	public void showAllInfo(){
		System.out.println(journal);
	}
}
