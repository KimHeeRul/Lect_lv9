package add;

import control.registration;
import model.student;

public class studentAdd extends registration implements add{
	public void adds() {
		System.out.print("����� �л��� �̸�:");
		String name = scan.next();
		int idx = nameCheck(name);
		if (idx == -1) {
			student.add(new student(name));
		} else {
			System.out.println("�̹� ��ϵ� �л����Դϴ�.");
		}
	}

}

//animal
//meat diet:Tiger ,lion,Crocodile
//Herbivore:Deer,Rabbit

//sports
//ball:Soccer, basketball, volleyball.
//bodyExercise:swimming,Wrestling