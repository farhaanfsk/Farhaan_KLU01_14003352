/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	int i,len=0;	
	LinkedList<Student> a=new LinkedList<Student>();
	public StudentGroup(int length) {
		this.students = new Student[length];
	len=length;
        }

	
	public Student[] getStudents() {
                
		return students;
	}


	public void setStudents(Student[] students) throws IllegalArgumentException {
	
        if(students!=null){
           for(i=0;i<a.size();i++)a.add(students[i]);
        }
        else{
            throw new IllegalArgumentException();
        }
	}


	public Student getStudent(int index)  throws IllegalArgumentException{
		if(index>=0&&index<a.size())
                    return a.get(index);
         else{
            throw new IllegalArgumentException();
        }
	}

	
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		if(index>=0&&index<a.size())a.set(index, student);
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void addFirst(Student student) throws IllegalArgumentException{
		a.set(0, student);
	
        }

	
	public void addLast(Student student) {
	a.set((a.size()-1), student);
	}


	public void add(Student student, int index)throws IllegalArgumentException {
		
                if(index>=0&&index<a.size())
                    a.set(index, student);
                  else{
            throw new IllegalArgumentException();
        }
                
               
	}

	
	public void remove(int index) throws IllegalArgumentException{
		if(index>=0&&index<a.size())
                    a.remove(index);
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void remove(Student student)throws IllegalArgumentException {
	int k=0;
            if(student!=null){
            for(i=0;i<a.size();i++)
            {
                if(a.get(i)==student)
                {
                    a.set(i,null);
               k=1;
                    break;
                }
            }
        }
        if(k==0)
            System.out.println("Student not exist");
        else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeFromIndex(int index) throws IllegalArgumentException{
		
            if(index>=0&&index<a.size()){
                  a.remove(index);
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeFromElement(Student student)  throws IllegalArgumentException{
	int f=0;
            if(student!=null){
           for(i=0;i<a.size();i++)if(a.get(i)==student)break;
           while(i<a.size()){
               if(a.get(i)==student)a.set(i,null);
               i++;
           }
	}
        else{
            throw new IllegalArgumentException();
        }
        }
	
	public void removeToIndex(int index) throws IllegalArgumentException{
		if(index>=0&&index<a.size()){
                    for(i=index+1;i<a.size();i++)a.set(i,null);
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeToElement(Student student) throws IllegalArgumentException{
		if(student!=null){
                    for(i=0;i<a.size();i++)if(a.get(i)==student)break;
                    while(i<a.size()){
                        if(a.get(i)==student)a.set(i, null);
                    }
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void bubbleSort() {
		int j;
                Student temp;
                for(i=0;i<a.size();i++){
                    for(j=i+1;j<a.size();j++){
                        if(a.get(i).getId()>a.get(j).getId()){
                            temp=a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp);
                        }
                    }
                }
	}

	
	public Student[] getByBirthDate(Date date)throws IllegalArgumentException {
		if(date!=null){
                    Student[] birth=new Student[a.size()];
                
                int j=0;
                for(i=0;i<a.size();i++){
                  if(date.compareTo(a.get(i).getBirthDate())<=0)birth[j++]=a.get(i);
                    
                }
		return birth;
        }
                
                else{
            throw new IllegalArgumentException();
        }
	}

	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		Student[] birth=new Student[a.size()];
                int j=0;
                if(firstDate!=null&&lastDate!=null){
                for(i=0;i<a.size();i++){
                    if(firstDate.compareTo(a.get(i).getBirthDate())>=0&&lastDate.compareTo(a.get(i).getBirthDate())<=0)birth[j++]=a.get(i);
                }
		return birth;
                }
        
                else{
            throw new IllegalArgumentException();
        }        
        }

	
	public Student[] getNearBirthDate(Date date, int days)throws IllegalArgumentException {
	if(date!=null){	
            Student[] birth=new Student[a.size()];
                int j=0;
                for(i=0;i<a.size();i++){
                    if(date.compareTo(a.get(i).getBirthDate())<=days)birth[j++]=a.get(i);
                }
		return birth;
        }
	
                else{
            throw new IllegalArgumentException();
        }        
        }

	
	public int getCurrentAgeByDate(int indexOfStudent) {
            Date age=null;
            if(indexOfStudent!=0){
                    Date date=a.get(indexOfStudent).getBirthDate();
                    long agein=new Date().getTime()-date.getTime();
                 age=new Date(agein);
                
                }
	return age.getYear();
        }

	
	public Student[] getStudentsByAge(int age) {
		
             
		return students;
	}

	
	public Student[] getStudentsWithMaxAvgMark() {
	double max=-1;
        int j=0;
        Student[] marks=new Student[a.size()];
              for(i=0;i<a.size();i++){
                  if(max<a.get(i).getAvgMark())
                      max=a.get(i).getAvgMark();
              }
              for(i=0;i<a.size();i++){
                  if(max==a.get(i).getAvgMark())
                      marks[j++]=a.get(i);
              }
               
              		return marks;
	}

	
	public Student getNextStudent(Student student)throws IllegalArgumentException {
		if(student!=null){
                    for(i=0;i<a.size();i++){
                        if(a.get(i)==student)
                            break;
                    }
        	return a.get(i+1);            
                }
	
	else{
            throw new IllegalArgumentException();
        }        
        }
}
