import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './AddStudentForm.css';
import StudentPortalService from '../component/StudentPortalService';
class AddStudentForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: '',
      dob: '',
      admissionDate: '',
      gender: '',
      phoneNo: '',
      yearOfPassing: '',
      courseName: '',
      email:""
    };
  }
  handleChange = (e) => {
    const { name, value } = e.target;

    // Check if the field is a date field
    if (name === 'dob' || name === 'admissionDate') {
      // Format the date to yyyy-mm-dd
      const formattedDate = new Date(value).toISOString().split('T')[0];
      this.setState({ [name]: formattedDate });
    } 
    else {
       this.setState({[name]:value});
     }
  };

  handleSubmit = async (e) => {
    e.preventDefault();

    const { name,email, dob, admissionDate, gender, phoneNo, yearOfPassing, courseName } = this.state;

    const formData = {
      name,
      email,
      dob,
      admissionDate,
      gender,
      phoneNo,
      yearOfPassing,
      courseName,
    };

    try {
      await StudentPortalService.submitFormData(formData);
      console.log('Form data sent successfully');
      // You can perform additional actions here on successful submission
    } catch (error) {
      console.error('Error sending form data', error);
      // Handle error cases here
    }
    alert("Data Submitted Successfully!!!")
    this.props.history.push('/adminHomePage')
  };

  render() {
    return (
      <div className="web-form-container">
        <div className="web-form">
          <h2>Add Student Detail</h2>
          <form onSubmit={this.handleSubmit}>
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
              required
            />
          <label htmlFor="name">Email:</label>
          <input
              type="email"
              id="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />

            <label htmlFor="dob">Date of Birth:</label>
            <input
              type="date"
              id="dob"
              name="dob"
              value={this.state.dob}
              onChange={this.handleChange}
              required
            />

            <label htmlFor="admissionDate">Admission Date:</label>
            <input
              type="date"
              id="admissionDate"
              name="admissionDate"
              value={this.state.admissionDate}
              onChange={this.handleChange}
              required
            />

            <label htmlFor="gender">Gender:</label>
            <select
              id="gender"
              name="gender"
              value={this.state.gender}
              onChange={this.handleChange}
              required
            >
              <option value="">Select Gender</option>
              <option value="M">Male</option>
              <option value="F">Female</option>
            </select>

            <label htmlFor="phoneNo">Phone Number:</label>
            <input
              type="tel"
              id="phoneNo"
              name="phoneNo"
              value={this.state.phoneNo}
              onChange={this.handleChange}
              required
            />

            <label htmlFor="yearOfPassing">Year of Passing:</label>
            <input
              type="text"
              id="yearOfPassing"
              name="yearOfPassing"
              value={this.state.yearOfPassing}
              onChange={this.handleChange}
              required
            />

            <label htmlFor="courseName">Course Name:</label>
            <input
              type="text"
              id="courseName"
              name="courseName"
              value={this.state.courseName}
              onChange={this.handleChange}
              required
            />
            <div className="button-container">
          <button type="submit" >Submit</button>
          <Link to={'/adminHomePage'} >
          <button type="button">Back</button>
          </Link>
          
        </div>
          </form>
        </div>
      </div>
    );
  }
}

export default AddStudentForm;
