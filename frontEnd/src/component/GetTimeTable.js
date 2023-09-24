import React, { Component } from "react";
//import './CourseTimeTable.css'; // Make sure to create this CSS file
//import StudentPortalService from "../StudentPortalService";
class GetTimeTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedCourse: "",
            timetableImage: null,
            imageData: {
                date: "",
                image: ""
              }
        };
      
    }
    componentDidMount() {
        // Simulating fetching data from the backend
        const id = parseInt(sessionStorage.getItem('login_id'));
        fetch(`http://localhost:8080/student/timeTable/${id}`)
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
      }


    render() {
        const { date, image } = this.state.imageData;

        return (
          <div>
            <h1 style={{ color: 'white'}}>Timetable</h1>
            <h2 style={{ color: 'white'}}>Date: {date}</h2>
            {image && <img src={`data:image/png;base64,${image}`} alt="Uploaded Timetable" />}
          </div>
        );
      }
}

export default GetTimeTable;
