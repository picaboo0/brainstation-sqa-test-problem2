package problem2;

import java.util.*;

/*
input-1
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

input-2
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samara 3.75
19 Samara 3.75
22 Fahim 3.76
*/
public class Main {

    public static void main(String[] args) {
    	List<Student> studentList = new ArrayList<Student>();
        
        Scanner scanner = new Scanner(System.in);
        int totalInput = scanner.nextInt();

        if(totalInput > 0) {
            for (int i=0; i<totalInput; i++) {
            	int id = scanner.nextInt();
            	String name = scanner.next();
            	double cgpa = scanner.nextDouble();
            	
                Student student = new Student(id, name, cgpa); // ID, First Name, CGPA
                studentList.add(student);
            }
        }
        
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.cgpa > student2.cgpa) return -1;
                if (student1.cgpa < student2.cgpa) return 1;
                
                if(student1.firstName.equals(student2.firstName)) {
                    if(student1.id > student2.id)
                        return 1;
                    return -1;
                }
                return student1.firstName.compareTo(student2.firstName);
            }
        });
        
        for(Student student: studentList) {
            System.out.println(student.firstName);
        }
    }
   
}

