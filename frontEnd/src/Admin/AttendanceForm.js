import React, { Component } from 'react';
import axios from 'axios';
import './AttendanceForm.css'; // Import your CSS file

class AttendanceForm extends Component {
  state = {
    selectedCourse: '',
    studentData: {},
    data:[]
  };

  handleCourseChange = async (e) => {
    const selectedCourse = e.target.value;
    this.setState({ selectedCourse });

    // Fetch student data for the selected course from the server
    try {
      const response = await axios.get(`http://localhost:8080/support/course/attendance/${selectedCourse}`);
      this.setState({ studentData: response.data });
      console.log("response student data in response.data")
      console.log(response.data.studentNameandId[1])
      this.state.data=response.data;
      console.log("response student data in this.data")
      console.log(this.state.data)
    } catch (error) {
      console.error('Error fetching student data:', error);
    }
  };

  handleCheckboxChange = (studentId, subject, value) => {
    debugger
    this.setState((prevState) => ({
      studentData: {
        ...prevState.studentData,
        [studentId]: {
          ...prevState.studentData[studentId],
          [subject]: value,
        },
      },
    }));
  };

  handleSubmit = (e) => {
    e.preventDefault();
    console.log('Final attendance:', JSON.stringify(this.state.studentData, null, 2));
  };

  render() {
    const { selectedCourse, studentData } = this.state;
    const courses = ['Java', 'Sql', 'Wpt', 'Sdm']; // Replace with actual course names

    return (
      <div className="course-selection-form">
        <h2>Course Selection Form</h2>
        <form onSubmit={this.handleSubmit}>
          <label htmlFor="course">Select Course:</label>
          <select id="course" value={selectedCourse} onChange={this.handleCourseChange}>
            <option value="">Select Course</option>
            <option value="Dac">DAC</option>
            <option value="Dbda">DBDA</option>
            <option value="Iot">IoT</option>
          </select>

          {selectedCourse && (
            <div className="student-attendance">
              <h3>Student Attendance for {selectedCourse}</h3>
              <table>
                <thead>
                  <tr>
                    <th>Student ID</th>
                    {courses.map((course) => (
                      <th key={course}>{course}</th>
                    ))}
                  </tr>
                </thead>
                <tbody>
                  {Object.keys(studentData).map((studentId) => (
                    <tr key={studentId}>
                      <td>{studentId}</td>
                      {courses.map((course) => (
                        <td key={course}>
                          <input
                            type="radio"
                            name={`attendance-${studentId}-${course}`}
                            value="P"
                            checked={studentData[studentId][course] === 'P'}
                            onChange={() => this.handleCheckboxChange(studentId, course, 'P')}
                          />{' '}
                          P
                          <input
                            type="radio"
                            name={`attendance-${studentId}-${course}`}
                            value="A"
                            checked={studentData[studentId][course] === 'A'}
                            onChange={() => this.handleCheckboxChange(studentId, course, 'A')}
                          />{' '}
                          A
                          <input
                            type="radio"
                            name={`attendance-${studentId}-${course}`}
                            value="NA"
                            checked={studentData[studentId][course] === 'NA'}
                            onChange={() => this.handleCheckboxChange(studentId, course, 'NA')}
                          />{' '}
                          NA
                        </td>
                      ))}
                    </tr>
                  ))}
                </tbody>
              </table>
              <button type="submit">Submit</button>
            </div>
          )}
        </form>
      </div>
    );
  }
}

export default AttendanceForm;
