import axios from "axios";
const baseURL='http://localhost:8080/';
class FacultyPortalService
{
    validateFaculty(username,password)
    {
        console.log("In faculty portal service validatelogin");
        const querystring=`login/${username}/${password}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    getFacultyData(loginId)
    {
        console.log('in faculty portal service');
        const querystring=`faculty/profile/${loginId}`;
        console.log("querystring:"+querystring);
        return axios.get(baseURL+""+querystring);
    }
    
    // getStudentDocument(login_id)
    // {
    //     console.log('in student portal service-getdocumnt');
    //     const querystring=`home/document/${login_id}`;
    //     console.log("querystring:"+querystring);
    //     return axios.get(baseURL+""+querystring);
    // }
}
export default new FacultyPortalService();