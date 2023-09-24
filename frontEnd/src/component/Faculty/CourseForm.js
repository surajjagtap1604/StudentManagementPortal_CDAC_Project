import React, { useState } from 'react';
import './CourseForm.css';
import StudentPortalService from '../StudentPortalService';

const CourseForm = () => {
  const courses = ['Dac', 'Dbda', 'Desd'];
  const subjects = {
    Dac: ['Web Development', 'Java', 'Database Management'],
    DBDA: ['Database Management', 'Machine Learning', 'Big Data'],
    DESD: ['Embedded Systems', 'IoT', 'RTOS'],
  };
  const modulesBySubject = {
    'Web Development': [' HTML', ' CSS', ' React'],
    'Java': ['Oops', 'Threading', 'Paging'],
    'Database Management': [' MySQL', ' Database Design', ' MongoDB'],
    'Machine Learning': [' Deep Learning', ' Artificial Neural Network', ' Vector'],
    'BigData': [' Blockchain ', ' Data Analytics', ' Cloud Computing'],
    'Embedded Systems': [' Control System', ' Microcontroller', ' Digital signal processing'],
    'IoT': [' Wireless sensor network', ' Computer network', ' Home automation'],
    'RTOS': [' OS', ' Scheduling', ' Asynchronous I/O'],
    
    
    // Add more modules for other subjects
  };

  const [selectedCourse, setSelectedCourse] = useState('');
  const [selectedSubject, setSelectedSubject] = useState('');
  const [moduleStatuses, setModuleStatuses] = useState([]);
  const [driveLink, setDriveLink] = useState('');

  const handleCourseChange = (course) => {
    setSelectedCourse(course);
    setSelectedSubject('');
    setModuleStatuses([]);
  };

  const handleSubjectChange = (subject) => {
    setSelectedSubject(subject);
    setModuleStatuses(modulesBySubject[subject].map(() =>false));
  };

  const handleModuleChange = (index) => {
    if (!moduleStatuses[index]) {
      const updatedStatuses = [...moduleStatuses];
      updatedStatuses[index] = modulesBySubject;
      setModuleStatuses(updatedStatuses);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Selected Course:', selectedCourse);
    console.log('Selected Subject:', selectedSubject);
    console.log('Selected Modules:', moduleStatuses.map((status, index) => status ? modulesBySubject[selectedSubject][index] : ''));
    console.log("module status",moduleStatuses)
    console.log('Drive Link:', driveLink);
    const moduleStatus=moduleStatuses.map((status, index) => status ? modulesBySubject[selectedSubject][index] : '');
    console.log('module status')
    console.log(moduleStatus)
            StudentPortalService.submitCourseForm(selectedCourse,selectedSubject,moduleStatus).then((result)=>
            {
                console.log("selected courses! ")
                  console.log(selectedCourse)
                  console.log("selected subject! ")
                  console.log(selectedSubject)
                  console.log("module statuses...")
                  console.log(moduleStatuses)
            }
            )
    
  };

  return (
    <form className="course-form" onSubmit={handleSubmit}>
      <h3>SELECT COURSE</h3>
      <div className="course-options">
        {courses.map((course, index) => (
          <label key={index}>
            <input
              type="radio"
              name="course"
              value={course}
              checked={selectedCourse === course}
              onChange={() => handleCourseChange(course)}
            />
            {course}
          </label>
        ))}
      </div>

      {selectedCourse && (
        <div className="subject-section">
          <h3>SELECT SUBJECT</h3>
          <select
            value={selectedSubject}
            onChange={(e) => handleSubjectChange(e.target.value)}
          >
            <option value="">Select Subject</option>
            {subjects[selectedCourse].map((subject, index) => (
              <option key={index} value={subject}>
                {subject}
              </option>
            ))}
          </select>
        </div>
      )}

      {selectedSubject && (
        <div className="modules-section">
          <h3>MODULES</h3>
          <ul className="module-list">
            {modulesBySubject[selectedSubject].map((module, index) => (
              <li key={index}>
                <label>
                  <input
                    type="checkbox"
                    disabled={moduleStatuses[index]}
                    checked={moduleStatuses[index]}
                    onChange={() => handleModuleChange(index)}
                  />
                  {module}
                </label>
              </li>
            ))}
          </ul>
          <input
            type="text"
            autoFocus
            placeholder="Enter Drive Link"
            value={driveLink}
            onChange={(e) => setDriveLink(e.target.value)}
          />
        </div>
      )}

      <button type="submit">Submit</button>
    </form>
  );
};

export default CourseForm;
