import React from "react";
import './AdminHomePage.css';
import Header from "./Header";
import AdminProfile from "./AdminProfile";
import AdminNavbar from "./AdminNavbar.js";
import AdminContent from "./AdminContent";
import FacultyLogout from "./FacultyLogout";
class AdminHomePage extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            username:"",
            login_id:"",
            selectedLink:"",
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
    
        return(
           
            <div className="app" >
            <Header />
            <div className="logout-button"><FacultyLogout/></div>
            <div className="content-container">
              <div className="profile-column">
                <AdminProfile  />
                <AdminNavbar onLinkClick={this.handleLinkClick} />
              </div>
              <div className="content-column">
                <AdminContent selectedLink={this.state.selectedLink} />
              </div>
            </div>
          </div>
          
        );
        
    }
}
export default AdminHomePage;