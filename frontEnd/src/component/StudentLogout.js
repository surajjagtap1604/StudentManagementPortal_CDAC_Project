// import React, { Component } from 'react';
// import { withRouter } from 'react-router-dom'; // Assuming you're using React Router

import React from 'react';
import { useHistory } from 'react-router-dom';

// // This is a fictional authentication service
const AuthService = {
  logout: () => {
    // Your logout logic here
    // For example, clearing tokens, cookies, or whatever your authentication mechanism requires
    // sessionStorage.removeItem('username');
    // sessionStorage.removeItem('login_id');
        sessionStorage.clear();
        sessionStorage.setItem('logoutstatus','true');
    // console.log('User logged out');
    
  },
};

// export default withRouter(StudentLogout);

const StudentLogout = () => {
  const history = useHistory();

  const handleLogout = () => {
    AuthService.logout();
    history.replace('/login');
  };

  return <button class='btn float-right login_btn' style={{marginRight:'-1200px'}} onClick={handleLogout}>Logout</button>;
};

export default StudentLogout;
