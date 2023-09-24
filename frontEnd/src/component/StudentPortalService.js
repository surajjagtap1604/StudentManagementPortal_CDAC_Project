import axios from "axios";
const baseURL='http://localhost:8080/';
class StudentPortalService
{
    //for validating user
    validateStudent(username,password,role)
    {
        console.log("In studentportal service validatelogin");
        const querystring=`login/${username}/${password}/${role}`;
        console.log("querystring:"+querystring);
        
        // const postData = {
        //     username,password,role
        // };

        return axios.get(baseURL+""+querystring);
    }
    //get student profile
    getStudentData(loginId)
    {
        console.log('in student portal service');
        const querystring=`student/home/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getStudentMark(loginId)
    {
        console.log('in student portal service-getmark');
        const querystring=`student/subjectMarks/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getSubjectList(loginId)
    {
        console.log('in student portal service-getsubjectlist');
        const querystring=`student/subjects/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getSubjectInfo(subjectName)
    {
        console.log('in student portal service-getsubjectInfo');
        const subjectId=parseInt(sessionStorage.getItem('login_id'));
        console.log(subjectId)
        const querystring=`student/modules/${subjectName}/${subjectId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getTimetable(formattedDate)
    {
        console.log('in student portal service-getTimetable');
        const querystring=`home/getTimetable/${formattedDate}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring,{responseType: 'blob'});
    }
    getAttendance(loginId)
    {
        console.log('in student portal service-getAttendance');
        const querystring=`student/attendance/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getAdminData(loginId)
    {
        console.log('in student portal service-getAdminData');
        const querystring=`support/profile/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    submitAttendance(attendanceData)
    {
        console.log('in student portal service-submitAttendance');
        //const querystring=`adminHome/attendance/${selectedValues}`;
        console.log("querystring:");
        console.log(attendanceData);
        return axios.post(`http://localhost:3001/adminHome/attendance`,attendanceData);
    }
    //support sending coursname and getting student list and subject list
    submitCourseName(selectedCourse)
    {
        console.log('in student portal service-selectedCourse');
        const querystring=`support/course/attendance/${selectedCourse}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);   
    }
    getAllStudentData()
    {
        console.log('in student portal service-get allStudentData');
        // const querystring=`adminHome/allStudentData`;
        // console.log("querystring:"+querystring);
        return axios.get(`http://localhost:8080/adminHome/allStudentData`);
    }
    submitAdminDetail(email,password)
    {
        console.log("In studentportal service submitAdminDetail");
       
        const querystring=`support/addlogin/${email}/${password}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    submitFormData(formData)
    {
        console.log("In studentportal service submitFormData");
        const querystring=`support/addlogin/addStudent`;
        console.log("querystring:"+querystring);
        //return axios.post(baseURL+""+querystring);
        return axios.post(baseURL+""+querystring,formData,{headers:
             {'Content-Type':'application/json'}});
    }

    // addEmployee(emp)
    // {
    //     console.log(emp);
    //     return axios.post(baseURL+"employees",emp,{headers:
    //         {'Content-Type':'application/json'}});
    // }


    // static async submitFormData(formData) {
    //     try {
    //       const response = await axios.post(`${baseURL}/adminHome/submit-form`, formData, {
    //         headers: {
    //           'Content-Type': 'application/json',
    //         },
    //       });
    //       return response.data;
    //     } catch (error) {
    //       throw error;
    //     }
    //   }

      //faculty service method


       submitCourseForm(courseName, subjectName, modulesList) 
       {
        console.log('in student portal service-CourseForm');
        const querystring = `faculty/course/subject/modulecompleted`;

        // Create a data object with the values you want to send
        const postData = {
            courseName,
            subjectName,
            modulesList
        };
        console.log(postData)
        return axios.post(baseURL+""+querystring,postData,{headers:
            {'Content-Type':'application/json'}});
    }

    submitTimetable(selectedCourse) {
        console.log('in student portal service-submittimetable');
        const querystring = `faculty/timetable/${selectedCourse}`;
        console.log("querystring:" + querystring);
        return axios.get(baseURL + querystring);
    }
    getFacultyData(loginId)
    {
        console.log('in faculty portal service');
        const querystring=`faculty/profile/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }

    
   
    uploadImage(image, course, date) {
        const url = 'http://localhost:8080/support/uploadTimetable'; // Replace with your actual upload URL
    
        const formData = new FormData();
        formData.append('image', image);
        console.log("image ")
        console.log(image)
        formData.append('course', course);
        formData.append('date', date);
        console.log("in upload image")
        console.log(image);
        console.log(course)
        console.log(date)
        
        return axios.post(url,formData,{
                headers: { 'Content-Type': 'multipart/form-data' },
            }
        )

        // return axios.post(url, formData, {
        //     headers: {
        //       'Content-Type': 'multipart/form-data',
        //     },
        //   }
    
        
      }
}
export default new StudentPortalService();