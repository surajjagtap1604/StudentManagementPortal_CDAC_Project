import React, { Component } from 'react';
import StudentPortalService from './StudentPortalService';
import { Link } from "react-router-dom";
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './Content.css';
import GetTimeTable from './GetTimeTable';
class Content extends Component 
{
    constructor(props)
    {
        super(props);
        this.state={
            username:sessionStorage.getItem('username'),
            login_id:"",
            name:"",
            email:"",
            phoneNo:"",
            gender:"",
            dob:"",
            admissionDate:"",
            courseName:"",
            studentPortalService:"",
            data:"",
           name:"",
            subjectName:[],
            marks:[],

            document_name:[],
            submission_status:[],
            
            subject_list:[],

            selectedDate: null,
            imageSrc:'',
            studentAttendance:0

            
        }
    }
    //this is for displaying date box
    handleDateChange = date => {
        this.setState({
          selectedDate: date,
        });
        this.handleDateSelectLogic(date);
      };
      handleDateSelectLogic = date => {
        // Your custom logic here when a date is selected
        const formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1)
            .toString()
            .padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')}`;
      
          console.log('Formatted Date:', formattedDate);
          //function to retrieve date from database
          StudentPortalService.getTimetable(formattedDate).then((response)=>
          {
            const imageUrl = URL.createObjectURL(response.data);
            this.setState({ imageSrc: imageUrl });  
          }
          ).catch(error => {
            console.error(error);
          });
        
      };

    formatDate = date => {
        return date.toLocaleDateString('en-CA'); // 'en-CA' for YYYY-MM-DD format
    };
    
    componentDidMount()
    {   
        console.log("In component Did mount");
        this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
        StudentPortalService.getStudentData(this.state.login_id).then((result)=>
            {
            
             
                console.log(result.data.courseName);
                this.state.data=result.data;
                //this.state.login_id=result.data.login_id;
                this.state.name=result.data.name;
                this.state.email=result.data.email;
                this.state.phoneNo=result.data.phoneNo;
                this.state.gender=result.data.gender;
                this.state.dob=result.data.dob;
                this.state.admissionDate=result.data.admissionDate;
                this.state.courseName=result.data.courseName;
              
                console.log("In component 'content ")
                console.log(this.state);    
              
            }
            )

    }
    componentDidUpdate(prevProps,prepend) 
    {
        // Call service methods here
        this.state.selectedLink=sessionStorage.getItem('selectedLink')
        //logic if user selected profile on navbar
        if(this.state.selectedLink==='profile')
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getStudentData(this.state.login_id).then((result)=>
            {
                console.log(result.data.courseName);
                this.state.data=result.data;
                this.state.login_id=result.data.login_id;
                this.state.name=result.data.name;
                this.state.email=result.data.email;
                this.state.phoneNo=result.data.phoneNo;
                this.state.gender=result.data.gender;
                this.state.dob=result.data.dob;
                this.state.admissionDate=result.data.admissionDate;
                this.state.courseName=result.data.courseName;
                console.log("In component 'content ")
                console.log(this.state);    
            }
            )
            
        }
        //logic if user selected mark on navbar
        else if(this.state.selectedLink==='marks')
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id=parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getStudentMark(this.state.login_id).then((result)=>
            {
                console.log("In marks data[0] subject name")
                console.log(result.data[0]);
                console.log("Result data");
                console.log(result.data);
                this.state.data=result.data;
                console.log("this.state.data")
                console.log(this.state.data)
                this.setState({
                    data: result.data,
                    subjectName: result.data.subjectName,
                    marks: result.data.marks
                  }, () => {
                    console.log("In marks component 'content  data=>");
                    console.log(this.state.data); // Display data in array
                  });
                  this.state.data="";
                  this.state.selectedLink="";
            }
            )
            
        }
        //logic if user selected subject on navabar
         else if(this.state.selectedLink==="subject")
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id = parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getSubjectList(this.state.login_id).then((result)=>
            {
                console.log("In subject data[0] subject list")
                console.log(result.data[0].subject_list);
                
                this.setState({
                    data: result.data
                  }, () => {
                    console.log("In subject component 'content  data=>");
                    console.log(this.state.data);
                    
                  });
            }
            )
            
        }
        //logic if user selected attendance on navabar
        else if(this.state.selectedLink==="attendance")
        {
            console.log("SelectedLink "+this.state.selectedLink);
            this.state.login_id = parseInt(sessionStorage.getItem('login_id'));
            StudentPortalService.getAttendance(this.state.login_id).then((result)=>
            {
                console.log("In content attendance")
                console.log(result);
                this.setState({
                  studentAttendance: result.data
                  }, () => {
                    console.log("In subject component 'content  data=>");
                    
                    this.state.studentAttendance=result.data;
                    console.log(this.state);
                  });
            }
            )
            
        }
        
      }
  renderContent(selectedLink) {
    sessionStorage.setItem('selectedLink',selectedLink);
    this.state.name=sessionStorage.getItem('username'); 
    const elements = [];
    for (let i = 0; i < this.state.data.length; i++) {
      const item = this.state.data[i];
      elements.push(
        <tr key={i}>
          <td>{item.subjectName}</td>
          <td>{item.marks}</td>
        </tr>
      );
    }
    const rows = [];
    for (let i = 0; i < this.state.data.length; i++) {
      const item = this.state.data;
      rows.push(
        <tr key={i}>
          <td>{item[i]}</td>
          <Link to={{pathname:`/view/${item[i]}`,state:{item:item}}}>
                <button type="button" className="btn btn-primary"  variant="outline-info">view</button>
          </Link>
        </tr>
      );
    }
    switch (selectedLink) {
      //displaying home page 
      case 'home':
        return <div className='studenthome'>
                <h2>Welcome To Home,</h2>
                <h4>{this.state.name}</h4>
        </div>;
        //displaying profile
      case 'profile':
        return <div class='profile-tag'>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th colSpan="2">General Information</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>{this.state.name}</td>
                </tr>
                <tr class="active-row">
                    <td>Email ID</td>
                    <td>{this.state.email}</td>
                </tr>
                <tr>
                    <td>Phone No</td>
                    <td>{this.state.phoneNo}</td>
                </tr>
                <tr class="active-row">
                    <td>Gender</td>
                    <td>{this.state.gender}</td>
                </tr>
                <tr class>
                    <td>Birth Date</td>
                    <td>{this.state.dob}</td>
                </tr>
                <tr class="active-row">
                    <td>Admission Date</td>
                    <td>{this.state.admissionDate}</td>
                </tr>
                <tr>
                    <td>Course ID</td>
                    <td>{this.state.courseName}</td>
                </tr>

      
                </tbody>
            </table>
          </div>;
      //displaying subject 
      case 'subject':
        return <div>Subject Content
           <table class="styled-table">
           <thead>
            <tr>
                <th>Subject List</th>
                <th>View Course Information</th>
            </tr>
            </thead>
            <tbody>
            {/* {this.state.data.map((item, index) => (
              <tr key={index}>
                <td>{item.subject_list}</td>
                <Link to={{pathname:`/view/${item.subject_list}`,state:{item:item}}}>
                <button type="button" className="btn btn-primary"  variant="outline-info">view</button>
                </Link>
              </tr>
            ))} */}
            {rows}
            </tbody>
            </table>
          </div>;

      // displaying mark content
    case 'marks':
        return <div class='profile-tag'>Mark Memo
   
        <table class="styled-table">
          <caption>Table of Indian States and its Capitals</caption>
          <thead>
            <tr>
               
                <th>Subject Name</th>
                <th>Marks</th>
            </tr>
          </thead>
          <tbody>
            {/* {this.state.data.map((item, index) => (
              <tr key={index}>
                <td>{item.marks}</td>
                <td>{item.subjectName}</td>
              </tr>
            ))} */}
            {elements}
          </tbody>
        </table>

        </div>
        //displaying timetable content
    case 'timetable':
      //     return <div class='timetable-tag'>Timetable
      //     <h2>Select a Date</h2>
      //     <DatePicker selected={this.state.selectedDate} onChange={this.handleDateChange} />
      //     {this.state.selectedDate && (
      //       <div>
      //         <p>Selected Date: {this.formatDate(this.state.selectedDate)}</p>
      //       </div>
      //     )}

      //     <h3>Image from Server</h3>
      //     {this.state.imageSrc && <img src={this.state.imageSrc} alt="Server Image" />}
      // </div>
        return <div>
          {<GetTimeTable/>}
        </div>
    //displaying attendence
    case 'attendance':
      return  <div className="value-circle">
             <span className="value">{this.state.studentAttendance}%</span>
             </div>
      
      default:
        return <div>Select a link to view content</div>;
    }
  }

  render() {
    const { selectedLink } = this.props;
    const { selectedDate } = this.state;
    const { imageSrc } = this.state;
    const content = this.renderContent(selectedLink);

    return <div className="content">{content}</div>;
  }
}

export default Content;

