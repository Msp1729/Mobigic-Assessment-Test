import axios from "axios";
import React, { useEffect, useState } from "react";
import FileNavBar from "./FileNavBar";
import Itemcard from "./Itemcard";

export default function FarmerShowProduct() {
  let id = sessionStorage.getItem("id");
  const [pdata, setPdata] = useState([{}]);

  useEffect(async () => {
    let result1 = await axios.get(
      `http://localhost:8080/file/showFiles/${id}`
    );
    console.log(result1.data);
    let pro = result1.data;

    setPdata(pro);
  }, []);

  return (
    <>
      <FileNavBar />

      <h1 className="text-center text-info">All Uploaded Files</h1>

      <div  >
        <div >
          <div   >
         <table class="table table-striped">
         <thead>
          <tr>
              <th >FileName</th>
              <th >Action</th>
            </tr>
          </thead>
          </table>
            {pdata.map((item) => {

              return (
                <div >
                  <Itemcard item={item}  />
                </div>
              );
            })}
          </div>
        </div>
      </div>
    </>
  );
}
