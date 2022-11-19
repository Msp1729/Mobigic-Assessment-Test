import { Link } from "react-router-dom";

export default function FileNavBar() {
 
  const removeSession = () => {
    sessionStorage.removeItem("role");
    sessionStorage.removeItem("email");
    window.location.href = "/";
  };
  return (
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
      <div class="container-fluid">
        <a class="navbar-brand px-4 text-info" href="/login">
          <b>E-Mobigic </b>
        </a>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ">
           

            <li class="nav-item p-2 mx-2">
              <Link  to="/addfile"
                style={{ textDecoration: "none", color: "#0F9D58" }}><b>Add-File</b></Link>
            </li>

            <li class="nav-item p-2 mx-2">
              <Link  to="/Showfile"
                style={{ textDecoration: "none", color: "#0F9D58" }}><b>Show-File</b></Link>
            </li>

            <li class="nav-item p-2 ml-5">
            <b className="text-info">User</b>
            </li>

            <li class="nav-item mx-5 ml-5">
              <button className="btn btn-success " onClick={removeSession}>
                Logout
              </button>
            </li>
          </ul>
          
        </div>
      </div>
    </nav>
  );
}
