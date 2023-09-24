import React from "react";
import './StudentHomePage.css';
import Header from "./Header";
import StudentProfile from "./StudentProfile";
import Navbar from "./Navbar.js";
import Content from "./Content";
import StudentLogout from "./StudentLogout";
class StudentHomePage extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            student_id:"",
            username:"",
            student_name:"",
            student_phone:"",
            student_gender:null,
            student_date_of_birth:"",
            student_admission_date:"",
            student_year_of_passing:"",
            student_course_id:"",
            login_id:"",
            selectedLink:"home",
            backgroundImage:this.props.backgroundImage,
        }
    }
    
    handleLinkClick = (link) => {
        this.setState({ selectedLink: link });
      };
    render()
    {
        //console.log(this.state);
        this.state.username=sessionStorage.getItem('username');
        this.state.login_id=sessionStorage.getItem("login_id");
        sessionStorage.setItem('logoutstatus','false')
        return(
           //defined Header ,Profile Icon ,Navbar and content
            <div className="app">
            <Header />  
            <div className="logout-button"><StudentLogout/></div>
            <div className="content-container">
              <div className="profile-column">
                <StudentProfile  />
                <Navbar onLinkClick={this.handleLinkClick} />
              </div>
              <div className="content-column">
                <Content selectedLink={this.state.selectedLink} />
              </div>
            </div>
          </div>
          
        );
        
    }
}
export default StudentHomePage;