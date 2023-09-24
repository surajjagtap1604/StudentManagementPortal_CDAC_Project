import React from 'react';
import StudentPortalService from './StudentPortalService';
import { Link } from "react-router-dom";

class SubjectInfo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      subject_name: this.props.match.params.subject_name,
      faculty_name: "",
      data: {
        moduleStatus: {},
        facultyName: ""
      },
      logoutstatus: ''
    };
  }

  componentDidMount() {
    console.log("In componentDidMount of SubjectInfo");
    this.state.logoutstatus = sessionStorage.getItem('logoutstatus');
    if (this.state.logoutstatus === 'true') {
      this.props.history.push("/login");
    }

    StudentPortalService.getSubjectInfo(this.state.subject_name).then((result) => {
      console.log("Inside getSubjectList");
      const newData = result.data;
      const newFacultyName = newData.facultyName;

      this.setState({
        data: newData,
        faculty_name: newFacultyName
      });
    });
  }

  render() {
    const { moduleStatus } = this.state.data;

    return (
      <div>
        <h5 style={{ color: '#FFBF00', position: 'absolute', top: '50px', left: '300px' }}>
          Faculty Name: {this.state.faculty_name}</h5>
        <Link to="/home" style={{ position: 'absolute', top: '50px', left: '900px' }}>
          <button type="button" name="btn" className="btn btn-success">
            Back
          </button>
        </Link>
        <table className="styled-table" style={{ marginLeft: '300px' }}>
          <thead>
            <tr>
              <th>Module Name</th>
              <th>Module Status</th>
            </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              {Object.entries(moduleStatus).map(([module]) => (
                <p key={module}>{module}</p>
              ))}
            </td>
            <td>
              {Object.entries(moduleStatus).map(([, status]) => (
                <p key={status}>
                  {status === 'NC' ? 'Not completed' : 'Completed'}
                </p>
              ))}
            </td>
          </tr>

          </tbody>
        </table>
      </div>
    );
  }
}

export default SubjectInfo;
