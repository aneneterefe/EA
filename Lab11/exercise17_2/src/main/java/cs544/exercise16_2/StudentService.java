package cs544.exercise16_2;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {

	private StudentDAO studentDAO;
	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("==============================================IN DAO==================");
		this.studentDAO=studentDAO;
	}
	public StudentService() {
		// TODO Auto-generated constructor stub
		//studentDAO=new StudentDAO();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
	public Student getStudent(long studentid) {
		return studentDAO.load(studentid);
	}
}
