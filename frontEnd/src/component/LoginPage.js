import React from "react";

import './LoginPage.css';
import StudentPortalService from "./StudentPortalService";

class LoginPage extends React.Component
{
    constructor(props) 
    {
        super(props);
        console.log("In login page constructor");
        this.state={
            login_id:"",
            username:"",
            password:"",
            role:"",
            selectedOption:null,
            data:"",
            responseMessage:""
        }

    }    
    handleOptionChange = (event) => {
        this.setState({
          selectedOption: event.target.value,
        });
      };
      //user validation
      validateUser=(event)=>
      {
        event.preventDefault();
        let loginDetail={username:this.state.username,password:this.state.password,role:this.state.selectedOption}
        if(this.state.username==='')
        {
            alert("Username should not be Blank !!!");
           
            return;
        }
        else if(this.state.password==='')
        {
            alert("Password should not be Blank !!!");
            return;
        }
        else if(this.state.selectedOption===null)
        {
            alert("Select Checkbox !!!");
            return;
        }
        //encoded username and password to prevent from displaying in querystring
        const encodedUsername = encodeURIComponent(this.state.username);
        const encodedPassword = encodeURIComponent(this.state.password);
        this.state.role=this.state.selectedOption;
        console.log("login detail info"+loginDetail)
        //called a service layer method for user validation
        StudentPortalService.validateStudent(this.state.username,this.state.password,this.state.role).then((result)=>
        {
            console.log("result data in login page");
            console.log(result.data);
            this.state.data=result.data;
            let studobj='';
            let user_role='';
            this.state.responseMessage=result.data.message;
            try
            {
                 studobj=result.data.login_id;
                 user_role=result.data.role;
            }
            catch(error)
            {
                //alert("Incorrect Username/Password");
            }
            this.state.login_id=studobj;
            this.state.role=user_role;
            console.log("in login page all data this.state.data");
            console.log(this.state.data);
            console.log(this.state.responseMessage);
            console.log(this.state);
            console.log(this.state.selectedOption);
            
            //checked for student
            if(this.state.responseMessage==="Successful"&&this.state.role==="Student"&&this.state.selectedOption==="Student")
            {
                console.log("result if msg"+(this.state.responseMessage));
               
                sessionStorage.setItem('username',this.state.username);
                sessionStorage.setItem('login_id',this.state.login_id);
                this.props.history.push("/home")
            }
            //checked for admin role
            else if(this.state.responseMessage==="Successful"&&this.state.role==="Support"&&this.state.selectedOption==="Support")
            {
                console.log("result if msg"+(this.state.responseMessage));
               
                sessionStorage.setItem('username',this.state.username);
                sessionStorage.setItem('login_id',this.state.login_id);
                this.props.history.push("/adminHomePage")
            }
            else if(this.state.responseMessage==="Successful"&&this.state.selectedOption==="Faculty"&&this.state.role==="Faculty")
            {
                console.log("result if msg"+(this.state.responseMessage));
               
                sessionStorage.setItem('username',this.state.username);
                sessionStorage.setItem('login_id',this.state.login_id);
                // localStorage.setItem('username',JSON.stringify(this.state.username));
                // localStorage.setItem('password',JSON.stringify(this.state.password));
                this.props.history.push("/facultyHomePage")
            }
            else if(this.state.responseMessage==="UnSuccessful")
            {
                console.log("result else msg "+this.state.responseMessage);
                window.alert('Invalid Username or Password');
                window.location.reload();
                
            }
                
        })
      }
    render() //display login form
    {
        return(
        <div>
            <div class="container">
	            <div class="d-flex justify-content-center h-100">
		            <div class="card">
			            <div class="card-header">
                            <h1>Student Management Portal</h1>
				             <h3>Login as </h3>
			            </div>
                        <div class="card-role">
                        <input type="radio" id="Student" name="role" value="Student"  checked={this.state.selectedOption === "Student"}
            onChange={this.handleOptionChange}></input>
                        <span>Student</span>
                        <input type="radio" id="Faculty" name="role" value="Faculty" checked={this.state.selectedOption === "Faculty"}
            onChange={this.handleOptionChange}></input>
                        <span>Faculty</span>
                        <input type="radio" id="Support" name="role" value="Support" checked={this.state.selectedOption ==="Support"}
            onChange={this.handleOptionChange}></input>
                        <span>Support</span>
                        {/* this is to check the value of radio box selected item */}
                        {/* <span>Selected option: {this.state.selectedOption}</span> */}
                        </div>
			        <div class="card-body">
				        <form>
					        <div class="input-group form-group">
						        <div class="input-group-prepend">
							    <span class="input-group-text"><i class="fas fa-user"></i></span>
						        </div>
						        <input type="email" class="form-control" placeholder="username" required  
                                value={this.state.username} onChange={(event)=>this.setState({username:event.target.value})} />
                                
					        </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                    <input type="password" class="form-control" placeholder="password" required 
                                    value={this.state.password} onChange={(event)=>this.setState({password:event.target.value})}/>
                                    
                            </div>
					        <div class="row align-items-center remember">
						        <input type="checkbox"/>Remember Me
					        </div>
                            <div class="form-group">
                                <input type="submit" value="Login" class="btn float-right login_btn"
                                onClick={this.validateUser}/>
                            </div>
				        </form>
			        </div>
                            <div class="card-footer">
                                <div class="d-flex justify-content-center links">
                                    Forgot your password?<a href="www.google.com">Click Here</a>
                                </div>
                            </div>
		            </div>
	            </div>
            </div>
        </div>)
    }
}
export default LoginPage;