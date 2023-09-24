import React, { Component } from 'react';
import axios from 'axios';

class AddTimeTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      courseName: '',
      date: '',
      image: null,
    };
  }

  handleCourseChange = (e) => {
    this.setState({ courseName: e.target.value });
  };

  handleDateChange = (e) => {
    this.setState({ date: e.target.value });
  };

  handleImageChange = (e) => {
    this.setState({ image: e.target.files[0] });
  };

  handleSubmit = async (e) => {
    e.preventDefault();

    const { courseName, date, image } = this.state;

    // Create a FormData object to send the image
    const formData = new FormData();
    formData.append('course', courseName);
    formData.append('date', date);
    formData.append('image', image);

    try {
      const response = await axios.post('http://localhost:8080/support/uploadTimetable', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      console.log('Upload response:', response.data);
      // Handle response from server as needed
    } catch (error) {
      console.error('Error uploading image:', error);
    }
  };

  render() {
    return (
      <div className="course-form">
        <h2>Course Form</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Select Course:</label>
            <select value={this.state.courseName} onChange={this.handleCourseChange}>
              <option value="">Select Course</option>
              <option value="Dac">DAC</option>
              <option value="Dbda">DBDA</option>
              <option value="Iot">IoT</option>
            </select>
          </div>
          <div>
            <label>Date (yyyy-mm-dd):</label>
            <input type="text" value={this.state.date} onChange={this.handleDateChange} />
          </div>
          <div>
            <label>Image:</label>
            <input type="file" onChange={this.handleImageChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default AddTimeTable;;
