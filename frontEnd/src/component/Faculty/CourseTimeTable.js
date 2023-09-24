import React, { Component } from 'react';

class CourseTimeTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedCourse: "Dac",
      timetableImage: null,
      imageData: {
        date: "",
        image: ""
      }
    };
  }

  handleCourseChange = (event) => {
    this.setState({ selectedCourse: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const { selectedCourse } = this.state;
    const id = parseInt(sessionStorage.getItem('login_id'));
    console.log(selectedCourse)
    console.log(id)
    fetch(`http://localhost:8080/faculty/timeTable/${id}/${selectedCourse}`)
      .then(response => response.json())
      .then(data => {
        this.setState({
          imageData: {
            date: data.date,
            image: data.image
          }
        });
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  };

  render() {
    const { date, image } = this.state.imageData;
    return (
      <div>
        <div>
          <h1>Select a Course</h1>
          <form onSubmit={this.handleSubmit}>
            <label>
              Select Course:
              <select value={this.state.selectedCourse} onChange={this.handleCourseChange}>
                <option value="Dac">DAC</option>
                <option value="Dbda">DBDA</option>
                <option value="Iot">IoT</option>
              </select>
            </label>
            <button type="submit">Submit</button>
          </form>
        </div>
        <div>
          <h1 style={{ color: 'white' }}>Timetable</h1>
          <h2 style={{ color: 'white'}}>Date: {date}</h2>
          {image && <img src={`data:image/png;base64,${image}`} alt="Uploaded Timetable" />}
        </div>
      </div>
    );
  }
}

export default CourseTimeTable;
