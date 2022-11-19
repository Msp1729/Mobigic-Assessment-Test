
import AdminNavbar from "./AdminNavbar";
import { useEffect } from "react";

export default function AdminHome() {
  useEffect(() => {
    if (
      sessionStorage.getItem("role") === "null" ||
      sessionStorage.getItem("role") != "ADMIN"
    ) {
      window.location.href = "/login";
    }
  }, []);
  return (
    <div>
      <AdminNavbar />
    </div>
  );
}
