
import { Route, Switch } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from './component/LoginPage';
import StudentHomePage from './component/StudentHomePage';
import SubjectInfo from './component/SubjectInfo';
import AdminHomePage from './Admin/AdminHomePage';
import AddStudentForm from './Admin/AddStudentForm';
import FacultyHomePage from './component/Faculty/FacultyHomePage'
function App() {
  return (
    <div className="App">
      <Switch>
        <Route path="/" exact component={LoginPage}></Route>
        <Route path="/login" exact component={LoginPage}></Route>
        <Route path="/home" exact render={() => <StudentHomePage/>}/>
         <Route path="/view/:subject_name" exact component={SubjectInfo}></Route>
         <Route path="/adminHomePage" exact component={AdminHomePage}></Route>
         <Route path="/addStudentForm" exact component={AddStudentForm}></Route>
         <Route path="/facultyHomePage" exact render={() => <FacultyHomePage />}/>
      </Switch>
    </div>
  );
}

export default App;
