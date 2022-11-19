import React, { useEffect, useState } from "react";
import { Form, FormGroup, Input, Button, Container } from "reactstrap";
import { Link } from "react-router-dom";
import axios from "axios";
import "./login.css";
 
import swal from "sweetalert";
import Swal from "sweetalert2";
import { color } from "@mui/system";



const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");   

  const addData = async (add) => {
    add.preventDefault();
    let user = {
      email: email,
      password: password,
    };
   
    let result = await axios.post(`http://localhost:8080/user/UserLogin`, user);
   

    if (email.trim() === "" || password.trim() === "") {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "All fields Required !!! ",
      });

    } else if (result.data.data === null || result.data.data === "") {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Invalid User",
      });
  
    } else {
      sessionStorage.setItem("role", result.data.data.role);
      sessionStorage.setItem("email", result.data.data.email);
      sessionStorage.setItem("id", result.data.data.id);
      sessionStorage.setItem("firstName", result.data.data.firstName);
      sessionStorage.setItem("lastName", result.data.data.lastName);
   

      if (result.data.data.status === "Active") {
        if (result.data.data.role === "ADMIN") {
          swal("Login Successfully!", "success");
          window.location.href = "/userdetails";
         } 
        else if (result.data.data.role === "GUEST") {
          swal("Login Successfully!", "success");
          window.location.href = "/Showfile";
         } 
        
      } else {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "You are temporarily block! Please contact admin",
        });
      }
    }
  };

  return (
    <>
      
      <div class="login-img">
        <div className="vh-100 d-flex">
          <div className="container w-50 m-auto log">
            <div className="row">
              <div className="col-lg-5 p-0">
                 
              </div>
              <div className="col-lg-7">
                <div className="m-auto w-75 pt-3 pb-3 align-self-center ">
                  <h1
                    className="text-center fw-bold mb-3"
                    // style={{ color: "#ba8b00" }}
                  >
                    E-Mobigic
                  </h1>
                  <h1 className="text-center display-4" >  <b>Login</b></h1>

                  <form className="row g-3 mt-3">
                    <div className="col-md-12">
                      <label>Email</label>
                      <Input
                        type="email"
                        onChange={(e) => {
                          setEmail(e.target.value);
                        }}
                        placeholder="Enter your email"
                        autoFocus
                        name="email"
                        id="email"
                        required
                        title="example@email.com"
                      />
                    </div>
                    <div className="col-md-12 mt-4">
                      <label> Password</label>
                      <Input
                        type="password"
                        onChange={(e) => {
                          setPassword(e.target.value);
                        }}
                        placeholder="Enter your password"
                        name="Password"
                        id="Password"
                        required
                      />
                    </div>
                    <a href="emailVerify"  style={{ color :"red"}} > <b>Forget password</b> </a>
                    <div className="col-md-12 text-center">
                      <Container className="text-right my-0">
                        <table>
                          <tr>
                            <th>
                              <button
                                className="btn btn-danger"
                                onClick={addData}
                              >
                                Login
                              </button>
                            </th>
                            <th>
                              <Link to="/">
                                <button
                                  type="button"
                                  className="btn btn-primary"
                                >
                                  Register NewUser{" "}
                                </button>
                              </Link>
                            </th>
                          </tr>
                        </table>
                      </Container>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </>
  );
};
export default Login;
