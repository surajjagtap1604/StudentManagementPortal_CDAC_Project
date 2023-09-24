import React from 'react';
import { Border } from 'react-bootstrap-icons';

class FacultyProfile extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state=
        {
            login_id:"",
            name:"" ,
        }
    }
   render()
   {
    this.state.login_id=sessionStorage.getItem('login_id');
    
  return (

    <div className="faculty-profile">
      <img
        src={require('./faculty_profile.png')} 
        alt="Faculty"
        style={{ width: '150px', height: '150px', borderRadius:'100%' }}
        className="faculty-image"
      />
      
      
      <h5>Login Id:{this.state.login_id}</h5>
    </div>
  );
   }
}

export default FacultyProfile;
