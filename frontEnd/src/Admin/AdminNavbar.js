import React from 'react';
import './AdminNavbar.css';
const AdminNavbar = ({ onLinkClick }) => {
  return (
    
    <div class="navbar">
    <li onClick={() => onLinkClick('admin_home')}>Home</li>
    <li onClick={() => onLinkClick('admin_profile')}>Profile </li> 
    <li onClick={() => onLinkClick('add_attendance')}>Add Attendance</li>
    <li onClick={() => onLinkClick('add_student')}>Add Student</li>
    <li onClick={() => onLinkClick('add_timetable')}>Add Timetable</li>
  </div>

  );
};

export default AdminNavbar;
