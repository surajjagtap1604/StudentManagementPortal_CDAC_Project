import React, { Component } from 'react';
import FacultyPortalService from './FacultyPortalService';
import './FacultyContent.css';
import './faculty.jpg';
import FacultyCourse from './FacultyCourse';
import FacultyTimeTable from './FacultyTimeTable';
import StudentPortalService from '../StudentPortalService';
import CourseTimeTable from './CourseTimeTable';
class Content extends Component 
{
    constructor(props)
    {
        super(props);
        this.state={
            login_id:"",
            faculty_name:"",
            phone_no:"",
            gender:"",
            experience:"",
            course_id:"",
            facultyPortalService:"",
            data:[],
            name:"",
            subject_name:[],
            email:'',
            selectedCourse: '',
      redirectToTimeTable: false
        }
        

    }
    componentDidMount()
    {   
        console.log("In component Did mount");
        this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
        FacultyPortalService.getFacultyData(this.state.login_id).then((result)=>
            {
                
                this.state.data=result.data;
                
                this.state.faculty_name=result.data.name;
                this.state.phone_no=result.data.phoneNo;
                this.state.gender=result.data.gender;
                this.state.experience=result.data.facultyExperience;
                this.state.email=result.data.email;
                console.log("In component 'content ")
                console.log(this.state);    
            }
            )

    }
    componentDidUpdate(prevProps,prepend) 
    {
        
        // Call service methods here
        this.state.selectedLink=sessionStorage.getItem('selectedLink')
        if(this.state.selectedLink==='profile')
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getFacultyData(this.state.login_id).then((result)=>
            {
                
                this.state.data=result.data;
                
                this.state.faculty_name=result.data.name;
                this.state.phone_no=result.data.phoneNo;
                this.state.gender=result.data.gender;
                this.state.experience=result.data.facultyExperience;
                this.state.email=result.data.email;
                console.log("In component 'content ")
                console.log(this.state);    
            }
            )
            
        }
        
      }
  renderContent(selectedLink) {
    sessionStorage.setItem('selectedLink',selectedLink);
    this.state.name=sessionStorage.getItem('username')
    
    switch (selectedLink) {
      case 'facultyHomePage':
        return <div>
                 <h2>{this.state.name}</h2>
                 <img
                    src={require('./faculty.jpg')} // Adjust the image path
                    alt="Image"
                    style={{ width: '1000px', height: '450px',objectFit: 'cover', borderRadius: '15px', marginBottom: '1px' }}
                 />
               </div>;

      case 'home':
        return <div>
                 <h2>{this.state.name}</h2>

                 <img
                    src={require('./faculty.jpg')} // Adjust the image path
                    alt="Image"
                    style={{ width: '1000px', height: '450px',objectFit: 'cover', borderRadius: '15px', marginBottom: '1px' }}
                 />
               </div>;
      
      case 'profile':
        return <div class='profile-tag'>
            <h2>Faculty Profile</h2>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th colSpan="2">Faculty Information</th>
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
                    <td>{this.state.phone_no}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>{this.state.gender}</td>
                </tr>
                <tr class>
                    <td>Experience</td>
                    <td>{this.state.experience}</td>
                </tr>
                
                <tr>
                    <td> Email</td>
                    <td>{this.state.email}</td>
                </tr>

      
    </tbody>
</table>
    </div>;

     case 'courses':
        return (
          <div class='courses-tag'>
          
          {<FacultyCourse />}
          </div>
        );

        case 'timetable':
        return (
          <div class='courses-tag'>
          
          {<CourseTimeTable />}
          </div>
        );

//       case 'courses':
//         return <div>Courses Content</div>;
//       // Add more cases for other links
//       case 'marks':
//         return <div class='profile-tag'>Mark Memo
//         <body>
//     <table class="styled-table">
//         <caption>Table of Indian States and its Capitals</caption>
//         <thead>
//             <tr>
//                 <th>Subject Name</th>
//                 <th>Marks</th>
//             </tr>
//         </thead>
//         <tbody>
//             {this.state.data.map((item, index) => (
//               <tr key={index}>
//                 <td>{item.subject_name}</td>
//                 <td>{item.marks}</td>
//               </tr>
//             ))}
//         </tbody>
//     </table>
// </body>
// </div>;
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

export default Content;

