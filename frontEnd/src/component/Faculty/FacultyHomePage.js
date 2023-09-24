import React from "react";
import './FacultyHomePage.css'
import Header from "./Header";
import FacultyProfile from "./FacultyProfile";
import Navbar from "./Navbar.js";
import Content from "./Content";
import FacultyLogout from "./FacultyLogout";

class FacultyHomePage extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            faculty_id:"",
            username:"",
            faculty_name:"",
            faculty_phone:"",
            faculty_gender:null,
            faculty_experience:"",
            faculty_course_id:"",
            login_id:"",
            selectedLink:"facultyHomePage",
            backgroundImage:this.props.backgroundImage,
        }
    }
    
    handleLinkClick = (link) => {
        this.setState({ selectedLink: link });
      };
     
    render()
    {
        console.log(this.state);
        this.state.username=sessionStorage.getItem('username');
        this.state.login_id=sessionStorage.getItem("login_id");
        const { backgroundImage } = this.state;

    const profileStyle = {
      backgroundImage: `url(${backgroundImage})`,
      backgroundSize: 'cover',
      backgroundRepeat: 'no-repeat',
      backgroundAttachment: 'fixed',
      /* Add other styling as needed */
    };
    
        return(
           
            <div className="app"  style={profileStyle}>
            <Header />
            <div className="logout-button"><FacultyLogout/></div>
            <div className="content-container">
              <div className="profile-column">
                <FacultyProfile />
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
export default FacultyHomePage;