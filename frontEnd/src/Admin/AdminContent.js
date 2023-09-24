import React, { Component } from 'react';
import StudentPortalService from '../component/StudentPortalService';
import './AdminContent.css';
import './AddStudentLogin.css';
import AttendanceForm from './AttendanceForm';
//6import './UploadFile.css'
import AddTimeTable from './AddTimeTable';
import { Link } from 'react-router-dom';
class AdminContent extends Component 
{
    constructor(props)
    {
        super(props);
        this.state={
            login_id:"",
            faculty_name:"",
            studentPortalService:"",
            data:"",
            phoneNo:"",
            gender:"",
            email:"",
            password:"",
            buttonClicked: false,
            selectedCourse: '',
            studentAttendance: {},
            selectedFile: null,
            course:"",
            courseName: '',
            date: '',
            imageFile: null,
            uploadResponse: '',
            selectedDate: '',
            courseOptions: ['Dac', 'Dbda', 'Iot'],
        }
    }
    
    handleInputChange = (event) => {
      const { name, value } = event.target;
      this.setState({ [name]: value });
    };
    
    handleFileChange = (event) => {
      this.setState({ imageFile: event.target.files[0] });
    };
  
    handleDateChange = (event) => {
      this.setState({ selectedDate: event.target.value });
    };
  
    handleFileSubmit = async (event) => {
      event.preventDefault();
  
      const { courseName, selectedDate, imageFile } = this.state;
  
      if (!courseName || !selectedDate || !imageFile) {
        return;
      }
        //upload file
        StudentPortalService.uploadImage(imageFile,courseName,selectedDate).then(response=>
          {
            console.log("uploaded file");
            this.setState({ uploadResponse: response.data.message });
            alert('Image Uploaded Successfully!!!')
          }).catch (error=>{
        console.error('Error uploading image:', error);
        this.setState({ uploadResponse: 'Error uploading image' });
      });
    }

    handleCourseChange = (e) => {
      this.setState({
        selectedCourse: e.target.value,
        studentAttendance: {},
      });
    };
  
    handleCheckboxChange = (studentId, subject, value) => {
      this.setState((prevState) => ({
        studentAttendance: {
          ...prevState.studentAttendance,
          [studentId]: {
            ...prevState.studentAttendance[studentId],
            [subject]: value,
          },
        },
      }));
    };
  
    handleAttendanceSubmit = (e) => {
      e.preventDefault();
      const { selectedCourse, studentAttendance } = this.state;
      const attendanceData = {
        courseName: selectedCourse,
        studentAttendance: { ...studentAttendance },
      };
      console.log('Attendance data:', JSON.stringify(attendanceData, null, 2));
      StudentPortalService.submitAttendance(attendanceData).then(response=>
        {
            console.log("Attendance submitted",response.data)
        }).catch(error=>{
          console.error("error submitting attendance",error)
        });
      // Send this data to the server
    };


    // componentDidMount()
    // {   
    //     console.log("In component Did mount");
    //     //this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
    //         StudentPortalService.getAllStudentData().then((result)=>
    //         {
            
             
  
    //             console.log("In component did mount of admin section ")
    //              console.log(this.state);    
    //             this.state.students=result.data;
              
    //         }
    //         )

    // }
    
    
    handleSubmitAddForm = async (e) => {
    e.preventDefault();

    const { email, password } = this.state;

    try {
      //await StudentPortalService.sendLoginForm(email, password);
      StudentPortalService.submitAdminDetail(email,password).then((result)=>
      {
        console.log('handleSubmitAddForm');
        const validationMessage=result.data;
        if(validationMessage==='success')
        {
          this.state.buttonClicked=true;
          
          console.log("success msg inside addForm")
          this.state.message=validationMessage;
         //this.props.history.push("/addStudentForm")
         {this.renderContent() }
        }
        else
        {
          this.state.message="failed";
          alert("Enter Valid Credential")
        }
      }
      )
      
      // You can perform additional actions here on successful submission
    } catch (error) {
      console.error('Error sending form data', error);
      // Handle error cases here
    }
  };

  handleEmailChange = (e) => {
    this.setState({ email: e.target.value });
  };

  handlePasswordChange = (e) => {
    this.setState({ password: e.target.value });
  };


    
   
    componentDidUpdate(prevProps,prepend) 
    {
        
        // Call service methods here
        this.state.selectedLink=sessionStorage.getItem('selectedLink')
        if(this.state.selectedLink==='admin_profile')
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getAdminData(this.state.login_id).then((result)=>
            {
                //console.log(result.data[0].course_id);

                this.setState({
                    data: result.data,
                    login_id:result.data.supportId,
                    faculty_name: result.data.name,
                    phoneNo:result.data.phoneNo,
                    gender:result.data.gender,
                    
                  }, () => {
                    console.log("In marks component 'content  data=>");
                    console.log(this.state.data); // Display data in array
                  });
                console.log("In component 'content ")
                console.log(this.state);    
            }
            )
            
        }
        
      }
  renderContent(selectedLink) {

    sessionStorage.setItem('selectedLink',selectedLink);
    const { courseName, selectedDate, uploadResponse, courseOptions } = this.state;
    this.state.name=sessionStorage.getItem('username')
    const students = [
      { id: 1, name: 'Mahesh' },
      { id: 2, name: 'Laxman' },
      { id: 3, name: 'Ram' },
      
      // Add more students here
    ];

    const courseSubjects = {
      dac: ['OS', 'DBMS', 'JAVA','WPT','DS','ADV_JAVA','dotNET','SDM'],
      dbda: ['ADV_Database', 'JAVA', 'OS'],
      iot: ['Calculus', 'OS', 'PYTHON'],
      // Add more course subjects here
    };

    switch (selectedLink) {
      case 'admin_home':
        return <div className='studenthome'>
                <h2>Welcome,</h2>
                <h2>{this.state.name}</h2>
        </div>;
      case 'admin_profile':
        return <div class='profile-tag'>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th colSpan="2">Admin Information</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>{this.state.faculty_name}</td>
                </tr>
                <tr>
                    <td>Phone No</td>
                    <td>{this.state.phoneNo}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>{this.state.gender}</td>
                </tr>
      
            </tbody>
        </table>
        </div>;
      case 'add_attendance':
        return (
          <div className="web-form-container">
             {<AttendanceForm/>}
          </div>
        );
        case 'add_student':
          return (
            <div className="login-container">
              <h2>Confirm Detail</h2>
              <form className="login-form">
                <div>
                  <label htmlFor="email">Email:</label>
                  <input
                    type="email"
                    id="email"
                    value={this.state.email}
                    onChange={this.handleEmailChange}
                    required
                  />
                </div>
                <div>
                  <label htmlFor="password">Password:</label>
                  <input
                    type="password"
                    id="password"
                    value={this.state.password}
                    onChange={this.handlePasswordChange}
                    required
                  />
                </div>
              
                <button type="submit"  onClick={this.handleSubmitAddForm}>Submit</button>
              </form>
              {this.state.buttonClicked && (
          <div>
            <p>Login successful. Redirecting...</p>
            {/* Add a button inside the Link */}
            <Link to={'/addStudentForm'}  className="button-link">
            <button style={{ padding: '10px 20px', border: 'none', borderRadius: '5px' }}>Clicke here To add</button>
            </Link>
          </div>
        )}
        
            </div>
          );

          
          case 'add_timetable':
  return (
     <div className="ImageUploadForm">
        <h1>Upload Timetable</h1>
        <form onSubmit={this.handleFileSubmit}>
          <div>
            <label htmlFor="courseName">Course Name:</label>
            <select
              id="courseName"
              name="courseName"
              value={courseName}
              onChange={this.handleInputChange}
              required
            >
              <option value="">Select Course</option>
              {courseOptions.map((course) => (
                <option key={course} value={course}>
                  {course}
                </option>
              ))}
            </select>
          </div>
          <div>
            <label htmlFor="selectedDate">Date:</label>
            <input
              type="date"
              id="selectedDate"
              name="selectedDate"
              value={selectedDate}
              onChange={this.handleDateChange}
              required
            />
          </div>
          <div>
            <label htmlFor="imageFile">Image:</label>
            <input
              type="file"
              id="image"
              name="image"
              accept="image/*"
              onChange={this.handleFileChange}
              required
            />
          </div>
          <button type="submit">Upload</button>
        </form>
        {uploadResponse && <p>{uploadResponse}</p>} 
        {/* {<AddTimeTable/>} */}
      </div>
      );

          
      // Add more cases for other links
      default:
        return <div>Select a link to view content</div>;
    }
  }

  render() {
    
    const { selectedLink } = this.props;
    const content = this.renderContent(selectedLink);

    return <div className="content">{content}</div>;
  }
}

export default AdminContent;

