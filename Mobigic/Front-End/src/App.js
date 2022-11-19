import logo from './logo.svg';
import './App.css';
import { render } from "@testing-library/react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import Register from "./Components/LogFiles/Register";
import Login from "./Components/LogFiles/Login";
import EmailVerify from "./Components/LogFiles/EmailVerify";
import OtpVerify from "./Components/LogFiles/OtpVerify";
import PasswordChange from "./Components/LogFiles/PasswordChange";
import AdminHome from "./Components/Admin/AdminHome";
import { UserDetails } from "./Components/Admin/UserDetails";

import UploadedFile from "./Components/FileUpload/UploadedFile";
import AddFile from './Components/FileUpload/AddFile';
import DoFileUpload from './Components/FileUpload/DoFileUpload';

export default function App() {
  return (
   <>
   <Routes>
   <Route path="/" element={<Register></Register>}></Route>
   <Route path="/adminhome" element={<AdminHome />} />
   <Route path="/login" element={<Login></Login>}></Route>
   <Route path="/emailVerify" element={<EmailVerify />}></Route>
   <Route path="/otpVerify" element={<OtpVerify />}></Route>
    <Route path="/passwordChange" element={<PasswordChange />}></Route>
    <Route path="/userdetails" element={<UserDetails />}></Route>

    <Route path="/Showfile" element={<UploadedFile />}></Route>
        <Route path="/addfile"element={<AddFile />}></Route>
        <Route path="/upload" element={<DoFileUpload />}></Route>

   </Routes>
   </>
  );
}


