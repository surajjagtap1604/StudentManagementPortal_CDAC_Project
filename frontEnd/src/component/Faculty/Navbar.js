import React from 'react';
import './FacultyNavbar.css';
const Navbar = ({ onLinkClick }) => {
  return (
    
    <div class="navbar">
    <li onClick={() => onLinkClick('home')}>Home</li>
    <li onClick={() => onLinkClick('profile')}>Profile</li>
    <li onClick={() => onLinkClick('timetable')}>Time Table</li>
    <li onClick={() => onLinkClick('courses')}>Courses</li>

  
  </div>

  );
};

export default Navbar;
