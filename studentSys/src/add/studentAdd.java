package add;

import control.registration;
import model.student;

public class studentAdd extends registration implements add{
	public void adds() {
		System.out.print("등록할 학생의 이름:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx == -1) {
			student.add(new student(name));
		} else {
			System.out.println("이미 등록된 학생명입니다.");
		}
	}

}

//animal
//meat diet:Tiger ,lion,Crocodile
//Herbivore:Deer,Rabbit

//sports
//ball:Soccer, basketball, volleyball.
//bodyExercise:swimming,Wrestling