import React from 'react';

class StudentProfile extends React.Component
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

    <div className="student-profile">
      <img
        src={require('./profile_picture3.png')} // Adjust the image path
        alt="Student"
        className="student-image"
      />
      <h5>Login Id:{this.state.login_id}</h5>
    </div>
  );
   }
}

export default StudentProfile;
