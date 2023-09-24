import React from 'react';
import './StudentNavbar.css';
const Navbar = ({ onLinkClick }) => {
  return (
    
    <div class="navbar">
    <li onClick={() => onLinkClick('home')}>Home</li>
    <li onClick={() => onLinkClick('profile')}>Profile </li> 
    <li onClick={() => onLinkClick('subject')}>Subject List</li>
    <li onClick={() => onLinkClick('marks')}>Mark</li>
    <li onClick={() => onLinkClick('timetable')}>Timetable</li>
    <li onClick={() => onLinkClick('attendance')}>Attendance</li>
  </div>

  );
};

export default Navbar;
