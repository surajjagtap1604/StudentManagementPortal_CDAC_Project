package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.HomeDto;
import com.app.dto.LoginDto;
import com.app.entity.Faculty;
import com.app.entity.Login;
import com.app.entity.Student;
import com.app.entity.Support;
import com.app.repository.FacultyRepo;
import com.app.repository.LoginRepo;
import com.app.repository.StudentRepo;
import com.app.repository.SupportRepo;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private FacultyRepo facultyRepo;

	@Autowired
    private SupportRepo supportRepo;

	@Override
    public HomeDto validateLogin(LoginDto login) {
        
    	try {
    	
    	HomeDto homeDto = new HomeDto();    
        Login loggedInUser = loginRepo.findByEmail(login.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));
        homeDto.setLogin_id(loggedInUser.getId());
    
    	
      
        
        
        if (login.getPassword().equals(loggedInUser.getPassword()) && login.getRole() == loggedInUser.getRole()) {
            switch (login.getRole().toString()) {
                case "Student":
                    Student student = studentRepo.findById(loggedInUser.getId())
                            .orElseThrow(() -> new RuntimeException("Student does not exist"));
                    homeDto.setUsername(student.getName());
                    break;

                case "Faculty":
                    Faculty faculty = facultyRepo.findById(loggedInUser.getId())
                            .orElseThrow(() -> new RuntimeException("Faculty does not exist"));
                    homeDto.setUsername(faculty.getName());
                    break;

                case "Support":
                    Support support = supportRepo.findById(loggedInUser.getId())
                            .orElseThrow(() -> new RuntimeException("Support does not exist"));
                    homeDto.setUsername(support.getName());
                    break;
            }
            homeDto.setMessage("Successful");
            homeDto.setRole(login.getRole().toString());
            return homeDto;
        } else {
            return new HomeDto("UnSuccessful");
        }
    	}catch (RuntimeException e) {
    		
    		return new HomeDto("UnSuccessful");
			
		}
        
       
        
        }}
