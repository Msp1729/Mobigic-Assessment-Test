import { useState, useEffect } from "react";
import FileNavBar from "./FileNavBar";
import axios from "axios";
import { Navigate, useNavigate } from "react-router-dom";
import swal from "sweetalert";



export default function AddFile() {
  useEffect(() => {
    if (
      sessionStorage.getItem("role") === "null" ||
      sessionStorage.getItem("role") != "GUEST"
    ) {
      window.location.href = "/login";
    }
  }, []);

  const [fileName, setFileName] = useState("");
  const [nameOfFile, setNameOfFile] = useState("");
  const navigate = useNavigate();

  let role = sessionStorage.getItem("role");
  let email = sessionStorage.getItem("email");
  
  let saveFile = (data) => {
    
    axios.post(`http://localhost:8080/file/add-file/${email}`, data).then(
      (response) => {
        sessionStorage.setItem("fileId", response.data.f_Id);
       navigate("/upload");
      },
      (error) => {
        console.log(error);

        alert(" ERROR : Failed to Add");
      }
    );
  };

  let inputdata = {
    fileName: fileName,
    nameOfFile : nameOfFile,
  };

  let validate = (e) => {
    if (
      fileName.trim() === "" 
      
    ) {
      swal("Fill all field");
    } else {
      e.preventDefault();
      saveFile(inputdata);
    }
  };

  return (
    <>
      <FileNavBar />

      <div>
        <div className="container-fluid">
          <div
            className="row  "
            style={{
              backgroundSize: "cover",
              height: "100vh",
              opacity: 1,
            }}
          >
            <div className="col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center my-2 "><b>Add File Below 1 Mb</b></h3>
              <div className="card-body">
                <form className="registerForm">
                  <div className="form-group my-2">
                    <label className="my-1"><b> File Name</b> </label>
                    <input
                      placeholder="Enter File Name"
                      name="File_Name"
                      className="form-control"
                      onChange={(e) => {
                        setFileName(e.target.value);
                        setNameOfFile(Math.floor(100000 + Math.random() * 900000));
                      }}
                    />
                  </div>
                  <button
                    className="btn btn-success my-2"
                    style={{ marginTop: "10px" }}
                    onClick={validate}
                  >
                    Save File
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    
    </>
  );
}
